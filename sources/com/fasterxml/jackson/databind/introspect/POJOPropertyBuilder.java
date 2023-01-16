package com.fasterxml.jackson.databind.introspect;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyMetadata;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.cfg.ConfigOverride;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/introspect/POJOPropertyBuilder.class */
public class POJOPropertyBuilder extends BeanPropertyDefinition implements Comparable<POJOPropertyBuilder> {
    private static final AnnotationIntrospector.ReferenceProperty NOT_REFEFERENCE_PROP = AnnotationIntrospector.ReferenceProperty.managed("");
    protected final boolean _forSerialization;
    protected final MapperConfig<?> _config;
    protected final AnnotationIntrospector _annotationIntrospector;
    protected final PropertyName _name;
    protected final PropertyName _internalName;
    protected Linked<AnnotatedField> _fields;
    protected Linked<AnnotatedParameter> _ctorParameters;
    protected Linked<AnnotatedMethod> _getters;
    protected Linked<AnnotatedMethod> _setters;
    protected transient PropertyMetadata _metadata;
    protected transient AnnotationIntrospector.ReferenceProperty _referenceInfo;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$WithMember.class */
    public interface WithMember<T> {
        T withMember(AnnotatedMember annotatedMember);
    }

    public POJOPropertyBuilder(MapperConfig<?> config, AnnotationIntrospector ai, boolean forSerialization, PropertyName internalName) {
        this(config, ai, forSerialization, internalName, internalName);
    }

    protected POJOPropertyBuilder(MapperConfig<?> config, AnnotationIntrospector ai, boolean forSerialization, PropertyName internalName, PropertyName name) {
        this._config = config;
        this._annotationIntrospector = ai;
        this._internalName = internalName;
        this._name = name;
        this._forSerialization = forSerialization;
    }

