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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindFieldInfoOuterClass.class */
public final class WindFieldInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013WindFieldInfo.proto\"÷\u0001\n\rWindFieldInfo\u0012\u001b\n\u0013Unk3300_GNKCFHMDOHJ\u0018\r \u0001(\r\u0012\u001b\n\u0013Unk3300_GLNHBJJJINK\u0018\u0004 \u0001(\r\u0012\u001b\n\u0013Unk3300_OJHJPBCAONA\u0018\f \u0001(\r\u0012\u001b\n\u0013Unk3300_EKMHMHJDHIL\u0018\n \u0001(\r\u0012\u001b\n\u0013Unk3300_NBIBKFKOCFK\u0018\u000f \u0001(\r\u0012\u001b\n\u0013Unk3300_GNJKOCLJFNM\u0018\b \u0001(\r\u0012\u001b\n\u0013Unk3300_FFODAKMKGEK\u0018\u0007 \u0001(\r\u0012\u001b\n\u0013Unk3300_MMONPDMIEBN\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_WindFieldInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WindFieldInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WindFieldInfo_descriptor, new String[]{"Unk3300GNKCFHMDOHJ", "Unk3300GLNHBJJJINK", "Unk3300OJHJPBCAONA", "Unk3300EKMHMHJDHIL", "Unk3300NBIBKFKOCFK", "Unk3300GNJKOCLJFNM", "Unk3300FFODAKMKGEK", "Unk3300MMONPDMIEBN"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindFieldInfoOuterClass$WindFieldInfoOrBuilder.class */
    public interface WindFieldInfoOrBuilder extends MessageOrBuilder {
        int getUnk3300GNKCFHMDOHJ();

        int getUnk3300GLNHBJJJINK();

        int getUnk3300OJHJPBCAONA();

        int getUnk3300EKMHMHJDHIL();

        int getUnk3300NBIBKFKOCFK();

        int getUnk3300GNJKOCLJFNM();

        int getUnk3300FFODAKMKGEK();

        int getUnk3300MMONPDMIEBN();
    }

    private WindFieldInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindFieldInfoOuterClass$WindFieldInfo.class */
    public static final class WindFieldInfo extends GeneratedMessageV3 implements WindFieldInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_GNKCFHMDOHJ_FIELD_NUMBER = 13;
        private int unk3300GNKCFHMDOHJ_;
        public static final int UNK3300_GLNHBJJJINK_FIELD_NUMBER = 4;
        private int unk3300GLNHBJJJINK_;
        public static final int UNK3300_OJHJPBCAONA_FIELD_NUMBER = 12;
        private int unk3300OJHJPBCAONA_;
        public static final int UNK3300_EKMHMHJDHIL_FIELD_NUMBER = 10;
        private int unk3300EKMHMHJDHIL_;
        public static final int UNK3300_NBIBKFKOCFK_FIELD_NUMBER = 15;
        private int unk3300NBIBKFKOCFK_;
        public static final int UNK3300_GNJKOCLJFNM_FIELD_NUMBER = 8;
        private int unk3300GNJKOCLJFNM_;
        public static final int UNK3300_FFODAKMKGEK_FIELD_NUMBER = 7;
        private int unk3300FFODAKMKGEK_;
        public static final int UNK3300_MMONPDMIEBN_FIELD_NUMBER = 9;
        private int unk3300MMONPDMIEBN_;
        private byte memoizedIsInitialized;
        private static final WindFieldInfo DEFAULT_INSTANCE = new WindFieldInfo();
        private static final Parser<WindFieldInfo> PARSER = new AbstractParser<WindFieldInfo>() { // from class: emu.grasscutter.net.proto.WindFieldInfoOuterClass.WindFieldInfo.1
            @Override // com.google.protobuf.Parser
            public WindFieldInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WindFieldInfo(input, extensionRegistry);
            }
        };

        private WindFieldInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WindFieldInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WindFieldInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WindFieldInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    this.unk3300GLNHBJJJINK_ = input.readUInt32();
                                    break;
                                case 56:
                                    this.unk3300FFODAKMKGEK_ = input.readUInt32();
                                    break;
                                case 64:
                                    this.unk3300GNJKOCLJFNM_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.unk3300MMONPDMIEBN_ = input.readUInt32();
                                    break;
                                case 80:
                                    this.unk3300EKMHMHJDHIL_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.unk3300OJHJPBCAONA_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.unk3300GNKCFHMDOHJ_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.unk3300NBIBKFKOCFK_ = input.readUInt32();
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
                        }
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
            return WindFieldInfoOuterClass.internal_static_WindFieldInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WindFieldInfoOuterClass.internal_static_WindFieldInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WindFieldInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WindFieldInfoOuterClass.WindFieldInfoOrBuilder
        public int getUnk3300GNKCFHMDOHJ() {
            return this.unk3300GNKCFHMDOHJ_;
        }

        @Override // emu.grasscutter.net.proto.WindFieldInfoOuterClass.WindFieldInfoOrBuilder
        public int getUnk3300GLNHBJJJINK() {
            return this.unk3300GLNHBJJJINK_;
        }

        @Override // emu.grasscutter.net.proto.WindFieldInfoOuterClass.WindFieldInfoOrBuilder
        public int getUnk3300OJHJPBCAONA() {
            return this.unk3300OJHJPBCAONA_;
        }

        @Override // emu.grasscutter.net.proto.WindFieldInfoOuterClass.WindFieldInfoOrBuilder
        public int getUnk3300EKMHMHJDHIL() {
            return this.unk3300EKMHMHJDHIL_;
        }

        @Override // emu.grasscutter.net.proto.WindFieldInfoOuterClass.WindFieldInfoOrBuilder
        public int getUnk3300NBIBKFKOCFK() {
            return this.unk3300NBIBKFKOCFK_;
        }

        @Override // emu.grasscutter.net.proto.WindFieldInfoOuterClass.WindFieldInfoOrBuilder
        public int getUnk3300GNJKOCLJFNM() {
            return this.unk3300GNJKOCLJFNM_;
        }

        @Override // emu.grasscutter.net.proto.WindFieldInfoOuterClass.WindFieldInfoOrBuilder
        public int getUnk3300FFODAKMKGEK() {
            return this.unk3300FFODAKMKGEK_;
        }

        @Override // emu.grasscutter.net.proto.WindFieldInfoOuterClass.WindFieldInfoOrBuilder
        public int getUnk3300MMONPDMIEBN() {
            return this.unk3300MMONPDMIEBN_;
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
            if (this.unk3300GLNHBJJJINK_ != 0) {
                output.writeUInt32(4, this.unk3300GLNHBJJJINK_);
            }
            if (this.unk3300FFODAKMKGEK_ != 0) {
                output.writeUInt32(7, this.unk3300FFODAKMKGEK_);
            }
            if (this.unk3300GNJKOCLJFNM_ != 0) {
                output.writeUInt32(8, this.unk3300GNJKOCLJFNM_);
            }
            if (this.unk3300MMONPDMIEBN_ != 0) {
                output.writeUInt32(9, this.unk3300MMONPDMIEBN_);
            }
            if (this.unk3300EKMHMHJDHIL_ != 0) {
                output.writeUInt32(10, this.unk3300EKMHMHJDHIL_);
            }
            if (this.unk3300OJHJPBCAONA_ != 0) {
                output.writeUInt32(12, this.unk3300OJHJPBCAONA_);
            }
            if (this.unk3300GNKCFHMDOHJ_ != 0) {
                output.writeUInt32(13, this.unk3300GNKCFHMDOHJ_);
            }
            if (this.unk3300NBIBKFKOCFK_ != 0) {
                output.writeUInt32(15, this.unk3300NBIBKFKOCFK_);
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
            if (this.unk3300GLNHBJJJINK_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(4, this.unk3300GLNHBJJJINK_);
            }
            if (this.unk3300FFODAKMKGEK_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.unk3300FFODAKMKGEK_);
            }
            if (this.unk3300GNJKOCLJFNM_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.unk3300GNJKOCLJFNM_);
            }
            if (this.unk3300MMONPDMIEBN_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.unk3300MMONPDMIEBN_);
            }
            if (this.unk3300EKMHMHJDHIL_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.unk3300EKMHMHJDHIL_);
            }
            if (this.unk3300OJHJPBCAONA_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.unk3300OJHJPBCAONA_);
            }
            if (this.unk3300GNKCFHMDOHJ_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.unk3300GNKCFHMDOHJ_);
            }
            if (this.unk3300NBIBKFKOCFK_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.unk3300NBIBKFKOCFK_);
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
            if (!(obj instanceof WindFieldInfo)) {
                return equals(obj);
            }
            WindFieldInfo other = (WindFieldInfo) obj;
            return getUnk3300GNKCFHMDOHJ() == other.getUnk3300GNKCFHMDOHJ() && getUnk3300GLNHBJJJINK() == other.getUnk3300GLNHBJJJINK() && getUnk3300OJHJPBCAONA() == other.getUnk3300OJHJPBCAONA() && getUnk3300EKMHMHJDHIL() == other.getUnk3300EKMHMHJDHIL() && getUnk3300NBIBKFKOCFK() == other.getUnk3300NBIBKFKOCFK() && getUnk3300GNJKOCLJFNM() == other.getUnk3300GNJKOCLJFNM() && getUnk3300FFODAKMKGEK() == other.getUnk3300FFODAKMKGEK() && getUnk3300MMONPDMIEBN() == other.getUnk3300MMONPDMIEBN() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + getUnk3300GNKCFHMDOHJ())) + 4)) + getUnk3300GLNHBJJJINK())) + 12)) + getUnk3300OJHJPBCAONA())) + 10)) + getUnk3300EKMHMHJDHIL())) + 15)) + getUnk3300NBIBKFKOCFK())) + 8)) + getUnk3300GNJKOCLJFNM())) + 7)) + getUnk3300FFODAKMKGEK())) + 9)) + getUnk3300MMONPDMIEBN())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static WindFieldInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WindFieldInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WindFieldInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WindFieldInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WindFieldInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WindFieldInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WindFieldInfo parseFrom(InputStream input) throws IOException {
            return (WindFieldInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WindFieldInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WindFieldInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WindFieldInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (WindFieldInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WindFieldInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WindFieldInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WindFieldInfo parseFrom(CodedInputStream input) throws IOException {
            return (WindFieldInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WindFieldInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WindFieldInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WindFieldInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WindFieldInfoOuterClass$WindFieldInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WindFieldInfoOrBuilder {
            private int unk3300GNKCFHMDOHJ_;
            private int unk3300GLNHBJJJINK_;
            private int unk3300OJHJPBCAONA_;
            private int unk3300EKMHMHJDHIL_;
            private int unk3300NBIBKFKOCFK_;
            private int unk3300GNJKOCLJFNM_;
            private int unk3300FFODAKMKGEK_;
            private int unk3300MMONPDMIEBN_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WindFieldInfoOuterClass.internal_static_WindFieldInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WindFieldInfoOuterClass.internal_static_WindFieldInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(WindFieldInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WindFieldInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300GNKCFHMDOHJ_ = 0;
                this.unk3300GLNHBJJJINK_ = 0;
                this.unk3300OJHJPBCAONA_ = 0;
                this.unk3300EKMHMHJDHIL_ = 0;
                this.unk3300NBIBKFKOCFK_ = 0;
                this.unk3300GNJKOCLJFNM_ = 0;
                this.unk3300FFODAKMKGEK_ = 0;
                this.unk3300MMONPDMIEBN_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WindFieldInfoOuterClass.internal_static_WindFieldInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WindFieldInfo getDefaultInstanceForType() {
                return WindFieldInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WindFieldInfo build() {
                WindFieldInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WindFieldInfo buildPartial() {
                WindFieldInfo result = new WindFieldInfo(this);
                result.unk3300GNKCFHMDOHJ_ = this.unk3300GNKCFHMDOHJ_;
                result.unk3300GLNHBJJJINK_ = this.unk3300GLNHBJJJINK_;
                result.unk3300OJHJPBCAONA_ = this.unk3300OJHJPBCAONA_;
                result.unk3300EKMHMHJDHIL_ = this.unk3300EKMHMHJDHIL_;
                result.unk3300NBIBKFKOCFK_ = this.unk3300NBIBKFKOCFK_;
                result.unk3300GNJKOCLJFNM_ = this.unk3300GNJKOCLJFNM_;
                result.unk3300FFODAKMKGEK_ = this.unk3300FFODAKMKGEK_;
                result.unk3300MMONPDMIEBN_ = this.unk3300MMONPDMIEBN_;
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
                if (other instanceof WindFieldInfo) {
                    return mergeFrom((WindFieldInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WindFieldInfo other) {
                if (other == WindFieldInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300GNKCFHMDOHJ() != 0) {
                    setUnk3300GNKCFHMDOHJ(other.getUnk3300GNKCFHMDOHJ());
                }
                if (other.getUnk3300GLNHBJJJINK() != 0) {
                    setUnk3300GLNHBJJJINK(other.getUnk3300GLNHBJJJINK());
                }
                if (other.getUnk3300OJHJPBCAONA() != 0) {
                    setUnk3300OJHJPBCAONA(other.getUnk3300OJHJPBCAONA());
                }
                if (other.getUnk3300EKMHMHJDHIL() != 0) {
                    setUnk3300EKMHMHJDHIL(other.getUnk3300EKMHMHJDHIL());
                }
                if (other.getUnk3300NBIBKFKOCFK() != 0) {
                    setUnk3300NBIBKFKOCFK(other.getUnk3300NBIBKFKOCFK());
                }
                if (other.getUnk3300GNJKOCLJFNM() != 0) {
                    setUnk3300GNJKOCLJFNM(other.getUnk3300GNJKOCLJFNM());
                }
                if (other.getUnk3300FFODAKMKGEK() != 0) {
                    setUnk3300FFODAKMKGEK(other.getUnk3300FFODAKMKGEK());
                }
                if (other.getUnk3300MMONPDMIEBN() != 0) {
                    setUnk3300MMONPDMIEBN(other.getUnk3300MMONPDMIEBN());
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
                WindFieldInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = WindFieldInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WindFieldInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WindFieldInfoOuterClass.WindFieldInfoOrBuilder
            public int getUnk3300GNKCFHMDOHJ() {
                return this.unk3300GNKCFHMDOHJ_;
            }

            public Builder setUnk3300GNKCFHMDOHJ(int value) {
                this.unk3300GNKCFHMDOHJ_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300GNKCFHMDOHJ() {
                this.unk3300GNKCFHMDOHJ_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WindFieldInfoOuterClass.WindFieldInfoOrBuilder
            public int getUnk3300GLNHBJJJINK() {
                return this.unk3300GLNHBJJJINK_;
            }

            public Builder setUnk3300GLNHBJJJINK(int value) {
                this.unk3300GLNHBJJJINK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300GLNHBJJJINK() {
                this.unk3300GLNHBJJJINK_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WindFieldInfoOuterClass.WindFieldInfoOrBuilder
            public int getUnk3300OJHJPBCAONA() {
                return this.unk3300OJHJPBCAONA_;
            }

            public Builder setUnk3300OJHJPBCAONA(int value) {
                this.unk3300OJHJPBCAONA_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300OJHJPBCAONA() {
                this.unk3300OJHJPBCAONA_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WindFieldInfoOuterClass.WindFieldInfoOrBuilder
            public int getUnk3300EKMHMHJDHIL() {
                return this.unk3300EKMHMHJDHIL_;
            }

            public Builder setUnk3300EKMHMHJDHIL(int value) {
                this.unk3300EKMHMHJDHIL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300EKMHMHJDHIL() {
                this.unk3300EKMHMHJDHIL_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WindFieldInfoOuterClass.WindFieldInfoOrBuilder
            public int getUnk3300NBIBKFKOCFK() {
                return this.unk3300NBIBKFKOCFK_;
            }

            public Builder setUnk3300NBIBKFKOCFK(int value) {
                this.unk3300NBIBKFKOCFK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NBIBKFKOCFK() {
                this.unk3300NBIBKFKOCFK_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WindFieldInfoOuterClass.WindFieldInfoOrBuilder
            public int getUnk3300GNJKOCLJFNM() {
                return this.unk3300GNJKOCLJFNM_;
            }

            public Builder setUnk3300GNJKOCLJFNM(int value) {
                this.unk3300GNJKOCLJFNM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300GNJKOCLJFNM() {
                this.unk3300GNJKOCLJFNM_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WindFieldInfoOuterClass.WindFieldInfoOrBuilder
            public int getUnk3300FFODAKMKGEK() {
                return this.unk3300FFODAKMKGEK_;
            }

            public Builder setUnk3300FFODAKMKGEK(int value) {
                this.unk3300FFODAKMKGEK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300FFODAKMKGEK() {
                this.unk3300FFODAKMKGEK_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WindFieldInfoOuterClass.WindFieldInfoOrBuilder
            public int getUnk3300MMONPDMIEBN() {
                return this.unk3300MMONPDMIEBN_;
            }

            public Builder setUnk3300MMONPDMIEBN(int value) {
                this.unk3300MMONPDMIEBN_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300MMONPDMIEBN() {
                this.unk3300MMONPDMIEBN_ = 0;
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

        public static WindFieldInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WindFieldInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WindFieldInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WindFieldInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
