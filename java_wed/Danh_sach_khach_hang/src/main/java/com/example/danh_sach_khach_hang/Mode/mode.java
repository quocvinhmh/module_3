package com.example.danh_sach_khach_hang.Mode;

import java.time.LocalDate;

public class mode {
    private int id;
    private String ten;
    private LocalDate day;
    private String nhan;

    public mode(int id, String ten, LocalDate day) {
        this.id = id;
        this.ten = ten;
        this.day = day;
        this.nhan = nhan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public String getNhan() {
        return nhan;
    }

    public void setNhan(String nhan) {
        this.nhan = nhan;
    }
}
