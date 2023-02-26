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
import emu.grasscutter.net.proto.FetterDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarFetterInfoOuterClass.class */
public final class AvatarFetterInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016AvatarFetterInfo.proto\u001a\u0010FetterData.proto\"£\u0001\n\u0010AvatarFetterInfo\u0012\u0011\n\texpNumber\u0018\u0001 \u0001(\r\u0012\u0010\n\bexpLevel\u0018\u0002 \u0001(\r\u0012\u0012\n\nopenIdList\u0018\u0003 \u0003(\r\u0012\u0014\n\ffinishIdList\u0018\u0004 \u0003(\r\u0012\u001f\n\u0017rewardedFetterLevelList\u0018\u0005 \u0003(\r\u0012\u001f\n\nfetterList\u0018\u0006 \u0003(\u000b2\u000b.FetterDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FetterDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AvatarFetterInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarFetterInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarFetterInfo_descriptor, new String[]{"ExpNumber", "ExpLevel", "OpenIdList", "FinishIdList", "RewardedFetterLevelList", "FetterList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarFetterInfoOuterClass$AvatarFetterInfoOrBuilder.class */
    public interface AvatarFetterInfoOrBuilder extends MessageOrBuilder {
        int getExpNumber();

        int getExpLevel();

        List<Integer> getOpenIdListList();

        int getOpenIdListCount();

        int getOpenIdList(int i);

        List<Integer> getFinishIdListList();

        int getFinishIdListCount();

        int getFinishIdList(int i);

        List<Integer> getRewardedFetterLevelListList();

        int getRewardedFetterLevelListCount();

        int getRewardedFetterLevelList(int i);

        List<FetterDataOuterClass.FetterData> getFetterListList();

        FetterDataOuterClass.FetterData getFetterList(int i);

        int getFetterListCount();

        List<? extends FetterDataOuterClass.FetterDataOrBuilder> getFetterListOrBuilderList();

        FetterDataOuterClass.FetterDataOrBuilder getFetterListOrBuilder(int i);
    }

    private AvatarFetterInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarFetterInfoOuterClass$AvatarFetterInfo.class */
    public static final class AvatarFetterInfo extends GeneratedMessageV3 implements AvatarFetterInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int EXPNUMBER_FIELD_NUMBER = 1;
        private int expNumber_;
        public static final int EXPLEVEL_FIELD_NUMBER = 2;
        private int expLevel_;
        public static final int OPENIDLIST_FIELD_NUMBER = 3;
        private Internal.IntList openIdList_;
        private int openIdListMemoizedSerializedSize;
        public static final int FINISHIDLIST_FIELD_NUMBER = 4;
        private Internal.IntList finishIdList_;
        private int finishIdListMemoizedSerializedSize;
        public static final int REWARDEDFETTERLEVELLIST_FIELD_NUMBER = 5;
        private Internal.IntList rewardedFetterLevelList_;
        private int rewardedFetterLevelListMemoizedSerializedSize;
        public static final int FETTERLIST_FIELD_NUMBER = 6;
        private List<FetterDataOuterClass.FetterData> fetterList_;
        private byte memoizedIsInitialized;
        private static final AvatarFetterInfo DEFAULT_INSTANCE = new AvatarFetterInfo();
        private static final Parser<AvatarFetterInfo> PARSER = new AbstractParser<AvatarFetterInfo>() { // from class: emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfo.1
            @Override // com.google.protobuf.Parser
            public AvatarFetterInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarFetterInfo(input, extensionRegistry);
            }
        };

        private AvatarFetterInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.openIdListMemoizedSerializedSize = -1;
            this.finishIdListMemoizedSerializedSize = -1;
            this.rewardedFetterLevelListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private AvatarFetterInfo() {
            this.openIdListMemoizedSerializedSize = -1;
            this.finishIdListMemoizedSerializedSize = -1;
            this.rewardedFetterLevelListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.openIdList_ = emptyIntList();
            this.finishIdList_ = emptyIntList();
            this.rewardedFetterLevelList_ = emptyIntList();
            this.fetterList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarFetterInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:114:0x0210 */
        private AvatarFetterInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.expNumber_ = input.readUInt32();
                                break;
                            case 16:
                                this.expLevel_ = input.readUInt32();
                                break;
                            case 24:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.openIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.openIdList_.addInt(input.readUInt32());
                                break;
                            case 26:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.openIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.openIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 32:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.finishIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.finishIdList_.addInt(input.readUInt32());
                                break;
                            case 34:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.finishIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.finishIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 40:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.rewardedFetterLevelList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.rewardedFetterLevelList_.addInt(input.readUInt32());
                                break;
                            case 42:
                                int limit3 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 4) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.rewardedFetterLevelList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.rewardedFetterLevelList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit3);
                                break;
                            case 50:
                                if ((mutable_bitField0_ & 8) == 0) {
                                    this.fetterList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                }
                                this.fetterList_.add((FetterDataOuterClass.FetterData) input.readMessage(FetterDataOuterClass.FetterData.parser(), extensionRegistry));
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
                    this.openIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.finishIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.rewardedFetterLevelList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.fetterList_ = Collections.unmodifiableList(this.fetterList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvatarFetterInfoOuterClass.internal_static_AvatarFetterInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarFetterInfoOuterClass.internal_static_AvatarFetterInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarFetterInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
        public int getExpNumber() {
            return this.expNumber_;
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
        public int getExpLevel() {
            return this.expLevel_;
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
        public List<Integer> getOpenIdListList() {
            return this.openIdList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
        public int getOpenIdListCount() {
            return this.openIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
        public int getOpenIdList(int index) {
            return this.openIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
        public List<Integer> getFinishIdListList() {
            return this.finishIdList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
        public int getFinishIdListCount() {
            return this.finishIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
        public int getFinishIdList(int index) {
            return this.finishIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
        public List<Integer> getRewardedFetterLevelListList() {
            return this.rewardedFetterLevelList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
        public int getRewardedFetterLevelListCount() {
            return this.rewardedFetterLevelList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
        public int getRewardedFetterLevelList(int index) {
            return this.rewardedFetterLevelList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
        public List<FetterDataOuterClass.FetterData> getFetterListList() {
            return this.fetterList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
        public List<? extends FetterDataOuterClass.FetterDataOrBuilder> getFetterListOrBuilderList() {
            return this.fetterList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
        public int getFetterListCount() {
            return this.fetterList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
        public FetterDataOuterClass.FetterData getFetterList(int index) {
            return this.fetterList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
        public FetterDataOuterClass.FetterDataOrBuilder getFetterListOrBuilder(int index) {
            return this.fetterList_.get(index);
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
            if (this.expNumber_ != 0) {
                output.writeUInt32(1, this.expNumber_);
            }
            if (this.expLevel_ != 0) {
                output.writeUInt32(2, this.expLevel_);
            }
            if (getOpenIdListList().size() > 0) {
                output.writeUInt32NoTag(26);
                output.writeUInt32NoTag(this.openIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.openIdList_.size(); i++) {
                output.writeUInt32NoTag(this.openIdList_.getInt(i));
            }
            if (getFinishIdListList().size() > 0) {
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.finishIdListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.finishIdList_.size(); i2++) {
                output.writeUInt32NoTag(this.finishIdList_.getInt(i2));
            }
            if (getRewardedFetterLevelListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.rewardedFetterLevelListMemoizedSerializedSize);
            }
            for (int i3 = 0; i3 < this.rewardedFetterLevelList_.size(); i3++) {
                output.writeUInt32NoTag(this.rewardedFetterLevelList_.getInt(i3));
            }
            for (int i4 = 0; i4 < this.fetterList_.size(); i4++) {
                output.writeMessage(6, this.fetterList_.get(i4));
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
            if (this.expNumber_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.expNumber_);
            }
            if (this.expLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.expLevel_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.openIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.openIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getOpenIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.openIdListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.finishIdList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.finishIdList_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getFinishIdListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.finishIdListMemoizedSerializedSize = dataSize2;
            int dataSize3 = 0;
            for (int i3 = 0; i3 < this.rewardedFetterLevelList_.size(); i3++) {
                dataSize3 += CodedOutputStream.computeUInt32SizeNoTag(this.rewardedFetterLevelList_.getInt(i3));
            }
            int size5 = size4 + dataSize3;
            if (!getRewardedFetterLevelListList().isEmpty()) {
                size5 = size5 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize3);
            }
            this.rewardedFetterLevelListMemoizedSerializedSize = dataSize3;
            for (int i4 = 0; i4 < this.fetterList_.size(); i4++) {
                size5 += CodedOutputStream.computeMessageSize(6, this.fetterList_.get(i4));
            }
            int size6 = size5 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size6;
            return size6;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AvatarFetterInfo)) {
                return equals(obj);
            }
            AvatarFetterInfo other = (AvatarFetterInfo) obj;
            return getExpNumber() == other.getExpNumber() && getExpLevel() == other.getExpLevel() && getOpenIdListList().equals(other.getOpenIdListList()) && getFinishIdListList().equals(other.getFinishIdListList()) && getRewardedFetterLevelListList().equals(other.getRewardedFetterLevelListList()) && getFetterListList().equals(other.getFetterListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getExpNumber())) + 2)) + getExpLevel();
            if (getOpenIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getOpenIdListList().hashCode();
            }
            if (getFinishIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getFinishIdListList().hashCode();
            }
            if (getRewardedFetterLevelListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getRewardedFetterLevelListList().hashCode();
            }
            if (getFetterListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getFetterListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarFetterInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarFetterInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarFetterInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarFetterInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarFetterInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarFetterInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarFetterInfo parseFrom(InputStream input) throws IOException {
            return (AvatarFetterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarFetterInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarFetterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarFetterInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarFetterInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarFetterInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarFetterInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarFetterInfo parseFrom(CodedInputStream input) throws IOException {
            return (AvatarFetterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarFetterInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarFetterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarFetterInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarFetterInfoOuterClass$AvatarFetterInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarFetterInfoOrBuilder {
            private int bitField0_;
            private int expNumber_;
            private int expLevel_;
            private Internal.IntList openIdList_ = AvatarFetterInfo.emptyIntList();
            private Internal.IntList finishIdList_ = AvatarFetterInfo.emptyIntList();
            private Internal.IntList rewardedFetterLevelList_ = AvatarFetterInfo.emptyIntList();
            private List<FetterDataOuterClass.FetterData> fetterList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<FetterDataOuterClass.FetterData, FetterDataOuterClass.FetterData.Builder, FetterDataOuterClass.FetterDataOrBuilder> fetterListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarFetterInfoOuterClass.internal_static_AvatarFetterInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarFetterInfoOuterClass.internal_static_AvatarFetterInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarFetterInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarFetterInfo.alwaysUseFieldBuilders) {
                    getFetterListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.expNumber_ = 0;
                this.expLevel_ = 0;
                this.openIdList_ = AvatarFetterInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.finishIdList_ = AvatarFetterInfo.emptyIntList();
                this.bitField0_ &= -3;
                this.rewardedFetterLevelList_ = AvatarFetterInfo.emptyIntList();
                this.bitField0_ &= -5;
                if (this.fetterListBuilder_ == null) {
                    this.fetterList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.fetterListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarFetterInfoOuterClass.internal_static_AvatarFetterInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarFetterInfo getDefaultInstanceForType() {
                return AvatarFetterInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarFetterInfo build() {
                AvatarFetterInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarFetterInfo buildPartial() {
                AvatarFetterInfo result = new AvatarFetterInfo(this);
                int i = this.bitField0_;
                result.expNumber_ = this.expNumber_;
                result.expLevel_ = this.expLevel_;
                if ((this.bitField0_ & 1) != 0) {
                    this.openIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.openIdList_ = this.openIdList_;
                if ((this.bitField0_ & 2) != 0) {
                    this.finishIdList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.finishIdList_ = this.finishIdList_;
                if ((this.bitField0_ & 4) != 0) {
                    this.rewardedFetterLevelList_.makeImmutable();
                    this.bitField0_ &= -5;
                }
                result.rewardedFetterLevelList_ = this.rewardedFetterLevelList_;
                if (this.fetterListBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.fetterList_ = Collections.unmodifiableList(this.fetterList_);
                        this.bitField0_ &= -9;
                    }
                    result.fetterList_ = this.fetterList_;
                } else {
                    result.fetterList_ = this.fetterListBuilder_.build();
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
                if (other instanceof AvatarFetterInfo) {
                    return mergeFrom((AvatarFetterInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarFetterInfo other) {
                if (other == AvatarFetterInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getExpNumber() != 0) {
                    setExpNumber(other.getExpNumber());
                }
                if (other.getExpLevel() != 0) {
                    setExpLevel(other.getExpLevel());
                }
                if (!other.openIdList_.isEmpty()) {
                    if (this.openIdList_.isEmpty()) {
                        this.openIdList_ = other.openIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureOpenIdListIsMutable();
                        this.openIdList_.addAll(other.openIdList_);
                    }
                    onChanged();
                }
                if (!other.finishIdList_.isEmpty()) {
                    if (this.finishIdList_.isEmpty()) {
                        this.finishIdList_ = other.finishIdList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureFinishIdListIsMutable();
                        this.finishIdList_.addAll(other.finishIdList_);
                    }
                    onChanged();
                }
                if (!other.rewardedFetterLevelList_.isEmpty()) {
                    if (this.rewardedFetterLevelList_.isEmpty()) {
                        this.rewardedFetterLevelList_ = other.rewardedFetterLevelList_;
                        this.bitField0_ &= -5;
                    } else {
                        ensureRewardedFetterLevelListIsMutable();
                        this.rewardedFetterLevelList_.addAll(other.rewardedFetterLevelList_);
                    }
                    onChanged();
                }
                if (this.fetterListBuilder_ == null) {
                    if (!other.fetterList_.isEmpty()) {
                        if (this.fetterList_.isEmpty()) {
                            this.fetterList_ = other.fetterList_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureFetterListIsMutable();
                            this.fetterList_.addAll(other.fetterList_);
                        }
                        onChanged();
                    }
                } else if (!other.fetterList_.isEmpty()) {
                    if (this.fetterListBuilder_.isEmpty()) {
                        this.fetterListBuilder_.dispose();
                        this.fetterListBuilder_ = null;
                        this.fetterList_ = other.fetterList_;
                        this.bitField0_ &= -9;
                        this.fetterListBuilder_ = AvatarFetterInfo.alwaysUseFieldBuilders ? getFetterListFieldBuilder() : null;
                    } else {
                        this.fetterListBuilder_.addAllMessages(other.fetterList_);
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
                AvatarFetterInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarFetterInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarFetterInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
            public int getExpNumber() {
                return this.expNumber_;
            }

            public Builder setExpNumber(int value) {
                this.expNumber_ = value;
                onChanged();
                return this;
            }

            public Builder clearExpNumber() {
                this.expNumber_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
            public int getExpLevel() {
                return this.expLevel_;
            }

            public Builder setExpLevel(int value) {
                this.expLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearExpLevel() {
                this.expLevel_ = 0;
                onChanged();
                return this;
            }

            private void ensureOpenIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.openIdList_ = AvatarFetterInfo.mutableCopy(this.openIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
            public List<Integer> getOpenIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.openIdList_) : this.openIdList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
            public int getOpenIdListCount() {
                return this.openIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
            public int getOpenIdList(int index) {
                return this.openIdList_.getInt(index);
            }

            public Builder setOpenIdList(int index, int value) {
                ensureOpenIdListIsMutable();
                this.openIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addOpenIdList(int value) {
                ensureOpenIdListIsMutable();
                this.openIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllOpenIdList(Iterable<? extends Integer> values) {
                ensureOpenIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.openIdList_);
                onChanged();
                return this;
            }

            public Builder clearOpenIdList() {
                this.openIdList_ = AvatarFetterInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureFinishIdListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.finishIdList_ = AvatarFetterInfo.mutableCopy(this.finishIdList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
            public List<Integer> getFinishIdListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.finishIdList_) : this.finishIdList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
            public int getFinishIdListCount() {
                return this.finishIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
            public int getFinishIdList(int index) {
                return this.finishIdList_.getInt(index);
            }

            public Builder setFinishIdList(int index, int value) {
                ensureFinishIdListIsMutable();
                this.finishIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addFinishIdList(int value) {
                ensureFinishIdListIsMutable();
                this.finishIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllFinishIdList(Iterable<? extends Integer> values) {
                ensureFinishIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.finishIdList_);
                onChanged();
                return this;
            }

            public Builder clearFinishIdList() {
                this.finishIdList_ = AvatarFetterInfo.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            private void ensureRewardedFetterLevelListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.rewardedFetterLevelList_ = AvatarFetterInfo.mutableCopy(this.rewardedFetterLevelList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
            public List<Integer> getRewardedFetterLevelListList() {
                return (this.bitField0_ & 4) != 0 ? Collections.unmodifiableList(this.rewardedFetterLevelList_) : this.rewardedFetterLevelList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
            public int getRewardedFetterLevelListCount() {
                return this.rewardedFetterLevelList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
            public int getRewardedFetterLevelList(int index) {
                return this.rewardedFetterLevelList_.getInt(index);
            }

            public Builder setRewardedFetterLevelList(int index, int value) {
                ensureRewardedFetterLevelListIsMutable();
                this.rewardedFetterLevelList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addRewardedFetterLevelList(int value) {
                ensureRewardedFetterLevelListIsMutable();
                this.rewardedFetterLevelList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllRewardedFetterLevelList(Iterable<? extends Integer> values) {
                ensureRewardedFetterLevelListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.rewardedFetterLevelList_);
                onChanged();
                return this;
            }

            public Builder clearRewardedFetterLevelList() {
                this.rewardedFetterLevelList_ = AvatarFetterInfo.emptyIntList();
                this.bitField0_ &= -5;
                onChanged();
                return this;
            }

            private void ensureFetterListIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.fetterList_ = new ArrayList(this.fetterList_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
            public List<FetterDataOuterClass.FetterData> getFetterListList() {
                if (this.fetterListBuilder_ == null) {
                    return Collections.unmodifiableList(this.fetterList_);
                }
                return this.fetterListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
            public int getFetterListCount() {
                if (this.fetterListBuilder_ == null) {
                    return this.fetterList_.size();
                }
                return this.fetterListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
            public FetterDataOuterClass.FetterData getFetterList(int index) {
                if (this.fetterListBuilder_ == null) {
                    return this.fetterList_.get(index);
                }
                return this.fetterListBuilder_.getMessage(index);
            }

            public Builder setFetterList(int index, FetterDataOuterClass.FetterData value) {
                if (this.fetterListBuilder_ != null) {
                    this.fetterListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFetterListIsMutable();
                    this.fetterList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setFetterList(int index, FetterDataOuterClass.FetterData.Builder builderForValue) {
                if (this.fetterListBuilder_ == null) {
                    ensureFetterListIsMutable();
                    this.fetterList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fetterListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addFetterList(FetterDataOuterClass.FetterData value) {
                if (this.fetterListBuilder_ != null) {
                    this.fetterListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFetterListIsMutable();
                    this.fetterList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addFetterList(int index, FetterDataOuterClass.FetterData value) {
                if (this.fetterListBuilder_ != null) {
                    this.fetterListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFetterListIsMutable();
                    this.fetterList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addFetterList(FetterDataOuterClass.FetterData.Builder builderForValue) {
                if (this.fetterListBuilder_ == null) {
                    ensureFetterListIsMutable();
                    this.fetterList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.fetterListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addFetterList(int index, FetterDataOuterClass.FetterData.Builder builderForValue) {
                if (this.fetterListBuilder_ == null) {
                    ensureFetterListIsMutable();
                    this.fetterList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fetterListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllFetterList(Iterable<? extends FetterDataOuterClass.FetterData> values) {
                if (this.fetterListBuilder_ == null) {
                    ensureFetterListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.fetterList_);
                    onChanged();
                } else {
                    this.fetterListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFetterList() {
                if (this.fetterListBuilder_ == null) {
                    this.fetterList_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.fetterListBuilder_.clear();
                }
                return this;
            }

            public Builder removeFetterList(int index) {
                if (this.fetterListBuilder_ == null) {
                    ensureFetterListIsMutable();
                    this.fetterList_.remove(index);
                    onChanged();
                } else {
                    this.fetterListBuilder_.remove(index);
                }
                return this;
            }

            public FetterDataOuterClass.FetterData.Builder getFetterListBuilder(int index) {
                return getFetterListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
            public FetterDataOuterClass.FetterDataOrBuilder getFetterListOrBuilder(int index) {
                if (this.fetterListBuilder_ == null) {
                    return this.fetterList_.get(index);
                }
                return this.fetterListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AvatarFetterInfoOuterClass.AvatarFetterInfoOrBuilder
            public List<? extends FetterDataOuterClass.FetterDataOrBuilder> getFetterListOrBuilderList() {
                if (this.fetterListBuilder_ != null) {
                    return this.fetterListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.fetterList_);
            }

            public FetterDataOuterClass.FetterData.Builder addFetterListBuilder() {
                return getFetterListFieldBuilder().addBuilder(FetterDataOuterClass.FetterData.getDefaultInstance());
            }

            public FetterDataOuterClass.FetterData.Builder addFetterListBuilder(int index) {
                return getFetterListFieldBuilder().addBuilder(index, FetterDataOuterClass.FetterData.getDefaultInstance());
            }

            public List<FetterDataOuterClass.FetterData.Builder> getFetterListBuilderList() {
                return getFetterListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FetterDataOuterClass.FetterData, FetterDataOuterClass.FetterData.Builder, FetterDataOuterClass.FetterDataOrBuilder> getFetterListFieldBuilder() {
                if (this.fetterListBuilder_ == null) {
                    this.fetterListBuilder_ = new RepeatedFieldBuilderV3<>(this.fetterList_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.fetterList_ = null;
                }
                return this.fetterListBuilder_;
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

        public static AvatarFetterInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarFetterInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarFetterInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarFetterInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FetterDataOuterClass.getDescriptor();
    }
}
