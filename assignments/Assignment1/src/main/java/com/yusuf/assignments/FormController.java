package com.yusuf.assignments;

import com.yusuf.assignments.model.Resume;
import com.yusuf.assignments.model.Social;
import com.yusuf.assignments.utils.CookieUtilities;
import com.yusuf.assignments.utils.SessionUtilities;
import com.yusuf.assignments.utils.Utilities;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.NumberUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/forms")
public class FormController {

    @Autowired
    private CookieUtilities cookieUtilities;

    @Autowired
    private SessionUtilities sessionUtilities;

    @Autowired
    private Utilities utilities;

    @RequestMapping("")
    public ModelAndView forms(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("forms");
        mav.addObject("social", cookieUtilities.getSocialDataFromCookies(request));
        mav.addObject("resume", sessionUtilities.getResume(request.getSession()));

        return mav;
    }

    @RequestMapping(path = "/addResume", method = RequestMethod.POST)
    public ModelAndView addResumeData(@ModelAttribute Resume resume, BindingResult bindingResult, HttpSession session){
        ModelAndView mav = new ModelAndView(new RedirectView("/forms", true));

        if( bindingResult.hasErrors() || isResumeDataNotValid(resume) ) {
            mav.addObject("resumeError", true);
            return mav;
        }

        sessionUtilities.putResume(session, resume);

        return mav;
    }

    private boolean isResumeDataNotValid(Resume resume){
        return StringUtils.isBlank(resume.getExperiences()) || !utilities.isAllBetween(1, 100, resume.getSkillsArray());
    }

    @RequestMapping(path = "/addSocial", method = RequestMethod.POST)
    public ModelAndView addSocialData(@ModelAttribute Social social, HttpServletResponse response){
        ModelAndView mav = new ModelAndView(new RedirectView("/forms", true));

        if( isSocialDataNotValid(social) ) {
            mav.addObject("socialError", true);
            return mav;
        }

        cookieUtilities.addSocialCookies(response, social);

        return mav;
    }

    private boolean isSocialDataNotValid(Social social) {
        String[] socialData = social.getDataAsArray();

        return StringUtils.isAnyBlank(socialData) || utilities.isAnyInvalidUrl(socialData);
    }

}
