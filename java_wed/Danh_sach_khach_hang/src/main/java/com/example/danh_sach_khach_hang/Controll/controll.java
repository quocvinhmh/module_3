package com.example.danh_sach_khach_hang.Controll;

import com.example.danh_sach_khach_hang.ClientRepository.ClientRepository;
import com.example.danh_sach_khach_hang.Mode.mode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name ="danhsach",value = "/clients")
public class controll extends HttpServlet {
  private final ClientRepository clientRepository = new ClientRepository();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<mode> clients = clientRepository.getAllClient();
        req.setAttribute("clients", clients);
        req.getRequestDispatcher("webapp/list.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     super.doPost(req, resp);
    }
}
