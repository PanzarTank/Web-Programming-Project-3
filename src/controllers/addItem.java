package controllers;

import helpers.SQLHelper;
import models.Item;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "addItem")
public class addItem extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SQLHelper sql = new SQLHelper();
        String itemName = request.getParameter("itemName");
        double itemPrice = Double.parseDouble(request.getParameter("itemPrice"));
        int itemQuantity = Integer.parseInt(request.getParameter("itemQuantity"));
        Item item = new Item(itemName, itemPrice, itemQuantity);
        sql.addItem(item);
        sql.closeConnection();
    }

}