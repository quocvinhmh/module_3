package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.repostiroy.IBookRepostiroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepostiroy bookRepostiroy;
    @Override
    public List<Book> getAllBooks() {
        return bookRepostiroy.findAll();
    }

    @Override
    public Optional<Book> getBookById(long id) {
        return bookRepostiroy.findById(id);
    }

    @Override
    public void decreaseQuantity(Book book) {
        book.setQuantity(book.getQuantity() - 1);
        bookRepostiroy.save(book);
    }

    @Override
    public void increaseQuantity(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        bookRepostiroy.save(book);
    }
}
