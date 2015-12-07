package com.bau.blog;

import com.bau.blog.dao.EntryDao;
import com.bau.blog.model.Entry;
import com.bau.blog.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class EntryController {

    @Autowired
    private EntryDao entryDao;

    @RequestMapping("/secure/addBlogPost")
    public String showEntryForm(){
        return "addBlogPost";
    }

    @RequestMapping(path = "/secure/addBlogPost", method = RequestMethod.POST)
    public ModelAndView addEntry(@RequestParam("title") String title,
                                 @RequestParam("entry") String entry,
                                 HttpSession session){
        User user = (User) session.getAttribute("user");
        ModelAndView mav;

        if(isValidData(title, entry)){
            Entry entryData = new Entry();
            entryData.setTitle(title);
            entryData.setEntry(entry);

            entryDao.addEntry(entryData, user);
            mav = new ModelAndView(new RedirectView("/", true));
        } else {
            mav = new ModelAndView(new RedirectView("/secure/addBlogPost", true));
            mav.addObject("error", true);
        }

        return mav;
    }

    private boolean isValidData(String title, String entry) {
        return StringUtils.isNoneBlank(title, entry);
    }

    public void setEntryDao(EntryDao entryDao) {
        this.entryDao = entryDao;
    }
}
