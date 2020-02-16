public class ItemFactory {

    public ItemFactory() {
    }

    public Item makeItem(String name, int sellIn, int quality) {
        if (name.contains("Aged Brie")) {
            return new BrieItem(name, sellIn, quality);
        }
        if (name.contains("Sulfuras")) {
            return new SulfurasItem(name, sellIn, quality);
        }
        if (name.contains("Backstage pass")) {
            return new PassItem(name, sellIn, quality);
        }
        if (name.contains("Conjured")) {
            return new ConjuredItem(name, sellIn, quality);
        }
        return new NormalItem(name,sellIn,quality);
    }
}
