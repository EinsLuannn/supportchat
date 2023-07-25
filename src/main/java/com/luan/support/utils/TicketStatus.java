package com.luan.support.utils;

import sun.security.krb5.internal.Ticket;

public enum TicketStatus {

    OPEN("geöffnet"),
    IN_PROGRESS("in Bearbeitung"),
    CLOSED("geschlossen"),
    DELETED("gelöscht");

    private final String status;

    public String getStatus() {
        return status;
    }

    TicketStatus(final  String status) {
        this.status = status;
    }
}
