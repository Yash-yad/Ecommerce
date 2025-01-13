package com.product.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProductDAOTest {

    private ProductDAO productDAO = new ProductDAO();

    @Test
    void testGetAllProducts() {
        assertNotNull(productDAO.getAllProducts());
        assertEquals(0, productDAO.getAllProducts().size(), "Should return an empty list initially");
    }

    @Test
    void testDeleteProduct() {
        int productId = 1; // Example ID
        productDAO.deleteProduct(productId);
        // Further assertions can be made based on your DAO implementation
    }
}
