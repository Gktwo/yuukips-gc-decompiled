package emu.grasscutter.database;

import com.mongodb.DBCollection;
import com.mongodb.MongoCommandException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import dev.morphia.Datastore;
import dev.morphia.Morphia;
import dev.morphia.annotations.Entity;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.MapperOptions;
import dev.morphia.query.experimental.filters.Filters;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.game.Account;
import org.reflections.Reflections;
import org.reflections.scanners.Scanner;

/* loaded from: grasscutter.jar:emu/grasscutter/database/DatabaseManager.class */
public final class DatabaseManager {
    private static Datastore gameDatastore;
    private static Datastore dispatchDatastore;

    public static Datastore getGameDatastore() {
        return gameDatastore;
    }

    public static MongoDatabase getGameDatabase() {
        return getGameDatastore().getDatabase();
    }

    public static Datastore getAccountDatastore() {
        return dispatchDatastore;
    }

    public static void initialize() {
        MongoClient gameMongoClient = MongoClients.create(Configuration.DATABASE.game.connectionUri);
        MapperOptions mapperOptions = MapperOptions.builder().storeEmpties(true).storeNulls(false).build();
        gameDatastore = Morphia.createDatastore(gameMongoClient, Configuration.DATABASE.game.collection, mapperOptions);
        gameDatastore.getMapper().map((Class[]) new Reflections(Grasscutter.class.getPackageName(), new Scanner[0]).getTypesAnnotatedWith(Entity.class).stream().filter(cls -> {
            Entity e = (Entity) cls.getAnnotation(Entity.class);
            return e != null && !e.value().equals(Mapper.IGNORED_FIELDNAME);
        }).toArray(x$0 -> {
            return new Class[x$0];
        }));
        ensureIndexes(gameDatastore);
        dispatchDatastore = Morphia.createDatastore(MongoClients.create(Configuration.DATABASE.server.connectionUri), Configuration.DATABASE.server.collection, mapperOptions);
        dispatchDatastore.getMapper().map(DatabaseCounter.class, Account.class);
        ensureIndexes(dispatchDatastore);
    }

    private static void ensureIndexes(Datastore datastore) {
        try {
            datastore.ensureIndexes();
        } catch (MongoCommandException e) {
            Grasscutter.getLogger().info("Mongo index error: ", (Throwable) e);
            if (e.getCode() == 85) {
                MongoCursor<String> it = datastore.getDatabase().listCollectionNames().iterator();
                while (it.hasNext()) {
                    datastore.getDatabase().getCollection(it.next()).dropIndexes();
                }
                datastore.ensureIndexes();
            }
        }
    }

    public static synchronized int getNextId(Class<?> c) {
        DatabaseCounter counter = (DatabaseCounter) getGameDatastore().find(DatabaseCounter.class).filter(Filters.m1223eq(DBCollection.ID_FIELD_NAME, c.getSimpleName())).first();
        if (counter == null) {
            counter = new DatabaseCounter(c.getSimpleName());
        }
        try {
            int nextId = counter.getNextId();
            getGameDatastore().save((Datastore) counter);
            return nextId;
        } catch (Throwable th) {
            getGameDatastore().save((Datastore) counter);
            throw th;
        }
    }

    public static synchronized int getNextId(Object o) {
        return getNextId(o.getClass());
    }
}
