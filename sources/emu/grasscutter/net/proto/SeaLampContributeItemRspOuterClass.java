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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SeaLampContributeItemRspOuterClass.class */
public final class SeaLampContributeItemRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001eSeaLampContributeItemRsp.proto\"z\n\u0018SeaLampContributeItemRsp\u0012\u0013\n\u000baddProgress\u0018\u0004 \u0001(\r\u0012\u001b\n\u0013Unk3300_AIINHBHNHOI\u0018\t \u0001(\r\u0012\u000f\n\u0007retcode\u0018\f \u0001(\u0005\u0012\u001b\n\u0013Unk3300_LPHALOGLGAL\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_SeaLampContributeItemRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SeaLampContributeItemRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SeaLampContributeItemRsp_descriptor, new String[]{"AddProgress", "Unk3300AIINHBHNHOI", "Retcode", "Unk3300LPHALOGLGAL"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SeaLampContributeItemRspOuterClass$SeaLampContributeItemRspOrBuilder.class */
    public interface SeaLampContributeItemRspOrBuilder extends MessageOrBuilder {
        int getAddProgress();

        int getUnk3300AIINHBHNHOI();

        int getRetcode();

        int getUnk3300LPHALOGLGAL();
    }

    private SeaLampContributeItemRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SeaLampContributeItemRspOuterClass$SeaLampContributeItemRsp.class */
    public static final class SeaLampContributeItemRsp extends GeneratedMessageV3 implements SeaLampContributeItemRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ADDPROGRESS_FIELD_NUMBER = 4;
        private int addProgress_;
        public static final int UNK3300_AIINHBHNHOI_FIELD_NUMBER = 9;
        private int unk3300AIINHBHNHOI_;
        public static final int RETCODE_FIELD_NUMBER = 12;
        private int retcode_;
        public static final int UNK3300_LPHALOGLGAL_FIELD_NUMBER = 2;
        private int unk3300LPHALOGLGAL_;
        private byte memoizedIsInitialized;
        private static final SeaLampContributeItemRsp DEFAULT_INSTANCE = new SeaLampContributeItemRsp();
        private static final Parser<SeaLampContributeItemRsp> PARSER = new AbstractParser<SeaLampContributeItemRsp>() { // from class: emu.grasscutter.net.proto.SeaLampContributeItemRspOuterClass.SeaLampContributeItemRsp.1
            @Override // com.google.protobuf.Parser
            public SeaLampContributeItemRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SeaLampContributeItemRsp(input, extensionRegistry);
            }
        };

        private SeaLampContributeItemRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SeaLampContributeItemRsp() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SeaLampContributeItemRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SeaLampContributeItemRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.unk3300LPHALOGLGAL_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.addProgress_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.unk3300AIINHBHNHOI_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.retcode_ = input.readInt32();
                                    break;
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
            return SeaLampContributeItemRspOuterClass.internal_static_SeaLampContributeItemRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SeaLampContributeItemRspOuterClass.internal_static_SeaLampContributeItemRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(SeaLampContributeItemRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SeaLampContributeItemRspOuterClass.SeaLampContributeItemRspOrBuilder
        public int getAddProgress() {
            return this.addProgress_;
        }

        @Override // emu.grasscutter.net.proto.SeaLampContributeItemRspOuterClass.SeaLampContributeItemRspOrBuilder
        public int getUnk3300AIINHBHNHOI() {
            return this.unk3300AIINHBHNHOI_;
        }

        @Override // emu.grasscutter.net.proto.SeaLampContributeItemRspOuterClass.SeaLampContributeItemRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.SeaLampContributeItemRspOuterClass.SeaLampContributeItemRspOrBuilder
        public int getUnk3300LPHALOGLGAL() {
            return this.unk3300LPHALOGLGAL_;
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
            if (this.unk3300LPHALOGLGAL_ != 0) {
                output.writeUInt32(2, this.unk3300LPHALOGLGAL_);
            }
            if (this.addProgress_ != 0) {
                output.writeUInt32(4, this.addProgress_);
            }
            if (this.unk3300AIINHBHNHOI_ != 0) {
                output.writeUInt32(9, this.unk3300AIINHBHNHOI_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(12, this.retcode_);
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
            if (this.unk3300LPHALOGLGAL_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.unk3300LPHALOGLGAL_);
            }
            if (this.addProgress_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.addProgress_);
            }
            if (this.unk3300AIINHBHNHOI_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.unk3300AIINHBHNHOI_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(12, this.retcode_);
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
            if (!(obj instanceof SeaLampContributeItemRsp)) {
                return equals(obj);
            }
            SeaLampContributeItemRsp other = (SeaLampContributeItemRsp) obj;
            return getAddProgress() == other.getAddProgress() && getUnk3300AIINHBHNHOI() == other.getUnk3300AIINHBHNHOI() && getRetcode() == other.getRetcode() && getUnk3300LPHALOGLGAL() == other.getUnk3300LPHALOGLGAL() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getAddProgress())) + 9)) + getUnk3300AIINHBHNHOI())) + 12)) + getRetcode())) + 2)) + getUnk3300LPHALOGLGAL())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static SeaLampContributeItemRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SeaLampContributeItemRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SeaLampContributeItemRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SeaLampContributeItemRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SeaLampContributeItemRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SeaLampContributeItemRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SeaLampContributeItemRsp parseFrom(InputStream input) throws IOException {
            return (SeaLampContributeItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SeaLampContributeItemRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SeaLampContributeItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SeaLampContributeItemRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (SeaLampContributeItemRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SeaLampContributeItemRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SeaLampContributeItemRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SeaLampContributeItemRsp parseFrom(CodedInputStream input) throws IOException {
            return (SeaLampContributeItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SeaLampContributeItemRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SeaLampContributeItemRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SeaLampContributeItemRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SeaLampContributeItemRspOuterClass$SeaLampContributeItemRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SeaLampContributeItemRspOrBuilder {
            private int addProgress_;
            private int unk3300AIINHBHNHOI_;
            private int retcode_;
            private int unk3300LPHALOGLGAL_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SeaLampContributeItemRspOuterClass.internal_static_SeaLampContributeItemRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SeaLampContributeItemRspOuterClass.internal_static_SeaLampContributeItemRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(SeaLampContributeItemRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SeaLampContributeItemRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.addProgress_ = 0;
                this.unk3300AIINHBHNHOI_ = 0;
                this.retcode_ = 0;
                this.unk3300LPHALOGLGAL_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SeaLampContributeItemRspOuterClass.internal_static_SeaLampContributeItemRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SeaLampContributeItemRsp getDefaultInstanceForType() {
                return SeaLampContributeItemRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SeaLampContributeItemRsp build() {
                SeaLampContributeItemRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SeaLampContributeItemRsp buildPartial() {
                SeaLampContributeItemRsp result = new SeaLampContributeItemRsp(this);
                result.addProgress_ = this.addProgress_;
                result.unk3300AIINHBHNHOI_ = this.unk3300AIINHBHNHOI_;
                result.retcode_ = this.retcode_;
                result.unk3300LPHALOGLGAL_ = this.unk3300LPHALOGLGAL_;
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
                if (other instanceof SeaLampContributeItemRsp) {
                    return mergeFrom((SeaLampContributeItemRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SeaLampContributeItemRsp other) {
                if (other == SeaLampContributeItemRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getAddProgress() != 0) {
                    setAddProgress(other.getAddProgress());
                }
                if (other.getUnk3300AIINHBHNHOI() != 0) {
                    setUnk3300AIINHBHNHOI(other.getUnk3300AIINHBHNHOI());
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getUnk3300LPHALOGLGAL() != 0) {
                    setUnk3300LPHALOGLGAL(other.getUnk3300LPHALOGLGAL());
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
                SeaLampContributeItemRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = SeaLampContributeItemRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SeaLampContributeItemRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SeaLampContributeItemRspOuterClass.SeaLampContributeItemRspOrBuilder
            public int getAddProgress() {
                return this.addProgress_;
            }

            public Builder setAddProgress(int value) {
                this.addProgress_ = value;
                onChanged();
                return this;
            }

            public Builder clearAddProgress() {
                this.addProgress_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SeaLampContributeItemRspOuterClass.SeaLampContributeItemRspOrBuilder
            public int getUnk3300AIINHBHNHOI() {
                return this.unk3300AIINHBHNHOI_;
            }

            public Builder setUnk3300AIINHBHNHOI(int value) {
                this.unk3300AIINHBHNHOI_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300AIINHBHNHOI() {
                this.unk3300AIINHBHNHOI_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SeaLampContributeItemRspOuterClass.SeaLampContributeItemRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.SeaLampContributeItemRspOuterClass.SeaLampContributeItemRspOrBuilder
            public int getUnk3300LPHALOGLGAL() {
                return this.unk3300LPHALOGLGAL_;
            }

            public Builder setUnk3300LPHALOGLGAL(int value) {
                this.unk3300LPHALOGLGAL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300LPHALOGLGAL() {
                this.unk3300LPHALOGLGAL_ = 0;
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

        public static SeaLampContributeItemRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SeaLampContributeItemRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SeaLampContributeItemRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SeaLampContributeItemRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
