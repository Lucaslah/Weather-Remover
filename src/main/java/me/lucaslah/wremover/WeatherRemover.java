package me.lucaslah.wremover;

import me.lucaslah.wremover.keybindings.KeybindManager;
import me.lucaslah.wremover.keybindings.ToggleKey;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class WeatherRemover implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("wremover");
	public boolean removeWeatherEnabled;
	public static WeatherRemover instance;

	@Override
	public void onInitialize() {
		instance = this;
		setRemoveWeatherEnabled(false);

		KeybindManager keybindManager = new KeybindManager();
		keybindManager.add(new ToggleKey());
	}

	public static WeatherRemover getInstance() {
		return instance;
	}

	public boolean isRemoveWeatherEnabled() {
		return removeWeatherEnabled;
	}

	public void setRemoveWeatherEnabled(boolean removeWeatherEnabled) {
		this.removeWeatherEnabled = removeWeatherEnabled;
	}

	public Logger getLogger() {
		return LOGGER;
	}
}
