package org.example.models;

import org.example.dbconfig.IDBConfig;
import org.example.interfaces.AuthInterface;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User implements AuthInterface {
    private String email;
    private String password;

    private Connection connection;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void register(User user) throws SQLException {
        connection = IDBConfig.getConnection();
        if (connection != null) {

            PreparedStatement prepareStatement = this.connection.prepareStatement("INSERT INTO user (email, password) VALUES (?, ?)");
            prepareStatement.setString(1, user.getEmail());
            prepareStatement.setString(2, user.getPassword());

            int row = prepareStatement.executeUpdate();

            if (row == 0){
                System.out.println("La création du compte n'a pas aboutie. Veuillez vérifier les informations saisies");
            }else{
                System.out.println(String.valueOf(row));
            }

            prepareStatement.close();
            this.connection.close();
        }

    }

    @Override
    public boolean signIn(User user) throws SQLException {
        this.connection = IDBConfig.getConnection();
        int row = 0;

        if (connection != null){
            String req = "SELECT * FROM user WHERE email = ? AND password = ? ;";
            PreparedStatement preparedStatement = this.connection.prepareStatement(req);
            preparedStatement.setString(1, getEmail());
            preparedStatement.setString(2, getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                row++;
            }
            preparedStatement.close();
            this.connection.close();

        }

        return row > 0;
    }
}
