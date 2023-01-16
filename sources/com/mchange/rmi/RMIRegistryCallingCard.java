package com.mchange.rmi;

import com.mchange.p005io.UnsupportedVersionException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/* loaded from: grasscutter.jar:com/mchange/rmi/RMIRegistryCallingCard.class */
public class RMIRegistryCallingCard implements CallingCard, Serializable {
    transient Remote cached;
    transient String url;
    static final long serialVersionUID = 1;
    private static final short VERSION = 1;

    public RMIRegistryCallingCard(String str, int i, String str2) {
        this.cached = null;
        this.url = "//" + str.toLowerCase() + ':' + i + '/' + str2;
    }

    public RMIRegistryCallingCard(String str, String str2) {
        this(str, 1099, str2);
    }

    @Override // com.mchange.rmi.CallingCard, java.lang.Object
    public boolean equals(Object obj) {
        return (obj instanceof RMIRegistryCallingCard) && this.url.equals(((RMIRegistryCallingCard) obj).url);
    }

    @Override // com.mchange.rmi.CallingCard, java.lang.Object
    public int hashCode() {
        return this.url.hashCode();
    }

    @Override // com.mchange.rmi.CallingCard
    public Remote findRemote() throws ServiceUnavailableException, RemoteException {
        if (this.cached instanceof Checkable) {
            try {
                this.cached.check();
                return this.cached;
            } catch (RemoteException e) {
                this.cached = null;
                return findRemote();
            }
        } else {
            try {
                Remote lookup = Naming.lookup(this.url);
                if (lookup instanceof Checkable) {
                    this.cached = lookup;
                }
                return lookup;
            } catch (MalformedURLException e2) {
                throw new ServiceUnavailableException("Uh oh. Bad url. It never will be available: " + this.url);
            } catch (NotBoundException e3) {
                throw new ServiceUnavailableException("Object Not Bound: " + this.url);
            }
        }
    }

    @Override // com.mchange.rmi.CallingCard, java.lang.Object
    public String toString() {
        return toString() + " [" + this.url + "];";
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeShort(1);
        objectOutputStream.writeUTF(this.url);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        short readShort = objectInputStream.readShort();
        switch (readShort) {
            case 1:
                this.url = objectInputStream.readUTF();
                return;
            default:
                throw new UnsupportedVersionException(getClass().getName() + "; Bad version: " + ((int) readShort));
        }
    }
}
