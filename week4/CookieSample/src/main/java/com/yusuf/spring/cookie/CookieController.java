package com.yusuf.spring.cookie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.CookieGenerator;

import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    @RequestMapping("/")
    public String home(HttpServletResponse response){
        /*
         * To send a cookie, all you need to do is to create a javax.servlet.http.Cookie instance
         * and put it into the response object. This is what org.springframework.web.util.CookieGenerator class
         * does in this example.
         *
         * Don't forget you have to add the cookie to the response before you print anything else to the client,
         * otherwise you would broke the HTTP standard
         */
        CookieGenerator cookieGenerator = new CookieGenerator();
        cookieGenerator.setCookieName("myTestCookie");
        cookieGenerator.addCookie(response, "myValue");

        return "cookie";
    }

    @RequestMapping("/read")
    /*
     * To read the cookie value in a method, you can use @CookieValue annotation.
     * you can get the cookie values from HttpServletRequest instance as well
     */
    public ModelAndView getCookieValue(@CookieValue("myTestCookie") String cookieValue){
        ModelAndView mav = new ModelAndView("cookie");
        mav.addObject("cookieValue", cookieValue);

        return mav;
    }
}
