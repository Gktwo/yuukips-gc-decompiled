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
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopInfoOuterClass.class */
public final class HomeLimitedShopInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019HomeLimitedShopInfo.proto\u001a\fVector.proto\" \u0001\n\u0013HomeLimitedShopInfo\u0012\u0019\n\u0011nextGuestOpenTime\u0018\u000e \u0001(\u0007\u0012\u000b\n\u0003uid\u0018\u0004 \u0001(\r\u0012\u0019\n\bdjinnRot\u0018\f \u0001(\u000b2\u0007.Vector\u0012\u0015\n\rnextCloseTime\u0018\u0002 \u0001(\u0007\u0012\u0019\n\bdjinnPos\u0018\u0006 \u0001(\u000b2\u0007.Vector\u0012\u0014\n\fnextOpenTime\u0018\u000f \u0001(\u0007B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HomeLimitedShopInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HomeLimitedShopInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HomeLimitedShopInfo_descriptor, new String[]{"NextGuestOpenTime", "Uid", "DjinnRot", "NextCloseTime", "DjinnPos", "NextOpenTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopInfoOuterClass$HomeLimitedShopInfoOrBuilder.class */
    public interface HomeLimitedShopInfoOrBuilder extends MessageOrBuilder {
        int getNextGuestOpenTime();

        int getUid();

        boolean hasDjinnRot();

        VectorOuterClass.Vector getDjinnRot();

        VectorOuterClass.VectorOrBuilder getDjinnRotOrBuilder();

        int getNextCloseTime();

        boolean hasDjinnPos();

        VectorOuterClass.Vector getDjinnPos();

        VectorOuterClass.VectorOrBuilder getDjinnPosOrBuilder();

        int getNextOpenTime();
    }

    private HomeLimitedShopInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopInfoOuterClass$HomeLimitedShopInfo.class */
    public static final class HomeLimitedShopInfo extends GeneratedMessageV3 implements HomeLimitedShopInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int NEXTGUESTOPENTIME_FIELD_NUMBER = 14;
        private int nextGuestOpenTime_;
        public static final int UID_FIELD_NUMBER = 4;
        private int uid_;
        public static final int DJINNROT_FIELD_NUMBER = 12;
        private VectorOuterClass.Vector djinnRot_;
        public static final int NEXTCLOSETIME_FIELD_NUMBER = 2;
        private int nextCloseTime_;
        public static final int DJINNPOS_FIELD_NUMBER = 6;
        private VectorOuterClass.Vector djinnPos_;
        public static final int NEXTOPENTIME_FIELD_NUMBER = 15;
        private int nextOpenTime_;
        private byte memoizedIsInitialized;
        private static final HomeLimitedShopInfo DEFAULT_INSTANCE = new HomeLimitedShopInfo();
        private static final Parser<HomeLimitedShopInfo> PARSER = new AbstractParser<HomeLimitedShopInfo>() { // from class: emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfo.1
            @Override // com.google.protobuf.Parser
            public HomeLimitedShopInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HomeLimitedShopInfo(input, extensionRegistry);
            }
        };

        private HomeLimitedShopInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HomeLimitedShopInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HomeLimitedShopInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HomeLimitedShopInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 21:
                                this.nextCloseTime_ = input.readFixed32();
                                break;
                            case 32:
                                this.uid_ = input.readUInt32();
                                break;
                            case 50:
                                VectorOuterClass.Vector.Builder subBuilder = this.djinnPos_ != null ? this.djinnPos_.toBuilder() : null;
                                this.djinnPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.djinnPos_);
                                    this.djinnPos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 98:
                                VectorOuterClass.Vector.Builder subBuilder2 = this.djinnRot_ != null ? this.djinnRot_.toBuilder() : null;
                                this.djinnRot_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.djinnRot_);
                                    this.djinnRot_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 117:
                                this.nextGuestOpenTime_ = input.readFixed32();
                                break;
                            case 125:
                                this.nextOpenTime_ = input.readFixed32();
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
            return HomeLimitedShopInfoOuterClass.internal_static_HomeLimitedShopInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HomeLimitedShopInfoOuterClass.internal_static_HomeLimitedShopInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeLimitedShopInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
        public int getNextGuestOpenTime() {
            return this.nextGuestOpenTime_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
        public boolean hasDjinnRot() {
            return this.djinnRot_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
        public VectorOuterClass.Vector getDjinnRot() {
            return this.djinnRot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.djinnRot_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getDjinnRotOrBuilder() {
            return getDjinnRot();
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
        public int getNextCloseTime() {
            return this.nextCloseTime_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
        public boolean hasDjinnPos() {
            return this.djinnPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
        public VectorOuterClass.Vector getDjinnPos() {
            return this.djinnPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.djinnPos_;
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getDjinnPosOrBuilder() {
            return getDjinnPos();
        }

        @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
        public int getNextOpenTime() {
            return this.nextOpenTime_;
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
            if (this.nextCloseTime_ != 0) {
                output.writeFixed32(2, this.nextCloseTime_);
            }
            if (this.uid_ != 0) {
                output.writeUInt32(4, this.uid_);
            }
            if (this.djinnPos_ != null) {
                output.writeMessage(6, getDjinnPos());
            }
            if (this.djinnRot_ != null) {
                output.writeMessage(12, getDjinnRot());
            }
            if (this.nextGuestOpenTime_ != 0) {
                output.writeFixed32(14, this.nextGuestOpenTime_);
            }
            if (this.nextOpenTime_ != 0) {
                output.writeFixed32(15, this.nextOpenTime_);
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
            if (this.nextCloseTime_ != 0) {
                size2 = 0 + CodedOutputStream.computeFixed32Size(2, this.nextCloseTime_);
            }
            if (this.uid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.uid_);
            }
            if (this.djinnPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(6, getDjinnPos());
            }
            if (this.djinnRot_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getDjinnRot());
            }
            if (this.nextGuestOpenTime_ != 0) {
                size2 += CodedOutputStream.computeFixed32Size(14, this.nextGuestOpenTime_);
            }
            if (this.nextOpenTime_ != 0) {
                size2 += CodedOutputStream.computeFixed32Size(15, this.nextOpenTime_);
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
            if (!(obj instanceof HomeLimitedShopInfo)) {
                return equals(obj);
            }
            HomeLimitedShopInfo other = (HomeLimitedShopInfo) obj;
            if (getNextGuestOpenTime() != other.getNextGuestOpenTime() || getUid() != other.getUid() || hasDjinnRot() != other.hasDjinnRot()) {
                return false;
            }
            if ((!hasDjinnRot() || getDjinnRot().equals(other.getDjinnRot())) && getNextCloseTime() == other.getNextCloseTime() && hasDjinnPos() == other.hasDjinnPos()) {
                return (!hasDjinnPos() || getDjinnPos().equals(other.getDjinnPos())) && getNextOpenTime() == other.getNextOpenTime() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getNextGuestOpenTime())) + 4)) + getUid();
            if (hasDjinnRot()) {
                hash = (53 * ((37 * hash) + 12)) + getDjinnRot().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 2)) + getNextCloseTime();
            if (hasDjinnPos()) {
                hash2 = (53 * ((37 * hash2) + 6)) + getDjinnPos().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 15)) + getNextOpenTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static HomeLimitedShopInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HomeLimitedShopInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HomeLimitedShopInfo parseFrom(InputStream input) throws IOException {
            return (HomeLimitedShopInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeLimitedShopInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeLimitedShopInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (HomeLimitedShopInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HomeLimitedShopInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HomeLimitedShopInfo parseFrom(CodedInputStream input) throws IOException {
            return (HomeLimitedShopInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HomeLimitedShopInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HomeLimitedShopInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HomeLimitedShopInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HomeLimitedShopInfoOuterClass$HomeLimitedShopInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HomeLimitedShopInfoOrBuilder {
            private int nextGuestOpenTime_;
            private int uid_;
            private VectorOuterClass.Vector djinnRot_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> djinnRotBuilder_;
            private int nextCloseTime_;
            private VectorOuterClass.Vector djinnPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> djinnPosBuilder_;
            private int nextOpenTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HomeLimitedShopInfoOuterClass.internal_static_HomeLimitedShopInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HomeLimitedShopInfoOuterClass.internal_static_HomeLimitedShopInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HomeLimitedShopInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HomeLimitedShopInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.nextGuestOpenTime_ = 0;
                this.uid_ = 0;
                if (this.djinnRotBuilder_ == null) {
                    this.djinnRot_ = null;
                } else {
                    this.djinnRot_ = null;
                    this.djinnRotBuilder_ = null;
                }
                this.nextCloseTime_ = 0;
                if (this.djinnPosBuilder_ == null) {
                    this.djinnPos_ = null;
                } else {
                    this.djinnPos_ = null;
                    this.djinnPosBuilder_ = null;
                }
                this.nextOpenTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HomeLimitedShopInfoOuterClass.internal_static_HomeLimitedShopInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HomeLimitedShopInfo getDefaultInstanceForType() {
                return HomeLimitedShopInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeLimitedShopInfo build() {
                HomeLimitedShopInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HomeLimitedShopInfo buildPartial() {
                HomeLimitedShopInfo result = new HomeLimitedShopInfo(this);
                result.nextGuestOpenTime_ = this.nextGuestOpenTime_;
                result.uid_ = this.uid_;
                if (this.djinnRotBuilder_ == null) {
                    result.djinnRot_ = this.djinnRot_;
                } else {
                    result.djinnRot_ = this.djinnRotBuilder_.build();
                }
                result.nextCloseTime_ = this.nextCloseTime_;
                if (this.djinnPosBuilder_ == null) {
                    result.djinnPos_ = this.djinnPos_;
                } else {
                    result.djinnPos_ = this.djinnPosBuilder_.build();
                }
                result.nextOpenTime_ = this.nextOpenTime_;
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
                if (other instanceof HomeLimitedShopInfo) {
                    return mergeFrom((HomeLimitedShopInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HomeLimitedShopInfo other) {
                if (other == HomeLimitedShopInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getNextGuestOpenTime() != 0) {
                    setNextGuestOpenTime(other.getNextGuestOpenTime());
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
                }
                if (other.hasDjinnRot()) {
                    mergeDjinnRot(other.getDjinnRot());
                }
                if (other.getNextCloseTime() != 0) {
                    setNextCloseTime(other.getNextCloseTime());
                }
                if (other.hasDjinnPos()) {
                    mergeDjinnPos(other.getDjinnPos());
                }
                if (other.getNextOpenTime() != 0) {
                    setNextOpenTime(other.getNextOpenTime());
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
                HomeLimitedShopInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = HomeLimitedShopInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HomeLimitedShopInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
            public int getNextGuestOpenTime() {
                return this.nextGuestOpenTime_;
            }

            public Builder setNextGuestOpenTime(int value) {
                this.nextGuestOpenTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearNextGuestOpenTime() {
                this.nextGuestOpenTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
            public int getUid() {
                return this.uid_;
            }

            public Builder setUid(int value) {
                this.uid_ = value;
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
            public boolean hasDjinnRot() {
                return (this.djinnRotBuilder_ == null && this.djinnRot_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
            public VectorOuterClass.Vector getDjinnRot() {
                if (this.djinnRotBuilder_ == null) {
                    return this.djinnRot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.djinnRot_;
                }
                return this.djinnRotBuilder_.getMessage();
            }

            public Builder setDjinnRot(VectorOuterClass.Vector value) {
                if (this.djinnRotBuilder_ != null) {
                    this.djinnRotBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.djinnRot_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setDjinnRot(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.djinnRotBuilder_ == null) {
                    this.djinnRot_ = builderForValue.build();
                    onChanged();
                } else {
                    this.djinnRotBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeDjinnRot(VectorOuterClass.Vector value) {
                if (this.djinnRotBuilder_ == null) {
                    if (this.djinnRot_ != null) {
                        this.djinnRot_ = VectorOuterClass.Vector.newBuilder(this.djinnRot_).mergeFrom(value).buildPartial();
                    } else {
                        this.djinnRot_ = value;
                    }
                    onChanged();
                } else {
                    this.djinnRotBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearDjinnRot() {
                if (this.djinnRotBuilder_ == null) {
                    this.djinnRot_ = null;
                    onChanged();
                } else {
                    this.djinnRot_ = null;
                    this.djinnRotBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getDjinnRotBuilder() {
                onChanged();
                return getDjinnRotFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getDjinnRotOrBuilder() {
                if (this.djinnRotBuilder_ != null) {
                    return this.djinnRotBuilder_.getMessageOrBuilder();
                }
                return this.djinnRot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.djinnRot_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getDjinnRotFieldBuilder() {
                if (this.djinnRotBuilder_ == null) {
                    this.djinnRotBuilder_ = new SingleFieldBuilderV3<>(getDjinnRot(), getParentForChildren(), isClean());
                    this.djinnRot_ = null;
                }
                return this.djinnRotBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
            public int getNextCloseTime() {
                return this.nextCloseTime_;
            }

            public Builder setNextCloseTime(int value) {
                this.nextCloseTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearNextCloseTime() {
                this.nextCloseTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
            public boolean hasDjinnPos() {
                return (this.djinnPosBuilder_ == null && this.djinnPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
            public VectorOuterClass.Vector getDjinnPos() {
                if (this.djinnPosBuilder_ == null) {
                    return this.djinnPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.djinnPos_;
                }
                return this.djinnPosBuilder_.getMessage();
            }

            public Builder setDjinnPos(VectorOuterClass.Vector value) {
                if (this.djinnPosBuilder_ != null) {
                    this.djinnPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.djinnPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setDjinnPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.djinnPosBuilder_ == null) {
                    this.djinnPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.djinnPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeDjinnPos(VectorOuterClass.Vector value) {
                if (this.djinnPosBuilder_ == null) {
                    if (this.djinnPos_ != null) {
                        this.djinnPos_ = VectorOuterClass.Vector.newBuilder(this.djinnPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.djinnPos_ = value;
                    }
                    onChanged();
                } else {
                    this.djinnPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearDjinnPos() {
                if (this.djinnPosBuilder_ == null) {
                    this.djinnPos_ = null;
                    onChanged();
                } else {
                    this.djinnPos_ = null;
                    this.djinnPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getDjinnPosBuilder() {
                onChanged();
                return getDjinnPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getDjinnPosOrBuilder() {
                if (this.djinnPosBuilder_ != null) {
                    return this.djinnPosBuilder_.getMessageOrBuilder();
                }
                return this.djinnPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.djinnPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getDjinnPosFieldBuilder() {
                if (this.djinnPosBuilder_ == null) {
                    this.djinnPosBuilder_ = new SingleFieldBuilderV3<>(getDjinnPos(), getParentForChildren(), isClean());
                    this.djinnPos_ = null;
                }
                return this.djinnPosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HomeLimitedShopInfoOuterClass.HomeLimitedShopInfoOrBuilder
            public int getNextOpenTime() {
                return this.nextOpenTime_;
            }

            public Builder setNextOpenTime(int value) {
                this.nextOpenTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearNextOpenTime() {
                this.nextOpenTime_ = 0;
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

        public static HomeLimitedShopInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HomeLimitedShopInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HomeLimitedShopInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HomeLimitedShopInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VectorOuterClass.getDescriptor();
    }
}
