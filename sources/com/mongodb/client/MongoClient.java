package com.mongodb.client;

import com.mongodb.ClientSessionOptions;
import com.mongodb.annotations.Immutable;
import com.mongodb.connection.ClusterDescription;
import java.io.Closeable;
import java.util.List;
import org.bson.Document;
import org.bson.conversions.Bson;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/client/MongoClient.class */
public interface MongoClient extends Closeable {
    MongoDatabase getDatabase(String str);

    ClientSession startSession();

    ClientSession startSession(ClientSessionOptions clientSessionOptions);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    MongoIterable<String> listDatabaseNames();

    MongoIterable<String> listDatabaseNames(ClientSession clientSession);

    ListDatabasesIterable<Document> listDatabases();

    ListDatabasesIterable<Document> listDatabases(ClientSession clientSession);

    <TResult> ListDatabasesIterable<TResult> listDatabases(Class<TResult> cls);

    <TResult> ListDatabasesIterable<TResult> listDatabases(ClientSession clientSession, Class<TResult> cls);

    ChangeStreamIterable<Document> watch();

    <TResult> ChangeStreamIterable<TResult> watch(Class<TResult> cls);

    ChangeStreamIterable<Document> watch(List<? extends Bson> list);

    <TResult> ChangeStreamIterable<TResult> watch(List<? extends Bson> list, Class<TResult> cls);

    ChangeStreamIterable<Document> watch(ClientSession clientSession);

    <TResult> ChangeStreamIterable<TResult> watch(ClientSession clientSession, Class<TResult> cls);

    ChangeStreamIterable<Document> watch(ClientSession clientSession, List<? extends Bson> list);

    <TResult> ChangeStreamIterable<TResult> watch(ClientSession clientSession, List<? extends Bson> list, Class<TResult> cls);

    ClusterDescription getClusterDescription();
}
