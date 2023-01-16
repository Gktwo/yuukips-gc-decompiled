package com.google.protobuf;

import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Descriptors;
import com.google.protobuf.Extension;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.LazyField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageReflection;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.jline.reader.LineReader;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage.class */
public abstract class GeneratedMessage extends AbstractMessage implements Serializable {
    private static final long serialVersionUID = 1;
    protected static boolean alwaysUseFieldBuilders = false;
    protected UnknownFieldSet unknownFields;

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$BuilderParent.class */
    public interface BuilderParent extends AbstractMessage.BuilderParent {
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$ExtendableMessageOrBuilder.class */
    public interface ExtendableMessageOrBuilder<MessageType extends ExtendableMessage> extends MessageOrBuilder {
        @Override // com.google.protobuf.MessageOrBuilder
        Message getDefaultInstanceForType();

        <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite);

        <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite);

        <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite);

        <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int i);

        <Type> boolean hasExtension(Extension<MessageType, Type> extension);

        <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> generatedExtension);

        <Type> int getExtensionCount(Extension<MessageType, List<Type>> extension);

        <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> generatedExtension);

        <Type> Type getExtension(Extension<MessageType, Type> extension);

        <Type> Type getExtension(GeneratedExtension<MessageType, Type> generatedExtension);

        <Type> Type getExtension(Extension<MessageType, List<Type>> extension, int i);

        <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> generatedExtension, int i);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$ExtensionDescriptorRetriever.class */
    public interface ExtensionDescriptorRetriever {
        Descriptors.FieldDescriptor getDescriptor();
    }

    protected abstract FieldAccessorTable internalGetFieldAccessorTable();

    /* access modifiers changed from: protected */
    public abstract Message.Builder newBuilderForType(BuilderParent builderParent);

    protected GeneratedMessage() {
        this.unknownFields = UnknownFieldSet.getDefaultInstance();
    }

    protected GeneratedMessage(Builder<?> builder) {
        this.unknownFields = builder.getUnknownFields();
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<? extends GeneratedMessage> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    static void enableAlwaysUseFieldBuildersForTesting() {
        alwaysUseFieldBuilders = true;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Descriptors.Descriptor getDescriptorForType() {
        return internalGetFieldAccessorTable().descriptor;
    }

    /* access modifiers changed from: private */
    public Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable(boolean getBytesForString) {
        TreeMap<Descriptors.FieldDescriptor, Object> result = new TreeMap<>();
        List<Descriptors.FieldDescriptor> fields = internalGetFieldAccessorTable().descriptor.getFields();
        int i = 0;
        while (i < fields.size()) {
            Descriptors.FieldDescriptor field = fields.get(i);
            Descriptors.OneofDescriptor oneofDescriptor = field.getContainingOneof();
            if (oneofDescriptor != null) {
                i += oneofDescriptor.getFieldCount() - 1;
                if (!hasOneof(oneofDescriptor)) {
                    i++;
                } else {
                    field = getOneofFieldDescriptor(oneofDescriptor);
                    if (getBytesForString || field.getJavaType() != Descriptors.FieldDescriptor.JavaType.STRING) {
                        result.put(field, getField(field));
                    } else {
                        result.put(field, getFieldRaw(field));
                    }
                    i++;
                }
            } else {
                if (field.isRepeated()) {
                    List<?> value = (List) getField(field);
                    if (!value.isEmpty()) {
                        result.put(field, value);
                    }
                } else {
                    if (!hasField(field)) {
                    }
                    if (getBytesForString) {
                    }
                    result.put(field, getField(field));
                }
                i++;
            }
        }
        return result;
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
    public boolean isInitialized() {
        for (Descriptors.FieldDescriptor field : getDescriptorForType().getFields()) {
            if (field.isRequired() && !hasField(field)) {
                return false;
            }
            if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                if (field.isRepeated()) {
                    for (Message element : (List) getField(field)) {
                        if (!element.isInitialized()) {
                            return false;
                        }
                    }
                    continue;
                } else if (hasField(field) && !((Message) getField(field)).isInitialized()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
        return Collections.unmodifiableMap(getAllFieldsMutable(false));
    }

    Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
        return Collections.unmodifiableMap(getAllFieldsMutable(true));
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public boolean hasOneof(Descriptors.OneofDescriptor oneof) {
        return internalGetFieldAccessorTable().getOneof(oneof).has(this);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageOrBuilder
    public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneof) {
        return internalGetFieldAccessorTable().getOneof(oneof).get(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public boolean hasField(Descriptors.FieldDescriptor field) {
        return internalGetFieldAccessorTable().getField(field).has(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getField(Descriptors.FieldDescriptor field) {
        return internalGetFieldAccessorTable().getField(field).get(this);
    }

    Object getFieldRaw(Descriptors.FieldDescriptor field) {
        return internalGetFieldAccessorTable().getField(field).getRaw(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public int getRepeatedFieldCount(Descriptors.FieldDescriptor field) {
        return internalGetFieldAccessorTable().getField(field).getRepeatedCount(this);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public Object getRepeatedField(Descriptors.FieldDescriptor field, int index) {
        return internalGetFieldAccessorTable().getField(field).getRepeated(this, index);
    }

    @Override // com.google.protobuf.MessageOrBuilder
    public UnknownFieldSet getUnknownFields() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    protected boolean parseUnknownField(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
        return unknownFields.mergeFieldFrom(tag, input);
    }

    protected static <M extends Message> M parseWithIOException(Parser<M> parser, InputStream input) throws IOException {
        try {
            return parser.parseFrom(input);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    protected static <M extends Message> M parseWithIOException(Parser<M> parser, InputStream input, ExtensionRegistryLite extensions) throws IOException {
        try {
            return parser.parseFrom(input, extensions);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    protected static <M extends Message> M parseWithIOException(Parser<M> parser, CodedInputStream input) throws IOException {
        try {
            return parser.parseFrom(input);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    protected static <M extends Message> M parseWithIOException(Parser<M> parser, CodedInputStream input, ExtensionRegistryLite extensions) throws IOException {
        try {
            return parser.parseFrom(input, extensions);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    protected static <M extends Message> M parseDelimitedWithIOException(Parser<M> parser, InputStream input) throws IOException {
        try {
            return parser.parseDelimitedFrom(input);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    protected static <M extends Message> M parseDelimitedWithIOException(Parser<M> parser, InputStream input, ExtensionRegistryLite extensions) throws IOException {
        try {
            return parser.parseDelimitedFrom(input, extensions);
        } catch (InvalidProtocolBufferException e) {
            throw e.unwrapIOException();
        }
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream output) throws IOException {
        MessageReflection.writeMessageTo(this, getAllFieldsRaw(), output, false);
    }

    @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int size = this.memoizedSize;
        if (size != -1) {
            return size;
        }
        this.memoizedSize = MessageReflection.getSerializedSize(this, getAllFieldsRaw());
        return this.memoizedSize;
    }

    protected void makeExtensionsImmutable() {
    }

    /* access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Message.Builder newBuilderForType(final AbstractMessage.BuilderParent parent) {
        return newBuilderForType((BuilderParent) new BuilderParent() { // from class: com.google.protobuf.GeneratedMessage.1
            @Override // com.google.protobuf.AbstractMessage.BuilderParent
            public void markDirty() {
                parent.markDirty();
            }
        });
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$Builder.class */
    public static abstract class Builder<BuilderType extends Builder<BuilderType>> extends AbstractMessage.Builder<BuilderType> {
        private BuilderParent builderParent;
        private Builder<BuilderType>.BuilderParentImpl meAsParent;
        private boolean isClean;
        private UnknownFieldSet unknownFields;

        protected abstract FieldAccessorTable internalGetFieldAccessorTable();

        protected Builder() {
            this(null);
        }

        protected Builder(BuilderParent builderParent) {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            this.builderParent = builderParent;
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.protobuf.AbstractMessage.Builder
        public void dispose() {
            this.builderParent = null;
        }

        protected void onBuilt() {
            if (this.builderParent != null) {
                markClean();
            }
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.AbstractMessage.Builder
        public void markClean() {
            this.isClean = true;
        }

        protected boolean isClean() {
            return this.isClean;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, java.lang.Object, com.google.protobuf.Message.Builder
        public BuilderType clone() {
            BuilderType builder = (BuilderType) ((Builder) getDefaultInstanceForType().newBuilderForType());
            builder.mergeFrom(buildPartial());
            return builder;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            this.unknownFields = UnknownFieldSet.getDefaultInstance();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return internalGetFieldAccessorTable().descriptor;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            return Collections.unmodifiableMap(getAllFieldsMutable());
        }

        /* access modifiers changed from: private */
        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsMutable() {
            TreeMap<Descriptors.FieldDescriptor, Object> result = new TreeMap<>();
            List<Descriptors.FieldDescriptor> fields = internalGetFieldAccessorTable().descriptor.getFields();
            int i = 0;
            while (i < fields.size()) {
                Descriptors.FieldDescriptor field = fields.get(i);
                Descriptors.OneofDescriptor oneofDescriptor = field.getContainingOneof();
                if (oneofDescriptor != null) {
                    i += oneofDescriptor.getFieldCount() - 1;
                    if (!hasOneof(oneofDescriptor)) {
                        i++;
                    } else {
                        field = getOneofFieldDescriptor(oneofDescriptor);
                        result.put(field, getField(field));
                        i++;
                    }
                } else {
                    if (field.isRepeated()) {
                        List<?> value = (List) getField(field);
                        if (!value.isEmpty()) {
                            result.put(field, value);
                        }
                    } else {
                        if (!hasField(field)) {
                        }
                        result.put(field, getField(field));
                    }
                    i++;
                }
            }
            return result;
        }

        @Override // com.google.protobuf.Message.Builder
        public Message.Builder newBuilderForField(Descriptors.FieldDescriptor field) {
            return internalGetFieldAccessorTable().getField(field).newBuilder();
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getFieldBuilder(Descriptors.FieldDescriptor field) {
            return internalGetFieldAccessorTable().getField(field).getBuilder(this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public Message.Builder getRepeatedFieldBuilder(Descriptors.FieldDescriptor field, int index) {
            return internalGetFieldAccessorTable().getField(field).getRepeatedBuilder(this, index);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasOneof(Descriptors.OneofDescriptor oneof) {
            return internalGetFieldAccessorTable().getOneof(oneof).has(this);
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.FieldDescriptor getOneofFieldDescriptor(Descriptors.OneofDescriptor oneof) {
            return internalGetFieldAccessorTable().getOneof(oneof).get(this);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor field) {
            return internalGetFieldAccessorTable().getField(field).has(this);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor field) {
            Object object = internalGetFieldAccessorTable().getField(field).get(this);
            if (field.isRepeated()) {
                return Collections.unmodifiableList((List) object);
            }
            return object;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType setField(Descriptors.FieldDescriptor field, Object value) {
            internalGetFieldAccessorTable().getField(field).set(this, value);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType clearField(Descriptors.FieldDescriptor field) {
            internalGetFieldAccessorTable().getField(field).clear(this);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType clearOneof(Descriptors.OneofDescriptor oneof) {
            internalGetFieldAccessorTable().getOneof(oneof).clear(this);
            return this;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor field) {
            return internalGetFieldAccessorTable().getField(field).getRepeatedCount(this);
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor field, int index) {
            return internalGetFieldAccessorTable().getField(field).getRepeated(this, index);
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
            internalGetFieldAccessorTable().getField(field).setRepeated(this, index, value);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
            internalGetFieldAccessorTable().getField(field).addRepeated(this, value);
            return this;
        }

        @Override // com.google.protobuf.Message.Builder
        public BuilderType setUnknownFields(UnknownFieldSet unknownFields) {
            this.unknownFields = unknownFields;
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType mergeUnknownFields(UnknownFieldSet unknownFields) {
            this.unknownFields = UnknownFieldSet.newBuilder(this.unknownFields).mergeFrom(unknownFields).build();
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            for (Descriptors.FieldDescriptor field : getDescriptorForType().getFields()) {
                if (field.isRequired() && !hasField(field)) {
                    return false;
                }
                if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                    if (field.isRepeated()) {
                        for (Message element : (List) getField(field)) {
                            if (!element.isInitialized()) {
                                return false;
                            }
                        }
                        continue;
                    } else if (hasField(field) && !((Message) getField(field)).isInitialized()) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override // com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        protected boolean parseUnknownField(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            return unknownFields.mergeFieldFrom(tag, input);
        }

        /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$Builder$BuilderParentImpl.class */
        private class BuilderParentImpl implements BuilderParent {
            private BuilderParentImpl() {
            }

            @Override // com.google.protobuf.AbstractMessage.BuilderParent
            public void markDirty() {
                Builder.this.onChanged();
            }
        }

        protected BuilderParent getParentForChildren() {
            if (this.meAsParent == null) {
                this.meAsParent = new BuilderParentImpl();
            }
            return this.meAsParent;
        }

        protected final void onChanged() {
            if (this.isClean && this.builderParent != null) {
                this.builderParent.markDirty();
                this.isClean = false;
            }
        }

        protected MapField internalGetMapField(int fieldNumber) {
            throw new RuntimeException("No map fields found in " + getClass().getName());
        }

        protected MapField internalGetMutableMapField(int fieldNumber) {
            throw new RuntimeException("No map fields found in " + getClass().getName());
        }
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$ExtendableMessage.class */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage> extends GeneratedMessage implements ExtendableMessageOrBuilder<MessageType> {
        private static final long serialVersionUID = 1;
        private final FieldSet<Descriptors.FieldDescriptor> extensions;

        protected ExtendableMessage() {
            this.extensions = FieldSet.newFieldSet();
        }

        protected ExtendableMessage(ExtendableBuilder<MessageType, ?> builder) {
            super(builder);
            this.extensions = builder.buildExtensions();
        }

        private void verifyExtensionContainingType(Extension<MessageType, ?> extension) {
            if (extension.getDescriptor().getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("Extension is for type \"" + extension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            Extension<MessageType, ?> checkNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(checkNotLite);
            return this.extensions.hasField(checkNotLite.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            Extension<MessageType, List<Type>> extension = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extension);
            return this.extensions.getRepeatedFieldCount(extension.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            Extension<MessageType, ?> checkNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(checkNotLite);
            Descriptors.FieldDescriptor descriptor = checkNotLite.getDescriptor();
            Object value = this.extensions.getField(descriptor);
            if (value != null) {
                return (Type) checkNotLite.fromReflectionType(value);
            }
            if (descriptor.isRepeated()) {
                return (Type) Collections.emptyList();
            }
            if (descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return (Type) checkNotLite.getMessageDefaultInstance();
            }
            return (Type) checkNotLite.fromReflectionType(descriptor.getDefaultValue());
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int index) {
            Extension<MessageType, List<Type>> extension = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extension);
            return (Type) extension.singularFromReflectionType(this.extensions.getRepeatedField(extension.getDescriptor(), index));
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(Extension<MessageType, Type> extension) {
            return hasExtension((ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> extension) {
            return hasExtension((ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(Extension<MessageType, List<Type>> extension) {
            return getExtensionCount((ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> extension) {
            return getExtensionCount((ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(Extension<MessageType, Type> extension) {
            return (Type) getExtension((ExtensionLite<MessageType, Object>) extension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> extension) {
            return (Type) getExtension((ExtensionLite<MessageType, Object>) extension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(Extension<MessageType, List<Type>> extension, int index) {
            return (Type) getExtension((ExtensionLite<MessageType, List<Object>>) extension, index);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> extension, int index) {
            return (Type) getExtension((ExtensionLite<MessageType, List<Object>>) extension, index);
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return isInitialized() && extensionsAreInitialized();
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected boolean parseUnknownField(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            return MessageReflection.mergeFieldFrom(input, unknownFields, extensionRegistry, getDescriptorForType(), new MessageReflection.ExtensionAdapter(this.extensions), tag);
        }

        @Override // com.google.protobuf.GeneratedMessage
        protected void makeExtensionsImmutable() {
            this.extensions.makeImmutable();
        }

        /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$ExtendableMessage$ExtensionWriter.class */
        protected class ExtensionWriter {
            private final Iterator<Map.Entry<Descriptors.FieldDescriptor, Object>> iter;
            private Map.Entry<Descriptors.FieldDescriptor, Object> next;
            private final boolean messageSetWireFormat;

            private ExtensionWriter(boolean messageSetWireFormat) {
                this.iter = ExtendableMessage.this.extensions.iterator();
                if (this.iter.hasNext()) {
                    this.next = this.iter.next();
                }
                this.messageSetWireFormat = messageSetWireFormat;
            }

            public void writeUntil(int end, CodedOutputStream output) throws IOException {
                while (this.next != null && this.next.getKey().getNumber() < end) {
                    Descriptors.FieldDescriptor descriptor = this.next.getKey();
                    if (!this.messageSetWireFormat || descriptor.getLiteJavaType() != WireFormat.JavaType.MESSAGE || descriptor.isRepeated()) {
                        FieldSet.writeField(descriptor, this.next.getValue(), output);
                    } else if (this.next instanceof LazyField.LazyEntry) {
                        output.writeRawMessageSetExtension(descriptor.getNumber(), ((LazyField.LazyEntry) this.next).getField().toByteString());
                    } else {
                        output.writeMessageSetExtension(descriptor.getNumber(), (Message) this.next.getValue());
                    }
                    if (this.iter.hasNext()) {
                        this.next = this.iter.next();
                    } else {
                        this.next = null;
                    }
                }
            }
        }

        protected ExtendableMessage<MessageType>.ExtensionWriter newExtensionWriter() {
            return new ExtensionWriter(false);
        }

        protected ExtendableMessage<MessageType>.ExtensionWriter newMessageSetExtensionWriter() {
            return new ExtensionWriter(true);
        }

        protected int extensionsSerializedSize() {
            return this.extensions.getSerializedSize();
        }

        protected int extensionsSerializedSizeAsMessageSet() {
            return this.extensions.getMessageSetSerializedSize();
        }

        protected Map<Descriptors.FieldDescriptor, Object> getExtensionFields() {
            return this.extensions.getAllFields();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map<Descriptors.FieldDescriptor, Object> result = getAllFieldsMutable(false);
            result.putAll(getExtensionFields());
            return Collections.unmodifiableMap(result);
        }

        @Override // com.google.protobuf.GeneratedMessage
        public Map<Descriptors.FieldDescriptor, Object> getAllFieldsRaw() {
            Map<Descriptors.FieldDescriptor, Object> result = getAllFieldsMutable(false);
            result.putAll(getExtensionFields());
            return Collections.unmodifiableMap(result);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor field) {
            if (!field.isExtension()) {
                return hasField(field);
            }
            verifyContainingType(field);
            return this.extensions.hasField(field);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor field) {
            if (!field.isExtension()) {
                return getField(field);
            }
            verifyContainingType(field);
            Object value = this.extensions.getField(field);
            if (value != null) {
                return value;
            }
            if (field.isRepeated()) {
                return Collections.emptyList();
            }
            if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return DynamicMessage.getDefaultInstance(field.getMessageType());
            }
            return field.getDefaultValue();
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor field) {
            if (!field.isExtension()) {
                return getRepeatedFieldCount(field);
            }
            verifyContainingType(field);
            return this.extensions.getRepeatedFieldCount(field);
        }

        @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor field, int index) {
            if (!field.isExtension()) {
                return getRepeatedField(field, index);
            }
            verifyContainingType(field);
            return this.extensions.getRepeatedField(field, index);
        }

        private void verifyContainingType(Descriptors.FieldDescriptor field) {
            if (field.getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$ExtendableBuilder.class */
    public static abstract class ExtendableBuilder<MessageType extends ExtendableMessage, BuilderType extends ExtendableBuilder<MessageType, BuilderType>> extends Builder<BuilderType> implements ExtendableMessageOrBuilder<MessageType> {
        private FieldSet<Descriptors.FieldDescriptor> extensions = FieldSet.emptySet();

        protected ExtendableBuilder() {
        }

        protected ExtendableBuilder(BuilderParent parent) {
            super(parent);
        }

        void internalSetExtensionSet(FieldSet<Descriptors.FieldDescriptor> extensions) {
            this.extensions = extensions;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public BuilderType clear() {
            this.extensions = FieldSet.emptySet();
            return (BuilderType) ((ExtendableBuilder) clear());
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, java.lang.Object, com.google.protobuf.Message.Builder
        public BuilderType clone() {
            return (BuilderType) ((ExtendableBuilder) clone());
        }

        private void ensureExtensionsIsMutable() {
            if (this.extensions.isImmutable()) {
                this.extensions = this.extensions.clone();
            }
        }

        private void verifyExtensionContainingType(Extension<MessageType, ?> extension) {
            if (extension.getDescriptor().getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("Extension is for type \"" + extension.getDescriptor().getContainingType().getFullName() + "\" which does not match message type \"" + getDescriptorForType().getFullName() + "\".");
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(ExtensionLite<MessageType, Type> extensionLite) {
            Extension<MessageType, ?> checkNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(checkNotLite);
            return this.extensions.hasField(checkNotLite.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(ExtensionLite<MessageType, List<Type>> extensionLite) {
            Extension<MessageType, List<Type>> extension = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extension);
            return this.extensions.getRepeatedFieldCount(extension.getDescriptor());
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, Type> extensionLite) {
            Extension<MessageType, ?> checkNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(checkNotLite);
            Descriptors.FieldDescriptor descriptor = checkNotLite.getDescriptor();
            Object value = this.extensions.getField(descriptor);
            if (value != null) {
                return (Type) checkNotLite.fromReflectionType(value);
            }
            if (descriptor.isRepeated()) {
                return (Type) Collections.emptyList();
            }
            if (descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return (Type) checkNotLite.getMessageDefaultInstance();
            }
            return (Type) checkNotLite.fromReflectionType(descriptor.getDefaultValue());
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int index) {
            Extension<MessageType, List<Type>> extension = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extension);
            return (Type) extension.singularFromReflectionType(this.extensions.getRepeatedField(extension.getDescriptor(), index));
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, Type> extensionLite, Type value) {
            Extension<MessageType, ?> checkNotLite = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(checkNotLite);
            ensureExtensionsIsMutable();
            this.extensions.setField(checkNotLite.getDescriptor(), checkNotLite.toReflectionType(value));
            onChanged();
            return this;
        }

        public final <Type> BuilderType setExtension(ExtensionLite<MessageType, List<Type>> extensionLite, int index, Type value) {
            Extension<MessageType, List<Type>> extension = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extension);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(extension.getDescriptor(), index, extension.singularToReflectionType(value));
            onChanged();
            return this;
        }

        public final <Type> BuilderType addExtension(ExtensionLite<MessageType, List<Type>> extensionLite, Type value) {
            Extension<MessageType, List<Type>> extension = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extension);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(extension.getDescriptor(), extension.singularToReflectionType(value));
            onChanged();
            return this;
        }

        public final <Type> BuilderType clearExtension(ExtensionLite<MessageType, ?> extensionLite) {
            Extension<MessageType, ?> extension = GeneratedMessage.checkNotLite(extensionLite);
            verifyExtensionContainingType(extension);
            ensureExtensionsIsMutable();
            this.extensions.clearField(extension.getDescriptor());
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(Extension<MessageType, Type> extension) {
            return hasExtension((ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> boolean hasExtension(GeneratedExtension<MessageType, Type> extension) {
            return hasExtension((ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(Extension<MessageType, List<Type>> extension) {
            return getExtensionCount((ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> int getExtensionCount(GeneratedExtension<MessageType, List<Type>> extension) {
            return getExtensionCount((ExtensionLite) extension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(Extension<MessageType, Type> extension) {
            return (Type) getExtension((ExtensionLite<MessageType, Object>) extension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, Type> extension) {
            return (Type) getExtension((ExtensionLite<MessageType, Object>) extension);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(Extension<MessageType, List<Type>> extension, int index) {
            return (Type) getExtension((ExtensionLite<MessageType, List<Object>>) extension, index);
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtendableMessageOrBuilder
        public final <Type> Type getExtension(GeneratedExtension<MessageType, List<Type>> extension, int index) {
            return (Type) getExtension((ExtensionLite<MessageType, List<Object>>) extension, index);
        }

        public final <Type> BuilderType setExtension(Extension<MessageType, Type> extension, Type value) {
            return setExtension(extension, (Extension<MessageType, Type>) value);
        }

        public <Type> BuilderType setExtension(GeneratedExtension<MessageType, Type> extension, Type value) {
            return setExtension((ExtensionLite<MessageType, GeneratedExtension<MessageType, Type>>) extension, (GeneratedExtension<MessageType, Type>) value);
        }

        public final <Type> BuilderType setExtension(Extension<MessageType, List<Type>> extension, int index, Type value) {
            return setExtension((ExtensionLite<MessageType, List<int>>) extension, index, (int) value);
        }

        public <Type> BuilderType setExtension(GeneratedExtension<MessageType, List<Type>> extension, int index, Type value) {
            return setExtension((ExtensionLite<MessageType, List<int>>) extension, index, (int) value);
        }

        public final <Type> BuilderType addExtension(Extension<MessageType, List<Type>> extension, Type value) {
            return addExtension(extension, (Extension<MessageType, List<Type>>) value);
        }

        public <Type> BuilderType addExtension(GeneratedExtension<MessageType, List<Type>> extension, Type value) {
            return addExtension((ExtensionLite<MessageType, List<GeneratedExtension<MessageType, List<Type>>>>) extension, (GeneratedExtension<MessageType, List<Type>>) value);
        }

        public final <Type> BuilderType clearExtension(Extension<MessageType, ?> extension) {
            return clearExtension((ExtensionLite) extension);
        }

        public <Type> BuilderType clearExtension(GeneratedExtension<MessageType, ?> extension) {
            return clearExtension((ExtensionLite) extension);
        }

        protected boolean extensionsAreInitialized() {
            return this.extensions.isInitialized();
        }

        /* access modifiers changed from: private */
        public FieldSet<Descriptors.FieldDescriptor> buildExtensions() {
            this.extensions.makeImmutable();
            return this.extensions;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageLiteOrBuilder
        public boolean isInitialized() {
            return isInitialized() && extensionsAreInitialized();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected boolean parseUnknownField(CodedInputStream input, UnknownFieldSet.Builder unknownFields, ExtensionRegistryLite extensionRegistry, int tag) throws IOException {
            return MessageReflection.mergeFieldFrom(input, unknownFields, extensionRegistry, getDescriptorForType(), new MessageReflection.BuilderAdapter(this), tag);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Map<Descriptors.FieldDescriptor, Object> getAllFields() {
            Map<Descriptors.FieldDescriptor, Object> result = getAllFieldsMutable();
            result.putAll(this.extensions.getAllFields());
            return Collections.unmodifiableMap(result);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Object getField(Descriptors.FieldDescriptor field) {
            if (!field.isExtension()) {
                return getField(field);
            }
            verifyContainingType(field);
            Object value = this.extensions.getField(field);
            if (value != null) {
                return value;
            }
            if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return DynamicMessage.getDefaultInstance(field.getMessageType());
            }
            return field.getDefaultValue();
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public int getRepeatedFieldCount(Descriptors.FieldDescriptor field) {
            if (!field.isExtension()) {
                return getRepeatedFieldCount(field);
            }
            verifyContainingType(field);
            return this.extensions.getRepeatedFieldCount(field);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public Object getRepeatedField(Descriptors.FieldDescriptor field, int index) {
            if (!field.isExtension()) {
                return getRepeatedField(field, index);
            }
            verifyContainingType(field);
            return this.extensions.getRepeatedField(field, index);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.MessageOrBuilder
        public boolean hasField(Descriptors.FieldDescriptor field) {
            if (!field.isExtension()) {
                return hasField(field);
            }
            verifyContainingType(field);
            return this.extensions.hasField(field);
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType setField(Descriptors.FieldDescriptor field, Object value) {
            if (!field.isExtension()) {
                return (BuilderType) ((ExtendableBuilder) setField(field, value));
            }
            verifyContainingType(field);
            ensureExtensionsIsMutable();
            this.extensions.setField(field, value);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType clearField(Descriptors.FieldDescriptor field) {
            if (!field.isExtension()) {
                return (BuilderType) ((ExtendableBuilder) clearField(field));
            }
            verifyContainingType(field);
            ensureExtensionsIsMutable();
            this.extensions.clearField(field);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
            if (!field.isExtension()) {
                return (BuilderType) ((ExtendableBuilder) setRepeatedField(field, index, value));
            }
            verifyContainingType(field);
            ensureExtensionsIsMutable();
            this.extensions.setRepeatedField(field, index, value);
            onChanged();
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder
        public BuilderType addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
            if (!field.isExtension()) {
                return (BuilderType) ((ExtendableBuilder) addRepeatedField(field, value));
            }
            verifyContainingType(field);
            ensureExtensionsIsMutable();
            this.extensions.addRepeatedField(field, value);
            onChanged();
            return this;
        }

        protected final void mergeExtensionFields(ExtendableMessage other) {
            ensureExtensionsIsMutable();
            this.extensions.mergeFrom(other.extensions);
            onChanged();
        }

        private void verifyContainingType(Descriptors.FieldDescriptor field) {
            if (field.getContainingType() != getDescriptorForType()) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            }
        }
    }

    public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newMessageScopedGeneratedExtension(final Message scope, final int descriptorIndex, Class singularType, Message defaultInstance) {
        return new GeneratedExtension<>(new CachedDescriptorRetriever() { // from class: com.google.protobuf.GeneratedMessage.2
            @Override // com.google.protobuf.GeneratedMessage.CachedDescriptorRetriever
            public Descriptors.FieldDescriptor loadDescriptor() {
                return scope.getDescriptorForType().getExtensions().get(descriptorIndex);
            }
        }, singularType, defaultInstance, Extension.ExtensionType.IMMUTABLE);
    }

    public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newFileScopedGeneratedExtension(Class singularType, Message defaultInstance) {
        return new GeneratedExtension<>(null, singularType, defaultInstance, Extension.ExtensionType.IMMUTABLE);
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$CachedDescriptorRetriever.class */
    private static abstract class CachedDescriptorRetriever implements ExtensionDescriptorRetriever {
        private volatile Descriptors.FieldDescriptor descriptor;

        protected abstract Descriptors.FieldDescriptor loadDescriptor();

        private CachedDescriptorRetriever() {
        }

        @Override // com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever
        public Descriptors.FieldDescriptor getDescriptor() {
            if (this.descriptor == null) {
                synchronized (this) {
                    if (this.descriptor == null) {
                        this.descriptor = loadDescriptor();
                    }
                }
            }
            return this.descriptor;
        }
    }

    public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newMessageScopedGeneratedExtension(final Message scope, final String name, Class singularType, Message defaultInstance) {
        return new GeneratedExtension<>(new CachedDescriptorRetriever() { // from class: com.google.protobuf.GeneratedMessage.3
            @Override // com.google.protobuf.GeneratedMessage.CachedDescriptorRetriever
            protected Descriptors.FieldDescriptor loadDescriptor() {
                return scope.getDescriptorForType().findFieldByName(name);
            }
        }, singularType, defaultInstance, Extension.ExtensionType.MUTABLE);
    }

    public static <ContainingType extends Message, Type> GeneratedExtension<ContainingType, Type> newFileScopedGeneratedExtension(final Class singularType, Message defaultInstance, final String descriptorOuterClass, final String extensionName) {
        return new GeneratedExtension<>(new CachedDescriptorRetriever() { // from class: com.google.protobuf.GeneratedMessage.4
            @Override // com.google.protobuf.GeneratedMessage.CachedDescriptorRetriever
            protected Descriptors.FieldDescriptor loadDescriptor() {
                try {
                    return ((Descriptors.FileDescriptor) singularType.getClassLoader().loadClass(descriptorOuterClass).getField("descriptor").get(null)).findExtensionByName(extensionName);
                } catch (Exception e) {
                    throw new RuntimeException("Cannot load descriptors: " + descriptorOuterClass + " is not a valid descriptor class name", e);
                }
            }
        }, singularType, defaultInstance, Extension.ExtensionType.MUTABLE);
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$GeneratedExtension.class */
    public static class GeneratedExtension<ContainingType extends Message, Type> extends Extension<ContainingType, Type> {
        private ExtensionDescriptorRetriever descriptorRetriever;
        private final Class singularType;
        private final Message messageDefaultInstance;
        private final Method enumValueOf;
        private final Method enumGetValueDescriptor;
        private final Extension.ExtensionType extensionType;

        GeneratedExtension(ExtensionDescriptorRetriever descriptorRetriever, Class singularType, Message messageDefaultInstance, Extension.ExtensionType extensionType) {
            if (!Message.class.isAssignableFrom(singularType) || singularType.isInstance(messageDefaultInstance)) {
                this.descriptorRetriever = descriptorRetriever;
                this.singularType = singularType;
                this.messageDefaultInstance = messageDefaultInstance;
                if (ProtocolMessageEnum.class.isAssignableFrom(singularType)) {
                    this.enumValueOf = GeneratedMessage.getMethodOrDie(singularType, CoreConstants.VALUE_OF, Descriptors.EnumValueDescriptor.class);
                    this.enumGetValueDescriptor = GeneratedMessage.getMethodOrDie(singularType, "getValueDescriptor", new Class[0]);
                } else {
                    this.enumValueOf = null;
                    this.enumGetValueDescriptor = null;
                }
                this.extensionType = extensionType;
                return;
            }
            throw new IllegalArgumentException("Bad messageDefaultInstance for " + singularType.getName());
        }

        public void internalInit(final Descriptors.FieldDescriptor descriptor) {
            if (this.descriptorRetriever != null) {
                throw new IllegalStateException("Already initialized.");
            }
            this.descriptorRetriever = new ExtensionDescriptorRetriever() { // from class: com.google.protobuf.GeneratedMessage.GeneratedExtension.1
                @Override // com.google.protobuf.GeneratedMessage.ExtensionDescriptorRetriever
                public Descriptors.FieldDescriptor getDescriptor() {
                    return descriptor;
                }
            };
        }

        @Override // com.google.protobuf.Extension
        public Descriptors.FieldDescriptor getDescriptor() {
            if (this.descriptorRetriever != null) {
                return this.descriptorRetriever.getDescriptor();
            }
            throw new IllegalStateException("getDescriptor() called before internalInit()");
        }

        @Override // com.google.protobuf.Extension, com.google.protobuf.ExtensionLite
        public Message getMessageDefaultInstance() {
            return this.messageDefaultInstance;
        }

        @Override // com.google.protobuf.Extension
        protected Extension.ExtensionType getExtensionType() {
            return this.extensionType;
        }

        @Override // com.google.protobuf.Extension
        protected Object fromReflectionType(Object value) {
            Descriptors.FieldDescriptor descriptor = getDescriptor();
            if (!descriptor.isRepeated()) {
                return singularFromReflectionType(value);
            }
            if (!(descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE || descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM)) {
                return value;
            }
            List result = new ArrayList();
            for (Object element : (List) value) {
                result.add(singularFromReflectionType(element));
            }
            return result;
        }

        @Override // com.google.protobuf.Extension
        protected Object singularFromReflectionType(Object value) {
            getDescriptor();
            switch (descriptor.getJavaType()) {
                case MESSAGE:
                    if (this.singularType.isInstance(value)) {
                        return value;
                    }
                    return this.messageDefaultInstance.newBuilderForType().mergeFrom((Message) value).build();
                case ENUM:
                    return GeneratedMessage.invokeOrDie(this.enumValueOf, null, (Descriptors.EnumValueDescriptor) value);
                default:
                    return value;
            }
        }

        @Override // com.google.protobuf.Extension
        protected Object toReflectionType(Object value) {
            Descriptors.FieldDescriptor descriptor = getDescriptor();
            if (!descriptor.isRepeated()) {
                return singularToReflectionType(value);
            }
            if (descriptor.getJavaType() != Descriptors.FieldDescriptor.JavaType.ENUM) {
                return value;
            }
            List result = new ArrayList();
            for (Object element : (List) value) {
                result.add(singularToReflectionType(element));
            }
            return result;
        }

        @Override // com.google.protobuf.Extension
        protected Object singularToReflectionType(Object value) {
            getDescriptor();
            switch (descriptor.getJavaType()) {
                case ENUM:
                    return GeneratedMessage.invokeOrDie(this.enumGetValueDescriptor, value, new Object[0]);
                default:
                    return value;
            }
        }

        @Override // com.google.protobuf.ExtensionLite
        public int getNumber() {
            return getDescriptor().getNumber();
        }

        @Override // com.google.protobuf.ExtensionLite
        public WireFormat.FieldType getLiteType() {
            return getDescriptor().getLiteType();
        }

        @Override // com.google.protobuf.ExtensionLite
        public boolean isRepeated() {
            return getDescriptor().isRepeated();
        }

        @Override // com.google.protobuf.ExtensionLite
        public Type getDefaultValue() {
            if (isRepeated()) {
                return (Type) Collections.emptyList();
            }
            if (getDescriptor().getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                return (Type) this.messageDefaultInstance;
            }
            return (Type) singularFromReflectionType(getDescriptor().getDefaultValue());
        }
    }

    /* access modifiers changed from: private */
    public static Method getMethodOrDie(Class clazz, String name, Class... params) {
        try {
            return clazz.getMethod(name, params);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("Generated message class \"" + clazz.getName() + "\" missing method \"" + name + "\".", e);
        }
    }

    /* access modifiers changed from: private */
    public static Object invokeOrDie(Method method, Object object, Object... params) {
        try {
            return method.invoke(object, params);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected MapField internalGetMapField(int fieldNumber) {
        throw new RuntimeException("No map fields found in " + getClass().getName());
    }

    /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$FieldAccessorTable.class */
    public static final class FieldAccessorTable {
        private final Descriptors.Descriptor descriptor;
        private final FieldAccessor[] fields;
        private String[] camelCaseNames;
        private final OneofAccessor[] oneofs;
        private volatile boolean initialized;

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$FieldAccessorTable$FieldAccessor.class */
        public interface FieldAccessor {
            Object get(GeneratedMessage generatedMessage);

            Object get(Builder builder);

            Object getRaw(GeneratedMessage generatedMessage);

            Object getRaw(Builder builder);

            void set(Builder builder, Object obj);

            Object getRepeated(GeneratedMessage generatedMessage, int i);

            Object getRepeated(Builder builder, int i);

            Object getRepeatedRaw(GeneratedMessage generatedMessage, int i);

            Object getRepeatedRaw(Builder builder, int i);

            void setRepeated(Builder builder, int i, Object obj);

            void addRepeated(Builder builder, Object obj);

            boolean has(GeneratedMessage generatedMessage);

            boolean has(Builder builder);

            int getRepeatedCount(GeneratedMessage generatedMessage);

            int getRepeatedCount(Builder builder);

            void clear(Builder builder);

            Message.Builder newBuilder();

            Message.Builder getBuilder(Builder builder);

            Message.Builder getRepeatedBuilder(Builder builder, int i);
        }

        public FieldAccessorTable(Descriptors.Descriptor descriptor, String[] camelCaseNames, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
            this(descriptor, camelCaseNames);
            ensureFieldAccessorsInitialized(messageClass, builderClass);
        }

        public FieldAccessorTable(Descriptors.Descriptor descriptor, String[] camelCaseNames) {
            this.descriptor = descriptor;
            this.camelCaseNames = camelCaseNames;
            this.fields = new FieldAccessor[descriptor.getFields().size()];
            this.oneofs = new OneofAccessor[descriptor.getOneofs().size()];
            this.initialized = false;
        }

        private boolean isMapFieldEnabled(Descriptors.FieldDescriptor field) {
            return true;
        }

        public FieldAccessorTable ensureFieldAccessorsInitialized(Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
            if (this.initialized) {
                return this;
            }
            synchronized (this) {
                if (this.initialized) {
                    return this;
                }
                int fieldsSize = this.fields.length;
                for (int i = 0; i < fieldsSize; i++) {
                    Descriptors.FieldDescriptor field = this.descriptor.getFields().get(i);
                    String containingOneofCamelCaseName = null;
                    if (field.getContainingOneof() != null) {
                        containingOneofCamelCaseName = this.camelCaseNames[fieldsSize + field.getContainingOneof().getIndex()];
                    }
                    if (field.isRepeated()) {
                        if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                            if (!field.isMapField() || !isMapFieldEnabled(field)) {
                                this.fields[i] = new RepeatedMessageFieldAccessor(field, this.camelCaseNames[i], messageClass, builderClass);
                            } else {
                                this.fields[i] = new MapFieldAccessor(field, this.camelCaseNames[i], messageClass, builderClass);
                            }
                        } else if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                            this.fields[i] = new RepeatedEnumFieldAccessor(field, this.camelCaseNames[i], messageClass, builderClass);
                        } else {
                            this.fields[i] = new RepeatedFieldAccessor(field, this.camelCaseNames[i], messageClass, builderClass);
                        }
                    } else if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
                        this.fields[i] = new SingularMessageFieldAccessor(field, this.camelCaseNames[i], messageClass, builderClass, containingOneofCamelCaseName);
                    } else if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.ENUM) {
                        this.fields[i] = new SingularEnumFieldAccessor(field, this.camelCaseNames[i], messageClass, builderClass, containingOneofCamelCaseName);
                    } else if (field.getJavaType() == Descriptors.FieldDescriptor.JavaType.STRING) {
                        this.fields[i] = new SingularStringFieldAccessor(field, this.camelCaseNames[i], messageClass, builderClass, containingOneofCamelCaseName);
                    } else {
                        this.fields[i] = new SingularFieldAccessor(field, this.camelCaseNames[i], messageClass, builderClass, containingOneofCamelCaseName);
                    }
                }
                int oneofsSize = this.oneofs.length;
                for (int i2 = 0; i2 < oneofsSize; i2++) {
                    this.oneofs[i2] = new OneofAccessor(this.descriptor, this.camelCaseNames[i2 + fieldsSize], messageClass, builderClass);
                }
                this.initialized = true;
                this.camelCaseNames = null;
                return this;
            }
        }

        /* access modifiers changed from: private */
        public FieldAccessor getField(Descriptors.FieldDescriptor field) {
            if (field.getContainingType() != this.descriptor) {
                throw new IllegalArgumentException("FieldDescriptor does not match message type.");
            } else if (!field.isExtension()) {
                return this.fields[field.getIndex()];
            } else {
                throw new IllegalArgumentException("This type does not have extensions.");
            }
        }

        /* access modifiers changed from: private */
        public OneofAccessor getOneof(Descriptors.OneofDescriptor oneof) {
            if (oneof.getContainingType() == this.descriptor) {
                return this.oneofs[oneof.getIndex()];
            }
            throw new IllegalArgumentException("OneofDescriptor does not match message type.");
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$FieldAccessorTable$OneofAccessor.class */
        public static class OneofAccessor {
            private final Descriptors.Descriptor descriptor;
            private final Method caseMethod;
            private final Method caseMethodBuilder;
            private final Method clearMethod;

            OneofAccessor(Descriptors.Descriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
                this.descriptor = descriptor;
                this.caseMethod = GeneratedMessage.getMethodOrDie(messageClass, BeanUtil.PREFIX_GETTER_GET + camelCaseName + "Case", new Class[0]);
                this.caseMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, BeanUtil.PREFIX_GETTER_GET + camelCaseName + "Case", new Class[0]);
                this.clearMethod = GeneratedMessage.getMethodOrDie(builderClass, LineReader.CLEAR + camelCaseName, new Class[0]);
            }

            public boolean has(GeneratedMessage message) {
                if (((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethod, message, new Object[0])).getNumber() == 0) {
                    return false;
                }
                return true;
            }

            public boolean has(Builder builder) {
                if (((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethodBuilder, builder, new Object[0])).getNumber() == 0) {
                    return false;
                }
                return true;
            }

            public Descriptors.FieldDescriptor get(GeneratedMessage message) {
                int fieldNumber = ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethod, message, new Object[0])).getNumber();
                if (fieldNumber > 0) {
                    return this.descriptor.findFieldByNumber(fieldNumber);
                }
                return null;
            }

            public Descriptors.FieldDescriptor get(Builder builder) {
                int fieldNumber = ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethodBuilder, builder, new Object[0])).getNumber();
                if (fieldNumber > 0) {
                    return this.descriptor.findFieldByNumber(fieldNumber);
                }
                return null;
            }

            public void clear(Builder builder) {
                GeneratedMessage.invokeOrDie(this.clearMethod, builder, new Object[0]);
            }
        }

        /* access modifiers changed from: private */
        public static boolean supportFieldPresence(Descriptors.FileDescriptor file) {
            return file.getSyntax() == Descriptors.FileDescriptor.Syntax.PROTO2;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$FieldAccessorTable$SingularFieldAccessor.class */
        public static class SingularFieldAccessor implements FieldAccessor {
            protected final Class<?> type;
            protected final Method getMethod;
            protected final Method getMethodBuilder;
            protected final Method setMethod;
            protected final Method hasMethod;
            protected final Method hasMethodBuilder;
            protected final Method clearMethod;
            protected final Method caseMethod;
            protected final Method caseMethodBuilder;
            protected final Descriptors.FieldDescriptor field;
            protected final boolean isOneofField;
            protected final boolean hasHasMethod;

            SingularFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass, String containingOneofCamelCaseName) {
                this.field = descriptor;
                this.isOneofField = descriptor.getContainingOneof() != null;
                this.hasHasMethod = FieldAccessorTable.supportFieldPresence(descriptor.getFile()) || (!this.isOneofField && descriptor.getJavaType() == Descriptors.FieldDescriptor.JavaType.MESSAGE);
                this.getMethod = GeneratedMessage.getMethodOrDie(messageClass, BeanUtil.PREFIX_GETTER_GET + camelCaseName, new Class[0]);
                this.getMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, BeanUtil.PREFIX_GETTER_GET + camelCaseName, new Class[0]);
                this.type = this.getMethod.getReturnType();
                this.setMethod = GeneratedMessage.getMethodOrDie(builderClass, "set" + camelCaseName, this.type);
                this.hasMethod = this.hasHasMethod ? GeneratedMessage.getMethodOrDie(messageClass, "has" + camelCaseName, new Class[0]) : null;
                this.hasMethodBuilder = this.hasHasMethod ? GeneratedMessage.getMethodOrDie(builderClass, "has" + camelCaseName, new Class[0]) : null;
                this.clearMethod = GeneratedMessage.getMethodOrDie(builderClass, LineReader.CLEAR + camelCaseName, new Class[0]);
                this.caseMethod = this.isOneofField ? GeneratedMessage.getMethodOrDie(messageClass, BeanUtil.PREFIX_GETTER_GET + containingOneofCamelCaseName + "Case", new Class[0]) : null;
                this.caseMethodBuilder = this.isOneofField ? GeneratedMessage.getMethodOrDie(builderClass, BeanUtil.PREFIX_GETTER_GET + containingOneofCamelCaseName + "Case", new Class[0]) : null;
            }

            private int getOneofFieldNumber(GeneratedMessage message) {
                return ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethod, message, new Object[0])).getNumber();
            }

            private int getOneofFieldNumber(Builder builder) {
                return ((Internal.EnumLite) GeneratedMessage.invokeOrDie(this.caseMethodBuilder, builder, new Object[0])).getNumber();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage message) {
                return GeneratedMessage.invokeOrDie(this.getMethod, message, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder builder) {
                return GeneratedMessage.invokeOrDie(this.getMethodBuilder, builder, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage message) {
                return get(message);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(Builder builder) {
                return get(builder);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder builder, Object value) {
                GeneratedMessage.invokeOrDie(this.setMethod, builder, value);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage message, int index) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeatedRaw(GeneratedMessage message, int index) {
                throw new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder builder, int index) {
                throw new UnsupportedOperationException("getRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeatedRaw(Builder builder, int index) {
                throw new UnsupportedOperationException("getRepeatedFieldRaw() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder builder, int index, Object value) {
                throw new UnsupportedOperationException("setRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder builder, Object value) {
                throw new UnsupportedOperationException("addRepeatedField() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage message) {
                if (!this.hasHasMethod) {
                    return this.isOneofField ? getOneofFieldNumber(message) == this.field.getNumber() : !get(message).equals(this.field.getDefaultValue());
                }
                return ((Boolean) GeneratedMessage.invokeOrDie(this.hasMethod, message, new Object[0])).booleanValue();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder builder) {
                if (!this.hasHasMethod) {
                    return this.isOneofField ? getOneofFieldNumber(builder) == this.field.getNumber() : !get(builder).equals(this.field.getDefaultValue());
                }
                return ((Boolean) GeneratedMessage.invokeOrDie(this.hasMethodBuilder, builder, new Object[0])).booleanValue();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage message) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder builder) {
                throw new UnsupportedOperationException("getRepeatedFieldSize() called on a singular field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder builder) {
                GeneratedMessage.invokeOrDie(this.clearMethod, builder, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder builder) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder builder, int index) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$FieldAccessorTable$RepeatedFieldAccessor.class */
        public static class RepeatedFieldAccessor implements FieldAccessor {
            protected final Class type;
            protected final Method getMethod;
            protected final Method getMethodBuilder;
            protected final Method getRepeatedMethod;
            protected final Method getRepeatedMethodBuilder;
            protected final Method setRepeatedMethod;
            protected final Method addRepeatedMethod;
            protected final Method getCountMethod;
            protected final Method getCountMethodBuilder;
            protected final Method clearMethod;

            RepeatedFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
                this.getMethod = GeneratedMessage.getMethodOrDie(messageClass, BeanUtil.PREFIX_GETTER_GET + camelCaseName + "List", new Class[0]);
                this.getMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, BeanUtil.PREFIX_GETTER_GET + camelCaseName + "List", new Class[0]);
                this.getRepeatedMethod = GeneratedMessage.getMethodOrDie(messageClass, BeanUtil.PREFIX_GETTER_GET + camelCaseName, Integer.TYPE);
                this.getRepeatedMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, BeanUtil.PREFIX_GETTER_GET + camelCaseName, Integer.TYPE);
                this.type = this.getRepeatedMethod.getReturnType();
                this.setRepeatedMethod = GeneratedMessage.getMethodOrDie(builderClass, "set" + camelCaseName, Integer.TYPE, this.type);
                this.addRepeatedMethod = GeneratedMessage.getMethodOrDie(builderClass, BeanUtil.PREFIX_ADDER + camelCaseName, this.type);
                this.getCountMethod = GeneratedMessage.getMethodOrDie(messageClass, BeanUtil.PREFIX_GETTER_GET + camelCaseName + "Count", new Class[0]);
                this.getCountMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, BeanUtil.PREFIX_GETTER_GET + camelCaseName + "Count", new Class[0]);
                this.clearMethod = GeneratedMessage.getMethodOrDie(builderClass, LineReader.CLEAR + camelCaseName, new Class[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage message) {
                return GeneratedMessage.invokeOrDie(this.getMethod, message, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder builder) {
                return GeneratedMessage.invokeOrDie(this.getMethodBuilder, builder, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage message) {
                return get(message);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(Builder builder) {
                return get(builder);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder builder, Object value) {
                clear(builder);
                for (Object element : (List) value) {
                    addRepeated(builder, element);
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage message, int index) {
                return GeneratedMessage.invokeOrDie(this.getRepeatedMethod, message, Integer.valueOf(index));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder builder, int index) {
                return GeneratedMessage.invokeOrDie(this.getRepeatedMethodBuilder, builder, Integer.valueOf(index));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeatedRaw(GeneratedMessage message, int index) {
                return getRepeated(message, index);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeatedRaw(Builder builder, int index) {
                return getRepeated(builder, index);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder builder, int index, Object value) {
                GeneratedMessage.invokeOrDie(this.setRepeatedMethod, builder, Integer.valueOf(index), value);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder builder, Object value) {
                GeneratedMessage.invokeOrDie(this.addRepeatedMethod, builder, value);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage message) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder builder) {
                throw new UnsupportedOperationException("hasField() called on a repeated field.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage message) {
                return ((Integer) GeneratedMessage.invokeOrDie(this.getCountMethod, message, new Object[0])).intValue();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder builder) {
                return ((Integer) GeneratedMessage.invokeOrDie(this.getCountMethodBuilder, builder, new Object[0])).intValue();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder builder) {
                GeneratedMessage.invokeOrDie(this.clearMethod, builder, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                throw new UnsupportedOperationException("newBuilderForField() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder builder) {
                throw new UnsupportedOperationException("getFieldBuilder() called on a non-Message type.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder builder, int index) {
                throw new UnsupportedOperationException("getRepeatedFieldBuilder() called on a non-Message type.");
            }
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$FieldAccessorTable$MapFieldAccessor.class */
        public static class MapFieldAccessor implements FieldAccessor {
            private final Descriptors.FieldDescriptor field;
            private final Message mapEntryMessageDefaultInstance;

            MapFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
                this.field = descriptor;
                this.mapEntryMessageDefaultInstance = getMapField((GeneratedMessage) GeneratedMessage.invokeOrDie(GeneratedMessage.getMethodOrDie(messageClass, "getDefaultInstance", new Class[0]), null, new Object[0])).getMapEntryMessageDefaultInstance();
            }

            private MapField<?, ?> getMapField(GeneratedMessage message) {
                return message.internalGetMapField(this.field.getNumber());
            }

            private MapField<?, ?> getMapField(Builder builder) {
                return builder.internalGetMapField(this.field.getNumber());
            }

            private MapField<?, ?> getMutableMapField(Builder builder) {
                return builder.internalGetMutableMapField(this.field.getNumber());
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage message) {
                List result = new ArrayList();
                for (int i = 0; i < getRepeatedCount(message); i++) {
                    result.add(getRepeated(message, i));
                }
                return Collections.unmodifiableList(result);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder builder) {
                List result = new ArrayList();
                for (int i = 0; i < getRepeatedCount(builder); i++) {
                    result.add(getRepeated(builder, i));
                }
                return Collections.unmodifiableList(result);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage message) {
                return get(message);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(Builder builder) {
                return get(builder);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder builder, Object value) {
                clear(builder);
                for (Object entry : (List) value) {
                    addRepeated(builder, entry);
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage message, int index) {
                return getMapField(message).getList().get(index);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder builder, int index) {
                return getMapField(builder).getList().get(index);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeatedRaw(GeneratedMessage message, int index) {
                return getRepeated(message, index);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeatedRaw(Builder builder, int index) {
                return getRepeated(builder, index);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder builder, int index, Object value) {
                getMutableMapField(builder).getMutableList().set(index, (Message) value);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder builder, Object value) {
                getMutableMapField(builder).getMutableList().add((Message) value);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(GeneratedMessage message) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public boolean has(Builder builder) {
                throw new UnsupportedOperationException("hasField() is not supported for repeated fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(GeneratedMessage message) {
                return getMapField(message).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public int getRepeatedCount(Builder builder) {
                return getMapField(builder).getList().size();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void clear(Builder builder) {
                getMutableMapField(builder).getMutableList().clear();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return this.mapEntryMessageDefaultInstance.newBuilderForType();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder builder) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder builder, int index) {
                throw new UnsupportedOperationException("Nested builder not supported for map fields.");
            }
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$FieldAccessorTable$SingularEnumFieldAccessor.class */
        public static final class SingularEnumFieldAccessor extends SingularFieldAccessor {
            private Descriptors.EnumDescriptor enumDescriptor;
            private Method valueOfMethod = GeneratedMessage.getMethodOrDie(this.type, CoreConstants.VALUE_OF, Descriptors.EnumValueDescriptor.class);
            private Method getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
            private boolean supportUnknownEnumValue;
            private Method getValueMethod;
            private Method getValueMethodBuilder;
            private Method setValueMethod;

            SingularEnumFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass, String containingOneofCamelCaseName) {
                super(descriptor, camelCaseName, messageClass, builderClass, containingOneofCamelCaseName);
                this.enumDescriptor = descriptor.getEnumType();
                this.supportUnknownEnumValue = descriptor.getFile().supportsUnknownEnumValue();
                if (this.supportUnknownEnumValue) {
                    this.getValueMethod = GeneratedMessage.getMethodOrDie(messageClass, BeanUtil.PREFIX_GETTER_GET + camelCaseName + "Value", new Class[0]);
                    this.getValueMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, BeanUtil.PREFIX_GETTER_GET + camelCaseName + "Value", new Class[0]);
                    this.setValueMethod = GeneratedMessage.getMethodOrDie(builderClass, "set" + camelCaseName + "Value", Integer.TYPE);
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage message) {
                if (!this.supportUnknownEnumValue) {
                    return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, get(message), new Object[0]);
                }
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.invokeOrDie(this.getValueMethod, message, new Object[0])).intValue());
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder builder) {
                if (!this.supportUnknownEnumValue) {
                    return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, get(builder), new Object[0]);
                }
                return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.invokeOrDie(this.getValueMethodBuilder, builder, new Object[0])).intValue());
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder builder, Object value) {
                if (this.supportUnknownEnumValue) {
                    GeneratedMessage.invokeOrDie(this.setValueMethod, builder, Integer.valueOf(((Descriptors.EnumValueDescriptor) value).getNumber()));
                } else {
                    set(builder, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, value));
                }
            }
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$FieldAccessorTable$RepeatedEnumFieldAccessor.class */
        public static final class RepeatedEnumFieldAccessor extends RepeatedFieldAccessor {
            private Descriptors.EnumDescriptor enumDescriptor;
            private final Method valueOfMethod = GeneratedMessage.getMethodOrDie(this.type, CoreConstants.VALUE_OF, Descriptors.EnumValueDescriptor.class);
            private final Method getValueDescriptorMethod = GeneratedMessage.getMethodOrDie(this.type, "getValueDescriptor", new Class[0]);
            private boolean supportUnknownEnumValue;
            private Method getRepeatedValueMethod;
            private Method getRepeatedValueMethodBuilder;
            private Method setRepeatedValueMethod;
            private Method addRepeatedValueMethod;

            RepeatedEnumFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
                super(descriptor, camelCaseName, messageClass, builderClass);
                this.enumDescriptor = descriptor.getEnumType();
                this.supportUnknownEnumValue = descriptor.getFile().supportsUnknownEnumValue();
                if (this.supportUnknownEnumValue) {
                    this.getRepeatedValueMethod = GeneratedMessage.getMethodOrDie(messageClass, BeanUtil.PREFIX_GETTER_GET + camelCaseName + "Value", Integer.TYPE);
                    this.getRepeatedValueMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, BeanUtil.PREFIX_GETTER_GET + camelCaseName + "Value", Integer.TYPE);
                    this.setRepeatedValueMethod = GeneratedMessage.getMethodOrDie(builderClass, "set" + camelCaseName + "Value", Integer.TYPE, Integer.TYPE);
                    this.addRepeatedValueMethod = GeneratedMessage.getMethodOrDie(builderClass, BeanUtil.PREFIX_ADDER + camelCaseName + "Value", Integer.TYPE);
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(GeneratedMessage message) {
                List newList = new ArrayList();
                int size = getRepeatedCount(message);
                for (int i = 0; i < size; i++) {
                    newList.add(getRepeated(message, i));
                }
                return Collections.unmodifiableList(newList);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object get(Builder builder) {
                List newList = new ArrayList();
                int size = getRepeatedCount(builder);
                for (int i = 0; i < size; i++) {
                    newList.add(getRepeated(builder, i));
                }
                return Collections.unmodifiableList(newList);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(GeneratedMessage message, int index) {
                if (this.supportUnknownEnumValue) {
                    return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.invokeOrDie(this.getRepeatedValueMethod, message, Integer.valueOf(index))).intValue());
                }
                return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, getRepeated(message, index), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRepeated(Builder builder, int index) {
                if (this.supportUnknownEnumValue) {
                    return this.enumDescriptor.findValueByNumberCreatingIfUnknown(((Integer) GeneratedMessage.invokeOrDie(this.getRepeatedValueMethodBuilder, builder, Integer.valueOf(index))).intValue());
                }
                return GeneratedMessage.invokeOrDie(this.getValueDescriptorMethod, getRepeated(builder, index), new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder builder, int index, Object value) {
                if (this.supportUnknownEnumValue) {
                    GeneratedMessage.invokeOrDie(this.setRepeatedValueMethod, builder, Integer.valueOf(index), Integer.valueOf(((Descriptors.EnumValueDescriptor) value).getNumber()));
                } else {
                    setRepeated(builder, index, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, value));
                }
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder builder, Object value) {
                if (this.supportUnknownEnumValue) {
                    GeneratedMessage.invokeOrDie(this.addRepeatedValueMethod, builder, Integer.valueOf(((Descriptors.EnumValueDescriptor) value).getNumber()));
                } else {
                    addRepeated(builder, GeneratedMessage.invokeOrDie(this.valueOfMethod, null, value));
                }
            }
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$FieldAccessorTable$SingularStringFieldAccessor.class */
        public static final class SingularStringFieldAccessor extends SingularFieldAccessor {
            private final Method getBytesMethod;
            private final Method getBytesMethodBuilder;
            private final Method setBytesMethodBuilder;

            SingularStringFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass, String containingOneofCamelCaseName) {
                super(descriptor, camelCaseName, messageClass, builderClass, containingOneofCamelCaseName);
                this.getBytesMethod = GeneratedMessage.getMethodOrDie(messageClass, BeanUtil.PREFIX_GETTER_GET + camelCaseName + "Bytes", new Class[0]);
                this.getBytesMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, BeanUtil.PREFIX_GETTER_GET + camelCaseName + "Bytes", new Class[0]);
                this.setBytesMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, "set" + camelCaseName + "Bytes", ByteString.class);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(GeneratedMessage message) {
                return GeneratedMessage.invokeOrDie(this.getBytesMethod, message, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Object getRaw(Builder builder) {
                return GeneratedMessage.invokeOrDie(this.getBytesMethodBuilder, builder, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder builder, Object value) {
                if (value instanceof ByteString) {
                    GeneratedMessage.invokeOrDie(this.setBytesMethodBuilder, builder, value);
                } else {
                    set(builder, value);
                }
            }
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$FieldAccessorTable$SingularMessageFieldAccessor.class */
        public static final class SingularMessageFieldAccessor extends SingularFieldAccessor {
            private final Method newBuilderMethod = GeneratedMessage.getMethodOrDie(this.type, "newBuilder", new Class[0]);
            private final Method getBuilderMethodBuilder;

            SingularMessageFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass, String containingOneofCamelCaseName) {
                super(descriptor, camelCaseName, messageClass, builderClass, containingOneofCamelCaseName);
                this.getBuilderMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, BeanUtil.PREFIX_GETTER_GET + camelCaseName + "Builder", new Class[0]);
            }

            private Object coerceType(Object value) {
                if (this.type.isInstance(value)) {
                    return value;
                }
                return ((Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) value).buildPartial();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void set(Builder builder, Object value) {
                set(builder, coerceType(value));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.SingularFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getBuilder(Builder builder) {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.getBuilderMethodBuilder, builder, new Object[0]);
            }
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/google/protobuf/GeneratedMessage$FieldAccessorTable$RepeatedMessageFieldAccessor.class */
        public static final class RepeatedMessageFieldAccessor extends RepeatedFieldAccessor {
            private final Method newBuilderMethod = GeneratedMessage.getMethodOrDie(this.type, "newBuilder", new Class[0]);
            private final Method getBuilderMethodBuilder;

            RepeatedMessageFieldAccessor(Descriptors.FieldDescriptor descriptor, String camelCaseName, Class<? extends GeneratedMessage> messageClass, Class<? extends Builder> builderClass) {
                super(descriptor, camelCaseName, messageClass, builderClass);
                this.getBuilderMethodBuilder = GeneratedMessage.getMethodOrDie(builderClass, BeanUtil.PREFIX_GETTER_GET + camelCaseName + "Builder", Integer.TYPE);
            }

            private Object coerceType(Object value) {
                if (this.type.isInstance(value)) {
                    return value;
                }
                return ((Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0])).mergeFrom((Message) value).build();
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void setRepeated(Builder builder, int index, Object value) {
                setRepeated(builder, index, coerceType(value));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public void addRepeated(Builder builder, Object value) {
                addRepeated(builder, coerceType(value));
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder newBuilder() {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.newBuilderMethod, null, new Object[0]);
            }

            @Override // com.google.protobuf.GeneratedMessage.FieldAccessorTable.RepeatedFieldAccessor, com.google.protobuf.GeneratedMessage.FieldAccessorTable.FieldAccessor
            public Message.Builder getRepeatedBuilder(Builder builder, int index) {
                return (Message.Builder) GeneratedMessage.invokeOrDie(this.getBuilderMethodBuilder, builder, Integer.valueOf(index));
            }
        }
    }

    protected Object writeReplace() throws ObjectStreamException {
        return new GeneratedMessageLite.SerializedForm(this);
    }

    /* access modifiers changed from: private */
    public static <MessageType extends ExtendableMessage<MessageType>, T> Extension<MessageType, T> checkNotLite(ExtensionLite<MessageType, T> extension) {
        if (!extension.isLite()) {
            return (Extension) extension;
        }
        throw new IllegalArgumentException("Expected non-lite extension.");
    }

    protected static int computeStringSize(int fieldNumber, Object value) {
        if (value instanceof String) {
            return CodedOutputStream.computeStringSize(fieldNumber, (String) value);
        }
        return CodedOutputStream.computeBytesSize(fieldNumber, (ByteString) value);
    }

    protected static int computeStringSizeNoTag(Object value) {
        if (value instanceof String) {
            return CodedOutputStream.computeStringSizeNoTag((String) value);
        }
        return CodedOutputStream.computeBytesSizeNoTag((ByteString) value);
    }

    protected static void writeString(CodedOutputStream output, int fieldNumber, Object value) throws IOException {
        if (value instanceof String) {
            output.writeString(fieldNumber, (String) value);
        } else {
            output.writeBytes(fieldNumber, (ByteString) value);
        }
    }

    protected static void writeStringNoTag(CodedOutputStream output, Object value) throws IOException {
        if (value instanceof String) {
            output.writeStringNoTag((String) value);
        } else {
            output.writeBytesNoTag((ByteString) value);
        }
    }
}
