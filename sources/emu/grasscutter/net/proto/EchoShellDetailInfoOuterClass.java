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
import emu.grasscutter.net.proto.SummerTimeDungeonInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EchoShellDetailInfoOuterClass.class */
public final class EchoShellDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019EchoShellDetailInfo.proto\u001a\u001bSummerTimeDungeonInfo.proto\"¤\u0001\n\u0013EchoShellDetailInfo\u0012\u001b\n\u0013Unk3300_OOCDFANFFDG\u0018\u0006 \u0003(\r\u0012\u0019\n\u0011taken_reward_list\u0018\u0005 \u0003(\r\u00128\n\u0018summer_time_dungeon_list\u0018\u0003 \u0003(\u000b2\u0016.SummerTimeDungeonInfo\u0012\u001b\n\u0013Unk3300_NEFBJPKBEHF\u0018\n \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SummerTimeDungeonInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_EchoShellDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_EchoShellDetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_EchoShellDetailInfo_descriptor, new String[]{"Unk3300OOCDFANFFDG", "TakenRewardList", "SummerTimeDungeonList", "Unk3300NEFBJPKBEHF"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EchoShellDetailInfoOuterClass$EchoShellDetailInfoOrBuilder.class */
    public interface EchoShellDetailInfoOrBuilder extends MessageOrBuilder {
        List<Integer> getUnk3300OOCDFANFFDGList();

        int getUnk3300OOCDFANFFDGCount();

        int getUnk3300OOCDFANFFDG(int i);

        List<Integer> getTakenRewardListList();

        int getTakenRewardListCount();

        int getTakenRewardList(int i);

        List<SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo> getSummerTimeDungeonListList();

        SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo getSummerTimeDungeonList(int i);

        int getSummerTimeDungeonListCount();

        List<? extends SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfoOrBuilder> getSummerTimeDungeonListOrBuilderList();

        SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfoOrBuilder getSummerTimeDungeonListOrBuilder(int i);

        List<Integer> getUnk3300NEFBJPKBEHFList();

        int getUnk3300NEFBJPKBEHFCount();

        int getUnk3300NEFBJPKBEHF(int i);
    }

    private EchoShellDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EchoShellDetailInfoOuterClass$EchoShellDetailInfo.class */
    public static final class EchoShellDetailInfo extends GeneratedMessageV3 implements EchoShellDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_OOCDFANFFDG_FIELD_NUMBER = 6;
        private Internal.IntList unk3300OOCDFANFFDG_;
        private int unk3300OOCDFANFFDGMemoizedSerializedSize;
        public static final int TAKEN_REWARD_LIST_FIELD_NUMBER = 5;
        private Internal.IntList takenRewardList_;
        private int takenRewardListMemoizedSerializedSize;
        public static final int SUMMER_TIME_DUNGEON_LIST_FIELD_NUMBER = 3;
        private List<SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo> summerTimeDungeonList_;
        public static final int UNK3300_NEFBJPKBEHF_FIELD_NUMBER = 10;
        private Internal.IntList unk3300NEFBJPKBEHF_;
        private int unk3300NEFBJPKBEHFMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final EchoShellDetailInfo DEFAULT_INSTANCE = new EchoShellDetailInfo();
        private static final Parser<EchoShellDetailInfo> PARSER = new AbstractParser<EchoShellDetailInfo>() { // from class: emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfo.1
            @Override // com.google.protobuf.Parser
            public EchoShellDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new EchoShellDetailInfo(input, extensionRegistry);
            }
        };

        private EchoShellDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unk3300OOCDFANFFDGMemoizedSerializedSize = -1;
            this.takenRewardListMemoizedSerializedSize = -1;
            this.unk3300NEFBJPKBEHFMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private EchoShellDetailInfo() {
            this.unk3300OOCDFANFFDGMemoizedSerializedSize = -1;
            this.takenRewardListMemoizedSerializedSize = -1;
            this.unk3300NEFBJPKBEHFMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unk3300OOCDFANFFDG_ = emptyIntList();
            this.takenRewardList_ = emptyIntList();
            this.summerTimeDungeonList_ = Collections.emptyList();
            this.unk3300NEFBJPKBEHF_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new EchoShellDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:110:0x01ec */
        private EchoShellDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 26:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.summerTimeDungeonList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.summerTimeDungeonList_.add((SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo) input.readMessage(SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo.parser(), extensionRegistry));
                                break;
                            case 40:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.takenRewardList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.takenRewardList_.addInt(input.readUInt32());
                                break;
                            case 42:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.takenRewardList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.takenRewardList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 48:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.unk3300OOCDFANFFDG_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.unk3300OOCDFANFFDG_.addInt(input.readUInt32());
                                break;
                            case 50:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300OOCDFANFFDG_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300OOCDFANFFDG_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 80:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.unk3300NEFBJPKBEHF_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.unk3300NEFBJPKBEHF_.addInt(input.readUInt32());
                                break;
                            case 82:
                                int limit3 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 8) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.unk3300NEFBJPKBEHF_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.unk3300NEFBJPKBEHF_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit3);
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
                    this.summerTimeDungeonList_ = Collections.unmodifiableList(this.summerTimeDungeonList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.takenRewardList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.unk3300OOCDFANFFDG_.makeImmutable();
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.unk3300NEFBJPKBEHF_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return EchoShellDetailInfoOuterClass.internal_static_EchoShellDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return EchoShellDetailInfoOuterClass.internal_static_EchoShellDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EchoShellDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
        public List<Integer> getUnk3300OOCDFANFFDGList() {
            return this.unk3300OOCDFANFFDG_;
        }

        @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
        public int getUnk3300OOCDFANFFDGCount() {
            return this.unk3300OOCDFANFFDG_.size();
        }

        @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
        public int getUnk3300OOCDFANFFDG(int index) {
            return this.unk3300OOCDFANFFDG_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
        public List<Integer> getTakenRewardListList() {
            return this.takenRewardList_;
        }

        @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
        public int getTakenRewardListCount() {
            return this.takenRewardList_.size();
        }

        @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
        public int getTakenRewardList(int index) {
            return this.takenRewardList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
        public List<SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo> getSummerTimeDungeonListList() {
            return this.summerTimeDungeonList_;
        }

        @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
        public List<? extends SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfoOrBuilder> getSummerTimeDungeonListOrBuilderList() {
            return this.summerTimeDungeonList_;
        }

        @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
        public int getSummerTimeDungeonListCount() {
            return this.summerTimeDungeonList_.size();
        }

        @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
        public SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo getSummerTimeDungeonList(int index) {
            return this.summerTimeDungeonList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
        public SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfoOrBuilder getSummerTimeDungeonListOrBuilder(int index) {
            return this.summerTimeDungeonList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
        public List<Integer> getUnk3300NEFBJPKBEHFList() {
            return this.unk3300NEFBJPKBEHF_;
        }

        @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
        public int getUnk3300NEFBJPKBEHFCount() {
            return this.unk3300NEFBJPKBEHF_.size();
        }

        @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
        public int getUnk3300NEFBJPKBEHF(int index) {
            return this.unk3300NEFBJPKBEHF_.getInt(index);
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
            for (int i = 0; i < this.summerTimeDungeonList_.size(); i++) {
                output.writeMessage(3, this.summerTimeDungeonList_.get(i));
            }
            if (getTakenRewardListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.takenRewardListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.takenRewardList_.size(); i2++) {
                output.writeUInt32NoTag(this.takenRewardList_.getInt(i2));
            }
            if (getUnk3300OOCDFANFFDGList().size() > 0) {
                output.writeUInt32NoTag(50);
                output.writeUInt32NoTag(this.unk3300OOCDFANFFDGMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.unk3300OOCDFANFFDG_.size(); i3++) {
                output.writeUInt32NoTag(this.unk3300OOCDFANFFDG_.getInt(i3));
            }
            if (getUnk3300NEFBJPKBEHFList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.unk3300NEFBJPKBEHFMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.unk3300NEFBJPKBEHF_.size(); i4++) {
                output.writeUInt32NoTag(this.unk3300NEFBJPKBEHF_.getInt(i4));
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
            for (int i = 0; i < this.summerTimeDungeonList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.summerTimeDungeonList_.get(i));
            }
            int dataSize = 0;
            for (int i2 = 0; i2 < this.takenRewardList_.size(); i2++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.takenRewardList_.getInt(i2));
            }
            int size3 = size2 + dataSize;
            if (!getTakenRewardListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.takenRewardListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i3 = 0; i3 < this.unk3300OOCDFANFFDG_.size(); i3++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300OOCDFANFFDG_.getInt(i3));
            }
            int size4 = size3 + dataSize2;
            if (!getUnk3300OOCDFANFFDGList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unk3300OOCDFANFFDGMemoizedSerializedSize = dataSize2;
            int dataSize3 = 0;
            for (int i4 = 0; i4 < this.unk3300NEFBJPKBEHF_.size(); i4++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300NEFBJPKBEHF_.getInt(i4));
            }
            int size5 = size4 + dataSize3;
            if (!getUnk3300NEFBJPKBEHFList().isEmpty()) {
                size5 = size5 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.unk3300NEFBJPKBEHFMemoizedSerializedSize = dataSize3;
            int size6 = size5 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size6;
            return size6;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EchoShellDetailInfo)) {
                return equals(obj);
            }
            EchoShellDetailInfo other = (EchoShellDetailInfo) obj;
            return getUnk3300OOCDFANFFDGList().equals(other.getUnk3300OOCDFANFFDGList()) && getTakenRewardListList().equals(other.getTakenRewardListList()) && getSummerTimeDungeonListList().equals(other.getSummerTimeDungeonListList()) && getUnk3300NEFBJPKBEHFList().equals(other.getUnk3300NEFBJPKBEHFList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getUnk3300OOCDFANFFDGCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getUnk3300OOCDFANFFDGList().hashCode();
            }
            if (getTakenRewardListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getTakenRewardListList().hashCode();
            }
            if (getSummerTimeDungeonListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getSummerTimeDungeonListList().hashCode();
            }
            if (getUnk3300NEFBJPKBEHFCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getUnk3300NEFBJPKBEHFList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static EchoShellDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EchoShellDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EchoShellDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EchoShellDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EchoShellDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static EchoShellDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static EchoShellDetailInfo parseFrom(InputStream input) throws IOException {
            return (EchoShellDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EchoShellDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EchoShellDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static EchoShellDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (EchoShellDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static EchoShellDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EchoShellDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static EchoShellDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (EchoShellDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static EchoShellDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (EchoShellDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(EchoShellDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/EchoShellDetailInfoOuterClass$EchoShellDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements EchoShellDetailInfoOrBuilder {
            private int bitField0_;
            private RepeatedFieldBuilderV3<SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo, SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo.Builder, SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfoOrBuilder> summerTimeDungeonListBuilder_;
            private Internal.IntList unk3300OOCDFANFFDG_ = EchoShellDetailInfo.emptyIntList();
            private Internal.IntList takenRewardList_ = EchoShellDetailInfo.emptyIntList();
            private List<SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo> summerTimeDungeonList_ = Collections.emptyList();
            private Internal.IntList unk3300NEFBJPKBEHF_ = EchoShellDetailInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return EchoShellDetailInfoOuterClass.internal_static_EchoShellDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return EchoShellDetailInfoOuterClass.internal_static_EchoShellDetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(EchoShellDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (EchoShellDetailInfo.alwaysUseFieldBuilders) {
                    getSummerTimeDungeonListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300OOCDFANFFDG_ = EchoShellDetailInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.takenRewardList_ = EchoShellDetailInfo.emptyIntList();
                this.bitField0_ &= -3;
                if (this.summerTimeDungeonListBuilder_ == null) {
                    this.summerTimeDungeonList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.summerTimeDungeonListBuilder_.clear();
                }
                this.unk3300NEFBJPKBEHF_ = EchoShellDetailInfo.emptyIntList();
                this.bitField0_ &= -9;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return EchoShellDetailInfoOuterClass.internal_static_EchoShellDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public EchoShellDetailInfo getDefaultInstanceForType() {
                return EchoShellDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EchoShellDetailInfo build() {
                EchoShellDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public EchoShellDetailInfo buildPartial() {
                EchoShellDetailInfo result = new EchoShellDetailInfo(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.unk3300OOCDFANFFDG_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.unk3300OOCDFANFFDG_ = this.unk3300OOCDFANFFDG_;
                if ((this.bitField0_ & 2) != 0) {
                    this.takenRewardList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.takenRewardList_ = this.takenRewardList_;
                if (this.summerTimeDungeonListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.summerTimeDungeonList_ = Collections.unmodifiableList(this.summerTimeDungeonList_);
                        this.bitField0_ &= -5;
                    }
                    result.summerTimeDungeonList_ = this.summerTimeDungeonList_;
                } else {
                    result.summerTimeDungeonList_ = this.summerTimeDungeonListBuilder_.build();
                }
                if ((this.bitField0_ & 8) != 0) {
                    this.unk3300NEFBJPKBEHF_.makeImmutable();
                    this.bitField0_ &= -9;
                }
                result.unk3300NEFBJPKBEHF_ = this.unk3300NEFBJPKBEHF_;
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
                if (other instanceof EchoShellDetailInfo) {
                    return mergeFrom((EchoShellDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(EchoShellDetailInfo other) {
                if (other == EchoShellDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (!other.unk3300OOCDFANFFDG_.isEmpty()) {
                    if (this.unk3300OOCDFANFFDG_.isEmpty()) {
                        this.unk3300OOCDFANFFDG_ = other.unk3300OOCDFANFFDG_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUnk3300OOCDFANFFDGIsMutable();
                        this.unk3300OOCDFANFFDG_.addAll(other.unk3300OOCDFANFFDG_);
                    }
                    onChanged();
                }
                if (!other.takenRewardList_.isEmpty()) {
                    if (this.takenRewardList_.isEmpty()) {
                        this.takenRewardList_ = other.takenRewardList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureTakenRewardListIsMutable();
                        this.takenRewardList_.addAll(other.takenRewardList_);
                    }
                    onChanged();
                }
                if (this.summerTimeDungeonListBuilder_ == null) {
                    if (!other.summerTimeDungeonList_.isEmpty()) {
                        if (this.summerTimeDungeonList_.isEmpty()) {
                            this.summerTimeDungeonList_ = other.summerTimeDungeonList_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureSummerTimeDungeonListIsMutable();
                            this.summerTimeDungeonList_.addAll(other.summerTimeDungeonList_);
                        }
                        onChanged();
                    }
                } else if (!other.summerTimeDungeonList_.isEmpty()) {
                    if (this.summerTimeDungeonListBuilder_.isEmpty()) {
                        this.summerTimeDungeonListBuilder_.dispose();
                        this.summerTimeDungeonListBuilder_ = null;
                        this.summerTimeDungeonList_ = other.summerTimeDungeonList_;
                        this.bitField0_ &= -5;
                        this.summerTimeDungeonListBuilder_ = EchoShellDetailInfo.alwaysUseFieldBuilders ? getSummerTimeDungeonListFieldBuilder() : null;
                    } else {
                        this.summerTimeDungeonListBuilder_.addAllMessages(other.summerTimeDungeonList_);
                    }
                }
                if (!other.unk3300NEFBJPKBEHF_.isEmpty()) {
                    if (this.unk3300NEFBJPKBEHF_.isEmpty()) {
                        this.unk3300NEFBJPKBEHF_ = other.unk3300NEFBJPKBEHF_;
                        this.bitField0_ &= -9;
                    } else {
                        ensureUnk3300NEFBJPKBEHFIsMutable();
                        this.unk3300NEFBJPKBEHF_.addAll(other.unk3300NEFBJPKBEHF_);
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
                EchoShellDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = EchoShellDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (EchoShellDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureUnk3300OOCDFANFFDGIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unk3300OOCDFANFFDG_ = EchoShellDetailInfo.mutableCopy(this.unk3300OOCDFANFFDG_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
            public List<Integer> getUnk3300OOCDFANFFDGList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.unk3300OOCDFANFFDG_) : this.unk3300OOCDFANFFDG_;
            }

            @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
            public int getUnk3300OOCDFANFFDGCount() {
                return this.unk3300OOCDFANFFDG_.size();
            }

            @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
            public int getUnk3300OOCDFANFFDG(int index) {
                return this.unk3300OOCDFANFFDG_.getInt(index);
            }

            public Builder setUnk3300OOCDFANFFDG(int index, int value) {
                ensureUnk3300OOCDFANFFDGIsMutable();
                this.unk3300OOCDFANFFDG_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300OOCDFANFFDG(int value) {
                ensureUnk3300OOCDFANFFDGIsMutable();
                this.unk3300OOCDFANFFDG_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300OOCDFANFFDG(Iterable<? extends Integer> values) {
                ensureUnk3300OOCDFANFFDGIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300OOCDFANFFDG_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300OOCDFANFFDG() {
                this.unk3300OOCDFANFFDG_ = EchoShellDetailInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureTakenRewardListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.takenRewardList_ = EchoShellDetailInfo.mutableCopy(this.takenRewardList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
            public List<Integer> getTakenRewardListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.takenRewardList_) : this.takenRewardList_;
            }

            @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
            public int getTakenRewardListCount() {
                return this.takenRewardList_.size();
            }

            @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
            public int getTakenRewardList(int index) {
                return this.takenRewardList_.getInt(index);
            }

            public Builder setTakenRewardList(int index, int value) {
                ensureTakenRewardListIsMutable();
                this.takenRewardList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addTakenRewardList(int value) {
                ensureTakenRewardListIsMutable();
                this.takenRewardList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllTakenRewardList(Iterable<? extends Integer> values) {
                ensureTakenRewardListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.takenRewardList_);
                onChanged();
                return this;
            }

            public Builder clearTakenRewardList() {
                this.takenRewardList_ = EchoShellDetailInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureSummerTimeDungeonListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.summerTimeDungeonList_ = new ArrayList(this.summerTimeDungeonList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
            public List<SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo> getSummerTimeDungeonListList() {
                if (this.summerTimeDungeonListBuilder_ == null) {
                    return Collections.unmodifiableList(this.summerTimeDungeonList_);
                }
                return this.summerTimeDungeonListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
            public int getSummerTimeDungeonListCount() {
                if (this.summerTimeDungeonListBuilder_ == null) {
                    return this.summerTimeDungeonList_.size();
                }
                return this.summerTimeDungeonListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
            public SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo getSummerTimeDungeonList(int index) {
                if (this.summerTimeDungeonListBuilder_ == null) {
                    return this.summerTimeDungeonList_.get(index);
                }
                return this.summerTimeDungeonListBuilder_.getMessage(index);
            }

            public Builder setSummerTimeDungeonList(int index, SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo value) {
                if (this.summerTimeDungeonListBuilder_ != null) {
                    this.summerTimeDungeonListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSummerTimeDungeonListIsMutable();
                    this.summerTimeDungeonList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setSummerTimeDungeonList(int index, SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo.Builder builderForValue) {
                if (this.summerTimeDungeonListBuilder_ == null) {
                    ensureSummerTimeDungeonListIsMutable();
                    this.summerTimeDungeonList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.summerTimeDungeonListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSummerTimeDungeonList(SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo value) {
                if (this.summerTimeDungeonListBuilder_ != null) {
                    this.summerTimeDungeonListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSummerTimeDungeonListIsMutable();
                    this.summerTimeDungeonList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addSummerTimeDungeonList(int index, SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo value) {
                if (this.summerTimeDungeonListBuilder_ != null) {
                    this.summerTimeDungeonListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSummerTimeDungeonListIsMutable();
                    this.summerTimeDungeonList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addSummerTimeDungeonList(SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo.Builder builderForValue) {
                if (this.summerTimeDungeonListBuilder_ == null) {
                    ensureSummerTimeDungeonListIsMutable();
                    this.summerTimeDungeonList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.summerTimeDungeonListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSummerTimeDungeonList(int index, SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo.Builder builderForValue) {
                if (this.summerTimeDungeonListBuilder_ == null) {
                    ensureSummerTimeDungeonListIsMutable();
                    this.summerTimeDungeonList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.summerTimeDungeonListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSummerTimeDungeonList(Iterable<? extends SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo> values) {
                if (this.summerTimeDungeonListBuilder_ == null) {
                    ensureSummerTimeDungeonListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.summerTimeDungeonList_);
                    onChanged();
                } else {
                    this.summerTimeDungeonListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSummerTimeDungeonList() {
                if (this.summerTimeDungeonListBuilder_ == null) {
                    this.summerTimeDungeonList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.summerTimeDungeonListBuilder_.clear();
                }
                return this;
            }

            public Builder removeSummerTimeDungeonList(int index) {
                if (this.summerTimeDungeonListBuilder_ == null) {
                    ensureSummerTimeDungeonListIsMutable();
                    this.summerTimeDungeonList_.remove(index);
                    onChanged();
                } else {
                    this.summerTimeDungeonListBuilder_.remove(index);
                }
                return this;
            }

            public SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo.Builder getSummerTimeDungeonListBuilder(int index) {
                return getSummerTimeDungeonListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
            public SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfoOrBuilder getSummerTimeDungeonListOrBuilder(int index) {
                if (this.summerTimeDungeonListBuilder_ == null) {
                    return this.summerTimeDungeonList_.get(index);
                }
                return this.summerTimeDungeonListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
            public List<? extends SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfoOrBuilder> getSummerTimeDungeonListOrBuilderList() {
                if (this.summerTimeDungeonListBuilder_ != null) {
                    return this.summerTimeDungeonListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.summerTimeDungeonList_);
            }

            public SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo.Builder addSummerTimeDungeonListBuilder() {
                return getSummerTimeDungeonListFieldBuilder().addBuilder(SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo.getDefaultInstance());
            }

            public SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo.Builder addSummerTimeDungeonListBuilder(int index) {
                return getSummerTimeDungeonListFieldBuilder().addBuilder(index, SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo.getDefaultInstance());
            }

            public List<SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo.Builder> getSummerTimeDungeonListBuilderList() {
                return getSummerTimeDungeonListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo, SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfo.Builder, SummerTimeDungeonInfoOuterClass.SummerTimeDungeonInfoOrBuilder> getSummerTimeDungeonListFieldBuilder() {
                if (this.summerTimeDungeonListBuilder_ == null) {
                    this.summerTimeDungeonListBuilder_ = new RepeatedFieldBuilderV3<>(this.summerTimeDungeonList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.summerTimeDungeonList_ = null;
                }
                return this.summerTimeDungeonListBuilder_;
            }

            private void ensureUnk3300NEFBJPKBEHFIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.unk3300NEFBJPKBEHF_ = EchoShellDetailInfo.mutableCopy(this.unk3300NEFBJPKBEHF_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
            public List<Integer> getUnk3300NEFBJPKBEHFList() {
                return (this.bitField0_ & 8) != 0 ? Collections.unmodifiableList(this.unk3300NEFBJPKBEHF_) : this.unk3300NEFBJPKBEHF_;
            }

            @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
            public int getUnk3300NEFBJPKBEHFCount() {
                return this.unk3300NEFBJPKBEHF_.size();
            }

            @Override // emu.grasscutter.net.proto.EchoShellDetailInfoOuterClass.EchoShellDetailInfoOrBuilder
            public int getUnk3300NEFBJPKBEHF(int index) {
                return this.unk3300NEFBJPKBEHF_.getInt(index);
            }

            public Builder setUnk3300NEFBJPKBEHF(int index, int value) {
                ensureUnk3300NEFBJPKBEHFIsMutable();
                this.unk3300NEFBJPKBEHF_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300NEFBJPKBEHF(int value) {
                ensureUnk3300NEFBJPKBEHFIsMutable();
                this.unk3300NEFBJPKBEHF_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300NEFBJPKBEHF(Iterable<? extends Integer> values) {
                ensureUnk3300NEFBJPKBEHFIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300NEFBJPKBEHF_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300NEFBJPKBEHF() {
                this.unk3300NEFBJPKBEHF_ = EchoShellDetailInfo.emptyIntList();
                this.bitField0_ &= -9;
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

        public static EchoShellDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<EchoShellDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<EchoShellDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public EchoShellDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SummerTimeDungeonInfoOuterClass.getDescriptor();
    }
}
