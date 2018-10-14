package de.schwangpierre.minecraftparty.utility;

import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import static de.schwangpierre.minecraftparty.utility.ReflectionAPI.getNMSClass;

public class TitleAPI {

    public static void sendTitle(Player player, String title, String subtitle, int fadeInTime, int showTime, int fadeOutTime) {
        try {
            Object chatTitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\": \"" + title + "\"}");
            Constructor<?> titleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), int.class, int.class, int.class);
            Object titlePacket = titleConstructor.newInstance(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null), chatTitle, fadeInTime, showTime, fadeOutTime);

            Object chatsTitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\": \"" + subtitle + "\"}");
            Constructor<?> stitleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"), int.class, int.class, int.class);
            Object subtitlePacket = stitleConstructor.newInstance(getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null), chatsTitle, fadeInTime, showTime, fadeOutTime);

            ReflectionAPI.sendPacket(player, titlePacket);
            ReflectionAPI.sendPacket(player, subtitlePacket);
        } catch (NoSuchMethodException | ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    public static void sendTitle(Player player, String title, String subtitle) {
        sendTitle(player, title, subtitle, 20, 20, 20);
    }

    public static void sendTitle(Collection<? extends Player> players, String title, String subtitle, int fadeInTime, int showTime, int fadeOutTime) {
        players.forEach(player -> sendTitle(player, title, subtitle, fadeInTime, showTime, fadeOutTime));
    }

    public static void sendTitle(Collection<? extends Player> players, String title, String subtitle) {
        sendTitle(players, title, subtitle, 20, 20, 20);
    }

}
