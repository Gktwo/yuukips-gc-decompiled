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
import emu.grasscutter.net.proto.CombatInvokeEntryOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombatInvocationsNotifyOuterClass.class */
public final class CombatInvocationsNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dCombatInvocationsNotify.proto\u001a\u0017CombatInvokeEntry.proto\"B\n\u0017CombatInvocationsNotify\u0012'\n\u000binvoke_list\u0018\u000e \u0003(\u000b2\u0012.CombatInvokeEntryB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CombatInvokeEntryOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CombatInvocationsNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CombatInvocationsNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CombatInvocationsNotify_descriptor, new String[]{"InvokeList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombatInvocationsNotifyOuterClass$CombatInvocationsNotifyOrBuilder.class */
    public interface CombatInvocationsNotifyOrBuilder extends MessageOrBuilder {
        List<CombatInvokeEntryOuterClass.CombatInvokeEntry> getInvokeListList();

        CombatInvokeEntryOuterClass.CombatInvokeEntry getInvokeList(int i);

        int getInvokeListCount();

        List<? extends CombatInvokeEntryOuterClass.CombatInvokeEntryOrBuilder> getInvokeListOrBuilderList();

        CombatInvokeEntryOuterClass.CombatInvokeEntryOrBuilder getInvokeListOrBuilder(int i);
    }

    private CombatInvocationsNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombatInvocationsNotifyOuterClass$CombatInvocationsNotify.class */
    public static final class CombatInvocationsNotify extends GeneratedMessageV3 implements CombatInvocationsNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int INVOKE_LIST_FIELD_NUMBER = 14;
        private List<CombatInvokeEntryOuterClass.CombatInvokeEntry> invokeList_;
        private byte memoizedIsInitialized;
        private static final CombatInvocationsNotify DEFAULT_INSTANCE = new CombatInvocationsNotify();
        private static final Parser<CombatInvocationsNotify> PARSER = new AbstractParser<CombatInvocationsNotify>() { // from class: emu.grasscutter.net.proto.CombatInvocationsNotifyOuterClass.CombatInvocationsNotify.1
            @Override // com.google.protobuf.Parser
            public CombatInvocationsNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CombatInvocationsNotify(input, extensionRegistry);
            }
        };

        private CombatInvocationsNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CombatInvocationsNotify() {
            this.memoizedIsInitialized = -1;
            this.invokeList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CombatInvocationsNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CombatInvocationsNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 114:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.invokeList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.invokeList_.add((CombatInvokeEntryOuterClass.CombatInvokeEntry) input.readMessage(CombatInvokeEntryOuterClass.CombatInvokeEntry.parser(), extensionRegistry));
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
                    this.invokeList_ = Collections.unmodifiableList(this.invokeList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CombatInvocationsNotifyOuterClass.internal_static_CombatInvocationsNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CombatInvocationsNotifyOuterClass.internal_static_CombatInvocationsNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CombatInvocationsNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CombatInvocationsNotifyOuterClass.CombatInvocationsNotifyOrBuilder
        public List<CombatInvokeEntryOuterClass.CombatInvokeEntry> getInvokeListList() {
            return this.invokeList_;
        }

        @Override // emu.grasscutter.net.proto.CombatInvocationsNotifyOuterClass.CombatInvocationsNotifyOrBuilder
        public List<? extends CombatInvokeEntryOuterClass.CombatInvokeEntryOrBuilder> getInvokeListOrBuilderList() {
            return this.invokeList_;
        }

        @Override // emu.grasscutter.net.proto.CombatInvocationsNotifyOuterClass.CombatInvocationsNotifyOrBuilder
        public int getInvokeListCount() {
            return this.invokeList_.size();
        }

        @Override // emu.grasscutter.net.proto.CombatInvocationsNotifyOuterClass.CombatInvocationsNotifyOrBuilder
        public CombatInvokeEntryOuterClass.CombatInvokeEntry getInvokeList(int index) {
            return this.invokeList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CombatInvocationsNotifyOuterClass.CombatInvocationsNotifyOrBuilder
        public CombatInvokeEntryOuterClass.CombatInvokeEntryOrBuilder getInvokeListOrBuilder(int index) {
            return this.invokeList_.get(index);
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
            for (int i = 0; i < this.invokeList_.size(); i++) {
                output.writeMessage(14, this.invokeList_.get(i));
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
            for (int i = 0; i < this.invokeList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(14, this.invokeList_.get(i));
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
            if (!(obj instanceof CombatInvocationsNotify)) {
                return equals(obj);
            }
            CombatInvocationsNotify other = (CombatInvocationsNotify) obj;
            return getInvokeListList().equals(other.getInvokeListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getInvokeListCount() > 0) {
                hash = (53 * ((37 * hash) + 14)) + getInvokeListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CombatInvocationsNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CombatInvocationsNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CombatInvocationsNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CombatInvocationsNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CombatInvocationsNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CombatInvocationsNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CombatInvocationsNotify parseFrom(InputStream input) throws IOException {
            return (CombatInvocationsNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CombatInvocationsNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombatInvocationsNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CombatInvocationsNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (CombatInvocationsNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CombatInvocationsNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombatInvocationsNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CombatInvocationsNotify parseFrom(CodedInputStream input) throws IOException {
            return (CombatInvocationsNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CombatInvocationsNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CombatInvocationsNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CombatInvocationsNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CombatInvocationsNotifyOuterClass$CombatInvocationsNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CombatInvocationsNotifyOrBuilder {
            private int bitField0_;
            private List<CombatInvokeEntryOuterClass.CombatInvokeEntry> invokeList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<CombatInvokeEntryOuterClass.CombatInvokeEntry, CombatInvokeEntryOuterClass.CombatInvokeEntry.Builder, CombatInvokeEntryOuterClass.CombatInvokeEntryOrBuilder> invokeListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CombatInvocationsNotifyOuterClass.internal_static_CombatInvocationsNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CombatInvocationsNotifyOuterClass.internal_static_CombatInvocationsNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CombatInvocationsNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CombatInvocationsNotify.alwaysUseFieldBuilders) {
                    getInvokeListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.invokeListBuilder_ == null) {
                    this.invokeList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.invokeListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CombatInvocationsNotifyOuterClass.internal_static_CombatInvocationsNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CombatInvocationsNotify getDefaultInstanceForType() {
                return CombatInvocationsNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CombatInvocationsNotify build() {
                CombatInvocationsNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CombatInvocationsNotify buildPartial() {
                CombatInvocationsNotify result = new CombatInvocationsNotify(this);
                int i = this.bitField0_;
                if (this.invokeListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.invokeList_ = Collections.unmodifiableList(this.invokeList_);
                        this.bitField0_ &= -2;
                    }
                    result.invokeList_ = this.invokeList_;
                } else {
                    result.invokeList_ = this.invokeListBuilder_.build();
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
                if (other instanceof CombatInvocationsNotify) {
                    return mergeFrom((CombatInvocationsNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CombatInvocationsNotify other) {
                if (other == CombatInvocationsNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.invokeListBuilder_ == null) {
                    if (!other.invokeList_.isEmpty()) {
                        if (this.invokeList_.isEmpty()) {
                            this.invokeList_ = other.invokeList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureInvokeListIsMutable();
                            this.invokeList_.addAll(other.invokeList_);
                        }
                        onChanged();
                    }
                } else if (!other.invokeList_.isEmpty()) {
                    if (this.invokeListBuilder_.isEmpty()) {
                        this.invokeListBuilder_.dispose();
                        this.invokeListBuilder_ = null;
                        this.invokeList_ = other.invokeList_;
                        this.bitField0_ &= -2;
                        this.invokeListBuilder_ = CombatInvocationsNotify.alwaysUseFieldBuilders ? getInvokeListFieldBuilder() : null;
                    } else {
                        this.invokeListBuilder_.addAllMessages(other.invokeList_);
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
                CombatInvocationsNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = CombatInvocationsNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CombatInvocationsNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureInvokeListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.invokeList_ = new ArrayList(this.invokeList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CombatInvocationsNotifyOuterClass.CombatInvocationsNotifyOrBuilder
            public List<CombatInvokeEntryOuterClass.CombatInvokeEntry> getInvokeListList() {
                if (this.invokeListBuilder_ == null) {
                    return Collections.unmodifiableList(this.invokeList_);
                }
                return this.invokeListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CombatInvocationsNotifyOuterClass.CombatInvocationsNotifyOrBuilder
            public int getInvokeListCount() {
                if (this.invokeListBuilder_ == null) {
                    return this.invokeList_.size();
                }
                return this.invokeListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CombatInvocationsNotifyOuterClass.CombatInvocationsNotifyOrBuilder
            public CombatInvokeEntryOuterClass.CombatInvokeEntry getInvokeList(int index) {
                if (this.invokeListBuilder_ == null) {
                    return this.invokeList_.get(index);
                }
                return this.invokeListBuilder_.getMessage(index);
            }

            public Builder setInvokeList(int index, CombatInvokeEntryOuterClass.CombatInvokeEntry value) {
                if (this.invokeListBuilder_ != null) {
                    this.invokeListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInvokeListIsMutable();
                    this.invokeList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setInvokeList(int index, CombatInvokeEntryOuterClass.CombatInvokeEntry.Builder builderForValue) {
                if (this.invokeListBuilder_ == null) {
                    ensureInvokeListIsMutable();
                    this.invokeList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.invokeListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addInvokeList(CombatInvokeEntryOuterClass.CombatInvokeEntry value) {
                if (this.invokeListBuilder_ != null) {
                    this.invokeListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInvokeListIsMutable();
                    this.invokeList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addInvokeList(int index, CombatInvokeEntryOuterClass.CombatInvokeEntry value) {
                if (this.invokeListBuilder_ != null) {
                    this.invokeListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInvokeListIsMutable();
                    this.invokeList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addInvokeList(CombatInvokeEntryOuterClass.CombatInvokeEntry.Builder builderForValue) {
                if (this.invokeListBuilder_ == null) {
                    ensureInvokeListIsMutable();
                    this.invokeList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.invokeListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addInvokeList(int index, CombatInvokeEntryOuterClass.CombatInvokeEntry.Builder builderForValue) {
                if (this.invokeListBuilder_ == null) {
                    ensureInvokeListIsMutable();
                    this.invokeList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.invokeListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllInvokeList(Iterable<? extends CombatInvokeEntryOuterClass.CombatInvokeEntry> values) {
                if (this.invokeListBuilder_ == null) {
                    ensureInvokeListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.invokeList_);
                    onChanged();
                } else {
                    this.invokeListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearInvokeList() {
                if (this.invokeListBuilder_ == null) {
                    this.invokeList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.invokeListBuilder_.clear();
                }
                return this;
            }

            public Builder removeInvokeList(int index) {
                if (this.invokeListBuilder_ == null) {
                    ensureInvokeListIsMutable();
                    this.invokeList_.remove(index);
                    onChanged();
                } else {
                    this.invokeListBuilder_.remove(index);
                }
                return this;
            }

            public CombatInvokeEntryOuterClass.CombatInvokeEntry.Builder getInvokeListBuilder(int index) {
                return getInvokeListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CombatInvocationsNotifyOuterClass.CombatInvocationsNotifyOrBuilder
            public CombatInvokeEntryOuterClass.CombatInvokeEntryOrBuilder getInvokeListOrBuilder(int index) {
                if (this.invokeListBuilder_ == null) {
                    return this.invokeList_.get(index);
                }
                return this.invokeListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CombatInvocationsNotifyOuterClass.CombatInvocationsNotifyOrBuilder
            public List<? extends CombatInvokeEntryOuterClass.CombatInvokeEntryOrBuilder> getInvokeListOrBuilderList() {
                if (this.invokeListBuilder_ != null) {
                    return this.invokeListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.invokeList_);
            }

            public CombatInvokeEntryOuterClass.CombatInvokeEntry.Builder addInvokeListBuilder() {
                return getInvokeListFieldBuilder().addBuilder(CombatInvokeEntryOuterClass.CombatInvokeEntry.getDefaultInstance());
            }

            public CombatInvokeEntryOuterClass.CombatInvokeEntry.Builder addInvokeListBuilder(int index) {
                return getInvokeListFieldBuilder().addBuilder(index, CombatInvokeEntryOuterClass.CombatInvokeEntry.getDefaultInstance());
            }

            public List<CombatInvokeEntryOuterClass.CombatInvokeEntry.Builder> getInvokeListBuilderList() {
                return getInvokeListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<CombatInvokeEntryOuterClass.CombatInvokeEntry, CombatInvokeEntryOuterClass.CombatInvokeEntry.Builder, CombatInvokeEntryOuterClass.CombatInvokeEntryOrBuilder> getInvokeListFieldBuilder() {
                if (this.invokeListBuilder_ == null) {
                    this.invokeListBuilder_ = new RepeatedFieldBuilderV3<>(this.invokeList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.invokeList_ = null;
                }
                return this.invokeListBuilder_;
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

        public static CombatInvocationsNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CombatInvocationsNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CombatInvocationsNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CombatInvocationsNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CombatInvokeEntryOuterClass.getDescriptor();
    }
}
