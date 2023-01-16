package p001ch.qos.logback.classic.p002db.names;

/* renamed from: ch.qos.logback.classic.db.names.DefaultDBNameResolver */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/db/names/DefaultDBNameResolver.class */
public class DefaultDBNameResolver implements DBNameResolver {
    @Override // p001ch.qos.logback.classic.p002db.names.DBNameResolver
    public <N extends Enum<?>> String getTableName(N tableName) {
        return tableName.toString().toLowerCase();
    }

    @Override // p001ch.qos.logback.classic.p002db.names.DBNameResolver
    public <N extends Enum<?>> String getColumnName(N columnName) {
        return columnName.toString().toLowerCase();
    }
}
