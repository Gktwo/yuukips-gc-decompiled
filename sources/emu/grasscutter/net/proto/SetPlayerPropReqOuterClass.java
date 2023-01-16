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
import emu.grasscutter.net.proto.PropValueOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetPlayerPropReqOuterClass.class */
public final class SetPlayerPropReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016SetPlayerPropReq.proto\u001a\u000fPropValue.proto\"1\n\u0010SetPlayerPropReq\u0012\u001d\n\tprop_list\u0018\u0003 \u0003(\u000b2\n.PropValueB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{PropValueOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SetPlayerPropReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SetPlayerPropReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SetPlayerPropReq_descriptor, new String[]{"PropList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetPlayerPropReqOuterClass$SetPlayerPropReqOrBuilder.class */
    public interface SetPlayerPropReqOrBuilder extends MessageOrBuilder {
        List<PropValueOuterClass.PropValue> getPropListList();

        PropValueOuterClass.PropValue getPropList(int i);

        int getPropListCount();

        List<? extends PropValueOuterClass.PropValueOrBuilder> getPropListOrBuilderList();

        PropValueOuterClass.PropValueOrBuilder getPropListOrBuilder(int i);
    }

    private SetPlayerPropReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetPlayerPropReqOuterClass$SetPlayerPropReq.class */
    public static final class SetPlayerPropReq extends GeneratedMessageV3 implements SetPlayerPropReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int PROP_LIST_FIELD_NUMBER = 3;
        private List<PropValueOuterClass.PropValue> propList_;
        private byte memoizedIsInitialized;
        private static final SetPlayerPropReq DEFAULT_INSTANCE = new SetPlayerPropReq();
        private static final Parser<SetPlayerPropReq> PARSER = new AbstractParser<SetPlayerPropReq>() { // from class: emu.grasscutter.net.proto.SetPlayerPropReqOuterClass.SetPlayerPropReq.1
            @Override // com.google.protobuf.Parser
            public SetPlayerPropReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SetPlayerPropReq(input, extensionRegistry);
            }
        };

        private SetPlayerPropReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SetPlayerPropReq() {
            this.memoizedIsInitialized = -1;
            this.propList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SetPlayerPropReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private SetPlayerPropReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 26:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.propList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.propList_.add((PropValueOuterClass.PropValue) input.readMessage(PropValueOuterClass.PropValue.parser(), extensionRegistry));
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
                    this.propList_ = Collections.unmodifiableList(this.propList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SetPlayerPropReqOuterClass.internal_static_SetPlayerPropReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SetPlayerPropReqOuterClass.internal_static_SetPlayerPropReq_fieldAccessorTable.ensureFieldAccessorsInitialized(SetPlayerPropReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SetPlayerPropReqOuterClass.SetPlayerPropReqOrBuilder
        public List<PropValueOuterClass.PropValue> getPropListList() {
            return this.propList_;
        }

        @Override // emu.grasscutter.net.proto.SetPlayerPropReqOuterClass.SetPlayerPropReqOrBuilder
        public List<? extends PropValueOuterClass.PropValueOrBuilder> getPropListOrBuilderList() {
            return this.propList_;
        }

        @Override // emu.grasscutter.net.proto.SetPlayerPropReqOuterClass.SetPlayerPropReqOrBuilder
        public int getPropListCount() {
            return this.propList_.size();
        }

        @Override // emu.grasscutter.net.proto.SetPlayerPropReqOuterClass.SetPlayerPropReqOrBuilder
        public PropValueOuterClass.PropValue getPropList(int index) {
            return this.propList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SetPlayerPropReqOuterClass.SetPlayerPropReqOrBuilder
        public PropValueOuterClass.PropValueOrBuilder getPropListOrBuilder(int index) {
            return this.propList_.get(index);
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
            for (int i = 0; i < this.propList_.size(); i++) {
                output.writeMessage(3, this.propList_.get(i));
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
            for (int i = 0; i < this.propList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.propList_.get(i));
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
            if (!(obj instanceof SetPlayerPropReq)) {
                return equals(obj);
            }
            SetPlayerPropReq other = (SetPlayerPropReq) obj;
            return getPropListList().equals(other.getPropListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getPropListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getPropListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static SetPlayerPropReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetPlayerPropReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetPlayerPropReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetPlayerPropReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetPlayerPropReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SetPlayerPropReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SetPlayerPropReq parseFrom(InputStream input) throws IOException {
            return (SetPlayerPropReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetPlayerPropReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetPlayerPropReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetPlayerPropReq parseDelimitedFrom(InputStream input) throws IOException {
            return (SetPlayerPropReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SetPlayerPropReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetPlayerPropReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SetPlayerPropReq parseFrom(CodedInputStream input) throws IOException {
            return (SetPlayerPropReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SetPlayerPropReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SetPlayerPropReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SetPlayerPropReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SetPlayerPropReqOuterClass$SetPlayerPropReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SetPlayerPropReqOrBuilder {
            private int bitField0_;
            private List<PropValueOuterClass.PropValue> propList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<PropValueOuterClass.PropValue, PropValueOuterClass.PropValue.Builder, PropValueOuterClass.PropValueOrBuilder> propListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return SetPlayerPropReqOuterClass.internal_static_SetPlayerPropReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SetPlayerPropReqOuterClass.internal_static_SetPlayerPropReq_fieldAccessorTable.ensureFieldAccessorsInitialized(SetPlayerPropReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SetPlayerPropReq.alwaysUseFieldBuilders) {
                    getPropListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.propListBuilder_ == null) {
                    this.propList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.propListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SetPlayerPropReqOuterClass.internal_static_SetPlayerPropReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SetPlayerPropReq getDefaultInstanceForType() {
                return SetPlayerPropReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetPlayerPropReq build() {
                SetPlayerPropReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SetPlayerPropReq buildPartial() {
                SetPlayerPropReq result = new SetPlayerPropReq(this);
                int i = this.bitField0_;
                if (this.propListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.propList_ = Collections.unmodifiableList(this.propList_);
                        this.bitField0_ &= -2;
                    }
                    result.propList_ = this.propList_;
                } else {
                    result.propList_ = this.propListBuilder_.build();
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
                if (other instanceof SetPlayerPropReq) {
                    return mergeFrom((SetPlayerPropReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SetPlayerPropReq other) {
                if (other == SetPlayerPropReq.getDefaultInstance()) {
                    return this;
                }
                if (this.propListBuilder_ == null) {
                    if (!other.propList_.isEmpty()) {
                        if (this.propList_.isEmpty()) {
                            this.propList_ = other.propList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensurePropListIsMutable();
                            this.propList_.addAll(other.propList_);
                        }
                        onChanged();
                    }
                } else if (!other.propList_.isEmpty()) {
                    if (this.propListBuilder_.isEmpty()) {
                        this.propListBuilder_.dispose();
                        this.propListBuilder_ = null;
                        this.propList_ = other.propList_;
                        this.bitField0_ &= -2;
                        this.propListBuilder_ = SetPlayerPropReq.alwaysUseFieldBuilders ? getPropListFieldBuilder() : null;
                    } else {
                        this.propListBuilder_.addAllMessages(other.propList_);
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
                SetPlayerPropReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = SetPlayerPropReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SetPlayerPropReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensurePropListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.propList_ = new ArrayList(this.propList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SetPlayerPropReqOuterClass.SetPlayerPropReqOrBuilder
            public List<PropValueOuterClass.PropValue> getPropListList() {
                if (this.propListBuilder_ == null) {
                    return Collections.unmodifiableList(this.propList_);
                }
                return this.propListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SetPlayerPropReqOuterClass.SetPlayerPropReqOrBuilder
            public int getPropListCount() {
                if (this.propListBuilder_ == null) {
                    return this.propList_.size();
                }
                return this.propListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SetPlayerPropReqOuterClass.SetPlayerPropReqOrBuilder
            public PropValueOuterClass.PropValue getPropList(int index) {
                if (this.propListBuilder_ == null) {
                    return this.propList_.get(index);
                }
                return this.propListBuilder_.getMessage(index);
            }

            public Builder setPropList(int index, PropValueOuterClass.PropValue value) {
                if (this.propListBuilder_ != null) {
                    this.propListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePropListIsMutable();
                    this.propList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setPropList(int index, PropValueOuterClass.PropValue.Builder builderForValue) {
                if (this.propListBuilder_ == null) {
                    ensurePropListIsMutable();
                    this.propList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.propListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addPropList(PropValueOuterClass.PropValue value) {
                if (this.propListBuilder_ != null) {
                    this.propListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePropListIsMutable();
                    this.propList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addPropList(int index, PropValueOuterClass.PropValue value) {
                if (this.propListBuilder_ != null) {
                    this.propListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensurePropListIsMutable();
                    this.propList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addPropList(PropValueOuterClass.PropValue.Builder builderForValue) {
                if (this.propListBuilder_ == null) {
                    ensurePropListIsMutable();
                    this.propList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.propListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addPropList(int index, PropValueOuterClass.PropValue.Builder builderForValue) {
                if (this.propListBuilder_ == null) {
                    ensurePropListIsMutable();
                    this.propList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.propListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllPropList(Iterable<? extends PropValueOuterClass.PropValue> values) {
                if (this.propListBuilder_ == null) {
                    ensurePropListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.propList_);
                    onChanged();
                } else {
                    this.propListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearPropList() {
                if (this.propListBuilder_ == null) {
                    this.propList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.propListBuilder_.clear();
                }
                return this;
            }

            public Builder removePropList(int index) {
                if (this.propListBuilder_ == null) {
                    ensurePropListIsMutable();
                    this.propList_.remove(index);
                    onChanged();
                } else {
                    this.propListBuilder_.remove(index);
                }
                return this;
            }

            public PropValueOuterClass.PropValue.Builder getPropListBuilder(int index) {
                return getPropListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SetPlayerPropReqOuterClass.SetPlayerPropReqOrBuilder
            public PropValueOuterClass.PropValueOrBuilder getPropListOrBuilder(int index) {
                if (this.propListBuilder_ == null) {
                    return this.propList_.get(index);
                }
                return this.propListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SetPlayerPropReqOuterClass.SetPlayerPropReqOrBuilder
            public List<? extends PropValueOuterClass.PropValueOrBuilder> getPropListOrBuilderList() {
                if (this.propListBuilder_ != null) {
                    return this.propListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.propList_);
            }

            public PropValueOuterClass.PropValue.Builder addPropListBuilder() {
                return getPropListFieldBuilder().addBuilder(PropValueOuterClass.PropValue.getDefaultInstance());
            }

            public PropValueOuterClass.PropValue.Builder addPropListBuilder(int index) {
                return getPropListFieldBuilder().addBuilder(index, PropValueOuterClass.PropValue.getDefaultInstance());
            }

            public List<PropValueOuterClass.PropValue.Builder> getPropListBuilderList() {
                return getPropListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<PropValueOuterClass.PropValue, PropValueOuterClass.PropValue.Builder, PropValueOuterClass.PropValueOrBuilder> getPropListFieldBuilder() {
                if (this.propListBuilder_ == null) {
                    this.propListBuilder_ = new RepeatedFieldBuilderV3<>(this.propList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.propList_ = null;
                }
                return this.propListBuilder_;
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

        public static SetPlayerPropReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SetPlayerPropReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SetPlayerPropReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SetPlayerPropReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        PropValueOuterClass.getDescriptor();
    }
}
