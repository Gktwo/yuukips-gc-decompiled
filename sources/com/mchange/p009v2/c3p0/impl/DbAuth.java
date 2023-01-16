package com.mchange.p009v2.c3p0.impl;

import com.mchange.p009v2.lang.ObjectUtils;
import com.mchange.p009v2.ser.UnsupportedVersionException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* renamed from: com.mchange.v2.c3p0.impl.DbAuth */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/DbAuth.class */
public final class DbAuth implements Serializable {
    transient String username;
    transient String password;
    static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    public DbAuth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUser() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getMaskedUserString() {
        return getMaskedUserString(2, 8);
    }

    private String getMaskedUserString(int chars_to_reveal, int total_chars) {
        if (this.username == null) {
            return "null";
        }
        StringBuffer sb = new StringBuffer(32);
        if (this.username.length() >= chars_to_reveal) {
            sb.append(this.username.substring(0, chars_to_reveal));
            int len = total_chars - chars_to_reveal;
            for (int i = 0; i < len; i++) {
                sb.append('*');
            }
        } else {
            sb.append(this.username);
        }
        return sb.toString();
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DbAuth other = (DbAuth) o;
        return ObjectUtils.eqOrBothNull(this.username, other.username) && ObjectUtils.eqOrBothNull(this.password, other.password);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ObjectUtils.hashOrZero(this.username) ^ ObjectUtils.hashOrZero(this.password);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeShort(1);
        out.writeObject(this.username);
        out.writeObject(this.password);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        short version = in.readShort();
        switch (version) {
            case 1:
                this.username = (String) in.readObject();
                this.password = (String) in.readObject();
                return;
            default:
                throw new UnsupportedVersionException(this, version);
        }
    }
}
