package com.mcatk.gemshop.commands;

import com.mcatk.gemshop.GemShop;
import com.mcatk.gemshop.shops.itemshop.ItemShopGui;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGemShop implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 0) {
                return true;
            } else if (args.length != 2) {
                sender.sendMessage("参数错误");
                return true;
            }
            Player player = (Player) sender;
            String type = args[0].toLowerCase();
            String id = args[1].toLowerCase();
            switch (type) {
                case "vip":
                    GemShop.getPlugin().getShopFactory().getVipShop().buyVip(player, id);
                    break;
                case "perm":
                    GemShop.getPlugin().getShopFactory().getPermShop().buyPerm(player, id);
                    break;
                case "item":
                    player.openInventory(
                            new ItemShopGui(
                                    GemShop.getPlugin().getShopFactory().
                                            getItemShop().getItems(id)).getGui()
                    );
                    break;
                default:
                    sender.sendMessage("gemshop vip/perm/item");
                    break;
            }
        } else {
            sender.sendMessage("非玩家不可执行");
        }
        return true;
    }
}
