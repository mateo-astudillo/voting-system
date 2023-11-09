package Domain;

import java.sql.*;

public class Voter {
    private int id;
    private int document;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private String address;
    private String sex;

    public Voter(Connection connection, int document) {
        this.document = document;
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL getVoter(?, ?, ?, ?, ?, ?);");
            callableStatement.setInt(1, document);
            callableStatement.execute();
            this.id = callableStatement.getInt(2);
            this.firstName = callableStatement.getString(3);
            this.lastName = callableStatement.getString(4);
            this.birthdate = callableStatement.getDate(5);
            this.address = callableStatement.getString(6);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            System.out.println("No hay nadie");
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthdate() {
        if (birthdate  ==null) {
            return "";
        }
        return birthdate.toString();
    }

    public String getDocument() {
        return "" + document;
    }
}
