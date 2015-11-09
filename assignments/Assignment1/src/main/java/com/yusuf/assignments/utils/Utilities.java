package com.yusuf.assignments.utils;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Component;

@Component
public class Utilities {

    private final UrlValidator urlValidator;

    public Utilities(){
        String[] schemes = {"http","https"};
        urlValidator = new UrlValidator(schemes);
    }

    public boolean isInvalidUrl(String data){
        String urlData = data;
        if( !urlData.startsWith("http://") && !urlData.startsWith("https://") ){
            urlData = "http://" + data;
        }

        return !urlValidator.isValid(urlData);
    }

    public boolean isAnyInvalidUrl(String ... dataList){
        for( String data : dataList ){
            if( isInvalidUrl(data) ){
                return true;
            }
        }

        return false;
    }

    public boolean isBetween(int min, int max, int number){
        return number >= min && number <= max;
    }

    public boolean isAllBetween(int min, int max, int ... numbers){
        for( int number : numbers ){
            if( !isBetween(min, max, number) ){
                return false;
            }
        }

        return true;
    }

}
