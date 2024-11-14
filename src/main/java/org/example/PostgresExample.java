package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PostgresExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/mydatabase";
        String user = "myuser";
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // テーブルを作成する例
            String createTableSQL = "CREATE TABLE IF NOT EXISTS employees (id SERIAL PRIMARY KEY, name VARCHAR(100), position VARCHAR(100))";
            stmt.execute(createTableSQL);

            // データを挿入する例
            String insertDataSQL = "INSERT INTO employees (name, position) VALUES ('Alice', 'Engineer'), ('Bob', 'Manager')";
            stmt.executeUpdate(insertDataSQL);

            // データを取得する例
            String querySQL = "SELECT * FROM employees";
            ResultSet rs = stmt.executeQuery(querySQL);

            // 結果を出力
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String position = rs.getString("position");
                System.out.println("ID: " + id + ", Name: " + name + ", Position: " + position);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
