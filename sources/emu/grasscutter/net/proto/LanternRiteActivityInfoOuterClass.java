package emu.grasscutter.net.proto;

import com.google.protobuf.AbstractMessageLite;
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
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.LanternProjectionInfoOuterClass;
import emu.grasscutter.net.proto.LanternRiteFireworksInfoOuterClass;
import emu.grasscutter.net.proto.SalvageStageInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternRiteActivityInfoOuterClass.class */
public final class LanternRiteActivityInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dLanternRiteActivityInfo.proto\u001a\u001eLanternRiteFireworksInfo.proto\u001a\u001bLanternProjectionInfo.proto\u001a\u0016SalvageStageInfo.proto\"õ\u0001\n\u0017LanternRiteActivityInfo\u00120\n\rfireworksInfo\u0018\u0006 \u0001(\u000b2\u0019.LanternRiteFireworksInfo\u0012.\n\u000eprojectionInfo\u0018\u000b \u0001(\u000b2\u0016.LanternProjectionInfo\u0012\u0014\n\fleftMonsters\u0018\t \u0001(\b\u0012\u001b\n\u0013Unk3300_PDFJNCDGKGH\u0018\u0003 \u0001(\b\u0012(\n\rstageInfoList\u0018\u0001 \u0003(\u000b2\u0011.SalvageStageInfo\u0012\u001b\n\u0013Unk3300_DKBJLCIMBAL\u0018\u0007 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{LanternRiteFireworksInfoOuterClass.getDescriptor(), LanternProjectionInfoOuterClass.getDescriptor(), SalvageStageInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_LanternRiteActivityInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_LanternRiteActivityInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_LanternRiteActivityInfo_descriptor, new String[]{"FireworksInfo", "ProjectionInfo", "LeftMonsters", "Unk3300PDFJNCDGKGH", "StageInfoList", "Unk3300DKBJLCIMBAL"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternRiteActivityInfoOuterClass$LanternRiteActivityInfoOrBuilder.class */
    public interface LanternRiteActivityInfoOrBuilder extends MessageOrBuilder {
        boolean hasFireworksInfo();

        LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo getFireworksInfo();

        LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfoOrBuilder getFireworksInfoOrBuilder();

        boolean hasProjectionInfo();

        LanternProjectionInfoOuterClass.LanternProjectionInfo getProjectionInfo();

        LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder getProjectionInfoOrBuilder();

        boolean getLeftMonsters();

        boolean getUnk3300PDFJNCDGKGH();

        List<SalvageStageInfoOuterClass.SalvageStageInfo> getStageInfoListList();

        SalvageStageInfoOuterClass.SalvageStageInfo getStageInfoList(int i);

        int getStageInfoListCount();

        List<? extends SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder> getStageInfoListOrBuilderList();

        SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder getStageInfoListOrBuilder(int i);

        boolean getUnk3300DKBJLCIMBAL();
    }

    private LanternRiteActivityInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternRiteActivityInfoOuterClass$LanternRiteActivityInfo.class */
    public static final class LanternRiteActivityInfo extends GeneratedMessageV3 implements LanternRiteActivityInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int FIREWORKSINFO_FIELD_NUMBER = 6;
        private LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo fireworksInfo_;
        public static final int PROJECTIONINFO_FIELD_NUMBER = 11;
        private LanternProjectionInfoOuterClass.LanternProjectionInfo projectionInfo_;
        public static final int LEFTMONSTERS_FIELD_NUMBER = 9;
        private boolean leftMonsters_;
        public static final int UNK3300_PDFJNCDGKGH_FIELD_NUMBER = 3;
        private boolean unk3300PDFJNCDGKGH_;
        public static final int STAGEINFOLIST_FIELD_NUMBER = 1;
        private List<SalvageStageInfoOuterClass.SalvageStageInfo> stageInfoList_;
        public static final int UNK3300_DKBJLCIMBAL_FIELD_NUMBER = 7;
        private boolean unk3300DKBJLCIMBAL_;
        private byte memoizedIsInitialized;
        private static final LanternRiteActivityInfo DEFAULT_INSTANCE = new LanternRiteActivityInfo();
        private static final Parser<LanternRiteActivityInfo> PARSER = new AbstractParser<LanternRiteActivityInfo>() { // from class: emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfo.1
            @Override // com.google.protobuf.Parser
            public LanternRiteActivityInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LanternRiteActivityInfo(input, extensionRegistry);
            }
        };

        private LanternRiteActivityInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private LanternRiteActivityInfo() {
            this.memoizedIsInitialized = -1;
            this.stageInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new LanternRiteActivityInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private LanternRiteActivityInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            int mutable_bitField0_;
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
                mutable_bitField0_ = 0;
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
                                case 10:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.stageInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.stageInfoList_.add((SalvageStageInfoOuterClass.SalvageStageInfo) input.readMessage(SalvageStageInfoOuterClass.SalvageStageInfo.parser(), extensionRegistry));
                                    break;
                                case 24:
                                    this.unk3300PDFJNCDGKGH_ = input.readBool();
                                    break;
                                case 50:
                                    LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.Builder subBuilder = this.fireworksInfo_ != null ? this.fireworksInfo_.toBuilder() : null;
                                    this.fireworksInfo_ = (LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo) input.readMessage(LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.fireworksInfo_);
                                        this.fireworksInfo_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 56:
                                    this.unk3300DKBJLCIMBAL_ = input.readBool();
                                    break;
                                case 72:
                                    this.leftMonsters_ = input.readBool();
                                    break;
                                case 90:
                                    LanternProjectionInfoOuterClass.LanternProjectionInfo.Builder subBuilder2 = this.projectionInfo_ != null ? this.projectionInfo_.toBuilder() : null;
                                    this.projectionInfo_ = (LanternProjectionInfoOuterClass.LanternProjectionInfo) input.readMessage(LanternProjectionInfoOuterClass.LanternProjectionInfo.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.projectionInfo_);
                                        this.projectionInfo_ = subBuilder2.buildPartial();
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.stageInfoList_ = Collections.unmodifiableList(this.stageInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LanternRiteActivityInfoOuterClass.internal_static_LanternRiteActivityInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LanternRiteActivityInfoOuterClass.internal_static_LanternRiteActivityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LanternRiteActivityInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
        public boolean hasFireworksInfo() {
            return this.fireworksInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
        public LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo getFireworksInfo() {
            return this.fireworksInfo_ == null ? LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.getDefaultInstance() : this.fireworksInfo_;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
        public LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfoOrBuilder getFireworksInfoOrBuilder() {
            return getFireworksInfo();
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
        public boolean hasProjectionInfo() {
            return this.projectionInfo_ != null;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
        public LanternProjectionInfoOuterClass.LanternProjectionInfo getProjectionInfo() {
            return this.projectionInfo_ == null ? LanternProjectionInfoOuterClass.LanternProjectionInfo.getDefaultInstance() : this.projectionInfo_;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
        public LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder getProjectionInfoOrBuilder() {
            return getProjectionInfo();
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
        public boolean getLeftMonsters() {
            return this.leftMonsters_;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
        public boolean getUnk3300PDFJNCDGKGH() {
            return this.unk3300PDFJNCDGKGH_;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
        public List<SalvageStageInfoOuterClass.SalvageStageInfo> getStageInfoListList() {
            return this.stageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
        public List<? extends SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder> getStageInfoListOrBuilderList() {
            return this.stageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
        public int getStageInfoListCount() {
            return this.stageInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
        public SalvageStageInfoOuterClass.SalvageStageInfo getStageInfoList(int index) {
            return this.stageInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
        public SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder getStageInfoListOrBuilder(int index) {
            return this.stageInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
        public boolean getUnk3300DKBJLCIMBAL() {
            return this.unk3300DKBJLCIMBAL_;
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
            for (int i = 0; i < this.stageInfoList_.size(); i++) {
                output.writeMessage(1, this.stageInfoList_.get(i));
            }
            if (this.unk3300PDFJNCDGKGH_) {
                output.writeBool(3, this.unk3300PDFJNCDGKGH_);
            }
            if (this.fireworksInfo_ != null) {
                output.writeMessage(6, getFireworksInfo());
            }
            if (this.unk3300DKBJLCIMBAL_) {
                output.writeBool(7, this.unk3300DKBJLCIMBAL_);
            }
            if (this.leftMonsters_) {
                output.writeBool(9, this.leftMonsters_);
            }
            if (this.projectionInfo_ != null) {
                output.writeMessage(11, getProjectionInfo());
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
            for (int i = 0; i < this.stageInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.stageInfoList_.get(i));
            }
            if (this.unk3300PDFJNCDGKGH_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.unk3300PDFJNCDGKGH_);
            }
            if (this.fireworksInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(6, getFireworksInfo());
            }
            if (this.unk3300DKBJLCIMBAL_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.unk3300DKBJLCIMBAL_);
            }
            if (this.leftMonsters_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.leftMonsters_);
            }
            if (this.projectionInfo_ != null) {
                size2 += CodedOutputStream.computeMessageSize(11, getProjectionInfo());
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
            if (!(obj instanceof LanternRiteActivityInfo)) {
                return equals(obj);
            }
            LanternRiteActivityInfo other = (LanternRiteActivityInfo) obj;
            if (hasFireworksInfo() != other.hasFireworksInfo()) {
                return false;
            }
            if ((!hasFireworksInfo() || getFireworksInfo().equals(other.getFireworksInfo())) && hasProjectionInfo() == other.hasProjectionInfo()) {
                return (!hasProjectionInfo() || getProjectionInfo().equals(other.getProjectionInfo())) && getLeftMonsters() == other.getLeftMonsters() && getUnk3300PDFJNCDGKGH() == other.getUnk3300PDFJNCDGKGH() && getStageInfoListList().equals(other.getStageInfoListList()) && getUnk3300DKBJLCIMBAL() == other.getUnk3300DKBJLCIMBAL() && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasFireworksInfo()) {
                hash = (53 * ((37 * hash) + 6)) + getFireworksInfo().hashCode();
            }
            if (hasProjectionInfo()) {
                hash = (53 * ((37 * hash) + 11)) + getProjectionInfo().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 9)) + Internal.hashBoolean(getLeftMonsters()))) + 3)) + Internal.hashBoolean(getUnk3300PDFJNCDGKGH());
            if (getStageInfoListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 1)) + getStageInfoListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 7)) + Internal.hashBoolean(getUnk3300DKBJLCIMBAL()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static LanternRiteActivityInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LanternRiteActivityInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LanternRiteActivityInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LanternRiteActivityInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LanternRiteActivityInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LanternRiteActivityInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LanternRiteActivityInfo parseFrom(InputStream input) throws IOException {
            return (LanternRiteActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LanternRiteActivityInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LanternRiteActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static LanternRiteActivityInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (LanternRiteActivityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static LanternRiteActivityInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LanternRiteActivityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static LanternRiteActivityInfo parseFrom(CodedInputStream input) throws IOException {
            return (LanternRiteActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LanternRiteActivityInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LanternRiteActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LanternRiteActivityInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternRiteActivityInfoOuterClass$LanternRiteActivityInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LanternRiteActivityInfoOrBuilder {
            private int bitField0_;
            private LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo fireworksInfo_;
            private SingleFieldBuilderV3<LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo, LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.Builder, LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfoOrBuilder> fireworksInfoBuilder_;
            private LanternProjectionInfoOuterClass.LanternProjectionInfo projectionInfo_;
            private SingleFieldBuilderV3<LanternProjectionInfoOuterClass.LanternProjectionInfo, LanternProjectionInfoOuterClass.LanternProjectionInfo.Builder, LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder> projectionInfoBuilder_;
            private boolean leftMonsters_;
            private boolean unk3300PDFJNCDGKGH_;
            private List<SalvageStageInfoOuterClass.SalvageStageInfo> stageInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<SalvageStageInfoOuterClass.SalvageStageInfo, SalvageStageInfoOuterClass.SalvageStageInfo.Builder, SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder> stageInfoListBuilder_;
            private boolean unk3300DKBJLCIMBAL_;

            public static final Descriptors.Descriptor getDescriptor() {
                return LanternRiteActivityInfoOuterClass.internal_static_LanternRiteActivityInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LanternRiteActivityInfoOuterClass.internal_static_LanternRiteActivityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LanternRiteActivityInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LanternRiteActivityInfo.alwaysUseFieldBuilders) {
                    getStageInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.fireworksInfoBuilder_ == null) {
                    this.fireworksInfo_ = null;
                } else {
                    this.fireworksInfo_ = null;
                    this.fireworksInfoBuilder_ = null;
                }
                if (this.projectionInfoBuilder_ == null) {
                    this.projectionInfo_ = null;
                } else {
                    this.projectionInfo_ = null;
                    this.projectionInfoBuilder_ = null;
                }
                this.leftMonsters_ = false;
                this.unk3300PDFJNCDGKGH_ = false;
                if (this.stageInfoListBuilder_ == null) {
                    this.stageInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.stageInfoListBuilder_.clear();
                }
                this.unk3300DKBJLCIMBAL_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LanternRiteActivityInfoOuterClass.internal_static_LanternRiteActivityInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LanternRiteActivityInfo getDefaultInstanceForType() {
                return LanternRiteActivityInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LanternRiteActivityInfo build() {
                LanternRiteActivityInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LanternRiteActivityInfo buildPartial() {
                LanternRiteActivityInfo result = new LanternRiteActivityInfo(this);
                int i = this.bitField0_;
                if (this.fireworksInfoBuilder_ == null) {
                    result.fireworksInfo_ = this.fireworksInfo_;
                } else {
                    result.fireworksInfo_ = this.fireworksInfoBuilder_.build();
                }
                if (this.projectionInfoBuilder_ == null) {
                    result.projectionInfo_ = this.projectionInfo_;
                } else {
                    result.projectionInfo_ = this.projectionInfoBuilder_.build();
                }
                result.leftMonsters_ = this.leftMonsters_;
                result.unk3300PDFJNCDGKGH_ = this.unk3300PDFJNCDGKGH_;
                if (this.stageInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.stageInfoList_ = Collections.unmodifiableList(this.stageInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.stageInfoList_ = this.stageInfoList_;
                } else {
                    result.stageInfoList_ = this.stageInfoListBuilder_.build();
                }
                result.unk3300DKBJLCIMBAL_ = this.unk3300DKBJLCIMBAL_;
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
                if (other instanceof LanternRiteActivityInfo) {
                    return mergeFrom((LanternRiteActivityInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LanternRiteActivityInfo other) {
                if (other == LanternRiteActivityInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasFireworksInfo()) {
                    mergeFireworksInfo(other.getFireworksInfo());
                }
                if (other.hasProjectionInfo()) {
                    mergeProjectionInfo(other.getProjectionInfo());
                }
                if (other.getLeftMonsters()) {
                    setLeftMonsters(other.getLeftMonsters());
                }
                if (other.getUnk3300PDFJNCDGKGH()) {
                    setUnk3300PDFJNCDGKGH(other.getUnk3300PDFJNCDGKGH());
                }
                if (this.stageInfoListBuilder_ == null) {
                    if (!other.stageInfoList_.isEmpty()) {
                        if (this.stageInfoList_.isEmpty()) {
                            this.stageInfoList_ = other.stageInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureStageInfoListIsMutable();
                            this.stageInfoList_.addAll(other.stageInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.stageInfoList_.isEmpty()) {
                    if (this.stageInfoListBuilder_.isEmpty()) {
                        this.stageInfoListBuilder_.dispose();
                        this.stageInfoListBuilder_ = null;
                        this.stageInfoList_ = other.stageInfoList_;
                        this.bitField0_ &= -2;
                        this.stageInfoListBuilder_ = LanternRiteActivityInfo.alwaysUseFieldBuilders ? getStageInfoListFieldBuilder() : null;
                    } else {
                        this.stageInfoListBuilder_.addAllMessages(other.stageInfoList_);
                    }
                }
                if (other.getUnk3300DKBJLCIMBAL()) {
                    setUnk3300DKBJLCIMBAL(other.getUnk3300DKBJLCIMBAL());
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
                LanternRiteActivityInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = LanternRiteActivityInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (LanternRiteActivityInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
            public boolean hasFireworksInfo() {
                return (this.fireworksInfoBuilder_ == null && this.fireworksInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
            public LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo getFireworksInfo() {
                if (this.fireworksInfoBuilder_ == null) {
                    return this.fireworksInfo_ == null ? LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.getDefaultInstance() : this.fireworksInfo_;
                }
                return this.fireworksInfoBuilder_.getMessage();
            }

            public Builder setFireworksInfo(LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo value) {
                if (this.fireworksInfoBuilder_ != null) {
                    this.fireworksInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.fireworksInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setFireworksInfo(LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.Builder builderForValue) {
                if (this.fireworksInfoBuilder_ == null) {
                    this.fireworksInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.fireworksInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeFireworksInfo(LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo value) {
                if (this.fireworksInfoBuilder_ == null) {
                    if (this.fireworksInfo_ != null) {
                        this.fireworksInfo_ = LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.newBuilder(this.fireworksInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.fireworksInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.fireworksInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearFireworksInfo() {
                if (this.fireworksInfoBuilder_ == null) {
                    this.fireworksInfo_ = null;
                    onChanged();
                } else {
                    this.fireworksInfo_ = null;
                    this.fireworksInfoBuilder_ = null;
                }
                return this;
            }

            public LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.Builder getFireworksInfoBuilder() {
                onChanged();
                return getFireworksInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
            public LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfoOrBuilder getFireworksInfoOrBuilder() {
                if (this.fireworksInfoBuilder_ != null) {
                    return this.fireworksInfoBuilder_.getMessageOrBuilder();
                }
                return this.fireworksInfo_ == null ? LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.getDefaultInstance() : this.fireworksInfo_;
            }

            private SingleFieldBuilderV3<LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo, LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfo.Builder, LanternRiteFireworksInfoOuterClass.LanternRiteFireworksInfoOrBuilder> getFireworksInfoFieldBuilder() {
                if (this.fireworksInfoBuilder_ == null) {
                    this.fireworksInfoBuilder_ = new SingleFieldBuilderV3<>(getFireworksInfo(), getParentForChildren(), isClean());
                    this.fireworksInfo_ = null;
                }
                return this.fireworksInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
            public boolean hasProjectionInfo() {
                return (this.projectionInfoBuilder_ == null && this.projectionInfo_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
            public LanternProjectionInfoOuterClass.LanternProjectionInfo getProjectionInfo() {
                if (this.projectionInfoBuilder_ == null) {
                    return this.projectionInfo_ == null ? LanternProjectionInfoOuterClass.LanternProjectionInfo.getDefaultInstance() : this.projectionInfo_;
                }
                return this.projectionInfoBuilder_.getMessage();
            }

            public Builder setProjectionInfo(LanternProjectionInfoOuterClass.LanternProjectionInfo value) {
                if (this.projectionInfoBuilder_ != null) {
                    this.projectionInfoBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.projectionInfo_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setProjectionInfo(LanternProjectionInfoOuterClass.LanternProjectionInfo.Builder builderForValue) {
                if (this.projectionInfoBuilder_ == null) {
                    this.projectionInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.projectionInfoBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeProjectionInfo(LanternProjectionInfoOuterClass.LanternProjectionInfo value) {
                if (this.projectionInfoBuilder_ == null) {
                    if (this.projectionInfo_ != null) {
                        this.projectionInfo_ = LanternProjectionInfoOuterClass.LanternProjectionInfo.newBuilder(this.projectionInfo_).mergeFrom(value).buildPartial();
                    } else {
                        this.projectionInfo_ = value;
                    }
                    onChanged();
                } else {
                    this.projectionInfoBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearProjectionInfo() {
                if (this.projectionInfoBuilder_ == null) {
                    this.projectionInfo_ = null;
                    onChanged();
                } else {
                    this.projectionInfo_ = null;
                    this.projectionInfoBuilder_ = null;
                }
                return this;
            }

            public LanternProjectionInfoOuterClass.LanternProjectionInfo.Builder getProjectionInfoBuilder() {
                onChanged();
                return getProjectionInfoFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
            public LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder getProjectionInfoOrBuilder() {
                if (this.projectionInfoBuilder_ != null) {
                    return this.projectionInfoBuilder_.getMessageOrBuilder();
                }
                return this.projectionInfo_ == null ? LanternProjectionInfoOuterClass.LanternProjectionInfo.getDefaultInstance() : this.projectionInfo_;
            }

            private SingleFieldBuilderV3<LanternProjectionInfoOuterClass.LanternProjectionInfo, LanternProjectionInfoOuterClass.LanternProjectionInfo.Builder, LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder> getProjectionInfoFieldBuilder() {
                if (this.projectionInfoBuilder_ == null) {
                    this.projectionInfoBuilder_ = new SingleFieldBuilderV3<>(getProjectionInfo(), getParentForChildren(), isClean());
                    this.projectionInfo_ = null;
                }
                return this.projectionInfoBuilder_;
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
            public boolean getUnk3300PDFJNCDGKGH() {
                return this.unk3300PDFJNCDGKGH_;
            }

            public Builder setUnk3300PDFJNCDGKGH(boolean value) {
                this.unk3300PDFJNCDGKGH_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300PDFJNCDGKGH() {
                this.unk3300PDFJNCDGKGH_ = false;
                onChanged();
                return this;
            }

            private void ensureStageInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.stageInfoList_ = new ArrayList(this.stageInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
            public List<SalvageStageInfoOuterClass.SalvageStageInfo> getStageInfoListList() {
                if (this.stageInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.stageInfoList_);
                }
                return this.stageInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
            public int getStageInfoListCount() {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.size();
                }
                return this.stageInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
            public SalvageStageInfoOuterClass.SalvageStageInfo getStageInfoList(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.get(index);
                }
                return this.stageInfoListBuilder_.getMessage(index);
            }

            public Builder setStageInfoList(int index, SalvageStageInfoOuterClass.SalvageStageInfo value) {
                if (this.stageInfoListBuilder_ != null) {
                    this.stageInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setStageInfoList(int index, SalvageStageInfoOuterClass.SalvageStageInfo.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addStageInfoList(SalvageStageInfoOuterClass.SalvageStageInfo value) {
                if (this.stageInfoListBuilder_ != null) {
                    this.stageInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageInfoList(int index, SalvageStageInfoOuterClass.SalvageStageInfo value) {
                if (this.stageInfoListBuilder_ != null) {
                    this.stageInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageInfoList(SalvageStageInfoOuterClass.SalvageStageInfo.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addStageInfoList(int index, SalvageStageInfoOuterClass.SalvageStageInfo.Builder builderForValue) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllStageInfoList(Iterable<? extends SalvageStageInfoOuterClass.SalvageStageInfo> values) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.stageInfoList_);
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearStageInfoList() {
                if (this.stageInfoListBuilder_ == null) {
                    this.stageInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeStageInfoList(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    ensureStageInfoListIsMutable();
                    this.stageInfoList_.remove(index);
                    onChanged();
                } else {
                    this.stageInfoListBuilder_.remove(index);
                }
                return this;
            }

            public SalvageStageInfoOuterClass.SalvageStageInfo.Builder getStageInfoListBuilder(int index) {
                return getStageInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
            public SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder getStageInfoListOrBuilder(int index) {
                if (this.stageInfoListBuilder_ == null) {
                    return this.stageInfoList_.get(index);
                }
                return this.stageInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
            public List<? extends SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder> getStageInfoListOrBuilderList() {
                if (this.stageInfoListBuilder_ != null) {
                    return this.stageInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.stageInfoList_);
            }

            public SalvageStageInfoOuterClass.SalvageStageInfo.Builder addStageInfoListBuilder() {
                return getStageInfoListFieldBuilder().addBuilder(SalvageStageInfoOuterClass.SalvageStageInfo.getDefaultInstance());
            }

            public SalvageStageInfoOuterClass.SalvageStageInfo.Builder addStageInfoListBuilder(int index) {
                return getStageInfoListFieldBuilder().addBuilder(index, SalvageStageInfoOuterClass.SalvageStageInfo.getDefaultInstance());
            }

            public List<SalvageStageInfoOuterClass.SalvageStageInfo.Builder> getStageInfoListBuilderList() {
                return getStageInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SalvageStageInfoOuterClass.SalvageStageInfo, SalvageStageInfoOuterClass.SalvageStageInfo.Builder, SalvageStageInfoOuterClass.SalvageStageInfoOrBuilder> getStageInfoListFieldBuilder() {
                if (this.stageInfoListBuilder_ == null) {
                    this.stageInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.stageInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.stageInfoList_ = null;
                }
                return this.stageInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.LanternRiteActivityInfoOuterClass.LanternRiteActivityInfoOrBuilder
            public boolean getUnk3300DKBJLCIMBAL() {
                return this.unk3300DKBJLCIMBAL_;
            }

            public Builder setUnk3300DKBJLCIMBAL(boolean value) {
                this.unk3300DKBJLCIMBAL_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300DKBJLCIMBAL() {
                this.unk3300DKBJLCIMBAL_ = false;
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

        public static LanternRiteActivityInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LanternRiteActivityInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LanternRiteActivityInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LanternRiteActivityInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        LanternRiteFireworksInfoOuterClass.getDescriptor();
        LanternProjectionInfoOuterClass.getDescriptor();
        SalvageStageInfoOuterClass.getDescriptor();
    }
}
