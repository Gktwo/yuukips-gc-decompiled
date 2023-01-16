package com.mchange.util.impl;

import com.mchange.util.PasswordManager;
import java.io.File;
import java.io.IOException;

/* loaded from: grasscutter.jar:com/mchange/util/impl/PlaintextPropertiesPasswordManager.class */
public class PlaintextPropertiesPasswordManager implements PasswordManager {
    private static final String PASSWORD_PROP_PFX = "password.";
    private static final String HEADER = "com.mchange.util.impl.PlaintextPropertiesPasswordManager data";
    SyncedProperties props;

    public PlaintextPropertiesPasswordManager(File file) throws IOException {
        this.props = new SyncedProperties(file, HEADER);
    }

    @Override // com.mchange.util.PasswordManager
    public boolean validate(String str, String str2) throws IOException {
        return str2.equals(this.props.getProperty(PASSWORD_PROP_PFX + str));
    }

    @Override // com.mchange.util.PasswordManager
    public boolean updatePassword(String str, String str2, String str3) throws IOException {
        if (!validate(str, str2)) {
            return false;
        }
        this.props.put(PASSWORD_PROP_PFX + str, str3);
        return true;
    }
}
