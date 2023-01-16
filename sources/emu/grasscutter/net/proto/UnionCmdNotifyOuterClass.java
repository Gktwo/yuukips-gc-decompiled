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
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.UnionCmdOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnionCmdNotifyOuterClass.class */
public final class UnionCmdNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014UnionCmdNotify.proto\u001a\u000eUnionCmd.proto\"-\n\u000eUnionCmdNotify\u0012\u001b\n\bcmd_list\u0018\u0007 \u0003(\u000b2\t.UnionCmdB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{UnionCmdOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_UnionCmdNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_UnionCmdNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_UnionCmdNotify_descriptor, new String[]{"CmdList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnionCmdNotifyOuterClass$UnionCmdNotifyOrBuilder.class */
    public interface UnionCmdNotifyOrBuilder extends MessageOrBuilder {
        List<UnionCmdOuterClass.UnionCmd> getCmdListList();

        UnionCmdOuterClass.UnionCmd getCmdList(int i);

        int getCmdListCount();

        List<? extends UnionCmdOuterClass.UnionCmdOrBuilder> getCmdListOrBuilderList();

        UnionCmdOuterClass.UnionCmdOrBuilder getCmdListOrBuilder(int i);
    }

    private UnionCmdNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnionCmdNotifyOuterClass$UnionCmdNotify.class */
    public static final class UnionCmdNotify extends GeneratedMessageV3 implements UnionCmdNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CMD_LIST_FIELD_NUMBER = 7;
        private List<UnionCmdOuterClass.UnionCmd> cmdList_;
        private byte memoizedIsInitialized;
        private static final UnionCmdNotify DEFAULT_INSTANCE = new UnionCmdNotify();
        private static final Parser<UnionCmdNotify> PARSER = new AbstractParser<UnionCmdNotify>() { // from class: emu.grasscutter.net.proto.UnionCmdNotifyOuterClass.UnionCmdNotify.1
            @Override // com.google.protobuf.Parser
            public UnionCmdNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new UnionCmdNotify(input, extensionRegistry);
            }
        };

        private UnionCmdNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private UnionCmdNotify() {
            this.memoizedIsInitialized = -1;
            this.cmdList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new UnionCmdNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private UnionCmdNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 58:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.cmdList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.cmdList_.add((UnionCmdOuterClass.UnionCmd) input.readMessage(UnionCmdOuterClass.UnionCmd.parser(), extensionRegistry));
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
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.cmdList_ = Collections.unmodifiableList(this.cmdList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return UnionCmdNotifyOuterClass.internal_static_UnionCmdNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return UnionCmdNotifyOuterClass.internal_static_UnionCmdNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(UnionCmdNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.UnionCmdNotifyOuterClass.UnionCmdNotifyOrBuilder
        public List<UnionCmdOuterClass.UnionCmd> getCmdListList() {
            return this.cmdList_;
        }

        @Override // emu.grasscutter.net.proto.UnionCmdNotifyOuterClass.UnionCmdNotifyOrBuilder
        public List<? extends UnionCmdOuterClass.UnionCmdOrBuilder> getCmdListOrBuilderList() {
            return this.cmdList_;
        }

        @Override // emu.grasscutter.net.proto.UnionCmdNotifyOuterClass.UnionCmdNotifyOrBuilder
        public int getCmdListCount() {
            return this.cmdList_.size();
        }

        @Override // emu.grasscutter.net.proto.UnionCmdNotifyOuterClass.UnionCmdNotifyOrBuilder
        public UnionCmdOuterClass.UnionCmd getCmdList(int index) {
            return this.cmdList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.UnionCmdNotifyOuterClass.UnionCmdNotifyOrBuilder
        public UnionCmdOuterClass.UnionCmdOrBuilder getCmdListOrBuilder(int index) {
            return this.cmdList_.get(index);
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
            for (int i = 0; i < this.cmdList_.size(); i++) {
                output.writeMessage(7, this.cmdList_.get(i));
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
            for (int i = 0; i < this.cmdList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.cmdList_.get(i));
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
            if (!(obj instanceof UnionCmdNotify)) {
                return equals(obj);
            }
            UnionCmdNotify other = (UnionCmdNotify) obj;
            return getCmdListList().equals(other.getCmdListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getCmdListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getCmdListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static UnionCmdNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UnionCmdNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UnionCmdNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UnionCmdNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UnionCmdNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static UnionCmdNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static UnionCmdNotify parseFrom(InputStream input) throws IOException {
            return (UnionCmdNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UnionCmdNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnionCmdNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static UnionCmdNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (UnionCmdNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static UnionCmdNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnionCmdNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static UnionCmdNotify parseFrom(CodedInputStream input) throws IOException {
            return (UnionCmdNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static UnionCmdNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnionCmdNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(UnionCmdNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/UnionCmdNotifyOuterClass$UnionCmdNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements UnionCmdNotifyOrBuilder {
            private int bitField0_;
            private List<UnionCmdOuterClass.UnionCmd> cmdList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<UnionCmdOuterClass.UnionCmd, UnionCmdOuterClass.UnionCmd.Builder, UnionCmdOuterClass.UnionCmdOrBuilder> cmdListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return UnionCmdNotifyOuterClass.internal_static_UnionCmdNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return UnionCmdNotifyOuterClass.internal_static_UnionCmdNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(UnionCmdNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (UnionCmdNotify.alwaysUseFieldBuilders) {
                    getCmdListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.cmdListBuilder_ == null) {
                    this.cmdList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.cmdListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return UnionCmdNotifyOuterClass.internal_static_UnionCmdNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public UnionCmdNotify getDefaultInstanceForType() {
                return UnionCmdNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UnionCmdNotify build() {
                UnionCmdNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public UnionCmdNotify buildPartial() {
                UnionCmdNotify result = new UnionCmdNotify(this);
                int i = this.bitField0_;
                if (this.cmdListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.cmdList_ = Collections.unmodifiableList(this.cmdList_);
                        this.bitField0_ &= -2;
                    }
                    result.cmdList_ = this.cmdList_;
                } else {
                    result.cmdList_ = this.cmdListBuilder_.build();
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
                if (other instanceof UnionCmdNotify) {
                    return mergeFrom((UnionCmdNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(UnionCmdNotify other) {
                if (other == UnionCmdNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.cmdListBuilder_ == null) {
                    if (!other.cmdList_.isEmpty()) {
                        if (this.cmdList_.isEmpty()) {
                            this.cmdList_ = other.cmdList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureCmdListIsMutable();
                            this.cmdList_.addAll(other.cmdList_);
                        }
                        onChanged();
                    }
                } else if (!other.cmdList_.isEmpty()) {
                    if (this.cmdListBuilder_.isEmpty()) {
                        this.cmdListBuilder_.dispose();
                        this.cmdListBuilder_ = null;
                        this.cmdList_ = other.cmdList_;
                        this.bitField0_ &= -2;
                        this.cmdListBuilder_ = UnionCmdNotify.alwaysUseFieldBuilders ? getCmdListFieldBuilder() : null;
                    } else {
                        this.cmdListBuilder_.addAllMessages(other.cmdList_);
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
                UnionCmdNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = UnionCmdNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (UnionCmdNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureCmdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.cmdList_ = new ArrayList(this.cmdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.UnionCmdNotifyOuterClass.UnionCmdNotifyOrBuilder
            public List<UnionCmdOuterClass.UnionCmd> getCmdListList() {
                if (this.cmdListBuilder_ == null) {
                    return Collections.unmodifiableList(this.cmdList_);
                }
                return this.cmdListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.UnionCmdNotifyOuterClass.UnionCmdNotifyOrBuilder
            public int getCmdListCount() {
                if (this.cmdListBuilder_ == null) {
                    return this.cmdList_.size();
                }
                return this.cmdListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.UnionCmdNotifyOuterClass.UnionCmdNotifyOrBuilder
            public UnionCmdOuterClass.UnionCmd getCmdList(int index) {
                if (this.cmdListBuilder_ == null) {
                    return this.cmdList_.get(index);
                }
                return this.cmdListBuilder_.getMessage(index);
            }

            public Builder setCmdList(int index, UnionCmdOuterClass.UnionCmd value) {
                if (this.cmdListBuilder_ != null) {
                    this.cmdListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCmdListIsMutable();
                    this.cmdList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setCmdList(int index, UnionCmdOuterClass.UnionCmd.Builder builderForValue) {
                if (this.cmdListBuilder_ == null) {
                    ensureCmdListIsMutable();
                    this.cmdList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.cmdListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addCmdList(UnionCmdOuterClass.UnionCmd value) {
                if (this.cmdListBuilder_ != null) {
                    this.cmdListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCmdListIsMutable();
                    this.cmdList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addCmdList(int index, UnionCmdOuterClass.UnionCmd value) {
                if (this.cmdListBuilder_ != null) {
                    this.cmdListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCmdListIsMutable();
                    this.cmdList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addCmdList(UnionCmdOuterClass.UnionCmd.Builder builderForValue) {
                if (this.cmdListBuilder_ == null) {
                    ensureCmdListIsMutable();
                    this.cmdList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.cmdListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addCmdList(int index, UnionCmdOuterClass.UnionCmd.Builder builderForValue) {
                if (this.cmdListBuilder_ == null) {
                    ensureCmdListIsMutable();
                    this.cmdList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.cmdListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllCmdList(Iterable<? extends UnionCmdOuterClass.UnionCmd> values) {
                if (this.cmdListBuilder_ == null) {
                    ensureCmdListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.cmdList_);
                    onChanged();
                } else {
                    this.cmdListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearCmdList() {
                if (this.cmdListBuilder_ == null) {
                    this.cmdList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.cmdListBuilder_.clear();
                }
                return this;
            }

            public Builder removeCmdList(int index) {
                if (this.cmdListBuilder_ == null) {
                    ensureCmdListIsMutable();
                    this.cmdList_.remove(index);
                    onChanged();
                } else {
                    this.cmdListBuilder_.remove(index);
                }
                return this;
            }

            public UnionCmdOuterClass.UnionCmd.Builder getCmdListBuilder(int index) {
                return getCmdListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.UnionCmdNotifyOuterClass.UnionCmdNotifyOrBuilder
            public UnionCmdOuterClass.UnionCmdOrBuilder getCmdListOrBuilder(int index) {
                if (this.cmdListBuilder_ == null) {
                    return this.cmdList_.get(index);
                }
                return this.cmdListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.UnionCmdNotifyOuterClass.UnionCmdNotifyOrBuilder
            public List<? extends UnionCmdOuterClass.UnionCmdOrBuilder> getCmdListOrBuilderList() {
                if (this.cmdListBuilder_ != null) {
                    return this.cmdListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.cmdList_);
            }

            public UnionCmdOuterClass.UnionCmd.Builder addCmdListBuilder() {
                return getCmdListFieldBuilder().addBuilder(UnionCmdOuterClass.UnionCmd.getDefaultInstance());
            }

            public UnionCmdOuterClass.UnionCmd.Builder addCmdListBuilder(int index) {
                return getCmdListFieldBuilder().addBuilder(index, UnionCmdOuterClass.UnionCmd.getDefaultInstance());
            }

            public List<UnionCmdOuterClass.UnionCmd.Builder> getCmdListBuilderList() {
                return getCmdListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<UnionCmdOuterClass.UnionCmd, UnionCmdOuterClass.UnionCmd.Builder, UnionCmdOuterClass.UnionCmdOrBuilder> getCmdListFieldBuilder() {
                if (this.cmdListBuilder_ == null) {
                    this.cmdListBuilder_ = new RepeatedFieldBuilderV3<>(this.cmdList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.cmdList_ = null;
                }
                return this.cmdListBuilder_;
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

        public static UnionCmdNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UnionCmdNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<UnionCmdNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public UnionCmdNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        UnionCmdOuterClass.getDescriptor();
    }
}
