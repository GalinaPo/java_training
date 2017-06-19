package ru.stqa.pft.sandbox;

/**
 * Created by gpodmorina on 14.06.2017.
 */
public class MySecondProgram {

  public static void main(String[] args) {

    Point p1 = new Point(5, 6);
    Point p2 = new Point(1,2);

    System.out.println("Расстояние между точками = " + p1.distance(p2));

  }

}
