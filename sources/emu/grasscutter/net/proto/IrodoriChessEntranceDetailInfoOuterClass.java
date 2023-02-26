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
import emu.grasscutter.net.proto.IrodoriChessEntranceInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEntranceDetailInfoOuterClass.class */
public final class IrodoriChessEntranceDetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$IrodoriChessEntranceDetailInfo.proto\u001a\u001eIrodoriChessEntranceInfo.proto\"M\n\u001eIrodoriChessEntranceDetailInfo\u0012+\n\binfoList\u0018\u0002 \u0003(\u000b2\u0019.IrodoriChessEntranceInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{IrodoriChessEntranceInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_IrodoriChessEntranceDetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_IrodoriChessEntranceDetailInfo_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f751x7626b70 = new GeneratedMessageV3.FieldAccessorTable(internal_static_IrodoriChessEntranceDetailInfo_descriptor, new String[]{"InfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEntranceDetailInfoOuterClass$IrodoriChessEntranceDetailInfoOrBuilder.class */
    public interface IrodoriChessEntranceDetailInfoOrBuilder extends MessageOrBuilder {
        List<IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo> getInfoListList();

        IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo getInfoList(int i);

        int getInfoListCount();

        List<? extends IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder> getInfoListOrBuilderList();

        IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder getInfoListOrBuilder(int i);
    }

    private IrodoriChessEntranceDetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEntranceDetailInfoOuterClass$IrodoriChessEntranceDetailInfo.class */
    public static final class IrodoriChessEntranceDetailInfo extends GeneratedMessageV3 implements IrodoriChessEntranceDetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int INFOLIST_FIELD_NUMBER = 2;
        private List<IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo> infoList_;
        private byte memoizedIsInitialized;
        private static final IrodoriChessEntranceDetailInfo DEFAULT_INSTANCE = new IrodoriChessEntranceDetailInfo();
        private static final Parser<IrodoriChessEntranceDetailInfo> PARSER = new AbstractParser<IrodoriChessEntranceDetailInfo>() { // from class: emu.grasscutter.net.proto.IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo.1
            @Override // com.google.protobuf.Parser
            public IrodoriChessEntranceDetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IrodoriChessEntranceDetailInfo(input, extensionRegistry);
            }
        };

        private IrodoriChessEntranceDetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private IrodoriChessEntranceDetailInfo() {
            this.memoizedIsInitialized = -1;
            this.infoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new IrodoriChessEntranceDetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private IrodoriChessEntranceDetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 18:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.infoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.infoList_.add((IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo) input.readMessage(IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo.parser(), extensionRegistry));
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
                    this.infoList_ = Collections.unmodifiableList(this.infoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return IrodoriChessEntranceDetailInfoOuterClass.internal_static_IrodoriChessEntranceDetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return IrodoriChessEntranceDetailInfoOuterClass.f751x7626b70.ensureFieldAccessorsInitialized(IrodoriChessEntranceDetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfoOrBuilder
        public List<IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo> getInfoListList() {
            return this.infoList_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfoOrBuilder
        public List<? extends IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder> getInfoListOrBuilderList() {
            return this.infoList_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfoOrBuilder
        public int getInfoListCount() {
            return this.infoList_.size();
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfoOrBuilder
        public IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo getInfoList(int index) {
            return this.infoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfoOrBuilder
        public IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder getInfoListOrBuilder(int index) {
            return this.infoList_.get(index);
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
            for (int i = 0; i < this.infoList_.size(); i++) {
                output.writeMessage(2, this.infoList_.get(i));
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
            for (int i = 0; i < this.infoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.infoList_.get(i));
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
            if (!(obj instanceof IrodoriChessEntranceDetailInfo)) {
                return equals(obj);
            }
            IrodoriChessEntranceDetailInfo other = (IrodoriChessEntranceDetailInfo) obj;
            return getInfoListList().equals(other.getInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getInfoListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static IrodoriChessEntranceDetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessEntranceDetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessEntranceDetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessEntranceDetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessEntranceDetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessEntranceDetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessEntranceDetailInfo parseFrom(InputStream input) throws IOException {
            return (IrodoriChessEntranceDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriChessEntranceDetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessEntranceDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriChessEntranceDetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (IrodoriChessEntranceDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static IrodoriChessEntranceDetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessEntranceDetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriChessEntranceDetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (IrodoriChessEntranceDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriChessEntranceDetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessEntranceDetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(IrodoriChessEntranceDetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessEntranceDetailInfoOuterClass$IrodoriChessEntranceDetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IrodoriChessEntranceDetailInfoOrBuilder {
            private int bitField0_;
            private List<IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo> infoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo, IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo.Builder, IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder> infoListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return IrodoriChessEntranceDetailInfoOuterClass.internal_static_IrodoriChessEntranceDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return IrodoriChessEntranceDetailInfoOuterClass.f751x7626b70.ensureFieldAccessorsInitialized(IrodoriChessEntranceDetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (IrodoriChessEntranceDetailInfo.alwaysUseFieldBuilders) {
                    getInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.infoListBuilder_ == null) {
                    this.infoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.infoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return IrodoriChessEntranceDetailInfoOuterClass.internal_static_IrodoriChessEntranceDetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public IrodoriChessEntranceDetailInfo getDefaultInstanceForType() {
                return IrodoriChessEntranceDetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriChessEntranceDetailInfo build() {
                IrodoriChessEntranceDetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriChessEntranceDetailInfo buildPartial() {
                IrodoriChessEntranceDetailInfo result = new IrodoriChessEntranceDetailInfo(this);
                int i = this.bitField0_;
                if (this.infoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.infoList_ = Collections.unmodifiableList(this.infoList_);
                        this.bitField0_ &= -2;
                    }
                    result.infoList_ = this.infoList_;
                } else {
                    result.infoList_ = this.infoListBuilder_.build();
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
                if (other instanceof IrodoriChessEntranceDetailInfo) {
                    return mergeFrom((IrodoriChessEntranceDetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IrodoriChessEntranceDetailInfo other) {
                if (other == IrodoriChessEntranceDetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.infoListBuilder_ == null) {
                    if (!other.infoList_.isEmpty()) {
                        if (this.infoList_.isEmpty()) {
                            this.infoList_ = other.infoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureInfoListIsMutable();
                            this.infoList_.addAll(other.infoList_);
                        }
                        onChanged();
                    }
                } else if (!other.infoList_.isEmpty()) {
                    if (this.infoListBuilder_.isEmpty()) {
                        this.infoListBuilder_.dispose();
                        this.infoListBuilder_ = null;
                        this.infoList_ = other.infoList_;
                        this.bitField0_ &= -2;
                        this.infoListBuilder_ = IrodoriChessEntranceDetailInfo.alwaysUseFieldBuilders ? getInfoListFieldBuilder() : null;
                    } else {
                        this.infoListBuilder_.addAllMessages(other.infoList_);
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
                IrodoriChessEntranceDetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = IrodoriChessEntranceDetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (IrodoriChessEntranceDetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.infoList_ = new ArrayList(this.infoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfoOrBuilder
            public List<IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo> getInfoListList() {
                if (this.infoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.infoList_);
                }
                return this.infoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfoOrBuilder
            public int getInfoListCount() {
                if (this.infoListBuilder_ == null) {
                    return this.infoList_.size();
                }
                return this.infoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfoOrBuilder
            public IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo getInfoList(int index) {
                if (this.infoListBuilder_ == null) {
                    return this.infoList_.get(index);
                }
                return this.infoListBuilder_.getMessage(index);
            }

            public Builder setInfoList(int index, IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo value) {
                if (this.infoListBuilder_ != null) {
                    this.infoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInfoListIsMutable();
                    this.infoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setInfoList(int index, IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo.Builder builderForValue) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    this.infoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.infoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addInfoList(IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo value) {
                if (this.infoListBuilder_ != null) {
                    this.infoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInfoListIsMutable();
                    this.infoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addInfoList(int index, IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo value) {
                if (this.infoListBuilder_ != null) {
                    this.infoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureInfoListIsMutable();
                    this.infoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addInfoList(IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo.Builder builderForValue) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    this.infoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.infoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addInfoList(int index, IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo.Builder builderForValue) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    this.infoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.infoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllInfoList(Iterable<? extends IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo> values) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.infoList_);
                    onChanged();
                } else {
                    this.infoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearInfoList() {
                if (this.infoListBuilder_ == null) {
                    this.infoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.infoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeInfoList(int index) {
                if (this.infoListBuilder_ == null) {
                    ensureInfoListIsMutable();
                    this.infoList_.remove(index);
                    onChanged();
                } else {
                    this.infoListBuilder_.remove(index);
                }
                return this;
            }

            public IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo.Builder getInfoListBuilder(int index) {
                return getInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfoOrBuilder
            public IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder getInfoListOrBuilder(int index) {
                if (this.infoListBuilder_ == null) {
                    return this.infoList_.get(index);
                }
                return this.infoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfoOrBuilder
            public List<? extends IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder> getInfoListOrBuilderList() {
                if (this.infoListBuilder_ != null) {
                    return this.infoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.infoList_);
            }

            public IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo.Builder addInfoListBuilder() {
                return getInfoListFieldBuilder().addBuilder(IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo.getDefaultInstance());
            }

            public IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo.Builder addInfoListBuilder(int index) {
                return getInfoListFieldBuilder().addBuilder(index, IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo.getDefaultInstance());
            }

            public List<IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo.Builder> getInfoListBuilderList() {
                return getInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo, IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfo.Builder, IrodoriChessEntranceInfoOuterClass.IrodoriChessEntranceInfoOrBuilder> getInfoListFieldBuilder() {
                if (this.infoListBuilder_ == null) {
                    this.infoListBuilder_ = new RepeatedFieldBuilderV3<>(this.infoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.infoList_ = null;
                }
                return this.infoListBuilder_;
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

        public static IrodoriChessEntranceDetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<IrodoriChessEntranceDetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<IrodoriChessEntranceDetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public IrodoriChessEntranceDetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        IrodoriChessEntranceInfoOuterClass.getDescriptor();
    }
}
