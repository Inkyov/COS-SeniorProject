package inkyov.judge;

import java.io.Serializable;

/**
 * Created by Inkyov on 11/22/2016.
 */
public class Point implements Serializable {
  private String color;
  private int points;
  private static final long serialVersionUID = 78931958389436584L;

  Point(String color, int points) {
    this.color = color;
    this.points = points;
  }

  public String getColor() {
    return this.color;
  }

  public int getPoints() {
    return this.points;
  }
}
