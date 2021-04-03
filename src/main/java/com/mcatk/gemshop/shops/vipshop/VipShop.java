package com.mcatk.gemshop.shops.vipshop;

import com.mcatk.gem.Gem;
import com.mcatk.gemshop.Message;
import com.mcatk.gemshop.ServerCmd;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class VipShop {
    
    public void buyVip(Player player, String vipType) {
//        new BukkitRunnable() {
//            @Override
//            public void run() {
                if (player.hasPermission("cmi.command.se")) {
                    player.sendMessage(Message.INFO + "已拥有VIP");
                } else if (Gem.getPlugin().getGemExecutor().
                        takeGems(player.getName(), getPrice(vipType))) {
                    String cmd = String.format(
                            "lp user %s parent addtemp %s 30d",
                            player.getName(), vipType
                    );
                    ServerCmd.sendConsoleCmd(cmd);
                    player.sendMessage(Message.INFO + "成功开通" + vipType + "30天");
                    Bukkit.getLogger().info(player.getName() + "成功开通" + vipType + "30天");
                } else {
                    player.sendMessage(Message.ERROR + "宝石不足");
                }
//            }
//        }.runTaskAsynchronously(Gem.getPlugin());
    }
    
    private int getPrice(String vipType) {
        switch (vipType) {
            case "vip":
                return 10;
            case "svip":
                return 20;
            case "mvp":
                return 30;
            default:
                return 1000;
            //impossible
        }
    }
    
}
