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
import emu.grasscutter.net.proto.ClientInputTypeOuterClass;
import emu.grasscutter.net.proto.LanternProjectionLevelInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternProjectionInfoOuterClass.class */
public final class LanternProjectionInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bLanternProjectionInfo.proto\u001a\u0015ClientInputType.proto\u001a LanternProjectionLevelInfo.proto\"¿\u0001\n\u0015LanternProjectionInfo\u0012-\n\u0013Unk3300_FAIAIJGCBJG\u0018\u0005 \u0003(\u000e2\u0010.ClientInputType\u0012\u0017\n\u000fopen_stage_list\u0018\u000f \u0003(\r\u0012/\n\nlevel_list\u0018\r \u0003(\u000b2\u001b.LanternProjectionLevelInfo\u0012-\n\u0013Unk3300_EBHHFKLDOFB\u0018\n \u0003(\u000e2\u0010.ClientInputTypeB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ClientInputTypeOuterClass.getDescriptor(), LanternProjectionLevelInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_LanternProjectionInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_LanternProjectionInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_LanternProjectionInfo_descriptor, new String[]{"Unk3300FAIAIJGCBJG", "OpenStageList", "LevelList", "Unk3300EBHHFKLDOFB"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternProjectionInfoOuterClass$LanternProjectionInfoOrBuilder.class */
    public interface LanternProjectionInfoOrBuilder extends MessageOrBuilder {
        List<ClientInputTypeOuterClass.ClientInputType> getUnk3300FAIAIJGCBJGList();

        int getUnk3300FAIAIJGCBJGCount();

        ClientInputTypeOuterClass.ClientInputType getUnk3300FAIAIJGCBJG(int i);

        List<Integer> getUnk3300FAIAIJGCBJGValueList();

        int getUnk3300FAIAIJGCBJGValue(int i);

        List<Integer> getOpenStageListList();

        int getOpenStageListCount();

        int getOpenStageList(int i);

        List<LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo> getLevelListList();

        LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo getLevelList(int i);

        int getLevelListCount();

        List<? extends LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfoOrBuilder> getLevelListOrBuilderList();

        LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfoOrBuilder getLevelListOrBuilder(int i);

        List<ClientInputTypeOuterClass.ClientInputType> getUnk3300EBHHFKLDOFBList();

        int getUnk3300EBHHFKLDOFBCount();

        ClientInputTypeOuterClass.ClientInputType getUnk3300EBHHFKLDOFB(int i);

        List<Integer> getUnk3300EBHHFKLDOFBValueList();

        int getUnk3300EBHHFKLDOFBValue(int i);
    }

    private LanternProjectionInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternProjectionInfoOuterClass$LanternProjectionInfo.class */
    public static final class LanternProjectionInfo extends GeneratedMessageV3 implements LanternProjectionInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_FAIAIJGCBJG_FIELD_NUMBER = 5;
        private List<Integer> unk3300FAIAIJGCBJG_;
        private int unk3300FAIAIJGCBJGMemoizedSerializedSize;
        public static final int OPEN_STAGE_LIST_FIELD_NUMBER = 15;
        private Internal.IntList openStageList_;
        private int openStageListMemoizedSerializedSize;
        public static final int LEVEL_LIST_FIELD_NUMBER = 13;
        private List<LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo> levelList_;
        public static final int UNK3300_EBHHFKLDOFB_FIELD_NUMBER = 10;
        private List<Integer> unk3300EBHHFKLDOFB_;
        private int unk3300EBHHFKLDOFBMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final Internal.ListAdapter.Converter<Integer, ClientInputTypeOuterClass.ClientInputType> unk3300FAIAIJGCBJG_converter_ = new Internal.ListAdapter.Converter<Integer, ClientInputTypeOuterClass.ClientInputType>() { // from class: emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfo.1
            public ClientInputTypeOuterClass.ClientInputType convert(Integer from) {
                ClientInputTypeOuterClass.ClientInputType result = ClientInputTypeOuterClass.ClientInputType.valueOf(from.intValue());
                return result == null ? ClientInputTypeOuterClass.ClientInputType.UNRECOGNIZED : result;
            }
        };
        private static final Internal.ListAdapter.Converter<Integer, ClientInputTypeOuterClass.ClientInputType> unk3300EBHHFKLDOFB_converter_ = new Internal.ListAdapter.Converter<Integer, ClientInputTypeOuterClass.ClientInputType>() { // from class: emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfo.2
            public ClientInputTypeOuterClass.ClientInputType convert(Integer from) {
                ClientInputTypeOuterClass.ClientInputType result = ClientInputTypeOuterClass.ClientInputType.valueOf(from.intValue());
                return result == null ? ClientInputTypeOuterClass.ClientInputType.UNRECOGNIZED : result;
            }
        };
        private static final LanternProjectionInfo DEFAULT_INSTANCE = new LanternProjectionInfo();
        private static final Parser<LanternProjectionInfo> PARSER = new AbstractParser<LanternProjectionInfo>() { // from class: emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfo.3
            @Override // com.google.protobuf.Parser
            public LanternProjectionInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new LanternProjectionInfo(input, extensionRegistry);
            }
        };

        private LanternProjectionInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.openStageListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private LanternProjectionInfo() {
            this.openStageListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unk3300FAIAIJGCBJG_ = Collections.emptyList();
            this.openStageList_ = emptyIntList();
            this.levelList_ = Collections.emptyList();
            this.unk3300EBHHFKLDOFB_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new LanternProjectionInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:108:0x020e */
        private LanternProjectionInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 40:
                                int rawValue = input.readEnum();
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.unk3300FAIAIJGCBJG_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.unk3300FAIAIJGCBJG_.add(Integer.valueOf(rawValue));
                                break;
                            case 42:
                                int oldLimit = input.pushLimit(input.readRawVarint32());
                                while (input.getBytesUntilLimit() > 0) {
                                    int rawValue2 = input.readEnum();
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.unk3300FAIAIJGCBJG_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.unk3300FAIAIJGCBJG_.add(Integer.valueOf(rawValue2));
                                }
                                input.popLimit(oldLimit);
                                break;
                            case 80:
                                int rawValue3 = input.readEnum();
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.unk3300EBHHFKLDOFB_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.unk3300EBHHFKLDOFB_.add(Integer.valueOf(rawValue3));
                                break;
                            case 82:
                                int oldLimit2 = input.pushLimit(input.readRawVarint32());
                                while (input.getBytesUntilLimit() > 0) {
                                    int rawValue4 = input.readEnum();
                                    if ((mutable_bitField0_ & 8) == 0) {
                                        this.unk3300EBHHFKLDOFB_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                    }
                                    this.unk3300EBHHFKLDOFB_.add(Integer.valueOf(rawValue4));
                                }
                                input.popLimit(oldLimit2);
                                break;
                            case 106:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.levelList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.levelList_.add((LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo) input.readMessage(LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo.parser(), extensionRegistry));
                                break;
                            case 120:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.openStageList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.openStageList_.addInt(input.readUInt32());
                                break;
                            case 122:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.openStageList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.openStageList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.unk3300FAIAIJGCBJG_ = Collections.unmodifiableList(this.unk3300FAIAIJGCBJG_);
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.unk3300EBHHFKLDOFB_ = Collections.unmodifiableList(this.unk3300EBHHFKLDOFB_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.levelList_ = Collections.unmodifiableList(this.levelList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.openStageList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return LanternProjectionInfoOuterClass.internal_static_LanternProjectionInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return LanternProjectionInfoOuterClass.internal_static_LanternProjectionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LanternProjectionInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
        public List<ClientInputTypeOuterClass.ClientInputType> getUnk3300FAIAIJGCBJGList() {
            return new Internal.ListAdapter(this.unk3300FAIAIJGCBJG_, unk3300FAIAIJGCBJG_converter_);
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
        public int getUnk3300FAIAIJGCBJGCount() {
            return this.unk3300FAIAIJGCBJG_.size();
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
        public ClientInputTypeOuterClass.ClientInputType getUnk3300FAIAIJGCBJG(int index) {
            return unk3300FAIAIJGCBJG_converter_.convert(this.unk3300FAIAIJGCBJG_.get(index));
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
        public List<Integer> getUnk3300FAIAIJGCBJGValueList() {
            return this.unk3300FAIAIJGCBJG_;
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
        public int getUnk3300FAIAIJGCBJGValue(int index) {
            return this.unk3300FAIAIJGCBJG_.get(index).intValue();
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
        public List<Integer> getOpenStageListList() {
            return this.openStageList_;
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
        public int getOpenStageListCount() {
            return this.openStageList_.size();
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
        public int getOpenStageList(int index) {
            return this.openStageList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
        public List<LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo> getLevelListList() {
            return this.levelList_;
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
        public List<? extends LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfoOrBuilder> getLevelListOrBuilderList() {
            return this.levelList_;
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
        public int getLevelListCount() {
            return this.levelList_.size();
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
        public LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo getLevelList(int index) {
            return this.levelList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
        public LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfoOrBuilder getLevelListOrBuilder(int index) {
            return this.levelList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
        public List<ClientInputTypeOuterClass.ClientInputType> getUnk3300EBHHFKLDOFBList() {
            return new Internal.ListAdapter(this.unk3300EBHHFKLDOFB_, unk3300EBHHFKLDOFB_converter_);
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
        public int getUnk3300EBHHFKLDOFBCount() {
            return this.unk3300EBHHFKLDOFB_.size();
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
        public ClientInputTypeOuterClass.ClientInputType getUnk3300EBHHFKLDOFB(int index) {
            return unk3300EBHHFKLDOFB_converter_.convert(this.unk3300EBHHFKLDOFB_.get(index));
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
        public List<Integer> getUnk3300EBHHFKLDOFBValueList() {
            return this.unk3300EBHHFKLDOFB_;
        }

        @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
        public int getUnk3300EBHHFKLDOFBValue(int index) {
            return this.unk3300EBHHFKLDOFB_.get(index).intValue();
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
            if (getUnk3300FAIAIJGCBJGList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.unk3300FAIAIJGCBJGMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unk3300FAIAIJGCBJG_.size(); i++) {
                output.writeEnumNoTag(this.unk3300FAIAIJGCBJG_.get(i).intValue());
            }
            if (getUnk3300EBHHFKLDOFBList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.unk3300EBHHFKLDOFBMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unk3300EBHHFKLDOFB_.size(); i2++) {
                output.writeEnumNoTag(this.unk3300EBHHFKLDOFB_.get(i2).intValue());
            }
            for (int i3 = 0; i3 < this.levelList_.size(); i3++) {
                output.writeMessage(13, this.levelList_.get(i3));
            }
            if (getOpenStageListList().size() > 0) {
                output.writeUInt32NoTag(122);
                output.writeUInt32NoTag(this.openStageListMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.openStageList_.size(); i4++) {
                output.writeUInt32NoTag(this.openStageList_.getInt(i4));
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
            for (int i = 0; i < this.unk3300FAIAIJGCBJG_.size(); i++) {
                dataSize += CodedOutputStream.computeEnumSizeNoTag(this.unk3300FAIAIJGCBJG_.get(i).intValue());
            }
            int size2 = 0 + dataSize;
            if (!getUnk3300FAIAIJGCBJGList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeUInt32SizeNoTag(dataSize);
            }
            this.unk3300FAIAIJGCBJGMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.unk3300EBHHFKLDOFB_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeEnumSizeNoTag(this.unk3300EBHHFKLDOFB_.get(i2).intValue());
            }
            int size3 = size2 + dataSize2;
            if (!getUnk3300EBHHFKLDOFBList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeUInt32SizeNoTag(dataSize2);
            }
            this.unk3300EBHHFKLDOFBMemoizedSerializedSize = dataSize2;
            for (int i3 = 0; i3 < this.levelList_.size(); i3++) {
                size3 += CodedOutputStream.computeMessageSize(13, this.levelList_.get(i3));
            }
            int dataSize3 = 0;
            for (int i4 = 0; i4 < this.openStageList_.size(); i4++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.openStageList_.getInt(i4));
            }
            int size4 = size3 + dataSize3;
            if (!getOpenStageListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.openStageListMemoizedSerializedSize = dataSize3;
            int size5 = size4 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size5;
            return size5;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof LanternProjectionInfo)) {
                return equals(obj);
            }
            LanternProjectionInfo other = (LanternProjectionInfo) obj;
            return this.unk3300FAIAIJGCBJG_.equals(other.unk3300FAIAIJGCBJG_) && getOpenStageListList().equals(other.getOpenStageListList()) && getLevelListList().equals(other.getLevelListList()) && this.unk3300EBHHFKLDOFB_.equals(other.unk3300EBHHFKLDOFB_) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getUnk3300FAIAIJGCBJGCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + this.unk3300FAIAIJGCBJG_.hashCode();
            }
            if (getOpenStageListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getOpenStageListList().hashCode();
            }
            if (getLevelListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getLevelListList().hashCode();
            }
            if (getUnk3300EBHHFKLDOFBCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + this.unk3300EBHHFKLDOFB_.hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static LanternProjectionInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LanternProjectionInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LanternProjectionInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LanternProjectionInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LanternProjectionInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static LanternProjectionInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static LanternProjectionInfo parseFrom(InputStream input) throws IOException {
            return (LanternProjectionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LanternProjectionInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LanternProjectionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static LanternProjectionInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (LanternProjectionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static LanternProjectionInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LanternProjectionInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static LanternProjectionInfo parseFrom(CodedInputStream input) throws IOException {
            return (LanternProjectionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static LanternProjectionInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (LanternProjectionInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(LanternProjectionInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/LanternProjectionInfoOuterClass$LanternProjectionInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements LanternProjectionInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo, LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo.Builder, LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfoOrBuilder> levelListBuilder_;
            private List<Integer> unk3300FAIAIJGCBJG_ = Collections.emptyList();
            private Internal.IntList openStageList_ = LanternProjectionInfo.emptyIntList();
            private List<LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo> levelList_ = Collections.emptyList();
            private List<Integer> unk3300EBHHFKLDOFB_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return LanternProjectionInfoOuterClass.internal_static_LanternProjectionInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return LanternProjectionInfoOuterClass.internal_static_LanternProjectionInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(LanternProjectionInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (LanternProjectionInfo.alwaysUseFieldBuilders) {
                    getLevelListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300FAIAIJGCBJG_ = Collections.emptyList();
                this.bitField0_ &= -2;
                this.openStageList_ = LanternProjectionInfo.emptyIntList();
                this.bitField0_ &= -3;
                if (this.levelListBuilder_ == null) {
                    this.levelList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.levelListBuilder_.clear();
                }
                this.unk3300EBHHFKLDOFB_ = Collections.emptyList();
                this.bitField0_ &= -9;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return LanternProjectionInfoOuterClass.internal_static_LanternProjectionInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public LanternProjectionInfo getDefaultInstanceForType() {
                return LanternProjectionInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LanternProjectionInfo build() {
                LanternProjectionInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public LanternProjectionInfo buildPartial() {
                LanternProjectionInfo result = new LanternProjectionInfo(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.unk3300FAIAIJGCBJG_ = Collections.unmodifiableList(this.unk3300FAIAIJGCBJG_);
                    this.bitField0_ &= -2;
                }
                result.unk3300FAIAIJGCBJG_ = this.unk3300FAIAIJGCBJG_;
                if ((this.bitField0_ & 2) != 0) {
                    this.openStageList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.openStageList_ = this.openStageList_;
                if (this.levelListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.levelList_ = Collections.unmodifiableList(this.levelList_);
                        this.bitField0_ &= -5;
                    }
                    result.levelList_ = this.levelList_;
                } else {
                    result.levelList_ = this.levelListBuilder_.build();
                }
                if ((this.bitField0_ & 8) != 0) {
                    this.unk3300EBHHFKLDOFB_ = Collections.unmodifiableList(this.unk3300EBHHFKLDOFB_);
                    this.bitField0_ &= -9;
                }
                result.unk3300EBHHFKLDOFB_ = this.unk3300EBHHFKLDOFB_;
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
                if (other instanceof LanternProjectionInfo) {
                    return mergeFrom((LanternProjectionInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(LanternProjectionInfo other) {
                if (other == LanternProjectionInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.unk3300FAIAIJGCBJG_.isEmpty()) {
                    if (this.unk3300FAIAIJGCBJG_.isEmpty()) {
                        this.unk3300FAIAIJGCBJG_ = other.unk3300FAIAIJGCBJG_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUnk3300FAIAIJGCBJGIsMutable();
                        this.unk3300FAIAIJGCBJG_.addAll(other.unk3300FAIAIJGCBJG_);
                    }
                    onChanged();
                }
                if (!other.openStageList_.isEmpty()) {
                    if (this.openStageList_.isEmpty()) {
                        this.openStageList_ = other.openStageList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureOpenStageListIsMutable();
                        this.openStageList_.addAll(other.openStageList_);
                    }
                    onChanged();
                }
                if (this.levelListBuilder_ == null) {
                    if (!other.levelList_.isEmpty()) {
                        if (this.levelList_.isEmpty()) {
                            this.levelList_ = other.levelList_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureLevelListIsMutable();
                            this.levelList_.addAll(other.levelList_);
                        }
                        onChanged();
                    }
                } else if (!other.levelList_.isEmpty()) {
                    if (this.levelListBuilder_.isEmpty()) {
                        this.levelListBuilder_.dispose();
                        this.levelListBuilder_ = null;
                        this.levelList_ = other.levelList_;
                        this.bitField0_ &= -5;
                        this.levelListBuilder_ = LanternProjectionInfo.alwaysUseFieldBuilders ? getLevelListFieldBuilder() : null;
                    } else {
                        this.levelListBuilder_.addAllMessages(other.levelList_);
                    }
                }
                if (!other.unk3300EBHHFKLDOFB_.isEmpty()) {
                    if (this.unk3300EBHHFKLDOFB_.isEmpty()) {
                        this.unk3300EBHHFKLDOFB_ = other.unk3300EBHHFKLDOFB_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureUnk3300EBHHFKLDOFBIsMutable();
                        this.unk3300EBHHFKLDOFB_.addAll(other.unk3300EBHHFKLDOFB_);
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
                LanternProjectionInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = LanternProjectionInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (LanternProjectionInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureUnk3300FAIAIJGCBJGIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unk3300FAIAIJGCBJG_ = new ArrayList(this.unk3300FAIAIJGCBJG_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
            public List<ClientInputTypeOuterClass.ClientInputType> getUnk3300FAIAIJGCBJGList() {
                return new Internal.ListAdapter(this.unk3300FAIAIJGCBJG_, LanternProjectionInfo.unk3300FAIAIJGCBJG_converter_);
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
            public int getUnk3300FAIAIJGCBJGCount() {
                return this.unk3300FAIAIJGCBJG_.size();
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
            public ClientInputTypeOuterClass.ClientInputType getUnk3300FAIAIJGCBJG(int index) {
                return LanternProjectionInfo.unk3300FAIAIJGCBJG_converter_.convert(this.unk3300FAIAIJGCBJG_.get(index));
            }

            public Builder setUnk3300FAIAIJGCBJG(int index, ClientInputTypeOuterClass.ClientInputType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureUnk3300FAIAIJGCBJGIsMutable();
                this.unk3300FAIAIJGCBJG_.set(index, Integer.valueOf(value.getNumber()));
                onChanged();
                return this;
            }

            public Builder addUnk3300FAIAIJGCBJG(ClientInputTypeOuterClass.ClientInputType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureUnk3300FAIAIJGCBJGIsMutable();
                this.unk3300FAIAIJGCBJG_.add(Integer.valueOf(value.getNumber()));
                onChanged();
                return this;
            }

            public Builder addAllUnk3300FAIAIJGCBJG(Iterable<? extends ClientInputTypeOuterClass.ClientInputType> values) {
                ensureUnk3300FAIAIJGCBJGIsMutable();
                for (ClientInputTypeOuterClass.ClientInputType value : values) {
                    this.unk3300FAIAIJGCBJG_.add(Integer.valueOf(value.getNumber()));
                }
                onChanged();
                return this;
            }

            public Builder clearUnk3300FAIAIJGCBJG() {
                this.unk3300FAIAIJGCBJG_ = Collections.emptyList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
            public List<Integer> getUnk3300FAIAIJGCBJGValueList() {
                return Collections.unmodifiableList(this.unk3300FAIAIJGCBJG_);
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
            public int getUnk3300FAIAIJGCBJGValue(int index) {
                return this.unk3300FAIAIJGCBJG_.get(index).intValue();
            }

            public Builder setUnk3300FAIAIJGCBJGValue(int index, int value) {
                ensureUnk3300FAIAIJGCBJGIsMutable();
                this.unk3300FAIAIJGCBJG_.set(index, Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addUnk3300FAIAIJGCBJGValue(int value) {
                ensureUnk3300FAIAIJGCBJGIsMutable();
                this.unk3300FAIAIJGCBJG_.add(Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addAllUnk3300FAIAIJGCBJGValue(Iterable<Integer> values) {
                ensureUnk3300FAIAIJGCBJGIsMutable();
                for (Integer num : values) {
                    this.unk3300FAIAIJGCBJG_.add(Integer.valueOf(num.intValue()));
                }
                onChanged();
                return this;
            }

            private void ensureOpenStageListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.openStageList_ = LanternProjectionInfo.mutableCopy(this.openStageList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
            public List<Integer> getOpenStageListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.openStageList_) : this.openStageList_;
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
            public int getOpenStageListCount() {
                return this.openStageList_.size();
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
            public int getOpenStageList(int index) {
                return this.openStageList_.getInt(index);
            }

            public Builder setOpenStageList(int index, int value) {
                ensureOpenStageListIsMutable();
                this.openStageList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addOpenStageList(int value) {
                ensureOpenStageListIsMutable();
                this.openStageList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllOpenStageList(Iterable<? extends Integer> values) {
                ensureOpenStageListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.openStageList_);
                onChanged();
                return this;
            }

            public Builder clearOpenStageList() {
                this.openStageList_ = LanternProjectionInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureLevelListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.levelList_ = new ArrayList(this.levelList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
            public List<LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo> getLevelListList() {
                if (this.levelListBuilder_ == null) {
                    return Collections.unmodifiableList(this.levelList_);
                }
                return this.levelListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
            public int getLevelListCount() {
                if (this.levelListBuilder_ == null) {
                    return this.levelList_.size();
                }
                return this.levelListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
            public LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo getLevelList(int index) {
                if (this.levelListBuilder_ == null) {
                    return this.levelList_.get(index);
                }
                return this.levelListBuilder_.getMessage(index);
            }

            public Builder setLevelList(int index, LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo value) {
                if (this.levelListBuilder_ != null) {
                    this.levelListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLevelListIsMutable();
                    this.levelList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setLevelList(int index, LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo.Builder builderForValue) {
                if (this.levelListBuilder_ == null) {
                    ensureLevelListIsMutable();
                    this.levelList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.levelListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addLevelList(LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo value) {
                if (this.levelListBuilder_ != null) {
                    this.levelListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLevelListIsMutable();
                    this.levelList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addLevelList(int index, LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo value) {
                if (this.levelListBuilder_ != null) {
                    this.levelListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLevelListIsMutable();
                    this.levelList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addLevelList(LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo.Builder builderForValue) {
                if (this.levelListBuilder_ == null) {
                    ensureLevelListIsMutable();
                    this.levelList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.levelListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addLevelList(int index, LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo.Builder builderForValue) {
                if (this.levelListBuilder_ == null) {
                    ensureLevelListIsMutable();
                    this.levelList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.levelListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllLevelList(Iterable<? extends LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo> values) {
                if (this.levelListBuilder_ == null) {
                    ensureLevelListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.levelList_);
                    onChanged();
                } else {
                    this.levelListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearLevelList() {
                if (this.levelListBuilder_ == null) {
                    this.levelList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.levelListBuilder_.clear();
                }
                return this;
            }

            public Builder removeLevelList(int index) {
                if (this.levelListBuilder_ == null) {
                    ensureLevelListIsMutable();
                    this.levelList_.remove(index);
                    onChanged();
                } else {
                    this.levelListBuilder_.remove(index);
                }
                return this;
            }

            public LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo.Builder getLevelListBuilder(int index) {
                return getLevelListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
            public LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfoOrBuilder getLevelListOrBuilder(int index) {
                if (this.levelListBuilder_ == null) {
                    return this.levelList_.get(index);
                }
                return this.levelListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
            public List<? extends LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfoOrBuilder> getLevelListOrBuilderList() {
                if (this.levelListBuilder_ != null) {
                    return this.levelListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.levelList_);
            }

            public LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo.Builder addLevelListBuilder() {
                return getLevelListFieldBuilder().addBuilder(LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo.getDefaultInstance());
            }

            public LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo.Builder addLevelListBuilder(int index) {
                return getLevelListFieldBuilder().addBuilder(index, LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo.getDefaultInstance());
            }

            public List<LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo.Builder> getLevelListBuilderList() {
                return getLevelListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo, LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfo.Builder, LanternProjectionLevelInfoOuterClass.LanternProjectionLevelInfoOrBuilder> getLevelListFieldBuilder() {
                if (this.levelListBuilder_ == null) {
                    this.levelListBuilder_ = new RepeatedFieldBuilderV3<>(this.levelList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.levelList_ = null;
                }
                return this.levelListBuilder_;
            }

            private void ensureUnk3300EBHHFKLDOFBIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.unk3300EBHHFKLDOFB_ = new ArrayList(this.unk3300EBHHFKLDOFB_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
            public List<ClientInputTypeOuterClass.ClientInputType> getUnk3300EBHHFKLDOFBList() {
                return new Internal.ListAdapter(this.unk3300EBHHFKLDOFB_, LanternProjectionInfo.unk3300EBHHFKLDOFB_converter_);
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
            public int getUnk3300EBHHFKLDOFBCount() {
                return this.unk3300EBHHFKLDOFB_.size();
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
            public ClientInputTypeOuterClass.ClientInputType getUnk3300EBHHFKLDOFB(int index) {
                return LanternProjectionInfo.unk3300EBHHFKLDOFB_converter_.convert(this.unk3300EBHHFKLDOFB_.get(index));
            }

            public Builder setUnk3300EBHHFKLDOFB(int index, ClientInputTypeOuterClass.ClientInputType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureUnk3300EBHHFKLDOFBIsMutable();
                this.unk3300EBHHFKLDOFB_.set(index, Integer.valueOf(value.getNumber()));
                onChanged();
                return this;
            }

            public Builder addUnk3300EBHHFKLDOFB(ClientInputTypeOuterClass.ClientInputType value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                ensureUnk3300EBHHFKLDOFBIsMutable();
                this.unk3300EBHHFKLDOFB_.add(Integer.valueOf(value.getNumber()));
                onChanged();
                return this;
            }

            public Builder addAllUnk3300EBHHFKLDOFB(Iterable<? extends ClientInputTypeOuterClass.ClientInputType> values) {
                ensureUnk3300EBHHFKLDOFBIsMutable();
                for (ClientInputTypeOuterClass.ClientInputType value : values) {
                    this.unk3300EBHHFKLDOFB_.add(Integer.valueOf(value.getNumber()));
                }
                onChanged();
                return this;
            }

            public Builder clearUnk3300EBHHFKLDOFB() {
                this.unk3300EBHHFKLDOFB_ = Collections.emptyList();
                this.bitField0_ &= -9;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
            public List<Integer> getUnk3300EBHHFKLDOFBValueList() {
                return Collections.unmodifiableList(this.unk3300EBHHFKLDOFB_);
            }

            @Override // emu.grasscutter.net.proto.LanternProjectionInfoOuterClass.LanternProjectionInfoOrBuilder
            public int getUnk3300EBHHFKLDOFBValue(int index) {
                return this.unk3300EBHHFKLDOFB_.get(index).intValue();
            }

            public Builder setUnk3300EBHHFKLDOFBValue(int index, int value) {
                ensureUnk3300EBHHFKLDOFBIsMutable();
                this.unk3300EBHHFKLDOFB_.set(index, Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addUnk3300EBHHFKLDOFBValue(int value) {
                ensureUnk3300EBHHFKLDOFBIsMutable();
                this.unk3300EBHHFKLDOFB_.add(Integer.valueOf(value));
                onChanged();
                return this;
            }

            public Builder addAllUnk3300EBHHFKLDOFBValue(Iterable<Integer> values) {
                ensureUnk3300EBHHFKLDOFBIsMutable();
                for (Integer num : values) {
                    this.unk3300EBHHFKLDOFB_.add(Integer.valueOf(num.intValue()));
                }
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

        public static LanternProjectionInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<LanternProjectionInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<LanternProjectionInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public LanternProjectionInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ClientInputTypeOuterClass.getDescriptor();
        LanternProjectionLevelInfoOuterClass.getDescriptor();
    }
}
