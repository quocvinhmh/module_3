package com.example.student.repository;

import com.example.student.model.student;

import java.util.List;

public interface IDStudentsRepositry {
    List<student> findAll();
}
