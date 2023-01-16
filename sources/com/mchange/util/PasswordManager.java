package com.mchange.util;

import java.io.IOException;

/* loaded from: grasscutter.jar:com/mchange/util/PasswordManager.class */
public interface PasswordManager {
    boolean validate(String str, String str2) throws IOException;

    boolean updatePassword(String str, String str2, String str3) throws IOException;
}
