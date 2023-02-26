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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeDungoenInfoOuterClass.class */
public final class RoguelikeDungoenInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aRoguelikeDungoenInfo.proto\u001a\u0014RogueStageInfo.proto\u001a\u001eRoguelikeShikigamiRecord.proto\"È\u0001\n\u0014RoguelikeDungoenInfo\u0012\"\n\tstageList\u0018\u0006 \u0003(\u000b2\u000f.RogueStageInfo\u0012\u0018\n\u0010equippedRuneList\u0018\f \u0003(\r\u00120\n\rshikigamiList\u0018\u0001 \u0003(\u000b2\u0019.RoguelikeShikigamiRecord\u0012\u0010\n\bruneList\u0018\u000b \u0003(\r\u0012\u0014\n\fleftMonsters\u0018\n \u0001(\b\u0012\u0018\n\u0010contentCloseTime\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{RogueStageInfoOuterClass.getDescriptor(), RoguelikeShikigamiRecordOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_RoguelikeDungoenInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_RoguelikeDungoenInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_RoguelikeDungoenInfo_descriptor, new String[]{"StageList", "EquippedRuneList", "ShikigamiList", "RuneList", "LeftMonsters", "ContentCloseTime"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeDungoenInfoOuterClass$RoguelikeDungoenInfoOrBuilder.class */
    public interface RoguelikeDungoenInfoOrBuilder extends MessageOrBuilder {
        List<RogueStageInfoOuterClass.RogueStageInfo> getStageListList();

        RogueStageInfoOuterClass.RogueStageInfo getStageList(int i);

        int getStageListCount();

        List<? extends RogueStageInfoOuterClass.RogueStageInfoOrBuilder> getStageListOrBuilderList();

        RogueStageInfoOuterClass.RogueStageInfoOrBuilder getStageListOrBuilder(int i);

        List<Integer> getEquippedRuneListList();

        int getEquippedRuneListCount();

        int getEquippedRuneList(int i);

        List<RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord> getShikigamiListList();

        RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord getShikigamiList(int i);

        int getShikigamiListCount();

        List<? extends RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecordOrBuilder> getShikigamiListOrBuilderList();

        RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecordOrBuilder getShikigamiListOrBuilder(int i);

        List<Integer> getRuneListList();

        int getRuneListCount();

        int getRuneList(int i);

        boolean getLeftMonsters();

        int getContentCloseTime();
    }

    private RoguelikeDungoenInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeDungoenInfoOuterClass$RoguelikeDungoenInfo.class */
    public static final class RoguelikeDungoenInfo extends GeneratedMessageV3 implements RoguelikeDungoenInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int STAGELIST_FIELD_NUMBER = 6;
        private List<RogueStageInfoOuterClass.RogueStageInfo> stageList_;
        public static final int EQUIPPEDRUNELIST_FIELD_NUMBER = 12;
        private Internal.IntList equippedRuneList_;
        private int equippedRuneListMemoizedSerializedSize;
        public static final int SHIKIGAMILIST_FIELD_NUMBER = 1;
        private List<RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord> shikigamiList_;
        public static final int RUNELIST_FIELD_NUMBER = 11;
        private Internal.IntList runeList_;
        private int runeListMemoizedSerializedSize;
        public static final int LEFTMONSTERS_FIELD_NUMBER = 10;
        private boolean leftMonsters_;
        public static final int CONTENTCLOSETIME_FIELD_NUMBER = 8;
        private int contentCloseTime_;
        private byte memoizedIsInitialized;
        private static final RoguelikeDungoenInfo DEFAULT_INSTANCE = new RoguelikeDungoenInfo();
        private static final Parser<RoguelikeDungoenInfo> PARSER = new AbstractParser<RoguelikeDungoenInfo>() { // from class: emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfo.1
            @Override // com.google.protobuf.Parser
            public RoguelikeDungoenInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new RoguelikeDungoenInfo(input, extensionRegistry);
            }
        };

        private RoguelikeDungoenInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.equippedRuneListMemoizedSerializedSize = -1;
            this.runeListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private RoguelikeDungoenInfo() {
            this.equippedRuneListMemoizedSerializedSize = -1;
            this.runeListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.stageList_ = Collections.emptyList();
            this.equippedRuneList_ = emptyIntList();
            this.shikigamiList_ = Collections.emptyList();
            this.runeList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new RoguelikeDungoenInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:104:0x01d0 */
        private RoguelikeDungoenInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 10:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.shikigamiList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.shikigamiList_.add((RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord) input.readMessage(RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord.parser(), extensionRegistry));
                                break;
                            case 50:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.stageList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.stageList_.add((RogueStageInfoOuterClass.RogueStageInfo) input.readMessage(RogueStageInfoOuterClass.RogueStageInfo.parser(), extensionRegistry));
                                break;
                            case 64:
                                this.contentCloseTime_ = input.readUInt32();
                                break;
                            case 80:
                                this.leftMonsters_ = input.readBool();
                                break;
                            case 88:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.runeList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.runeList_.addInt(input.readUInt32());
                                break;
                            case 90:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 8) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.runeList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.runeList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 96:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.equippedRuneList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.equippedRuneList_.addInt(input.readUInt32());
                                break;
                            case 98:
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
                    this.shikigamiList_ = Collections.unmodifiableList(this.shikigamiList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.stageList_ = Collections.unmodifiableList(this.stageList_);
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.runeList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.equippedRuneList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return RoguelikeDungoenInfoOuterClass.internal_static_RoguelikeDungoenInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return RoguelikeDungoenInfoOuterClass.internal_static_RoguelikeDungoenInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RoguelikeDungoenInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
        public List<RogueStageInfoOuterClass.RogueStageInfo> getStageListList() {
            return this.stageList_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
        public List<? extends RogueStageInfoOuterClass.RogueStageInfoOrBuilder> getStageListOrBuilderList() {
            return this.stageList_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
        public int getStageListCount() {
            return this.stageList_.size();
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
        public RogueStageInfoOuterClass.RogueStageInfo getStageList(int index) {
            return this.stageList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
        public RogueStageInfoOuterClass.RogueStageInfoOrBuilder getStageListOrBuilder(int index) {
            return this.stageList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
        public List<Integer> getEquippedRuneListList() {
            return this.equippedRuneList_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
        public int getEquippedRuneListCount() {
            return this.equippedRuneList_.size();
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
        public int getEquippedRuneList(int index) {
            return this.equippedRuneList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
        public List<RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord> getShikigamiListList() {
            return this.shikigamiList_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
        public List<? extends RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecordOrBuilder> getShikigamiListOrBuilderList() {
            return this.shikigamiList_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
        public int getShikigamiListCount() {
            return this.shikigamiList_.size();
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
        public RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord getShikigamiList(int index) {
            return this.shikigamiList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
        public RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecordOrBuilder getShikigamiListOrBuilder(int index) {
            return this.shikigamiList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
        public List<Integer> getRuneListList() {
            return this.runeList_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
        public int getRuneListCount() {
            return this.runeList_.size();
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
        public int getRuneList(int index) {
            return this.runeList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
        public boolean getLeftMonsters() {
            return this.leftMonsters_;
        }

        @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
        public int getContentCloseTime() {
            return this.contentCloseTime_;
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
            for (int i = 0; i < this.shikigamiList_.size(); i++) {
                output.writeMessage(1, this.shikigamiList_.get(i));
            }
            for (int i2 = 0; i2 < this.stageList_.size(); i2++) {
                output.writeMessage(6, this.stageList_.get(i2));
            }
            if (this.contentCloseTime_ != 0) {
                output.writeUInt32(8, this.contentCloseTime_);
            }
            if (this.leftMonsters_) {
                output.writeBool(10, this.leftMonsters_);
            }
            if (getRuneListList().size() > 0) {
                output.writeUInt32NoTag(90);
                output.writeUInt32NoTag(this.runeListMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.runeList_.size(); i3++) {
                output.writeUInt32NoTag(this.runeList_.getInt(i3));
            }
            if (getEquippedRuneListList().size() > 0) {
                output.writeUInt32NoTag(98);
                output.writeUInt32NoTag(this.equippedRuneListMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.equippedRuneList_.size(); i4++) {
                output.writeUInt32NoTag(this.equippedRuneList_.getInt(i4));
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
            for (int i = 0; i < this.shikigamiList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.shikigamiList_.get(i));
            }
            for (int i2 = 0; i2 < this.stageList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.stageList_.get(i2));
            }
            if (this.contentCloseTime_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.contentCloseTime_);
            }
            if (this.leftMonsters_) {
                size2 += CodedOutputStream.computeBoolSize(10, this.leftMonsters_);
            }
            int dataSize = 0;
            for (int i3 = 0; i3 < this.runeList_.size(); i3++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.runeList_.getInt(i3));
            }
            int size3 = size2 + dataSize;
            if (!getRuneListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.runeListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i4 = 0; i4 < this.equippedRuneList_.size(); i4++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.equippedRuneList_.getInt(i4));
            }
            int size4 = size3 + dataSize2;
            if (!getEquippedRuneListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.equippedRuneListMemoizedSerializedSize = dataSize2;
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof RoguelikeDungoenInfo)) {
                return equals(obj);
            }
            RoguelikeDungoenInfo other = (RoguelikeDungoenInfo) obj;
            return getStageListList().equals(other.getStageListList()) && getEquippedRuneListList().equals(other.getEquippedRuneListList()) && getShikigamiListList().equals(other.getShikigamiListList()) && getRuneListList().equals(other.getRuneListList()) && getLeftMonsters() == other.getLeftMonsters() && getContentCloseTime() == other.getContentCloseTime() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getStageListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getStageListList().hashCode();
            }
            if (getEquippedRuneListCount() > 0) {
                hash = (53 * ((37 * hash) + 12)) + getEquippedRuneListList().hashCode();
            }
            if (getShikigamiListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getShikigamiListList().hashCode();
            }
            if (getRuneListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getRuneListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 10)) + Internal.hashBoolean(getLeftMonsters()))) + 8)) + getContentCloseTime())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static RoguelikeDungoenInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoguelikeDungoenInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoguelikeDungoenInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoguelikeDungoenInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoguelikeDungoenInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static RoguelikeDungoenInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static RoguelikeDungoenInfo parseFrom(InputStream input) throws IOException {
            return (RoguelikeDungoenInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RoguelikeDungoenInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoguelikeDungoenInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static RoguelikeDungoenInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (RoguelikeDungoenInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static RoguelikeDungoenInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoguelikeDungoenInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static RoguelikeDungoenInfo parseFrom(CodedInputStream input) throws IOException {
            return (RoguelikeDungoenInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static RoguelikeDungoenInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RoguelikeDungoenInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(RoguelikeDungoenInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/RoguelikeDungoenInfoOuterClass$RoguelikeDungoenInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements RoguelikeDungoenInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<RogueStageInfoOuterClass.RogueStageInfo, RogueStageInfoOuterClass.RogueStageInfo.Builder, RogueStageInfoOuterClass.RogueStageInfoOrBuilder> stageListBuilder_;
            private RepeatedFieldBuilderV3<RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord, RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord.Builder, RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecordOrBuilder> shikigamiListBuilder_;
            private boolean leftMonsters_;
            private int contentCloseTime_;
            private List<RogueStageInfoOuterClass.RogueStageInfo> stageList_ = Collections.emptyList();
            private Internal.IntList equippedRuneList_ = RoguelikeDungoenInfo.emptyIntList();
            private List<RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord> shikigamiList_ = Collections.emptyList();
            private Internal.IntList runeList_ = RoguelikeDungoenInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return RoguelikeDungoenInfoOuterClass.internal_static_RoguelikeDungoenInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return RoguelikeDungoenInfoOuterClass.internal_static_RoguelikeDungoenInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(RoguelikeDungoenInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (RoguelikeDungoenInfo.alwaysUseFieldBuilders) {
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
                this.equippedRuneList_ = RoguelikeDungoenInfo.emptyIntList();
                this.bitField0_ &= -3;
                if (this.shikigamiListBuilder_ == null) {
                    this.shikigamiList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.shikigamiListBuilder_.clear();
                }
                this.runeList_ = RoguelikeDungoenInfo.emptyIntList();
                this.bitField0_ &= -9;
                this.leftMonsters_ = false;
                this.contentCloseTime_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return RoguelikeDungoenInfoOuterClass.internal_static_RoguelikeDungoenInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public RoguelikeDungoenInfo getDefaultInstanceForType() {
                return RoguelikeDungoenInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RoguelikeDungoenInfo build() {
                RoguelikeDungoenInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public RoguelikeDungoenInfo buildPartial() {
                RoguelikeDungoenInfo result = new RoguelikeDungoenInfo(this);
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
                if (this.shikigamiListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.shikigamiList_ = Collections.unmodifiableList(this.shikigamiList_);
                        this.bitField0_ &= -5;
                    }
                    result.shikigamiList_ = this.shikigamiList_;
                } else {
                    result.shikigamiList_ = this.shikigamiListBuilder_.build();
                }
                if ((this.bitField0_ & 8) != 0) {
                    this.runeList_.makeImmutable();
                    this.bitField0_ &= -9;
                }
                result.runeList_ = this.runeList_;
                result.leftMonsters_ = this.leftMonsters_;
                result.contentCloseTime_ = this.contentCloseTime_;
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
                if (other instanceof RoguelikeDungoenInfo) {
                    return mergeFrom((RoguelikeDungoenInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(RoguelikeDungoenInfo other) {
                if (other == RoguelikeDungoenInfo.getDefaultInstance()) {
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
                        this.stageListBuilder_ = RoguelikeDungoenInfo.alwaysUseFieldBuilders ? getStageListFieldBuilder() : null;
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
                if (this.shikigamiListBuilder_ == null) {
                    if (!other.shikigamiList_.isEmpty()) {
                        if (this.shikigamiList_.isEmpty()) {
                            this.shikigamiList_ = other.shikigamiList_;
                            this.bitField0_ &= -5;
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
                        this.bitField0_ &= -5;
                        this.shikigamiListBuilder_ = RoguelikeDungoenInfo.alwaysUseFieldBuilders ? getShikigamiListFieldBuilder() : null;
                    } else {
                        this.shikigamiListBuilder_.addAllMessages(other.shikigamiList_);
                    }
                }
                if (!other.runeList_.isEmpty()) {
                    if (this.runeList_.isEmpty()) {
                        this.runeList_ = other.runeList_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureRuneListIsMutable();
                        this.runeList_.addAll(other.runeList_);
                    }
                    onChanged();
                }
                if (other.getLeftMonsters()) {
                    setLeftMonsters(other.getLeftMonsters());
                }
                if (other.getContentCloseTime() != 0) {
                    setContentCloseTime(other.getContentCloseTime());
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
                RoguelikeDungoenInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = RoguelikeDungoenInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (RoguelikeDungoenInfo) e.getUnfinishedMessage();
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

            @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
            public List<RogueStageInfoOuterClass.RogueStageInfo> getStageListList() {
                if (this.stageListBuilder_ == null) {
                    return Collections.unmodifiableList(this.stageList_);
                }
                return this.stageListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
            public int getStageListCount() {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.size();
                }
                return this.stageListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
            public RogueStageInfoOuterClass.RogueStageInfoOrBuilder getStageListOrBuilder(int index) {
                if (this.stageListBuilder_ == null) {
                    return this.stageList_.get(index);
                }
                return this.stageListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
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
                    this.equippedRuneList_ = RoguelikeDungoenInfo.mutableCopy(this.equippedRuneList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
            public List<Integer> getEquippedRuneListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.equippedRuneList_) : this.equippedRuneList_;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
            public int getEquippedRuneListCount() {
                return this.equippedRuneList_.size();
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
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
                this.equippedRuneList_ = RoguelikeDungoenInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureShikigamiListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.shikigamiList_ = new ArrayList(this.shikigamiList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
            public List<RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecord> getShikigamiListList() {
                if (this.shikigamiListBuilder_ == null) {
                    return Collections.unmodifiableList(this.shikigamiList_);
                }
                return this.shikigamiListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
            public int getShikigamiListCount() {
                if (this.shikigamiListBuilder_ == null) {
                    return this.shikigamiList_.size();
                }
                return this.shikigamiListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
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
                    this.bitField0_ &= -5;
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

            @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
            public RoguelikeShikigamiRecordOuterClass.RoguelikeShikigamiRecordOrBuilder getShikigamiListOrBuilder(int index) {
                if (this.shikigamiListBuilder_ == null) {
                    return this.shikigamiList_.get(index);
                }
                return this.shikigamiListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
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
                    this.shikigamiListBuilder_ = new RepeatedFieldBuilderV3<>(this.shikigamiList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.shikigamiList_ = null;
                }
                return this.shikigamiListBuilder_;
            }

            private void ensureRuneListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.runeList_ = RoguelikeDungoenInfo.mutableCopy(this.runeList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
            public List<Integer> getRuneListList() {
                return (this.bitField0_ & 8) != 0 ? Collections.unmodifiableList(this.runeList_) : this.runeList_;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
            public int getRuneListCount() {
                return this.runeList_.size();
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
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
                this.runeList_ = RoguelikeDungoenInfo.emptyIntList();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.RoguelikeDungoenInfoOuterClass.RoguelikeDungoenInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static RoguelikeDungoenInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RoguelikeDungoenInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<RoguelikeDungoenInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public RoguelikeDungoenInfo getDefaultInstanceForType() {
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
