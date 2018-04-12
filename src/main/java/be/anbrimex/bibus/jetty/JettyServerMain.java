package be.anbrimex.bibus.jetty;

import be.anbrimex.bibus.dao.BibusDao;
import be.anbrimex.bibus.servlet.IpConfig;
import be.anbrimex.bibus.servlet.UserSetup;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyServerMain {

    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        if (args.length > 0) {
            BibusDao.setHost(args[0]);
        }

        ServletContextHandler context = new ServletContextHandler(
                ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        context.setResourceBase(System.getProperty("java.io.tmpdir"));
        server.setHandler(context);

        // Add user setup
        ServletHolder userSetupServletHolder = context.addServlet(UserSetup.class, "/UserSetup");
        // Add Ip Config
        ServletHolder ipConfigServletHolder = context.addServlet(IpConfig.class, "/IpConfig");
        // Add default servlet
        ServletHolder defaultContext = context.addServlet(DefaultServlet.class, "/");

        server.start();
        ipConfigServletHolder.getServlet();
        userSetupServletHolder.getServlet();
        defaultContext.getServlet();
        server.join();
    }
}
