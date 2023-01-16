package dev.morphia.mapping;

import dev.morphia.mapping.conventions.ConfigureProperties;
import dev.morphia.mapping.conventions.FieldDiscovery;
import dev.morphia.mapping.conventions.MethodDiscovery;
import dev.morphia.mapping.conventions.MorphiaConvention;
import dev.morphia.mapping.conventions.MorphiaDefaultsConvention;
import dev.morphia.query.DefaultQueryFactory;
import dev.morphia.query.LegacyQueryFactory;
import dev.morphia.query.QueryFactory;
import dev.morphia.sofia.Sofia;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.ServiceLoader;
import org.bson.UuidRepresentation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:dev/morphia/mapping/MapperOptions.class */
public class MapperOptions {
    public static final MapperOptions DEFAULT = builder().build();
    private static final Logger LOG = LoggerFactory.getLogger(MapperOptions.class);
    private final boolean ignoreFinals;
    private final boolean storeNulls;
    private final boolean storeEmpties;
    private final boolean cacheClassLookups;
    private final boolean mapSubPackages;
    private final DateStorage dateStorage;
    private final String discriminatorKey;
    private final DiscriminatorFunction discriminator;
    private final List<MorphiaConvention> conventions;
    private final NamingStrategy collectionNaming;
    private final PropertyDiscovery propertyDiscovery;
    private final NamingStrategy propertyNaming;
    private final UuidRepresentation uuidRepresentation;
    private final QueryFactory queryFactory;
    private final boolean enablePolymorphicQueries;
    private ClassLoader classLoader;

    /* loaded from: grasscutter.jar:dev/morphia/mapping/MapperOptions$PropertyDiscovery.class */
    public enum PropertyDiscovery {
        FIELDS,
        METHODS
    }

