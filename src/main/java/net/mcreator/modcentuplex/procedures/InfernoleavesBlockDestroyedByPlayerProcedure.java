package net.mcreator.modcentuplex.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.modcentuplex.block.InfernosapingBlock;
import net.mcreator.modcentuplex.block.InfernoleavesBlock;
import net.mcreator.modcentuplex.ModCentuplexModElements;

import java.util.Map;

@ModCentuplexModElements.ModElement.Tag
public class InfernoleavesBlockDestroyedByPlayerProcedure extends ModCentuplexModElements.ModElement {
	public InfernoleavesBlockDestroyedByPlayerProcedure(ModCentuplexModElements instance) {
		super(instance, 51);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure InfernoleavesBlockDestroyedByPlayer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double chance = 0;
		if ((((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemMainhand() : ItemStack.EMPTY)
				.getItem() == new ItemStack(Items.SHEARS, (int) (1)).getItem())) {
			if (entity instanceof PlayerEntity) {
				ItemStack _setstack = new ItemStack(InfernoleavesBlock.block, (int) (1));
				_setstack.setCount((int) 1);
				ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
			}
		} else {
			chance = (double) (Math.random() * 19);
			if (((chance) == 0)) {
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = new ItemStack(InfernosapingBlock.block, (int) (1));
					_setstack.setCount((int) 1);
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
			}
		}
	}
}
