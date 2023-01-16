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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/Unk2700GBBDJMDIDEI.class */
public final class Unk2700GBBDJMDIDEI {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019Unk2700_GBBDJMDIDEI.proto\"H\n\u0013Unk2700_GBBDJMDIDEI\u0012\u001b\n\u0013Unk2700_JIGANFOOJHB\u0018\u0001 \u0001(\r\u0012\u0014\n\fmain_prop_id\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_Unk2700_GBBDJMDIDEI_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_Unk2700_GBBDJMDIDEI_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_Unk2700_GBBDJMDIDEI_descriptor, new String[]{"Unk2700JIGANFOOJHB", "MainPropId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/Unk2700GBBDJMDIDEI$Unk2700_GBBDJMDIDEIOrBuilder.class */
    public interface Unk2700_GBBDJMDIDEIOrBuilder extends MessageOrBuilder {
        int getUnk2700JIGANFOOJHB();

        int getMainPropId();
    }

    private Unk2700GBBDJMDIDEI() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/Unk2700GBBDJMDIDEI$Unk2700_GBBDJMDIDEI.class */
    public static final class Unk2700_GBBDJMDIDEI extends GeneratedMessageV3 implements Unk2700_GBBDJMDIDEIOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK2700_JIGANFOOJHB_FIELD_NUMBER = 1;
        private int unk2700JIGANFOOJHB_;
        public static final int MAIN_PROP_ID_FIELD_NUMBER = 12;
        private int mainPropId_;
        private byte memoizedIsInitialized;
        private static final Unk2700_GBBDJMDIDEI DEFAULT_INSTANCE = new Unk2700_GBBDJMDIDEI();
        private static final Parser<Unk2700_GBBDJMDIDEI> PARSER = new AbstractParser<Unk2700_GBBDJMDIDEI>() { // from class: emu.grasscutter.net.proto.Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEI.1
            @Override // com.google.protobuf.Parser
            public Unk2700_GBBDJMDIDEI parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Unk2700_GBBDJMDIDEI(input, extensionRegistry);
            }
        };

        private Unk2700_GBBDJMDIDEI(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private Unk2700_GBBDJMDIDEI() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new Unk2700_GBBDJMDIDEI();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Unk2700_GBBDJMDIDEI(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 8:
                                this.unk2700JIGANFOOJHB_ = input.readUInt32();
                                break;
                            case 96:
                                this.mainPropId_ = input.readUInt32();
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
            return Unk2700GBBDJMDIDEI.internal_static_Unk2700_GBBDJMDIDEI_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return Unk2700GBBDJMDIDEI.internal_static_Unk2700_GBBDJMDIDEI_fieldAccessorTable.ensureFieldAccessorsInitialized(Unk2700_GBBDJMDIDEI.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEIOrBuilder
        public int getUnk2700JIGANFOOJHB() {
            return this.unk2700JIGANFOOJHB_;
        }

        @Override // emu.grasscutter.net.proto.Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEIOrBuilder
        public int getMainPropId() {
            return this.mainPropId_;
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
            if (this.unk2700JIGANFOOJHB_ != 0) {
                output.writeUInt32(1, this.unk2700JIGANFOOJHB_);
            }
            if (this.mainPropId_ != 0) {
                output.writeUInt32(12, this.mainPropId_);
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
            if (this.unk2700JIGANFOOJHB_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.unk2700JIGANFOOJHB_);
            }
            if (this.mainPropId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.mainPropId_);
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
            if (!(obj instanceof Unk2700_GBBDJMDIDEI)) {
                return equals(obj);
            }
            Unk2700_GBBDJMDIDEI other = (Unk2700_GBBDJMDIDEI) obj;
            return getUnk2700JIGANFOOJHB() == other.getUnk2700JIGANFOOJHB() && getMainPropId() == other.getMainPropId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getUnk2700JIGANFOOJHB())) + 12)) + getMainPropId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static Unk2700_GBBDJMDIDEI parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Unk2700_GBBDJMDIDEI parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Unk2700_GBBDJMDIDEI parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Unk2700_GBBDJMDIDEI parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Unk2700_GBBDJMDIDEI parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Unk2700_GBBDJMDIDEI parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Unk2700_GBBDJMDIDEI parseFrom(InputStream input) throws IOException {
            return (Unk2700_GBBDJMDIDEI) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Unk2700_GBBDJMDIDEI parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Unk2700_GBBDJMDIDEI) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static Unk2700_GBBDJMDIDEI parseDelimitedFrom(InputStream input) throws IOException {
            return (Unk2700_GBBDJMDIDEI) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static Unk2700_GBBDJMDIDEI parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Unk2700_GBBDJMDIDEI) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static Unk2700_GBBDJMDIDEI parseFrom(CodedInputStream input) throws IOException {
            return (Unk2700_GBBDJMDIDEI) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Unk2700_GBBDJMDIDEI parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Unk2700_GBBDJMDIDEI) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Unk2700_GBBDJMDIDEI prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/Unk2700GBBDJMDIDEI$Unk2700_GBBDJMDIDEI$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements Unk2700_GBBDJMDIDEIOrBuilder {
            private int unk2700JIGANFOOJHB_;
            private int mainPropId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return Unk2700GBBDJMDIDEI.internal_static_Unk2700_GBBDJMDIDEI_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return Unk2700GBBDJMDIDEI.internal_static_Unk2700_GBBDJMDIDEI_fieldAccessorTable.ensureFieldAccessorsInitialized(Unk2700_GBBDJMDIDEI.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Unk2700_GBBDJMDIDEI.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk2700JIGANFOOJHB_ = 0;
                this.mainPropId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return Unk2700GBBDJMDIDEI.internal_static_Unk2700_GBBDJMDIDEI_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Unk2700_GBBDJMDIDEI getDefaultInstanceForType() {
                return Unk2700_GBBDJMDIDEI.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Unk2700_GBBDJMDIDEI build() {
                Unk2700_GBBDJMDIDEI result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Unk2700_GBBDJMDIDEI buildPartial() {
                Unk2700_GBBDJMDIDEI result = new Unk2700_GBBDJMDIDEI(this);
                result.unk2700JIGANFOOJHB_ = this.unk2700JIGANFOOJHB_;
                result.mainPropId_ = this.mainPropId_;
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
                if (other instanceof Unk2700_GBBDJMDIDEI) {
                    return mergeFrom((Unk2700_GBBDJMDIDEI) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Unk2700_GBBDJMDIDEI other) {
                if (other == Unk2700_GBBDJMDIDEI.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk2700JIGANFOOJHB() != 0) {
                    setUnk2700JIGANFOOJHB(other.getUnk2700JIGANFOOJHB());
                }
                if (other.getMainPropId() != 0) {
                    setMainPropId(other.getMainPropId());
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
                Unk2700_GBBDJMDIDEI parsedMessage = null;
                try {
                    try {
                        parsedMessage = Unk2700_GBBDJMDIDEI.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (Unk2700_GBBDJMDIDEI) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEIOrBuilder
            public int getUnk2700JIGANFOOJHB() {
                return this.unk2700JIGANFOOJHB_;
            }

            public Builder setUnk2700JIGANFOOJHB(int value) {
                this.unk2700JIGANFOOJHB_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk2700JIGANFOOJHB() {
                this.unk2700JIGANFOOJHB_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.Unk2700GBBDJMDIDEI.Unk2700_GBBDJMDIDEIOrBuilder
            public int getMainPropId() {
                return this.mainPropId_;
            }

            public Builder setMainPropId(int value) {
                this.mainPropId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMainPropId() {
                this.mainPropId_ = 0;
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

        public static Unk2700_GBBDJMDIDEI getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Unk2700_GBBDJMDIDEI> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Unk2700_GBBDJMDIDEI> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Unk2700_GBBDJMDIDEI getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
