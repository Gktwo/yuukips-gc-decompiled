package com.mongodb.management;

import com.mongodb.connection.ConnectionId;
import com.mongodb.connection.ServerId;
import com.mongodb.event.ConnectionCheckedInEvent;
import com.mongodb.event.ConnectionCheckedOutEvent;
import com.mongodb.event.ConnectionClosedEvent;
import com.mongodb.event.ConnectionCreatedEvent;
import com.mongodb.event.ConnectionPoolClosedEvent;
import com.mongodb.event.ConnectionPoolCreatedEvent;
import com.mongodb.event.ConnectionPoolListener;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.management.ObjectName;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:com/mongodb/management/JMXConnectionPoolListener.class */
public class JMXConnectionPoolListener implements ConnectionPoolListener {
    private final ConcurrentMap<ServerId, ConnectionPoolStatistics> map = new ConcurrentHashMap();

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionPoolCreated(ConnectionPoolCreatedEvent event) {
        ConnectionPoolStatistics statistics = new ConnectionPoolStatistics(event);
        this.map.put(event.getServerId(), statistics);
        MBeanServerFactory.getMBeanServer().registerMBean(statistics, getMBeanObjectName(event.getServerId()));
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionPoolClosed(ConnectionPoolClosedEvent event) {
        this.map.remove(event.getServerId());
        MBeanServerFactory.getMBeanServer().unregisterMBean(getMBeanObjectName(event.getServerId()));
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionCheckedOut(ConnectionCheckedOutEvent event) {
        ConnectionPoolStatistics statistics = getStatistics(event.getConnectionId());
        if (statistics != null) {
            statistics.connectionCheckedOut(event);
        }
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionCheckedIn(ConnectionCheckedInEvent event) {
        ConnectionPoolStatistics statistics = getStatistics(event.getConnectionId());
        if (statistics != null) {
            statistics.connectionCheckedIn(event);
        }
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionCreated(ConnectionCreatedEvent event) {
        ConnectionPoolStatistics statistics = getStatistics(event.getConnectionId());
        if (statistics != null) {
            statistics.connectionCreated(event);
        }
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionClosed(ConnectionClosedEvent event) {
        ConnectionPoolStatistics statistics = getStatistics(event.getConnectionId());
        if (statistics != null) {
            statistics.connectionClosed(event);
        }
    }

    String getMBeanObjectName(ServerId serverId) {
        String name = String.format("org.mongodb.driver:type=ConnectionPool,clusterId=%s,host=%s,port=%s", ensureValidValue(serverId.getClusterId().getValue()), ensureValidValue(serverId.getAddress().getHost()), Integer.valueOf(serverId.getAddress().getPort()));
        if (serverId.getClusterId().getDescription() != null) {
            name = String.format("%s,description=%s", name, ensureValidValue(serverId.getClusterId().getDescription()));
        }
        return name;
    }

    ConnectionPoolStatisticsMBean getMBean(ServerId serverId) {
        return getStatistics(serverId);
    }

    private ConnectionPoolStatistics getStatistics(ConnectionId connectionId) {
        return getStatistics(connectionId.getServerId());
    }

    private ConnectionPoolStatistics getStatistics(ServerId serverId) {
        return this.map.get(serverId);
    }

    private String ensureValidValue(String value) {
        if (containsQuotableCharacter(value)) {
            return ObjectName.quote(value);
        }
        return value;
    }

    private boolean containsQuotableCharacter(String value) {
        if (value == null || value.length() == 0) {
            return false;
        }
        for (String quotable : Arrays.asList(",", EmitterKt.COMMENT_PREFIX, "?", "*", "=", "\"", "\\", "\n")) {
            if (value.contains(quotable)) {
                return true;
            }
        }
        return false;
    }
}
