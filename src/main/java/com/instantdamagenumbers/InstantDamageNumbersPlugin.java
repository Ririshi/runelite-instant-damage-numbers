package com.instantdamagenumbers;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.events.StatChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Instant Damage Numbers"
)
public class InstantDamageNumbersPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private InstantDamageNumbersConfig config;

	@Override
	protected void startUp() throws Exception
	{
		log.info("InstantDamageNumbers started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.info("InstantDamageNumbers stopped!");
	}

	@Subscribe
	public void onStatChanged(StatChanged statChanged)
	{
		if (statChanged.getSkill() == Skill.HITPOINTS)
		{
			long hit = Math.round(statChanged.getXp() / 13.3);
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "You will hit " + hit, null);
		}
	}

	@Provides
	InstantDamageNumbersConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(InstantDamageNumbersConfig.class);
	}
}
