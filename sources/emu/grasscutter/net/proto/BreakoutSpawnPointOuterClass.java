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
import emu.grasscutter.net.proto.BreakoutPhysicalObjectOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutSpawnPointOuterClass.class */
public final class BreakoutSpawnPointOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018BreakoutSpawnPoint.proto\u001a\u001cBreakoutPhysicalObject.proto\"m\n\u0012BreakoutSpawnPoint\u0012\n\n\u0002id\u0018\u0001 \u0001(\r\u0012\u0016\n\u000ebrick_suite_id\u0018\u0002 \u0001(\r\u00123\n\u0012spawned_brick_list\u0018\u0003 \u0003(\u000b2\u0017.BreakoutPhysicalObjectB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BreakoutPhysicalObjectOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BreakoutSpawnPoint_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BreakoutSpawnPoint_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BreakoutSpawnPoint_descriptor, new String[]{"Id", "BrickSuiteId", "SpawnedBrickList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutSpawnPointOuterClass$BreakoutSpawnPointOrBuilder.class */
    public interface BreakoutSpawnPointOrBuilder extends MessageOrBuilder {
        int getId();

        int getBrickSuiteId();

        List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> getSpawnedBrickListList();

        BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject getSpawnedBrickList(int i);

        int getSpawnedBrickListCount();

        List<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getSpawnedBrickListOrBuilderList();

        BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder getSpawnedBrickListOrBuilder(int i);
    }

    private BreakoutSpawnPointOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutSpawnPointOuterClass$BreakoutSpawnPoint.class */
    public static final class BreakoutSpawnPoint extends GeneratedMessageV3 implements BreakoutSpawnPointOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ID_FIELD_NUMBER = 1;
        private int id_;
        public static final int BRICK_SUITE_ID_FIELD_NUMBER = 2;
        private int brickSuiteId_;
        public static final int SPAWNED_BRICK_LIST_FIELD_NUMBER = 3;
        private List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> spawnedBrickList_;
        private byte memoizedIsInitialized;
        private static final BreakoutSpawnPoint DEFAULT_INSTANCE = new BreakoutSpawnPoint();
        private static final Parser<BreakoutSpawnPoint> PARSER = new AbstractParser<BreakoutSpawnPoint>() { // from class: emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPoint.1
            @Override // com.google.protobuf.Parser
            public BreakoutSpawnPoint parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BreakoutSpawnPoint(input, extensionRegistry);
            }
        };

        private BreakoutSpawnPoint(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BreakoutSpawnPoint() {
            this.memoizedIsInitialized = -1;
            this.spawnedBrickList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BreakoutSpawnPoint();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BreakoutSpawnPoint(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                        int tag = input.readTag();
                        switch (tag) {
                            case 0:
                                done = true;
                                break;
                            case 8:
                                this.id_ = input.readUInt32();
                                break;
                            case 16:
                                this.brickSuiteId_ = input.readUInt32();
                                break;
                            case 26:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.spawnedBrickList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.spawnedBrickList_.add((BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject) input.readMessage(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.parser(), extensionRegistry));
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
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.spawnedBrickList_ = Collections.unmodifiableList(this.spawnedBrickList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BreakoutSpawnPointOuterClass.internal_static_BreakoutSpawnPoint_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BreakoutSpawnPointOuterClass.internal_static_BreakoutSpawnPoint_fieldAccessorTable.ensureFieldAccessorsInitialized(BreakoutSpawnPoint.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
        public int getBrickSuiteId() {
            return this.brickSuiteId_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
        public List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> getSpawnedBrickListList() {
            return this.spawnedBrickList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
        public List<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getSpawnedBrickListOrBuilderList() {
            return this.spawnedBrickList_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
        public int getSpawnedBrickListCount() {
            return this.spawnedBrickList_.size();
        }

        @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
        public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject getSpawnedBrickList(int index) {
            return this.spawnedBrickList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
        public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder getSpawnedBrickListOrBuilder(int index) {
            return this.spawnedBrickList_.get(index);
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
            if (this.brickSuiteId_ != 0) {
                output.writeUInt32(2, this.brickSuiteId_);
            }
            for (int i = 0; i < this.spawnedBrickList_.size(); i++) {
                output.writeMessage(3, this.spawnedBrickList_.get(i));
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
            if (this.brickSuiteId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.brickSuiteId_);
            }
            for (int i = 0; i < this.spawnedBrickList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.spawnedBrickList_.get(i));
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
            if (!(obj instanceof BreakoutSpawnPoint)) {
                return equals(obj);
            }
            BreakoutSpawnPoint other = (BreakoutSpawnPoint) obj;
            return getId() == other.getId() && getBrickSuiteId() == other.getBrickSuiteId() && getSpawnedBrickListList().equals(other.getSpawnedBrickListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getId())) + 2)) + getBrickSuiteId();
            if (getSpawnedBrickListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getSpawnedBrickListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BreakoutSpawnPoint parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutSpawnPoint parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutSpawnPoint parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutSpawnPoint parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutSpawnPoint parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutSpawnPoint parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutSpawnPoint parseFrom(InputStream input) throws IOException {
            return (BreakoutSpawnPoint) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BreakoutSpawnPoint parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutSpawnPoint) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BreakoutSpawnPoint parseDelimitedFrom(InputStream input) throws IOException {
            return (BreakoutSpawnPoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BreakoutSpawnPoint parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutSpawnPoint) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BreakoutSpawnPoint parseFrom(CodedInputStream input) throws IOException {
            return (BreakoutSpawnPoint) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BreakoutSpawnPoint parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutSpawnPoint) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BreakoutSpawnPoint prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutSpawnPointOuterClass$BreakoutSpawnPoint$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BreakoutSpawnPointOrBuilder {
            private int bitField0_;
            private int id_;
            private int brickSuiteId_;
            private List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> spawnedBrickList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> spawnedBrickListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BreakoutSpawnPointOuterClass.internal_static_BreakoutSpawnPoint_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BreakoutSpawnPointOuterClass.internal_static_BreakoutSpawnPoint_fieldAccessorTable.ensureFieldAccessorsInitialized(BreakoutSpawnPoint.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BreakoutSpawnPoint.alwaysUseFieldBuilders) {
                    getSpawnedBrickListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.id_ = 0;
                this.brickSuiteId_ = 0;
                if (this.spawnedBrickListBuilder_ == null) {
                    this.spawnedBrickList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.spawnedBrickListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BreakoutSpawnPointOuterClass.internal_static_BreakoutSpawnPoint_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BreakoutSpawnPoint getDefaultInstanceForType() {
                return BreakoutSpawnPoint.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BreakoutSpawnPoint build() {
                BreakoutSpawnPoint result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BreakoutSpawnPoint buildPartial() {
                BreakoutSpawnPoint result = new BreakoutSpawnPoint(this);
                int i = this.bitField0_;
                result.id_ = this.id_;
                result.brickSuiteId_ = this.brickSuiteId_;
                if (this.spawnedBrickListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.spawnedBrickList_ = Collections.unmodifiableList(this.spawnedBrickList_);
                        this.bitField0_ &= -2;
                    }
                    result.spawnedBrickList_ = this.spawnedBrickList_;
                } else {
                    result.spawnedBrickList_ = this.spawnedBrickListBuilder_.build();
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
                if (other instanceof BreakoutSpawnPoint) {
                    return mergeFrom((BreakoutSpawnPoint) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BreakoutSpawnPoint other) {
                if (other == BreakoutSpawnPoint.getDefaultInstance()) {
                    return this;
                }
                if (other.getId() != 0) {
                    setId(other.getId());
                }
                if (other.getBrickSuiteId() != 0) {
                    setBrickSuiteId(other.getBrickSuiteId());
                }
                if (this.spawnedBrickListBuilder_ == null) {
                    if (!other.spawnedBrickList_.isEmpty()) {
                        if (this.spawnedBrickList_.isEmpty()) {
                            this.spawnedBrickList_ = other.spawnedBrickList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureSpawnedBrickListIsMutable();
                            this.spawnedBrickList_.addAll(other.spawnedBrickList_);
                        }
                        onChanged();
                    }
                } else if (!other.spawnedBrickList_.isEmpty()) {
                    if (this.spawnedBrickListBuilder_.isEmpty()) {
                        this.spawnedBrickListBuilder_.dispose();
                        this.spawnedBrickListBuilder_ = null;
                        this.spawnedBrickList_ = other.spawnedBrickList_;
                        this.bitField0_ &= -2;
                        this.spawnedBrickListBuilder_ = BreakoutSpawnPoint.alwaysUseFieldBuilders ? getSpawnedBrickListFieldBuilder() : null;
                    } else {
                        this.spawnedBrickListBuilder_.addAllMessages(other.spawnedBrickList_);
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
                BreakoutSpawnPoint parsedMessage = null;
                try {
                    try {
                        parsedMessage = BreakoutSpawnPoint.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BreakoutSpawnPoint) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
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

            @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
            public int getBrickSuiteId() {
                return this.brickSuiteId_;
            }

            public Builder setBrickSuiteId(int value) {
                this.brickSuiteId_ = value;
                onChanged();
                return this;
            }

            public Builder clearBrickSuiteId() {
                this.brickSuiteId_ = 0;
                onChanged();
                return this;
            }

            private void ensureSpawnedBrickListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.spawnedBrickList_ = new ArrayList(this.spawnedBrickList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
            public List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> getSpawnedBrickListList() {
                if (this.spawnedBrickListBuilder_ == null) {
                    return Collections.unmodifiableList(this.spawnedBrickList_);
                }
                return this.spawnedBrickListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
            public int getSpawnedBrickListCount() {
                if (this.spawnedBrickListBuilder_ == null) {
                    return this.spawnedBrickList_.size();
                }
                return this.spawnedBrickListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject getSpawnedBrickList(int index) {
                if (this.spawnedBrickListBuilder_ == null) {
                    return this.spawnedBrickList_.get(index);
                }
                return this.spawnedBrickListBuilder_.getMessage(index);
            }

            public Builder setSpawnedBrickList(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject value) {
                if (this.spawnedBrickListBuilder_ != null) {
                    this.spawnedBrickListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSpawnedBrickListIsMutable();
                    this.spawnedBrickList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setSpawnedBrickList(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder builderForValue) {
                if (this.spawnedBrickListBuilder_ == null) {
                    ensureSpawnedBrickListIsMutable();
                    this.spawnedBrickList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.spawnedBrickListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSpawnedBrickList(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject value) {
                if (this.spawnedBrickListBuilder_ != null) {
                    this.spawnedBrickListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSpawnedBrickListIsMutable();
                    this.spawnedBrickList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addSpawnedBrickList(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject value) {
                if (this.spawnedBrickListBuilder_ != null) {
                    this.spawnedBrickListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSpawnedBrickListIsMutable();
                    this.spawnedBrickList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addSpawnedBrickList(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder builderForValue) {
                if (this.spawnedBrickListBuilder_ == null) {
                    ensureSpawnedBrickListIsMutable();
                    this.spawnedBrickList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.spawnedBrickListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSpawnedBrickList(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder builderForValue) {
                if (this.spawnedBrickListBuilder_ == null) {
                    ensureSpawnedBrickListIsMutable();
                    this.spawnedBrickList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.spawnedBrickListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSpawnedBrickList(Iterable<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> values) {
                if (this.spawnedBrickListBuilder_ == null) {
                    ensureSpawnedBrickListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.spawnedBrickList_);
                    onChanged();
                } else {
                    this.spawnedBrickListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSpawnedBrickList() {
                if (this.spawnedBrickListBuilder_ == null) {
                    this.spawnedBrickList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.spawnedBrickListBuilder_.clear();
                }
                return this;
            }

            public Builder removeSpawnedBrickList(int index) {
                if (this.spawnedBrickListBuilder_ == null) {
                    ensureSpawnedBrickListIsMutable();
                    this.spawnedBrickList_.remove(index);
                    onChanged();
                } else {
                    this.spawnedBrickListBuilder_.remove(index);
                }
                return this;
            }

            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder getSpawnedBrickListBuilder(int index) {
                return getSpawnedBrickListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder getSpawnedBrickListOrBuilder(int index) {
                if (this.spawnedBrickListBuilder_ == null) {
                    return this.spawnedBrickList_.get(index);
                }
                return this.spawnedBrickListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
            public List<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getSpawnedBrickListOrBuilderList() {
                if (this.spawnedBrickListBuilder_ != null) {
                    return this.spawnedBrickListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.spawnedBrickList_);
            }

            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder addSpawnedBrickListBuilder() {
                return getSpawnedBrickListFieldBuilder().addBuilder(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.getDefaultInstance());
            }

            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder addSpawnedBrickListBuilder(int index) {
                return getSpawnedBrickListFieldBuilder().addBuilder(index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.getDefaultInstance());
            }

            public List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder> getSpawnedBrickListBuilderList() {
                return getSpawnedBrickListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getSpawnedBrickListFieldBuilder() {
                if (this.spawnedBrickListBuilder_ == null) {
                    this.spawnedBrickListBuilder_ = new RepeatedFieldBuilderV3<>(this.spawnedBrickList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.spawnedBrickList_ = null;
                }
                return this.spawnedBrickListBuilder_;
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

        public static BreakoutSpawnPoint getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BreakoutSpawnPoint> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BreakoutSpawnPoint> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BreakoutSpawnPoint getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BreakoutPhysicalObjectOuterClass.getDescriptor();
    }
}
