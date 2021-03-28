package com.mcatk.gemshop.shops;

import com.mcatk.gemshop.GemShop;
import com.mcatk.gemshop.shops.itemshop.ItemShop;
import com.mcatk.gemshop.shops.permshop.PermShop;
import com.mcatk.gemshop.shops.vipshop.VipShop;

public class ShopFactory {
    private final VipShop vipShop;
    private final PermShop permShop;
    private final ItemShop itemShop;
    
    public ShopFactory() {
        vipShop = new VipShop();
        GemShop.log("VipShop初始化");
        permShop = new PermShop();
        GemShop.log("PermShop初始化");
        itemShop = new ItemShop();
        GemShop.log("ItemShop初始化");
    }
    
    public VipShop getVipShop() {
        return vipShop;
    }
    
    public PermShop getPermShop() {
        return permShop;
    }
    
    public ItemShop getItemShop() {
        return itemShop;
    }
}
