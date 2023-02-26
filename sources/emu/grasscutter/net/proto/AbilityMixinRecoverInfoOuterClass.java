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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.BreakoutSnapShotOuterClass;
import emu.grasscutter.net.proto.MassivePropSyncInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityMixinRecoverInfoOuterClass.class */
public final class AbilityMixinRecoverInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dAbilityMixinRecoverInfo.proto\u001a\u0016BreakoutSnapShot.proto\u001a\u0019MassivePropSyncInfo.proto\"\u0002\n\u0017AbilityMixinRecoverInfo\u0012\u001e\n\u0014instanced_ability_id\u0018\u0001 \u0001(\rH��\u0012\u001f\n\u0015instanced_modifier_id\u0018\u0002 \u0001(\rH��\u0012\u000f\n\u0007localId\u0018\u0003 \u0001(\r\u0012\u0010\n\bdataList\u0018\u0004 \u0003(\r\u0012\u001c\n\u0014isServerbuffModifier\u0018\u0005 \u0001(\b\u0012-\n\u000fmassivePropList\u0018\u0006 \u0003(\u000b2\u0014.MassivePropSyncInfo\u0012+\n\u0010breakoutSnapShot\u0018\u0007 \u0001(\u000b2\u0011.BreakoutSnapShotB\b\n\u0006sourceB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BreakoutSnapShotOuterClass.getDescriptor(), MassivePropSyncInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AbilityMixinRecoverInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AbilityMixinRecoverInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AbilityMixinRecoverInfo_descriptor, new String[]{"InstancedAbilityId", "InstancedModifierId", "LocalId", "DataList", "IsServerbuffModifier", "MassivePropList", "BreakoutSnapShot", "Source"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityMixinRecoverInfoOuterClass$AbilityMixinRecoverInfoOrBuilder.class */
    public interface AbilityMixinRecoverInfoOrBuilder extends MessageOrBuilder {
        boolean hasInstancedAbilityId();

        int getInstancedAbilityId();

        boolean hasInstancedModifierId();

        int getInstancedModifierId();

        int getLocalId();

        List<Integer> getDataListList();

        int getDataListCount();

        int getDataList(int i);

        boolean getIsServerbuffModifier();

        List<MassivePropSyncInfoOuterClass.MassivePropSyncInfo> getMassivePropListList();

        MassivePropSyncInfoOuterClass.MassivePropSyncInfo getMassivePropList(int i);

        int getMassivePropListCount();

        List<? extends MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder> getMassivePropListOrBuilderList();

        MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder getMassivePropListOrBuilder(int i);

        boolean hasBreakoutSnapShot();

        BreakoutSnapShotOuterClass.BreakoutSnapShot getBreakoutSnapShot();

        BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder getBreakoutSnapShotOrBuilder();

        AbilityMixinRecoverInfo.SourceCase getSourceCase();
    }

    private AbilityMixinRecoverInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityMixinRecoverInfoOuterClass$AbilityMixinRecoverInfo.class */
    public static final class AbilityMixinRecoverInfo extends GeneratedMessageV3 implements AbilityMixinRecoverInfoOrBuilder {
        private static final long serialVersionUID = 0;
        private int sourceCase_;
        private Object source_;
        public static final int INSTANCED_ABILITY_ID_FIELD_NUMBER = 1;
        public static final int INSTANCED_MODIFIER_ID_FIELD_NUMBER = 2;
        public static final int LOCALID_FIELD_NUMBER = 3;
        private int localId_;
        public static final int DATALIST_FIELD_NUMBER = 4;
        private Internal.IntList dataList_;
        private int dataListMemoizedSerializedSize;
        public static final int ISSERVERBUFFMODIFIER_FIELD_NUMBER = 5;
        private boolean isServerbuffModifier_;
        public static final int MASSIVEPROPLIST_FIELD_NUMBER = 6;
        private List<MassivePropSyncInfoOuterClass.MassivePropSyncInfo> massivePropList_;
        public static final int BREAKOUTSNAPSHOT_FIELD_NUMBER = 7;
        private BreakoutSnapShotOuterClass.BreakoutSnapShot breakoutSnapShot_;
        private byte memoizedIsInitialized;
        private static final AbilityMixinRecoverInfo DEFAULT_INSTANCE = new AbilityMixinRecoverInfo();
        private static final Parser<AbilityMixinRecoverInfo> PARSER = new AbstractParser<AbilityMixinRecoverInfo>() { // from class: emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo.1
            @Override // com.google.protobuf.Parser
            public AbilityMixinRecoverInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AbilityMixinRecoverInfo(input, extensionRegistry);
            }
        };

        private AbilityMixinRecoverInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.sourceCase_ = 0;
            this.dataListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private AbilityMixinRecoverInfo() {
            this.sourceCase_ = 0;
            this.dataListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.dataList_ = emptyIntList();
            this.massivePropList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AbilityMixinRecoverInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:84:0x019b */
        private AbilityMixinRecoverInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.sourceCase_ = 1;
                                this.source_ = Integer.valueOf(input.readUInt32());
                                break;
                            case 16:
                                this.sourceCase_ = 2;
                                this.source_ = Integer.valueOf(input.readUInt32());
                                break;
                            case 24:
                                this.localId_ = input.readUInt32();
                                break;
                            case 32:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.dataList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.dataList_.addInt(input.readUInt32());
                                break;
                            case 34:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.dataList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.dataList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 40:
                                this.isServerbuffModifier_ = input.readBool();
                                break;
                            case 50:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.massivePropList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.massivePropList_.add((MassivePropSyncInfoOuterClass.MassivePropSyncInfo) input.readMessage(MassivePropSyncInfoOuterClass.MassivePropSyncInfo.parser(), extensionRegistry));
                                break;
                            case 58:
                                BreakoutSnapShotOuterClass.BreakoutSnapShot.Builder subBuilder = this.breakoutSnapShot_ != null ? this.breakoutSnapShot_.toBuilder() : null;
                                this.breakoutSnapShot_ = (BreakoutSnapShotOuterClass.BreakoutSnapShot) input.readMessage(BreakoutSnapShotOuterClass.BreakoutSnapShot.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.breakoutSnapShot_);
                                    this.breakoutSnapShot_ = subBuilder.buildPartial();
                                    break;
                                }
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
                    this.dataList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.massivePropList_ = Collections.unmodifiableList(this.massivePropList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AbilityMixinRecoverInfoOuterClass.internal_static_AbilityMixinRecoverInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbilityMixinRecoverInfoOuterClass.internal_static_AbilityMixinRecoverInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityMixinRecoverInfo.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityMixinRecoverInfoOuterClass$AbilityMixinRecoverInfo$SourceCase.class */
        public enum SourceCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            INSTANCED_ABILITY_ID(1),
            INSTANCED_MODIFIER_ID(2),
            SOURCE_NOT_SET(0);
            
            private final int value;

            SourceCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static SourceCase valueOf(int value) {
                return forNumber(value);
            }

            public static SourceCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return SOURCE_NOT_SET;
                    case 1:
                        return INSTANCED_ABILITY_ID;
                    case 2:
                        return INSTANCED_MODIFIER_ID;
                    default:
                        return null;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
        public SourceCase getSourceCase() {
            return SourceCase.forNumber(this.sourceCase_);
        }

        @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
        public boolean hasInstancedAbilityId() {
            return this.sourceCase_ == 1;
        }

        @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
        public int getInstancedAbilityId() {
            if (this.sourceCase_ == 1) {
                return ((Integer) this.source_).intValue();
            }
            return 0;
        }

        @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
        public boolean hasInstancedModifierId() {
            return this.sourceCase_ == 2;
        }

        @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
        public int getInstancedModifierId() {
            if (this.sourceCase_ == 2) {
                return ((Integer) this.source_).intValue();
            }
            return 0;
        }

        @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
        public int getLocalId() {
            return this.localId_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
        public List<Integer> getDataListList() {
            return this.dataList_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
        public int getDataListCount() {
            return this.dataList_.size();
        }

        @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
        public int getDataList(int index) {
            return this.dataList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
        public boolean getIsServerbuffModifier() {
            return this.isServerbuffModifier_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
        public List<MassivePropSyncInfoOuterClass.MassivePropSyncInfo> getMassivePropListList() {
            return this.massivePropList_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
        public List<? extends MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder> getMassivePropListOrBuilderList() {
            return this.massivePropList_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
        public int getMassivePropListCount() {
            return this.massivePropList_.size();
        }

        @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
        public MassivePropSyncInfoOuterClass.MassivePropSyncInfo getMassivePropList(int index) {
            return this.massivePropList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
        public MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder getMassivePropListOrBuilder(int index) {
            return this.massivePropList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
        public boolean hasBreakoutSnapShot() {
            return this.breakoutSnapShot_ != null;
        }

        @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
        public BreakoutSnapShotOuterClass.BreakoutSnapShot getBreakoutSnapShot() {
            return this.breakoutSnapShot_ == null ? BreakoutSnapShotOuterClass.BreakoutSnapShot.getDefaultInstance() : this.breakoutSnapShot_;
        }

        @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
        public BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder getBreakoutSnapShotOrBuilder() {
            return getBreakoutSnapShot();
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
            if (this.sourceCase_ == 1) {
                output.writeUInt32(1, ((Integer) this.source_).intValue());
            }
            if (this.sourceCase_ == 2) {
                output.writeUInt32(2, ((Integer) this.source_).intValue());
            }
            if (this.localId_ != 0) {
                output.writeUInt32(3, this.localId_);
            }
            if (getDataListList().size() > 0) {
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.dataListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.dataList_.size(); i++) {
                output.writeUInt32NoTag(this.dataList_.getInt(i));
            }
            if (this.isServerbuffModifier_) {
                output.writeBool(5, this.isServerbuffModifier_);
            }
            for (int i2 = 0; i2 < this.massivePropList_.size(); i2++) {
                output.writeMessage(6, this.massivePropList_.get(i2));
            }
            if (this.breakoutSnapShot_ != null) {
                output.writeMessage(7, getBreakoutSnapShot());
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
            if (this.sourceCase_ == 1) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, ((Integer) this.source_).intValue());
            }
            if (this.sourceCase_ == 2) {
                size2 += CodedOutputStream.computeUInt32Size(2, ((Integer) this.source_).intValue());
            }
            if (this.localId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.localId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.dataList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.dataList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getDataListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.dataListMemoizedSerializedSize = dataSize;
            if (this.isServerbuffModifier_) {
                size3 += CodedOutputStream.computeBoolSize(5, this.isServerbuffModifier_);
            }
            for (int i2 = 0; i2 < this.massivePropList_.size(); i2++) {
                size3 += CodedOutputStream.computeMessageSize(6, this.massivePropList_.get(i2));
            }
            if (this.breakoutSnapShot_ != null) {
                size3 += CodedOutputStream.computeMessageSize(7, getBreakoutSnapShot());
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
            if (!(obj instanceof AbilityMixinRecoverInfo)) {
                return equals(obj);
            }
            AbilityMixinRecoverInfo other = (AbilityMixinRecoverInfo) obj;
            if (getLocalId() != other.getLocalId() || !getDataListList().equals(other.getDataListList()) || getIsServerbuffModifier() != other.getIsServerbuffModifier() || !getMassivePropListList().equals(other.getMassivePropListList()) || hasBreakoutSnapShot() != other.hasBreakoutSnapShot()) {
                return false;
            }
            if ((hasBreakoutSnapShot() && !getBreakoutSnapShot().equals(other.getBreakoutSnapShot())) || !getSourceCase().equals(other.getSourceCase())) {
                return false;
            }
            switch (this.sourceCase_) {
                case 1:
                    if (getInstancedAbilityId() != other.getInstancedAbilityId()) {
                        return false;
                    }
                    break;
                case 2:
                    if (getInstancedModifierId() != other.getInstancedModifierId()) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getLocalId();
            if (getDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getDataListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 5)) + Internal.hashBoolean(getIsServerbuffModifier());
            if (getMassivePropListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 6)) + getMassivePropListList().hashCode();
            }
            if (hasBreakoutSnapShot()) {
                hash2 = (53 * ((37 * hash2) + 7)) + getBreakoutSnapShot().hashCode();
            }
            switch (this.sourceCase_) {
                case 1:
                    hash2 = (53 * ((37 * hash2) + 1)) + getInstancedAbilityId();
                    break;
                case 2:
                    hash2 = (53 * ((37 * hash2) + 2)) + getInstancedModifierId();
                    break;
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static AbilityMixinRecoverInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityMixinRecoverInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityMixinRecoverInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityMixinRecoverInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityMixinRecoverInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilityMixinRecoverInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilityMixinRecoverInfo parseFrom(InputStream input) throws IOException {
            return (AbilityMixinRecoverInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityMixinRecoverInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityMixinRecoverInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityMixinRecoverInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AbilityMixinRecoverInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AbilityMixinRecoverInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityMixinRecoverInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilityMixinRecoverInfo parseFrom(CodedInputStream input) throws IOException {
            return (AbilityMixinRecoverInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilityMixinRecoverInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilityMixinRecoverInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AbilityMixinRecoverInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilityMixinRecoverInfoOuterClass$AbilityMixinRecoverInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AbilityMixinRecoverInfoOrBuilder {
            private Object source_;
            private int bitField0_;
            private int localId_;
            private boolean isServerbuffModifier_;
            private RepeatedFieldBuilderV3<MassivePropSyncInfoOuterClass.MassivePropSyncInfo, MassivePropSyncInfoOuterClass.MassivePropSyncInfo.Builder, MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder> massivePropListBuilder_;
            private BreakoutSnapShotOuterClass.BreakoutSnapShot breakoutSnapShot_;
            private SingleFieldBuilderV3<BreakoutSnapShotOuterClass.BreakoutSnapShot, BreakoutSnapShotOuterClass.BreakoutSnapShot.Builder, BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder> breakoutSnapShotBuilder_;
            private int sourceCase_ = 0;
            private Internal.IntList dataList_ = AbilityMixinRecoverInfo.emptyIntList();
            private List<MassivePropSyncInfoOuterClass.MassivePropSyncInfo> massivePropList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return AbilityMixinRecoverInfoOuterClass.internal_static_AbilityMixinRecoverInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbilityMixinRecoverInfoOuterClass.internal_static_AbilityMixinRecoverInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilityMixinRecoverInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AbilityMixinRecoverInfo.alwaysUseFieldBuilders) {
                    getMassivePropListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.localId_ = 0;
                this.dataList_ = AbilityMixinRecoverInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.isServerbuffModifier_ = false;
                if (this.massivePropListBuilder_ == null) {
                    this.massivePropList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.massivePropListBuilder_.clear();
                }
                if (this.breakoutSnapShotBuilder_ == null) {
                    this.breakoutSnapShot_ = null;
                } else {
                    this.breakoutSnapShot_ = null;
                    this.breakoutSnapShotBuilder_ = null;
                }
                this.sourceCase_ = 0;
                this.source_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbilityMixinRecoverInfoOuterClass.internal_static_AbilityMixinRecoverInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AbilityMixinRecoverInfo getDefaultInstanceForType() {
                return AbilityMixinRecoverInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityMixinRecoverInfo build() {
                AbilityMixinRecoverInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilityMixinRecoverInfo buildPartial() {
                AbilityMixinRecoverInfo result = new AbilityMixinRecoverInfo(this);
                int i = this.bitField0_;
                if (this.sourceCase_ == 1) {
                    result.source_ = this.source_;
                }
                if (this.sourceCase_ == 2) {
                    result.source_ = this.source_;
                }
                result.localId_ = this.localId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.dataList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.dataList_ = this.dataList_;
                result.isServerbuffModifier_ = this.isServerbuffModifier_;
                if (this.massivePropListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.massivePropList_ = Collections.unmodifiableList(this.massivePropList_);
                        this.bitField0_ &= -3;
                    }
                    result.massivePropList_ = this.massivePropList_;
                } else {
                    result.massivePropList_ = this.massivePropListBuilder_.build();
                }
                if (this.breakoutSnapShotBuilder_ == null) {
                    result.breakoutSnapShot_ = this.breakoutSnapShot_;
                } else {
                    result.breakoutSnapShot_ = this.breakoutSnapShotBuilder_.build();
                }
                result.sourceCase_ = this.sourceCase_;
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
                if (other instanceof AbilityMixinRecoverInfo) {
                    return mergeFrom((AbilityMixinRecoverInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AbilityMixinRecoverInfo other) {
                if (other == AbilityMixinRecoverInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getLocalId() != 0) {
                    setLocalId(other.getLocalId());
                }
                if (!other.dataList_.isEmpty()) {
                    if (this.dataList_.isEmpty()) {
                        this.dataList_ = other.dataList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureDataListIsMutable();
                        this.dataList_.addAll(other.dataList_);
                    }
                    onChanged();
                }
                if (other.getIsServerbuffModifier()) {
                    setIsServerbuffModifier(other.getIsServerbuffModifier());
                }
                if (this.massivePropListBuilder_ == null) {
                    if (!other.massivePropList_.isEmpty()) {
                        if (this.massivePropList_.isEmpty()) {
                            this.massivePropList_ = other.massivePropList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureMassivePropListIsMutable();
                            this.massivePropList_.addAll(other.massivePropList_);
                        }
                        onChanged();
                    }
                } else if (!other.massivePropList_.isEmpty()) {
                    if (this.massivePropListBuilder_.isEmpty()) {
                        this.massivePropListBuilder_.dispose();
                        this.massivePropListBuilder_ = null;
                        this.massivePropList_ = other.massivePropList_;
                        this.bitField0_ &= -3;
                        this.massivePropListBuilder_ = AbilityMixinRecoverInfo.alwaysUseFieldBuilders ? getMassivePropListFieldBuilder() : null;
                    } else {
                        this.massivePropListBuilder_.addAllMessages(other.massivePropList_);
                    }
                }
                if (other.hasBreakoutSnapShot()) {
                    mergeBreakoutSnapShot(other.getBreakoutSnapShot());
                }
                switch (other.getSourceCase()) {
                    case INSTANCED_ABILITY_ID:
                        setInstancedAbilityId(other.getInstancedAbilityId());
                        break;
                    case INSTANCED_MODIFIER_ID:
                        setInstancedModifierId(other.getInstancedModifierId());
                        break;
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
                AbilityMixinRecoverInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AbilityMixinRecoverInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AbilityMixinRecoverInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
            public SourceCase getSourceCase() {
                return SourceCase.forNumber(this.sourceCase_);
            }

            public Builder clearSource() {
                this.sourceCase_ = 0;
                this.source_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
            public boolean hasInstancedAbilityId() {
                return this.sourceCase_ == 1;
            }

            @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
            public int getInstancedAbilityId() {
                if (this.sourceCase_ == 1) {
                    return ((Integer) this.source_).intValue();
                }
                return 0;
            }

            public Builder setInstancedAbilityId(int value) {
                this.sourceCase_ = 1;
                this.source_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearInstancedAbilityId() {
                if (this.sourceCase_ == 1) {
                    this.sourceCase_ = 0;
                    this.source_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
            public boolean hasInstancedModifierId() {
                return this.sourceCase_ == 2;
            }

            @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
            public int getInstancedModifierId() {
                if (this.sourceCase_ == 2) {
                    return ((Integer) this.source_).intValue();
                }
                return 0;
            }

            public Builder setInstancedModifierId(int value) {
                this.sourceCase_ = 2;
                this.source_ = Integer.valueOf(value);
                onChanged();
                return this;
            }

            public Builder clearInstancedModifierId() {
                if (this.sourceCase_ == 2) {
                    this.sourceCase_ = 0;
                    this.source_ = null;
                    onChanged();
                }
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
            public int getLocalId() {
                return this.localId_;
            }

            public Builder setLocalId(int value) {
                this.localId_ = value;
                onChanged();
                return this;
            }

            public Builder clearLocalId() {
                this.localId_ = 0;
                onChanged();
                return this;
            }

            private void ensureDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.dataList_ = AbilityMixinRecoverInfo.mutableCopy(this.dataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
            public List<Integer> getDataListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.dataList_) : this.dataList_;
            }

            @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
            public int getDataListCount() {
                return this.dataList_.size();
            }

            @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
            public int getDataList(int index) {
                return this.dataList_.getInt(index);
            }

            public Builder setDataList(int index, int value) {
                ensureDataListIsMutable();
                this.dataList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addDataList(int value) {
                ensureDataListIsMutable();
                this.dataList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllDataList(Iterable<? extends Integer> values) {
                ensureDataListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.dataList_);
                onChanged();
                return this;
            }

            public Builder clearDataList() {
                this.dataList_ = AbilityMixinRecoverInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
            public boolean getIsServerbuffModifier() {
                return this.isServerbuffModifier_;
            }

            public Builder setIsServerbuffModifier(boolean value) {
                this.isServerbuffModifier_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsServerbuffModifier() {
                this.isServerbuffModifier_ = false;
                onChanged();
                return this;
            }

            private void ensureMassivePropListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.massivePropList_ = new ArrayList(this.massivePropList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
            public List<MassivePropSyncInfoOuterClass.MassivePropSyncInfo> getMassivePropListList() {
                if (this.massivePropListBuilder_ == null) {
                    return Collections.unmodifiableList(this.massivePropList_);
                }
                return this.massivePropListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
            public int getMassivePropListCount() {
                if (this.massivePropListBuilder_ == null) {
                    return this.massivePropList_.size();
                }
                return this.massivePropListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
            public MassivePropSyncInfoOuterClass.MassivePropSyncInfo getMassivePropList(int index) {
                if (this.massivePropListBuilder_ == null) {
                    return this.massivePropList_.get(index);
                }
                return this.massivePropListBuilder_.getMessage(index);
            }

            public Builder setMassivePropList(int index, MassivePropSyncInfoOuterClass.MassivePropSyncInfo value) {
                if (this.massivePropListBuilder_ != null) {
                    this.massivePropListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMassivePropListIsMutable();
                    this.massivePropList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMassivePropList(int index, MassivePropSyncInfoOuterClass.MassivePropSyncInfo.Builder builderForValue) {
                if (this.massivePropListBuilder_ == null) {
                    ensureMassivePropListIsMutable();
                    this.massivePropList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.massivePropListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMassivePropList(MassivePropSyncInfoOuterClass.MassivePropSyncInfo value) {
                if (this.massivePropListBuilder_ != null) {
                    this.massivePropListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMassivePropListIsMutable();
                    this.massivePropList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMassivePropList(int index, MassivePropSyncInfoOuterClass.MassivePropSyncInfo value) {
                if (this.massivePropListBuilder_ != null) {
                    this.massivePropListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMassivePropListIsMutable();
                    this.massivePropList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMassivePropList(MassivePropSyncInfoOuterClass.MassivePropSyncInfo.Builder builderForValue) {
                if (this.massivePropListBuilder_ == null) {
                    ensureMassivePropListIsMutable();
                    this.massivePropList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.massivePropListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMassivePropList(int index, MassivePropSyncInfoOuterClass.MassivePropSyncInfo.Builder builderForValue) {
                if (this.massivePropListBuilder_ == null) {
                    ensureMassivePropListIsMutable();
                    this.massivePropList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.massivePropListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMassivePropList(Iterable<? extends MassivePropSyncInfoOuterClass.MassivePropSyncInfo> values) {
                if (this.massivePropListBuilder_ == null) {
                    ensureMassivePropListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.massivePropList_);
                    onChanged();
                } else {
                    this.massivePropListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMassivePropList() {
                if (this.massivePropListBuilder_ == null) {
                    this.massivePropList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.massivePropListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMassivePropList(int index) {
                if (this.massivePropListBuilder_ == null) {
                    ensureMassivePropListIsMutable();
                    this.massivePropList_.remove(index);
                    onChanged();
                } else {
                    this.massivePropListBuilder_.remove(index);
                }
                return this;
            }

            public MassivePropSyncInfoOuterClass.MassivePropSyncInfo.Builder getMassivePropListBuilder(int index) {
                return getMassivePropListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
            public MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder getMassivePropListOrBuilder(int index) {
                if (this.massivePropListBuilder_ == null) {
                    return this.massivePropList_.get(index);
                }
                return this.massivePropListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
            public List<? extends MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder> getMassivePropListOrBuilderList() {
                if (this.massivePropListBuilder_ != null) {
                    return this.massivePropListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.massivePropList_);
            }

            public MassivePropSyncInfoOuterClass.MassivePropSyncInfo.Builder addMassivePropListBuilder() {
                return getMassivePropListFieldBuilder().addBuilder(MassivePropSyncInfoOuterClass.MassivePropSyncInfo.getDefaultInstance());
            }

            public MassivePropSyncInfoOuterClass.MassivePropSyncInfo.Builder addMassivePropListBuilder(int index) {
                return getMassivePropListFieldBuilder().addBuilder(index, MassivePropSyncInfoOuterClass.MassivePropSyncInfo.getDefaultInstance());
            }

            public List<MassivePropSyncInfoOuterClass.MassivePropSyncInfo.Builder> getMassivePropListBuilderList() {
                return getMassivePropListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MassivePropSyncInfoOuterClass.MassivePropSyncInfo, MassivePropSyncInfoOuterClass.MassivePropSyncInfo.Builder, MassivePropSyncInfoOuterClass.MassivePropSyncInfoOrBuilder> getMassivePropListFieldBuilder() {
                if (this.massivePropListBuilder_ == null) {
                    this.massivePropListBuilder_ = new RepeatedFieldBuilderV3<>(this.massivePropList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.massivePropList_ = null;
                }
                return this.massivePropListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
            public boolean hasBreakoutSnapShot() {
                return (this.breakoutSnapShotBuilder_ == null && this.breakoutSnapShot_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
            public BreakoutSnapShotOuterClass.BreakoutSnapShot getBreakoutSnapShot() {
                if (this.breakoutSnapShotBuilder_ == null) {
                    return this.breakoutSnapShot_ == null ? BreakoutSnapShotOuterClass.BreakoutSnapShot.getDefaultInstance() : this.breakoutSnapShot_;
                }
                return this.breakoutSnapShotBuilder_.getMessage();
            }

            public Builder setBreakoutSnapShot(BreakoutSnapShotOuterClass.BreakoutSnapShot value) {
                if (this.breakoutSnapShotBuilder_ != null) {
                    this.breakoutSnapShotBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.breakoutSnapShot_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setBreakoutSnapShot(BreakoutSnapShotOuterClass.BreakoutSnapShot.Builder builderForValue) {
                if (this.breakoutSnapShotBuilder_ == null) {
                    this.breakoutSnapShot_ = builderForValue.build();
                    onChanged();
                } else {
                    this.breakoutSnapShotBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeBreakoutSnapShot(BreakoutSnapShotOuterClass.BreakoutSnapShot value) {
                if (this.breakoutSnapShotBuilder_ == null) {
                    if (this.breakoutSnapShot_ != null) {
                        this.breakoutSnapShot_ = BreakoutSnapShotOuterClass.BreakoutSnapShot.newBuilder(this.breakoutSnapShot_).mergeFrom(value).buildPartial();
                    } else {
                        this.breakoutSnapShot_ = value;
                    }
                    onChanged();
                } else {
                    this.breakoutSnapShotBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearBreakoutSnapShot() {
                if (this.breakoutSnapShotBuilder_ == null) {
                    this.breakoutSnapShot_ = null;
                    onChanged();
                } else {
                    this.breakoutSnapShot_ = null;
                    this.breakoutSnapShotBuilder_ = null;
                }
                return this;
            }

            public BreakoutSnapShotOuterClass.BreakoutSnapShot.Builder getBreakoutSnapShotBuilder() {
                onChanged();
                return getBreakoutSnapShotFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder
            public BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder getBreakoutSnapShotOrBuilder() {
                if (this.breakoutSnapShotBuilder_ != null) {
                    return this.breakoutSnapShotBuilder_.getMessageOrBuilder();
                }
                return this.breakoutSnapShot_ == null ? BreakoutSnapShotOuterClass.BreakoutSnapShot.getDefaultInstance() : this.breakoutSnapShot_;
            }

            private SingleFieldBuilderV3<BreakoutSnapShotOuterClass.BreakoutSnapShot, BreakoutSnapShotOuterClass.BreakoutSnapShot.Builder, BreakoutSnapShotOuterClass.BreakoutSnapShotOrBuilder> getBreakoutSnapShotFieldBuilder() {
                if (this.breakoutSnapShotBuilder_ == null) {
                    this.breakoutSnapShotBuilder_ = new SingleFieldBuilderV3<>(getBreakoutSnapShot(), getParentForChildren(), isClean());
                    this.breakoutSnapShot_ = null;
                }
                return this.breakoutSnapShotBuilder_;
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

        public static AbilityMixinRecoverInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AbilityMixinRecoverInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AbilityMixinRecoverInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AbilityMixinRecoverInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BreakoutSnapShotOuterClass.getDescriptor();
        MassivePropSyncInfoOuterClass.getDescriptor();
    }
}
