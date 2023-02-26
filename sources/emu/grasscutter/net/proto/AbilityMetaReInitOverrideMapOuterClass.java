package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityMetaReInitOverrideMapOuterClass.class */
public final class AbilityMetaReInitOverrideMapOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\"AbilityMetaReInitOverrideMap.proto\u001a\u001dAbilityScalarValueEntry.proto\"M\n\u001cAbilityMetaReInitOverrideMap\u0012-\n\u000boverrideMap\u0018\u0002 \u0003(\u000b2\u0018.AbilityScalarValueEntryB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilityScalarValueEntryOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AbilityMetaReInitOverrideMap_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AbilityMetaReInitOverrideMap_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AbilityMetaReInitOverrideMap_descriptor, new String[]{"OverrideMap"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityMetaReInitOverrideMapOuterClass$AbilityMetaReInitOverrideMapOrBuilder.class */
    public interface AbilityMetaReInitOverrideMapOrBuilder extends MessageOrBuilder {
        List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> getOverrideMapList();

        AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry getOverrideMap(int i);

        int getOverrideMapCount();

        List<? extends AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> getOverrideMapOrBuilderList();

        AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder getOverrideMapOrBuilder(int i);
    }

    private AbilityMetaReInitOverrideMapOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityMetaReInitOverrideMapOuterClass$AbilityMetaReInitOverrideMap.class */
    public static final class AbilityMetaReInitOverrideMap extends GeneratedMessageV3 implements AbilityMetaReInitOverrideMapOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int OVERRIDEMAP_FIELD_NUMBER = 2;
        private List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> overrideMap_;
        private byte memoizedIsInitialized;
        private static final AbilityMetaReInitOverrideMap DEFAULT_INSTANCE = new AbilityMetaReInitOverrideMap();
        private static final Parser<AbilityMetaReInitOverrideMap> PARSER = new AbstractParser<AbilityMetaReInitOverrideMap>() { // from class: emu.grasscutter.net.proto.AbilityMetaReInitOverrideMapOuterClass.AbilityMetaReInitOverrideMap.1
            @Override // com.google.protobuf.Parser
            public AbilityMetaReInitOverrideMap parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AbilityMetaReInitOverrideMap(input, extensionRegistry);
            }
        };

        private AbilityMetaReInitOverrideMap(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AbilityMetaReInitOverrideMap() {
            this.memoizedIsInitialized = -1;
            this.overrideMap_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AbilityMetaReInitOverrideMap();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AbilityMetaReInitOverrideMap(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 18:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.overrideMap_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.overrideMap_.add((AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry) input.readMessage(AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.parser(), extensionRegistry));
                                    break;
                                default:
                                    if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                        break;
                                    } else {
                                        done = true;
                                        break;
                                    }
                            }
                        } catch (InvalidProtocolBufferException e) {
                            throw e.setUnfinishedMessage(this);
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.overrideMap_ = Collections.unmodifiableList(this.overrideMap_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AbilityMetaReInitOverrideMapOuterClass.internal_static_AbilityMetaReInitOverrideMap_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbilityMetaReInitOverrideMapOuterClass.internal_static_AbilityMetaReInitOverrideMap_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityMetaReInitOverrideMap.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaReInitOverrideMapOuterClass.AbilityMetaReInitOverrideMapOrBuilder
        public List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> getOverrideMapList() {
            return this.overrideMap_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaReInitOverrideMapOuterClass.AbilityMetaReInitOverrideMapOrBuilder
        public List<? extends AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> getOverrideMapOrBuilderList() {
            return this.overrideMap_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaReInitOverrideMapOuterClass.AbilityMetaReInitOverrideMapOrBuilder
        public int getOverrideMapCount() {
            return this.overrideMap_.size();
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaReInitOverrideMapOuterClass.AbilityMetaReInitOverrideMapOrBuilder
        public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry getOverrideMap(int index) {
            return this.overrideMap_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AbilityMetaReInitOverrideMapOuterClass.AbilityMetaReInitOverrideMapOrBuilder
        public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder getOverrideMapOrBuilder(int index) {
            return this.overrideMap_.get(index);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte isInitialized = this.memoizedIsInitialized;
            if (isInitialized == 1) {
                return true;
            }
            if (isInitialized == 0) {
                return false;
            }
            this.memoizedIsInitialized = 1;
            return true;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public void writeTo(CodedOutputStream output) throws IOException {
            for (int i = 0; i < this.overrideMap_.size(); i++) {
                output.writeMessage(2, this.overrideMap_.get(i));
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int size2 = 0;
            for (int i = 0; i < this.overrideMap_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.overrideMap_.get(i));
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AbilityMetaReInitOverrideMap)) {
                return equals(obj);
            }
            AbilityMetaReInitOverrideMap other = (AbilityMetaReInitOverrideMap) obj;
            return getOverrideMapList().equals(other.getOverrideMapList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getOverrideMapCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getOverrideMapList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AbilityMetaReInitOverrideMap parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityMetaReInitOverrideMap parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityMetaReInitOverrideMap parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityMetaReInitOverrideMap parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityMetaReInitOverrideMap parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityMetaReInitOverrideMap parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityMetaReInitOverrideMap parseFrom(InputStream input) throws IOException {
            return (AbilityMetaReInitOverrideMap) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityMetaReInitOverrideMap parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityMetaReInitOverrideMap) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityMetaReInitOverrideMap parseDelimitedFrom(InputStream input) throws IOException {
            return (AbilityMetaReInitOverrideMap) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AbilityMetaReInitOverrideMap parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityMetaReInitOverrideMap) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityMetaReInitOverrideMap parseFrom(CodedInputStream input) throws IOException {
            return (AbilityMetaReInitOverrideMap) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityMetaReInitOverrideMap parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityMetaReInitOverrideMap) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AbilityMetaReInitOverrideMap prototype) {
            return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder toBuilder() {
            return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Builder newBuilderForType(GeneratedMessageV3.BuilderParent parent) {
            return new Builder(parent);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityMetaReInitOverrideMapOuterClass$AbilityMetaReInitOverrideMap$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AbilityMetaReInitOverrideMapOrBuilder {
            private int bitField0_;
            private List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> overrideMap_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> overrideMapBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AbilityMetaReInitOverrideMapOuterClass.internal_static_AbilityMetaReInitOverrideMap_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbilityMetaReInitOverrideMapOuterClass.internal_static_AbilityMetaReInitOverrideMap_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityMetaReInitOverrideMap.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AbilityMetaReInitOverrideMap.alwaysUseFieldBuilders) {
                    getOverrideMapFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.overrideMapBuilder_ == null) {
                    this.overrideMap_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.overrideMapBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbilityMetaReInitOverrideMapOuterClass.internal_static_AbilityMetaReInitOverrideMap_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AbilityMetaReInitOverrideMap getDefaultInstanceForType() {
                return AbilityMetaReInitOverrideMap.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityMetaReInitOverrideMap build() {
                AbilityMetaReInitOverrideMap result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityMetaReInitOverrideMap buildPartial() {
                AbilityMetaReInitOverrideMap result = new AbilityMetaReInitOverrideMap(this);
                int i = this.bitField0_;
                if (this.overrideMapBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.overrideMap_ = Collections.unmodifiableList(this.overrideMap_);
                        this.bitField0_ &= -2;
                    }
                    result.overrideMap_ = this.overrideMap_;
                } else {
                    result.overrideMap_ = this.overrideMapBuilder_.build();
                }
                onBuilt();
                return result;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, java.lang.Object, com.google.protobuf.Message.Builder
            public Builder clone() {
                return clone();
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setField(Descriptors.FieldDescriptor field, Object value) {
                return setField(field, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder clearField(Descriptors.FieldDescriptor field) {
                return clearField(field);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder clearOneof(Descriptors.OneofDescriptor oneof) {
                return clearOneof(oneof);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder setRepeatedField(Descriptors.FieldDescriptor field, int index, Object value) {
                return setRepeatedField(field, index, value);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public Builder addRepeatedField(Descriptors.FieldDescriptor field, Object value) {
                return addRepeatedField(field, value);
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(Message other) {
                if (other instanceof AbilityMetaReInitOverrideMap) {
                    return mergeFrom((AbilityMetaReInitOverrideMap) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AbilityMetaReInitOverrideMap other) {
                if (other == AbilityMetaReInitOverrideMap.getDefaultInstance()) {
                    return this;
                }
                if (this.overrideMapBuilder_ == null) {
                    if (!other.overrideMap_.isEmpty()) {
                        if (this.overrideMap_.isEmpty()) {
                            this.overrideMap_ = other.overrideMap_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureOverrideMapIsMutable();
                            this.overrideMap_.addAll(other.overrideMap_);
                        }
                        onChanged();
                    }
                } else if (!other.overrideMap_.isEmpty()) {
                    if (this.overrideMapBuilder_.isEmpty()) {
                        this.overrideMapBuilder_.dispose();
                        this.overrideMapBuilder_ = null;
                        this.overrideMap_ = other.overrideMap_;
                        this.bitField0_ &= -2;
                        this.overrideMapBuilder_ = AbilityMetaReInitOverrideMap.alwaysUseFieldBuilders ? getOverrideMapFieldBuilder() : null;
                    } else {
                        this.overrideMapBuilder_.addAllMessages(other.overrideMap_);
                    }
                }
                mergeUnknownFields(other.unknownFields);
                onChanged();
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            @Override // com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder mergeFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                AbilityMetaReInitOverrideMap parsedMessage = null;
                try {
                    try {
                        parsedMessage = AbilityMetaReInitOverrideMap.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AbilityMetaReInitOverrideMap) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureOverrideMapIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.overrideMap_ = new ArrayList(this.overrideMap_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilityMetaReInitOverrideMapOuterClass.AbilityMetaReInitOverrideMapOrBuilder
            public List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> getOverrideMapList() {
                if (this.overrideMapBuilder_ == null) {
                    return Collections.unmodifiableList(this.overrideMap_);
                }
                return this.overrideMapBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AbilityMetaReInitOverrideMapOuterClass.AbilityMetaReInitOverrideMapOrBuilder
            public int getOverrideMapCount() {
                if (this.overrideMapBuilder_ == null) {
                    return this.overrideMap_.size();
                }
                return this.overrideMapBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AbilityMetaReInitOverrideMapOuterClass.AbilityMetaReInitOverrideMapOrBuilder
            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry getOverrideMap(int index) {
                if (this.overrideMapBuilder_ == null) {
                    return this.overrideMap_.get(index);
                }
                return this.overrideMapBuilder_.getMessage(index);
            }

            public Builder setOverrideMap(int index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry value) {
                if (this.overrideMapBuilder_ != null) {
                    this.overrideMapBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOverrideMapIsMutable();
                    this.overrideMap_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setOverrideMap(int index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder builderForValue) {
                if (this.overrideMapBuilder_ == null) {
                    ensureOverrideMapIsMutable();
                    this.overrideMap_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.overrideMapBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addOverrideMap(AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry value) {
                if (this.overrideMapBuilder_ != null) {
                    this.overrideMapBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOverrideMapIsMutable();
                    this.overrideMap_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addOverrideMap(int index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry value) {
                if (this.overrideMapBuilder_ != null) {
                    this.overrideMapBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOverrideMapIsMutable();
                    this.overrideMap_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addOverrideMap(AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder builderForValue) {
                if (this.overrideMapBuilder_ == null) {
                    ensureOverrideMapIsMutable();
                    this.overrideMap_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.overrideMapBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addOverrideMap(int index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder builderForValue) {
                if (this.overrideMapBuilder_ == null) {
                    ensureOverrideMapIsMutable();
                    this.overrideMap_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.overrideMapBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllOverrideMap(Iterable<? extends AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> values) {
                if (this.overrideMapBuilder_ == null) {
                    ensureOverrideMapIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.overrideMap_);
                    onChanged();
                } else {
                    this.overrideMapBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearOverrideMap() {
                if (this.overrideMapBuilder_ == null) {
                    this.overrideMap_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.overrideMapBuilder_.clear();
                }
                return this;
            }

            public Builder removeOverrideMap(int index) {
                if (this.overrideMapBuilder_ == null) {
                    ensureOverrideMapIsMutable();
                    this.overrideMap_.remove(index);
                    onChanged();
                } else {
                    this.overrideMapBuilder_.remove(index);
                }
                return this;
            }

            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder getOverrideMapBuilder(int index) {
                return getOverrideMapFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilityMetaReInitOverrideMapOuterClass.AbilityMetaReInitOverrideMapOrBuilder
            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder getOverrideMapOrBuilder(int index) {
                if (this.overrideMapBuilder_ == null) {
                    return this.overrideMap_.get(index);
                }
                return this.overrideMapBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilityMetaReInitOverrideMapOuterClass.AbilityMetaReInitOverrideMapOrBuilder
            public List<? extends AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> getOverrideMapOrBuilderList() {
                if (this.overrideMapBuilder_ != null) {
                    return this.overrideMapBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.overrideMap_);
            }

            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder addOverrideMapBuilder() {
                return getOverrideMapFieldBuilder().addBuilder(AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.getDefaultInstance());
            }

            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder addOverrideMapBuilder(int index) {
                return getOverrideMapFieldBuilder().addBuilder(index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.getDefaultInstance());
            }

            public List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder> getOverrideMapBuilderList() {
                return getOverrideMapFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> getOverrideMapFieldBuilder() {
                if (this.overrideMapBuilder_ == null) {
                    this.overrideMapBuilder_ = new RepeatedFieldBuilderV3<>(this.overrideMap_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.overrideMap_ = null;
                }
                return this.overrideMapBuilder_;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static AbilityMetaReInitOverrideMap getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AbilityMetaReInitOverrideMap> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AbilityMetaReInitOverrideMap> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AbilityMetaReInitOverrideMap getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilityScalarValueEntryOuterClass.getDescriptor();
    }
}
