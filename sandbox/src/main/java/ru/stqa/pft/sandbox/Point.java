package ru.stqa.pft.sandbox;

/**
 * Created by gpodmorina on 15.06.2017.
 */
public class Point {

  public double x1;
  public double y1;
  public double x2;
  public double y2;

  public Point(double x1, double y1, double x2, double y2) {
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  public double distance() {

    double dx = this.x2 - this.x1;
    double dy = this.y2 - this.y1;
    double a = Math.sqrt(dx*dx + dy*dy);
    return a;

  }

}
