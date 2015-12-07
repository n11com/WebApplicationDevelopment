package com.bau.blog;

import com.bau.blog.model.User;
import com.bau.blog.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginControllerTest {

    private LoginController controller = new LoginController();

    private HttpSession session = Mockito.mock(HttpSession.class);

    private UserService userService = Mockito.mock(UserService.class);

    @Before
    public void init() {
        controller.setUserService(userService);
    }

    @Test
    public void shouldReturnIndexPage() {
        assertThat(controller.index(), equalTo("login"));
    }

    @Test
    public void shouldLoginUser() {
        String username = "admin";
        String password = "123qwe";

        User user = new User();
        user.setUsername(username);
        user.setPassword(EncryptionUtils.encrypt(password));

        Mockito.when(userService.getUserWithUsername(username)).thenReturn(user);

        ModelAndView modelAndView = controller.loginUser(username, password, session);

        Mockito.verify(session).setAttribute("user", user);

        View view = modelAndView.getView();
        assertThat(view, instanceOf(RedirectView.class));
        assertThat(((RedirectView) view).getUrl(), equalTo("/"));
    }

    @Test
    public void shouldNotLoginUserWhenUsernameIsInvalid(){
        String username = "";
        String password = "123qwe";

        ModelAndView modelAndView = controller.loginUser(username, password, session);

        Mockito.verifyZeroInteractions(userService);
        Mockito.verifyZeroInteractions(session);

        View view = modelAndView.getView();
        assertThat(view, instanceOf(RedirectView.class));
        assertThat(((RedirectView) view).getUrl(), equalTo("/girisyap"));
        assertThat(modelAndView.getModel().get("error"), equalTo(true));
    }

    @Test
    public void shouldNotLoginUserWhenPasswordIsInvalid(){
        String username = "admin";
        String password = "";

        ModelAndView modelAndView = controller.loginUser(username, password, session);

        Mockito.verifyZeroInteractions(userService);
        Mockito.verifyZeroInteractions(session);

        View view = modelAndView.getView();
        assertThat(view, instanceOf(RedirectView.class));
        assertThat(((RedirectView) view).getUrl(), equalTo("/girisyap"));
        assertThat(modelAndView.getModel().get("error"), equalTo(true));
    }

    @Test
    public void shouldLogoutUser(){
        ModelAndView modelAndView = controller.logoutUser(session);

        Mockito.verify(session).removeAttribute("user");

        View view = modelAndView.getView();
        assertThat(view, instanceOf(RedirectView.class));
        assertThat(((RedirectView) view).getUrl(), equalTo("/"));
    }

}