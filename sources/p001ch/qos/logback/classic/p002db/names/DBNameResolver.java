package p001ch.qos.logback.classic.p002db.names;

/* renamed from: ch.qos.logback.classic.db.names.DBNameResolver */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/db/names/DBNameResolver.class */
public interface DBNameResolver {
    <N extends Enum<?>> String getTableName(N n);

    <N extends Enum<?>> String getColumnName(N n);
}
