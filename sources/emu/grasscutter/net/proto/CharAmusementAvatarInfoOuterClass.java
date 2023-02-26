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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CharAmusementAvatarInfoOuterClass.class */
public final class CharAmusementAvatarInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dCharAmusementAvatarInfo.proto\"Q\n\u0017CharAmusementAvatarInfo\u0012\u000b\n\u0003uid\u0018\u0003 \u0001(\r\u0012\u0014\n\favatarIdList\u0018\u000b \u0003(\r\u0012\u0013\n\u000bpmahgkplcgi\u0018\u0001 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_CharAmusementAvatarInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CharAmusementAvatarInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CharAmusementAvatarInfo_descriptor, new String[]{"Uid", "AvatarIdList", "Pmahgkplcgi"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CharAmusementAvatarInfoOuterClass$CharAmusementAvatarInfoOrBuilder.class */
    public interface CharAmusementAvatarInfoOrBuilder extends MessageOrBuilder {
        int getUid();

        List<Integer> getAvatarIdListList();

        int getAvatarIdListCount();

        int getAvatarIdList(int i);

        int getPmahgkplcgi();
    }

    private CharAmusementAvatarInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CharAmusementAvatarInfoOuterClass$CharAmusementAvatarInfo.class */
    public static final class CharAmusementAvatarInfo extends GeneratedMessageV3 implements CharAmusementAvatarInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int UID_FIELD_NUMBER = 3;
        private int uid_;
        public static final int AVATARIDLIST_FIELD_NUMBER = 11;
        private Internal.IntList avatarIdList_;
        private int avatarIdListMemoizedSerializedSize;
        public static final int PMAHGKPLCGI_FIELD_NUMBER = 1;
        private int pmahgkplcgi_;
        private byte memoizedIsInitialized;
        private static final CharAmusementAvatarInfo DEFAULT_INSTANCE = new CharAmusementAvatarInfo();
        private static final Parser<CharAmusementAvatarInfo> PARSER = new AbstractParser<CharAmusementAvatarInfo>() { // from class: emu.grasscutter.net.proto.CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfo.1
            @Override // com.google.protobuf.Parser
            public CharAmusementAvatarInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CharAmusementAvatarInfo(input, extensionRegistry);
            }
        };

        private CharAmusementAvatarInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.avatarIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private CharAmusementAvatarInfo() {
            this.avatarIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.avatarIdList_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CharAmusementAvatarInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CharAmusementAvatarInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.pmahgkplcgi_ = input.readUInt32();
                                break;
                            case 24:
                                this.uid_ = input.readUInt32();
                                break;
                            case 88:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.avatarIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.avatarIdList_.addInt(input.readUInt32());
                                break;
                            case 90:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.avatarIdList_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.avatarIdList_.addInt(input.readUInt32());
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
                    this.avatarIdList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CharAmusementAvatarInfoOuterClass.internal_static_CharAmusementAvatarInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CharAmusementAvatarInfoOuterClass.internal_static_CharAmusementAvatarInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CharAmusementAvatarInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfoOrBuilder
        public int getUid() {
            return this.uid_;
        }

        @Override // emu.grasscutter.net.proto.CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfoOrBuilder
        public List<Integer> getAvatarIdListList() {
            return this.avatarIdList_;
        }

        @Override // emu.grasscutter.net.proto.CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfoOrBuilder
        public int getAvatarIdListCount() {
            return this.avatarIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfoOrBuilder
        public int getAvatarIdList(int index) {
            return this.avatarIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfoOrBuilder
        public int getPmahgkplcgi() {
            return this.pmahgkplcgi_;
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
            if (this.pmahgkplcgi_ != 0) {
                output.writeUInt32(1, this.pmahgkplcgi_);
            }
            if (this.uid_ != 0) {
                output.writeUInt32(3, this.uid_);
            }
            if (getAvatarIdListList().size() > 0) {
                output.writeUInt32NoTag(90);
                output.writeUInt32NoTag(this.avatarIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.avatarIdList_.size(); i++) {
                output.writeUInt32NoTag(this.avatarIdList_.getInt(i));
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
            if (this.pmahgkplcgi_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.pmahgkplcgi_);
            }
            if (this.uid_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(3, this.uid_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.avatarIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.avatarIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getAvatarIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.avatarIdListMemoizedSerializedSize = dataSize;
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof CharAmusementAvatarInfo)) {
                return equals(obj);
            }
            CharAmusementAvatarInfo other = (CharAmusementAvatarInfo) obj;
            return getUid() == other.getUid() && getAvatarIdListList().equals(other.getAvatarIdListList()) && getPmahgkplcgi() == other.getPmahgkplcgi() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 3)) + getUid();
            if (getAvatarIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getAvatarIdListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 1)) + getPmahgkplcgi())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CharAmusementAvatarInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CharAmusementAvatarInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CharAmusementAvatarInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CharAmusementAvatarInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CharAmusementAvatarInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CharAmusementAvatarInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CharAmusementAvatarInfo parseFrom(InputStream input) throws IOException {
            return (CharAmusementAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CharAmusementAvatarInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CharAmusementAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CharAmusementAvatarInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (CharAmusementAvatarInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CharAmusementAvatarInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CharAmusementAvatarInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CharAmusementAvatarInfo parseFrom(CodedInputStream input) throws IOException {
            return (CharAmusementAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CharAmusementAvatarInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CharAmusementAvatarInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CharAmusementAvatarInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CharAmusementAvatarInfoOuterClass$CharAmusementAvatarInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CharAmusementAvatarInfoOrBuilder {
            private int bitField0_;
            private int uid_;
            private Internal.IntList avatarIdList_ = CharAmusementAvatarInfo.emptyIntList();
            private int pmahgkplcgi_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CharAmusementAvatarInfoOuterClass.internal_static_CharAmusementAvatarInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CharAmusementAvatarInfoOuterClass.internal_static_CharAmusementAvatarInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(CharAmusementAvatarInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CharAmusementAvatarInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.uid_ = 0;
                this.avatarIdList_ = CharAmusementAvatarInfo.emptyIntList();
                this.bitField0_ &= -2;
                this.pmahgkplcgi_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CharAmusementAvatarInfoOuterClass.internal_static_CharAmusementAvatarInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CharAmusementAvatarInfo getDefaultInstanceForType() {
                return CharAmusementAvatarInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CharAmusementAvatarInfo build() {
                CharAmusementAvatarInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CharAmusementAvatarInfo buildPartial() {
                CharAmusementAvatarInfo result = new CharAmusementAvatarInfo(this);
                int i = this.bitField0_;
                result.uid_ = this.uid_;
                if ((this.bitField0_ & 1) != 0) {
                    this.avatarIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.avatarIdList_ = this.avatarIdList_;
                result.pmahgkplcgi_ = this.pmahgkplcgi_;
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
                if (other instanceof CharAmusementAvatarInfo) {
                    return mergeFrom((CharAmusementAvatarInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CharAmusementAvatarInfo other) {
                if (other == CharAmusementAvatarInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getUid() != 0) {
                    setUid(other.getUid());
                }
                if (!other.avatarIdList_.isEmpty()) {
                    if (this.avatarIdList_.isEmpty()) {
                        this.avatarIdList_ = other.avatarIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAvatarIdListIsMutable();
                        this.avatarIdList_.addAll(other.avatarIdList_);
                    }
                    onChanged();
                }
                if (other.getPmahgkplcgi() != 0) {
                    setPmahgkplcgi(other.getPmahgkplcgi());
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
                CharAmusementAvatarInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = CharAmusementAvatarInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CharAmusementAvatarInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfoOrBuilder
            public int getUid() {
                return this.uid_;
            }

            public Builder setUid(int value) {
                this.uid_ = value;
                onChanged();
                return this;
            }

            public Builder clearUid() {
                this.uid_ = 0;
                onChanged();
                return this;
            }

            private void ensureAvatarIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.avatarIdList_ = CharAmusementAvatarInfo.mutableCopy(this.avatarIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfoOrBuilder
            public List<Integer> getAvatarIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.avatarIdList_) : this.avatarIdList_;
            }

            @Override // emu.grasscutter.net.proto.CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfoOrBuilder
            public int getAvatarIdListCount() {
                return this.avatarIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfoOrBuilder
            public int getAvatarIdList(int index) {
                return this.avatarIdList_.getInt(index);
            }

            public Builder setAvatarIdList(int index, int value) {
                ensureAvatarIdListIsMutable();
                this.avatarIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addAvatarIdList(int value) {
                ensureAvatarIdListIsMutable();
                this.avatarIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllAvatarIdList(Iterable<? extends Integer> values) {
                ensureAvatarIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.avatarIdList_);
                onChanged();
                return this;
            }

            public Builder clearAvatarIdList() {
                this.avatarIdList_ = CharAmusementAvatarInfo.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.CharAmusementAvatarInfoOuterClass.CharAmusementAvatarInfoOrBuilder
            public int getPmahgkplcgi() {
                return this.pmahgkplcgi_;
            }

            public Builder setPmahgkplcgi(int value) {
                this.pmahgkplcgi_ = value;
                onChanged();
                return this;
            }

            public Builder clearPmahgkplcgi() {
                this.pmahgkplcgi_ = 0;
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

        public static CharAmusementAvatarInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CharAmusementAvatarInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CharAmusementAvatarInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CharAmusementAvatarInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
