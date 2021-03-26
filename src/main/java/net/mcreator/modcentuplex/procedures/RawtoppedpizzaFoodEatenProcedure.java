package net.mcreator.modcentuplex.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.modcentuplex.ModCentuplexModElements;

import java.util.Map;

@ModCentuplexModElements.ModElement.Tag
public class RawtoppedpizzaFoodEatenProcedure extends ModCentuplexModElements.ModElement {
	public RawtoppedpizzaFoodEatenProcedure(ModCentuplexModElements instance) {
		super(instance, 37);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure RawtoppedpizzaFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HUNGER, (int) 300, (int) 1));
	}
}
