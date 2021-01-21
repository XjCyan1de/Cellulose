package com.github.xjcyan1de.cellulose.mixin.api.server.dedicated;

import com.github.xjcyan1de.cellulose.mixin.api.server.MinecraftServer_API;
import net.minecraft.server.dedicated.MinecraftDedicatedServer;
import org.spongepowered.api.Server;
import org.spongepowered.asm.mixin.*;

import java.net.InetSocketAddress;
import java.util.Optional;

@Mixin(MinecraftDedicatedServer.class)
@Implements(@Interface(iface = Server.class, prefix = "sponge$"))
public abstract class MinecraftDedicatedServer_API extends MinecraftServer_API implements Server {

    @Shadow
    public abstract String getHostname();

    @Override
    public Optional<InetSocketAddress> getBoundAddress() {
        String hostname = getHostname();
        if (hostname == null) {
            return Optional.empty();
        }
        return Optional.of(new InetSocketAddress(hostname, getServerPort()));
    }

    @Intrinsic
    public boolean sponge$isDedicatedServer() {
        return true;
    }
}
