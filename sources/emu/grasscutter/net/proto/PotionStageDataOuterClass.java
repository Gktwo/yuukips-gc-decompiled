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
import emu.grasscutter.net.proto.PotionLevelDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PotionStageDataOuterClass.class */
public final class PotionStageDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015PotionStageData.proto\u001a\u0015PotionLevelData.proto\"\u0001\n\u000fPotionStageData\u0012\u001b\n\u0013Unk3300_BMEHJHFCPMA\u0018\u0007 \u0003(\r\u0012\u001b\n\u0013Unk3300_NLMEPPPMCKI\u0018\t \u0003(\r\u0012\u0010\n\bstage_id\u0018\r \u0001(\r\u0012\u000f\n\u0007is_open\u0018\b \u0001(\b\u0012$\n\nlevel_list\u0018\u000b \u0003(\u000b2\u0010.PotionLevelDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PotionLevelDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PotionStageData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PotionStageData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PotionStageData_descriptor, new String[]{"Unk3300BMEHJHFCPMA", "Unk3300NLMEPPPMCKI", "StageId", "IsOpen", "LevelList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PotionStageDataOuterClass$PotionStageDataOrBuilder.class */
    public interface PotionStageDataOrBuilder extends MessageOrBuilder {
        List<Integer> getUnk3300BMEHJHFCPMAList();

        int getUnk3300BMEHJHFCPMACount();

        int getUnk3300BMEHJHFCPMA(int i);

        List<Integer> getUnk3300NLMEPPPMCKIList();

        int getUnk3300NLMEPPPMCKICount();

        int getUnk3300NLMEPPPMCKI(int i);

        int getStageId();

        boolean getIsOpen();

        List<PotionLevelDataOuterClass.PotionLevelData> getLevelListList();

        PotionLevelDataOuterClass.PotionLevelData getLevelList(int i);

        int getLevelListCount();

        List<? extends PotionLevelDataOuterClass.PotionLevelDataOrBuilder> getLevelListOrBuilderList();

        PotionLevelDataOuterClass.PotionLevelDataOrBuilder getLevelListOrBuilder(int i);
    }

    private PotionStageDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PotionStageDataOuterClass$PotionStageData.class */
    public static final class PotionStageData extends GeneratedMessageV3 implements PotionStageDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_BMEHJHFCPMA_FIELD_NUMBER = 7;
        private Internal.IntList unk3300BMEHJHFCPMA_;
        private int unk3300BMEHJHFCPMAMemoizedSerializedSize;
        public static final int UNK3300_NLMEPPPMCKI_FIELD_NUMBER = 9;
        private Internal.IntList unk3300NLMEPPPMCKI_;
        private int unk3300NLMEPPPMCKIMemoizedSerializedSize;
        public static final int STAGE_ID_FIELD_NUMBER = 13;
        private int stageId_;
        public static final int IS_OPEN_FIELD_NUMBER = 8;
        private boolean isOpen_;
        public static final int LEVEL_LIST_FIELD_NUMBER = 11;
        private List<PotionLevelDataOuterClass.PotionLevelData> levelList_;
        private byte memoizedIsInitialized;
        private static final PotionStageData DEFAULT_INSTANCE = new PotionStageData();
        private static final Parser<PotionStageData> PARSER = new AbstractParser<PotionStageData>() { // from class: emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageData.1
            @Override // com.google.protobuf.Parser
            public PotionStageData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PotionStageData(input, extensionRegistry);
            }
        };

        private PotionStageData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.unk3300BMEHJHFCPMAMemoizedSerializedSize = -1;
            this.unk3300NLMEPPPMCKIMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private PotionStageData() {
            this.unk3300BMEHJHFCPMAMemoizedSerializedSize = -1;
            this.unk3300NLMEPPPMCKIMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.unk3300BMEHJHFCPMA_ = emptyIntList();
            this.unk3300NLMEPPPMCKI_ = emptyIntList();
            this.levelList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PotionStageData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:93:0x0197 */
        private PotionStageData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 56:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.unk3300BMEHJHFCPMA_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.unk3300BMEHJHFCPMA_.addInt(input.readUInt32());
                                    break;
                                case 58:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.unk3300BMEHJHFCPMA_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.unk3300BMEHJHFCPMA_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit);
                                    break;
                                case 64:
                                    this.isOpen_ = input.readBool();
                                    break;
                                case 72:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.unk3300NLMEPPPMCKI_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.unk3300NLMEPPPMCKI_.addInt(input.readUInt32());
                                    break;
                                case 74:
                                    int limit2 = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.unk3300NLMEPPPMCKI_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.unk3300NLMEPPPMCKI_.addInt(input.readUInt32());
                                    }
                                    input.popLimit(limit2);
                                    break;
                                case 90:
                                    if ((mutable_bitField0_ & 4) == 0) {
                                        this.levelList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    this.levelList_.add((PotionLevelDataOuterClass.PotionLevelData) input.readMessage(PotionLevelDataOuterClass.PotionLevelData.parser(), extensionRegistry));
                                    break;
                                case 104:
                                    this.stageId_ = input.readUInt32();
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.unk3300BMEHJHFCPMA_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.unk3300NLMEPPPMCKI_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.levelList_ = Collections.unmodifiableList(this.levelList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PotionStageDataOuterClass.internal_static_PotionStageData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PotionStageDataOuterClass.internal_static_PotionStageData_fieldAccessorTable.ensureFieldAccessorsInitialized(PotionStageData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
        public List<Integer> getUnk3300BMEHJHFCPMAList() {
            return this.unk3300BMEHJHFCPMA_;
        }

        @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
        public int getUnk3300BMEHJHFCPMACount() {
            return this.unk3300BMEHJHFCPMA_.size();
        }

        @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
        public int getUnk3300BMEHJHFCPMA(int index) {
            return this.unk3300BMEHJHFCPMA_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
        public List<Integer> getUnk3300NLMEPPPMCKIList() {
            return this.unk3300NLMEPPPMCKI_;
        }

        @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
        public int getUnk3300NLMEPPPMCKICount() {
            return this.unk3300NLMEPPPMCKI_.size();
        }

        @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
        public int getUnk3300NLMEPPPMCKI(int index) {
            return this.unk3300NLMEPPPMCKI_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
        public int getStageId() {
            return this.stageId_;
        }

        @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
        public boolean getIsOpen() {
            return this.isOpen_;
        }

        @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
        public List<PotionLevelDataOuterClass.PotionLevelData> getLevelListList() {
            return this.levelList_;
        }

        @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
        public List<? extends PotionLevelDataOuterClass.PotionLevelDataOrBuilder> getLevelListOrBuilderList() {
            return this.levelList_;
        }

        @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
        public int getLevelListCount() {
            return this.levelList_.size();
        }

        @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
        public PotionLevelDataOuterClass.PotionLevelData getLevelList(int index) {
            return this.levelList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
        public PotionLevelDataOuterClass.PotionLevelDataOrBuilder getLevelListOrBuilder(int index) {
            return this.levelList_.get(index);
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
            if (getUnk3300BMEHJHFCPMAList().size() > 0) {
                output.writeUInt32NoTag(58);
                output.writeUInt32NoTag(this.unk3300BMEHJHFCPMAMemoizedSerializedSize);
            }
            for (int i = 0; i < this.unk3300BMEHJHFCPMA_.size(); i++) {
                output.writeUInt32NoTag(this.unk3300BMEHJHFCPMA_.getInt(i));
            }
            if (this.isOpen_) {
                output.writeBool(8, this.isOpen_);
            }
            if (getUnk3300NLMEPPPMCKIList().size() > 0) {
                output.writeUInt32NoTag(74);
                output.writeUInt32NoTag(this.unk3300NLMEPPPMCKIMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.unk3300NLMEPPPMCKI_.size(); i2++) {
                output.writeUInt32NoTag(this.unk3300NLMEPPPMCKI_.getInt(i2));
            }
            for (int i3 = 0; i3 < this.levelList_.size(); i3++) {
                output.writeMessage(11, this.levelList_.get(i3));
            }
            if (this.stageId_ != 0) {
                output.writeUInt32(13, this.stageId_);
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
            for (int i = 0; i < this.unk3300BMEHJHFCPMA_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300BMEHJHFCPMA_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getUnk3300BMEHJHFCPMAList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.unk3300BMEHJHFCPMAMemoizedSerializedSize = dataSize;
            if (this.isOpen_) {
                size2 += CodedOutputStream.computeBoolSize(8, this.isOpen_);
            }
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.unk3300NLMEPPPMCKI_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.unk3300NLMEPPPMCKI_.getInt(i2));
            }
            int size3 = size2 + dataSize2;
            if (!getUnk3300NLMEPPPMCKIList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.unk3300NLMEPPPMCKIMemoizedSerializedSize = dataSize2;
            for (int i3 = 0; i3 < this.levelList_.size(); i3++) {
                size3 += CodedOutputStream.computeMessageSize(11, this.levelList_.get(i3));
            }
            if (this.stageId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(13, this.stageId_);
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
            if (!(obj instanceof PotionStageData)) {
                return equals(obj);
            }
            PotionStageData other = (PotionStageData) obj;
            return getUnk3300BMEHJHFCPMAList().equals(other.getUnk3300BMEHJHFCPMAList()) && getUnk3300NLMEPPPMCKIList().equals(other.getUnk3300NLMEPPPMCKIList()) && getStageId() == other.getStageId() && getIsOpen() == other.getIsOpen() && getLevelListList().equals(other.getLevelListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getUnk3300BMEHJHFCPMACount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getUnk3300BMEHJHFCPMAList().hashCode();
            }
            if (getUnk3300NLMEPPPMCKICount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getUnk3300NLMEPPPMCKIList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 13)) + getStageId())) + 8)) + Internal.hashBoolean(getIsOpen());
            if (getLevelListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 11)) + getLevelListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static PotionStageData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PotionStageData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PotionStageData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PotionStageData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PotionStageData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PotionStageData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PotionStageData parseFrom(InputStream input) throws IOException {
            return (PotionStageData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PotionStageData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PotionStageData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PotionStageData parseDelimitedFrom(InputStream input) throws IOException {
            return (PotionStageData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PotionStageData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PotionStageData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PotionStageData parseFrom(CodedInputStream input) throws IOException {
            return (PotionStageData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PotionStageData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PotionStageData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PotionStageData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PotionStageDataOuterClass$PotionStageData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PotionStageDataOrBuilder {
            private int bitField0_;
            private int stageId_;
            private boolean isOpen_;
            private RepeatedFieldBuilderV3<PotionLevelDataOuterClass.PotionLevelData, PotionLevelDataOuterClass.PotionLevelData.Builder, PotionLevelDataOuterClass.PotionLevelDataOrBuilder> levelListBuilder_;
            private Internal.IntList unk3300BMEHJHFCPMA_ = PotionStageData.emptyIntList();
            private Internal.IntList unk3300NLMEPPPMCKI_ = PotionStageData.emptyIntList();
            private List<PotionLevelDataOuterClass.PotionLevelData> levelList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return PotionStageDataOuterClass.internal_static_PotionStageData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PotionStageDataOuterClass.internal_static_PotionStageData_fieldAccessorTable.ensureFieldAccessorsInitialized(PotionStageData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PotionStageData.alwaysUseFieldBuilders) {
                    getLevelListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.unk3300BMEHJHFCPMA_ = PotionStageData.emptyIntList();
                this.bitField0_ &= -2;
                this.unk3300NLMEPPPMCKI_ = PotionStageData.emptyIntList();
                this.bitField0_ &= -3;
                this.stageId_ = 0;
                this.isOpen_ = false;
                if (this.levelListBuilder_ == null) {
                    this.levelList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.levelListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PotionStageDataOuterClass.internal_static_PotionStageData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PotionStageData getDefaultInstanceForType() {
                return PotionStageData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PotionStageData build() {
                PotionStageData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PotionStageData buildPartial() {
                PotionStageData result = new PotionStageData(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.unk3300BMEHJHFCPMA_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.unk3300BMEHJHFCPMA_ = this.unk3300BMEHJHFCPMA_;
                if ((this.bitField0_ & 2) != 0) {
                    this.unk3300NLMEPPPMCKI_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.unk3300NLMEPPPMCKI_ = this.unk3300NLMEPPPMCKI_;
                result.stageId_ = this.stageId_;
                result.isOpen_ = this.isOpen_;
                if (this.levelListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.levelList_ = Collections.unmodifiableList(this.levelList_);
                        this.bitField0_ &= -5;
                    }
                    result.levelList_ = this.levelList_;
                } else {
                    result.levelList_ = this.levelListBuilder_.build();
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
                if (other instanceof PotionStageData) {
                    return mergeFrom((PotionStageData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PotionStageData other) {
                if (other == PotionStageData.getDefaultInstance()) {
                    return this;
                }
                if (!other.unk3300BMEHJHFCPMA_.isEmpty()) {
                    if (this.unk3300BMEHJHFCPMA_.isEmpty()) {
                        this.unk3300BMEHJHFCPMA_ = other.unk3300BMEHJHFCPMA_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureUnk3300BMEHJHFCPMAIsMutable();
                        this.unk3300BMEHJHFCPMA_.addAll(other.unk3300BMEHJHFCPMA_);
                    }
                    onChanged();
                }
                if (!other.unk3300NLMEPPPMCKI_.isEmpty()) {
                    if (this.unk3300NLMEPPPMCKI_.isEmpty()) {
                        this.unk3300NLMEPPPMCKI_ = other.unk3300NLMEPPPMCKI_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureUnk3300NLMEPPPMCKIIsMutable();
                        this.unk3300NLMEPPPMCKI_.addAll(other.unk3300NLMEPPPMCKI_);
                    }
                    onChanged();
                }
                if (other.getStageId() != 0) {
                    setStageId(other.getStageId());
                }
                if (other.getIsOpen()) {
                    setIsOpen(other.getIsOpen());
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
                        this.levelListBuilder_ = PotionStageData.alwaysUseFieldBuilders ? getLevelListFieldBuilder() : null;
                    } else {
                        this.levelListBuilder_.addAllMessages(other.levelList_);
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
                PotionStageData parsedMessage = null;
                try {
                    try {
                        parsedMessage = PotionStageData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PotionStageData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureUnk3300BMEHJHFCPMAIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.unk3300BMEHJHFCPMA_ = PotionStageData.mutableCopy(this.unk3300BMEHJHFCPMA_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
            public List<Integer> getUnk3300BMEHJHFCPMAList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.unk3300BMEHJHFCPMA_) : this.unk3300BMEHJHFCPMA_;
            }

            @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
            public int getUnk3300BMEHJHFCPMACount() {
                return this.unk3300BMEHJHFCPMA_.size();
            }

            @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
            public int getUnk3300BMEHJHFCPMA(int index) {
                return this.unk3300BMEHJHFCPMA_.getInt(index);
            }

            public Builder setUnk3300BMEHJHFCPMA(int index, int value) {
                ensureUnk3300BMEHJHFCPMAIsMutable();
                this.unk3300BMEHJHFCPMA_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300BMEHJHFCPMA(int value) {
                ensureUnk3300BMEHJHFCPMAIsMutable();
                this.unk3300BMEHJHFCPMA_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300BMEHJHFCPMA(Iterable<? extends Integer> values) {
                ensureUnk3300BMEHJHFCPMAIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300BMEHJHFCPMA_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300BMEHJHFCPMA() {
                this.unk3300BMEHJHFCPMA_ = PotionStageData.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureUnk3300NLMEPPPMCKIIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.unk3300NLMEPPPMCKI_ = PotionStageData.mutableCopy(this.unk3300NLMEPPPMCKI_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
            public List<Integer> getUnk3300NLMEPPPMCKIList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.unk3300NLMEPPPMCKI_) : this.unk3300NLMEPPPMCKI_;
            }

            @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
            public int getUnk3300NLMEPPPMCKICount() {
                return this.unk3300NLMEPPPMCKI_.size();
            }

            @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
            public int getUnk3300NLMEPPPMCKI(int index) {
                return this.unk3300NLMEPPPMCKI_.getInt(index);
            }

            public Builder setUnk3300NLMEPPPMCKI(int index, int value) {
                ensureUnk3300NLMEPPPMCKIIsMutable();
                this.unk3300NLMEPPPMCKI_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addUnk3300NLMEPPPMCKI(int value) {
                ensureUnk3300NLMEPPPMCKIIsMutable();
                this.unk3300NLMEPPPMCKI_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllUnk3300NLMEPPPMCKI(Iterable<? extends Integer> values) {
                ensureUnk3300NLMEPPPMCKIIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.unk3300NLMEPPPMCKI_);
                onChanged();
                return this;
            }

            public Builder clearUnk3300NLMEPPPMCKI() {
                this.unk3300NLMEPPPMCKI_ = PotionStageData.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
            public int getStageId() {
                return this.stageId_;
            }

            public Builder setStageId(int value) {
                this.stageId_ = value;
                onChanged();
                return this;
            }

            public Builder clearStageId() {
                this.stageId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
            public boolean getIsOpen() {
                return this.isOpen_;
            }

            public Builder setIsOpen(boolean value) {
                this.isOpen_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsOpen() {
                this.isOpen_ = false;
                onChanged();
                return this;
            }

            private void ensureLevelListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.levelList_ = new ArrayList(this.levelList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
            public List<PotionLevelDataOuterClass.PotionLevelData> getLevelListList() {
                if (this.levelListBuilder_ == null) {
                    return Collections.unmodifiableList(this.levelList_);
                }
                return this.levelListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
            public int getLevelListCount() {
                if (this.levelListBuilder_ == null) {
                    return this.levelList_.size();
                }
                return this.levelListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
            public PotionLevelDataOuterClass.PotionLevelData getLevelList(int index) {
                if (this.levelListBuilder_ == null) {
                    return this.levelList_.get(index);
                }
                return this.levelListBuilder_.getMessage(index);
            }

            public Builder setLevelList(int index, PotionLevelDataOuterClass.PotionLevelData value) {
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

            public Builder setLevelList(int index, PotionLevelDataOuterClass.PotionLevelData.Builder builderForValue) {
                if (this.levelListBuilder_ == null) {
                    ensureLevelListIsMutable();
                    this.levelList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.levelListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addLevelList(PotionLevelDataOuterClass.PotionLevelData value) {
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

            public Builder addLevelList(int index, PotionLevelDataOuterClass.PotionLevelData value) {
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

            public Builder addLevelList(PotionLevelDataOuterClass.PotionLevelData.Builder builderForValue) {
                if (this.levelListBuilder_ == null) {
                    ensureLevelListIsMutable();
                    this.levelList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.levelListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addLevelList(int index, PotionLevelDataOuterClass.PotionLevelData.Builder builderForValue) {
                if (this.levelListBuilder_ == null) {
                    ensureLevelListIsMutable();
                    this.levelList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.levelListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllLevelList(Iterable<? extends PotionLevelDataOuterClass.PotionLevelData> values) {
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

            public PotionLevelDataOuterClass.PotionLevelData.Builder getLevelListBuilder(int index) {
                return getLevelListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
            public PotionLevelDataOuterClass.PotionLevelDataOrBuilder getLevelListOrBuilder(int index) {
                if (this.levelListBuilder_ == null) {
                    return this.levelList_.get(index);
                }
                return this.levelListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PotionStageDataOuterClass.PotionStageDataOrBuilder
            public List<? extends PotionLevelDataOuterClass.PotionLevelDataOrBuilder> getLevelListOrBuilderList() {
                if (this.levelListBuilder_ != null) {
                    return this.levelListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.levelList_);
            }

            public PotionLevelDataOuterClass.PotionLevelData.Builder addLevelListBuilder() {
                return getLevelListFieldBuilder().addBuilder(PotionLevelDataOuterClass.PotionLevelData.getDefaultInstance());
            }

            public PotionLevelDataOuterClass.PotionLevelData.Builder addLevelListBuilder(int index) {
                return getLevelListFieldBuilder().addBuilder(index, PotionLevelDataOuterClass.PotionLevelData.getDefaultInstance());
            }

            public List<PotionLevelDataOuterClass.PotionLevelData.Builder> getLevelListBuilderList() {
                return getLevelListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<PotionLevelDataOuterClass.PotionLevelData, PotionLevelDataOuterClass.PotionLevelData.Builder, PotionLevelDataOuterClass.PotionLevelDataOrBuilder> getLevelListFieldBuilder() {
                if (this.levelListBuilder_ == null) {
                    this.levelListBuilder_ = new RepeatedFieldBuilderV3<>(this.levelList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.levelList_ = null;
                }
                return this.levelListBuilder_;
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

        public static PotionStageData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PotionStageData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PotionStageData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PotionStageData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PotionLevelDataOuterClass.getDescriptor();
    }
}
