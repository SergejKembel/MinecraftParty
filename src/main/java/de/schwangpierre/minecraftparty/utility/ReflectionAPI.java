package de.schwangpierre.minecraftparty.utility;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class ReflectionAPI {

    public static Class<?> getNMSClass(String name) throws ClassNotFoundException {
        return Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + name);
    }

    public static void sendPacket(Player player, Object packet) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Object handle = player.getClass().getMethod("getHandle").invoke(player);
        Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
        playerConnection.getClass().getMethod("sendPacket", getNMSClass("Packet")).invoke(playerConnection, packet);
    }

}
