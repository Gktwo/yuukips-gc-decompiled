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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AdjustTrackingInfoOuterClass.class */
public final class AdjustTrackingInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018AdjustTrackingInfo.proto\"Â\u0001\n\u0012AdjustTrackingInfo\u0012\u001b\n\u0013Unk3300_CHCOHLGBHLB\u0018\u0002 \u0001(\t\u0012\u001b\n\u0013Unk3300_GAMLJPFKCGC\u0018\t \u0001(\t\u0012\u001b\n\u0013Unk3300_ONNMBNODPIA\u0018\u0004 \u0001(\t\u0012\u001b\n\u0013Unk3300_MHDOPAMDMPL\u0018\u0006 \u0001(\t\u0012\u001b\n\u0013Unk3300_INAIEOMCIEM\u0018\u0007 \u0001(\t\u0012\u001b\n\u0013Unk3300_KLKFLIIOFKK\u0018\u0003 \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AdjustTrackingInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AdjustTrackingInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AdjustTrackingInfo_descriptor, new String[]{"Unk3300CHCOHLGBHLB", "Unk3300GAMLJPFKCGC", "Unk3300ONNMBNODPIA", "Unk3300MHDOPAMDMPL", "Unk3300INAIEOMCIEM", "Unk3300KLKFLIIOFKK"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AdjustTrackingInfoOuterClass$AdjustTrackingInfoOrBuilder.class */
    public interface AdjustTrackingInfoOrBuilder extends MessageOrBuilder {
        String getUnk3300CHCOHLGBHLB();

        ByteString getUnk3300CHCOHLGBHLBBytes();

        String getUnk3300GAMLJPFKCGC();

        ByteString getUnk3300GAMLJPFKCGCBytes();

        String getUnk3300ONNMBNODPIA();

        ByteString getUnk3300ONNMBNODPIABytes();

        String getUnk3300MHDOPAMDMPL();

        ByteString getUnk3300MHDOPAMDMPLBytes();

        String getUnk3300INAIEOMCIEM();

        ByteString getUnk3300INAIEOMCIEMBytes();

        String getUnk3300KLKFLIIOFKK();

        ByteString getUnk3300KLKFLIIOFKKBytes();
    }

    private AdjustTrackingInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AdjustTrackingInfoOuterClass$AdjustTrackingInfo.class */
    public static final class AdjustTrackingInfo extends GeneratedMessageV3 implements AdjustTrackingInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_CHCOHLGBHLB_FIELD_NUMBER = 2;
        private volatile Object unk3300CHCOHLGBHLB_;
        public static final int UNK3300_GAMLJPFKCGC_FIELD_NUMBER = 9;
        private volatile Object unk3300GAMLJPFKCGC_;
        public static final int UNK3300_ONNMBNODPIA_FIELD_NUMBER = 4;
        private volatile Object unk3300ONNMBNODPIA_;
        public static final int UNK3300_MHDOPAMDMPL_FIELD_NUMBER = 6;
        private volatile Object unk3300MHDOPAMDMPL_;
        public static final int UNK3300_INAIEOMCIEM_FIELD_NUMBER = 7;
        private volatile Object unk3300INAIEOMCIEM_;
        public static final int UNK3300_KLKFLIIOFKK_FIELD_NUMBER = 3;
        private volatile Object unk3300KLKFLIIOFKK_;
        private byte memoizedIsInitialized;
        private static final AdjustTrackingInfo DEFAULT_INSTANCE = new AdjustTrackingInfo();
        private static final Parser<AdjustTrackingInfo> PARSER = new AbstractParser<AdjustTrackingInfo>() { // from class: emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfo.1
            @Override // com.google.protobuf.Parser
            public AdjustTrackingInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AdjustTrackingInfo(input, extensionRegistry);
            }
        };

        private AdjustTrackingInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AdjustTrackingInfo() {
            this.memoizedIsInitialized = -1;
            this.unk3300CHCOHLGBHLB_ = "";
            this.unk3300GAMLJPFKCGC_ = "";
            this.unk3300ONNMBNODPIA_ = "";
            this.unk3300MHDOPAMDMPL_ = "";
            this.unk3300INAIEOMCIEM_ = "";
            this.unk3300KLKFLIIOFKK_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AdjustTrackingInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AdjustTrackingInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 18:
                                    this.unk3300CHCOHLGBHLB_ = input.readStringRequireUtf8();
                                    break;
                                case 26:
                                    this.unk3300KLKFLIIOFKK_ = input.readStringRequireUtf8();
                                    break;
                                case 34:
                                    this.unk3300ONNMBNODPIA_ = input.readStringRequireUtf8();
                                    break;
                                case 50:
                                    this.unk3300MHDOPAMDMPL_ = input.readStringRequireUtf8();
                                    break;
                                case 58:
                                    this.unk3300INAIEOMCIEM_ = input.readStringRequireUtf8();
                                    break;
                                case 74:
                                    this.unk3300GAMLJPFKCGC_ = input.readStringRequireUtf8();
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
            return AdjustTrackingInfoOuterClass.internal_static_AdjustTrackingInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AdjustTrackingInfoOuterClass.internal_static_AdjustTrackingInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AdjustTrackingInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
        public String getUnk3300CHCOHLGBHLB() {
            Object ref = this.unk3300CHCOHLGBHLB_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.unk3300CHCOHLGBHLB_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
        public ByteString getUnk3300CHCOHLGBHLBBytes() {
            Object ref = this.unk3300CHCOHLGBHLB_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.unk3300CHCOHLGBHLB_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
        public String getUnk3300GAMLJPFKCGC() {
            Object ref = this.unk3300GAMLJPFKCGC_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.unk3300GAMLJPFKCGC_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
        public ByteString getUnk3300GAMLJPFKCGCBytes() {
            Object ref = this.unk3300GAMLJPFKCGC_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.unk3300GAMLJPFKCGC_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
        public String getUnk3300ONNMBNODPIA() {
            Object ref = this.unk3300ONNMBNODPIA_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.unk3300ONNMBNODPIA_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
        public ByteString getUnk3300ONNMBNODPIABytes() {
            Object ref = this.unk3300ONNMBNODPIA_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.unk3300ONNMBNODPIA_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
        public String getUnk3300MHDOPAMDMPL() {
            Object ref = this.unk3300MHDOPAMDMPL_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.unk3300MHDOPAMDMPL_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
        public ByteString getUnk3300MHDOPAMDMPLBytes() {
            Object ref = this.unk3300MHDOPAMDMPL_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.unk3300MHDOPAMDMPL_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
        public String getUnk3300INAIEOMCIEM() {
            Object ref = this.unk3300INAIEOMCIEM_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.unk3300INAIEOMCIEM_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
        public ByteString getUnk3300INAIEOMCIEMBytes() {
            Object ref = this.unk3300INAIEOMCIEM_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.unk3300INAIEOMCIEM_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
        public String getUnk3300KLKFLIIOFKK() {
            Object ref = this.unk3300KLKFLIIOFKK_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.unk3300KLKFLIIOFKK_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
        public ByteString getUnk3300KLKFLIIOFKKBytes() {
            Object ref = this.unk3300KLKFLIIOFKK_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.unk3300KLKFLIIOFKK_ = b;
            return b;
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
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300CHCOHLGBHLB_)) {
                GeneratedMessageV3.writeString(output, 2, this.unk3300CHCOHLGBHLB_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300KLKFLIIOFKK_)) {
                GeneratedMessageV3.writeString(output, 3, this.unk3300KLKFLIIOFKK_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300ONNMBNODPIA_)) {
                GeneratedMessageV3.writeString(output, 4, this.unk3300ONNMBNODPIA_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300MHDOPAMDMPL_)) {
                GeneratedMessageV3.writeString(output, 6, this.unk3300MHDOPAMDMPL_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300INAIEOMCIEM_)) {
                GeneratedMessageV3.writeString(output, 7, this.unk3300INAIEOMCIEM_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300GAMLJPFKCGC_)) {
                GeneratedMessageV3.writeString(output, 9, this.unk3300GAMLJPFKCGC_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300CHCOHLGBHLB_)) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(2, this.unk3300CHCOHLGBHLB_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300KLKFLIIOFKK_)) {
                size2 += GeneratedMessageV3.computeStringSize(3, this.unk3300KLKFLIIOFKK_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300ONNMBNODPIA_)) {
                size2 += GeneratedMessageV3.computeStringSize(4, this.unk3300ONNMBNODPIA_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300MHDOPAMDMPL_)) {
                size2 += GeneratedMessageV3.computeStringSize(6, this.unk3300MHDOPAMDMPL_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300INAIEOMCIEM_)) {
                size2 += GeneratedMessageV3.computeStringSize(7, this.unk3300INAIEOMCIEM_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300GAMLJPFKCGC_)) {
                size2 += GeneratedMessageV3.computeStringSize(9, this.unk3300GAMLJPFKCGC_);
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
            if (!(obj instanceof AdjustTrackingInfo)) {
                return equals(obj);
            }
            AdjustTrackingInfo other = (AdjustTrackingInfo) obj;
            return getUnk3300CHCOHLGBHLB().equals(other.getUnk3300CHCOHLGBHLB()) && getUnk3300GAMLJPFKCGC().equals(other.getUnk3300GAMLJPFKCGC()) && getUnk3300ONNMBNODPIA().equals(other.getUnk3300ONNMBNODPIA()) && getUnk3300MHDOPAMDMPL().equals(other.getUnk3300MHDOPAMDMPL()) && getUnk3300INAIEOMCIEM().equals(other.getUnk3300INAIEOMCIEM()) && getUnk3300KLKFLIIOFKK().equals(other.getUnk3300KLKFLIIOFKK()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + getUnk3300CHCOHLGBHLB().hashCode())) + 9)) + getUnk3300GAMLJPFKCGC().hashCode())) + 4)) + getUnk3300ONNMBNODPIA().hashCode())) + 6)) + getUnk3300MHDOPAMDMPL().hashCode())) + 7)) + getUnk3300INAIEOMCIEM().hashCode())) + 3)) + getUnk3300KLKFLIIOFKK().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static AdjustTrackingInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AdjustTrackingInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AdjustTrackingInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AdjustTrackingInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AdjustTrackingInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AdjustTrackingInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AdjustTrackingInfo parseFrom(InputStream input) throws IOException {
            return (AdjustTrackingInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AdjustTrackingInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AdjustTrackingInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AdjustTrackingInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AdjustTrackingInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AdjustTrackingInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AdjustTrackingInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AdjustTrackingInfo parseFrom(CodedInputStream input) throws IOException {
            return (AdjustTrackingInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AdjustTrackingInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AdjustTrackingInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AdjustTrackingInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AdjustTrackingInfoOuterClass$AdjustTrackingInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AdjustTrackingInfoOrBuilder {
            private Object unk3300CHCOHLGBHLB_ = "";
            private Object unk3300GAMLJPFKCGC_ = "";
            private Object unk3300ONNMBNODPIA_ = "";
            private Object unk3300MHDOPAMDMPL_ = "";
            private Object unk3300INAIEOMCIEM_ = "";
            private Object unk3300KLKFLIIOFKK_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return AdjustTrackingInfoOuterClass.internal_static_AdjustTrackingInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AdjustTrackingInfoOuterClass.internal_static_AdjustTrackingInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AdjustTrackingInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AdjustTrackingInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300CHCOHLGBHLB_ = "";
                this.unk3300GAMLJPFKCGC_ = "";
                this.unk3300ONNMBNODPIA_ = "";
                this.unk3300MHDOPAMDMPL_ = "";
                this.unk3300INAIEOMCIEM_ = "";
                this.unk3300KLKFLIIOFKK_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AdjustTrackingInfoOuterClass.internal_static_AdjustTrackingInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AdjustTrackingInfo getDefaultInstanceForType() {
                return AdjustTrackingInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AdjustTrackingInfo build() {
                AdjustTrackingInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AdjustTrackingInfo buildPartial() {
                AdjustTrackingInfo result = new AdjustTrackingInfo(this);
                result.unk3300CHCOHLGBHLB_ = this.unk3300CHCOHLGBHLB_;
                result.unk3300GAMLJPFKCGC_ = this.unk3300GAMLJPFKCGC_;
                result.unk3300ONNMBNODPIA_ = this.unk3300ONNMBNODPIA_;
                result.unk3300MHDOPAMDMPL_ = this.unk3300MHDOPAMDMPL_;
                result.unk3300INAIEOMCIEM_ = this.unk3300INAIEOMCIEM_;
                result.unk3300KLKFLIIOFKK_ = this.unk3300KLKFLIIOFKK_;
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
                if (other instanceof AdjustTrackingInfo) {
                    return mergeFrom((AdjustTrackingInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AdjustTrackingInfo other) {
                if (other == AdjustTrackingInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.getUnk3300CHCOHLGBHLB().isEmpty()) {
                    this.unk3300CHCOHLGBHLB_ = other.unk3300CHCOHLGBHLB_;
                    onChanged();
                }
                if (!other.getUnk3300GAMLJPFKCGC().isEmpty()) {
                    this.unk3300GAMLJPFKCGC_ = other.unk3300GAMLJPFKCGC_;
                    onChanged();
                }
                if (!other.getUnk3300ONNMBNODPIA().isEmpty()) {
                    this.unk3300ONNMBNODPIA_ = other.unk3300ONNMBNODPIA_;
                    onChanged();
                }
                if (!other.getUnk3300MHDOPAMDMPL().isEmpty()) {
                    this.unk3300MHDOPAMDMPL_ = other.unk3300MHDOPAMDMPL_;
                    onChanged();
                }
                if (!other.getUnk3300INAIEOMCIEM().isEmpty()) {
                    this.unk3300INAIEOMCIEM_ = other.unk3300INAIEOMCIEM_;
                    onChanged();
                }
                if (!other.getUnk3300KLKFLIIOFKK().isEmpty()) {
                    this.unk3300KLKFLIIOFKK_ = other.unk3300KLKFLIIOFKK_;
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
                AdjustTrackingInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AdjustTrackingInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AdjustTrackingInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
            public String getUnk3300CHCOHLGBHLB() {
                Object ref = this.unk3300CHCOHLGBHLB_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.unk3300CHCOHLGBHLB_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
            public ByteString getUnk3300CHCOHLGBHLBBytes() {
                Object ref = this.unk3300CHCOHLGBHLB_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.unk3300CHCOHLGBHLB_ = b;
                return b;
            }

            public Builder setUnk3300CHCOHLGBHLB(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unk3300CHCOHLGBHLB_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300CHCOHLGBHLB() {
                this.unk3300CHCOHLGBHLB_ = AdjustTrackingInfo.getDefaultInstance().getUnk3300CHCOHLGBHLB();
                onChanged();
                return this;
            }

            public Builder setUnk3300CHCOHLGBHLBBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                AdjustTrackingInfo.checkByteStringIsUtf8(value);
                this.unk3300CHCOHLGBHLB_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
            public String getUnk3300GAMLJPFKCGC() {
                Object ref = this.unk3300GAMLJPFKCGC_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.unk3300GAMLJPFKCGC_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
            public ByteString getUnk3300GAMLJPFKCGCBytes() {
                Object ref = this.unk3300GAMLJPFKCGC_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.unk3300GAMLJPFKCGC_ = b;
                return b;
            }

            public Builder setUnk3300GAMLJPFKCGC(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unk3300GAMLJPFKCGC_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300GAMLJPFKCGC() {
                this.unk3300GAMLJPFKCGC_ = AdjustTrackingInfo.getDefaultInstance().getUnk3300GAMLJPFKCGC();
                onChanged();
                return this;
            }

            public Builder setUnk3300GAMLJPFKCGCBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                AdjustTrackingInfo.checkByteStringIsUtf8(value);
                this.unk3300GAMLJPFKCGC_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
            public String getUnk3300ONNMBNODPIA() {
                Object ref = this.unk3300ONNMBNODPIA_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.unk3300ONNMBNODPIA_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
            public ByteString getUnk3300ONNMBNODPIABytes() {
                Object ref = this.unk3300ONNMBNODPIA_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.unk3300ONNMBNODPIA_ = b;
                return b;
            }

            public Builder setUnk3300ONNMBNODPIA(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unk3300ONNMBNODPIA_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300ONNMBNODPIA() {
                this.unk3300ONNMBNODPIA_ = AdjustTrackingInfo.getDefaultInstance().getUnk3300ONNMBNODPIA();
                onChanged();
                return this;
            }

            public Builder setUnk3300ONNMBNODPIABytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                AdjustTrackingInfo.checkByteStringIsUtf8(value);
                this.unk3300ONNMBNODPIA_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
            public String getUnk3300MHDOPAMDMPL() {
                Object ref = this.unk3300MHDOPAMDMPL_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.unk3300MHDOPAMDMPL_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
            public ByteString getUnk3300MHDOPAMDMPLBytes() {
                Object ref = this.unk3300MHDOPAMDMPL_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.unk3300MHDOPAMDMPL_ = b;
                return b;
            }

            public Builder setUnk3300MHDOPAMDMPL(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unk3300MHDOPAMDMPL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300MHDOPAMDMPL() {
                this.unk3300MHDOPAMDMPL_ = AdjustTrackingInfo.getDefaultInstance().getUnk3300MHDOPAMDMPL();
                onChanged();
                return this;
            }

            public Builder setUnk3300MHDOPAMDMPLBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                AdjustTrackingInfo.checkByteStringIsUtf8(value);
                this.unk3300MHDOPAMDMPL_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
            public String getUnk3300INAIEOMCIEM() {
                Object ref = this.unk3300INAIEOMCIEM_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.unk3300INAIEOMCIEM_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
            public ByteString getUnk3300INAIEOMCIEMBytes() {
                Object ref = this.unk3300INAIEOMCIEM_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.unk3300INAIEOMCIEM_ = b;
                return b;
            }

            public Builder setUnk3300INAIEOMCIEM(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unk3300INAIEOMCIEM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300INAIEOMCIEM() {
                this.unk3300INAIEOMCIEM_ = AdjustTrackingInfo.getDefaultInstance().getUnk3300INAIEOMCIEM();
                onChanged();
                return this;
            }

            public Builder setUnk3300INAIEOMCIEMBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                AdjustTrackingInfo.checkByteStringIsUtf8(value);
                this.unk3300INAIEOMCIEM_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
            public String getUnk3300KLKFLIIOFKK() {
                Object ref = this.unk3300KLKFLIIOFKK_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.unk3300KLKFLIIOFKK_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.AdjustTrackingInfoOuterClass.AdjustTrackingInfoOrBuilder
            public ByteString getUnk3300KLKFLIIOFKKBytes() {
                Object ref = this.unk3300KLKFLIIOFKK_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.unk3300KLKFLIIOFKK_ = b;
                return b;
            }

            public Builder setUnk3300KLKFLIIOFKK(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unk3300KLKFLIIOFKK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300KLKFLIIOFKK() {
                this.unk3300KLKFLIIOFKK_ = AdjustTrackingInfo.getDefaultInstance().getUnk3300KLKFLIIOFKK();
                onChanged();
                return this;
            }

            public Builder setUnk3300KLKFLIIOFKKBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                AdjustTrackingInfo.checkByteStringIsUtf8(value);
                this.unk3300KLKFLIIOFKK_ = value;
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

        public static AdjustTrackingInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AdjustTrackingInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AdjustTrackingInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AdjustTrackingInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
