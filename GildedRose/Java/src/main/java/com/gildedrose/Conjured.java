package com.gildedrose;

public class Conjured extends Item {

    public Conjured(int sellIn, int quality) {
        super(GildedRose.CONJURED, sellIn, quality);
    }

    @Override
    protected void update_Quality() {
        decreaseQuality();
        decreaseSellInValue();
        if (this.sellIn < 0) {
            decreaseQuality();
        }

    }

    private void decreaseQuality() {
        this.quality = this.quality - 2;
    }

    private void decreaseSellInValue() {
        this.sellIn = this.sellIn - 1;
    }

}
