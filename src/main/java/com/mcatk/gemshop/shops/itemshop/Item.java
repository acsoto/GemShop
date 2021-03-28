package com.mcatk.gemshop.shops.itemshop;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class Item implements ConfigurationSerializable {
    private String id;
    private ItemStack itemStack;
    private int price;
    
    public Item(String id, ItemStack itemStack, int price) {
        this.id = id;
        this.itemStack = itemStack;
        this.price = price;
    }
    
    public String getId() {
        return id;
    }
    
    public int getPrice() {
        return price;
    }
    
    public ItemStack getItemStack() {
        return itemStack;
    }
    
    @Override
    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("itemStack", itemStack);
        map.put("price", price);
        return map;
    }
    
    public static Item deserialize(Map<String, Object> map) {
        return new Item(
                (String) map.get("id"),
                (ItemStack) map.get("itemStack"),
                (int) map.get("price")
        );
    }
}
