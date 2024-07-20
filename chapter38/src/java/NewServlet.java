/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class NewServlet extends HttpServlet {
/** Process the HTTP Post request
     * @param request
     * @param response
     * @throws jakarta.servlet.ServletException
     * @throws java.io.IOException */
@Override
public void doGet(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {
    //response.setContentType("index.html");
    response.setContentType("index.jsp");
    // Obtain parameters from the client
    try (PrintWriter out = response.getWriter()) {
        // Obtain parameters from the client
        String qStr = request.getParameter("q");
        int q = Integer.parseInt(qStr);
        String qqStr = request.getParameter("qq");
        int qq = Integer.parseInt(qqStr);
        String qqqStr = request.getParameter("qqq");
        int qqq = Integer.parseInt(qqqStr);
        String uStr = request.getParameter("u");
        int u = Integer.parseInt(uStr);
        String uuStr = request.getParameter("uu");
        int uu = Integer.parseInt(uuStr);
        String uuuStr = request.getParameter("uuu");
        int uuu = Integer.parseInt(uuuStr);
        String aStr = request.getParameter("a");
        int a = Integer.parseInt(aStr);
        String aaStr = request.getParameter("aa");
        int aa = Integer.parseInt(aaStr);
        String aaaStr = request.getParameter("aaa");
        int aaa = Integer.parseInt(aaaStr);
        String r;
        if (q + u == a) {
            r = ": Correct";
        } else {
            r = ": Incorrect";
        }
        String rr;
        if (qq + uu == aa) {
            rr = ": Correct";
        } else {
            rr = ": Incorrect";
        }
        String rrr;
        if (qqq + uuu == aaa) {
            rrr = ": Correct";
        } else {
            rrr = ": Incorrect";
        }
        out.println(q + " + " + u + " = " + a  + r);
        out.println(qq + " + " + uu + " = " + aa  + rr);
        out.println(qqq + " + " + uuu + " = " + aaa  + rrr);
        // Close stream
    }
}
}
