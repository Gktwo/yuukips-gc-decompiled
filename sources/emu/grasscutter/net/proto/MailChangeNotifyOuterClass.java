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
import emu.grasscutter.net.proto.MailDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MailChangeNotifyOuterClass.class */
public final class MailChangeNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016MailChangeNotify.proto\u001a\u000eMailData.proto\"F\n\u0010MailChangeNotify\u0012\u0015\n\rdelMailIdList\u0018\u0004 \u0003(\r\u0012\u001b\n\bmailList\u0018\u0005 \u0003(\u000b2\t.MailDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MailDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MailChangeNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MailChangeNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MailChangeNotify_descriptor, new String[]{"DelMailIdList", "MailList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MailChangeNotifyOuterClass$MailChangeNotifyOrBuilder.class */
    public interface MailChangeNotifyOrBuilder extends MessageOrBuilder {
        List<Integer> getDelMailIdListList();

        int getDelMailIdListCount();

        int getDelMailIdList(int i);

        List<MailDataOuterClass.MailData> getMailListList();

        MailDataOuterClass.MailData getMailList(int i);

        int getMailListCount();

        List<? extends MailDataOuterClass.MailDataOrBuilder> getMailListOrBuilderList();

        MailDataOuterClass.MailDataOrBuilder getMailListOrBuilder(int i);
    }

    private MailChangeNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MailChangeNotifyOuterClass$MailChangeNotify.class */
    public static final class MailChangeNotify extends GeneratedMessageV3 implements MailChangeNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DELMAILIDLIST_FIELD_NUMBER = 4;
        private Internal.IntList delMailIdList_;
        private int delMailIdListMemoizedSerializedSize;
        public static final int MAILLIST_FIELD_NUMBER = 5;
        private List<MailDataOuterClass.MailData> mailList_;
        private byte memoizedIsInitialized;
        private static final MailChangeNotify DEFAULT_INSTANCE = new MailChangeNotify();
        private static final Parser<MailChangeNotify> PARSER = new AbstractParser<MailChangeNotify>() { // from class: emu.grasscutter.net.proto.MailChangeNotifyOuterClass.MailChangeNotify.1
            @Override // com.google.protobuf.Parser
            public MailChangeNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MailChangeNotify(input, extensionRegistry);
            }
        };

        private MailChangeNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.delMailIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private MailChangeNotify() {
            this.delMailIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.delMailIdList_ = emptyIntList();
            this.mailList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MailChangeNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:68:0x00fa */
        private MailChangeNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.delMailIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.delMailIdList_.addInt(input.readUInt32());
                                break;
                            case 34:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.delMailIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.delMailIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 42:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.mailList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.mailList_.add((MailDataOuterClass.MailData) input.readMessage(MailDataOuterClass.MailData.parser(), extensionRegistry));
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
                if ((mutable_bitField0_ & 1) != 0) {
                    this.delMailIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.mailList_ = Collections.unmodifiableList(this.mailList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MailChangeNotifyOuterClass.internal_static_MailChangeNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MailChangeNotifyOuterClass.internal_static_MailChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(MailChangeNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MailChangeNotifyOuterClass.MailChangeNotifyOrBuilder
        public List<Integer> getDelMailIdListList() {
            return this.delMailIdList_;
        }

        @Override // emu.grasscutter.net.proto.MailChangeNotifyOuterClass.MailChangeNotifyOrBuilder
        public int getDelMailIdListCount() {
            return this.delMailIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.MailChangeNotifyOuterClass.MailChangeNotifyOrBuilder
        public int getDelMailIdList(int index) {
            return this.delMailIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.MailChangeNotifyOuterClass.MailChangeNotifyOrBuilder
        public List<MailDataOuterClass.MailData> getMailListList() {
            return this.mailList_;
        }

        @Override // emu.grasscutter.net.proto.MailChangeNotifyOuterClass.MailChangeNotifyOrBuilder
        public List<? extends MailDataOuterClass.MailDataOrBuilder> getMailListOrBuilderList() {
            return this.mailList_;
        }

        @Override // emu.grasscutter.net.proto.MailChangeNotifyOuterClass.MailChangeNotifyOrBuilder
        public int getMailListCount() {
            return this.mailList_.size();
        }

        @Override // emu.grasscutter.net.proto.MailChangeNotifyOuterClass.MailChangeNotifyOrBuilder
        public MailDataOuterClass.MailData getMailList(int index) {
            return this.mailList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MailChangeNotifyOuterClass.MailChangeNotifyOrBuilder
        public MailDataOuterClass.MailDataOrBuilder getMailListOrBuilder(int index) {
            return this.mailList_.get(index);
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
            if (getDelMailIdListList().size() > 0) {
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.delMailIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.delMailIdList_.size(); i++) {
                output.writeUInt32NoTag(this.delMailIdList_.getInt(i));
            }
            for (int i2 = 0; i2 < this.mailList_.size(); i2++) {
                output.writeMessage(5, this.mailList_.get(i2));
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
            for (int i = 0; i < this.delMailIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.delMailIdList_.getInt(i));
            }
            int size2 = 0 + dataSize;
            if (!getDelMailIdListList().isEmpty()) {
                size2 = size2 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.delMailIdListMemoizedSerializedSize = dataSize;
            for (int i2 = 0; i2 < this.mailList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.mailList_.get(i2));
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
            if (!(obj instanceof MailChangeNotify)) {
                return equals(obj);
            }
            MailChangeNotify other = (MailChangeNotify) obj;
            return getDelMailIdListList().equals(other.getDelMailIdListList()) && getMailListList().equals(other.getMailListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getDelMailIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getDelMailIdListList().hashCode();
            }
            if (getMailListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getMailListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MailChangeNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MailChangeNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailChangeNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MailChangeNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailChangeNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MailChangeNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MailChangeNotify parseFrom(InputStream input) throws IOException {
            return (MailChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MailChangeNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MailChangeNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (MailChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MailChangeNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailChangeNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MailChangeNotify parseFrom(CodedInputStream input) throws IOException {
            return (MailChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MailChangeNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MailChangeNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MailChangeNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MailChangeNotifyOuterClass$MailChangeNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MailChangeNotifyOrBuilder {
            private int bitField0_;
            private Internal.IntList delMailIdList_ = MailChangeNotify.emptyIntList();
            private List<MailDataOuterClass.MailData> mailList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<MailDataOuterClass.MailData, MailDataOuterClass.MailData.Builder, MailDataOuterClass.MailDataOrBuilder> mailListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MailChangeNotifyOuterClass.internal_static_MailChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MailChangeNotifyOuterClass.internal_static_MailChangeNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(MailChangeNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MailChangeNotify.alwaysUseFieldBuilders) {
                    getMailListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.delMailIdList_ = MailChangeNotify.emptyIntList();
                this.bitField0_ &= -2;
                if (this.mailListBuilder_ == null) {
                    this.mailList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.mailListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MailChangeNotifyOuterClass.internal_static_MailChangeNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MailChangeNotify getDefaultInstanceForType() {
                return MailChangeNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MailChangeNotify build() {
                MailChangeNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MailChangeNotify buildPartial() {
                MailChangeNotify result = new MailChangeNotify(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.delMailIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.delMailIdList_ = this.delMailIdList_;
                if (this.mailListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.mailList_ = Collections.unmodifiableList(this.mailList_);
                        this.bitField0_ &= -3;
                    }
                    result.mailList_ = this.mailList_;
                } else {
                    result.mailList_ = this.mailListBuilder_.build();
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
                if (other instanceof MailChangeNotify) {
                    return mergeFrom((MailChangeNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MailChangeNotify other) {
                if (other == MailChangeNotify.getDefaultInstance()) {
                    return this;
                }
                if (!other.delMailIdList_.isEmpty()) {
                    if (this.delMailIdList_.isEmpty()) {
                        this.delMailIdList_ = other.delMailIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureDelMailIdListIsMutable();
                        this.delMailIdList_.addAll(other.delMailIdList_);
                    }
                    onChanged();
                }
                if (this.mailListBuilder_ == null) {
                    if (!other.mailList_.isEmpty()) {
                        if (this.mailList_.isEmpty()) {
                            this.mailList_ = other.mailList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureMailListIsMutable();
                            this.mailList_.addAll(other.mailList_);
                        }
                        onChanged();
                    }
                } else if (!other.mailList_.isEmpty()) {
                    if (this.mailListBuilder_.isEmpty()) {
                        this.mailListBuilder_.dispose();
                        this.mailListBuilder_ = null;
                        this.mailList_ = other.mailList_;
                        this.bitField0_ &= -3;
                        this.mailListBuilder_ = MailChangeNotify.alwaysUseFieldBuilders ? getMailListFieldBuilder() : null;
                    } else {
                        this.mailListBuilder_.addAllMessages(other.mailList_);
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
                MailChangeNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = MailChangeNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MailChangeNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureDelMailIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.delMailIdList_ = MailChangeNotify.mutableCopy(this.delMailIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MailChangeNotifyOuterClass.MailChangeNotifyOrBuilder
            public List<Integer> getDelMailIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.delMailIdList_) : this.delMailIdList_;
            }

            @Override // emu.grasscutter.net.proto.MailChangeNotifyOuterClass.MailChangeNotifyOrBuilder
            public int getDelMailIdListCount() {
                return this.delMailIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.MailChangeNotifyOuterClass.MailChangeNotifyOrBuilder
            public int getDelMailIdList(int index) {
                return this.delMailIdList_.getInt(index);
            }

            public Builder setDelMailIdList(int index, int value) {
                ensureDelMailIdListIsMutable();
                this.delMailIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addDelMailIdList(int value) {
                ensureDelMailIdListIsMutable();
                this.delMailIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllDelMailIdList(Iterable<? extends Integer> values) {
                ensureDelMailIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.delMailIdList_);
                onChanged();
                return this;
            }

            public Builder clearDelMailIdList() {
                this.delMailIdList_ = MailChangeNotify.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            private void ensureMailListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.mailList_ = new ArrayList(this.mailList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.MailChangeNotifyOuterClass.MailChangeNotifyOrBuilder
            public List<MailDataOuterClass.MailData> getMailListList() {
                if (this.mailListBuilder_ == null) {
                    return Collections.unmodifiableList(this.mailList_);
                }
                return this.mailListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MailChangeNotifyOuterClass.MailChangeNotifyOrBuilder
            public int getMailListCount() {
                if (this.mailListBuilder_ == null) {
                    return this.mailList_.size();
                }
                return this.mailListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MailChangeNotifyOuterClass.MailChangeNotifyOrBuilder
            public MailDataOuterClass.MailData getMailList(int index) {
                if (this.mailListBuilder_ == null) {
                    return this.mailList_.get(index);
                }
                return this.mailListBuilder_.getMessage(index);
            }

            public Builder setMailList(int index, MailDataOuterClass.MailData value) {
                if (this.mailListBuilder_ != null) {
                    this.mailListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMailListIsMutable();
                    this.mailList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMailList(int index, MailDataOuterClass.MailData.Builder builderForValue) {
                if (this.mailListBuilder_ == null) {
                    ensureMailListIsMutable();
                    this.mailList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.mailListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMailList(MailDataOuterClass.MailData value) {
                if (this.mailListBuilder_ != null) {
                    this.mailListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMailListIsMutable();
                    this.mailList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMailList(int index, MailDataOuterClass.MailData value) {
                if (this.mailListBuilder_ != null) {
                    this.mailListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMailListIsMutable();
                    this.mailList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMailList(MailDataOuterClass.MailData.Builder builderForValue) {
                if (this.mailListBuilder_ == null) {
                    ensureMailListIsMutable();
                    this.mailList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.mailListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMailList(int index, MailDataOuterClass.MailData.Builder builderForValue) {
                if (this.mailListBuilder_ == null) {
                    ensureMailListIsMutable();
                    this.mailList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.mailListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMailList(Iterable<? extends MailDataOuterClass.MailData> values) {
                if (this.mailListBuilder_ == null) {
                    ensureMailListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.mailList_);
                    onChanged();
                } else {
                    this.mailListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMailList() {
                if (this.mailListBuilder_ == null) {
                    this.mailList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.mailListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMailList(int index) {
                if (this.mailListBuilder_ == null) {
                    ensureMailListIsMutable();
                    this.mailList_.remove(index);
                    onChanged();
                } else {
                    this.mailListBuilder_.remove(index);
                }
                return this;
            }

            public MailDataOuterClass.MailData.Builder getMailListBuilder(int index) {
                return getMailListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MailChangeNotifyOuterClass.MailChangeNotifyOrBuilder
            public MailDataOuterClass.MailDataOrBuilder getMailListOrBuilder(int index) {
                if (this.mailListBuilder_ == null) {
                    return this.mailList_.get(index);
                }
                return this.mailListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MailChangeNotifyOuterClass.MailChangeNotifyOrBuilder
            public List<? extends MailDataOuterClass.MailDataOrBuilder> getMailListOrBuilderList() {
                if (this.mailListBuilder_ != null) {
                    return this.mailListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.mailList_);
            }

            public MailDataOuterClass.MailData.Builder addMailListBuilder() {
                return getMailListFieldBuilder().addBuilder(MailDataOuterClass.MailData.getDefaultInstance());
            }

            public MailDataOuterClass.MailData.Builder addMailListBuilder(int index) {
                return getMailListFieldBuilder().addBuilder(index, MailDataOuterClass.MailData.getDefaultInstance());
            }

            public List<MailDataOuterClass.MailData.Builder> getMailListBuilderList() {
                return getMailListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MailDataOuterClass.MailData, MailDataOuterClass.MailData.Builder, MailDataOuterClass.MailDataOrBuilder> getMailListFieldBuilder() {
                if (this.mailListBuilder_ == null) {
                    this.mailListBuilder_ = new RepeatedFieldBuilderV3<>(this.mailList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.mailList_ = null;
                }
                return this.mailListBuilder_;
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

        public static MailChangeNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MailChangeNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MailChangeNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MailChangeNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MailDataOuterClass.getDescriptor();
    }
}
