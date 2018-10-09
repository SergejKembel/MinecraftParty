package de.schwangpierre.minecraftparty.utility;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.util.Collection;

public class TitleAPI {

    public static void sendTitle(Player player, String title, String subtitle) {
        PacketPlayOutTitle packetPlayOutTitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}"));
        PacketPlayOutTitle packetPlayOutSubtitle = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}"));
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packetPlayOutTitle);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packetPlayOutSubtitle);
    }

    public static void sendTitle(Collection<? extends Player> players, String title, String subtitle) {
        players.forEach(player -> sendTitle(player, title, subtitle));
    }

}
