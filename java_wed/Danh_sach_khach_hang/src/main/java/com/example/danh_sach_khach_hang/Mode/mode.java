package com.example.danh_sach_khach_hang;

import jdk.vm.ci.meta.Local;
import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class mode {
    private String id;
    private String ten;
    private LocalDate day;
    private String nhan;

    public mode(String id, String ten, LocalDate day, String nhan) {
        this.id = id;
        this.ten = ten;
        this.day = day;
        this.nhan = nhan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
