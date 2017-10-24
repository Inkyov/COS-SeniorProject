package core;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 * Created by Inkyov on 12/10/2016.
 */

public class Tournament {
  private SimpleIntegerProperty id;
  private SimpleStringProperty name;
  private SimpleStringProperty dateFrom;
  private SimpleStringProperty dateTo;
  private SimpleStringProperty type;
  private SimpleStringProperty city;

  public Tournament(String name) {
    this.name = new SimpleStringProperty(name);
  }

  public Tournament(int id, String name, String dateFrom, String dateTo, String type, String city) {
    this.id = new SimpleIntegerProperty(id);
    this.name = new SimpleStringProperty(name);
    this.dateFrom = new SimpleStringProperty(dateFrom);
    this.dateTo = new SimpleStringProperty(dateTo);
    this.type = new SimpleStringProperty(type);
    this.city = new SimpleStringProperty(city);
  }

  public int getId() {
    return id.get();
  }

  public String getName() {
    return name.get();
  }

  public String getFrom() {
    return dateFrom.get();
  }

  public String getTo() {
    return dateTo.get();
  }

  public String getType() {
    return type.get();
  }

  public String getCity() {
    return city.get();
  }
}
