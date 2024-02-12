package product.dao;

import DBIO.ObjectDBIO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrandDao extends ObjectDBIO {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String MYSQL_URL = System.getenv("DB_URL");
    private static final String USERNAME = System.getenv("DB_USERNAME");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");
/*
    브랜드 코드 ID에 해당하는 브랜드 이름을 데이터베이스에서 조회합니다.
*/
    public String getBrandName(int brandCodeId) {
        Connection conn = open();
        String brandName = null;

        try {
            String sql = "SELECT name FROM brand WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, brandCodeId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                brandName = rs.getString("name");
            }

            rs.close();
            pstmt.close();
            close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return brandName;
    }

    public List<String> getAllBrands() {
        Connection conn = open();
        List<String> brand = new ArrayList<>();

        try {
            String sql = "SELECT name FROM brand";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                brand.add(rs.getString("name"));
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return brand;
    }


}