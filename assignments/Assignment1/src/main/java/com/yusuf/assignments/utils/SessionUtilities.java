package com.yusuf.assignments.utils;

import com.yusuf.assignments.model.Resume;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class SessionUtilities {

    public static final String RESUME_KEY = "resume";

    public void putResume(HttpSession session, Resume resume){
        session.setAttribute(RESUME_KEY, resume);
    }

    public Resume getResume(HttpSession session){
        Resume resume = (Resume) session.getAttribute(RESUME_KEY);
        if( resume == null ){
            resume = new Resume();
        }

        return resume;
    }

}
