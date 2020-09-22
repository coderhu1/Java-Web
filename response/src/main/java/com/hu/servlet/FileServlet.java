package com.hu.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * @author coderhu1
 * @create 2020-09-21 20:45
 */
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String realpath = "D:\\projects\\helloservlet\\response\\src\\main\\resources\\带眼镜的女生.jpg";
        System.out.println("realpath：" + realpath);

        String filename = realpath.substring(realpath.lastIndexOf("\\") + 1);

        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));

        FileInputStream is = new FileInputStream(realpath);

        int len = 0;
        byte[] buffer = new byte[1024];

        ServletOutputStream os = resp.getOutputStream();

        while((len = is.read(buffer)) > 0){
            os.write(buffer, 0, len);
        }

        is.close();
        os.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
