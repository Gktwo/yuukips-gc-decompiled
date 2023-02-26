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
import emu.grasscutter.net.proto.LunaRiteHintPointTypeOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LunaRiteHintPointOuterClass.class */
public final class LunaRiteHintPointOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017LunaRiteHintPoint.proto\u001a\fVector.proto\u001a\u001bLunaRiteHintPointType.proto\"n\n\u0011LunaRiteHintPoint\u0012\r\n\u0005index\u0018\u0004 \u0001(\r\u0012\u0014\n\u0003pos\u0018\u000b \u0001(\u000b2\u0007.Vector\u0012\u000e\n\u0006areaId\u0018\u0002 \u0001(\r\u0012$\n\u0004type\u0018\u000f \u0001(\u000e2\u0016.LunaRiteHintPointTypeB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor(), LunaRiteHintPointTypeOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_LunaRiteHintPoint_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_LunaRiteHintPoint_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_LunaRiteHintPoint_descriptor, new String[]{"Index", "Pos", "AreaId", "Type"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LunaRiteHintPointOuterClass$LunaRiteHintPointOrBuilder.class */
    public interface LunaRiteHintPointOrBuilder extends MessageOrBuilder {
        int getIndex();

        boolean hasPos();

        VectorOuterClass.Vector getPos();

        VectorOuterClass.VectorOrBuilder getPosOrBuilder();

        int getAreaId();

        int getTypeValue();

        LunaRiteHintPointTypeOuterClass.LunaRiteHintPointType getType();
    }

    private LunaRiteHintPointOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LunaRiteHintPointOuterClass$LunaRiteHintPoint.class */
    public static final class LunaRiteHintPoint extends GeneratedMessageV3 implements LunaRiteHintPointOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int INDEX_FIELD_NUMBER = 4;
        private int index_;
        public static final int POS_FIELD_NUMBER = 11;
        private VectorOuterClass.Vector pos_;
        public static final int AREAID_FIELD_NUMBER = 2;
        private int areaId_;
        public static final int TYPE_FIELD_NUMBER = 15;
        private int type_;
        private byte memoizedIsInitialized;
        private static final LunaRiteHintPoint DEFAULT_INSTANCE = new LunaRiteHintPoint();
        private static final Parser<LunaRiteHintPoint> PARSER = new AbstractParser<LunaRiteHintPoint>() { // from class: emu.grasscutter.net.proto.LunaRiteHintPointOuterClass.LunaRiteHintPoint.1
            @Override // com.google.protobuf.Parser
            public LunaRiteHintPoint parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LunaRiteHintPoint(input, extensionRegistry);
            }
        };

        private LunaRiteHintPoint(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private LunaRiteHintPoint() {
            this.memoizedIsInitialized = -1;
            this.type_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new LunaRiteHintPoint();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LunaRiteHintPoint(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.areaId_ = input.readUInt32();
                                break;
                            case 32:
                                this.index_ = input.readUInt32();
                                break;
                            case 90:
                                VectorOuterClass.Vector.Builder subBuilder = this.pos_ != null ? this.pos_.toBuilder() : null;
                                this.pos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.pos_);
                                    this.pos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 120:
                                this.type_ = input.readEnum();
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
            return LunaRiteHintPointOuterClass.internal_static_LunaRiteHintPoint_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LunaRiteHintPointOuterClass.internal_static_LunaRiteHintPoint_fieldAccessorTable.ensureFieldAccessorsInitialized(LunaRiteHintPoint.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder
        public int getIndex() {
            return this.index_;
        }

        @Override // emu.grasscutter.net.proto.LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder
        public VectorOuterClass.Vector getPos() {
            return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder
        public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // emu.grasscutter.net.proto.LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder
        public int getAreaId() {
            return this.areaId_;
        }

        @Override // emu.grasscutter.net.proto.LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder
        public int getTypeValue() {
            return this.type_;
        }

        @Override // emu.grasscutter.net.proto.LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder
        public LunaRiteHintPointTypeOuterClass.LunaRiteHintPointType getType() {
            LunaRiteHintPointTypeOuterClass.LunaRiteHintPointType result = LunaRiteHintPointTypeOuterClass.LunaRiteHintPointType.valueOf(this.type_);
            return result == null ? LunaRiteHintPointTypeOuterClass.LunaRiteHintPointType.UNRECOGNIZED : result;
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
            if (this.areaId_ != 0) {
                output.writeUInt32(2, this.areaId_);
            }
            if (this.index_ != 0) {
                output.writeUInt32(4, this.index_);
            }
            if (this.pos_ != null) {
                output.writeMessage(11, getPos());
            }
            if (this.type_ != LunaRiteHintPointTypeOuterClass.LunaRiteHintPointType.LUNA_RITE_HINT_POINT_TYPE_NONE.getNumber()) {
                output.writeEnum(15, this.type_);
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
            if (this.areaId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.areaId_);
            }
            if (this.index_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.index_);
            }
            if (this.pos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getPos());
            }
            if (this.type_ != LunaRiteHintPointTypeOuterClass.LunaRiteHintPointType.LUNA_RITE_HINT_POINT_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(15, this.type_);
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
            if (!(obj instanceof LunaRiteHintPoint)) {
                return equals(obj);
            }
            LunaRiteHintPoint other = (LunaRiteHintPoint) obj;
            if (getIndex() == other.getIndex() && hasPos() == other.hasPos()) {
                return (!hasPos() || getPos().equals(other.getPos())) && getAreaId() == other.getAreaId() && this.type_ == other.type_ && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getIndex();
            if (hasPos()) {
                hash = (53 * ((37 * hash) + 11)) + getPos().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 2)) + getAreaId())) + 15)) + this.type_)) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static LunaRiteHintPoint parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LunaRiteHintPoint parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LunaRiteHintPoint parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LunaRiteHintPoint parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LunaRiteHintPoint parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LunaRiteHintPoint parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LunaRiteHintPoint parseFrom(InputStream input) throws IOException {
            return (LunaRiteHintPoint) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LunaRiteHintPoint parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LunaRiteHintPoint) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static LunaRiteHintPoint parseDelimitedFrom(InputStream input) throws IOException {
            return (LunaRiteHintPoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static LunaRiteHintPoint parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LunaRiteHintPoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static LunaRiteHintPoint parseFrom(CodedInputStream input) throws IOException {
            return (LunaRiteHintPoint) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LunaRiteHintPoint parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LunaRiteHintPoint) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LunaRiteHintPoint prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LunaRiteHintPointOuterClass$LunaRiteHintPoint$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LunaRiteHintPointOrBuilder {
            private int index_;
            private VectorOuterClass.Vector pos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> posBuilder_;
            private int areaId_;
            private int type_ = 0;

            public static final Descriptors.Descriptor getDescriptor() {
                return LunaRiteHintPointOuterClass.internal_static_LunaRiteHintPoint_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LunaRiteHintPointOuterClass.internal_static_LunaRiteHintPoint_fieldAccessorTable.ensureFieldAccessorsInitialized(LunaRiteHintPoint.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LunaRiteHintPoint.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.index_ = 0;
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                this.areaId_ = 0;
                this.type_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LunaRiteHintPointOuterClass.internal_static_LunaRiteHintPoint_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LunaRiteHintPoint getDefaultInstanceForType() {
                return LunaRiteHintPoint.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LunaRiteHintPoint build() {
                LunaRiteHintPoint result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LunaRiteHintPoint buildPartial() {
                LunaRiteHintPoint result = new LunaRiteHintPoint(this);
                result.index_ = this.index_;
                if (this.posBuilder_ == null) {
                    result.pos_ = this.pos_;
                } else {
                    result.pos_ = this.posBuilder_.build();
                }
                result.areaId_ = this.areaId_;
                result.type_ = this.type_;
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
                if (other instanceof LunaRiteHintPoint) {
                    return mergeFrom((LunaRiteHintPoint) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LunaRiteHintPoint other) {
                if (other == LunaRiteHintPoint.getDefaultInstance()) {
                    return this;
                }
                if (other.getIndex() != 0) {
                    setIndex(other.getIndex());
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
                }
                if (other.getAreaId() != 0) {
                    setAreaId(other.getAreaId());
                }
                if (other.type_ != 0) {
                    setTypeValue(other.getTypeValue());
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
                LunaRiteHintPoint parsedMessage = null;
                try {
                    try {
                        parsedMessage = LunaRiteHintPoint.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (LunaRiteHintPoint) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder
            public int getIndex() {
                return this.index_;
            }

            public Builder setIndex(int value) {
                this.index_ = value;
                onChanged();
                return this;
            }

            public Builder clearIndex() {
                this.index_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder
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

            @Override // emu.grasscutter.net.proto.LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder
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

            @Override // emu.grasscutter.net.proto.LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder
            public int getAreaId() {
                return this.areaId_;
            }

            public Builder setAreaId(int value) {
                this.areaId_ = value;
                onChanged();
                return this;
            }

            public Builder clearAreaId() {
                this.areaId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder
            public int getTypeValue() {
                return this.type_;
            }

            public Builder setTypeValue(int value) {
                this.type_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LunaRiteHintPointOuterClass.LunaRiteHintPointOrBuilder
            public LunaRiteHintPointTypeOuterClass.LunaRiteHintPointType getType() {
                LunaRiteHintPointTypeOuterClass.LunaRiteHintPointType result = LunaRiteHintPointTypeOuterClass.LunaRiteHintPointType.valueOf(this.type_);
                return result == null ? LunaRiteHintPointTypeOuterClass.LunaRiteHintPointType.UNRECOGNIZED : result;
            }

            public Builder setType(LunaRiteHintPointTypeOuterClass.LunaRiteHintPointType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.type_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
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

        public static LunaRiteHintPoint getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LunaRiteHintPoint> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LunaRiteHintPoint> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LunaRiteHintPoint getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        VectorOuterClass.getDescriptor();
        LunaRiteHintPointTypeOuterClass.getDescriptor();
    }
}
