package com.mongodb;

import java.io.Serializable;

/* loaded from: grasscutter.jar:com/mongodb/ServerCursor.class */
public final class ServerCursor implements Serializable {
    private static final long serialVersionUID = -7013636754565190109L;

    /* renamed from: id */
    private final long f433id;
    private final ServerAddress address;

    public ServerCursor(long id, ServerAddress address) {
        if (id == 0) {
            throw new IllegalArgumentException();
        }
        this.f433id = id;
        this.address = address;
    }

    public long getId() {
        return this.f433id;
    }

    public ServerAddress getAddress() {
        return this.address;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ServerCursor that = (ServerCursor) o;
        if (this.f433id == that.f433id && this.address.equals(that.address)) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (31 * ((int) (this.f433id ^ (this.f433id >>> 32)))) + this.address.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return "ServerCursor{getId=" + this.f433id + ", address=" + this.address + '}';
    }
}
