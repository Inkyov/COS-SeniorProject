package database;

import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.*;

public class Database {
    Connection conn;
    Statement stmt;
    ResultSet resultSet;
    ObservableList<Participant> data = FXCollections.observableArrayList();
    ObservableList<Club> clubData = FXCollections.observableArrayList();
    ObservableList<Rank> rankData = FXCollections.observableArrayList();
    ObservableList<Category> categoryData = FXCollections.observableArrayList();
    ObservableList<Age> ageData = FXCollections.observableArrayList();
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("org.hsqldb.jdbcDriver");
        return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","sa", "");
    }

    public void shutdown() throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","sa", "");
        Statement statement = connection.createStatement();
        statement.execute("SHUTDOWN");
        connection.close();
    }

    public ObservableList<Participant> showParticipants() throws Exception{
        conn = getConnection();
        String query="SELECT PARTICIPANTS.ID, PARTICIPANTS.NAME, CLUBS.CLUBNAME AS Club, RANKS.RANKNAME AS Rank, CATEGORIES.CATNAME AS Category, AGES.AGENAME AS Age FROM PARTICIPANTS \n" +
                "LEFT JOIN CLUBS ON PARTICIPANTS.CLUB = CLUBS.CLUBID\n" +
                "LEFT JOIN RANKS ON PARTICIPANTS.RANK = RANKS.RANKID\n" +
                "LEFT JOIN CATEGORIES ON PARTICIPANTS.CATEGORY = CATEGORIES.CATID\n" +
                "LEFT JOIN AGES ON PARTICIPANTS.AGE = AGES.AGEID ";
        stmt = conn.createStatement();
        resultSet = stmt.executeQuery(query);
        while (resultSet.next()) {
            data.add(new Participant(
                    resultSet.getInt("ID"),
                    resultSet.getString("NAME"),
                    resultSet.getString("CLUB"),
                    resultSet.getString("RANK"),
                    resultSet.getString("CATEGORY"),
                    resultSet.getString("AGE")
            ));
        }
        return data;
    }

    public ObservableList<Club> fillClubs() throws Exception {
        conn = getConnection();
        String query="SELECT CLUBS.CLUBNAME AS CLUBNAME From CLUBS";
        stmt = conn.createStatement();
        resultSet = stmt.executeQuery(query);
        while (resultSet.next()) {
            clubData.add(new Club(
                    resultSet.getString("CLUBNAME")
            ));
        }
        return clubData;
    }

    public ObservableList<Rank> fillRanks() throws Exception {
        conn = getConnection();
        String query="SELECT RANKS.RANKNAME AS RANKNAME From RANKS";
        stmt = conn.createStatement();
        resultSet = stmt.executeQuery(query);
        while (resultSet.next()) {
            rankData.add(new Rank(
                    resultSet.getString("RANKNAME")
            ));
        }
        return rankData;
    }

    public ObservableList<Category> fillCategories() throws Exception {
        conn = getConnection();
        String query="SELECT CATEGORIES.CATNAME AS CATNAME From CATEGORIES";
        stmt = conn.createStatement();
        resultSet = stmt.executeQuery(query);
        while (resultSet.next()) {
            categoryData.add(new Category(
                    resultSet.getString("CATNAME")
            ));
        }
        return categoryData;
    }

    public ObservableList<Age> fillAges() throws Exception {
        conn = getConnection();
        String query="SELECT AGES.AGENAME AS AGENAME From AGES";
        stmt = conn.createStatement();
        resultSet = stmt.executeQuery(query);
        while (resultSet.next()) {
            ageData.add(new Age(
                    resultSet.getString("AGENAME")
            ));
        }
        return ageData;
    }

    public void insertParticipant(String name, int club, int rank, int category, int age) throws SQLException, ClassNotFoundException {
        conn = getConnection();
        String query="Insert Into Participants (Name, Club, Rank, Category, Age) Values (?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, club);
        preparedStatement.setInt(3, rank);
        preparedStatement.setInt(4, category);
        preparedStatement.setInt(5, age);
        preparedStatement.executeUpdate();

        conn.close();

    }

    public void deleteParticipant(int id) throws SQLException, ClassNotFoundException {
        conn = getConnection();
        String query = "Delete From Participants Where ID = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        conn.close();

    }

    public void updateParticipant(int id, String name, int club, int rank, int category, int age) throws SQLException, ClassNotFoundException{
        conn = getConnection();
        String query = "Update Participants Set Name = ?, Club = ?, Rank = ?, Category = ?, Age = ? Where ID=?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, club);
        preparedStatement.setInt(3, rank);
        preparedStatement.setInt(4, category);
        preparedStatement.setInt(5, age);
        preparedStatement.setInt(6, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        conn.close();
    }

}
