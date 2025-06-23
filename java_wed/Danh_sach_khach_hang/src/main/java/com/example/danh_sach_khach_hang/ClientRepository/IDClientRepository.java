package com.example.danh_sach_khach_hang.ClientRepository;

import com.example.danh_sach_khach_hang.Mode.mode;

import java.util.List;

public interface IDClientRepository {
    List<mode> getAllClient();
    boolean addClient(mode client);
}
