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
import emu.grasscutter.net.proto.LockedPersonallineDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PersonalLineAllDataRspOuterClass.class */
public final class PersonalLineAllDataRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cPersonalLineAllDataRsp.proto\u001a\u001cLockedPersonallineData.proto\"è\u0001\n\u0016PersonalLineAllDataRsp\u0012\u001f\n\u0017ongoingPersonalLineList\u0018\u0005 \u0003(\r\u0012\u0019\n\u0011legendaryKeyCount\u0018\u0007 \u0001(\r\u0012!\n\u0019curFinishedDailyTaskCount\u0018\u0002 \u0001(\r\u0012%\n\u001dcanBeUnlockedPersonalLineList\u0018\u0004 \u0003(\r\u0012\u000f\n\u0007retcode\u0018\u000b \u0001(\u0005\u00127\n\u0016lockedPersonalLineList\u0018\n \u0003(\u000b2\u0017.LockedPersonallineDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{LockedPersonallineDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_PersonalLineAllDataRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_PersonalLineAllDataRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_PersonalLineAllDataRsp_descriptor, new String[]{"OngoingPersonalLineList", "LegendaryKeyCount", "CurFinishedDailyTaskCount", "CanBeUnlockedPersonalLineList", "Retcode", "LockedPersonalLineList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PersonalLineAllDataRspOuterClass$PersonalLineAllDataRspOrBuilder.class */
    public interface PersonalLineAllDataRspOrBuilder extends MessageOrBuilder {
        List<Integer> getOngoingPersonalLineListList();

        int getOngoingPersonalLineListCount();

        int getOngoingPersonalLineList(int i);

        int getLegendaryKeyCount();

        int getCurFinishedDailyTaskCount();

        List<Integer> getCanBeUnlockedPersonalLineListList();

        int getCanBeUnlockedPersonalLineListCount();

        int getCanBeUnlockedPersonalLineList(int i);

        int getRetcode();

        List<LockedPersonallineDataOuterClass.LockedPersonallineData> getLockedPersonalLineListList();

        LockedPersonallineDataOuterClass.LockedPersonallineData getLockedPersonalLineList(int i);

        int getLockedPersonalLineListCount();

        List<? extends LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder> getLockedPersonalLineListOrBuilderList();

        LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder getLockedPersonalLineListOrBuilder(int i);
    }

    private PersonalLineAllDataRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PersonalLineAllDataRspOuterClass$PersonalLineAllDataRsp.class */
    public static final class PersonalLineAllDataRsp extends GeneratedMessageV3 implements PersonalLineAllDataRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ONGOINGPERSONALLINELIST_FIELD_NUMBER = 5;
        private Internal.IntList ongoingPersonalLineList_;
        private int ongoingPersonalLineListMemoizedSerializedSize;
        public static final int LEGENDARYKEYCOUNT_FIELD_NUMBER = 7;
        private int legendaryKeyCount_;
        public static final int CURFINISHEDDAILYTASKCOUNT_FIELD_NUMBER = 2;
        private int curFinishedDailyTaskCount_;
        public static final int CANBEUNLOCKEDPERSONALLINELIST_FIELD_NUMBER = 4;
        private Internal.IntList canBeUnlockedPersonalLineList_;
        private int canBeUnlockedPersonalLineListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 11;
        private int retcode_;
        public static final int LOCKEDPERSONALLINELIST_FIELD_NUMBER = 10;
        private List<LockedPersonallineDataOuterClass.LockedPersonallineData> lockedPersonalLineList_;
        private byte memoizedIsInitialized;
        private static final PersonalLineAllDataRsp DEFAULT_INSTANCE = new PersonalLineAllDataRsp();
        private static final Parser<PersonalLineAllDataRsp> PARSER = new AbstractParser<PersonalLineAllDataRsp>() { // from class: emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRsp.1
            @Override // com.google.protobuf.Parser
            public PersonalLineAllDataRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new PersonalLineAllDataRsp(input, extensionRegistry);
            }
        };

        private PersonalLineAllDataRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.ongoingPersonalLineListMemoizedSerializedSize = -1;
            this.canBeUnlockedPersonalLineListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private PersonalLineAllDataRsp() {
            this.ongoingPersonalLineListMemoizedSerializedSize = -1;
            this.canBeUnlockedPersonalLineListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.ongoingPersonalLineList_ = emptyIntList();
            this.canBeUnlockedPersonalLineList_ = emptyIntList();
            this.lockedPersonalLineList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new PersonalLineAllDataRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:95:0x01aa */
        private PersonalLineAllDataRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.curFinishedDailyTaskCount_ = input.readUInt32();
                                break;
                            case 32:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.canBeUnlockedPersonalLineList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.canBeUnlockedPersonalLineList_.addInt(input.readUInt32());
                                break;
                            case 34:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 2) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.canBeUnlockedPersonalLineList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.canBeUnlockedPersonalLineList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 40:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.ongoingPersonalLineList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.ongoingPersonalLineList_.addInt(input.readUInt32());
                                break;
                            case 42:
                                int limit2 = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.ongoingPersonalLineList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.ongoingPersonalLineList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit2);
                                break;
                            case 56:
                                this.legendaryKeyCount_ = input.readUInt32();
                                break;
                            case 82:
                                if ((mutable_bitField0_ & 4) == 0) {
                                    this.lockedPersonalLineList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                }
                                this.lockedPersonalLineList_.add((LockedPersonallineDataOuterClass.LockedPersonallineData) input.readMessage(LockedPersonallineDataOuterClass.LockedPersonallineData.parser(), extensionRegistry));
                                break;
                            case 88:
                                this.retcode_ = input.readInt32();
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
                    this.canBeUnlockedPersonalLineList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.ongoingPersonalLineList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.lockedPersonalLineList_ = Collections.unmodifiableList(this.lockedPersonalLineList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return PersonalLineAllDataRspOuterClass.internal_static_PersonalLineAllDataRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return PersonalLineAllDataRspOuterClass.internal_static_PersonalLineAllDataRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PersonalLineAllDataRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
        public List<Integer> getOngoingPersonalLineListList() {
            return this.ongoingPersonalLineList_;
        }

        @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
        public int getOngoingPersonalLineListCount() {
            return this.ongoingPersonalLineList_.size();
        }

        @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
        public int getOngoingPersonalLineList(int index) {
            return this.ongoingPersonalLineList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
        public int getLegendaryKeyCount() {
            return this.legendaryKeyCount_;
        }

        @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
        public int getCurFinishedDailyTaskCount() {
            return this.curFinishedDailyTaskCount_;
        }

        @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
        public List<Integer> getCanBeUnlockedPersonalLineListList() {
            return this.canBeUnlockedPersonalLineList_;
        }

        @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
        public int getCanBeUnlockedPersonalLineListCount() {
            return this.canBeUnlockedPersonalLineList_.size();
        }

        @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
        public int getCanBeUnlockedPersonalLineList(int index) {
            return this.canBeUnlockedPersonalLineList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
        public List<LockedPersonallineDataOuterClass.LockedPersonallineData> getLockedPersonalLineListList() {
            return this.lockedPersonalLineList_;
        }

        @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
        public List<? extends LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder> getLockedPersonalLineListOrBuilderList() {
            return this.lockedPersonalLineList_;
        }

        @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
        public int getLockedPersonalLineListCount() {
            return this.lockedPersonalLineList_.size();
        }

        @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
        public LockedPersonallineDataOuterClass.LockedPersonallineData getLockedPersonalLineList(int index) {
            return this.lockedPersonalLineList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
        public LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder getLockedPersonalLineListOrBuilder(int index) {
            return this.lockedPersonalLineList_.get(index);
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
            if (this.curFinishedDailyTaskCount_ != 0) {
                output.writeUInt32(2, this.curFinishedDailyTaskCount_);
            }
            if (getCanBeUnlockedPersonalLineListList().size() > 0) {
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.canBeUnlockedPersonalLineListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.canBeUnlockedPersonalLineList_.size(); i++) {
                output.writeUInt32NoTag(this.canBeUnlockedPersonalLineList_.getInt(i));
            }
            if (getOngoingPersonalLineListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.ongoingPersonalLineListMemoizedSerializedSize);
            }
            for (int i2 = 0; i2 < this.ongoingPersonalLineList_.size(); i2++) {
                output.writeUInt32NoTag(this.ongoingPersonalLineList_.getInt(i2));
            }
            if (this.legendaryKeyCount_ != 0) {
                output.writeUInt32(7, this.legendaryKeyCount_);
            }
            for (int i3 = 0; i3 < this.lockedPersonalLineList_.size(); i3++) {
                output.writeMessage(10, this.lockedPersonalLineList_.get(i3));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(11, this.retcode_);
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
            if (this.curFinishedDailyTaskCount_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.curFinishedDailyTaskCount_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.canBeUnlockedPersonalLineList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.canBeUnlockedPersonalLineList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getCanBeUnlockedPersonalLineListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.canBeUnlockedPersonalLineListMemoizedSerializedSize = dataSize;
            int dataSize2 = 0;
            for (int i2 = 0; i2 < this.ongoingPersonalLineList_.size(); i2++) {
                dataSize2 += CodedOutputStream.computeUInt32SizeNoTag(this.ongoingPersonalLineList_.getInt(i2));
            }
            int size4 = size3 + dataSize2;
            if (!getOngoingPersonalLineListList().isEmpty()) {
                size4 = size4 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize2);
            }
            this.ongoingPersonalLineListMemoizedSerializedSize = dataSize2;
            if (this.legendaryKeyCount_ != 0) {
                size4 += CodedOutputStream.computeUInt32Size(7, this.legendaryKeyCount_);
            }
            for (int i3 = 0; i3 < this.lockedPersonalLineList_.size(); i3++) {
                size4 += CodedOutputStream.computeMessageSize(10, this.lockedPersonalLineList_.get(i3));
            }
            if (this.retcode_ != 0) {
                size4 += CodedOutputStream.computeInt32Size(11, this.retcode_);
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
            if (!(obj instanceof PersonalLineAllDataRsp)) {
                return equals(obj);
            }
            PersonalLineAllDataRsp other = (PersonalLineAllDataRsp) obj;
            return getOngoingPersonalLineListList().equals(other.getOngoingPersonalLineListList()) && getLegendaryKeyCount() == other.getLegendaryKeyCount() && getCurFinishedDailyTaskCount() == other.getCurFinishedDailyTaskCount() && getCanBeUnlockedPersonalLineListList().equals(other.getCanBeUnlockedPersonalLineListList()) && getRetcode() == other.getRetcode() && getLockedPersonalLineListList().equals(other.getLockedPersonalLineListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getOngoingPersonalLineListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getOngoingPersonalLineListList().hashCode();
            }
            int hash2 = (53 * ((37 * ((53 * ((37 * hash) + 7)) + getLegendaryKeyCount())) + 2)) + getCurFinishedDailyTaskCount();
            if (getCanBeUnlockedPersonalLineListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 4)) + getCanBeUnlockedPersonalLineListList().hashCode();
            }
            int hash3 = (53 * ((37 * hash2) + 11)) + getRetcode();
            if (getLockedPersonalLineListCount() > 0) {
                hash3 = (53 * ((37 * hash3) + 10)) + getLockedPersonalLineListList().hashCode();
            }
            int hash4 = (29 * hash3) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash4;
            return hash4;
        }

        public static PersonalLineAllDataRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PersonalLineAllDataRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PersonalLineAllDataRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PersonalLineAllDataRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PersonalLineAllDataRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static PersonalLineAllDataRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static PersonalLineAllDataRsp parseFrom(InputStream input) throws IOException {
            return (PersonalLineAllDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PersonalLineAllDataRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PersonalLineAllDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static PersonalLineAllDataRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (PersonalLineAllDataRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static PersonalLineAllDataRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PersonalLineAllDataRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static PersonalLineAllDataRsp parseFrom(CodedInputStream input) throws IOException {
            return (PersonalLineAllDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static PersonalLineAllDataRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (PersonalLineAllDataRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(PersonalLineAllDataRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/PersonalLineAllDataRspOuterClass$PersonalLineAllDataRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements PersonalLineAllDataRspOrBuilder {
            private int bitField0_;
            private int legendaryKeyCount_;
            private int curFinishedDailyTaskCount_;
            private int retcode_;
            private RepeatedFieldBuilderV3<LockedPersonallineDataOuterClass.LockedPersonallineData, LockedPersonallineDataOuterClass.LockedPersonallineData.Builder, LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder> lockedPersonalLineListBuilder_;
            private Internal.IntList ongoingPersonalLineList_ = PersonalLineAllDataRsp.emptyIntList();
            private Internal.IntList canBeUnlockedPersonalLineList_ = PersonalLineAllDataRsp.emptyIntList();
            private List<LockedPersonallineDataOuterClass.LockedPersonallineData> lockedPersonalLineList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return PersonalLineAllDataRspOuterClass.internal_static_PersonalLineAllDataRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return PersonalLineAllDataRspOuterClass.internal_static_PersonalLineAllDataRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(PersonalLineAllDataRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (PersonalLineAllDataRsp.alwaysUseFieldBuilders) {
                    getLockedPersonalLineListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.ongoingPersonalLineList_ = PersonalLineAllDataRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.legendaryKeyCount_ = 0;
                this.curFinishedDailyTaskCount_ = 0;
                this.canBeUnlockedPersonalLineList_ = PersonalLineAllDataRsp.emptyIntList();
                this.bitField0_ &= -3;
                this.retcode_ = 0;
                if (this.lockedPersonalLineListBuilder_ == null) {
                    this.lockedPersonalLineList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.lockedPersonalLineListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return PersonalLineAllDataRspOuterClass.internal_static_PersonalLineAllDataRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public PersonalLineAllDataRsp getDefaultInstanceForType() {
                return PersonalLineAllDataRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PersonalLineAllDataRsp build() {
                PersonalLineAllDataRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public PersonalLineAllDataRsp buildPartial() {
                PersonalLineAllDataRsp result = new PersonalLineAllDataRsp(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.ongoingPersonalLineList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.ongoingPersonalLineList_ = this.ongoingPersonalLineList_;
                result.legendaryKeyCount_ = this.legendaryKeyCount_;
                result.curFinishedDailyTaskCount_ = this.curFinishedDailyTaskCount_;
                if ((this.bitField0_ & 2) != 0) {
                    this.canBeUnlockedPersonalLineList_.makeImmutable();
                    this.bitField0_ &= -3;
                }
                result.canBeUnlockedPersonalLineList_ = this.canBeUnlockedPersonalLineList_;
                result.retcode_ = this.retcode_;
                if (this.lockedPersonalLineListBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.lockedPersonalLineList_ = Collections.unmodifiableList(this.lockedPersonalLineList_);
                        this.bitField0_ &= -5;
                    }
                    result.lockedPersonalLineList_ = this.lockedPersonalLineList_;
                } else {
                    result.lockedPersonalLineList_ = this.lockedPersonalLineListBuilder_.build();
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
                if (other instanceof PersonalLineAllDataRsp) {
                    return mergeFrom((PersonalLineAllDataRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(PersonalLineAllDataRsp other) {
                if (other == PersonalLineAllDataRsp.getDefaultInstance()) {
                    return this;
                }
                if (!other.ongoingPersonalLineList_.isEmpty()) {
                    if (this.ongoingPersonalLineList_.isEmpty()) {
                        this.ongoingPersonalLineList_ = other.ongoingPersonalLineList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureOngoingPersonalLineListIsMutable();
                        this.ongoingPersonalLineList_.addAll(other.ongoingPersonalLineList_);
                    }
                    onChanged();
                }
                if (other.getLegendaryKeyCount() != 0) {
                    setLegendaryKeyCount(other.getLegendaryKeyCount());
                }
                if (other.getCurFinishedDailyTaskCount() != 0) {
                    setCurFinishedDailyTaskCount(other.getCurFinishedDailyTaskCount());
                }
                if (!other.canBeUnlockedPersonalLineList_.isEmpty()) {
                    if (this.canBeUnlockedPersonalLineList_.isEmpty()) {
                        this.canBeUnlockedPersonalLineList_ = other.canBeUnlockedPersonalLineList_;
                        this.bitField0_ &= -3;
                    } else {
                        ensureCanBeUnlockedPersonalLineListIsMutable();
                        this.canBeUnlockedPersonalLineList_.addAll(other.canBeUnlockedPersonalLineList_);
                    }
                    onChanged();
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (this.lockedPersonalLineListBuilder_ == null) {
                    if (!other.lockedPersonalLineList_.isEmpty()) {
                        if (this.lockedPersonalLineList_.isEmpty()) {
                            this.lockedPersonalLineList_ = other.lockedPersonalLineList_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureLockedPersonalLineListIsMutable();
                            this.lockedPersonalLineList_.addAll(other.lockedPersonalLineList_);
                        }
                        onChanged();
                    }
                } else if (!other.lockedPersonalLineList_.isEmpty()) {
                    if (this.lockedPersonalLineListBuilder_.isEmpty()) {
                        this.lockedPersonalLineListBuilder_.dispose();
                        this.lockedPersonalLineListBuilder_ = null;
                        this.lockedPersonalLineList_ = other.lockedPersonalLineList_;
                        this.bitField0_ &= -5;
                        this.lockedPersonalLineListBuilder_ = PersonalLineAllDataRsp.alwaysUseFieldBuilders ? getLockedPersonalLineListFieldBuilder() : null;
                    } else {
                        this.lockedPersonalLineListBuilder_.addAllMessages(other.lockedPersonalLineList_);
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
                PersonalLineAllDataRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = PersonalLineAllDataRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (PersonalLineAllDataRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureOngoingPersonalLineListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.ongoingPersonalLineList_ = PersonalLineAllDataRsp.mutableCopy(this.ongoingPersonalLineList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
            public List<Integer> getOngoingPersonalLineListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.ongoingPersonalLineList_) : this.ongoingPersonalLineList_;
            }

            @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
            public int getOngoingPersonalLineListCount() {
                return this.ongoingPersonalLineList_.size();
            }

            @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
            public int getOngoingPersonalLineList(int index) {
                return this.ongoingPersonalLineList_.getInt(index);
            }

            public Builder setOngoingPersonalLineList(int index, int value) {
                ensureOngoingPersonalLineListIsMutable();
                this.ongoingPersonalLineList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addOngoingPersonalLineList(int value) {
                ensureOngoingPersonalLineListIsMutable();
                this.ongoingPersonalLineList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllOngoingPersonalLineList(Iterable<? extends Integer> values) {
                ensureOngoingPersonalLineListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.ongoingPersonalLineList_);
                onChanged();
                return this;
            }

            public Builder clearOngoingPersonalLineList() {
                this.ongoingPersonalLineList_ = PersonalLineAllDataRsp.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
            public int getLegendaryKeyCount() {
                return this.legendaryKeyCount_;
            }

            public Builder setLegendaryKeyCount(int value) {
                this.legendaryKeyCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearLegendaryKeyCount() {
                this.legendaryKeyCount_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
            public int getCurFinishedDailyTaskCount() {
                return this.curFinishedDailyTaskCount_;
            }

            public Builder setCurFinishedDailyTaskCount(int value) {
                this.curFinishedDailyTaskCount_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurFinishedDailyTaskCount() {
                this.curFinishedDailyTaskCount_ = 0;
                onChanged();
                return this;
            }

            private void ensureCanBeUnlockedPersonalLineListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.canBeUnlockedPersonalLineList_ = PersonalLineAllDataRsp.mutableCopy(this.canBeUnlockedPersonalLineList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
            public List<Integer> getCanBeUnlockedPersonalLineListList() {
                return (this.bitField0_ & 2) != 0 ? Collections.unmodifiableList(this.canBeUnlockedPersonalLineList_) : this.canBeUnlockedPersonalLineList_;
            }

            @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
            public int getCanBeUnlockedPersonalLineListCount() {
                return this.canBeUnlockedPersonalLineList_.size();
            }

            @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
            public int getCanBeUnlockedPersonalLineList(int index) {
                return this.canBeUnlockedPersonalLineList_.getInt(index);
            }

            public Builder setCanBeUnlockedPersonalLineList(int index, int value) {
                ensureCanBeUnlockedPersonalLineListIsMutable();
                this.canBeUnlockedPersonalLineList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addCanBeUnlockedPersonalLineList(int value) {
                ensureCanBeUnlockedPersonalLineListIsMutable();
                this.canBeUnlockedPersonalLineList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllCanBeUnlockedPersonalLineList(Iterable<? extends Integer> values) {
                ensureCanBeUnlockedPersonalLineListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.canBeUnlockedPersonalLineList_);
                onChanged();
                return this;
            }

            public Builder clearCanBeUnlockedPersonalLineList() {
                this.canBeUnlockedPersonalLineList_ = PersonalLineAllDataRsp.emptyIntList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
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

            private void ensureLockedPersonalLineListIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.lockedPersonalLineList_ = new ArrayList(this.lockedPersonalLineList_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
            public List<LockedPersonallineDataOuterClass.LockedPersonallineData> getLockedPersonalLineListList() {
                if (this.lockedPersonalLineListBuilder_ == null) {
                    return Collections.unmodifiableList(this.lockedPersonalLineList_);
                }
                return this.lockedPersonalLineListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
            public int getLockedPersonalLineListCount() {
                if (this.lockedPersonalLineListBuilder_ == null) {
                    return this.lockedPersonalLineList_.size();
                }
                return this.lockedPersonalLineListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
            public LockedPersonallineDataOuterClass.LockedPersonallineData getLockedPersonalLineList(int index) {
                if (this.lockedPersonalLineListBuilder_ == null) {
                    return this.lockedPersonalLineList_.get(index);
                }
                return this.lockedPersonalLineListBuilder_.getMessage(index);
            }

            public Builder setLockedPersonalLineList(int index, LockedPersonallineDataOuterClass.LockedPersonallineData value) {
                if (this.lockedPersonalLineListBuilder_ != null) {
                    this.lockedPersonalLineListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLockedPersonalLineListIsMutable();
                    this.lockedPersonalLineList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setLockedPersonalLineList(int index, LockedPersonallineDataOuterClass.LockedPersonallineData.Builder builderForValue) {
                if (this.lockedPersonalLineListBuilder_ == null) {
                    ensureLockedPersonalLineListIsMutable();
                    this.lockedPersonalLineList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.lockedPersonalLineListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addLockedPersonalLineList(LockedPersonallineDataOuterClass.LockedPersonallineData value) {
                if (this.lockedPersonalLineListBuilder_ != null) {
                    this.lockedPersonalLineListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLockedPersonalLineListIsMutable();
                    this.lockedPersonalLineList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addLockedPersonalLineList(int index, LockedPersonallineDataOuterClass.LockedPersonallineData value) {
                if (this.lockedPersonalLineListBuilder_ != null) {
                    this.lockedPersonalLineListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureLockedPersonalLineListIsMutable();
                    this.lockedPersonalLineList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addLockedPersonalLineList(LockedPersonallineDataOuterClass.LockedPersonallineData.Builder builderForValue) {
                if (this.lockedPersonalLineListBuilder_ == null) {
                    ensureLockedPersonalLineListIsMutable();
                    this.lockedPersonalLineList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.lockedPersonalLineListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addLockedPersonalLineList(int index, LockedPersonallineDataOuterClass.LockedPersonallineData.Builder builderForValue) {
                if (this.lockedPersonalLineListBuilder_ == null) {
                    ensureLockedPersonalLineListIsMutable();
                    this.lockedPersonalLineList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.lockedPersonalLineListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllLockedPersonalLineList(Iterable<? extends LockedPersonallineDataOuterClass.LockedPersonallineData> values) {
                if (this.lockedPersonalLineListBuilder_ == null) {
                    ensureLockedPersonalLineListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.lockedPersonalLineList_);
                    onChanged();
                } else {
                    this.lockedPersonalLineListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearLockedPersonalLineList() {
                if (this.lockedPersonalLineListBuilder_ == null) {
                    this.lockedPersonalLineList_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.lockedPersonalLineListBuilder_.clear();
                }
                return this;
            }

            public Builder removeLockedPersonalLineList(int index) {
                if (this.lockedPersonalLineListBuilder_ == null) {
                    ensureLockedPersonalLineListIsMutable();
                    this.lockedPersonalLineList_.remove(index);
                    onChanged();
                } else {
                    this.lockedPersonalLineListBuilder_.remove(index);
                }
                return this;
            }

            public LockedPersonallineDataOuterClass.LockedPersonallineData.Builder getLockedPersonalLineListBuilder(int index) {
                return getLockedPersonalLineListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
            public LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder getLockedPersonalLineListOrBuilder(int index) {
                if (this.lockedPersonalLineListBuilder_ == null) {
                    return this.lockedPersonalLineList_.get(index);
                }
                return this.lockedPersonalLineListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.PersonalLineAllDataRspOuterClass.PersonalLineAllDataRspOrBuilder
            public List<? extends LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder> getLockedPersonalLineListOrBuilderList() {
                if (this.lockedPersonalLineListBuilder_ != null) {
                    return this.lockedPersonalLineListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.lockedPersonalLineList_);
            }

            public LockedPersonallineDataOuterClass.LockedPersonallineData.Builder addLockedPersonalLineListBuilder() {
                return getLockedPersonalLineListFieldBuilder().addBuilder(LockedPersonallineDataOuterClass.LockedPersonallineData.getDefaultInstance());
            }

            public LockedPersonallineDataOuterClass.LockedPersonallineData.Builder addLockedPersonalLineListBuilder(int index) {
                return getLockedPersonalLineListFieldBuilder().addBuilder(index, LockedPersonallineDataOuterClass.LockedPersonallineData.getDefaultInstance());
            }

            public List<LockedPersonallineDataOuterClass.LockedPersonallineData.Builder> getLockedPersonalLineListBuilderList() {
                return getLockedPersonalLineListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<LockedPersonallineDataOuterClass.LockedPersonallineData, LockedPersonallineDataOuterClass.LockedPersonallineData.Builder, LockedPersonallineDataOuterClass.LockedPersonallineDataOrBuilder> getLockedPersonalLineListFieldBuilder() {
                if (this.lockedPersonalLineListBuilder_ == null) {
                    this.lockedPersonalLineListBuilder_ = new RepeatedFieldBuilderV3<>(this.lockedPersonalLineList_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.lockedPersonalLineList_ = null;
                }
                return this.lockedPersonalLineListBuilder_;
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

        public static PersonalLineAllDataRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<PersonalLineAllDataRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<PersonalLineAllDataRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public PersonalLineAllDataRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        LockedPersonallineDataOuterClass.getDescriptor();
    }
}
