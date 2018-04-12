package be.anbrimex.bibus.servlet;

import be.anbrimex.bibus.builder.FormBuilder;
import be.anbrimex.bibus.builder.ObjectBuilder;
import be.anbrimex.bibus.dao.Entity.IPConfigHAEth0;
import be.anbrimex.bibus.dao.IpConfigDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/IpConfig/", loadOnStartup = 1)
public class IpConfig extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(IpConfig.class.getName());

    @Override
    public void init() throws ServletException {
        LOGGER.log(Level.INFO, "My servlet has been initialized");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set response content type
        resp.setContentType("text/html");

        // Get the parameters (IpConfig values)
        IPConfigHAEth0 ipConfig;
        Map<String, String[]> paramsMap = req.getParameterMap();
        if (paramsMap.size() > 0) {
            // Submit form => Update the values. 
            ipConfig = ObjectBuilder.buildObject(IPConfigHAEth0.class, paramsMap);
            IpConfigDao.updateIpConfig(ipConfig);
        } else {
            ipConfig = IpConfigDao.getIpConfig();
        }

        PrintWriter out = resp.getWriter();
        String title = "Ip Config";

        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "
                + "transitional//en\">\n";

        out.println(docType + "<html>\n"
                + "<head><title>" + title + "</title></head>\n"
                + "<body bgcolor=\"#f0f0f0\">\n"
                + "<h1 align=\"center\">" + title + "</h1>\n");

        out = FormBuilder.buildForm("IpConfig", out, ipConfig);

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

}
