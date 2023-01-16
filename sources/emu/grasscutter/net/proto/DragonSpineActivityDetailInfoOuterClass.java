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
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.DragonSpineChapterInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DragonSpineActivityDetailInfoOuterClass.class */
public final class DragonSpineActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#DragonSpineActivityDetailInfo.proto\u001a\u001cDragonSpineChapterInfo.proto\"\u0002\n\u001dDragonSpineActivityDetailInfo\u0012\u0019\n\u0011is_content_closed\u0018\t \u0001(\b\u0012\u001b\n\u0013Unk3300_FOHJDGCAKEK\u0018\u0003 \u0001(\r\u0012\u001b\n\u0013Unk3300_PPABOFMIGNM\u0018\n \u0001(\r\u00122\n\u0011chapter_info_list\u0018\u0007 \u0003(\u000b2\u0017.DragonSpineChapterInfo\u0012\u001b\n\u0013Unk3300_NEOCMGJCEOJ\u0018\u0004 \u0001(\r\u0012\u001b\n\u0013Unk3300_IMLKIJAOADF\u0018\f \u0001(\r\u0012\u001c\n\u0014weapon_enhance_level\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{DragonSpineChapterInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DragonSpineActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DragonSpineActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DragonSpineActivityDetailInfo_descriptor, new String[]{"IsContentClosed", "Unk3300FOHJDGCAKEK", "Unk3300PPABOFMIGNM", "ChapterInfoList", "Unk3300NEOCMGJCEOJ", "Unk3300IMLKIJAOADF", "WeaponEnhanceLevel"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DragonSpineActivityDetailInfoOuterClass$DragonSpineActivityDetailInfoOrBuilder.class */
    public interface DragonSpineActivityDetailInfoOrBuilder extends MessageOrBuilder {
        boolean getIsContentClosed();

        int getUnk3300FOHJDGCAKEK();

        int getUnk3300PPABOFMIGNM();

        List<DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo> getChapterInfoListList();

        DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo getChapterInfoList(int i);

        int getChapterInfoListCount();

        List<? extends DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder> getChapterInfoListOrBuilderList();

        DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder getChapterInfoListOrBuilder(int i);

        int getUnk3300NEOCMGJCEOJ();

        int getUnk3300IMLKIJAOADF();

        int getWeaponEnhanceLevel();
    }

    private DragonSpineActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DragonSpineActivityDetailInfoOuterClass$DragonSpineActivityDetailInfo.class */
    public static final class DragonSpineActivityDetailInfo extends GeneratedMessageV3 implements DragonSpineActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 9;
        private boolean isContentClosed_;
        public static final int UNK3300_FOHJDGCAKEK_FIELD_NUMBER = 3;
        private int unk3300FOHJDGCAKEK_;
        public static final int UNK3300_PPABOFMIGNM_FIELD_NUMBER = 10;
        private int unk3300PPABOFMIGNM_;
        public static final int CHAPTER_INFO_LIST_FIELD_NUMBER = 7;
        private List<DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo> chapterInfoList_;
        public static final int UNK3300_NEOCMGJCEOJ_FIELD_NUMBER = 4;
        private int unk3300NEOCMGJCEOJ_;
        public static final int UNK3300_IMLKIJAOADF_FIELD_NUMBER = 12;
        private int unk3300IMLKIJAOADF_;
        public static final int WEAPON_ENHANCE_LEVEL_FIELD_NUMBER = 8;
        private int weaponEnhanceLevel_;
        private byte memoizedIsInitialized;
        private static final DragonSpineActivityDetailInfo DEFAULT_INSTANCE = new DragonSpineActivityDetailInfo();
        private static final Parser<DragonSpineActivityDetailInfo> PARSER = new AbstractParser<DragonSpineActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public DragonSpineActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DragonSpineActivityDetailInfo(input, extensionRegistry);
            }
        };

        private DragonSpineActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DragonSpineActivityDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.chapterInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DragonSpineActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DragonSpineActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.unk3300FOHJDGCAKEK_ = input.readUInt32();
                                    break;
                                case 32:
                                    this.unk3300NEOCMGJCEOJ_ = input.readUInt32();
                                    break;
                                case 58:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.chapterInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.chapterInfoList_.add((DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo) input.readMessage(DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo.parser(), extensionRegistry));
                                    break;
                                case 64:
                                    this.weaponEnhanceLevel_ = input.readUInt32();
                                    break;
                                case 72:
                                    this.isContentClosed_ = input.readBool();
                                    break;
                                case 80:
                                    this.unk3300PPABOFMIGNM_ = input.readUInt32();
                                    break;
                                case 96:
                                    this.unk3300IMLKIJAOADF_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.chapterInfoList_ = Collections.unmodifiableList(this.chapterInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DragonSpineActivityDetailInfoOuterClass.internal_static_DragonSpineActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DragonSpineActivityDetailInfoOuterClass.internal_static_DragonSpineActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DragonSpineActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
        public int getUnk3300FOHJDGCAKEK() {
            return this.unk3300FOHJDGCAKEK_;
        }

        @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
        public int getUnk3300PPABOFMIGNM() {
            return this.unk3300PPABOFMIGNM_;
        }

        @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
        public List<DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo> getChapterInfoListList() {
            return this.chapterInfoList_;
        }

        @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
        public List<? extends DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder> getChapterInfoListOrBuilderList() {
            return this.chapterInfoList_;
        }

        @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
        public int getChapterInfoListCount() {
            return this.chapterInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
        public DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo getChapterInfoList(int index) {
            return this.chapterInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
        public DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder getChapterInfoListOrBuilder(int index) {
            return this.chapterInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
        public int getUnk3300NEOCMGJCEOJ() {
            return this.unk3300NEOCMGJCEOJ_;
        }

        @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
        public int getUnk3300IMLKIJAOADF() {
            return this.unk3300IMLKIJAOADF_;
        }

        @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
        public int getWeaponEnhanceLevel() {
            return this.weaponEnhanceLevel_;
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
            if (this.unk3300FOHJDGCAKEK_ != 0) {
                output.writeUInt32(3, this.unk3300FOHJDGCAKEK_);
            }
            if (this.unk3300NEOCMGJCEOJ_ != 0) {
                output.writeUInt32(4, this.unk3300NEOCMGJCEOJ_);
            }
            for (int i = 0; i < this.chapterInfoList_.size(); i++) {
                output.writeMessage(7, this.chapterInfoList_.get(i));
            }
            if (this.weaponEnhanceLevel_ != 0) {
                output.writeUInt32(8, this.weaponEnhanceLevel_);
            }
            if (this.isContentClosed_) {
                output.writeBool(9, this.isContentClosed_);
            }
            if (this.unk3300PPABOFMIGNM_ != 0) {
                output.writeUInt32(10, this.unk3300PPABOFMIGNM_);
            }
            if (this.unk3300IMLKIJAOADF_ != 0) {
                output.writeUInt32(12, this.unk3300IMLKIJAOADF_);
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
            if (this.unk3300FOHJDGCAKEK_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.unk3300FOHJDGCAKEK_);
            }
            if (this.unk3300NEOCMGJCEOJ_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.unk3300NEOCMGJCEOJ_);
            }
            for (int i = 0; i < this.chapterInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.chapterInfoList_.get(i));
            }
            if (this.weaponEnhanceLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.weaponEnhanceLevel_);
            }
            if (this.isContentClosed_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.isContentClosed_);
            }
            if (this.unk3300PPABOFMIGNM_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.unk3300PPABOFMIGNM_);
            }
            if (this.unk3300IMLKIJAOADF_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.unk3300IMLKIJAOADF_);
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
            if (!(obj instanceof DragonSpineActivityDetailInfo)) {
                return equals(obj);
            }
            DragonSpineActivityDetailInfo other = (DragonSpineActivityDetailInfo) obj;
            return getIsContentClosed() == other.getIsContentClosed() && getUnk3300FOHJDGCAKEK() == other.getUnk3300FOHJDGCAKEK() && getUnk3300PPABOFMIGNM() == other.getUnk3300PPABOFMIGNM() && getChapterInfoListList().equals(other.getChapterInfoListList()) && getUnk3300NEOCMGJCEOJ() == other.getUnk3300NEOCMGJCEOJ() && getUnk3300IMLKIJAOADF() == other.getUnk3300IMLKIJAOADF() && getWeaponEnhanceLevel() == other.getWeaponEnhanceLevel() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 9)) + Internal.hashBoolean(getIsContentClosed()))) + 3)) + getUnk3300FOHJDGCAKEK())) + 10)) + getUnk3300PPABOFMIGNM();
            if (getChapterInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getChapterInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 4)) + getUnk3300NEOCMGJCEOJ())) + 12)) + getUnk3300IMLKIJAOADF())) + 8)) + getWeaponEnhanceLevel())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DragonSpineActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DragonSpineActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DragonSpineActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DragonSpineActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DragonSpineActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DragonSpineActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DragonSpineActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (DragonSpineActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DragonSpineActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DragonSpineActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DragonSpineActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (DragonSpineActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DragonSpineActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DragonSpineActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DragonSpineActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (DragonSpineActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DragonSpineActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DragonSpineActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DragonSpineActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DragonSpineActivityDetailInfoOuterClass$DragonSpineActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DragonSpineActivityDetailInfoOrBuilder {
            private int bitField0_;
            private boolean isContentClosed_;
            private int unk3300FOHJDGCAKEK_;
            private int unk3300PPABOFMIGNM_;
            private List<DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo> chapterInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo, DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo.Builder, DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder> chapterInfoListBuilder_;
            private int unk3300NEOCMGJCEOJ_;
            private int unk3300IMLKIJAOADF_;
            private int weaponEnhanceLevel_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DragonSpineActivityDetailInfoOuterClass.internal_static_DragonSpineActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DragonSpineActivityDetailInfoOuterClass.internal_static_DragonSpineActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DragonSpineActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DragonSpineActivityDetailInfo.alwaysUseFieldBuilders) {
                    getChapterInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isContentClosed_ = false;
                this.unk3300FOHJDGCAKEK_ = 0;
                this.unk3300PPABOFMIGNM_ = 0;
                if (this.chapterInfoListBuilder_ == null) {
                    this.chapterInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.chapterInfoListBuilder_.clear();
                }
                this.unk3300NEOCMGJCEOJ_ = 0;
                this.unk3300IMLKIJAOADF_ = 0;
                this.weaponEnhanceLevel_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DragonSpineActivityDetailInfoOuterClass.internal_static_DragonSpineActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DragonSpineActivityDetailInfo getDefaultInstanceForType() {
                return DragonSpineActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DragonSpineActivityDetailInfo build() {
                DragonSpineActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DragonSpineActivityDetailInfo buildPartial() {
                DragonSpineActivityDetailInfo result = new DragonSpineActivityDetailInfo(this);
                int i = this.bitField0_;
                result.isContentClosed_ = this.isContentClosed_;
                result.unk3300FOHJDGCAKEK_ = this.unk3300FOHJDGCAKEK_;
                result.unk3300PPABOFMIGNM_ = this.unk3300PPABOFMIGNM_;
                if (this.chapterInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.chapterInfoList_ = Collections.unmodifiableList(this.chapterInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.chapterInfoList_ = this.chapterInfoList_;
                } else {
                    result.chapterInfoList_ = this.chapterInfoListBuilder_.build();
                }
                result.unk3300NEOCMGJCEOJ_ = this.unk3300NEOCMGJCEOJ_;
                result.unk3300IMLKIJAOADF_ = this.unk3300IMLKIJAOADF_;
                result.weaponEnhanceLevel_ = this.weaponEnhanceLevel_;
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
                if (other instanceof DragonSpineActivityDetailInfo) {
                    return mergeFrom((DragonSpineActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DragonSpineActivityDetailInfo other) {
                if (other == DragonSpineActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                if (other.getUnk3300FOHJDGCAKEK() != 0) {
                    setUnk3300FOHJDGCAKEK(other.getUnk3300FOHJDGCAKEK());
                }
                if (other.getUnk3300PPABOFMIGNM() != 0) {
                    setUnk3300PPABOFMIGNM(other.getUnk3300PPABOFMIGNM());
                }
                if (this.chapterInfoListBuilder_ == null) {
                    if (!other.chapterInfoList_.isEmpty()) {
                        if (this.chapterInfoList_.isEmpty()) {
                            this.chapterInfoList_ = other.chapterInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureChapterInfoListIsMutable();
                            this.chapterInfoList_.addAll(other.chapterInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.chapterInfoList_.isEmpty()) {
                    if (this.chapterInfoListBuilder_.isEmpty()) {
                        this.chapterInfoListBuilder_.dispose();
                        this.chapterInfoListBuilder_ = null;
                        this.chapterInfoList_ = other.chapterInfoList_;
                        this.bitField0_ &= -2;
                        this.chapterInfoListBuilder_ = DragonSpineActivityDetailInfo.alwaysUseFieldBuilders ? getChapterInfoListFieldBuilder() : null;
                    } else {
                        this.chapterInfoListBuilder_.addAllMessages(other.chapterInfoList_);
                    }
                }
                if (other.getUnk3300NEOCMGJCEOJ() != 0) {
                    setUnk3300NEOCMGJCEOJ(other.getUnk3300NEOCMGJCEOJ());
                }
                if (other.getUnk3300IMLKIJAOADF() != 0) {
                    setUnk3300IMLKIJAOADF(other.getUnk3300IMLKIJAOADF());
                }
                if (other.getWeaponEnhanceLevel() != 0) {
                    setWeaponEnhanceLevel(other.getWeaponEnhanceLevel());
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
                DragonSpineActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = DragonSpineActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DragonSpineActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
            public int getUnk3300FOHJDGCAKEK() {
                return this.unk3300FOHJDGCAKEK_;
            }

            public Builder setUnk3300FOHJDGCAKEK(int value) {
                this.unk3300FOHJDGCAKEK_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300FOHJDGCAKEK() {
                this.unk3300FOHJDGCAKEK_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
            public int getUnk3300PPABOFMIGNM() {
                return this.unk3300PPABOFMIGNM_;
            }

            public Builder setUnk3300PPABOFMIGNM(int value) {
                this.unk3300PPABOFMIGNM_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300PPABOFMIGNM() {
                this.unk3300PPABOFMIGNM_ = 0;
                onChanged();
                return this;
            }

            private void ensureChapterInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.chapterInfoList_ = new ArrayList(this.chapterInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
            public List<DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo> getChapterInfoListList() {
                if (this.chapterInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.chapterInfoList_);
                }
                return this.chapterInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
            public int getChapterInfoListCount() {
                if (this.chapterInfoListBuilder_ == null) {
                    return this.chapterInfoList_.size();
                }
                return this.chapterInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
            public DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo getChapterInfoList(int index) {
                if (this.chapterInfoListBuilder_ == null) {
                    return this.chapterInfoList_.get(index);
                }
                return this.chapterInfoListBuilder_.getMessage(index);
            }

            public Builder setChapterInfoList(int index, DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo value) {
                if (this.chapterInfoListBuilder_ != null) {
                    this.chapterInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setChapterInfoList(int index, DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo.Builder builderForValue) {
                if (this.chapterInfoListBuilder_ == null) {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.chapterInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addChapterInfoList(DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo value) {
                if (this.chapterInfoListBuilder_ != null) {
                    this.chapterInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addChapterInfoList(int index, DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo value) {
                if (this.chapterInfoListBuilder_ != null) {
                    this.chapterInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addChapterInfoList(DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo.Builder builderForValue) {
                if (this.chapterInfoListBuilder_ == null) {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.chapterInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addChapterInfoList(int index, DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo.Builder builderForValue) {
                if (this.chapterInfoListBuilder_ == null) {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.chapterInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllChapterInfoList(Iterable<? extends DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo> values) {
                if (this.chapterInfoListBuilder_ == null) {
                    ensureChapterInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.chapterInfoList_);
                    onChanged();
                } else {
                    this.chapterInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearChapterInfoList() {
                if (this.chapterInfoListBuilder_ == null) {
                    this.chapterInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.chapterInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeChapterInfoList(int index) {
                if (this.chapterInfoListBuilder_ == null) {
                    ensureChapterInfoListIsMutable();
                    this.chapterInfoList_.remove(index);
                    onChanged();
                } else {
                    this.chapterInfoListBuilder_.remove(index);
                }
                return this;
            }

            public DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo.Builder getChapterInfoListBuilder(int index) {
                return getChapterInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
            public DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder getChapterInfoListOrBuilder(int index) {
                if (this.chapterInfoListBuilder_ == null) {
                    return this.chapterInfoList_.get(index);
                }
                return this.chapterInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
            public List<? extends DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder> getChapterInfoListOrBuilderList() {
                if (this.chapterInfoListBuilder_ != null) {
                    return this.chapterInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.chapterInfoList_);
            }

            public DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo.Builder addChapterInfoListBuilder() {
                return getChapterInfoListFieldBuilder().addBuilder(DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo.getDefaultInstance());
            }

            public DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo.Builder addChapterInfoListBuilder(int index) {
                return getChapterInfoListFieldBuilder().addBuilder(index, DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo.getDefaultInstance());
            }

            public List<DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo.Builder> getChapterInfoListBuilderList() {
                return getChapterInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo, DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo.Builder, DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder> getChapterInfoListFieldBuilder() {
                if (this.chapterInfoListBuilder_ == null) {
                    this.chapterInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.chapterInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.chapterInfoList_ = null;
                }
                return this.chapterInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
            public int getUnk3300NEOCMGJCEOJ() {
                return this.unk3300NEOCMGJCEOJ_;
            }

            public Builder setUnk3300NEOCMGJCEOJ(int value) {
                this.unk3300NEOCMGJCEOJ_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300NEOCMGJCEOJ() {
                this.unk3300NEOCMGJCEOJ_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
            public int getUnk3300IMLKIJAOADF() {
                return this.unk3300IMLKIJAOADF_;
            }

            public Builder setUnk3300IMLKIJAOADF(int value) {
                this.unk3300IMLKIJAOADF_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300IMLKIJAOADF() {
                this.unk3300IMLKIJAOADF_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.DragonSpineActivityDetailInfoOuterClass.DragonSpineActivityDetailInfoOrBuilder
            public int getWeaponEnhanceLevel() {
                return this.weaponEnhanceLevel_;
            }

            public Builder setWeaponEnhanceLevel(int value) {
                this.weaponEnhanceLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearWeaponEnhanceLevel() {
                this.weaponEnhanceLevel_ = 0;
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

        public static DragonSpineActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DragonSpineActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DragonSpineActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DragonSpineActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DragonSpineChapterInfoOuterClass.getDescriptor();
    }
}
