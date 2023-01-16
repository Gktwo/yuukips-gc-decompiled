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
import emu.grasscutter.net.proto.FireWorkInstanceOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireWorkDataOuterClass.class */
public final class FireWorkDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0012FireWorkData.proto\u001a\u0016FireWorkInstance.proto\"G\n\fFireWorkData\u0012\n\n\u0002id\u0018\u0001 \u0001(\r\u0012+\n\u0010fireWorkInstance\u0018\u0002 \u0003(\u000b2\u0011.FireWorkInstanceB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{FireWorkInstanceOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_FireWorkData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_FireWorkData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_FireWorkData_descriptor, new String[]{"Id", "FireWorkInstance"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireWorkDataOuterClass$FireWorkDataOrBuilder.class */
    public interface FireWorkDataOrBuilder extends MessageOrBuilder {
        int getId();

        List<FireWorkInstanceOuterClass.FireWorkInstance> getFireWorkInstanceList();

        FireWorkInstanceOuterClass.FireWorkInstance getFireWorkInstance(int i);

        int getFireWorkInstanceCount();

        List<? extends FireWorkInstanceOuterClass.FireWorkInstanceOrBuilder> getFireWorkInstanceOrBuilderList();

        FireWorkInstanceOuterClass.FireWorkInstanceOrBuilder getFireWorkInstanceOrBuilder(int i);
    }

    private FireWorkDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireWorkDataOuterClass$FireWorkData.class */
    public static final class FireWorkData extends GeneratedMessageV3 implements FireWorkDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int FIREWORKINSTANCE_FIELD_NUMBER = 2;
        private List<FireWorkInstanceOuterClass.FireWorkInstance> fireWorkInstance_;
        private byte memoizedIsInitialized;
        private static final FireWorkData DEFAULT_INSTANCE = new FireWorkData();
        private static final Parser<FireWorkData> PARSER = new AbstractParser<FireWorkData>() { // from class: emu.grasscutter.net.proto.FireWorkDataOuterClass.FireWorkData.1
            @Override // com.google.protobuf.Parser
            public FireWorkData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new FireWorkData(input, extensionRegistry);
            }
        };

        private FireWorkData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private FireWorkData() {
            this.memoizedIsInitialized = -1;
            this.fireWorkInstance_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new FireWorkData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private FireWorkData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.id_ = input.readUInt32();
                                    break;
                                case 18:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.fireWorkInstance_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.fireWorkInstance_.add((FireWorkInstanceOuterClass.FireWorkInstance) input.readMessage(FireWorkInstanceOuterClass.FireWorkInstance.parser(), extensionRegistry));
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
                    this.fireWorkInstance_ = Collections.unmodifiableList(this.fireWorkInstance_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return FireWorkDataOuterClass.internal_static_FireWorkData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return FireWorkDataOuterClass.internal_static_FireWorkData_fieldAccessorTable.ensureFieldAccessorsInitialized(FireWorkData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.FireWorkDataOuterClass.FireWorkDataOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // emu.grasscutter.net.proto.FireWorkDataOuterClass.FireWorkDataOrBuilder
        public List<FireWorkInstanceOuterClass.FireWorkInstance> getFireWorkInstanceList() {
            return this.fireWorkInstance_;
        }

        @Override // emu.grasscutter.net.proto.FireWorkDataOuterClass.FireWorkDataOrBuilder
        public List<? extends FireWorkInstanceOuterClass.FireWorkInstanceOrBuilder> getFireWorkInstanceOrBuilderList() {
            return this.fireWorkInstance_;
        }

        @Override // emu.grasscutter.net.proto.FireWorkDataOuterClass.FireWorkDataOrBuilder
        public int getFireWorkInstanceCount() {
            return this.fireWorkInstance_.size();
        }

        @Override // emu.grasscutter.net.proto.FireWorkDataOuterClass.FireWorkDataOrBuilder
        public FireWorkInstanceOuterClass.FireWorkInstance getFireWorkInstance(int index) {
            return this.fireWorkInstance_.get(index);
        }

        @Override // emu.grasscutter.net.proto.FireWorkDataOuterClass.FireWorkDataOrBuilder
        public FireWorkInstanceOuterClass.FireWorkInstanceOrBuilder getFireWorkInstanceOrBuilder(int index) {
            return this.fireWorkInstance_.get(index);
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
            if (this.id_ != 0) {
                output.writeUInt32(1, this.id_);
            }
            for (int i = 0; i < this.fireWorkInstance_.size(); i++) {
                output.writeMessage(2, this.fireWorkInstance_.get(i));
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
            if (this.id_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.id_);
            }
            for (int i = 0; i < this.fireWorkInstance_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.fireWorkInstance_.get(i));
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
            if (!(obj instanceof FireWorkData)) {
                return equals(obj);
            }
            FireWorkData other = (FireWorkData) obj;
            return getId() == other.getId() && getFireWorkInstanceList().equals(other.getFireWorkInstanceList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getId();
            if (getFireWorkInstanceCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getFireWorkInstanceList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static FireWorkData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FireWorkData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FireWorkData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FireWorkData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FireWorkData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static FireWorkData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static FireWorkData parseFrom(InputStream input) throws IOException {
            return (FireWorkData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FireWorkData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FireWorkData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static FireWorkData parseDelimitedFrom(InputStream input) throws IOException {
            return (FireWorkData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static FireWorkData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FireWorkData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static FireWorkData parseFrom(CodedInputStream input) throws IOException {
            return (FireWorkData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static FireWorkData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (FireWorkData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(FireWorkData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/FireWorkDataOuterClass$FireWorkData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements FireWorkDataOrBuilder {
            private int bitField0_;
            private int id_;
            private List<FireWorkInstanceOuterClass.FireWorkInstance> fireWorkInstance_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<FireWorkInstanceOuterClass.FireWorkInstance, FireWorkInstanceOuterClass.FireWorkInstance.Builder, FireWorkInstanceOuterClass.FireWorkInstanceOrBuilder> fireWorkInstanceBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return FireWorkDataOuterClass.internal_static_FireWorkData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return FireWorkDataOuterClass.internal_static_FireWorkData_fieldAccessorTable.ensureFieldAccessorsInitialized(FireWorkData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (FireWorkData.alwaysUseFieldBuilders) {
                    getFireWorkInstanceFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.id_ = 0;
                if (this.fireWorkInstanceBuilder_ == null) {
                    this.fireWorkInstance_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.fireWorkInstanceBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return FireWorkDataOuterClass.internal_static_FireWorkData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public FireWorkData getDefaultInstanceForType() {
                return FireWorkData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FireWorkData build() {
                FireWorkData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public FireWorkData buildPartial() {
                FireWorkData result = new FireWorkData(this);
                int i = this.bitField0_;
                result.id_ = this.id_;
                if (this.fireWorkInstanceBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.fireWorkInstance_ = Collections.unmodifiableList(this.fireWorkInstance_);
                        this.bitField0_ &= -2;
                    }
                    result.fireWorkInstance_ = this.fireWorkInstance_;
                } else {
                    result.fireWorkInstance_ = this.fireWorkInstanceBuilder_.build();
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
                if (other instanceof FireWorkData) {
                    return mergeFrom((FireWorkData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(FireWorkData other) {
                if (other == FireWorkData.getDefaultInstance()) {
                    return this;
                }
                if (other.getId() != 0) {
                    setId(other.getId());
                }
                if (this.fireWorkInstanceBuilder_ == null) {
                    if (!other.fireWorkInstance_.isEmpty()) {
                        if (this.fireWorkInstance_.isEmpty()) {
                            this.fireWorkInstance_ = other.fireWorkInstance_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureFireWorkInstanceIsMutable();
                            this.fireWorkInstance_.addAll(other.fireWorkInstance_);
                        }
                        onChanged();
                    }
                } else if (!other.fireWorkInstance_.isEmpty()) {
                    if (this.fireWorkInstanceBuilder_.isEmpty()) {
                        this.fireWorkInstanceBuilder_.dispose();
                        this.fireWorkInstanceBuilder_ = null;
                        this.fireWorkInstance_ = other.fireWorkInstance_;
                        this.bitField0_ &= -2;
                        this.fireWorkInstanceBuilder_ = FireWorkData.alwaysUseFieldBuilders ? getFireWorkInstanceFieldBuilder() : null;
                    } else {
                        this.fireWorkInstanceBuilder_.addAllMessages(other.fireWorkInstance_);
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
                FireWorkData parsedMessage = null;
                try {
                    try {
                        parsedMessage = FireWorkData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (FireWorkData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.FireWorkDataOuterClass.FireWorkDataOrBuilder
            public int getId() {
                return this.id_;
            }

            public Builder setId(int value) {
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
                onChanged();
                return this;
            }

            private void ensureFireWorkInstanceIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.fireWorkInstance_ = new ArrayList(this.fireWorkInstance_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.FireWorkDataOuterClass.FireWorkDataOrBuilder
            public List<FireWorkInstanceOuterClass.FireWorkInstance> getFireWorkInstanceList() {
                if (this.fireWorkInstanceBuilder_ == null) {
                    return Collections.unmodifiableList(this.fireWorkInstance_);
                }
                return this.fireWorkInstanceBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.FireWorkDataOuterClass.FireWorkDataOrBuilder
            public int getFireWorkInstanceCount() {
                if (this.fireWorkInstanceBuilder_ == null) {
                    return this.fireWorkInstance_.size();
                }
                return this.fireWorkInstanceBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.FireWorkDataOuterClass.FireWorkDataOrBuilder
            public FireWorkInstanceOuterClass.FireWorkInstance getFireWorkInstance(int index) {
                if (this.fireWorkInstanceBuilder_ == null) {
                    return this.fireWorkInstance_.get(index);
                }
                return this.fireWorkInstanceBuilder_.getMessage(index);
            }

            public Builder setFireWorkInstance(int index, FireWorkInstanceOuterClass.FireWorkInstance value) {
                if (this.fireWorkInstanceBuilder_ != null) {
                    this.fireWorkInstanceBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFireWorkInstanceIsMutable();
                    this.fireWorkInstance_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setFireWorkInstance(int index, FireWorkInstanceOuterClass.FireWorkInstance.Builder builderForValue) {
                if (this.fireWorkInstanceBuilder_ == null) {
                    ensureFireWorkInstanceIsMutable();
                    this.fireWorkInstance_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fireWorkInstanceBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addFireWorkInstance(FireWorkInstanceOuterClass.FireWorkInstance value) {
                if (this.fireWorkInstanceBuilder_ != null) {
                    this.fireWorkInstanceBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFireWorkInstanceIsMutable();
                    this.fireWorkInstance_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addFireWorkInstance(int index, FireWorkInstanceOuterClass.FireWorkInstance value) {
                if (this.fireWorkInstanceBuilder_ != null) {
                    this.fireWorkInstanceBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureFireWorkInstanceIsMutable();
                    this.fireWorkInstance_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addFireWorkInstance(FireWorkInstanceOuterClass.FireWorkInstance.Builder builderForValue) {
                if (this.fireWorkInstanceBuilder_ == null) {
                    ensureFireWorkInstanceIsMutable();
                    this.fireWorkInstance_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.fireWorkInstanceBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addFireWorkInstance(int index, FireWorkInstanceOuterClass.FireWorkInstance.Builder builderForValue) {
                if (this.fireWorkInstanceBuilder_ == null) {
                    ensureFireWorkInstanceIsMutable();
                    this.fireWorkInstance_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.fireWorkInstanceBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllFireWorkInstance(Iterable<? extends FireWorkInstanceOuterClass.FireWorkInstance> values) {
                if (this.fireWorkInstanceBuilder_ == null) {
                    ensureFireWorkInstanceIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.fireWorkInstance_);
                    onChanged();
                } else {
                    this.fireWorkInstanceBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearFireWorkInstance() {
                if (this.fireWorkInstanceBuilder_ == null) {
                    this.fireWorkInstance_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.fireWorkInstanceBuilder_.clear();
                }
                return this;
            }

            public Builder removeFireWorkInstance(int index) {
                if (this.fireWorkInstanceBuilder_ == null) {
                    ensureFireWorkInstanceIsMutable();
                    this.fireWorkInstance_.remove(index);
                    onChanged();
                } else {
                    this.fireWorkInstanceBuilder_.remove(index);
                }
                return this;
            }

            public FireWorkInstanceOuterClass.FireWorkInstance.Builder getFireWorkInstanceBuilder(int index) {
                return getFireWorkInstanceFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FireWorkDataOuterClass.FireWorkDataOrBuilder
            public FireWorkInstanceOuterClass.FireWorkInstanceOrBuilder getFireWorkInstanceOrBuilder(int index) {
                if (this.fireWorkInstanceBuilder_ == null) {
                    return this.fireWorkInstance_.get(index);
                }
                return this.fireWorkInstanceBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.FireWorkDataOuterClass.FireWorkDataOrBuilder
            public List<? extends FireWorkInstanceOuterClass.FireWorkInstanceOrBuilder> getFireWorkInstanceOrBuilderList() {
                if (this.fireWorkInstanceBuilder_ != null) {
                    return this.fireWorkInstanceBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.fireWorkInstance_);
            }

            public FireWorkInstanceOuterClass.FireWorkInstance.Builder addFireWorkInstanceBuilder() {
                return getFireWorkInstanceFieldBuilder().addBuilder(FireWorkInstanceOuterClass.FireWorkInstance.getDefaultInstance());
            }

            public FireWorkInstanceOuterClass.FireWorkInstance.Builder addFireWorkInstanceBuilder(int index) {
                return getFireWorkInstanceFieldBuilder().addBuilder(index, FireWorkInstanceOuterClass.FireWorkInstance.getDefaultInstance());
            }

            public List<FireWorkInstanceOuterClass.FireWorkInstance.Builder> getFireWorkInstanceBuilderList() {
                return getFireWorkInstanceFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<FireWorkInstanceOuterClass.FireWorkInstance, FireWorkInstanceOuterClass.FireWorkInstance.Builder, FireWorkInstanceOuterClass.FireWorkInstanceOrBuilder> getFireWorkInstanceFieldBuilder() {
                if (this.fireWorkInstanceBuilder_ == null) {
                    this.fireWorkInstanceBuilder_ = new RepeatedFieldBuilderV3<>(this.fireWorkInstance_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.fireWorkInstance_ = null;
                }
                return this.fireWorkInstanceBuilder_;
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

        public static FireWorkData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<FireWorkData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<FireWorkData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public FireWorkData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FireWorkInstanceOuterClass.getDescriptor();
    }
}
