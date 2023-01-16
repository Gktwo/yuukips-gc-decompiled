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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryOuterClass.class */
public final class ReliquaryOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u000fReliquary.proto\"q\n\tReliquary\u0012\r\n\u0005level\u0018\u0001 \u0001(\r\u0012\u000b\n\u0003exp\u0018\u0002 \u0001(\r\u0012\u0015\n\rpromote_level\u0018\u0003 \u0001(\r\u0012\u0014\n\fmain_prop_id\u0018\u0004 \u0001(\r\u0012\u001b\n\u0013append_prop_id_list\u0018\u0005 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_Reliquary_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_Reliquary_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_Reliquary_descriptor, new String[]{"Level", "Exp", "PromoteLevel", "MainPropId", "AppendPropIdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryOuterClass$ReliquaryOrBuilder.class */
    public interface ReliquaryOrBuilder extends MessageOrBuilder {
        int getLevel();

        int getExp();

        int getPromoteLevel();

        int getMainPropId();

        List<Integer> getAppendPropIdListList();

        int getAppendPropIdListCount();

        int getAppendPropIdList(int i);
    }

    private ReliquaryOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryOuterClass$Reliquary.class */
    public static final class Reliquary extends GeneratedMessageV3 implements ReliquaryOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEVEL_FIELD_NUMBER = 1;
        private int level_;
        public static final int EXP_FIELD_NUMBER = 2;
        private int exp_;
        public static final int PROMOTE_LEVEL_FIELD_NUMBER = 3;
        private int promoteLevel_;
        public static final int MAIN_PROP_ID_FIELD_NUMBER = 4;
        private int mainPropId_;
        public static final int APPEND_PROP_ID_LIST_FIELD_NUMBER = 5;
        private Internal.IntList appendPropIdList_;
        private int appendPropIdListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final Reliquary DEFAULT_INSTANCE = new Reliquary();
        private static final Parser<Reliquary> PARSER = new AbstractParser<Reliquary>() { // from class: emu.grasscutter.net.proto.ReliquaryOuterClass.Reliquary.1
            @Override // com.google.protobuf.Parser
            public Reliquary parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new Reliquary(input, extensionRegistry);
            }
        };

        private Reliquary(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.appendPropIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private Reliquary() {
            this.appendPropIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.appendPropIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new Reliquary();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private Reliquary(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.level_ = input.readUInt32();
                                break;
                            case 16:
                                this.exp_ = input.readUInt32();
                                break;
                            case 24:
                                this.promoteLevel_ = input.readUInt32();
                                break;
                            case 32:
                                this.mainPropId_ = input.readUInt32();
                                break;
                            case 40:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.appendPropIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.appendPropIdList_.addInt(input.readUInt32());
                                break;
                            case 42:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.appendPropIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.appendPropIdList_.addInt(input.readUInt32());
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.appendPropIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return ReliquaryOuterClass.internal_static_Reliquary_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return ReliquaryOuterClass.internal_static_Reliquary_fieldAccessorTable.ensureFieldAccessorsInitialized(Reliquary.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.ReliquaryOuterClass.ReliquaryOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryOuterClass.ReliquaryOrBuilder
        public int getExp() {
            return this.exp_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryOuterClass.ReliquaryOrBuilder
        public int getPromoteLevel() {
            return this.promoteLevel_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryOuterClass.ReliquaryOrBuilder
        public int getMainPropId() {
            return this.mainPropId_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryOuterClass.ReliquaryOrBuilder
        public List<Integer> getAppendPropIdListList() {
            return this.appendPropIdList_;
        }

        @Override // emu.grasscutter.net.proto.ReliquaryOuterClass.ReliquaryOrBuilder
        public int getAppendPropIdListCount() {
            return this.appendPropIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.ReliquaryOuterClass.ReliquaryOrBuilder
        public int getAppendPropIdList(int index) {
            return this.appendPropIdList_.getInt(index);
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
            if (this.level_ != 0) {
                output.writeUInt32(1, this.level_);
            }
            if (this.exp_ != 0) {
                output.writeUInt32(2, this.exp_);
            }
            if (this.promoteLevel_ != 0) {
                output.writeUInt32(3, this.promoteLevel_);
            }
            if (this.mainPropId_ != 0) {
                output.writeUInt32(4, this.mainPropId_);
            }
            if (getAppendPropIdListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.appendPropIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.appendPropIdList_.size(); i++) {
                output.writeUInt32NoTag(this.appendPropIdList_.getInt(i));
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
            if (this.level_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.level_);
            }
            if (this.exp_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.exp_);
            }
            if (this.promoteLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.promoteLevel_);
            }
            if (this.mainPropId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(4, this.mainPropId_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.appendPropIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.appendPropIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getAppendPropIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.appendPropIdListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Reliquary)) {
                return equals(obj);
            }
            Reliquary other = (Reliquary) obj;
            return getLevel() == other.getLevel() && getExp() == other.getExp() && getPromoteLevel() == other.getPromoteLevel() && getMainPropId() == other.getMainPropId() && getAppendPropIdListList().equals(other.getAppendPropIdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getLevel())) + 2)) + getExp())) + 3)) + getPromoteLevel())) + 4)) + getMainPropId();
            if (getAppendPropIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getAppendPropIdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static Reliquary parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Reliquary parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Reliquary parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Reliquary parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Reliquary parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static Reliquary parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static Reliquary parseFrom(InputStream input) throws IOException {
            return (Reliquary) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Reliquary parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Reliquary) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static Reliquary parseDelimitedFrom(InputStream input) throws IOException {
            return (Reliquary) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static Reliquary parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Reliquary) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static Reliquary parseFrom(CodedInputStream input) throws IOException {
            return (Reliquary) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static Reliquary parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Reliquary) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(Reliquary prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/ReliquaryOuterClass$Reliquary$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements ReliquaryOrBuilder {
            private int bitField0_;
            private int level_;
            private int exp_;
            private int promoteLevel_;
            private int mainPropId_;
            private Internal.IntList appendPropIdList_ = Reliquary.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return ReliquaryOuterClass.internal_static_Reliquary_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return ReliquaryOuterClass.internal_static_Reliquary_fieldAccessorTable.ensureFieldAccessorsInitialized(Reliquary.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (Reliquary.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.level_ = 0;
                this.exp_ = 0;
                this.promoteLevel_ = 0;
                this.mainPropId_ = 0;
                this.appendPropIdList_ = Reliquary.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return ReliquaryOuterClass.internal_static_Reliquary_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public Reliquary getDefaultInstanceForType() {
                return Reliquary.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Reliquary build() {
                Reliquary result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Reliquary buildPartial() {
                Reliquary result = new Reliquary(this);
                int i = this.bitField0_;
                result.level_ = this.level_;
                result.exp_ = this.exp_;
                result.promoteLevel_ = this.promoteLevel_;
                result.mainPropId_ = this.mainPropId_;
                if ((this.bitField0_ & 1) != 0) {
                    this.appendPropIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.appendPropIdList_ = this.appendPropIdList_;
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
                if (other instanceof Reliquary) {
                    return mergeFrom((Reliquary) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(Reliquary other) {
                if (other == Reliquary.getDefaultInstance()) {
                    return this;
                }
                if (other.getLevel() != 0) {
                    setLevel(other.getLevel());
                }
                if (other.getExp() != 0) {
                    setExp(other.getExp());
                }
                if (other.getPromoteLevel() != 0) {
                    setPromoteLevel(other.getPromoteLevel());
                }
                if (other.getMainPropId() != 0) {
                    setMainPropId(other.getMainPropId());
                }
                if (!other.appendPropIdList_.isEmpty()) {
                    if (this.appendPropIdList_.isEmpty()) {
                        this.appendPropIdList_ = other.appendPropIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAppendPropIdListIsMutable();
                        this.appendPropIdList_.addAll(other.appendPropIdList_);
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
                Reliquary parsedMessage = null;
                try {
                    try {
                        parsedMessage = Reliquary.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (Reliquary) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.ReliquaryOuterClass.ReliquaryOrBuilder
            public int getLevel() {
                return this.level_;
            }

            public Builder setLevel(int value) {
                this.level_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.level_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryOuterClass.ReliquaryOrBuilder
            public int getExp() {
                return this.exp_;
            }

            public Builder setExp(int value) {
                this.exp_ = value;
                onChanged();
                return this;
            }

            public Builder clearExp() {
                this.exp_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryOuterClass.ReliquaryOrBuilder
            public int getPromoteLevel() {
                return this.promoteLevel_;
            }

            public Builder setPromoteLevel(int value) {
                this.promoteLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearPromoteLevel() {
                this.promoteLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryOuterClass.ReliquaryOrBuilder
            public int getMainPropId() {
                return this.mainPropId_;
            }

            public Builder setMainPropId(int value) {
                this.mainPropId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMainPropId() {
                this.mainPropId_ = 0;
                onChanged();
                return this;
            }

            private void ensureAppendPropIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.appendPropIdList_ = Reliquary.mutableCopy(this.appendPropIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.ReliquaryOuterClass.ReliquaryOrBuilder
            public List<Integer> getAppendPropIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.appendPropIdList_) : this.appendPropIdList_;
            }

            @Override // emu.grasscutter.net.proto.ReliquaryOuterClass.ReliquaryOrBuilder
            public int getAppendPropIdListCount() {
                return this.appendPropIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.ReliquaryOuterClass.ReliquaryOrBuilder
            public int getAppendPropIdList(int index) {
                return this.appendPropIdList_.getInt(index);
            }

            public Builder setAppendPropIdList(int index, int value) {
                ensureAppendPropIdListIsMutable();
                this.appendPropIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addAppendPropIdList(int value) {
                ensureAppendPropIdListIsMutable();
                this.appendPropIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllAppendPropIdList(Iterable<? extends Integer> values) {
                ensureAppendPropIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.appendPropIdList_);
                onChanged();
                return this;
            }

            public Builder clearAppendPropIdList() {
                this.appendPropIdList_ = Reliquary.emptyIntList();
                this.bitField0_ &= -2;
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

        public static Reliquary getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Reliquary> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<Reliquary> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Reliquary getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
