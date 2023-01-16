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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HitTreeNotifyOuterClass.class */
public final class HitTreeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013HitTreeNotify.proto\u001a\fVector.proto\"X\n\rHitTreeNotify\u0012\u0011\n\ttree_type\u0018\b \u0001(\r\u0012\u0019\n\bdrop_pos\u0018\f \u0001(\u000b2\u0007.Vector\u0012\u0019\n\btree_pos\u0018\u000f \u0001(\u000b2\u0007.VectorB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HitTreeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HitTreeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HitTreeNotify_descriptor, new String[]{"TreeType", "DropPos", "TreePos"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HitTreeNotifyOuterClass$HitTreeNotifyOrBuilder.class */
    public interface HitTreeNotifyOrBuilder extends MessageOrBuilder {
        int getTreeType();

        boolean hasDropPos();

        VectorOuterClass.Vector getDropPos();

        VectorOuterClass.VectorOrBuilder getDropPosOrBuilder();

        boolean hasTreePos();

        VectorOuterClass.Vector getTreePos();

        VectorOuterClass.VectorOrBuilder getTreePosOrBuilder();
    }

    private HitTreeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HitTreeNotifyOuterClass$HitTreeNotify.class */
    public static final class HitTreeNotify extends GeneratedMessageV3 implements HitTreeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TREE_TYPE_FIELD_NUMBER = 8;
        private int treeType_;
        public static final int DROP_POS_FIELD_NUMBER = 12;
        private VectorOuterClass.Vector dropPos_;
        public static final int TREE_POS_FIELD_NUMBER = 15;
        private VectorOuterClass.Vector treePos_;
        private byte memoizedIsInitialized;
        private static final HitTreeNotify DEFAULT_INSTANCE = new HitTreeNotify();
        private static final Parser<HitTreeNotify> PARSER = new AbstractParser<HitTreeNotify>() { // from class: emu.grasscutter.net.proto.HitTreeNotifyOuterClass.HitTreeNotify.1
            @Override // com.google.protobuf.Parser
            public HitTreeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HitTreeNotify(input, extensionRegistry);
            }
        };

        private HitTreeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private HitTreeNotify() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HitTreeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private HitTreeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 64:
                                this.treeType_ = input.readUInt32();
                                break;
                            case 98:
                                VectorOuterClass.Vector.Builder subBuilder = this.dropPos_ != null ? this.dropPos_.toBuilder() : null;
                                this.dropPos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.dropPos_);
                                    this.dropPos_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 122:
                                VectorOuterClass.Vector.Builder subBuilder2 = this.treePos_ != null ? this.treePos_.toBuilder() : null;
                                this.treePos_ = (VectorOuterClass.Vector) input.readMessage(VectorOuterClass.Vector.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.treePos_);
                                    this.treePos_ = subBuilder2.buildPartial();
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
            return HitTreeNotifyOuterClass.internal_static_HitTreeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HitTreeNotifyOuterClass.internal_static_HitTreeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(HitTreeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HitTreeNotifyOuterClass.HitTreeNotifyOrBuilder
        public int getTreeType() {
            return this.treeType_;
        }

        @Override // emu.grasscutter.net.proto.HitTreeNotifyOuterClass.HitTreeNotifyOrBuilder
        public boolean hasDropPos() {
            return this.dropPos_ != null;
        }

        @Override // emu.grasscutter.net.proto.HitTreeNotifyOuterClass.HitTreeNotifyOrBuilder
        public VectorOuterClass.Vector getDropPos() {
            return this.dropPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.dropPos_;
        }

        @Override // emu.grasscutter.net.proto.HitTreeNotifyOuterClass.HitTreeNotifyOrBuilder
        public VectorOuterClass.VectorOrBuilder getDropPosOrBuilder() {
            return getDropPos();
        }

        @Override // emu.grasscutter.net.proto.HitTreeNotifyOuterClass.HitTreeNotifyOrBuilder
        public boolean hasTreePos() {
            return this.treePos_ != null;
        }

        @Override // emu.grasscutter.net.proto.HitTreeNotifyOuterClass.HitTreeNotifyOrBuilder
        public VectorOuterClass.Vector getTreePos() {
            return this.treePos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.treePos_;
        }

        @Override // emu.grasscutter.net.proto.HitTreeNotifyOuterClass.HitTreeNotifyOrBuilder
        public VectorOuterClass.VectorOrBuilder getTreePosOrBuilder() {
            return getTreePos();
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
            if (this.treeType_ != 0) {
                output.writeUInt32(8, this.treeType_);
            }
            if (this.dropPos_ != null) {
                output.writeMessage(12, getDropPos());
            }
            if (this.treePos_ != null) {
                output.writeMessage(15, getTreePos());
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
            if (this.treeType_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(8, this.treeType_);
            }
            if (this.dropPos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getDropPos());
            }
            if (this.treePos_ != null) {
                size2 += CodedOutputStream.computeMessageSize(15, getTreePos());
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
            if (!(obj instanceof HitTreeNotify)) {
                return equals(obj);
            }
            HitTreeNotify other = (HitTreeNotify) obj;
            if (getTreeType() != other.getTreeType() || hasDropPos() != other.hasDropPos()) {
                return false;
            }
            if ((!hasDropPos() || getDropPos().equals(other.getDropPos())) && hasTreePos() == other.hasTreePos()) {
                return (!hasTreePos() || getTreePos().equals(other.getTreePos())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + getTreeType();
            if (hasDropPos()) {
                hash = (53 * ((37 * hash) + 12)) + getDropPos().hashCode();
            }
            if (hasTreePos()) {
                hash = (53 * ((37 * hash) + 15)) + getTreePos().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HitTreeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HitTreeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HitTreeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HitTreeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HitTreeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HitTreeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HitTreeNotify parseFrom(InputStream input) throws IOException {
            return (HitTreeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HitTreeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HitTreeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HitTreeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (HitTreeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HitTreeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HitTreeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HitTreeNotify parseFrom(CodedInputStream input) throws IOException {
            return (HitTreeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HitTreeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HitTreeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HitTreeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HitTreeNotifyOuterClass$HitTreeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HitTreeNotifyOrBuilder {
            private int treeType_;
            private VectorOuterClass.Vector dropPos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> dropPosBuilder_;
            private VectorOuterClass.Vector treePos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> treePosBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return HitTreeNotifyOuterClass.internal_static_HitTreeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HitTreeNotifyOuterClass.internal_static_HitTreeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(HitTreeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HitTreeNotify.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.treeType_ = 0;
                if (this.dropPosBuilder_ == null) {
                    this.dropPos_ = null;
                } else {
                    this.dropPos_ = null;
                    this.dropPosBuilder_ = null;
                }
                if (this.treePosBuilder_ == null) {
                    this.treePos_ = null;
                } else {
                    this.treePos_ = null;
                    this.treePosBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HitTreeNotifyOuterClass.internal_static_HitTreeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HitTreeNotify getDefaultInstanceForType() {
                return HitTreeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HitTreeNotify build() {
                HitTreeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HitTreeNotify buildPartial() {
                HitTreeNotify result = new HitTreeNotify(this);
                result.treeType_ = this.treeType_;
                if (this.dropPosBuilder_ == null) {
                    result.dropPos_ = this.dropPos_;
                } else {
                    result.dropPos_ = this.dropPosBuilder_.build();
                }
                if (this.treePosBuilder_ == null) {
                    result.treePos_ = this.treePos_;
                } else {
                    result.treePos_ = this.treePosBuilder_.build();
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
                if (other instanceof HitTreeNotify) {
                    return mergeFrom((HitTreeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HitTreeNotify other) {
                if (other == HitTreeNotify.getDefaultInstance()) {
                    return this;
                }
                if (other.getTreeType() != 0) {
                    setTreeType(other.getTreeType());
                }
                if (other.hasDropPos()) {
                    mergeDropPos(other.getDropPos());
                }
                if (other.hasTreePos()) {
                    mergeTreePos(other.getTreePos());
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
                HitTreeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = HitTreeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HitTreeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.HitTreeNotifyOuterClass.HitTreeNotifyOrBuilder
            public int getTreeType() {
                return this.treeType_;
            }

            public Builder setTreeType(int value) {
                this.treeType_ = value;
                onChanged();
                return this;
            }

            public Builder clearTreeType() {
                this.treeType_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.HitTreeNotifyOuterClass.HitTreeNotifyOrBuilder
            public boolean hasDropPos() {
                return (this.dropPosBuilder_ == null && this.dropPos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HitTreeNotifyOuterClass.HitTreeNotifyOrBuilder
            public VectorOuterClass.Vector getDropPos() {
                if (this.dropPosBuilder_ == null) {
                    return this.dropPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.dropPos_;
                }
                return this.dropPosBuilder_.getMessage();
            }

            public Builder setDropPos(VectorOuterClass.Vector value) {
                if (this.dropPosBuilder_ != null) {
                    this.dropPosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.dropPos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setDropPos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.dropPosBuilder_ == null) {
                    this.dropPos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.dropPosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeDropPos(VectorOuterClass.Vector value) {
                if (this.dropPosBuilder_ == null) {
                    if (this.dropPos_ != null) {
                        this.dropPos_ = VectorOuterClass.Vector.newBuilder(this.dropPos_).mergeFrom(value).buildPartial();
                    } else {
                        this.dropPos_ = value;
                    }
                    onChanged();
                } else {
                    this.dropPosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearDropPos() {
                if (this.dropPosBuilder_ == null) {
                    this.dropPos_ = null;
                    onChanged();
                } else {
                    this.dropPos_ = null;
                    this.dropPosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getDropPosBuilder() {
                onChanged();
                return getDropPosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HitTreeNotifyOuterClass.HitTreeNotifyOrBuilder
            public VectorOuterClass.VectorOrBuilder getDropPosOrBuilder() {
                if (this.dropPosBuilder_ != null) {
                    return this.dropPosBuilder_.getMessageOrBuilder();
                }
                return this.dropPos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.dropPos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getDropPosFieldBuilder() {
                if (this.dropPosBuilder_ == null) {
                    this.dropPosBuilder_ = new SingleFieldBuilderV3<>(getDropPos(), getParentForChildren(), isClean());
                    this.dropPos_ = null;
                }
                return this.dropPosBuilder_;
            }

            @Override // emu.grasscutter.net.proto.HitTreeNotifyOuterClass.HitTreeNotifyOrBuilder
            public boolean hasTreePos() {
                return (this.treePosBuilder_ == null && this.treePos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.HitTreeNotifyOuterClass.HitTreeNotifyOrBuilder
            public VectorOuterClass.Vector getTreePos() {
                if (this.treePosBuilder_ == null) {
                    return this.treePos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.treePos_;
                }
                return this.treePosBuilder_.getMessage();
            }

            public Builder setTreePos(VectorOuterClass.Vector value) {
                if (this.treePosBuilder_ != null) {
                    this.treePosBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.treePos_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setTreePos(VectorOuterClass.Vector.Builder builderForValue) {
                if (this.treePosBuilder_ == null) {
                    this.treePos_ = builderForValue.build();
                    onChanged();
                } else {
                    this.treePosBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeTreePos(VectorOuterClass.Vector value) {
                if (this.treePosBuilder_ == null) {
                    if (this.treePos_ != null) {
                        this.treePos_ = VectorOuterClass.Vector.newBuilder(this.treePos_).mergeFrom(value).buildPartial();
                    } else {
                        this.treePos_ = value;
                    }
                    onChanged();
                } else {
                    this.treePosBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearTreePos() {
                if (this.treePosBuilder_ == null) {
                    this.treePos_ = null;
                    onChanged();
                } else {
                    this.treePos_ = null;
                    this.treePosBuilder_ = null;
                }
                return this;
            }

            public VectorOuterClass.Vector.Builder getTreePosBuilder() {
                onChanged();
                return getTreePosFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.HitTreeNotifyOuterClass.HitTreeNotifyOrBuilder
            public VectorOuterClass.VectorOrBuilder getTreePosOrBuilder() {
                if (this.treePosBuilder_ != null) {
                    return this.treePosBuilder_.getMessageOrBuilder();
                }
                return this.treePos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.treePos_;
            }

            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> getTreePosFieldBuilder() {
                if (this.treePosBuilder_ == null) {
                    this.treePosBuilder_ = new SingleFieldBuilderV3<>(getTreePos(), getParentForChildren(), isClean());
                    this.treePos_ = null;
                }
                return this.treePosBuilder_;
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

        public static HitTreeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HitTreeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HitTreeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HitTreeNotify getDefaultInstanceForType() {
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
