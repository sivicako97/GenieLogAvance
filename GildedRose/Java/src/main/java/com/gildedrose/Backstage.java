package com.gildedrose;

public class Backstage extends Item {

    public Backstage(int sellIn, int quality) {
        super(GildedRose.BACKSTAGE, sellIn, quality);
    }

    @Override
    protected void update_Quality() {
        if (quality < GildedRose.MAXQUALITY) {
            increaseQuality();
            if (sellIn < GildedRose.BACKSTAGE_MAX_SELLIN) {
                increaseQuality();
            }
            if (sellIn < GildedRose.BACKSTAGE_MIDDLE_SELLIN) {
                increaseQuality();
            }
        }
        decreaseSellInValue();
        if (sellIn < 0) {
            quality = 0;
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
