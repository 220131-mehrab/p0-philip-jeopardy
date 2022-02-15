package com.philip.jeopardy;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class JeopardyServer {
    private Tomcat server;

    public JeopardyServer(JeopardyService jeopardyService){
        this.server = new Tomcat();
        this.server.setBaseDir(System.getProperty("java.io.tmpdir"));
        this.server.getConnector();
        this.server.addContext("", null);
        this.server.addServlet("", "questionServlet", jeopardyService).addMapping("/");
        try {
            this.server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
