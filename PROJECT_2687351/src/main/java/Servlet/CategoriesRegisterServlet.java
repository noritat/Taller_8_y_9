package Servlet;

import Repository.Repository;
import Repository.CategoryRepositoryImpl;
import beans.Categories;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/category-register")

public class CategoriesRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
      //  super.doPost(request, resp);

        //  collect all form data
        String Category_name = request.getParameter("Category_name");


        //fill it up in a user bean

       Categories categories=new Categories();
        categories.setCategory_name(Category_name);


        // call repository loyer and save the user object to DB
        int rows=0;
        Repository<Categories> repository = new CategoryRepositoryImpl();
        try {
            rows= repository.saveObj(categories);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //  prepare information message for user about sucess or fallure of the console

        if(rows==0){
            //infoMessage = "Ocurrio un error";
            System.out.println("Ocurrio un error");
        }else {
            //infoMessage = "Registro exitoso";
            System.out.println("registro existoso");
        }


    }
}
