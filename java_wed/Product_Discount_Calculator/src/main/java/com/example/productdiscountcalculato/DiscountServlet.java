package com.example.productdiscountcalculato;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "DiscountServlet", value ="/discount")
public class DiscountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String product_name = request.getParameter("Product_Description");
    double product_price = Double.parseDouble(request.getParameter("List_Price"));
    double product_discount = Double.parseDouble(request.getParameter("discount_percent"));
    double product_Amount = product_price * product_discount * 0.01 ;
    double Discount_Price = product_price - product_Amount;
        request.setAttribute("productName", product_name);
        request.setAttribute("discountPercent", product_discount);
        request.setAttribute("discountAmount", product_Amount);
        request.setAttribute("discountPrice", Discount_Price);
        request.setAttribute("price", product_price);


        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
