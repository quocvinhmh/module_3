package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
List<Book> getAllBooks();
Optional<Book> getBookById(long id);
    void decreaseQuantity(Book book);
    void increaseQuantity(Book book);
}
