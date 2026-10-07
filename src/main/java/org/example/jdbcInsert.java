package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcInsert {
    static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java_study?useTimezone=false&serverTimezone=UTC&characterEncoding=utf8";
        String user = "root";
        String password = "123456";

        String sql = "insert into student (name,age,score) values(?,?,?)";
        try(Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, "赵九");
            ps.setInt(2, 22);
            ps.setDouble(3, 95.5);

            int rows = ps.executeUpdate();
            System.out.println("插入成功，影响行数：" + rows);

        }catch(SQLException e){
            e.printStackTrace();
        }
     }
}
