package com.gildedrose;

import static com.gildedrose.GildedRose.AGEDBRIE;
import static com.gildedrose.GildedRose.BACKSTAGE;
import static com.gildedrose.GildedRose.SUFLURAS;

public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public static Item createItem(String name, int sellIn, int quality) {
        switch (name) {
            case AGEDBRIE:
                return new AgedBrie(sellIn, quality);
            case BACKSTAGE:
                return new Backstage(sellIn, quality);
            case SUFLURAS:
                return new Sulfuras(sellIn, quality);
            default:
                return new Item(name, sellIn, quality);
        }
    }

    
   @Override
   public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    protected void update_Quality(GildedRose gildedRose) {
        switch (this.name) {
            case GildedRose.AGEDBRIE:
                increaseQuality();
                decreaseSellInValue();
                if (this.sellIn < 0) {
                    increaseQuality();
                }
                break;
            case GildedRose.BACKSTAGE:
                if (this.quality < GildedRose.MAXQUALITY) {
                    increaseQuality();
                    if (this.sellIn < GildedRose.BACKSTAGE_MAX_SELLIN) {
                        increaseQuality();
                    }
                    if (this.sellIn < GildedRose.BACKSTAGE_MIDDLE_SELLIN) {
                        increaseQuality();
                    }
                }
                decreaseSellInValue();
                if (this.sellIn < 0) {
                    this.quality = 0;
                }
                break;
            case GildedRose.SUFLURAS:
                break;
            default:
                if (this.quality > 0) {
                    decreaseQuality();
                }
                decreaseSellInValue();
                if (this.sellIn < 0 && this.quality > 0) {
                    decreaseQuality();
                }
                break;
        }
    }

    private void decreaseQuality() {
        this.quality = this.quality - 1;
    }

    private void decreaseSellInValue() {
        this.sellIn = this.sellIn - 1;
    }

    private void increaseQuality() {
        if (this.quality < 50) {
            this.quality = this.quality + 1;
        }
    }

    void update_Quality() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        decreaseQuality();
        decreaseSellInValue();
    }
}