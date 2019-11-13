package com.gildedrose;

public class AgedBrie extends Item {

    public AgedBrie(int sellIn, int quality) {
        super(GildedRose.AGEDBRIE, sellIn, quality);
    }

    @Override
    protected void update_Quality() {
        increaseQuality();
        decreaseSellInValue();
        if (this.sellIn < 0) {
            increaseQuality();
        }
    }

    private void decreaseSellInValue() {
        this.sellIn = this.sellIn - 1;
    }

    private void increaseQuality() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
        }
    }
}
