package com.admission.school.system.application.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectioClass {
    Connection conn = null;
    String url = "jdbc:mysql://192.168.10.13:3306/";
    String dbName = "school_admission-system";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root";
    String password = "root";

    public String getCourseTitle(int id) {
        try {
            Connection connection = this.getConnection();
            Statement stmt = connection.createStatement();
            String sql = "SELECT name from course where id=" + id;
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                return rs.getString("name");
            }
            connection.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private Connection getConnection() {
        try {
            Class.forName(driver).newInstance();
            return DriverManager.getConnection(url + dbName, userName, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
