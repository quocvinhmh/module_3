package com.example.ung_dung_muon_sach.repostiroy;

import com.example.ung_dung_muon_sach.model.BorrowCode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBorrowCodeRepostiory extends JpaRepository<BorrowCode, Long>{
    Optional<BorrowCode> findByCode(String code);
}
