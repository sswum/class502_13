package org.choongang.file.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.nio.file.Files;

@WebServlet("/file/download")
public class FileDownloadController extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File("D:/uploads/1.png");
        String contentType= Files.probeContentType(file.toPath());
        String fileName = new String(file.getName().getBytes(), "ISO8859_1"); //윈도우즈에서 한글 깨짐 문제 발생, 인코딩 UTF-8 ->2바이트 형태로 바꿔야 한다

        resp.setHeader("Content-Disposition","attachment; filename=" + fileName);
        resp.setContentType(contentType);
        resp.setHeader("Cache-control","must-revalidate"); // 캐시는 갱신
        resp.setIntHeader("Expires",0); //만료시간 길게 바꿔야 다운로드 했을 때 끊기지 않음
        resp.setContentLengthLong(file.length());

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            OutputStream out = resp.getOutputStream();
            out.write(bis.readAllBytes());
        }

    }
}
