package com.example.student.controller;

import com.example.student.model.student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "students",value ="/students")
public class StudentSv extends HttpServlet {
    private static List<student> studentList = new ArrayList();
    static {
        studentList.add(new student(1,"vinh1",18));
        studentList.add(new student(2,"vinh2",15));
        studentList.add(new student(3,"vinh3",11));
        studentList.add(new student(4,"vinh4",13));
        studentList.add(new student(5,"vinh5",17));
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("studentList",studentList);
        req.getRequestDispatcher("/student/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
