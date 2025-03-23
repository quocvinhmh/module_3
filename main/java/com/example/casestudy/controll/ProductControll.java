package com.example.casestudy.controll;

import com.example.casestudy.model.Product;
import com.example.casestudy.repository.ProductRepository;
import com.example.casestudy.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = ("ProductControll"), urlPatterns ="/HomeControll")
public class  ProductControll extends HttpServlet {
private ProductRepository productService = new ProductRepository();
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action == null) {
        action = "";
    }
    switch (action) {
        case "Create":
showFormCreate(request, response);
            break;
        case "Delete":
showFormDelete(request, response);
            break;
                case "Search":
                    searchByName(request, response);
                    break;
                    default:
                        showList(request, response);
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
            case "Create":
                save(req, resp);
                break;
                    case "Update":
update(req, resp);
                        break;
default:
        }
    }
    private void save (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    double price;
    try {
        price = Double.parseDouble(request.getParameter("price"));

    } catch (NumberFormatException e) {
        request.setAttribute("Error","giá không hợp lệ");
        showFormCreate(request,response);
        return;
    }
    String name = request.getParameter("name");
    String description = request.getParameter("description");
    String manufacturer = request.getParameter("manufacturer");
    Product product = new Product(name,price, description, manufacturer);
    boolean flag = productService.add(product);
  showFormCreate(request,response);
  if (flag) {
      response.sendRedirect("/HomeControll?mess=Add succsess");
  }else {
      showFormCreate(request,response);
  }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher("/view/product/create.jsp").forward(request,response);
    }
    private void showList (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    List<Product> products = productService.findAll();
    request.setAttribute("products",products);
    request.getRequestDispatcher("/view/product/list.jsp").forward(request,response);
    }
    private void showFormDelete (HttpServletRequest request, HttpServletResponse response) throws IOException {
    int id = Integer.parseInt(request.getParameter("id"));
    boolean isDelleteSuccess = productService.delete(id);
    String Delete = "Delete not success";
if (isDelleteSuccess) {
    Delete = "Delete success";
}
response.sendRedirect("/HomeControll?mess=" + Delete);
    }
    private void searchByName(HttpServletRequest req, HttpServletResponse resp) {
        String searchName = req.getParameter("searchName");
        List<Product> result = productService.findByName(searchName);
        req.setAttribute("products", result);
        req.setAttribute("searchName", searchName);
        try {
            req.getRequestDispatcher("/view/product/list.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try{
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String manufacturer = req.getParameter("manufacturer");
        Product product = new Product(id,name,description,manufacturer);
        productService.update(product);
        resp.sendRedirect(req.getContextPath()+"/HomeControll?mess=Update success");
 showList(req, resp);
        } catch (NumberFormatException e) {
        resp.sendRedirect(req.getContextPath()+"/HomeControll?mess=Update failed");
    }
    }
}


