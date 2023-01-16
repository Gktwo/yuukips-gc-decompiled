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
import emu.grasscutter.net.proto.RogueStageInfoOuterClass;
import emu.grasscutter.net.proto.RoguelikeShikigamiRecordOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeDungeonActivityDetailInfoOuterClass.class */
public final class RoguelikeDungeonActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n(RoguelikeDungeonActivityDetailInfo.proto\u001a\u0014RogueStageInfo.proto\u001a\u001eRoguelikeShikigamiRecord.proto\"â\u0001\n\"RoguelikeDungeonActivityDetailInfo\u0012#\n\nstage_list\u0018\u000e \u0003(\u000b2\u000f.RogueStageInfo\u0012\u001a\n\u0012equipped_rune_list\u0018\t \u0003(\r\u0012\u001a\n\u0012content_close_time\u0018\u000b \u0001(\r\u0012\u0011\n\trune_list\u0018\u0003 \u0003(\r\u00121\n\u000eshikigami_list\u0018\u0004 \u0003(\u000b2\u0019.RoguelikeShikigamiRecord\u0012\u0019\n\u0011is_content_closed\u0018\u0005 \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{RogueStageInfoOuterClass.getDescriptor(), RoguelikeShikigamiRecordOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_RoguelikeDungeonActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_RoguelikeDungeonActivityDetailInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f847xfe34a146 = new GeneratedMessageV3.FieldAccessorTable(internal_static_RoguelikeDungeonActivityDetailInfo_descriptor, new String[]{"StageList", "EquippedRuneList", "ContentCloseTime", "RuneList", "ShikigamiList", "IsContentClosed"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeDungeonActivityDetailInfoOuterClass$RoguelikeDungeonActivityDetailInfoOrBuilder.class */
    public interface RoguelikeDungeonActivityDetailInfoOrBuilder extends MessageOrBuilder {
        List<RogueStageInfoOuterClass.RogueStageInfo> getStageListList();

        RogueStageInfoOuterClass.RogueStageInfo getStageList(int i);

        int getStageListCount();

        List<? extends RogueStageInfoOuterClass.RogueStageInfoOrBuilder> getStageListOrBuilderList();

        RogueStageInfoOuterClass.RogueStageInfoOrBuilder getStageListOrBuilder(int i);

        List<Integer> getEquippedRuneListList();

        int getEquippedRuneListCount();

        int getEquippedRuneList(int i);

        int getContentCloseTime();

        List<Integer> getRuneListList();

        int getRuneListCount();

        int getRuneList(int i);

        List<RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord> getShikigamiListList();

        RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord getShikigamiList(int i);

        int getShikigamiListCount();

        List<? extends RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecordOrBuilder> getShikigamiListOrBuilderList();

        RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecordOrBuilder getShikigamiListOrBuilder(int i);

        boolean getIsContentClosed();
    }

    private RoguelikeDungeonActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeDungeonActivityDetailInfoOuterClass$RoguelikeDungeonActivityDetailInfo.class */
    public static final class RoguelikeDungeonActivityDetailInfo extends GeneratedMessageV3 implements RoguelikeDungeonActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGE_LIST_FIELD_NUMBER = 14;
        private List<RogueStageInfoOuterClass.RogueStageInfo> stageList_;
        public static final int EQUIPPED_RUNE_LIST_FIELD_NUMBER = 9;
        private Internal.IntList equippedRuneList_;
        private int equippedRuneListMemoizedSerializedSize;
        public static final int CONTENT_CLOSE_TIME_FIELD_NUMBER = 11;
        private int contentCloseTime_;
        public static final int RUNE_LIST_FIELD_NUMBER = 3;
        private Internal.IntList runeList_;
        private int runeListMemoizedSerializedSize;
        public static final int SHIKIGAMI_LIST_FIELD_NUMBER = 4;
        private List<RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord> shikigamiList_;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 5;
        private boolean isContentClosed_;
        private byte memoizedIsInitialized;
        private static final RoguelikeDungeonActivityDetailInfo DEFAULT_INSTANCE = new RoguelikeDungeonActivityDetailInfo();
        private static final Parser<RoguelikeDungeonActivityDetailInfo> PARSER = new AbstractParser<RoguelikeDungeonActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public RoguelikeDungeonActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RoguelikeDungeonActivityDetailInfo(input, extensionRegistry);
            }
        };

        private RoguelikeDungeonActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.equippedRuneListMemoizedSerializedSize = -1;
            this.runeListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private RoguelikeDungeonActivityDetailInfo() {
            this.equippedRuneListMemoizedSerializedSize = -1;
            this.runeListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.stageList_ = Collections.emptyList();
            this.equippedRuneList_ = emptyIntList();
            this.runeList_ = emptyIntList();
            this.shikigamiList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RoguelikeDungeonActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:104:0x01ce */
        private RoguelikeDungeonActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.runeList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.runeList_.addInt(input.readUInt32());
                                break;
                            case 26:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.runeList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.runeList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 34:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.shikigamiList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.shikigamiList_.add((RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord) input.readMessage(RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord.parser(), extensionRegistry));
                                break;
                            case 40:
                                this.isContentClosed_ = input.readBool();
                                break;
                            case 72:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.equippedRuneList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.equippedRuneList_.addInt(input.readUInt32());
                                break;
                            case 74:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.equippedRuneList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.equippedRuneList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 88:
                                this.contentCloseTime_ = input.readUInt32();
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.stageList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.stageList_.add((RogueStageInfoOuterClass.RogueStageInfo) input.readMessage(RogueStageInfoOuterClass.RogueStageInfo.parser(), extensionRegistry));
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 4) != 0) {
                    this.runeList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.shikigamiList_ = Collections.unmodifiableList(this.shikigamiList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.equippedRuneList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.stageList_ = Collections.unmodifiableList(this.stageList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RoguelikeDungeonActivityDetailInfoOuterClass.internal_static_RoguelikeDungeonActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RoguelikeDungeonActivityDetailInfoOuterClass.f847xfe34a146.ensureFieldAccessorsInitialized(RoguelikeDungeonActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
        public List<RogueStageInfoOuterClass.RogueStageInfo> getStageListList() {
            return this.stageList_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
        public List<? extends RogueStageInfoOuterClass.RogueStageInfoOrBuilder> getStageListOrBuilderList() {
            return this.stageList_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
        public int getStageListCount() {
            return this.stageList_.size();
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
        public RogueStageInfoOuterClass.RogueStageInfo getStageList(int index) {
            return this.stageList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
        public RogueStageInfoOuterClass.RogueStageInfoOrBuilder getStageListOrBuilder(int index) {
            return this.stageList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
        public List<Integer> getEquippedRuneListList() {
            return this.equippedRuneList_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
        public int getEquippedRuneListCount() {
            return this.equippedRuneList_.size();
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
        public int getEquippedRuneList(int index) {
            return this.equippedRuneList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
        public int getContentCloseTime() {
            return this.contentCloseTime_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
        public List<Integer> getRuneListList() {
            return this.runeList_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
        public int getRuneListCount() {
            return this.runeList_.size();
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
        public int getRuneList(int index) {
            return this.runeList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
        public List<RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord> getShikigamiListList() {
            return this.shikigamiList_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
        public List<? extends RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecordOrBuilder> getShikigamiListOrBuilderList() {
            return this.shikigamiList_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
        public int getShikigamiListCount() {
            return this.shikigamiList_.size();
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
        public RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord getShikigamiList(int index) {
            return this.shikigamiList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
        public RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecordOrBuilder getShikigamiListOrBuilder(int index) {
            return this.shikigamiList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
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
            getSerializedSize();
            if (getRuneListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.runeListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.runeList_.size(); i++) {
                output.writeUInt32NoTag(this.runeList_.getInt(i));
            }
            for (int i2 = 0; i2 < this.shikigamiList_.size(); i2++) {
                output.writeMessage(4, this.shikigamiList_.get(i2));
            }
            if (this.isContentClosed_) {
                output.writeBool(5, this.isContentClosed_);
            }
            if (getEquippedRuneListList().size() > 0) {
                output.writeUInt32NoTag(74);
                output.writeUInt32NoTag(this.equippedRuneListMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.equippedRuneList_.size(); i3++) {
                output.writeUInt32NoTag(this.equippedRuneList_.getInt(i3));
            }
            if (this.contentCloseTime_ != 0) {
                output.writeUInt32(11, this.contentCloseTime_);
            }
            for (int i4 = 0; i4 < this.stageList_.size(); i4++) {
                output.writeMessage(14, this.stageList_.get(i4));
            }
            this.unknownFields.writeTo(output);
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.AbstractMessage, com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int size = this.memoizedSize;
            if (size != -1) {
                return size;
            }
            int dataSize = 0;
            for (int i = 0; i < this.runeList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.runeList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getRuneListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.runeListMemoizedSerializedSize = dataSize;
            for (int i2 = 0; i2 < this.shikigamiList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.shikigamiList_.get(i2));
            }
            if (this.isContentClosed_) {
                size2 += CodedOutputStream.computeBoolSize(5, this.isContentClosed_);
            }
            int dataSize2 = 0;
            for (int i3 = 0; i3 < this.equippedRuneList_.size(); i3++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.equippedRuneList_.getInt(i3));
            }
            int size3 = size2 + dataSize2;
            if (!getEquippedRuneListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.equippedRuneListMemoizedSerializedSize = dataSize2;
            if (this.contentCloseTime_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(11, this.contentCloseTime_);
            }
            for (int i4 = 0; i4 < this.stageList_.size(); i4++) {
                size3 += CodedOutputStream.computeMessageSize(14, this.stageList_.get(i4));
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RoguelikeDungeonActivityDetailInfo)) {
                return equals(obj);
            }
            RoguelikeDungeonActivityDetailInfo other = (RoguelikeDungeonActivityDetailInfo) obj;
            return getStageListList().equals(other.getStageListList()) && getEquippedRuneListList().equals(other.getEquippedRuneListList()) && getContentCloseTime() == other.getContentCloseTime() && getRuneListList().equals(other.getRuneListList()) && getShikigamiListList().equals(other.getShikigamiListList()) && getIsContentClosed() == other.getIsContentClosed() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getStageListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getStageListList().hashCode();
            }
            if (getEquippedRuneListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getEquippedRuneListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 11)) + getContentCloseTime();
            if (getRuneListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 3)) + getRuneListList().hashCode();
            }
            if (getShikigamiListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 4)) + getShikigamiListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 5)) + Internal.hashBoolean(getIsContentClosed()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static RoguelikeDungeonActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoguelikeDungeonActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoguelikeDungeonActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoguelikeDungeonActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoguelikeDungeonActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoguelikeDungeonActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoguelikeDungeonActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (RoguelikeDungeonActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RoguelikeDungeonActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoguelikeDungeonActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RoguelikeDungeonActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (RoguelikeDungeonActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RoguelikeDungeonActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoguelikeDungeonActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RoguelikeDungeonActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (RoguelikeDungeonActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RoguelikeDungeonActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoguelikeDungeonActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RoguelikeDungeonActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeDungeonActivityDetailInfoOuterClass$RoguelikeDungeonActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RoguelikeDungeonActivityDetailInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<RogueStageInfoOuterClass.RogueStageInfo, RogueStageInfoOuterClass.RogueStageInfo.Builder, RogueStageInfoOuterClass.RogueStageInfoOrBuilder> stageListBuilder_;
            private int contentCloseTime_;
            private RepeatedFieldBuilderV3<RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord, RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord.Builder, RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecordOrBuilder> shikigamiListBuilder_;
            private boolean isContentClosed_;
            private List<RogueStageInfoOuterClass.RogueStageInfo> stageList_ = Collections.emptyList();
            private Internal.IntList equippedRuneList_ = RoguelikeDungeonActivityDetailInfo.emptyIntList();
            private Internal.IntList runeList_ = RoguelikeDungeonActivityDetailInfo.emptyIntList();
            private List<RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord> shikigamiList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return RoguelikeDungeonActivityDetailInfoOuterClass.internal_static_RoguelikeDungeonActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RoguelikeDungeonActivityDetailInfoOuterClass.f847xfe34a146.ensureFieldAccessorsInitialized(RoguelikeDungeonActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RoguelikeDungeonActivityDetailInfo.alwaysUseFieldBuilders) {
                    getStageListFieldBuilder();
                    getShikigamiListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.stageListBuilder_ == null) {
                    this.stageList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.stageListBuilder_.clear();
                }
                this.equippedRuneList_ = RoguelikeDungeonActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -3;
                this.contentCloseTime_ = 0;
                this.runeList_ = RoguelikeDungeonActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -5;
                if (this.shikigamiListBuilder_ == null) {
                    this.shikigamiList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.shikigamiListBuilder_.clear();
                }
                this.isContentClosed_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RoguelikeDungeonActivityDetailInfoOuterClass.internal_static_RoguelikeDungeonActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RoguelikeDungeonActivityDetailInfo getDefaultInstanceForType() {
                return RoguelikeDungeonActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RoguelikeDungeonActivityDetailInfo build() {
                RoguelikeDungeonActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RoguelikeDungeonActivityDetailInfo buildPartial() {
                RoguelikeDungeonActivityDetailInfo result = new RoguelikeDungeonActivityDetailInfo(this);
                int i = this.bitField0_;
                if (this.stageListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.stageList_ = Collections.unmodifiableList(this.stageList_);
                        this.bitField0_ &= -2;
                    }
                    result.stageList_ = this.stageList_;
                } else {
                    result.stageList_ = this.stageListBuilder_.build();
                }
                if ((this.bitField0_ & 2) != 0) {
                    this.equippedRuneList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.equippedRuneList_ = this.equippedRuneList_;
                result.contentCloseTime_ = this.contentCloseTime_;
                if ((this.bitField0_ & 4) != 0) {
                    this.runeList_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.runeList_ = this.runeList_;
                if (this.shikigamiListBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.shikigamiList_ = Collections.unmodifiableList(this.shikigamiList_);
                        this.bitField0_ &= -9;
                    }
                    result.shikigamiList_ = this.shikigamiList_;
                } else {
                    result.shikigamiList_ = this.shikigamiListBuilder_.build();
                }
                result.isContentClosed_ = this.isContentClosed_;
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
                if (other instanceof RoguelikeDungeonActivityDetailInfo) {
                    return mergeFrom((RoguelikeDungeonActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RoguelikeDungeonActivityDetailInfo other) {
                if (other == RoguelikeDungeonActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.stageListBuilder_ == null) {
                    if (!other.stageList_.isEmpty()) {
                        if (this.stageList_.isEmpty()) {
                            this.stageList_ = other.stageList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureStageListIsMutable();
                            this.stageList_.addAll(other.stageList_);
                        }
                        onChanged();
                    }
                } else if (!other.stageList_.isEmpty()) {
                    if (this.stageListBuilder_.isEmpty()) {
                        this.stageListBuilder_.dispose();
                        this.stageListBuilder_ = null;
                        this.stageList_ = other.stageList_;
                        this.bitField0_ &= -2;
                        this.stageListBuilder_ = RoguelikeDungeonActivityDetailInfo.alwaysUseFieldBuilders ? getStageListFieldBuilder() : null;
                    } else {
                        this.stageListBuilder_.addAllMessages(other.stageList_);
                    }
                }
                if (!other.equippedRuneList_.isEmpty()) {
                    if (this.equippedRuneList_.isEmpty()) {
                        this.equippedRuneList_ = other.equippedRuneList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureEquippedRuneListIsMutable();
                        this.equippedRuneList_.addAll(other.equippedRuneList_);
                    }
                    onChanged();
                }
                if (other.getContentCloseTime() != 0) {
                    setContentCloseTime(other.getContentCloseTime());
                }
                if (!other.runeList_.isEmpty()) {
                    if (this.runeList_.isEmpty()) {
                        this.runeList_ = other.runeList_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureRuneListIsMutable();
                        this.runeList_.addAll(other.runeList_);
                    }
                    onChanged();
                }
                if (this.shikigamiListBuilder_ == null) {
                    if (!other.shikigamiList_.isEmpty()) {
                        if (this.shikigamiList_.isEmpty()) {
                            this.shikigamiList_ = other.shikigamiList_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureShikigamiListIsMutable();
                            this.shikigamiList_.addAll(other.shikigamiList_);
                        }
                        onChanged();
                    }
                } else if (!other.shikigamiList_.isEmpty()) {
                    if (this.shikigamiListBuilder_.isEmpty()) {
                        this.shikigamiListBuilder_.dispose();
                        this.shikigamiListBuilder_ = null;
                        this.shikigamiList_ = other.shikigamiList_;
                        this.bitField0_ &= -9;
                        this.shikigamiListBuilder_ = RoguelikeDungeonActivityDetailInfo.alwaysUseFieldBuilders ? getShikigamiListFieldBuilder() : null;
                    } else {
                        this.shikigamiListBuilder_.addAllMessages(other.shikigamiList_);
                    }
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
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
                RoguelikeDungeonActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = RoguelikeDungeonActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RoguelikeDungeonActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureStageListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.stageList_ = new ArrayList(this.stageList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
            public List<RogueStageInfoOuterClass.RogueStageInfo> getStageListList() {
                if (this.stageListBuilder_ == null) {
                    return Collections.unmodifiableList(this.stageList_);
                }
                return this.stageListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
            public int getStageListCount() {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.size();
                }
                return this.stageListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
            public RogueStageInfoOuterClass.RogueStageInfo getStageList(int index) {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.get(index);
                }
                return this.stageListBuilder_.getMessage(index);
            }

            public Builder setStageList(int index, RogueStageInfoOuterClass.RogueStageInfo value) {
                if (this.stageListBuilder_ != null) {
                    this.stageListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageListIsMutable();
                    this.stageList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setStageList(int index, RogueStageInfoOuterClass.RogueStageInfo.Builder builderForValue) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addStageList(RogueStageInfoOuterClass.RogueStageInfo value) {
                if (this.stageListBuilder_ != null) {
                    this.stageListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageListIsMutable();
                    this.stageList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageList(int index, RogueStageInfoOuterClass.RogueStageInfo value) {
                if (this.stageListBuilder_ != null) {
                    this.stageListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureStageListIsMutable();
                    this.stageList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addStageList(RogueStageInfoOuterClass.RogueStageInfo.Builder builderForValue) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.stageListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addStageList(int index, RogueStageInfoOuterClass.RogueStageInfo.Builder builderForValue) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.stageListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllStageList(Iterable<? extends RogueStageInfoOuterClass.RogueStageInfo> values) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.stageList_);
                    onChanged();
                } else {
                    this.stageListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearStageList() {
                if (this.stageListBuilder_ == null) {
                    this.stageList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.stageListBuilder_.clear();
                }
                return this;
            }

            public Builder removeStageList(int index) {
                if (this.stageListBuilder_ == null) {
                    ensureStageListIsMutable();
                    this.stageList_.remove(index);
                    onChanged();
                } else {
                    this.stageListBuilder_.remove(index);
                }
                return this;
            }

            public RogueStageInfoOuterClass.RogueStageInfo.Builder getStageListBuilder(int index) {
                return getStageListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
            public RogueStageInfoOuterClass.RogueStageInfoOrBuilder getStageListOrBuilder(int index) {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.get(index);
                }
                return this.stageListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
            public List<? extends RogueStageInfoOuterClass.RogueStageInfoOrBuilder> getStageListOrBuilderList() {
                if (this.stageListBuilder_ != null) {
                    return this.stageListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.stageList_);
            }

            public RogueStageInfoOuterClass.RogueStageInfo.Builder addStageListBuilder() {
                return getStageListFieldBuilder().addBuilder(RogueStageInfoOuterClass.RogueStageInfo.getDefaultInstance());
            }

            public RogueStageInfoOuterClass.RogueStageInfo.Builder addStageListBuilder(int index) {
                return getStageListFieldBuilder().addBuilder(index, RogueStageInfoOuterClass.RogueStageInfo.getDefaultInstance());
            }

            public List<RogueStageInfoOuterClass.RogueStageInfo.Builder> getStageListBuilderList() {
                return getStageListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<RogueStageInfoOuterClass.RogueStageInfo, RogueStageInfoOuterClass.RogueStageInfo.Builder, RogueStageInfoOuterClass.RogueStageInfoOrBuilder> getStageListFieldBuilder() {
                if (this.stageListBuilder_ == null) {
                    this.stageListBuilder_ = new RepeatedFieldBuilderV3<>(this.stageList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.stageList_ = null;
                }
                return this.stageListBuilder_;
            }

            private void ensureEquippedRuneListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.equippedRuneList_ = RoguelikeDungeonActivityDetailInfo.mutableCopy(this.equippedRuneList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
            public List<Integer> getEquippedRuneListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.equippedRuneList_) : this.equippedRuneList_;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
            public int getEquippedRuneListCount() {
                return this.equippedRuneList_.size();
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
            public int getEquippedRuneList(int index) {
                return this.equippedRuneList_.getInt(index);
            }

            public Builder setEquippedRuneList(int index, int value) {
                ensureEquippedRuneListIsMutable();
                this.equippedRuneList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addEquippedRuneList(int value) {
                ensureEquippedRuneListIsMutable();
                this.equippedRuneList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllEquippedRuneList(Iterable<? extends Integer> values) {
                ensureEquippedRuneListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.equippedRuneList_);
                onChanged();
                return this;
            }

            public Builder clearEquippedRuneList() {
                this.equippedRuneList_ = RoguelikeDungeonActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
            public int getContentCloseTime() {
                return this.contentCloseTime_;
            }

            public Builder setContentCloseTime(int value) {
                this.contentCloseTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearContentCloseTime() {
                this.contentCloseTime_ = 0;
                onChanged();
                return this;
            }

            private void ensureRuneListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.runeList_ = RoguelikeDungeonActivityDetailInfo.mutableCopy(this.runeList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
            public List<Integer> getRuneListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.runeList_) : this.runeList_;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
            public int getRuneListCount() {
                return this.runeList_.size();
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
            public int getRuneList(int index) {
                return this.runeList_.getInt(index);
            }

            public Builder setRuneList(int index, int value) {
                ensureRuneListIsMutable();
                this.runeList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addRuneList(int value) {
                ensureRuneListIsMutable();
                this.runeList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllRuneList(Iterable<? extends Integer> values) {
                ensureRuneListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.runeList_);
                onChanged();
                return this;
            }

            public Builder clearRuneList() {
                this.runeList_ = RoguelikeDungeonActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            private void ensureShikigamiListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.shikigamiList_ = new ArrayList(this.shikigamiList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
            public List<RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord> getShikigamiListList() {
                if (this.shikigamiListBuilder_ == null) {
                    return Collections.unmodifiableList(this.shikigamiList_);
                }
                return this.shikigamiListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
            public int getShikigamiListCount() {
                if (this.shikigamiListBuilder_ == null) {
                    return this.shikigamiList_.size();
                }
                return this.shikigamiListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
            public RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord getShikigamiList(int index) {
                if (this.shikigamiListBuilder_ == null) {
                    return this.shikigamiList_.get(index);
                }
                return this.shikigamiListBuilder_.getMessage(index);
            }

            public Builder setShikigamiList(int index, RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord value) {
                if (this.shikigamiListBuilder_ != null) {
                    this.shikigamiListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureShikigamiListIsMutable();
                    this.shikigamiList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setShikigamiList(int index, RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord.Builder builderForValue) {
                if (this.shikigamiListBuilder_ == null) {
                    ensureShikigamiListIsMutable();
                    this.shikigamiList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.shikigamiListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addShikigamiList(RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord value) {
                if (this.shikigamiListBuilder_ != null) {
                    this.shikigamiListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureShikigamiListIsMutable();
                    this.shikigamiList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addShikigamiList(int index, RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord value) {
                if (this.shikigamiListBuilder_ != null) {
                    this.shikigamiListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureShikigamiListIsMutable();
                    this.shikigamiList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addShikigamiList(RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord.Builder builderForValue) {
                if (this.shikigamiListBuilder_ == null) {
                    ensureShikigamiListIsMutable();
                    this.shikigamiList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.shikigamiListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addShikigamiList(int index, RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord.Builder builderForValue) {
                if (this.shikigamiListBuilder_ == null) {
                    ensureShikigamiListIsMutable();
                    this.shikigamiList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.shikigamiListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllShikigamiList(Iterable<? extends RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord> values) {
                if (this.shikigamiListBuilder_ == null) {
                    ensureShikigamiListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.shikigamiList_);
                    onChanged();
                } else {
                    this.shikigamiListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearShikigamiList() {
                if (this.shikigamiListBuilder_ == null) {
                    this.shikigamiList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.shikigamiListBuilder_.clear();
                }
                return this;
            }

            public Builder removeShikigamiList(int index) {
                if (this.shikigamiListBuilder_ == null) {
                    ensureShikigamiListIsMutable();
                    this.shikigamiList_.remove(index);
                    onChanged();
                } else {
                    this.shikigamiListBuilder_.remove(index);
                }
                return this;
            }

            public RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord.Builder getShikigamiListBuilder(int index) {
                return getShikigamiListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
            public RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecordOrBuilder getShikigamiListOrBuilder(int index) {
                if (this.shikigamiListBuilder_ == null) {
                    return this.shikigamiList_.get(index);
                }
                return this.shikigamiListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
            public List<? extends RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecordOrBuilder> getShikigamiListOrBuilderList() {
                if (this.shikigamiListBuilder_ != null) {
                    return this.shikigamiListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.shikigamiList_);
            }

            public RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord.Builder addShikigamiListBuilder() {
                return getShikigamiListFieldBuilder().addBuilder(RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord.getDefaultInstance());
            }

            public RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord.Builder addShikigamiListBuilder(int index) {
                return getShikigamiListFieldBuilder().addBuilder(index, RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord.getDefaultInstance());
            }

            public List<RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord.Builder> getShikigamiListBuilderList() {
                return getShikigamiListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord, RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord.Builder, RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecordOrBuilder> getShikigamiListFieldBuilder() {
                if (this.shikigamiListBuilder_ == null) {
                    this.shikigamiListBuilder_ = new RepeatedFieldBuilderV3<>(this.shikigamiList_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.shikigamiList_ = null;
                }
                return this.shikigamiListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungeonActivityDetailInfoOuterClass.RoguelikeDungeonActivityDetailInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static RoguelikeDungeonActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RoguelikeDungeonActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RoguelikeDungeonActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RoguelikeDungeonActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        RogueStageInfoOuterClass.getDescriptor();
        RoguelikeShikigamiRecordOuterClass.getDescriptor();
    }
}
