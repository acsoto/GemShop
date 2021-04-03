package com.mcatk.gemshop.shops.permshop;

import com.mcatk.gem.Gem;
import com.mcatk.gemshop.Message;
import com.mcatk.gemshop.ServerCmd;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

public class PermShop {
    
    private HashMap<String, Integer> permPrice;
    
    public PermShop() {
        permPrice = new HashMap<>();
        permPrice.put("dragon.use.10", 10);
        permPrice.put("dragon.use.11", 20);
        permPrice.put("dragon.use.12", 30);
        permPrice.put("z.island.biomes", 10);
    }
    
    public void buyPerm(Player player, String permission) {
//        new BukkitRunnable() {
//            @Override
//            public void run() {
                if (!permPrice.containsKey(permission)) {
                    player.sendMessage(Message.ERROR + "无该权限");
                } else if (player.hasPermission(permission)) {
                    player.sendMessage(Message.INFO + "已拥有该权限");
                } else if (Gem.getPlugin().getGemExecutor().
                        takeGems(player.getName(), permPrice.get(permission))) {
                    ServerCmd.addPermission(player.getName(), permission);
                    player.sendMessage(Message.INFO + "购买成功");
                } else {
                    player.sendMessage(Message.ERROR + "宝石不足");
                }
//            }
//        }.runTaskAsynchronously(Gem.getPlugin());
    }
}
