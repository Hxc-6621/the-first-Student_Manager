package org.example;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

public class StudentDao {
    public static void add(Student s){
        String sql="insert into student (id,name,age,score) VALUES (?,?,?,?)";
        try (Connection conn=DBUtil.getConnection();
        PreparedStatement ps=conn.prepareStatement(sql)){
            ps.setString(1,s.getId());
            ps.setString(2, s.getName());
            ps.setInt(3, s.getAge());
            ps.setInt(4, s.getScore());
            ps.executeUpdate();
            System.out.println("添加成功");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public List<Student> findAll(){
        List<Student> list=new ArrayList<>();
        String sql="SELECT id,name,age,score FROM student";
        try (Connection conn=DBUtil.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()){
            while(rs.next()){
                Student s=new Student();
                s.setId(rs.getString("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                s.setScore(rs.getInt("score"));
                list.add(s);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        return list;
    }
    // 根据 id 删除
    public void deleteById(String id) {
        String sql = "DELETE FROM student WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            int rows = ps.executeUpdate();            // ✅ 执行！
            if (rows > 0) {
                System.out.println("删除成功！");
            } else {
                System.out.println("未找到该学号的学生！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 根据 id 查询
    public Student findById(String id) {
        String sql = "SELECT id, name, age, score FROM student WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Student s = new Student();
                    s.setId(rs.getString("id"));
                    s.setName(rs.getString("name"));
                    s.setAge(rs.getInt("age"));
                    s.setScore(rs.getInt("score"));
                    return s;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // 修改
    public void update(Student s) {
        String sql = "UPDATE student SET name = ?, age = ?, score = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setDouble(3, s.getScore());
            ps.setString(4, s.getId());    // id 是 String

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("修改成功！");
            } else {
                System.out.println("未找到该学生！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
