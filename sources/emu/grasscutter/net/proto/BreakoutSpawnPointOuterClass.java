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
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018BreakoutSpawnPoint.proto\u001a\u001cBreakoutPhysicalObject.proto\"c\n\u0012BreakoutSpawnPoint\u0012\n\n\u0002id\u0018\u0001 \u0001(\r\u0012\u0013\n\u000bjkjacakbdch\u0018\u0002 \u0001(\r\u0012,\n\u000bclnllfklpjc\u0018\u0003 \u0003(\u000b2\u0017.BreakoutPhysicalObjectB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BreakoutPhysicalObjectOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BreakoutSpawnPoint_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BreakoutSpawnPoint_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BreakoutSpawnPoint_descriptor, new String[]{"Id", "Jkjacakbdch", "Clnllfklpjc"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutSpawnPointOuterClass$BreakoutSpawnPointOrBuilder.class */
    public interface BreakoutSpawnPointOrBuilder extends MessageOrBuilder {
        int getId();

        int getJkjacakbdch();

        List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> getClnllfklpjcList();

        BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject getClnllfklpjc(int i);

        int getClnllfklpjcCount();

        List<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getClnllfklpjcOrBuilderList();

        BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder getClnllfklpjcOrBuilder(int i);
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
        public static final int JKJACAKBDCH_FIELD_NUMBER = 2;
        private int jkjacakbdch_;
        public static final int CLNLLFKLPJC_FIELD_NUMBER = 3;
        private List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> clnllfklpjc_;
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
            this.clnllfklpjc_ = Collections.emptyList();
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
                                this.jkjacakbdch_ = input.readUInt32();
                                break;
                            case 26:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.clnllfklpjc_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.clnllfklpjc_.add((BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject) input.readMessage(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.parser(), extensionRegistry));
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
                    this.clnllfklpjc_ = Collections.unmodifiableList(this.clnllfklpjc_);
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
        public int getJkjacakbdch() {
            return this.jkjacakbdch_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
        public List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> getClnllfklpjcList() {
            return this.clnllfklpjc_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
        public List<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getClnllfklpjcOrBuilderList() {
            return this.clnllfklpjc_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
        public int getClnllfklpjcCount() {
            return this.clnllfklpjc_.size();
        }

        @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
        public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject getClnllfklpjc(int index) {
            return this.clnllfklpjc_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
        public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder getClnllfklpjcOrBuilder(int index) {
            return this.clnllfklpjc_.get(index);
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
            if (this.jkjacakbdch_ != 0) {
                output.writeUInt32(2, this.jkjacakbdch_);
            }
            for (int i = 0; i < this.clnllfklpjc_.size(); i++) {
                output.writeMessage(3, this.clnllfklpjc_.get(i));
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
            if (this.jkjacakbdch_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.jkjacakbdch_);
            }
            for (int i = 0; i < this.clnllfklpjc_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.clnllfklpjc_.get(i));
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
            return getId() == other.getId() && getJkjacakbdch() == other.getJkjacakbdch() && getClnllfklpjcList().equals(other.getClnllfklpjcList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getId())) + 2)) + getJkjacakbdch();
            if (getClnllfklpjcCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getClnllfklpjcList().hashCode();
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
            private int jkjacakbdch_;
            private List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> clnllfklpjc_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> clnllfklpjcBuilder_;

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
                    getClnllfklpjcFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.id_ = 0;
                this.jkjacakbdch_ = 0;
                if (this.clnllfklpjcBuilder_ == null) {
                    this.clnllfklpjc_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.clnllfklpjcBuilder_.clear();
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
                result.jkjacakbdch_ = this.jkjacakbdch_;
                if (this.clnllfklpjcBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.clnllfklpjc_ = Collections.unmodifiableList(this.clnllfklpjc_);
                        this.bitField0_ &= -2;
                    }
                    result.clnllfklpjc_ = this.clnllfklpjc_;
                } else {
                    result.clnllfklpjc_ = this.clnllfklpjcBuilder_.build();
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
                if (other.getJkjacakbdch() != 0) {
                    setJkjacakbdch(other.getJkjacakbdch());
                }
                if (this.clnllfklpjcBuilder_ == null) {
                    if (!other.clnllfklpjc_.isEmpty()) {
                        if (this.clnllfklpjc_.isEmpty()) {
                            this.clnllfklpjc_ = other.clnllfklpjc_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureClnllfklpjcIsMutable();
                            this.clnllfklpjc_.addAll(other.clnllfklpjc_);
                        }
                        onChanged();
                    }
                } else if (!other.clnllfklpjc_.isEmpty()) {
                    if (this.clnllfklpjcBuilder_.isEmpty()) {
                        this.clnllfklpjcBuilder_.dispose();
                        this.clnllfklpjcBuilder_ = null;
                        this.clnllfklpjc_ = other.clnllfklpjc_;
                        this.bitField0_ &= -2;
                        this.clnllfklpjcBuilder_ = BreakoutSpawnPoint.alwaysUseFieldBuilders ? getClnllfklpjcFieldBuilder() : null;
                    } else {
                        this.clnllfklpjcBuilder_.addAllMessages(other.clnllfklpjc_);
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
            public int getJkjacakbdch() {
                return this.jkjacakbdch_;
            }

            public Builder setJkjacakbdch(int value) {
                this.jkjacakbdch_ = value;
                onChanged();
                return this;
            }

            public Builder clearJkjacakbdch() {
                this.jkjacakbdch_ = 0;
                onChanged();
                return this;
            }

            private void ensureClnllfklpjcIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.clnllfklpjc_ = new ArrayList(this.clnllfklpjc_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
            public List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> getClnllfklpjcList() {
                if (this.clnllfklpjcBuilder_ == null) {
                    return Collections.unmodifiableList(this.clnllfklpjc_);
                }
                return this.clnllfklpjcBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
            public int getClnllfklpjcCount() {
                if (this.clnllfklpjcBuilder_ == null) {
                    return this.clnllfklpjc_.size();
                }
                return this.clnllfklpjcBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject getClnllfklpjc(int index) {
                if (this.clnllfklpjcBuilder_ == null) {
                    return this.clnllfklpjc_.get(index);
                }
                return this.clnllfklpjcBuilder_.getMessage(index);
            }

            public Builder setClnllfklpjc(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject value) {
                if (this.clnllfklpjcBuilder_ != null) {
                    this.clnllfklpjcBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureClnllfklpjcIsMutable();
                    this.clnllfklpjc_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setClnllfklpjc(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder builderForValue) {
                if (this.clnllfklpjcBuilder_ == null) {
                    ensureClnllfklpjcIsMutable();
                    this.clnllfklpjc_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.clnllfklpjcBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addClnllfklpjc(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject value) {
                if (this.clnllfklpjcBuilder_ != null) {
                    this.clnllfklpjcBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureClnllfklpjcIsMutable();
                    this.clnllfklpjc_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addClnllfklpjc(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject value) {
                if (this.clnllfklpjcBuilder_ != null) {
                    this.clnllfklpjcBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureClnllfklpjcIsMutable();
                    this.clnllfklpjc_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addClnllfklpjc(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder builderForValue) {
                if (this.clnllfklpjcBuilder_ == null) {
                    ensureClnllfklpjcIsMutable();
                    this.clnllfklpjc_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.clnllfklpjcBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addClnllfklpjc(int index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder builderForValue) {
                if (this.clnllfklpjcBuilder_ == null) {
                    ensureClnllfklpjcIsMutable();
                    this.clnllfklpjc_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.clnllfklpjcBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllClnllfklpjc(Iterable<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject> values) {
                if (this.clnllfklpjcBuilder_ == null) {
                    ensureClnllfklpjcIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.clnllfklpjc_);
                    onChanged();
                } else {
                    this.clnllfklpjcBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearClnllfklpjc() {
                if (this.clnllfklpjcBuilder_ == null) {
                    this.clnllfklpjc_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.clnllfklpjcBuilder_.clear();
                }
                return this;
            }

            public Builder removeClnllfklpjc(int index) {
                if (this.clnllfklpjcBuilder_ == null) {
                    ensureClnllfklpjcIsMutable();
                    this.clnllfklpjc_.remove(index);
                    onChanged();
                } else {
                    this.clnllfklpjcBuilder_.remove(index);
                }
                return this;
            }

            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder getClnllfklpjcBuilder(int index) {
                return getClnllfklpjcFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder getClnllfklpjcOrBuilder(int index) {
                if (this.clnllfklpjcBuilder_ == null) {
                    return this.clnllfklpjc_.get(index);
                }
                return this.clnllfklpjcBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BreakoutSpawnPointOuterClass.BreakoutSpawnPointOrBuilder
            public List<? extends BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getClnllfklpjcOrBuilderList() {
                if (this.clnllfklpjcBuilder_ != null) {
                    return this.clnllfklpjcBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.clnllfklpjc_);
            }

            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder addClnllfklpjcBuilder() {
                return getClnllfklpjcFieldBuilder().addBuilder(BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.getDefaultInstance());
            }

            public BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder addClnllfklpjcBuilder(int index) {
                return getClnllfklpjcFieldBuilder().addBuilder(index, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.getDefaultInstance());
            }

            public List<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder> getClnllfklpjcBuilderList() {
                return getClnllfklpjcFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObject.Builder, BreakoutPhysicalObjectOuterClass.BreakoutPhysicalObjectOrBuilder> getClnllfklpjcFieldBuilder() {
                if (this.clnllfklpjcBuilder_ == null) {
                    this.clnllfklpjcBuilder_ = new RepeatedFieldBuilderV3<>(this.clnllfklpjc_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.clnllfklpjc_ = null;
                }
                return this.clnllfklpjcBuilder_;
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