    private MapperOptions(Builder builder) {
        this.cacheClassLookups = builder.cacheClassLookups;
        this.classLoader = builder.classLoader;
        this.collectionNaming = builder.collectionNaming;
        this.conventions = builder.conventions();
        this.dateStorage = builder.dateStorage();
        this.discriminator = builder.discriminator();
        this.discriminatorKey = builder.discriminatorKey();
        this.enablePolymorphicQueries = builder.enablePolymorphicQueries();
        this.propertyDiscovery = builder.propertyDiscovery();
        this.propertyNaming = builder.propertyNaming();
        this.ignoreFinals = builder.ignoreFinals();
        this.mapSubPackages = builder.mapSubPackages();
        this.queryFactory = builder.queryFactory();
        this.storeEmpties = builder.storeEmpties();
        this.storeNulls = builder.storeNulls();
        this.uuidRepresentation = builder.uuidRepresentation();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(MapperOptions original) {
        return new Builder(original);
    }

    public static Builder legacy() {
        return new Builder().dateStorage(DateStorage.SYSTEM_DEFAULT).discriminatorKey("className").discriminator(DiscriminatorFunction.className()).collectionNaming(NamingStrategy.identity()).propertyNaming(NamingStrategy.identity()).queryFactory(new LegacyQueryFactory());
    }

    public ClassLoader getClassLoader() {
        if (this.classLoader == null) {
            this.classLoader = Thread.currentThread().getContextClassLoader();
        }
        return this.classLoader;
    }

    public NamingStrategy getCollectionNaming() {
        return this.collectionNaming;
    }

    public List<MorphiaConvention> getConventions() {
        return Collections.unmodifiableList(this.conventions);
    }

    public DateStorage getDateStorage() {
        return this.dateStorage;
    }

    public DiscriminatorFunction getDiscriminator() {
        return this.discriminator;
    }

    public String getDiscriminatorKey() {
        return this.discriminatorKey;
    }

    @Deprecated(forRemoval = true)
    public NamingStrategy getFieldNaming() {
        return getPropertyNaming();
    }

    public NamingStrategy getPropertyNaming() {
        return this.propertyNaming;
    }

    public QueryFactory getQueryFactory() {
        return this.queryFactory;
    }

    public UuidRepresentation getUuidRepresentation() {
        return this.uuidRepresentation;
    }

    public boolean isCacheClassLookups() {
        return this.cacheClassLookups;
    }

    public boolean isEnablePolymorphicQueries() {
        return this.enablePolymorphicQueries;
    }

    public boolean isIgnoreFinals() {
        return this.ignoreFinals;
    }

    public boolean isMapSubPackages() {
        return this.mapSubPackages;
    }

    public boolean isStoreEmpties() {
        return this.storeEmpties;
    }

    public boolean isStoreNulls() {
        return this.storeNulls;
    }

    /* loaded from: grasscutter.jar:dev/morphia/mapping/MapperOptions$Builder.class */
    public static final class Builder {
        private final List<MorphiaConvention> conventions;
        private boolean ignoreFinals;
        private boolean storeNulls;
        private boolean storeEmpties;
        private boolean cacheClassLookups;
        private boolean mapSubPackages;
        private boolean enablePolymorphicQueries;
        private ClassLoader classLoader;
        private DateStorage dateStorage;
        private String discriminatorKey;
        private DiscriminatorFunction discriminator;
        private NamingStrategy collectionNaming;
        private NamingStrategy propertyNaming;
        private UuidRepresentation uuidRepresentation;
        private QueryFactory queryFactory;
        private PropertyDiscovery propertyDiscovery;
        private MapperOptions options;

        private Builder() {
            this.conventions = new ArrayList();
            this.dateStorage = DateStorage.UTC;
            this.discriminatorKey = "_t";
            this.discriminator = DiscriminatorFunction.simpleName();
            this.collectionNaming = NamingStrategy.camelCase();
            this.propertyNaming = NamingStrategy.identity();
            this.uuidRepresentation = UuidRepresentation.STANDARD;
            this.queryFactory = new DefaultQueryFactory();
            this.propertyDiscovery = PropertyDiscovery.FIELDS;
        }

        public Builder(MapperOptions original) {
            this.conventions = new ArrayList();
            this.dateStorage = DateStorage.UTC;
            this.discriminatorKey = "_t";
            this.discriminator = DiscriminatorFunction.simpleName();
            this.collectionNaming = NamingStrategy.camelCase();
            this.propertyNaming = NamingStrategy.identity();
            this.uuidRepresentation = UuidRepresentation.STANDARD;
            this.queryFactory = new DefaultQueryFactory();
            this.propertyDiscovery = PropertyDiscovery.FIELDS;
            this.cacheClassLookups = original.isCacheClassLookups();
            this.classLoader = original.getClassLoader();
            this.dateStorage = original.getDateStorage();
            this.ignoreFinals = original.isIgnoreFinals();
            this.mapSubPackages = original.isMapSubPackages();
            this.storeEmpties = original.isStoreEmpties();
            this.storeNulls = original.isStoreNulls();
            this.enablePolymorphicQueries = original.enablePolymorphicQueries;
            this.discriminatorKey = original.discriminatorKey;
            this.discriminator = original.discriminator;
            this.collectionNaming = original.collectionNaming;
            this.propertyNaming = original.propertyNaming;
            this.uuidRepresentation = original.uuidRepresentation;
            this.queryFactory = original.queryFactory;
            this.propertyDiscovery = original.propertyDiscovery;
        }

        public Builder addConvention(MorphiaConvention convention) {
            assertNotLocked();
            this.conventions.add(convention);
            return this;
        }

        public MapperOptions build() {
            if (this.options == null) {
                this.options = new MapperOptions(this);
            }
            return this.options;
        }

        public Builder cacheClassLookups(boolean cacheClassLookups) {
            assertNotLocked();
            this.cacheClassLookups = cacheClassLookups;
            return this;
        }

        public Builder classLoader(ClassLoader classLoader) {
            assertNotLocked();
            this.classLoader = classLoader;
            return this;
        }

        public Builder collectionNaming(NamingStrategy strategy) {
            assertNotLocked();
            this.collectionNaming = strategy;
            return this;
        }

        @Deprecated
        public Builder dateForm(DateStorage dateStorage) {
            assertNotLocked();
            return dateStorage(dateStorage);
        }

        public Builder dateStorage(DateStorage dateStorage) {
            assertNotLocked();
            this.dateStorage = dateStorage;
            return this;
        }

        @Deprecated(forRemoval = true)
        public Builder disableEmbeddedIndexes(boolean disableEmbeddedIndexes) {
            assertNotLocked();
            MapperOptions.LOG.warn("this option is no longer used");
            return this;
        }

        public Builder discriminator(DiscriminatorFunction function) {
            assertNotLocked();
            this.discriminator = function;
            return this;
        }

        public Builder discriminatorKey(String key) {
            assertNotLocked();
            this.discriminatorKey = key;
            return this;
        }

        public Builder enablePolymorphicQueries(boolean enablePolymorphicQueries) {
            assertNotLocked();
            this.enablePolymorphicQueries = enablePolymorphicQueries;
            return this;
        }

        @Deprecated(forRemoval = true)
        public Builder fieldNaming(NamingStrategy strategy) {
            assertNotLocked();
            return propertyNaming(strategy);
        }

        public Builder ignoreFinals(boolean ignoreFinals) {
            assertNotLocked();
            this.ignoreFinals = ignoreFinals;
            return this;
        }

        public Builder mapSubPackages(boolean mapSubPackages) {
            assertNotLocked();
            this.mapSubPackages = mapSubPackages;
            return this;
        }

        public Builder propertyDiscovery(PropertyDiscovery discovery) {
            assertNotLocked();
            this.propertyDiscovery = discovery;
            return this;
        }

        public Builder propertyNaming(NamingStrategy strategy) {
            assertNotLocked();
            this.propertyNaming = strategy;
            return this;
        }

        public Builder queryFactory(QueryFactory queryFactory) {
            assertNotLocked();
            this.queryFactory = queryFactory;
            return this;
        }

        public Builder storeEmpties(boolean storeEmpties) {
            assertNotLocked();
            this.storeEmpties = storeEmpties;
            return this;
        }

        public Builder storeNulls(boolean storeNulls) {
            assertNotLocked();
            this.storeNulls = storeNulls;
            return this;
        }

        @Deprecated(since = "2.0", forRemoval = true)
        public Builder useLowerCaseCollectionNames(boolean useLowerCaseCollectionNames) {
            assertNotLocked();
            if (useLowerCaseCollectionNames) {
                collectionNaming(NamingStrategy.lowerCase());
            }
            return this;
        }

        public Builder uuidRepresentation(UuidRepresentation uuidRepresentation) {
            assertNotLocked();
            this.uuidRepresentation = uuidRepresentation;
            return this;
        }

        private void assertNotLocked() {
            if (this.options != null) {
                throw new MappingException(Sofia.mapperOptionsLocked(new Locale[0]));
            }
        }

        private List<MorphiaConvention> conventions() {
            if (!this.conventions.isEmpty()) {
                return this.conventions;
            }
            List<MorphiaConvention> list = new ArrayList<>(List.of(new MorphiaDefaultsConvention(), this.propertyDiscovery == PropertyDiscovery.FIELDS ? new FieldDiscovery() : new MethodDiscovery(), new ConfigureProperties()));
            ServiceLoader<MorphiaConvention> conventions = ServiceLoader.load(MorphiaConvention.class);
            Objects.requireNonNull(list);
            conventions.forEach((v1) -> {
                r1.add(v1);
            });
            return list;
        }

        private DateStorage dateStorage() {
            return this.dateStorage;
        }

        private DiscriminatorFunction discriminator() {
            return this.discriminator;
        }

        private String discriminatorKey() {
            return this.discriminatorKey;
        }

        private boolean enablePolymorphicQueries() {
            return this.enablePolymorphicQueries;
        }

        private boolean ignoreFinals() {
            return this.ignoreFinals;
        }

        private boolean mapSubPackages() {
            return this.mapSubPackages;
        }

        private PropertyDiscovery propertyDiscovery() {
            return this.propertyDiscovery;
        }

        private NamingStrategy propertyNaming() {
            return this.propertyNaming;
        }

        private QueryFactory queryFactory() {
            return this.queryFactory;
        }

        private boolean storeEmpties() {
            return this.storeEmpties;
        }

        private boolean storeNulls() {
            return this.storeNulls;
        }

        private UuidRepresentation uuidRepresentation() {
            return this.uuidRepresentation;
        }
    }
}
