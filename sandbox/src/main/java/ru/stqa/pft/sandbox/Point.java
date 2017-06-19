package ru.stqa.pft.sandbox;

/**
 * Created by gpodmorina on 15.06.2017.
 */
public class Point {

  public double x;
  public double y;


  public Point(double x, double y) {
    this.x = x;
    this.y = y;

  }

  public double distance(double x, double y) {

    double dx = this.x - x;
    double dy = this.y - y;
    double a = Math.sqrt(dx*dx + dy*dy);
    return a;

  }

}
