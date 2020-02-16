public class PassItem extends Item implements TickItem {

    public PassItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void tick() {
        int degradation;
        if (sellIn < 0) {
            quality = 0;
        } else {
            if (sellIn > 10) {
                degradation = -1;
            } else if (sellIn > 5) {
                degradation = -2;
            } else {
                degradation = -3;
            }
            quality = (quality < 50) ? quality - degradation : 50;
        }
        sellIn--;
    }
}
