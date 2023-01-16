package com.fasterxml.jackson.databind.jdk14;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.introspect.AnnotatedConstructor;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/jdk14/JDK14Util.class */
public class JDK14Util {
    public static String[] getRecordFieldNames(Class<?> recordType) {
        return RecordAccessor.instance().getRecordFieldNames(recordType);
    }

    public static AnnotatedConstructor findRecordConstructor(DeserializationContext ctxt, BeanDescription beanDesc, List<String> names) {
        return new CreatorLocator(ctxt, beanDesc).locate(names);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/jdk14/JDK14Util$RecordAccessor.class */
    public static class RecordAccessor {
        private final Method RECORD_GET_RECORD_COMPONENTS;
        private final Method RECORD_COMPONENT_GET_NAME;
        private final Method RECORD_COMPONENT_GET_TYPE;
        private static final RecordAccessor INSTANCE;
        private static final RuntimeException PROBLEM;

        static {
            RuntimeException prob = null;
            RecordAccessor inst = null;
            try {
                inst = new RecordAccessor();
            } catch (RuntimeException e) {
                prob = e;
            }
            INSTANCE = inst;
            PROBLEM = prob;
        }

        private RecordAccessor() throws RuntimeException {
            try {
                this.RECORD_GET_RECORD_COMPONENTS = Class.class.getMethod("getRecordComponents", new Class[0]);
                Class<?> c = Class.forName("java.lang.reflect.RecordComponent");
                this.RECORD_COMPONENT_GET_NAME = c.getMethod("getName", new Class[0]);
                this.RECORD_COMPONENT_GET_TYPE = c.getMethod("getType", new Class[0]);
            } catch (Exception e) {
                throw new RuntimeException(String.format("Failed to access Methods needed to support `java.lang.Record`: (%s) %s", e.getClass().getName(), e.getMessage()), e);
            }
        }

        public static RecordAccessor instance() {
            if (PROBLEM == null) {
                return INSTANCE;
            }
            throw PROBLEM;
        }

        public String[] getRecordFieldNames(Class<?> recordType) throws IllegalArgumentException {
            Object[] components = recordComponents(recordType);
            String[] names = new String[components.length];
            for (int i = 0; i < components.length; i++) {
                try {
                    names[i] = (String) this.RECORD_COMPONENT_GET_NAME.invoke(components[i], new Object[0]);
                } catch (Exception e) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i), Integer.valueOf(components.length), ClassUtil.nameOf(recordType)), e);
                }
            }
            return names;
        }

        public RawTypeName[] getRecordFields(Class<?> recordType) throws IllegalArgumentException {
            Object[] components = recordComponents(recordType);
            RawTypeName[] results = new RawTypeName[components.length];
            for (int i = 0; i < components.length; i++) {
                try {
                    try {
                        results[i] = new RawTypeName((Class) this.RECORD_COMPONENT_GET_TYPE.invoke(components[i], new Object[0]), (String) this.RECORD_COMPONENT_GET_NAME.invoke(components[i], new Object[0]));
                    } catch (Exception e) {
                        throw new IllegalArgumentException(String.format("Failed to access type of field #%d (of %d) of Record type %s", Integer.valueOf(i), Integer.valueOf(components.length), ClassUtil.nameOf(recordType)), e);
                    }
                } catch (Exception e2) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i), Integer.valueOf(components.length), ClassUtil.nameOf(recordType)), e2);
                }
            }
            return results;
        }

        protected Object[] recordComponents(Class<?> recordType) throws IllegalArgumentException {
            try {
                return (Object[]) this.RECORD_GET_RECORD_COMPONENTS.invoke(recordType, new Object[0]);
            } catch (Exception e) {
                throw new IllegalArgumentException("Failed to access RecordComponents of type " + ClassUtil.nameOf(recordType));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/jdk14/JDK14Util$RawTypeName.class */
    public static class RawTypeName {
        public final Class<?> rawType;
        public final String name;

        public RawTypeName(Class<?> rt, String n) {
            this.rawType = rt;
            this.name = n;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/jdk14/JDK14Util$CreatorLocator.class */
    public static class CreatorLocator {
        protected final BeanDescription _beanDesc;
        protected final DeserializationConfig _config;
        protected final AnnotationIntrospector _intr;
        protected final List<AnnotatedConstructor> _constructors;
        protected final AnnotatedConstructor _primaryConstructor;
        protected final RawTypeName[] _recordFields;

        CreatorLocator(DeserializationContext ctxt, BeanDescription beanDesc) {
            this._beanDesc = beanDesc;
            this._intr = ctxt.getAnnotationIntrospector();
            this._config = ctxt.getConfig();
            this._recordFields = RecordAccessor.instance().getRecordFields(beanDesc.getBeanClass());
            int argCount = this._recordFields.length;
            AnnotatedConstructor primary = null;
            if (argCount != 0) {
                this._constructors = beanDesc.getConstructors();
                Iterator<AnnotatedConstructor> it = this._constructors.iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AnnotatedConstructor ctor = it.next();
                    if (ctor.getParameterCount() == argCount) {
                        for (int i = 0; i < argCount; i++) {
                            if (!ctor.getRawParameterType(i).equals(this._recordFields[i].rawType)) {
                                break;
                            }
                        }
                        primary = ctor;
                        break loop0;
                    }
                }
            } else {
                primary = beanDesc.findDefaultConstructor();
                this._constructors = Collections.singletonList(primary);
            }
            if (primary == null) {
                throw new IllegalArgumentException("Failed to find the canonical Record constructor of type " + ClassUtil.getTypeDescription(this._beanDesc.getType()));
            }
            this._primaryConstructor = primary;
        }

        public AnnotatedConstructor locate(List<String> names) {
            for (AnnotatedConstructor ctor : this._constructors) {
                JsonCreator.Mode creatorMode = this._intr.findCreatorAnnotation(this._config, ctor);
                if (!(null == creatorMode || JsonCreator.Mode.DISABLED == creatorMode || (JsonCreator.Mode.DELEGATING != creatorMode && ctor == this._primaryConstructor))) {
                    return null;
                }
            }
            for (RawTypeName field : this._recordFields) {
                names.add(field.name);
            }
            return this._primaryConstructor;
        }
    }
}
