package core;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Inkyov on 12/8/2016.
 */
public class Category {

  private SimpleStringProperty catName;

  public Category(String catName) {
    this.catName = new SimpleStringProperty(catName);
  }

  public String getCategoryName() {
    return catName.get();
  }
}
