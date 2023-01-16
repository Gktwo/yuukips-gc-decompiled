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
import emu.grasscutter.net.proto.MaterialInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DestroyMaterialReqOuterClass.class */
public final class DestroyMaterialReqOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018DestroyMaterialReq.proto\u001a\u0012MaterialInfo.proto\":\n\u0012DestroyMaterialReq\u0012$\n\rmaterial_list\u0018\u0001 \u0003(\u000b2\r.MaterialInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MaterialInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_DestroyMaterialReq_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_DestroyMaterialReq_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_DestroyMaterialReq_descriptor, new String[]{"MaterialList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DestroyMaterialReqOuterClass$DestroyMaterialReqOrBuilder.class */
    public interface DestroyMaterialReqOrBuilder extends MessageOrBuilder {
        List<MaterialInfoOuterClass.MaterialInfo> getMaterialListList();

        MaterialInfoOuterClass.MaterialInfo getMaterialList(int i);

        int getMaterialListCount();

        List<? extends MaterialInfoOuterClass.MaterialInfoOrBuilder> getMaterialListOrBuilderList();

        MaterialInfoOuterClass.MaterialInfoOrBuilder getMaterialListOrBuilder(int i);
    }

    private DestroyMaterialReqOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DestroyMaterialReqOuterClass$DestroyMaterialReq.class */
    public static final class DestroyMaterialReq extends GeneratedMessageV3 implements DestroyMaterialReqOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MATERIAL_LIST_FIELD_NUMBER = 1;
        private List<MaterialInfoOuterClass.MaterialInfo> materialList_;
        private byte memoizedIsInitialized;
        private static final DestroyMaterialReq DEFAULT_INSTANCE = new DestroyMaterialReq();
        private static final Parser<DestroyMaterialReq> PARSER = new AbstractParser<DestroyMaterialReq>() { // from class: emu.grasscutter.net.proto.DestroyMaterialReqOuterClass.DestroyMaterialReq.1
            @Override // com.google.protobuf.Parser
            public DestroyMaterialReq parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new DestroyMaterialReq(input, extensionRegistry);
            }
        };

        private DestroyMaterialReq(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private DestroyMaterialReq() {
            this.memoizedIsInitialized = -1;
            this.materialList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new DestroyMaterialReq();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private DestroyMaterialReq(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 10:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.materialList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.materialList_.add((MaterialInfoOuterClass.MaterialInfo) input.readMessage(MaterialInfoOuterClass.MaterialInfo.parser(), extensionRegistry));
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
                    this.materialList_ = Collections.unmodifiableList(this.materialList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return DestroyMaterialReqOuterClass.internal_static_DestroyMaterialReq_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return DestroyMaterialReqOuterClass.internal_static_DestroyMaterialReq_fieldAccessorTable.ensureFieldAccessorsInitialized(DestroyMaterialReq.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.DestroyMaterialReqOuterClass.DestroyMaterialReqOrBuilder
        public List<MaterialInfoOuterClass.MaterialInfo> getMaterialListList() {
            return this.materialList_;
        }

        @Override // emu.grasscutter.net.proto.DestroyMaterialReqOuterClass.DestroyMaterialReqOrBuilder
        public List<? extends MaterialInfoOuterClass.MaterialInfoOrBuilder> getMaterialListOrBuilderList() {
            return this.materialList_;
        }

        @Override // emu.grasscutter.net.proto.DestroyMaterialReqOuterClass.DestroyMaterialReqOrBuilder
        public int getMaterialListCount() {
            return this.materialList_.size();
        }

        @Override // emu.grasscutter.net.proto.DestroyMaterialReqOuterClass.DestroyMaterialReqOrBuilder
        public MaterialInfoOuterClass.MaterialInfo getMaterialList(int index) {
            return this.materialList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.DestroyMaterialReqOuterClass.DestroyMaterialReqOrBuilder
        public MaterialInfoOuterClass.MaterialInfoOrBuilder getMaterialListOrBuilder(int index) {
            return this.materialList_.get(index);
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
            for (int i = 0; i < this.materialList_.size(); i++) {
                output.writeMessage(1, this.materialList_.get(i));
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
            for (int i = 0; i < this.materialList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.materialList_.get(i));
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
            if (!(obj instanceof DestroyMaterialReq)) {
                return equals(obj);
            }
            DestroyMaterialReq other = (DestroyMaterialReq) obj;
            return getMaterialListList().equals(other.getMaterialListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getMaterialListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getMaterialListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static DestroyMaterialReq parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DestroyMaterialReq parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DestroyMaterialReq parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DestroyMaterialReq parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DestroyMaterialReq parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static DestroyMaterialReq parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static DestroyMaterialReq parseFrom(InputStream input) throws IOException {
            return (DestroyMaterialReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DestroyMaterialReq parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DestroyMaterialReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static DestroyMaterialReq parseDelimitedFrom(InputStream input) throws IOException {
            return (DestroyMaterialReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static DestroyMaterialReq parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DestroyMaterialReq) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static DestroyMaterialReq parseFrom(CodedInputStream input) throws IOException {
            return (DestroyMaterialReq) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static DestroyMaterialReq parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DestroyMaterialReq) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(DestroyMaterialReq prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/DestroyMaterialReqOuterClass$DestroyMaterialReq$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DestroyMaterialReqOrBuilder {
            private int bitField0_;
            private List<MaterialInfoOuterClass.MaterialInfo> materialList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<MaterialInfoOuterClass.MaterialInfo, MaterialInfoOuterClass.MaterialInfo.Builder, MaterialInfoOuterClass.MaterialInfoOrBuilder> materialListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return DestroyMaterialReqOuterClass.internal_static_DestroyMaterialReq_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return DestroyMaterialReqOuterClass.internal_static_DestroyMaterialReq_fieldAccessorTable.ensureFieldAccessorsInitialized(DestroyMaterialReq.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (DestroyMaterialReq.alwaysUseFieldBuilders) {
                    getMaterialListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.materialListBuilder_ == null) {
                    this.materialList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.materialListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return DestroyMaterialReqOuterClass.internal_static_DestroyMaterialReq_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DestroyMaterialReq getDefaultInstanceForType() {
                return DestroyMaterialReq.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DestroyMaterialReq build() {
                DestroyMaterialReq result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public DestroyMaterialReq buildPartial() {
                DestroyMaterialReq result = new DestroyMaterialReq(this);
                int i = this.bitField0_;
                if (this.materialListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.materialList_ = Collections.unmodifiableList(this.materialList_);
                        this.bitField0_ &= -2;
                    }
                    result.materialList_ = this.materialList_;
                } else {
                    result.materialList_ = this.materialListBuilder_.build();
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
                if (other instanceof DestroyMaterialReq) {
                    return mergeFrom((DestroyMaterialReq) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(DestroyMaterialReq other) {
                if (other == DestroyMaterialReq.getDefaultInstance()) {
                    return this;
                }
                if (this.materialListBuilder_ == null) {
                    if (!other.materialList_.isEmpty()) {
                        if (this.materialList_.isEmpty()) {
                            this.materialList_ = other.materialList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureMaterialListIsMutable();
                            this.materialList_.addAll(other.materialList_);
                        }
                        onChanged();
                    }
                } else if (!other.materialList_.isEmpty()) {
                    if (this.materialListBuilder_.isEmpty()) {
                        this.materialListBuilder_.dispose();
                        this.materialListBuilder_ = null;
                        this.materialList_ = other.materialList_;
                        this.bitField0_ &= -2;
                        this.materialListBuilder_ = DestroyMaterialReq.alwaysUseFieldBuilders ? getMaterialListFieldBuilder() : null;
                    } else {
                        this.materialListBuilder_.addAllMessages(other.materialList_);
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
                DestroyMaterialReq parsedMessage = null;
                try {
                    try {
                        parsedMessage = DestroyMaterialReq.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (DestroyMaterialReq) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureMaterialListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.materialList_ = new ArrayList(this.materialList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.DestroyMaterialReqOuterClass.DestroyMaterialReqOrBuilder
            public List<MaterialInfoOuterClass.MaterialInfo> getMaterialListList() {
                if (this.materialListBuilder_ == null) {
                    return Collections.unmodifiableList(this.materialList_);
                }
                return this.materialListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.DestroyMaterialReqOuterClass.DestroyMaterialReqOrBuilder
            public int getMaterialListCount() {
                if (this.materialListBuilder_ == null) {
                    return this.materialList_.size();
                }
                return this.materialListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.DestroyMaterialReqOuterClass.DestroyMaterialReqOrBuilder
            public MaterialInfoOuterClass.MaterialInfo getMaterialList(int index) {
                if (this.materialListBuilder_ == null) {
                    return this.materialList_.get(index);
                }
                return this.materialListBuilder_.getMessage(index);
            }

            public Builder setMaterialList(int index, MaterialInfoOuterClass.MaterialInfo value) {
                if (this.materialListBuilder_ != null) {
                    this.materialListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMaterialListIsMutable();
                    this.materialList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMaterialList(int index, MaterialInfoOuterClass.MaterialInfo.Builder builderForValue) {
                if (this.materialListBuilder_ == null) {
                    ensureMaterialListIsMutable();
                    this.materialList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.materialListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMaterialList(MaterialInfoOuterClass.MaterialInfo value) {
                if (this.materialListBuilder_ != null) {
                    this.materialListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMaterialListIsMutable();
                    this.materialList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMaterialList(int index, MaterialInfoOuterClass.MaterialInfo value) {
                if (this.materialListBuilder_ != null) {
                    this.materialListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMaterialListIsMutable();
                    this.materialList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMaterialList(MaterialInfoOuterClass.MaterialInfo.Builder builderForValue) {
                if (this.materialListBuilder_ == null) {
                    ensureMaterialListIsMutable();
                    this.materialList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.materialListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMaterialList(int index, MaterialInfoOuterClass.MaterialInfo.Builder builderForValue) {
                if (this.materialListBuilder_ == null) {
                    ensureMaterialListIsMutable();
                    this.materialList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.materialListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMaterialList(Iterable<? extends MaterialInfoOuterClass.MaterialInfo> values) {
                if (this.materialListBuilder_ == null) {
                    ensureMaterialListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.materialList_);
                    onChanged();
                } else {
                    this.materialListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMaterialList() {
                if (this.materialListBuilder_ == null) {
                    this.materialList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.materialListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMaterialList(int index) {
                if (this.materialListBuilder_ == null) {
                    ensureMaterialListIsMutable();
                    this.materialList_.remove(index);
                    onChanged();
                } else {
                    this.materialListBuilder_.remove(index);
                }
                return this;
            }

            public MaterialInfoOuterClass.MaterialInfo.Builder getMaterialListBuilder(int index) {
                return getMaterialListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DestroyMaterialReqOuterClass.DestroyMaterialReqOrBuilder
            public MaterialInfoOuterClass.MaterialInfoOrBuilder getMaterialListOrBuilder(int index) {
                if (this.materialListBuilder_ == null) {
                    return this.materialList_.get(index);
                }
                return this.materialListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.DestroyMaterialReqOuterClass.DestroyMaterialReqOrBuilder
            public List<? extends MaterialInfoOuterClass.MaterialInfoOrBuilder> getMaterialListOrBuilderList() {
                if (this.materialListBuilder_ != null) {
                    return this.materialListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.materialList_);
            }

            public MaterialInfoOuterClass.MaterialInfo.Builder addMaterialListBuilder() {
                return getMaterialListFieldBuilder().addBuilder(MaterialInfoOuterClass.MaterialInfo.getDefaultInstance());
            }

            public MaterialInfoOuterClass.MaterialInfo.Builder addMaterialListBuilder(int index) {
                return getMaterialListFieldBuilder().addBuilder(index, MaterialInfoOuterClass.MaterialInfo.getDefaultInstance());
            }

            public List<MaterialInfoOuterClass.MaterialInfo.Builder> getMaterialListBuilderList() {
                return getMaterialListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MaterialInfoOuterClass.MaterialInfo, MaterialInfoOuterClass.MaterialInfo.Builder, MaterialInfoOuterClass.MaterialInfoOrBuilder> getMaterialListFieldBuilder() {
                if (this.materialListBuilder_ == null) {
                    this.materialListBuilder_ = new RepeatedFieldBuilderV3<>(this.materialList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.materialList_ = null;
                }
                return this.materialListBuilder_;
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

        public static DestroyMaterialReq getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DestroyMaterialReq> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<DestroyMaterialReq> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public DestroyMaterialReq getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MaterialInfoOuterClass.getDescriptor();
    }
}
