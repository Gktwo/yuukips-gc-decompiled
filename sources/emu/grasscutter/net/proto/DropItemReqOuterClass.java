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
import emu.grasscutter.net.proto.StoreTypeOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DropItemReqOuterClass.class */
public final class DropItemReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0011DropItemReq.proto\u001a\u000fStoreType.proto\u001a\fVector.proto\"_\n\u000bDropItemReq\u0012\f\n\u0004guid\u0018\n \u0001(\u0004\u0012\r\n\u0005count\u0018\u0003 \u0001(\r\u0012\u001d\n\tstoreType\u0018\f \u0001(\u000e2\n.StoreType\u0012\u0014\n\u0003pos\u0018\r \u0001(\u000b2\u0007.VectorB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{StoreTypeOuterClass.getDescriptor(), VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DropItemReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DropItemReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DropItemReq_descriptor, new String[]{"Guid", "Count", "StoreType", "Pos"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DropItemReqOuterClass$DropItemReqOrBuilder.class */
    public interface DropItemReqOrBuilder extends MessageOrBuilder {
        long getGuid();

        int getCount();

        int getStoreTypeValue();

        StoreTypeOuterClass.StoreType getStoreType();

        boolean hasPos();

        VectorOuterClass.Vector getPos();

        VectorOuterClass.VectorOrBuilder getPosOrBuilder();
    }

    private DropItemReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DropItemReqOuterClass$DropItemReq.class */
    public static final class DropItemReq extends GeneratedMessageV3 implements DropItemReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GUID_FIELD_NUMBER = 10;
        private long guid_;
        public static final int COUNT_FIELD_NUMBER = 3;
        private int count_;
        public static final int STORETYPE_FIELD_NUMBER = 12;
        private int storeType_;
        public static final int POS_FIELD_NUMBER = 13;
        private VectorOuterClass.Vector pos_;
        private byte memoizedIsInitialized;
        private static final DropItemReq DEFAULT_INSTANCE = new DropItemReq();
        private static final Parser<DropItemReq> PARSER = new AbstractParser<DropItemReq>() { // from class: emu.grasscutter.net.proto.DropItemReqOuterClass.DropItemReq.1
            @Override // com.google.protobuf.Parser
            public DropItemReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DropItemReq(input, extensionRegistry);
            }
        };

        private DropItemReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DropItemReq() {
            this.memoizedIsInitialized = -1;
            this.storeType_ = 0;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DropItemReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DropItemReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.count_ = input.readUInt32();
                                break;
                            case 80:
                                this.guid_ = input.readUInt64();
                                break;
                            case 96:
                                this.storeType_ = input.readEnum();
                                break;
                            case 106:
                                VectorOuterClass.Vector.Builder subBuilder = this.pos_ != null ? this.pos_.toBuilder() : null;
                                this.pos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.pos_);
                                    this.pos_ = subBuilder.buildPartial();
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
            return DropItemReqOuterClass.internal_static_DropItemReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DropItemReqOuterClass.internal_static_DropItemReq_fieldAccessorTable.ensureFieldAccessorsInitialized(DropItemReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DropItemReqOuterClass.DropItemReqOrBuilder
        public long getGuid() {
            return this.guid_;
        }

        @Override // emu.grasscutter.net.proto.DropItemReqOuterClass.DropItemReqOrBuilder
        public int getCount() {
            return this.count_;
        }

        @Override // emu.grasscutter.net.proto.DropItemReqOuterClass.DropItemReqOrBuilder
        public int getStoreTypeValue() {
            return this.storeType_;
        }

        @Override // emu.grasscutter.net.proto.DropItemReqOuterClass.DropItemReqOrBuilder
        public StoreTypeOuterClass.StoreType getStoreType() {
            StoreTypeOuterClass.StoreType result = StoreTypeOuterClass.StoreType.valueOf(this.storeType_);
            return result == null ? StoreTypeOuterClass.StoreType.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.DropItemReqOuterClass.DropItemReqOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.DropItemReqOuterClass.DropItemReqOrBuilder
        public VectorOuterClass.Vector getPos() {
            return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.DropItemReqOuterClass.DropItemReqOrBuilder
        public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
            return getPos();
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
            if (this.count_ != 0) {
                output.writeUInt32(3, this.count_);
            }
            if (this.guid_ != 0) {
                output.writeUInt64(10, this.guid_);
            }
            if (this.storeType_ != StoreTypeOuterClass.StoreType.STORE_TYPE_NONE.getNumber()) {
                output.writeEnum(12, this.storeType_);
            }
            if (this.pos_ != null) {
                output.writeMessage(13, getPos());
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
            if (this.count_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.count_);
            }
            if (this.guid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(10, this.guid_);
            }
            if (this.storeType_ != StoreTypeOuterClass.StoreType.STORE_TYPE_NONE.getNumber()) {
                size2 += CodedOutputStream.computeEnumSize(12, this.storeType_);
            }
            if (this.pos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(13, getPos());
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
            if (!(obj instanceof DropItemReq)) {
                return equals(obj);
            }
            DropItemReq other = (DropItemReq) obj;
            if (getGuid() == other.getGuid() && getCount() == other.getCount() && this.storeType_ == other.storeType_ && hasPos() == other.hasPos()) {
                return (!hasPos() || getPos().equals(other.getPos())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 10)) + Internal.hashLong(getGuid()))) + 3)) + getCount())) + 12)) + this.storeType_;
            if (hasPos()) {
                hash = (53 * ((37 * hash) + 13)) + getPos().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DropItemReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DropItemReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DropItemReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DropItemReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DropItemReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DropItemReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DropItemReq parseFrom(InputStream input) throws IOException {
            return (DropItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DropItemReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DropItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DropItemReq parseDelimitedFrom(InputStream input) throws IOException {
            return (DropItemReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DropItemReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DropItemReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DropItemReq parseFrom(CodedInputStream input) throws IOException {
            return (DropItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DropItemReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DropItemReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DropItemReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DropItemReqOuterClass$DropItemReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DropItemReqOrBuilder {
            private long guid_;
            private int count_;
            private int storeType_ = 0;
            private VectorOuterClass.Vector pos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> posBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DropItemReqOuterClass.internal_static_DropItemReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DropItemReqOuterClass.internal_static_DropItemReq_fieldAccessorTable.ensureFieldAccessorsInitialized(DropItemReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DropItemReq.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.guid_ = 0;
                this.count_ = 0;
                this.storeType_ = 0;
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DropItemReqOuterClass.internal_static_DropItemReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DropItemReq getDefaultInstanceForType() {
                return DropItemReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DropItemReq build() {
                DropItemReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DropItemReq buildPartial() {
                DropItemReq result = new DropItemReq(this);
                result.guid_ = this.guid_;
                result.count_ = this.count_;
                result.storeType_ = this.storeType_;
                if (this.posBuilder_ == null) {
                    result.pos_ = this.pos_;
                } else {
                    result.pos_ = this.posBuilder_.build();
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
                if (other instanceof DropItemReq) {
                    return mergeFrom((DropItemReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DropItemReq other) {
                if (other == DropItemReq.getDefaultInstance()) {
                    return this;
                }
                if (other.getGuid() != 0) {
                    setGuid(other.getGuid());
                }
                if (other.getCount() != 0) {
                    setCount(other.getCount());
                }
                if (other.storeType_ != 0) {
                    setStoreTypeValue(other.getStoreTypeValue());
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
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
                DropItemReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = DropItemReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DropItemReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DropItemReqOuterClass.DropItemReqOrBuilder
            public long getGuid() {
                return this.guid_;
            }

            public Builder setGuid(long value) {
                this.guid_ = value;
                onChanged();
                return this;
            }

            public Builder clearGuid() {
                this.guid_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DropItemReqOuterClass.DropItemReqOrBuilder
            public int getCount() {
                return this.count_;
            }

            public Builder setCount(int value) {
                this.count_ = value;
                onChanged();
                return this;
            }

            public Builder clearCount() {
                this.count_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DropItemReqOuterClass.DropItemReqOrBuilder
            public int getStoreTypeValue() {
                return this.storeType_;
            }

            public Builder setStoreTypeValue(int value) {
                this.storeType_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DropItemReqOuterClass.DropItemReqOrBuilder
            public StoreTypeOuterClass.StoreType getStoreType() {
                StoreTypeOuterClass.StoreType result = StoreTypeOuterClass.StoreType.valueOf(this.storeType_);
                return result == null ? StoreTypeOuterClass.StoreType.UNRECOGNIZED : result;
            }

            public Builder setStoreType(StoreTypeOuterClass.StoreType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.storeType_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearStoreType() {
                this.storeType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DropItemReqOuterClass.DropItemReqOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.DropItemReqOuterClass.DropItemReqOrBuilder
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

            @Override // emu.grasscutter.net.proto.DropItemReqOuterClass.DropItemReqOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static DropItemReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DropItemReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DropItemReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DropItemReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        StoreTypeOuterClass.getDescriptor();
        VectorOuterClass.getDescriptor();
    }
}
