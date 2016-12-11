package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 * Created by Inkyov on 12/10/2016.
 */

public class Tournament {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty date_from;
    private SimpleStringProperty date_to;
    private SimpleStringProperty type;
    private SimpleStringProperty city;

    public Tournament(String name){
        this.name = new SimpleStringProperty(name);
    }

    public Tournament(int id, String name, String date_from, String date_to, String type, String city){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.date_from = new SimpleStringProperty(date_from);
        this.date_to = new SimpleStringProperty(date_to);
        this.type = new SimpleStringProperty(type);
        this.city = new SimpleStringProperty(city);
    }

    public int getId(){ return id.get(); }

    public String getName(){
        return name.get();
    }

    public String getFrom(){
        return date_from.get();
    }

    public String getTo(){
        return date_to.get();
    }

    public String getType(){
        return type.get();
    }

    public String getCity(){
        return city.get();
    }
}
