package com.mongodb.internal.connection;

import com.mongodb.AuthenticationMechanism;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.MongoInternalException;
import com.mongodb.ServerAddress;
import com.mongodb.connection.ConnectionDescription;
import com.mongodb.lang.NonNull;
import com.mongodb.lang.Nullable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.security.sasl.SaslClient;
import javax.security.sasl.SaslException;
import org.bson.BsonBinary;
import org.bson.BsonBinaryWriter;
import org.bson.BsonDocument;
import org.bson.BsonInt32;
import org.bson.BsonString;
import org.bson.BsonWriter;
import org.bson.RawBsonDocument;
import org.bson.codecs.BsonDocumentCodec;
import org.bson.codecs.EncoderContext;
import org.bson.p022io.BasicOutputBuffer;
import p001ch.qos.logback.core.pattern.color.ANSIConstants;
import p001ch.qos.logback.core.rolling.helper.DateTokenConverter;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/AwsAuthenticator.class */
public class AwsAuthenticator extends SaslAuthenticator {
    private static final String MONGODB_AWS_MECHANISM_NAME = "MONGODB-AWS";
    private static final int RANDOM_LENGTH = 32;

    @Override // com.mongodb.internal.connection.SaslAuthenticator, com.mongodb.internal.connection.Authenticator
    public /* bridge */ /* synthetic */ void authenticate(InternalConnection internalConnection, ConnectionDescription connectionDescription) {
        authenticate(internalConnection, connectionDescription);
    }

    public AwsAuthenticator(MongoCredentialWithCache credential) {
        super(credential);
        if (getMongoCredential().getAuthenticationMechanism() != AuthenticationMechanism.MONGODB_AWS) {
            throw new MongoException("Incorrect mechanism: " + getMongoCredential().getMechanism());
        }
    }

    @Override // com.mongodb.internal.connection.SaslAuthenticator
    public String getMechanismName() {
        return MONGODB_AWS_MECHANISM_NAME;
    }

    @Override // com.mongodb.internal.connection.SaslAuthenticator
    protected SaslClient createSaslClient(ServerAddress serverAddress) {
        return new AwsSaslClient(getMongoCredential());
    }

    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/AwsAuthenticator$AwsSaslClient.class */
    private static class AwsSaslClient implements SaslClient {
        private final MongoCredential credential;
        private final byte[] clientNonce = new byte[32];
        private int step = -1;
        private String httpResponse;

        AwsSaslClient(MongoCredential credential) {
            this.credential = credential;
        }

        public String getMechanismName() {
            AuthenticationMechanism authMechanism = this.credential.getAuthenticationMechanism();
            if (authMechanism != null) {
                return authMechanism.getMechanismName();
            }
            throw new IllegalArgumentException("Authentication mechanism cannot be null");
        }

        public boolean hasInitialResponse() {
            return true;
        }

        public byte[] evaluateChallenge(byte[] challenge) throws SaslException {
            this.step++;
            if (this.step == 0) {
                return computeClientFirstMessage();
            }
            if (this.step == 1) {
                return computeClientFinalMessage(challenge);
            }
            throw new SaslException(String.format("Too many steps involved in the %s negotiation.", getMechanismName()));
        }

        public boolean isComplete() {
            return this.step == 1;
        }

        public byte[] unwrap(byte[] bytes, int i, int i1) {
            throw new UnsupportedOperationException("Not implemented yet!");
        }

        public byte[] wrap(byte[] bytes, int i, int i1) {
            throw new UnsupportedOperationException("Not implemented yet!");
        }

        public Object getNegotiatedProperty(String s) {
            throw new UnsupportedOperationException("Not implemented yet!");
        }

        public void dispose() {
        }

        private byte[] computeClientFirstMessage() {
            new SecureRandom().nextBytes(this.clientNonce);
            return toBson(new BsonDocument().append("r", new BsonBinary(this.clientNonce)).append("p", new BsonInt32(110)));
        }

        private byte[] computeClientFinalMessage(byte[] serverFirst) throws SaslException {
            BsonDocument document = new RawBsonDocument(serverFirst);
            String host = document.getString("h").getValue();
            byte[] serverNonce = document.getBinary("s").getData();
            if (serverNonce.length != 64) {
                throw new SaslException(String.format("Server nonce must be %d bytes", 64));
            } else if (!Arrays.equals(Arrays.copyOf(serverNonce, 32), this.clientNonce)) {
                throw new SaslException(String.format("The first %d bytes of the server nonce must be the client nonce", 32));
            } else {
                String timestamp = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'").withZone(ZoneId.of("UTC")).format(Instant.now());
                String token = getSessionToken();
                AuthorizationHeader authorizationHeader = AuthorizationHeader.builder().setAccessKeyID(getUserName()).setSecretKey(getPassword()).setSessionToken(token).setHost(host).setNonce(serverNonce).setTimestamp(timestamp).build();
                BsonDocument ret = new BsonDocument().append("a", new BsonString(authorizationHeader.toString())).append(DateTokenConverter.CONVERTER_KEY, new BsonString(authorizationHeader.getTimestamp()));
                if (token != null) {
                    ret.append("t", new BsonString(token));
                }
                return toBson(ret);
            }
        }

