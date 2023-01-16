package com.mongodb.internal.connection;

import com.mongodb.MongoCompressor;
import com.mongodb.MongoDriverInformation;
import com.mongodb.assertions.Assertions;
import com.mongodb.connection.ServerId;
import com.mongodb.connection.StreamFactory;
import com.mongodb.event.CommandListener;
import java.util.List;
import org.bson.BsonDocument;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/InternalStreamConnectionFactory.class */
class InternalStreamConnectionFactory implements InternalConnectionFactory {
    private final StreamFactory streamFactory;
    private final BsonDocument clientMetadataDocument;
    private final List<MongoCompressor> compressorList;
    private final CommandListener commandListener;
    private final MongoCredentialWithCache credential;

    /* access modifiers changed from: package-private */
    public InternalStreamConnectionFactory(StreamFactory streamFactory, MongoCredentialWithCache credential, String applicationName, MongoDriverInformation mongoDriverInformation, List<MongoCompressor> compressorList, CommandListener commandListener) {
        this.streamFactory = (StreamFactory) Assertions.notNull("streamFactory", streamFactory);
        this.compressorList = (List) Assertions.notNull("compressorList", compressorList);
        this.commandListener = commandListener;
        this.clientMetadataDocument = ClientMetadataHelper.createClientMetadataDocument(applicationName, mongoDriverInformation);
        this.credential = credential;
    }

    @Override // com.mongodb.internal.connection.InternalConnectionFactory
    public InternalConnection create(ServerId serverId) {
        return new InternalStreamConnection(serverId, this.streamFactory, this.compressorList, this.commandListener, new InternalStreamConnectionInitializer(this.credential == null ? null : createAuthenticator(this.credential), this.clientMetadataDocument, this.compressorList));
    }

    private Authenticator createAuthenticator(MongoCredentialWithCache credential) {
        if (credential.getAuthenticationMechanism() == null) {
            return new DefaultAuthenticator(credential);
        }
        switch (credential.getAuthenticationMechanism()) {
            case GSSAPI:
                return new GSSAPIAuthenticator(credential);
            case PLAIN:
                return new PlainAuthenticator(credential);
            case MONGODB_X509:
                return new X509Authenticator(credential);
            case SCRAM_SHA_1:
            case SCRAM_SHA_256:
                return new ScramShaAuthenticator(credential);
            case MONGODB_AWS:
                return new AwsAuthenticator(credential);
            default:
                throw new IllegalArgumentException("Unsupported authentication mechanism " + credential.getAuthenticationMechanism());
        }
    }
}
