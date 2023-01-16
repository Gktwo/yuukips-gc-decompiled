package dev.morphia.mapping.codec;

import dev.morphia.Datastore;
import dev.morphia.annotations.PostLoad;
import dev.morphia.annotations.PostPersist;
import dev.morphia.annotations.PreLoad;
import dev.morphia.annotations.PrePersist;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityDecoder;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.LifecycleDecoder;
import dev.morphia.mapping.codec.pojo.LifecycleEncoder;
import dev.morphia.mapping.codec.pojo.MorphiaCodec;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;
import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PropertyCodecProvider;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/MorphiaCodecProvider.class */
public class MorphiaCodecProvider implements CodecProvider {
    private final Mapper mapper;
    private final Datastore datastore;
    private final Map<Class<?>, Codec<?>> codecs = new HashMap();
    private final List<PropertyCodecProvider> propertyCodecProviders = new ArrayList();

    public MorphiaCodecProvider(Mapper mapper, Datastore datastore) {
        this.datastore = datastore;
        this.mapper = mapper;
        this.propertyCodecProviders.addAll(List.of(new MorphiaMapPropertyCodecProvider(), new MorphiaCollectionPropertyCodecProvider()));
        ServiceLoader<MorphiaPropertyCodecProvider> providers = ServiceLoader.load(MorphiaPropertyCodecProvider.class);
        List<PropertyCodecProvider> list = this.propertyCodecProviders;
        Objects.requireNonNull(list);
        providers.forEach((v1) -> {
            r1.add(v1);
        });
    }

    @Override // org.bson.codecs.configuration.CodecProvider
    public <T> Codec<T> get(Class<T> type, CodecRegistry registry) {
        MorphiaCodec<T> codec = (MorphiaCodec) this.codecs.get(type);
        if (codec == null && (this.mapper.isMapped(type) || this.mapper.isMappable(type))) {
            EntityModel model = this.mapper.getEntityModel(type);
            codec = new MorphiaCodec<>(this.datastore, model, this.propertyCodecProviders, this.mapper.getDiscriminatorLookup(), registry);
            if (model.hasLifecycle(PostPersist.class) || model.hasLifecycle(PrePersist.class) || this.mapper.hasInterceptors()) {
                codec.setEncoder(new LifecycleEncoder(codec));
            }
            if (model.hasLifecycle(PreLoad.class) || model.hasLifecycle(PostLoad.class) || this.mapper.hasInterceptors()) {
                codec.setDecoder(new LifecycleDecoder(codec));
            }
            this.codecs.put(type, codec);
        }
        return codec;
    }

    public <T> Codec<T> getRefreshCodec(final T entity, CodecRegistry registry) {
        return new MorphiaCodec<T>(this.datastore, this.mapper.getEntityModel(entity.getClass()), this.propertyCodecProviders, this.mapper.getDiscriminatorLookup(), registry) { // from class: dev.morphia.mapping.codec.MorphiaCodecProvider.1
            @Override // dev.morphia.mapping.codec.pojo.MorphiaCodec
            protected EntityDecoder getDecoder() {
                return new EntityDecoder(this) { // from class: dev.morphia.mapping.codec.MorphiaCodecProvider.1.1
                    @Override // dev.morphia.mapping.codec.pojo.EntityDecoder
                    protected MorphiaInstanceCreator getInstanceCreator() {
                        return new MorphiaInstanceCreator() { // from class: dev.morphia.mapping.codec.MorphiaCodecProvider.1.1.1
                            /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
                            @Override // dev.morphia.mapping.codec.InstanceCreator
                            public T getInstance() {
                                return entity;
                            }

                            @Override // dev.morphia.mapping.codec.InstanceCreator
                            public void set(Object value, PropertyModel model) {
                                model.getAccessor().set(entity, value);
                            }
                        };
                    }
                };
            }
        };
    }
}
