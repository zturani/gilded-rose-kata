public class ConjuredItem extends Item implements TickItem{
    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void tick() {
        int degradation = (sellIn >= 0) ? 2 : 4;
        quality = (quality > 0) ? quality - degradation : 0;
        sellIn--;
    }
}
