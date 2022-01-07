package me.lucaslah.wremover.keybindings;

import java.util.HashMap;

import me.lucaslah.wremover.WeatherRemover;
import org.jetbrains.annotations.NotNull;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil.Type;
import net.minecraft.util.Identifier;

public abstract class Key {
    public final WeatherRemover mod = WeatherRemover.getInstance();

    public KeyBinding keybind;

    public Key(@NotNull String name) {
        keybind = KeyBindingHelper.registerKeyBinding(new KeyBinding(this.getDisplayName(), this.getKeyType(), this.getKey(), this.getCategory()));
    }

    public abstract void onPress(@NotNull MinecraftClient client);
    public abstract Identifier getId();

    public abstract KeyBinding getKeyBinding();

    public abstract boolean isEnabled();
    public abstract String getDisplayName();
    public abstract Type getKeyType();
    public abstract String getCategory();
    public abstract int getKey();
}
