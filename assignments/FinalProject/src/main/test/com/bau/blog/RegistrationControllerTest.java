package com.bau.blog;

import com.bau.blog.dao.UserDao;
import com.bau.blog.model.User;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.eq;

public class RegistrationControllerTest {

    private RegistrationController controller = new RegistrationController();

    @Test
    public void shouldOpenSignupPage() {
        UserDao userDao = Mockito.mock(UserDao.class);
        controller.setUserDao(userDao);

        assertThat(controller.index(), equalTo("register"));

        Mockito.verifyZeroInteractions(userDao);
    }

    @Test
    public void shouldAddUser(){
        String firstName = "firstName";
        String lastName = "lastName";
        String username = "username";
        String password = "password";
        String email = "email";

        UserDao userDao = Mockito.mock(UserDao.class);
        controller.setUserDao(userDao);

        ModelAndView mav = controller.doRegister(firstName, lastName, username, email, password);

        Map<String, Object> model = mav.getModel();
        assertThat(model.get("error"), nullValue());

        Mockito.verify(userDao).addUser(Mockito.any(User.class));
    }

    @Test
    public void shouldNotAddUserIfFirstNameIsEmpty(){
        String firstName = "";
        String lastName = "lastName";
        String username = "username";
        String password = "password";
        String email = "email";

        UserDao userDao = Mockito.mock(UserDao.class);
        controller.setUserDao(userDao);

        ModelAndView mav = controller.doRegister(firstName, lastName, username, email, password);

        Map<String, Object> model = mav.getModel();
        assertTrue((Boolean) model.get("error"));

        Mockito.verifyZeroInteractions(userDao);
    }

    @Test
    public void shouldNotAddUserIfLastNameIsEmpty(){
        String firstName = "firstName";
        String lastName = "";
        String username = "username";
        String password = "password";
        String email = "email";

        UserDao userDao = Mockito.mock(UserDao.class);
        controller.setUserDao(userDao);

        ModelAndView mav = controller.doRegister(firstName, lastName, username, email, password);

        Map<String, Object> model = mav.getModel();
        assertTrue((Boolean) model.get("error"));

        Mockito.verifyZeroInteractions(userDao);
    }

    @Test
    public void shouldNotAddUserIfUsernameIsEmpty(){
        String firstName = "firstName";
        String lastName = "lastName";
        String username = "";
        String password = "password";
        String email = "email";

        UserDao userDao = Mockito.mock(UserDao.class);
        controller.setUserDao(userDao);

        ModelAndView mav = controller.doRegister(firstName, lastName, username, email, password);

        Map<String, Object> model = mav.getModel();
        assertTrue((Boolean) model.get("error"));

        Mockito.verifyZeroInteractions(userDao);
    }

    @Test
    public void shouldNotAddUserIfPasswordIsEmpty(){
        String firstName = "firstName";
        String lastName = "lastName";
        String username = "username";
        String password = "";
        String email = "email";

        UserDao userDao = Mockito.mock(UserDao.class);
        controller.setUserDao(userDao);

        ModelAndView mav = controller.doRegister(firstName, lastName, username, email, password);

        Map<String, Object> model = mav.getModel();
        assertTrue((Boolean) model.get("error"));

        Mockito.verifyZeroInteractions(userDao);
    }

    @Test
    public void shouldNotAddUserIfEmailIsEmpty(){
        String firstName = "firstName";
        String lastName = "lastName";
        String username = "username";
        String password = "password";
        String email = "";

        UserDao userDao = Mockito.mock(UserDao.class);
        controller.setUserDao(userDao);

        ModelAndView mav = controller.doRegister(firstName, lastName, username, email, password);

        Map<String, Object> model = mav.getModel();
        assertTrue((Boolean) model.get("error"));

        Mockito.verifyZeroInteractions(userDao);
    }

}