package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by gpodmorina on 16.06.2017.
 */
public class PointTests {

  @Test
  public void testDistance() {
    Point p = new Point(1, 2, 5, 6);
    Assert.assertEquals(p.distance(), 5.656854249492381);
  }
}
