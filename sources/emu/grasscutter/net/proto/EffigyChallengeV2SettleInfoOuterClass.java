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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeV2SettleInfoOuterClass.class */
public final class EffigyChallengeV2SettleInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!EffigyChallengeV2SettleInfo.proto\"Ï\u0001\n\u001bEffigyChallengeV2SettleInfo\u0012\u001b\n\u0013Unk3300_MHOIIPJKAMN\u0018\u000e \u0001(\r\u0012\u001b\n\u0013Unk3300_AKMPCDIKBJD\u0018\u0005 \u0001(\b\u0012\u001b\n\u0013Unk3300_ONKPGFOLDFL\u0018\u000f \u0001(\r\u0012\u001b\n\u0013Unk3300_PHEIMLOKIJG\u0018\n \u0001(\r\u0012\u001f\n\u0017challengeModeDifficulty\u0018\r \u0001(\r\u0012\u001b\n\u0013Unk3300_NGBKNDHJPCP\u0018\u0001 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_EffigyChallengeV2SettleInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EffigyChallengeV2SettleInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EffigyChallengeV2SettleInfo_descriptor, new String[]{"Unk3300MHOIIPJKAMN", "Unk3300AKMPCDIKBJD", "Unk3300ONKPGFOLDFL", "Unk3300PHEIMLOKIJG", "ChallengeModeDifficulty", "Unk3300NGBKNDHJPCP"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeV2SettleInfoOuterClass$EffigyChallengeV2SettleInfoOrBuilder.class */
    public interface EffigyChallengeV2SettleInfoOrBuilder extends MessageOrBuilder {
        int getUnk3300MHOIIPJKAMN();

        boolean getUnk3300AKMPCDIKBJD();

        int getUnk3300ONKPGFOLDFL();

        int getUnk3300PHEIMLOKIJG();

        int getChallengeModeDifficulty();

        boolean getUnk3300NGBKNDHJPCP();
    }

    private EffigyChallengeV2SettleInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeV2SettleInfoOuterClass$EffigyChallengeV2SettleInfo.class */
    public static final class EffigyChallengeV2SettleInfo extends GeneratedMessageV3 implements EffigyChallengeV2SettleInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_MHOIIPJKAMN_FIELD_NUMBER = 14;
        private int unk3300MHOIIPJKAMN_;
        public static final int UNK3300_AKMPCDIKBJD_FIELD_NUMBER = 5;
        private boolean unk3300AKMPCDIKBJD_;
        public static final int UNK3300_ONKPGFOLDFL_FIELD_NUMBER = 15;
        private int unk3300ONKPGFOLDFL_;
        public static final int UNK3300_PHEIMLOKIJG_FIELD_NUMBER = 10;
        private int unk3300PHEIMLOKIJG_;
        public static final int CHALLENGEMODEDIFFICULTY_FIELD_NUMBER = 13;
        private int challengeModeDifficulty_;
        public static final int UNK3300_NGBKNDHJPCP_FIELD_NUMBER = 1;
        private boolean unk3300NGBKNDHJPCP_;
        private byte memoizedIsInitialized;
        private static final EffigyChallengeV2SettleInfo DEFAULT_INSTANCE = new EffigyChallengeV2SettleInfo();
        private static final Parser<EffigyChallengeV2SettleInfo> PARSER = new AbstractParser<EffigyChallengeV2SettleInfo>() { // from class: emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfo.1
            @Override // com.google.protobuf.Parser
            public EffigyChallengeV2SettleInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EffigyChallengeV2SettleInfo(input, extensionRegistry);
            }
        };

        private EffigyChallengeV2SettleInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private EffigyChallengeV2SettleInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EffigyChallengeV2SettleInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private EffigyChallengeV2SettleInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.unk3300NGBKNDHJPCP_ = input.readBool();
                                break;
                            case 40:
                                this.unk3300AKMPCDIKBJD_ = input.readBool();
                                break;
                            case 80:
                                this.unk3300PHEIMLOKIJG_ = input.readUInt32();
                                break;
                            case 104:
                                this.challengeModeDifficulty_ = input.readUInt32();
                                break;
                            case 112:
                                this.unk3300MHOIIPJKAMN_ = input.readUInt32();
                                break;
                            case 120:
                                this.unk3300ONKPGFOLDFL_ = input.readUInt32();
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
            return EffigyChallengeV2SettleInfoOuterClass.internal_static_EffigyChallengeV2SettleInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EffigyChallengeV2SettleInfoOuterClass.internal_static_EffigyChallengeV2SettleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EffigyChallengeV2SettleInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfoOrBuilder
        public int getUnk3300MHOIIPJKAMN() {
            return this.unk3300MHOIIPJKAMN_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfoOrBuilder
        public boolean getUnk3300AKMPCDIKBJD() {
            return this.unk3300AKMPCDIKBJD_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfoOrBuilder
        public int getUnk3300ONKPGFOLDFL() {
            return this.unk3300ONKPGFOLDFL_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfoOrBuilder
        public int getUnk3300PHEIMLOKIJG() {
            return this.unk3300PHEIMLOKIJG_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfoOrBuilder
        public int getChallengeModeDifficulty() {
            return this.challengeModeDifficulty_;
        }

        @Override // emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfoOrBuilder
        public boolean getUnk3300NGBKNDHJPCP() {
            return this.unk3300NGBKNDHJPCP_;
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
            if (this.unk3300NGBKNDHJPCP_) {
                output.writeBool(1, this.unk3300NGBKNDHJPCP_);
            }
            if (this.unk3300AKMPCDIKBJD_) {
                output.writeBool(5, this.unk3300AKMPCDIKBJD_);
            }
            if (this.unk3300PHEIMLOKIJG_ != 0) {
                output.writeUInt32(10, this.unk3300PHEIMLOKIJG_);
            }
            if (this.challengeModeDifficulty_ != 0) {
                output.writeUInt32(13, this.challengeModeDifficulty_);
            }
            if (this.unk3300MHOIIPJKAMN_ != 0) {
                output.writeUInt32(14, this.unk3300MHOIIPJKAMN_);
            }
            if (this.unk3300ONKPGFOLDFL_ != 0) {
                output.writeUInt32(15, this.unk3300ONKPGFOLDFL_);
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
            if (this.unk3300NGBKNDHJPCP_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.unk3300NGBKNDHJPCP_);
            }
            if (this.unk3300AKMPCDIKBJD_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.unk3300AKMPCDIKBJD_);
            }
            if (this.unk3300PHEIMLOKIJG_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.unk3300PHEIMLOKIJG_);
            }
            if (this.challengeModeDifficulty_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.challengeModeDifficulty_);
            }
            if (this.unk3300MHOIIPJKAMN_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.unk3300MHOIIPJKAMN_);
            }
            if (this.unk3300ONKPGFOLDFL_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.unk3300ONKPGFOLDFL_);
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
            if (!(obj instanceof EffigyChallengeV2SettleInfo)) {
                return equals(obj);
            }
            EffigyChallengeV2SettleInfo other = (EffigyChallengeV2SettleInfo) obj;
            return getUnk3300MHOIIPJKAMN() == other.getUnk3300MHOIIPJKAMN() && getUnk3300AKMPCDIKBJD() == other.getUnk3300AKMPCDIKBJD() && getUnk3300ONKPGFOLDFL() == other.getUnk3300ONKPGFOLDFL() && getUnk3300PHEIMLOKIJG() == other.getUnk3300PHEIMLOKIJG() && getChallengeModeDifficulty() == other.getChallengeModeDifficulty() && getUnk3300NGBKNDHJPCP() == other.getUnk3300NGBKNDHJPCP() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getUnk3300MHOIIPJKAMN())) + 5)) + Internal.hashBoolean(getUnk3300AKMPCDIKBJD()))) + 15)) + getUnk3300ONKPGFOLDFL())) + 10)) + getUnk3300PHEIMLOKIJG())) + 13)) + getChallengeModeDifficulty())) + 1)) + Internal.hashBoolean(getUnk3300NGBKNDHJPCP()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static EffigyChallengeV2SettleInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyChallengeV2SettleInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyChallengeV2SettleInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyChallengeV2SettleInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyChallengeV2SettleInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EffigyChallengeV2SettleInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EffigyChallengeV2SettleInfo parseFrom(InputStream input) throws IOException {
            return (EffigyChallengeV2SettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EffigyChallengeV2SettleInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyChallengeV2SettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EffigyChallengeV2SettleInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (EffigyChallengeV2SettleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EffigyChallengeV2SettleInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyChallengeV2SettleInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EffigyChallengeV2SettleInfo parseFrom(CodedInputStream input) throws IOException {
            return (EffigyChallengeV2SettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EffigyChallengeV2SettleInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EffigyChallengeV2SettleInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EffigyChallengeV2SettleInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EffigyChallengeV2SettleInfoOuterClass$EffigyChallengeV2SettleInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EffigyChallengeV2SettleInfoOrBuilder {
            private int unk3300MHOIIPJKAMN_;
            private boolean unk3300AKMPCDIKBJD_;
            private int unk3300ONKPGFOLDFL_;
            private int unk3300PHEIMLOKIJG_;
            private int challengeModeDifficulty_;
            private boolean unk3300NGBKNDHJPCP_;

            public static final Descriptors.Descriptor getDescriptor() {
                return EffigyChallengeV2SettleInfoOuterClass.internal_static_EffigyChallengeV2SettleInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EffigyChallengeV2SettleInfoOuterClass.internal_static_EffigyChallengeV2SettleInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EffigyChallengeV2SettleInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EffigyChallengeV2SettleInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300MHOIIPJKAMN_ = 0;
                this.unk3300AKMPCDIKBJD_ = false;
                this.unk3300ONKPGFOLDFL_ = 0;
                this.unk3300PHEIMLOKIJG_ = 0;
                this.challengeModeDifficulty_ = 0;
                this.unk3300NGBKNDHJPCP_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EffigyChallengeV2SettleInfoOuterClass.internal_static_EffigyChallengeV2SettleInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EffigyChallengeV2SettleInfo getDefaultInstanceForType() {
                return EffigyChallengeV2SettleInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EffigyChallengeV2SettleInfo build() {
                EffigyChallengeV2SettleInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EffigyChallengeV2SettleInfo buildPartial() {
                EffigyChallengeV2SettleInfo result = new EffigyChallengeV2SettleInfo(this);
                result.unk3300MHOIIPJKAMN_ = this.unk3300MHOIIPJKAMN_;
                result.unk3300AKMPCDIKBJD_ = this.unk3300AKMPCDIKBJD_;
                result.unk3300ONKPGFOLDFL_ = this.unk3300ONKPGFOLDFL_;
                result.unk3300PHEIMLOKIJG_ = this.unk3300PHEIMLOKIJG_;
                result.challengeModeDifficulty_ = this.challengeModeDifficulty_;
                result.unk3300NGBKNDHJPCP_ = this.unk3300NGBKNDHJPCP_;
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
                if (other instanceof EffigyChallengeV2SettleInfo) {
                    return mergeFrom((EffigyChallengeV2SettleInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EffigyChallengeV2SettleInfo other) {
                if (other == EffigyChallengeV2SettleInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300MHOIIPJKAMN() != 0) {
                    setUnk3300MHOIIPJKAMN(other.getUnk3300MHOIIPJKAMN());
                }
                if (other.getUnk3300AKMPCDIKBJD()) {
                    setUnk3300AKMPCDIKBJD(other.getUnk3300AKMPCDIKBJD());
                }
                if (other.getUnk3300ONKPGFOLDFL() != 0) {
                    setUnk3300ONKPGFOLDFL(other.getUnk3300ONKPGFOLDFL());
                }
                if (other.getUnk3300PHEIMLOKIJG() != 0) {
                    setUnk3300PHEIMLOKIJG(other.getUnk3300PHEIMLOKIJG());
                }
                if (other.getChallengeModeDifficulty() != 0) {
                    setChallengeModeDifficulty(other.getChallengeModeDifficulty());
                }
                if (other.getUnk3300NGBKNDHJPCP()) {
                    setUnk3300NGBKNDHJPCP(other.getUnk3300NGBKNDHJPCP());
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
                EffigyChallengeV2SettleInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = EffigyChallengeV2SettleInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EffigyChallengeV2SettleInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfoOrBuilder
            public int getUnk3300MHOIIPJKAMN() {
                return this.unk3300MHOIIPJKAMN_;
            }

            public Builder setUnk3300MHOIIPJKAMN(int value) {
                this.unk3300MHOIIPJKAMN_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300MHOIIPJKAMN() {
                this.unk3300MHOIIPJKAMN_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfoOrBuilder
            public boolean getUnk3300AKMPCDIKBJD() {
                return this.unk3300AKMPCDIKBJD_;
            }

            public Builder setUnk3300AKMPCDIKBJD(boolean value) {
                this.unk3300AKMPCDIKBJD_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300AKMPCDIKBJD() {
                this.unk3300AKMPCDIKBJD_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfoOrBuilder
            public int getUnk3300ONKPGFOLDFL() {
                return this.unk3300ONKPGFOLDFL_;
            }

            public Builder setUnk3300ONKPGFOLDFL(int value) {
                this.unk3300ONKPGFOLDFL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300ONKPGFOLDFL() {
                this.unk3300ONKPGFOLDFL_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfoOrBuilder
            public int getUnk3300PHEIMLOKIJG() {
                return this.unk3300PHEIMLOKIJG_;
            }

            public Builder setUnk3300PHEIMLOKIJG(int value) {
                this.unk3300PHEIMLOKIJG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300PHEIMLOKIJG() {
                this.unk3300PHEIMLOKIJG_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfoOrBuilder
            public int getChallengeModeDifficulty() {
                return this.challengeModeDifficulty_;
            }

            public Builder setChallengeModeDifficulty(int value) {
                this.challengeModeDifficulty_ = value;
                onChanged();
                return this;
            }

            public Builder clearChallengeModeDifficulty() {
                this.challengeModeDifficulty_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.EffigyChallengeV2SettleInfoOuterClass.EffigyChallengeV2SettleInfoOrBuilder
            public boolean getUnk3300NGBKNDHJPCP() {
                return this.unk3300NGBKNDHJPCP_;
            }

            public Builder setUnk3300NGBKNDHJPCP(boolean value) {
                this.unk3300NGBKNDHJPCP_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NGBKNDHJPCP() {
                this.unk3300NGBKNDHJPCP_ = false;
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

        public static EffigyChallengeV2SettleInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EffigyChallengeV2SettleInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EffigyChallengeV2SettleInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EffigyChallengeV2SettleInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
