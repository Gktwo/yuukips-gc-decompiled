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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampAcceptItemResultInfoOuterClass.class */
public final class WinterCampAcceptItemResultInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$WinterCampAcceptItemResultInfo.proto\u001a\u000fItemParam.proto\"\n\u001eWinterCampAcceptItemResultInfo\u0012\u000b\n\u0003uid\u0018\u0006 \u0001(\r\u0012'\n\u0013Unk3300_ILELLFNPDFJ\u0018\t \u0003(\u000b2\n.ItemParam\u0012'\n\u0013Unk3300_JHKOMCFHAOG\u0018\u000b \u0003(\u000b2\n.ItemParamB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WinterCampAcceptItemResultInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_WinterCampAcceptItemResultInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f914x51c89491 = new GeneratedMessageV3.FieldAccessorTable(internal_static_WinterCampAcceptItemResultInfo_descriptor, new String[]{"Uid", "Unk3300ILELLFNPDFJ", "Unk3300JHKOMCFHAOG"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampAcceptItemResultInfoOuterClass$WinterCampAcceptItemResultInfoOrBuilder.class */
    public interface WinterCampAcceptItemResultInfoOrBuilder extends MessageOrBuilder {
        int getUid();

        List<ItemParamOuterClass.ItemParam> getUnk3300ILELLFNPDFJList();

        ItemParamOuterClass.ItemParam getUnk3300ILELLFNPDFJ(int i);

        int getUnk3300ILELLFNPDFJCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getUnk3300ILELLFNPDFJOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getUnk3300ILELLFNPDFJOrBuilder(int i);

        List<ItemParamOuterClass.ItemParam> getUnk3300JHKOMCFHAOGList();

        ItemParamOuterClass.ItemParam getUnk3300JHKOMCFHAOG(int i);

        int getUnk3300JHKOMCFHAOGCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getUnk3300JHKOMCFHAOGOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getUnk3300JHKOMCFHAOGOrBuilder(int i);
    }

    private WinterCampAcceptItemResultInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampAcceptItemResultInfoOuterClass$WinterCampAcceptItemResultInfo.class */
    public static final class WinterCampAcceptItemResultInfo extends GeneratedMessageV3 implements WinterCampAcceptItemResultInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UID_FIELD_NUMBER = 6;
        private int uid_;
        public static final int UNK3300_ILELLFNPDFJ_FIELD_NUMBER = 9;
        private List<ItemParamOuterClass.ItemParam> unk3300ILELLFNPDFJ_;
        public static final int UNK3300_JHKOMCFHAOG_FIELD_NUMBER = 11;
        private List<ItemParamOuterClass.ItemParam> unk3300JHKOMCFHAOG_;
        private byte memoizedIsInitialized;
        private static final WinterCampAcceptItemResultInfo DEFAULT_INSTANCE = new WinterCampAcceptItemResultInfo();
        private static final Parser<WinterCampAcceptItemResultInfo> PARSER = new AbstractParser<WinterCampAcceptItemResultInfo>() { // from class: emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfo.1
            @Override // com.google.protobuf.Parser
            public WinterCampAcceptItemResultInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WinterCampAcceptItemResultInfo(input, extensionRegistry);
            }
        };

        private WinterCampAcceptItemResultInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WinterCampAcceptItemResultInfo() {
            this.memoizedIsInitialized = -1;
            this.unk3300ILELLFNPDFJ_ = Collections.emptyList();
            this.unk3300JHKOMCFHAOG_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WinterCampAcceptItemResultInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:60:0x00cb */
        private WinterCampAcceptItemResultInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 48:
                                this.uid_ = input.readUInt32();
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.unk3300ILELLFNPDFJ_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.unk3300ILELLFNPDFJ_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            case 90:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unk3300JHKOMCFHAOG_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.unk3300JHKOMCFHAOG_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.unk3300ILELLFNPDFJ_ = Collections.unmodifiableList(this.unk3300ILELLFNPDFJ_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unk3300JHKOMCFHAOG_ = Collections.unmodifiableList(this.unk3300JHKOMCFHAOG_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WinterCampAcceptItemResultInfoOuterClass.internal_static_WinterCampAcceptItemResultInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WinterCampAcceptItemResultInfoOuterClass.f914x51c89491.ensureFieldAccessorsInitialized(WinterCampAcceptItemResultInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
        public List<ItemParamOuterClass.ItemParam> getUnk3300ILELLFNPDFJList() {
            return this.unk3300ILELLFNPDFJ_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getUnk3300ILELLFNPDFJOrBuilderList() {
            return this.unk3300ILELLFNPDFJ_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
        public int getUnk3300ILELLFNPDFJCount() {
            return this.unk3300ILELLFNPDFJ_.size();
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
        public ItemParamOuterClass.ItemParam getUnk3300ILELLFNPDFJ(int index) {
            return this.unk3300ILELLFNPDFJ_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getUnk3300ILELLFNPDFJOrBuilder(int index) {
            return this.unk3300ILELLFNPDFJ_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
        public List<ItemParamOuterClass.ItemParam> getUnk3300JHKOMCFHAOGList() {
            return this.unk3300JHKOMCFHAOG_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getUnk3300JHKOMCFHAOGOrBuilderList() {
            return this.unk3300JHKOMCFHAOG_;
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
        public int getUnk3300JHKOMCFHAOGCount() {
            return this.unk3300JHKOMCFHAOG_.size();
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
        public ItemParamOuterClass.ItemParam getUnk3300JHKOMCFHAOG(int index) {
            return this.unk3300JHKOMCFHAOG_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getUnk3300JHKOMCFHAOGOrBuilder(int index) {
            return this.unk3300JHKOMCFHAOG_.get(index);
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
            if (this.uid_ != 0) {
                output.writeUInt32(6, this.uid_);
            }
            for (int i = 0; i < this.unk3300ILELLFNPDFJ_.size(); i++) {
                output.writeMessage(9, this.unk3300ILELLFNPDFJ_.get(i));
            }
            for (int i2 = 0; i2 < this.unk3300JHKOMCFHAOG_.size(); i2++) {
                output.writeMessage(11, this.unk3300JHKOMCFHAOG_.get(i2));
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
            if (this.uid_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.uid_);
            }
            for (int i = 0; i < this.unk3300ILELLFNPDFJ_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.unk3300ILELLFNPDFJ_.get(i));
            }
            for (int i2 = 0; i2 < this.unk3300JHKOMCFHAOG_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.unk3300JHKOMCFHAOG_.get(i2));
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
            if (!(obj instanceof WinterCampAcceptItemResultInfo)) {
                return equals(obj);
            }
            WinterCampAcceptItemResultInfo other = (WinterCampAcceptItemResultInfo) obj;
            return getUid() == other.getUid() && getUnk3300ILELLFNPDFJList().equals(other.getUnk3300ILELLFNPDFJList()) && getUnk3300JHKOMCFHAOGList().equals(other.getUnk3300JHKOMCFHAOGList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getUid();
            if (getUnk3300ILELLFNPDFJCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getUnk3300ILELLFNPDFJList().hashCode();
            }
            if (getUnk3300JHKOMCFHAOGCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getUnk3300JHKOMCFHAOGList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WinterCampAcceptItemResultInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampAcceptItemResultInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampAcceptItemResultInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampAcceptItemResultInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampAcceptItemResultInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WinterCampAcceptItemResultInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WinterCampAcceptItemResultInfo parseFrom(InputStream input) throws IOException {
            return (WinterCampAcceptItemResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampAcceptItemResultInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampAcceptItemResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampAcceptItemResultInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (WinterCampAcceptItemResultInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WinterCampAcceptItemResultInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampAcceptItemResultInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WinterCampAcceptItemResultInfo parseFrom(CodedInputStream input) throws IOException {
            return (WinterCampAcceptItemResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WinterCampAcceptItemResultInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WinterCampAcceptItemResultInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WinterCampAcceptItemResultInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WinterCampAcceptItemResultInfoOuterClass$WinterCampAcceptItemResultInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WinterCampAcceptItemResultInfoOrBuilder {
            private int bitField0_;
            private int uid_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> unk3300ILELLFNPDFJBuilder_;
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> unk3300JHKOMCFHAOGBuilder_;
            private List<ItemParamOuterClass.ItemParam> unk3300ILELLFNPDFJ_ = Collections.emptyList();
            private List<ItemParamOuterClass.ItemParam> unk3300JHKOMCFHAOG_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return WinterCampAcceptItemResultInfoOuterClass.internal_static_WinterCampAcceptItemResultInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WinterCampAcceptItemResultInfoOuterClass.f914x51c89491.ensureFieldAccessorsInitialized(WinterCampAcceptItemResultInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WinterCampAcceptItemResultInfo.alwaysUseFieldBuilders) {
                    getUnk3300ILELLFNPDFJFieldBuilder();
                    getUnk3300JHKOMCFHAOGFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.uid_ = 0;
                if (this.unk3300ILELLFNPDFJBuilder_ == null) {
                    this.unk3300ILELLFNPDFJ_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.unk3300ILELLFNPDFJBuilder_.clear();
                }
                if (this.unk3300JHKOMCFHAOGBuilder_ == null) {
                    this.unk3300JHKOMCFHAOG_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.unk3300JHKOMCFHAOGBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WinterCampAcceptItemResultInfoOuterClass.internal_static_WinterCampAcceptItemResultInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WinterCampAcceptItemResultInfo getDefaultInstanceForType() {
                return WinterCampAcceptItemResultInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampAcceptItemResultInfo build() {
                WinterCampAcceptItemResultInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WinterCampAcceptItemResultInfo buildPartial() {
                WinterCampAcceptItemResultInfo result = new WinterCampAcceptItemResultInfo(this);
                int i = this.bitField0_;
                result.uid_ = this.uid_;
                if (this.unk3300ILELLFNPDFJBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.unk3300ILELLFNPDFJ_ = Collections.unmodifiableList(this.unk3300ILELLFNPDFJ_);
                        this.bitField0_ &= -2;
                    }
                    result.unk3300ILELLFNPDFJ_ = this.unk3300ILELLFNPDFJ_;
                } else {
                    result.unk3300ILELLFNPDFJ_ = this.unk3300ILELLFNPDFJBuilder_.build();
                }
                if (this.unk3300JHKOMCFHAOGBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.unk3300JHKOMCFHAOG_ = Collections.unmodifiableList(this.unk3300JHKOMCFHAOG_);
                        this.bitField0_ &= -3;
                    }
                    result.unk3300JHKOMCFHAOG_ = this.unk3300JHKOMCFHAOG_;
                } else {
                    result.unk3300JHKOMCFHAOG_ = this.unk3300JHKOMCFHAOGBuilder_.build();
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
                if (other instanceof WinterCampAcceptItemResultInfo) {
                    return mergeFrom((WinterCampAcceptItemResultInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WinterCampAcceptItemResultInfo other) {
                if (other == WinterCampAcceptItemResultInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
                }
                if (this.unk3300ILELLFNPDFJBuilder_ == null) {
                    if (!other.unk3300ILELLFNPDFJ_.isEmpty()) {
                        if (this.unk3300ILELLFNPDFJ_.isEmpty()) {
                            this.unk3300ILELLFNPDFJ_ = other.unk3300ILELLFNPDFJ_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureUnk3300ILELLFNPDFJIsMutable();
                            this.unk3300ILELLFNPDFJ_.addAll(other.unk3300ILELLFNPDFJ_);
                        }
                        onChanged();
                    }
                } else if (!other.unk3300ILELLFNPDFJ_.isEmpty()) {
                    if (this.unk3300ILELLFNPDFJBuilder_.isEmpty()) {
                        this.unk3300ILELLFNPDFJBuilder_.dispose();
                        this.unk3300ILELLFNPDFJBuilder_ = null;
                        this.unk3300ILELLFNPDFJ_ = other.unk3300ILELLFNPDFJ_;
                        this.bitField0_ &= -2;
                        this.unk3300ILELLFNPDFJBuilder_ = WinterCampAcceptItemResultInfo.alwaysUseFieldBuilders ? getUnk3300ILELLFNPDFJFieldBuilder() : null;
                    } else {
                        this.unk3300ILELLFNPDFJBuilder_.addAllMessages(other.unk3300ILELLFNPDFJ_);
                    }
                }
                if (this.unk3300JHKOMCFHAOGBuilder_ == null) {
                    if (!other.unk3300JHKOMCFHAOG_.isEmpty()) {
                        if (this.unk3300JHKOMCFHAOG_.isEmpty()) {
                            this.unk3300JHKOMCFHAOG_ = other.unk3300JHKOMCFHAOG_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureUnk3300JHKOMCFHAOGIsMutable();
                            this.unk3300JHKOMCFHAOG_.addAll(other.unk3300JHKOMCFHAOG_);
                        }
                        onChanged();
                    }
                } else if (!other.unk3300JHKOMCFHAOG_.isEmpty()) {
                    if (this.unk3300JHKOMCFHAOGBuilder_.isEmpty()) {
                        this.unk3300JHKOMCFHAOGBuilder_.dispose();
                        this.unk3300JHKOMCFHAOGBuilder_ = null;
                        this.unk3300JHKOMCFHAOG_ = other.unk3300JHKOMCFHAOG_;
                        this.bitField0_ &= -3;
                        this.unk3300JHKOMCFHAOGBuilder_ = WinterCampAcceptItemResultInfo.alwaysUseFieldBuilders ? getUnk3300JHKOMCFHAOGFieldBuilder() : null;
                    } else {
                        this.unk3300JHKOMCFHAOGBuilder_.addAllMessages(other.unk3300JHKOMCFHAOG_);
                    }
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
                WinterCampAcceptItemResultInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = WinterCampAcceptItemResultInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WinterCampAcceptItemResultInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
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

            private void ensureUnk3300ILELLFNPDFJIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unk3300ILELLFNPDFJ_ = new ArrayList(this.unk3300ILELLFNPDFJ_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
            public List<ItemParamOuterClass.ItemParam> getUnk3300ILELLFNPDFJList() {
                if (this.unk3300ILELLFNPDFJBuilder_ == null) {
                    return Collections.unmodifiableList(this.unk3300ILELLFNPDFJ_);
                }
                return this.unk3300ILELLFNPDFJBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
            public int getUnk3300ILELLFNPDFJCount() {
                if (this.unk3300ILELLFNPDFJBuilder_ == null) {
                    return this.unk3300ILELLFNPDFJ_.size();
                }
                return this.unk3300ILELLFNPDFJBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
            public ItemParamOuterClass.ItemParam getUnk3300ILELLFNPDFJ(int index) {
                if (this.unk3300ILELLFNPDFJBuilder_ == null) {
                    return this.unk3300ILELLFNPDFJ_.get(index);
                }
                return this.unk3300ILELLFNPDFJBuilder_.getMessage(index);
            }

            public Builder setUnk3300ILELLFNPDFJ(int index, ItemParamOuterClass.ItemParam value) {
                if (this.unk3300ILELLFNPDFJBuilder_ != null) {
                    this.unk3300ILELLFNPDFJBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk3300ILELLFNPDFJIsMutable();
                    this.unk3300ILELLFNPDFJ_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUnk3300ILELLFNPDFJ(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.unk3300ILELLFNPDFJBuilder_ == null) {
                    ensureUnk3300ILELLFNPDFJIsMutable();
                    this.unk3300ILELLFNPDFJ_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unk3300ILELLFNPDFJBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUnk3300ILELLFNPDFJ(ItemParamOuterClass.ItemParam value) {
                if (this.unk3300ILELLFNPDFJBuilder_ != null) {
                    this.unk3300ILELLFNPDFJBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk3300ILELLFNPDFJIsMutable();
                    this.unk3300ILELLFNPDFJ_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnk3300ILELLFNPDFJ(int index, ItemParamOuterClass.ItemParam value) {
                if (this.unk3300ILELLFNPDFJBuilder_ != null) {
                    this.unk3300ILELLFNPDFJBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk3300ILELLFNPDFJIsMutable();
                    this.unk3300ILELLFNPDFJ_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnk3300ILELLFNPDFJ(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.unk3300ILELLFNPDFJBuilder_ == null) {
                    ensureUnk3300ILELLFNPDFJIsMutable();
                    this.unk3300ILELLFNPDFJ_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.unk3300ILELLFNPDFJBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUnk3300ILELLFNPDFJ(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.unk3300ILELLFNPDFJBuilder_ == null) {
                    ensureUnk3300ILELLFNPDFJIsMutable();
                    this.unk3300ILELLFNPDFJ_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unk3300ILELLFNPDFJBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUnk3300ILELLFNPDFJ(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.unk3300ILELLFNPDFJBuilder_ == null) {
                    ensureUnk3300ILELLFNPDFJIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300ILELLFNPDFJ_);
                    onChanged();
                } else {
                    this.unk3300ILELLFNPDFJBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUnk3300ILELLFNPDFJ() {
                if (this.unk3300ILELLFNPDFJBuilder_ == null) {
                    this.unk3300ILELLFNPDFJ_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.unk3300ILELLFNPDFJBuilder_.clear();
                }
                return this;
            }

            public Builder removeUnk3300ILELLFNPDFJ(int index) {
                if (this.unk3300ILELLFNPDFJBuilder_ == null) {
                    ensureUnk3300ILELLFNPDFJIsMutable();
                    this.unk3300ILELLFNPDFJ_.remove(index);
                    onChanged();
                } else {
                    this.unk3300ILELLFNPDFJBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getUnk3300ILELLFNPDFJBuilder(int index) {
                return getUnk3300ILELLFNPDFJFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getUnk3300ILELLFNPDFJOrBuilder(int index) {
                if (this.unk3300ILELLFNPDFJBuilder_ == null) {
                    return this.unk3300ILELLFNPDFJ_.get(index);
                }
                return this.unk3300ILELLFNPDFJBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getUnk3300ILELLFNPDFJOrBuilderList() {
                if (this.unk3300ILELLFNPDFJBuilder_ != null) {
                    return this.unk3300ILELLFNPDFJBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.unk3300ILELLFNPDFJ_);
            }

            public ItemParamOuterClass.ItemParam.Builder addUnk3300ILELLFNPDFJBuilder() {
                return getUnk3300ILELLFNPDFJFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addUnk3300ILELLFNPDFJBuilder(int index) {
                return getUnk3300ILELLFNPDFJFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getUnk3300ILELLFNPDFJBuilderList() {
                return getUnk3300ILELLFNPDFJFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getUnk3300ILELLFNPDFJFieldBuilder() {
                if (this.unk3300ILELLFNPDFJBuilder_ == null) {
                    this.unk3300ILELLFNPDFJBuilder_ = new RepeatedFieldBuilderV3<>(this.unk3300ILELLFNPDFJ_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.unk3300ILELLFNPDFJ_ = null;
                }
                return this.unk3300ILELLFNPDFJBuilder_;
            }

            private void ensureUnk3300JHKOMCFHAOGIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unk3300JHKOMCFHAOG_ = new ArrayList(this.unk3300JHKOMCFHAOG_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
            public List<ItemParamOuterClass.ItemParam> getUnk3300JHKOMCFHAOGList() {
                if (this.unk3300JHKOMCFHAOGBuilder_ == null) {
                    return Collections.unmodifiableList(this.unk3300JHKOMCFHAOG_);
                }
                return this.unk3300JHKOMCFHAOGBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
            public int getUnk3300JHKOMCFHAOGCount() {
                if (this.unk3300JHKOMCFHAOGBuilder_ == null) {
                    return this.unk3300JHKOMCFHAOG_.size();
                }
                return this.unk3300JHKOMCFHAOGBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
            public ItemParamOuterClass.ItemParam getUnk3300JHKOMCFHAOG(int index) {
                if (this.unk3300JHKOMCFHAOGBuilder_ == null) {
                    return this.unk3300JHKOMCFHAOG_.get(index);
                }
                return this.unk3300JHKOMCFHAOGBuilder_.getMessage(index);
            }

            public Builder setUnk3300JHKOMCFHAOG(int index, ItemParamOuterClass.ItemParam value) {
                if (this.unk3300JHKOMCFHAOGBuilder_ != null) {
                    this.unk3300JHKOMCFHAOGBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk3300JHKOMCFHAOGIsMutable();
                    this.unk3300JHKOMCFHAOG_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUnk3300JHKOMCFHAOG(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.unk3300JHKOMCFHAOGBuilder_ == null) {
                    ensureUnk3300JHKOMCFHAOGIsMutable();
                    this.unk3300JHKOMCFHAOG_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unk3300JHKOMCFHAOGBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUnk3300JHKOMCFHAOG(ItemParamOuterClass.ItemParam value) {
                if (this.unk3300JHKOMCFHAOGBuilder_ != null) {
                    this.unk3300JHKOMCFHAOGBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk3300JHKOMCFHAOGIsMutable();
                    this.unk3300JHKOMCFHAOG_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnk3300JHKOMCFHAOG(int index, ItemParamOuterClass.ItemParam value) {
                if (this.unk3300JHKOMCFHAOGBuilder_ != null) {
                    this.unk3300JHKOMCFHAOGBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnk3300JHKOMCFHAOGIsMutable();
                    this.unk3300JHKOMCFHAOG_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnk3300JHKOMCFHAOG(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.unk3300JHKOMCFHAOGBuilder_ == null) {
                    ensureUnk3300JHKOMCFHAOGIsMutable();
                    this.unk3300JHKOMCFHAOG_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.unk3300JHKOMCFHAOGBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUnk3300JHKOMCFHAOG(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.unk3300JHKOMCFHAOGBuilder_ == null) {
                    ensureUnk3300JHKOMCFHAOGIsMutable();
                    this.unk3300JHKOMCFHAOG_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unk3300JHKOMCFHAOGBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUnk3300JHKOMCFHAOG(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.unk3300JHKOMCFHAOGBuilder_ == null) {
                    ensureUnk3300JHKOMCFHAOGIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300JHKOMCFHAOG_);
                    onChanged();
                } else {
                    this.unk3300JHKOMCFHAOGBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUnk3300JHKOMCFHAOG() {
                if (this.unk3300JHKOMCFHAOGBuilder_ == null) {
                    this.unk3300JHKOMCFHAOG_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.unk3300JHKOMCFHAOGBuilder_.clear();
                }
                return this;
            }

            public Builder removeUnk3300JHKOMCFHAOG(int index) {
                if (this.unk3300JHKOMCFHAOGBuilder_ == null) {
                    ensureUnk3300JHKOMCFHAOGIsMutable();
                    this.unk3300JHKOMCFHAOG_.remove(index);
                    onChanged();
                } else {
                    this.unk3300JHKOMCFHAOGBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getUnk3300JHKOMCFHAOGBuilder(int index) {
                return getUnk3300JHKOMCFHAOGFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getUnk3300JHKOMCFHAOGOrBuilder(int index) {
                if (this.unk3300JHKOMCFHAOGBuilder_ == null) {
                    return this.unk3300JHKOMCFHAOG_.get(index);
                }
                return this.unk3300JHKOMCFHAOGBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WinterCampAcceptItemResultInfoOuterClass.WinterCampAcceptItemResultInfoOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getUnk3300JHKOMCFHAOGOrBuilderList() {
                if (this.unk3300JHKOMCFHAOGBuilder_ != null) {
                    return this.unk3300JHKOMCFHAOGBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.unk3300JHKOMCFHAOG_);
            }

            public ItemParamOuterClass.ItemParam.Builder addUnk3300JHKOMCFHAOGBuilder() {
                return getUnk3300JHKOMCFHAOGFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addUnk3300JHKOMCFHAOGBuilder(int index) {
                return getUnk3300JHKOMCFHAOGFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getUnk3300JHKOMCFHAOGBuilderList() {
                return getUnk3300JHKOMCFHAOGFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getUnk3300JHKOMCFHAOGFieldBuilder() {
                if (this.unk3300JHKOMCFHAOGBuilder_ == null) {
                    this.unk3300JHKOMCFHAOGBuilder_ = new RepeatedFieldBuilderV3<>(this.unk3300JHKOMCFHAOG_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.unk3300JHKOMCFHAOG_ = null;
                }
                return this.unk3300JHKOMCFHAOGBuilder_;
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

        public static WinterCampAcceptItemResultInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WinterCampAcceptItemResultInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WinterCampAcceptItemResultInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WinterCampAcceptItemResultInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ItemParamOuterClass.getDescriptor();
    }
}
