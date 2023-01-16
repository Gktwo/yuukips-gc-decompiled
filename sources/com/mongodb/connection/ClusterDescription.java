package com.mongodb.connection;

import com.mongodb.MongoException;
import com.mongodb.ReadPreference;
import com.mongodb.annotations.Immutable;
import com.mongodb.assertions.Assertions;
import com.mongodb.internal.connection.ClusterDescriptionHelper;
import com.mongodb.internal.selector.ReadPreferenceServerSelector;
import com.mongodb.internal.selector.WritableServerSelector;
import com.mongodb.lang.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jline.console.Printer;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/connection/ClusterDescription.class */
public class ClusterDescription {
    private final ClusterConnectionMode connectionMode;
    private final ClusterType type;
    private final List<ServerDescription> serverDescriptions;
    private final ClusterSettings clusterSettings;
    private final ServerSettings serverSettings;
    private final MongoException srvResolutionException;

    public ClusterDescription(ClusterConnectionMode connectionMode, ClusterType type, List<ServerDescription> serverDescriptions) {
        this(connectionMode, type, serverDescriptions, null, null);
    }

    public ClusterDescription(ClusterConnectionMode connectionMode, ClusterType type, List<ServerDescription> serverDescriptions, ClusterSettings clusterSettings, ServerSettings serverSettings) {
        this(connectionMode, type, null, serverDescriptions, clusterSettings, serverSettings);
    }

    public ClusterDescription(ClusterConnectionMode connectionMode, ClusterType type, MongoException srvResolutionException, List<ServerDescription> serverDescriptions, ClusterSettings clusterSettings, ServerSettings serverSettings) {
        Assertions.notNull(Printer.ALL, serverDescriptions);
        this.connectionMode = (ClusterConnectionMode) Assertions.notNull("connectionMode", connectionMode);
        this.type = (ClusterType) Assertions.notNull("type", type);
        this.srvResolutionException = srvResolutionException;
        this.serverDescriptions = new ArrayList(serverDescriptions);
        this.clusterSettings = clusterSettings;
        this.serverSettings = serverSettings;
    }

    public ClusterSettings getClusterSettings() {
        return this.clusterSettings;
    }

    public ServerSettings getServerSettings() {
        return this.serverSettings;
    }

    public boolean isCompatibleWithDriver() {
        for (ServerDescription cur : this.serverDescriptions) {
            if (!cur.isCompatibleWithDriver()) {
                return false;
            }
        }
        return true;
    }

    @Nullable
    public ServerDescription findServerIncompatiblyOlderThanDriver() {
        for (ServerDescription cur : this.serverDescriptions) {
            if (cur.isIncompatiblyOlderThanDriver()) {
                return cur;
            }
        }
        return null;
    }

    @Nullable
    public ServerDescription findServerIncompatiblyNewerThanDriver() {
        for (ServerDescription cur : this.serverDescriptions) {
            if (cur.isIncompatiblyNewerThanDriver()) {
                return cur;
            }
        }
        return null;
    }

    public boolean hasReadableServer(ReadPreference readPreference) {
        Assertions.notNull("readPreference", readPreference);
        return !new ReadPreferenceServerSelector(readPreference).select(this).isEmpty();
    }

    public boolean hasWritableServer() {
        return !new WritableServerSelector().select(this).isEmpty();
    }

    public ClusterConnectionMode getConnectionMode() {
        return this.connectionMode;
    }

    public ClusterType getType() {
        return this.type;
    }

    @Nullable
    public MongoException getSrvResolutionException() {
        return this.srvResolutionException;
    }

    public List<ServerDescription> getServerDescriptions() {
        return Collections.unmodifiableList(this.serverDescriptions);
    }

    @Nullable
    public Integer getLogicalSessionTimeoutMinutes() {
        Integer retVal = null;
        for (ServerDescription cur : ClusterDescriptionHelper.getServersByPredicate(this, serverDescription -> {
            return serverDescription.isPrimary() || serverDescription.isSecondary();
        })) {
            Integer logicalSessionTimeoutMinutes = cur.getLogicalSessionTimeoutMinutes();
            if (logicalSessionTimeoutMinutes == null) {
                return null;
            }
            if (retVal == null) {
                retVal = logicalSessionTimeoutMinutes;
            } else {
                retVal = Integer.valueOf(Math.min(retVal.intValue(), logicalSessionTimeoutMinutes.intValue()));
            }
        }
        return retVal;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClusterDescription that = (ClusterDescription) o;
        if (this.connectionMode != that.connectionMode || this.type != that.type || this.serverDescriptions.size() != that.serverDescriptions.size() || !this.serverDescriptions.containsAll(that.serverDescriptions)) {
            return false;
        }
        Class<?> thisExceptionClass = this.srvResolutionException != null ? this.srvResolutionException.getClass() : null;
        Class<?> thatExceptionClass = that.srvResolutionException != null ? that.srvResolutionException.getClass() : null;
        if (thisExceptionClass != null) {
            if (!thisExceptionClass.equals(thatExceptionClass)) {
                return false;
            }
        } else if (thatExceptionClass != null) {
            return false;
        }
        String thisExceptionMessage = this.srvResolutionException != null ? this.srvResolutionException.getMessage() : null;
        String thatExceptionMessage = that.srvResolutionException != null ? that.srvResolutionException.getMessage() : null;
        if (thisExceptionMessage != null) {
            if (!thisExceptionMessage.equals(thatExceptionMessage)) {
                return false;
            }
            return true;
        } else if (thatExceptionMessage != null) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return (31 * ((31 * ((31 * this.connectionMode.hashCode()) + this.type.hashCode())) + (this.srvResolutionException == null ? 0 : this.srvResolutionException.hashCode()))) + this.serverDescriptions.hashCode();
    }

    public String toString() {
        return "ClusterDescription{type=" + getType() + (this.srvResolutionException == null ? "" : ", srvResolutionException=" + this.srvResolutionException) + ", connectionMode=" + this.connectionMode + ", serverDescriptions=" + this.serverDescriptions + '}';
    }

    public String getShortDescription() {
        StringBuilder serverDescriptions = new StringBuilder();
        String delimiter = "";
        for (ServerDescription cur : this.serverDescriptions) {
            serverDescriptions.append(delimiter).append(cur.getShortDescription());
            delimiter = ", ";
        }
        if (this.srvResolutionException == null) {
            return String.format("{type=%s, servers=[%s]", this.type, serverDescriptions);
        }
        return String.format("{type=%s, srvResolutionException=%s, servers=[%s]", this.type, this.srvResolutionException, serverDescriptions);
    }
}
