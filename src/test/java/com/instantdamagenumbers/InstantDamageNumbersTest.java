package com.instantdamagenumbers;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class InstantDamageNumbersTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(InstantDamageNumbersPlugin.class);
		RuneLite.main(args);
	}
}