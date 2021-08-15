/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0001 Online quiz
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-18      1.0              PhuongNVHE140784      Initial commit
 */
package entity;

/**
 * This Class represent for Business object Account.<br>
 * The object has properties:<br>
 * <ul>
 * <li>username <code>java.lang.String</code></li>
 * <li>password <code>java.lang.String</code></li>
 * <li>isTeacher <code>boolean</code><li>
 * <li>name <code>java.lang.String</code></li>
 * </ul>
 *
 * @author phuon
 */
public class Account {

    private String username;
    private String password;
    private boolean isTeacher;
    private String email;

    public Account() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsTeacher() {
        return isTeacher;
    }

    public void setIsTeacher(boolean isTeacher) {
        this.isTeacher = isTeacher;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
