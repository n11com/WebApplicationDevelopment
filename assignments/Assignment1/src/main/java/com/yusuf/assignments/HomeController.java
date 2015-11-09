package com.yusuf.assignments;

import com.yusuf.assignments.utils.SessionUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private SessionUtilities sessionUtilities;

    @RequestMapping("/")
    public ModelAndView home(HttpSession session){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("resume", sessionUtilities.getResume(session));

        return mav;
    }

}
