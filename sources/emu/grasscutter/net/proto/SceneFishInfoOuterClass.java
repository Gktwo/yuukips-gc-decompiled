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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneFishInfoOuterClass.class */
public final class SceneFishInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013SceneFishInfo.proto\u001a\fVector.proto\"\u0001\n\rSceneFishInfo\u0012\u000e\n\u0006fishId\u0018\u0001 \u0001(\r\u0012\u0018\n\u0010fishPoolEntityId\u0018\u0002 \u0001(\r\u0012\u001c\n\u000bfishPoolPos\u0018\u0003 \u0001(\u000b2\u0007.Vector\u0012\u0018\n\u0010fishPoolGadgetId\u0018\u0004 \u0001(\r\u0012\u0015\n\rlastShockTime\u0018\u0005 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SceneFishInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SceneFishInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SceneFishInfo_descriptor, new String[]{"FishId", "FishPoolEntityId", "FishPoolPos", "FishPoolGadgetId", "LastShockTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneFishInfoOuterClass$SceneFishInfoOrBuilder.class */
    public interface SceneFishInfoOrBuilder extends MessageOrBuilder {
        int getFishId();

        int getFishPoolEntityId();

        boolean hasFishPoolPos();

        VectorOuterClass.Vector getFishPoolPos();

        VectorOuterClass.VectorOrBuilder getFishPoolPosOrBuilder();

        int getFishPoolGadgetId();

        int getLastShockTime();
    }

    private SceneFishInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneFishInfoOuterClass$SceneFishInfo.class */
    public static final class SceneFishInfo extends GeneratedMessageV3 implements SceneFishInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FISHID_FIELD_NUMBER = 1;
        private int fishId_;
        public static final int FISHPOOLENTITYID_FIELD_NUMBER = 2;
        private int fishPoolEntityId_;
        public static final int FISHPOOLPOS_FIELD_NUMBER = 3;
        private VectorOuterClass.Vector fishPoolPos_;
        public static final int FISHPOOLGADGETID_FIELD_NUMBER = 4;
        private int fishPoolGadgetId_;
        public static final int LASTSHOCKTIME_FIELD_NUMBER = 5;
        private int lastShockTime_;
        private byte memoizedIsInitialized;
        private static final SceneFishInfo DEFAULT_INSTANCE = new SceneFishInfo();
        private static final Parser<SceneFishInfo> PARSER = new AbstractParser<SceneFishInfo>() { // from class: emu.grasscutter.net.proto.SceneFishInfoOuterClass.SceneFishInfo.1
            @Override // com.google.protobuf.Parser
            public SceneFishInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SceneFishInfo(input, extensionRegistry);
            }
        };

        private SceneFishInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SceneFishInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SceneFishInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SceneFishInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.fishId_ = input.readUInt32();
                                break;
                            case 16:
                                this.fishPoolEntityId_ = input.readUInt32();
                                break;
                            case 26:
                                VectorOuterClass.Vector.Builder subBuilder = this.fishPoolPos_ != null ? this.fishPoolPos_.toBuilder() : null;
                                this.fishPoolPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.fishPoolPos_);
                                    this.fishPoolPos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 32:
                                this.fishPoolGadgetId_ = input.readUInt32();
                                break;
                            case 40:
                                this.lastShockTime_ = input.readUInt32();
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
            return SceneFishInfoOuterClass.internal_static_SceneFishInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SceneFishInfoOuterClass.internal_static_SceneFishInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneFishInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SceneFishInfoOuterClass.SceneFishInfoOrBuilder
        public int getFishId() {
            return this.fishId_;
        }

        @Override // emu.grasscutter.net.proto.SceneFishInfoOuterClass.SceneFishInfoOrBuilder
        public int getFishPoolEntityId() {
            return this.fishPoolEntityId_;
        }

        @Override // emu.grasscutter.net.proto.SceneFishInfoOuterClass.SceneFishInfoOrBuilder
        public boolean hasFishPoolPos() {
            return this.fishPoolPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.SceneFishInfoOuterClass.SceneFishInfoOrBuilder
        public VectorOuterClass.Vector getFishPoolPos() {
            return this.fishPoolPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.fishPoolPos_;
        }

        @Override // emu.grasscutter.net.proto.SceneFishInfoOuterClass.SceneFishInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getFishPoolPosOrBuilder() {
            return getFishPoolPos();
        }

        @Override // emu.grasscutter.net.proto.SceneFishInfoOuterClass.SceneFishInfoOrBuilder
        public int getFishPoolGadgetId() {
            return this.fishPoolGadgetId_;
        }

        @Override // emu.grasscutter.net.proto.SceneFishInfoOuterClass.SceneFishInfoOrBuilder
        public int getLastShockTime() {
            return this.lastShockTime_;
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
            if (this.fishId_ != 0) {
                output.writeUInt32(1, this.fishId_);
            }
            if (this.fishPoolEntityId_ != 0) {
                output.writeUInt32(2, this.fishPoolEntityId_);
            }
            if (this.fishPoolPos_ != null) {
                output.writeMessage(3, getFishPoolPos());
            }
            if (this.fishPoolGadgetId_ != 0) {
                output.writeUInt32(4, this.fishPoolGadgetId_);
            }
            if (this.lastShockTime_ != 0) {
                output.writeUInt32(5, this.lastShockTime_);
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
            if (this.fishId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.fishId_);
            }
            if (this.fishPoolEntityId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.fishPoolEntityId_);
            }
            if (this.fishPoolPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(3, getFishPoolPos());
            }
            if (this.fishPoolGadgetId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.fishPoolGadgetId_);
            }
            if (this.lastShockTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.lastShockTime_);
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
            if (!(obj instanceof SceneFishInfo)) {
                return equals(obj);
            }
            SceneFishInfo other = (SceneFishInfo) obj;
            if (getFishId() == other.getFishId() && getFishPoolEntityId() == other.getFishPoolEntityId() && hasFishPoolPos() == other.hasFishPoolPos()) {
                return (!hasFishPoolPos() || getFishPoolPos().equals(other.getFishPoolPos())) && getFishPoolGadgetId() == other.getFishPoolGadgetId() && getLastShockTime() == other.getLastShockTime() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getFishId())) + 2)) + getFishPoolEntityId();
            if (hasFishPoolPos()) {
                hash = (53 * ((37 * hash) + 3)) + getFishPoolPos().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 4)) + getFishPoolGadgetId())) + 5)) + getLastShockTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SceneFishInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneFishInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneFishInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneFishInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneFishInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SceneFishInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SceneFishInfo parseFrom(InputStream input) throws IOException {
            return (SceneFishInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneFishInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneFishInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneFishInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SceneFishInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SceneFishInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneFishInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SceneFishInfo parseFrom(CodedInputStream input) throws IOException {
            return (SceneFishInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SceneFishInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SceneFishInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SceneFishInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneFishInfoOuterClass$SceneFishInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SceneFishInfoOrBuilder {
            private int fishId_;
            private int fishPoolEntityId_;
            private VectorOuterClass.Vector fishPoolPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> fishPoolPosBuilder_;
            private int fishPoolGadgetId_;
            private int lastShockTime_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SceneFishInfoOuterClass.internal_static_SceneFishInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SceneFishInfoOuterClass.internal_static_SceneFishInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SceneFishInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SceneFishInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.fishId_ = 0;
                this.fishPoolEntityId_ = 0;
                if (this.fishPoolPosBuilder_ == null) {
                    this.fishPoolPos_ = null;
                } else {
                    this.fishPoolPos_ = null;
                    this.fishPoolPosBuilder_ = null;
                }
                this.fishPoolGadgetId_ = 0;
                this.lastShockTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SceneFishInfoOuterClass.internal_static_SceneFishInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SceneFishInfo getDefaultInstanceForType() {
                return SceneFishInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneFishInfo build() {
                SceneFishInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SceneFishInfo buildPartial() {
                SceneFishInfo result = new SceneFishInfo(this);
                result.fishId_ = this.fishId_;
                result.fishPoolEntityId_ = this.fishPoolEntityId_;
                if (this.fishPoolPosBuilder_ == null) {
                    result.fishPoolPos_ = this.fishPoolPos_;
                } else {
                    result.fishPoolPos_ = this.fishPoolPosBuilder_.build();
                }
                result.fishPoolGadgetId_ = this.fishPoolGadgetId_;
                result.lastShockTime_ = this.lastShockTime_;
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
                if (other instanceof SceneFishInfo) {
                    return mergeFrom((SceneFishInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SceneFishInfo other) {
                if (other == SceneFishInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getFishId() != 0) {
                    setFishId(other.getFishId());
                }
                if (other.getFishPoolEntityId() != 0) {
                    setFishPoolEntityId(other.getFishPoolEntityId());
                }
                if (other.hasFishPoolPos()) {
                    mergeFishPoolPos(other.getFishPoolPos());
                }
                if (other.getFishPoolGadgetId() != 0) {
                    setFishPoolGadgetId(other.getFishPoolGadgetId());
                }
                if (other.getLastShockTime() != 0) {
                    setLastShockTime(other.getLastShockTime());
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
                SceneFishInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SceneFishInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SceneFishInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SceneFishInfoOuterClass.SceneFishInfoOrBuilder
            public int getFishId() {
                return this.fishId_;
            }

            public Builder setFishId(int value) {
                this.fishId_ = value;
                onChanged();
                return this;
            }

            public Builder clearFishId() {
                this.fishId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneFishInfoOuterClass.SceneFishInfoOrBuilder
            public int getFishPoolEntityId() {
                return this.fishPoolEntityId_;
            }

            public Builder setFishPoolEntityId(int value) {
                this.fishPoolEntityId_ = value;
                onChanged();
                return this;
            }

            public Builder clearFishPoolEntityId() {
                this.fishPoolEntityId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneFishInfoOuterClass.SceneFishInfoOrBuilder
            public boolean hasFishPoolPos() {
                return (this.fishPoolPosBuilder_ == null && this.fishPoolPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.SceneFishInfoOuterClass.SceneFishInfoOrBuilder
            public VectorOuterClass.Vector getFishPoolPos() {
                if (this.fishPoolPosBuilder_ == null) {
                    return this.fishPoolPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.fishPoolPos_;
                }
                return this.fishPoolPosBuilder_.getMessage();
            }

            public Builder setFishPoolPos(VectorOuterClass.Vector value) {
                if (this.fishPoolPosBuilder_ != null) {
                    this.fishPoolPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.fishPoolPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setFishPoolPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.fishPoolPosBuilder_ == null) {
                    this.fishPoolPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.fishPoolPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeFishPoolPos(VectorOuterClass.Vector value) {
                if (this.fishPoolPosBuilder_ == null) {
                    if (this.fishPoolPos_ != null) {
                        this.fishPoolPos_ = VectorOuterClass.Vector.newBuilder(this.fishPoolPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.fishPoolPos_ = value;
                    }
                    onChanged();
                } else {
                    this.fishPoolPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearFishPoolPos() {
                if (this.fishPoolPosBuilder_ == null) {
                    this.fishPoolPos_ = null;
                    onChanged();
                } else {
                    this.fishPoolPos_ = null;
                    this.fishPoolPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getFishPoolPosBuilder() {
                onChanged();
                return getFishPoolPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.SceneFishInfoOuterClass.SceneFishInfoOrBuilder
            public VectorOuterClass.VectorOrBuilder getFishPoolPosOrBuilder() {
                if (this.fishPoolPosBuilder_ != null) {
                    return this.fishPoolPosBuilder_.getMessageOrBuilder();
                }
                return this.fishPoolPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.fishPoolPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getFishPoolPosFieldBuilder() {
                if (this.fishPoolPosBuilder_ == null) {
                    this.fishPoolPosBuilder_ = new SingleFieldBuilderV3<>(getFishPoolPos(), getParentForChildren(), isClean());
                    this.fishPoolPos_ = null;
                }
                return this.fishPoolPosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SceneFishInfoOuterClass.SceneFishInfoOrBuilder
            public int getFishPoolGadgetId() {
                return this.fishPoolGadgetId_;
            }

            public Builder setFishPoolGadgetId(int value) {
                this.fishPoolGadgetId_ = value;
                onChanged();
                return this;
            }

            public Builder clearFishPoolGadgetId() {
                this.fishPoolGadgetId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SceneFishInfoOuterClass.SceneFishInfoOrBuilder
            public int getLastShockTime() {
                return this.lastShockTime_;
            }

            public Builder setLastShockTime(int value) {
                this.lastShockTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearLastShockTime() {
                this.lastShockTime_ = 0;
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

        public static SceneFishInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SceneFishInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SceneFishInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SceneFishInfo getDefaultInstanceForType() {
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
