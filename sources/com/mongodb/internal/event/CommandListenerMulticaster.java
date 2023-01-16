package com.mongodb.internal.event;

import com.mongodb.assertions.Assertions;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.event.CommandFailedEvent;
import com.mongodb.event.CommandListener;
import com.mongodb.event.CommandStartedEvent;
import com.mongodb.event.CommandSucceededEvent;
import java.util.ArrayList;
import java.util.List;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/event/CommandListenerMulticaster.class */
public final class CommandListenerMulticaster implements CommandListener {
    private static final Logger LOGGER = Loggers.getLogger("protocol.event");
    private final List<CommandListener> commandListeners;

    /* access modifiers changed from: package-private */
    public CommandListenerMulticaster(List<CommandListener> commandListeners) {
        Assertions.isTrue("All CommandListener instances are non-null", !commandListeners.contains(null));
        this.commandListeners = new ArrayList(commandListeners);
    }

    @Override // com.mongodb.event.CommandListener
    public void commandStarted(CommandStartedEvent event) {
        for (CommandListener cur : this.commandListeners) {
            try {
                cur.commandStarted(event);
            } catch (Exception e) {
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn(String.format("Exception thrown raising command started event to listener %s", cur), e);
                }
            }
        }
    }

    @Override // com.mongodb.event.CommandListener
    public void commandSucceeded(CommandSucceededEvent event) {
        for (CommandListener cur : this.commandListeners) {
            try {
                cur.commandSucceeded(event);
            } catch (Exception e) {
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn(String.format("Exception thrown raising command succeeded event to listener %s", cur), e);
                }
            }
        }
    }

    @Override // com.mongodb.event.CommandListener
    public void commandFailed(CommandFailedEvent event) {
        for (CommandListener cur : this.commandListeners) {
            try {
                cur.commandFailed(event);
            } catch (Exception e) {
                if (LOGGER.isWarnEnabled()) {
                    LOGGER.warn(String.format("Exception thrown raising command failed event to listener %s", cur), e);
                }
            }
        }
    }
}
