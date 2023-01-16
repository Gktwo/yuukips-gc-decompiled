package com.mongodb.internal.connection;

import com.mongodb.connection.ClusterDescription;
import com.mongodb.connection.ServerDescription;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/EventHelper.class */
final class EventHelper {
    /* access modifiers changed from: package-private */
    public static boolean wouldDescriptionsGenerateEquivalentEvents(ClusterDescription current, ClusterDescription previous) {
        if (!(exceptionsEquals(current.getSrvResolutionException(), previous.getSrvResolutionException()) && current.getServerDescriptions().size() == previous.getServerDescriptions().size())) {
            return false;
        }
        for (ServerDescription curNew : current.getServerDescriptions()) {
            ServerDescription matchingPrev = null;
            Iterator<ServerDescription> it = previous.getServerDescriptions().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ServerDescription curPrev = it.next();
                if (curNew.getAddress().equals(curPrev.getAddress())) {
                    matchingPrev = curPrev;
                    break;
                }
            }
            if (!wouldDescriptionsGenerateEquivalentEvents(curNew, matchingPrev)) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public static boolean wouldDescriptionsGenerateEquivalentEvents(ServerDescription current, ServerDescription previous) {
        if (current == previous) {
            return true;
        }
        if (previous == null || current == null || current.isOk() != previous.isOk() || current.getState() != previous.getState() || current.getType() != previous.getType() || current.getMinWireVersion() != previous.getMinWireVersion() || current.getMaxWireVersion() != previous.getMaxWireVersion() || !Objects.equals(current.getCanonicalAddress(), previous.getCanonicalAddress()) || !current.getHosts().equals(previous.getHosts()) || !current.getPassives().equals(previous.getPassives()) || !current.getArbiters().equals(previous.getArbiters()) || !current.getTagSet().equals(previous.getTagSet()) || !Objects.equals(current.getSetName(), previous.getSetName()) || !Objects.equals(current.getSetVersion(), previous.getSetVersion()) || !Objects.equals(current.getElectionId(), previous.getElectionId()) || !Objects.equals(current.getPrimary(), previous.getPrimary()) || !Objects.equals(current.getLogicalSessionTimeoutMinutes(), previous.getLogicalSessionTimeoutMinutes()) || !Objects.equals(current.getTopologyVersion(), previous.getTopologyVersion()) || !exceptionsEquals(current.getException(), previous.getException())) {
            return false;
        }
        return true;
    }

    private static boolean exceptionsEquals(Throwable current, Throwable previous) {
        if (current == null || previous == null) {
            return current == previous;
        }
        if (Objects.equals(current.getClass(), previous.getClass()) && Objects.equals(current.getMessage(), previous.getMessage())) {
            return true;
        }
        return false;
    }

    private EventHelper() {
    }
}
