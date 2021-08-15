/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0001 Online quiz
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-18      1.0              PhuongNVHE140784      Initial commit
 */
package dao.impl;

import dao.DBContext;
import dao.IAccountDAO;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * This class supplies a method to get account match by username & password <br>
 * The method implements IAccountDAO.<br>
 * The method will throw an object of <code>java.lang.Exception</code> class<br>
 * if there is any error occurring when searching or getting data.
 *
 * @author phuon
 */
public class AccountDAO extends DBContext implements IAccountDAO {

    /**
     * This method return an account from Database<br>
     * which is matched with username & password.
     *
     * @param username
     * @param password
     * @return account from Database.
     * @throws Exception provide information about database access error.
     */
    @Override
    public Account getAccount(String username, String password) throws Exception {
        String sql = "SELECT [username],[password],[isTeacher],[email]\n"
                + "FROM [Account]\n"
                + "WHERE [username] = ? AND [password] = ?";

        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();
            if (rs.next()) { // found
                Account account = new Account();
                account.setUsername(rs.getString("username"));
                account.setPassword(rs.getString("password"));
                account.setIsTeacher(rs.getBoolean("isTeacher"));
                account.setEmail(rs.getString("email"));
                return account;
            } else { // not found ~> return null
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            closeConnection(connection);
            closePreparedStatement(stm);
            closeResultSet(rs);
        }
    }

    /**
     * This method add an account to Database<br>
     *
     * @param account
     * @return status of method success or not.
     * @throws Exception provide information about database access error.
     */
    @Override
    public boolean insertAccount(Account account) throws Exception {
        String sql = "INSERT INTO [Account] ([username],[password],[isTeacher],[email])\n"
                + "VALUES(?,?,?,?)";

        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = getConnection();
            stm = connection.prepareStatement(sql);
            stm.setString(1, account.getUsername());
            stm.setString(2, account.getPassword());
            stm.setBoolean(3, account.isIsTeacher());
            stm.setString(4, account.getEmail());

            try {
                stm.execute();
                return true;
            } catch (SQLException e) { // violate primary key ~> insert fail
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            closeConnection(connection);
            closePreparedStatement(stm);
        }
    }
}
