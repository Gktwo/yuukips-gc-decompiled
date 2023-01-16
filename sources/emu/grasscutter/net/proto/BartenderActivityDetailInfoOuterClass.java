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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BartenderActivityDetailInfoOuterClass.class */
public final class BartenderActivityDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!BartenderActivityDetailInfo.proto\u001a\u0018BartenderLevelInfo.proto\u001a\u0017BartenderTaskInfo.proto\"í\u0001\n\u001bBartenderActivityDetailInfo\u0012\u0019\n\u0011is_content_closed\u0018\u000f \u0001(\b\u0012.\n\u0011unlock_level_list\u0018\n \u0003(\u000b2\u0013.BartenderLevelInfo\u0012\u0018\n\u0010unlock_item_list\u0018\u0003 \u0003(\r\u0012\u001b\n\u0013unlock_formula_list\u0018\u0006 \u0003(\r\u0012,\n\u0010unlock_task_list\u0018\u0005 \u0003(\u000b2\u0012.BartenderTaskInfo\u0012\u001e\n\u0016is_develop_module_open\u0018\t \u0001(\bB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BartenderLevelInfoOuterClass.getDescriptor(), BartenderTaskInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BartenderActivityDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BartenderActivityDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BartenderActivityDetailInfo_descriptor, new String[]{"IsContentClosed", "UnlockLevelList", "UnlockItemList", "UnlockFormulaList", "UnlockTaskList", "IsDevelopModuleOpen"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BartenderActivityDetailInfoOuterClass$BartenderActivityDetailInfoOrBuilder.class */
    public interface BartenderActivityDetailInfoOrBuilder extends MessageOrBuilder {
        boolean getIsContentClosed();

        List<BartenderLevelInfoOuterClass.BartenderLevelInfo> getUnlockLevelListList();

        BartenderLevelInfoOuterClass.BartenderLevelInfo getUnlockLevelList(int i);

        int getUnlockLevelListCount();

        List<? extends BartenderLevelInfoOuterClass.BartenderLevelInfoOrBuilder> getUnlockLevelListOrBuilderList();

        BartenderLevelInfoOuterClass.BartenderLevelInfoOrBuilder getUnlockLevelListOrBuilder(int i);

        List<Integer> getUnlockItemListList();

        int getUnlockItemListCount();

        int getUnlockItemList(int i);

        List<Integer> getUnlockFormulaListList();

        int getUnlockFormulaListCount();

        int getUnlockFormulaList(int i);

        List<BartenderTaskInfoOuterClass.BartenderTaskInfo> getUnlockTaskListList();

        BartenderTaskInfoOuterClass.BartenderTaskInfo getUnlockTaskList(int i);

        int getUnlockTaskListCount();

        List<? extends BartenderTaskInfoOuterClass.BartenderTaskInfoOrBuilder> getUnlockTaskListOrBuilderList();

        BartenderTaskInfoOuterClass.BartenderTaskInfoOrBuilder getUnlockTaskListOrBuilder(int i);

        boolean getIsDevelopModuleOpen();
    }

    private BartenderActivityDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BartenderActivityDetailInfoOuterClass$BartenderActivityDetailInfo.class */
    public static final class BartenderActivityDetailInfo extends GeneratedMessageV3 implements BartenderActivityDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 15;
        private boolean isContentClosed_;
        public static final int UNLOCK_LEVEL_LIST_FIELD_NUMBER = 10;
        private List<BartenderLevelInfoOuterClass.BartenderLevelInfo> unlockLevelList_;
        public static final int UNLOCK_ITEM_LIST_FIELD_NUMBER = 3;
        private Internal.IntList unlockItemList_;
        private int unlockItemListMemoizedSerializedSize;
        public static final int UNLOCK_FORMULA_LIST_FIELD_NUMBER = 6;
        private Internal.IntList unlockFormulaList_;
        private int unlockFormulaListMemoizedSerializedSize;
        public static final int UNLOCK_TASK_LIST_FIELD_NUMBER = 5;
        private List<BartenderTaskInfoOuterClass.BartenderTaskInfo> unlockTaskList_;
        public static final int IS_DEVELOP_MODULE_OPEN_FIELD_NUMBER = 9;
        private boolean isDevelopModuleOpen_;
        private byte memoizedIsInitialized;
        private static final BartenderActivityDetailInfo DEFAULT_INSTANCE = new BartenderActivityDetailInfo();
        private static final Parser<BartenderActivityDetailInfo> PARSER = new AbstractParser<BartenderActivityDetailInfo>() { // from class: emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfo.1
            @Override // com.google.protobuf.Parser
            public BartenderActivityDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BartenderActivityDetailInfo(input, extensionRegistry);
            }
        };

        private BartenderActivityDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unlockItemListMemoizedSerializedSize = -1;
            this.unlockFormulaListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private BartenderActivityDetailInfo() {
            this.unlockItemListMemoizedSerializedSize = -1;
            this.unlockFormulaListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unlockLevelList_ = Collections.emptyList();
            this.unlockItemList_ = emptyIntList();
            this.unlockFormulaList_ = emptyIntList();
            this.unlockTaskList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BartenderActivityDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:104:0x01ce */
        private BartenderActivityDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.unlockItemList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.unlockItemList_.addInt(input.readUInt32());
                                break;
                            case 26:
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
                            case 42:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.unlockTaskList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.unlockTaskList_.add((BartenderTaskInfoOuterClass.BartenderTaskInfo) input.readMessage(BartenderTaskInfoOuterClass.BartenderTaskInfo.parser(), extensionRegistry));
                                break;
                            case 48:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.unlockFormulaList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.unlockFormulaList_.addInt(input.readUInt32());
                                break;
                            case 50:
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
                            case 72:
                                this.isDevelopModuleOpen_ = input.readBool();
                                break;
                            case 82:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.unlockLevelList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.unlockLevelList_.add((BartenderLevelInfoOuterClass.BartenderLevelInfo) input.readMessage(BartenderLevelInfoOuterClass.BartenderLevelInfo.parser(), extensionRegistry));
                                break;
                            case 120:
                                this.isContentClosed_ = input.readBool();
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
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unlockItemList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.unlockTaskList_ = Collections.unmodifiableList(this.unlockTaskList_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.unlockFormulaList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.unlockLevelList_ = Collections.unmodifiableList(this.unlockLevelList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BartenderActivityDetailInfoOuterClass.internal_static_BartenderActivityDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BartenderActivityDetailInfoOuterClass.internal_static_BartenderActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BartenderActivityDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
        public List<BartenderLevelInfoOuterClass.BartenderLevelInfo> getUnlockLevelListList() {
            return this.unlockLevelList_;
        }

        @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
        public List<? extends BartenderLevelInfoOuterClass.BartenderLevelInfoOrBuilder> getUnlockLevelListOrBuilderList() {
            return this.unlockLevelList_;
        }

        @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
        public int getUnlockLevelListCount() {
            return this.unlockLevelList_.size();
        }

        @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
        public BartenderLevelInfoOuterClass.BartenderLevelInfo getUnlockLevelList(int index) {
            return this.unlockLevelList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
        public BartenderLevelInfoOuterClass.BartenderLevelInfoOrBuilder getUnlockLevelListOrBuilder(int index) {
            return this.unlockLevelList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
        public List<Integer> getUnlockItemListList() {
            return this.unlockItemList_;
        }

        @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
        public int getUnlockItemListCount() {
            return this.unlockItemList_.size();
        }

        @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
        public int getUnlockItemList(int index) {
            return this.unlockItemList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
        public List<Integer> getUnlockFormulaListList() {
            return this.unlockFormulaList_;
        }

        @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
        public int getUnlockFormulaListCount() {
            return this.unlockFormulaList_.size();
        }

        @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
        public int getUnlockFormulaList(int index) {
            return this.unlockFormulaList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
        public List<BartenderTaskInfoOuterClass.BartenderTaskInfo> getUnlockTaskListList() {
            return this.unlockTaskList_;
        }

        @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
        public List<? extends BartenderTaskInfoOuterClass.BartenderTaskInfoOrBuilder> getUnlockTaskListOrBuilderList() {
            return this.unlockTaskList_;
        }

        @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
        public int getUnlockTaskListCount() {
            return this.unlockTaskList_.size();
        }

        @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
        public BartenderTaskInfoOuterClass.BartenderTaskInfo getUnlockTaskList(int index) {
            return this.unlockTaskList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
        public BartenderTaskInfoOuterClass.BartenderTaskInfoOrBuilder getUnlockTaskListOrBuilder(int index) {
            return this.unlockTaskList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
        public boolean getIsDevelopModuleOpen() {
            return this.isDevelopModuleOpen_;
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
            if (getUnlockItemListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.unlockItemListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unlockItemList_.size(); i++) {
                output.writeUInt32NoTag(this.unlockItemList_.getInt(i));
            }
            for (int i2 = 0; i2 < this.unlockTaskList_.size(); i2++) {
                output.writeMessage(5, this.unlockTaskList_.get(i2));
            }
            if (getUnlockFormulaListList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.unlockFormulaListMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.unlockFormulaList_.size(); i3++) {
                output.writeUInt32NoTag(this.unlockFormulaList_.getInt(i3));
            }
            if (this.isDevelopModuleOpen_) {
                output.writeBool(9, this.isDevelopModuleOpen_);
            }
            for (int i4 = 0; i4 < this.unlockLevelList_.size(); i4++) {
                output.writeMessage(10, this.unlockLevelList_.get(i4));
            }
            if (this.isContentClosed_) {
                output.writeBool(15, this.isContentClosed_);
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
            for (int i = 0; i < this.unlockItemList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unlockItemList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getUnlockItemListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unlockItemListMemoizedSerializedSize = dataSize;
            for (int i2 = 0; i2 < this.unlockTaskList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.unlockTaskList_.get(i2));
            }
            int dataSize2 = 0;
            for (int i3 = 0; i3 < this.unlockFormulaList_.size(); i3++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unlockFormulaList_.getInt(i3));
            }
            int size3 = size2 + dataSize2;
            if (!getUnlockFormulaListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unlockFormulaListMemoizedSerializedSize = dataSize2;
            if (this.isDevelopModuleOpen_) {
                size3 += CodedOutputStream.computeBoolSize(9, this.isDevelopModuleOpen_);
            }
            for (int i4 = 0; i4 < this.unlockLevelList_.size(); i4++) {
                size3 += CodedOutputStream.computeMessageSize(10, this.unlockLevelList_.get(i4));
            }
            if (this.isContentClosed_) {
                size3 += CodedOutputStream.computeBoolSize(15, this.isContentClosed_);
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
            if (!(obj instanceof BartenderActivityDetailInfo)) {
                return equals(obj);
            }
            BartenderActivityDetailInfo other = (BartenderActivityDetailInfo) obj;
            return getIsContentClosed() == other.getIsContentClosed() && getUnlockLevelListList().equals(other.getUnlockLevelListList()) && getUnlockItemListList().equals(other.getUnlockItemListList()) && getUnlockFormulaListList().equals(other.getUnlockFormulaListList()) && getUnlockTaskListList().equals(other.getUnlockTaskListList()) && getIsDevelopModuleOpen() == other.getIsDevelopModuleOpen() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + Internal.hashBoolean(getIsContentClosed());
            if (getUnlockLevelListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getUnlockLevelListList().hashCode();
            }
            if (getUnlockItemListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getUnlockItemListList().hashCode();
            }
            if (getUnlockFormulaListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getUnlockFormulaListList().hashCode();
            }
            if (getUnlockTaskListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getUnlockTaskListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 9)) + Internal.hashBoolean(getIsDevelopModuleOpen()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BartenderActivityDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BartenderActivityDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BartenderActivityDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BartenderActivityDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BartenderActivityDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BartenderActivityDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BartenderActivityDetailInfo parseFrom(InputStream input) throws IOException {
            return (BartenderActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BartenderActivityDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BartenderActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BartenderActivityDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (BartenderActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BartenderActivityDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BartenderActivityDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BartenderActivityDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (BartenderActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BartenderActivityDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BartenderActivityDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BartenderActivityDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BartenderActivityDetailInfoOuterClass$BartenderActivityDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BartenderActivityDetailInfoOrBuilder {
            private int bitField0_;
            private boolean isContentClosed_;
            private RepeatedFieldBuilderV3<BartenderLevelInfoOuterClass.BartenderLevelInfo, BartenderLevelInfoOuterClass.BartenderLevelInfo.Builder, BartenderLevelInfoOuterClass.BartenderLevelInfoOrBuilder> unlockLevelListBuilder_;
            private RepeatedFieldBuilderV3<BartenderTaskInfoOuterClass.BartenderTaskInfo, BartenderTaskInfoOuterClass.BartenderTaskInfo.Builder, BartenderTaskInfoOuterClass.BartenderTaskInfoOrBuilder> unlockTaskListBuilder_;
            private boolean isDevelopModuleOpen_;
            private List<BartenderLevelInfoOuterClass.BartenderLevelInfo> unlockLevelList_ = Collections.emptyList();
            private Internal.IntList unlockItemList_ = BartenderActivityDetailInfo.emptyIntList();
            private Internal.IntList unlockFormulaList_ = BartenderActivityDetailInfo.emptyIntList();
            private List<BartenderTaskInfoOuterClass.BartenderTaskInfo> unlockTaskList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return BartenderActivityDetailInfoOuterClass.internal_static_BartenderActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BartenderActivityDetailInfoOuterClass.internal_static_BartenderActivityDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(BartenderActivityDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BartenderActivityDetailInfo.alwaysUseFieldBuilders) {
                    getUnlockLevelListFieldBuilder();
                    getUnlockTaskListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isContentClosed_ = false;
                if (this.unlockLevelListBuilder_ == null) {
                    this.unlockLevelList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.unlockLevelListBuilder_.clear();
                }
                this.unlockItemList_ = BartenderActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -3;
                this.unlockFormulaList_ = BartenderActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -5;
                if (this.unlockTaskListBuilder_ == null) {
                    this.unlockTaskList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.unlockTaskListBuilder_.clear();
                }
                this.isDevelopModuleOpen_ = false;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BartenderActivityDetailInfoOuterClass.internal_static_BartenderActivityDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BartenderActivityDetailInfo getDefaultInstanceForType() {
                return BartenderActivityDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BartenderActivityDetailInfo build() {
                BartenderActivityDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BartenderActivityDetailInfo buildPartial() {
                BartenderActivityDetailInfo result = new BartenderActivityDetailInfo(this);
                int i = this.bitField0_;
                result.isContentClosed_ = this.isContentClosed_;
                if (this.unlockLevelListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.unlockLevelList_ = Collections.unmodifiableList(this.unlockLevelList_);
                        this.bitField0_ &= -2;
                    }
                    result.unlockLevelList_ = this.unlockLevelList_;
                } else {
                    result.unlockLevelList_ = this.unlockLevelListBuilder_.build();
                }
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
                if (this.unlockTaskListBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.unlockTaskList_ = Collections.unmodifiableList(this.unlockTaskList_);
                        this.bitField0_ &= -9;
                    }
                    result.unlockTaskList_ = this.unlockTaskList_;
                } else {
                    result.unlockTaskList_ = this.unlockTaskListBuilder_.build();
                }
                result.isDevelopModuleOpen_ = this.isDevelopModuleOpen_;
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
                if (other instanceof BartenderActivityDetailInfo) {
                    return mergeFrom((BartenderActivityDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BartenderActivityDetailInfo other) {
                if (other == BartenderActivityDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                if (this.unlockLevelListBuilder_ == null) {
                    if (!other.unlockLevelList_.isEmpty()) {
                        if (this.unlockLevelList_.isEmpty()) {
                            this.unlockLevelList_ = other.unlockLevelList_;
                            this.bitField0_ &= -2;
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
                        this.bitField0_ &= -2;
                        this.unlockLevelListBuilder_ = BartenderActivityDetailInfo.alwaysUseFieldBuilders ? getUnlockLevelListFieldBuilder() : null;
                    } else {
                        this.unlockLevelListBuilder_.addAllMessages(other.unlockLevelList_);
                    }
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
                if (this.unlockTaskListBuilder_ == null) {
                    if (!other.unlockTaskList_.isEmpty()) {
                        if (this.unlockTaskList_.isEmpty()) {
                            this.unlockTaskList_ = other.unlockTaskList_;
                            this.bitField0_ &= -9;
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
                        this.bitField0_ &= -9;
                        this.unlockTaskListBuilder_ = BartenderActivityDetailInfo.alwaysUseFieldBuilders ? getUnlockTaskListFieldBuilder() : null;
                    } else {
                        this.unlockTaskListBuilder_.addAllMessages(other.unlockTaskList_);
                    }
                }
                if (other.getIsDevelopModuleOpen()) {
                    setIsDevelopModuleOpen(other.getIsDevelopModuleOpen());
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
                BartenderActivityDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = BartenderActivityDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BartenderActivityDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
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

            private void ensureUnlockLevelListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unlockLevelList_ = new ArrayList(this.unlockLevelList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
            public List<BartenderLevelInfoOuterClass.BartenderLevelInfo> getUnlockLevelListList() {
                if (this.unlockLevelListBuilder_ == null) {
                    return Collections.unmodifiableList(this.unlockLevelList_);
                }
                return this.unlockLevelListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
            public int getUnlockLevelListCount() {
                if (this.unlockLevelListBuilder_ == null) {
                    return this.unlockLevelList_.size();
                }
                return this.unlockLevelListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
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
                    this.bitField0_ &= -2;
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

            @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
            public BartenderLevelInfoOuterClass.BartenderLevelInfoOrBuilder getUnlockLevelListOrBuilder(int index) {
                if (this.unlockLevelListBuilder_ == null) {
                    return this.unlockLevelList_.get(index);
                }
                return this.unlockLevelListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
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
                    this.unlockLevelListBuilder_ = new RepeatedFieldBuilderV3<>(this.unlockLevelList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.unlockLevelList_ = null;
                }
                return this.unlockLevelListBuilder_;
            }

            private void ensureUnlockItemListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unlockItemList_ = BartenderActivityDetailInfo.mutableCopy(this.unlockItemList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
            public List<Integer> getUnlockItemListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unlockItemList_) : this.unlockItemList_;
            }

            @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
            public int getUnlockItemListCount() {
                return this.unlockItemList_.size();
            }

            @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
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
                this.unlockItemList_ = BartenderActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureUnlockFormulaListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.unlockFormulaList_ = BartenderActivityDetailInfo.mutableCopy(this.unlockFormulaList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
            public List<Integer> getUnlockFormulaListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.unlockFormulaList_) : this.unlockFormulaList_;
            }

            @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
            public int getUnlockFormulaListCount() {
                return this.unlockFormulaList_.size();
            }

            @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
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
                this.unlockFormulaList_ = BartenderActivityDetailInfo.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            private void ensureUnlockTaskListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.unlockTaskList_ = new ArrayList(this.unlockTaskList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
            public List<BartenderTaskInfoOuterClass.BartenderTaskInfo> getUnlockTaskListList() {
                if (this.unlockTaskListBuilder_ == null) {
                    return Collections.unmodifiableList(this.unlockTaskList_);
                }
                return this.unlockTaskListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
            public int getUnlockTaskListCount() {
                if (this.unlockTaskListBuilder_ == null) {
                    return this.unlockTaskList_.size();
                }
                return this.unlockTaskListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
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
                    this.bitField0_ &= -9;
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

            @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
            public BartenderTaskInfoOuterClass.BartenderTaskInfoOrBuilder getUnlockTaskListOrBuilder(int index) {
                if (this.unlockTaskListBuilder_ == null) {
                    return this.unlockTaskList_.get(index);
                }
                return this.unlockTaskListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
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
                    this.unlockTaskListBuilder_ = new RepeatedFieldBuilderV3<>(this.unlockTaskList_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.unlockTaskList_ = null;
                }
                return this.unlockTaskListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BartenderActivityDetailInfoOuterClass.BartenderActivityDetailInfoOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static BartenderActivityDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BartenderActivityDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BartenderActivityDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BartenderActivityDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BartenderLevelInfoOuterClass.getDescriptor();
        BartenderTaskInfoOuterClass.getDescriptor();
    }
}
