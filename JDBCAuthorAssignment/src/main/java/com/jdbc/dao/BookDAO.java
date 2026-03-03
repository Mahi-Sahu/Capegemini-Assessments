package com.jdbc.dao;

import com.jdbc.connection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO implements IBookDAO {

    @Override
    public void insertBook(String title, double price, int authorId) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO book(title,price,author_id) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, title);
            ps.setDouble(2, price);
            ps.setInt(3, authorId);

            ps.executeUpdate();
            System.out.println("Book inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getBooksByAuthorName(String firstName) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = """
                    SELECT b.title
                    FROM book b
                    JOIN author a ON b.author_id=a.author_id
                    WHERE a.first_name=?
                    """;

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, firstName);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println("Book: " + rs.getString("title"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBookPriceByAuthor(String firstName, double newPrice) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = """
                    UPDATE book b
                    JOIN author a ON b.author_id=a.author_id
                    SET b.price=?
                    WHERE a.first_name=?
                    """;

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, newPrice);
            ps.setString(2, firstName);

            ps.executeUpdate();
            System.out.println("Price updated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}