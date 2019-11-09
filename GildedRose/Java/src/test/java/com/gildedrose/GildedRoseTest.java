package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {
    
    @Test
    public void QualityNeverNegative(){
        Item[] items = new Item[]{ 
            new Item("foo", 0, 5) 
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        for (int i = 0; i < items.length; i++){
            assertFalse(app.items[i].quality < 0);
        }
    }
    
    @Test
    public void QualityNeverOverFifty(){
        Item[] items = new Item[]{
            new Item("foo", 0, 0),
            new Item("Sulfuras, Hand of Ragnaros", 0, 50),
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        for( int i = 0; i < items.length; i++){
            assertFalse(app.items[i].quality > 50);         
        }
    }
    
    @Test
    public void Sulfura(){
        Item[] items = new Item[]{
            new Item("Sulfuras, Hand of Ragnaros", 0, 80)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 80);
        assertEquals(app.items[0].sellIn, 0);
               
    }
    
    @Test 
    public void ItemNormal(){
        Item[] items = new Item[]{
            new Item("objNormal1", -1, 20), 
            new Item("objNormal2", -1,  20), 
            new Item("objNormal3", -1,  20)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        for( int i = 0; i < items.length; i++){
            if (app.items[i].sellIn > 0){
                assertEquals(app.items[i].sellIn, -2);
                assertEquals(app.items[i].quality, 19);
            }else{
                assertEquals(app.items[i].sellIn, -2);
                assertEquals(app.items[i].quality, 18);   
            }
        }
    }

    @Test 
    public void AgedBrie(){
        Item[] items = new Item[]{
            new Item("Aged Brie", 3, 14), 
            new Item("Aged Brie", 3, 14), 
            new Item("Aged Brie", 3, 14),
            //new Item("Sulfuras, Hand of Ragnaros", 3, 14)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        for( int i = 0; i < items.length; i++){
            if (app.items[i].sellIn > 0){
                assertEquals(app.items[i].sellIn, 2);
                assertEquals(app.items[i].quality, 15);
            }else{
                assertEquals(app.items[i].sellIn, 2);
                assertEquals(app.items[i].quality, 16);     
            }
        }
    }
    
    @Test 
    public void BackstageInfTen(){
        Item[] items = new Item[]{
            new Item("Backstage passes to a TAFKAL80ETC concert", 6, 14)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 16);         
    }
    
    @Test 
    public void BackstageInfFive(){
        Item[] items = new Item[]{
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 14)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 17);         
    }
    
    @Test 
    public void BackstageExpired(){
        Item[] items = new Item[]{
            new Item("Backstage passes to a TAFKAL80ETC concert", -1, 14)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 0);         
    }
    
    @Test 
    public void BackstageSupTen(){
        Item[] items = new Item[]{
            new Item("Backstage passes to a TAFKAL80ETC concert", 12, 15)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 16);         
    }
    
    @Test 
    public void ItemConjured(){
        Item[] items = new Item[]{
            new Item("Conjured", 6, 14)
        };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(app.items[0].quality, 12);         
    }
 }
