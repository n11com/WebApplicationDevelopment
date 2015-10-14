package com.yusuf.spring.session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpSession session){
        ModelAndView mav = new ModelAndView("index");

        if( "yusuf".equals(username) && "123".equals(password) ){
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);

            session.setAttribute("user", user);
            mav.addObject("message", "You have successfully logged in");
        }


        return mav;
    }
}
