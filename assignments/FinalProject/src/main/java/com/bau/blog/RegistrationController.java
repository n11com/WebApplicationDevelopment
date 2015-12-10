package com.bau.blog;

import com.bau.blog.model.User;
import com.bau.blog.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping("/uyeol")
    public String index(){
        return "register";
    }

    @RequestMapping(path="/uyeol", method = RequestMethod.POST)
    public ModelAndView doRegister(@RequestParam("firstName") String firstName,
                                   @RequestParam("lastName") String lastName,
                                   @RequestParam("username") String username,
                                   @RequestParam("email") String email,
                                   @RequestParam("password") String password){
        ModelAndView mav;
        boolean isUserSaved = false;

        if( isDataValid(firstName, lastName, username, email, password)){
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword(password);

            isUserSaved = userService.saveUser(user);
        }

        if( isUserSaved ){
            mav = new ModelAndView(new RedirectView("/", true));
        } else {
            mav = new ModelAndView(new RedirectView("/uyeol", true));
            mav.addObject("error", true);
        }

        return mav;
    }

    private boolean isDataValid(String firstName, String lastName, String username, String email, String password) {
        return StringUtils.isNoneBlank(firstName, lastName, username, email, password);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
