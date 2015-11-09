package com.yusuf.assignments;

import com.yusuf.assignments.model.Resume;
import com.yusuf.assignments.model.Social;
import com.yusuf.assignments.utils.CookieUtilities;
import com.yusuf.assignments.utils.SessionUtilities;
import com.yusuf.assignments.utils.Utilities;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FormControllerTest {

    @InjectMocks
    private FormController controller;

    @Mock
    private CookieUtilities cookieUtilities;

    @Mock
    private SessionUtilities sessionUtilities;

    @Mock
    private Utilities utilities;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpSession session;

    @Test
    public void shouldGetInitialForm() {
        Social social = new Social();
        Resume resume = new Resume();

        when(cookieUtilities.getSocialDataFromCookies(request)).thenReturn(social);
        when(sessionUtilities.getResume(request.getSession())).thenReturn(resume);

        ModelAndView modelAndView = controller.forms(request);

        assertThat(modelAndView.getViewName(), equalTo("forms"));
        Map<String, Object> model = modelAndView.getModel();
        Object socialObject = model.get("social");
        Object resumeObject = model.get("resume");

        assertThat(socialObject, notNullValue());
        assertThat(socialObject, equalTo(social));

        assertThat(resumeObject, notNullValue());
        assertThat(resumeObject, equalTo(resume));
    }

    @Test
    public void shouldAddResumeDataIfThereIsNoError(){
        Resume resume = getValidResume();

        BindingResult bindingResult = mock(BindingResult.class);

        when(utilities.isAllBetween(anyInt(), anyInt(), anyVararg())).thenReturn(true);

        controller.addResumeData(resume, bindingResult, session);
        verify(sessionUtilities).putResume(session, resume);
    }

    @Test
    public void shouldNotAddResumeDataIfThereIsBindingError(){
        Resume resume = getValidResume();

        BindingResult bindingResult = mock(BindingResult.class);
        when(bindingResult.hasErrors()).thenReturn(true);

        ModelAndView modelAndView = controller.addResumeData(resume, bindingResult, session);
        assertThat(modelAndView.getModel().get("resumeError"), equalTo(true));

        verifyZeroInteractions(sessionUtilities);
    }

    @Test
    public void shouldNotAddResumeDataIfResumeIsInvalid(){
        Resume resume = new Resume();

        BindingResult bindingResult = mock(BindingResult.class);

        when(utilities.isAllBetween(anyInt(), anyInt(), anyVararg())).thenReturn(false);

        ModelAndView modelAndView = controller.addResumeData(resume, bindingResult, session);
        assertThat(modelAndView.getModel().get("resumeError"), equalTo(true));

        verifyZeroInteractions(sessionUtilities);
    }

    private Resume getValidResume() {
        Resume resume = new Resume();
        resume.setExperiences("experiences");
        resume.setSkill1(12);
        resume.setSkill2(12);
        resume.setSkill3(12);
        resume.setSkill4(12);
        resume.setSkill5(12);
        resume.setSkill6(12);
        return resume;
    }

}