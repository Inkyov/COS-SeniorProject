package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import core.*;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection conn;
    private Statement stmt;
    private ResultSet resultSet;

    private Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("org.hsqldb.jdbcDriver");
        return DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/","SA", "");
    }

    public void shutdown() throws SQLException, ClassNotFoundException {
        conn = getConnection();
        stmt = conn.createStatement();
        stmt.execute("SHUTDOWN");
        conn.close();

    }

    public ObservableList<Tournament> showTournaments() throws SQLException{
        ObservableList<Tournament> tournaments = FXCollections.observableArrayList();
        try {
            conn = getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query = "Select TOURID, TOURNAME, DATE_FROM, DATE_TO, TYPE, CITY From Tournament";
        stmt = conn.createStatement();
        resultSet = stmt.executeQuery(query);
        while (resultSet.next()){
            tournaments.add(new Tournament(
                    resultSet.getInt("TOURID"),
                    resultSet.getString("TOURNAME"),
                    resultSet.getString("Date_From"),
                    resultSet.getString("Date_To"),
                    resultSet.getString("Type"),
                    resultSet.getString("City")
            ));
        }
        return tournaments;
    }

    public ObservableList<Participant> showParticipants() throws Exception{
        ObservableList<Participant> participants = FXCollections.observableArrayList();
        conn = getConnection();
        String query="SELECT PARTICIPANTS.ID, PARTICIPANTS.NAME, CLUBS.CLUBNAME AS Club, RANKS.RANKNAME AS Rank, CATEGORIES.CATNAME AS Category, AGES.AGENAME AS Age, TOURNAMENT.TOURNAME AS TOURNAMENT FROM PARTICIPANTS \n" +
                "LEFT JOIN CLUBS ON PARTICIPANTS.CLUB = CLUBS.CLUBID\n" +
                "LEFT JOIN RANKS ON PARTICIPANTS.RANK = RANKS.RANKID\n" +
                "LEFT JOIN CATEGORIES ON PARTICIPANTS.CATEGORY = CATEGORIES.CATID\n" +
                "LEFT JOIN AGES ON PARTICIPANTS.AGE = AGES.AGEID\n" +
                "LEFT JOIN TOURNAMENT ON PARTICIPANTS.TOURNAMENT = TOURNAMENT.TOURID";
        stmt = conn.createStatement();
        resultSet = stmt.executeQuery(query);
        while (resultSet.next()) {
            participants.add(new Participant(
                    resultSet.getInt("ID"),
                    resultSet.getString("NAME"),
                    resultSet.getString("CLUB"),
                    resultSet.getString("RANK"),
                    resultSet.getString("CATEGORY"),
                    resultSet.getString("AGE"),
                    resultSet.getString("TOURNAMENT")
            ));
        }
        return participants;
    }

    public ObservableList<Club> fillClubs() throws Exception {
        ObservableList<Club> clubData = FXCollections.observableArrayList();
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
        ObservableList<Rank> rankData = FXCollections.observableArrayList();
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
        ObservableList<Category> categoryData = FXCollections.observableArrayList();
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
        ObservableList<Age> ageData = FXCollections.observableArrayList();
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

    public ObservableList<Tournament> fillTournament() throws Exception{
        ObservableList<Tournament> tournamentData = FXCollections.observableArrayList();
        conn = getConnection();
        String query = "Select Tournament.TourName as Name From Tournament";
        stmt = conn.createStatement();
        resultSet = stmt.executeQuery(query);
        while (resultSet.next()){
            tournamentData.add(new Tournament(
                    resultSet.getString("Name")
            ));
        }
        return tournamentData;
    }

    public ObservableList<Participant> randomList (ArrayList<Integer> values) throws SQLException, ClassNotFoundException {
        ObservableList<Participant> randomList = FXCollections.observableArrayList();
        conn = getConnection();
        String query = "Select Participants.Name From Participants Where Id IN (unnest(?)) Order By RAND()";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        Integer [] integers = new Integer[values.size()];
        values.toArray(integers);
        preparedStatement.setArray(1, conn.createArrayOf("int", integers));
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            randomList.add(new Participant(
                    resultSet.getString("Name")
            ));
        }
        return randomList;
    }


    public void insertParticipant(String name, int club, int rank, int category, int age, int tournament) throws SQLException, ClassNotFoundException {
        conn = getConnection();
        String query="Insert Into Participants (Name, Club, Rank, Category, Age, Tournament) Values (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, club);
        preparedStatement.setInt(3, rank);
        preparedStatement.setInt(4, category);
        preparedStatement.setInt(5, age);
        preparedStatement.setInt(6, tournament);
        preparedStatement.executeUpdate();

        conn.close();

    }

    public void addTournament(String name, String from, String to, String type, String city) throws SQLException, ClassNotFoundException {
        conn = getConnection();
        String query = "Insert Into Tournament (TourName, Date_From, Date_To, Type, City) Values (?,?,?,?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, from);
        preparedStatement.setString(3, to);
        preparedStatement.setString(4, type);
        preparedStatement.setString(5, city);
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

    public void updateParticipant(int id, String name, int club, int rank, int category, int age, int tournament) throws SQLException, ClassNotFoundException{
        conn = getConnection();
        String query = "Update Participants Set Name = ?, Club = ?, Rank = ?, Category = ?, Age = ?, Tournament = ? Where ID=?";
        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, name);
        preparedStatement.setInt(2, club);
        preparedStatement.setInt(3, rank);
        preparedStatement.setInt(4, category);
        preparedStatement.setInt(5, age);
        preparedStatement.setInt(6, tournament);
        preparedStatement.setInt(7, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        conn.close();
    }

}
