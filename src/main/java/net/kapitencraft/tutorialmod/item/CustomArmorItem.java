package net.kapitencraft.tutorialmod.item;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.function.BiFunction;

public class CustomArmorItem extends ArmorItem {
    private static final ArmorItem.Type[] ARMOR = new Type[]{Type.BOOTS, Type.LEGGINGS, Type.CHESTPLATE, Type.HELMET};

    public CustomArmorItem(Holder<ArmorMaterial> p_323783_, Type p_266831_, Properties p_40388_) {
        super(p_323783_, p_266831_, p_40388_);
    }

    public static <T extends CustomArmorItem> EnumMap<Type, DeferredItem<T>> createRegistry(DeferredRegister.Items registry, String registryKey, BiFunction<Type, Item.Properties, T> constructor) {
        EnumMap<Type, DeferredItem<T>> map = new EnumMap<>(Type.class);
        for (Type slot : ARMOR) {
            map.put(slot, registry.registerItem(registryKey + "_" + slot.getName(), properties -> constructor.apply(slot, properties)));
        }
        return map;
    }
}
