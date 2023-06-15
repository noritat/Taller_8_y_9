package Servlet;

        import Repository.Repository;
        import beans.User;
        import Repository.UserRepositoryImpl;
        import jakarta.servlet.ServletException;
        import jakarta.servlet.annotation.WebServlet;
        import jakarta.servlet.http.HttpServlet;
        import jakarta.servlet.http.HttpServletRequest;
        import jakarta.servlet.http.HttpServletResponse;

        import java.awt.datatransfer.DataFlavor;
        import java.io.IOException;
        import java.sql.SQLException;


@WebServlet("/user-register")

public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
       // super.doPost(request, resp);

        //  collect all form data
        String user_firstname = request.getParameter("user_firstname");
        String user_lastname = request.getParameter("user_lastname");
        String user_email = request.getParameter("user_email");
        String user_password = request.getParameter("user_password");

        //fill it up in a user bean

        User user = new User();
        user.setUser_firstname(user_firstname);
        user.setUser_lastname(user_lastname);
        user.setUser_email(user_email);
        user.setUser_password(user_password);

        // call repository loyer and save the user object to DB

        Repository<User> repository = new UserRepositoryImpl();
        try {
            repository.saveObj(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //  prepare information message for user about sucess or fallure of the console
        int rows = 0;
        if (rows == 0) {
            //infoMessage = "Ocurrio un error";
            System.out.println("Ocurrio un error");
        } else {
            //infoMessage = "Registro exitoso";
            System.out.println("registro existoso");
        }


    }
}


