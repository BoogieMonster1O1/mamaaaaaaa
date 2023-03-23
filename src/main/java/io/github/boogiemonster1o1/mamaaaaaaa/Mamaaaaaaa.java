package io.github.boogiemonster1o1.mamaaaaaaa;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class Mamaaaaaaa implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("mamaaaaaaa");

	public static final SoundEvent ENTITY_HURT = SoundEvent.of(new Identifier("mamaaaaaaa", "entity.hurt"));
	public static final SoundEvent ENTITY_ALMOST_DEAD = SoundEvent.of(new Identifier("mamaaaaaaa", "entity.almost_dead"));
	public static final SoundEvent ENTITY_DEATH = SoundEvent.of(new Identifier("mamaaaaaaa", "entity.death"));

	@Override
	public void onInitialize() {
		LOGGER.info("Beelzebub has the devil put aside for me, for me, for me!");
		Registry.register(Registries.SOUND_EVENT, ENTITY_HURT.getId(), ENTITY_HURT);
		Registry.register(Registries.SOUND_EVENT, ENTITY_ALMOST_DEAD.getId(), ENTITY_ALMOST_DEAD);
		Registry.register(Registries.SOUND_EVENT, ENTITY_DEATH.getId(), ENTITY_DEATH);
	}
}
