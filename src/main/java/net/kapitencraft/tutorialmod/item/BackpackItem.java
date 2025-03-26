package net.kapitencraft.tutorialmod.item;

import net.kapitencraft.tutorialmod.item.component.Backpack;
import net.kapitencraft.tutorialmod.item.component.ModDataComponentTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class BackpackItem extends Item {
    public BackpackItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player p, InteractionHand hand) {
        ItemStack stack = p.getItemInHand(hand);
        if (!level.isClientSide()) {
            Backpack backpack = stack.get(ModDataComponentTypes.BACKPACK.get());
            if (backpack == null) {
                backpack = new Backpack();
                stack.set(ModDataComponentTypes.BACKPACK.get(), backpack);
            }
            final Backpack fBackpack = backpack;
            MenuProvider provider  = new SimpleMenuProvider(
                    (i, inventory, player) ->
                            ChestMenu.threeRows(i, inventory, fBackpack),
                    stack.getHoverName()
            );
            p.openMenu(provider);
        }
        return super.use(level, p, hand);
    }
}
