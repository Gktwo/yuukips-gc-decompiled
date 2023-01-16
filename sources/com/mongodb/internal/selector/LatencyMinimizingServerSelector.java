package com.mongodb.internal.selector;

import com.mongodb.connection.ClusterConnectionMode;
import com.mongodb.connection.ClusterDescription;
import com.mongodb.connection.ServerDescription;
import com.mongodb.internal.connection.ClusterDescriptionHelper;
import com.mongodb.selector.ServerSelector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: grasscutter.jar:com/mongodb/internal/selector/LatencyMinimizingServerSelector.class */
public class LatencyMinimizingServerSelector implements ServerSelector {
    private final long acceptableLatencyDifferenceNanos;

    public LatencyMinimizingServerSelector(long acceptableLatencyDifference, TimeUnit timeUnit) {
        this.acceptableLatencyDifferenceNanos = TimeUnit.NANOSECONDS.convert(acceptableLatencyDifference, timeUnit);
    }

    public long getAcceptableLatencyDifference(TimeUnit timeUnit) {
        return timeUnit.convert(this.acceptableLatencyDifferenceNanos, TimeUnit.NANOSECONDS);
    }

    @Override // com.mongodb.selector.ServerSelector
    public List<ServerDescription> select(ClusterDescription clusterDescription) {
        if (clusterDescription.getConnectionMode() != ClusterConnectionMode.MULTIPLE) {
            return ClusterDescriptionHelper.getAny(clusterDescription);
        }
        return getServersWithAcceptableLatencyDifference(ClusterDescriptionHelper.getAny(clusterDescription), getFastestRoundTripTimeNanos(clusterDescription.getServerDescriptions()));
    }

    public String toString() {
        return "LatencyMinimizingServerSelector{acceptableLatencyDifference=" + TimeUnit.MILLISECONDS.convert(this.acceptableLatencyDifferenceNanos, TimeUnit.NANOSECONDS) + " ms}";
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o != null && getClass() == o.getClass() && this.acceptableLatencyDifferenceNanos == ((LatencyMinimizingServerSelector) o).acceptableLatencyDifferenceNanos;
    }

    public int hashCode() {
        return (int) (this.acceptableLatencyDifferenceNanos ^ (this.acceptableLatencyDifferenceNanos >>> 32));
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [long] */
    private long getFastestRoundTripTimeNanos(List<ServerDescription> members) {
        char c = 65535;
        for (ServerDescription cur : members) {
            if (cur.isOk() && cur.getRoundTripTimeNanos() < c) {
                c = cur.getRoundTripTimeNanos();
            }
        }
        return c;
    }

    private List<ServerDescription> getServersWithAcceptableLatencyDifference(List<ServerDescription> servers, long bestPingTime) {
        List<ServerDescription> goodSecondaries = new ArrayList<>(servers.size());
        for (ServerDescription cur : servers) {
            if (cur.isOk() && cur.getRoundTripTimeNanos() - this.acceptableLatencyDifferenceNanos <= bestPingTime) {
                goodSecondaries.add(cur);
            }
        }
        return goodSecondaries;
    }
}
