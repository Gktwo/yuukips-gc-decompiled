package com.mongodb.internal.connection;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.security.sasl.SaslException;
import org.bson.internal.Base64;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/AuthorizationHeader.class */
final class AuthorizationHeader {
    private static final String AWS4_HMAC_SHA256 = "AWS4-HMAC-SHA256";
    private static final String SERVICE = "sts";
    private final String host;
    private final String timestamp;
    private final String signature;
    private final String sessionToken;
    private final String authorizationHeader;
    private final byte[] nonce;
    private final Map<String, String> requestHeaders;
    private final String body;

    private AuthorizationHeader(Builder builder) throws SaslException {
        this.sessionToken = builder.sessionToken;
        this.host = builder.host;
        this.timestamp = builder.timestamp;
        this.nonce = builder.nonce;
        this.body = "Action=GetCallerIdentity&Version=2011-06-15";
        this.requestHeaders = getRequestHeaders();
        this.signature = calculateSignature(createStringToSign(hash(createCanonicalRequest("POST", "", this.body, this.requestHeaders)), getTimestamp(), getCredentialScope()), builder.secretKey, getDate(), getRegion(this.host), SERVICE);
        this.authorizationHeader = String.format("%s Credential=%s/%s, SignedHeaders=%s, Signature=%s", AWS4_HMAC_SHA256, builder.accessKeyID, getCredentialScope(), getSignedHeaders(this.requestHeaders), getSignature());
    }

    static String createCanonicalRequest(String method, String query, String body, Map<String, String> requestHeaders) throws SaslException {
        return String.join("\n", Arrays.asList(method, "/", query, getCanonicalHeaders(requestHeaders), getSignedHeaders(requestHeaders), hash(body)));
    }

    static String createStringToSign(String hash, String timestamp, String credentialScope) {
        return String.join("\n", Arrays.asList(AWS4_HMAC_SHA256, timestamp, credentialScope, hash));
    }

    static String calculateSignature(String toSign, String secret, String date, String region, String service) throws SaslException {
        return hexEncode(hmac(hmac(hmac(hmac(hmac(decodeUTF8("AWS4" + secret), decodeUTF8(date)), decodeUTF8(region)), decodeUTF8(service)), decodeUTF8("aws4_request")), decodeUTF8(toSign)));
    }

    private Map<String, String> getRequestHeaders() {
        if (this.requestHeaders != null) {
            return this.requestHeaders;
        }
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/x-www-form-urlencoded");
        requestHeaders.put("Content-Length", String.valueOf(this.body.length()));
        requestHeaders.put("Host", this.host);
        requestHeaders.put("X-Amz-Date", this.timestamp);
        requestHeaders.put("X-MongoDB-Server-Nonce", Base64.encode(this.nonce));
        requestHeaders.put("X-MongoDB-GS2-CB-Flag", "n");
        if (this.sessionToken != null) {
            requestHeaders.put("X-Amz-Security-Token", this.sessionToken);
        }
        return requestHeaders;
    }

    private String getCredentialScope() throws SaslException {
        return String.format("%s/%s/%s/aws4_request", getDate(), getRegion(this.host), SERVICE);
    }

    static String getSignedHeaders(Map<String, String> requestHeaders) {
        return (String) requestHeaders.keySet().stream().map((v0) -> {
            return v0.toLowerCase();
        }).sorted().collect(Collectors.joining(";"));
    }

    static String getCanonicalHeaders(Map<String, String> requestHeaders) {
        return (String) requestHeaders.entrySet().stream().map(kvp -> {
            return String.format("%s:%s\n", ((String) kvp.getKey()).toLowerCase(), ((String) kvp.getValue()).trim().replaceAll(" +", " "));
        }).sorted().collect(Collectors.joining(""));
    }

    static String getRegion(String host) throws SaslException {
        if (host.equals("sts.amazonaws.com") || host.matches(String.format("%s", "(\\w)+(-\\w)*"))) {
            return "us-east-1";
        }
        if (host.matches(String.format("%s(.%s)+", "(\\w)+(-\\w)*", "(\\w)+(-\\w)*"))) {
            return host.split("\\.")[1];
        }
        throw new SaslException("Invalid host");
    }

    String getSignature() {
        return this.signature;
    }

    /* access modifiers changed from: package-private */
    public String getTimestamp() {
        return this.timestamp;
    }

    private String getDate() {
        return getTimestamp().substring(0, "YYYYMMDD".length());
    }

    static String hash(String str) throws SaslException {
        return hexEncode(sha256(str)).toLowerCase();
    }

    private static String hexEncode(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        int length = bytes.length;
        for (int i = 0; i < length; i++) {
            sb.append(String.format("%02x", Byte.valueOf(bytes[i])));
        }
        return sb.toString();
    }

    private static byte[] decodeUTF8(String str) {
        return str.getBytes(StandardCharsets.UTF_8);
    }

    private static byte[] hmac(byte[] secret, byte[] message) throws SaslException {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret, "HmacSHA256"));
            return mac.doFinal(message);
        } catch (Exception e) {
            throw new SaslException(e.getMessage());
        }
    }

    private static byte[] sha256(String payload) throws SaslException {
        try {
            return MessageDigest.getInstance("SHA-256").digest(payload.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            throw new SaslException(e.getMessage());
        }
    }

    public String toString() {
        return this.authorizationHeader;
    }

    public static Builder builder() {
        return new Builder();
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/AuthorizationHeader$Builder.class */
    static final class Builder {
        private String accessKeyID;
        private String secretKey;
        private String sessionToken;
        private String host;
        private String timestamp;
        private byte[] nonce;

        private Builder() {
        }

        /* access modifiers changed from: package-private */
        public Builder setAccessKeyID(String accessKeyID) {
            this.accessKeyID = accessKeyID;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setSecretKey(String secretKey) {
            this.secretKey = secretKey;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setSessionToken(String sessionToken) {
            this.sessionToken = sessionToken;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setHost(String host) {
            this.host = host;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setTimestamp(String timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setNonce(byte[] nonce) {
            this.nonce = nonce;
            return this;
        }

        /* access modifiers changed from: package-private */
        public AuthorizationHeader build() throws SaslException {
            return new AuthorizationHeader(this);
        }
    }
}
