package com.mongodb.connection;

import com.mongodb.assertions.Assertions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/connection/ServerVersion.class */
public class ServerVersion implements Comparable<ServerVersion> {
    private final List<Integer> versionList;

    public ServerVersion() {
        this.versionList = Collections.unmodifiableList(Arrays.asList(0, 0, 0));
    }

    public ServerVersion(List<Integer> versionList) {
        Assertions.notNull("versionList", versionList);
        Assertions.isTrue("version array has three elements", versionList.size() == 3);
        this.versionList = Collections.unmodifiableList(new ArrayList(versionList));
    }

    public ServerVersion(int majorVersion, int minorVersion) {
        this(Arrays.asList(Integer.valueOf(majorVersion), Integer.valueOf(minorVersion), 0));
    }

    public List<Integer> getVersionList() {
        return this.versionList;
    }

    public int compareTo(ServerVersion o) {
        int retVal = 0;
        for (int i = 0; i < this.versionList.size(); i++) {
            retVal = this.versionList.get(i).compareTo(o.versionList.get(i));
            if (retVal != 0) {
                break;
            }
        }
        return retVal;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !this.versionList.equals(((ServerVersion) o).versionList)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.versionList.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return "ServerVersion{versionList=" + this.versionList + '}';
    }
}
