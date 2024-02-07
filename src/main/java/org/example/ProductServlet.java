package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/product/*")
public class ProductServlet extends HttpServlet {

    ProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        System.out.println("path is " + path);
        String[] pathParts = path.split("/");
        String op = pathParts[1];
        if(op.equals("edit")){
            System.out.println("edit product " + pathParts[2]);
        } else if (op.equals("list")) {
            response.setContentType("application/json");
            List<Product> productList = productService.getProducts();
            response.getWriter().println("[");
            for(Product product : productList) {
                response.getWriter().println("   {");
                response.getWriter().println("     \"name\":\"" + product.name + "\",");
                response.getWriter().println("      \"price\":\"" + product.price + "\"");
                response.getWriter().print("   }");
                response.getWriter().println(",");
            }
            response.getWriter().println("]");


        }
    }
}
