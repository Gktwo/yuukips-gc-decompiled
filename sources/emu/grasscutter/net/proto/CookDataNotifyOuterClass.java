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
import emu.grasscutter.net.proto.CookRecipeDataOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CookDataNotifyOuterClass.class */
public final class CookDataNotifyOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0014CookDataNotify.proto\u001a\u0014CookRecipeData.proto\"J\n\u000eCookDataNotify\u0012)\n\u0010recipe_data_list\u0018\u000f \u0003(\u000b2\u000f.CookRecipeData\u0012\r\n\u0005grade\u0018\t \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CookRecipeDataOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CookDataNotify_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_CookDataNotify_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_CookDataNotify_descriptor, new String[]{"RecipeDataList", "Grade"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CookDataNotifyOuterClass$CookDataNotifyOrBuilder.class */
    public interface CookDataNotifyOrBuilder extends MessageOrBuilder {
        List<CookRecipeDataOuterClass.CookRecipeData> getRecipeDataListList();

        CookRecipeDataOuterClass.CookRecipeData getRecipeDataList(int i);

        int getRecipeDataListCount();

        List<? extends CookRecipeDataOuterClass.CookRecipeDataOrBuilder> getRecipeDataListOrBuilderList();

        CookRecipeDataOuterClass.CookRecipeDataOrBuilder getRecipeDataListOrBuilder(int i);

        int getGrade();
    }

    private CookDataNotifyOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CookDataNotifyOuterClass$CookDataNotify.class */
    public static final class CookDataNotify extends GeneratedMessageV3 implements CookDataNotifyOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RECIPE_DATA_LIST_FIELD_NUMBER = 15;
        private List<CookRecipeDataOuterClass.CookRecipeData> recipeDataList_;
        public static final int GRADE_FIELD_NUMBER = 9;
        private int grade_;
        private byte memoizedIsInitialized;
        private static final CookDataNotify DEFAULT_INSTANCE = new CookDataNotify();
        private static final Parser<CookDataNotify> PARSER = new AbstractParser<CookDataNotify>() { // from class: emu.grasscutter.net.proto.CookDataNotifyOuterClass.CookDataNotify.1
            @Override // com.google.protobuf.Parser
            public CookDataNotify parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CookDataNotify(input, extensionRegistry);
            }
        };

        private CookDataNotify(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CookDataNotify() {
            this.memoizedIsInitialized = -1;
            this.recipeDataList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CookDataNotify();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CookDataNotify(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 72:
                                    this.grade_ = input.readUInt32();
                                    break;
                                case 122:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.recipeDataList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.recipeDataList_.add((CookRecipeDataOuterClass.CookRecipeData) input.readMessage(CookRecipeDataOuterClass.CookRecipeData.parser(), extensionRegistry));
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
                    this.recipeDataList_ = Collections.unmodifiableList(this.recipeDataList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return CookDataNotifyOuterClass.internal_static_CookDataNotify_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CookDataNotifyOuterClass.internal_static_CookDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CookDataNotify.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CookDataNotifyOuterClass.CookDataNotifyOrBuilder
        public List<CookRecipeDataOuterClass.CookRecipeData> getRecipeDataListList() {
            return this.recipeDataList_;
        }

        @Override // emu.grasscutter.net.proto.CookDataNotifyOuterClass.CookDataNotifyOrBuilder
        public List<? extends CookRecipeDataOuterClass.CookRecipeDataOrBuilder> getRecipeDataListOrBuilderList() {
            return this.recipeDataList_;
        }

        @Override // emu.grasscutter.net.proto.CookDataNotifyOuterClass.CookDataNotifyOrBuilder
        public int getRecipeDataListCount() {
            return this.recipeDataList_.size();
        }

        @Override // emu.grasscutter.net.proto.CookDataNotifyOuterClass.CookDataNotifyOrBuilder
        public CookRecipeDataOuterClass.CookRecipeData getRecipeDataList(int index) {
            return this.recipeDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CookDataNotifyOuterClass.CookDataNotifyOrBuilder
        public CookRecipeDataOuterClass.CookRecipeDataOrBuilder getRecipeDataListOrBuilder(int index) {
            return this.recipeDataList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CookDataNotifyOuterClass.CookDataNotifyOrBuilder
        public int getGrade() {
            return this.grade_;
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
            if (this.grade_ != 0) {
                output.writeUInt32(9, this.grade_);
            }
            for (int i = 0; i < this.recipeDataList_.size(); i++) {
                output.writeMessage(15, this.recipeDataList_.get(i));
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
            if (this.grade_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(9, this.grade_);
            }
            for (int i = 0; i < this.recipeDataList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(15, this.recipeDataList_.get(i));
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
            if (!(obj instanceof CookDataNotify)) {
                return equals(obj);
            }
            CookDataNotify other = (CookDataNotify) obj;
            return getRecipeDataListList().equals(other.getRecipeDataListList()) && getGrade() == other.getGrade() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getRecipeDataListCount() > 0) {
                hash = (53 * ((37 * hash) + 15)) + getRecipeDataListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 9)) + getGrade())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CookDataNotify parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CookDataNotify parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CookDataNotify parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CookDataNotify parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CookDataNotify parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CookDataNotify parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CookDataNotify parseFrom(InputStream input) throws IOException {
            return (CookDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CookDataNotify parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CookDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CookDataNotify parseDelimitedFrom(InputStream input) throws IOException {
            return (CookDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CookDataNotify parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CookDataNotify) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CookDataNotify parseFrom(CodedInputStream input) throws IOException {
            return (CookDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CookDataNotify parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CookDataNotify) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CookDataNotify prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CookDataNotifyOuterClass$CookDataNotify$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CookDataNotifyOrBuilder {
            private int bitField0_;
            private List<CookRecipeDataOuterClass.CookRecipeData> recipeDataList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<CookRecipeDataOuterClass.CookRecipeData, CookRecipeDataOuterClass.CookRecipeData.Builder, CookRecipeDataOuterClass.CookRecipeDataOrBuilder> recipeDataListBuilder_;
            private int grade_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CookDataNotifyOuterClass.internal_static_CookDataNotify_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CookDataNotifyOuterClass.internal_static_CookDataNotify_fieldAccessorTable.ensureFieldAccessorsInitialized(CookDataNotify.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CookDataNotify.alwaysUseFieldBuilders) {
                    getRecipeDataListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.recipeDataListBuilder_ == null) {
                    this.recipeDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.recipeDataListBuilder_.clear();
                }
                this.grade_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CookDataNotifyOuterClass.internal_static_CookDataNotify_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CookDataNotify getDefaultInstanceForType() {
                return CookDataNotify.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CookDataNotify build() {
                CookDataNotify result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CookDataNotify buildPartial() {
                CookDataNotify result = new CookDataNotify(this);
                int i = this.bitField0_;
                if (this.recipeDataListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.recipeDataList_ = Collections.unmodifiableList(this.recipeDataList_);
                        this.bitField0_ &= -2;
                    }
                    result.recipeDataList_ = this.recipeDataList_;
                } else {
                    result.recipeDataList_ = this.recipeDataListBuilder_.build();
                }
                result.grade_ = this.grade_;
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
                if (other instanceof CookDataNotify) {
                    return mergeFrom((CookDataNotify) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CookDataNotify other) {
                if (other == CookDataNotify.getDefaultInstance()) {
                    return this;
                }
                if (this.recipeDataListBuilder_ == null) {
                    if (!other.recipeDataList_.isEmpty()) {
                        if (this.recipeDataList_.isEmpty()) {
                            this.recipeDataList_ = other.recipeDataList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureRecipeDataListIsMutable();
                            this.recipeDataList_.addAll(other.recipeDataList_);
                        }
                        onChanged();
                    }
                } else if (!other.recipeDataList_.isEmpty()) {
                    if (this.recipeDataListBuilder_.isEmpty()) {
                        this.recipeDataListBuilder_.dispose();
                        this.recipeDataListBuilder_ = null;
                        this.recipeDataList_ = other.recipeDataList_;
                        this.bitField0_ &= -2;
                        this.recipeDataListBuilder_ = CookDataNotify.alwaysUseFieldBuilders ? getRecipeDataListFieldBuilder() : null;
                    } else {
                        this.recipeDataListBuilder_.addAllMessages(other.recipeDataList_);
                    }
                }
                if (other.getGrade() != 0) {
                    setGrade(other.getGrade());
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
                CookDataNotify parsedMessage = null;
                try {
                    try {
                        parsedMessage = CookDataNotify.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CookDataNotify) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureRecipeDataListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.recipeDataList_ = new ArrayList(this.recipeDataList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CookDataNotifyOuterClass.CookDataNotifyOrBuilder
            public List<CookRecipeDataOuterClass.CookRecipeData> getRecipeDataListList() {
                if (this.recipeDataListBuilder_ == null) {
                    return Collections.unmodifiableList(this.recipeDataList_);
                }
                return this.recipeDataListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CookDataNotifyOuterClass.CookDataNotifyOrBuilder
            public int getRecipeDataListCount() {
                if (this.recipeDataListBuilder_ == null) {
                    return this.recipeDataList_.size();
                }
                return this.recipeDataListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CookDataNotifyOuterClass.CookDataNotifyOrBuilder
            public CookRecipeDataOuterClass.CookRecipeData getRecipeDataList(int index) {
                if (this.recipeDataListBuilder_ == null) {
                    return this.recipeDataList_.get(index);
                }
                return this.recipeDataListBuilder_.getMessage(index);
            }

            public Builder setRecipeDataList(int index, CookRecipeDataOuterClass.CookRecipeData value) {
                if (this.recipeDataListBuilder_ != null) {
                    this.recipeDataListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRecipeDataListIsMutable();
                    this.recipeDataList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setRecipeDataList(int index, CookRecipeDataOuterClass.CookRecipeData.Builder builderForValue) {
                if (this.recipeDataListBuilder_ == null) {
                    ensureRecipeDataListIsMutable();
                    this.recipeDataList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.recipeDataListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addRecipeDataList(CookRecipeDataOuterClass.CookRecipeData value) {
                if (this.recipeDataListBuilder_ != null) {
                    this.recipeDataListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRecipeDataListIsMutable();
                    this.recipeDataList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addRecipeDataList(int index, CookRecipeDataOuterClass.CookRecipeData value) {
                if (this.recipeDataListBuilder_ != null) {
                    this.recipeDataListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureRecipeDataListIsMutable();
                    this.recipeDataList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addRecipeDataList(CookRecipeDataOuterClass.CookRecipeData.Builder builderForValue) {
                if (this.recipeDataListBuilder_ == null) {
                    ensureRecipeDataListIsMutable();
                    this.recipeDataList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.recipeDataListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addRecipeDataList(int index, CookRecipeDataOuterClass.CookRecipeData.Builder builderForValue) {
                if (this.recipeDataListBuilder_ == null) {
                    ensureRecipeDataListIsMutable();
                    this.recipeDataList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.recipeDataListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllRecipeDataList(Iterable<? extends CookRecipeDataOuterClass.CookRecipeData> values) {
                if (this.recipeDataListBuilder_ == null) {
                    ensureRecipeDataListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.recipeDataList_);
                    onChanged();
                } else {
                    this.recipeDataListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearRecipeDataList() {
                if (this.recipeDataListBuilder_ == null) {
                    this.recipeDataList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.recipeDataListBuilder_.clear();
                }
                return this;
            }

            public Builder removeRecipeDataList(int index) {
                if (this.recipeDataListBuilder_ == null) {
                    ensureRecipeDataListIsMutable();
                    this.recipeDataList_.remove(index);
                    onChanged();
                } else {
                    this.recipeDataListBuilder_.remove(index);
                }
                return this;
            }

            public CookRecipeDataOuterClass.CookRecipeData.Builder getRecipeDataListBuilder(int index) {
                return getRecipeDataListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CookDataNotifyOuterClass.CookDataNotifyOrBuilder
            public CookRecipeDataOuterClass.CookRecipeDataOrBuilder getRecipeDataListOrBuilder(int index) {
                if (this.recipeDataListBuilder_ == null) {
                    return this.recipeDataList_.get(index);
                }
                return this.recipeDataListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CookDataNotifyOuterClass.CookDataNotifyOrBuilder
            public List<? extends CookRecipeDataOuterClass.CookRecipeDataOrBuilder> getRecipeDataListOrBuilderList() {
                if (this.recipeDataListBuilder_ != null) {
                    return this.recipeDataListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.recipeDataList_);
            }

            public CookRecipeDataOuterClass.CookRecipeData.Builder addRecipeDataListBuilder() {
                return getRecipeDataListFieldBuilder().addBuilder(CookRecipeDataOuterClass.CookRecipeData.getDefaultInstance());
            }

            public CookRecipeDataOuterClass.CookRecipeData.Builder addRecipeDataListBuilder(int index) {
                return getRecipeDataListFieldBuilder().addBuilder(index, CookRecipeDataOuterClass.CookRecipeData.getDefaultInstance());
            }

            public List<CookRecipeDataOuterClass.CookRecipeData.Builder> getRecipeDataListBuilderList() {
                return getRecipeDataListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<CookRecipeDataOuterClass.CookRecipeData, CookRecipeDataOuterClass.CookRecipeData.Builder, CookRecipeDataOuterClass.CookRecipeDataOrBuilder> getRecipeDataListFieldBuilder() {
                if (this.recipeDataListBuilder_ == null) {
                    this.recipeDataListBuilder_ = new RepeatedFieldBuilderV3<>(this.recipeDataList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.recipeDataList_ = null;
                }
                return this.recipeDataListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.CookDataNotifyOuterClass.CookDataNotifyOrBuilder
            public int getGrade() {
                return this.grade_;
            }

            public Builder setGrade(int value) {
                this.grade_ = value;
                onChanged();
                return this;
            }

            public Builder clearGrade() {
                this.grade_ = 0;
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

        public static CookDataNotify getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CookDataNotify> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CookDataNotify> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CookDataNotify getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CookRecipeDataOuterClass.getDescriptor();
    }
}
