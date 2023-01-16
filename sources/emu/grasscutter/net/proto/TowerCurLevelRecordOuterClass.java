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
import emu.grasscutter.net.proto.TowerTeamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerCurLevelRecordOuterClass.class */
public final class TowerCurLevelRecordOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019TowerCurLevelRecord.proto\u001a\u000fTowerTeam.proto\"¨\u0001\n\u0013TowerCurLevelRecord\u0012\u0014\n\fbuff_id_list\u0018\u000e \u0003(\r\u0012\u0015\n\ris_upper_part\u0018\u0004 \u0001(\b\u0012\u0017\n\u000fcur_level_index\u0018\u0006 \u0001(\r\u0012\u0010\n\bis_empty\u0018\u0001 \u0001(\b\u0012#\n\u000ftower_team_list\u0018\b \u0003(\u000b2\n.TowerTeam\u0012\u0014\n\fcur_floor_id\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{TowerTeamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_TowerCurLevelRecord_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TowerCurLevelRecord_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TowerCurLevelRecord_descriptor, new String[]{"BuffIdList", "IsUpperPart", "CurLevelIndex", "IsEmpty", "TowerTeamList", "CurFloorId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerCurLevelRecordOuterClass$TowerCurLevelRecordOrBuilder.class */
    public interface TowerCurLevelRecordOrBuilder extends MessageOrBuilder {
        List<Integer> getBuffIdListList();

        int getBuffIdListCount();

        int getBuffIdList(int i);

        boolean getIsUpperPart();

        int getCurLevelIndex();

        boolean getIsEmpty();

        List<TowerTeamOuterClass.TowerTeam> getTowerTeamListList();

        TowerTeamOuterClass.TowerTeam getTowerTeamList(int i);

        int getTowerTeamListCount();

        List<? extends TowerTeamOuterClass.TowerTeamOrBuilder> getTowerTeamListOrBuilderList();

        TowerTeamOuterClass.TowerTeamOrBuilder getTowerTeamListOrBuilder(int i);

        int getCurFloorId();
    }

    private TowerCurLevelRecordOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerCurLevelRecordOuterClass$TowerCurLevelRecord.class */
    public static final class TowerCurLevelRecord extends GeneratedMessageV3 implements TowerCurLevelRecordOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BUFF_ID_LIST_FIELD_NUMBER = 14;
        private Internal.IntList buffIdList_;
        private int buffIdListMemoizedSerializedSize;
        public static final int IS_UPPER_PART_FIELD_NUMBER = 4;
        private boolean isUpperPart_;
        public static final int CUR_LEVEL_INDEX_FIELD_NUMBER = 6;
        private int curLevelIndex_;
        public static final int IS_EMPTY_FIELD_NUMBER = 1;
        private boolean isEmpty_;
        public static final int TOWER_TEAM_LIST_FIELD_NUMBER = 8;
        private List<TowerTeamOuterClass.TowerTeam> towerTeamList_;
        public static final int CUR_FLOOR_ID_FIELD_NUMBER = 9;
        private int curFloorId_;
        private byte memoizedIsInitialized;
        private static final TowerCurLevelRecord DEFAULT_INSTANCE = new TowerCurLevelRecord();
        private static final Parser<TowerCurLevelRecord> PARSER = new AbstractParser<TowerCurLevelRecord>() { // from class: emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecord.1
            @Override // com.google.protobuf.Parser
            public TowerCurLevelRecord parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TowerCurLevelRecord(input, extensionRegistry);
            }
        };

        private TowerCurLevelRecord(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.buffIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private TowerCurLevelRecord() {
            this.buffIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.buffIdList_ = emptyIntList();
            this.towerTeamList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TowerCurLevelRecord();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:76:0x0146 */
        private TowerCurLevelRecord(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.isEmpty_ = input.readBool();
                                    break;
                                case 32:
                                    this.isUpperPart_ = input.readBool();
                                    break;
                                case 48:
                                    this.curLevelIndex_ = input.readUInt32();
                                    break;
                                case 66:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.towerTeamList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.towerTeamList_.add((TowerTeamOuterClass.TowerTeam) input.readMessage(TowerTeamOuterClass.TowerTeam.parser(), extensionRegistry));
                                    break;
                                case 72:
                                    this.curFloorId_ = input.readUInt32();
                                    break;
                                case 112:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.buffIdList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.buffIdList_.addInt(input.readUInt32());
                                    break;
                                case 114:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.buffIdList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.buffIdList_.addInt(input.readUInt32());
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 2) != 0) {
                    this.towerTeamList_ = Collections.unmodifiableList(this.towerTeamList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.buffIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TowerCurLevelRecordOuterClass.internal_static_TowerCurLevelRecord_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TowerCurLevelRecordOuterClass.internal_static_TowerCurLevelRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerCurLevelRecord.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
        public List<Integer> getBuffIdListList() {
            return this.buffIdList_;
        }

        @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
        public int getBuffIdListCount() {
            return this.buffIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
        public int getBuffIdList(int index) {
            return this.buffIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
        public boolean getIsUpperPart() {
            return this.isUpperPart_;
        }

        @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
        public int getCurLevelIndex() {
            return this.curLevelIndex_;
        }

        @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
        public boolean getIsEmpty() {
            return this.isEmpty_;
        }

        @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
        public List<TowerTeamOuterClass.TowerTeam> getTowerTeamListList() {
            return this.towerTeamList_;
        }

        @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
        public List<? extends TowerTeamOuterClass.TowerTeamOrBuilder> getTowerTeamListOrBuilderList() {
            return this.towerTeamList_;
        }

        @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
        public int getTowerTeamListCount() {
            return this.towerTeamList_.size();
        }

        @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
        public TowerTeamOuterClass.TowerTeam getTowerTeamList(int index) {
            return this.towerTeamList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
        public TowerTeamOuterClass.TowerTeamOrBuilder getTowerTeamListOrBuilder(int index) {
            return this.towerTeamList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
        public int getCurFloorId() {
            return this.curFloorId_;
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
            if (this.isEmpty_) {
                output.writeBool(1, this.isEmpty_);
            }
            if (this.isUpperPart_) {
                output.writeBool(4, this.isUpperPart_);
            }
            if (this.curLevelIndex_ != 0) {
                output.writeUInt32(6, this.curLevelIndex_);
            }
            for (int i = 0; i < this.towerTeamList_.size(); i++) {
                output.writeMessage(8, this.towerTeamList_.get(i));
            }
            if (this.curFloorId_ != 0) {
                output.writeUInt32(9, this.curFloorId_);
            }
            if (getBuffIdListList().size() > 0) {
                output.writeUInt32NoTag(114);
                output.writeUInt32NoTag(this.buffIdListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.buffIdList_.size(); i2++) {
                output.writeUInt32NoTag(this.buffIdList_.getInt(i2));
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
            if (this.isEmpty_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.isEmpty_);
            }
            if (this.isUpperPart_) {
                size2 += CodedOutputStream.computeBoolSize(4, this.isUpperPart_);
            }
            if (this.curLevelIndex_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(6, this.curLevelIndex_);
            }
            for (int i = 0; i < this.towerTeamList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(8, this.towerTeamList_.get(i));
            }
            if (this.curFloorId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.curFloorId_);
            }
            int dataSize = 0;
            for (int i2 = 0; i2 < this.buffIdList_.size(); i2++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.buffIdList_.getInt(i2));
            }
            int size3 = size2 + dataSize;
            if (!getBuffIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.buffIdListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TowerCurLevelRecord)) {
                return equals(obj);
            }
            TowerCurLevelRecord other = (TowerCurLevelRecord) obj;
            return getBuffIdListList().equals(other.getBuffIdListList()) && getIsUpperPart() == other.getIsUpperPart() && getCurLevelIndex() == other.getCurLevelIndex() && getIsEmpty() == other.getIsEmpty() && getTowerTeamListList().equals(other.getTowerTeamListList()) && getCurFloorId() == other.getCurFloorId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getBuffIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getBuffIdListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 4)) + Internal.hashBoolean(getIsUpperPart()))) + 6)) + getCurLevelIndex())) + 1)) + Internal.hashBoolean(getIsEmpty());
            if (getTowerTeamListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 8)) + getTowerTeamListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 9)) + getCurFloorId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static TowerCurLevelRecord parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerCurLevelRecord parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerCurLevelRecord parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerCurLevelRecord parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerCurLevelRecord parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TowerCurLevelRecord parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TowerCurLevelRecord parseFrom(InputStream input) throws IOException {
            return (TowerCurLevelRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerCurLevelRecord parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerCurLevelRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerCurLevelRecord parseDelimitedFrom(InputStream input) throws IOException {
            return (TowerCurLevelRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TowerCurLevelRecord parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerCurLevelRecord) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TowerCurLevelRecord parseFrom(CodedInputStream input) throws IOException {
            return (TowerCurLevelRecord) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TowerCurLevelRecord parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TowerCurLevelRecord) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TowerCurLevelRecord prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TowerCurLevelRecordOuterClass$TowerCurLevelRecord$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TowerCurLevelRecordOrBuilder {
            private int bitField0_;
            private boolean isUpperPart_;
            private int curLevelIndex_;
            private boolean isEmpty_;
            private RepeatedFieldBuilderV3<TowerTeamOuterClass.TowerTeam, TowerTeamOuterClass.TowerTeam.Builder, TowerTeamOuterClass.TowerTeamOrBuilder> towerTeamListBuilder_;
            private int curFloorId_;
            private Internal.IntList buffIdList_ = TowerCurLevelRecord.emptyIntList();
            private List<TowerTeamOuterClass.TowerTeam> towerTeamList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return TowerCurLevelRecordOuterClass.internal_static_TowerCurLevelRecord_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TowerCurLevelRecordOuterClass.internal_static_TowerCurLevelRecord_fieldAccessorTable.ensureFieldAccessorsInitialized(TowerCurLevelRecord.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TowerCurLevelRecord.alwaysUseFieldBuilders) {
                    getTowerTeamListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.buffIdList_ = TowerCurLevelRecord.emptyIntList();
                this.bitField0_ &= -2;
                this.isUpperPart_ = false;
                this.curLevelIndex_ = 0;
                this.isEmpty_ = false;
                if (this.towerTeamListBuilder_ == null) {
                    this.towerTeamList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.towerTeamListBuilder_.clear();
                }
                this.curFloorId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TowerCurLevelRecordOuterClass.internal_static_TowerCurLevelRecord_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TowerCurLevelRecord getDefaultInstanceForType() {
                return TowerCurLevelRecord.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerCurLevelRecord build() {
                TowerCurLevelRecord result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TowerCurLevelRecord buildPartial() {
                TowerCurLevelRecord result = new TowerCurLevelRecord(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.buffIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.buffIdList_ = this.buffIdList_;
                result.isUpperPart_ = this.isUpperPart_;
                result.curLevelIndex_ = this.curLevelIndex_;
                result.isEmpty_ = this.isEmpty_;
                if (this.towerTeamListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.towerTeamList_ = Collections.unmodifiableList(this.towerTeamList_);
                        this.bitField0_ &= -3;
                    }
                    result.towerTeamList_ = this.towerTeamList_;
                } else {
                    result.towerTeamList_ = this.towerTeamListBuilder_.build();
                }
                result.curFloorId_ = this.curFloorId_;
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
                if (other instanceof TowerCurLevelRecord) {
                    return mergeFrom((TowerCurLevelRecord) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TowerCurLevelRecord other) {
                if (other == TowerCurLevelRecord.getDefaultInstance()) {
                    return this;
                }
                if (!other.buffIdList_.isEmpty()) {
                    if (this.buffIdList_.isEmpty()) {
                        this.buffIdList_ = other.buffIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureBuffIdListIsMutable();
                        this.buffIdList_.addAll(other.buffIdList_);
                    }
                    onChanged();
                }
                if (other.getIsUpperPart()) {
                    setIsUpperPart(other.getIsUpperPart());
                }
                if (other.getCurLevelIndex() != 0) {
                    setCurLevelIndex(other.getCurLevelIndex());
                }
                if (other.getIsEmpty()) {
                    setIsEmpty(other.getIsEmpty());
                }
                if (this.towerTeamListBuilder_ == null) {
                    if (!other.towerTeamList_.isEmpty()) {
                        if (this.towerTeamList_.isEmpty()) {
                            this.towerTeamList_ = other.towerTeamList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureTowerTeamListIsMutable();
                            this.towerTeamList_.addAll(other.towerTeamList_);
                        }
                        onChanged();
                    }
                } else if (!other.towerTeamList_.isEmpty()) {
                    if (this.towerTeamListBuilder_.isEmpty()) {
                        this.towerTeamListBuilder_.dispose();
                        this.towerTeamListBuilder_ = null;
                        this.towerTeamList_ = other.towerTeamList_;
                        this.bitField0_ &= -3;
                        this.towerTeamListBuilder_ = TowerCurLevelRecord.alwaysUseFieldBuilders ? getTowerTeamListFieldBuilder() : null;
                    } else {
                        this.towerTeamListBuilder_.addAllMessages(other.towerTeamList_);
                    }
                }
                if (other.getCurFloorId() != 0) {
                    setCurFloorId(other.getCurFloorId());
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
                TowerCurLevelRecord parsedMessage = null;
                try {
                    try {
                        parsedMessage = TowerCurLevelRecord.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TowerCurLevelRecord) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureBuffIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.buffIdList_ = TowerCurLevelRecord.mutableCopy(this.buffIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
            public List<Integer> getBuffIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.buffIdList_) : this.buffIdList_;
            }

            @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
            public int getBuffIdListCount() {
                return this.buffIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
            public int getBuffIdList(int index) {
                return this.buffIdList_.getInt(index);
            }

            public Builder setBuffIdList(int index, int value) {
                ensureBuffIdListIsMutable();
                this.buffIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addBuffIdList(int value) {
                ensureBuffIdListIsMutable();
                this.buffIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllBuffIdList(Iterable<? extends Integer> values) {
                ensureBuffIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.buffIdList_);
                onChanged();
                return this;
            }

            public Builder clearBuffIdList() {
                this.buffIdList_ = TowerCurLevelRecord.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
            public boolean getIsUpperPart() {
                return this.isUpperPart_;
            }

            public Builder setIsUpperPart(boolean value) {
                this.isUpperPart_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsUpperPart() {
                this.isUpperPart_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
            public int getCurLevelIndex() {
                return this.curLevelIndex_;
            }

            public Builder setCurLevelIndex(int value) {
                this.curLevelIndex_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurLevelIndex() {
                this.curLevelIndex_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
            public boolean getIsEmpty() {
                return this.isEmpty_;
            }

            public Builder setIsEmpty(boolean value) {
                this.isEmpty_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsEmpty() {
                this.isEmpty_ = false;
                onChanged();
                return this;
            }

            private void ensureTowerTeamListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.towerTeamList_ = new ArrayList(this.towerTeamList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
            public List<TowerTeamOuterClass.TowerTeam> getTowerTeamListList() {
                if (this.towerTeamListBuilder_ == null) {
                    return Collections.unmodifiableList(this.towerTeamList_);
                }
                return this.towerTeamListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
            public int getTowerTeamListCount() {
                if (this.towerTeamListBuilder_ == null) {
                    return this.towerTeamList_.size();
                }
                return this.towerTeamListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
            public TowerTeamOuterClass.TowerTeam getTowerTeamList(int index) {
                if (this.towerTeamListBuilder_ == null) {
                    return this.towerTeamList_.get(index);
                }
                return this.towerTeamListBuilder_.getMessage(index);
            }

            public Builder setTowerTeamList(int index, TowerTeamOuterClass.TowerTeam value) {
                if (this.towerTeamListBuilder_ != null) {
                    this.towerTeamListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTowerTeamListIsMutable();
                    this.towerTeamList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setTowerTeamList(int index, TowerTeamOuterClass.TowerTeam.Builder builderForValue) {
                if (this.towerTeamListBuilder_ == null) {
                    ensureTowerTeamListIsMutable();
                    this.towerTeamList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.towerTeamListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addTowerTeamList(TowerTeamOuterClass.TowerTeam value) {
                if (this.towerTeamListBuilder_ != null) {
                    this.towerTeamListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTowerTeamListIsMutable();
                    this.towerTeamList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addTowerTeamList(int index, TowerTeamOuterClass.TowerTeam value) {
                if (this.towerTeamListBuilder_ != null) {
                    this.towerTeamListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureTowerTeamListIsMutable();
                    this.towerTeamList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addTowerTeamList(TowerTeamOuterClass.TowerTeam.Builder builderForValue) {
                if (this.towerTeamListBuilder_ == null) {
                    ensureTowerTeamListIsMutable();
                    this.towerTeamList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.towerTeamListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addTowerTeamList(int index, TowerTeamOuterClass.TowerTeam.Builder builderForValue) {
                if (this.towerTeamListBuilder_ == null) {
                    ensureTowerTeamListIsMutable();
                    this.towerTeamList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.towerTeamListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllTowerTeamList(Iterable<? extends TowerTeamOuterClass.TowerTeam> values) {
                if (this.towerTeamListBuilder_ == null) {
                    ensureTowerTeamListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.towerTeamList_);
                    onChanged();
                } else {
                    this.towerTeamListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearTowerTeamList() {
                if (this.towerTeamListBuilder_ == null) {
                    this.towerTeamList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.towerTeamListBuilder_.clear();
                }
                return this;
            }

            public Builder removeTowerTeamList(int index) {
                if (this.towerTeamListBuilder_ == null) {
                    ensureTowerTeamListIsMutable();
                    this.towerTeamList_.remove(index);
                    onChanged();
                } else {
                    this.towerTeamListBuilder_.remove(index);
                }
                return this;
            }

            public TowerTeamOuterClass.TowerTeam.Builder getTowerTeamListBuilder(int index) {
                return getTowerTeamListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
            public TowerTeamOuterClass.TowerTeamOrBuilder getTowerTeamListOrBuilder(int index) {
                if (this.towerTeamListBuilder_ == null) {
                    return this.towerTeamList_.get(index);
                }
                return this.towerTeamListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
            public List<? extends TowerTeamOuterClass.TowerTeamOrBuilder> getTowerTeamListOrBuilderList() {
                if (this.towerTeamListBuilder_ != null) {
                    return this.towerTeamListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.towerTeamList_);
            }

            public TowerTeamOuterClass.TowerTeam.Builder addTowerTeamListBuilder() {
                return getTowerTeamListFieldBuilder().addBuilder(TowerTeamOuterClass.TowerTeam.getDefaultInstance());
            }

            public TowerTeamOuterClass.TowerTeam.Builder addTowerTeamListBuilder(int index) {
                return getTowerTeamListFieldBuilder().addBuilder(index, TowerTeamOuterClass.TowerTeam.getDefaultInstance());
            }

            public List<TowerTeamOuterClass.TowerTeam.Builder> getTowerTeamListBuilderList() {
                return getTowerTeamListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<TowerTeamOuterClass.TowerTeam, TowerTeamOuterClass.TowerTeam.Builder, TowerTeamOuterClass.TowerTeamOrBuilder> getTowerTeamListFieldBuilder() {
                if (this.towerTeamListBuilder_ == null) {
                    this.towerTeamListBuilder_ = new RepeatedFieldBuilderV3<>(this.towerTeamList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.towerTeamList_ = null;
                }
                return this.towerTeamListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.TowerCurLevelRecordOuterClass.TowerCurLevelRecordOrBuilder
            public int getCurFloorId() {
                return this.curFloorId_;
            }

            public Builder setCurFloorId(int value) {
                this.curFloorId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurFloorId() {
                this.curFloorId_ = 0;
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

        public static TowerCurLevelRecord getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TowerCurLevelRecord> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TowerCurLevelRecord> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TowerCurLevelRecord getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        TowerTeamOuterClass.getDescriptor();
    }
}
