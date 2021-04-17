package com.mcatk.gemshop;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class GemListener implements Listener {
    
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getInventory().getTitle().contains("§6宝石商店-")) {
            if (event.getWhoClicked() instanceof Player) {
                ItemStack icon = event.getCurrentItem();
                event.setCancelled(true);
                if (icon != null) {
                    List<String> list = icon.getItemMeta().getLore();
                    if (list != null) {
                        String shopId = event.getInventory().getTitle().split("-")[1];
                        String itemId = list.get(0).split(":")[1];
                        GemShop.getPlugin().getShopFactory().
                                getItemShop().buyItem(
                                        (Player) event.getWhoClicked(),shopId, itemId
                        );
                    }
                    if (icon.getItemMeta().getDisplayName().equals("返回")){
                        ((Player) event.getWhoClicked()).chat("/gemshop");
                    }
                    
                }
            }
        }
    }
}
