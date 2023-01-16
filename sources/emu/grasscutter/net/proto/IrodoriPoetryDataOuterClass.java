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
import emu.grasscutter.net.proto.IrodoriPoetryThemeDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriPoetryDataOuterClass.class */
public final class IrodoriPoetryDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0017IrodoriPoetryData.proto\u001a\u001cIrodoriPoetryThemeData.proto\"[\n\u0011IrodoriPoetryData\u00120\n\u000ftheme_data_list\u0018\u0002 \u0003(\u000b2\u0017.IrodoriPoetryThemeData\u0012\u0014\n\fcur_theme_id\u0018\f \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{IrodoriPoetryThemeDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_IrodoriPoetryData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_IrodoriPoetryData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_IrodoriPoetryData_descriptor, new String[]{"ThemeDataList", "CurThemeId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriPoetryDataOuterClass$IrodoriPoetryDataOrBuilder.class */
    public interface IrodoriPoetryDataOrBuilder extends MessageOrBuilder {
        List<IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData> getThemeDataListList();

        IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData getThemeDataList(int i);

        int getThemeDataListCount();

        List<? extends IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder> getThemeDataListOrBuilderList();

        IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder getThemeDataListOrBuilder(int i);

        int getCurThemeId();
    }

    private IrodoriPoetryDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriPoetryDataOuterClass$IrodoriPoetryData.class */
    public static final class IrodoriPoetryData extends GeneratedMessageV3 implements IrodoriPoetryDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int THEME_DATA_LIST_FIELD_NUMBER = 2;
        private List<IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData> themeDataList_;
        public static final int CUR_THEME_ID_FIELD_NUMBER = 12;
        private int curThemeId_;
        private byte memoizedIsInitialized;
        private static final IrodoriPoetryData DEFAULT_INSTANCE = new IrodoriPoetryData();
        private static final Parser<IrodoriPoetryData> PARSER = new AbstractParser<IrodoriPoetryData>() { // from class: emu.grasscutter.net.proto.IrodoriPoetryDataOuterClass.IrodoriPoetryData.1
            @Override // com.google.protobuf.Parser
            public IrodoriPoetryData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IrodoriPoetryData(input, extensionRegistry);
            }
        };

        private IrodoriPoetryData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private IrodoriPoetryData() {
            this.memoizedIsInitialized = -1;
            this.themeDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new IrodoriPoetryData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private IrodoriPoetryData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.themeDataList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.themeDataList_.add((IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData) input.readMessage(IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData.parser(), extensionRegistry));
                                    break;
                                case 96:
                                    this.curThemeId_ = input.readUInt32();
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
                    this.themeDataList_ = Collections.unmodifiableList(this.themeDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return IrodoriPoetryDataOuterClass.internal_static_IrodoriPoetryData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return IrodoriPoetryDataOuterClass.internal_static_IrodoriPoetryData_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriPoetryData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.IrodoriPoetryDataOuterClass.IrodoriPoetryDataOrBuilder
        public List<IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData> getThemeDataListList() {
            return this.themeDataList_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriPoetryDataOuterClass.IrodoriPoetryDataOrBuilder
        public List<? extends IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder> getThemeDataListOrBuilderList() {
            return this.themeDataList_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriPoetryDataOuterClass.IrodoriPoetryDataOrBuilder
        public int getThemeDataListCount() {
            return this.themeDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.IrodoriPoetryDataOuterClass.IrodoriPoetryDataOrBuilder
        public IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData getThemeDataList(int index) {
            return this.themeDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.IrodoriPoetryDataOuterClass.IrodoriPoetryDataOrBuilder
        public IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder getThemeDataListOrBuilder(int index) {
            return this.themeDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.IrodoriPoetryDataOuterClass.IrodoriPoetryDataOrBuilder
        public int getCurThemeId() {
            return this.curThemeId_;
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
            for (int i = 0; i < this.themeDataList_.size(); i++) {
                output.writeMessage(2, this.themeDataList_.get(i));
            }
            if (this.curThemeId_ != 0) {
                output.writeUInt32(12, this.curThemeId_);
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
            for (int i = 0; i < this.themeDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.themeDataList_.get(i));
            }
            if (this.curThemeId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.curThemeId_);
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
            if (!(obj instanceof IrodoriPoetryData)) {
                return equals(obj);
            }
            IrodoriPoetryData other = (IrodoriPoetryData) obj;
            return getThemeDataListList().equals(other.getThemeDataListList()) && getCurThemeId() == other.getCurThemeId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getThemeDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getThemeDataListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 12)) + getCurThemeId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static IrodoriPoetryData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriPoetryData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriPoetryData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriPoetryData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriPoetryData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriPoetryData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriPoetryData parseFrom(InputStream input) throws IOException {
            return (IrodoriPoetryData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriPoetryData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriPoetryData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriPoetryData parseDelimitedFrom(InputStream input) throws IOException {
            return (IrodoriPoetryData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static IrodoriPoetryData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriPoetryData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriPoetryData parseFrom(CodedInputStream input) throws IOException {
            return (IrodoriPoetryData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriPoetryData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriPoetryData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(IrodoriPoetryData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriPoetryDataOuterClass$IrodoriPoetryData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IrodoriPoetryDataOrBuilder {
            private int bitField0_;
            private List<IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData> themeDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData, IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData.Builder, IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder> themeDataListBuilder_;
            private int curThemeId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return IrodoriPoetryDataOuterClass.internal_static_IrodoriPoetryData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return IrodoriPoetryDataOuterClass.internal_static_IrodoriPoetryData_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriPoetryData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (IrodoriPoetryData.alwaysUseFieldBuilders) {
                    getThemeDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.themeDataListBuilder_ == null) {
                    this.themeDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.themeDataListBuilder_.clear();
                }
                this.curThemeId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return IrodoriPoetryDataOuterClass.internal_static_IrodoriPoetryData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public IrodoriPoetryData getDefaultInstanceForType() {
                return IrodoriPoetryData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriPoetryData build() {
                IrodoriPoetryData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriPoetryData buildPartial() {
                IrodoriPoetryData result = new IrodoriPoetryData(this);
                int i = this.bitField0_;
                if (this.themeDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.themeDataList_ = Collections.unmodifiableList(this.themeDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.themeDataList_ = this.themeDataList_;
                } else {
                    result.themeDataList_ = this.themeDataListBuilder_.build();
                }
                result.curThemeId_ = this.curThemeId_;
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
                if (other instanceof IrodoriPoetryData) {
                    return mergeFrom((IrodoriPoetryData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IrodoriPoetryData other) {
                if (other == IrodoriPoetryData.getDefaultInstance()) {
                    return this;
                }
                if (this.themeDataListBuilder_ == null) {
                    if (!other.themeDataList_.isEmpty()) {
                        if (this.themeDataList_.isEmpty()) {
                            this.themeDataList_ = other.themeDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureThemeDataListIsMutable();
                            this.themeDataList_.addAll(other.themeDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.themeDataList_.isEmpty()) {
                    if (this.themeDataListBuilder_.isEmpty()) {
                        this.themeDataListBuilder_.dispose();
                        this.themeDataListBuilder_ = null;
                        this.themeDataList_ = other.themeDataList_;
                        this.bitField0_ &= -2;
                        this.themeDataListBuilder_ = IrodoriPoetryData.alwaysUseFieldBuilders ? getThemeDataListFieldBuilder() : null;
                    } else {
                        this.themeDataListBuilder_.addAllMessages(other.themeDataList_);
                    }
                }
                if (other.getCurThemeId() != 0) {
                    setCurThemeId(other.getCurThemeId());
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
                IrodoriPoetryData parsedMessage = null;
                try {
                    try {
                        parsedMessage = IrodoriPoetryData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (IrodoriPoetryData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureThemeDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.themeDataList_ = new ArrayList(this.themeDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriPoetryDataOuterClass.IrodoriPoetryDataOrBuilder
            public List<IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData> getThemeDataListList() {
                if (this.themeDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.themeDataList_);
                }
                return this.themeDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.IrodoriPoetryDataOuterClass.IrodoriPoetryDataOrBuilder
            public int getThemeDataListCount() {
                if (this.themeDataListBuilder_ == null) {
                    return this.themeDataList_.size();
                }
                return this.themeDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.IrodoriPoetryDataOuterClass.IrodoriPoetryDataOrBuilder
            public IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData getThemeDataList(int index) {
                if (this.themeDataListBuilder_ == null) {
                    return this.themeDataList_.get(index);
                }
                return this.themeDataListBuilder_.getMessage(index);
            }

            public Builder setThemeDataList(int index, IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData value) {
                if (this.themeDataListBuilder_ != null) {
                    this.themeDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureThemeDataListIsMutable();
                    this.themeDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setThemeDataList(int index, IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData.Builder builderForValue) {
                if (this.themeDataListBuilder_ == null) {
                    ensureThemeDataListIsMutable();
                    this.themeDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.themeDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addThemeDataList(IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData value) {
                if (this.themeDataListBuilder_ != null) {
                    this.themeDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureThemeDataListIsMutable();
                    this.themeDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addThemeDataList(int index, IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData value) {
                if (this.themeDataListBuilder_ != null) {
                    this.themeDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureThemeDataListIsMutable();
                    this.themeDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addThemeDataList(IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData.Builder builderForValue) {
                if (this.themeDataListBuilder_ == null) {
                    ensureThemeDataListIsMutable();
                    this.themeDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.themeDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addThemeDataList(int index, IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData.Builder builderForValue) {
                if (this.themeDataListBuilder_ == null) {
                    ensureThemeDataListIsMutable();
                    this.themeDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.themeDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllThemeDataList(Iterable<? extends IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData> values) {
                if (this.themeDataListBuilder_ == null) {
                    ensureThemeDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.themeDataList_);
                    onChanged();
                } else {
                    this.themeDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearThemeDataList() {
                if (this.themeDataListBuilder_ == null) {
                    this.themeDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.themeDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeThemeDataList(int index) {
                if (this.themeDataListBuilder_ == null) {
                    ensureThemeDataListIsMutable();
                    this.themeDataList_.remove(index);
                    onChanged();
                } else {
                    this.themeDataListBuilder_.remove(index);
                }
                return this;
            }

            public IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData.Builder getThemeDataListBuilder(int index) {
                return getThemeDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.IrodoriPoetryDataOuterClass.IrodoriPoetryDataOrBuilder
            public IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder getThemeDataListOrBuilder(int index) {
                if (this.themeDataListBuilder_ == null) {
                    return this.themeDataList_.get(index);
                }
                return this.themeDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.IrodoriPoetryDataOuterClass.IrodoriPoetryDataOrBuilder
            public List<? extends IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder> getThemeDataListOrBuilderList() {
                if (this.themeDataListBuilder_ != null) {
                    return this.themeDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.themeDataList_);
            }

            public IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData.Builder addThemeDataListBuilder() {
                return getThemeDataListFieldBuilder().addBuilder(IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData.getDefaultInstance());
            }

            public IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData.Builder addThemeDataListBuilder(int index) {
                return getThemeDataListFieldBuilder().addBuilder(index, IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData.getDefaultInstance());
            }

            public List<IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData.Builder> getThemeDataListBuilderList() {
                return getThemeDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData, IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeData.Builder, IrodoriPoetryThemeDataOuterClass.IrodoriPoetryThemeDataOrBuilder> getThemeDataListFieldBuilder() {
                if (this.themeDataListBuilder_ == null) {
                    this.themeDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.themeDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.themeDataList_ = null;
                }
                return this.themeDataListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.IrodoriPoetryDataOuterClass.IrodoriPoetryDataOrBuilder
            public int getCurThemeId() {
                return this.curThemeId_;
            }

            public Builder setCurThemeId(int value) {
                this.curThemeId_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurThemeId() {
                this.curThemeId_ = 0;
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

        public static IrodoriPoetryData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<IrodoriPoetryData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<IrodoriPoetryData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public IrodoriPoetryData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        IrodoriPoetryThemeDataOuterClass.getDescriptor();
    }
}
