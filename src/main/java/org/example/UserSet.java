package org.example;

import java.util.*;

public class UserSet {

    private Set<String> users = new HashSet<>();
    private int userCount = 0;

    public boolean addUser(String user) {
        if (user == null || user.isEmpty() || user.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (containsUser(user)) {
            return false;
        }
        else {
            users.add(user);
            userCount++;
            return true;
        }
    }

    public boolean containsUser(String user) {
        return users.contains(user);
    }

    public int getUserCount() {
        return userCount;
    }

    public boolean removeUser(String user) {
        if (containsUser(user)) {
            users.remove(user);
            userCount--;
            return true;
        }
        else {
            return false;
        }
    }

    public HashSet<String> getUsersWithPrefix(String prefix) {
        HashSet<String> filteredSet = new HashSet<>();
        if (prefix == null) {
            throw new IllegalArgumentException();
        }
        if (users.isEmpty()) {
            return filteredSet;
        }

        for (String user : users) {
            if (user.startsWith(prefix)) {
                filteredSet.add(user);
            }
        }
        return filteredSet;
    }

    public boolean areAllUsersUnique(String[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException();
        }
        if (arr.length == 0) {
            return true;
        }
        HashSet<String> seenUsers = new HashSet<>();

        for (String user : arr) {
            if (seenUsers.contains(user)) {
                return false;
            }
            else {
                seenUsers.add(user);
            }
        }
        return true;

    }

}
