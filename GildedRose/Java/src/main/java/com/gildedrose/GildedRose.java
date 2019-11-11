package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Aged Brie":
                    increaseQualityWhenQualityLessThenFifty(item);
                    decreaseSellInValue(item);
                    if (item.sellIn < 0) {
                        increaseQualityWhenQualityLessThenFifty(item);
                    }   break;
                case "Backstage passes to a TAFKAL80ETC concert":
                    if (item.quality < 50) {
                        increaseQualityWhenQualityLessThenFifty(item);
                        if (item.sellIn < 11) {
                            increaseQualityWhenQualityLessThenFifty(item);
                        }
                        if (item.sellIn < 6) {
                            increaseQualityWhenQualityLessThenFifty(item);
                        }
                    }   decreaseSellInValue(item);
                    if (item.sellIn < 0) {
                        item.quality = 0;
                    }   break;
                case "Sulfuras, Hand of Ragnaros":
                    break;
                default:
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                    decreaseSellInValue(item);
                    if (item.sellIn < 0 && item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                    break;
            }
        }
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