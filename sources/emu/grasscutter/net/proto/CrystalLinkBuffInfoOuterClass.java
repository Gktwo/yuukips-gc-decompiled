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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkBuffInfoOuterClass.class */
public final class CrystalLinkBuffInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019CrystalLinkBuffInfo.proto\"O\n\u0013CrystalLinkBuffInfo\u0012\u001b\n\u0013Unk3300_BGKLAFCBNOA\u0018\u0006 \u0001(\r\u0012\u001b\n\u0013Unk3300_PFLAOCMEFIL\u0018\u0004 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_CrystalLinkBuffInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CrystalLinkBuffInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CrystalLinkBuffInfo_descriptor, new String[]{"Unk3300BGKLAFCBNOA", "Unk3300PFLAOCMEFIL"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkBuffInfoOuterClass$CrystalLinkBuffInfoOrBuilder.class */
    public interface CrystalLinkBuffInfoOrBuilder extends MessageOrBuilder {
        int getUnk3300BGKLAFCBNOA();

        int getUnk3300PFLAOCMEFIL();
    }

    private CrystalLinkBuffInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkBuffInfoOuterClass$CrystalLinkBuffInfo.class */
    public static final class CrystalLinkBuffInfo extends GeneratedMessageV3 implements CrystalLinkBuffInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_BGKLAFCBNOA_FIELD_NUMBER = 6;
        private int unk3300BGKLAFCBNOA_;
        public static final int UNK3300_PFLAOCMEFIL_FIELD_NUMBER = 4;
        private int unk3300PFLAOCMEFIL_;
        private byte memoizedIsInitialized;
        private static final CrystalLinkBuffInfo DEFAULT_INSTANCE = new CrystalLinkBuffInfo();
        private static final Parser<CrystalLinkBuffInfo> PARSER = new AbstractParser<CrystalLinkBuffInfo>() { // from class: emu.grasscutter.net.proto.CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfo.1
            @Override // com.google.protobuf.Parser
            public CrystalLinkBuffInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CrystalLinkBuffInfo(input, extensionRegistry);
            }
        };

        private CrystalLinkBuffInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CrystalLinkBuffInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CrystalLinkBuffInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CrystalLinkBuffInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                this.unk3300PFLAOCMEFIL_ = input.readUInt32();
                                break;
                            case 48:
                                this.unk3300BGKLAFCBNOA_ = input.readUInt32();
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
            return CrystalLinkBuffInfoOuterClass.internal_static_CrystalLinkBuffInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CrystalLinkBuffInfoOuterClass.internal_static_CrystalLinkBuffInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CrystalLinkBuffInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfoOrBuilder
        public int getUnk3300BGKLAFCBNOA() {
            return this.unk3300BGKLAFCBNOA_;
        }

        @Override // emu.grasscutter.net.proto.CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfoOrBuilder
        public int getUnk3300PFLAOCMEFIL() {
            return this.unk3300PFLAOCMEFIL_;
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
            if (this.unk3300PFLAOCMEFIL_ != 0) {
                output.writeUInt32(4, this.unk3300PFLAOCMEFIL_);
            }
            if (this.unk3300BGKLAFCBNOA_ != 0) {
                output.writeUInt32(6, this.unk3300BGKLAFCBNOA_);
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
            if (this.unk3300PFLAOCMEFIL_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.unk3300PFLAOCMEFIL_);
            }
            if (this.unk3300BGKLAFCBNOA_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.unk3300BGKLAFCBNOA_);
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
            if (!(obj instanceof CrystalLinkBuffInfo)) {
                return equals(obj);
            }
            CrystalLinkBuffInfo other = (CrystalLinkBuffInfo) obj;
            return getUnk3300BGKLAFCBNOA() == other.getUnk3300BGKLAFCBNOA() && getUnk3300PFLAOCMEFIL() == other.getUnk3300PFLAOCMEFIL() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 6)) + getUnk3300BGKLAFCBNOA())) + 4)) + getUnk3300PFLAOCMEFIL())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static CrystalLinkBuffInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CrystalLinkBuffInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CrystalLinkBuffInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CrystalLinkBuffInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CrystalLinkBuffInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CrystalLinkBuffInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CrystalLinkBuffInfo parseFrom(InputStream input) throws IOException {
            return (CrystalLinkBuffInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CrystalLinkBuffInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CrystalLinkBuffInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CrystalLinkBuffInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CrystalLinkBuffInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CrystalLinkBuffInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CrystalLinkBuffInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CrystalLinkBuffInfo parseFrom(CodedInputStream input) throws IOException {
            return (CrystalLinkBuffInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CrystalLinkBuffInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CrystalLinkBuffInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CrystalLinkBuffInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CrystalLinkBuffInfoOuterClass$CrystalLinkBuffInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CrystalLinkBuffInfoOrBuilder {
            private int unk3300BGKLAFCBNOA_;
            private int unk3300PFLAOCMEFIL_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CrystalLinkBuffInfoOuterClass.internal_static_CrystalLinkBuffInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CrystalLinkBuffInfoOuterClass.internal_static_CrystalLinkBuffInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CrystalLinkBuffInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CrystalLinkBuffInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300BGKLAFCBNOA_ = 0;
                this.unk3300PFLAOCMEFIL_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CrystalLinkBuffInfoOuterClass.internal_static_CrystalLinkBuffInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CrystalLinkBuffInfo getDefaultInstanceForType() {
                return CrystalLinkBuffInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CrystalLinkBuffInfo build() {
                CrystalLinkBuffInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CrystalLinkBuffInfo buildPartial() {
                CrystalLinkBuffInfo result = new CrystalLinkBuffInfo(this);
                result.unk3300BGKLAFCBNOA_ = this.unk3300BGKLAFCBNOA_;
                result.unk3300PFLAOCMEFIL_ = this.unk3300PFLAOCMEFIL_;
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
                if (other instanceof CrystalLinkBuffInfo) {
                    return mergeFrom((CrystalLinkBuffInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CrystalLinkBuffInfo other) {
                if (other == CrystalLinkBuffInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300BGKLAFCBNOA() != 0) {
                    setUnk3300BGKLAFCBNOA(other.getUnk3300BGKLAFCBNOA());
                }
                if (other.getUnk3300PFLAOCMEFIL() != 0) {
                    setUnk3300PFLAOCMEFIL(other.getUnk3300PFLAOCMEFIL());
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
                CrystalLinkBuffInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CrystalLinkBuffInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CrystalLinkBuffInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfoOrBuilder
            public int getUnk3300BGKLAFCBNOA() {
                return this.unk3300BGKLAFCBNOA_;
            }

            public Builder setUnk3300BGKLAFCBNOA(int value) {
                this.unk3300BGKLAFCBNOA_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300BGKLAFCBNOA() {
                this.unk3300BGKLAFCBNOA_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CrystalLinkBuffInfoOuterClass.CrystalLinkBuffInfoOrBuilder
            public int getUnk3300PFLAOCMEFIL() {
                return this.unk3300PFLAOCMEFIL_;
            }

            public Builder setUnk3300PFLAOCMEFIL(int value) {
                this.unk3300PFLAOCMEFIL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300PFLAOCMEFIL() {
                this.unk3300PFLAOCMEFIL_ = 0;
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

        public static CrystalLinkBuffInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CrystalLinkBuffInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CrystalLinkBuffInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CrystalLinkBuffInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
