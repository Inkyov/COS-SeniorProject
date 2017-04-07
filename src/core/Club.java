package core;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Inkyov on 12/8/2016.
 */
public class Club {

    private SimpleStringProperty clubName;

    public Club(String clubName){
        this.clubName = new SimpleStringProperty(clubName);
    }

    public String getClubName(){
        return clubName.get();
    }
}
