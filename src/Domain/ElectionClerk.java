package Domain;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

public class ElectionClerk {
    private int id;
    private Date opening_time;
    private Date closing_time;

    public ElectionClerk(int id) {
        this.id = id;
    }

    public static int validateLogin(Connection connection, String username, String password) {
        if (username.length()  !=6 || password.length()  !=6) {
            return 0;
        }
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL validateElectionClerk(?, ?, ?)");
            callableStatement.setString(1, username);
            callableStatement.setString(2, password);
            callableStatement.execute();
            return callableStatement.getInt(3);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean saveOpeningTime(Connection connection) {
        try {
            CallableStatement callableStatement = connection.prepareCall("CALL saveOpeningTime(?)");
            callableStatement.setInt(1, this.id);
            return callableStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
