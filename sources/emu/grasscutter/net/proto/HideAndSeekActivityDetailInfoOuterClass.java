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
import emu.grasscutter.net.proto.HideAndSeekMapInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HideAndSeekActivityDetailInfoOuterClass.class */
public final class HideAndSeekActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#HideAndSeekActivityDetailInfo.proto\u001a\u0018HideAndSeekMapInfo.proto\"Å\u0001\n\u001dHideAndSeekActivityDetailInfo\u0012 \n\u0018chosen_hunter_skill_list\u0018\u0006 \u0003(\r\u0012/\n\u0012open_map_info_list\u0018\r \u0003(\u000b2\u0013.HideAndSeekMapInfo\u0012\u001f\n\u0017chosen_hider_skill_list\u0018\u0002 \u0003(\r\u0012\u0017\n\u000fchosen_map_list\u0018\u000f \u0003(\r\u0012\u0017\n\u000funlock_map_list\u0018\u0004 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{HideAndSeekMapInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_HideAndSeekActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_HideAndSeekActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_HideAndSeekActivityDetailInfo_descriptor, new String[]{"ChosenHunterSkillList", "OpenMapInfoList", "ChosenHiderSkillList", "ChosenMapList", "UnlockMapList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HideAndSeekActivityDetailInfoOuterClass$HideAndSeekActivityDetailInfoOrBuilder.class */
    public interface HideAndSeekActivityDetailInfoOrBuilder extends MessageOrBuilder {
        List<Integer> getChosenHunterSkillListList();

        int getChosenHunterSkillListCount();

        int getChosenHunterSkillList(int i);

        List<HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo> getOpenMapInfoListList();

        HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo getOpenMapInfoList(int i);

        int getOpenMapInfoListCount();

        List<? extends HideAndSeekMapInfoOuterClass.HideAndSeekMapInfoOrBuilder> getOpenMapInfoListOrBuilderList();

        HideAndSeekMapInfoOuterClass.HideAndSeekMapInfoOrBuilder getOpenMapInfoListOrBuilder(int i);

        List<Integer> getChosenHiderSkillListList();

        int getChosenHiderSkillListCount();

        int getChosenHiderSkillList(int i);

        List<Integer> getChosenMapListList();

        int getChosenMapListCount();

        int getChosenMapList(int i);

        List<Integer> getUnlockMapListList();

        int getUnlockMapListCount();

        int getUnlockMapList(int i);
    }

    private HideAndSeekActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HideAndSeekActivityDetailInfoOuterClass$HideAndSeekActivityDetailInfo.class */
    public static final class HideAndSeekActivityDetailInfo extends GeneratedMessageV3 implements HideAndSeekActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CHOSEN_HUNTER_SKILL_LIST_FIELD_NUMBER = 6;
        private Internal.IntList chosenHunterSkillList_;
        private int chosenHunterSkillListMemoizedSerializedSize;
        public static final int OPEN_MAP_INFO_LIST_FIELD_NUMBER = 13;
        private List<HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo> openMapInfoList_;
        public static final int CHOSEN_HIDER_SKILL_LIST_FIELD_NUMBER = 2;
        private Internal.IntList chosenHiderSkillList_;
        private int chosenHiderSkillListMemoizedSerializedSize;
        public static final int CHOSEN_MAP_LIST_FIELD_NUMBER = 15;
        private Internal.IntList chosenMapList_;
        private int chosenMapListMemoizedSerializedSize;
        public static final int UNLOCK_MAP_LIST_FIELD_NUMBER = 4;
        private Internal.IntList unlockMapList_;
        private int unlockMapListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final HideAndSeekActivityDetailInfo DEFAULT_INSTANCE = new HideAndSeekActivityDetailInfo();
        private static final Parser<HideAndSeekActivityDetailInfo> PARSER = new AbstractParser<HideAndSeekActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public HideAndSeekActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new HideAndSeekActivityDetailInfo(input, extensionRegistry);
            }
        };

        private HideAndSeekActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.chosenHunterSkillListMemoizedSerializedSize = -1;
            this.chosenHiderSkillListMemoizedSerializedSize = -1;
            this.chosenMapListMemoizedSerializedSize = -1;
            this.unlockMapListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private HideAndSeekActivityDetailInfo() {
            this.chosenHunterSkillListMemoizedSerializedSize = -1;
            this.chosenHiderSkillListMemoizedSerializedSize = -1;
            this.chosenMapListMemoizedSerializedSize = -1;
            this.unlockMapListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.chosenHunterSkillList_ = emptyIntList();
            this.openMapInfoList_ = Collections.emptyList();
            this.chosenHiderSkillList_ = emptyIntList();
            this.chosenMapList_ = emptyIntList();
            this.unlockMapList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new HideAndSeekActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:131:0x0267 */
        private HideAndSeekActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    if ((mutable_bitField0_ & 4) == 0) {
                                        this.chosenHiderSkillList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    this.chosenHiderSkillList_.addInt(input.readUInt32());
                                    break;
                                case 18:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.chosenHiderSkillList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.chosenHiderSkillList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 32:
                                    if ((mutable_bitField0_ & 16) == 0) {
                                        this.unlockMapList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                    }
                                    this.unlockMapList_.addInt(input.readUInt32());
                                    break;
                                case 34:
                                    int limit2 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 16) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.unlockMapList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.unlockMapList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit2);
                                    break;
                                case 48:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.chosenHunterSkillList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.chosenHunterSkillList_.addInt(input.readUInt32());
                                    break;
                                case 50:
                                    int limit3 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.chosenHunterSkillList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.chosenHunterSkillList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit3);
                                    break;
                                case 106:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.openMapInfoList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.openMapInfoList_.add((HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo) input.readMessage(HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo.parser(), extensionRegistry));
                                    break;
                                case 120:
                                    if ((mutable_bitField0_ & 8) == 0) {
                                        this.chosenMapList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                    }
                                    this.chosenMapList_.addInt(input.readUInt32());
                                    break;
                                case 122:
                                    int limit4 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 8) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.chosenMapList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.chosenMapList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit4);
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 4) != 0) {
                    this.chosenHiderSkillList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 16) != 0) {
                    this.unlockMapList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.chosenHunterSkillList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.openMapInfoList_ = Collections.unmodifiableList(this.openMapInfoList_);
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.chosenMapList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return HideAndSeekActivityDetailInfoOuterClass.internal_static_HideAndSeekActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return HideAndSeekActivityDetailInfoOuterClass.internal_static_HideAndSeekActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HideAndSeekActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
        public List<Integer> getChosenHunterSkillListList() {
            return this.chosenHunterSkillList_;
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
        public int getChosenHunterSkillListCount() {
            return this.chosenHunterSkillList_.size();
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
        public int getChosenHunterSkillList(int index) {
            return this.chosenHunterSkillList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
        public List<HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo> getOpenMapInfoListList() {
            return this.openMapInfoList_;
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
        public List<? extends HideAndSeekMapInfoOuterClass.HideAndSeekMapInfoOrBuilder> getOpenMapInfoListOrBuilderList() {
            return this.openMapInfoList_;
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
        public int getOpenMapInfoListCount() {
            return this.openMapInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
        public HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo getOpenMapInfoList(int index) {
            return this.openMapInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
        public HideAndSeekMapInfoOuterClass.HideAndSeekMapInfoOrBuilder getOpenMapInfoListOrBuilder(int index) {
            return this.openMapInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
        public List<Integer> getChosenHiderSkillListList() {
            return this.chosenHiderSkillList_;
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
        public int getChosenHiderSkillListCount() {
            return this.chosenHiderSkillList_.size();
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
        public int getChosenHiderSkillList(int index) {
            return this.chosenHiderSkillList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
        public List<Integer> getChosenMapListList() {
            return this.chosenMapList_;
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
        public int getChosenMapListCount() {
            return this.chosenMapList_.size();
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
        public int getChosenMapList(int index) {
            return this.chosenMapList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
        public List<Integer> getUnlockMapListList() {
            return this.unlockMapList_;
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
        public int getUnlockMapListCount() {
            return this.unlockMapList_.size();
        }

        @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
        public int getUnlockMapList(int index) {
            return this.unlockMapList_.getInt(index);
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
            if (getChosenHiderSkillListList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.chosenHiderSkillListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.chosenHiderSkillList_.size(); i++) {
                output.writeUInt32NoTag(this.chosenHiderSkillList_.getInt(i));
            }
            if (getUnlockMapListList().size() > 0) {
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.unlockMapListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unlockMapList_.size(); i2++) {
                output.writeUInt32NoTag(this.unlockMapList_.getInt(i2));
            }
            if (getChosenHunterSkillListList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.chosenHunterSkillListMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.chosenHunterSkillList_.size(); i3++) {
                output.writeUInt32NoTag(this.chosenHunterSkillList_.getInt(i3));
            }
            for (int i4 = 0; i4 < this.openMapInfoList_.size(); i4++) {
                output.writeMessage(13, this.openMapInfoList_.get(i4));
            }
            if (getChosenMapListList().size() > 0) {
                output.writeUInt32NoTag(122);
                output.writeUInt32NoTag(this.chosenMapListMemoizedSerializedSize);
            }
            for (int i5 = 0; i5 < this.chosenMapList_.size(); i5++) {
                output.writeUInt32NoTag(this.chosenMapList_.getInt(i5));
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
            for (int i = 0; i < this.chosenHiderSkillList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.chosenHiderSkillList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getChosenHiderSkillListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.chosenHiderSkillListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.unlockMapList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unlockMapList_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getUnlockMapListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unlockMapListMemoizedSerializedSize = dataSize2;
            int dataSize3 = 0;
            for (int i3 = 0; i3 < this.chosenHunterSkillList_.size(); i3++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.chosenHunterSkillList_.getInt(i3));
            }
            int size4 = size3 + dataSize3;
            if (!getChosenHunterSkillListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.chosenHunterSkillListMemoizedSerializedSize = dataSize3;
            for (int i4 = 0; i4 < this.openMapInfoList_.size(); i4++) {
                size4 += CodedOutputStream.computeMessageSize(13, this.openMapInfoList_.get(i4));
            }
            int dataSize4 = 0;
            for (int i5 = 0; i5 < this.chosenMapList_.size(); i5++) {
                dataSize4 += CodedOutputStream.computeUInt32SizeNoTag(this.chosenMapList_.getInt(i5));
            }
            int size5 = size4 + dataSize4;
            if (!getChosenMapListList().isEmpty()) {
                size5 = size5 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize4);
            }
            this.chosenMapListMemoizedSerializedSize = dataSize4;
            int size6 = size5 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size6;
            return size6;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof HideAndSeekActivityDetailInfo)) {
                return equals(obj);
            }
            HideAndSeekActivityDetailInfo other = (HideAndSeekActivityDetailInfo) obj;
            return getChosenHunterSkillListList().equals(other.getChosenHunterSkillListList()) && getOpenMapInfoListList().equals(other.getOpenMapInfoListList()) && getChosenHiderSkillListList().equals(other.getChosenHiderSkillListList()) && getChosenMapListList().equals(other.getChosenMapListList()) && getUnlockMapListList().equals(other.getUnlockMapListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getChosenHunterSkillListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getChosenHunterSkillListList().hashCode();
            }
            if (getOpenMapInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getOpenMapInfoListList().hashCode();
            }
            if (getChosenHiderSkillListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getChosenHiderSkillListList().hashCode();
            }
            if (getChosenMapListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getChosenMapListList().hashCode();
            }
            if (getUnlockMapListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getUnlockMapListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static HideAndSeekActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HideAndSeekActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HideAndSeekActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HideAndSeekActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HideAndSeekActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static HideAndSeekActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static HideAndSeekActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (HideAndSeekActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HideAndSeekActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HideAndSeekActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static HideAndSeekActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (HideAndSeekActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static HideAndSeekActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HideAndSeekActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static HideAndSeekActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (HideAndSeekActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static HideAndSeekActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (HideAndSeekActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(HideAndSeekActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/HideAndSeekActivityDetailInfoOuterClass$HideAndSeekActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements HideAndSeekActivityDetailInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo, HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo.Builder, HideAndSeekMapInfoOuterClass.HideAndSeekMapInfoOrBuilder> openMapInfoListBuilder_;
            private Internal.IntList chosenHunterSkillList_ = HideAndSeekActivityDetailInfo.emptyIntList();
            private List<HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo> openMapInfoList_ = Collections.emptyList();
            private Internal.IntList chosenHiderSkillList_ = HideAndSeekActivityDetailInfo.emptyIntList();
            private Internal.IntList chosenMapList_ = HideAndSeekActivityDetailInfo.emptyIntList();
            private Internal.IntList unlockMapList_ = HideAndSeekActivityDetailInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return HideAndSeekActivityDetailInfoOuterClass.internal_static_HideAndSeekActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return HideAndSeekActivityDetailInfoOuterClass.internal_static_HideAndSeekActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(HideAndSeekActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (HideAndSeekActivityDetailInfo.alwaysUseFieldBuilders) {
                    getOpenMapInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.chosenHunterSkillList_ = HideAndSeekActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -2;
                if (this.openMapInfoListBuilder_ == null) {
                    this.openMapInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.openMapInfoListBuilder_.clear();
                }
                this.chosenHiderSkillList_ = HideAndSeekActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -5;
                this.chosenMapList_ = HideAndSeekActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -9;
                this.unlockMapList_ = HideAndSeekActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -17;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return HideAndSeekActivityDetailInfoOuterClass.internal_static_HideAndSeekActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public HideAndSeekActivityDetailInfo getDefaultInstanceForType() {
                return HideAndSeekActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HideAndSeekActivityDetailInfo build() {
                HideAndSeekActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public HideAndSeekActivityDetailInfo buildPartial() {
                HideAndSeekActivityDetailInfo result = new HideAndSeekActivityDetailInfo(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.chosenHunterSkillList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.chosenHunterSkillList_ = this.chosenHunterSkillList_;
                if (this.openMapInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.openMapInfoList_ = Collections.unmodifiableList(this.openMapInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.openMapInfoList_ = this.openMapInfoList_;
                } else {
                    result.openMapInfoList_ = this.openMapInfoListBuilder_.build();
                }
                if ((this.bitField0_ & 4) != 0) {
                    this.chosenHiderSkillList_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.chosenHiderSkillList_ = this.chosenHiderSkillList_;
                if ((this.bitField0_ & 8) != 0) {
                    this.chosenMapList_.makeImmutable();
                    this.bitField0_ &= -9;
                }
                result.chosenMapList_ = this.chosenMapList_;
                if ((this.bitField0_ & 16) != 0) {
                    this.unlockMapList_.makeImmutable();
                    this.bitField0_ &= -17;
                }
                result.unlockMapList_ = this.unlockMapList_;
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
                if (other instanceof HideAndSeekActivityDetailInfo) {
                    return mergeFrom((HideAndSeekActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(HideAndSeekActivityDetailInfo other) {
                if (other == HideAndSeekActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.chosenHunterSkillList_.isEmpty()) {
                    if (this.chosenHunterSkillList_.isEmpty()) {
                        this.chosenHunterSkillList_ = other.chosenHunterSkillList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureChosenHunterSkillListIsMutable();
                        this.chosenHunterSkillList_.addAll(other.chosenHunterSkillList_);
                    }
                    onChanged();
                }
                if (this.openMapInfoListBuilder_ == null) {
                    if (!other.openMapInfoList_.isEmpty()) {
                        if (this.openMapInfoList_.isEmpty()) {
                            this.openMapInfoList_ = other.openMapInfoList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureOpenMapInfoListIsMutable();
                            this.openMapInfoList_.addAll(other.openMapInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.openMapInfoList_.isEmpty()) {
                    if (this.openMapInfoListBuilder_.isEmpty()) {
                        this.openMapInfoListBuilder_.dispose();
                        this.openMapInfoListBuilder_ = null;
                        this.openMapInfoList_ = other.openMapInfoList_;
                        this.bitField0_ &= -3;
                        this.openMapInfoListBuilder_ = HideAndSeekActivityDetailInfo.alwaysUseFieldBuilders ? getOpenMapInfoListFieldBuilder() : null;
                    } else {
                        this.openMapInfoListBuilder_.addAllMessages(other.openMapInfoList_);
                    }
                }
                if (!other.chosenHiderSkillList_.isEmpty()) {
                    if (this.chosenHiderSkillList_.isEmpty()) {
                        this.chosenHiderSkillList_ = other.chosenHiderSkillList_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureChosenHiderSkillListIsMutable();
                        this.chosenHiderSkillList_.addAll(other.chosenHiderSkillList_);
                    }
                    onChanged();
                }
                if (!other.chosenMapList_.isEmpty()) {
                    if (this.chosenMapList_.isEmpty()) {
                        this.chosenMapList_ = other.chosenMapList_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureChosenMapListIsMutable();
                        this.chosenMapList_.addAll(other.chosenMapList_);
                    }
                    onChanged();
                }
                if (!other.unlockMapList_.isEmpty()) {
                    if (this.unlockMapList_.isEmpty()) {
                        this.unlockMapList_ = other.unlockMapList_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureUnlockMapListIsMutable();
                        this.unlockMapList_.addAll(other.unlockMapList_);
                    }
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
                HideAndSeekActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = HideAndSeekActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (HideAndSeekActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureChosenHunterSkillListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.chosenHunterSkillList_ = HideAndSeekActivityDetailInfo.mutableCopy(this.chosenHunterSkillList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
            public List<Integer> getChosenHunterSkillListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.chosenHunterSkillList_) : this.chosenHunterSkillList_;
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
            public int getChosenHunterSkillListCount() {
                return this.chosenHunterSkillList_.size();
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
            public int getChosenHunterSkillList(int index) {
                return this.chosenHunterSkillList_.getInt(index);
            }

            public Builder setChosenHunterSkillList(int index, int value) {
                ensureChosenHunterSkillListIsMutable();
                this.chosenHunterSkillList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addChosenHunterSkillList(int value) {
                ensureChosenHunterSkillListIsMutable();
                this.chosenHunterSkillList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllChosenHunterSkillList(Iterable<? extends Integer> values) {
                ensureChosenHunterSkillListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.chosenHunterSkillList_);
                onChanged();
                return this;
            }

            public Builder clearChosenHunterSkillList() {
                this.chosenHunterSkillList_ = HideAndSeekActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureOpenMapInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.openMapInfoList_ = new ArrayList(this.openMapInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
            public List<HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo> getOpenMapInfoListList() {
                if (this.openMapInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.openMapInfoList_);
                }
                return this.openMapInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
            public int getOpenMapInfoListCount() {
                if (this.openMapInfoListBuilder_ == null) {
                    return this.openMapInfoList_.size();
                }
                return this.openMapInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
            public HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo getOpenMapInfoList(int index) {
                if (this.openMapInfoListBuilder_ == null) {
                    return this.openMapInfoList_.get(index);
                }
                return this.openMapInfoListBuilder_.getMessage(index);
            }

            public Builder setOpenMapInfoList(int index, HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo value) {
                if (this.openMapInfoListBuilder_ != null) {
                    this.openMapInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOpenMapInfoListIsMutable();
                    this.openMapInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setOpenMapInfoList(int index, HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo.Builder builderForValue) {
                if (this.openMapInfoListBuilder_ == null) {
                    ensureOpenMapInfoListIsMutable();
                    this.openMapInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.openMapInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addOpenMapInfoList(HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo value) {
                if (this.openMapInfoListBuilder_ != null) {
                    this.openMapInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOpenMapInfoListIsMutable();
                    this.openMapInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addOpenMapInfoList(int index, HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo value) {
                if (this.openMapInfoListBuilder_ != null) {
                    this.openMapInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureOpenMapInfoListIsMutable();
                    this.openMapInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addOpenMapInfoList(HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo.Builder builderForValue) {
                if (this.openMapInfoListBuilder_ == null) {
                    ensureOpenMapInfoListIsMutable();
                    this.openMapInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.openMapInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addOpenMapInfoList(int index, HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo.Builder builderForValue) {
                if (this.openMapInfoListBuilder_ == null) {
                    ensureOpenMapInfoListIsMutable();
                    this.openMapInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.openMapInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllOpenMapInfoList(Iterable<? extends HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo> values) {
                if (this.openMapInfoListBuilder_ == null) {
                    ensureOpenMapInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.openMapInfoList_);
                    onChanged();
                } else {
                    this.openMapInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearOpenMapInfoList() {
                if (this.openMapInfoListBuilder_ == null) {
                    this.openMapInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.openMapInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeOpenMapInfoList(int index) {
                if (this.openMapInfoListBuilder_ == null) {
                    ensureOpenMapInfoListIsMutable();
                    this.openMapInfoList_.remove(index);
                    onChanged();
                } else {
                    this.openMapInfoListBuilder_.remove(index);
                }
                return this;
            }

            public HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo.Builder getOpenMapInfoListBuilder(int index) {
                return getOpenMapInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
            public HideAndSeekMapInfoOuterClass.HideAndSeekMapInfoOrBuilder getOpenMapInfoListOrBuilder(int index) {
                if (this.openMapInfoListBuilder_ == null) {
                    return this.openMapInfoList_.get(index);
                }
                return this.openMapInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
            public List<? extends HideAndSeekMapInfoOuterClass.HideAndSeekMapInfoOrBuilder> getOpenMapInfoListOrBuilderList() {
                if (this.openMapInfoListBuilder_ != null) {
                    return this.openMapInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.openMapInfoList_);
            }

            public HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo.Builder addOpenMapInfoListBuilder() {
                return getOpenMapInfoListFieldBuilder().addBuilder(HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo.getDefaultInstance());
            }

            public HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo.Builder addOpenMapInfoListBuilder(int index) {
                return getOpenMapInfoListFieldBuilder().addBuilder(index, HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo.getDefaultInstance());
            }

            public List<HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo.Builder> getOpenMapInfoListBuilderList() {
                return getOpenMapInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo, HideAndSeekMapInfoOuterClass.HideAndSeekMapInfo.Builder, HideAndSeekMapInfoOuterClass.HideAndSeekMapInfoOrBuilder> getOpenMapInfoListFieldBuilder() {
                if (this.openMapInfoListBuilder_ == null) {
                    this.openMapInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.openMapInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.openMapInfoList_ = null;
                }
                return this.openMapInfoListBuilder_;
            }

            private void ensureChosenHiderSkillListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.chosenHiderSkillList_ = HideAndSeekActivityDetailInfo.mutableCopy(this.chosenHiderSkillList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
            public List<Integer> getChosenHiderSkillListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.chosenHiderSkillList_) : this.chosenHiderSkillList_;
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
            public int getChosenHiderSkillListCount() {
                return this.chosenHiderSkillList_.size();
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
            public int getChosenHiderSkillList(int index) {
                return this.chosenHiderSkillList_.getInt(index);
            }

            public Builder setChosenHiderSkillList(int index, int value) {
                ensureChosenHiderSkillListIsMutable();
                this.chosenHiderSkillList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addChosenHiderSkillList(int value) {
                ensureChosenHiderSkillListIsMutable();
                this.chosenHiderSkillList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllChosenHiderSkillList(Iterable<? extends Integer> values) {
                ensureChosenHiderSkillListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.chosenHiderSkillList_);
                onChanged();
                return this;
            }

            public Builder clearChosenHiderSkillList() {
                this.chosenHiderSkillList_ = HideAndSeekActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            private void ensureChosenMapListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.chosenMapList_ = HideAndSeekActivityDetailInfo.mutableCopy(this.chosenMapList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
            public List<Integer> getChosenMapListList() {
                return (this.bitField0_ & 8) != 0 ? Collections.unmodifiableList(this.chosenMapList_) : this.chosenMapList_;
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
            public int getChosenMapListCount() {
                return this.chosenMapList_.size();
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
            public int getChosenMapList(int index) {
                return this.chosenMapList_.getInt(index);
            }

            public Builder setChosenMapList(int index, int value) {
                ensureChosenMapListIsMutable();
                this.chosenMapList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addChosenMapList(int value) {
                ensureChosenMapListIsMutable();
                this.chosenMapList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllChosenMapList(Iterable<? extends Integer> values) {
                ensureChosenMapListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.chosenMapList_);
                onChanged();
                return this;
            }

            public Builder clearChosenMapList() {
                this.chosenMapList_ = HideAndSeekActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            private void ensureUnlockMapListIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.unlockMapList_ = HideAndSeekActivityDetailInfo.mutableCopy(this.unlockMapList_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
            public List<Integer> getUnlockMapListList() {
                return (this.bitField0_ & 16) != 0 ? Collections.unmodifiableList(this.unlockMapList_) : this.unlockMapList_;
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
            public int getUnlockMapListCount() {
                return this.unlockMapList_.size();
            }

            @Override // emu.grasscutter.net.proto.HideAndSeekActivityDetailInfoOuterClass.HideAndSeekActivityDetailInfoOrBuilder
            public int getUnlockMapList(int index) {
                return this.unlockMapList_.getInt(index);
            }

            public Builder setUnlockMapList(int index, int value) {
                ensureUnlockMapListIsMutable();
                this.unlockMapList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnlockMapList(int value) {
                ensureUnlockMapListIsMutable();
                this.unlockMapList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnlockMapList(Iterable<? extends Integer> values) {
                ensureUnlockMapListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unlockMapList_);
                onChanged();
                return this;
            }

            public Builder clearUnlockMapList() {
                this.unlockMapList_ = HideAndSeekActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -17;
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

        public static HideAndSeekActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<HideAndSeekActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<HideAndSeekActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public HideAndSeekActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        HideAndSeekMapInfoOuterClass.getDescriptor();
    }
}
