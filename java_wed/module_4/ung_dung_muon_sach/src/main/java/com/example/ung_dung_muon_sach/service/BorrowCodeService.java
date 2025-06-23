package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.BorrowCode;
import com.example.ung_dung_muon_sach.repostiroy.IBookRepostiroy;
import com.example.ung_dung_muon_sach.repostiroy.IBorrowCodeRepostiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class BorrowCodeService implements IBorrowCodeService{
@Autowired
private IBorrowCodeRepostiory borrowCodeRepostiory;

    @Override
    public BorrowCode createBorrowCode(Book book) {
        String code = UUID.randomUUID().toString();
        BorrowCode borrowCode = new BorrowCode();
        borrowCode.setBook(book);
        borrowCode.setCode(code);
        return borrowCodeRepostiory.save(borrowCode);
    }

    @Override
    public Optional<BorrowCode> getBorrowCode(String borrowCode) {
        return borrowCodeRepostiory.findByCode((borrowCode));
    }

    @Override
    public void deleteBorrowCode(BorrowCode code) {
        borrowCodeRepostiory.delete(code);
    }
}
