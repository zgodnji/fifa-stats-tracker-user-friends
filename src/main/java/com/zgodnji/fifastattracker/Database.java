package com.zgodnji.fifastattracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;


public class Database {

    // user id, list of friends' ids
    private static Map<String, List<UserFriends>> users = new HashMap<>();

    // get all users with friends
    public static Map<String, List<UserFriends>> getUsers() {
        return users;
    }

    // get friends for a specific user
    public static List getFriends(String userId) {
        return users.get(userId);
    }

    // add user and his friends
    public static void addUser(String id, List<UserFriends> friends) {
        users.put(id, friends);
    }

    // delete user and his friends
    public static void deleteUser(String userId) {
        users.remove(userId);
    }
}