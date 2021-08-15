/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0001 Online quiz
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-18      1.0              PhuongNVHE140784      Initial commit
 */
package dao.impl;

import dao.DBContext;
import dao.IQuestionDAO;
import entity.Account;
import entity.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class supplies a method to get questions match by account,<br>
 * random or insert to Database.<br>
 * The method implements IQuestionDAO.<br>
 * The method will throw an object of <code>java.lang.Exception</code> class<br>
 * if there is any error occurring when searching or getting data.
 *
 * @author phuon
 */
public class QuestionDAO extends DBContext implements IQuestionDAO {

    /**
     * This method return a list of questions from Database<br>
     * which created by specifics account
     *
     * @param account account of user.
     * @return list of questions matched with account.
     * @throws Exception provide information about database access error.
     */
    @Override
    public List<Question> getQuestions(Account account) throws Exception {
        List<Question> questions = new ArrayList<>();

        String sql = "SELECT [id],[question],\n"
                + "	[option1],[option2],[option3],[option4],\n"
                + "	[solution],[dateCreated],[createdBy]\n"
                + "FROM [Question]\n"
                + "WHERE [createdBy] = ?\n"
                + "ORDER BY [dateCreated]";

        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            stm = connection.prepareStatement(sql);
            stm.setString(1, account.getUsername());
            rs = stm.executeQuery();
            while (rs.next()) { // add to list until reach the end of result set
                Question q = new Question();
                q.setId(rs.getInt("id"));
                q.setQuestion(rs.getString("question"));
                q.setOption1(rs.getString("option1"));
                q.setOption2(rs.getString("option2"));
                q.setOption3(rs.getString("option3"));
                q.setOption4(rs.getString("option4"));
                q.setSolution(rs.getString("solution"));
                q.setDateCreated(rs.getDate("dateCreated"));
                Account createdBy = new Account();
                createdBy.setUsername(rs.getString("createdBy"));
                q.setCreatedBy(createdBy);

                questions.add(q);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            closeConnection(connection);
            closePreparedStatement(stm);
            closeResultSet(rs);
        }
        return questions;
    }

    /**
     * This method return a list of random questions from Database<br>
     *
     * @param numOfQuestions number of question user want to test.
     * @return random questions from Database.
     * @throws Exception provide information about database access error.
     */
    @Override
    public List<Question> getRandomQuestions(int numOfQuestions) throws Exception {
        List<Question> questions = new ArrayList<>();

        String sql = "SELECT TOP (?) \n"
                + "	[id],[question],\n"
                + "	[option1],[option2],[option3],[option4],\n"
                + "	[solution],[dateCreated],[createdBy]\n"
                + "FROM [Question]\n"
                + "ORDER BY NEWID()";

        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            stm = connection.prepareStatement(sql);
            stm.setInt(1, numOfQuestions);
            rs = stm.executeQuery();
            while (rs.next()) { // add to list until reach the end of result set
                Question q = new Question();
                q.setId(rs.getInt("id"));
                q.setQuestion(rs.getString("question"));
                q.setOption1(rs.getString("option1"));
                q.setOption2(rs.getString("option2"));
                q.setOption3(rs.getString("option3"));
                q.setOption4(rs.getString("option4"));
                q.setSolution(rs.getString("solution"));
                q.setDateCreated(rs.getDate("dateCreated"));
                Account createdBy = new Account();
                createdBy.setUsername(rs.getString("createdBy"));
                q.setCreatedBy(createdBy);

                questions.add(q);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            closeConnection(connection);
            closePreparedStatement(stm);
            closeResultSet(rs);
        }
        return questions;
    }

    /**
     * This method return total questions from Database<br>
     *
     * @return random number of questions from Database.
     * @throws Exception provide information about database access error.
     */
    @Override
    public int getTotalQuestions() throws Exception {
        String sql = "SELECT COUNT(*) AS [Total] FROM [Question]";

        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            if (rs.next()) { // count the number of quests
                return rs.getInt("Total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            closeConnection(connection);
            closePreparedStatement(stm);
            closeResultSet(rs);
        }
        return 0;
    }

    /**
     * This method insert a new question to Database<br>
     *
     * @param q new question want to add.
     * @throws Exception provide information about database access error.
     */
    @Override
    public void insert(Question q) throws Exception {
        String sql = "INSERT INTO [Question] ("
                + "[question],[option1],[option2],[option3],[option4],"
                + "[solution],[dateCreated],[createdBy])\n"
                + "VALUES(?,?,?,?,?,?,?,?)";

        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = getConnection();
            stm = connection.prepareStatement(sql);
            stm.setString(1, q.getQuestion());
            stm.setString(2, q.getOption1());
            stm.setString(3, q.getOption2());
            stm.setString(4, q.getOption3());
            stm.setString(5, q.getOption4());
            stm.setString(6, q.getSolution());
            stm.setDate(7, q.getDateCreated());
            stm.setString(8, q.getCreatedBy().getUsername());
            stm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            closeConnection(connection);
            closePreparedStatement(stm);
        }
    }
}
