package com.example.demo_jps.controller;

import com.example.demo_jps.mode.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet",value = "/students")
public class StudentServiet  extends HttpServlet {
    private static List <student> studentList = new ArrayList();
    static{
        studentList.add(new student(1,"chanh5",true,9,1));
        studentList.add(new student(2,"chanh4",false,3,1));
        studentList.add(new student(3,"chanh3",true,5,1));
        studentList.add(new student(4,"chanh2",false,6,1));
        studentList.add(new student(5,"chanh1",true,8,1));

    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("studentList",studentList);
req.getRequestDispatcher("/views/student/list.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}