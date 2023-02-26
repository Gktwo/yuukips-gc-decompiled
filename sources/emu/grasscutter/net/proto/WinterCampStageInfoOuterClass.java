package emu.grasscutter.net.proto;

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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampStageInfoOuterClass.class */
public final class WinterCampStageInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019WinterCampStageInfo.proto\u001a\fVector.proto\"\u0001\n\u0013WinterCampStageInfo\u0012\u0015\n\rtotalProgress\u0018\u000f \u0001(\r\u0012\u0013\n\u000bcurProgress\u0018\u0002 \u0001(\r\u0012\n\n\u0002id\u0018\r \u0001(\r\u0012\u0010\n\bopenTime\u0018\f \u0001(\r\u0012\u0014\n\u0003pos\u0018\u0006 \u0001(\u000b2\u0007.Vector\u0012\u0012\n\nisFinished\u0018\t \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WinterCampStageInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WinterCampStageInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WinterCampStageInfo_descriptor, new String[]{"TotalProgress", "CurProgress", "Id", "OpenTime", "Pos", "IsFinished"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampStageInfoOuterClass$WinterCampStageInfoOrBuilder.class */
    public interface WinterCampStageInfoOrBuilder extends MessageOrBuilder {
        int getTotalProgress();

        int getCurProgress();

        int getId();

        int getOpenTime();

        boolean hasPos();

        VectorOuterClass.Vector getPos();

        VectorOuterClass.VectorOrBuilder getPosOrBuilder();

        boolean getIsFinished();
    }

    private WinterCampStageInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampStageInfoOuterClass$WinterCampStageInfo.class */
    public static final class WinterCampStageInfo extends GeneratedMessageV3 implements WinterCampStageInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TOTALPROGRESS_FIELD_NUMBER = 15;
        private int totalProgress_;
        public static final int CURPROGRESS_FIELD_NUMBER = 2;
        private int curProgress_;
        public static final int ID_FIELD_NUMBER = 13;
        private int id_;
        public static final int OPENTIME_FIELD_NUMBER = 12;
        private int openTime_;
        public static final int POS_FIELD_NUMBER = 6;
        private VectorOuterClass.Vector pos_;
        public static final int ISFINISHED_FIELD_NUMBER = 9;
        private boolean isFinished_;
        private byte memoizedIsInitialized;
        private static final WinterCampStageInfo DEFAULT_INSTANCE = new WinterCampStageInfo();
        private static final Parser<WinterCampStageInfo> PARSER = new AbstractParser<WinterCampStageInfo>() { // from class: emu.grasscutter.net.proto.WinterCampStageInfoOuterClass.WinterCampStageInfo.1
            @Override // com.google.protobuf.Parser
            public WinterCampStageInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WinterCampStageInfo(input, extensionRegistry);
            }
        };

        private WinterCampStageInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WinterCampStageInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WinterCampStageInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WinterCampStageInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.curProgress_ = input.readUInt32();
                                break;
                            case 50:
                                VectorOuterClass.Vector.Builder subBuilder = this.pos_ != null ? this.pos_.toBuilder() : null;
                                this.pos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.pos_);
                                    this.pos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 72:
                                this.isFinished_ = input.readBool();
                                break;
                            case 96:
                                this.openTime_ = input.readUInt32();
                                break;
                            case 104:
                                this.id_ = input.readUInt32();
                                break;
                            case 120:
                                this.totalProgress_ = input.readUInt32();
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
            return WinterCampStageInfoOuterClass.internal_static_WinterCampStageInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WinterCampStageInfoOuterClass.internal_static_WinterCampStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WinterCampStageInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder
        public int getTotalProgress() {
            return this.totalProgress_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder
        public int getCurProgress() {
            return this.curProgress_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder
        public int getOpenTime() {
            return this.openTime_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder
        public VectorOuterClass.Vector getPos() {
            return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // emu.grasscutter.net.proto.WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder
        public boolean getIsFinished() {
            return this.isFinished_;
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
            if (this.curProgress_ != 0) {
                output.writeUInt32(2, this.curProgress_);
            }
            if (this.pos_ != null) {
                output.writeMessage(6, getPos());
            }
            if (this.isFinished_) {
                output.writeBool(9, this.isFinished_);
            }
            if (this.openTime_ != 0) {
                output.writeUInt32(12, this.openTime_);
            }
            if (this.id_ != 0) {
                output.writeUInt32(13, this.id_);
            }
            if (this.totalProgress_ != 0) {
                output.writeUInt32(15, this.totalProgress_);
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
            if (this.curProgress_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.curProgress_);
            }
            if (this.pos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(6, getPos());
            }
            if (this.isFinished_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.isFinished_);
            }
            if (this.openTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.openTime_);
            }
            if (this.id_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.id_);
            }
            if (this.totalProgress_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.totalProgress_);
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
            if (!(obj instanceof WinterCampStageInfo)) {
                return equals(obj);
            }
            WinterCampStageInfo other = (WinterCampStageInfo) obj;
            if (getTotalProgress() == other.getTotalProgress() && getCurProgress() == other.getCurProgress() && getId() == other.getId() && getOpenTime() == other.getOpenTime() && hasPos() == other.hasPos()) {
                return (!hasPos() || getPos().equals(other.getPos())) && getIsFinished() == other.getIsFinished() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getTotalProgress())) + 2)) + getCurProgress())) + 13)) + getId())) + 12)) + getOpenTime();
            if (hasPos()) {
                hash = (53 * ((37 * hash) + 6)) + getPos().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 9)) + Internal.hashBoolean(getIsFinished()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WinterCampStageInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampStageInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampStageInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampStageInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampStageInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampStageInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampStageInfo parseFrom(InputStream input) throws IOException {
            return (WinterCampStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampStageInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampStageInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (WinterCampStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WinterCampStageInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampStageInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampStageInfo parseFrom(CodedInputStream input) throws IOException {
            return (WinterCampStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampStageInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampStageInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WinterCampStageInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampStageInfoOuterClass$WinterCampStageInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WinterCampStageInfoOrBuilder {
            private int totalProgress_;
            private int curProgress_;
            private int id_;
            private int openTime_;
            private VectorOuterClass.Vector pos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> posBuilder_;
            private boolean isFinished_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WinterCampStageInfoOuterClass.internal_static_WinterCampStageInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WinterCampStageInfoOuterClass.internal_static_WinterCampStageInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WinterCampStageInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WinterCampStageInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.totalProgress_ = 0;
                this.curProgress_ = 0;
                this.id_ = 0;
                this.openTime_ = 0;
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                this.isFinished_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WinterCampStageInfoOuterClass.internal_static_WinterCampStageInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WinterCampStageInfo getDefaultInstanceForType() {
                return WinterCampStageInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampStageInfo build() {
                WinterCampStageInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampStageInfo buildPartial() {
                WinterCampStageInfo result = new WinterCampStageInfo(this);
                result.totalProgress_ = this.totalProgress_;
                result.curProgress_ = this.curProgress_;
                result.id_ = this.id_;
                result.openTime_ = this.openTime_;
                if (this.posBuilder_ == null) {
                    result.pos_ = this.pos_;
                } else {
                    result.pos_ = this.posBuilder_.build();
                }
                result.isFinished_ = this.isFinished_;
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
                if (other instanceof WinterCampStageInfo) {
                    return mergeFrom((WinterCampStageInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WinterCampStageInfo other) {
                if (other == WinterCampStageInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getTotalProgress() != 0) {
                    setTotalProgress(other.getTotalProgress());
                }
                if (other.getCurProgress() != 0) {
                    setCurProgress(other.getCurProgress());
                }
                if (other.getId() != 0) {
                    setId(other.getId());
                }
                if (other.getOpenTime() != 0) {
                    setOpenTime(other.getOpenTime());
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
                }
                if (other.getIsFinished()) {
                    setIsFinished(other.getIsFinished());
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
                WinterCampStageInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = WinterCampStageInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WinterCampStageInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder
            public int getTotalProgress() {
                return this.totalProgress_;
            }

            public Builder setTotalProgress(int value) {
                this.totalProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearTotalProgress() {
                this.totalProgress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder
            public int getCurProgress() {
                return this.curProgress_;
            }

            public Builder setCurProgress(int value) {
                this.curProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurProgress() {
                this.curProgress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder
            public int getId() {
                return this.id_;
            }

            public Builder setId(int value) {
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder
            public int getOpenTime() {
                return this.openTime_;
            }

            public Builder setOpenTime(int value) {
                this.openTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearOpenTime() {
                this.openTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder
            public VectorOuterClass.Vector getPos() {
                if (this.posBuilder_ == null) {
                    return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
                }
                return this.posBuilder_.getMessage();
            }

            public Builder setPos(VectorOuterClass.Vector value) {
                if (this.posBuilder_ != null) {
                    this.posBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.pos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.posBuilder_ == null) {
                    this.pos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.posBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePos(VectorOuterClass.Vector value) {
                if (this.posBuilder_ == null) {
                    if (this.pos_ != null) {
                        this.pos_ = VectorOuterClass.Vector.newBuilder(this.pos_).mergeFrom(value).buildPartial();
                    } else {
                        this.pos_ = value;
                    }
                    onChanged();
                } else {
                    this.posBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPos() {
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                    onChanged();
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getPosBuilder() {
                onChanged();
                return getPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
                if (this.posBuilder_ != null) {
                    return this.posBuilder_.getMessageOrBuilder();
                }
                return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getPosFieldBuilder() {
                if (this.posBuilder_ == null) {
                    this.posBuilder_ = new SingleFieldBuilderV3<>(getPos(), getParentForChildren(), isClean());
                    this.pos_ = null;
                }
                return this.posBuilder_;
            }

            @Override // emu.grasscutter.net.proto.WinterCampStageInfoOuterClass.WinterCampStageInfoOrBuilder
            public boolean getIsFinished() {
                return this.isFinished_;
            }

            public Builder setIsFinished(boolean value) {
                this.isFinished_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsFinished() {
                this.isFinished_ = false;
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

        public static WinterCampStageInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WinterCampStageInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WinterCampStageInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WinterCampStageInfo getDefaultInstanceForType() {
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
