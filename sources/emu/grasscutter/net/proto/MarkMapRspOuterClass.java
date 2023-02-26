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
import emu.grasscutter.net.proto.MapMarkPointOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MarkMapRspOuterClass.class */
public final class MarkMapRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0010MarkMapRsp.proto\u001a\u0012MapMarkPoint.proto\">\n\nMarkMapRsp\u0012\u000f\n\u0007retcode\u0018\u0001 \u0001(\u0005\u0012\u001f\n\bmarkList\u0018\u0005 \u0003(\u000b2\r.MapMarkPointB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MapMarkPointOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_MarkMapRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MarkMapRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MarkMapRsp_descriptor, new String[]{"Retcode", "MarkList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MarkMapRspOuterClass$MarkMapRspOrBuilder.class */
    public interface MarkMapRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        List<MapMarkPointOuterClass.MapMarkPoint> getMarkListList();

        MapMarkPointOuterClass.MapMarkPoint getMarkList(int i);

        int getMarkListCount();

        List<? extends MapMarkPointOuterClass.MapMarkPointOrBuilder> getMarkListOrBuilderList();

        MapMarkPointOuterClass.MapMarkPointOrBuilder getMarkListOrBuilder(int i);
    }

    private MarkMapRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MarkMapRspOuterClass$MarkMapRsp.class */
    public static final class MarkMapRsp extends GeneratedMessageV3 implements MarkMapRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 1;
        private int retcode_;
        public static final int MARKLIST_FIELD_NUMBER = 5;
        private List<MapMarkPointOuterClass.MapMarkPoint> markList_;
        private byte memoizedIsInitialized;
        private static final MarkMapRsp DEFAULT_INSTANCE = new MarkMapRsp();
        private static final Parser<MarkMapRsp> PARSER = new AbstractParser<MarkMapRsp>() { // from class: emu.grasscutter.net.proto.MarkMapRspOuterClass.MarkMapRsp.1
            @Override // com.google.protobuf.Parser
            public MarkMapRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MarkMapRsp(input, extensionRegistry);
            }
        };

        private MarkMapRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private MarkMapRsp() {
            this.memoizedIsInitialized = -1;
            this.markList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MarkMapRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MarkMapRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 42:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.markList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.markList_.add((MapMarkPointOuterClass.MapMarkPoint) input.readMessage(MapMarkPointOuterClass.MapMarkPoint.parser(), extensionRegistry));
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
                    this.markList_ = Collections.unmodifiableList(this.markList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return MarkMapRspOuterClass.internal_static_MarkMapRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MarkMapRspOuterClass.internal_static_MarkMapRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(MarkMapRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.MarkMapRspOuterClass.MarkMapRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.MarkMapRspOuterClass.MarkMapRspOrBuilder
        public List<MapMarkPointOuterClass.MapMarkPoint> getMarkListList() {
            return this.markList_;
        }

        @Override // emu.grasscutter.net.proto.MarkMapRspOuterClass.MarkMapRspOrBuilder
        public List<? extends MapMarkPointOuterClass.MapMarkPointOrBuilder> getMarkListOrBuilderList() {
            return this.markList_;
        }

        @Override // emu.grasscutter.net.proto.MarkMapRspOuterClass.MarkMapRspOrBuilder
        public int getMarkListCount() {
            return this.markList_.size();
        }

        @Override // emu.grasscutter.net.proto.MarkMapRspOuterClass.MarkMapRspOrBuilder
        public MapMarkPointOuterClass.MapMarkPoint getMarkList(int index) {
            return this.markList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.MarkMapRspOuterClass.MarkMapRspOrBuilder
        public MapMarkPointOuterClass.MapMarkPointOrBuilder getMarkListOrBuilder(int index) {
            return this.markList_.get(index);
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
                output.writeInt32(1, this.retcode_);
            }
            for (int i = 0; i < this.markList_.size(); i++) {
                output.writeMessage(5, this.markList_.get(i));
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
                size2 = 0 + CodedOutputStream.computeInt32Size(1, this.retcode_);
            }
            for (int i = 0; i < this.markList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.markList_.get(i));
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
            if (!(obj instanceof MarkMapRsp)) {
                return equals(obj);
            }
            MarkMapRsp other = (MarkMapRsp) obj;
            return getRetcode() == other.getRetcode() && getMarkListList().equals(other.getMarkListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getRetcode();
            if (getMarkListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getMarkListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MarkMapRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MarkMapRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MarkMapRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MarkMapRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MarkMapRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MarkMapRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MarkMapRsp parseFrom(InputStream input) throws IOException {
            return (MarkMapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MarkMapRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MarkMapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MarkMapRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (MarkMapRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MarkMapRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MarkMapRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MarkMapRsp parseFrom(CodedInputStream input) throws IOException {
            return (MarkMapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MarkMapRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MarkMapRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MarkMapRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MarkMapRspOuterClass$MarkMapRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MarkMapRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private List<MapMarkPointOuterClass.MapMarkPoint> markList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<MapMarkPointOuterClass.MapMarkPoint, MapMarkPointOuterClass.MapMarkPoint.Builder, MapMarkPointOuterClass.MapMarkPointOrBuilder> markListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MarkMapRspOuterClass.internal_static_MarkMapRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MarkMapRspOuterClass.internal_static_MarkMapRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(MarkMapRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MarkMapRsp.alwaysUseFieldBuilders) {
                    getMarkListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                if (this.markListBuilder_ == null) {
                    this.markList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.markListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MarkMapRspOuterClass.internal_static_MarkMapRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MarkMapRsp getDefaultInstanceForType() {
                return MarkMapRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MarkMapRsp build() {
                MarkMapRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MarkMapRsp buildPartial() {
                MarkMapRsp result = new MarkMapRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                if (this.markListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.markList_ = Collections.unmodifiableList(this.markList_);
                        this.bitField0_ &= -2;
                    }
                    result.markList_ = this.markList_;
                } else {
                    result.markList_ = this.markListBuilder_.build();
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
                if (other instanceof MarkMapRsp) {
                    return mergeFrom((MarkMapRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MarkMapRsp other) {
                if (other == MarkMapRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (this.markListBuilder_ == null) {
                    if (!other.markList_.isEmpty()) {
                        if (this.markList_.isEmpty()) {
                            this.markList_ = other.markList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureMarkListIsMutable();
                            this.markList_.addAll(other.markList_);
                        }
                        onChanged();
                    }
                } else if (!other.markList_.isEmpty()) {
                    if (this.markListBuilder_.isEmpty()) {
                        this.markListBuilder_.dispose();
                        this.markListBuilder_ = null;
                        this.markList_ = other.markList_;
                        this.bitField0_ &= -2;
                        this.markListBuilder_ = MarkMapRsp.alwaysUseFieldBuilders ? getMarkListFieldBuilder() : null;
                    } else {
                        this.markListBuilder_.addAllMessages(other.markList_);
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
                MarkMapRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = MarkMapRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MarkMapRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MarkMapRspOuterClass.MarkMapRspOrBuilder
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

            private void ensureMarkListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.markList_ = new ArrayList(this.markList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.MarkMapRspOuterClass.MarkMapRspOrBuilder
            public List<MapMarkPointOuterClass.MapMarkPoint> getMarkListList() {
                if (this.markListBuilder_ == null) {
                    return Collections.unmodifiableList(this.markList_);
                }
                return this.markListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.MarkMapRspOuterClass.MarkMapRspOrBuilder
            public int getMarkListCount() {
                if (this.markListBuilder_ == null) {
                    return this.markList_.size();
                }
                return this.markListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.MarkMapRspOuterClass.MarkMapRspOrBuilder
            public MapMarkPointOuterClass.MapMarkPoint getMarkList(int index) {
                if (this.markListBuilder_ == null) {
                    return this.markList_.get(index);
                }
                return this.markListBuilder_.getMessage(index);
            }

            public Builder setMarkList(int index, MapMarkPointOuterClass.MapMarkPoint value) {
                if (this.markListBuilder_ != null) {
                    this.markListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMarkListIsMutable();
                    this.markList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMarkList(int index, MapMarkPointOuterClass.MapMarkPoint.Builder builderForValue) {
                if (this.markListBuilder_ == null) {
                    ensureMarkListIsMutable();
                    this.markList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.markListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMarkList(MapMarkPointOuterClass.MapMarkPoint value) {
                if (this.markListBuilder_ != null) {
                    this.markListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMarkListIsMutable();
                    this.markList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMarkList(int index, MapMarkPointOuterClass.MapMarkPoint value) {
                if (this.markListBuilder_ != null) {
                    this.markListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMarkListIsMutable();
                    this.markList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMarkList(MapMarkPointOuterClass.MapMarkPoint.Builder builderForValue) {
                if (this.markListBuilder_ == null) {
                    ensureMarkListIsMutable();
                    this.markList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.markListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMarkList(int index, MapMarkPointOuterClass.MapMarkPoint.Builder builderForValue) {
                if (this.markListBuilder_ == null) {
                    ensureMarkListIsMutable();
                    this.markList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.markListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMarkList(Iterable<? extends MapMarkPointOuterClass.MapMarkPoint> values) {
                if (this.markListBuilder_ == null) {
                    ensureMarkListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.markList_);
                    onChanged();
                } else {
                    this.markListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMarkList() {
                if (this.markListBuilder_ == null) {
                    this.markList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.markListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMarkList(int index) {
                if (this.markListBuilder_ == null) {
                    ensureMarkListIsMutable();
                    this.markList_.remove(index);
                    onChanged();
                } else {
                    this.markListBuilder_.remove(index);
                }
                return this;
            }

            public MapMarkPointOuterClass.MapMarkPoint.Builder getMarkListBuilder(int index) {
                return getMarkListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MarkMapRspOuterClass.MarkMapRspOrBuilder
            public MapMarkPointOuterClass.MapMarkPointOrBuilder getMarkListOrBuilder(int index) {
                if (this.markListBuilder_ == null) {
                    return this.markList_.get(index);
                }
                return this.markListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.MarkMapRspOuterClass.MarkMapRspOrBuilder
            public List<? extends MapMarkPointOuterClass.MapMarkPointOrBuilder> getMarkListOrBuilderList() {
                if (this.markListBuilder_ != null) {
                    return this.markListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.markList_);
            }

            public MapMarkPointOuterClass.MapMarkPoint.Builder addMarkListBuilder() {
                return getMarkListFieldBuilder().addBuilder(MapMarkPointOuterClass.MapMarkPoint.getDefaultInstance());
            }

            public MapMarkPointOuterClass.MapMarkPoint.Builder addMarkListBuilder(int index) {
                return getMarkListFieldBuilder().addBuilder(index, MapMarkPointOuterClass.MapMarkPoint.getDefaultInstance());
            }

            public List<MapMarkPointOuterClass.MapMarkPoint.Builder> getMarkListBuilderList() {
                return getMarkListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MapMarkPointOuterClass.MapMarkPoint, MapMarkPointOuterClass.MapMarkPoint.Builder, MapMarkPointOuterClass.MapMarkPointOrBuilder> getMarkListFieldBuilder() {
                if (this.markListBuilder_ == null) {
                    this.markListBuilder_ = new RepeatedFieldBuilderV3<>(this.markList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.markList_ = null;
                }
                return this.markListBuilder_;
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

        public static MarkMapRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MarkMapRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MarkMapRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MarkMapRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MapMarkPointOuterClass.getDescriptor();
    }
}
