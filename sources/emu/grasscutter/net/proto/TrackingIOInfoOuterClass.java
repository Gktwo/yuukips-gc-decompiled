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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrackingIOInfoOuterClass.class */
public final class TrackingIOInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014TrackingIOInfo.proto\"É\u0001\n\u000eTrackingIOInfo\u0012\u0014\n\frydevicetype\u0018\u0002 \u0001(\t\u0012\u0010\n\bclientTz\u0018\u0006 \u0001(\t\u0012\u001b\n\u0013Unk3300_CCOGBICMHKG\u0018\u000f \u0001(\t\u0012\u001b\n\u0013Unk3300_NMDNLHLAKAM\u0018\u000b \u0001(\t\u0012\u001b\n\u0013Unk3300_PIBFPDAMJLE\u0018\u0005 \u0001(\t\u0012\u001b\n\u0013Unk3300_DJHKHEFPCDK\u0018\t \u0001(\t\u0012\u001b\n\u0013Unk3300_CNPIGDOEJPB\u0018\u0003 \u0001(\tB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TrackingIOInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TrackingIOInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TrackingIOInfo_descriptor, new String[]{"Rydevicetype", "ClientTz", "Unk3300CCOGBICMHKG", "Unk3300NMDNLHLAKAM", "Unk3300PIBFPDAMJLE", "Unk3300DJHKHEFPCDK", "Unk3300CNPIGDOEJPB"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrackingIOInfoOuterClass$TrackingIOInfoOrBuilder.class */
    public interface TrackingIOInfoOrBuilder extends MessageOrBuilder {
        String getRydevicetype();

        ByteString getRydevicetypeBytes();

        String getClientTz();

        ByteString getClientTzBytes();

        String getUnk3300CCOGBICMHKG();

        ByteString getUnk3300CCOGBICMHKGBytes();

        String getUnk3300NMDNLHLAKAM();

        ByteString getUnk3300NMDNLHLAKAMBytes();

        String getUnk3300PIBFPDAMJLE();

        ByteString getUnk3300PIBFPDAMJLEBytes();

        String getUnk3300DJHKHEFPCDK();

        ByteString getUnk3300DJHKHEFPCDKBytes();

        String getUnk3300CNPIGDOEJPB();

        ByteString getUnk3300CNPIGDOEJPBBytes();
    }

    private TrackingIOInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrackingIOInfoOuterClass$TrackingIOInfo.class */
    public static final class TrackingIOInfo extends GeneratedMessageV3 implements TrackingIOInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RYDEVICETYPE_FIELD_NUMBER = 2;
        private volatile Object rydevicetype_;
        public static final int CLIENTTZ_FIELD_NUMBER = 6;
        private volatile Object clientTz_;
        public static final int UNK3300_CCOGBICMHKG_FIELD_NUMBER = 15;
        private volatile Object unk3300CCOGBICMHKG_;
        public static final int UNK3300_NMDNLHLAKAM_FIELD_NUMBER = 11;
        private volatile Object unk3300NMDNLHLAKAM_;
        public static final int UNK3300_PIBFPDAMJLE_FIELD_NUMBER = 5;
        private volatile Object unk3300PIBFPDAMJLE_;
        public static final int UNK3300_DJHKHEFPCDK_FIELD_NUMBER = 9;
        private volatile Object unk3300DJHKHEFPCDK_;
        public static final int UNK3300_CNPIGDOEJPB_FIELD_NUMBER = 3;
        private volatile Object unk3300CNPIGDOEJPB_;
        private byte memoizedIsInitialized;
        private static final TrackingIOInfo DEFAULT_INSTANCE = new TrackingIOInfo();
        private static final Parser<TrackingIOInfo> PARSER = new AbstractParser<TrackingIOInfo>() { // from class: emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfo.1
            @Override // com.google.protobuf.Parser
            public TrackingIOInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TrackingIOInfo(input, extensionRegistry);
            }
        };

        private TrackingIOInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private TrackingIOInfo() {
            this.memoizedIsInitialized = -1;
            this.rydevicetype_ = "";
            this.clientTz_ = "";
            this.unk3300CCOGBICMHKG_ = "";
            this.unk3300NMDNLHLAKAM_ = "";
            this.unk3300PIBFPDAMJLE_ = "";
            this.unk3300DJHKHEFPCDK_ = "";
            this.unk3300CNPIGDOEJPB_ = "";
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TrackingIOInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TrackingIOInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 18:
                                this.rydevicetype_ = input.readStringRequireUtf8();
                                break;
                            case 26:
                                this.unk3300CNPIGDOEJPB_ = input.readStringRequireUtf8();
                                break;
                            case 42:
                                this.unk3300PIBFPDAMJLE_ = input.readStringRequireUtf8();
                                break;
                            case 50:
                                this.clientTz_ = input.readStringRequireUtf8();
                                break;
                            case 74:
                                this.unk3300DJHKHEFPCDK_ = input.readStringRequireUtf8();
                                break;
                            case 90:
                                this.unk3300NMDNLHLAKAM_ = input.readStringRequireUtf8();
                                break;
                            case 122:
                                this.unk3300CCOGBICMHKG_ = input.readStringRequireUtf8();
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
            return TrackingIOInfoOuterClass.internal_static_TrackingIOInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TrackingIOInfoOuterClass.internal_static_TrackingIOInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TrackingIOInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
        public String getRydevicetype() {
            Object ref = this.rydevicetype_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.rydevicetype_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
        public ByteString getRydevicetypeBytes() {
            Object ref = this.rydevicetype_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.rydevicetype_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
        public String getClientTz() {
            Object ref = this.clientTz_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.clientTz_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
        public ByteString getClientTzBytes() {
            Object ref = this.clientTz_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.clientTz_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
        public String getUnk3300CCOGBICMHKG() {
            Object ref = this.unk3300CCOGBICMHKG_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.unk3300CCOGBICMHKG_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
        public ByteString getUnk3300CCOGBICMHKGBytes() {
            Object ref = this.unk3300CCOGBICMHKG_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.unk3300CCOGBICMHKG_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
        public String getUnk3300NMDNLHLAKAM() {
            Object ref = this.unk3300NMDNLHLAKAM_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.unk3300NMDNLHLAKAM_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
        public ByteString getUnk3300NMDNLHLAKAMBytes() {
            Object ref = this.unk3300NMDNLHLAKAM_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.unk3300NMDNLHLAKAM_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
        public String getUnk3300PIBFPDAMJLE() {
            Object ref = this.unk3300PIBFPDAMJLE_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.unk3300PIBFPDAMJLE_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
        public ByteString getUnk3300PIBFPDAMJLEBytes() {
            Object ref = this.unk3300PIBFPDAMJLE_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.unk3300PIBFPDAMJLE_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
        public String getUnk3300DJHKHEFPCDK() {
            Object ref = this.unk3300DJHKHEFPCDK_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.unk3300DJHKHEFPCDK_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
        public ByteString getUnk3300DJHKHEFPCDKBytes() {
            Object ref = this.unk3300DJHKHEFPCDK_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.unk3300DJHKHEFPCDK_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
        public String getUnk3300CNPIGDOEJPB() {
            Object ref = this.unk3300CNPIGDOEJPB_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.unk3300CNPIGDOEJPB_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
        public ByteString getUnk3300CNPIGDOEJPBBytes() {
            Object ref = this.unk3300CNPIGDOEJPB_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.unk3300CNPIGDOEJPB_ = b;
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
            if (!GeneratedMessageV3.isStringEmpty(this.rydevicetype_)) {
                GeneratedMessageV3.writeString(output, 2, this.rydevicetype_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300CNPIGDOEJPB_)) {
                GeneratedMessageV3.writeString(output, 3, this.unk3300CNPIGDOEJPB_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300PIBFPDAMJLE_)) {
                GeneratedMessageV3.writeString(output, 5, this.unk3300PIBFPDAMJLE_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientTz_)) {
                GeneratedMessageV3.writeString(output, 6, this.clientTz_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300DJHKHEFPCDK_)) {
                GeneratedMessageV3.writeString(output, 9, this.unk3300DJHKHEFPCDK_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300NMDNLHLAKAM_)) {
                GeneratedMessageV3.writeString(output, 11, this.unk3300NMDNLHLAKAM_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300CCOGBICMHKG_)) {
                GeneratedMessageV3.writeString(output, 15, this.unk3300CCOGBICMHKG_);
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
            if (!GeneratedMessageV3.isStringEmpty(this.rydevicetype_)) {
                size2 = 0 + GeneratedMessageV3.computeStringSize(2, this.rydevicetype_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300CNPIGDOEJPB_)) {
                size2 += GeneratedMessageV3.computeStringSize(3, this.unk3300CNPIGDOEJPB_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300PIBFPDAMJLE_)) {
                size2 += GeneratedMessageV3.computeStringSize(5, this.unk3300PIBFPDAMJLE_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.clientTz_)) {
                size2 += GeneratedMessageV3.computeStringSize(6, this.clientTz_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300DJHKHEFPCDK_)) {
                size2 += GeneratedMessageV3.computeStringSize(9, this.unk3300DJHKHEFPCDK_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300NMDNLHLAKAM_)) {
                size2 += GeneratedMessageV3.computeStringSize(11, this.unk3300NMDNLHLAKAM_);
            }
            if (!GeneratedMessageV3.isStringEmpty(this.unk3300CCOGBICMHKG_)) {
                size2 += GeneratedMessageV3.computeStringSize(15, this.unk3300CCOGBICMHKG_);
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
            if (!(obj instanceof TrackingIOInfo)) {
                return equals(obj);
            }
            TrackingIOInfo other = (TrackingIOInfo) obj;
            return getRydevicetype().equals(other.getRydevicetype()) && getClientTz().equals(other.getClientTz()) && getUnk3300CCOGBICMHKG().equals(other.getUnk3300CCOGBICMHKG()) && getUnk3300NMDNLHLAKAM().equals(other.getUnk3300NMDNLHLAKAM()) && getUnk3300PIBFPDAMJLE().equals(other.getUnk3300PIBFPDAMJLE()) && getUnk3300DJHKHEFPCDK().equals(other.getUnk3300DJHKHEFPCDK()) && getUnk3300CNPIGDOEJPB().equals(other.getUnk3300CNPIGDOEJPB()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 2)) + getRydevicetype().hashCode())) + 6)) + getClientTz().hashCode())) + 15)) + getUnk3300CCOGBICMHKG().hashCode())) + 11)) + getUnk3300NMDNLHLAKAM().hashCode())) + 5)) + getUnk3300PIBFPDAMJLE().hashCode())) + 9)) + getUnk3300DJHKHEFPCDK().hashCode())) + 3)) + getUnk3300CNPIGDOEJPB().hashCode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static TrackingIOInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TrackingIOInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrackingIOInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TrackingIOInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrackingIOInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TrackingIOInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TrackingIOInfo parseFrom(InputStream input) throws IOException {
            return (TrackingIOInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TrackingIOInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrackingIOInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TrackingIOInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (TrackingIOInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TrackingIOInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrackingIOInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TrackingIOInfo parseFrom(CodedInputStream input) throws IOException {
            return (TrackingIOInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TrackingIOInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TrackingIOInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TrackingIOInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TrackingIOInfoOuterClass$TrackingIOInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TrackingIOInfoOrBuilder {
            private Object rydevicetype_ = "";
            private Object clientTz_ = "";
            private Object unk3300CCOGBICMHKG_ = "";
            private Object unk3300NMDNLHLAKAM_ = "";
            private Object unk3300PIBFPDAMJLE_ = "";
            private Object unk3300DJHKHEFPCDK_ = "";
            private Object unk3300CNPIGDOEJPB_ = "";

            public static final Descriptors.Descriptor getDescriptor() {
                return TrackingIOInfoOuterClass.internal_static_TrackingIOInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TrackingIOInfoOuterClass.internal_static_TrackingIOInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(TrackingIOInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TrackingIOInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.rydevicetype_ = "";
                this.clientTz_ = "";
                this.unk3300CCOGBICMHKG_ = "";
                this.unk3300NMDNLHLAKAM_ = "";
                this.unk3300PIBFPDAMJLE_ = "";
                this.unk3300DJHKHEFPCDK_ = "";
                this.unk3300CNPIGDOEJPB_ = "";
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TrackingIOInfoOuterClass.internal_static_TrackingIOInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TrackingIOInfo getDefaultInstanceForType() {
                return TrackingIOInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TrackingIOInfo build() {
                TrackingIOInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TrackingIOInfo buildPartial() {
                TrackingIOInfo result = new TrackingIOInfo(this);
                result.rydevicetype_ = this.rydevicetype_;
                result.clientTz_ = this.clientTz_;
                result.unk3300CCOGBICMHKG_ = this.unk3300CCOGBICMHKG_;
                result.unk3300NMDNLHLAKAM_ = this.unk3300NMDNLHLAKAM_;
                result.unk3300PIBFPDAMJLE_ = this.unk3300PIBFPDAMJLE_;
                result.unk3300DJHKHEFPCDK_ = this.unk3300DJHKHEFPCDK_;
                result.unk3300CNPIGDOEJPB_ = this.unk3300CNPIGDOEJPB_;
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
                if (other instanceof TrackingIOInfo) {
                    return mergeFrom((TrackingIOInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TrackingIOInfo other) {
                if (other == TrackingIOInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.getRydevicetype().isEmpty()) {
                    this.rydevicetype_ = other.rydevicetype_;
                    onChanged();
                }
                if (!other.getClientTz().isEmpty()) {
                    this.clientTz_ = other.clientTz_;
                    onChanged();
                }
                if (!other.getUnk3300CCOGBICMHKG().isEmpty()) {
                    this.unk3300CCOGBICMHKG_ = other.unk3300CCOGBICMHKG_;
                    onChanged();
                }
                if (!other.getUnk3300NMDNLHLAKAM().isEmpty()) {
                    this.unk3300NMDNLHLAKAM_ = other.unk3300NMDNLHLAKAM_;
                    onChanged();
                }
                if (!other.getUnk3300PIBFPDAMJLE().isEmpty()) {
                    this.unk3300PIBFPDAMJLE_ = other.unk3300PIBFPDAMJLE_;
                    onChanged();
                }
                if (!other.getUnk3300DJHKHEFPCDK().isEmpty()) {
                    this.unk3300DJHKHEFPCDK_ = other.unk3300DJHKHEFPCDK_;
                    onChanged();
                }
                if (!other.getUnk3300CNPIGDOEJPB().isEmpty()) {
                    this.unk3300CNPIGDOEJPB_ = other.unk3300CNPIGDOEJPB_;
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
                TrackingIOInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = TrackingIOInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TrackingIOInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
            public String getRydevicetype() {
                Object ref = this.rydevicetype_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.rydevicetype_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
            public ByteString getRydevicetypeBytes() {
                Object ref = this.rydevicetype_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.rydevicetype_ = b;
                return b;
            }

            public Builder setRydevicetype(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.rydevicetype_ = value;
                onChanged();
                return this;
            }

            public Builder clearRydevicetype() {
                this.rydevicetype_ = TrackingIOInfo.getDefaultInstance().getRydevicetype();
                onChanged();
                return this;
            }

            public Builder setRydevicetypeBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                TrackingIOInfo.checkByteStringIsUtf8(value);
                this.rydevicetype_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
            public String getClientTz() {
                Object ref = this.clientTz_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.clientTz_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
            public ByteString getClientTzBytes() {
                Object ref = this.clientTz_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.clientTz_ = b;
                return b;
            }

            public Builder setClientTz(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.clientTz_ = value;
                onChanged();
                return this;
            }

            public Builder clearClientTz() {
                this.clientTz_ = TrackingIOInfo.getDefaultInstance().getClientTz();
                onChanged();
                return this;
            }

            public Builder setClientTzBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                TrackingIOInfo.checkByteStringIsUtf8(value);
                this.clientTz_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
            public String getUnk3300CCOGBICMHKG() {
                Object ref = this.unk3300CCOGBICMHKG_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.unk3300CCOGBICMHKG_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
            public ByteString getUnk3300CCOGBICMHKGBytes() {
                Object ref = this.unk3300CCOGBICMHKG_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.unk3300CCOGBICMHKG_ = b;
                return b;
            }

            public Builder setUnk3300CCOGBICMHKG(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unk3300CCOGBICMHKG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300CCOGBICMHKG() {
                this.unk3300CCOGBICMHKG_ = TrackingIOInfo.getDefaultInstance().getUnk3300CCOGBICMHKG();
                onChanged();
                return this;
            }

            public Builder setUnk3300CCOGBICMHKGBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                TrackingIOInfo.checkByteStringIsUtf8(value);
                this.unk3300CCOGBICMHKG_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
            public String getUnk3300NMDNLHLAKAM() {
                Object ref = this.unk3300NMDNLHLAKAM_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.unk3300NMDNLHLAKAM_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
            public ByteString getUnk3300NMDNLHLAKAMBytes() {
                Object ref = this.unk3300NMDNLHLAKAM_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.unk3300NMDNLHLAKAM_ = b;
                return b;
            }

            public Builder setUnk3300NMDNLHLAKAM(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unk3300NMDNLHLAKAM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NMDNLHLAKAM() {
                this.unk3300NMDNLHLAKAM_ = TrackingIOInfo.getDefaultInstance().getUnk3300NMDNLHLAKAM();
                onChanged();
                return this;
            }

            public Builder setUnk3300NMDNLHLAKAMBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                TrackingIOInfo.checkByteStringIsUtf8(value);
                this.unk3300NMDNLHLAKAM_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
            public String getUnk3300PIBFPDAMJLE() {
                Object ref = this.unk3300PIBFPDAMJLE_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.unk3300PIBFPDAMJLE_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
            public ByteString getUnk3300PIBFPDAMJLEBytes() {
                Object ref = this.unk3300PIBFPDAMJLE_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.unk3300PIBFPDAMJLE_ = b;
                return b;
            }

            public Builder setUnk3300PIBFPDAMJLE(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unk3300PIBFPDAMJLE_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300PIBFPDAMJLE() {
                this.unk3300PIBFPDAMJLE_ = TrackingIOInfo.getDefaultInstance().getUnk3300PIBFPDAMJLE();
                onChanged();
                return this;
            }

            public Builder setUnk3300PIBFPDAMJLEBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                TrackingIOInfo.checkByteStringIsUtf8(value);
                this.unk3300PIBFPDAMJLE_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
            public String getUnk3300DJHKHEFPCDK() {
                Object ref = this.unk3300DJHKHEFPCDK_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.unk3300DJHKHEFPCDK_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
            public ByteString getUnk3300DJHKHEFPCDKBytes() {
                Object ref = this.unk3300DJHKHEFPCDK_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.unk3300DJHKHEFPCDK_ = b;
                return b;
            }

            public Builder setUnk3300DJHKHEFPCDK(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unk3300DJHKHEFPCDK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300DJHKHEFPCDK() {
                this.unk3300DJHKHEFPCDK_ = TrackingIOInfo.getDefaultInstance().getUnk3300DJHKHEFPCDK();
                onChanged();
                return this;
            }

            public Builder setUnk3300DJHKHEFPCDKBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                TrackingIOInfo.checkByteStringIsUtf8(value);
                this.unk3300DJHKHEFPCDK_ = value;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
            public String getUnk3300CNPIGDOEJPB() {
                Object ref = this.unk3300CNPIGDOEJPB_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.unk3300CNPIGDOEJPB_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.TrackingIOInfoOuterClass.TrackingIOInfoOrBuilder
            public ByteString getUnk3300CNPIGDOEJPBBytes() {
                Object ref = this.unk3300CNPIGDOEJPB_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.unk3300CNPIGDOEJPB_ = b;
                return b;
            }

            public Builder setUnk3300CNPIGDOEJPB(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.unk3300CNPIGDOEJPB_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300CNPIGDOEJPB() {
                this.unk3300CNPIGDOEJPB_ = TrackingIOInfo.getDefaultInstance().getUnk3300CNPIGDOEJPB();
                onChanged();
                return this;
            }

            public Builder setUnk3300CNPIGDOEJPBBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                TrackingIOInfo.checkByteStringIsUtf8(value);
                this.unk3300CNPIGDOEJPB_ = value;
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

        public static TrackingIOInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TrackingIOInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TrackingIOInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TrackingIOInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
