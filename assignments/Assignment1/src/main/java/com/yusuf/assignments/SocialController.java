package com.yusuf.assignments;

import com.yusuf.assignments.utils.CookieUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SocialController {

    @Autowired
    private CookieUtilities cookieUtilities;


    @RequestMapping("/social")
    public ModelAndView social(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("social");
        mav.addObject("social", cookieUtilities.getSocialDataFromCookies(request));

        return mav;
    }
}
