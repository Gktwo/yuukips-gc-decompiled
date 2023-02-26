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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessMonsterInfoOuterClass.class */
public final class IrodoriChessMonsterInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dIrodoriChessMonsterInfo.proto\"c\n\u0017IrodoriChessMonsterInfo\u0012\u0011\n\tmonsterId\u0018\f \u0001(\r\u0012\r\n\u0005level\u0018\r \u0001(\r\u0012\u0013\n\u000bhhmklcpngkl\u0018\u000e \u0001(\r\u0012\u0011\n\taffixList\u0018\u0001 \u0003(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_IrodoriChessMonsterInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_IrodoriChessMonsterInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_IrodoriChessMonsterInfo_descriptor, new String[]{"MonsterId", "Level", "Hhmklcpngkl", "AffixList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessMonsterInfoOuterClass$IrodoriChessMonsterInfoOrBuilder.class */
    public interface IrodoriChessMonsterInfoOrBuilder extends MessageOrBuilder {
        int getMonsterId();

        int getLevel();

        int getHhmklcpngkl();

        List<Integer> getAffixListList();

        int getAffixListCount();

        int getAffixList(int i);
    }

    private IrodoriChessMonsterInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessMonsterInfoOuterClass$IrodoriChessMonsterInfo.class */
    public static final class IrodoriChessMonsterInfo extends GeneratedMessageV3 implements IrodoriChessMonsterInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MONSTERID_FIELD_NUMBER = 12;
        private int monsterId_;
        public static final int LEVEL_FIELD_NUMBER = 13;
        private int level_;
        public static final int HHMKLCPNGKL_FIELD_NUMBER = 14;
        private int hhmklcpngkl_;
        public static final int AFFIXLIST_FIELD_NUMBER = 1;
        private Internal.IntList affixList_;
        private int affixListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final IrodoriChessMonsterInfo DEFAULT_INSTANCE = new IrodoriChessMonsterInfo();
        private static final Parser<IrodoriChessMonsterInfo> PARSER = new AbstractParser<IrodoriChessMonsterInfo>() { // from class: emu.grasscutter.net.proto.IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfo.1
            @Override // com.google.protobuf.Parser
            public IrodoriChessMonsterInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IrodoriChessMonsterInfo(input, extensionRegistry);
            }
        };

        private IrodoriChessMonsterInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.affixListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private IrodoriChessMonsterInfo() {
            this.affixListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.affixList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new IrodoriChessMonsterInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private IrodoriChessMonsterInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.affixList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.affixList_.addInt(input.readUInt32());
                                break;
                            case 10:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.affixList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.affixList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 96:
                                this.monsterId_ = input.readUInt32();
                                break;
                            case 104:
                                this.level_ = input.readUInt32();
                                break;
                            case 112:
                                this.hhmklcpngkl_ = input.readUInt32();
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
                    this.affixList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return IrodoriChessMonsterInfoOuterClass.internal_static_IrodoriChessMonsterInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return IrodoriChessMonsterInfoOuterClass.internal_static_IrodoriChessMonsterInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriChessMonsterInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder
        public int getMonsterId() {
            return this.monsterId_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder
        public int getHhmklcpngkl() {
            return this.hhmklcpngkl_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder
        public List<Integer> getAffixListList() {
            return this.affixList_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder
        public int getAffixListCount() {
            return this.affixList_.size();
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder
        public int getAffixList(int index) {
            return this.affixList_.getInt(index);
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
            if (getAffixListList().size() > 0) {
                output.writeUInt32NoTag(10);
                output.writeUInt32NoTag(this.affixListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.affixList_.size(); i++) {
                output.writeUInt32NoTag(this.affixList_.getInt(i));
            }
            if (this.monsterId_ != 0) {
                output.writeUInt32(12, this.monsterId_);
            }
            if (this.level_ != 0) {
                output.writeUInt32(13, this.level_);
            }
            if (this.hhmklcpngkl_ != 0) {
                output.writeUInt32(14, this.hhmklcpngkl_);
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
            for (int i = 0; i < this.affixList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.affixList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getAffixListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.affixListMemoizedSerializedSize = dataSize;
            if (this.monsterId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.monsterId_);
            }
            if (this.level_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.level_);
            }
            if (this.hhmklcpngkl_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.hhmklcpngkl_);
            }
            int size3 = size2 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size3;
            return size3;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof IrodoriChessMonsterInfo)) {
                return equals(obj);
            }
            IrodoriChessMonsterInfo other = (IrodoriChessMonsterInfo) obj;
            return getMonsterId() == other.getMonsterId() && getLevel() == other.getLevel() && getHhmklcpngkl() == other.getHhmklcpngkl() && getAffixListList().equals(other.getAffixListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 12)) + getMonsterId())) + 13)) + getLevel())) + 14)) + getHhmklcpngkl();
            if (getAffixListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getAffixListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static IrodoriChessMonsterInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessMonsterInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessMonsterInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessMonsterInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessMonsterInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessMonsterInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessMonsterInfo parseFrom(InputStream input) throws IOException {
            return (IrodoriChessMonsterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriChessMonsterInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessMonsterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriChessMonsterInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (IrodoriChessMonsterInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static IrodoriChessMonsterInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessMonsterInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriChessMonsterInfo parseFrom(CodedInputStream input) throws IOException {
            return (IrodoriChessMonsterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriChessMonsterInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessMonsterInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(IrodoriChessMonsterInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessMonsterInfoOuterClass$IrodoriChessMonsterInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IrodoriChessMonsterInfoOrBuilder {
            private int bitField0_;
            private int monsterId_;
            private int level_;
            private int hhmklcpngkl_;
            private Internal.IntList affixList_ = IrodoriChessMonsterInfo.emptyIntList();

            public static final Descriptors.Descriptor getDescriptor() {
                return IrodoriChessMonsterInfoOuterClass.internal_static_IrodoriChessMonsterInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return IrodoriChessMonsterInfoOuterClass.internal_static_IrodoriChessMonsterInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriChessMonsterInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (IrodoriChessMonsterInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.monsterId_ = 0;
                this.level_ = 0;
                this.hhmklcpngkl_ = 0;
                this.affixList_ = IrodoriChessMonsterInfo.emptyIntList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return IrodoriChessMonsterInfoOuterClass.internal_static_IrodoriChessMonsterInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public IrodoriChessMonsterInfo getDefaultInstanceForType() {
                return IrodoriChessMonsterInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriChessMonsterInfo build() {
                IrodoriChessMonsterInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriChessMonsterInfo buildPartial() {
                IrodoriChessMonsterInfo result = new IrodoriChessMonsterInfo(this);
                int i = this.bitField0_;
                result.monsterId_ = this.monsterId_;
                result.level_ = this.level_;
                result.hhmklcpngkl_ = this.hhmklcpngkl_;
                if ((this.bitField0_ & 1) != 0) {
                    this.affixList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.affixList_ = this.affixList_;
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
                if (other instanceof IrodoriChessMonsterInfo) {
                    return mergeFrom((IrodoriChessMonsterInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IrodoriChessMonsterInfo other) {
                if (other == IrodoriChessMonsterInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getMonsterId() != 0) {
                    setMonsterId(other.getMonsterId());
                }
                if (other.getLevel() != 0) {
                    setLevel(other.getLevel());
                }
                if (other.getHhmklcpngkl() != 0) {
                    setHhmklcpngkl(other.getHhmklcpngkl());
                }
                if (!other.affixList_.isEmpty()) {
                    if (this.affixList_.isEmpty()) {
                        this.affixList_ = other.affixList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAffixListIsMutable();
                        this.affixList_.addAll(other.affixList_);
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
                IrodoriChessMonsterInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = IrodoriChessMonsterInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (IrodoriChessMonsterInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder
            public int getMonsterId() {
                return this.monsterId_;
            }

            public Builder setMonsterId(int value) {
                this.monsterId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMonsterId() {
                this.monsterId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder
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

            @Override // emu.grasscutter.net.proto.IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder
            public int getHhmklcpngkl() {
                return this.hhmklcpngkl_;
            }

            public Builder setHhmklcpngkl(int value) {
                this.hhmklcpngkl_ = value;
                onChanged();
                return this;
            }

            public Builder clearHhmklcpngkl() {
                this.hhmklcpngkl_ = 0;
                onChanged();
                return this;
            }

            private void ensureAffixListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.affixList_ = IrodoriChessMonsterInfo.mutableCopy(this.affixList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder
            public List<Integer> getAffixListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.affixList_) : this.affixList_;
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder
            public int getAffixListCount() {
                return this.affixList_.size();
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessMonsterInfoOuterClass.IrodoriChessMonsterInfoOrBuilder
            public int getAffixList(int index) {
                return this.affixList_.getInt(index);
            }

            public Builder setAffixList(int index, int value) {
                ensureAffixListIsMutable();
                this.affixList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addAffixList(int value) {
                ensureAffixListIsMutable();
                this.affixList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllAffixList(Iterable<? extends Integer> values) {
                ensureAffixListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.affixList_);
                onChanged();
                return this;
            }

            public Builder clearAffixList() {
                this.affixList_ = IrodoriChessMonsterInfo.emptyIntList();
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

        public static IrodoriChessMonsterInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<IrodoriChessMonsterInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<IrodoriChessMonsterInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public IrodoriChessMonsterInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
