package org.bson.codecs.pojo;

import dev.morphia.mapping.Mapper;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.bson.codecs.configuration.CodecConfigurationException;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/codecs/pojo/DiscriminatorLookup.class */
public final class DiscriminatorLookup {
    private final Map<String, Class<?>> discriminatorClassMap = new ConcurrentHashMap();
    private final Set<String> packages;

    /* access modifiers changed from: package-private */
    public DiscriminatorLookup(Map<Class<?>, ClassModel<?>> classModels, Set<String> packages) {
        for (ClassModel<?> classModel : classModels.values()) {
            if (classModel.getDiscriminator() != null) {
                this.discriminatorClassMap.put(classModel.getDiscriminator(), classModel.getType());
            }
        }
        this.packages = packages;
    }

    public Class<?> lookup(String discriminator) {
        if (this.discriminatorClassMap.containsKey(discriminator)) {
            return this.discriminatorClassMap.get(discriminator);
        }
        Class<?> clazz = getClassForName(discriminator);
        if (clazz == null) {
            clazz = searchPackages(discriminator);
        }
        if (clazz == null) {
            throw new CodecConfigurationException(String.format("A class could not be found for the discriminator: '%s'.", discriminator));
        }
        this.discriminatorClassMap.put(discriminator, clazz);
        return clazz;
    }

    /* access modifiers changed from: package-private */
    public void addClassModel(ClassModel<?> classModel) {
        if (classModel.getDiscriminator() != null) {
            this.discriminatorClassMap.put(classModel.getDiscriminator(), classModel.getType());
        }
    }

    private Class<?> getClassForName(String discriminator) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(discriminator);
        } catch (ClassNotFoundException e) {
        }
        return clazz;
    }

    private Class<?> searchPackages(String discriminator) {
        Class<?> clazz = null;
        Iterator<String> it = this.packages.iterator();
        while (it.hasNext()) {
            clazz = getClassForName(it.next() + Mapper.IGNORED_FIELDNAME + discriminator);
            if (clazz != null) {
                return clazz;
            }
        }
        return clazz;
    }
}
