package me.lucaslah.wremover.mixin;

import me.lucaslah.wremover.WeatherRemover;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;

import java.util.function.Supplier;

@Mixin(ClientWorld.class)
public abstract class WorldMixin extends World {
    private final WeatherRemover mod = WeatherRemover.getInstance();

    protected WorldMixin(MutableWorldProperties properties, RegistryKey<World> registryRef, DimensionType dimensionType, Supplier<Profiler> profiler, boolean isClient, boolean debugWorld, long seed) {
        super(properties, registryRef, dimensionType, profiler, isClient, debugWorld, seed);
    }

    @Override
    public float getRainGradient(float delta) {
        if (mod.isRemoveWeatherEnabled()) {
            return 0;
        } else {
            return super.getRainGradient(delta);
        }
    }

    @Override
    public float getThunderGradient(float delta) {
        if (mod.isRemoveWeatherEnabled()) {
            return 0;
        } else {
            return super.getThunderGradient(delta);
        }
    }

    @Override
    public boolean isRaining() {
        // Not needed, added for later use
        return super.isRaining();
    }

    public boolean isThundering() {
        // Not needed added for later use
        return super.isThundering();
    }
}
