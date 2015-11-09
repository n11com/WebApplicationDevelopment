package com.yusuf.assignments.utils;

import com.yusuf.assignments.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpSession;

public class SessionUtilitiesTest {

    private SessionUtilities sessionUtilities;

    private HttpSession session;

    @Before
    public void before(){
        sessionUtilities = new SessionUtilities();
        session = Mockito.mock(HttpSession.class);
    }

    @Test
    public void shouldPutResumeIntoSession() {
        Resume resume = new Resume();

        sessionUtilities.putResume(session, resume);

        verify(session).setAttribute("resume", resume);
    }

    @Test
    public void shouldGetResumeIfExists(){
        Resume resume = new Resume();
        when(session.getAttribute("resume")).thenReturn(resume);

        Resume actualResume = sessionUtilities.getResume(session);

        assertThat(actualResume, equalTo(resume));
    }

    @Test
    public void shouldGetEmptyResumeIfNotExists(){
        when(session.getAttribute("resume")).thenReturn(null);

        Resume actualResume = sessionUtilities.getResume(session);

        Assert.assertNotNull(actualResume);
    }

}