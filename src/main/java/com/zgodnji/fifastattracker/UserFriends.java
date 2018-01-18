package com.zgodnji.fifastattracker;

import java.util.Date;



public class UserFriends {

    private String userId;
    private Date added;
    private boolean bestFriend;
    private String message;

    public UserFriends(String userId, Date added, boolean bestFriend, String message) {
        this.userId = userId;
        this.added = added;
        this.bestFriend = bestFriend;
        this.message = message;
    }

    public boolean isBestFriend() {
        return bestFriend;
    }

    public Date getAdded() {
        return added;
    }

    public String getMessage() {
        return message;
    }

    public String getUserId() {
        return userId;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public void setBestFriend(boolean bestFriend) {
        this.bestFriend = bestFriend;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
