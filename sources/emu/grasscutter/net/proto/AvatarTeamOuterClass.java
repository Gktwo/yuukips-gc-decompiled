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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarTeamOuterClass.class */
public final class AvatarTeamOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010AvatarTeam.proto\"6\n\nAvatarTeam\u0012\u0010\n\bteamName\u0018\u000b \u0001(\t\u0012\u0016\n\u000eavatarGuidList\u0018\u0005 \u0003(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_AvatarTeam_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AvatarTeam_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AvatarTeam_descriptor, new String[]{"TeamName", "AvatarGuidList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarTeamOuterClass$AvatarTeamOrBuilder.class */
    public interface AvatarTeamOrBuilder extends MessageOrBuilder {
        String getTeamName();

        ByteString getTeamNameBytes();

        List<Long> getAvatarGuidListList();

        int getAvatarGuidListCount();

        long getAvatarGuidList(int i);
    }

    private AvatarTeamOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarTeamOuterClass$AvatarTeam.class */
    public static final class AvatarTeam extends GeneratedMessageV3 implements AvatarTeamOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TEAMNAME_FIELD_NUMBER = 11;
        private volatile Object teamName_;
        public static final int AVATARGUIDLIST_FIELD_NUMBER = 5;
        private Internal.LongList avatarGuidList_;
        private int avatarGuidListMemoizedSerializedSize;
        private byte memoizedIsInitialized;
        private static final AvatarTeam DEFAULT_INSTANCE = new AvatarTeam();
        private static final Parser<AvatarTeam> PARSER = new AbstractParser<AvatarTeam>() { // from class: emu.grasscutter.net.proto.AvatarTeamOuterClass.AvatarTeam.1
            @Override // com.google.protobuf.Parser
            public AvatarTeam parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AvatarTeam(input, extensionRegistry);
            }
        };

        private AvatarTeam(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.avatarGuidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private AvatarTeam() {
            this.avatarGuidListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.teamName_ = "";
            this.avatarGuidList_ = emptyLongList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AvatarTeam();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private AvatarTeam(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 40:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.avatarGuidList_ = newLongList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.avatarGuidList_.addLong(input.readUInt64());
                                break;
                            case 42:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.avatarGuidList_ = newLongList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.avatarGuidList_.addLong(input.readUInt64());
                                }
                                input.popLimit(limit);
                                break;
                            case 90:
                                this.teamName_ = input.readStringRequireUtf8();
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
                    this.avatarGuidList_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AvatarTeamOuterClass.internal_static_AvatarTeam_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AvatarTeamOuterClass.internal_static_AvatarTeam_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarTeam.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamOuterClass.AvatarTeamOrBuilder
        public String getTeamName() {
            Object ref = this.teamName_;
            if (ref instanceof String) {
                return (String) ref;
            }
            String s = ((ByteString) ref).toStringUtf8();
            this.teamName_ = s;
            return s;
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamOuterClass.AvatarTeamOrBuilder
        public ByteString getTeamNameBytes() {
            Object ref = this.teamName_;
            if (!(ref instanceof String)) {
                return (ByteString) ref;
            }
            ByteString b = ByteString.copyFromUtf8((String) ref);
            this.teamName_ = b;
            return b;
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamOuterClass.AvatarTeamOrBuilder
        public List<Long> getAvatarGuidListList() {
            return this.avatarGuidList_;
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamOuterClass.AvatarTeamOrBuilder
        public int getAvatarGuidListCount() {
            return this.avatarGuidList_.size();
        }

        @Override // emu.grasscutter.net.proto.AvatarTeamOuterClass.AvatarTeamOrBuilder
        public long getAvatarGuidList(int index) {
            return this.avatarGuidList_.getLong(index);
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
            if (getAvatarGuidListList().size() > 0) {
                output.writeUInt32NoTag(42);
                output.writeUInt32NoTag(this.avatarGuidListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.avatarGuidList_.size(); i++) {
                output.writeUInt64NoTag(this.avatarGuidList_.getLong(i));
            }
            if (!GeneratedMessageV3.isStringEmpty(this.teamName_)) {
                GeneratedMessageV3.writeString(output, 11, this.teamName_);
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
            for (int i = 0; i < this.avatarGuidList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt64SizeNoTag(this.avatarGuidList_.getLong(i));
            }
            int size2 = 0 + dataSize;
            if (!getAvatarGuidListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.avatarGuidListMemoizedSerializedSize = dataSize;
            if (!GeneratedMessageV3.isStringEmpty(this.teamName_)) {
                size2 += GeneratedMessageV3.computeStringSize(11, this.teamName_);
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
            if (!(obj instanceof AvatarTeam)) {
                return equals(obj);
            }
            AvatarTeam other = (AvatarTeam) obj;
            return getTeamName().equals(other.getTeamName()) && getAvatarGuidListList().equals(other.getAvatarGuidListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 11)) + getTeamName().hashCode();
            if (getAvatarGuidListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getAvatarGuidListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AvatarTeam parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarTeam parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarTeam parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarTeam parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarTeam parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AvatarTeam parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AvatarTeam parseFrom(InputStream input) throws IOException {
            return (AvatarTeam) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarTeam parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarTeam) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarTeam parseDelimitedFrom(InputStream input) throws IOException {
            return (AvatarTeam) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AvatarTeam parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarTeam) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AvatarTeam parseFrom(CodedInputStream input) throws IOException {
            return (AvatarTeam) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AvatarTeam parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AvatarTeam) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AvatarTeam prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AvatarTeamOuterClass$AvatarTeam$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AvatarTeamOrBuilder {
            private int bitField0_;
            private Object teamName_ = "";
            private Internal.LongList avatarGuidList_ = AvatarTeam.emptyLongList();

            public static final Descriptors.Descriptor getDescriptor() {
                return AvatarTeamOuterClass.internal_static_AvatarTeam_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AvatarTeamOuterClass.internal_static_AvatarTeam_fieldAccessorTable.ensureFieldAccessorsInitialized(AvatarTeam.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AvatarTeam.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.teamName_ = "";
                this.avatarGuidList_ = AvatarTeam.emptyLongList();
                this.bitField0_ &= -2;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AvatarTeamOuterClass.internal_static_AvatarTeam_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AvatarTeam getDefaultInstanceForType() {
                return AvatarTeam.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarTeam build() {
                AvatarTeam result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AvatarTeam buildPartial() {
                AvatarTeam result = new AvatarTeam(this);
                int i = this.bitField0_;
                result.teamName_ = this.teamName_;
                if ((this.bitField0_ & 1) != 0) {
                    this.avatarGuidList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.avatarGuidList_ = this.avatarGuidList_;
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
                if (other instanceof AvatarTeam) {
                    return mergeFrom((AvatarTeam) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AvatarTeam other) {
                if (other == AvatarTeam.getDefaultInstance()) {
                    return this;
                }
                if (!other.getTeamName().isEmpty()) {
                    this.teamName_ = other.teamName_;
                    onChanged();
                }
                if (!other.avatarGuidList_.isEmpty()) {
                    if (this.avatarGuidList_.isEmpty()) {
                        this.avatarGuidList_ = other.avatarGuidList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAvatarGuidListIsMutable();
                        this.avatarGuidList_.addAll(other.avatarGuidList_);
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
                AvatarTeam parsedMessage = null;
                try {
                    try {
                        parsedMessage = AvatarTeam.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AvatarTeam) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamOuterClass.AvatarTeamOrBuilder
            public String getTeamName() {
                Object ref = this.teamName_;
                if (ref instanceof String) {
                    return (String) ref;
                }
                String s = ((ByteString) ref).toStringUtf8();
                this.teamName_ = s;
                return s;
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamOuterClass.AvatarTeamOrBuilder
            public ByteString getTeamNameBytes() {
                Object ref = this.teamName_;
                if (!(ref instanceof String)) {
                    return (ByteString) ref;
                }
                ByteString b = ByteString.copyFromUtf8((String) ref);
                this.teamName_ = b;
                return b;
            }

            public Builder setTeamName(String value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                this.teamName_ = value;
                onChanged();
                return this;
            }

            public Builder clearTeamName() {
                this.teamName_ = AvatarTeam.getDefaultInstance().getTeamName();
                onChanged();
                return this;
            }

            public Builder setTeamNameBytes(ByteString value) {
                if (value == null) {
                    throw new NullPointerException();
                }
                AvatarTeam.checkByteStringIsUtf8(value);
                this.teamName_ = value;
                onChanged();
                return this;
            }

            private void ensureAvatarGuidListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.avatarGuidList_ = AvatarTeam.mutableCopy(this.avatarGuidList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamOuterClass.AvatarTeamOrBuilder
            public List<Long> getAvatarGuidListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.avatarGuidList_) : this.avatarGuidList_;
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamOuterClass.AvatarTeamOrBuilder
            public int getAvatarGuidListCount() {
                return this.avatarGuidList_.size();
            }

            @Override // emu.grasscutter.net.proto.AvatarTeamOuterClass.AvatarTeamOrBuilder
            public long getAvatarGuidList(int index) {
                return this.avatarGuidList_.getLong(index);
            }

            public Builder setAvatarGuidList(int index, long value) {
                ensureAvatarGuidListIsMutable();
                this.avatarGuidList_.setLong(index, value);
                onChanged();
                return this;
            }

            public Builder addAvatarGuidList(long value) {
                ensureAvatarGuidListIsMutable();
                this.avatarGuidList_.addLong(value);
                onChanged();
                return this;
            }

            public Builder addAllAvatarGuidList(Iterable<? extends Long> values) {
                ensureAvatarGuidListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.avatarGuidList_);
                onChanged();
                return this;
            }

            public Builder clearAvatarGuidList() {
                this.avatarGuidList_ = AvatarTeam.emptyLongList();
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

        public static AvatarTeam getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AvatarTeam> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AvatarTeam> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AvatarTeam getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
