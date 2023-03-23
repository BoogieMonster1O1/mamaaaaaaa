package io.github.boogiemonster1o1.mamaaaaaaa.mixin;

import io.github.boogiemonster1o1.mamaaaaaaa.Mamaaaaaaa;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTracker;
import net.minecraft.sound.SoundEvent;
import net.minecraft.world.World;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
	@Shadow public abstract DamageTracker getDamageTracker();

	@Shadow public abstract float getHealth();

	public LivingEntityMixin(EntityType<?> type, World world) {
		super(type, world);
	}

	@Redirect(method = "playHurtSound", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/entity/LivingEntity;getHurtSound(Lnet/minecraft/entity/damage/DamageSource;)Lnet/minecraft/sound/SoundEvent;"))
	public SoundEvent replaceHurtSound(LivingEntity instance, DamageSource source) {
		if (this.getDamageTracker().getMostRecentDamage().getDamage() > this.getHealth()) {
			return Mamaaaaaaa.ENTITY_ALMOST_DEAD;
		}
		return Mamaaaaaaa.ENTITY_HURT;
	}

	@Redirect(method = "handleStatus", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/entity/LivingEntity;getDeathSound()Lnet/minecraft/sound/SoundEvent;"))
	public SoundEvent replaceDeathSound1(LivingEntity instance) {
		return Mamaaaaaaa.ENTITY_DEATH;
	}

	@Redirect(method = "damage", at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/entity/LivingEntity;getDeathSound()Lnet/minecraft/sound/SoundEvent;"))
	public SoundEvent replaceDeathSound2(LivingEntity instance) {
		return Mamaaaaaaa.ENTITY_DEATH;
	}
}
