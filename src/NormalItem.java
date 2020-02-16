public class NormalItem extends Item implements TickItem {

    public NormalItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void tick() {
        int degradation = (sellIn >= 0) ? 1 : 2;
        quality = (quality > 0) ? quality - degradation : 0;
        sellIn--;
    }
}
