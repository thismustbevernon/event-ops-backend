package org.EventOps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class DatabaseConnection {
    private static String url = "jdbc:postgresql://localhost/event-ops";
    public static Connection createConnection() {
        //        modify this function to return only the connection then use the connection in other files to perform
//        the necessary tasks

        {
            Connection conn;
            try {
                conn = DriverManager.getConnection(url, "vernon", "");
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


            try {
                System.out.println(conn.getMetaData().getDatabaseProductVersion());
            } catch (SQLException e) {
                System.out.println("Error connecting to database " + Arrays.toString(e.getStackTrace()));
                throw new RuntimeException(e);
            }


            return conn;
        }

    }

    //    Populates the database with initial values;
    public static void populateDatabase() {
        Connection currentConn = createConnection();
        Statement st;

        {
            try {
                st = currentConn.createStatement();
                st.execute("DROP TABLE students ");
                st.execute("CREATE TABLE IF NOT EXISTS students (id SERIAL PRIMARY KEY, firstName VARCHAR(255), lastName VARCHAR(255), netId VARCHAR(255), hours INTEGER)");
                st.execute("INSERT INTO students (firstName, lastName, netId, hours) VALUES ('Alonzo','Williams', 'aw123', 20)");
                st.execute("INSERT INTO students (firstName, lastName, netId, hours) VALUES ('Tessa','Kim', 'tk123', 18)");

                st.close();

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }


    }


}
