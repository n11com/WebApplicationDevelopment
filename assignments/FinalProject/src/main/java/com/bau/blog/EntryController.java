package com.bau.blog;

import com.bau.blog.dao.EntryDao;
import com.bau.blog.model.Entry;
import com.bau.blog.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

@Controller
public class EntryController {

    @Autowired
    private EntryDao entryDao;

    @RequestMapping("/readPost")
    public ModelAndView readPost(@RequestParam(name = "id", required = false) Integer entryId){
        boolean redirectToMainPage = false;

        if( entryId == null ){
            redirectToMainPage = true;
        }

        ModelAndView mav = new ModelAndView("readPost");

        Entry entry = entryDao.getEntry(entryId);
        if( entry == null ){
            redirectToMainPage = true;
        }
        mav.addObject("entry", entry);

        if( redirectToMainPage ){
            mav = new ModelAndView(new RedirectView("/", true));
        }

        return mav;
    }

    @RequestMapping("/secure/addBlogPost")
    public ModelAndView showEntryForm(HttpSession session){
        String csrfToken = RandomStringUtils.randomAlphanumeric(20);
        session.setAttribute("addBlogPostCsrfToken", csrfToken);

        ModelAndView mav = new ModelAndView("addBlogPost");
        mav.addObject("csrfToken", csrfToken);

        return mav;
    }

    @RequestMapping(path = "/secure/addBlogPost", method = RequestMethod.POST)
    public ModelAndView addEntry(@RequestParam("title") String title,
                                 @RequestParam("entry") String entry,
                                 @RequestParam("image") MultipartFile imageFile,
                                 @RequestParam("csrfToken") String csrfToken,
                                 HttpSession session){

        User user = (User) session.getAttribute("user");
        ModelAndView mav;

        if(checkCsrfToken(session, csrfToken) && isValidData(title, entry)){
            Entry entryData = new Entry();
            entryData.setTitle(title);
            entryData.setEntry(entry);
            entryData.setImagePath(saveUploadedFile(imageFile));

            entryDao.addEntry(entryData, user);
            mav = new ModelAndView(new RedirectView("/", true));
        } else {
            mav = new ModelAndView(new RedirectView("/secure/addBlogPost", true));
            mav.addObject("error", true);
        }

        return mav;
    }

    private boolean checkCsrfToken(HttpSession session, String csrfToken){
        String csrfTokenValue = (String) session.getAttribute("addBlogPostCsrfToken");
        session.removeAttribute("addBlogPostCsrfToken");
        return csrfTokenValue != null && csrfTokenValue.equals(csrfToken);
    }

    private String saveUploadedFile(MultipartFile imageFile) {
        String filePath = null;

        if (!imageFile.isEmpty()) {
            try {
                byte[] bytes = imageFile.getBytes();

                String displayFolder = "/resources/uploaded/";

                File folder = new File("/Users/yusufsoysal/Development/course/workspace/assignments/FinalProject/target/blog" + displayFolder);
                if( !folder.exists() ){
                    folder.mkdir();
                }

                filePath = displayFolder + "/" + imageFile.getOriginalFilename();

                // Create the file on server
                File serverFile = new File(folder + "/" + imageFile.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

            } catch (Exception e) {
                e.printStackTrace();
                filePath = null;
            }
        }

        return filePath;
    }

    private boolean isValidData(String title, String entry) {
        return StringUtils.isNoneBlank(title, entry);
    }

    public void setEntryDao(EntryDao entryDao) {
        this.entryDao = entryDao;
    }
}
