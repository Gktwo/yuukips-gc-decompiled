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
import emu.grasscutter.net.proto.FurnitureMakeHelpDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeHelpRspOuterClass.class */
public final class FurnitureMakeHelpRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aFurnitureMakeHelpRsp.proto\u001a\u001bFurnitureMakeHelpData.proto\"W\n\u0014FurnitureMakeHelpRsp\u0012.\n\u000ehelp_data_list\u0018\u0004 \u0003(\u000b2\u0016.FurnitureMakeHelpData\u0012\u000f\n\u0007retcode\u0018\u0003 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FurnitureMakeHelpDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FurnitureMakeHelpRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FurnitureMakeHelpRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FurnitureMakeHelpRsp_descriptor, new String[]{"HelpDataList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeHelpRspOuterClass$FurnitureMakeHelpRspOrBuilder.class */
    public interface FurnitureMakeHelpRspOrBuilder extends MessageOrBuilder {
        List<FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData> getHelpDataListList();

        FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData getHelpDataList(int i);

        int getHelpDataListCount();

        List<? extends FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpDataOrBuilder> getHelpDataListOrBuilderList();

        FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpDataOrBuilder getHelpDataListOrBuilder(int i);

        int getRetcode();
    }

    private FurnitureMakeHelpRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeHelpRspOuterClass$FurnitureMakeHelpRsp.class */
    public static final class FurnitureMakeHelpRsp extends GeneratedMessageV3 implements FurnitureMakeHelpRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int HELP_DATA_LIST_FIELD_NUMBER = 4;
        private List<FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData> helpDataList_;
        public static final int RETCODE_FIELD_NUMBER = 3;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final FurnitureMakeHelpRsp DEFAULT_INSTANCE = new FurnitureMakeHelpRsp();
        private static final Parser<FurnitureMakeHelpRsp> PARSER = new AbstractParser<FurnitureMakeHelpRsp>() { // from class: emu.grasscutter.net.proto.FurnitureMakeHelpRspOuterClass.FurnitureMakeHelpRsp.1
            @Override // com.google.protobuf.Parser
            public FurnitureMakeHelpRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FurnitureMakeHelpRsp(input, extensionRegistry);
            }
        };

        private FurnitureMakeHelpRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FurnitureMakeHelpRsp() {
            this.memoizedIsInitialized = -1;
            this.helpDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FurnitureMakeHelpRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FurnitureMakeHelpRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 24:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 34:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.helpDataList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.helpDataList_.add((FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData) input.readMessage(FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.parser(), extensionRegistry));
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
                    this.helpDataList_ = Collections.unmodifiableList(this.helpDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FurnitureMakeHelpRspOuterClass.internal_static_FurnitureMakeHelpRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FurnitureMakeHelpRspOuterClass.internal_static_FurnitureMakeHelpRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(FurnitureMakeHelpRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeHelpRspOuterClass.FurnitureMakeHelpRspOrBuilder
        public List<FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData> getHelpDataListList() {
            return this.helpDataList_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeHelpRspOuterClass.FurnitureMakeHelpRspOrBuilder
        public List<? extends FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpDataOrBuilder> getHelpDataListOrBuilderList() {
            return this.helpDataList_;
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeHelpRspOuterClass.FurnitureMakeHelpRspOrBuilder
        public int getHelpDataListCount() {
            return this.helpDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeHelpRspOuterClass.FurnitureMakeHelpRspOrBuilder
        public FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData getHelpDataList(int index) {
            return this.helpDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeHelpRspOuterClass.FurnitureMakeHelpRspOrBuilder
        public FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpDataOrBuilder getHelpDataListOrBuilder(int index) {
            return this.helpDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FurnitureMakeHelpRspOuterClass.FurnitureMakeHelpRspOrBuilder
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
            if (this.retcode_ != 0) {
                output.writeInt32(3, this.retcode_);
            }
            for (int i = 0; i < this.helpDataList_.size(); i++) {
                output.writeMessage(4, this.helpDataList_.get(i));
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
                size2 = 0 + CodedOutputStream.computeInt32Size(3, this.retcode_);
            }
            for (int i = 0; i < this.helpDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.helpDataList_.get(i));
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
            if (!(obj instanceof FurnitureMakeHelpRsp)) {
                return equals(obj);
            }
            FurnitureMakeHelpRsp other = (FurnitureMakeHelpRsp) obj;
            return getHelpDataListList().equals(other.getHelpDataListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getHelpDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getHelpDataListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 3)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FurnitureMakeHelpRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeHelpRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeHelpRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeHelpRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeHelpRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FurnitureMakeHelpRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FurnitureMakeHelpRsp parseFrom(InputStream input) throws IOException {
            return (FurnitureMakeHelpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureMakeHelpRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeHelpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureMakeHelpRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (FurnitureMakeHelpRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FurnitureMakeHelpRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeHelpRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FurnitureMakeHelpRsp parseFrom(CodedInputStream input) throws IOException {
            return (FurnitureMakeHelpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FurnitureMakeHelpRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FurnitureMakeHelpRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FurnitureMakeHelpRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FurnitureMakeHelpRspOuterClass$FurnitureMakeHelpRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FurnitureMakeHelpRspOrBuilder {
            private int bitField0_;
            private List<FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData> helpDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData, FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.Builder, FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpDataOrBuilder> helpDataListBuilder_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FurnitureMakeHelpRspOuterClass.internal_static_FurnitureMakeHelpRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FurnitureMakeHelpRspOuterClass.internal_static_FurnitureMakeHelpRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(FurnitureMakeHelpRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FurnitureMakeHelpRsp.alwaysUseFieldBuilders) {
                    getHelpDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.helpDataListBuilder_ == null) {
                    this.helpDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.helpDataListBuilder_.clear();
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FurnitureMakeHelpRspOuterClass.internal_static_FurnitureMakeHelpRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FurnitureMakeHelpRsp getDefaultInstanceForType() {
                return FurnitureMakeHelpRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureMakeHelpRsp build() {
                FurnitureMakeHelpRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FurnitureMakeHelpRsp buildPartial() {
                FurnitureMakeHelpRsp result = new FurnitureMakeHelpRsp(this);
                int i = this.bitField0_;
                if (this.helpDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.helpDataList_ = Collections.unmodifiableList(this.helpDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.helpDataList_ = this.helpDataList_;
                } else {
                    result.helpDataList_ = this.helpDataListBuilder_.build();
                }
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
                if (other instanceof FurnitureMakeHelpRsp) {
                    return mergeFrom((FurnitureMakeHelpRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FurnitureMakeHelpRsp other) {
                if (other == FurnitureMakeHelpRsp.getDefaultInstance()) {
                    return this;
                }
                if (this.helpDataListBuilder_ == null) {
                    if (!other.helpDataList_.isEmpty()) {
                        if (this.helpDataList_.isEmpty()) {
                            this.helpDataList_ = other.helpDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureHelpDataListIsMutable();
                            this.helpDataList_.addAll(other.helpDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.helpDataList_.isEmpty()) {
                    if (this.helpDataListBuilder_.isEmpty()) {
                        this.helpDataListBuilder_.dispose();
                        this.helpDataListBuilder_ = null;
                        this.helpDataList_ = other.helpDataList_;
                        this.bitField0_ &= -2;
                        this.helpDataListBuilder_ = FurnitureMakeHelpRsp.alwaysUseFieldBuilders ? getHelpDataListFieldBuilder() : null;
                    } else {
                        this.helpDataListBuilder_.addAllMessages(other.helpDataList_);
                    }
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
                FurnitureMakeHelpRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = FurnitureMakeHelpRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FurnitureMakeHelpRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureHelpDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.helpDataList_ = new ArrayList(this.helpDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeHelpRspOuterClass.FurnitureMakeHelpRspOrBuilder
            public List<FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData> getHelpDataListList() {
                if (this.helpDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.helpDataList_);
                }
                return this.helpDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeHelpRspOuterClass.FurnitureMakeHelpRspOrBuilder
            public int getHelpDataListCount() {
                if (this.helpDataListBuilder_ == null) {
                    return this.helpDataList_.size();
                }
                return this.helpDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeHelpRspOuterClass.FurnitureMakeHelpRspOrBuilder
            public FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData getHelpDataList(int index) {
                if (this.helpDataListBuilder_ == null) {
                    return this.helpDataList_.get(index);
                }
                return this.helpDataListBuilder_.getMessage(index);
            }

            public Builder setHelpDataList(int index, FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData value) {
                if (this.helpDataListBuilder_ != null) {
                    this.helpDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureHelpDataListIsMutable();
                    this.helpDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setHelpDataList(int index, FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.Builder builderForValue) {
                if (this.helpDataListBuilder_ == null) {
                    ensureHelpDataListIsMutable();
                    this.helpDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.helpDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addHelpDataList(FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData value) {
                if (this.helpDataListBuilder_ != null) {
                    this.helpDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureHelpDataListIsMutable();
                    this.helpDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addHelpDataList(int index, FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData value) {
                if (this.helpDataListBuilder_ != null) {
                    this.helpDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureHelpDataListIsMutable();
                    this.helpDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addHelpDataList(FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.Builder builderForValue) {
                if (this.helpDataListBuilder_ == null) {
                    ensureHelpDataListIsMutable();
                    this.helpDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.helpDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addHelpDataList(int index, FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.Builder builderForValue) {
                if (this.helpDataListBuilder_ == null) {
                    ensureHelpDataListIsMutable();
                    this.helpDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.helpDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllHelpDataList(Iterable<? extends FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData> values) {
                if (this.helpDataListBuilder_ == null) {
                    ensureHelpDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.helpDataList_);
                    onChanged();
                } else {
                    this.helpDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearHelpDataList() {
                if (this.helpDataListBuilder_ == null) {
                    this.helpDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.helpDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeHelpDataList(int index) {
                if (this.helpDataListBuilder_ == null) {
                    ensureHelpDataListIsMutable();
                    this.helpDataList_.remove(index);
                    onChanged();
                } else {
                    this.helpDataListBuilder_.remove(index);
                }
                return this;
            }

            public FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.Builder getHelpDataListBuilder(int index) {
                return getHelpDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeHelpRspOuterClass.FurnitureMakeHelpRspOrBuilder
            public FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpDataOrBuilder getHelpDataListOrBuilder(int index) {
                if (this.helpDataListBuilder_ == null) {
                    return this.helpDataList_.get(index);
                }
                return this.helpDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeHelpRspOuterClass.FurnitureMakeHelpRspOrBuilder
            public List<? extends FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpDataOrBuilder> getHelpDataListOrBuilderList() {
                if (this.helpDataListBuilder_ != null) {
                    return this.helpDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.helpDataList_);
            }

            public FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.Builder addHelpDataListBuilder() {
                return getHelpDataListFieldBuilder().addBuilder(FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.getDefaultInstance());
            }

            public FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.Builder addHelpDataListBuilder(int index) {
                return getHelpDataListFieldBuilder().addBuilder(index, FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.getDefaultInstance());
            }

            public List<FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.Builder> getHelpDataListBuilderList() {
                return getHelpDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData, FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpData.Builder, FurnitureMakeHelpDataOuterClass.FurnitureMakeHelpDataOrBuilder> getHelpDataListFieldBuilder() {
                if (this.helpDataListBuilder_ == null) {
                    this.helpDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.helpDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.helpDataList_ = null;
                }
                return this.helpDataListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.FurnitureMakeHelpRspOuterClass.FurnitureMakeHelpRspOrBuilder
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

        public static FurnitureMakeHelpRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FurnitureMakeHelpRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FurnitureMakeHelpRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FurnitureMakeHelpRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FurnitureMakeHelpDataOuterClass.getDescriptor();
    }
}
