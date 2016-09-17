package database;

import java.sql.*;

import sample.*;

public class Database {

    Connection conn;

public Database(String db_file_name_prefix) throws Exception{
Class.forName("org.hsqldb.jdbcDriver");
    conn = DriverManager.getConnection("jdbc:hsqldb" + db_file_name_prefix ,"sa", "");
}
    public void shutdown() throws SQLException{
        Statement statement = conn.createStatement();
        statement.execute("SHUTDOWN");
        conn.close();
    }

    public static void insertParticipant(Participant participant) throws SQLException{

    }

}
