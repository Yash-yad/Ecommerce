package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.product.dao.ProductDAO;

import jakarta.servlet.annotation.WebServlet;

/**
 * ProductServlet - Controller for handling product-related actions
 */
@WebServlet("/")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProductDAO productDAO;

    public ProductServlet() {
        super();
    }

    @Override
    public void init() {
        productDAO = new ProductDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/add":
                    showNewForm(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/delete":
                    deleteProduct(request, response);
                    break;
                case "/list":
                    listProducts(request, response);
                    break;
                default:
                    listProducts(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Implementation for showing edit form
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-product.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        // Implementation for deleting a product
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.deleteProduct(id);
        response.sendRedirect("list");
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Implementation for listing all products
        request.setAttribute("productList", productDAO.getAllProducts());
        RequestDispatcher dispatcher = request.getRequestDispatcher("product-list.jsp");
        dispatcher.forward(request, response);
    }
}
