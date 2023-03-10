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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MichiaeMatsuriChestPositionInfoOuterClass.class */
public final class MichiaeMatsuriChestPositionInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%MichiaeMatsuriChestPositionInfo.proto\u001a\fVector.proto\"Z\n\u001fMichiaeMatsuriChestPositionInfo\u0012\u000f\n\u0007groupId\u0018\u0004 \u0001(\r\u0012\u0014\n\u0003pos\u0018\r \u0001(\u000b2\u0007.Vector\u0012\u0010\n\bconfigId\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{VectorOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MichiaeMatsuriChestPositionInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_MichiaeMatsuriChestPositionInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f781x8828afd0 = new GeneratedMessageV3.FieldAccessorTable(internal_static_MichiaeMatsuriChestPositionInfo_descriptor, new String[]{"GroupId", "Pos", "ConfigId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MichiaeMatsuriChestPositionInfoOuterClass$MichiaeMatsuriChestPositionInfoOrBuilder.class */
    public interface MichiaeMatsuriChestPositionInfoOrBuilder extends MessageOrBuilder {
        int getGroupId();

        boolean hasPos();

        VectorOuterClass.Vector getPos();

        VectorOuterClass.VectorOrBuilder getPosOrBuilder();

        int getConfigId();
    }

    private MichiaeMatsuriChestPositionInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MichiaeMatsuriChestPositionInfoOuterClass$MichiaeMatsuriChestPositionInfo.class */
    public static final class MichiaeMatsuriChestPositionInfo extends GeneratedMessageV3 implements MichiaeMatsuriChestPositionInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int GROUPID_FIELD_NUMBER = 4;
        private int groupId_;
        public static final int POS_FIELD_NUMBER = 13;
        private VectorOuterClass.Vector pos_;
        public static final int CONFIGID_FIELD_NUMBER = 2;
        private int configId_;
        private byte memoizedIsInitialized;
        private static final MichiaeMatsuriChestPositionInfo DEFAULT_INSTANCE = new MichiaeMatsuriChestPositionInfo();
        private static final Parser<MichiaeMatsuriChestPositionInfo> PARSER = new AbstractParser<MichiaeMatsuriChestPositionInfo>() { // from class: emu.grasscutter.net.proto.MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfo.1
            @Override // com.google.protobuf.Parser
            public MichiaeMatsuriChestPositionInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MichiaeMatsuriChestPositionInfo(input, extensionRegistry);
            }
        };

        private MichiaeMatsuriChestPositionInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MichiaeMatsuriChestPositionInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MichiaeMatsuriChestPositionInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MichiaeMatsuriChestPositionInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 16:
                                    this.configId_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.groupId_ = input.readUInt32();
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MichiaeMatsuriChestPositionInfoOuterClass.internal_static_MichiaeMatsuriChestPositionInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MichiaeMatsuriChestPositionInfoOuterClass.f781x8828afd0.ensureFieldAccessorsInitialized(MichiaeMatsuriChestPositionInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder
        public int getGroupId() {
            return this.groupId_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder
        public boolean hasPos() {
            return this.pos_ != null;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder
        public VectorOuterClass.Vector getPos() {
            return this.pos_ == null ? VectorOuterClass.Vector.getDefaultInstance() : this.pos_;
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder
        public VectorOuterClass.VectorOrBuilder getPosOrBuilder() {
            return getPos();
        }

        @Override // emu.grasscutter.net.proto.MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder
        public int getConfigId() {
            return this.configId_;
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
            if (this.configId_ != 0) {
                output.writeUInt32(2, this.configId_);
            }
            if (this.groupId_ != 0) {
                output.writeUInt32(4, this.groupId_);
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
            if (this.configId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.configId_);
            }
            if (this.groupId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.groupId_);
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
            if (!(obj instanceof MichiaeMatsuriChestPositionInfo)) {
                return equals(obj);
            }
            MichiaeMatsuriChestPositionInfo other = (MichiaeMatsuriChestPositionInfo) obj;
            if (getGroupId() == other.getGroupId() && hasPos() == other.hasPos()) {
                return (!hasPos() || getPos().equals(other.getPos())) && getConfigId() == other.getConfigId() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getGroupId();
            if (hasPos()) {
                hash = (53 * ((37 * hash) + 13)) + getPos().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 2)) + getConfigId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MichiaeMatsuriChestPositionInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MichiaeMatsuriChestPositionInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MichiaeMatsuriChestPositionInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MichiaeMatsuriChestPositionInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MichiaeMatsuriChestPositionInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MichiaeMatsuriChestPositionInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MichiaeMatsuriChestPositionInfo parseFrom(InputStream input) throws IOException {
            return (MichiaeMatsuriChestPositionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MichiaeMatsuriChestPositionInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MichiaeMatsuriChestPositionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MichiaeMatsuriChestPositionInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MichiaeMatsuriChestPositionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MichiaeMatsuriChestPositionInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MichiaeMatsuriChestPositionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MichiaeMatsuriChestPositionInfo parseFrom(CodedInputStream input) throws IOException {
            return (MichiaeMatsuriChestPositionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MichiaeMatsuriChestPositionInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MichiaeMatsuriChestPositionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MichiaeMatsuriChestPositionInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MichiaeMatsuriChestPositionInfoOuterClass$MichiaeMatsuriChestPositionInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MichiaeMatsuriChestPositionInfoOrBuilder {
            private int groupId_;
            private VectorOuterClass.Vector pos_;
            private SingleFieldBuilderV3<VectorOuterClass.Vector, VectorOuterClass.Vector.Builder, VectorOuterClass.VectorOrBuilder> posBuilder_;
            private int configId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MichiaeMatsuriChestPositionInfoOuterClass.internal_static_MichiaeMatsuriChestPositionInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MichiaeMatsuriChestPositionInfoOuterClass.f781x8828afd0.ensureFieldAccessorsInitialized(MichiaeMatsuriChestPositionInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MichiaeMatsuriChestPositionInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.groupId_ = 0;
                if (this.posBuilder_ == null) {
                    this.pos_ = null;
                } else {
                    this.pos_ = null;
                    this.posBuilder_ = null;
                }
                this.configId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MichiaeMatsuriChestPositionInfoOuterClass.internal_static_MichiaeMatsuriChestPositionInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MichiaeMatsuriChestPositionInfo getDefaultInstanceForType() {
                return MichiaeMatsuriChestPositionInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MichiaeMatsuriChestPositionInfo build() {
                MichiaeMatsuriChestPositionInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MichiaeMatsuriChestPositionInfo buildPartial() {
                MichiaeMatsuriChestPositionInfo result = new MichiaeMatsuriChestPositionInfo(this);
                result.groupId_ = this.groupId_;
                if (this.posBuilder_ == null) {
                    result.pos_ = this.pos_;
                } else {
                    result.pos_ = this.posBuilder_.build();
                }
                result.configId_ = this.configId_;
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
                if (other instanceof MichiaeMatsuriChestPositionInfo) {
                    return mergeFrom((MichiaeMatsuriChestPositionInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MichiaeMatsuriChestPositionInfo other) {
                if (other == MichiaeMatsuriChestPositionInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getGroupId() != 0) {
                    setGroupId(other.getGroupId());
                }
                if (other.hasPos()) {
                    mergePos(other.getPos());
                }
                if (other.getConfigId() != 0) {
                    setConfigId(other.getConfigId());
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
                MichiaeMatsuriChestPositionInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = MichiaeMatsuriChestPositionInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MichiaeMatsuriChestPositionInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder
            public int getGroupId() {
                return this.groupId_;
            }

            public Builder setGroupId(int value) {
                this.groupId_ = value;
                onChanged();
                return this;
            }

            public Builder clearGroupId() {
                this.groupId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder
            public boolean hasPos() {
                return (this.posBuilder_ == null && this.pos_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.MichiaeMatsuriChestPositionInfoOuterClass.MichiaeMatsuriChestPositionInfoOrBuilder
            public int getConfigId() {
                return this.configId_;
            }

            public Builder setConfigId(int value) {
                this.configId_ = value;
                onChanged();
                return this;
            }

            public Builder clearConfigId() {
                this.configId_ = 0;
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

        public static MichiaeMatsuriChestPositionInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MichiaeMatsuriChestPositionInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MichiaeMatsuriChestPositionInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MichiaeMatsuriChestPositionInfo getDefaultInstanceForType() {
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
