package sample;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Inkyov on 12/8/2016.
 */
public class Rank {

    private SimpleStringProperty rankName;

    public Rank(String rankName){
        this.rankName = new SimpleStringProperty(rankName);
    }

    public String getRankName(){
        return rankName.get();
    }
}
