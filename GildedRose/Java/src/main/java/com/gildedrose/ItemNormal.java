package com.gildedrose;

public class ItemNormal extends Item {

    public ItemNormal(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    protected void update_Quality() {
        if (this.quality > 0) {
            decreaseQuality();
        }
        decreaseSellInValue();
        if (this.sellIn < 0 && this.quality > 0) {
            decreaseQuality();
        }
    }

    private void decreaseQuality() {
        this.quality = this.quality - 1;
    }

    private void decreaseSellInValue() {
        this.sellIn = this.sellIn - 1;
    }

}
