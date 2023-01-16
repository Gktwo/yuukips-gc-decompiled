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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetScenePointRspOuterClass.class */
public final class GetScenePointRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016GetScenePointRsp.proto\"í\u0002\n\u0010GetScenePointRsp\u0012\u0018\n\u0010unlock_area_list\u0018\t \u0003(\r\u0012\u0019\n\u0011locked_point_list\u0018\u000f \u0003(\r\u0012\u000f\n\u0007retcode\u0018\r \u0001(\u0005\u0012\u0019\n\u0011unhide_point_list\u0018\u0003 \u0003(\r\u0012\u0017\n\u000fhide_point_list\u0018\n \u0003(\r\u0012 \n\u0018group_unlimit_point_list\u0018\u0001 \u0003(\r\u0012'\n\u001fnot_interact_dungeon_entry_list\u0018\u000b \u0003(\r\u0012(\n to_be_explore_dungeon_entry_list\u0018\u0006 \u0003(\r\u0012'\n\u001fnot_explored_dungeon_entry_list\u0018\u0007 \u0003(\r\u0012\u0012\n\nbelong_uid\u0018\f \u0001(\r\u0012\u001b\n\u0013unlocked_point_list\u0018\u0002 \u0003(\r\u0012\u0010\n\bscene_id\u0018\b \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_GetScenePointRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetScenePointRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetScenePointRsp_descriptor, new String[]{"UnlockAreaList", "LockedPointList", "Retcode", "UnhidePointList", "HidePointList", "GroupUnlimitPointList", "NotInteractDungeonEntryList", "ToBeExploreDungeonEntryList", "NotExploredDungeonEntryList", "BelongUid", "UnlockedPointList", "SceneId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetScenePointRspOuterClass$GetScenePointRspOrBuilder.class */
    public interface GetScenePointRspOrBuilder extends MessageOrBuilder {
        List<Integer> getUnlockAreaListList();

        int getUnlockAreaListCount();

        int getUnlockAreaList(int i);

        List<Integer> getLockedPointListList();

        int getLockedPointListCount();

        int getLockedPointList(int i);

        int getRetcode();

        List<Integer> getUnhidePointListList();

        int getUnhidePointListCount();

        int getUnhidePointList(int i);

        List<Integer> getHidePointListList();

        int getHidePointListCount();

        int getHidePointList(int i);

        List<Integer> getGroupUnlimitPointListList();

        int getGroupUnlimitPointListCount();

        int getGroupUnlimitPointList(int i);

        List<Integer> getNotInteractDungeonEntryListList();

        int getNotInteractDungeonEntryListCount();

        int getNotInteractDungeonEntryList(int i);

        List<Integer> getToBeExploreDungeonEntryListList();

        int getToBeExploreDungeonEntryListCount();

        int getToBeExploreDungeonEntryList(int i);

        List<Integer> getNotExploredDungeonEntryListList();

        int getNotExploredDungeonEntryListCount();

        int getNotExploredDungeonEntryList(int i);

        int getBelongUid();

        List<Integer> getUnlockedPointListList();

        int getUnlockedPointListCount();

        int getUnlockedPointList(int i);

        int getSceneId();
    }

    private GetScenePointRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetScenePointRspOuterClass$GetScenePointRsp.class */
    public static final class GetScenePointRsp extends GeneratedMessageV3 implements GetScenePointRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNLOCK_AREA_LIST_FIELD_NUMBER = 9;
        private Internal.IntList unlockAreaList_;
        private int unlockAreaListMemoizedSerializedSize;
        public static final int LOCKED_POINT_LIST_FIELD_NUMBER = 15;
        private Internal.IntList lockedPointList_;
        private int lockedPointListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 13;
        private int retcode_;
        public static final int UNHIDE_POINT_LIST_FIELD_NUMBER = 3;
        private Internal.IntList unhidePointList_;
        private int unhidePointListMemoizedSerializedSize;
        public static final int HIDE_POINT_LIST_FIELD_NUMBER = 10;
        private Internal.IntList hidePointList_;
        private int hidePointListMemoizedSerializedSize;
        public static final int GROUP_UNLIMIT_POINT_LIST_FIELD_NUMBER = 1;
        private Internal.IntList groupUnlimitPointList_;
        private int groupUnlimitPointListMemoizedSerializedSize;
        public static final int NOT_INTERACT_DUNGEON_ENTRY_LIST_FIELD_NUMBER = 11;
        private Internal.IntList notInteractDungeonEntryList_;
        private int notInteractDungeonEntryListMemoizedSerializedSize;
        public static final int TO_BE_EXPLORE_DUNGEON_ENTRY_LIST_FIELD_NUMBER = 6;
        private Internal.IntList toBeExploreDungeonEntryList_;
        private int toBeExploreDungeonEntryListMemoizedSerializedSize;
        public static final int NOT_EXPLORED_DUNGEON_ENTRY_LIST_FIELD_NUMBER = 7;
        private Internal.IntList notExploredDungeonEntryList_;
        private int notExploredDungeonEntryListMemoizedSerializedSize;
        public static final int BELONG_UID_FIELD_NUMBER = 12;
        private int belongUid_;
        public static final int UNLOCKED_POINT_LIST_FIELD_NUMBER = 2;
        private Internal.IntList unlockedPointList_;
        private int unlockedPointListMemoizedSerializedSize;
        public static final int SCENE_ID_FIELD_NUMBER = 8;
        private int sceneId_;
        private byte memoizedIsInitialized;
        private static final GetScenePointRsp DEFAULT_INSTANCE = new GetScenePointRsp();
        private static final Parser<GetScenePointRsp> PARSER = new AbstractParser<GetScenePointRsp>() { // from class: emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRsp.1
            @Override // com.google.protobuf.Parser
            public GetScenePointRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetScenePointRsp(input, extensionRegistry);
            }
        };

        private GetScenePointRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unlockAreaListMemoizedSerializedSize = -1;
            this.lockedPointListMemoizedSerializedSize = -1;
            this.unhidePointListMemoizedSerializedSize = -1;
            this.hidePointListMemoizedSerializedSize = -1;
            this.groupUnlimitPointListMemoizedSerializedSize = -1;
            this.notInteractDungeonEntryListMemoizedSerializedSize = -1;
            this.toBeExploreDungeonEntryListMemoizedSerializedSize = -1;
            this.notExploredDungeonEntryListMemoizedSerializedSize = -1;
            this.unlockedPointListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GetScenePointRsp() {
            this.unlockAreaListMemoizedSerializedSize = -1;
            this.lockedPointListMemoizedSerializedSize = -1;
            this.unhidePointListMemoizedSerializedSize = -1;
            this.hidePointListMemoizedSerializedSize = -1;
            this.groupUnlimitPointListMemoizedSerializedSize = -1;
            this.notInteractDungeonEntryListMemoizedSerializedSize = -1;
            this.toBeExploreDungeonEntryListMemoizedSerializedSize = -1;
            this.notExploredDungeonEntryListMemoizedSerializedSize = -1;
            this.unlockedPointListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unlockAreaList_ = emptyIntList();
            this.lockedPointList_ = emptyIntList();
            this.unhidePointList_ = emptyIntList();
            this.hidePointList_ = emptyIntList();
            this.groupUnlimitPointList_ = emptyIntList();
            this.notInteractDungeonEntryList_ = emptyIntList();
            this.toBeExploreDungeonEntryList_ = emptyIntList();
            this.notExploredDungeonEntryList_ = emptyIntList();
            this.unlockedPointList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetScenePointRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:231:0x04d6 */
        private GetScenePointRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    if ((mutable_bitField0_ & 16) == 0) {
                                        this.groupUnlimitPointList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                    }
                                    this.groupUnlimitPointList_.addInt(input.readUInt32());
                                    break;
                                case 10:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 16) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.groupUnlimitPointList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.groupUnlimitPointList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 16:
                                    if ((mutable_bitField0_ & 256) == 0) {
                                        this.unlockedPointList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 256) == 1 ? 1 : 0;
                                    }
                                    this.unlockedPointList_.addInt(input.readUInt32());
                                    break;
                                case 18:
                                    int limit2 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 256) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.unlockedPointList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 256) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.unlockedPointList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit2);
                                    break;
                                case 24:
                                    if ((mutable_bitField0_ & 4) == 0) {
                                        this.unhidePointList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    this.unhidePointList_.addInt(input.readUInt32());
                                    break;
                                case 26:
                                    int limit3 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.unhidePointList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.unhidePointList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit3);
                                    break;
                                case 48:
                                    if ((mutable_bitField0_ & 64) == 0) {
                                        this.toBeExploreDungeonEntryList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                    }
                                    this.toBeExploreDungeonEntryList_.addInt(input.readUInt32());
                                    break;
                                case 50:
                                    int limit4 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 64) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.toBeExploreDungeonEntryList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 64) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.toBeExploreDungeonEntryList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit4);
                                    break;
                                case 56:
                                    if ((mutable_bitField0_ & 128) == 0) {
                                        this.notExploredDungeonEntryList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 128) == 1 ? 1 : 0;
                                    }
                                    this.notExploredDungeonEntryList_.addInt(input.readUInt32());
                                    break;
                                case 58:
                                    int limit5 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 128) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.notExploredDungeonEntryList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 128) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.notExploredDungeonEntryList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit5);
                                    break;
                                case 64:
                                    this.sceneId_ = input.readUInt32();
                                    break;
                                case 72:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.unlockAreaList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.unlockAreaList_.addInt(input.readUInt32());
                                    break;
                                case 74:
                                    int limit6 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.unlockAreaList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.unlockAreaList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit6);
                                    break;
                                case 80:
                                    if ((mutable_bitField0_ & 8) == 0) {
                                        this.hidePointList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                    }
                                    this.hidePointList_.addInt(input.readUInt32());
                                    break;
                                case 82:
                                    int limit7 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 8) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.hidePointList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.hidePointList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit7);
                                    break;
                                case 88:
                                    if ((mutable_bitField0_ & 32) == 0) {
                                        this.notInteractDungeonEntryList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                    }
                                    this.notInteractDungeonEntryList_.addInt(input.readUInt32());
                                    break;
                                case 90:
                                    int limit8 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 32) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.notInteractDungeonEntryList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 32) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.notInteractDungeonEntryList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit8);
                                    break;
                                case 96:
                                    this.belongUid_ = input.readUInt32();
                                    break;
                                case 104:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 120:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.lockedPointList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.lockedPointList_.addInt(input.readUInt32());
                                    break;
                                case 122:
                                    int limit9 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.lockedPointList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.lockedPointList_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit9);
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
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 16) != 0) {
                    this.groupUnlimitPointList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 256) != 0) {
                    this.unlockedPointList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.unhidePointList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 64) != 0) {
                    this.toBeExploreDungeonEntryList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 128) != 0) {
                    this.notExploredDungeonEntryList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.unlockAreaList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.hidePointList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 32) != 0) {
                    this.notInteractDungeonEntryList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.lockedPointList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetScenePointRspOuterClass.internal_static_GetScenePointRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetScenePointRspOuterClass.internal_static_GetScenePointRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetScenePointRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public List<Integer> getUnlockAreaListList() {
            return this.unlockAreaList_;
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getUnlockAreaListCount() {
            return this.unlockAreaList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getUnlockAreaList(int index) {
            return this.unlockAreaList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public List<Integer> getLockedPointListList() {
            return this.lockedPointList_;
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getLockedPointListCount() {
            return this.lockedPointList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getLockedPointList(int index) {
            return this.lockedPointList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public List<Integer> getUnhidePointListList() {
            return this.unhidePointList_;
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getUnhidePointListCount() {
            return this.unhidePointList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getUnhidePointList(int index) {
            return this.unhidePointList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public List<Integer> getHidePointListList() {
            return this.hidePointList_;
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getHidePointListCount() {
            return this.hidePointList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getHidePointList(int index) {
            return this.hidePointList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public List<Integer> getGroupUnlimitPointListList() {
            return this.groupUnlimitPointList_;
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getGroupUnlimitPointListCount() {
            return this.groupUnlimitPointList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getGroupUnlimitPointList(int index) {
            return this.groupUnlimitPointList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public List<Integer> getNotInteractDungeonEntryListList() {
            return this.notInteractDungeonEntryList_;
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getNotInteractDungeonEntryListCount() {
            return this.notInteractDungeonEntryList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getNotInteractDungeonEntryList(int index) {
            return this.notInteractDungeonEntryList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public List<Integer> getToBeExploreDungeonEntryListList() {
            return this.toBeExploreDungeonEntryList_;
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getToBeExploreDungeonEntryListCount() {
            return this.toBeExploreDungeonEntryList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getToBeExploreDungeonEntryList(int index) {
            return this.toBeExploreDungeonEntryList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public List<Integer> getNotExploredDungeonEntryListList() {
            return this.notExploredDungeonEntryList_;
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getNotExploredDungeonEntryListCount() {
            return this.notExploredDungeonEntryList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getNotExploredDungeonEntryList(int index) {
            return this.notExploredDungeonEntryList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getBelongUid() {
            return this.belongUid_;
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public List<Integer> getUnlockedPointListList() {
            return this.unlockedPointList_;
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getUnlockedPointListCount() {
            return this.unlockedPointList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getUnlockedPointList(int index) {
            return this.unlockedPointList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
        public int getSceneId() {
            return this.sceneId_;
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
            if (getGroupUnlimitPointListList().size() > 0) {
                output.writeUInt32NoTag(10);
                output.writeUInt32NoTag(this.groupUnlimitPointListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.groupUnlimitPointList_.size(); i++) {
                output.writeUInt32NoTag(this.groupUnlimitPointList_.getInt(i));
            }
            if (getUnlockedPointListList().size() > 0) {
                output.writeUInt32NoTag(18);
                output.writeUInt32NoTag(this.unlockedPointListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unlockedPointList_.size(); i2++) {
                output.writeUInt32NoTag(this.unlockedPointList_.getInt(i2));
            }
            if (getUnhidePointListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.unhidePointListMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.unhidePointList_.size(); i3++) {
                output.writeUInt32NoTag(this.unhidePointList_.getInt(i3));
            }
            if (getToBeExploreDungeonEntryListList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.toBeExploreDungeonEntryListMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.toBeExploreDungeonEntryList_.size(); i4++) {
                output.writeUInt32NoTag(this.toBeExploreDungeonEntryList_.getInt(i4));
            }
            if (getNotExploredDungeonEntryListList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.notExploredDungeonEntryListMemoizedSerializedSize);
            }
            for (int i5 = 0; i5 < this.notExploredDungeonEntryList_.size(); i5++) {
                output.writeUInt32NoTag(this.notExploredDungeonEntryList_.getInt(i5));
            }
            if (this.sceneId_ != 0) {
                output.writeUInt32(8, this.sceneId_);
            }
            if (getUnlockAreaListList().size() > 0) {
                output.writeUInt32NoTag(74);
                output.writeUInt32NoTag(this.unlockAreaListMemoizedSerializedSize);
            }
            for (int i6 = 0; i6 < this.unlockAreaList_.size(); i6++) {
                output.writeUInt32NoTag(this.unlockAreaList_.getInt(i6));
            }
            if (getHidePointListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.hidePointListMemoizedSerializedSize);
            }
            for (int i7 = 0; i7 < this.hidePointList_.size(); i7++) {
                output.writeUInt32NoTag(this.hidePointList_.getInt(i7));
            }
            if (getNotInteractDungeonEntryListList().size() > 0) {
                output.writeUInt32NoTag(90);
                output.writeUInt32NoTag(this.notInteractDungeonEntryListMemoizedSerializedSize);
            }
            for (int i8 = 0; i8 < this.notInteractDungeonEntryList_.size(); i8++) {
                output.writeUInt32NoTag(this.notInteractDungeonEntryList_.getInt(i8));
            }
            if (this.belongUid_ != 0) {
                output.writeUInt32(12, this.belongUid_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(13, this.retcode_);
            }
            if (getLockedPointListList().size() > 0) {
                output.writeUInt32NoTag(122);
                output.writeUInt32NoTag(this.lockedPointListMemoizedSerializedSize);
            }
            for (int i9 = 0; i9 < this.lockedPointList_.size(); i9++) {
                output.writeUInt32NoTag(this.lockedPointList_.getInt(i9));
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
            for (int i = 0; i < this.groupUnlimitPointList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.groupUnlimitPointList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getGroupUnlimitPointListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.groupUnlimitPointListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.unlockedPointList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unlockedPointList_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getUnlockedPointListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unlockedPointListMemoizedSerializedSize = dataSize2;
            int dataSize3 = 0;
            for (int i3 = 0; i3 < this.unhidePointList_.size(); i3++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.unhidePointList_.getInt(i3));
            }
            int size4 = size3 + dataSize3;
            if (!getUnhidePointListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.unhidePointListMemoizedSerializedSize = dataSize3;
            int dataSize4 = 0;
            for (int i4 = 0; i4 < this.toBeExploreDungeonEntryList_.size(); i4++) {
                dataSize4 += CodedOutputStream.computeUInt32SizeNoTag(this.toBeExploreDungeonEntryList_.getInt(i4));
            }
            int size5 = size4 + dataSize4;
            if (!getToBeExploreDungeonEntryListList().isEmpty()) {
                size5 = size5 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize4);
            }
            this.toBeExploreDungeonEntryListMemoizedSerializedSize = dataSize4;
            int dataSize5 = 0;
            for (int i5 = 0; i5 < this.notExploredDungeonEntryList_.size(); i5++) {
                dataSize5 += CodedOutputStream.computeUInt32SizeNoTag(this.notExploredDungeonEntryList_.getInt(i5));
            }
            int size6 = size5 + dataSize5;
            if (!getNotExploredDungeonEntryListList().isEmpty()) {
                size6 = size6 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize5);
            }
            this.notExploredDungeonEntryListMemoizedSerializedSize = dataSize5;
            if (this.sceneId_ != 0) {
                size6 += CodedOutputStream.computeUInt32Size(8, this.sceneId_);
            }
            int dataSize6 = 0;
            for (int i6 = 0; i6 < this.unlockAreaList_.size(); i6++) {
                dataSize6 += CodedOutputStream.computeUInt32SizeNoTag(this.unlockAreaList_.getInt(i6));
            }
            int size7 = size6 + dataSize6;
            if (!getUnlockAreaListList().isEmpty()) {
                size7 = size7 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize6);
            }
            this.unlockAreaListMemoizedSerializedSize = dataSize6;
            int dataSize7 = 0;
            for (int i7 = 0; i7 < this.hidePointList_.size(); i7++) {
                dataSize7 += CodedOutputStream.computeUInt32SizeNoTag(this.hidePointList_.getInt(i7));
            }
            int size8 = size7 + dataSize7;
            if (!getHidePointListList().isEmpty()) {
                size8 = size8 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize7);
            }
            this.hidePointListMemoizedSerializedSize = dataSize7;
            int dataSize8 = 0;
            for (int i8 = 0; i8 < this.notInteractDungeonEntryList_.size(); i8++) {
                dataSize8 += CodedOutputStream.computeUInt32SizeNoTag(this.notInteractDungeonEntryList_.getInt(i8));
            }
            int size9 = size8 + dataSize8;
            if (!getNotInteractDungeonEntryListList().isEmpty()) {
                size9 = size9 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize8);
            }
            this.notInteractDungeonEntryListMemoizedSerializedSize = dataSize8;
            if (this.belongUid_ != 0) {
                size9 += CodedOutputStream.computeUInt32Size(12, this.belongUid_);
            }
            if (this.retcode_ != 0) {
                size9 += CodedOutputStream.computeInt32Size(13, this.retcode_);
            }
            int dataSize9 = 0;
            for (int i9 = 0; i9 < this.lockedPointList_.size(); i9++) {
                dataSize9 += CodedOutputStream.computeUInt32SizeNoTag(this.lockedPointList_.getInt(i9));
            }
            int size10 = size9 + dataSize9;
            if (!getLockedPointListList().isEmpty()) {
                size10 = size10 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize9);
            }
            this.lockedPointListMemoizedSerializedSize = dataSize9;
            int size11 = size10 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size11;
            return size11;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GetScenePointRsp)) {
                return equals(obj);
            }
            GetScenePointRsp other = (GetScenePointRsp) obj;
            return getUnlockAreaListList().equals(other.getUnlockAreaListList()) && getLockedPointListList().equals(other.getLockedPointListList()) && getRetcode() == other.getRetcode() && getUnhidePointListList().equals(other.getUnhidePointListList()) && getHidePointListList().equals(other.getHidePointListList()) && getGroupUnlimitPointListList().equals(other.getGroupUnlimitPointListList()) && getNotInteractDungeonEntryListList().equals(other.getNotInteractDungeonEntryListList()) && getToBeExploreDungeonEntryListList().equals(other.getToBeExploreDungeonEntryListList()) && getNotExploredDungeonEntryListList().equals(other.getNotExploredDungeonEntryListList()) && getBelongUid() == other.getBelongUid() && getUnlockedPointListList().equals(other.getUnlockedPointListList()) && getSceneId() == other.getSceneId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getUnlockAreaListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getUnlockAreaListList().hashCode();
            }
            if (getLockedPointListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getLockedPointListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 13)) + getRetcode();
            if (getUnhidePointListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 3)) + getUnhidePointListList().hashCode();
            }
            if (getHidePointListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 10)) + getHidePointListList().hashCode();
            }
            if (getGroupUnlimitPointListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 1)) + getGroupUnlimitPointListList().hashCode();
            }
            if (getNotInteractDungeonEntryListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 11)) + getNotInteractDungeonEntryListList().hashCode();
            }
            if (getToBeExploreDungeonEntryListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 6)) + getToBeExploreDungeonEntryListList().hashCode();
            }
            if (getNotExploredDungeonEntryListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 7)) + getNotExploredDungeonEntryListList().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 12)) + getBelongUid();
            if (getUnlockedPointListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 2)) + getUnlockedPointListList().hashCode();
            }
            int hash4 = (29 * ((53 * ((37 * hash3) + 8)) + getSceneId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static GetScenePointRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetScenePointRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetScenePointRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetScenePointRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetScenePointRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetScenePointRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetScenePointRsp parseFrom(InputStream input) throws IOException {
            return (GetScenePointRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetScenePointRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetScenePointRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetScenePointRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetScenePointRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetScenePointRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetScenePointRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetScenePointRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetScenePointRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetScenePointRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetScenePointRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetScenePointRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetScenePointRspOuterClass$GetScenePointRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetScenePointRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private int belongUid_;
            private int sceneId_;
            private Internal.IntList unlockAreaList_ = GetScenePointRsp.emptyIntList();
            private Internal.IntList lockedPointList_ = GetScenePointRsp.emptyIntList();
            private Internal.IntList unhidePointList_ = GetScenePointRsp.emptyIntList();
            private Internal.IntList hidePointList_ = GetScenePointRsp.emptyIntList();
            private Internal.IntList groupUnlimitPointList_ = GetScenePointRsp.emptyIntList();
            private Internal.IntList notInteractDungeonEntryList_ = GetScenePointRsp.emptyIntList();
            private Internal.IntList toBeExploreDungeonEntryList_ = GetScenePointRsp.emptyIntList();
            private Internal.IntList notExploredDungeonEntryList_ = GetScenePointRsp.emptyIntList();
            private Internal.IntList unlockedPointList_ = GetScenePointRsp.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return GetScenePointRspOuterClass.internal_static_GetScenePointRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetScenePointRspOuterClass.internal_static_GetScenePointRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetScenePointRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetScenePointRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unlockAreaList_ = GetScenePointRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.lockedPointList_ = GetScenePointRsp.emptyIntList();
                this.bitField0_ &= -3;
                this.retcode_ = 0;
                this.unhidePointList_ = GetScenePointRsp.emptyIntList();
                this.bitField0_ &= -5;
                this.hidePointList_ = GetScenePointRsp.emptyIntList();
                this.bitField0_ &= -9;
                this.groupUnlimitPointList_ = GetScenePointRsp.emptyIntList();
                this.bitField0_ &= -17;
                this.notInteractDungeonEntryList_ = GetScenePointRsp.emptyIntList();
                this.bitField0_ &= -33;
                this.toBeExploreDungeonEntryList_ = GetScenePointRsp.emptyIntList();
                this.bitField0_ &= -65;
                this.notExploredDungeonEntryList_ = GetScenePointRsp.emptyIntList();
                this.bitField0_ &= -129;
                this.belongUid_ = 0;
                this.unlockedPointList_ = GetScenePointRsp.emptyIntList();
                this.bitField0_ &= -257;
                this.sceneId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetScenePointRspOuterClass.internal_static_GetScenePointRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetScenePointRsp getDefaultInstanceForType() {
                return GetScenePointRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetScenePointRsp build() {
                GetScenePointRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetScenePointRsp buildPartial() {
                GetScenePointRsp result = new GetScenePointRsp(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.unlockAreaList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.unlockAreaList_ = this.unlockAreaList_;
                if ((this.bitField0_ & 2) != 0) {
                    this.lockedPointList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.lockedPointList_ = this.lockedPointList_;
                result.retcode_ = this.retcode_;
                if ((this.bitField0_ & 4) != 0) {
                    this.unhidePointList_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.unhidePointList_ = this.unhidePointList_;
                if ((this.bitField0_ & 8) != 0) {
                    this.hidePointList_.makeImmutable();
                    this.bitField0_ &= -9;
                }
                result.hidePointList_ = this.hidePointList_;
                if ((this.bitField0_ & 16) != 0) {
                    this.groupUnlimitPointList_.makeImmutable();
                    this.bitField0_ &= -17;
                }
                result.groupUnlimitPointList_ = this.groupUnlimitPointList_;
                if ((this.bitField0_ & 32) != 0) {
                    this.notInteractDungeonEntryList_.makeImmutable();
                    this.bitField0_ &= -33;
                }
                result.notInteractDungeonEntryList_ = this.notInteractDungeonEntryList_;
                if ((this.bitField0_ & 64) != 0) {
                    this.toBeExploreDungeonEntryList_.makeImmutable();
                    this.bitField0_ &= -65;
                }
                result.toBeExploreDungeonEntryList_ = this.toBeExploreDungeonEntryList_;
                if ((this.bitField0_ & 128) != 0) {
                    this.notExploredDungeonEntryList_.makeImmutable();
                    this.bitField0_ &= -129;
                }
                result.notExploredDungeonEntryList_ = this.notExploredDungeonEntryList_;
                result.belongUid_ = this.belongUid_;
                if ((this.bitField0_ & 256) != 0) {
                    this.unlockedPointList_.makeImmutable();
                    this.bitField0_ &= -257;
                }
                result.unlockedPointList_ = this.unlockedPointList_;
                result.sceneId_ = this.sceneId_;
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
                if (other instanceof GetScenePointRsp) {
                    return mergeFrom((GetScenePointRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetScenePointRsp other) {
                if (other == GetScenePointRsp.getDefaultInstance()) {
                    return this;
                }
                if (!other.unlockAreaList_.isEmpty()) {
                    if (this.unlockAreaList_.isEmpty()) {
                        this.unlockAreaList_ = other.unlockAreaList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUnlockAreaListIsMutable();
                        this.unlockAreaList_.addAll(other.unlockAreaList_);
                    }
                    onChanged();
                }
                if (!other.lockedPointList_.isEmpty()) {
                    if (this.lockedPointList_.isEmpty()) {
                        this.lockedPointList_ = other.lockedPointList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureLockedPointListIsMutable();
                        this.lockedPointList_.addAll(other.lockedPointList_);
                    }
                    onChanged();
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (!other.unhidePointList_.isEmpty()) {
                    if (this.unhidePointList_.isEmpty()) {
                        this.unhidePointList_ = other.unhidePointList_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureUnhidePointListIsMutable();
                        this.unhidePointList_.addAll(other.unhidePointList_);
                    }
                    onChanged();
                }
                if (!other.hidePointList_.isEmpty()) {
                    if (this.hidePointList_.isEmpty()) {
                        this.hidePointList_ = other.hidePointList_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureHidePointListIsMutable();
                        this.hidePointList_.addAll(other.hidePointList_);
                    }
                    onChanged();
                }
                if (!other.groupUnlimitPointList_.isEmpty()) {
                    if (this.groupUnlimitPointList_.isEmpty()) {
                        this.groupUnlimitPointList_ = other.groupUnlimitPointList_;
                        this.bitField0_ &= -17;
                    } else {
                        ensureGroupUnlimitPointListIsMutable();
                        this.groupUnlimitPointList_.addAll(other.groupUnlimitPointList_);
                    }
                    onChanged();
                }
                if (!other.notInteractDungeonEntryList_.isEmpty()) {
                    if (this.notInteractDungeonEntryList_.isEmpty()) {
                        this.notInteractDungeonEntryList_ = other.notInteractDungeonEntryList_;
                        this.bitField0_ &= -33;
                    } else {
                        ensureNotInteractDungeonEntryListIsMutable();
                        this.notInteractDungeonEntryList_.addAll(other.notInteractDungeonEntryList_);
                    }
                    onChanged();
                }
                if (!other.toBeExploreDungeonEntryList_.isEmpty()) {
                    if (this.toBeExploreDungeonEntryList_.isEmpty()) {
                        this.toBeExploreDungeonEntryList_ = other.toBeExploreDungeonEntryList_;
                        this.bitField0_ &= -65;
                    } else {
                        ensureToBeExploreDungeonEntryListIsMutable();
                        this.toBeExploreDungeonEntryList_.addAll(other.toBeExploreDungeonEntryList_);
                    }
                    onChanged();
                }
                if (!other.notExploredDungeonEntryList_.isEmpty()) {
                    if (this.notExploredDungeonEntryList_.isEmpty()) {
                        this.notExploredDungeonEntryList_ = other.notExploredDungeonEntryList_;
                        this.bitField0_ &= -129;
                    } else {
                        ensureNotExploredDungeonEntryListIsMutable();
                        this.notExploredDungeonEntryList_.addAll(other.notExploredDungeonEntryList_);
                    }
                    onChanged();
                }
                if (other.getBelongUid() != 0) {
                    setBelongUid(other.getBelongUid());
                }
                if (!other.unlockedPointList_.isEmpty()) {
                    if (this.unlockedPointList_.isEmpty()) {
                        this.unlockedPointList_ = other.unlockedPointList_;
                        this.bitField0_ &= -257;
                    } else {
                        ensureUnlockedPointListIsMutable();
                        this.unlockedPointList_.addAll(other.unlockedPointList_);
                    }
                    onChanged();
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
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
                GetScenePointRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetScenePointRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetScenePointRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureUnlockAreaListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unlockAreaList_ = GetScenePointRsp.mutableCopy(this.unlockAreaList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public List<Integer> getUnlockAreaListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.unlockAreaList_) : this.unlockAreaList_;
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getUnlockAreaListCount() {
                return this.unlockAreaList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getUnlockAreaList(int index) {
                return this.unlockAreaList_.getInt(index);
            }

            public Builder setUnlockAreaList(int index, int value) {
                ensureUnlockAreaListIsMutable();
                this.unlockAreaList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnlockAreaList(int value) {
                ensureUnlockAreaListIsMutable();
                this.unlockAreaList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnlockAreaList(Iterable<? extends Integer> values) {
                ensureUnlockAreaListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unlockAreaList_);
                onChanged();
                return this;
            }

            public Builder clearUnlockAreaList() {
                this.unlockAreaList_ = GetScenePointRsp.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureLockedPointListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.lockedPointList_ = GetScenePointRsp.mutableCopy(this.lockedPointList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public List<Integer> getLockedPointListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.lockedPointList_) : this.lockedPointList_;
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getLockedPointListCount() {
                return this.lockedPointList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getLockedPointList(int index) {
                return this.lockedPointList_.getInt(index);
            }

            public Builder setLockedPointList(int index, int value) {
                ensureLockedPointListIsMutable();
                this.lockedPointList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addLockedPointList(int value) {
                ensureLockedPointListIsMutable();
                this.lockedPointList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllLockedPointList(Iterable<? extends Integer> values) {
                ensureLockedPointListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.lockedPointList_);
                onChanged();
                return this;
            }

            public Builder clearLockedPointList() {
                this.lockedPointList_ = GetScenePointRsp.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getRetcode() {
                return this.retcode_;
            }

            public Builder setRetcode(int value) {
                this.retcode_ = value;
                onChanged();
                return this;
            }

            public Builder clearRetcode() {
                this.retcode_ = 0;
                onChanged();
                return this;
            }

            private void ensureUnhidePointListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.unhidePointList_ = GetScenePointRsp.mutableCopy(this.unhidePointList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public List<Integer> getUnhidePointListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.unhidePointList_) : this.unhidePointList_;
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getUnhidePointListCount() {
                return this.unhidePointList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getUnhidePointList(int index) {
                return this.unhidePointList_.getInt(index);
            }

            public Builder setUnhidePointList(int index, int value) {
                ensureUnhidePointListIsMutable();
                this.unhidePointList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnhidePointList(int value) {
                ensureUnhidePointListIsMutable();
                this.unhidePointList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnhidePointList(Iterable<? extends Integer> values) {
                ensureUnhidePointListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unhidePointList_);
                onChanged();
                return this;
            }

            public Builder clearUnhidePointList() {
                this.unhidePointList_ = GetScenePointRsp.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            private void ensureHidePointListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.hidePointList_ = GetScenePointRsp.mutableCopy(this.hidePointList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public List<Integer> getHidePointListList() {
                return (this.bitField0_ & 8) != 0 ? Collections.unmodifiableList(this.hidePointList_) : this.hidePointList_;
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getHidePointListCount() {
                return this.hidePointList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getHidePointList(int index) {
                return this.hidePointList_.getInt(index);
            }

            public Builder setHidePointList(int index, int value) {
                ensureHidePointListIsMutable();
                this.hidePointList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addHidePointList(int value) {
                ensureHidePointListIsMutable();
                this.hidePointList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllHidePointList(Iterable<? extends Integer> values) {
                ensureHidePointListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.hidePointList_);
                onChanged();
                return this;
            }

            public Builder clearHidePointList() {
                this.hidePointList_ = GetScenePointRsp.emptyIntList();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            private void ensureGroupUnlimitPointListIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.groupUnlimitPointList_ = GetScenePointRsp.mutableCopy(this.groupUnlimitPointList_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public List<Integer> getGroupUnlimitPointListList() {
                return (this.bitField0_ & 16) != 0 ? Collections.unmodifiableList(this.groupUnlimitPointList_) : this.groupUnlimitPointList_;
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getGroupUnlimitPointListCount() {
                return this.groupUnlimitPointList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getGroupUnlimitPointList(int index) {
                return this.groupUnlimitPointList_.getInt(index);
            }

            public Builder setGroupUnlimitPointList(int index, int value) {
                ensureGroupUnlimitPointListIsMutable();
                this.groupUnlimitPointList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addGroupUnlimitPointList(int value) {
                ensureGroupUnlimitPointListIsMutable();
                this.groupUnlimitPointList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllGroupUnlimitPointList(Iterable<? extends Integer> values) {
                ensureGroupUnlimitPointListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.groupUnlimitPointList_);
                onChanged();
                return this;
            }

            public Builder clearGroupUnlimitPointList() {
                this.groupUnlimitPointList_ = GetScenePointRsp.emptyIntList();
                this.bitField0_ &= -17;
                onChanged();
                return this;
            }

            private void ensureNotInteractDungeonEntryListIsMutable() {
                if ((this.bitField0_ & 32) == 0) {
                    this.notInteractDungeonEntryList_ = GetScenePointRsp.mutableCopy(this.notInteractDungeonEntryList_);
                    this.bitField0_ |= 32;
                }
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public List<Integer> getNotInteractDungeonEntryListList() {
                return (this.bitField0_ & 32) != 0 ? Collections.unmodifiableList(this.notInteractDungeonEntryList_) : this.notInteractDungeonEntryList_;
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getNotInteractDungeonEntryListCount() {
                return this.notInteractDungeonEntryList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getNotInteractDungeonEntryList(int index) {
                return this.notInteractDungeonEntryList_.getInt(index);
            }

            public Builder setNotInteractDungeonEntryList(int index, int value) {
                ensureNotInteractDungeonEntryListIsMutable();
                this.notInteractDungeonEntryList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addNotInteractDungeonEntryList(int value) {
                ensureNotInteractDungeonEntryListIsMutable();
                this.notInteractDungeonEntryList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllNotInteractDungeonEntryList(Iterable<? extends Integer> values) {
                ensureNotInteractDungeonEntryListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.notInteractDungeonEntryList_);
                onChanged();
                return this;
            }

            public Builder clearNotInteractDungeonEntryList() {
                this.notInteractDungeonEntryList_ = GetScenePointRsp.emptyIntList();
                this.bitField0_ &= -33;
                onChanged();
                return this;
            }

            private void ensureToBeExploreDungeonEntryListIsMutable() {
                if ((this.bitField0_ & 64) == 0) {
                    this.toBeExploreDungeonEntryList_ = GetScenePointRsp.mutableCopy(this.toBeExploreDungeonEntryList_);
                    this.bitField0_ |= 64;
                }
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public List<Integer> getToBeExploreDungeonEntryListList() {
                return (this.bitField0_ & 64) != 0 ? Collections.unmodifiableList(this.toBeExploreDungeonEntryList_) : this.toBeExploreDungeonEntryList_;
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getToBeExploreDungeonEntryListCount() {
                return this.toBeExploreDungeonEntryList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getToBeExploreDungeonEntryList(int index) {
                return this.toBeExploreDungeonEntryList_.getInt(index);
            }

            public Builder setToBeExploreDungeonEntryList(int index, int value) {
                ensureToBeExploreDungeonEntryListIsMutable();
                this.toBeExploreDungeonEntryList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addToBeExploreDungeonEntryList(int value) {
                ensureToBeExploreDungeonEntryListIsMutable();
                this.toBeExploreDungeonEntryList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllToBeExploreDungeonEntryList(Iterable<? extends Integer> values) {
                ensureToBeExploreDungeonEntryListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.toBeExploreDungeonEntryList_);
                onChanged();
                return this;
            }

            public Builder clearToBeExploreDungeonEntryList() {
                this.toBeExploreDungeonEntryList_ = GetScenePointRsp.emptyIntList();
                this.bitField0_ &= -65;
                onChanged();
                return this;
            }

            private void ensureNotExploredDungeonEntryListIsMutable() {
                if ((this.bitField0_ & 128) == 0) {
                    this.notExploredDungeonEntryList_ = GetScenePointRsp.mutableCopy(this.notExploredDungeonEntryList_);
                    this.bitField0_ |= 128;
                }
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public List<Integer> getNotExploredDungeonEntryListList() {
                return (this.bitField0_ & 128) != 0 ? Collections.unmodifiableList(this.notExploredDungeonEntryList_) : this.notExploredDungeonEntryList_;
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getNotExploredDungeonEntryListCount() {
                return this.notExploredDungeonEntryList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getNotExploredDungeonEntryList(int index) {
                return this.notExploredDungeonEntryList_.getInt(index);
            }

            public Builder setNotExploredDungeonEntryList(int index, int value) {
                ensureNotExploredDungeonEntryListIsMutable();
                this.notExploredDungeonEntryList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addNotExploredDungeonEntryList(int value) {
                ensureNotExploredDungeonEntryListIsMutable();
                this.notExploredDungeonEntryList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllNotExploredDungeonEntryList(Iterable<? extends Integer> values) {
                ensureNotExploredDungeonEntryListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.notExploredDungeonEntryList_);
                onChanged();
                return this;
            }

            public Builder clearNotExploredDungeonEntryList() {
                this.notExploredDungeonEntryList_ = GetScenePointRsp.emptyIntList();
                this.bitField0_ &= -129;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getBelongUid() {
                return this.belongUid_;
            }

            public Builder setBelongUid(int value) {
                this.belongUid_ = value;
                onChanged();
                return this;
            }

            public Builder clearBelongUid() {
                this.belongUid_ = 0;
                onChanged();
                return this;
            }

            private void ensureUnlockedPointListIsMutable() {
                if ((this.bitField0_ & 256) == 0) {
                    this.unlockedPointList_ = GetScenePointRsp.mutableCopy(this.unlockedPointList_);
                    this.bitField0_ |= 256;
                }
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public List<Integer> getUnlockedPointListList() {
                return (this.bitField0_ & 256) != 0 ? Collections.unmodifiableList(this.unlockedPointList_) : this.unlockedPointList_;
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getUnlockedPointListCount() {
                return this.unlockedPointList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getUnlockedPointList(int index) {
                return this.unlockedPointList_.getInt(index);
            }

            public Builder setUnlockedPointList(int index, int value) {
                ensureUnlockedPointListIsMutable();
                this.unlockedPointList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnlockedPointList(int value) {
                ensureUnlockedPointListIsMutable();
                this.unlockedPointList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnlockedPointList(Iterable<? extends Integer> values) {
                ensureUnlockedPointListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unlockedPointList_);
                onChanged();
                return this;
            }

            public Builder clearUnlockedPointList() {
                this.unlockedPointList_ = GetScenePointRsp.emptyIntList();
                this.bitField0_ &= -257;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetScenePointRspOuterClass.GetScenePointRspOrBuilder
            public int getSceneId() {
                return this.sceneId_;
            }

            public Builder setSceneId(int value) {
                this.sceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneId() {
                this.sceneId_ = 0;
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

        public static GetScenePointRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetScenePointRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetScenePointRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetScenePointRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
