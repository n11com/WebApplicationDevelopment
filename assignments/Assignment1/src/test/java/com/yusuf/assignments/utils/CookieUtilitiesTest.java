package com.yusuf.assignments.utils;

import com.yusuf.assignments.model.Social;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.util.CookieGenerator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CookieUtilitiesTest {

    @InjectMocks
    private CookieUtilities cookieUtilities;

    @Mock
    private CookieGenerator cookieGenerator;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpServletRequest request;

    @Test
    public void shouldAddNewCookie() {
        cookieUtilities.addCookie(response, "cookieName", "cookieValue");

        verify(cookieGenerator).setCookieName("cookieName");
        verify(cookieGenerator).addCookie(response, "cookieValue");
    }

    @Test
    public void shouldGetCookieValueIfExists(){
        Cookie[] cookieArray = new Cookie[3];
        cookieArray[0] = new Cookie("cookie0", "value0");
        cookieArray[1] = new Cookie("cookie1", "value2");
        cookieArray[2] = new Cookie("cookie2", "value2");

        when(request.getCookies()).thenReturn(cookieArray);
        String cookieValue = cookieUtilities.getCookieValue(request, "cookie1");

        assertThat(cookieValue, equalTo("value2"));
    }

    @Test
    public void shouldReturnNullIfCookieNotExists(){
        Cookie[] cookieArray = new Cookie[3];
        cookieArray[0] = new Cookie("cookie0", "value0");
        cookieArray[1] = new Cookie("cookie1", "value2");
        cookieArray[2] = new Cookie("cookie2", "value2");

        when(request.getCookies()).thenReturn(cookieArray);
        String cookieValue = cookieUtilities.getCookieValue(request, "cookie5");

        assertNull(cookieValue);
    }

    @Test
    public void shouldAddSocialDataAsCookies(){
        Social social = new Social();
        social.setFacebook("fb");
        social.setFlickr("fl");
        social.setLinkedin("li");
        social.setTwitter("tw");

        cookieUtilities.addSocialCookies(response, social);

        ArgumentCaptor<String> cookieNameCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> cookieValueCaptor = ArgumentCaptor.forClass(String.class);

        verify(cookieGenerator, times(4)).setCookieName(cookieNameCaptor.capture());
        verify(cookieGenerator, times(4)).addCookie(eq(response), cookieValueCaptor.capture());

        assertThat(cookieNameCaptor.getAllValues(), equalTo(Arrays.asList("facebook", "twitter", "linkedin", "flickr")));
        assertThat(cookieValueCaptor.getAllValues(), equalTo(Arrays.asList("fb", "tw", "li", "fl")));
    }

    @Test
    public void shouldGetSocialDataFromCookies(){
        Cookie[] cookieArray = new Cookie[4];
        cookieArray[0] = new Cookie("facebook", "fb");
        cookieArray[1] = new Cookie("twitter", "tw");
        cookieArray[2] = new Cookie("linkedin", "li");
        cookieArray[3] = new Cookie("flickr", "fl");

        when(request.getCookies()).thenReturn(cookieArray);

        Social social = new Social();
        social.setFacebook("fb");
        social.setFlickr("fl");
        social.setLinkedin("li");
        social.setTwitter("tw");

        Social actualSocial = cookieUtilities.getSocialDataFromCookies(request);

        assertThat(actualSocial, equalTo(social));
    }

}