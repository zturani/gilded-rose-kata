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
    items.add(new Item("+5 Dexterity Vest", 10, 20)); //0
    items.add(new Item("Aged Brie", 2, 0));  //1
    items.add(new Item("Elixir of the Mongoose", 5, 3));  //2
    items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));  //3
    items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 46));  //4
    items.add(new Item("Conjured Mana Cake", 5, 20));  //5
    items.add(new Item("+5 Dexterity Vest", 10, 0)); //6
    items.add(new Item("+5 Dexterity Vest", -1, 25)); //7
    items.add(new Item("Aged Brie", 10, 50));  //8
    items.add(new Item("Backstage passes to a TAFKAL80ETC concert", -1, 20));  //9
    items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));  //10
    items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50));  //11
    GildedRose.items = items;
    GildedRose.updateQuality();
  }
  
  @Test
  public void sulfurasNotChangingQuality() {
    assertEquals(items.get(3).quality,80);
  }
  
  @Test
  public void sulfurasNotAgeing() {
    assertEquals(items.get(3).sellIn,0);
  }
  
  @Test
  public void normalItemsAgeing() {
    assertEquals(items.get(0).sellIn,9);
  }
  
  @Test
  public void normalItemsChangingQuality() {
    assertEquals(items.get(0).quality,19);
  }
  
  @Test
  public void qualityNotLowerThanZero() {
    assertEquals(items.get(6).quality,0);
  }
  
  @Test
  public void qualityDecreasesTwiceAsFast() {
    assertEquals(items.get(7).quality,23);
  }
  
  @Test
  public void agedBrieQualityIncreases() {
    assertEquals(items.get(1).quality,1);
  }
  
  @Test
  public void qualityNotBeyond50() {
    assertEquals(items.get(8).quality,50); //Brie
    assertEquals(items.get(11).quality,50); //BSPass
  }
  
  @Test
  public void backstagePassAfterConcertToZeroQuality() {
    assertEquals(items.get(9).quality,0);
  }
  
  @Test
  public void backstagePassIncreaseQualityMoreThan10Days() {
    assertEquals(items.get(4).quality,47);
  }
  
  @Test
  public void backstagePassIncreaseQualityWithin10Days() {
    assertEquals(items.get(10).quality,23);
  }
}