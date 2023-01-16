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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.GravenInnocenceCampInfoOuterClass;
import emu.grasscutter.net.proto.GravenInnocenceCarveInfoOuterClass;
import emu.grasscutter.net.proto.GravenInnocencePhotoInfoOuterClass;
import emu.grasscutter.net.proto.GravenInnocenceRaceInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceDetailInfoOuterClass.class */
public final class GravenInnocenceDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001fGravenInnocenceDetailInfo.proto\u001a\u001dGravenInnocenceCampInfo.proto\u001a\u001eGravenInnocenceCarveInfo.proto\u001a\u001eGravenInnocencePhotoInfo.proto\u001a\u001dGravenInnocenceRaceInfo.proto\"î\u0001\n\u0019GravenInnocenceDetailInfo\u0012\u0019\n\u0011is_content_closed\u0018\b \u0001(\b\u0012+\n\trace_info\u0018\u0002 \u0001(\u000b2\u0018.GravenInnocenceRaceInfo\u0012+\n\tcamp_info\u0018\u0003 \u0001(\u000b2\u0018.GravenInnocenceCampInfo\u0012-\n\ncarve_info\u0018\r \u0001(\u000b2\u0019.GravenInnocenceCarveInfo\u0012-\n\nphoto_info\u0018\n \u0001(\u000b2\u0019.GravenInnocencePhotoInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GravenInnocenceCampInfoOuterClass.getDescriptor(), GravenInnocenceCarveInfoOuterClass.getDescriptor(), GravenInnocencePhotoInfoOuterClass.getDescriptor(), GravenInnocenceRaceInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GravenInnocenceDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GravenInnocenceDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GravenInnocenceDetailInfo_descriptor, new String[]{"IsContentClosed", "RaceInfo", "CampInfo", "CarveInfo", "PhotoInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceDetailInfoOuterClass$GravenInnocenceDetailInfoOrBuilder.class */
    public interface GravenInnocenceDetailInfoOrBuilder extends MessageOrBuilder {
        boolean getIsContentClosed();

        boolean hasRaceInfo();

        GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo getRaceInfo();

        GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfoOrBuilder getRaceInfoOrBuilder();

        boolean hasCampInfo();

        GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo getCampInfo();

        GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfoOrBuilder getCampInfoOrBuilder();

        boolean hasCarveInfo();

        GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo getCarveInfo();

        GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder getCarveInfoOrBuilder();

        boolean hasPhotoInfo();

        GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo getPhotoInfo();

        GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder getPhotoInfoOrBuilder();
    }

    private GravenInnocenceDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceDetailInfoOuterClass$GravenInnocenceDetailInfo.class */
    public static final class GravenInnocenceDetailInfo extends GeneratedMessageV3 implements GravenInnocenceDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 8;
        private boolean isContentClosed_;
        public static final int RACE_INFO_FIELD_NUMBER = 2;
        private GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo raceInfo_;
        public static final int CAMP_INFO_FIELD_NUMBER = 3;
        private GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo campInfo_;
        public static final int CARVE_INFO_FIELD_NUMBER = 13;
        private GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo carveInfo_;
        public static final int PHOTO_INFO_FIELD_NUMBER = 10;
        private GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo photoInfo_;
        private byte memoizedIsInitialized;
        private static final GravenInnocenceDetailInfo DEFAULT_INSTANCE = new GravenInnocenceDetailInfo();
        private static final Parser<GravenInnocenceDetailInfo> PARSER = new AbstractParser<GravenInnocenceDetailInfo>() { // from class: emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfo.1
            @Override // com.google.protobuf.Parser
            public GravenInnocenceDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GravenInnocenceDetailInfo(input, extensionRegistry);
            }
        };

        private GravenInnocenceDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GravenInnocenceDetailInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GravenInnocenceDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GravenInnocenceDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo.Builder subBuilder = this.raceInfo_ != null ? this.raceInfo_.toBuilder() : null;
                                this.raceInfo_ = (GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo) input.readMessage(GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.raceInfo_);
                                    this.raceInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 26:
                                GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo.Builder subBuilder2 = this.campInfo_ != null ? this.campInfo_.toBuilder() : null;
                                this.campInfo_ = (GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo) input.readMessage(GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.campInfo_);
                                    this.campInfo_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 64:
                                this.isContentClosed_ = input.readBool();
                                break;
                            case 82:
                                GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo.Builder subBuilder3 = this.photoInfo_ != null ? this.photoInfo_.toBuilder() : null;
                                this.photoInfo_ = (GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo) input.readMessage(GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo.parser(), extensionRegistry);
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(this.photoInfo_);
                                    this.photoInfo_ = subBuilder3.buildPartial();
                                    break;
                                }
                            case 106:
                                GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo.Builder subBuilder4 = this.carveInfo_ != null ? this.carveInfo_.toBuilder() : null;
                                this.carveInfo_ = (GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo) input.readMessage(GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo.parser(), extensionRegistry);
                                if (subBuilder4 == null) {
                                    break;
                                } else {
                                    subBuilder4.mergeFrom(this.carveInfo_);
                                    this.carveInfo_ = subBuilder4.buildPartial();
                                    break;
                                }
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
            return GravenInnocenceDetailInfoOuterClass.internal_static_GravenInnocenceDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GravenInnocenceDetailInfoOuterClass.internal_static_GravenInnocenceDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GravenInnocenceDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
        public boolean hasRaceInfo() {
            return this.raceInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
        public GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo getRaceInfo() {
            return this.raceInfo_ == null ? GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo.getDefaultInstance() : this.raceInfo_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
        public GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfoOrBuilder getRaceInfoOrBuilder() {
            return getRaceInfo();
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
        public boolean hasCampInfo() {
            return this.campInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
        public GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo getCampInfo() {
            return this.campInfo_ == null ? GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo.getDefaultInstance() : this.campInfo_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
        public GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfoOrBuilder getCampInfoOrBuilder() {
            return getCampInfo();
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
        public boolean hasCarveInfo() {
            return this.carveInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
        public GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo getCarveInfo() {
            return this.carveInfo_ == null ? GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo.getDefaultInstance() : this.carveInfo_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
        public GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder getCarveInfoOrBuilder() {
            return getCarveInfo();
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
        public boolean hasPhotoInfo() {
            return this.photoInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
        public GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo getPhotoInfo() {
            return this.photoInfo_ == null ? GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo.getDefaultInstance() : this.photoInfo_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
        public GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder getPhotoInfoOrBuilder() {
            return getPhotoInfo();
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
            if (this.raceInfo_ != null) {
                output.writeMessage(2, getRaceInfo());
            }
            if (this.campInfo_ != null) {
                output.writeMessage(3, getCampInfo());
            }
            if (this.isContentClosed_) {
                output.writeBool(8, this.isContentClosed_);
            }
            if (this.photoInfo_ != null) {
                output.writeMessage(10, getPhotoInfo());
            }
            if (this.carveInfo_ != null) {
                output.writeMessage(13, getCarveInfo());
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
            if (this.raceInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(2, getRaceInfo());
            }
            if (this.campInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(3, getCampInfo());
            }
            if (this.isContentClosed_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isContentClosed_);
            }
            if (this.photoInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(10, getPhotoInfo());
            }
            if (this.carveInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(13, getCarveInfo());
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
            if (!(obj instanceof GravenInnocenceDetailInfo)) {
                return equals(obj);
            }
            GravenInnocenceDetailInfo other = (GravenInnocenceDetailInfo) obj;
            if (getIsContentClosed() != other.getIsContentClosed() || hasRaceInfo() != other.hasRaceInfo()) {
                return false;
            }
            if ((hasRaceInfo() && !getRaceInfo().equals(other.getRaceInfo())) || hasCampInfo() != other.hasCampInfo()) {
                return false;
            }
            if ((hasCampInfo() && !getCampInfo().equals(other.getCampInfo())) || hasCarveInfo() != other.hasCarveInfo()) {
                return false;
            }
            if ((!hasCarveInfo() || getCarveInfo().equals(other.getCarveInfo())) && hasPhotoInfo() == other.hasPhotoInfo()) {
                return (!hasPhotoInfo() || getPhotoInfo().equals(other.getPhotoInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 8)) + Internal.hashBoolean(getIsContentClosed());
            if (hasRaceInfo()) {
                hash = (53 * ((37 * hash) + 2)) + getRaceInfo().hashCode();
            }
            if (hasCampInfo()) {
                hash = (53 * ((37 * hash) + 3)) + getCampInfo().hashCode();
            }
            if (hasCarveInfo()) {
                hash = (53 * ((37 * hash) + 13)) + getCarveInfo().hashCode();
            }
            if (hasPhotoInfo()) {
                hash = (53 * ((37 * hash) + 10)) + getPhotoInfo().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GravenInnocenceDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocenceDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocenceDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocenceDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocenceDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocenceDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocenceDetailInfo parseFrom(InputStream input) throws IOException {
            return (GravenInnocenceDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GravenInnocenceDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocenceDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GravenInnocenceDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GravenInnocenceDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GravenInnocenceDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocenceDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GravenInnocenceDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (GravenInnocenceDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GravenInnocenceDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocenceDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GravenInnocenceDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceDetailInfoOuterClass$GravenInnocenceDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GravenInnocenceDetailInfoOrBuilder {
            private boolean isContentClosed_;
            private GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo raceInfo_;
            private SingleFieldBuilderV3<GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo, GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo.Builder, GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfoOrBuilder> raceInfoBuilder_;
            private GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo campInfo_;
            private SingleFieldBuilderV3<GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo, GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo.Builder, GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfoOrBuilder> campInfoBuilder_;
            private GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo carveInfo_;
            private SingleFieldBuilderV3<GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo, GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo.Builder, GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder> carveInfoBuilder_;
            private GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo photoInfo_;
            private SingleFieldBuilderV3<GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo, GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo.Builder, GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder> photoInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GravenInnocenceDetailInfoOuterClass.internal_static_GravenInnocenceDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GravenInnocenceDetailInfoOuterClass.internal_static_GravenInnocenceDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GravenInnocenceDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GravenInnocenceDetailInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isContentClosed_ = false;
                if (this.raceInfoBuilder_ == null) {
                    this.raceInfo_ = null;
                } else {
                    this.raceInfo_ = null;
                    this.raceInfoBuilder_ = null;
                }
                if (this.campInfoBuilder_ == null) {
                    this.campInfo_ = null;
                } else {
                    this.campInfo_ = null;
                    this.campInfoBuilder_ = null;
                }
                if (this.carveInfoBuilder_ == null) {
                    this.carveInfo_ = null;
                } else {
                    this.carveInfo_ = null;
                    this.carveInfoBuilder_ = null;
                }
                if (this.photoInfoBuilder_ == null) {
                    this.photoInfo_ = null;
                } else {
                    this.photoInfo_ = null;
                    this.photoInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GravenInnocenceDetailInfoOuterClass.internal_static_GravenInnocenceDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GravenInnocenceDetailInfo getDefaultInstanceForType() {
                return GravenInnocenceDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GravenInnocenceDetailInfo build() {
                GravenInnocenceDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GravenInnocenceDetailInfo buildPartial() {
                GravenInnocenceDetailInfo result = new GravenInnocenceDetailInfo(this);
                result.isContentClosed_ = this.isContentClosed_;
                if (this.raceInfoBuilder_ == null) {
                    result.raceInfo_ = this.raceInfo_;
                } else {
                    result.raceInfo_ = this.raceInfoBuilder_.build();
                }
                if (this.campInfoBuilder_ == null) {
                    result.campInfo_ = this.campInfo_;
                } else {
                    result.campInfo_ = this.campInfoBuilder_.build();
                }
                if (this.carveInfoBuilder_ == null) {
                    result.carveInfo_ = this.carveInfo_;
                } else {
                    result.carveInfo_ = this.carveInfoBuilder_.build();
                }
                if (this.photoInfoBuilder_ == null) {
                    result.photoInfo_ = this.photoInfo_;
                } else {
                    result.photoInfo_ = this.photoInfoBuilder_.build();
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
                if (other instanceof GravenInnocenceDetailInfo) {
                    return mergeFrom((GravenInnocenceDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GravenInnocenceDetailInfo other) {
                if (other == GravenInnocenceDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                if (other.hasRaceInfo()) {
                    mergeRaceInfo(other.getRaceInfo());
                }
                if (other.hasCampInfo()) {
                    mergeCampInfo(other.getCampInfo());
                }
                if (other.hasCarveInfo()) {
                    mergeCarveInfo(other.getCarveInfo());
                }
                if (other.hasPhotoInfo()) {
                    mergePhotoInfo(other.getPhotoInfo());
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
                GravenInnocenceDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = GravenInnocenceDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GravenInnocenceDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
            public boolean getIsContentClosed() {
                return this.isContentClosed_;
            }

            public Builder setIsContentClosed(boolean value) {
                this.isContentClosed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsContentClosed() {
                this.isContentClosed_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
            public boolean hasRaceInfo() {
                return (this.raceInfoBuilder_ == null && this.raceInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
            public GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo getRaceInfo() {
                if (this.raceInfoBuilder_ == null) {
                    return this.raceInfo_ == null ? GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo.getDefaultInstance() : this.raceInfo_;
                }
                return this.raceInfoBuilder_.getMessage();
            }

            public Builder setRaceInfo(GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo value) {
                if (this.raceInfoBuilder_ != null) {
                    this.raceInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.raceInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setRaceInfo(GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo.Builder builderForValue) {
                if (this.raceInfoBuilder_ == null) {
                    this.raceInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.raceInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeRaceInfo(GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo value) {
                if (this.raceInfoBuilder_ == null) {
                    if (this.raceInfo_ != null) {
                        this.raceInfo_ = GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo.newBuilder(this.raceInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.raceInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.raceInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearRaceInfo() {
                if (this.raceInfoBuilder_ == null) {
                    this.raceInfo_ = null;
                    onChanged();
                } else {
                    this.raceInfo_ = null;
                    this.raceInfoBuilder_ = null;
                }
                return this;
            }

            public GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo.Builder getRaceInfoBuilder() {
                onChanged();
                return getRaceInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
            public GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfoOrBuilder getRaceInfoOrBuilder() {
                if (this.raceInfoBuilder_ != null) {
                    return this.raceInfoBuilder_.getMessageOrBuilder();
                }
                return this.raceInfo_ == null ? GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo.getDefaultInstance() : this.raceInfo_;
            }

            private SingleFieldBuilderV3<GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo, GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo.Builder, GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfoOrBuilder> getRaceInfoFieldBuilder() {
                if (this.raceInfoBuilder_ == null) {
                    this.raceInfoBuilder_ = new SingleFieldBuilderV3<>(getRaceInfo(), getParentForChildren(), isClean());
                    this.raceInfo_ = null;
                }
                return this.raceInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
            public boolean hasCampInfo() {
                return (this.campInfoBuilder_ == null && this.campInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
            public GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo getCampInfo() {
                if (this.campInfoBuilder_ == null) {
                    return this.campInfo_ == null ? GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo.getDefaultInstance() : this.campInfo_;
                }
                return this.campInfoBuilder_.getMessage();
            }

            public Builder setCampInfo(GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo value) {
                if (this.campInfoBuilder_ != null) {
                    this.campInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.campInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setCampInfo(GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo.Builder builderForValue) {
                if (this.campInfoBuilder_ == null) {
                    this.campInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.campInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeCampInfo(GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo value) {
                if (this.campInfoBuilder_ == null) {
                    if (this.campInfo_ != null) {
                        this.campInfo_ = GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo.newBuilder(this.campInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.campInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.campInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearCampInfo() {
                if (this.campInfoBuilder_ == null) {
                    this.campInfo_ = null;
                    onChanged();
                } else {
                    this.campInfo_ = null;
                    this.campInfoBuilder_ = null;
                }
                return this;
            }

            public GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo.Builder getCampInfoBuilder() {
                onChanged();
                return getCampInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
            public GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfoOrBuilder getCampInfoOrBuilder() {
                if (this.campInfoBuilder_ != null) {
                    return this.campInfoBuilder_.getMessageOrBuilder();
                }
                return this.campInfo_ == null ? GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo.getDefaultInstance() : this.campInfo_;
            }

            private SingleFieldBuilderV3<GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo, GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo.Builder, GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfoOrBuilder> getCampInfoFieldBuilder() {
                if (this.campInfoBuilder_ == null) {
                    this.campInfoBuilder_ = new SingleFieldBuilderV3<>(getCampInfo(), getParentForChildren(), isClean());
                    this.campInfo_ = null;
                }
                return this.campInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
            public boolean hasCarveInfo() {
                return (this.carveInfoBuilder_ == null && this.carveInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
            public GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo getCarveInfo() {
                if (this.carveInfoBuilder_ == null) {
                    return this.carveInfo_ == null ? GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo.getDefaultInstance() : this.carveInfo_;
                }
                return this.carveInfoBuilder_.getMessage();
            }

            public Builder setCarveInfo(GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo value) {
                if (this.carveInfoBuilder_ != null) {
                    this.carveInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.carveInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setCarveInfo(GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo.Builder builderForValue) {
                if (this.carveInfoBuilder_ == null) {
                    this.carveInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.carveInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeCarveInfo(GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo value) {
                if (this.carveInfoBuilder_ == null) {
                    if (this.carveInfo_ != null) {
                        this.carveInfo_ = GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo.newBuilder(this.carveInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.carveInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.carveInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearCarveInfo() {
                if (this.carveInfoBuilder_ == null) {
                    this.carveInfo_ = null;
                    onChanged();
                } else {
                    this.carveInfo_ = null;
                    this.carveInfoBuilder_ = null;
                }
                return this;
            }

            public GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo.Builder getCarveInfoBuilder() {
                onChanged();
                return getCarveInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
            public GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder getCarveInfoOrBuilder() {
                if (this.carveInfoBuilder_ != null) {
                    return this.carveInfoBuilder_.getMessageOrBuilder();
                }
                return this.carveInfo_ == null ? GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo.getDefaultInstance() : this.carveInfo_;
            }

            private SingleFieldBuilderV3<GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo, GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo.Builder, GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder> getCarveInfoFieldBuilder() {
                if (this.carveInfoBuilder_ == null) {
                    this.carveInfoBuilder_ = new SingleFieldBuilderV3<>(getCarveInfo(), getParentForChildren(), isClean());
                    this.carveInfo_ = null;
                }
                return this.carveInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
            public boolean hasPhotoInfo() {
                return (this.photoInfoBuilder_ == null && this.photoInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
            public GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo getPhotoInfo() {
                if (this.photoInfoBuilder_ == null) {
                    return this.photoInfo_ == null ? GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo.getDefaultInstance() : this.photoInfo_;
                }
                return this.photoInfoBuilder_.getMessage();
            }

            public Builder setPhotoInfo(GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo value) {
                if (this.photoInfoBuilder_ != null) {
                    this.photoInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.photoInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setPhotoInfo(GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo.Builder builderForValue) {
                if (this.photoInfoBuilder_ == null) {
                    this.photoInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.photoInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergePhotoInfo(GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo value) {
                if (this.photoInfoBuilder_ == null) {
                    if (this.photoInfo_ != null) {
                        this.photoInfo_ = GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo.newBuilder(this.photoInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.photoInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.photoInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearPhotoInfo() {
                if (this.photoInfoBuilder_ == null) {
                    this.photoInfo_ = null;
                    onChanged();
                } else {
                    this.photoInfo_ = null;
                    this.photoInfoBuilder_ = null;
                }
                return this;
            }

            public GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo.Builder getPhotoInfoBuilder() {
                onChanged();
                return getPhotoInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceDetailInfoOuterClass.GravenInnocenceDetailInfoOrBuilder
            public GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder getPhotoInfoOrBuilder() {
                if (this.photoInfoBuilder_ != null) {
                    return this.photoInfoBuilder_.getMessageOrBuilder();
                }
                return this.photoInfo_ == null ? GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo.getDefaultInstance() : this.photoInfo_;
            }

            private SingleFieldBuilderV3<GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo, GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo.Builder, GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder> getPhotoInfoFieldBuilder() {
                if (this.photoInfoBuilder_ == null) {
                    this.photoInfoBuilder_ = new SingleFieldBuilderV3<>(getPhotoInfo(), getParentForChildren(), isClean());
                    this.photoInfo_ = null;
                }
                return this.photoInfoBuilder_;
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

        public static GravenInnocenceDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GravenInnocenceDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GravenInnocenceDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GravenInnocenceDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        GravenInnocenceCampInfoOuterClass.getDescriptor();
        GravenInnocenceCarveInfoOuterClass.getDescriptor();
        GravenInnocencePhotoInfoOuterClass.getDescriptor();
        GravenInnocenceRaceInfoOuterClass.getDescriptor();
    }
}
