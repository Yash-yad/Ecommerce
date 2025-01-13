package controller;

import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ecommerce.dao.ProductDAO;

class ProductServletTest {

    @Mock
    private ProductDAO productDAO;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher dispatcher;

    @InjectMocks
    private ProductServlet productservlet;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShowNewForm() throws ServletException, IOException {
        when(request.getRequestDispatcher("product-form.jsp")).thenReturn(dispatcher);

        productservlet.showNewForm(request, response);

        verify(request, times(1)).getRequestDispatcher("product-form.jsp");
        verify(dispatcher).forward(request, response);
    }

    @Test
    void testListProducts() throws ServletException, IOException {
        when(request.getServletPath()).thenReturn("/list");
        when(productDAO.getAllProducts()).thenReturn(null); // Mock data

        productservlet.doGet(request, response);

        verify(request, times(1)).setAttribute(eq("productList"), any());
        verify(request.getRequestDispatcher("product-list.jsp")).forward(request, response);
    }
}

