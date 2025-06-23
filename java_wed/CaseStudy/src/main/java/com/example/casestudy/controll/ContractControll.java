package com.example.casestudy.controll;

import com.example.casestudy.model.Contract.Contract;
import com.example.casestudy.service.ContractService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@WebServlet(name = "ContractHome", value = "/Contract")
public class ContractControll extends HttpServlet {
    private ContractService contractService = new ContractService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                showid(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "update":
showUpdateForm(req, resp);
            default:
                showlist(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "search":
                showid(req, resp);
                break;
            case "delete":
                delete(req, resp);
                break;
            case "update":
                update(req, resp);
            default:
                break;
        }
    }

    private void showlist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Contract> contractList = contractService.findAllContract();
        req.setAttribute("contractList", contractList);
        req.getRequestDispatcher("/View/Contract/list.jsp").forward(req, resp);
        System.out.println("Số lượng hợp đồng: " + contractList.size());
    }

    private void showid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("contractID");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int contractID = Integer.parseInt(idParam);
                List<Contract> searchContract = contractService.searchContract(contractID);
                req.setAttribute("contractList", searchContract);
            } catch (NumberFormatException e) {
                req.setAttribute("error", "Contract ID không hợp lệ");
            }
        } else {
            req.setAttribute("error", "Chưa cung cấp Contract ID");
        }
        req.getRequestDispatcher("/View/Contract/list.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("contractID");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int contractID = Integer.parseInt(idParam);
                // Gọi hàm xóa từ service
                boolean deleteSuccess = contractService.deleteContract(contractID);

                // Xác định thông báo phù hợp
                String mess = deleteSuccess ? "Delete successful" : "Delete failed";

                // Chuyển hướng đến trang danh sách với thông báo
                resp.sendRedirect(req.getContextPath() + "/Contract?mess=" + URLEncoder.encode(mess, "UTF-8"));
            } catch (NumberFormatException e) {
                // Nếu contractID không hợp lệ, chuyển tiếp và hiển thị thông báo lỗi
                req.setAttribute("error", "Contract ID không hợp lệ");
                req.getRequestDispatcher("/View/Contract/list.jsp").forward(req, resp);
            }
        } else {
            // Nếu không cung cấp contractID, chuyển tiếp và hiển thị thông báo lỗi
            req.setAttribute("error", "Chưa cung cấp Contract ID");
            req.getRequestDispatcher("/View/Contract/list.jsp").forward(req, resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("contractID");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int contractID = Integer.parseInt(idParam);
                String statusParam = req.getParameter("status");
                String endDateParam = req.getParameter("endDate");
                double depositParam = Double.parseDouble(req.getParameter("deposit"));
                double totalMoneyParam = Double.parseDouble(req.getParameter("totalMoney"));
                int customerID = Integer.parseInt(req.getParameter("customerID"));
                Contract contract = new Contract(contractID, statusParam, endDateParam, depositParam, totalMoneyParam, customerID);
                boolean update = contractService.updateContract(contractID, contract);
                String mess = update ? "Update successful" : "Update failed";
                resp.sendRedirect(req.getContextPath() + "/View/Contract/list.jsp?mess=" + URLEncoder.encode(mess, "UTF-8"));
            } catch (NumberFormatException e) {
                req.setAttribute("error", "Contract ID không hợp lệ");
                req.getRequestDispatcher("/View/Contract/list.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("error", "Chưa cung cấp Contract ID");
            req.getRequestDispatcher("/View/Contract/list.jsp").forward(req, resp);
        }
    }

    private void showUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("contractID");
        if (idParam != null && !idParam.isEmpty()) {
            try {
                int contractID = Integer.parseInt(idParam);
                // Lấy thông tin hợp đồng theo ID (giả sử phương thức này có trong contractService)
                Contract contract = contractService.findAllContract().stream()
                        .filter(c -> c.getContractID() == contractID)
                        .findFirst()
                        .orElse(null);
                if (contract != null) {
                    req.setAttribute("contract", contract);
                    // Chuyển đến trang update.jsp để hiển thị form cập nhật
                    req.getRequestDispatcher("/View/Contract/update.jsp").forward(req, resp);
                } else {
                    req.setAttribute("error", "Không tìm thấy hợp đồng với ID: " + contractID);
                    showlist(req, resp);
                }
            } catch (NumberFormatException e) {
                req.setAttribute("error", "Contract ID không hợp lệ");
                showlist(req, resp);
            }
        } else {
            req.setAttribute("error", "Chưa cung cấp Contract ID");
            showlist(req, resp);
        }
    }
}
