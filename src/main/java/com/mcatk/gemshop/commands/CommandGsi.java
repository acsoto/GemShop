package com.mcatk.gemshop.commands;

import com.mcatk.gemshop.GemShop;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGsi implements CommandExecutor {
    
    private CommandSender sender;
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        this.sender = sender;
        if (args.length == 0) {
            printHelp();
            return true;
        }
        if (sender.isOp()) {
            if (args[0].equals("add")) {
                GemShop.getPlugin().getShopFactory().getItemShop().
                        addItem((Player) sender, args[1], args[2], args[3]);
            }
            if (args[0].equals("del")) {
                GemShop.getPlugin().getShopFactory().getItemShop().
                        delItem(args[1], args[2]);
            }
            if (args[0].equals("list")) {
                sender.sendMessage(GemShop.getPlugin().getShopFactory().getItemShop().toString());
            }
            return true;
        } else {
            return false;
        }
    }
    
    void printHelp() {
        sender.sendMessage("帮助：无设置判错机制，严格按照格式执行");
        sender.sendMessage("上架物品：/gsi add <商店ID> <物品ID> <价格>");
        sender.sendMessage("删除物品：/gsi del <商店ID> <物品ID>");
    }
}
