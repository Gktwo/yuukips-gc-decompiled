package com.mongodb;

import com.mongodb.annotations.NotThreadSafe;
import com.mongodb.assertions.Assertions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/MongoDriverInformation.class */
public final class MongoDriverInformation {
    private final List<String> driverNames;
    private final List<String> driverVersions;
    private final List<String> driverPlatforms;

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(MongoDriverInformation mongoDriverInformation) {
        return new Builder();
    }

    public List<String> getDriverNames() {
        return this.driverNames;
    }

    public List<String> getDriverVersions() {
        return this.driverVersions;
    }

    public List<String> getDriverPlatforms() {
        return this.driverPlatforms;
    }

    @NotThreadSafe
    /* loaded from: grasscutter.jar:com/mongodb/MongoDriverInformation$Builder.class */
    public static final class Builder {
        private final MongoDriverInformation driverInformation;
        private String driverName;
        private String driverVersion;
        private String driverPlatform;

        public Builder driverName(String driverName) {
            this.driverName = (String) Assertions.notNull("driverName", driverName);
            return this;
        }

        public Builder driverVersion(String driverVersion) {
            this.driverVersion = (String) Assertions.notNull("driverVersion", driverVersion);
            return this;
        }

        public Builder driverPlatform(String driverPlatform) {
            this.driverPlatform = (String) Assertions.notNull("driverPlatform", driverPlatform);
            return this;
        }

        public MongoDriverInformation build() {
            Assertions.isTrue("You must also set the driver name when setting the driver version", this.driverName != null || this.driverVersion == null);
            return new MongoDriverInformation(prependToList(this.driverInformation.getDriverNames(), this.driverName), prependToList(this.driverInformation.getDriverVersions(), this.driverVersion), prependToList(this.driverInformation.getDriverPlatforms(), this.driverPlatform));
        }

        private List<String> prependToList(List<String> stringList, String value) {
            if (value == null) {
                return stringList;
            }
            ArrayList<String> newList = new ArrayList<>();
            newList.add(value);
            newList.addAll(stringList);
            return Collections.unmodifiableList(newList);
        }

        private Builder() {
            List<String> immutableEmptyList = Collections.unmodifiableList(Collections.emptyList());
            this.driverInformation = new MongoDriverInformation(immutableEmptyList, immutableEmptyList, immutableEmptyList);
        }

        private Builder(MongoDriverInformation driverInformation) {
            this.driverInformation = (MongoDriverInformation) Assertions.notNull("driverInformation", driverInformation);
        }
    }

    private MongoDriverInformation(List<String> driverNames, List<String> driverVersions, List<String> driverPlatforms) {
        this.driverNames = driverNames;
        this.driverVersions = driverVersions;
        this.driverPlatforms = driverPlatforms;
    }
}
