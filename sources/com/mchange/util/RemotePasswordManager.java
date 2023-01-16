package com.mchange.util;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/* loaded from: grasscutter.jar:com/mchange/util/RemotePasswordManager.class */
public interface RemotePasswordManager extends PasswordManager, Remote {
    @Override // com.mchange.util.PasswordManager
    boolean validate(String str, String str2) throws RemoteException, IOException;

    @Override // com.mchange.util.PasswordManager
    boolean updatePassword(String str, String str2, String str3) throws RemoteException, IOException;
}