    protected POJOPropertyBuilder(POJOPropertyBuilder src, PropertyName newName) {
        this._config = src._config;
        this._annotationIntrospector = src._annotationIntrospector;
        this._internalName = src._internalName;
        this._name = newName;
        this._fields = src._fields;
        this._ctorParameters = src._ctorParameters;
        this._getters = src._getters;
        this._setters = src._setters;
        this._forSerialization = src._forSerialization;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public POJOPropertyBuilder withName(PropertyName newName) {
        return new POJOPropertyBuilder(this, newName);
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public POJOPropertyBuilder withSimpleName(String newSimpleName) {
        PropertyName newName = this._name.withSimpleName(newSimpleName);
        return newName == this._name ? this : new POJOPropertyBuilder(this, newName);
    }

    public int compareTo(POJOPropertyBuilder other) {
        if (this._ctorParameters != null) {
            if (other._ctorParameters == null) {
                return -1;
            }
        } else if (other._ctorParameters != null) {
            return 1;
        }
        return getName().compareTo(other.getName());
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition, com.fasterxml.jackson.databind.util.Named
    public String getName() {
        if (this._name == null) {
            return null;
        }
        return this._name.getSimpleName();
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public PropertyName getFullName() {
        return this._name;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean hasName(PropertyName name) {
        return this._name.equals(name);
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public String getInternalName() {
        return this._internalName.getSimpleName();
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public PropertyName getWrapperName() {
        AnnotatedMember member = getPrimaryMember();
        if (member == null || this._annotationIntrospector == null) {
            return null;
        }
        return this._annotationIntrospector.findWrapperName(member);
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean isExplicitlyIncluded() {
        return _anyExplicits(this._fields) || _anyExplicits(this._getters) || _anyExplicits(this._setters) || _anyExplicitNames(this._ctorParameters);
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean isExplicitlyNamed() {
        return _anyExplicitNames(this._fields) || _anyExplicitNames(this._getters) || _anyExplicitNames(this._setters) || _anyExplicitNames(this._ctorParameters);
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public PropertyMetadata getMetadata() {
        if (this._metadata == null) {
            AnnotatedMember prim = getPrimaryMemberUnchecked();
            if (prim == null) {
                this._metadata = PropertyMetadata.STD_REQUIRED_OR_OPTIONAL;
            } else {
                Boolean b = this._annotationIntrospector.hasRequiredMarker(prim);
                String desc = this._annotationIntrospector.findPropertyDescription(prim);
                Integer idx = this._annotationIntrospector.findPropertyIndex(prim);
                String def = this._annotationIntrospector.findPropertyDefaultValue(prim);
                if (b == null && idx == null && def == null) {
                    this._metadata = desc == null ? PropertyMetadata.STD_REQUIRED_OR_OPTIONAL : PropertyMetadata.STD_REQUIRED_OR_OPTIONAL.withDescription(desc);
                } else {
                    this._metadata = PropertyMetadata.construct(b, desc, idx, def);
                }
                if (!this._forSerialization) {
                    this._metadata = _getSetterInfo(this._metadata, prim);
                }
            }
        }
        return this._metadata;
    }

    protected PropertyMetadata _getSetterInfo(PropertyMetadata metadata, AnnotatedMember primary) {
        Boolean b;
        Boolean b2;
        boolean needMerge = true;
        Nulls valueNulls = null;
        Nulls contentNulls = null;
        AnnotatedMember acc = getAccessor();
        if (primary != null) {
            if (this._annotationIntrospector != null) {
                if (!(acc == null || (b2 = this._annotationIntrospector.findMergeInfo(primary)) == null)) {
                    needMerge = false;
                    if (b2.booleanValue()) {
                        metadata = metadata.withMergeInfo(PropertyMetadata.MergeInfo.createForPropertyOverride(acc));
                    }
                }
                JsonSetter.Value setterInfo = this._annotationIntrospector.findSetterInfo(primary);
                if (setterInfo != null) {
                    valueNulls = setterInfo.nonDefaultValueNulls();
                    contentNulls = setterInfo.nonDefaultContentNulls();
                }
            }
            if (needMerge || valueNulls == null || contentNulls == null) {
                ConfigOverride co = this._config.getConfigOverride(_rawTypeOf(primary));
                JsonSetter.Value setterInfo2 = co.getSetterInfo();
                if (setterInfo2 != null) {
                    if (valueNulls == null) {
                        valueNulls = setterInfo2.nonDefaultValueNulls();
                    }
                    if (contentNulls == null) {
                        contentNulls = setterInfo2.nonDefaultContentNulls();
                    }
                }
                if (!(!needMerge || acc == null || (b = co.getMergeable()) == null)) {
                    needMerge = false;
                    if (b.booleanValue()) {
                        metadata = metadata.withMergeInfo(PropertyMetadata.MergeInfo.createForTypeOverride(acc));
                    }
                }
            }
        }
        if (needMerge || valueNulls == null || contentNulls == null) {
            JsonSetter.Value setterInfo3 = this._config.getDefaultSetterInfo();
            if (valueNulls == null) {
                valueNulls = setterInfo3.nonDefaultValueNulls();
            }
            if (contentNulls == null) {
                contentNulls = setterInfo3.nonDefaultContentNulls();
            }
            if (needMerge) {
                if (Boolean.TRUE.equals(this._config.getDefaultMergeable()) && acc != null) {
                    metadata = metadata.withMergeInfo(PropertyMetadata.MergeInfo.createForDefaults(acc));
                }
            }
        }
        if (!(valueNulls == null && contentNulls == null)) {
            metadata = metadata.withNulls(valueNulls, contentNulls);
        }
        return metadata;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public JavaType getPrimaryType() {
        if (this._forSerialization) {
            AnnotatedMember m = getGetter();
            if (m == null) {
                m = getField();
                if (m == null) {
                    return TypeFactory.unknownType();
                }
            }
            return m.getType();
        }
        AnnotatedMember m2 = getConstructorParameter();
        if (m2 == null) {
            AnnotatedMember m3 = getSetter();
            if (m3 != null) {
                return ((AnnotatedMethod) m3).getParameterType(0);
            }
            m2 = getField();
        }
        if (m2 == null) {
            m2 = getGetter();
            if (m2 == null) {
                return TypeFactory.unknownType();
            }
        }
        return m2.getType();
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public Class<?> getRawPrimaryType() {
        return getPrimaryType().getRawClass();
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean hasGetter() {
        return this._getters != null;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean hasSetter() {
        return this._setters != null;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean hasField() {
        return this._fields != null;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean hasConstructorParameter() {
        return this._ctorParameters != null;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean couldDeserialize() {
        return (this._ctorParameters == null && this._setters == null && this._fields == null) ? false : true;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean couldSerialize() {
        return (this._getters == null && this._fields == null) ? false : true;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public AnnotatedMethod getGetter() {
        Linked<AnnotatedMethod> curr = this._getters;
        if (curr == null) {
            return null;
        }
        Linked<AnnotatedMethod> next = curr.next;
        if (next == null) {
            return curr.value;
        }
        while (next != null) {
            Class<?> currClass = curr.value.getDeclaringClass();
            Class<?> nextClass = next.value.getDeclaringClass();
            if (currClass != nextClass) {
                if (currClass.isAssignableFrom(nextClass)) {
                    curr = next;
                } else if (nextClass.isAssignableFrom(currClass)) {
                    continue;
                }
                next = next.next;
            }
            int priNext = _getterPriority(next.value);
            int priCurr = _getterPriority(curr.value);
            if (priNext != priCurr) {
                if (priNext < priCurr) {
                    curr = next;
                }
                next = next.next;
            } else {
                throw new IllegalArgumentException("Conflicting getter definitions for property \"" + getName() + "\": " + curr.value.getFullName() + " vs " + next.value.getFullName());
            }
        }
        this._getters = curr.withoutNext();
        return curr.value;
    }

    /* access modifiers changed from: protected */
    public AnnotatedMethod getGetterUnchecked() {
        Linked<AnnotatedMethod> curr = this._getters;
        if (curr == null) {
            return null;
        }
        return curr.value;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public AnnotatedMethod getSetter() {
        Linked<AnnotatedMethod> curr = this._setters;
        if (curr == null) {
            return null;
        }
        Linked<AnnotatedMethod> next = curr.next;
        if (next == null) {
            return curr.value;
        }
        while (next != null) {
            AnnotatedMethod selected = _selectSetter(curr.value, next.value);
            if (selected != curr.value) {
                if (selected != next.value) {
                    return _selectSetterFromMultiple(curr, next);
                }
                curr = next;
            }
            next = next.next;
        }
        this._setters = curr.withoutNext();
        return curr.value;
    }

    /* access modifiers changed from: protected */
    public AnnotatedMethod getSetterUnchecked() {
        Linked<AnnotatedMethod> curr = this._setters;
        if (curr == null) {
            return null;
        }
        return curr.value;
    }

    protected AnnotatedMethod _selectSetterFromMultiple(Linked<AnnotatedMethod> curr, Linked<AnnotatedMethod> next) {
        List<AnnotatedMethod> conflicts = new ArrayList<>();
        conflicts.add(curr.value);
        conflicts.add(next.value);
        for (Linked<AnnotatedMethod> next2 = next.next; next2 != null; next2 = next2.next) {
            AnnotatedMethod selected = _selectSetter(curr.value, next2.value);
            if (selected != curr.value) {
                if (selected == next2.value) {
                    conflicts.clear();
                    curr = next2;
                } else {
                    conflicts.add(next2.value);
                }
            }
        }
        if (conflicts.isEmpty()) {
            this._setters = curr.withoutNext();
            return curr.value;
        }
        throw new IllegalArgumentException(String.format("Conflicting setter definitions for property \"%s\": %s", getName(), (String) conflicts.stream().map((v0) -> {
            return v0.getFullName();
        }).collect(Collectors.joining(" vs "))));
    }

    protected AnnotatedMethod _selectSetter(AnnotatedMethod currM, AnnotatedMethod nextM) {
        Class<?> currClass = currM.getDeclaringClass();
        Class<?> nextClass = nextM.getDeclaringClass();
        if (currClass != nextClass) {
            if (currClass.isAssignableFrom(nextClass)) {
                return nextM;
            }
            if (nextClass.isAssignableFrom(currClass)) {
                return currM;
            }
        }
        int priNext = _setterPriority(nextM);
        int priCurr = _setterPriority(currM);
        if (priNext != priCurr) {
            if (priNext < priCurr) {
                return nextM;
            }
            return currM;
        } else if (this._annotationIntrospector == null) {
            return null;
        } else {
            return this._annotationIntrospector.resolveSetterConflict(this._config, currM, nextM);
        }
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public AnnotatedField getField() {
        if (this._fields == null) {
            return null;
        }
        AnnotatedField field = this._fields.value;
        for (Linked linked = this._fields.next; linked != null; linked = linked.next) {
            AnnotatedField nextField = (AnnotatedField) linked.value;
            Class<?> fieldClass = field.getDeclaringClass();
            Class<?> nextClass = nextField.getDeclaringClass();
            if (fieldClass != nextClass) {
                if (fieldClass.isAssignableFrom(nextClass)) {
                    field = nextField;
                } else if (nextClass.isAssignableFrom(fieldClass)) {
                }
            }
            throw new IllegalArgumentException("Multiple fields representing property \"" + getName() + "\": " + field.getFullName() + " vs " + nextField.getFullName());
        }
        return field;
    }

    /* access modifiers changed from: protected */
    public AnnotatedField getFieldUnchecked() {
        Linked<AnnotatedField> curr = this._fields;
        if (curr == null) {
            return null;
        }
        return curr.value;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public AnnotatedParameter getConstructorParameter() {
        if (this._ctorParameters == null) {
            return null;
        }
        Linked<AnnotatedParameter> curr = this._ctorParameters;
        while (!(curr.value.getOwner() instanceof AnnotatedConstructor)) {
            curr = curr.next;
            if (curr == null) {
                return this._ctorParameters.value;
            }
        }
        return curr.value;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public Iterator<AnnotatedParameter> getConstructorParameters() {
        if (this._ctorParameters == null) {
            return ClassUtil.emptyIterator();
        }
        return new MemberIterator(this._ctorParameters);
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public AnnotatedMember getPrimaryMember() {
        if (this._forSerialization) {
            return getAccessor();
        }
        AnnotatedMember m = getMutator();
        if (m == null) {
            m = getAccessor();
        }
        return m;
    }

    protected AnnotatedMember getPrimaryMemberUnchecked() {
        if (this._forSerialization) {
            if (this._getters != null) {
                return this._getters.value;
            }
            if (this._fields != null) {
                return this._fields.value;
            }
            return null;
        } else if (this._ctorParameters != null) {
            return this._ctorParameters.value;
        } else {
            if (this._setters != null) {
                return this._setters.value;
            }
            if (this._fields != null) {
                return this._fields.value;
            }
            if (this._getters != null) {
                return this._getters.value;
            }
            return null;
        }
    }

    protected int _getterPriority(AnnotatedMethod m) {
        String name = m.getName();
        if (name.startsWith(BeanUtil.PREFIX_GETTER_GET) && name.length() > 3) {
            return 1;
        }
        if (!name.startsWith(BeanUtil.PREFIX_GETTER_IS) || name.length() <= 2) {
            return 3;
        }
        return 2;
    }

    protected int _setterPriority(AnnotatedMethod m) {
        String name = m.getName();
        if (!name.startsWith("set") || name.length() <= 3) {
            return 2;
        }
        return 1;
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public Class<?>[] findViews() {
        return (Class[]) fromMemberAnnotations(new WithMember<Class<?>[]>() { // from class: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.1
            @Override // com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.WithMember
            public Class<?>[] withMember(AnnotatedMember member) {
                return POJOPropertyBuilder.this._annotationIntrospector.findViews(member);
            }
        });
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public AnnotationIntrospector.ReferenceProperty findReferenceType() {
        AnnotationIntrospector.ReferenceProperty result = this._referenceInfo;
        if (result == null) {
            AnnotationIntrospector.ReferenceProperty result2 = (AnnotationIntrospector.ReferenceProperty) fromMemberAnnotations(new WithMember<AnnotationIntrospector.ReferenceProperty>() { // from class: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.2
                @Override // com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.WithMember
                public AnnotationIntrospector.ReferenceProperty withMember(AnnotatedMember member) {
                    return POJOPropertyBuilder.this._annotationIntrospector.findReferenceType(member);
                }
            });
            this._referenceInfo = result2 == null ? NOT_REFEFERENCE_PROP : result2;
            return result2;
        } else if (result == NOT_REFEFERENCE_PROP) {
            return null;
        } else {
            return result;
        }
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public boolean isTypeId() {
        Boolean b = (Boolean) fromMemberAnnotations(new WithMember<Boolean>() { // from class: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.3
            @Override // com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.WithMember
            public Boolean withMember(AnnotatedMember member) {
                return POJOPropertyBuilder.this._annotationIntrospector.isTypeId(member);
            }
        });
        return b != null && b.booleanValue();
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public ObjectIdInfo findObjectIdInfo() {
        return (ObjectIdInfo) fromMemberAnnotations(new WithMember<ObjectIdInfo>() { // from class: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.4
            @Override // com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.WithMember
            public ObjectIdInfo withMember(AnnotatedMember member) {
                ObjectIdInfo info = POJOPropertyBuilder.this._annotationIntrospector.findObjectIdInfo(member);
                if (info != null) {
                    info = POJOPropertyBuilder.this._annotationIntrospector.findObjectReferenceInfo(member, info);
                }
                return info;
            }
        });
    }

    @Override // com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition
    public JsonInclude.Value findInclusion() {
        JsonInclude.Value v = this._annotationIntrospector == null ? null : this._annotationIntrospector.findPropertyInclusion(getAccessor());
        return v == null ? JsonInclude.Value.empty() : v;
    }

    public JsonProperty.Access findAccess() {
        return (JsonProperty.Access) fromMemberAnnotationsExcept(new WithMember<JsonProperty.Access>() { // from class: com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.5
            @Override // com.fasterxml.jackson.databind.introspect.POJOPropertyBuilder.WithMember
            public JsonProperty.Access withMember(AnnotatedMember member) {
                return POJOPropertyBuilder.this._annotationIntrospector.findPropertyAccess(member);
            }
        }, JsonProperty.Access.AUTO);
    }

    public void addField(AnnotatedField a, PropertyName name, boolean explName, boolean visible, boolean ignored) {
        this._fields = new Linked<>(a, this._fields, name, explName, visible, ignored);
    }

    public void addCtor(AnnotatedParameter a, PropertyName name, boolean explName, boolean visible, boolean ignored) {
        this._ctorParameters = new Linked<>(a, this._ctorParameters, name, explName, visible, ignored);
    }

    public void addGetter(AnnotatedMethod a, PropertyName name, boolean explName, boolean visible, boolean ignored) {
        this._getters = new Linked<>(a, this._getters, name, explName, visible, ignored);
    }

    public void addSetter(AnnotatedMethod a, PropertyName name, boolean explName, boolean visible, boolean ignored) {
        this._setters = new Linked<>(a, this._setters, name, explName, visible, ignored);
    }

    public void addAll(POJOPropertyBuilder src) {
        this._fields = merge(this._fields, src._fields);
        this._ctorParameters = merge(this._ctorParameters, src._ctorParameters);
        this._getters = merge(this._getters, src._getters);
        this._setters = merge(this._setters, src._setters);
    }

    private static <T> Linked<T> merge(Linked<T> chain1, Linked<T> chain2) {
        if (chain1 == null) {
            return chain2;
        }
        if (chain2 == null) {
            return chain1;
        }
        return chain1.append(chain2);
    }

    public void removeIgnored() {
        this._fields = _removeIgnored(this._fields);
        this._getters = _removeIgnored(this._getters);
        this._setters = _removeIgnored(this._setters);
        this._ctorParameters = _removeIgnored(this._ctorParameters);
    }

    @Deprecated
    public JsonProperty.Access removeNonVisible(boolean inferMutators) {
        return removeNonVisible(inferMutators, null);
    }

    public JsonProperty.Access removeNonVisible(boolean inferMutators, POJOPropertiesCollector parent) {
        JsonProperty.Access acc = findAccess();
        if (acc == null) {
            acc = JsonProperty.Access.AUTO;
        }
        switch (acc) {
            case READ_ONLY:
                if (parent != null) {
                    parent._collectIgnorals(getName());
                    for (PropertyName pn : findExplicitNames()) {
                        parent._collectIgnorals(pn.getSimpleName());
                    }
                }
                this._setters = null;
                this._ctorParameters = null;
                if (!this._forSerialization) {
                    this._fields = null;
                    break;
                }
                break;
            case READ_WRITE:
                break;
            case WRITE_ONLY:
                this._getters = null;
                if (this._forSerialization) {
                    this._fields = null;
                    break;
                }
                break;
            case AUTO:
            default:
                this._getters = _removeNonVisible(this._getters);
                this._ctorParameters = _removeNonVisible(this._ctorParameters);
                if (!inferMutators || this._getters == null) {
                    this._fields = _removeNonVisible(this._fields);
                    this._setters = _removeNonVisible(this._setters);
                    break;
                }
                break;
        }
        return acc;
    }

    public void removeConstructors() {
        this._ctorParameters = null;
    }

    public void trimByVisibility() {
        this._fields = _trimByVisibility(this._fields);
        this._getters = _trimByVisibility(this._getters);
        this._setters = _trimByVisibility(this._setters);
        this._ctorParameters = _trimByVisibility(this._ctorParameters);
    }

    public void mergeAnnotations(boolean forSerialization) {
        if (forSerialization) {
            if (this._getters != null) {
                this._getters = _applyAnnotations(this._getters, _mergeAnnotations(0, this._getters, this._fields, this._ctorParameters, this._setters));
            } else if (this._fields != null) {
                this._fields = _applyAnnotations(this._fields, _mergeAnnotations(0, this._fields, this._ctorParameters, this._setters));
            }
        } else if (this._ctorParameters != null) {
            this._ctorParameters = _applyAnnotations(this._ctorParameters, _mergeAnnotations(0, this._ctorParameters, this._setters, this._fields, this._getters));
        } else if (this._setters != null) {
            this._setters = _applyAnnotations(this._setters, _mergeAnnotations(0, this._setters, this._fields, this._getters));
        } else if (this._fields != null) {
            this._fields = _applyAnnotations(this._fields, _mergeAnnotations(0, this._fields, this._getters));
        }
    }

    private AnnotationMap _mergeAnnotations(int index, Linked<? extends AnnotatedMember>... nodes) {
        AnnotationMap ann = _getAllAnnotations(nodes[index]);
        do {
            index++;
            if (index >= nodes.length) {
                return ann;
            }
        } while (nodes[index] == null);
        return AnnotationMap.merge(ann, _mergeAnnotations(index, nodes));
    }

    private <T extends AnnotatedMember> AnnotationMap _getAllAnnotations(Linked<T> node) {
        AnnotationMap ann = node.value.getAllAnnotations();
        if (node.next != null) {
            ann = AnnotationMap.merge(ann, _getAllAnnotations(node.next));
        }
        return ann;
    }

    private <T extends AnnotatedMember> Linked<T> _applyAnnotations(Linked<T> node, AnnotationMap ann) {
        AnnotatedMember annotatedMember = (AnnotatedMember) node.value.withAnnotations(ann);
        Linked<T> linked = node.next;
        Linked linked2 = node;
        if (linked != null) {
            linked2 = node.withNext(_applyAnnotations(node.next, ann));
        }
        return linked2.withValue(annotatedMember);
    }

    private <T> Linked<T> _removeIgnored(Linked<T> node) {
        if (node == null) {
            return node;
        }
        return node.withoutIgnored();
    }

    private <T> Linked<T> _removeNonVisible(Linked<T> node) {
        if (node == null) {
            return node;
        }
        return node.withoutNonVisible();
    }

    private <T> Linked<T> _trimByVisibility(Linked<T> node) {
        if (node == null) {
            return node;
        }
        return node.trimByVisibility();
    }

    private <T> boolean _anyExplicits(Linked<T> n) {
        while (n != null) {
            if (n.name != null && n.name.hasSimpleName()) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    private <T> boolean _anyExplicitNames(Linked<T> n) {
        while (n != null) {
            if (n.name != null && n.isNameExplicit) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    public boolean anyVisible() {
        return _anyVisible(this._fields) || _anyVisible(this._getters) || _anyVisible(this._setters) || _anyVisible(this._ctorParameters);
    }

    private <T> boolean _anyVisible(Linked<T> n) {
        while (n != null) {
            if (n.isVisible) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    public boolean anyIgnorals() {
        return _anyIgnorals(this._fields) || _anyIgnorals(this._getters) || _anyIgnorals(this._setters) || _anyIgnorals(this._ctorParameters);
    }

    private <T> boolean _anyIgnorals(Linked<T> n) {
        while (n != null) {
            if (n.isMarkedIgnored) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    public Set<PropertyName> findExplicitNames() {
        Set<PropertyName> renamed = _findExplicitNames(this._ctorParameters, _findExplicitNames(this._setters, _findExplicitNames(this._getters, _findExplicitNames(this._fields, null))));
        if (renamed == null) {
            return Collections.emptySet();
        }
        return renamed;
    }

    public Collection<POJOPropertyBuilder> explode(Collection<PropertyName> newNames) {
        HashMap<PropertyName, POJOPropertyBuilder> props = new HashMap<>();
        _explode(newNames, props, this._fields);
        _explode(newNames, props, this._getters);
        _explode(newNames, props, this._setters);
        _explode(newNames, props, this._ctorParameters);
        return props.values();
    }

    private void _explode(Collection<PropertyName> newNames, Map<PropertyName, POJOPropertyBuilder> props, Linked<?> accessors) {
        for (Linked linked = accessors; linked != null; linked = linked.next) {
            PropertyName name = linked.name;
            if (linked.isNameExplicit && name != null) {
                POJOPropertyBuilder prop = props.get(name);
                if (prop == null) {
                    prop = new POJOPropertyBuilder(this._config, this._annotationIntrospector, this._forSerialization, this._internalName, name);
                    props.put(name, prop);
                }
                if (accessors == this._fields) {
                    prop._fields = linked.withNext(prop._fields);
                } else if (accessors == this._getters) {
                    prop._getters = linked.withNext(prop._getters);
                } else if (accessors == this._setters) {
                    prop._setters = linked.withNext(prop._setters);
                } else if (accessors == this._ctorParameters) {
                    prop._ctorParameters = linked.withNext(prop._ctorParameters);
                } else {
                    throw new IllegalStateException("Internal error: mismatched accessors, property: " + this);
                }
            } else if (linked.isVisible) {
                throw new IllegalStateException("Conflicting/ambiguous property name definitions (implicit name " + ClassUtil.name(this._name) + "): found multiple explicit names: " + newNames + ", but also implicit accessor: " + linked);
            }
        }
    }

    private Set<PropertyName> _findExplicitNames(Linked<? extends AnnotatedMember> node, Set<PropertyName> renamed) {
        while (node != null) {
            if (node.isNameExplicit && node.name != null) {
                if (renamed == null) {
                    renamed = new HashSet();
                }
                renamed.add(node.name);
            }
            node = node.next;
        }
        return renamed;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[Property '").append(this._name).append("'; ctors: ").append(this._ctorParameters).append(", field(s): ").append(this._fields).append(", getter(s): ").append(this._getters).append(", setter(s): ").append(this._setters);
        sb.append("]");
        return sb.toString();
    }

    protected <T> T fromMemberAnnotations(WithMember<T> func) {
        T result = null;
        if (this._annotationIntrospector != null) {
            if (!this._forSerialization) {
                if (this._ctorParameters != null) {
                    result = func.withMember(this._ctorParameters.value);
                }
                if (result == null && this._setters != null) {
                    result = func.withMember(this._setters.value);
                }
            } else if (this._getters != null) {
                result = func.withMember(this._getters.value);
            }
            if (result == null && this._fields != null) {
                result = func.withMember(this._fields.value);
            }
        }
        return result;
    }

    protected <T> T fromMemberAnnotationsExcept(WithMember<T> func, T defaultValue) {
        T result;
        T result2;
        T result3;
        T result4;
        T result5;
        T result6;
        T result7;
        T result8;
        if (this._annotationIntrospector == null) {
            return null;
        }
        if (this._forSerialization) {
            if (this._getters != null && (result8 = func.withMember(this._getters.value)) != null && result8 != defaultValue) {
                return result8;
            }
            if (this._fields != null && (result7 = func.withMember(this._fields.value)) != null && result7 != defaultValue) {
                return result7;
            }
            if (this._ctorParameters != null && (result6 = func.withMember(this._ctorParameters.value)) != null && result6 != defaultValue) {
                return result6;
            }
            if (this._setters == null || (result5 = func.withMember(this._setters.value)) == null || result5 == defaultValue) {
                return null;
            }
            return result5;
        } else if (this._ctorParameters != null && (result4 = func.withMember(this._ctorParameters.value)) != null && result4 != defaultValue) {
            return result4;
        } else {
            if (this._setters != null && (result3 = func.withMember(this._setters.value)) != null && result3 != defaultValue) {
                return result3;
            }
            if (this._fields != null && (result2 = func.withMember(this._fields.value)) != null && result2 != defaultValue) {
                return result2;
            }
            if (this._getters == null || (result = func.withMember(this._getters.value)) == null || result == defaultValue) {
                return null;
            }
            return result;
        }
    }

    protected Class<?> _rawTypeOf(AnnotatedMember m) {
        if (m instanceof AnnotatedMethod) {
            AnnotatedMethod meh = (AnnotatedMethod) m;
            if (meh.getParameterCount() > 0) {
                return meh.getParameterType(0).getRawClass();
            }
        }
        return m.getType().getRawClass();
    }

    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$MemberIterator.class */
    protected static class MemberIterator<T extends AnnotatedMember> implements Iterator<T> {
        private Linked<T> next;

        public MemberIterator(Linked<T> first) {
            this.next = first;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.next != null;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.next == null) {
                throw new NoSuchElementException();
            }
            T result = this.next.value;
            this.next = this.next.next;
            return result;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/introspect/POJOPropertyBuilder$Linked.class */
    public static final class Linked<T> {
        public final T value;
        public final Linked<T> next;
        public final PropertyName name;
        public final boolean isNameExplicit;
        public final boolean isVisible;
        public final boolean isMarkedIgnored;

        public Linked(T v, Linked<T> n, PropertyName name, boolean explName, boolean visible, boolean ignored) {
            this.value = v;
            this.next = n;
            this.name = (name == null || name.isEmpty()) ? null : name;
            if (explName) {
                if (this.name == null) {
                    throw new IllegalArgumentException("Cannot pass true for 'explName' if name is null/empty");
                } else if (!name.hasSimpleName()) {
                    explName = false;
                }
            }
            this.isNameExplicit = explName;
            this.isVisible = visible;
            this.isMarkedIgnored = ignored;
        }

        public Linked<T> withoutNext() {
            if (this.next == null) {
                return this;
            }
            return new Linked<>(this.value, null, this.name, this.isNameExplicit, this.isVisible, this.isMarkedIgnored);
        }

        public Linked<T> withValue(T newValue) {
            if (newValue == this.value) {
                return this;
            }
            return new Linked<>(newValue, this.next, this.name, this.isNameExplicit, this.isVisible, this.isMarkedIgnored);
        }

        public Linked<T> withNext(Linked<T> newNext) {
            if (newNext == this.next) {
                return this;
            }
            return new Linked<>(this.value, newNext, this.name, this.isNameExplicit, this.isVisible, this.isMarkedIgnored);
        }

        public Linked<T> withoutIgnored() {
            Linked<T> newNext;
            if (this.isMarkedIgnored) {
                if (this.next == null) {
                    return null;
                }
                return this.next.withoutIgnored();
            } else if (this.next == null || (newNext = this.next.withoutIgnored()) == this.next) {
                return this;
            } else {
                return withNext(newNext);
            }
        }

        public Linked<T> withoutNonVisible() {
            Linked<T> newNext = this.next == null ? null : this.next.withoutNonVisible();
            return this.isVisible ? withNext(newNext) : newNext;
        }

        protected Linked<T> append(Linked<T> appendable) {
            if (this.next == null) {
                return withNext(appendable);
            }
            return withNext(this.next.append(appendable));
        }

        public Linked<T> trimByVisibility() {
            if (this.next == null) {
                return this;
            }
            Linked<T> newNext = this.next.trimByVisibility();
            if (this.name != null) {
                if (newNext.name == null) {
                    return withNext(null);
                }
                return withNext(newNext);
            } else if (newNext.name != null) {
                return newNext;
            } else {
                if (this.isVisible == newNext.isVisible) {
                    return withNext(newNext);
                }
                return this.isVisible ? withNext(null) : newNext;
            }
        }

        public String toString() {
            String msg = String.format("%s[visible=%b,ignore=%b,explicitName=%b]", this.value.toString(), Boolean.valueOf(this.isVisible), Boolean.valueOf(this.isMarkedIgnored), Boolean.valueOf(this.isNameExplicit));
            if (this.next != null) {
                msg = msg + ", " + this.next.toString();
            }
            return msg;
        }
    }
}
