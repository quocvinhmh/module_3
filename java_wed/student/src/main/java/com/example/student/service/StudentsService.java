package com.example.student.service;

import com.example.student.model.student;
import com.example.student.repository.IDStudentsRepositry;
import com.example.student.repository.StudentsRepositry;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentsService implements IDStudentsService {
    private IDStudentsRepositry studentsRepositry = new StudentsRepositry();
    @Override
    public List<student> findAll() {
        return studentsRepositry.findAll();
    }
}



