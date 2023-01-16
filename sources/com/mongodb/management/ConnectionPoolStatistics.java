package com.mongodb.management;

import com.mongodb.ServerAddress;
import com.mongodb.connection.ConnectionPoolSettings;
import com.mongodb.event.ConnectionCheckedInEvent;
import com.mongodb.event.ConnectionCheckedOutEvent;
import com.mongodb.event.ConnectionClosedEvent;
import com.mongodb.event.ConnectionCreatedEvent;
import com.mongodb.event.ConnectionPoolCreatedEvent;
import com.mongodb.event.ConnectionPoolListener;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: grasscutter.jar:com/mongodb/management/ConnectionPoolStatistics.class */
final class ConnectionPoolStatistics implements ConnectionPoolListener, ConnectionPoolStatisticsMBean {
    private final ServerAddress serverAddress;
    private final ConnectionPoolSettings settings;
    private final AtomicInteger size = new AtomicInteger();
    private final AtomicInteger checkedOutCount = new AtomicInteger();

    /* access modifiers changed from: package-private */
    public ConnectionPoolStatistics(ConnectionPoolCreatedEvent event) {
        this.serverAddress = event.getServerId().getAddress();
        this.settings = event.getSettings();
    }

    @Override // com.mongodb.management.ConnectionPoolStatisticsMBean
    public String getHost() {
        return this.serverAddress.getHost();
    }

    @Override // com.mongodb.management.ConnectionPoolStatisticsMBean
    public int getPort() {
        return this.serverAddress.getPort();
    }

    @Override // com.mongodb.management.ConnectionPoolStatisticsMBean
    public int getMinSize() {
        return this.settings.getMinSize();
    }

    @Override // com.mongodb.management.ConnectionPoolStatisticsMBean
    public int getMaxSize() {
        return this.settings.getMaxSize();
    }

    @Override // com.mongodb.management.ConnectionPoolStatisticsMBean
    public int getSize() {
        return this.size.get();
    }

    @Override // com.mongodb.management.ConnectionPoolStatisticsMBean
    public int getCheckedOutCount() {
        return this.checkedOutCount.get();
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionCheckedOut(ConnectionCheckedOutEvent event) {
        this.checkedOutCount.incrementAndGet();
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionCheckedIn(ConnectionCheckedInEvent event) {
        this.checkedOutCount.decrementAndGet();
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionCreated(ConnectionCreatedEvent event) {
        this.size.incrementAndGet();
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionClosed(ConnectionClosedEvent event) {
        this.size.decrementAndGet();
    }
}
