package com.mchange.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/* loaded from: grasscutter.jar:com/mchange/rmi/CallingCard.class */
public interface CallingCard {
    Remote findRemote() throws ServiceUnavailableException, RemoteException;

    @Override // java.lang.Object
    boolean equals(Object obj);

    @Override // java.lang.Object
    int hashCode();

    @Override // java.lang.Object
    String toString();
}
