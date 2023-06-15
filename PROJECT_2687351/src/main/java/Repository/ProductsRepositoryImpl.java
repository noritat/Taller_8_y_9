package Repository;

import beans.Products;
import util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsRepositoryImpl implements Repository<Products>{
    private String sql = null;

    public Products createObj(ResultSet rs) throws SQLException {
        Products products = new Products();
        products.setProduct_id(rs.getInt( "Products_id"));
        products.setProduct_name(rs.getString( "product_name"));
        products.setProduct_value(rs.getFloat( "product_value"));
        products.setCategory_id(rs.getInt( "Category_id"));
        return products;
    }

    public List<Products> listAllObj() throws SQLException {
        sql = "select p.product_id, p.product_name, p.product_value,p.Category_id "+
                " from products_tbl p order by p.products_id,p.product_name";
        List<Products> products = new ArrayList<>();
        try (Connection conn = ConnectionPool.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Products p = createObj(rs);
                products.add(p);
            } // while
        } // try
        return products;
    }

    public Products byIdObj(Integer id) throws SQLException {
        sql = "select p.product_id, p.product_name " +
                "from products_tbl p where p.product_id = ?";
        Products products = null;
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt( 1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    products = createObj(rs);
                }

            }
        } // try
        return products;
    }

    public Integer saveObj(Products products) throws SQLException {
        int rowsAffected;

        if (products.getProduct_id() != null && products.getProduct_id() > 0) {
            sql = "update products_tbl set product_name = ?, product_value=?, Category_id=? " +
                    "where product_id = ?";
        } else {
            sql = "insert into products_tbl (product_name,product_value,Category_id)" +
                    " values(upper(?),?, ?)";
        }
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString( 1, products.getProduct_name());
            ps.setFloat( 2, products.getProduct_value());
            ps.setInt( 3, products.getCategory_id());
            if (products.getProduct_id() != null && products.getProduct_id() > 0) {
                ps.setInt( 4, products.getProduct_id());
            }
            rowsAffected = ps.executeUpdate();
        }
        return rowsAffected;
    }

    public void deleteObj(Integer id) throws SQLException {
        sql = "delete from products_tbl where product_id = ?";
        try (Connection conn = ConnectionPool.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt( 1, id);
            ps.executeUpdate();
        } // try
    }
}
// UserRepositoryImpl
