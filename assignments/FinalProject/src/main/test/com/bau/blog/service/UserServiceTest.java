package com.bau.blog.service;

import com.bau.blog.EncryptionUtils;
import com.bau.blog.dao.UserDao;
import com.bau.blog.model.User;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserServiceTest {

    private UserService service = new UserService();

    private UserDao userDao = Mockito.mock(UserDao.class);

    @Before
    public void init(){
        service.setUserDao(userDao);
    }

    @Test
    public void shouldAddUser() {
        User user = new User();
        user.setEmail("abc@gmail.com");
        user.setUsername("theUsername");
        String password = "123qwe";
        user.setPassword(password);

        Mockito.when(userDao.getUser("theUsername")).thenReturn(null);

        boolean saveResult = service.saveUser(user);
        Assert.assertTrue(saveResult);

        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        Mockito.verify(userDao).addUser(argumentCaptor.capture());

        User capturedUser = argumentCaptor.getValue();
        assertThat(capturedUser.getPassword(), equalTo(EncryptionUtils.encrypt(password)));
    }

    @Test
    public void shouldAddUserWithExistingUsername() {
        User user = new User();
        user.setEmail("abc@gmail.com");
        user.setUsername("theUsername");
        user.setPassword("123qwe");

        Mockito.when(userDao.getUser("theUsername")).thenReturn(new User());

        boolean saveResult = service.saveUser(user);
        Assert.assertFalse(saveResult);

        Mockito.verify(userDao).getUser("theUsername");
        Mockito.verifyNoMoreInteractions(userDao);
    }

}