package sample;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Inkyov on 12/8/2016.
 */
public class Age {
    private SimpleStringProperty age;

    public Age(String ageName){
        this.age = new SimpleStringProperty(ageName);
    }

    public String getAge(){
        return age.get();
    }
}
