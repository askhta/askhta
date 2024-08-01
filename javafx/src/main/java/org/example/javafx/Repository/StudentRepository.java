package org.example.javafx.Repository;

import javafx.collections.ObservableList;
import org.example.javafx.entity.Article;
import org.example.javafx.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentRepository {
    private final String MYSQL_CONNECTION = "jdbc:mysql://localhost:3306/student";
    private final String MYSQL_USER = "root";
    private final String MYSQL_PASSWORD = "";


    public Student save(Student student) {
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USER, MYSQL_PASSWORD);
            String strSql = "insert into students (code, fullname, phone, email) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(strSql);
            preparedStatement.setString(1, student.getCode());
            preparedStatement.setString(2, student.getFullname());
            preparedStatement.setString(3, student.getPhone());
            preparedStatement.setString(4, student.getEmail());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
    public ArrayList<Student> findAll(){
        ArrayList<Student> students = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(MYSQL_CONNECTION, MYSQL_USER, MYSQL_PASSWORD);
            String prSql = "select * from students";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(prSql);
            while (resultSet.next()) {
                String code = resultSet.getString("code");
                String fullName = resultSet.getString("fullName");
                String phone = resultSet.getString("phone");
                Student obj = new Student();
                obj.setCode(code);
                obj.setFullname(fullName);
                obj.setPhone(phone);
                students.add(obj);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArticleRepository articleRepository = new ArticleRepository();
        Article article = new Article();
        article.setId(1);
        article.setTitle("Lan");
        article.setDescription("HoangLan");
        article.setContent("0123456789");
        articleRepository.save(article);

    }
}

