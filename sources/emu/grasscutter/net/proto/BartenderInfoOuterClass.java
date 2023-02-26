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
import emu.grasscutter.net.proto.BartenderLevelInfoOuterClass;
import emu.grasscutter.net.proto.BartenderTaskInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BartenderInfoOuterClass.class */
public final class BartenderInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013BartenderInfo.proto\u001a\u0017BartenderTaskInfo.proto\u001a\u0018BartenderLevelInfo.proto\"Ï\u0001\n\rBartenderInfo\u0012*\n\u000eunlockTaskList\u0018\u000f \u0003(\u000b2\u0012.BartenderTaskInfo\u0012\u001b\n\u0013isDevelopModuleOpen\u0018\n \u0001(\b\u0012\u0016\n\u000eunlockItemList\u0018\b \u0003(\r\u0012\u0019\n\u0011unlockFormulaList\u0018\u000e \u0003(\r\u0012\u0014\n\fleftMonsters\u0018\u0002 \u0001(\b\u0012,\n\u000funlockLevelList\u0018\u0004 \u0003(\u000b2\u0013.BartenderLevelInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BartenderTaskInfoOuterClass.getDescriptor(), BartenderLevelInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BartenderInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BartenderInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BartenderInfo_descriptor, new String[]{"UnlockTaskList", "IsDevelopModuleOpen", "UnlockItemList", "UnlockFormulaList", "LeftMonsters", "UnlockLevelList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BartenderInfoOuterClass$BartenderInfoOrBuilder.class */
    public interface BartenderInfoOrBuilder extends MessageOrBuilder {
        List<BartenderTaskInfoOuterClass.BartenderTaskInfo> getUnlockTaskListList();

        BartenderTaskInfoOuterClass.BartenderTaskInfo getUnlockTaskList(int i);

        int getUnlockTaskListCount();

        List<? extends BartenderTaskInfoOuterClass.BartenderTaskInfoOrBuilder> getUnlockTaskListOrBuilderList();

        BartenderTaskInfoOuterClass.BartenderTaskInfoOrBuilder getUnlockTaskListOrBuilder(int i);

        boolean getIsDevelopModuleOpen();

        List<Integer> getUnlockItemListList();

        int getUnlockItemListCount();

        int getUnlockItemList(int i);

        List<Integer> getUnlockFormulaListList();

        int getUnlockFormulaListCount();

        int getUnlockFormulaList(int i);

        boolean getLeftMonsters();

        List<BartenderLevelInfoOuterClass.BartenderLevelInfo> getUnlockLevelListList();

        BartenderLevelInfoOuterClass.BartenderLevelInfo getUnlockLevelList(int i);

        int getUnlockLevelListCount();

        List<? extends BartenderLevelInfoOuterClass.BartenderLevelInfoOrBuilder> getUnlockLevelListOrBuilderList();

        BartenderLevelInfoOuterClass.BartenderLevelInfoOrBuilder getUnlockLevelListOrBuilder(int i);
    }

    private BartenderInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BartenderInfoOuterClass$BartenderInfo.class */
    public static final class BartenderInfo extends GeneratedMessageV3 implements BartenderInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNLOCKTASKLIST_FIELD_NUMBER = 15;
        private List<BartenderTaskInfoOuterClass.BartenderTaskInfo> unlockTaskList_;
        public static final int ISDEVELOPMODULEOPEN_FIELD_NUMBER = 10;
        private boolean isDevelopModuleOpen_;
        public static final int UNLOCKITEMLIST_FIELD_NUMBER = 8;
        private Internal.IntList unlockItemList_;
        private int unlockItemListMemoizedSerializedSize;
        public static final int UNLOCKFORMULALIST_FIELD_NUMBER = 14;
        private Internal.IntList unlockFormulaList_;
        private int unlockFormulaListMemoizedSerializedSize;
        public static final int LEFTMONSTERS_FIELD_NUMBER = 2;
        private boolean leftMonsters_;
        public static final int UNLOCKLEVELLIST_FIELD_NUMBER = 4;
        private List<BartenderLevelInfoOuterClass.BartenderLevelInfo> unlockLevelList_;
        private byte memoizedIsInitialized;
        private static final BartenderInfo DEFAULT_INSTANCE = new BartenderInfo();
        private static final Parser<BartenderInfo> PARSER = new AbstractParser<BartenderInfo>() { // from class: emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfo.1
            @Override // com.google.protobuf.Parser
            public BartenderInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BartenderInfo(input, extensionRegistry);
            }
        };

        private BartenderInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unlockItemListMemoizedSerializedSize = -1;
            this.unlockFormulaListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private BartenderInfo() {
            this.unlockItemListMemoizedSerializedSize = -1;
            this.unlockFormulaListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unlockTaskList_ = Collections.emptyList();
            this.unlockItemList_ = emptyIntList();
            this.unlockFormulaList_ = emptyIntList();
            this.unlockLevelList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BartenderInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:104:0x01ce */
        private BartenderInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.leftMonsters_ = input.readBool();
                                break;
                            case 34:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.unlockLevelList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.unlockLevelList_.add((BartenderLevelInfoOuterClass.BartenderLevelInfo) input.readMessage(BartenderLevelInfoOuterClass.BartenderLevelInfo.parser(), extensionRegistry));
                                break;
                            case 64:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unlockItemList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.unlockItemList_.addInt(input.readUInt32());
                                break;
                            case 66:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unlockItemList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unlockItemList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 80:
                                this.isDevelopModuleOpen_ = input.readBool();
                                break;
                            case 112:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.unlockFormulaList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.unlockFormulaList_.addInt(input.readUInt32());
                                break;
                            case 114:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unlockFormulaList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unlockFormulaList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 122:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.unlockTaskList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.unlockTaskList_.add((BartenderTaskInfoOuterClass.BartenderTaskInfo) input.readMessage(BartenderTaskInfoOuterClass.BartenderTaskInfo.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 8) != 0) {
                    this.unlockLevelList_ = Collections.unmodifiableList(this.unlockLevelList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unlockItemList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.unlockFormulaList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.unlockTaskList_ = Collections.unmodifiableList(this.unlockTaskList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BartenderInfoOuterClass.internal_static_BartenderInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BartenderInfoOuterClass.internal_static_BartenderInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BartenderInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
        public List<BartenderTaskInfoOuterClass.BartenderTaskInfo> getUnlockTaskListList() {
            return this.unlockTaskList_;
        }

        @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
        public List<? extends BartenderTaskInfoOuterClass.BartenderTaskInfoOrBuilder> getUnlockTaskListOrBuilderList() {
            return this.unlockTaskList_;
        }

        @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
        public int getUnlockTaskListCount() {
            return this.unlockTaskList_.size();
        }

        @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
        public BartenderTaskInfoOuterClass.BartenderTaskInfo getUnlockTaskList(int index) {
            return this.unlockTaskList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
        public BartenderTaskInfoOuterClass.BartenderTaskInfoOrBuilder getUnlockTaskListOrBuilder(int index) {
            return this.unlockTaskList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
        public boolean getIsDevelopModuleOpen() {
            return this.isDevelopModuleOpen_;
        }

        @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
        public List<Integer> getUnlockItemListList() {
            return this.unlockItemList_;
        }

        @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
        public int getUnlockItemListCount() {
            return this.unlockItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
        public int getUnlockItemList(int index) {
            return this.unlockItemList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
        public List<Integer> getUnlockFormulaListList() {
            return this.unlockFormulaList_;
        }

        @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
        public int getUnlockFormulaListCount() {
            return this.unlockFormulaList_.size();
        }

        @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
        public int getUnlockFormulaList(int index) {
            return this.unlockFormulaList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
        public boolean getLeftMonsters() {
            return this.leftMonsters_;
        }

        @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
        public List<BartenderLevelInfoOuterClass.BartenderLevelInfo> getUnlockLevelListList() {
            return this.unlockLevelList_;
        }

        @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
        public List<? extends BartenderLevelInfoOuterClass.BartenderLevelInfoOrBuilder> getUnlockLevelListOrBuilderList() {
            return this.unlockLevelList_;
        }

        @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
        public int getUnlockLevelListCount() {
            return this.unlockLevelList_.size();
        }

        @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
        public BartenderLevelInfoOuterClass.BartenderLevelInfo getUnlockLevelList(int index) {
            return this.unlockLevelList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
        public BartenderLevelInfoOuterClass.BartenderLevelInfoOrBuilder getUnlockLevelListOrBuilder(int index) {
            return this.unlockLevelList_.get(index);
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
            if (this.leftMonsters_) {
                output.writeBool(2, this.leftMonsters_);
            }
            for (int i = 0; i < this.unlockLevelList_.size(); i++) {
                output.writeMessage(4, this.unlockLevelList_.get(i));
            }
            if (getUnlockItemListList().size() > 0) {
                output.writeUInt32NoTag(66);
                output.writeUInt32NoTag(this.unlockItemListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unlockItemList_.size(); i2++) {
                output.writeUInt32NoTag(this.unlockItemList_.getInt(i2));
            }
            if (this.isDevelopModuleOpen_) {
                output.writeBool(10, this.isDevelopModuleOpen_);
            }
            if (getUnlockFormulaListList().size() > 0) {
                output.writeUInt32NoTag(114);
                output.writeUInt32NoTag(this.unlockFormulaListMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.unlockFormulaList_.size(); i3++) {
                output.writeUInt32NoTag(this.unlockFormulaList_.getInt(i3));
            }
            for (int i4 = 0; i4 < this.unlockTaskList_.size(); i4++) {
                output.writeMessage(15, this.unlockTaskList_.get(i4));
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
                size2 = 0 + CodedOutputStream.computeBoolSize(2, this.leftMonsters_);
            }
            for (int i = 0; i < this.unlockLevelList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.unlockLevelList_.get(i));
            }
            int dataSize = 0;
            for (int i2 = 0; i2 < this.unlockItemList_.size(); i2++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unlockItemList_.getInt(i2));
            }
            int size3 = size2 + dataSize;
            if (!getUnlockItemListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unlockItemListMemoizedSerializedSize = dataSize;
            if (this.isDevelopModuleOpen_) {
                size3 += CodedOutputStream.computeBoolSize(10, this.isDevelopModuleOpen_);
            }
            int dataSize2 = 0;
            for (int i3 = 0; i3 < this.unlockFormulaList_.size(); i3++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unlockFormulaList_.getInt(i3));
            }
            int size4 = size3 + dataSize2;
            if (!getUnlockFormulaListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unlockFormulaListMemoizedSerializedSize = dataSize2;
            for (int i4 = 0; i4 < this.unlockTaskList_.size(); i4++) {
                size4 += CodedOutputStream.computeMessageSize(15, this.unlockTaskList_.get(i4));
            }
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof BartenderInfo)) {
                return equals(obj);
            }
            BartenderInfo other = (BartenderInfo) obj;
            return getUnlockTaskListList().equals(other.getUnlockTaskListList()) && getIsDevelopModuleOpen() == other.getIsDevelopModuleOpen() && getUnlockItemListList().equals(other.getUnlockItemListList()) && getUnlockFormulaListList().equals(other.getUnlockFormulaListList()) && getLeftMonsters() == other.getLeftMonsters() && getUnlockLevelListList().equals(other.getUnlockLevelListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getUnlockTaskListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getUnlockTaskListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 10)) + Internal.hashBoolean(getIsDevelopModuleOpen());
            if (getUnlockItemListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 8)) + getUnlockItemListList().hashCode();
            }
            if (getUnlockFormulaListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 14)) + getUnlockFormulaListList().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 2)) + Internal.hashBoolean(getLeftMonsters());
            if (getUnlockLevelListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 4)) + getUnlockLevelListList().hashCode();
            }
            int hash4 = (29 * hash3) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static BartenderInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BartenderInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BartenderInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BartenderInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BartenderInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BartenderInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BartenderInfo parseFrom(InputStream input) throws IOException {
            return (BartenderInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BartenderInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BartenderInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BartenderInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BartenderInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BartenderInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BartenderInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BartenderInfo parseFrom(CodedInputStream input) throws IOException {
            return (BartenderInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BartenderInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BartenderInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BartenderInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BartenderInfoOuterClass$BartenderInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BartenderInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<BartenderTaskInfoOuterClass.BartenderTaskInfo, BartenderTaskInfoOuterClass.BartenderTaskInfo.Builder, BartenderTaskInfoOuterClass.BartenderTaskInfoOrBuilder> unlockTaskListBuilder_;
            private boolean isDevelopModuleOpen_;
            private boolean leftMonsters_;
            private RepeatedFieldBuilderV3<BartenderLevelInfoOuterClass.BartenderLevelInfo, BartenderLevelInfoOuterClass.BartenderLevelInfo.Builder, BartenderLevelInfoOuterClass.BartenderLevelInfoOrBuilder> unlockLevelListBuilder_;
            private List<BartenderTaskInfoOuterClass.BartenderTaskInfo> unlockTaskList_ = Collections.emptyList();
            private Internal.IntList unlockItemList_ = BartenderInfo.emptyIntList();
            private Internal.IntList unlockFormulaList_ = BartenderInfo.emptyIntList();
            private List<BartenderLevelInfoOuterClass.BartenderLevelInfo> unlockLevelList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return BartenderInfoOuterClass.internal_static_BartenderInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BartenderInfoOuterClass.internal_static_BartenderInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BartenderInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BartenderInfo.alwaysUseFieldBuilders) {
                    getUnlockTaskListFieldBuilder();
                    getUnlockLevelListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.unlockTaskListBuilder_ == null) {
                    this.unlockTaskList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.unlockTaskListBuilder_.clear();
                }
                this.isDevelopModuleOpen_ = false;
                this.unlockItemList_ = BartenderInfo.emptyIntList();
                this.bitField0_ &= -3;
                this.unlockFormulaList_ = BartenderInfo.emptyIntList();
                this.bitField0_ &= -5;
                this.leftMonsters_ = false;
                if (this.unlockLevelListBuilder_ == null) {
                    this.unlockLevelList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.unlockLevelListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BartenderInfoOuterClass.internal_static_BartenderInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BartenderInfo getDefaultInstanceForType() {
                return BartenderInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BartenderInfo build() {
                BartenderInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BartenderInfo buildPartial() {
                BartenderInfo result = new BartenderInfo(this);
                int i = this.bitField0_;
                if (this.unlockTaskListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.unlockTaskList_ = Collections.unmodifiableList(this.unlockTaskList_);
                        this.bitField0_ &= -2;
                    }
                    result.unlockTaskList_ = this.unlockTaskList_;
                } else {
                    result.unlockTaskList_ = this.unlockTaskListBuilder_.build();
                }
                result.isDevelopModuleOpen_ = this.isDevelopModuleOpen_;
                if ((this.bitField0_ & 2) != 0) {
                    this.unlockItemList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unlockItemList_ = this.unlockItemList_;
                if ((this.bitField0_ & 4) != 0) {
                    this.unlockFormulaList_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.unlockFormulaList_ = this.unlockFormulaList_;
                result.leftMonsters_ = this.leftMonsters_;
                if (this.unlockLevelListBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.unlockLevelList_ = Collections.unmodifiableList(this.unlockLevelList_);
                        this.bitField0_ &= -9;
                    }
                    result.unlockLevelList_ = this.unlockLevelList_;
                } else {
                    result.unlockLevelList_ = this.unlockLevelListBuilder_.build();
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
                if (other instanceof BartenderInfo) {
                    return mergeFrom((BartenderInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BartenderInfo other) {
                if (other == BartenderInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.unlockTaskListBuilder_ == null) {
                    if (!other.unlockTaskList_.isEmpty()) {
                        if (this.unlockTaskList_.isEmpty()) {
                            this.unlockTaskList_ = other.unlockTaskList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureUnlockTaskListIsMutable();
                            this.unlockTaskList_.addAll(other.unlockTaskList_);
                        }
                        onChanged();
                    }
                } else if (!other.unlockTaskList_.isEmpty()) {
                    if (this.unlockTaskListBuilder_.isEmpty()) {
                        this.unlockTaskListBuilder_.dispose();
                        this.unlockTaskListBuilder_ = null;
                        this.unlockTaskList_ = other.unlockTaskList_;
                        this.bitField0_ &= -2;
                        this.unlockTaskListBuilder_ = BartenderInfo.alwaysUseFieldBuilders ? getUnlockTaskListFieldBuilder() : null;
                    } else {
                        this.unlockTaskListBuilder_.addAllMessages(other.unlockTaskList_);
                    }
                }
                if (other.getIsDevelopModuleOpen()) {
                    setIsDevelopModuleOpen(other.getIsDevelopModuleOpen());
                }
                if (!other.unlockItemList_.isEmpty()) {
                    if (this.unlockItemList_.isEmpty()) {
                        this.unlockItemList_ = other.unlockItemList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureUnlockItemListIsMutable();
                        this.unlockItemList_.addAll(other.unlockItemList_);
                    }
                    onChanged();
                }
                if (!other.unlockFormulaList_.isEmpty()) {
                    if (this.unlockFormulaList_.isEmpty()) {
                        this.unlockFormulaList_ = other.unlockFormulaList_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureUnlockFormulaListIsMutable();
                        this.unlockFormulaList_.addAll(other.unlockFormulaList_);
                    }
                    onChanged();
                }
                if (other.getLeftMonsters()) {
                    setLeftMonsters(other.getLeftMonsters());
                }
                if (this.unlockLevelListBuilder_ == null) {
                    if (!other.unlockLevelList_.isEmpty()) {
                        if (this.unlockLevelList_.isEmpty()) {
                            this.unlockLevelList_ = other.unlockLevelList_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureUnlockLevelListIsMutable();
                            this.unlockLevelList_.addAll(other.unlockLevelList_);
                        }
                        onChanged();
                    }
                } else if (!other.unlockLevelList_.isEmpty()) {
                    if (this.unlockLevelListBuilder_.isEmpty()) {
                        this.unlockLevelListBuilder_.dispose();
                        this.unlockLevelListBuilder_ = null;
                        this.unlockLevelList_ = other.unlockLevelList_;
                        this.bitField0_ &= -9;
                        this.unlockLevelListBuilder_ = BartenderInfo.alwaysUseFieldBuilders ? getUnlockLevelListFieldBuilder() : null;
                    } else {
                        this.unlockLevelListBuilder_.addAllMessages(other.unlockLevelList_);
                    }
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
                BartenderInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BartenderInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BartenderInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureUnlockTaskListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unlockTaskList_ = new ArrayList(this.unlockTaskList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
            public List<BartenderTaskInfoOuterClass.BartenderTaskInfo> getUnlockTaskListList() {
                if (this.unlockTaskListBuilder_ == null) {
                    return Collections.unmodifiableList(this.unlockTaskList_);
                }
                return this.unlockTaskListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
            public int getUnlockTaskListCount() {
                if (this.unlockTaskListBuilder_ == null) {
                    return this.unlockTaskList_.size();
                }
                return this.unlockTaskListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
            public BartenderTaskInfoOuterClass.BartenderTaskInfo getUnlockTaskList(int index) {
                if (this.unlockTaskListBuilder_ == null) {
                    return this.unlockTaskList_.get(index);
                }
                return this.unlockTaskListBuilder_.getMessage(index);
            }

            public Builder setUnlockTaskList(int index, BartenderTaskInfoOuterClass.BartenderTaskInfo value) {
                if (this.unlockTaskListBuilder_ != null) {
                    this.unlockTaskListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnlockTaskListIsMutable();
                    this.unlockTaskList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUnlockTaskList(int index, BartenderTaskInfoOuterClass.BartenderTaskInfo.Builder builderForValue) {
                if (this.unlockTaskListBuilder_ == null) {
                    ensureUnlockTaskListIsMutable();
                    this.unlockTaskList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unlockTaskListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUnlockTaskList(BartenderTaskInfoOuterClass.BartenderTaskInfo value) {
                if (this.unlockTaskListBuilder_ != null) {
                    this.unlockTaskListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnlockTaskListIsMutable();
                    this.unlockTaskList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnlockTaskList(int index, BartenderTaskInfoOuterClass.BartenderTaskInfo value) {
                if (this.unlockTaskListBuilder_ != null) {
                    this.unlockTaskListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnlockTaskListIsMutable();
                    this.unlockTaskList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnlockTaskList(BartenderTaskInfoOuterClass.BartenderTaskInfo.Builder builderForValue) {
                if (this.unlockTaskListBuilder_ == null) {
                    ensureUnlockTaskListIsMutable();
                    this.unlockTaskList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.unlockTaskListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUnlockTaskList(int index, BartenderTaskInfoOuterClass.BartenderTaskInfo.Builder builderForValue) {
                if (this.unlockTaskListBuilder_ == null) {
                    ensureUnlockTaskListIsMutable();
                    this.unlockTaskList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unlockTaskListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUnlockTaskList(Iterable<? extends BartenderTaskInfoOuterClass.BartenderTaskInfo> values) {
                if (this.unlockTaskListBuilder_ == null) {
                    ensureUnlockTaskListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unlockTaskList_);
                    onChanged();
                } else {
                    this.unlockTaskListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUnlockTaskList() {
                if (this.unlockTaskListBuilder_ == null) {
                    this.unlockTaskList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.unlockTaskListBuilder_.clear();
                }
                return this;
            }

            public Builder removeUnlockTaskList(int index) {
                if (this.unlockTaskListBuilder_ == null) {
                    ensureUnlockTaskListIsMutable();
                    this.unlockTaskList_.remove(index);
                    onChanged();
                } else {
                    this.unlockTaskListBuilder_.remove(index);
                }
                return this;
            }

            public BartenderTaskInfoOuterClass.BartenderTaskInfo.Builder getUnlockTaskListBuilder(int index) {
                return getUnlockTaskListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
            public BartenderTaskInfoOuterClass.BartenderTaskInfoOrBuilder getUnlockTaskListOrBuilder(int index) {
                if (this.unlockTaskListBuilder_ == null) {
                    return this.unlockTaskList_.get(index);
                }
                return this.unlockTaskListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
            public List<? extends BartenderTaskInfoOuterClass.BartenderTaskInfoOrBuilder> getUnlockTaskListOrBuilderList() {
                if (this.unlockTaskListBuilder_ != null) {
                    return this.unlockTaskListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.unlockTaskList_);
            }

            public BartenderTaskInfoOuterClass.BartenderTaskInfo.Builder addUnlockTaskListBuilder() {
                return getUnlockTaskListFieldBuilder().addBuilder(BartenderTaskInfoOuterClass.BartenderTaskInfo.getDefaultInstance());
            }

            public BartenderTaskInfoOuterClass.BartenderTaskInfo.Builder addUnlockTaskListBuilder(int index) {
                return getUnlockTaskListFieldBuilder().addBuilder(index, BartenderTaskInfoOuterClass.BartenderTaskInfo.getDefaultInstance());
            }

            public List<BartenderTaskInfoOuterClass.BartenderTaskInfo.Builder> getUnlockTaskListBuilderList() {
                return getUnlockTaskListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BartenderTaskInfoOuterClass.BartenderTaskInfo, BartenderTaskInfoOuterClass.BartenderTaskInfo.Builder, BartenderTaskInfoOuterClass.BartenderTaskInfoOrBuilder> getUnlockTaskListFieldBuilder() {
                if (this.unlockTaskListBuilder_ == null) {
                    this.unlockTaskListBuilder_ = new RepeatedFieldBuilderV3<>(this.unlockTaskList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.unlockTaskList_ = null;
                }
                return this.unlockTaskListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
            public boolean getIsDevelopModuleOpen() {
                return this.isDevelopModuleOpen_;
            }

            public Builder setIsDevelopModuleOpen(boolean value) {
                this.isDevelopModuleOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsDevelopModuleOpen() {
                this.isDevelopModuleOpen_ = false;
                onChanged();
                return this;
            }

            private void ensureUnlockItemListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unlockItemList_ = BartenderInfo.mutableCopy(this.unlockItemList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
            public List<Integer> getUnlockItemListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unlockItemList_) : this.unlockItemList_;
            }

            @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
            public int getUnlockItemListCount() {
                return this.unlockItemList_.size();
            }

            @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
            public int getUnlockItemList(int index) {
                return this.unlockItemList_.getInt(index);
            }

            public Builder setUnlockItemList(int index, int value) {
                ensureUnlockItemListIsMutable();
                this.unlockItemList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnlockItemList(int value) {
                ensureUnlockItemListIsMutable();
                this.unlockItemList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnlockItemList(Iterable<? extends Integer> values) {
                ensureUnlockItemListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unlockItemList_);
                onChanged();
                return this;
            }

            public Builder clearUnlockItemList() {
                this.unlockItemList_ = BartenderInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureUnlockFormulaListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.unlockFormulaList_ = BartenderInfo.mutableCopy(this.unlockFormulaList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
            public List<Integer> getUnlockFormulaListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.unlockFormulaList_) : this.unlockFormulaList_;
            }

            @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
            public int getUnlockFormulaListCount() {
                return this.unlockFormulaList_.size();
            }

            @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
            public int getUnlockFormulaList(int index) {
                return this.unlockFormulaList_.getInt(index);
            }

            public Builder setUnlockFormulaList(int index, int value) {
                ensureUnlockFormulaListIsMutable();
                this.unlockFormulaList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnlockFormulaList(int value) {
                ensureUnlockFormulaListIsMutable();
                this.unlockFormulaList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnlockFormulaList(Iterable<? extends Integer> values) {
                ensureUnlockFormulaListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unlockFormulaList_);
                onChanged();
                return this;
            }

            public Builder clearUnlockFormulaList() {
                this.unlockFormulaList_ = BartenderInfo.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
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

            private void ensureUnlockLevelListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.unlockLevelList_ = new ArrayList(this.unlockLevelList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
            public List<BartenderLevelInfoOuterClass.BartenderLevelInfo> getUnlockLevelListList() {
                if (this.unlockLevelListBuilder_ == null) {
                    return Collections.unmodifiableList(this.unlockLevelList_);
                }
                return this.unlockLevelListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
            public int getUnlockLevelListCount() {
                if (this.unlockLevelListBuilder_ == null) {
                    return this.unlockLevelList_.size();
                }
                return this.unlockLevelListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
            public BartenderLevelInfoOuterClass.BartenderLevelInfo getUnlockLevelList(int index) {
                if (this.unlockLevelListBuilder_ == null) {
                    return this.unlockLevelList_.get(index);
                }
                return this.unlockLevelListBuilder_.getMessage(index);
            }

            public Builder setUnlockLevelList(int index, BartenderLevelInfoOuterClass.BartenderLevelInfo value) {
                if (this.unlockLevelListBuilder_ != null) {
                    this.unlockLevelListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnlockLevelListIsMutable();
                    this.unlockLevelList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setUnlockLevelList(int index, BartenderLevelInfoOuterClass.BartenderLevelInfo.Builder builderForValue) {
                if (this.unlockLevelListBuilder_ == null) {
                    ensureUnlockLevelListIsMutable();
                    this.unlockLevelList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unlockLevelListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addUnlockLevelList(BartenderLevelInfoOuterClass.BartenderLevelInfo value) {
                if (this.unlockLevelListBuilder_ != null) {
                    this.unlockLevelListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnlockLevelListIsMutable();
                    this.unlockLevelList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnlockLevelList(int index, BartenderLevelInfoOuterClass.BartenderLevelInfo value) {
                if (this.unlockLevelListBuilder_ != null) {
                    this.unlockLevelListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureUnlockLevelListIsMutable();
                    this.unlockLevelList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addUnlockLevelList(BartenderLevelInfoOuterClass.BartenderLevelInfo.Builder builderForValue) {
                if (this.unlockLevelListBuilder_ == null) {
                    ensureUnlockLevelListIsMutable();
                    this.unlockLevelList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.unlockLevelListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addUnlockLevelList(int index, BartenderLevelInfoOuterClass.BartenderLevelInfo.Builder builderForValue) {
                if (this.unlockLevelListBuilder_ == null) {
                    ensureUnlockLevelListIsMutable();
                    this.unlockLevelList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.unlockLevelListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllUnlockLevelList(Iterable<? extends BartenderLevelInfoOuterClass.BartenderLevelInfo> values) {
                if (this.unlockLevelListBuilder_ == null) {
                    ensureUnlockLevelListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unlockLevelList_);
                    onChanged();
                } else {
                    this.unlockLevelListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearUnlockLevelList() {
                if (this.unlockLevelListBuilder_ == null) {
                    this.unlockLevelList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.unlockLevelListBuilder_.clear();
                }
                return this;
            }

            public Builder removeUnlockLevelList(int index) {
                if (this.unlockLevelListBuilder_ == null) {
                    ensureUnlockLevelListIsMutable();
                    this.unlockLevelList_.remove(index);
                    onChanged();
                } else {
                    this.unlockLevelListBuilder_.remove(index);
                }
                return this;
            }

            public BartenderLevelInfoOuterClass.BartenderLevelInfo.Builder getUnlockLevelListBuilder(int index) {
                return getUnlockLevelListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
            public BartenderLevelInfoOuterClass.BartenderLevelInfoOrBuilder getUnlockLevelListOrBuilder(int index) {
                if (this.unlockLevelListBuilder_ == null) {
                    return this.unlockLevelList_.get(index);
                }
                return this.unlockLevelListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BartenderInfoOuterClass.BartenderInfoOrBuilder
            public List<? extends BartenderLevelInfoOuterClass.BartenderLevelInfoOrBuilder> getUnlockLevelListOrBuilderList() {
                if (this.unlockLevelListBuilder_ != null) {
                    return this.unlockLevelListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.unlockLevelList_);
            }

            public BartenderLevelInfoOuterClass.BartenderLevelInfo.Builder addUnlockLevelListBuilder() {
                return getUnlockLevelListFieldBuilder().addBuilder(BartenderLevelInfoOuterClass.BartenderLevelInfo.getDefaultInstance());
            }

            public BartenderLevelInfoOuterClass.BartenderLevelInfo.Builder addUnlockLevelListBuilder(int index) {
                return getUnlockLevelListFieldBuilder().addBuilder(index, BartenderLevelInfoOuterClass.BartenderLevelInfo.getDefaultInstance());
            }

            public List<BartenderLevelInfoOuterClass.BartenderLevelInfo.Builder> getUnlockLevelListBuilderList() {
                return getUnlockLevelListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BartenderLevelInfoOuterClass.BartenderLevelInfo, BartenderLevelInfoOuterClass.BartenderLevelInfo.Builder, BartenderLevelInfoOuterClass.BartenderLevelInfoOrBuilder> getUnlockLevelListFieldBuilder() {
                if (this.unlockLevelListBuilder_ == null) {
                    this.unlockLevelListBuilder_ = new RepeatedFieldBuilderV3<>(this.unlockLevelList_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.unlockLevelList_ = null;
                }
                return this.unlockLevelListBuilder_;
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

        public static BartenderInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BartenderInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BartenderInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BartenderInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BartenderTaskInfoOuterClass.getDescriptor();
        BartenderLevelInfoOuterClass.getDescriptor();
    }
}
