package com.mchange.util.impl;

import com.mchange.lang.ByteUtils;
import com.mchange.util.PasswordManager;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: grasscutter.jar:com/mchange/util/impl/HexAsciiMD5PropertiesPasswordManager.class */
public class HexAsciiMD5PropertiesPasswordManager implements PasswordManager {
    private static final String DIGEST_ALGORITHM = "MD5";
    private static final String PASSWORD_ENCODING = "8859_1";
    private static final String DEF_PASSWORD_PROP_PFX = "password";
    private static final String DEF_HEADER = "com.mchange.util.impl.HexAsciiMD5PropertiesPasswordManager data";
    private static final boolean DEBUG = true;
    SyncedProperties props;
    String pfx;

    /* renamed from: md */
    MessageDigest f376md;

    public HexAsciiMD5PropertiesPasswordManager(File file, String str, String[] strArr) throws IOException {
        this(new SyncedProperties(file, strArr), str);
    }

    public HexAsciiMD5PropertiesPasswordManager(File file, String str, String str2) throws IOException {
        this(new SyncedProperties(file, str2), str);
    }

    public HexAsciiMD5PropertiesPasswordManager(File file) throws IOException {
        this(file, "password", DEF_HEADER);
    }

    private HexAsciiMD5PropertiesPasswordManager(SyncedProperties syncedProperties, String str) throws IOException {
        try {
            this.props = syncedProperties;
            this.pfx = str;
            this.f376md = MessageDigest.getInstance(DIGEST_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new InternalError("MD5 is not supported???");
        }
    }

    @Override // com.mchange.util.PasswordManager
    public synchronized boolean validate(String str, String str2) throws IOException {
        try {
            return Arrays.equals(ByteUtils.fromHexAscii(this.props.getProperty(this.pfx != null ? this.pfx + '.' + str : str)), this.f376md.digest(str2.getBytes(PASSWORD_ENCODING)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            throw new InternalError("8859_1is an unsupported encoding???");
        } catch (NumberFormatException e2) {
            throw new IOException("Password file corrupted! [contains invalid hex ascii string]");
        }
    }

    @Override // com.mchange.util.PasswordManager
    public synchronized boolean updatePassword(String str, String str2, String str3) throws IOException {
        if (!validate(str, str2)) {
            return false;
        }
        this.props.put(this.pfx + '.' + str, ByteUtils.toHexAscii(this.f376md.digest(str3.getBytes(PASSWORD_ENCODING))));
        return true;
    }
}
