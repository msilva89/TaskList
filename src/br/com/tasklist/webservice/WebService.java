package br.com.tasklist.webservice;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class WebService extends ResourceConfig {

    public WebService() {
        packages("br.com.tasklist.webservice.controllers");
    }

}
