package com.vuclip.http;

import org.apache.cxf.jaxrs.ext.MessageContext;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import ua_parser.Client;
import ua_parser.Parser;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by arsemilan on 2015/6/8.
 */
@WebService
@Path( "/getDeviceInfo")
public class RestService {
    @Context
    private MessageContext context;
    //@Inject
    private Parser uaParser ;
    @Produces( {"application/json"} )
    @GET
    public Client getDeviceInfo(@QueryParam( "user_agent") String userAgent) throws IOException{
        HttpServletRequest request = (HttpServletRequest)
                context.get(AbstractHTTPDestination.HTTP_REQUEST);
        //String host=request.getRemoteAddr();
        if(null == userAgent){
            userAgent = request.getHeader("user-agent");
            System.out.println(userAgent);
        }
        System.out.println(URLEncoder.encode(userAgent, "utf-8"));
        uaParser = new Parser();
        return uaParser.parse(userAgent);
    }

}
