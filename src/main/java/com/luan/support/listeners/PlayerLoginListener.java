package com.luan.support.listeners;

import com.luan.support.SupportChat;
import com.luan.support.database.SupporterManager;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.event.EventPriority;

import java.util.UUID;

public class PlayerLoginListener implements Listener {

    private final SupporterManager supporterManager = new SupporterManager();

    @EventHandler(priority = EventPriority.LOWEST)
    public void handleLogin(PostLoginEvent event) {
        final ProxiedPlayer player = event.getPlayer();
        if(player.hasPermission("supportchat.supporter"))  {
            if(!(supporterManager.isSupporter(UUID.fromString(player.getUniqueId().toString())))) {
                supporterManager.insertSupporter(UUID.fromString(player.getUniqueId().toString()), 0, true);
            }
            final boolean loggedIn = supporterManager.isLoggedIn(UUID.fromString(player.getUniqueId().toString()));
            player.sendMessage(TextComponent.fromLegacyText(SupportChat.getInstance().getPrefix() + "§7Status§8: " + (loggedIn ? "§aeingeloggt" : "§causgeloggt")));
        }
    }
}
