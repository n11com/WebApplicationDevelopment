package com.bau.blog;

import com.bau.blog.dao.UserDao;
import com.bau.blog.model.User;
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
    private UserDao userDao;

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
        ModelAndView mav = null;

        if( isForDataInvalid(firstName, lastName, username, email, password)){
            mav = new ModelAndView(new RedirectView("/uyeol"));
            mav.addObject("error", true);
        } else {
            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword(password);

            userDao.addUser(user);

            mav = new ModelAndView(new RedirectView("/"));
        }

        return mav;
    }

    private boolean isForDataInvalid(String firstName, String lastName, String username, String email, String password) {
        return StringUtils.isAnyBlank(firstName, lastName, username, email, password);
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
