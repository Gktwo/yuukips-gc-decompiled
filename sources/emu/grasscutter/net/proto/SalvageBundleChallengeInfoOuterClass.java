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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalvageBundleChallengeInfoOuterClass.class */
public final class SalvageBundleChallengeInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n SalvageBundleChallengeInfo.proto\":\n\u001aSalvageBundleChallengeInfo\u0012\u001c\n\u0014finished_bundle_list\u0018\u000b \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SalvageBundleChallengeInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SalvageBundleChallengeInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SalvageBundleChallengeInfo_descriptor, new String[]{"FinishedBundleList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalvageBundleChallengeInfoOuterClass$SalvageBundleChallengeInfoOrBuilder.class */
    public interface SalvageBundleChallengeInfoOrBuilder extends MessageOrBuilder {
        List<Integer> getFinishedBundleListList();

        int getFinishedBundleListCount();

        int getFinishedBundleList(int i);
    }

    private SalvageBundleChallengeInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalvageBundleChallengeInfoOuterClass$SalvageBundleChallengeInfo.class */
    public static final class SalvageBundleChallengeInfo extends GeneratedMessageV3 implements SalvageBundleChallengeInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FINISHED_BUNDLE_LIST_FIELD_NUMBER = 11;
        private Internal.IntList finishedBundleList_;
        private int finishedBundleListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final SalvageBundleChallengeInfo DEFAULT_INSTANCE = new SalvageBundleChallengeInfo();
        private static final Parser<SalvageBundleChallengeInfo> PARSER = new AbstractParser<SalvageBundleChallengeInfo>() { // from class: emu.grasscutter.net.proto.SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfo.1
            @Override // com.google.protobuf.Parser
            public SalvageBundleChallengeInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SalvageBundleChallengeInfo(input, extensionRegistry);
            }
        };

        private SalvageBundleChallengeInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.finishedBundleListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private SalvageBundleChallengeInfo() {
            this.finishedBundleListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.finishedBundleList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SalvageBundleChallengeInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SalvageBundleChallengeInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 88:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.finishedBundleList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.finishedBundleList_.addInt(input.readUInt32());
                                    break;
                                case 90:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.finishedBundleList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.finishedBundleList_.addInt(input.readUInt32());
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
                    this.finishedBundleList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SalvageBundleChallengeInfoOuterClass.internal_static_SalvageBundleChallengeInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SalvageBundleChallengeInfoOuterClass.internal_static_SalvageBundleChallengeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SalvageBundleChallengeInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfoOrBuilder
        public List<Integer> getFinishedBundleListList() {
            return this.finishedBundleList_;
        }

        @Override // emu.grasscutter.net.proto.SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfoOrBuilder
        public int getFinishedBundleListCount() {
            return this.finishedBundleList_.size();
        }

        @Override // emu.grasscutter.net.proto.SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfoOrBuilder
        public int getFinishedBundleList(int index) {
            return this.finishedBundleList_.getInt(index);
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
            if (getFinishedBundleListList().size() > 0) {
                output.writeUInt32NoTag(90);
                output.writeUInt32NoTag(this.finishedBundleListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.finishedBundleList_.size(); i++) {
                output.writeUInt32NoTag(this.finishedBundleList_.getInt(i));
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
            for (int i = 0; i < this.finishedBundleList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.finishedBundleList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getFinishedBundleListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.finishedBundleListMemoizedSerializedSize = dataSize;
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof SalvageBundleChallengeInfo)) {
                return equals(obj);
            }
            SalvageBundleChallengeInfo other = (SalvageBundleChallengeInfo) obj;
            return getFinishedBundleListList().equals(other.getFinishedBundleListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getFinishedBundleListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getFinishedBundleListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SalvageBundleChallengeInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SalvageBundleChallengeInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SalvageBundleChallengeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SalvageBundleChallengeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SalvageBundleChallengeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SalvageBundleChallengeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SalvageBundleChallengeInfo parseFrom(InputStream input) throws IOException {
            return (SalvageBundleChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SalvageBundleChallengeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SalvageBundleChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SalvageBundleChallengeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SalvageBundleChallengeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SalvageBundleChallengeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SalvageBundleChallengeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SalvageBundleChallengeInfo parseFrom(CodedInputStream input) throws IOException {
            return (SalvageBundleChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SalvageBundleChallengeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SalvageBundleChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SalvageBundleChallengeInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SalvageBundleChallengeInfoOuterClass$SalvageBundleChallengeInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SalvageBundleChallengeInfoOrBuilder {
            private int bitField0_;
            private Internal.IntList finishedBundleList_ = SalvageBundleChallengeInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return SalvageBundleChallengeInfoOuterClass.internal_static_SalvageBundleChallengeInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SalvageBundleChallengeInfoOuterClass.internal_static_SalvageBundleChallengeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SalvageBundleChallengeInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SalvageBundleChallengeInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.finishedBundleList_ = SalvageBundleChallengeInfo.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SalvageBundleChallengeInfoOuterClass.internal_static_SalvageBundleChallengeInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SalvageBundleChallengeInfo getDefaultInstanceForType() {
                return SalvageBundleChallengeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SalvageBundleChallengeInfo build() {
                SalvageBundleChallengeInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SalvageBundleChallengeInfo buildPartial() {
                SalvageBundleChallengeInfo result = new SalvageBundleChallengeInfo(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.finishedBundleList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.finishedBundleList_ = this.finishedBundleList_;
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
                if (other instanceof SalvageBundleChallengeInfo) {
                    return mergeFrom((SalvageBundleChallengeInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SalvageBundleChallengeInfo other) {
                if (other == SalvageBundleChallengeInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.finishedBundleList_.isEmpty()) {
                    if (this.finishedBundleList_.isEmpty()) {
                        this.finishedBundleList_ = other.finishedBundleList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureFinishedBundleListIsMutable();
                        this.finishedBundleList_.addAll(other.finishedBundleList_);
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
                SalvageBundleChallengeInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SalvageBundleChallengeInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SalvageBundleChallengeInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureFinishedBundleListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.finishedBundleList_ = SalvageBundleChallengeInfo.mutableCopy(this.finishedBundleList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfoOrBuilder
            public List<Integer> getFinishedBundleListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.finishedBundleList_) : this.finishedBundleList_;
            }

            @Override // emu.grasscutter.net.proto.SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfoOrBuilder
            public int getFinishedBundleListCount() {
                return this.finishedBundleList_.size();
            }

            @Override // emu.grasscutter.net.proto.SalvageBundleChallengeInfoOuterClass.SalvageBundleChallengeInfoOrBuilder
            public int getFinishedBundleList(int index) {
                return this.finishedBundleList_.getInt(index);
            }

            public Builder setFinishedBundleList(int index, int value) {
                ensureFinishedBundleListIsMutable();
                this.finishedBundleList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFinishedBundleList(int value) {
                ensureFinishedBundleListIsMutable();
                this.finishedBundleList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFinishedBundleList(Iterable<? extends Integer> values) {
                ensureFinishedBundleListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.finishedBundleList_);
                onChanged();
                return this;
            }

            public Builder clearFinishedBundleList() {
                this.finishedBundleList_ = SalvageBundleChallengeInfo.emptyIntList();
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

        public static SalvageBundleChallengeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SalvageBundleChallengeInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SalvageBundleChallengeInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SalvageBundleChallengeInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