        private byte[] toBson(BsonDocument document) {
            BasicOutputBuffer buffer = new BasicOutputBuffer();
            new BsonDocumentCodec().encode((BsonWriter) new BsonBinaryWriter(buffer), document, EncoderContext.builder().build());
            byte[] bytes = new byte[buffer.size()];
            System.arraycopy(buffer.getInternalBuffer(), 0, bytes, 0, buffer.getSize());
            return bytes;
        }

        @NonNull
        String getUserName() {
            String userName = this.credential.getUserName();
            if (userName == null) {
                userName = System.getenv("AWS_ACCESS_KEY_ID");
                if (userName == null) {
                    userName = BsonDocument.parse(getHttpResponse()).getString("AccessKeyId").getValue();
                }
            }
            return userName;
        }

        @NonNull
        private String getPassword() {
            char[] password = this.credential.getPassword();
            if (password == null) {
                if (System.getenv("AWS_SECRET_ACCESS_KEY") != null) {
                    password = System.getenv("AWS_SECRET_ACCESS_KEY").toCharArray();
                } else {
                    password = BsonDocument.parse(getHttpResponse()).getString("SecretAccessKey").getValue().toCharArray();
                }
            }
            return new String(password);
        }

        @Nullable
        private String getSessionToken() {
            String token = (String) this.credential.getMechanismProperty("AWS_SESSION_TOKEN", null);
            if (this.credential.getUserName() != null) {
                return token;
            }
            if (token != null) {
                throw new IllegalArgumentException("The connection string contains a session token without credentials");
            } else if (System.getenv("AWS_SECRET_ACCESS_KEY") == null && System.getenv("AWS_ACCESS_KEY_ID") == null && System.getenv("AWS_SESSION_TOKEN") == null) {
                return BsonDocument.parse(getHttpResponse()).getString("Token").getValue();
            } else {
                if (System.getenv("AWS_SECRET_ACCESS_KEY") != null && System.getenv("AWS_ACCESS_KEY_ID") != null) {
                    return System.getenv("AWS_SESSION_TOKEN");
                }
                throw new IllegalArgumentException("The environment variables 'AWS_ACCESS_KEY_ID' and 'AWS_SECRET_ACCESS_KEY' must either both be set or both be null");
            }
        }

        @NonNull
        private String getHttpResponse() {
            String str;
            if (this.httpResponse != null) {
                return this.httpResponse;
            }
            String path = System.getenv("AWS_CONTAINER_CREDENTIALS_RELATIVE_URI");
            if (path == null) {
                str = getEc2Response();
            } else {
                str = getHttpContents("GET", "http://169.254.170.2" + path, null);
            }
            this.httpResponse = str;
            return this.httpResponse;
        }

        private String getEc2Response() {
            Map<String, String> header = new HashMap<>();
            header.put("X-aws-ec2-metadata-token-ttl-seconds", ANSIConstants.BLACK_FG);
            String token = getHttpContents("PUT", "http://169.254.169.254/latest/api/token", header);
            header.clear();
            header.put("X-aws-ec2-metadata-token", token);
            return getHttpContents("GET", "http://169.254.169.254/latest/meta-data/iam/security-credentials/" + getHttpContents("GET", "http://169.254.169.254/latest/meta-data/iam/security-credentials/", header), header);
        }

        @NonNull
        private static String getHttpContents(String method, String endpoint, Map<String, String> headers) {
            HttpURLConnection conn;
            try {
                StringBuilder content = new StringBuilder();
                conn = null;
                try {
                    HttpURLConnection conn2 = (HttpURLConnection) new URL(endpoint).openConnection();
                    conn2.setRequestMethod(method);
                    conn2.setReadTimeout(10000);
                    if (headers != null) {
                        for (Map.Entry<String, String> kvp : headers.entrySet()) {
                            conn2.setRequestProperty(kvp.getKey(), kvp.getValue());
                        }
                    }
                    int status = conn2.getResponseCode();
                    if (status != 200) {
                        throw new IOException(String.format("%d %s", Integer.valueOf(status), conn2.getResponseMessage()));
                    }
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn2.getInputStream(), StandardCharsets.UTF_8));
                    while (true) {
                        try {
                            String inputLine = in.readLine();
                            if (inputLine == null) {
                                break;
                            }
                            content.append(inputLine);
                        } catch (Throwable th) {
                            try {
                                in.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                            throw th;
                        }
                    }
                    in.close();
                    if (conn2 != null) {
                        conn2.disconnect();
                    }
                    return content.toString();
                } catch (IOException e) {
                    throw new MongoInternalException("Unexpected IOException", e);
                }
            } catch (Throwable th3) {
                if (0 != 0) {
                    conn.disconnect();
                }
                throw th3;
            }
        }
    }
}
