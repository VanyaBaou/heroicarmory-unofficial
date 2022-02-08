package com.vanyabaou.heroicarmory.integration.ItemType;

import com.oblivioussp.spartanweaponry.api.ToolMaterialEx;
import com.oblivioussp.spartanweaponry.api.weaponproperty.WeaponProperty;
import com.oblivioussp.spartanweaponry.item.ItemDagger;
import com.oblivioussp.spartanweaponry.item.ItemParryingDagger;
import com.oblivioussp.spartanweaponry.util.StringHelper;
import com.vanyabaou.heroicarmory.HeroicArmory;
import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.vanyabaou.heroicarmory.init.HAItemRegistry.tabHeroicArmory;

public class ItemParryingDaggerHW extends ItemParryingDagger {

    protected int enchantability;
    protected int lootRarity;

    public ItemParryingDaggerHW(String unlocName, Object material, HashMap<String,Object> properties, WeaponProperty... weaponProperties) {
        super(unlocName, HeroicArmory.MOD_ID, (ToolMaterialEx)material);
        this.setCreativeTab(tabHeroicArmory);
        this.modId = HeroicArmory.MOD_ID;

        this.displayName = unlocName;

        this.attackDamage = (float)properties.getOrDefault("attack", 9f);
        this.attackSpeed = (double)properties.getOrDefault("speed", 1.6f);
        this.setMaxDamage((int)properties.getOrDefault("durability", 1000));
        this.enchantability = (int)properties.getOrDefault("enchantability", 0);
        this.lootRarity = (int)properties.getOrDefault("rarity",0);

        this.properties = Arrays.asList(weaponProperties);
//        this.properties.addAll(Arrays.asList(weaponProperties));

    }

    @Override
    public Item setCreativeTab(CreativeTabs tab) {
        return super.setCreativeTab(tabHeroicArmory);
    }

    @Override
    public String getCreatorModId(ItemStack itemStack) {
        return HeroicArmory.MOD_ID;
    }

    @Override
    public int getItemEnchantability() {
        return this.enchantability;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {
        if (this.displayName != null) {
            return I18n.format(String.format("item.%s.name", this.displayName), I18n.format(this.materialEx.getFullUnlocName()));
        }
        return super.getItemStackDisplayName(stack);
    }

    @Override
    public String getUnlocalizedName() {
        return StringHelper.getItemUnlocalizedName(super.getUnlocalizedName());
    }

}