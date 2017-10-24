package core;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Inkyov on 12/8/2016.
 */

public class Age {
  private SimpleStringProperty ageNumber;

  public Age(String ageName) {
    this.ageNumber = new SimpleStringProperty(ageName);
  }

  public String getAge() {
    return ageNumber.get();
  }
}
