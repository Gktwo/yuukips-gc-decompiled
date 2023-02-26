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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeInfoOuterClass.class */
public final class EffigyChallengeInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019EffigyChallengeInfo.proto\"¦\u0001\n\u0013EffigyChallengeInfo\u0012\u001b\n\u0013Unk3300_MBHBNIPEPNJ\u0018\u0005 \u0001(\r\u0012\u001b\n\u0013Unk3300_EOGAPBOFHOP\u0018\f \u0001(\r\u0012\u001b\n\u0013Unk3300_BMPCKGJAGPE\u0018\b \u0001(\r\u0012\u001b\n\u0013Unk3300_AIEEGIBMOFH\u0018\r \u0001(\r\u0012\u001b\n\u0013Unk3300_MICPCKIOEJA\u0018\u0006 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_EffigyChallengeInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EffigyChallengeInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EffigyChallengeInfo_descriptor, new String[]{"Unk3300MBHBNIPEPNJ", "Unk3300EOGAPBOFHOP", "Unk3300BMPCKGJAGPE", "Unk3300AIEEGIBMOFH", "Unk3300MICPCKIOEJA"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeInfoOuterClass$EffigyChallengeInfoOrBuilder.class */
    public interface EffigyChallengeInfoOrBuilder extends MessageOrBuilder {
        int getUnk3300MBHBNIPEPNJ();

        int getUnk3300EOGAPBOFHOP();

        int getUnk3300BMPCKGJAGPE();

        int getUnk3300AIEEGIBMOFH();

        int getUnk3300MICPCKIOEJA();
    }

    private EffigyChallengeInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeInfoOuterClass$EffigyChallengeInfo.class */
    public static final class EffigyChallengeInfo extends GeneratedMessageV3 implements EffigyChallengeInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_MBHBNIPEPNJ_FIELD_NUMBER = 5;
        private int unk3300MBHBNIPEPNJ_;
        public static final int UNK3300_EOGAPBOFHOP_FIELD_NUMBER = 12;
        private int unk3300EOGAPBOFHOP_;
        public static final int UNK3300_BMPCKGJAGPE_FIELD_NUMBER = 8;
        private int unk3300BMPCKGJAGPE_;
        public static final int UNK3300_AIEEGIBMOFH_FIELD_NUMBER = 13;
        private int unk3300AIEEGIBMOFH_;
        public static final int UNK3300_MICPCKIOEJA_FIELD_NUMBER = 6;
        private int unk3300MICPCKIOEJA_;
        private byte memoizedIsInitialized;
        private static final EffigyChallengeInfo DEFAULT_INSTANCE = new EffigyChallengeInfo();
        private static final Parser<EffigyChallengeInfo> PARSER = new AbstractParser<EffigyChallengeInfo>() { // from class: emu.grasscutter.net.proto.EffigyChallengeInfoOuterClass.EffigyChallengeInfo.1
            @Override // com.google.protobuf.Parser
            public EffigyChallengeInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EffigyChallengeInfo(input, extensionRegistry);
            }
        };

        private EffigyChallengeInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EffigyChallengeInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EffigyChallengeInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EffigyChallengeInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 40:
                                this.unk3300MBHBNIPEPNJ_ = input.readUInt32();
                                break;
                            case 48:
                                this.unk3300MICPCKIOEJA_ = input.readUInt32();
                                break;
                            case 64:
                                this.unk3300BMPCKGJAGPE_ = input.readUInt32();
                                break;
                            case 96:
                                this.unk3300EOGAPBOFHOP_ = input.readUInt32();
                                break;
                            case 104:
                                this.unk3300AIEEGIBMOFH_ = input.readUInt32();
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
            return EffigyChallengeInfoOuterClass.internal_static_EffigyChallengeInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EffigyChallengeInfoOuterClass.internal_static_EffigyChallengeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EffigyChallengeInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeInfoOuterClass.EffigyChallengeInfoOrBuilder
        public int getUnk3300MBHBNIPEPNJ() {
            return this.unk3300MBHBNIPEPNJ_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeInfoOuterClass.EffigyChallengeInfoOrBuilder
        public int getUnk3300EOGAPBOFHOP() {
            return this.unk3300EOGAPBOFHOP_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeInfoOuterClass.EffigyChallengeInfoOrBuilder
        public int getUnk3300BMPCKGJAGPE() {
            return this.unk3300BMPCKGJAGPE_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeInfoOuterClass.EffigyChallengeInfoOrBuilder
        public int getUnk3300AIEEGIBMOFH() {
            return this.unk3300AIEEGIBMOFH_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeInfoOuterClass.EffigyChallengeInfoOrBuilder
        public int getUnk3300MICPCKIOEJA() {
            return this.unk3300MICPCKIOEJA_;
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
            if (this.unk3300MBHBNIPEPNJ_ != 0) {
                output.writeUInt32(5, this.unk3300MBHBNIPEPNJ_);
            }
            if (this.unk3300MICPCKIOEJA_ != 0) {
                output.writeUInt32(6, this.unk3300MICPCKIOEJA_);
            }
            if (this.unk3300BMPCKGJAGPE_ != 0) {
                output.writeUInt32(8, this.unk3300BMPCKGJAGPE_);
            }
            if (this.unk3300EOGAPBOFHOP_ != 0) {
                output.writeUInt32(12, this.unk3300EOGAPBOFHOP_);
            }
            if (this.unk3300AIEEGIBMOFH_ != 0) {
                output.writeUInt32(13, this.unk3300AIEEGIBMOFH_);
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
            if (this.unk3300MBHBNIPEPNJ_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(5, this.unk3300MBHBNIPEPNJ_);
            }
            if (this.unk3300MICPCKIOEJA_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.unk3300MICPCKIOEJA_);
            }
            if (this.unk3300BMPCKGJAGPE_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.unk3300BMPCKGJAGPE_);
            }
            if (this.unk3300EOGAPBOFHOP_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.unk3300EOGAPBOFHOP_);
            }
            if (this.unk3300AIEEGIBMOFH_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.unk3300AIEEGIBMOFH_);
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
            if (!(obj instanceof EffigyChallengeInfo)) {
                return equals(obj);
            }
            EffigyChallengeInfo other = (EffigyChallengeInfo) obj;
            return getUnk3300MBHBNIPEPNJ() == other.getUnk3300MBHBNIPEPNJ() && getUnk3300EOGAPBOFHOP() == other.getUnk3300EOGAPBOFHOP() && getUnk3300BMPCKGJAGPE() == other.getUnk3300BMPCKGJAGPE() && getUnk3300AIEEGIBMOFH() == other.getUnk3300AIEEGIBMOFH() && getUnk3300MICPCKIOEJA() == other.getUnk3300MICPCKIOEJA() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getUnk3300MBHBNIPEPNJ())) + 12)) + getUnk3300EOGAPBOFHOP())) + 8)) + getUnk3300BMPCKGJAGPE())) + 13)) + getUnk3300AIEEGIBMOFH())) + 6)) + getUnk3300MICPCKIOEJA())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static EffigyChallengeInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyChallengeInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyChallengeInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyChallengeInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyChallengeInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyChallengeInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyChallengeInfo parseFrom(InputStream input) throws IOException {
            return (EffigyChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EffigyChallengeInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EffigyChallengeInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (EffigyChallengeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EffigyChallengeInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyChallengeInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EffigyChallengeInfo parseFrom(CodedInputStream input) throws IOException {
            return (EffigyChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EffigyChallengeInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyChallengeInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EffigyChallengeInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeInfoOuterClass$EffigyChallengeInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EffigyChallengeInfoOrBuilder {
            private int unk3300MBHBNIPEPNJ_;
            private int unk3300EOGAPBOFHOP_;
            private int unk3300BMPCKGJAGPE_;
            private int unk3300AIEEGIBMOFH_;
            private int unk3300MICPCKIOEJA_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EffigyChallengeInfoOuterClass.internal_static_EffigyChallengeInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EffigyChallengeInfoOuterClass.internal_static_EffigyChallengeInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EffigyChallengeInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EffigyChallengeInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300MBHBNIPEPNJ_ = 0;
                this.unk3300EOGAPBOFHOP_ = 0;
                this.unk3300BMPCKGJAGPE_ = 0;
                this.unk3300AIEEGIBMOFH_ = 0;
                this.unk3300MICPCKIOEJA_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EffigyChallengeInfoOuterClass.internal_static_EffigyChallengeInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EffigyChallengeInfo getDefaultInstanceForType() {
                return EffigyChallengeInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EffigyChallengeInfo build() {
                EffigyChallengeInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EffigyChallengeInfo buildPartial() {
                EffigyChallengeInfo result = new EffigyChallengeInfo(this);
                result.unk3300MBHBNIPEPNJ_ = this.unk3300MBHBNIPEPNJ_;
                result.unk3300EOGAPBOFHOP_ = this.unk3300EOGAPBOFHOP_;
                result.unk3300BMPCKGJAGPE_ = this.unk3300BMPCKGJAGPE_;
                result.unk3300AIEEGIBMOFH_ = this.unk3300AIEEGIBMOFH_;
                result.unk3300MICPCKIOEJA_ = this.unk3300MICPCKIOEJA_;
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
                if (other instanceof EffigyChallengeInfo) {
                    return mergeFrom((EffigyChallengeInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EffigyChallengeInfo other) {
                if (other == EffigyChallengeInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300MBHBNIPEPNJ() != 0) {
                    setUnk3300MBHBNIPEPNJ(other.getUnk3300MBHBNIPEPNJ());
                }
                if (other.getUnk3300EOGAPBOFHOP() != 0) {
                    setUnk3300EOGAPBOFHOP(other.getUnk3300EOGAPBOFHOP());
                }
                if (other.getUnk3300BMPCKGJAGPE() != 0) {
                    setUnk3300BMPCKGJAGPE(other.getUnk3300BMPCKGJAGPE());
                }
                if (other.getUnk3300AIEEGIBMOFH() != 0) {
                    setUnk3300AIEEGIBMOFH(other.getUnk3300AIEEGIBMOFH());
                }
                if (other.getUnk3300MICPCKIOEJA() != 0) {
                    setUnk3300MICPCKIOEJA(other.getUnk3300MICPCKIOEJA());
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
                EffigyChallengeInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = EffigyChallengeInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EffigyChallengeInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeInfoOuterClass.EffigyChallengeInfoOrBuilder
            public int getUnk3300MBHBNIPEPNJ() {
                return this.unk3300MBHBNIPEPNJ_;
            }

            public Builder setUnk3300MBHBNIPEPNJ(int value) {
                this.unk3300MBHBNIPEPNJ_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300MBHBNIPEPNJ() {
                this.unk3300MBHBNIPEPNJ_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeInfoOuterClass.EffigyChallengeInfoOrBuilder
            public int getUnk3300EOGAPBOFHOP() {
                return this.unk3300EOGAPBOFHOP_;
            }

            public Builder setUnk3300EOGAPBOFHOP(int value) {
                this.unk3300EOGAPBOFHOP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300EOGAPBOFHOP() {
                this.unk3300EOGAPBOFHOP_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeInfoOuterClass.EffigyChallengeInfoOrBuilder
            public int getUnk3300BMPCKGJAGPE() {
                return this.unk3300BMPCKGJAGPE_;
            }

            public Builder setUnk3300BMPCKGJAGPE(int value) {
                this.unk3300BMPCKGJAGPE_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300BMPCKGJAGPE() {
                this.unk3300BMPCKGJAGPE_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeInfoOuterClass.EffigyChallengeInfoOrBuilder
            public int getUnk3300AIEEGIBMOFH() {
                return this.unk3300AIEEGIBMOFH_;
            }

            public Builder setUnk3300AIEEGIBMOFH(int value) {
                this.unk3300AIEEGIBMOFH_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300AIEEGIBMOFH() {
                this.unk3300AIEEGIBMOFH_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeInfoOuterClass.EffigyChallengeInfoOrBuilder
            public int getUnk3300MICPCKIOEJA() {
                return this.unk3300MICPCKIOEJA_;
            }

            public Builder setUnk3300MICPCKIOEJA(int value) {
                this.unk3300MICPCKIOEJA_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300MICPCKIOEJA() {
                this.unk3300MICPCKIOEJA_ = 0;
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

        public static EffigyChallengeInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EffigyChallengeInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EffigyChallengeInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EffigyChallengeInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
