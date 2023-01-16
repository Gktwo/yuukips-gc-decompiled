package com.mongodb.internal.event;

import com.mongodb.assertions.Assertions;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.event.ConnectionAddedEvent;
import com.mongodb.event.ConnectionCheckOutFailedEvent;
import com.mongodb.event.ConnectionCheckOutStartedEvent;
import com.mongodb.event.ConnectionCheckedInEvent;
import com.mongodb.event.ConnectionCheckedOutEvent;
import com.mongodb.event.ConnectionClosedEvent;
import com.mongodb.event.ConnectionCreatedEvent;
import com.mongodb.event.ConnectionPoolClearedEvent;
import com.mongodb.event.ConnectionPoolClosedEvent;
import com.mongodb.event.ConnectionPoolCreatedEvent;
import com.mongodb.event.ConnectionPoolListener;
import com.mongodb.event.ConnectionPoolOpenedEvent;
import com.mongodb.event.ConnectionReadyEvent;
import com.mongodb.event.ConnectionRemovedEvent;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/event/ConnectionPoolListenerMulticaster.class */
public final class ConnectionPoolListenerMulticaster implements ConnectionPoolListener {
    private static final Logger LOGGER = Loggers.getLogger("protocol.event");
    private final List<ConnectionPoolListener> connectionPoolListeners;

    /* access modifiers changed from: package-private */
    public ConnectionPoolListenerMulticaster(List<ConnectionPoolListener> connectionPoolListeners) {
        Assertions.isTrue("All ConnectionPoolListener instances are non-null", !connectionPoolListeners.contains(null));
        this.connectionPoolListeners = new ArrayList(connectionPoolListeners);
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionPoolOpened(ConnectionPoolOpenedEvent event) {
        for (ConnectionPoolListener cur : this.connectionPoolListeners) {
            try {
                cur.connectionPoolOpened(event);
            } catch (Exception e) {
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn(String.format("Exception thrown raising connection pool opened event to listener %s", cur), e);
                }
            }
        }
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionPoolCreated(ConnectionPoolCreatedEvent event) {
        for (ConnectionPoolListener cur : this.connectionPoolListeners) {
            try {
                cur.connectionPoolCreated(event);
            } catch (Exception e) {
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn(String.format("Exception thrown raising connection pool created event to listener %s", cur), e);
                }
            }
        }
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionPoolCleared(ConnectionPoolClearedEvent event) {
        for (ConnectionPoolListener cur : this.connectionPoolListeners) {
            try {
                cur.connectionPoolCleared(event);
            } catch (Exception e) {
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn(String.format("Exception thrown raising connection pool cleared event to listener %s", cur), e);
                }
            }
        }
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionPoolClosed(ConnectionPoolClosedEvent event) {
        for (ConnectionPoolListener cur : this.connectionPoolListeners) {
            try {
                cur.connectionPoolClosed(event);
            } catch (Exception e) {
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn(String.format("Exception thrown raising connection pool closed event to listener %s", cur), e);
                }
            }
        }
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionCheckOutStarted(ConnectionCheckOutStartedEvent event) {
        for (ConnectionPoolListener cur : this.connectionPoolListeners) {
            try {
                cur.connectionCheckOutStarted(event);
            } catch (Exception e) {
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn(String.format("Exception thrown raising connection check out started event to listener %s", cur), e);
                }
            }
        }
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionCheckedOut(ConnectionCheckedOutEvent event) {
        for (ConnectionPoolListener cur : this.connectionPoolListeners) {
            try {
                cur.connectionCheckedOut(event);
            } catch (Exception e) {
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn(String.format("Exception thrown raising connection pool checked out event to listener %s", cur), e);
                }
            }
        }
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionCheckOutFailed(ConnectionCheckOutFailedEvent event) {
        for (ConnectionPoolListener cur : this.connectionPoolListeners) {
            try {
                cur.connectionCheckOutFailed(event);
            } catch (Exception e) {
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn(String.format("Exception thrown raising connection pool check out failed event to listener %s", cur), e);
                }
            }
        }
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionCheckedIn(ConnectionCheckedInEvent event) {
        for (ConnectionPoolListener cur : this.connectionPoolListeners) {
            try {
                cur.connectionCheckedIn(event);
            } catch (Exception e) {
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn(String.format("Exception thrown raising connection pool checked in event to listener %s", cur), e);
                }
            }
        }
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionRemoved(ConnectionRemovedEvent event) {
        for (ConnectionPoolListener cur : this.connectionPoolListeners) {
            try {
                cur.connectionRemoved(event);
            } catch (Exception e) {
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn(String.format("Exception thrown raising connection pool connection removed event to listener %s", cur), e);
                }
            }
        }
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionAdded(ConnectionAddedEvent event) {
        for (ConnectionPoolListener cur : this.connectionPoolListeners) {
            try {
                cur.connectionAdded(event);
            } catch (Exception e) {
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn(String.format("Exception thrown raising connection pool connection added event to listener %s", cur), e);
                }
            }
        }
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionCreated(ConnectionCreatedEvent event) {
        for (ConnectionPoolListener cur : this.connectionPoolListeners) {
            try {
                cur.connectionCreated(event);
            } catch (Exception e) {
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn(String.format("Exception thrown raising connection pool connection created event to listener %s", cur), e);
                }
            }
        }
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionReady(ConnectionReadyEvent event) {
        for (ConnectionPoolListener cur : this.connectionPoolListeners) {
            try {
                cur.connectionReady(event);
            } catch (Exception e) {
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn(String.format("Exception thrown raising connection pool connection ready event to listener %s", cur), e);
                }
            }
        }
    }

    @Override // com.mongodb.event.ConnectionPoolListener
    public void connectionClosed(ConnectionClosedEvent event) {
        for (ConnectionPoolListener cur : this.connectionPoolListeners) {
            try {
                cur.connectionClosed(event);
            } catch (Exception e) {
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn(String.format("Exception thrown raising connection pool connection removed event to listener %s", cur), e);
                }
            }
        }
    }
}
