package com.luan.support.listeners;

import com.luan.support.database.TicketManager;
import com.luan.support.utils.TicketStatus;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerQuitListener implements Listener {

    private final TicketManager ticketManager;

    public PlayerQuitListener() {
        ticketManager = new TicketManager();
    }

    @EventHandler
    public void handleQuit(final PlayerDisconnectEvent event) {
        if(ticketManager.isTicketOpen(event.getPlayer().getUniqueId())) {
            ticketManager.updateStatus(ticketManager.getTicketID(event.getPlayer().getUniqueId(), TicketStatus.OPEN), TicketStatus.CLOSED);
            ticketManager.updateClosedDate(ticketManager.getTicketID(event.getPlayer().getUniqueId(), TicketStatus.OPEN));
        }
    }
}
