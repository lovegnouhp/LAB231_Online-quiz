/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0001 Online quiz
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-18      1.0              PhuongNVHE140784      Initial commit
 */
package entity;

import java.sql.Date;

/**
 * This Class represent for Business object Question.<br>
 * The object has properties:<br>
 * <ul>
 * <li>id <code>int</code></li>
 * <li>question <code>java.lang.String</code></li>
 * <li>option1 <code>java.lang.String</code></li>
 * <li>option2 <code>java.lang.String</code></li>
 * <li>option3 <code>java.lang.String</code></li>
 * <li>option4 <code>java.lang.String</code></li>
 * <li>solution <code>java.lang.String</code></li>
 * <li>dateCreated <code>java.sql.Date</code><li>
 * <li>createdBy <code>entity.Account</code></li>
 * </ul>
 *
 * @author phuon
 */
public class Question {

    private int id;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String solution;
    private Date dateCreated;
    private Account createdBy;

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Account getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Account createdBy) {
        this.createdBy = createdBy;
    }

}
