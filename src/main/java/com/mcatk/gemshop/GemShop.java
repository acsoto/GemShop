package com.mcatk.gemshop;

import com.mcatk.gemshop.commands.CommandGemShop;
import com.mcatk.gemshop.commands.CommandGsi;
import com.mcatk.gemshop.shops.ShopFactory;
import com.mcatk.gemshop.shops.itemshop.Item;
import org.bukkit.Bukkit;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

public final class GemShop extends JavaPlugin {
    private static GemShop plugin;
    private ShopFactory shopFactory;
    
    public static GemShop getPlugin() {
        return plugin;
    }
    
    public ShopFactory getShopFactory() {
        return shopFactory;
    }
    
    @Override
    public void onEnable() {
        saveDefaultConfig();
        ConfigurationSerialization.registerClass(Item.class);
        plugin = this;
        shopFactory = new ShopFactory();
        Bukkit.getPluginCommand("gemshop").
                setExecutor(new CommandGemShop());
        Bukkit.getPluginCommand("gsi").
                setExecutor(new CommandGsi());
        Bukkit.getPluginManager().
                registerEvents(new GemListener(), this);
        log("GemShop已启动");
    }
    
    @Override
    public void onDisable() {
        log("GemShop已关闭");
    }
    
    public static void log(String str) {
        getPlugin().getLogger().info(str);
    }
    
}
