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
import emu.grasscutter.net.proto.MapAreaInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetMapAreaRspOuterClass.class */
public final class GetMapAreaRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0013GetMapAreaRsp.proto\u001a\u0011MapAreaInfo.proto\"G\n\rGetMapAreaRsp\u0012%\n\u000fmapAreaInfoList\u0018\u0003 \u0003(\u000b2\f.MapAreaInfo\u0012\u000f\n\u0007retcode\u0018\u0002 \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{MapAreaInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetMapAreaRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetMapAreaRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetMapAreaRsp_descriptor, new String[]{"MapAreaInfoList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetMapAreaRspOuterClass$GetMapAreaRspOrBuilder.class */
    public interface GetMapAreaRspOrBuilder extends MessageOrBuilder {
        List<MapAreaInfoOuterClass.MapAreaInfo> getMapAreaInfoListList();

        MapAreaInfoOuterClass.MapAreaInfo getMapAreaInfoList(int i);

        int getMapAreaInfoListCount();

        List<? extends MapAreaInfoOuterClass.MapAreaInfoOrBuilder> getMapAreaInfoListOrBuilderList();

        MapAreaInfoOuterClass.MapAreaInfoOrBuilder getMapAreaInfoListOrBuilder(int i);

        int getRetcode();
    }

    private GetMapAreaRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetMapAreaRspOuterClass$GetMapAreaRsp.class */
    public static final class GetMapAreaRsp extends GeneratedMessageV3 implements GetMapAreaRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MAPAREAINFOLIST_FIELD_NUMBER = 3;
        private List<MapAreaInfoOuterClass.MapAreaInfo> mapAreaInfoList_;
        public static final int RETCODE_FIELD_NUMBER = 2;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final GetMapAreaRsp DEFAULT_INSTANCE = new GetMapAreaRsp();
        private static final Parser<GetMapAreaRsp> PARSER = new AbstractParser<GetMapAreaRsp>() { // from class: emu.grasscutter.net.proto.GetMapAreaRspOuterClass.GetMapAreaRsp.1
            @Override // com.google.protobuf.Parser
            public GetMapAreaRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetMapAreaRsp(input, extensionRegistry);
            }
        };

        private GetMapAreaRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetMapAreaRsp() {
            this.memoizedIsInitialized = -1;
            this.mapAreaInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetMapAreaRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetMapAreaRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 16:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 26:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.mapAreaInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.mapAreaInfoList_.add((MapAreaInfoOuterClass.MapAreaInfo) input.readMessage(MapAreaInfoOuterClass.MapAreaInfo.parser(), extensionRegistry));
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
                    this.mapAreaInfoList_ = Collections.unmodifiableList(this.mapAreaInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetMapAreaRspOuterClass.internal_static_GetMapAreaRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetMapAreaRspOuterClass.internal_static_GetMapAreaRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMapAreaRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetMapAreaRspOuterClass.GetMapAreaRspOrBuilder
        public List<MapAreaInfoOuterClass.MapAreaInfo> getMapAreaInfoListList() {
            return this.mapAreaInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetMapAreaRspOuterClass.GetMapAreaRspOrBuilder
        public List<? extends MapAreaInfoOuterClass.MapAreaInfoOrBuilder> getMapAreaInfoListOrBuilderList() {
            return this.mapAreaInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetMapAreaRspOuterClass.GetMapAreaRspOrBuilder
        public int getMapAreaInfoListCount() {
            return this.mapAreaInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetMapAreaRspOuterClass.GetMapAreaRspOrBuilder
        public MapAreaInfoOuterClass.MapAreaInfo getMapAreaInfoList(int index) {
            return this.mapAreaInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetMapAreaRspOuterClass.GetMapAreaRspOrBuilder
        public MapAreaInfoOuterClass.MapAreaInfoOrBuilder getMapAreaInfoListOrBuilder(int index) {
            return this.mapAreaInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetMapAreaRspOuterClass.GetMapAreaRspOrBuilder
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
                output.writeInt32(2, this.retcode_);
            }
            for (int i = 0; i < this.mapAreaInfoList_.size(); i++) {
                output.writeMessage(3, this.mapAreaInfoList_.get(i));
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
                size2 = 0 + CodedOutputStream.computeInt32Size(2, this.retcode_);
            }
            for (int i = 0; i < this.mapAreaInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.mapAreaInfoList_.get(i));
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
            if (!(obj instanceof GetMapAreaRsp)) {
                return equals(obj);
            }
            GetMapAreaRsp other = (GetMapAreaRsp) obj;
            return getMapAreaInfoListList().equals(other.getMapAreaInfoListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getMapAreaInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getMapAreaInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 2)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetMapAreaRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetMapAreaRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMapAreaRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetMapAreaRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMapAreaRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetMapAreaRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetMapAreaRsp parseFrom(InputStream input) throws IOException {
            return (GetMapAreaRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetMapAreaRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMapAreaRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetMapAreaRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetMapAreaRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetMapAreaRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMapAreaRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetMapAreaRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetMapAreaRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetMapAreaRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetMapAreaRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetMapAreaRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetMapAreaRspOuterClass$GetMapAreaRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetMapAreaRspOrBuilder {
            private int bitField0_;
            private List<MapAreaInfoOuterClass.MapAreaInfo> mapAreaInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<MapAreaInfoOuterClass.MapAreaInfo, MapAreaInfoOuterClass.MapAreaInfo.Builder, MapAreaInfoOuterClass.MapAreaInfoOrBuilder> mapAreaInfoListBuilder_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetMapAreaRspOuterClass.internal_static_GetMapAreaRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetMapAreaRspOuterClass.internal_static_GetMapAreaRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetMapAreaRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetMapAreaRsp.alwaysUseFieldBuilders) {
                    getMapAreaInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.mapAreaInfoListBuilder_ == null) {
                    this.mapAreaInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.mapAreaInfoListBuilder_.clear();
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetMapAreaRspOuterClass.internal_static_GetMapAreaRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetMapAreaRsp getDefaultInstanceForType() {
                return GetMapAreaRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetMapAreaRsp build() {
                GetMapAreaRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetMapAreaRsp buildPartial() {
                GetMapAreaRsp result = new GetMapAreaRsp(this);
                int i = this.bitField0_;
                if (this.mapAreaInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.mapAreaInfoList_ = Collections.unmodifiableList(this.mapAreaInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.mapAreaInfoList_ = this.mapAreaInfoList_;
                } else {
                    result.mapAreaInfoList_ = this.mapAreaInfoListBuilder_.build();
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
                if (other instanceof GetMapAreaRsp) {
                    return mergeFrom((GetMapAreaRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetMapAreaRsp other) {
                if (other == GetMapAreaRsp.getDefaultInstance()) {
                    return this;
                }
                if (this.mapAreaInfoListBuilder_ == null) {
                    if (!other.mapAreaInfoList_.isEmpty()) {
                        if (this.mapAreaInfoList_.isEmpty()) {
                            this.mapAreaInfoList_ = other.mapAreaInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureMapAreaInfoListIsMutable();
                            this.mapAreaInfoList_.addAll(other.mapAreaInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.mapAreaInfoList_.isEmpty()) {
                    if (this.mapAreaInfoListBuilder_.isEmpty()) {
                        this.mapAreaInfoListBuilder_.dispose();
                        this.mapAreaInfoListBuilder_ = null;
                        this.mapAreaInfoList_ = other.mapAreaInfoList_;
                        this.bitField0_ &= -2;
                        this.mapAreaInfoListBuilder_ = GetMapAreaRsp.alwaysUseFieldBuilders ? getMapAreaInfoListFieldBuilder() : null;
                    } else {
                        this.mapAreaInfoListBuilder_.addAllMessages(other.mapAreaInfoList_);
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
                GetMapAreaRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetMapAreaRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetMapAreaRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureMapAreaInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.mapAreaInfoList_ = new ArrayList(this.mapAreaInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetMapAreaRspOuterClass.GetMapAreaRspOrBuilder
            public List<MapAreaInfoOuterClass.MapAreaInfo> getMapAreaInfoListList() {
                if (this.mapAreaInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.mapAreaInfoList_);
                }
                return this.mapAreaInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetMapAreaRspOuterClass.GetMapAreaRspOrBuilder
            public int getMapAreaInfoListCount() {
                if (this.mapAreaInfoListBuilder_ == null) {
                    return this.mapAreaInfoList_.size();
                }
                return this.mapAreaInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetMapAreaRspOuterClass.GetMapAreaRspOrBuilder
            public MapAreaInfoOuterClass.MapAreaInfo getMapAreaInfoList(int index) {
                if (this.mapAreaInfoListBuilder_ == null) {
                    return this.mapAreaInfoList_.get(index);
                }
                return this.mapAreaInfoListBuilder_.getMessage(index);
            }

            public Builder setMapAreaInfoList(int index, MapAreaInfoOuterClass.MapAreaInfo value) {
                if (this.mapAreaInfoListBuilder_ != null) {
                    this.mapAreaInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMapAreaInfoListIsMutable();
                    this.mapAreaInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMapAreaInfoList(int index, MapAreaInfoOuterClass.MapAreaInfo.Builder builderForValue) {
                if (this.mapAreaInfoListBuilder_ == null) {
                    ensureMapAreaInfoListIsMutable();
                    this.mapAreaInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.mapAreaInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMapAreaInfoList(MapAreaInfoOuterClass.MapAreaInfo value) {
                if (this.mapAreaInfoListBuilder_ != null) {
                    this.mapAreaInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMapAreaInfoListIsMutable();
                    this.mapAreaInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMapAreaInfoList(int index, MapAreaInfoOuterClass.MapAreaInfo value) {
                if (this.mapAreaInfoListBuilder_ != null) {
                    this.mapAreaInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMapAreaInfoListIsMutable();
                    this.mapAreaInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMapAreaInfoList(MapAreaInfoOuterClass.MapAreaInfo.Builder builderForValue) {
                if (this.mapAreaInfoListBuilder_ == null) {
                    ensureMapAreaInfoListIsMutable();
                    this.mapAreaInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.mapAreaInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMapAreaInfoList(int index, MapAreaInfoOuterClass.MapAreaInfo.Builder builderForValue) {
                if (this.mapAreaInfoListBuilder_ == null) {
                    ensureMapAreaInfoListIsMutable();
                    this.mapAreaInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.mapAreaInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMapAreaInfoList(Iterable<? extends MapAreaInfoOuterClass.MapAreaInfo> values) {
                if (this.mapAreaInfoListBuilder_ == null) {
                    ensureMapAreaInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.mapAreaInfoList_);
                    onChanged();
                } else {
                    this.mapAreaInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMapAreaInfoList() {
                if (this.mapAreaInfoListBuilder_ == null) {
                    this.mapAreaInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.mapAreaInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeMapAreaInfoList(int index) {
                if (this.mapAreaInfoListBuilder_ == null) {
                    ensureMapAreaInfoListIsMutable();
                    this.mapAreaInfoList_.remove(index);
                    onChanged();
                } else {
                    this.mapAreaInfoListBuilder_.remove(index);
                }
                return this;
            }

            public MapAreaInfoOuterClass.MapAreaInfo.Builder getMapAreaInfoListBuilder(int index) {
                return getMapAreaInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetMapAreaRspOuterClass.GetMapAreaRspOrBuilder
            public MapAreaInfoOuterClass.MapAreaInfoOrBuilder getMapAreaInfoListOrBuilder(int index) {
                if (this.mapAreaInfoListBuilder_ == null) {
                    return this.mapAreaInfoList_.get(index);
                }
                return this.mapAreaInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetMapAreaRspOuterClass.GetMapAreaRspOrBuilder
            public List<? extends MapAreaInfoOuterClass.MapAreaInfoOrBuilder> getMapAreaInfoListOrBuilderList() {
                if (this.mapAreaInfoListBuilder_ != null) {
                    return this.mapAreaInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.mapAreaInfoList_);
            }

            public MapAreaInfoOuterClass.MapAreaInfo.Builder addMapAreaInfoListBuilder() {
                return getMapAreaInfoListFieldBuilder().addBuilder(MapAreaInfoOuterClass.MapAreaInfo.getDefaultInstance());
            }

            public MapAreaInfoOuterClass.MapAreaInfo.Builder addMapAreaInfoListBuilder(int index) {
                return getMapAreaInfoListFieldBuilder().addBuilder(index, MapAreaInfoOuterClass.MapAreaInfo.getDefaultInstance());
            }

            public List<MapAreaInfoOuterClass.MapAreaInfo.Builder> getMapAreaInfoListBuilderList() {
                return getMapAreaInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<MapAreaInfoOuterClass.MapAreaInfo, MapAreaInfoOuterClass.MapAreaInfo.Builder, MapAreaInfoOuterClass.MapAreaInfoOrBuilder> getMapAreaInfoListFieldBuilder() {
                if (this.mapAreaInfoListBuilder_ == null) {
                    this.mapAreaInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.mapAreaInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.mapAreaInfoList_ = null;
                }
                return this.mapAreaInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GetMapAreaRspOuterClass.GetMapAreaRspOrBuilder
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

        public static GetMapAreaRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetMapAreaRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetMapAreaRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetMapAreaRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        MapAreaInfoOuterClass.getDescriptor();
    }
}
