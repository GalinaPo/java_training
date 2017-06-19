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

  public double distance(Point p2) {

    double dx = this.x - p2.x;
    double dy = this.y - p2.y;
    double a = Math.sqrt(dx*dx + dy*dy);
    return a;

  }

}
