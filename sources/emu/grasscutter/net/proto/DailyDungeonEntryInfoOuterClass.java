package emu.grasscutter.net.proto;

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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.DungeonEntryInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyDungeonEntryInfoOuterClass.class */
public final class DailyDungeonEntryInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bDailyDungeonEntryInfo.proto\u001a\u0016DungeonEntryInfo.proto\"\u0001\n\u0015DailyDungeonEntryInfo\u0012\u001a\n\u0012recommendDungeonId\u0018\r \u0001(\r\u0012\u0016\n\u000edungeonEntryId\u0018\b \u0001(\r\u0012\u001c\n\u0014dungeonEntryConfigId\u0018\u0002 \u0001(\r\u00124\n\u0019recommendDungeonEntryInfo\u0018\u000e \u0001(\u000b2\u0011.DungeonEntryInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{DungeonEntryInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DailyDungeonEntryInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DailyDungeonEntryInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DailyDungeonEntryInfo_descriptor, new String[]{"RecommendDungeonId", "DungeonEntryId", "DungeonEntryConfigId", "RecommendDungeonEntryInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyDungeonEntryInfoOuterClass$DailyDungeonEntryInfoOrBuilder.class */
    public interface DailyDungeonEntryInfoOrBuilder extends MessageOrBuilder {
        int getRecommendDungeonId();

        int getDungeonEntryId();

        int getDungeonEntryConfigId();

        boolean hasRecommendDungeonEntryInfo();

        DungeonEntryInfoOuterClass.DungeonEntryInfo getRecommendDungeonEntryInfo();

        DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder getRecommendDungeonEntryInfoOrBuilder();
    }

    private DailyDungeonEntryInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyDungeonEntryInfoOuterClass$DailyDungeonEntryInfo.class */
    public static final class DailyDungeonEntryInfo extends GeneratedMessageV3 implements DailyDungeonEntryInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RECOMMENDDUNGEONID_FIELD_NUMBER = 13;
        private int recommendDungeonId_;
        public static final int DUNGEONENTRYID_FIELD_NUMBER = 8;
        private int dungeonEntryId_;
        public static final int DUNGEONENTRYCONFIGID_FIELD_NUMBER = 2;
        private int dungeonEntryConfigId_;
        public static final int RECOMMENDDUNGEONENTRYINFO_FIELD_NUMBER = 14;
        private DungeonEntryInfoOuterClass.DungeonEntryInfo recommendDungeonEntryInfo_;
        private byte memoizedIsInitialized;
        private static final DailyDungeonEntryInfo DEFAULT_INSTANCE = new DailyDungeonEntryInfo();
        private static final Parser<DailyDungeonEntryInfo> PARSER = new AbstractParser<DailyDungeonEntryInfo>() { // from class: emu.grasscutter.net.proto.DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo.1
            @Override // com.google.protobuf.Parser
            public DailyDungeonEntryInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DailyDungeonEntryInfo(input, extensionRegistry);
            }
        };

        private DailyDungeonEntryInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DailyDungeonEntryInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DailyDungeonEntryInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DailyDungeonEntryInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                unknownFields = UnknownFieldSet.newBuilder();
                boolean done = false;
                while (!done) {
                    try {
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 16:
                                this.dungeonEntryConfigId_ = input.readUInt32();
                                break;
                            case 64:
                                this.dungeonEntryId_ = input.readUInt32();
                                break;
                            case 104:
                                this.recommendDungeonId_ = input.readUInt32();
                                break;
                            case 114:
                                DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder subBuilder = this.recommendDungeonEntryInfo_ != null ? this.recommendDungeonEntryInfo_.toBuilder() : null;
                                this.recommendDungeonEntryInfo_ = (DungeonEntryInfoOuterClass.DungeonEntryInfo) input.readMessage(DungeonEntryInfoOuterClass.DungeonEntryInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.recommendDungeonEntryInfo_);
                                    this.recommendDungeonEntryInfo_ = subBuilder.buildPartial();
                                    break;
                                }
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
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DailyDungeonEntryInfoOuterClass.internal_static_DailyDungeonEntryInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DailyDungeonEntryInfoOuterClass.internal_static_DailyDungeonEntryInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyDungeonEntryInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder
        public int getRecommendDungeonId() {
            return this.recommendDungeonId_;
        }

        @Override // emu.grasscutter.net.proto.DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder
        public int getDungeonEntryId() {
            return this.dungeonEntryId_;
        }

        @Override // emu.grasscutter.net.proto.DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder
        public int getDungeonEntryConfigId() {
            return this.dungeonEntryConfigId_;
        }

        @Override // emu.grasscutter.net.proto.DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder
        public boolean hasRecommendDungeonEntryInfo() {
            return this.recommendDungeonEntryInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder
        public DungeonEntryInfoOuterClass.DungeonEntryInfo getRecommendDungeonEntryInfo() {
            return this.recommendDungeonEntryInfo_ == null ? DungeonEntryInfoOuterClass.DungeonEntryInfo.getDefaultInstance() : this.recommendDungeonEntryInfo_;
        }

        @Override // emu.grasscutter.net.proto.DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder
        public DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder getRecommendDungeonEntryInfoOrBuilder() {
            return getRecommendDungeonEntryInfo();
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
            if (this.dungeonEntryConfigId_ != 0) {
                output.writeUInt32(2, this.dungeonEntryConfigId_);
            }
            if (this.dungeonEntryId_ != 0) {
                output.writeUInt32(8, this.dungeonEntryId_);
            }
            if (this.recommendDungeonId_ != 0) {
                output.writeUInt32(13, this.recommendDungeonId_);
            }
            if (this.recommendDungeonEntryInfo_ != null) {
                output.writeMessage(14, getRecommendDungeonEntryInfo());
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
            if (this.dungeonEntryConfigId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.dungeonEntryConfigId_);
            }
            if (this.dungeonEntryId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.dungeonEntryId_);
            }
            if (this.recommendDungeonId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.recommendDungeonId_);
            }
            if (this.recommendDungeonEntryInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(14, getRecommendDungeonEntryInfo());
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
            if (!(obj instanceof DailyDungeonEntryInfo)) {
                return equals(obj);
            }
            DailyDungeonEntryInfo other = (DailyDungeonEntryInfo) obj;
            if (getRecommendDungeonId() == other.getRecommendDungeonId() && getDungeonEntryId() == other.getDungeonEntryId() && getDungeonEntryConfigId() == other.getDungeonEntryConfigId() && hasRecommendDungeonEntryInfo() == other.hasRecommendDungeonEntryInfo()) {
                return (!hasRecommendDungeonEntryInfo() || getRecommendDungeonEntryInfo().equals(other.getRecommendDungeonEntryInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + getRecommendDungeonId())) + 8)) + getDungeonEntryId())) + 2)) + getDungeonEntryConfigId();
            if (hasRecommendDungeonEntryInfo()) {
                hash = (53 * ((37 * hash) + 14)) + getRecommendDungeonEntryInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DailyDungeonEntryInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DailyDungeonEntryInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyDungeonEntryInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DailyDungeonEntryInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyDungeonEntryInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DailyDungeonEntryInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DailyDungeonEntryInfo parseFrom(InputStream input) throws IOException {
            return (DailyDungeonEntryInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DailyDungeonEntryInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyDungeonEntryInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DailyDungeonEntryInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (DailyDungeonEntryInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DailyDungeonEntryInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyDungeonEntryInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DailyDungeonEntryInfo parseFrom(CodedInputStream input) throws IOException {
            return (DailyDungeonEntryInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DailyDungeonEntryInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DailyDungeonEntryInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DailyDungeonEntryInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DailyDungeonEntryInfoOuterClass$DailyDungeonEntryInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DailyDungeonEntryInfoOrBuilder {
            private int recommendDungeonId_;
            private int dungeonEntryId_;
            private int dungeonEntryConfigId_;
            private DungeonEntryInfoOuterClass.DungeonEntryInfo recommendDungeonEntryInfo_;
            private SingleFieldBuilderV3<DungeonEntryInfoOuterClass.DungeonEntryInfo, DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder, DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder> recommendDungeonEntryInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DailyDungeonEntryInfoOuterClass.internal_static_DailyDungeonEntryInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DailyDungeonEntryInfoOuterClass.internal_static_DailyDungeonEntryInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DailyDungeonEntryInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DailyDungeonEntryInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.recommendDungeonId_ = 0;
                this.dungeonEntryId_ = 0;
                this.dungeonEntryConfigId_ = 0;
                if (this.recommendDungeonEntryInfoBuilder_ == null) {
                    this.recommendDungeonEntryInfo_ = null;
                } else {
                    this.recommendDungeonEntryInfo_ = null;
                    this.recommendDungeonEntryInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DailyDungeonEntryInfoOuterClass.internal_static_DailyDungeonEntryInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DailyDungeonEntryInfo getDefaultInstanceForType() {
                return DailyDungeonEntryInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DailyDungeonEntryInfo build() {
                DailyDungeonEntryInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DailyDungeonEntryInfo buildPartial() {
                DailyDungeonEntryInfo result = new DailyDungeonEntryInfo(this);
                result.recommendDungeonId_ = this.recommendDungeonId_;
                result.dungeonEntryId_ = this.dungeonEntryId_;
                result.dungeonEntryConfigId_ = this.dungeonEntryConfigId_;
                if (this.recommendDungeonEntryInfoBuilder_ == null) {
                    result.recommendDungeonEntryInfo_ = this.recommendDungeonEntryInfo_;
                } else {
                    result.recommendDungeonEntryInfo_ = this.recommendDungeonEntryInfoBuilder_.build();
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
                if (other instanceof DailyDungeonEntryInfo) {
                    return mergeFrom((DailyDungeonEntryInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DailyDungeonEntryInfo other) {
                if (other == DailyDungeonEntryInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getRecommendDungeonId() != 0) {
                    setRecommendDungeonId(other.getRecommendDungeonId());
                }
                if (other.getDungeonEntryId() != 0) {
                    setDungeonEntryId(other.getDungeonEntryId());
                }
                if (other.getDungeonEntryConfigId() != 0) {
                    setDungeonEntryConfigId(other.getDungeonEntryConfigId());
                }
                if (other.hasRecommendDungeonEntryInfo()) {
                    mergeRecommendDungeonEntryInfo(other.getRecommendDungeonEntryInfo());
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
                DailyDungeonEntryInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = DailyDungeonEntryInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DailyDungeonEntryInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder
            public int getRecommendDungeonId() {
                return this.recommendDungeonId_;
            }

            public Builder setRecommendDungeonId(int value) {
                this.recommendDungeonId_ = value;
                onChanged();
                return this;
            }

            public Builder clearRecommendDungeonId() {
                this.recommendDungeonId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder
            public int getDungeonEntryId() {
                return this.dungeonEntryId_;
            }

            public Builder setDungeonEntryId(int value) {
                this.dungeonEntryId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDungeonEntryId() {
                this.dungeonEntryId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder
            public int getDungeonEntryConfigId() {
                return this.dungeonEntryConfigId_;
            }

            public Builder setDungeonEntryConfigId(int value) {
                this.dungeonEntryConfigId_ = value;
                onChanged();
                return this;
            }

            public Builder clearDungeonEntryConfigId() {
                this.dungeonEntryConfigId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder
            public boolean hasRecommendDungeonEntryInfo() {
                return (this.recommendDungeonEntryInfoBuilder_ == null && this.recommendDungeonEntryInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder
            public DungeonEntryInfoOuterClass.DungeonEntryInfo getRecommendDungeonEntryInfo() {
                if (this.recommendDungeonEntryInfoBuilder_ == null) {
                    return this.recommendDungeonEntryInfo_ == null ? DungeonEntryInfoOuterClass.DungeonEntryInfo.getDefaultInstance() : this.recommendDungeonEntryInfo_;
                }
                return this.recommendDungeonEntryInfoBuilder_.getMessage();
            }

            public Builder setRecommendDungeonEntryInfo(DungeonEntryInfoOuterClass.DungeonEntryInfo value) {
                if (this.recommendDungeonEntryInfoBuilder_ != null) {
                    this.recommendDungeonEntryInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.recommendDungeonEntryInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRecommendDungeonEntryInfo(DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder builderForValue) {
                if (this.recommendDungeonEntryInfoBuilder_ == null) {
                    this.recommendDungeonEntryInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.recommendDungeonEntryInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRecommendDungeonEntryInfo(DungeonEntryInfoOuterClass.DungeonEntryInfo value) {
                if (this.recommendDungeonEntryInfoBuilder_ == null) {
                    if (this.recommendDungeonEntryInfo_ != null) {
                        this.recommendDungeonEntryInfo_ = DungeonEntryInfoOuterClass.DungeonEntryInfo.newBuilder(this.recommendDungeonEntryInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.recommendDungeonEntryInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.recommendDungeonEntryInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRecommendDungeonEntryInfo() {
                if (this.recommendDungeonEntryInfoBuilder_ == null) {
                    this.recommendDungeonEntryInfo_ = null;
                    onChanged();
                } else {
                    this.recommendDungeonEntryInfo_ = null;
                    this.recommendDungeonEntryInfoBuilder_ = null;
                }
                return this;
            }

            public DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder getRecommendDungeonEntryInfoBuilder() {
                onChanged();
                return getRecommendDungeonEntryInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder
            public DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder getRecommendDungeonEntryInfoOrBuilder() {
                if (this.recommendDungeonEntryInfoBuilder_ != null) {
                    return this.recommendDungeonEntryInfoBuilder_.getMessageOrBuilder();
                }
                return this.recommendDungeonEntryInfo_ == null ? DungeonEntryInfoOuterClass.DungeonEntryInfo.getDefaultInstance() : this.recommendDungeonEntryInfo_;
            }

            private SingleFieldBuilderV3<DungeonEntryInfoOuterClass.DungeonEntryInfo, DungeonEntryInfoOuterClass.DungeonEntryInfo.Builder, DungeonEntryInfoOuterClass.DungeonEntryInfoOrBuilder> getRecommendDungeonEntryInfoFieldBuilder() {
                if (this.recommendDungeonEntryInfoBuilder_ == null) {
                    this.recommendDungeonEntryInfoBuilder_ = new SingleFieldBuilderV3<>(getRecommendDungeonEntryInfo(), getParentForChildren(), isClean());
                    this.recommendDungeonEntryInfo_ = null;
                }
                return this.recommendDungeonEntryInfoBuilder_;
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

        public static DailyDungeonEntryInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DailyDungeonEntryInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DailyDungeonEntryInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DailyDungeonEntryInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DungeonEntryInfoOuterClass.getDescriptor();
    }
}
