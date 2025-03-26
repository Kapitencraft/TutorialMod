package net.kapitencraft.tutorialmod.item;

import net.kapitencraft.tutorialmod.Tutorialmod;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public interface ModItems {
    DeferredRegister.Items REGISTRY = DeferredRegister.Items.createItems(Tutorialmod.MOD_ID);

    DeferredItem<BackpackItem> BACKPACK = REGISTRY.registerItem("backpack", BackpackItem::new);
}
