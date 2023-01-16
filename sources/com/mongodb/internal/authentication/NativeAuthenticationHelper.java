package com.mongodb.internal.authentication;

import com.mongodb.internal.HexUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonString;
import org.bson.BsonValue;
import p001ch.qos.logback.core.joran.action.Action;

/* loaded from: grasscutter.jar:com/mongodb/internal/authentication/NativeAuthenticationHelper.class */
public final class NativeAuthenticationHelper {
    private static final Charset UTF_8_CHARSET = Charset.forName("UTF-8");

    public static String createAuthenticationHash(String userName, char[] password) {
        ByteArrayOutputStream bout = new ByteArrayOutputStream(userName.length() + 20 + password.length);
        try {
            bout.write(userName.getBytes(UTF_8_CHARSET));
            bout.write(":mongo:".getBytes(UTF_8_CHARSET));
            bout.write(new String(password).getBytes(UTF_8_CHARSET));
            return HexUtils.hexMD5(bout.toByteArray());
        } catch (IOException ioe) {
            throw new RuntimeException("impossible", ioe);
        }
    }

    public static BsonDocument getAuthCommand(String userName, char[] password, String nonce) {
        return getAuthCommand(userName, createAuthenticationHash(userName, password), nonce);
    }

    public static BsonDocument getAuthCommand(String userName, String authHash, String nonce) {
        BsonDocument cmd = new BsonDocument();
        cmd.put("authenticate", (BsonValue) new BsonInt32(1));
        cmd.put("user", (BsonValue) new BsonString(userName));
        cmd.put("nonce", (BsonValue) new BsonString(nonce));
        cmd.put(Action.KEY_ATTRIBUTE, (BsonValue) new BsonString(HexUtils.hexMD5((nonce + userName + authHash).getBytes(UTF_8_CHARSET))));
        return cmd;
    }

    public static BsonDocument getNonceCommand() {
        return new BsonDocument("getnonce", new BsonInt32(1));
    }

    private NativeAuthenticationHelper() {
    }
}
