package com.yusuf.spring.session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class SecureController {

    @RequestMapping("/secure")
    public String securePage(HttpSession session){
        User user = (User) session.getAttribute("user");

        if( user == null ){
            return "failed";
        }

        return "secure";
    }
}
