package com.yusuf.spring.session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("sessionKey")
public class SessionController {

    @RequestMapping("/")
    public String home(HttpSession session){
        session.setAttribute("mySessionKey", "mySessionValue");

        return "session";
    }

    @RequestMapping("/read")
    public ModelAndView getSessionValue(){
        ModelAndView mav = new ModelAndView("session");
        mav.addObject("sessionKey", "sessionValue");

        return mav;
    }
}
