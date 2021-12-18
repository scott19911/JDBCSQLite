package org.itstep.verizhenko;

import java.sql.*;

public class JDBCSQLite {
    public static void main(String[] args) {
        Connection connection = null;
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:D:/MyDB/test.db");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT p.FIO, p.AGE from Student as s inner join Person as p on " +
                            "s.ID_PERSON= p.id"
                    );
            while (resultSet.next())
            {
                System.out.println(resultSet.getString("FIO") +" "+ resultSet.getInt("AGE"));
            }
            resultSet = statement.executeQuery("SELECT u.FIRST_NAME, u.LAST_NAME from Student as s inner join Person as p on " +
                    "s.ID_PERSON= p.id inner join User as u on p.FIO = u.LAST_NAME"
            );
            while (resultSet.next())
            {
                System.out.println(resultSet.getString("FIRST_NAME") +" "
                        + resultSet.getString("LAST_NAME"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }
}
