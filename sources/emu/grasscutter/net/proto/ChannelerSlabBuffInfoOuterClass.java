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
import emu.grasscutter.net.proto.ChannelerSlabAssistInfoOuterClass;
import emu.grasscutter.net.proto.ChannelerSlabBuffSchemeInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabBuffInfoOuterClass.class */
public final class ChannelerSlabBuffInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001bChannelerSlabBuffInfo.proto\u001a!ChannelerSlabBuffSchemeInfo.proto\u001a\u001dChannelerSlabAssistInfo.proto\"Ó\u0001\n\u0015ChannelerSlabBuffInfo\u00129\n\u0013Unk3300_ANENHMAADLN\u0018\u0006 \u0001(\u000b2\u001c.ChannelerSlabBuffSchemeInfo\u0012\u0012\n\nbuffIdList\u0018\n \u0003(\r\u00129\n\u0013Unk3300_CDFLIONGKCH\u0018\t \u0001(\u000b2\u001c.ChannelerSlabBuffSchemeInfo\u00120\n\u000eassistInfoList\u0018\u000e \u0003(\u000b2\u0018.ChannelerSlabAssistInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ChannelerSlabBuffSchemeInfoOuterClass.getDescriptor(), ChannelerSlabAssistInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_ChannelerSlabBuffInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_ChannelerSlabBuffInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_ChannelerSlabBuffInfo_descriptor, new String[]{"Unk3300ANENHMAADLN", "BuffIdList", "Unk3300CDFLIONGKCH", "AssistInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabBuffInfoOuterClass$ChannelerSlabBuffInfoOrBuilder.class */
    public interface ChannelerSlabBuffInfoOrBuilder extends MessageOrBuilder {
        boolean hasUnk3300ANENHMAADLN();

        ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo getUnk3300ANENHMAADLN();

        ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder getUnk3300ANENHMAADLNOrBuilder();

        List<Integer> getBuffIdListList();

        int getBuffIdListCount();

        int getBuffIdList(int i);

        boolean hasUnk3300CDFLIONGKCH();

        ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo getUnk3300CDFLIONGKCH();

        ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder getUnk3300CDFLIONGKCHOrBuilder();

        List<ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo> getAssistInfoListList();

        ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo getAssistInfoList(int i);

        int getAssistInfoListCount();

        List<? extends ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfoOrBuilder> getAssistInfoListOrBuilderList();

        ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfoOrBuilder getAssistInfoListOrBuilder(int i);
    }

    private ChannelerSlabBuffInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabBuffInfoOuterClass$ChannelerSlabBuffInfo.class */
    public static final class ChannelerSlabBuffInfo extends GeneratedMessageV3 implements ChannelerSlabBuffInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UNK3300_ANENHMAADLN_FIELD_NUMBER = 6;
        private ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo unk3300ANENHMAADLN_;
        public static final int BUFFIDLIST_FIELD_NUMBER = 10;
        private Internal.IntList buffIdList_;
        private int buffIdListMemoizedSerializedSize;
        public static final int UNK3300_CDFLIONGKCH_FIELD_NUMBER = 9;
        private ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo unk3300CDFLIONGKCH_;
        public static final int ASSISTINFOLIST_FIELD_NUMBER = 14;
        private List<ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo> assistInfoList_;
        private byte memoizedIsInitialized;
        private static final ChannelerSlabBuffInfo DEFAULT_INSTANCE = new ChannelerSlabBuffInfo();
        private static final Parser<ChannelerSlabBuffInfo> PARSER = new AbstractParser<ChannelerSlabBuffInfo>() { // from class: emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfo.1
            @Override // com.google.protobuf.Parser
            public ChannelerSlabBuffInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new ChannelerSlabBuffInfo(input, extensionRegistry);
            }
        };

        private ChannelerSlabBuffInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.buffIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private ChannelerSlabBuffInfo() {
            this.buffIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.buffIdList_ = emptyIntList();
            this.assistInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new ChannelerSlabBuffInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:84:0x0184 */
        private ChannelerSlabBuffInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 50:
                                    ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.Builder subBuilder = this.unk3300ANENHMAADLN_ != null ? this.unk3300ANENHMAADLN_.toBuilder() : null;
                                    this.unk3300ANENHMAADLN_ = (ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo) input.readMessage(ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.parser(), extensionRegistry);
                                    if (subBuilder == null) {
                                        break;
                                    } else {
                                        subBuilder.mergeFrom(this.unk3300ANENHMAADLN_);
                                        this.unk3300ANENHMAADLN_ = subBuilder.buildPartial();
                                        break;
                                    }
                                case 74:
                                    ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.Builder subBuilder2 = this.unk3300CDFLIONGKCH_ != null ? this.unk3300CDFLIONGKCH_.toBuilder() : null;
                                    this.unk3300CDFLIONGKCH_ = (ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo) input.readMessage(ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.parser(), extensionRegistry);
                                    if (subBuilder2 == null) {
                                        break;
                                    } else {
                                        subBuilder2.mergeFrom(this.unk3300CDFLIONGKCH_);
                                        this.unk3300CDFLIONGKCH_ = subBuilder2.buildPartial();
                                        break;
                                    }
                                case 80:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.buffIdList_ = newIntList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.buffIdList_.addInt(input.readUInt32());
                                    break;
                                case 82:
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
                                case 114:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.assistInfoList_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.assistInfoList_.add((ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo) input.readMessage(ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.buffIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.assistInfoList_ = Collections.unmodifiableList(this.assistInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ChannelerSlabBuffInfoOuterClass.internal_static_ChannelerSlabBuffInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ChannelerSlabBuffInfoOuterClass.internal_static_ChannelerSlabBuffInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ChannelerSlabBuffInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
        public boolean hasUnk3300ANENHMAADLN() {
            return this.unk3300ANENHMAADLN_ != null;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
        public ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo getUnk3300ANENHMAADLN() {
            return this.unk3300ANENHMAADLN_ == null ? ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.getDefaultInstance() : this.unk3300ANENHMAADLN_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
        public ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder getUnk3300ANENHMAADLNOrBuilder() {
            return getUnk3300ANENHMAADLN();
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
        public List<Integer> getBuffIdListList() {
            return this.buffIdList_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
        public int getBuffIdListCount() {
            return this.buffIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
        public int getBuffIdList(int index) {
            return this.buffIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
        public boolean hasUnk3300CDFLIONGKCH() {
            return this.unk3300CDFLIONGKCH_ != null;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
        public ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo getUnk3300CDFLIONGKCH() {
            return this.unk3300CDFLIONGKCH_ == null ? ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.getDefaultInstance() : this.unk3300CDFLIONGKCH_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
        public ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder getUnk3300CDFLIONGKCHOrBuilder() {
            return getUnk3300CDFLIONGKCH();
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
        public List<ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo> getAssistInfoListList() {
            return this.assistInfoList_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
        public List<? extends ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfoOrBuilder> getAssistInfoListOrBuilderList() {
            return this.assistInfoList_;
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
        public int getAssistInfoListCount() {
            return this.assistInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
        public ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo getAssistInfoList(int index) {
            return this.assistInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
        public ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfoOrBuilder getAssistInfoListOrBuilder(int index) {
            return this.assistInfoList_.get(index);
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
            if (this.unk3300ANENHMAADLN_ != null) {
                output.writeMessage(6, getUnk3300ANENHMAADLN());
            }
            if (this.unk3300CDFLIONGKCH_ != null) {
                output.writeMessage(9, getUnk3300CDFLIONGKCH());
            }
            if (getBuffIdListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.buffIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.buffIdList_.size(); i++) {
                output.writeUInt32NoTag(this.buffIdList_.getInt(i));
            }
            for (int i2 = 0; i2 < this.assistInfoList_.size(); i2++) {
                output.writeMessage(14, this.assistInfoList_.get(i2));
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
            if (this.unk3300ANENHMAADLN_ != null) {
                size2 = 0 + CodedOutputStream.computeMessageSize(6, getUnk3300ANENHMAADLN());
            }
            if (this.unk3300CDFLIONGKCH_ != null) {
                size2 += CodedOutputStream.computeMessageSize(9, getUnk3300CDFLIONGKCH());
            }
            int dataSize = 0;
            for (int i = 0; i < this.buffIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.buffIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getBuffIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.buffIdListMemoizedSerializedSize = dataSize;
            for (int i2 = 0; i2 < this.assistInfoList_.size(); i2++) {
                size3 += CodedOutputStream.computeMessageSize(14, this.assistInfoList_.get(i2));
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
            if (!(obj instanceof ChannelerSlabBuffInfo)) {
                return equals(obj);
            }
            ChannelerSlabBuffInfo other = (ChannelerSlabBuffInfo) obj;
            if (hasUnk3300ANENHMAADLN() != other.hasUnk3300ANENHMAADLN()) {
                return false;
            }
            if ((!hasUnk3300ANENHMAADLN() || getUnk3300ANENHMAADLN().equals(other.getUnk3300ANENHMAADLN())) && getBuffIdListList().equals(other.getBuffIdListList()) && hasUnk3300CDFLIONGKCH() == other.hasUnk3300CDFLIONGKCH()) {
                return (!hasUnk3300CDFLIONGKCH() || getUnk3300CDFLIONGKCH().equals(other.getUnk3300CDFLIONGKCH())) && getAssistInfoListList().equals(other.getAssistInfoListList()) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (hasUnk3300ANENHMAADLN()) {
                hash = (53 * ((37 * hash) + 6)) + getUnk3300ANENHMAADLN().hashCode();
            }
            if (getBuffIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getBuffIdListList().hashCode();
            }
            if (hasUnk3300CDFLIONGKCH()) {
                hash = (53 * ((37 * hash) + 9)) + getUnk3300CDFLIONGKCH().hashCode();
            }
            if (getAssistInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getAssistInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static ChannelerSlabBuffInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabBuffInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabBuffInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabBuffInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabBuffInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static ChannelerSlabBuffInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static ChannelerSlabBuffInfo parseFrom(InputStream input) throws IOException {
            return (ChannelerSlabBuffInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChannelerSlabBuffInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabBuffInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChannelerSlabBuffInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (ChannelerSlabBuffInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static ChannelerSlabBuffInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabBuffInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static ChannelerSlabBuffInfo parseFrom(CodedInputStream input) throws IOException {
            return (ChannelerSlabBuffInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static ChannelerSlabBuffInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChannelerSlabBuffInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(ChannelerSlabBuffInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ChannelerSlabBuffInfoOuterClass$ChannelerSlabBuffInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ChannelerSlabBuffInfoOrBuilder {
            private int bitField0_;
            private ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo unk3300ANENHMAADLN_;
            private SingleFieldBuilderV3<ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo, ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.Builder, ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder> unk3300ANENHMAADLNBuilder_;
            private ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo unk3300CDFLIONGKCH_;
            private SingleFieldBuilderV3<ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo, ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.Builder, ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder> unk3300CDFLIONGKCHBuilder_;
            private RepeatedFieldBuilderV3<ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo, ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo.Builder, ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfoOrBuilder> assistInfoListBuilder_;
            private Internal.IntList buffIdList_ = ChannelerSlabBuffInfo.emptyIntList();
            private List<ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo> assistInfoList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ChannelerSlabBuffInfoOuterClass.internal_static_ChannelerSlabBuffInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ChannelerSlabBuffInfoOuterClass.internal_static_ChannelerSlabBuffInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(ChannelerSlabBuffInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (ChannelerSlabBuffInfo.alwaysUseFieldBuilders) {
                    getAssistInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.unk3300ANENHMAADLNBuilder_ == null) {
                    this.unk3300ANENHMAADLN_ = null;
                } else {
                    this.unk3300ANENHMAADLN_ = null;
                    this.unk3300ANENHMAADLNBuilder_ = null;
                }
                this.buffIdList_ = ChannelerSlabBuffInfo.emptyIntList();
                this.bitField0_ &= -2;
                if (this.unk3300CDFLIONGKCHBuilder_ == null) {
                    this.unk3300CDFLIONGKCH_ = null;
                } else {
                    this.unk3300CDFLIONGKCH_ = null;
                    this.unk3300CDFLIONGKCHBuilder_ = null;
                }
                if (this.assistInfoListBuilder_ == null) {
                    this.assistInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.assistInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ChannelerSlabBuffInfoOuterClass.internal_static_ChannelerSlabBuffInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public ChannelerSlabBuffInfo getDefaultInstanceForType() {
                return ChannelerSlabBuffInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChannelerSlabBuffInfo build() {
                ChannelerSlabBuffInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public ChannelerSlabBuffInfo buildPartial() {
                ChannelerSlabBuffInfo result = new ChannelerSlabBuffInfo(this);
                int i = this.bitField0_;
                if (this.unk3300ANENHMAADLNBuilder_ == null) {
                    result.unk3300ANENHMAADLN_ = this.unk3300ANENHMAADLN_;
                } else {
                    result.unk3300ANENHMAADLN_ = this.unk3300ANENHMAADLNBuilder_.build();
                }
                if ((this.bitField0_ & 1) != 0) {
                    this.buffIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.buffIdList_ = this.buffIdList_;
                if (this.unk3300CDFLIONGKCHBuilder_ == null) {
                    result.unk3300CDFLIONGKCH_ = this.unk3300CDFLIONGKCH_;
                } else {
                    result.unk3300CDFLIONGKCH_ = this.unk3300CDFLIONGKCHBuilder_.build();
                }
                if (this.assistInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.assistInfoList_ = Collections.unmodifiableList(this.assistInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.assistInfoList_ = this.assistInfoList_;
                } else {
                    result.assistInfoList_ = this.assistInfoListBuilder_.build();
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
                if (other instanceof ChannelerSlabBuffInfo) {
                    return mergeFrom((ChannelerSlabBuffInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(ChannelerSlabBuffInfo other) {
                if (other == ChannelerSlabBuffInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.hasUnk3300ANENHMAADLN()) {
                    mergeUnk3300ANENHMAADLN(other.getUnk3300ANENHMAADLN());
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
                if (other.hasUnk3300CDFLIONGKCH()) {
                    mergeUnk3300CDFLIONGKCH(other.getUnk3300CDFLIONGKCH());
                }
                if (this.assistInfoListBuilder_ == null) {
                    if (!other.assistInfoList_.isEmpty()) {
                        if (this.assistInfoList_.isEmpty()) {
                            this.assistInfoList_ = other.assistInfoList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureAssistInfoListIsMutable();
                            this.assistInfoList_.addAll(other.assistInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.assistInfoList_.isEmpty()) {
                    if (this.assistInfoListBuilder_.isEmpty()) {
                        this.assistInfoListBuilder_.dispose();
                        this.assistInfoListBuilder_ = null;
                        this.assistInfoList_ = other.assistInfoList_;
                        this.bitField0_ &= -3;
                        this.assistInfoListBuilder_ = ChannelerSlabBuffInfo.alwaysUseFieldBuilders ? getAssistInfoListFieldBuilder() : null;
                    } else {
                        this.assistInfoListBuilder_.addAllMessages(other.assistInfoList_);
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
                ChannelerSlabBuffInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = ChannelerSlabBuffInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (ChannelerSlabBuffInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
            public boolean hasUnk3300ANENHMAADLN() {
                return (this.unk3300ANENHMAADLNBuilder_ == null && this.unk3300ANENHMAADLN_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
            public ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo getUnk3300ANENHMAADLN() {
                if (this.unk3300ANENHMAADLNBuilder_ == null) {
                    return this.unk3300ANENHMAADLN_ == null ? ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.getDefaultInstance() : this.unk3300ANENHMAADLN_;
                }
                return this.unk3300ANENHMAADLNBuilder_.getMessage();
            }

            public Builder setUnk3300ANENHMAADLN(ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo value) {
                if (this.unk3300ANENHMAADLNBuilder_ != null) {
                    this.unk3300ANENHMAADLNBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.unk3300ANENHMAADLN_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setUnk3300ANENHMAADLN(ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.Builder builderForValue) {
                if (this.unk3300ANENHMAADLNBuilder_ == null) {
                    this.unk3300ANENHMAADLN_ = builderForValue.build();
                    onChanged();
                } else {
                    this.unk3300ANENHMAADLNBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeUnk3300ANENHMAADLN(ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo value) {
                if (this.unk3300ANENHMAADLNBuilder_ == null) {
                    if (this.unk3300ANENHMAADLN_ != null) {
                        this.unk3300ANENHMAADLN_ = ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.newBuilder(this.unk3300ANENHMAADLN_).mergeFrom(value).buildPartial();
                    } else {
                        this.unk3300ANENHMAADLN_ = value;
                    }
                    onChanged();
                } else {
                    this.unk3300ANENHMAADLNBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearUnk3300ANENHMAADLN() {
                if (this.unk3300ANENHMAADLNBuilder_ == null) {
                    this.unk3300ANENHMAADLN_ = null;
                    onChanged();
                } else {
                    this.unk3300ANENHMAADLN_ = null;
                    this.unk3300ANENHMAADLNBuilder_ = null;
                }
                return this;
            }

            public ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.Builder getUnk3300ANENHMAADLNBuilder() {
                onChanged();
                return getUnk3300ANENHMAADLNFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
            public ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder getUnk3300ANENHMAADLNOrBuilder() {
                if (this.unk3300ANENHMAADLNBuilder_ != null) {
                    return this.unk3300ANENHMAADLNBuilder_.getMessageOrBuilder();
                }
                return this.unk3300ANENHMAADLN_ == null ? ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.getDefaultInstance() : this.unk3300ANENHMAADLN_;
            }

            private SingleFieldBuilderV3<ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo, ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.Builder, ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder> getUnk3300ANENHMAADLNFieldBuilder() {
                if (this.unk3300ANENHMAADLNBuilder_ == null) {
                    this.unk3300ANENHMAADLNBuilder_ = new SingleFieldBuilderV3<>(getUnk3300ANENHMAADLN(), getParentForChildren(), isClean());
                    this.unk3300ANENHMAADLN_ = null;
                }
                return this.unk3300ANENHMAADLNBuilder_;
            }

            private void ensureBuffIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.buffIdList_ = ChannelerSlabBuffInfo.mutableCopy(this.buffIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
            public List<Integer> getBuffIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.buffIdList_) : this.buffIdList_;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
            public int getBuffIdListCount() {
                return this.buffIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
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
                this.buffIdList_ = ChannelerSlabBuffInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
            public boolean hasUnk3300CDFLIONGKCH() {
                return (this.unk3300CDFLIONGKCHBuilder_ == null && this.unk3300CDFLIONGKCH_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
            public ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo getUnk3300CDFLIONGKCH() {
                if (this.unk3300CDFLIONGKCHBuilder_ == null) {
                    return this.unk3300CDFLIONGKCH_ == null ? ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.getDefaultInstance() : this.unk3300CDFLIONGKCH_;
                }
                return this.unk3300CDFLIONGKCHBuilder_.getMessage();
            }

            public Builder setUnk3300CDFLIONGKCH(ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo value) {
                if (this.unk3300CDFLIONGKCHBuilder_ != null) {
                    this.unk3300CDFLIONGKCHBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.unk3300CDFLIONGKCH_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setUnk3300CDFLIONGKCH(ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.Builder builderForValue) {
                if (this.unk3300CDFLIONGKCHBuilder_ == null) {
                    this.unk3300CDFLIONGKCH_ = builderForValue.build();
                    onChanged();
                } else {
                    this.unk3300CDFLIONGKCHBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeUnk3300CDFLIONGKCH(ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo value) {
                if (this.unk3300CDFLIONGKCHBuilder_ == null) {
                    if (this.unk3300CDFLIONGKCH_ != null) {
                        this.unk3300CDFLIONGKCH_ = ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.newBuilder(this.unk3300CDFLIONGKCH_).mergeFrom(value).buildPartial();
                    } else {
                        this.unk3300CDFLIONGKCH_ = value;
                    }
                    onChanged();
                } else {
                    this.unk3300CDFLIONGKCHBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearUnk3300CDFLIONGKCH() {
                if (this.unk3300CDFLIONGKCHBuilder_ == null) {
                    this.unk3300CDFLIONGKCH_ = null;
                    onChanged();
                } else {
                    this.unk3300CDFLIONGKCH_ = null;
                    this.unk3300CDFLIONGKCHBuilder_ = null;
                }
                return this;
            }

            public ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.Builder getUnk3300CDFLIONGKCHBuilder() {
                onChanged();
                return getUnk3300CDFLIONGKCHFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
            public ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder getUnk3300CDFLIONGKCHOrBuilder() {
                if (this.unk3300CDFLIONGKCHBuilder_ != null) {
                    return this.unk3300CDFLIONGKCHBuilder_.getMessageOrBuilder();
                }
                return this.unk3300CDFLIONGKCH_ == null ? ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.getDefaultInstance() : this.unk3300CDFLIONGKCH_;
            }

            private SingleFieldBuilderV3<ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo, ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfo.Builder, ChannelerSlabBuffSchemeInfoOuterClass.ChannelerSlabBuffSchemeInfoOrBuilder> getUnk3300CDFLIONGKCHFieldBuilder() {
                if (this.unk3300CDFLIONGKCHBuilder_ == null) {
                    this.unk3300CDFLIONGKCHBuilder_ = new SingleFieldBuilderV3<>(getUnk3300CDFLIONGKCH(), getParentForChildren(), isClean());
                    this.unk3300CDFLIONGKCH_ = null;
                }
                return this.unk3300CDFLIONGKCHBuilder_;
            }

            private void ensureAssistInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.assistInfoList_ = new ArrayList(this.assistInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
            public List<ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo> getAssistInfoListList() {
                if (this.assistInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.assistInfoList_);
                }
                return this.assistInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
            public int getAssistInfoListCount() {
                if (this.assistInfoListBuilder_ == null) {
                    return this.assistInfoList_.size();
                }
                return this.assistInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
            public ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo getAssistInfoList(int index) {
                if (this.assistInfoListBuilder_ == null) {
                    return this.assistInfoList_.get(index);
                }
                return this.assistInfoListBuilder_.getMessage(index);
            }

            public Builder setAssistInfoList(int index, ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo value) {
                if (this.assistInfoListBuilder_ != null) {
                    this.assistInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAssistInfoListIsMutable();
                    this.assistInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAssistInfoList(int index, ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo.Builder builderForValue) {
                if (this.assistInfoListBuilder_ == null) {
                    ensureAssistInfoListIsMutable();
                    this.assistInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.assistInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAssistInfoList(ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo value) {
                if (this.assistInfoListBuilder_ != null) {
                    this.assistInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAssistInfoListIsMutable();
                    this.assistInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAssistInfoList(int index, ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo value) {
                if (this.assistInfoListBuilder_ != null) {
                    this.assistInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAssistInfoListIsMutable();
                    this.assistInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAssistInfoList(ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo.Builder builderForValue) {
                if (this.assistInfoListBuilder_ == null) {
                    ensureAssistInfoListIsMutable();
                    this.assistInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.assistInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAssistInfoList(int index, ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo.Builder builderForValue) {
                if (this.assistInfoListBuilder_ == null) {
                    ensureAssistInfoListIsMutable();
                    this.assistInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.assistInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAssistInfoList(Iterable<? extends ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo> values) {
                if (this.assistInfoListBuilder_ == null) {
                    ensureAssistInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.assistInfoList_);
                    onChanged();
                } else {
                    this.assistInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAssistInfoList() {
                if (this.assistInfoListBuilder_ == null) {
                    this.assistInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.assistInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeAssistInfoList(int index) {
                if (this.assistInfoListBuilder_ == null) {
                    ensureAssistInfoListIsMutable();
                    this.assistInfoList_.remove(index);
                    onChanged();
                } else {
                    this.assistInfoListBuilder_.remove(index);
                }
                return this;
            }

            public ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo.Builder getAssistInfoListBuilder(int index) {
                return getAssistInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
            public ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfoOrBuilder getAssistInfoListOrBuilder(int index) {
                if (this.assistInfoListBuilder_ == null) {
                    return this.assistInfoList_.get(index);
                }
                return this.assistInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.ChannelerSlabBuffInfoOuterClass.ChannelerSlabBuffInfoOrBuilder
            public List<? extends ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfoOrBuilder> getAssistInfoListOrBuilderList() {
                if (this.assistInfoListBuilder_ != null) {
                    return this.assistInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.assistInfoList_);
            }

            public ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo.Builder addAssistInfoListBuilder() {
                return getAssistInfoListFieldBuilder().addBuilder(ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo.getDefaultInstance());
            }

            public ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo.Builder addAssistInfoListBuilder(int index) {
                return getAssistInfoListFieldBuilder().addBuilder(index, ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo.getDefaultInstance());
            }

            public List<ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo.Builder> getAssistInfoListBuilderList() {
                return getAssistInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo, ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfo.Builder, ChannelerSlabAssistInfoOuterClass.ChannelerSlabAssistInfoOrBuilder> getAssistInfoListFieldBuilder() {
                if (this.assistInfoListBuilder_ == null) {
                    this.assistInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.assistInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.assistInfoList_ = null;
                }
                return this.assistInfoListBuilder_;
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

        public static ChannelerSlabBuffInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChannelerSlabBuffInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<ChannelerSlabBuffInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public ChannelerSlabBuffInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ChannelerSlabBuffSchemeInfoOuterClass.getDescriptor();
        ChannelerSlabAssistInfoOuterClass.getDescriptor();
    }
}
