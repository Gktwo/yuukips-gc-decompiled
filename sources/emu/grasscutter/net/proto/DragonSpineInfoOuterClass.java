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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DragonSpineInfoOuterClass.class */
public final class DragonSpineInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015DragonSpineInfo.proto\u001a\u001cDragonSpineChapterInfo.proto\"é\u0001\n\u000fDragonSpineInfo\u0012\u001b\n\u0013Unk3300_PPABOFMIGNM\u0018\u000e \u0001(\r\u0012\u001b\n\u0013Unk3300_IMLKIJAOADF\u0018\u0005 \u0001(\r\u0012\u001b\n\u0013Unk3300_FOHJDGCAKEK\u0018\u0001 \u0001(\r\u0012\u001b\n\u0013Unk3300_NEOCMGJCEOJ\u0018\u0007 \u0001(\r\u0012\u0014\n\fleftMonsters\u0018\u0002 \u0001(\b\u00120\n\u000fchapterInfoList\u0018\t \u0003(\u000b2\u0017.DragonSpineChapterInfo\u0012\u001a\n\u0012weaponEnhanceLevel\u0018\u000f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{DragonSpineChapterInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DragonSpineInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DragonSpineInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DragonSpineInfo_descriptor, new String[]{"Unk3300PPABOFMIGNM", "Unk3300IMLKIJAOADF", "Unk3300FOHJDGCAKEK", "Unk3300NEOCMGJCEOJ", "LeftMonsters", "ChapterInfoList", "WeaponEnhanceLevel"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DragonSpineInfoOuterClass$DragonSpineInfoOrBuilder.class */
    public interface DragonSpineInfoOrBuilder extends MessageOrBuilder {
        int getUnk3300PPABOFMIGNM();

        int getUnk3300IMLKIJAOADF();

        int getUnk3300FOHJDGCAKEK();

        int getUnk3300NEOCMGJCEOJ();

        boolean getLeftMonsters();

        List<DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo> getChapterInfoListList();

        DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo getChapterInfoList(int i);

        int getChapterInfoListCount();

        List<? extends DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder> getChapterInfoListOrBuilderList();

        DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder getChapterInfoListOrBuilder(int i);

        int getWeaponEnhanceLevel();
    }

    private DragonSpineInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DragonSpineInfoOuterClass$DragonSpineInfo.class */
    public static final class DragonSpineInfo extends GeneratedMessageV3 implements DragonSpineInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_PPABOFMIGNM_FIELD_NUMBER = 14;
        private int unk3300PPABOFMIGNM_;
        public static final int UNK3300_IMLKIJAOADF_FIELD_NUMBER = 5;
        private int unk3300IMLKIJAOADF_;
        public static final int UNK3300_FOHJDGCAKEK_FIELD_NUMBER = 1;
        private int unk3300FOHJDGCAKEK_;
        public static final int UNK3300_NEOCMGJCEOJ_FIELD_NUMBER = 7;
        private int unk3300NEOCMGJCEOJ_;
        public static final int LEFTMONSTERS_FIELD_NUMBER = 2;
        private boolean leftMonsters_;
        public static final int CHAPTERINFOLIST_FIELD_NUMBER = 9;
        private List<DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo> chapterInfoList_;
        public static final int WEAPONENHANCELEVEL_FIELD_NUMBER = 15;
        private int weaponEnhanceLevel_;
        private byte memoizedIsInitialized;
        private static final DragonSpineInfo DEFAULT_INSTANCE = new DragonSpineInfo();
        private static final Parser<DragonSpineInfo> PARSER = new AbstractParser<DragonSpineInfo>() { // from class: emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfo.1
            @Override // com.google.protobuf.Parser
            public DragonSpineInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DragonSpineInfo(input, extensionRegistry);
            }
        };

        private DragonSpineInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DragonSpineInfo() {
            this.memoizedIsInitialized = -1;
            this.chapterInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DragonSpineInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DragonSpineInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.unk3300FOHJDGCAKEK_ = input.readUInt32();
                                    break;
                                case 16:
                                    this.leftMonsters_ = input.readBool();
                                    break;
                                case 40:
                                    this.unk3300IMLKIJAOADF_ = input.readUInt32();
                                    break;
                                case 56:
                                    this.unk3300NEOCMGJCEOJ_ = input.readUInt32();
                                    break;
                                case 74:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.chapterInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.chapterInfoList_.add((DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo) input.readMessage(DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo.parser(), extensionRegistry));
                                    break;
                                case 112:
                                    this.unk3300PPABOFMIGNM_ = input.readUInt32();
                                    break;
                                case 120:
                                    this.weaponEnhanceLevel_ = input.readUInt32();
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
            return DragonSpineInfoOuterClass.internal_static_DragonSpineInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DragonSpineInfoOuterClass.internal_static_DragonSpineInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DragonSpineInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
        public int getUnk3300PPABOFMIGNM() {
            return this.unk3300PPABOFMIGNM_;
        }

        @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
        public int getUnk3300IMLKIJAOADF() {
            return this.unk3300IMLKIJAOADF_;
        }

        @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
        public int getUnk3300FOHJDGCAKEK() {
            return this.unk3300FOHJDGCAKEK_;
        }

        @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
        public int getUnk3300NEOCMGJCEOJ() {
            return this.unk3300NEOCMGJCEOJ_;
        }

        @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
        public boolean getLeftMonsters() {
            return this.leftMonsters_;
        }

        @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
        public List<DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo> getChapterInfoListList() {
            return this.chapterInfoList_;
        }

        @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
        public List<? extends DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder> getChapterInfoListOrBuilderList() {
            return this.chapterInfoList_;
        }

        @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
        public int getChapterInfoListCount() {
            return this.chapterInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
        public DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo getChapterInfoList(int index) {
            return this.chapterInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
        public DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder getChapterInfoListOrBuilder(int index) {
            return this.chapterInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
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
                output.writeUInt32(1, this.unk3300FOHJDGCAKEK_);
            }
            if (this.leftMonsters_) {
                output.writeBool(2, this.leftMonsters_);
            }
            if (this.unk3300IMLKIJAOADF_ != 0) {
                output.writeUInt32(5, this.unk3300IMLKIJAOADF_);
            }
            if (this.unk3300NEOCMGJCEOJ_ != 0) {
                output.writeUInt32(7, this.unk3300NEOCMGJCEOJ_);
            }
            for (int i = 0; i < this.chapterInfoList_.size(); i++) {
                output.writeMessage(9, this.chapterInfoList_.get(i));
            }
            if (this.unk3300PPABOFMIGNM_ != 0) {
                output.writeUInt32(14, this.unk3300PPABOFMIGNM_);
            }
            if (this.weaponEnhanceLevel_ != 0) {
                output.writeUInt32(15, this.weaponEnhanceLevel_);
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
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.unk3300FOHJDGCAKEK_);
            }
            if (this.leftMonsters_) {
                size2 += CodedOutputStream.computeBoolSize(2, this.leftMonsters_);
            }
            if (this.unk3300IMLKIJAOADF_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.unk3300IMLKIJAOADF_);
            }
            if (this.unk3300NEOCMGJCEOJ_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(7, this.unk3300NEOCMGJCEOJ_);
            }
            for (int i = 0; i < this.chapterInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.chapterInfoList_.get(i));
            }
            if (this.unk3300PPABOFMIGNM_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.unk3300PPABOFMIGNM_);
            }
            if (this.weaponEnhanceLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.weaponEnhanceLevel_);
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
            if (!(obj instanceof DragonSpineInfo)) {
                return equals(obj);
            }
            DragonSpineInfo other = (DragonSpineInfo) obj;
            return getUnk3300PPABOFMIGNM() == other.getUnk3300PPABOFMIGNM() && getUnk3300IMLKIJAOADF() == other.getUnk3300IMLKIJAOADF() && getUnk3300FOHJDGCAKEK() == other.getUnk3300FOHJDGCAKEK() && getUnk3300NEOCMGJCEOJ() == other.getUnk3300NEOCMGJCEOJ() && getLeftMonsters() == other.getLeftMonsters() && getChapterInfoListList().equals(other.getChapterInfoListList()) && getWeaponEnhanceLevel() == other.getWeaponEnhanceLevel() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + getUnk3300PPABOFMIGNM())) + 5)) + getUnk3300IMLKIJAOADF())) + 1)) + getUnk3300FOHJDGCAKEK())) + 7)) + getUnk3300NEOCMGJCEOJ())) + 2)) + Internal.hashBoolean(getLeftMonsters());
            if (getChapterInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getChapterInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 15)) + getWeaponEnhanceLevel())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DragonSpineInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DragonSpineInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DragonSpineInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DragonSpineInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DragonSpineInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DragonSpineInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DragonSpineInfo parseFrom(InputStream input) throws IOException {
            return (DragonSpineInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DragonSpineInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DragonSpineInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DragonSpineInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (DragonSpineInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DragonSpineInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DragonSpineInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DragonSpineInfo parseFrom(CodedInputStream input) throws IOException {
            return (DragonSpineInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DragonSpineInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DragonSpineInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DragonSpineInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DragonSpineInfoOuterClass$DragonSpineInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DragonSpineInfoOrBuilder {
            private int bitField0_;
            private int unk3300PPABOFMIGNM_;
            private int unk3300IMLKIJAOADF_;
            private int unk3300FOHJDGCAKEK_;
            private int unk3300NEOCMGJCEOJ_;
            private boolean leftMonsters_;
            private List<DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo> chapterInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo, DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo.Builder, DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder> chapterInfoListBuilder_;
            private int weaponEnhanceLevel_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DragonSpineInfoOuterClass.internal_static_DragonSpineInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DragonSpineInfoOuterClass.internal_static_DragonSpineInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(DragonSpineInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DragonSpineInfo.alwaysUseFieldBuilders) {
                    getChapterInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300PPABOFMIGNM_ = 0;
                this.unk3300IMLKIJAOADF_ = 0;
                this.unk3300FOHJDGCAKEK_ = 0;
                this.unk3300NEOCMGJCEOJ_ = 0;
                this.leftMonsters_ = false;
                if (this.chapterInfoListBuilder_ == null) {
                    this.chapterInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.chapterInfoListBuilder_.clear();
                }
                this.weaponEnhanceLevel_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DragonSpineInfoOuterClass.internal_static_DragonSpineInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DragonSpineInfo getDefaultInstanceForType() {
                return DragonSpineInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DragonSpineInfo build() {
                DragonSpineInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DragonSpineInfo buildPartial() {
                DragonSpineInfo result = new DragonSpineInfo(this);
                int i = this.bitField0_;
                result.unk3300PPABOFMIGNM_ = this.unk3300PPABOFMIGNM_;
                result.unk3300IMLKIJAOADF_ = this.unk3300IMLKIJAOADF_;
                result.unk3300FOHJDGCAKEK_ = this.unk3300FOHJDGCAKEK_;
                result.unk3300NEOCMGJCEOJ_ = this.unk3300NEOCMGJCEOJ_;
                result.leftMonsters_ = this.leftMonsters_;
                if (this.chapterInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.chapterInfoList_ = Collections.unmodifiableList(this.chapterInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.chapterInfoList_ = this.chapterInfoList_;
                } else {
                    result.chapterInfoList_ = this.chapterInfoListBuilder_.build();
                }
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
                if (other instanceof DragonSpineInfo) {
                    return mergeFrom((DragonSpineInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DragonSpineInfo other) {
                if (other == DragonSpineInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUnk3300PPABOFMIGNM() != 0) {
                    setUnk3300PPABOFMIGNM(other.getUnk3300PPABOFMIGNM());
                }
                if (other.getUnk3300IMLKIJAOADF() != 0) {
                    setUnk3300IMLKIJAOADF(other.getUnk3300IMLKIJAOADF());
                }
                if (other.getUnk3300FOHJDGCAKEK() != 0) {
                    setUnk3300FOHJDGCAKEK(other.getUnk3300FOHJDGCAKEK());
                }
                if (other.getUnk3300NEOCMGJCEOJ() != 0) {
                    setUnk3300NEOCMGJCEOJ(other.getUnk3300NEOCMGJCEOJ());
                }
                if (other.getLeftMonsters()) {
                    setLeftMonsters(other.getLeftMonsters());
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
                        this.chapterInfoListBuilder_ = DragonSpineInfo.alwaysUseFieldBuilders ? getChapterInfoListFieldBuilder() : null;
                    } else {
                        this.chapterInfoListBuilder_.addAllMessages(other.chapterInfoList_);
                    }
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
                DragonSpineInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = DragonSpineInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DragonSpineInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
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

            private void ensureChapterInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.chapterInfoList_ = new ArrayList(this.chapterInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
            public List<DragonSpineChapterInfoOuterClass.DragonSpineChapterInfo> getChapterInfoListList() {
                if (this.chapterInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.chapterInfoList_);
                }
                return this.chapterInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
            public int getChapterInfoListCount() {
                if (this.chapterInfoListBuilder_ == null) {
                    return this.chapterInfoList_.size();
                }
                return this.chapterInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
            public DragonSpineChapterInfoOuterClass.DragonSpineChapterInfoOrBuilder getChapterInfoListOrBuilder(int index) {
                if (this.chapterInfoListBuilder_ == null) {
                    return this.chapterInfoList_.get(index);
                }
                return this.chapterInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.DragonSpineInfoOuterClass.DragonSpineInfoOrBuilder
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

        public static DragonSpineInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DragonSpineInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DragonSpineInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DragonSpineInfo getDefaultInstanceForType() {
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
