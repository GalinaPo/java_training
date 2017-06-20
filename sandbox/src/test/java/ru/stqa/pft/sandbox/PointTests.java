package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by gpodmorina on 16.06.2017.
 */
public class PointTests {

  @Test
  public void testDistance() {
    Point p1 = new Point(5, 6);
    Point p2 = new Point(1,2);
    Assert.assertEquals(p1.distance(p2), 5.656854249492381);
  }
}
