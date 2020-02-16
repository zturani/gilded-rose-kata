import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class GildedRoseTest {
  
  private List<Item> items;
  
  public GildedRoseTest() {
  }
  
  @Before
  public void setUp() {
    this.items = new ArrayList<>();
    ItemFactory iF = new ItemFactory();
    items.add(iF.makeItem("+5 Dexterity Vest", 10, 20)); //0
    items.add(iF.makeItem("Aged Brie", 2, 0));  //1
    items.add(iF.makeItem("Elixir of the Mongoose", 5, 3));  //2
    items.add(iF.makeItem("Sulfuras, Hand of Ragnaros", 0, 80));  //3
    items.add(iF.makeItem("Backstage passes to a TAFKAL80ETC concert", 15, 46));  //4
    items.add(iF.makeItem("Conjured Mana Cake", 5, 20));  //5
    items.add(iF.makeItem("+5 Dexterity Vest", 10, 0)); //6
    items.add(iF.makeItem("+5 Dexterity Vest", -1, 25)); //7
    items.add(iF.makeItem("Aged Brie", 10, 50));  //8
    items.add(iF.makeItem("Backstage passes to a TAFKAL80ETC concert", -1, 20));  //9
    items.add(iF.makeItem("Backstage passes to a TAFKAL80ETC concert", 5, 20));  //10
    items.add(iF.makeItem("Backstage passes to a TAFKAL80ETC concert", 3, 50));  //11
    items.add(iF.makeItem("Conjured Mana Cake", 5, 20)); //12
    GildedRose.items = items;
    GildedRose.updateQuality();
  }
  
  @Test
  public void sulfurasNotChangingQuality() {
    assertEquals(80,items.get(3).quality);
  }
  
  @Test
  public void sulfurasNotAgeing() { assertEquals(0,items.get(3).sellIn);
  }
  
  @Test
  public void normalItemsAgeing() { assertEquals(9,items.get(0).sellIn);
  }
  
  @Test
  public void normalItemsChangingQuality() { assertEquals(19,items.get(0).quality);
  }
  
  @Test
  public void qualityNotLowerThanZero() { assertEquals(0,items.get(6).quality);
  }
  
  @Test
  public void qualityDecreasesTwiceAsFast() {
    assertEquals(23,items.get(7).quality);
  }
  
  @Test
  public void agedBrieQualityIncreases() {
    assertEquals(1,items.get(1).quality);
  }
  
  @Test
  public void qualityNotBeyond50() {
    assertEquals(50,items.get(8).quality); //Brie
    assertEquals(50,items.get(11).quality); //BSPass
  }
  
  @Test
  public void backstagePassAfterConcertToZeroQuality() {
    assertEquals(0,items.get(9).quality);
  }
  
  @Test
  public void backstagePassIncreaseQualityMoreThan10Days() {
    assertEquals(47,items.get(4).quality);
  }
  
  @Test
  public void backstagePassIncreaseQualityWithin10Days() {
    assertEquals(23,items.get(10).quality);
  }
  
  @Test
  public void conjuredItemsQualityChangeFaster() {
    assertEquals(18,items.get(12).quality);
  }
}