package com.yusuf.spring.basicauth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.BASE64Decoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class BasicAuthController {

    @RequestMapping("/admin")
    public void home(HttpServletRequest request, HttpServletResponse response){
        String authorizationData = getAuthorizationData(request);
        System.out.println(authorizationData);
        if( authorizationData == null ){
            sendUnauthorizedResponse(response);
        }
    }

    private void sendUnauthorizedResponse(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setHeader("WWW-Authenticate", "Basic realm=\"My Server\"");
    }

    public String getAuthorizationData(HttpServletRequest request){
        String decoded = null;
        try{
            String authorizationHeader = request.getHeader("authorization");
            if( authorizationHeader != null ){
                // Header is in the format "Basic 3nc0dedDat4"
                // We need to extract data before decoding it back to original string
                String data = authorizationHeader.substring(authorizationHeader.indexOf(" ") +1 );

                // Decode the data back to original string
                byte[] bytes = new BASE64Decoder().decodeBuffer(data);
                decoded = new String(bytes);
            }


        }catch(Exception e){
           decoded = null;
        }

        return decoded;
    }
}
