package com.mftplus.loginpage.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/save")
public class userServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getParameter("name"));
//        System.out.println(req.getParameter("family"));
//        System.out.println(req.getParameter("user_name"));
//        System.out.println(req.getParameter("password"));
        UserController.add(req.getParameter("name"),req.getParameter("family"),req.getParameter("userName")
                ,req.getParameter("passWord"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Ok");
    }
}
