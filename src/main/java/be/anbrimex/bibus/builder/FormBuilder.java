/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.anbrimex.bibus.builder;

import be.anbrimex.bibus.servlet.IpConfig;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utils to build html form.
 *
 * @author Francois
 */
public class FormBuilder {

    public static PrintWriter buildForm(final String servletName, final PrintWriter output, final Object obj) {
        if (obj != null) {
            output.println("<form action=\"" + servletName + "\" method=\"POST\" >");
            output.println("<table style=\"width:80%\">");
            output.println("<tr><th style=\"text-align:left\"><h3>Variables</h3></th><th style=\"text-align:left\"><h3>Valeurs</h3></th></tr>");

            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field f : Arrays.asList(fields)) {
                try {
                    f.setAccessible(true);
                    Object value = f.get(obj);
                    output.println("<tr>");
                    output.println("<td>" + f.getName() + "</td>");
                    output.println("<td><input type=\"text\" name=\"" + f.getName() + "\" " + (value == null ? ">" : ("value=\"" + value + "\"></td>")));
                    output.println("</tr>");
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    Logger.getLogger(IpConfig.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            output.println("</table>");
            output.println("<input type=\"submit\" value=\"Submit\" />");
            output.println("</form>");
        }
        return output;
    }

}
