package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

public class StudentManager {
    private static List <Student> students=new ArrayList<>();
    private static Scanner sc=new Scanner(System.in);
    private  static StudentDao studentDao=new StudentDao();
    private static void printMenu(){
        System.out.println("==== 学生管理系统====");
        System.out.println("1.添加学生");
        System.out.println("2.删除学生");
        System.out.println("3.修改学生");
        System.out.println("4.查看所有学生");
        System.out.println("5.依据学号查看");
        System.out.println("6.exit");
        System.out.println("请选择： ");
        }
    public static void main(String[] args) {
        while(true){
            printMenu();
            int choice=sc.nextInt();
            switch(choice){
                    case 1-> addStudent();
                    case 2 -> deleteStudent();
                    case 3 -> updateStudent();
                    case 4 -> listStudents();
                    case 5 -> checkStudent();
                    case 6 -> {
                        System.out.println("退出系统");
                        return;
                    }
                    default -> System.out.println("输入有误，请重新选择");
            }
        }
    }

    private static void addStudent() {
//        System.out.println("请输入学生名字，查看是否已经存在");
//        String id=sc.next();
//        for(Student s:students){
//            if(s.getId().equals(id)){
//                System.out.println("此学号已存在，添加失败");
//                return;
//            }
//        }
//        System.out.println("请输入学生名字");
//        String name=sc.next();
//        System.out.println("请输入学生年龄");
//        int age=sc.nextInt();
//        System.out.println("请输入学生成绩");
//        int score=sc.nextInt();
//        Student student=new Student(id,name,age,score);
//        students.add(student);
//            System.out.println("添加成功");
        System.out.print("请输入学号：");
        String id = sc.next();
        System.out.print("请输入姓名：");
        String name = sc.next();
        System.out.print("请输入年龄：");
        int age = sc.nextInt();
        System.out.print("请输入成绩：");
        int score = sc.nextInt();   //
        Student s=new Student(id,name,age,score);
        StudentDao.add(s);
    }

    private static void listStudents() {
        List<Student> list=studentDao.findAll();
        if(list.isEmpty()){
            System.out.println("No student data Available");
        }else {
            for(Student s:list){
                System.out.println(s);
            }
        }
//    if(students.isEmpty()){
//        System.out.println("暂无学生");
//    }
//    for(Student s:students){
//    System.out.println("学号："+s.getId()+" 姓名"+s.getName()+" 年龄："+s.getAge()+" 成绩："+s.getScore());}
    }

   private static void updateStudent() {
//        System.out.println("输入你要修改学号：");
//        String updateId=sc.next();
//        for(Student s:students){
//            if(s.getId().equals(updateId)){
//                s.setId(updateId);
//                System.out.print("请输入新姓名：");
//                s.setName(sc.next());
//                System.out.print("请输入新年龄：");
//                s.setAge(sc.nextInt());
//                System.out.print("请输入新成绩：");
//                s.setScore(sc.nextInt());
//                System.out.println("修改成功！");
//                return;
//            }
//        }
//        System.out.println("未找到该学号的学生，修改失败！");
       System.out.print("请输入要修改的学号：");
       String id = sc.next();
       Student s =studentDao.findById(id);
       if(s==null){
           System.out.println("no found student with id:"+id);
           return;
       }
       System.out.print("请输入新姓名：");
       s.setName(sc.next());
       System.out.print("请输入新年龄：");
       s.setAge(sc.nextInt());
       System.out.print("请输入新成绩：");
       s.setScore(sc.nextInt());   // int
       studentDao.update(s);
    }
    private static void deleteStudent(){
//        System.out.println("请输入你要删除的学号");
//        String deleteId=sc.next();
//        Iterator<Student> it =students.iterator();
//        while(it.hasNext()){
//            Student s=it.next();
//            if(s.getId().equals(deleteId)){
//                it.remove();//安全删除，底层会同步修改集合结构；
//            }
//            System.out.println("删除成功");
//            return;
//        }
//        System.out.println("未找到该学号");
        System.out.print("请输入要删除的学号：");
        String id = sc.next();  // String
        studentDao.deleteById(id);
    }
    private static void checkStudent(){
//        System.out.println("查看学生");
//        String checkId=sc.next();
//        for(Student s:students){
//            if(s.getId().equals(checkId)){
//                System.out.println("学号"+s.getId()+"姓名"+s.getName()+"年龄"+s.getAge()+"成绩"+s.getScore());
//            return;
//            }
//        }
//        System.out.println("学号输入错误，不存在");
        System.out.print("请输入要查找的学号：");
        String id = sc.next();
        Student s = studentDao.findById(id);
        if (s != null) System.out.println(s);
        else System.out.println("未找到该学生");
    }

}
