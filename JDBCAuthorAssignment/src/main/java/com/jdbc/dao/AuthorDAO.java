package com.jdbc.dao;

import com.jdbc.connection.DBConnection;
import com.jdbc.entity.Author;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthorDAO implements IAuthorDAO {

    @Override
    public void insertAuthor(Author author) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "INSERT INTO author(first_name,last_name,phone_no) VALUES(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, author.getFirstName());
            ps.setString(2, author.getLastName());
            ps.setString(3, author.getPhoneNo());

            ps.executeUpdate();
            System.out.println("Author inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAuthor(int id, String phoneNo) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "UPDATE author SET phone_no=? WHERE author_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, phoneNo);
            ps.setInt(2, id);

            ps.executeUpdate();
            System.out.println("Author updated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAuthor(int id) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "DELETE FROM author WHERE author_id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();
            System.out.println("Author deleted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAuthorById(int id) {
        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT * FROM author WHERE author_id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("ID: " + rs.getInt("author_id"));
                System.out.println("Name: " +
                        rs.getString("first_name") + " " +
                        rs.getString("last_name"));
                System.out.println("Phone: " +
                        rs.getString("phone_no"));
            } else {
                System.out.println("Author not found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}