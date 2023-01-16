package com.mongodb.internal.connection;

import com.mongodb.ServerAddress;
import com.mongodb.TagSet;
import com.mongodb.connection.ClusterDescription;
import com.mongodb.connection.ServerDescription;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ClusterDescriptionHelper.class */
public final class ClusterDescriptionHelper {

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/ClusterDescriptionHelper$Predicate.class */
    public interface Predicate {
        boolean apply(ServerDescription serverDescription);
    }

    public static Set<ServerDescription> getAll(ClusterDescription clusterDescription) {
        Set<ServerDescription> serverDescriptionSet = new TreeSet<>(o1, o2 -> {
            int val = o1.getAddress().getHost().compareTo(o2.getAddress().getHost());
            if (val != 0) {
                return val;
            }
            return Integer.compare(o1.getAddress().getPort(), o2.getAddress().getPort());
        });
        serverDescriptionSet.addAll(clusterDescription.getServerDescriptions());
        return Collections.unmodifiableSet(serverDescriptionSet);
    }

    public static ServerDescription getByServerAddress(ClusterDescription clusterDescription, ServerAddress serverAddress) {
        for (ServerDescription cur : clusterDescription.getServerDescriptions()) {
            if (cur.isOk() && cur.getAddress().equals(serverAddress)) {
                return cur;
            }
        }
        return null;
    }

    public static List<ServerDescription> getPrimaries(ClusterDescription clusterDescription) {
        return getServersByPredicate(clusterDescription, (v0) -> {
            return v0.isPrimary();
        });
    }

    public static List<ServerDescription> getSecondaries(ClusterDescription clusterDescription) {
        return getServersByPredicate(clusterDescription, (v0) -> {
            return v0.isSecondary();
        });
    }

    public static List<ServerDescription> getSecondaries(ClusterDescription clusterDescription, TagSet tagSet) {
        return getServersByPredicate(clusterDescription, serverDescription -> {
            return serverDescription.isSecondary() && serverDescription.hasTags(tagSet);
        });
    }

    public static List<ServerDescription> getAny(ClusterDescription clusterDescription) {
        return getServersByPredicate(clusterDescription, (v0) -> {
            return v0.isOk();
        });
    }

    public static List<ServerDescription> getAnyPrimaryOrSecondary(ClusterDescription clusterDescription) {
        return getServersByPredicate(clusterDescription, serverDescription -> {
            return serverDescription.isPrimary() || serverDescription.isSecondary();
        });
    }

    public static List<ServerDescription> getAnyPrimaryOrSecondary(ClusterDescription clusterDescription, TagSet tagSet) {
        return getServersByPredicate(clusterDescription, serverDescription -> {
            return (serverDescription.isPrimary() || serverDescription.isSecondary()) && serverDescription.hasTags(tagSet);
        });
    }

    public static List<ServerDescription> getServersByPredicate(ClusterDescription clusterDescription, Predicate predicate) {
        List<ServerDescription> membersByTag = new ArrayList<>();
        for (ServerDescription cur : clusterDescription.getServerDescriptions()) {
            if (predicate.apply(cur)) {
                membersByTag.add(cur);
            }
        }
        return membersByTag;
    }

    private ClusterDescriptionHelper() {
    }
}
