package com.example.ung_dung_muon_sach.service;

import com.example.ung_dung_muon_sach.model.Book;
import com.example.ung_dung_muon_sach.model.BorrowCode;

import java.util.Optional;

public interface IBorrowCodeService {
    BorrowCode createBorrowCode(Book book);
    Optional<BorrowCode> getBorrowCode(String borrowCode);
    void deleteBorrowCode( BorrowCode code);
}
