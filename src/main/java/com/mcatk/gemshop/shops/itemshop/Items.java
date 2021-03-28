package com.mcatk.gemshop.shops.itemshop;

import com.mcatk.gemshop.GemShop;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashMap;

public class Items {
    private String id;
    private HashMap<String, Item> map;
    
    public Items(String id) {
        this.id = id;
        map = loadItems();
    }
    
    private HashMap<String, Item> loadItems() {
        HashMap<String, Item> map = new HashMap<>();
        ConfigurationSection cs =
                GemShop.getPlugin().getConfig().getConfigurationSection("Items." + id);
        if (cs != null) {
            StringBuilder stringBuilder = new StringBuilder(id + "已载入:");
            for (String key : cs.getKeys(false)) {
                map.put(key, (Item) cs.get(key));
                stringBuilder.append(key).append(",");
            }
            GemShop.log(stringBuilder.toString());
        }
        return map;
    }
    
    public HashMap<String, Item> getMap() {
        return map;
    }
    
    public String getId() {
        return id;
    }
}
