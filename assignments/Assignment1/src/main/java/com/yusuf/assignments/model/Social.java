package com.yusuf.assignments.model;

import java.util.Arrays;
import java.util.List;

public class Social {
    private String facebook;
    private String twitter;
    private String linkedin;
    private String flickr;

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getFlickr() {
        return flickr;
    }

    public void setFlickr(String flickr) {
        this.flickr = flickr;
    }

    public String[] getDataAsArray(){
        return new String[]{facebook, twitter, linkedin, flickr};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Social)) return false;

        Social social = (Social) o;

        if (facebook != null ? !facebook.equals(social.facebook) : social.facebook != null) return false;
        if (flickr != null ? !flickr.equals(social.flickr) : social.flickr != null) return false;
        if (linkedin != null ? !linkedin.equals(social.linkedin) : social.linkedin != null) return false;
        if (twitter != null ? !twitter.equals(social.twitter) : social.twitter != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = facebook != null ? facebook.hashCode() : 0;
        result = 31 * result + (twitter != null ? twitter.hashCode() : 0);
        result = 31 * result + (linkedin != null ? linkedin.hashCode() : 0);
        result = 31 * result + (flickr != null ? flickr.hashCode() : 0);
        return result;
    }
}
