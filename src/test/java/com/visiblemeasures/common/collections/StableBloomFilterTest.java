package com.visiblemeasures.common.collections;

import com.google.common.hash.Funnels;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: aarutyunyants
 * Date: 7/12/13
 * Time: 11:19 AM
 * To change this template use File | Settings | File Templates.
 */
public class StableBloomFilterTest {
  private StableBloomFilter<CharSequence> sbf;

  @BeforeMethod
  public void setUp() {
    sbf = new StableBloomFilter<CharSequence>(50, 10, 5, Funnels.stringFunnel());
  }

  @AfterMethod
  public void tearDown() {
    sbf = null;
  }

  @Test
  public void testMightContain() throws Exception {
    sbf.put("1test");
    sbf.put("2test");
    sbf.put("3test");
    sbf.put("3test");
    sbf.put("3test");
    sbf.put("3test");
    sbf.put("3test");
    sbf.put("3test");
    sbf.put("3test");
    sbf.put("3test");
    Assert.assertTrue(sbf.mightContain("1test"), "False negative");
    Assert.assertFalse(sbf.mightContain("10test"), "False positive");
  }

  @Test
  public void testPut() throws Exception {
    sbf.put("1test");
    Assert.assertTrue(sbf.mightContain("1test"));
    Assert.assertFalse(sbf.mightContain("10test"));
  }

  @Test
  public void testDecrement() throws Exception {
    int min = 65;
    int max = 90;
    for (int i = min; i < max; i++) {
      sbf.put((char) i + "");
    }
    Assert.assertTrue(sbf.mightContain((char) (max - 1) + ""), "Recent items should be in the filter");
    Assert.assertTrue(sbf.mightContain((char) (max - 2) + ""), "Recent items should be in the filter");
    Assert.assertTrue(sbf.mightContain((char) (max - 3) + ""), "Recent items should be in the filter");
    Assert.assertFalse(sbf.mightContain("no"), "False positive");
    Assert.assertFalse(sbf.mightContain((char) min + ""), "Old items might NOT be in the filter");
  }
}
