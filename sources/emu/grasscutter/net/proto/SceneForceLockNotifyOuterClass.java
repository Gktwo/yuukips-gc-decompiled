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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneForceLockNotifyOuterClass.class */
public final class SceneForceLockNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aSceneForceLockNotify.proto\"+\n\u0014SceneForceLockNotify\u0012\u0013\n\u000bforceIdList\u0018\u0006 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SceneForceLockNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneForceLockNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneForceLockNotify_descriptor, new String[]{"ForceIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneForceLockNotifyOuterClass$SceneForceLockNotifyOrBuilder.class */
    public interface SceneForceLockNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getForceIdListList();

        int getForceIdListCount();

        int getForceIdList(int i);
    }

    private SceneForceLockNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneForceLockNotifyOuterClass$SceneForceLockNotify.class */
    public static final class SceneForceLockNotify extends GeneratedMessageV3 implements SceneForceLockNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FORCEIDLIST_FIELD_NUMBER = 6;
        private Internal.IntList forceIdList_;
        private int forceIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final SceneForceLockNotify DEFAULT_INSTANCE = new SceneForceLockNotify();
        private static final Parser<SceneForceLockNotify> PARSER = new AbstractParser<SceneForceLockNotify>() { // from class: emu.grasscutter.net.proto.SceneForceLockNotifyOuterClass.SceneForceLockNotify.1
            @Override // com.google.protobuf.Parser
            public SceneForceLockNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneForceLockNotify(input, extensionRegistry);
            }
        };

        private SceneForceLockNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.forceIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private SceneForceLockNotify() {
            this.forceIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.forceIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneForceLockNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneForceLockNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 48:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.forceIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.forceIdList_.addInt(input.readUInt32());
                                    break;
                                case 50:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.forceIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.forceIdList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
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
                    this.forceIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SceneForceLockNotifyOuterClass.internal_static_SceneForceLockNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneForceLockNotifyOuterClass.internal_static_SceneForceLockNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneForceLockNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SceneForceLockNotifyOuterClass.SceneForceLockNotifyOrBuilder
        public List<Integer> getForceIdListList() {
            return this.forceIdList_;
        }

        @Override // emu.grasscutter.net.proto.SceneForceLockNotifyOuterClass.SceneForceLockNotifyOrBuilder
        public int getForceIdListCount() {
            return this.forceIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.SceneForceLockNotifyOuterClass.SceneForceLockNotifyOrBuilder
        public int getForceIdList(int index) {
            return this.forceIdList_.getInt(index);
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
            getSerializedSize();
            if (getForceIdListList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.forceIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.forceIdList_.size(); i++) {
                output.writeUInt32NoTag(this.forceIdList_.getInt(i));
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.forceIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.forceIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getForceIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.forceIdListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SceneForceLockNotify)) {
                return equals(obj);
            }
            SceneForceLockNotify other = (SceneForceLockNotify) obj;
            return getForceIdListList().equals(other.getForceIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getForceIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getForceIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SceneForceLockNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneForceLockNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneForceLockNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneForceLockNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneForceLockNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneForceLockNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneForceLockNotify parseFrom(InputStream input) throws IOException {
            return (SceneForceLockNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneForceLockNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneForceLockNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneForceLockNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneForceLockNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneForceLockNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneForceLockNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneForceLockNotify parseFrom(CodedInputStream input) throws IOException {
            return (SceneForceLockNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneForceLockNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneForceLockNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneForceLockNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneForceLockNotifyOuterClass$SceneForceLockNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneForceLockNotifyOrBuilder {
            private int bitField0_;
            private Internal.IntList forceIdList_ = SceneForceLockNotify.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneForceLockNotifyOuterClass.internal_static_SceneForceLockNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneForceLockNotifyOuterClass.internal_static_SceneForceLockNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneForceLockNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneForceLockNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.forceIdList_ = SceneForceLockNotify.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneForceLockNotifyOuterClass.internal_static_SceneForceLockNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneForceLockNotify getDefaultInstanceForType() {
                return SceneForceLockNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneForceLockNotify build() {
                SceneForceLockNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneForceLockNotify buildPartial() {
                SceneForceLockNotify result = new SceneForceLockNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.forceIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.forceIdList_ = this.forceIdList_;
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
                if (other instanceof SceneForceLockNotify) {
                    return mergeFrom((SceneForceLockNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneForceLockNotify other) {
                if (other == SceneForceLockNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.forceIdList_.isEmpty()) {
                    if (this.forceIdList_.isEmpty()) {
                        this.forceIdList_ = other.forceIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureForceIdListIsMutable();
                        this.forceIdList_.addAll(other.forceIdList_);
                    }
                    onChanged();
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
                SceneForceLockNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneForceLockNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneForceLockNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureForceIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.forceIdList_ = SceneForceLockNotify.mutableCopy(this.forceIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneForceLockNotifyOuterClass.SceneForceLockNotifyOrBuilder
            public List<Integer> getForceIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.forceIdList_) : this.forceIdList_;
            }

            @Override // emu.grasscutter.net.proto.SceneForceLockNotifyOuterClass.SceneForceLockNotifyOrBuilder
            public int getForceIdListCount() {
                return this.forceIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.SceneForceLockNotifyOuterClass.SceneForceLockNotifyOrBuilder
            public int getForceIdList(int index) {
                return this.forceIdList_.getInt(index);
            }

            public Builder setForceIdList(int index, int value) {
                ensureForceIdListIsMutable();
                this.forceIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addForceIdList(int value) {
                ensureForceIdListIsMutable();
                this.forceIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllForceIdList(Iterable<? extends Integer> values) {
                ensureForceIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.forceIdList_);
                onChanged();
                return this;
            }

            public Builder clearForceIdList() {
                this.forceIdList_ = SceneForceLockNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
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

        public static SceneForceLockNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneForceLockNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneForceLockNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneForceLockNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
