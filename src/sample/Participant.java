package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Inkyov on 3/22/2016.
 */
public class Participant {

    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty club;
    private SimpleStringProperty rank;
    private SimpleStringProperty category;
    private SimpleStringProperty age;
    private SimpleStringProperty tournament;

    public Participant(int id, String name, String club, String rank, String category, String age, String tournament){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.club = new SimpleStringProperty(club);
        this.rank = new SimpleStringProperty(rank);
        this.category = new SimpleStringProperty(category);
        this.age = new SimpleStringProperty(age);
        this.tournament = new SimpleStringProperty(tournament);
    }

    public int getId(){ return id.get(); }

    public String getName(){
        return name.get();
    }

    public String getClub(){
        return club.get();
    }

    public String getRank(){
        return rank.get();
    }

    public String getCategory(){
        return category.get();
    }

    public String getAge(){ return age.get(); }

    public String getTournament(){ return tournament.get(); }


}
