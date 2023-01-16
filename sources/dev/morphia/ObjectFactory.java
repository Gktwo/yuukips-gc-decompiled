package dev.morphia;

import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/ObjectFactory.class */
public interface ObjectFactory {
    <T> T createInstance(Class<T> cls);

    <T> T createInstance(Class<T> cls, Document document);

    Object createInstance(Mapper mapper, PropertyModel propertyModel, Document document);

    List createList(PropertyModel propertyModel);

    Map createMap(PropertyModel propertyModel);

    Set createSet(PropertyModel propertyModel);
}
