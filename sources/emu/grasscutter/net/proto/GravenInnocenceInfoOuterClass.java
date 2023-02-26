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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceInfoOuterClass.class */
public final class GravenInnocenceInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019GravenInnocenceInfo.proto\u001a\u001eGravenInnocenceCarveInfo.proto\u001a\u001eGravenInnocencePhotoInfo.proto\u001a\u001dGravenInnocenceRaceInfo.proto\u001a\u001dGravenInnocenceCampInfo.proto\"ß\u0001\n\u0013GravenInnocenceInfo\u0012,\n\tcarveInfo\u0018\f \u0001(\u000b2\u0019.GravenInnocenceCarveInfo\u0012,\n\tphotoInfo\u0018\u0005 \u0001(\u000b2\u0019.GravenInnocencePhotoInfo\u0012*\n\braceInfo\u0018\r \u0001(\u000b2\u0018.GravenInnocenceRaceInfo\u0012\u0014\n\fleftMonsters\u0018\b \u0001(\b\u0012*\n\bcampInfo\u0018\u000b \u0001(\u000b2\u0018.GravenInnocenceCampInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{GravenInnocenceCarveInfoOuterClass.getDescriptor(), GravenInnocencePhotoInfoOuterClass.getDescriptor(), GravenInnocenceRaceInfoOuterClass.getDescriptor(), GravenInnocenceCampInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GravenInnocenceInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GravenInnocenceInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GravenInnocenceInfo_descriptor, new String[]{"CarveInfo", "PhotoInfo", "RaceInfo", "LeftMonsters", "CampInfo"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceInfoOuterClass$GravenInnocenceInfoOrBuilder.class */
    public interface GravenInnocenceInfoOrBuilder extends MessageOrBuilder {
        boolean hasCarveInfo();

        GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo getCarveInfo();

        GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder getCarveInfoOrBuilder();

        boolean hasPhotoInfo();

        GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo getPhotoInfo();

        GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder getPhotoInfoOrBuilder();

        boolean hasRaceInfo();

        GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo getRaceInfo();

        GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfoOrBuilder getRaceInfoOrBuilder();

        boolean getLeftMonsters();

        boolean hasCampInfo();

        GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo getCampInfo();

        GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfoOrBuilder getCampInfoOrBuilder();
    }

    private GravenInnocenceInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceInfoOuterClass$GravenInnocenceInfo.class */
    public static final class GravenInnocenceInfo extends GeneratedMessageV3 implements GravenInnocenceInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CARVEINFO_FIELD_NUMBER = 12;
        private GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo carveInfo_;
        public static final int PHOTOINFO_FIELD_NUMBER = 5;
        private GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo photoInfo_;
        public static final int RACEINFO_FIELD_NUMBER = 13;
        private GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo raceInfo_;
        public static final int LEFTMONSTERS_FIELD_NUMBER = 8;
        private boolean leftMonsters_;
        public static final int CAMPINFO_FIELD_NUMBER = 11;
        private GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo campInfo_;
        private byte memoizedIsInitialized;
        private static final GravenInnocenceInfo DEFAULT_INSTANCE = new GravenInnocenceInfo();
        private static final Parser<GravenInnocenceInfo> PARSER = new AbstractParser<GravenInnocenceInfo>() { // from class: emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfo.1
            @Override // com.google.protobuf.Parser
            public GravenInnocenceInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GravenInnocenceInfo(input, extensionRegistry);
            }
        };

        private GravenInnocenceInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GravenInnocenceInfo() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GravenInnocenceInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GravenInnocenceInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 42:
                                GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo.Builder subBuilder = this.photoInfo_ != null ? this.photoInfo_.toBuilder() : null;
                                this.photoInfo_ = (GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo) input.readMessage(GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.photoInfo_);
                                    this.photoInfo_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 64:
                                this.leftMonsters_ = input.readBool();
                                break;
                            case 90:
                                GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo.Builder subBuilder2 = this.campInfo_ != null ? this.campInfo_.toBuilder() : null;
                                this.campInfo_ = (GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo) input.readMessage(GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo.parser(), extensionRegistry);
                                if (subBuilder2 == null) {
                                    break;
                                } else {
                                    subBuilder2.mergeFrom(this.campInfo_);
                                    this.campInfo_ = subBuilder2.buildPartial();
                                    break;
                                }
                            case 98:
                                GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo.Builder subBuilder3 = this.carveInfo_ != null ? this.carveInfo_.toBuilder() : null;
                                this.carveInfo_ = (GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo) input.readMessage(GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo.parser(), extensionRegistry);
                                if (subBuilder3 == null) {
                                    break;
                                } else {
                                    subBuilder3.mergeFrom(this.carveInfo_);
                                    this.carveInfo_ = subBuilder3.buildPartial();
                                    break;
                                }
                            case 106:
                                GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo.Builder subBuilder4 = this.raceInfo_ != null ? this.raceInfo_.toBuilder() : null;
                                this.raceInfo_ = (GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo) input.readMessage(GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo.parser(), extensionRegistry);
                                if (subBuilder4 == null) {
                                    break;
                                } else {
                                    subBuilder4.mergeFrom(this.raceInfo_);
                                    this.raceInfo_ = subBuilder4.buildPartial();
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
            return GravenInnocenceInfoOuterClass.internal_static_GravenInnocenceInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GravenInnocenceInfoOuterClass.internal_static_GravenInnocenceInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GravenInnocenceInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
        public boolean hasCarveInfo() {
            return this.carveInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
        public GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo getCarveInfo() {
            return this.carveInfo_ == null ? GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo.getDefaultInstance() : this.carveInfo_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
        public GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder getCarveInfoOrBuilder() {
            return getCarveInfo();
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
        public boolean hasPhotoInfo() {
            return this.photoInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
        public GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo getPhotoInfo() {
            return this.photoInfo_ == null ? GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo.getDefaultInstance() : this.photoInfo_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
        public GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder getPhotoInfoOrBuilder() {
            return getPhotoInfo();
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
        public boolean hasRaceInfo() {
            return this.raceInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
        public GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo getRaceInfo() {
            return this.raceInfo_ == null ? GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo.getDefaultInstance() : this.raceInfo_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
        public GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfoOrBuilder getRaceInfoOrBuilder() {
            return getRaceInfo();
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
        public boolean getLeftMonsters() {
            return this.leftMonsters_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
        public boolean hasCampInfo() {
            return this.campInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
        public GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo getCampInfo() {
            return this.campInfo_ == null ? GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo.getDefaultInstance() : this.campInfo_;
        }

        @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
        public GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfoOrBuilder getCampInfoOrBuilder() {
            return getCampInfo();
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
            if (this.photoInfo_ != null) {
                output.writeMessage(5, getPhotoInfo());
            }
            if (this.leftMonsters_) {
                output.writeBool(8, this.leftMonsters_);
            }
            if (this.campInfo_ != null) {
                output.writeMessage(11, getCampInfo());
            }
            if (this.carveInfo_ != null) {
                output.writeMessage(12, getCarveInfo());
            }
            if (this.raceInfo_ != null) {
                output.writeMessage(13, getRaceInfo());
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
            if (this.photoInfo_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(5, getPhotoInfo());
            }
            if (this.leftMonsters_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.leftMonsters_);
            }
            if (this.campInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getCampInfo());
            }
            if (this.carveInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(12, getCarveInfo());
            }
            if (this.raceInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(13, getRaceInfo());
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
            if (!(obj instanceof GravenInnocenceInfo)) {
                return equals(obj);
            }
            GravenInnocenceInfo other = (GravenInnocenceInfo) obj;
            if (hasCarveInfo() != other.hasCarveInfo()) {
                return false;
            }
            if ((hasCarveInfo() && !getCarveInfo().equals(other.getCarveInfo())) || hasPhotoInfo() != other.hasPhotoInfo()) {
                return false;
            }
            if ((hasPhotoInfo() && !getPhotoInfo().equals(other.getPhotoInfo())) || hasRaceInfo() != other.hasRaceInfo()) {
                return false;
            }
            if ((!hasRaceInfo() || getRaceInfo().equals(other.getRaceInfo())) && getLeftMonsters() == other.getLeftMonsters() && hasCampInfo() == other.hasCampInfo()) {
                return (!hasCampInfo() || getCampInfo().equals(other.getCampInfo())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasCarveInfo()) {
                hash = (53 * ((37 * hash) + 12)) + getCarveInfo().hashCode();
            }
            if (hasPhotoInfo()) {
                hash = (53 * ((37 * hash) + 5)) + getPhotoInfo().hashCode();
            }
            if (hasRaceInfo()) {
                hash = (53 * ((37 * hash) + 13)) + getRaceInfo().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 8)) + Internal.hashBoolean(getLeftMonsters());
            if (hasCampInfo()) {
                hash2 = (53 * ((37 * hash2) + 11)) + getCampInfo().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static GravenInnocenceInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocenceInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocenceInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocenceInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocenceInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GravenInnocenceInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GravenInnocenceInfo parseFrom(InputStream input) throws IOException {
            return (GravenInnocenceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GravenInnocenceInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocenceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GravenInnocenceInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (GravenInnocenceInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GravenInnocenceInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocenceInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GravenInnocenceInfo parseFrom(CodedInputStream input) throws IOException {
            return (GravenInnocenceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GravenInnocenceInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GravenInnocenceInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GravenInnocenceInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GravenInnocenceInfoOuterClass$GravenInnocenceInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GravenInnocenceInfoOrBuilder {
            private GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo carveInfo_;
            private SingleFieldBuilderV3<GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo, GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfo.Builder, GravenInnocenceCarveInfoOuterClass.GravenInnocenceCarveInfoOrBuilder> carveInfoBuilder_;
            private GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo photoInfo_;
            private SingleFieldBuilderV3<GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo, GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfo.Builder, GravenInnocencePhotoInfoOuterClass.GravenInnocencePhotoInfoOrBuilder> photoInfoBuilder_;
            private GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo raceInfo_;
            private SingleFieldBuilderV3<GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo, GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfo.Builder, GravenInnocenceRaceInfoOuterClass.GravenInnocenceRaceInfoOrBuilder> raceInfoBuilder_;
            private boolean leftMonsters_;
            private GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo campInfo_;
            private SingleFieldBuilderV3<GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo, GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfo.Builder, GravenInnocenceCampInfoOuterClass.GravenInnocenceCampInfoOrBuilder> campInfoBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GravenInnocenceInfoOuterClass.internal_static_GravenInnocenceInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GravenInnocenceInfoOuterClass.internal_static_GravenInnocenceInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(GravenInnocenceInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GravenInnocenceInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
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
                if (this.raceInfoBuilder_ == null) {
                    this.raceInfo_ = null;
                } else {
                    this.raceInfo_ = null;
                    this.raceInfoBuilder_ = null;
                }
                this.leftMonsters_ = false;
                if (this.campInfoBuilder_ == null) {
                    this.campInfo_ = null;
                } else {
                    this.campInfo_ = null;
                    this.campInfoBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GravenInnocenceInfoOuterClass.internal_static_GravenInnocenceInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GravenInnocenceInfo getDefaultInstanceForType() {
                return GravenInnocenceInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GravenInnocenceInfo build() {
                GravenInnocenceInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GravenInnocenceInfo buildPartial() {
                GravenInnocenceInfo result = new GravenInnocenceInfo(this);
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
                if (this.raceInfoBuilder_ == null) {
                    result.raceInfo_ = this.raceInfo_;
                } else {
                    result.raceInfo_ = this.raceInfoBuilder_.build();
                }
                result.leftMonsters_ = this.leftMonsters_;
                if (this.campInfoBuilder_ == null) {
                    result.campInfo_ = this.campInfo_;
                } else {
                    result.campInfo_ = this.campInfoBuilder_.build();
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
                if (other instanceof GravenInnocenceInfo) {
                    return mergeFrom((GravenInnocenceInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GravenInnocenceInfo other) {
                if (other == GravenInnocenceInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasCarveInfo()) {
                    mergeCarveInfo(other.getCarveInfo());
                }
                if (other.hasPhotoInfo()) {
                    mergePhotoInfo(other.getPhotoInfo());
                }
                if (other.hasRaceInfo()) {
                    mergeRaceInfo(other.getRaceInfo());
                }
                if (other.getLeftMonsters()) {
                    setLeftMonsters(other.getLeftMonsters());
                }
                if (other.hasCampInfo()) {
                    mergeCampInfo(other.getCampInfo());
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
                GravenInnocenceInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = GravenInnocenceInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GravenInnocenceInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
            public boolean hasCarveInfo() {
                return (this.carveInfoBuilder_ == null && this.carveInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
            public boolean hasPhotoInfo() {
                return (this.photoInfoBuilder_ == null && this.photoInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
            public boolean hasRaceInfo() {
                return (this.raceInfoBuilder_ == null && this.raceInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
            public boolean getLeftMonsters() {
                return this.leftMonsters_;
            }

            public Builder setLeftMonsters(boolean value) {
                this.leftMonsters_ = value;
                onChanged();
                return this;
            }

            public Builder clearLeftMonsters() {
                this.leftMonsters_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
            public boolean hasCampInfo() {
                return (this.campInfoBuilder_ == null && this.campInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.GravenInnocenceInfoOuterClass.GravenInnocenceInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static GravenInnocenceInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GravenInnocenceInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GravenInnocenceInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GravenInnocenceInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        GravenInnocenceCarveInfoOuterClass.getDescriptor();
        GravenInnocencePhotoInfoOuterClass.getDescriptor();
        GravenInnocenceRaceInfoOuterClass.getDescriptor();
        GravenInnocenceCampInfoOuterClass.getDescriptor();
    }
}
