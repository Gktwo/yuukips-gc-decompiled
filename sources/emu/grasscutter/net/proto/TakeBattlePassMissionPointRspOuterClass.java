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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBattlePassMissionPointRspOuterClass.class */
public final class TakeBattlePassMissionPointRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n#TakeBattlePassMissionPointRsp.proto\"G\n\u001dTakeBattlePassMissionPointRsp\u0012\u0015\n\rmissionIdList\u0018\n \u0003(\r\u0012\u000f\n\u0007retcode\u0018\u0004 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_TakeBattlePassMissionPointRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_TakeBattlePassMissionPointRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_TakeBattlePassMissionPointRsp_descriptor, new String[]{"MissionIdList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBattlePassMissionPointRspOuterClass$TakeBattlePassMissionPointRspOrBuilder.class */
    public interface TakeBattlePassMissionPointRspOrBuilder extends MessageOrBuilder {
        List<Integer> getMissionIdListList();

        int getMissionIdListCount();

        int getMissionIdList(int i);

        int getRetcode();
    }

    private TakeBattlePassMissionPointRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBattlePassMissionPointRspOuterClass$TakeBattlePassMissionPointRsp.class */
    public static final class TakeBattlePassMissionPointRsp extends GeneratedMessageV3 implements TakeBattlePassMissionPointRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MISSIONIDLIST_FIELD_NUMBER = 10;
        private Internal.IntList missionIdList_;
        private int missionIdListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 4;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final TakeBattlePassMissionPointRsp DEFAULT_INSTANCE = new TakeBattlePassMissionPointRsp();
        private static final Parser<TakeBattlePassMissionPointRsp> PARSER = new AbstractParser<TakeBattlePassMissionPointRsp>() { // from class: emu.grasscutter.net.proto.TakeBattlePassMissionPointRspOuterClass.TakeBattlePassMissionPointRsp.1
            @Override // com.google.protobuf.Parser
            public TakeBattlePassMissionPointRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new TakeBattlePassMissionPointRsp(input, extensionRegistry);
            }
        };

        private TakeBattlePassMissionPointRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.missionIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private TakeBattlePassMissionPointRsp() {
            this.missionIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.missionIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new TakeBattlePassMissionPointRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private TakeBattlePassMissionPointRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 32:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 80:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.missionIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.missionIdList_.addInt(input.readUInt32());
                                    break;
                                case 82:
                                    int limit = input.pushLimit(input.readRawVarint32());
                                    if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                        this.missionIdList_ = newIntList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    while (input.getBytesUntilLimit() > 0) {
                                        this.missionIdList_.addInt(input.readUInt32());
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
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.missionIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return TakeBattlePassMissionPointRspOuterClass.internal_static_TakeBattlePassMissionPointRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return TakeBattlePassMissionPointRspOuterClass.internal_static_TakeBattlePassMissionPointRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeBattlePassMissionPointRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassMissionPointRspOuterClass.TakeBattlePassMissionPointRspOrBuilder
        public List<Integer> getMissionIdListList() {
            return this.missionIdList_;
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassMissionPointRspOuterClass.TakeBattlePassMissionPointRspOrBuilder
        public int getMissionIdListCount() {
            return this.missionIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassMissionPointRspOuterClass.TakeBattlePassMissionPointRspOrBuilder
        public int getMissionIdList(int index) {
            return this.missionIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.TakeBattlePassMissionPointRspOuterClass.TakeBattlePassMissionPointRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
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
            if (this.retcode_ != 0) {
                output.writeInt32(4, this.retcode_);
            }
            if (getMissionIdListList().size() > 0) {
                output.writeUInt32NoTag(82);
                output.writeUInt32NoTag(this.missionIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.missionIdList_.size(); i++) {
                output.writeUInt32NoTag(this.missionIdList_.getInt(i));
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
            if (this.retcode_ != 0) {
                size2 = 0 + CodedOutputStream.computeInt32Size(4, this.retcode_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.missionIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.missionIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getMissionIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.missionIdListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TakeBattlePassMissionPointRsp)) {
                return equals(obj);
            }
            TakeBattlePassMissionPointRsp other = (TakeBattlePassMissionPointRsp) obj;
            return getMissionIdListList().equals(other.getMissionIdListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getMissionIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getMissionIdListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 4)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static TakeBattlePassMissionPointRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeBattlePassMissionPointRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeBattlePassMissionPointRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeBattlePassMissionPointRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeBattlePassMissionPointRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static TakeBattlePassMissionPointRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static TakeBattlePassMissionPointRsp parseFrom(InputStream input) throws IOException {
            return (TakeBattlePassMissionPointRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeBattlePassMissionPointRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeBattlePassMissionPointRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeBattlePassMissionPointRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (TakeBattlePassMissionPointRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static TakeBattlePassMissionPointRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeBattlePassMissionPointRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static TakeBattlePassMissionPointRsp parseFrom(CodedInputStream input) throws IOException {
            return (TakeBattlePassMissionPointRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static TakeBattlePassMissionPointRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TakeBattlePassMissionPointRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(TakeBattlePassMissionPointRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/TakeBattlePassMissionPointRspOuterClass$TakeBattlePassMissionPointRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements TakeBattlePassMissionPointRspOrBuilder {
            private int bitField0_;
            private Internal.IntList missionIdList_ = TakeBattlePassMissionPointRsp.emptyIntList();
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return TakeBattlePassMissionPointRspOuterClass.internal_static_TakeBattlePassMissionPointRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return TakeBattlePassMissionPointRspOuterClass.internal_static_TakeBattlePassMissionPointRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(TakeBattlePassMissionPointRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (TakeBattlePassMissionPointRsp.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.missionIdList_ = TakeBattlePassMissionPointRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return TakeBattlePassMissionPointRspOuterClass.internal_static_TakeBattlePassMissionPointRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public TakeBattlePassMissionPointRsp getDefaultInstanceForType() {
                return TakeBattlePassMissionPointRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeBattlePassMissionPointRsp build() {
                TakeBattlePassMissionPointRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public TakeBattlePassMissionPointRsp buildPartial() {
                TakeBattlePassMissionPointRsp result = new TakeBattlePassMissionPointRsp(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.missionIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.missionIdList_ = this.missionIdList_;
                result.retcode_ = this.retcode_;
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
                if (other instanceof TakeBattlePassMissionPointRsp) {
                    return mergeFrom((TakeBattlePassMissionPointRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(TakeBattlePassMissionPointRsp other) {
                if (other == TakeBattlePassMissionPointRsp.getDefaultInstance()) {
                    return this;
                }
                if (!other.missionIdList_.isEmpty()) {
                    if (this.missionIdList_.isEmpty()) {
                        this.missionIdList_ = other.missionIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureMissionIdListIsMutable();
                        this.missionIdList_.addAll(other.missionIdList_);
                    }
                    onChanged();
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
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
                TakeBattlePassMissionPointRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = TakeBattlePassMissionPointRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (TakeBattlePassMissionPointRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureMissionIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.missionIdList_ = TakeBattlePassMissionPointRsp.mutableCopy(this.missionIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassMissionPointRspOuterClass.TakeBattlePassMissionPointRspOrBuilder
            public List<Integer> getMissionIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.missionIdList_) : this.missionIdList_;
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassMissionPointRspOuterClass.TakeBattlePassMissionPointRspOrBuilder
            public int getMissionIdListCount() {
                return this.missionIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassMissionPointRspOuterClass.TakeBattlePassMissionPointRspOrBuilder
            public int getMissionIdList(int index) {
                return this.missionIdList_.getInt(index);
            }

            public Builder setMissionIdList(int index, int value) {
                ensureMissionIdListIsMutable();
                this.missionIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addMissionIdList(int value) {
                ensureMissionIdListIsMutable();
                this.missionIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllMissionIdList(Iterable<? extends Integer> values) {
                ensureMissionIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.missionIdList_);
                onChanged();
                return this;
            }

            public Builder clearMissionIdList() {
                this.missionIdList_ = TakeBattlePassMissionPointRsp.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.TakeBattlePassMissionPointRspOuterClass.TakeBattlePassMissionPointRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static TakeBattlePassMissionPointRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TakeBattlePassMissionPointRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<TakeBattlePassMissionPointRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public TakeBattlePassMissionPointRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
