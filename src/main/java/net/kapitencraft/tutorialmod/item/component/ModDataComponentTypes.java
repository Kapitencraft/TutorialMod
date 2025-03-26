package net.kapitencraft.tutorialmod.item.component;

import net.kapitencraft.tutorialmod.Tutorialmod;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public interface ModDataComponentTypes {
    DeferredRegister.DataComponents REGISTRY = DeferredRegister.DataComponents.createDataComponents(Registries.DATA_COMPONENT_TYPE, Tutorialmod.MOD_ID);

    DeferredHolder<DataComponentType<?>, DataComponentType<Backpack>> BACKPACK = REGISTRY.registerComponentType("backpack", builder -> builder.persistent(Backpack.CODEC));
}
