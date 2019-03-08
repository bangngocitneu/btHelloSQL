package controller;
import database.ProductHandler;
import model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class EditServlet extends HttpServlet{
    protected  void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        process(request,response);
    }
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        process(request,response);
    }
    private void process(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException {
        String uri = request.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex+1);
        String dispatchUrl = null;
        if (action.equals("product_edit")){
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String descript  = request.getParameter("descript");
            String price = request.getParameter("price");
            new ProductHandler().update(id,name,descript,price);
            dispatchUrl = "/";
            response.sendRedirect(dispatchUrl);
        }
        else {
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = new ProductHandler().getProductInfor(id);
            request.setAttribute("product",product);
            dispatchUrl = "ProductEdit.jsp";
            RequestDispatcher rd = request.getRequestDispatcher(dispatchUrl);
            rd.forward(request,response);
        }
        
    }
}