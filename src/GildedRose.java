import java.util.ArrayList;
import java.util.List;


public class GildedRose {
  
  public static List<Item> items = null;
  
  public static void main(String[] args) {
    items = new ArrayList<>();
    ItemFactory iF = new ItemFactory();
    items.add(iF.makeItem("+5 Dexterity Vest", 10, 20));
    items.add(iF.makeItem("Aged Brie", 2, 0));
    items.add(iF.makeItem("Elixir of the Mongoose", 5, 3));
    items.add(iF.makeItem("Sulfuras, Hand of Ragnaros", 0, 80));
    items.add(iF.makeItem("Backstage passes to a TAFKAL80ETC concert", 15, 46));
    items.add(iF.makeItem("Conjured Mana Cake", 5, 20));
  }
  
  public static void updateQuality() {

    for (Item item : items) {
      TickItem i = (TickItem) item;
      i.tick();
    }
  }
}