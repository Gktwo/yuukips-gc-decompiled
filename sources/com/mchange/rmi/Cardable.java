package com.mchange.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/* loaded from: grasscutter.jar:com/mchange/rmi/Cardable.class */
public interface Cardable extends Remote {
    CallingCard getCallingCard() throws ServiceUnavailableException, RemoteException;
}
