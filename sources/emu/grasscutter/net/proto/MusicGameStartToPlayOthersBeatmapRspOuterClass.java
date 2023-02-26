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
import emu.grasscutter.net.proto.MusicGameUnknown1EnumOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameStartToPlayOthersBeatmapRspOuterClass.class */
public final class MusicGameStartToPlayOthersBeatmapRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n*MusicGameStartToPlayOthersBeatmapRsp.proto\u001a\u001bMusicGameUnknown1Enum.proto\"{\n$MusicGameStartToPlayOthersBeatmapRsp\u0012\u000f\n\u0007retcode\u0018\u0002 \u0001(\u0005\u0012-\n\runknown_enum1\u0018\u000b \u0001(\u000e2\u0016.MusicGameUnknown1Enum\u0012\u0013\n\u000bAMNODOLNOIM\u0018\u0006 \u0003(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MusicGameUnknown1EnumOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MusicGameStartToPlayOthersBeatmapRsp_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_MusicGameStartToPlayOthersBeatmapRsp_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f793x6a05117 = new GeneratedMessageV3.FieldAccessorTable(internal_static_MusicGameStartToPlayOthersBeatmapRsp_descriptor, new String[]{"Retcode", "UnknownEnum1", "AMNODOLNOIM"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameStartToPlayOthersBeatmapRspOuterClass$MusicGameStartToPlayOthersBeatmapRspOrBuilder.class */
    public interface MusicGameStartToPlayOthersBeatmapRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        int getUnknownEnum1Value();

        MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum getUnknownEnum1();

        List<Long> getAMNODOLNOIMList();

        int getAMNODOLNOIMCount();

        long getAMNODOLNOIM(int i);
    }

    private MusicGameStartToPlayOthersBeatmapRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameStartToPlayOthersBeatmapRspOuterClass$MusicGameStartToPlayOthersBeatmapRsp.class */
    public static final class MusicGameStartToPlayOthersBeatmapRsp extends GeneratedMessageV3 implements MusicGameStartToPlayOthersBeatmapRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 2;
        private int retcode_;
        public static final int UNKNOWN_ENUM1_FIELD_NUMBER = 11;
        private int unknownEnum1_;
        public static final int AMNODOLNOIM_FIELD_NUMBER = 6;
        private Internal.LongList aMNODOLNOIM_;
        private int aMNODOLNOIMMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final MusicGameStartToPlayOthersBeatmapRsp DEFAULT_INSTANCE = new MusicGameStartToPlayOthersBeatmapRsp();
        private static final Parser<MusicGameStartToPlayOthersBeatmapRsp> PARSER = new AbstractParser<MusicGameStartToPlayOthersBeatmapRsp>() { // from class: emu.grasscutter.net.proto.MusicGameStartToPlayOthersBeatmapRspOuterClass.MusicGameStartToPlayOthersBeatmapRsp.1
            @Override // com.google.protobuf.Parser
            public MusicGameStartToPlayOthersBeatmapRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MusicGameStartToPlayOthersBeatmapRsp(input, extensionRegistry);
            }
        };

        private MusicGameStartToPlayOthersBeatmapRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.aMNODOLNOIMMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private MusicGameStartToPlayOthersBeatmapRsp() {
            this.aMNODOLNOIMMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unknownEnum1_ = 0;
            this.aMNODOLNOIM_ = emptyLongList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MusicGameStartToPlayOthersBeatmapRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MusicGameStartToPlayOthersBeatmapRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 16:
                                this.retcode_ = input.readInt32();
                                break;
                            case 48:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.aMNODOLNOIM_ = newLongList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.aMNODOLNOIM_.addLong(input.readUInt64());
                                break;
                            case 50:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.aMNODOLNOIM_ = newLongList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.aMNODOLNOIM_.addLong(input.readUInt64());
                                }
                                input.popLimit(limit);
                                break;
                            case 88:
                                this.unknownEnum1_ = input.readEnum();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.aMNODOLNOIM_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MusicGameStartToPlayOthersBeatmapRspOuterClass.internal_static_MusicGameStartToPlayOthersBeatmapRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MusicGameStartToPlayOthersBeatmapRspOuterClass.f793x6a05117.ensureFieldAccessorsInitialized(MusicGameStartToPlayOthersBeatmapRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MusicGameStartToPlayOthersBeatmapRspOuterClass.MusicGameStartToPlayOthersBeatmapRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameStartToPlayOthersBeatmapRspOuterClass.MusicGameStartToPlayOthersBeatmapRspOrBuilder
        public int getUnknownEnum1Value() {
            return this.unknownEnum1_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameStartToPlayOthersBeatmapRspOuterClass.MusicGameStartToPlayOthersBeatmapRspOrBuilder
        public MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum getUnknownEnum1() {
            MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum result = MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.valueOf(this.unknownEnum1_);
            return result == null ? MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.UNRECOGNIZED : result;
        }

        @Override // emu.grasscutter.net.proto.MusicGameStartToPlayOthersBeatmapRspOuterClass.MusicGameStartToPlayOthersBeatmapRspOrBuilder
        public List<Long> getAMNODOLNOIMList() {
            return this.aMNODOLNOIM_;
        }

        @Override // emu.grasscutter.net.proto.MusicGameStartToPlayOthersBeatmapRspOuterClass.MusicGameStartToPlayOthersBeatmapRspOrBuilder
        public int getAMNODOLNOIMCount() {
            return this.aMNODOLNOIM_.size();
        }

        @Override // emu.grasscutter.net.proto.MusicGameStartToPlayOthersBeatmapRspOuterClass.MusicGameStartToPlayOthersBeatmapRspOrBuilder
        public long getAMNODOLNOIM(int index) {
            return this.aMNODOLNOIM_.getLong(index);
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
            if (this.retcode_ != 0) {
                output.writeInt32(2, this.retcode_);
            }
            if (getAMNODOLNOIMList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.aMNODOLNOIMMemoizedSerializedSize);
            }
            for (int i = 0; i < this.aMNODOLNOIM_.size(); i++) {
                output.writeUInt64NoTag(this.aMNODOLNOIM_.getLong(i));
            }
            if (this.unknownEnum1_ != MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.MusicGameUnknown1Enum_NONE.getNumber()) {
                output.writeEnum(11, this.unknownEnum1_);
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(2, this.retcode_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.aMNODOLNOIM_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt64SizeNoTag(this.aMNODOLNOIM_.getLong(i));
            }
            int size3 = size2 + dataSize;
            if (!getAMNODOLNOIMList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.aMNODOLNOIMMemoizedSerializedSize = dataSize;
            if (this.unknownEnum1_ != MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.MusicGameUnknown1Enum_NONE.getNumber()) {
                size3 += CodedOutputStream.computeEnumSize(11, this.unknownEnum1_);
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MusicGameStartToPlayOthersBeatmapRsp)) {
                return equals(obj);
            }
            MusicGameStartToPlayOthersBeatmapRsp other = (MusicGameStartToPlayOthersBeatmapRsp) obj;
            return getRetcode() == other.getRetcode() && this.unknownEnum1_ == other.unknownEnum1_ && getAMNODOLNOIMList().equals(other.getAMNODOLNOIMList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + getRetcode())) + 11)) + this.unknownEnum1_;
            if (getAMNODOLNOIMCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getAMNODOLNOIMList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MusicGameStartToPlayOthersBeatmapRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameStartToPlayOthersBeatmapRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameStartToPlayOthersBeatmapRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameStartToPlayOthersBeatmapRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameStartToPlayOthersBeatmapRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MusicGameStartToPlayOthersBeatmapRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MusicGameStartToPlayOthersBeatmapRsp parseFrom(InputStream input) throws IOException {
            return (MusicGameStartToPlayOthersBeatmapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameStartToPlayOthersBeatmapRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameStartToPlayOthersBeatmapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameStartToPlayOthersBeatmapRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (MusicGameStartToPlayOthersBeatmapRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MusicGameStartToPlayOthersBeatmapRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameStartToPlayOthersBeatmapRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MusicGameStartToPlayOthersBeatmapRsp parseFrom(CodedInputStream input) throws IOException {
            return (MusicGameStartToPlayOthersBeatmapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MusicGameStartToPlayOthersBeatmapRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MusicGameStartToPlayOthersBeatmapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MusicGameStartToPlayOthersBeatmapRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MusicGameStartToPlayOthersBeatmapRspOuterClass$MusicGameStartToPlayOthersBeatmapRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MusicGameStartToPlayOthersBeatmapRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private int unknownEnum1_ = 0;
            private Internal.LongList aMNODOLNOIM_ = MusicGameStartToPlayOthersBeatmapRsp.emptyLongList();

            public static final Descriptors.Descriptor getDescriptor() {
                return MusicGameStartToPlayOthersBeatmapRspOuterClass.internal_static_MusicGameStartToPlayOthersBeatmapRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MusicGameStartToPlayOthersBeatmapRspOuterClass.f793x6a05117.ensureFieldAccessorsInitialized(MusicGameStartToPlayOthersBeatmapRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MusicGameStartToPlayOthersBeatmapRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.unknownEnum1_ = 0;
                this.aMNODOLNOIM_ = MusicGameStartToPlayOthersBeatmapRsp.emptyLongList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MusicGameStartToPlayOthersBeatmapRspOuterClass.internal_static_MusicGameStartToPlayOthersBeatmapRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MusicGameStartToPlayOthersBeatmapRsp getDefaultInstanceForType() {
                return MusicGameStartToPlayOthersBeatmapRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameStartToPlayOthersBeatmapRsp build() {
                MusicGameStartToPlayOthersBeatmapRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MusicGameStartToPlayOthersBeatmapRsp buildPartial() {
                MusicGameStartToPlayOthersBeatmapRsp result = new MusicGameStartToPlayOthersBeatmapRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                result.unknownEnum1_ = this.unknownEnum1_;
                if ((this.bitField0_ & 1) != 0) {
                    this.aMNODOLNOIM_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.aMNODOLNOIM_ = this.aMNODOLNOIM_;
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
                if (other instanceof MusicGameStartToPlayOthersBeatmapRsp) {
                    return mergeFrom((MusicGameStartToPlayOthersBeatmapRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MusicGameStartToPlayOthersBeatmapRsp other) {
                if (other == MusicGameStartToPlayOthersBeatmapRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.unknownEnum1_ != 0) {
                    setUnknownEnum1Value(other.getUnknownEnum1Value());
                }
                if (!other.aMNODOLNOIM_.isEmpty()) {
                    if (this.aMNODOLNOIM_.isEmpty()) {
                        this.aMNODOLNOIM_ = other.aMNODOLNOIM_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAMNODOLNOIMIsMutable();
                        this.aMNODOLNOIM_.addAll(other.aMNODOLNOIM_);
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
                MusicGameStartToPlayOthersBeatmapRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = MusicGameStartToPlayOthersBeatmapRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MusicGameStartToPlayOthersBeatmapRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicGameStartToPlayOthersBeatmapRspOuterClass.MusicGameStartToPlayOthersBeatmapRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameStartToPlayOthersBeatmapRspOuterClass.MusicGameStartToPlayOthersBeatmapRspOrBuilder
            public int getUnknownEnum1Value() {
                return this.unknownEnum1_;
            }

            public Builder setUnknownEnum1Value(int value) {
                this.unknownEnum1_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MusicGameStartToPlayOthersBeatmapRspOuterClass.MusicGameStartToPlayOthersBeatmapRspOrBuilder
            public MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum getUnknownEnum1() {
                MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum result = MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.valueOf(this.unknownEnum1_);
                return result == null ? MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum.UNRECOGNIZED : result;
            }

            public Builder setUnknownEnum1(MusicGameUnknown1EnumOuterClass.MusicGameUnknown1Enum value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unknownEnum1_ = value.getNumber();
                onChanged();
                return this;
            }

            public Builder clearUnknownEnum1() {
                this.unknownEnum1_ = 0;
                onChanged();
                return this;
            }

            private void ensureAMNODOLNOIMIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.aMNODOLNOIM_ = MusicGameStartToPlayOthersBeatmapRsp.mutableCopy(this.aMNODOLNOIM_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MusicGameStartToPlayOthersBeatmapRspOuterClass.MusicGameStartToPlayOthersBeatmapRspOrBuilder
            public List<Long> getAMNODOLNOIMList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.aMNODOLNOIM_) : this.aMNODOLNOIM_;
            }

            @Override // emu.grasscutter.net.proto.MusicGameStartToPlayOthersBeatmapRspOuterClass.MusicGameStartToPlayOthersBeatmapRspOrBuilder
            public int getAMNODOLNOIMCount() {
                return this.aMNODOLNOIM_.size();
            }

            @Override // emu.grasscutter.net.proto.MusicGameStartToPlayOthersBeatmapRspOuterClass.MusicGameStartToPlayOthersBeatmapRspOrBuilder
            public long getAMNODOLNOIM(int index) {
                return this.aMNODOLNOIM_.getLong(index);
            }

            public Builder setAMNODOLNOIM(int index, long value) {
                ensureAMNODOLNOIMIsMutable();
                this.aMNODOLNOIM_.setLong(index, value);
                onChanged();
                return this;
            }

            public Builder addAMNODOLNOIM(long value) {
                ensureAMNODOLNOIMIsMutable();
                this.aMNODOLNOIM_.addLong(value);
                onChanged();
                return this;
            }

            public Builder addAllAMNODOLNOIM(Iterable<? extends Long> values) {
                ensureAMNODOLNOIMIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.aMNODOLNOIM_);
                onChanged();
                return this;
            }

            public Builder clearAMNODOLNOIM() {
                this.aMNODOLNOIM_ = MusicGameStartToPlayOthersBeatmapRsp.emptyLongList();
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

        public static MusicGameStartToPlayOthersBeatmapRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MusicGameStartToPlayOthersBeatmapRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MusicGameStartToPlayOthersBeatmapRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MusicGameStartToPlayOthersBeatmapRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MusicGameUnknown1EnumOuterClass.getDescriptor();
    }
}
