package com.vuclip.http;


import com.vuclip.server.core.define.SystemConstants;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * Created by arsemilan on 2015/6/8.
 */
public class Starter {
    public Starter(){}

    public void start() throws Exception {

        System.out.println("Server init...");
        Server server = new Server(SystemConstants.restHttpPort);
        // Register and map the dispatcher servlet
        final ServletHolder servletHolder = new ServletHolder(new CXFServlet());
        final ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        context.addServlet(servletHolder, "/devicePedia/*");
        context.addEventListener(new ContextLoaderListener());
        //配置spring注解
        context.setInitParameter("contextClass", AnnotationConfigWebApplicationContext.class.getName());
        context.setInitParameter("contextConfigLocation", AppConfig.class.getName());
        System.out.println("Server start...at port:"+SystemConstants.restHttpPort);
        server.setHandler(context);
        server.start();
        server.join();
        System.out.println("Server start ok...");
    }

    public static void main(final String[] args) throws Exception {
        new Starter().start();
    }
}
