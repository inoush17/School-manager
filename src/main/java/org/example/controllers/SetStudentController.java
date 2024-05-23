package org.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.example.models.Student;

import java.sql.SQLException;
import java.time.LocalDate;

public class SetStudentController {

    @FXML
    private TextField PlaceOfBirthTextField;

    @FXML
    private DatePicker DateOfBirthTextField;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private TextField stateTextField;
    @FXML
    private TextField classroomIdTextField;

    public void onSubmitStudent() throws SQLException {

        String placeOfBirth = PlaceOfBirthTextField.getText().trim();
        LocalDate dateOfBirth= DateOfBirthTextField.getValue();
        String firstname = firstnameTextField.getText().trim();
        String lastname = lastnameTextField.getText().trim();
        int state = Integer.parseInt(stateTextField.getText().trim());
        int classroomId = Integer.parseInt(classroomIdTextField.getText().trim());

        Student student = new Student();

        student.setPlaceOfBirth(placeOfBirth);
        student.setDateOfBirth(dateOfBirth);
        student.setFirstname(firstname);
        student.setLastname(lastname);
        student.setState(state);
        student.setClassroomId(classroomId);

        student.create(student);

    }

}

