package org.example;

import java.sql.*;
public class JdbcQuery {
    static void main(String[] args) {
        String url = "JDBC:mysql://localhost:3306/java_study?useSSL=false&serverTimezone=UTC&characterEncoding=utf8";
        String user = "root";
        String password = "123456";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            conn = DBUtil.getConnection();
            System.out.println("Connected to database successfully");
//            //1 qu dong
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            //2 huo qu lian jie
//            conn=DriverManager.getConnection(url,user,password);
//            System.out.println("Connected to database successfully");
            //3 chuang jian PreparedStatement
            String sql="SELECT id,name,age,score FROM student";
            ps = conn.prepareStatement(sql);
            //4 zhi xing cha xun
            rs=ps.executeQuery();























                        //5 bian li jie guo ji
            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                int age=rs.getInt("age");
                double score=rs.getDouble("score");
                System.out.println(id+"|"+name+"|"+age+"|"+score);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6 shi fang zi yuan
            try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
