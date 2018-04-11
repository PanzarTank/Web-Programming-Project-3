package controllers;

import com.google.gson.Gson;
import helpers.SQLHelper;
import models.Item;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "getItems")
public class getItems extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SQLHelper sql = new SQLHelper();
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        ArrayList<Item> itemList = sql.getItems();
        String json = gson.toJson(itemList);
        out.println(json);
        out.flush();
        sql.closeConnection();
    }

}