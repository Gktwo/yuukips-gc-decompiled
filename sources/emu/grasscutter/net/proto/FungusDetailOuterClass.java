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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusDetailOuterClass.class */
public final class FungusDetailOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012FungusDetail.proto\"\u0001\n\fFungusDetail\u0012\u000f\n\u0007name_id\u0018\b \u0001(\r\u0012\u001b\n\u0013Unk3300_EHNBDJPANKL\u0018\u0002 \u0001(\r\u0012\u0011\n\tfungus_id\u0018\u0003 \u0001(\r\u0012\u0014\n\fis_cultivate\u0018\u0007 \u0001(\b\u0012\u001b\n\u0013Unk3300_GCLBPDJDEDN\u0018\r \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_FungusDetail_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FungusDetail_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FungusDetail_descriptor, new String[]{"NameId", "Unk3300EHNBDJPANKL", "FungusId", "IsCultivate", "Unk3300GCLBPDJDEDN"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusDetailOuterClass$FungusDetailOrBuilder.class */
    public interface FungusDetailOrBuilder extends MessageOrBuilder {
        int getNameId();

        int getUnk3300EHNBDJPANKL();

        int getFungusId();

        boolean getIsCultivate();

        int getUnk3300GCLBPDJDEDN();
    }

    private FungusDetailOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusDetailOuterClass$FungusDetail.class */
    public static final class FungusDetail extends GeneratedMessageV3 implements FungusDetailOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int NAME_ID_FIELD_NUMBER = 8;
        private int nameId_;
        public static final int UNK3300_EHNBDJPANKL_FIELD_NUMBER = 2;
        private int unk3300EHNBDJPANKL_;
        public static final int FUNGUS_ID_FIELD_NUMBER = 3;
        private int fungusId_;
        public static final int IS_CULTIVATE_FIELD_NUMBER = 7;
        private boolean isCultivate_;
        public static final int UNK3300_GCLBPDJDEDN_FIELD_NUMBER = 13;
        private int unk3300GCLBPDJDEDN_;
        private byte memoizedIsInitialized;
        private static final FungusDetail DEFAULT_INSTANCE = new FungusDetail();
        private static final Parser<FungusDetail> PARSER = new AbstractParser<FungusDetail>() { // from class: emu.grasscutter.net.proto.FungusDetailOuterClass.FungusDetail.1
            @Override // com.google.protobuf.Parser
            public FungusDetail parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FungusDetail(input, extensionRegistry);
            }
        };

        private FungusDetail(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FungusDetail() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FungusDetail();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FungusDetail(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.unk3300EHNBDJPANKL_ = input.readUInt32();
                                break;
                            case 24:
                                this.fungusId_ = input.readUInt32();
                                break;
                            case 56:
                                this.isCultivate_ = input.readBool();
                                break;
                            case 64:
                                this.nameId_ = input.readUInt32();
                                break;
                            case 104:
                                this.unk3300GCLBPDJDEDN_ = input.readUInt32();
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
            return FungusDetailOuterClass.internal_static_FungusDetail_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FungusDetailOuterClass.internal_static_FungusDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(FungusDetail.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FungusDetailOuterClass.FungusDetailOrBuilder
        public int getNameId() {
            return this.nameId_;
        }

        @Override // emu.grasscutter.net.proto.FungusDetailOuterClass.FungusDetailOrBuilder
        public int getUnk3300EHNBDJPANKL() {
            return this.unk3300EHNBDJPANKL_;
        }

        @Override // emu.grasscutter.net.proto.FungusDetailOuterClass.FungusDetailOrBuilder
        public int getFungusId() {
            return this.fungusId_;
        }

        @Override // emu.grasscutter.net.proto.FungusDetailOuterClass.FungusDetailOrBuilder
        public boolean getIsCultivate() {
            return this.isCultivate_;
        }

        @Override // emu.grasscutter.net.proto.FungusDetailOuterClass.FungusDetailOrBuilder
        public int getUnk3300GCLBPDJDEDN() {
            return this.unk3300GCLBPDJDEDN_;
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
            if (this.unk3300EHNBDJPANKL_ != 0) {
                output.writeUInt32(2, this.unk3300EHNBDJPANKL_);
            }
            if (this.fungusId_ != 0) {
                output.writeUInt32(3, this.fungusId_);
            }
            if (this.isCultivate_) {
                output.writeBool(7, this.isCultivate_);
            }
            if (this.nameId_ != 0) {
                output.writeUInt32(8, this.nameId_);
            }
            if (this.unk3300GCLBPDJDEDN_ != 0) {
                output.writeUInt32(13, this.unk3300GCLBPDJDEDN_);
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
            if (this.unk3300EHNBDJPANKL_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.unk3300EHNBDJPANKL_);
            }
            if (this.fungusId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.fungusId_);
            }
            if (this.isCultivate_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.isCultivate_);
            }
            if (this.nameId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.nameId_);
            }
            if (this.unk3300GCLBPDJDEDN_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.unk3300GCLBPDJDEDN_);
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
            if (!(obj instanceof FungusDetail)) {
                return equals(obj);
            }
            FungusDetail other = (FungusDetail) obj;
            return getNameId() == other.getNameId() && getUnk3300EHNBDJPANKL() == other.getUnk3300EHNBDJPANKL() && getFungusId() == other.getFungusId() && getIsCultivate() == other.getIsCultivate() && getUnk3300GCLBPDJDEDN() == other.getUnk3300GCLBPDJDEDN() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + getNameId())) + 2)) + getUnk3300EHNBDJPANKL())) + 3)) + getFungusId())) + 7)) + Internal.hashBoolean(getIsCultivate()))) + 13)) + getUnk3300GCLBPDJDEDN())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static FungusDetail parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusDetail parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusDetail parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusDetail parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusDetail parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FungusDetail parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FungusDetail parseFrom(InputStream input) throws IOException {
            return (FungusDetail) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FungusDetail parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusDetail) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FungusDetail parseDelimitedFrom(InputStream input) throws IOException {
            return (FungusDetail) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FungusDetail parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusDetail) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FungusDetail parseFrom(CodedInputStream input) throws IOException {
            return (FungusDetail) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FungusDetail parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FungusDetail) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FungusDetail prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FungusDetailOuterClass$FungusDetail$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FungusDetailOrBuilder {
            private int nameId_;
            private int unk3300EHNBDJPANKL_;
            private int fungusId_;
            private boolean isCultivate_;
            private int unk3300GCLBPDJDEDN_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FungusDetailOuterClass.internal_static_FungusDetail_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FungusDetailOuterClass.internal_static_FungusDetail_fieldAccessorTable.ensureFieldAccessorsInitialized(FungusDetail.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FungusDetail.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.nameId_ = 0;
                this.unk3300EHNBDJPANKL_ = 0;
                this.fungusId_ = 0;
                this.isCultivate_ = false;
                this.unk3300GCLBPDJDEDN_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FungusDetailOuterClass.internal_static_FungusDetail_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FungusDetail getDefaultInstanceForType() {
                return FungusDetail.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FungusDetail build() {
                FungusDetail result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FungusDetail buildPartial() {
                FungusDetail result = new FungusDetail(this);
                result.nameId_ = this.nameId_;
                result.unk3300EHNBDJPANKL_ = this.unk3300EHNBDJPANKL_;
                result.fungusId_ = this.fungusId_;
                result.isCultivate_ = this.isCultivate_;
                result.unk3300GCLBPDJDEDN_ = this.unk3300GCLBPDJDEDN_;
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
                if (other instanceof FungusDetail) {
                    return mergeFrom((FungusDetail) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FungusDetail other) {
                if (other == FungusDetail.getDefaultInstance()) {
                    return this;
                }
                if (other.getNameId() != 0) {
                    setNameId(other.getNameId());
                }
                if (other.getUnk3300EHNBDJPANKL() != 0) {
                    setUnk3300EHNBDJPANKL(other.getUnk3300EHNBDJPANKL());
                }
                if (other.getFungusId() != 0) {
                    setFungusId(other.getFungusId());
                }
                if (other.getIsCultivate()) {
                    setIsCultivate(other.getIsCultivate());
                }
                if (other.getUnk3300GCLBPDJDEDN() != 0) {
                    setUnk3300GCLBPDJDEDN(other.getUnk3300GCLBPDJDEDN());
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
                FungusDetail parsedMessage = null;
                try {
                    try {
                        parsedMessage = FungusDetail.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FungusDetail) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FungusDetailOuterClass.FungusDetailOrBuilder
            public int getNameId() {
                return this.nameId_;
            }

            public Builder setNameId(int value) {
                this.nameId_ = value;
                onChanged();
                return this;
            }

            public Builder clearNameId() {
                this.nameId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FungusDetailOuterClass.FungusDetailOrBuilder
            public int getUnk3300EHNBDJPANKL() {
                return this.unk3300EHNBDJPANKL_;
            }

            public Builder setUnk3300EHNBDJPANKL(int value) {
                this.unk3300EHNBDJPANKL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300EHNBDJPANKL() {
                this.unk3300EHNBDJPANKL_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FungusDetailOuterClass.FungusDetailOrBuilder
            public int getFungusId() {
                return this.fungusId_;
            }

            public Builder setFungusId(int value) {
                this.fungusId_ = value;
                onChanged();
                return this;
            }

            public Builder clearFungusId() {
                this.fungusId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FungusDetailOuterClass.FungusDetailOrBuilder
            public boolean getIsCultivate() {
                return this.isCultivate_;
            }

            public Builder setIsCultivate(boolean value) {
                this.isCultivate_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsCultivate() {
                this.isCultivate_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.FungusDetailOuterClass.FungusDetailOrBuilder
            public int getUnk3300GCLBPDJDEDN() {
                return this.unk3300GCLBPDJDEDN_;
            }

            public Builder setUnk3300GCLBPDJDEDN(int value) {
                this.unk3300GCLBPDJDEDN_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300GCLBPDJDEDN() {
                this.unk3300GCLBPDJDEDN_ = 0;
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

        public static FungusDetail getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FungusDetail> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FungusDetail> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FungusDetail getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
