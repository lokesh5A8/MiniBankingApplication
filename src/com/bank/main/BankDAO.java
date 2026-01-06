package com.bank.dao;

import java.sql.*;
import com.bank.util.DBConnection;

public class BankDAO {

    public void createAccount(int accNo, String name, double balance) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
            con.prepareStatement("INSERT INTO bank_account VALUES(?,?,?)");
        ps.setInt(1, accNo);
        ps.setString(2, name);
        ps.setDouble(3, balance);
        ps.executeUpdate();
        con.close();
    }

    public double getBalance(int accNo) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
            con.prepareStatement("SELECT balance FROM bank_account WHERE acc_no=?");
        ps.setInt(1, accNo);
        ResultSet rs = ps.executeQuery();
        double bal = 0;
        if (rs.next()) bal = rs.getDouble(1);
        con.close();
        return bal;
    }

    public void deposit(int accNo, double amount) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
            con.prepareStatement("UPDATE bank_account SET balance=balance+? WHERE acc_no=?");
        ps.setDouble(1, amount);
        ps.setInt(2, accNo);
        ps.executeUpdate();
        con.close();
    }

    public void withdraw(int accNo, double amount) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps =
            con.prepareStatement("UPDATE bank_account SET balance=balance-? WHERE acc_no=?");
        ps.setDouble(1, amount);
        ps.setInt(2, accNo);
        ps.executeUpdate();
        con.close();
    }
}
