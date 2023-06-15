package Repository;

import beans.Categories;
import beans.User;
import util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements Repository<Categories>{
    private String sql = null;

    public Categories createObj(ResultSet rs) throws SQLException {
        Categories categories = new Categories();
        categories.setCategory_id(rs.getInt( "Category_id"));
        categories.setCategory_name(rs.getString( "Category_name"));
        return categories;
    }

    public List<Categories> listAllObj() throws SQLException {
        sql = "select c.categy_id, c.category_name"+
                " from categories_tbl c order by c.categy_id, c.category_name";
        List<Categories> category = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Categories c = createObj(rs);
                category.add(c);
            } // while
        } // try
        return category;
    }

    public Categories byIdObj(Integer id) throws SQLException {
        sql = "select c.categy_id, c.category_name " +
                "from categories_tbl c where c.categy_id = ?";
        Categories categories = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt( 1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    categories = createObj(rs);
                }

            }
        } // try
        return categories;
    }

    public Integer saveObj(Categories categories) throws SQLException {
        int rowsAffected;



            if (categories.getCategory_id() != null && categories.getCategory_id() > 0) {
                sql = "update categories_tbl set category_name = ? " +
                        "where category_id = ?";
            } else {
                sql = "insert into categories_tbl (category_name) values(upper(?))";
            }
            try (Connection conn = ConnectionPool.getConnection();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString( 1, categories.getCategory_name());
                if (categories.getCategory_id() != null && categories.getCategory_id() > 0) {
                    ps.setInt( 2, categories.getCategory_id());
                }
                rowsAffected = ps.executeUpdate();
            }


        return rowsAffected;
    }

    public void deleteObj(Integer id) throws SQLException {
        sql = "delete from categories_tbl where category_id = ?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt( 1, id);
            ps.executeUpdate();
        } // try
    }
}
// UserRepositoryImpl
