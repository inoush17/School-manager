package org.example.models;

import javafx.scene.control.TableView;
import org.example.dbconfig.IDBConfig;
import org.example.interfaces.StudentInterface;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student implements StudentInterface {
    public TableView<Student> Table;
    private int id;
    private String lastname;
    private String  firstname;
    private LocalDate dateOfBirth;
    private String  placeOfBirth;
    private int state;
    private int classroomId;

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    private Connection connection;

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    @Override
    public void create(Student student) throws SQLException {
        connection = IDBConfig.getConnection();
        if (connection != null){

            String req = "INSERT INTO student (firstname, lastname, dateOfBirth, placeOfBirth, state, classroom_id) VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement prepareStatement = this.connection.prepareStatement(req);
            prepareStatement.setString(1, getFirstname());
            prepareStatement.setString(2, getLastname());
            prepareStatement.setDate(3, Date.valueOf(getDateOfBirth()));
            prepareStatement.setString(4, getPlaceOfBirth());
            prepareStatement.setInt(5, getState());
            prepareStatement.setInt(6, getClassroomId());


            prepareStatement.executeUpdate();
            prepareStatement.close();
            this.connection.close();

            System.out.println("Elève ajouté avec succès !");

        }
    }

    @Override
    public void read(int id) {

    }

    @Override
    public void update(Student student) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Student> list() throws SQLException {
        List<Student> students = new ArrayList<>();

        connection = IDBConfig.getConnection();
        if (connection != null){

            String req = "SELECT * FROM clients LIMIT 3 ";
            PreparedStatement prepareStatement = this.connection.prepareStatement(req);

            ResultSet resultSet = prepareStatement.executeQuery();

            while (resultSet.next()){
                Student student = new Student();
                student.setLastname(resultSet.getString("Nom"));
                student.setFirstname(resultSet.getString("Prénoms"));
                student.setDateOfBirth(resultSet.getDate("Date_de_naissance").toLocalDate());
                student.setPlaceOfBirth(resultSet.getString("Lieu_de_naissance"));
                student.setState(resultSet.getInt("Etat"));

                students.add(student);
            }
            prepareStatement.close();
            this.connection.close();

        }
        return null;
    }
}
