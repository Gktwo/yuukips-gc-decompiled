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
import emu.grasscutter.net.proto.WidgetSlotDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetWidgetSlotRspOuterClass.class */
public final class GetWidgetSlotRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016GetWidgetSlotRsp.proto\u001a\u0014WidgetSlotData.proto\"F\n\u0010GetWidgetSlotRsp\u0012\u000f\n\u0007retcode\u0018\u000f \u0001(\u0005\u0012!\n\bslotList\u0018\r \u0003(\u000b2\u000f.WidgetSlotDataB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{WidgetSlotDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetWidgetSlotRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetWidgetSlotRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetWidgetSlotRsp_descriptor, new String[]{"Retcode", "SlotList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetWidgetSlotRspOuterClass$GetWidgetSlotRspOrBuilder.class */
    public interface GetWidgetSlotRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        List<WidgetSlotDataOuterClass.WidgetSlotData> getSlotListList();

        WidgetSlotDataOuterClass.WidgetSlotData getSlotList(int i);

        int getSlotListCount();

        List<? extends WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder> getSlotListOrBuilderList();

        WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder getSlotListOrBuilder(int i);
    }

    private GetWidgetSlotRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetWidgetSlotRspOuterClass$GetWidgetSlotRsp.class */
    public static final class GetWidgetSlotRsp extends GeneratedMessageV3 implements GetWidgetSlotRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 15;
        private int retcode_;
        public static final int SLOTLIST_FIELD_NUMBER = 13;
        private List<WidgetSlotDataOuterClass.WidgetSlotData> slotList_;
        private byte memoizedIsInitialized;
        private static final GetWidgetSlotRsp DEFAULT_INSTANCE = new GetWidgetSlotRsp();
        private static final Parser<GetWidgetSlotRsp> PARSER = new AbstractParser<GetWidgetSlotRsp>() { // from class: emu.grasscutter.net.proto.GetWidgetSlotRspOuterClass.GetWidgetSlotRsp.1
            @Override // com.google.protobuf.Parser
            public GetWidgetSlotRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetWidgetSlotRsp(input, extensionRegistry);
            }
        };

        private GetWidgetSlotRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetWidgetSlotRsp() {
            this.memoizedIsInitialized = -1;
            this.slotList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetWidgetSlotRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetWidgetSlotRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 106:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.slotList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.slotList_.add((WidgetSlotDataOuterClass.WidgetSlotData) input.readMessage(WidgetSlotDataOuterClass.WidgetSlotData.parser(), extensionRegistry));
                                    break;
                                case 120:
                                    this.retcode_ = input.readInt32();
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
                    this.slotList_ = Collections.unmodifiableList(this.slotList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetWidgetSlotRspOuterClass.internal_static_GetWidgetSlotRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetWidgetSlotRspOuterClass.internal_static_GetWidgetSlotRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetWidgetSlotRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetWidgetSlotRspOuterClass.GetWidgetSlotRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetWidgetSlotRspOuterClass.GetWidgetSlotRspOrBuilder
        public List<WidgetSlotDataOuterClass.WidgetSlotData> getSlotListList() {
            return this.slotList_;
        }

        @Override // emu.grasscutter.net.proto.GetWidgetSlotRspOuterClass.GetWidgetSlotRspOrBuilder
        public List<? extends WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder> getSlotListOrBuilderList() {
            return this.slotList_;
        }

        @Override // emu.grasscutter.net.proto.GetWidgetSlotRspOuterClass.GetWidgetSlotRspOrBuilder
        public int getSlotListCount() {
            return this.slotList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetWidgetSlotRspOuterClass.GetWidgetSlotRspOrBuilder
        public WidgetSlotDataOuterClass.WidgetSlotData getSlotList(int index) {
            return this.slotList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetWidgetSlotRspOuterClass.GetWidgetSlotRspOrBuilder
        public WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder getSlotListOrBuilder(int index) {
            return this.slotList_.get(index);
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
            for (int i = 0; i < this.slotList_.size(); i++) {
                output.writeMessage(13, this.slotList_.get(i));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(15, this.retcode_);
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
            for (int i = 0; i < this.slotList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.slotList_.get(i));
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(15, this.retcode_);
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
            if (!(obj instanceof GetWidgetSlotRsp)) {
                return equals(obj);
            }
            GetWidgetSlotRsp other = (GetWidgetSlotRsp) obj;
            return getRetcode() == other.getRetcode() && getSlotListList().equals(other.getSlotListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 15)) + getRetcode();
            if (getSlotListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getSlotListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetWidgetSlotRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetWidgetSlotRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetWidgetSlotRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetWidgetSlotRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetWidgetSlotRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetWidgetSlotRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetWidgetSlotRsp parseFrom(InputStream input) throws IOException {
            return (GetWidgetSlotRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetWidgetSlotRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetWidgetSlotRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetWidgetSlotRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetWidgetSlotRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetWidgetSlotRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetWidgetSlotRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetWidgetSlotRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetWidgetSlotRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetWidgetSlotRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetWidgetSlotRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetWidgetSlotRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetWidgetSlotRspOuterClass$GetWidgetSlotRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetWidgetSlotRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private List<WidgetSlotDataOuterClass.WidgetSlotData> slotList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<WidgetSlotDataOuterClass.WidgetSlotData, WidgetSlotDataOuterClass.WidgetSlotData.Builder, WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder> slotListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetWidgetSlotRspOuterClass.internal_static_GetWidgetSlotRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetWidgetSlotRspOuterClass.internal_static_GetWidgetSlotRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetWidgetSlotRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetWidgetSlotRsp.alwaysUseFieldBuilders) {
                    getSlotListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                if (this.slotListBuilder_ == null) {
                    this.slotList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.slotListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetWidgetSlotRspOuterClass.internal_static_GetWidgetSlotRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetWidgetSlotRsp getDefaultInstanceForType() {
                return GetWidgetSlotRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetWidgetSlotRsp build() {
                GetWidgetSlotRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetWidgetSlotRsp buildPartial() {
                GetWidgetSlotRsp result = new GetWidgetSlotRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                if (this.slotListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.slotList_ = Collections.unmodifiableList(this.slotList_);
                        this.bitField0_ &= -2;
                    }
                    result.slotList_ = this.slotList_;
                } else {
                    result.slotList_ = this.slotListBuilder_.build();
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
                if (other instanceof GetWidgetSlotRsp) {
                    return mergeFrom((GetWidgetSlotRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetWidgetSlotRsp other) {
                if (other == GetWidgetSlotRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (this.slotListBuilder_ == null) {
                    if (!other.slotList_.isEmpty()) {
                        if (this.slotList_.isEmpty()) {
                            this.slotList_ = other.slotList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureSlotListIsMutable();
                            this.slotList_.addAll(other.slotList_);
                        }
                        onChanged();
                    }
                } else if (!other.slotList_.isEmpty()) {
                    if (this.slotListBuilder_.isEmpty()) {
                        this.slotListBuilder_.dispose();
                        this.slotListBuilder_ = null;
                        this.slotList_ = other.slotList_;
                        this.bitField0_ &= -2;
                        this.slotListBuilder_ = GetWidgetSlotRsp.alwaysUseFieldBuilders ? getSlotListFieldBuilder() : null;
                    } else {
                        this.slotListBuilder_.addAllMessages(other.slotList_);
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
                GetWidgetSlotRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetWidgetSlotRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetWidgetSlotRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.GetWidgetSlotRspOuterClass.GetWidgetSlotRspOrBuilder
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

            private void ensureSlotListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.slotList_ = new ArrayList(this.slotList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetWidgetSlotRspOuterClass.GetWidgetSlotRspOrBuilder
            public List<WidgetSlotDataOuterClass.WidgetSlotData> getSlotListList() {
                if (this.slotListBuilder_ == null) {
                    return Collections.unmodifiableList(this.slotList_);
                }
                return this.slotListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetWidgetSlotRspOuterClass.GetWidgetSlotRspOrBuilder
            public int getSlotListCount() {
                if (this.slotListBuilder_ == null) {
                    return this.slotList_.size();
                }
                return this.slotListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetWidgetSlotRspOuterClass.GetWidgetSlotRspOrBuilder
            public WidgetSlotDataOuterClass.WidgetSlotData getSlotList(int index) {
                if (this.slotListBuilder_ == null) {
                    return this.slotList_.get(index);
                }
                return this.slotListBuilder_.getMessage(index);
            }

            public Builder setSlotList(int index, WidgetSlotDataOuterClass.WidgetSlotData value) {
                if (this.slotListBuilder_ != null) {
                    this.slotListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSlotListIsMutable();
                    this.slotList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setSlotList(int index, WidgetSlotDataOuterClass.WidgetSlotData.Builder builderForValue) {
                if (this.slotListBuilder_ == null) {
                    ensureSlotListIsMutable();
                    this.slotList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.slotListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSlotList(WidgetSlotDataOuterClass.WidgetSlotData value) {
                if (this.slotListBuilder_ != null) {
                    this.slotListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSlotListIsMutable();
                    this.slotList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addSlotList(int index, WidgetSlotDataOuterClass.WidgetSlotData value) {
                if (this.slotListBuilder_ != null) {
                    this.slotListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSlotListIsMutable();
                    this.slotList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addSlotList(WidgetSlotDataOuterClass.WidgetSlotData.Builder builderForValue) {
                if (this.slotListBuilder_ == null) {
                    ensureSlotListIsMutable();
                    this.slotList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.slotListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSlotList(int index, WidgetSlotDataOuterClass.WidgetSlotData.Builder builderForValue) {
                if (this.slotListBuilder_ == null) {
                    ensureSlotListIsMutable();
                    this.slotList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.slotListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSlotList(Iterable<? extends WidgetSlotDataOuterClass.WidgetSlotData> values) {
                if (this.slotListBuilder_ == null) {
                    ensureSlotListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.slotList_);
                    onChanged();
                } else {
                    this.slotListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSlotList() {
                if (this.slotListBuilder_ == null) {
                    this.slotList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.slotListBuilder_.clear();
                }
                return this;
            }

            public Builder removeSlotList(int index) {
                if (this.slotListBuilder_ == null) {
                    ensureSlotListIsMutable();
                    this.slotList_.remove(index);
                    onChanged();
                } else {
                    this.slotListBuilder_.remove(index);
                }
                return this;
            }

            public WidgetSlotDataOuterClass.WidgetSlotData.Builder getSlotListBuilder(int index) {
                return getSlotListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetWidgetSlotRspOuterClass.GetWidgetSlotRspOrBuilder
            public WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder getSlotListOrBuilder(int index) {
                if (this.slotListBuilder_ == null) {
                    return this.slotList_.get(index);
                }
                return this.slotListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetWidgetSlotRspOuterClass.GetWidgetSlotRspOrBuilder
            public List<? extends WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder> getSlotListOrBuilderList() {
                if (this.slotListBuilder_ != null) {
                    return this.slotListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.slotList_);
            }

            public WidgetSlotDataOuterClass.WidgetSlotData.Builder addSlotListBuilder() {
                return getSlotListFieldBuilder().addBuilder(WidgetSlotDataOuterClass.WidgetSlotData.getDefaultInstance());
            }

            public WidgetSlotDataOuterClass.WidgetSlotData.Builder addSlotListBuilder(int index) {
                return getSlotListFieldBuilder().addBuilder(index, WidgetSlotDataOuterClass.WidgetSlotData.getDefaultInstance());
            }

            public List<WidgetSlotDataOuterClass.WidgetSlotData.Builder> getSlotListBuilderList() {
                return getSlotListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<WidgetSlotDataOuterClass.WidgetSlotData, WidgetSlotDataOuterClass.WidgetSlotData.Builder, WidgetSlotDataOuterClass.WidgetSlotDataOrBuilder> getSlotListFieldBuilder() {
                if (this.slotListBuilder_ == null) {
                    this.slotListBuilder_ = new RepeatedFieldBuilderV3<>(this.slotList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.slotList_ = null;
                }
                return this.slotListBuilder_;
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

        public static GetWidgetSlotRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetWidgetSlotRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetWidgetSlotRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetWidgetSlotRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        WidgetSlotDataOuterClass.getDescriptor();
    }
}
