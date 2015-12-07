package com.bau.blog;

import com.bau.blog.model.User;
import com.bau.blog.service.UserService;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class RegistrationControllerTest {

    private RegistrationController controller = new RegistrationController();

    @Test
    public void shouldOpenSignupPage() {
        UserService userService = Mockito.mock(UserService.class);
        controller.setUserService(userService);

        assertThat(controller.index(), equalTo("register"));

        Mockito.verifyZeroInteractions(userService);
    }

    @Test
    public void shouldAddUser(){
        String firstName = "firstName";
        String lastName = "lastName";
        String username = "username";
        String password = "password";
        String email = "email";

        UserService userService = Mockito.mock(UserService.class);
        controller.setUserService(userService);

        Mockito.when(userService.saveUser(Mockito.any(User.class))).thenReturn(true);

        ModelAndView mav = controller.doRegister(firstName, lastName, username, email, password);

        Map<String, Object> model = mav.getModel();
        assertThat(model.get("error"), nullValue());

        Mockito.verify(userService).saveUser(Mockito.any(User.class));
    }

    @Test
    public void shouldNotAddUserIfFirstNameIsEmpty(){
        String firstName = "";
        String lastName = "lastName";
        String username = "username";
        String password = "password";
        String email = "email";

        UserService userService = Mockito.mock(UserService.class);
        controller.setUserService(userService);

        ModelAndView mav = controller.doRegister(firstName, lastName, username, email, password);

        Map<String, Object> model = mav.getModel();
        assertTrue((Boolean) model.get("error"));

        Mockito.verifyZeroInteractions(userService);
    }

    @Test
    public void shouldNotAddUserIfLastNameIsEmpty(){
        String firstName = "firstName";
        String lastName = "";
        String username = "username";
        String password = "password";
        String email = "email";

        UserService userService = Mockito.mock(UserService.class);
        controller.setUserService(userService);

        ModelAndView mav = controller.doRegister(firstName, lastName, username, email, password);

        Map<String, Object> model = mav.getModel();
        assertTrue((Boolean) model.get("error"));

        Mockito.verifyZeroInteractions(userService);
    }

    @Test
    public void shouldNotAddUserIfUsernameIsEmpty(){
        String firstName = "firstName";
        String lastName = "lastName";
        String username = "";
        String password = "password";
        String email = "email";

        UserService userService = Mockito.mock(UserService.class);
        controller.setUserService(userService);

        ModelAndView mav = controller.doRegister(firstName, lastName, username, email, password);

        Map<String, Object> model = mav.getModel();
        assertTrue((Boolean) model.get("error"));

        Mockito.verifyZeroInteractions(userService);
    }

    @Test
    public void shouldNotAddUserIfPasswordIsEmpty(){
        String firstName = "firstName";
        String lastName = "lastName";
        String username = "username";
        String password = "";
        String email = "email";

        UserService userService = Mockito.mock(UserService.class);
        controller.setUserService(userService);

        ModelAndView mav = controller.doRegister(firstName, lastName, username, email, password);

        Map<String, Object> model = mav.getModel();
        assertTrue((Boolean) model.get("error"));

        Mockito.verifyZeroInteractions(userService);
    }

    @Test
    public void shouldNotAddUserIfEmailIsEmpty(){
        String firstName = "firstName";
        String lastName = "lastName";
        String username = "username";
        String password = "password";
        String email = "";

        UserService userService = Mockito.mock(UserService.class);
        controller.setUserService(userService);

        ModelAndView mav = controller.doRegister(firstName, lastName, username, email, password);

        Map<String, Object> model = mav.getModel();
        assertTrue((Boolean) model.get("error"));

        Mockito.verifyZeroInteractions(userService);
    }

}