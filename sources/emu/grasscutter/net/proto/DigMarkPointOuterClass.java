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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DigMarkPointOuterClass.class */
public final class DigMarkPointOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012DigMarkPoint.proto\u001a\fVector.proto\"L\n\fDigMarkPoint\u0012\u0014\n\u0003rot\u0018\u000e \u0001(\u000b2\u0007.Vector\u0012\u0014\n\u0003pos\u0018\u0002 \u0001(\u000b2\u0007.Vector\u0012\u0010\n\bbundleId\u0018\u0003 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DigMarkPoint_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DigMarkPoint_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DigMarkPoint_descriptor, new String[]{"Rot", "Pos", "BundleId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DigMarkPointOuterClass$DigMarkPointOrBuilder.class */
    public interface DigMarkPointOrBuilder extends MessageOrBuilder {
        boolean hasRot();

        VectorOuterClass.Vector getRot();

        VectorOuterClass.VectorOrBuilder getRotOrBuilder();

        boolean hasPos();

        VectorOuterClass.Vector getPos();

        VectorOuterClass.VectorOrBuilder getPosOrBuilder();

        int getBundleId();
    }

    private DigMarkPointOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DigMarkPointOuterClass$DigMarkPoint.class */
    public static final class DigMarkPoint extends GeneratedMessageV3 implements DigMarkPointOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ROT_FIELD_NUMBER = 14;
        private VectorOuterClass.Vector rot_;
        public static final int POS_FIELD_NUMBER = 2;
        private VectorOuterClass.Vector pos_;
        public static final int BUNDLEID_FIELD_NUMBER = 3;
        private int bundleId_;
        private byte memoizedIsInitialized;
        private static final DigMarkPoint DEFAULT_INSTANCE = new DigMarkPoint();
        private static final Parser<DigMarkPoint> PARSER = new AbstractParser<DigMarkPoint>() { // from class: emu.grasscutter.net.proto.DigMarkPointOuterClass.DigMarkPoint.1
            @Override // com.google.protobuf.Parser
            public DigMarkPoint parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DigMarkPoint(input, extensionRegistry);
            }
        };

        private DigMarkPoint(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DigMarkPoint() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DigMarkPoint();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DigMarkPoint(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 18:
                                VectorOuterClass.Vector.Builder subBuilder = this.pos_ != null ? this.pos_.toBuilder() : null;
                                this.pos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.pos_);
                                    this.pos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 24:
                                this.bundleId_ = input.readUInt32();
                                break;
                            case 114:
                                VectorOuterClass.Vector.Builder subBuilder2 = this.rot_ != null ? this.rot_.toBuilder() : null;
                                this.rot_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.rot_);
                                    this.rot_ = subBuilder2.buildPartial();
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
            return DigMarkPointOuterClass.internal_static_DigMarkPoint_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DigMarkPointOuterClass.internal_static_DigMarkPoint_fieldAccessorTable.ensureFieldAccessorsInitialized(DigMarkPoint.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DigMarkPointOuterClass.DigMarkPointOrBuilder
        public boolean hasRot() {
            return this.rot_ != null;
        }

        @Override // emu.grasscutter.net.proto.DigMarkPointOuterClass.DigMarkPointOrBuilder
        public VectorOuterClass.Vector getRot() {
            return this.rot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.rot_;
        }

        @Override // emu.grasscutter.net.proto.DigMarkPointOuterClass.DigMarkPointOrBuilder
        public VectorOuterClass.VectorOrBuilder getRotOrBuilder() {
            return getRot();
        }

        @Override // emu.grasscutter.net.proto.DigMarkPointOuterClass.DigMarkPointOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.DigMarkPointOuterClass.DigMarkPointOrBuilder
        public VectorOuterClass.Vector getPos() {
            return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.DigMarkPointOuterClass.DigMarkPointOrBuilder
        public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // emu.grasscutter.net.proto.DigMarkPointOuterClass.DigMarkPointOrBuilder
        public int getBundleId() {
            return this.bundleId_;
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
            if (this.pos_ != null) {
                output.writeMessage(2, getPos());
            }
            if (this.bundleId_ != 0) {
                output.writeUInt32(3, this.bundleId_);
            }
            if (this.rot_ != null) {
                output.writeMessage(14, getRot());
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
            if (this.pos_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, getPos());
            }
            if (this.bundleId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.bundleId_);
            }
            if (this.rot_ != null) {
                size2 += CodedOutputStream.computeMessageSize(14, getRot());
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
            if (!(obj instanceof DigMarkPoint)) {
                return equals(obj);
            }
            DigMarkPoint other = (DigMarkPoint) obj;
            if (hasRot() != other.hasRot()) {
                return false;
            }
            if ((!hasRot() || getRot().equals(other.getRot())) && hasPos() == other.hasPos()) {
                return (!hasPos() || getPos().equals(other.getPos())) && getBundleId() == other.getBundleId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasRot()) {
                hash = (53 * ((37 * hash) + 14)) + getRot().hashCode();
            }
            if (hasPos()) {
                hash = (53 * ((37 * hash) + 2)) + getPos().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 3)) + getBundleId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DigMarkPoint parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DigMarkPoint parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DigMarkPoint parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DigMarkPoint parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DigMarkPoint parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DigMarkPoint parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DigMarkPoint parseFrom(InputStream input) throws IOException {
            return (DigMarkPoint) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DigMarkPoint parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DigMarkPoint) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DigMarkPoint parseDelimitedFrom(InputStream input) throws IOException {
            return (DigMarkPoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DigMarkPoint parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DigMarkPoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DigMarkPoint parseFrom(CodedInputStream input) throws IOException {
            return (DigMarkPoint) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DigMarkPoint parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DigMarkPoint) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DigMarkPoint prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DigMarkPointOuterClass$DigMarkPoint$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DigMarkPointOrBuilder {
            private VectorOuterClass.Vector rot_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> rotBuilder_;
            private VectorOuterClass.Vector pos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> posBuilder_;
            private int bundleId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DigMarkPointOuterClass.internal_static_DigMarkPoint_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DigMarkPointOuterClass.internal_static_DigMarkPoint_fieldAccessorTable.ensureFieldAccessorsInitialized(DigMarkPoint.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DigMarkPoint.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.rotBuilder_ == null) {
                    this.rot_ = null;
                } else {
                    this.rot_ = null;
                    this.rotBuilder_ = null;
                }
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                this.bundleId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DigMarkPointOuterClass.internal_static_DigMarkPoint_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DigMarkPoint getDefaultInstanceForType() {
                return DigMarkPoint.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DigMarkPoint build() {
                DigMarkPoint result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DigMarkPoint buildPartial() {
                DigMarkPoint result = new DigMarkPoint(this);
                if (this.rotBuilder_ == null) {
                    result.rot_ = this.rot_;
                } else {
                    result.rot_ = this.rotBuilder_.build();
                }
                if (this.posBuilder_ == null) {
                    result.pos_ = this.pos_;
                } else {
                    result.pos_ = this.posBuilder_.build();
                }
                result.bundleId_ = this.bundleId_;
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
                if (other instanceof DigMarkPoint) {
                    return mergeFrom((DigMarkPoint) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DigMarkPoint other) {
                if (other == DigMarkPoint.getDefaultInstance()) {
                    return this;
                }
                if (other.hasRot()) {
                    mergeRot(other.getRot());
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
                }
                if (other.getBundleId() != 0) {
                    setBundleId(other.getBundleId());
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
                DigMarkPoint parsedMessage = null;
                try {
                    try {
                        parsedMessage = DigMarkPoint.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DigMarkPoint) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DigMarkPointOuterClass.DigMarkPointOrBuilder
            public boolean hasRot() {
                return (this.rotBuilder_ == null && this.rot_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.DigMarkPointOuterClass.DigMarkPointOrBuilder
            public VectorOuterClass.Vector getRot() {
                if (this.rotBuilder_ == null) {
                    return this.rot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.rot_;
                }
                return this.rotBuilder_.getMessage();
            }

            public Builder setRot(VectorOuterClass.Vector value) {
                if (this.rotBuilder_ != null) {
                    this.rotBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.rot_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRot(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.rotBuilder_ == null) {
                    this.rot_ = builderForValue.build();
                    onChanged();
                } else {
                    this.rotBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRot(VectorOuterClass.Vector value) {
                if (this.rotBuilder_ == null) {
                    if (this.rot_ != null) {
                        this.rot_ = VectorOuterClass.Vector.newBuilder(this.rot_).mergeFrom(value).buildPartial();
                    } else {
                        this.rot_ = value;
                    }
                    onChanged();
                } else {
                    this.rotBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRot() {
                if (this.rotBuilder_ == null) {
                    this.rot_ = null;
                    onChanged();
                } else {
                    this.rot_ = null;
                    this.rotBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getRotBuilder() {
                onChanged();
                return getRotFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.DigMarkPointOuterClass.DigMarkPointOrBuilder
            public VectorOuterClass.VectorOrBuilder getRotOrBuilder() {
                if (this.rotBuilder_ != null) {
                    return this.rotBuilder_.getMessageOrBuilder();
                }
                return this.rot_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.rot_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getRotFieldBuilder() {
                if (this.rotBuilder_ == null) {
                    this.rotBuilder_ = new SingleFieldBuilderV3<>(getRot(), getParentForChildren(), isClean());
                    this.rot_ = null;
                }
                return this.rotBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DigMarkPointOuterClass.DigMarkPointOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.DigMarkPointOuterClass.DigMarkPointOrBuilder
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

            @Override // emu.grasscutter.net.proto.DigMarkPointOuterClass.DigMarkPointOrBuilder
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

            @Override // emu.grasscutter.net.proto.DigMarkPointOuterClass.DigMarkPointOrBuilder
            public int getBundleId() {
                return this.bundleId_;
            }

            public Builder setBundleId(int value) {
                this.bundleId_ = value;
                onChanged();
                return this;
            }

            public Builder clearBundleId() {
                this.bundleId_ = 0;
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

        public static DigMarkPoint getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DigMarkPoint> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DigMarkPoint> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DigMarkPoint getDefaultInstanceForType() {
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
