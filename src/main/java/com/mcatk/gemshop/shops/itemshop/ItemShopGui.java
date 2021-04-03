package com.mcatk.gemshop.shops.itemshop;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.TreeMap;

public class ItemShopGui {
    private final Inventory gui;
    
    public ItemShopGui(Items items) {
        gui = Bukkit.createInventory(null, 54, "§6宝石商店-" + items.getId());
        for (Item i : new TreeMap<>(items.getMap()).values()) {
            gui.addItem(getIcon(i));
        }
        gui.setItem(53,getQuitIcon());
    }
    
    public Inventory getGui() {
        return gui;
    }
    
    private ItemStack getIcon(Item item) {
        ItemStack icon = item.getItemStack().clone();
        ItemMeta meta = icon.getItemMeta();
        ArrayList<String> list = new ArrayList<>();
        list.add("ID:" + item.getId());
        if (meta.getLore() != null) {
            list.addAll(meta.getLore());
        }
        list.add("§e§m§l一§6§m§l一§c§m§l一§a§m§l一§b§m§l一§a§m§l一§c§m§l一§6§m§l一§e§m§l一");
        list.add("§a§l    点 击 购 买");
        list.add("§6 $消耗$ §a " + item.getPrice() + " §b宝石");
        list.add("§e§m§l一§6§m§l一§c§m§l一§a§m§l一§b§m§l一§a§m§l一§c§m§l一§6§m§l一§e§m§l一");
        meta.setLore(list);
        icon.setItemMeta(meta);
        return icon;
    }
    
    private ItemStack getQuitIcon(){
        ItemStack icon =  new ItemStack(Material.GOLD_NUGGET);
        ItemMeta meta = icon.getItemMeta();
        meta.setDisplayName("返回");
        icon.setItemMeta(meta);
        return icon;
    }
    
}
