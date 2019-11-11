package com.gildedrose;


public class AgedBrie extends Item {

    public AgedBrie(int sellIn, int quality) {
        super(GildedRose.AGEDBRIE, sellIn, quality);
    }
    
    @Override
    protected void update_Quality() {
        if (this.quality < 50) {
            quality = quality + 1;
        }
        sellIn = sellIn - 1;
        if (this.sellIn < 0) {
            if(quality < 50){
                quality = quality + 1;
            }  
        }
    }
}  
