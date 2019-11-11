package com.gildedrose;

class GildedRose {

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    public static final String AGEDBRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SUFLURAS = "Sulfuras, Hand of Ragnaros";
    public static int MAXQUALITY = 50;
    public static int BACKSTAGE_MAX_SELLIN = 11;
    public static int BACKSTAGE_MIDDLE_SELLIN = 6;

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case AGEDBRIE:
                    increaseQualityWhenQualityLessThenFifty(item);
                    decreaseSellInValue(item);
                    if (item.sellIn < 0) {
                        increaseQualityWhenQualityLessThenFifty(item);
                    }
                    break;
                case BACKSTAGE:
                    if (item.quality < MAXQUALITY) {
                        increaseQualityWhenQualityLessThenFifty(item);
                        if (item.sellIn < BACKSTAGE_MAX_SELLIN) {
                            increaseQualityWhenQualityLessThenFifty(item);
                        }
                        if (item.sellIn < BACKSTAGE_MIDDLE_SELLIN) {
                            increaseQualityWhenQualityLessThenFifty(item);
                        }
                    }
                    decreaseSellInValue(item);
                    if (item.sellIn < 0) {
                        item.quality = 0;
                    }
                    break;
                case SUFLURAS:
                    break;
                default:
                    if (item.quality > 0) {
                        decreaseQuality(item);
                    }
                    decreaseSellInValue(item);
                    if (item.sellIn < 0 && item.quality > 0) {
                        decreaseQuality(item);
                    }
                    break;
            }
        }
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private void decreaseSellInValue(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private void increaseQualityWhenQualityLessThenFifty(Item item) {
        if (item.quality < 50) {
            increaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }
}
