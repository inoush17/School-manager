package org.example.interfaces;

import org.example.models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserInterface {
    List<User> list() throws SQLException;
}
