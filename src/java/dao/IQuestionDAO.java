/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0001 Online quiz
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-18      1.0              PhuongNVHE140784      Initial commit
 */
package dao;

import entity.Account;
import entity.Question;
import java.util.List;

/**
 * This interface contain methods about Question<br>
 * <code>java.lang.Exception</code> throws when error occurs
 *
 * @author phuon
 */
public interface IQuestionDAO {

    /**
     * This method return a list of random questions from Database<br>
     *
     * @param numOfQuestions number of question user want to test.
     * @return random questions from Database.
     * @throws Exception provide information about database access error.
     */
    public List<Question> getRandomQuestions(int numOfQuestions) throws Exception;

    /**
     * This method return total questions from Database<br>
     *
     * @return random number of questions from Database.
     * @throws Exception provide information about database access error.
     */
    public int getTotalQuestions() throws Exception;

    /**
     * This method return a list of questions from Database<br>
     * which created by specifics account
     *
     * @param account account of user.
     * @return list of questions matched with account.
     * @throws Exception provide information about database access error.
     */
    public List<Question> getQuestions(Account account) throws Exception;

    /**
     * This method insert a new question to Database<br>
     *
     * @param q new question want to add.
     * @throws Exception provide information about database access error.
     */
    public void insert(Question q) throws Exception;
}
