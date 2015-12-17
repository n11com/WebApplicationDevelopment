package com.bau.blog;

import com.bau.blog.dao.EntryDao;
import com.bau.blog.model.Entry;
import com.bau.blog.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private EntryDao entryDao;

    @RequestMapping("/")
    public ModelAndView index(@RequestParam(name = "tagId", required = false) Integer tagId){
        ModelAndView mav = new ModelAndView("index");

        List<Entry> entries;
        if( tagId != null ){
            Tag tag = entryDao.getTag(tagId);
            if( tag != null ){
                 entries = entryDao.getEntries(tag);
            } else {
                return new ModelAndView(new RedirectView("/", true));
            }
        } else {
            entries = entryDao.getEntries();
        }

        mav.addObject("entries", entries);
        mav.addObject("tags", entryDao.getAllTags());

        return mav;
    }

    public void setEntryDao(EntryDao entryDao) {
        this.entryDao = entryDao;
    }
}
