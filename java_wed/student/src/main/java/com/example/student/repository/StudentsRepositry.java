package com.example.student.repository;

import com.example.student.model.student;
import com.example.student.service.IDStudentsService;

import java.util.ArrayList;
import java.util.List;

public class StudentsRepositry implements IDStudentsRepositry {
public final String SELECT_ALL = "select * from student";

    @Override
    public List<student> findAll() {
        return List.of();
    }
}
