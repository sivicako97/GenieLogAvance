package com.gildedrose;

import static com.gildedrose.GildedRose.AGEDBRIE;
import static com.gildedrose.GildedRose.BACKSTAGE;
import static com.gildedrose.GildedRose.CONJURED;
import static com.gildedrose.GildedRose.SUFLURAS;

public class Item {

    static Item createItem(String name, int sellIn, int quality) {
        switch (name) {
            case AGEDBRIE:
                return new AgedBrie(sellIn, quality);
            case BACKSTAGE:
                return new Backstage(sellIn, quality);
            case SUFLURAS:
                return new Sulfuras(sellIn, quality);
            case CONJURED:
                return new Conjured(sellIn, quality);
            default:
                return new ItemNormal(name, sellIn, quality);
        }
    }

    public String name;

    public int sellIn;

    public int quality;

    Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    protected void update_Quality() {
    }
}
