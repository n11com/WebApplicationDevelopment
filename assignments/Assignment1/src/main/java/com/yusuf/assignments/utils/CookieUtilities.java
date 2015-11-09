package com.yusuf.assignments.utils;

import com.yusuf.assignments.model.Social;
import org.springframework.stereotype.Component;
import org.springframework.web.util.CookieGenerator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CookieUtilities {

    private static final String FACEBOOK_COOKIE_NAME = "facebook";
    private static final String TWITTER_COOKIE_NAME = "twitter";
    private static final String LINKEDIN_COOKIE_NAME = "linkedin";
    private static final String FLICKR_COOKIE_NAME = "flickr";

    private CookieGenerator cookieGenerator;

    public CookieUtilities(){
        cookieGenerator = new CookieGenerator();
        cookieGenerator.setCookieMaxAge(30 * 24 * 60 * 60);
    }

    public void addCookie(HttpServletResponse response, String cookieName, String cookieValue){
        cookieGenerator.setCookieName(cookieName);
        cookieGenerator.addCookie(response, cookieValue);
    }

    public String getCookieValue(HttpServletRequest request, String name){
        Cookie[] cookies = request.getCookies();
        if( cookies != null ){
            for( Cookie cookie : cookies ){
                if( cookie.getName().equals(name) ){
                    return cookie.getValue();
                }
            }
        }

        return null;
    }

    public void addSocialCookies(HttpServletResponse response, Social social){
        addCookie(response, FACEBOOK_COOKIE_NAME, social.getFacebook());
        addCookie(response, TWITTER_COOKIE_NAME, social.getTwitter());
        addCookie(response, LINKEDIN_COOKIE_NAME, social.getLinkedin());
        addCookie(response, FLICKR_COOKIE_NAME, social.getFlickr());
    }

    public Social getSocialDataFromCookies(HttpServletRequest request){
        Social social = new Social();
        social.setFacebook(getCookieValue(request, FACEBOOK_COOKIE_NAME));
        social.setTwitter(getCookieValue(request, TWITTER_COOKIE_NAME));
        social.setLinkedin(getCookieValue(request, LINKEDIN_COOKIE_NAME));
        social.setFlickr(getCookieValue(request, FLICKR_COOKIE_NAME));

        return social;
    }
}
