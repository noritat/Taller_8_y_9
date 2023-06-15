package Servlet;


        import Repository.Repository;
        import Repository.ProductsRepositoryImpl;
        import beans.Categories;
        import beans.Products;
        import jakarta.servlet.ServletException;
        import jakarta.servlet.annotation.WebServlet;
        import jakarta.servlet.http.HttpServlet;
        import jakarta.servlet.http.HttpServletRequest;
        import jakarta.servlet.http.HttpServletResponse;

        import java.io.IOException;
        import java.sql.SQLException;




@WebServlet("/products-register")

public class ProductRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
      //  super.doPost(request, resp);

        //  collect all form data
        String Product_name = request.getParameter("product_name");

        String product_value = request.getParameter("product_value");

        String product_categories = request.getParameter("product_categories");


        //fill it up in a user bean

        Products product=new Products();
        product.setProduct_name(Product_name);
        product.setProduct_value(Float.valueOf(product_value));
        product.setCategory_id(Integer.parseInt(product_categories));

        // call repository loyer and save the user object to DB
        int rows=0;
        Repository<Products> repository = new ProductsRepositoryImpl();
        try {
            rows=  repository.saveObj(product);
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
