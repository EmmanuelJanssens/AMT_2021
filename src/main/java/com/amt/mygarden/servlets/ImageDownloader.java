package com.amt.mygarden.servlets;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/download")
public class ImageDownloader extends HttpServlet {

    private final int ARBITARY_SIZE = 10480;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String filename = request.getParameter("filename");

        File image = new File("/usr/local/mygarden/images/fruitImages/"+filename);

        InputStream is;
        if(!image.exists())
        {
            is = request.getServletContext().getResourceAsStream("/images/placeholder.jpg");
            filename="placeholder.jpg";
        }
        else
        {
            is = new FileInputStream(image);
        }

        response.setContentType("image/*");
        response.setHeader("Content-disposition", "attachment; filename="+filename);
        try(OutputStream out = response .getOutputStream()) {

            byte[] buffer = new byte[ARBITARY_SIZE];

            int numBytesRead;
            while ((numBytesRead = is.read(buffer)) > 0) {
                out.write(buffer, 0, numBytesRead);
            }
        }
    }
}
