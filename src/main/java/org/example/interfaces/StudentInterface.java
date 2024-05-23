package org.example.interfaces;

import org.example.models.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentInterface {
    void create(Student student) throws SQLException;
    void read(int id);
    void update(Student student);
    void delete (int id);
    List<Student> list() throws SQLException;
}
