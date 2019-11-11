package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    public static final String AGEDBRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SUFLURAS = "Sulfuras, Hand of Ragnaros";
    public static final String CONJURED = "Conjured Mana Cake";
    public static int MAXQUALITY = 50;
    public static int BACKSTAGE_MAX_SELLIN = 11;
    public static int BACKSTAGE_MIDDLE_SELLIN = 6;
    
    public void updateQuality(){
        for (Item item : items) {
            item.update_Quality(this);
        }
    }
}
