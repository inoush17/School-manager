package org.example.interfaces;

import org.example.models.User;

import java.sql.SQLException;

public interface AuthInterface {
    void register(User user) throws SQLException;
    boolean signIn(User user) throws  SQLException;
}
