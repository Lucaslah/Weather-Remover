package me.lucaslah.wremover.keybindings;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

public class ToggleKey extends Key {
    public ToggleKey() {
        super("ToggleKey");
    }

    @Override
    public void onPress(@NotNull MinecraftClient client) {
        if (mod.isRemoveWeatherEnabled()) {
            mod.setRemoveWeatherEnabled(false);
            client.player.sendMessage(new LiteralText("Disabled Weather Remover"), true);
        } else {
            mod.setRemoveWeatherEnabled(true);
            client.player.sendMessage(new LiteralText("Enabled Weather Remover"), true);
        }
    }

    @Override
    public Identifier getId() {
        return new Identifier("keys", "togglekey");
    }

    @Override
    public KeyBinding getKeyBinding() {
        return this.keybind;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getDisplayName() {
        return "Toggle Weather";
    }

    @Override
    public InputUtil.Type getKeyType() {
        return InputUtil.Type.KEYSYM;
    }

    @Override
    public String getCategory() {
        return "Weather Remover";
    }

    @Override
    public int getKey() {
        return -1;
    }
}
