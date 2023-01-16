package com.mchange.rmi;

import java.rmi.AccessException;
import java.rmi.ConnectException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/* loaded from: grasscutter.jar:com/mchange/rmi/RegistryManager.class */
public class RegistryManager {
    public static Registry ensureRegistry(int i) throws RemoteException {
        Registry findRegistry = findRegistry(i);
        if (findRegistry == null) {
            findRegistry = LocateRegistry.createRegistry(i);
        }
        return findRegistry;
    }

    public static Registry ensureRegistry() throws RemoteException {
        return ensureRegistry(1099);
    }

    public static boolean registryAvailable(int i) throws RemoteException, AccessException {
        try {
            LocateRegistry.getRegistry(i).list();
            return true;
        } catch (ConnectException e) {
            return false;
        }
    }

    public static boolean registryAvailable() throws RemoteException, AccessException {
        return registryAvailable(1099);
    }

    public static Registry findRegistry(int i) throws RemoteException, AccessException {
        if (!registryAvailable(i)) {
            return null;
        }
        return LocateRegistry.getRegistry(i);
    }

    public static Registry findRegistry() throws RemoteException, AccessException {
        return findRegistry(1099);
    }
}
