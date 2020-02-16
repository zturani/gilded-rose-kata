public class BrieItem extends NormalItem implements TickItem {
    public BrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void tick() {
        int degradation = -1;
        quality = (quality < 50) ? quality - degradation : 50;
        sellIn--;
    }
}
