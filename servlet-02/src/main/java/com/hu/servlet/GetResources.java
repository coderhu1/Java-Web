package com.hu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author coderhu1
 * @create 2020-09-21 19:00
 */
public class GetResources extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        InputStream is = servletContext.getResourceAsStream("/WEB-INF/classes/com/hu/servlet/aa.properties");
        Properties properties = new Properties();
        properties.load(is);
        String username = (String) properties.get("username");
        String password = (String) properties.get("password");

        resp.setCharacterEncoding("utf-8");

        resp.getWriter().print(username + " " + password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
