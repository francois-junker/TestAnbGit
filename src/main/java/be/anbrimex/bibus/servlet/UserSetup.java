package be.anbrimex.bibus.servlet;

import be.anbrimex.bibus.dao.Entity.User;
import be.anbrimex.bibus.dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/UserSetup/")
public class UserSetup extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set response content type
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        String title = "Setup Users";

        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 "
                + "transitional//en\">\n";

        out.println(docType + "<html>\n"
                + "<head><title>" + title + "</title></head>\n"
                + "<body bgcolor=\"#f0f0f0\">\n"
                + "<h1 align=\"center\">" + title + "</h1>\n");

        // load all users. 
        List<User> users = UserDao.findAllUsers();
        if (!users.isEmpty()) {
            out.println("<table style=\"width:100%\">");
            out.println("<tr><th>UserId</th><th>Active</th><th>Nom</th></tr>");
            for (User u : users) {
                out.println("<tr>");
                out.println("<td>" + u.getUser() + "</td>");
                out.println("<td>" + u.getActive() + "</td>");
                out.println("<td>" + u.getNom() + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        doGet(req, resp);
    }

}
