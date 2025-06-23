package com.example.danh_sach_khach_hang.ClientRepository;
import com.example.danh_sach_khach_hang.Mode.mode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository  implements IDClientRepository {
    private static List<mode> clients = new ArrayList<>();
    static {
        clients.add(new mode(1,"Mai Văn Hoàn", LocalDate.of(2003,2,4)));
        clients.add(new mode(1,"Mai Văn Hoàn", LocalDate.of(2003,2,4)));
        clients.add(new mode(1,"Mai Văn Hoàn", LocalDate.of(2003,2,4)));
    }

    @Override
    public List<mode> getAllClient() {
     return clients;
    }

    @Override
    public boolean addClient(mode client) {
        return clients.add(client);
    }
}

