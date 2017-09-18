package com.keji.blog.dataobject;

import java.util.Date;

public class BlogUser {
    private Long userId;

    private String userName;

    private String userNickname;

    private String userPassword;

    private String userQuestion;

    private String userAnswer;

    private String userPicture;

    private Boolean userStatus;

    private Date userCreated;

    private Date userUpdated;

    private String userIp;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserQuestion() {
        return userQuestion;
    }

    public void setUserQuestion(String userQuestion) {
        this.userQuestion = userQuestion == null ? null : userQuestion.trim();
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer == null ? null : userAnswer.trim();
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture == null ? null : userPicture.trim();
    }

    public Boolean getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Boolean userStatus) {
        this.userStatus = userStatus;
    }

    public Date getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(Date userCreated) {
        this.userCreated = userCreated;
    }

    public Date getUserUpdated() {
        return userUpdated;
    }

    public void setUserUpdated(Date userUpdated) {
        this.userUpdated = userUpdated;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }
}