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
import emu.grasscutter.net.proto.SeaLampSectionInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SeaLampActivityInfoOuterClass.class */
public final class SeaLampActivityInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019SeaLampActivityInfo.proto\u001a\u0018SeaLampSectionInfo.proto\"ÿ\u0001\n\u0013SeaLampActivityInfo\u0012\u0014\n\fleftMonsters\u0018\u0001 \u0001(\b\u0012\u001b\n\u0013Unk3300_BAJIGNGJALG\u0018\u0003 \u0001(\b\u0012,\n\u000fsectionInfoList\u0018\u0002 \u0003(\u000b2\u0013.SeaLampSectionInfo\u0012\u0019\n\u0011firstDayStartTime\u0018\n \u0001(\r\u0012\u0012\n\npopularity\u0018\u0005 \u0001(\r\u0012\u001b\n\u0013Unk3300_JMPCJGJHPIH\u0018\u000e \u0001(\b\u0012\u0010\n\bdayIndex\u0018\u0004 \u0001(\r\u0012\u0014\n\fmechanicusId\u0018\f \u0001(\r\u0012\u0013\n\u000bseaLampCoin\u0018\u0006 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SeaLampSectionInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SeaLampActivityInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SeaLampActivityInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SeaLampActivityInfo_descriptor, new String[]{"LeftMonsters", "Unk3300BAJIGNGJALG", "SectionInfoList", "FirstDayStartTime", "Popularity", "Unk3300JMPCJGJHPIH", "DayIndex", "MechanicusId", "SeaLampCoin"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SeaLampActivityInfoOuterClass$SeaLampActivityInfoOrBuilder.class */
    public interface SeaLampActivityInfoOrBuilder extends MessageOrBuilder {
        boolean getLeftMonsters();

        boolean getUnk3300BAJIGNGJALG();

        List<SeaLampSectionInfoOuterClass.SeaLampSectionInfo> getSectionInfoListList();

        SeaLampSectionInfoOuterClass.SeaLampSectionInfo getSectionInfoList(int i);

        int getSectionInfoListCount();

        List<? extends SeaLampSectionInfoOuterClass.SeaLampSectionInfoOrBuilder> getSectionInfoListOrBuilderList();

        SeaLampSectionInfoOuterClass.SeaLampSectionInfoOrBuilder getSectionInfoListOrBuilder(int i);

        int getFirstDayStartTime();

        int getPopularity();

        boolean getUnk3300JMPCJGJHPIH();

        int getDayIndex();

        int getMechanicusId();

        int getSeaLampCoin();
    }

    private SeaLampActivityInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SeaLampActivityInfoOuterClass$SeaLampActivityInfo.class */
    public static final class SeaLampActivityInfo extends GeneratedMessageV3 implements SeaLampActivityInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEFTMONSTERS_FIELD_NUMBER = 1;
        private boolean leftMonsters_;
        public static final int UNK3300_BAJIGNGJALG_FIELD_NUMBER = 3;
        private boolean unk3300BAJIGNGJALG_;
        public static final int SECTIONINFOLIST_FIELD_NUMBER = 2;
        private List<SeaLampSectionInfoOuterClass.SeaLampSectionInfo> sectionInfoList_;
        public static final int FIRSTDAYSTARTTIME_FIELD_NUMBER = 10;
        private int firstDayStartTime_;
        public static final int POPULARITY_FIELD_NUMBER = 5;
        private int popularity_;
        public static final int UNK3300_JMPCJGJHPIH_FIELD_NUMBER = 14;
        private boolean unk3300JMPCJGJHPIH_;
        public static final int DAYINDEX_FIELD_NUMBER = 4;
        private int dayIndex_;
        public static final int MECHANICUSID_FIELD_NUMBER = 12;
        private int mechanicusId_;
        public static final int SEALAMPCOIN_FIELD_NUMBER = 6;
        private int seaLampCoin_;
        private byte memoizedIsInitialized;
        private static final SeaLampActivityInfo DEFAULT_INSTANCE = new SeaLampActivityInfo();
        private static final Parser<SeaLampActivityInfo> PARSER = new AbstractParser<SeaLampActivityInfo>() { // from class: emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfo.1
            @Override // com.google.protobuf.Parser
            public SeaLampActivityInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SeaLampActivityInfo(input, extensionRegistry);
            }
        };

        private SeaLampActivityInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SeaLampActivityInfo() {
            this.memoizedIsInitialized = -1;
            this.sectionInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SeaLampActivityInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SeaLampActivityInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 8:
                                this.leftMonsters_ = input.readBool();
                                break;
                            case 18:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.sectionInfoList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.sectionInfoList_.add((SeaLampSectionInfoOuterClass.SeaLampSectionInfo) input.readMessage(SeaLampSectionInfoOuterClass.SeaLampSectionInfo.parser(), extensionRegistry));
                                break;
                            case 24:
                                this.unk3300BAJIGNGJALG_ = input.readBool();
                                break;
                            case 32:
                                this.dayIndex_ = input.readUInt32();
                                break;
                            case 40:
                                this.popularity_ = input.readUInt32();
                                break;
                            case 48:
                                this.seaLampCoin_ = input.readUInt32();
                                break;
                            case 80:
                                this.firstDayStartTime_ = input.readUInt32();
                                break;
                            case 96:
                                this.mechanicusId_ = input.readUInt32();
                                break;
                            case 112:
                                this.unk3300JMPCJGJHPIH_ = input.readBool();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.sectionInfoList_ = Collections.unmodifiableList(this.sectionInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SeaLampActivityInfoOuterClass.internal_static_SeaLampActivityInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SeaLampActivityInfoOuterClass.internal_static_SeaLampActivityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SeaLampActivityInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
        public boolean getLeftMonsters() {
            return this.leftMonsters_;
        }

        @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
        public boolean getUnk3300BAJIGNGJALG() {
            return this.unk3300BAJIGNGJALG_;
        }

        @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
        public List<SeaLampSectionInfoOuterClass.SeaLampSectionInfo> getSectionInfoListList() {
            return this.sectionInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
        public List<? extends SeaLampSectionInfoOuterClass.SeaLampSectionInfoOrBuilder> getSectionInfoListOrBuilderList() {
            return this.sectionInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
        public int getSectionInfoListCount() {
            return this.sectionInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
        public SeaLampSectionInfoOuterClass.SeaLampSectionInfo getSectionInfoList(int index) {
            return this.sectionInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
        public SeaLampSectionInfoOuterClass.SeaLampSectionInfoOrBuilder getSectionInfoListOrBuilder(int index) {
            return this.sectionInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
        public int getFirstDayStartTime() {
            return this.firstDayStartTime_;
        }

        @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
        public int getPopularity() {
            return this.popularity_;
        }

        @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
        public boolean getUnk3300JMPCJGJHPIH() {
            return this.unk3300JMPCJGJHPIH_;
        }

        @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
        public int getDayIndex() {
            return this.dayIndex_;
        }

        @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
        public int getMechanicusId() {
            return this.mechanicusId_;
        }

        @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
        public int getSeaLampCoin() {
            return this.seaLampCoin_;
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
            if (this.leftMonsters_) {
                output.writeBool(1, this.leftMonsters_);
            }
            for (int i = 0; i < this.sectionInfoList_.size(); i++) {
                output.writeMessage(2, this.sectionInfoList_.get(i));
            }
            if (this.unk3300BAJIGNGJALG_) {
                output.writeBool(3, this.unk3300BAJIGNGJALG_);
            }
            if (this.dayIndex_ != 0) {
                output.writeUInt32(4, this.dayIndex_);
            }
            if (this.popularity_ != 0) {
                output.writeUInt32(5, this.popularity_);
            }
            if (this.seaLampCoin_ != 0) {
                output.writeUInt32(6, this.seaLampCoin_);
            }
            if (this.firstDayStartTime_ != 0) {
                output.writeUInt32(10, this.firstDayStartTime_);
            }
            if (this.mechanicusId_ != 0) {
                output.writeUInt32(12, this.mechanicusId_);
            }
            if (this.unk3300JMPCJGJHPIH_) {
                output.writeBool(14, this.unk3300JMPCJGJHPIH_);
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
            if (this.leftMonsters_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.leftMonsters_);
            }
            for (int i = 0; i < this.sectionInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.sectionInfoList_.get(i));
            }
            if (this.unk3300BAJIGNGJALG_) {
                size2 += CodedOutputStream.computeBoolSize(3, this.unk3300BAJIGNGJALG_);
            }
            if (this.dayIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.dayIndex_);
            }
            if (this.popularity_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.popularity_);
            }
            if (this.seaLampCoin_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.seaLampCoin_);
            }
            if (this.firstDayStartTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.firstDayStartTime_);
            }
            if (this.mechanicusId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.mechanicusId_);
            }
            if (this.unk3300JMPCJGJHPIH_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.unk3300JMPCJGJHPIH_);
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
            if (!(obj instanceof SeaLampActivityInfo)) {
                return equals(obj);
            }
            SeaLampActivityInfo other = (SeaLampActivityInfo) obj;
            return getLeftMonsters() == other.getLeftMonsters() && getUnk3300BAJIGNGJALG() == other.getUnk3300BAJIGNGJALG() && getSectionInfoListList().equals(other.getSectionInfoListList()) && getFirstDayStartTime() == other.getFirstDayStartTime() && getPopularity() == other.getPopularity() && getUnk3300JMPCJGJHPIH() == other.getUnk3300JMPCJGJHPIH() && getDayIndex() == other.getDayIndex() && getMechanicusId() == other.getMechanicusId() && getSeaLampCoin() == other.getSeaLampCoin() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Internal.hashBoolean(getLeftMonsters()))) + 3)) + Internal.hashBoolean(getUnk3300BAJIGNGJALG());
            if (getSectionInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getSectionInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 10)) + getFirstDayStartTime())) + 5)) + getPopularity())) + 14)) + Internal.hashBoolean(getUnk3300JMPCJGJHPIH()))) + 4)) + getDayIndex())) + 12)) + getMechanicusId())) + 6)) + getSeaLampCoin())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SeaLampActivityInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SeaLampActivityInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SeaLampActivityInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SeaLampActivityInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SeaLampActivityInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SeaLampActivityInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SeaLampActivityInfo parseFrom(InputStream input) throws IOException {
            return (SeaLampActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SeaLampActivityInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SeaLampActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SeaLampActivityInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SeaLampActivityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SeaLampActivityInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SeaLampActivityInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SeaLampActivityInfo parseFrom(CodedInputStream input) throws IOException {
            return (SeaLampActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SeaLampActivityInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SeaLampActivityInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SeaLampActivityInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SeaLampActivityInfoOuterClass$SeaLampActivityInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SeaLampActivityInfoOrBuilder {
            private int bitField0_;
            private boolean leftMonsters_;
            private boolean unk3300BAJIGNGJALG_;
            private List<SeaLampSectionInfoOuterClass.SeaLampSectionInfo> sectionInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<SeaLampSectionInfoOuterClass.SeaLampSectionInfo, SeaLampSectionInfoOuterClass.SeaLampSectionInfo.Builder, SeaLampSectionInfoOuterClass.SeaLampSectionInfoOrBuilder> sectionInfoListBuilder_;
            private int firstDayStartTime_;
            private int popularity_;
            private boolean unk3300JMPCJGJHPIH_;
            private int dayIndex_;
            private int mechanicusId_;
            private int seaLampCoin_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SeaLampActivityInfoOuterClass.internal_static_SeaLampActivityInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SeaLampActivityInfoOuterClass.internal_static_SeaLampActivityInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SeaLampActivityInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SeaLampActivityInfo.alwaysUseFieldBuilders) {
                    getSectionInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.leftMonsters_ = false;
                this.unk3300BAJIGNGJALG_ = false;
                if (this.sectionInfoListBuilder_ == null) {
                    this.sectionInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.sectionInfoListBuilder_.clear();
                }
                this.firstDayStartTime_ = 0;
                this.popularity_ = 0;
                this.unk3300JMPCJGJHPIH_ = false;
                this.dayIndex_ = 0;
                this.mechanicusId_ = 0;
                this.seaLampCoin_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SeaLampActivityInfoOuterClass.internal_static_SeaLampActivityInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SeaLampActivityInfo getDefaultInstanceForType() {
                return SeaLampActivityInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SeaLampActivityInfo build() {
                SeaLampActivityInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SeaLampActivityInfo buildPartial() {
                SeaLampActivityInfo result = new SeaLampActivityInfo(this);
                int i = this.bitField0_;
                result.leftMonsters_ = this.leftMonsters_;
                result.unk3300BAJIGNGJALG_ = this.unk3300BAJIGNGJALG_;
                if (this.sectionInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.sectionInfoList_ = Collections.unmodifiableList(this.sectionInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.sectionInfoList_ = this.sectionInfoList_;
                } else {
                    result.sectionInfoList_ = this.sectionInfoListBuilder_.build();
                }
                result.firstDayStartTime_ = this.firstDayStartTime_;
                result.popularity_ = this.popularity_;
                result.unk3300JMPCJGJHPIH_ = this.unk3300JMPCJGJHPIH_;
                result.dayIndex_ = this.dayIndex_;
                result.mechanicusId_ = this.mechanicusId_;
                result.seaLampCoin_ = this.seaLampCoin_;
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
                if (other instanceof SeaLampActivityInfo) {
                    return mergeFrom((SeaLampActivityInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SeaLampActivityInfo other) {
                if (other == SeaLampActivityInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getLeftMonsters()) {
                    setLeftMonsters(other.getLeftMonsters());
                }
                if (other.getUnk3300BAJIGNGJALG()) {
                    setUnk3300BAJIGNGJALG(other.getUnk3300BAJIGNGJALG());
                }
                if (this.sectionInfoListBuilder_ == null) {
                    if (!other.sectionInfoList_.isEmpty()) {
                        if (this.sectionInfoList_.isEmpty()) {
                            this.sectionInfoList_ = other.sectionInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureSectionInfoListIsMutable();
                            this.sectionInfoList_.addAll(other.sectionInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.sectionInfoList_.isEmpty()) {
                    if (this.sectionInfoListBuilder_.isEmpty()) {
                        this.sectionInfoListBuilder_.dispose();
                        this.sectionInfoListBuilder_ = null;
                        this.sectionInfoList_ = other.sectionInfoList_;
                        this.bitField0_ &= -2;
                        this.sectionInfoListBuilder_ = SeaLampActivityInfo.alwaysUseFieldBuilders ? getSectionInfoListFieldBuilder() : null;
                    } else {
                        this.sectionInfoListBuilder_.addAllMessages(other.sectionInfoList_);
                    }
                }
                if (other.getFirstDayStartTime() != 0) {
                    setFirstDayStartTime(other.getFirstDayStartTime());
                }
                if (other.getPopularity() != 0) {
                    setPopularity(other.getPopularity());
                }
                if (other.getUnk3300JMPCJGJHPIH()) {
                    setUnk3300JMPCJGJHPIH(other.getUnk3300JMPCJGJHPIH());
                }
                if (other.getDayIndex() != 0) {
                    setDayIndex(other.getDayIndex());
                }
                if (other.getMechanicusId() != 0) {
                    setMechanicusId(other.getMechanicusId());
                }
                if (other.getSeaLampCoin() != 0) {
                    setSeaLampCoin(other.getSeaLampCoin());
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
                SeaLampActivityInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SeaLampActivityInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SeaLampActivityInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
            public boolean getUnk3300BAJIGNGJALG() {
                return this.unk3300BAJIGNGJALG_;
            }

            public Builder setUnk3300BAJIGNGJALG(boolean value) {
                this.unk3300BAJIGNGJALG_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300BAJIGNGJALG() {
                this.unk3300BAJIGNGJALG_ = false;
                onChanged();
                return this;
            }

            private void ensureSectionInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.sectionInfoList_ = new ArrayList(this.sectionInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
            public List<SeaLampSectionInfoOuterClass.SeaLampSectionInfo> getSectionInfoListList() {
                if (this.sectionInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.sectionInfoList_);
                }
                return this.sectionInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
            public int getSectionInfoListCount() {
                if (this.sectionInfoListBuilder_ == null) {
                    return this.sectionInfoList_.size();
                }
                return this.sectionInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
            public SeaLampSectionInfoOuterClass.SeaLampSectionInfo getSectionInfoList(int index) {
                if (this.sectionInfoListBuilder_ == null) {
                    return this.sectionInfoList_.get(index);
                }
                return this.sectionInfoListBuilder_.getMessage(index);
            }

            public Builder setSectionInfoList(int index, SeaLampSectionInfoOuterClass.SeaLampSectionInfo value) {
                if (this.sectionInfoListBuilder_ != null) {
                    this.sectionInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSectionInfoListIsMutable();
                    this.sectionInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setSectionInfoList(int index, SeaLampSectionInfoOuterClass.SeaLampSectionInfo.Builder builderForValue) {
                if (this.sectionInfoListBuilder_ == null) {
                    ensureSectionInfoListIsMutable();
                    this.sectionInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.sectionInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSectionInfoList(SeaLampSectionInfoOuterClass.SeaLampSectionInfo value) {
                if (this.sectionInfoListBuilder_ != null) {
                    this.sectionInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSectionInfoListIsMutable();
                    this.sectionInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addSectionInfoList(int index, SeaLampSectionInfoOuterClass.SeaLampSectionInfo value) {
                if (this.sectionInfoListBuilder_ != null) {
                    this.sectionInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSectionInfoListIsMutable();
                    this.sectionInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addSectionInfoList(SeaLampSectionInfoOuterClass.SeaLampSectionInfo.Builder builderForValue) {
                if (this.sectionInfoListBuilder_ == null) {
                    ensureSectionInfoListIsMutable();
                    this.sectionInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.sectionInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSectionInfoList(int index, SeaLampSectionInfoOuterClass.SeaLampSectionInfo.Builder builderForValue) {
                if (this.sectionInfoListBuilder_ == null) {
                    ensureSectionInfoListIsMutable();
                    this.sectionInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.sectionInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSectionInfoList(Iterable<? extends SeaLampSectionInfoOuterClass.SeaLampSectionInfo> values) {
                if (this.sectionInfoListBuilder_ == null) {
                    ensureSectionInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.sectionInfoList_);
                    onChanged();
                } else {
                    this.sectionInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSectionInfoList() {
                if (this.sectionInfoListBuilder_ == null) {
                    this.sectionInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.sectionInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeSectionInfoList(int index) {
                if (this.sectionInfoListBuilder_ == null) {
                    ensureSectionInfoListIsMutable();
                    this.sectionInfoList_.remove(index);
                    onChanged();
                } else {
                    this.sectionInfoListBuilder_.remove(index);
                }
                return this;
            }

            public SeaLampSectionInfoOuterClass.SeaLampSectionInfo.Builder getSectionInfoListBuilder(int index) {
                return getSectionInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
            public SeaLampSectionInfoOuterClass.SeaLampSectionInfoOrBuilder getSectionInfoListOrBuilder(int index) {
                if (this.sectionInfoListBuilder_ == null) {
                    return this.sectionInfoList_.get(index);
                }
                return this.sectionInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
            public List<? extends SeaLampSectionInfoOuterClass.SeaLampSectionInfoOrBuilder> getSectionInfoListOrBuilderList() {
                if (this.sectionInfoListBuilder_ != null) {
                    return this.sectionInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.sectionInfoList_);
            }

            public SeaLampSectionInfoOuterClass.SeaLampSectionInfo.Builder addSectionInfoListBuilder() {
                return getSectionInfoListFieldBuilder().addBuilder(SeaLampSectionInfoOuterClass.SeaLampSectionInfo.getDefaultInstance());
            }

            public SeaLampSectionInfoOuterClass.SeaLampSectionInfo.Builder addSectionInfoListBuilder(int index) {
                return getSectionInfoListFieldBuilder().addBuilder(index, SeaLampSectionInfoOuterClass.SeaLampSectionInfo.getDefaultInstance());
            }

            public List<SeaLampSectionInfoOuterClass.SeaLampSectionInfo.Builder> getSectionInfoListBuilderList() {
                return getSectionInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SeaLampSectionInfoOuterClass.SeaLampSectionInfo, SeaLampSectionInfoOuterClass.SeaLampSectionInfo.Builder, SeaLampSectionInfoOuterClass.SeaLampSectionInfoOrBuilder> getSectionInfoListFieldBuilder() {
                if (this.sectionInfoListBuilder_ == null) {
                    this.sectionInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.sectionInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.sectionInfoList_ = null;
                }
                return this.sectionInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
            public int getFirstDayStartTime() {
                return this.firstDayStartTime_;
            }

            public Builder setFirstDayStartTime(int value) {
                this.firstDayStartTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearFirstDayStartTime() {
                this.firstDayStartTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
            public int getPopularity() {
                return this.popularity_;
            }

            public Builder setPopularity(int value) {
                this.popularity_ = value;
                onChanged();
                return this;
            }

            public Builder clearPopularity() {
                this.popularity_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
            public boolean getUnk3300JMPCJGJHPIH() {
                return this.unk3300JMPCJGJHPIH_;
            }

            public Builder setUnk3300JMPCJGJHPIH(boolean value) {
                this.unk3300JMPCJGJHPIH_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300JMPCJGJHPIH() {
                this.unk3300JMPCJGJHPIH_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
            public int getDayIndex() {
                return this.dayIndex_;
            }

            public Builder setDayIndex(int value) {
                this.dayIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearDayIndex() {
                this.dayIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
            public int getMechanicusId() {
                return this.mechanicusId_;
            }

            public Builder setMechanicusId(int value) {
                this.mechanicusId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMechanicusId() {
                this.mechanicusId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SeaLampActivityInfoOuterClass.SeaLampActivityInfoOrBuilder
            public int getSeaLampCoin() {
                return this.seaLampCoin_;
            }

            public Builder setSeaLampCoin(int value) {
                this.seaLampCoin_ = value;
                onChanged();
                return this;
            }

            public Builder clearSeaLampCoin() {
                this.seaLampCoin_ = 0;
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

        public static SeaLampActivityInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SeaLampActivityInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SeaLampActivityInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SeaLampActivityInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SeaLampSectionInfoOuterClass.getDescriptor();
    }
}
