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
    response.setContentType("index.html");
    // Obtain parameters from the client
    try (PrintWriter out = response.getWriter()) {
        // Obtain parameters from the client
        String loanStr = request.getParameter("loan");
        String yearlyRateStr = request.getParameter("yearlyRate");
        String yearsStr = request.getParameter("years");
        double loan = Integer.parseInt(loanStr);
        double yearlyRate = Integer.parseInt(yearlyRateStr);
        double years = Integer.parseInt(yearsStr);
        double monthlyRate = yearlyRate / 1200;
        double monthlyPayment = loan * monthlyRate / (1 - (1 / Math.pow(1 + monthlyRate, years * 12)));
        double total = monthlyPayment * years * 12;
        out.println("Loan Amount: " + loan);
        out.println("Annual Interest Rate: " + yearlyRate);
        out.println("Number of Years: " + years);
        out.println("Monthy Payment: " + monthlyPayment);
        out.println("Total Payment: " + total);
        // Close stream
    }
}
}
