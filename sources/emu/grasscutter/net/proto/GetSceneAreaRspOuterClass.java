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
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.CityInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetSceneAreaRspOuterClass.class */
public final class GetSceneAreaRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0015GetSceneAreaRsp.proto\u001a\u000eCityInfo.proto\"h\n\u000fGetSceneAreaRsp\u0012\u0012\n\nareaIdList\u0018\u000b \u0003(\r\u0012\u000f\n\u0007retcode\u0018\u0006 \u0001(\u0005\u0012\u001f\n\fcityInfoList\u0018\u000e \u0003(\u000b2\t.CityInfo\u0012\u000f\n\u0007sceneId\u0018\u0002 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{CityInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetSceneAreaRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetSceneAreaRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetSceneAreaRsp_descriptor, new String[]{"AreaIdList", "Retcode", "CityInfoList", "SceneId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetSceneAreaRspOuterClass$GetSceneAreaRspOrBuilder.class */
    public interface GetSceneAreaRspOrBuilder extends MessageOrBuilder {
        List<Integer> getAreaIdListList();

        int getAreaIdListCount();

        int getAreaIdList(int i);

        int getRetcode();

        List<CityInfoOuterClass.CityInfo> getCityInfoListList();

        CityInfoOuterClass.CityInfo getCityInfoList(int i);

        int getCityInfoListCount();

        List<? extends CityInfoOuterClass.CityInfoOrBuilder> getCityInfoListOrBuilderList();

        CityInfoOuterClass.CityInfoOrBuilder getCityInfoListOrBuilder(int i);

        int getSceneId();
    }

    private GetSceneAreaRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetSceneAreaRspOuterClass$GetSceneAreaRsp.class */
    public static final class GetSceneAreaRsp extends GeneratedMessageV3 implements GetSceneAreaRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int AREAIDLIST_FIELD_NUMBER = 11;
        private Internal.IntList areaIdList_;
        private int areaIdListMemoizedSerializedSize;
        public static final int RETCODE_FIELD_NUMBER = 6;
        private int retcode_;
        public static final int CITYINFOLIST_FIELD_NUMBER = 14;
        private List<CityInfoOuterClass.CityInfo> cityInfoList_;
        public static final int SCENEID_FIELD_NUMBER = 2;
        private int sceneId_;
        private byte memoizedIsInitialized;
        private static final GetSceneAreaRsp DEFAULT_INSTANCE = new GetSceneAreaRsp();
        private static final Parser<GetSceneAreaRsp> PARSER = new AbstractParser<GetSceneAreaRsp>() { // from class: emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRsp.1
            @Override // com.google.protobuf.Parser
            public GetSceneAreaRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetSceneAreaRsp(input, extensionRegistry);
            }
        };

        private GetSceneAreaRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.areaIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private GetSceneAreaRsp() {
            this.areaIdListMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.areaIdList_ = emptyIntList();
            this.cityInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetSceneAreaRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:72:0x0120 */
        private GetSceneAreaRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 16:
                                this.sceneId_ = input.readUInt32();
                                break;
                            case 48:
                                this.retcode_ = input.readInt32();
                                break;
                            case 88:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.areaIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.areaIdList_.addInt(input.readUInt32());
                                break;
                            case 90:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.areaIdList_ = newIntList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.areaIdList_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 114:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.cityInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.cityInfoList_.add((CityInfoOuterClass.CityInfo) input.readMessage(CityInfoOuterClass.CityInfo.parser(), extensionRegistry));
                                break;
                            default:
                                if (parseUnknownField(input, unknownFields, extensionRegistry, tag)) {
                                    break;
                                } else {
                                    done = true;
                                    break;
                                }
                        }
                        done = done;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.areaIdList_.makeImmutable();
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.cityInfoList_ = Collections.unmodifiableList(this.cityInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetSceneAreaRspOuterClass.internal_static_GetSceneAreaRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetSceneAreaRspOuterClass.internal_static_GetSceneAreaRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetSceneAreaRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
        public List<Integer> getAreaIdListList() {
            return this.areaIdList_;
        }

        @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
        public int getAreaIdListCount() {
            return this.areaIdList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
        public int getAreaIdList(int index) {
            return this.areaIdList_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
        public List<CityInfoOuterClass.CityInfo> getCityInfoListList() {
            return this.cityInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
        public List<? extends CityInfoOuterClass.CityInfoOrBuilder> getCityInfoListOrBuilderList() {
            return this.cityInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
        public int getCityInfoListCount() {
            return this.cityInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
        public CityInfoOuterClass.CityInfo getCityInfoList(int index) {
            return this.cityInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
        public CityInfoOuterClass.CityInfoOrBuilder getCityInfoListOrBuilder(int index) {
            return this.cityInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
        public int getSceneId() {
            return this.sceneId_;
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
            getSerializedSize();
            if (this.sceneId_ != 0) {
                output.writeUInt32(2, this.sceneId_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(6, this.retcode_);
            }
            if (getAreaIdListList().size() > 0) {
                output.writeUInt32NoTag(90);
                output.writeUInt32NoTag(this.areaIdListMemoizedSerializedSize);
            }
            for (int i = 0; i < this.areaIdList_.size(); i++) {
                output.writeUInt32NoTag(this.areaIdList_.getInt(i));
            }
            for (int i2 = 0; i2 < this.cityInfoList_.size(); i2++) {
                output.writeMessage(14, this.cityInfoList_.get(i2));
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
            if (this.sceneId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(2, this.sceneId_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(6, this.retcode_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.areaIdList_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.areaIdList_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getAreaIdListList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.areaIdListMemoizedSerializedSize = dataSize;
            for (int i2 = 0; i2 < this.cityInfoList_.size(); i2++) {
                size3 += CodedOutputStream.computeMessageSize(14, this.cityInfoList_.get(i2));
            }
            int size4 = size3 + this.unknownFields.getSerializedSize();
            this.memoizedSize = size4;
            return size4;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof GetSceneAreaRsp)) {
                return equals(obj);
            }
            GetSceneAreaRsp other = (GetSceneAreaRsp) obj;
            return getAreaIdListList().equals(other.getAreaIdListList()) && getRetcode() == other.getRetcode() && getCityInfoListList().equals(other.getCityInfoListList()) && getSceneId() == other.getSceneId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getAreaIdListCount() > 0) {
                hash = (53 * ((37 * hash) + 11)) + getAreaIdListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 6)) + getRetcode();
            if (getCityInfoListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 14)) + getCityInfoListList().hashCode();
            }
            int hash3 = (29 * ((53 * ((37 * hash2) + 2)) + getSceneId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static GetSceneAreaRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetSceneAreaRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetSceneAreaRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetSceneAreaRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetSceneAreaRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetSceneAreaRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetSceneAreaRsp parseFrom(InputStream input) throws IOException {
            return (GetSceneAreaRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetSceneAreaRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetSceneAreaRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetSceneAreaRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetSceneAreaRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetSceneAreaRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetSceneAreaRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetSceneAreaRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetSceneAreaRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetSceneAreaRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetSceneAreaRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetSceneAreaRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetSceneAreaRspOuterClass$GetSceneAreaRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetSceneAreaRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private RepeatedFieldBuilderV3<CityInfoOuterClass.CityInfo, CityInfoOuterClass.CityInfo.Builder, CityInfoOuterClass.CityInfoOrBuilder> cityInfoListBuilder_;
            private int sceneId_;
            private Internal.IntList areaIdList_ = GetSceneAreaRsp.emptyIntList();
            private List<CityInfoOuterClass.CityInfo> cityInfoList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return GetSceneAreaRspOuterClass.internal_static_GetSceneAreaRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetSceneAreaRspOuterClass.internal_static_GetSceneAreaRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetSceneAreaRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetSceneAreaRsp.alwaysUseFieldBuilders) {
                    getCityInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.areaIdList_ = GetSceneAreaRsp.emptyIntList();
                this.bitField0_ &= -2;
                this.retcode_ = 0;
                if (this.cityInfoListBuilder_ == null) {
                    this.cityInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.cityInfoListBuilder_.clear();
                }
                this.sceneId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetSceneAreaRspOuterClass.internal_static_GetSceneAreaRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetSceneAreaRsp getDefaultInstanceForType() {
                return GetSceneAreaRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetSceneAreaRsp build() {
                GetSceneAreaRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetSceneAreaRsp buildPartial() {
                GetSceneAreaRsp result = new GetSceneAreaRsp(this);
                int i = this.bitField0_;
                if ((this.bitField0_ & 1) != 0) {
                    this.areaIdList_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.areaIdList_ = this.areaIdList_;
                result.retcode_ = this.retcode_;
                if (this.cityInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.cityInfoList_ = Collections.unmodifiableList(this.cityInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.cityInfoList_ = this.cityInfoList_;
                } else {
                    result.cityInfoList_ = this.cityInfoListBuilder_.build();
                }
                result.sceneId_ = this.sceneId_;
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
                if (other instanceof GetSceneAreaRsp) {
                    return mergeFrom((GetSceneAreaRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetSceneAreaRsp other) {
                if (other == GetSceneAreaRsp.getDefaultInstance()) {
                    return this;
                }
                if (!other.areaIdList_.isEmpty()) {
                    if (this.areaIdList_.isEmpty()) {
                        this.areaIdList_ = other.areaIdList_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureAreaIdListIsMutable();
                        this.areaIdList_.addAll(other.areaIdList_);
                    }
                    onChanged();
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (this.cityInfoListBuilder_ == null) {
                    if (!other.cityInfoList_.isEmpty()) {
                        if (this.cityInfoList_.isEmpty()) {
                            this.cityInfoList_ = other.cityInfoList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureCityInfoListIsMutable();
                            this.cityInfoList_.addAll(other.cityInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.cityInfoList_.isEmpty()) {
                    if (this.cityInfoListBuilder_.isEmpty()) {
                        this.cityInfoListBuilder_.dispose();
                        this.cityInfoListBuilder_ = null;
                        this.cityInfoList_ = other.cityInfoList_;
                        this.bitField0_ &= -3;
                        this.cityInfoListBuilder_ = GetSceneAreaRsp.alwaysUseFieldBuilders ? getCityInfoListFieldBuilder() : null;
                    } else {
                        this.cityInfoListBuilder_.addAllMessages(other.cityInfoList_);
                    }
                }
                if (other.getSceneId() != 0) {
                    setSceneId(other.getSceneId());
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
                GetSceneAreaRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetSceneAreaRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetSceneAreaRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureAreaIdListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.areaIdList_ = GetSceneAreaRsp.mutableCopy(this.areaIdList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
            public List<Integer> getAreaIdListList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.areaIdList_) : this.areaIdList_;
            }

            @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
            public int getAreaIdListCount() {
                return this.areaIdList_.size();
            }

            @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
            public int getAreaIdList(int index) {
                return this.areaIdList_.getInt(index);
            }

            public Builder setAreaIdList(int index, int value) {
                ensureAreaIdListIsMutable();
                this.areaIdList_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addAreaIdList(int value) {
                ensureAreaIdListIsMutable();
                this.areaIdList_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllAreaIdList(Iterable<? extends Integer> values) {
                ensureAreaIdListIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.areaIdList_);
                onChanged();
                return this;
            }

            public Builder clearAreaIdList() {
                this.areaIdList_ = GetSceneAreaRsp.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
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

            private void ensureCityInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.cityInfoList_ = new ArrayList(this.cityInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
            public List<CityInfoOuterClass.CityInfo> getCityInfoListList() {
                if (this.cityInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.cityInfoList_);
                }
                return this.cityInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
            public int getCityInfoListCount() {
                if (this.cityInfoListBuilder_ == null) {
                    return this.cityInfoList_.size();
                }
                return this.cityInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
            public CityInfoOuterClass.CityInfo getCityInfoList(int index) {
                if (this.cityInfoListBuilder_ == null) {
                    return this.cityInfoList_.get(index);
                }
                return this.cityInfoListBuilder_.getMessage(index);
            }

            public Builder setCityInfoList(int index, CityInfoOuterClass.CityInfo value) {
                if (this.cityInfoListBuilder_ != null) {
                    this.cityInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCityInfoListIsMutable();
                    this.cityInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setCityInfoList(int index, CityInfoOuterClass.CityInfo.Builder builderForValue) {
                if (this.cityInfoListBuilder_ == null) {
                    ensureCityInfoListIsMutable();
                    this.cityInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.cityInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addCityInfoList(CityInfoOuterClass.CityInfo value) {
                if (this.cityInfoListBuilder_ != null) {
                    this.cityInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCityInfoListIsMutable();
                    this.cityInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addCityInfoList(int index, CityInfoOuterClass.CityInfo value) {
                if (this.cityInfoListBuilder_ != null) {
                    this.cityInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureCityInfoListIsMutable();
                    this.cityInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addCityInfoList(CityInfoOuterClass.CityInfo.Builder builderForValue) {
                if (this.cityInfoListBuilder_ == null) {
                    ensureCityInfoListIsMutable();
                    this.cityInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.cityInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addCityInfoList(int index, CityInfoOuterClass.CityInfo.Builder builderForValue) {
                if (this.cityInfoListBuilder_ == null) {
                    ensureCityInfoListIsMutable();
                    this.cityInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.cityInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllCityInfoList(Iterable<? extends CityInfoOuterClass.CityInfo> values) {
                if (this.cityInfoListBuilder_ == null) {
                    ensureCityInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.cityInfoList_);
                    onChanged();
                } else {
                    this.cityInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearCityInfoList() {
                if (this.cityInfoListBuilder_ == null) {
                    this.cityInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.cityInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeCityInfoList(int index) {
                if (this.cityInfoListBuilder_ == null) {
                    ensureCityInfoListIsMutable();
                    this.cityInfoList_.remove(index);
                    onChanged();
                } else {
                    this.cityInfoListBuilder_.remove(index);
                }
                return this;
            }

            public CityInfoOuterClass.CityInfo.Builder getCityInfoListBuilder(int index) {
                return getCityInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
            public CityInfoOuterClass.CityInfoOrBuilder getCityInfoListOrBuilder(int index) {
                if (this.cityInfoListBuilder_ == null) {
                    return this.cityInfoList_.get(index);
                }
                return this.cityInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
            public List<? extends CityInfoOuterClass.CityInfoOrBuilder> getCityInfoListOrBuilderList() {
                if (this.cityInfoListBuilder_ != null) {
                    return this.cityInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.cityInfoList_);
            }

            public CityInfoOuterClass.CityInfo.Builder addCityInfoListBuilder() {
                return getCityInfoListFieldBuilder().addBuilder(CityInfoOuterClass.CityInfo.getDefaultInstance());
            }

            public CityInfoOuterClass.CityInfo.Builder addCityInfoListBuilder(int index) {
                return getCityInfoListFieldBuilder().addBuilder(index, CityInfoOuterClass.CityInfo.getDefaultInstance());
            }

            public List<CityInfoOuterClass.CityInfo.Builder> getCityInfoListBuilderList() {
                return getCityInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<CityInfoOuterClass.CityInfo, CityInfoOuterClass.CityInfo.Builder, CityInfoOuterClass.CityInfoOrBuilder> getCityInfoListFieldBuilder() {
                if (this.cityInfoListBuilder_ == null) {
                    this.cityInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.cityInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.cityInfoList_ = null;
                }
                return this.cityInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GetSceneAreaRspOuterClass.GetSceneAreaRspOrBuilder
            public int getSceneId() {
                return this.sceneId_;
            }

            public Builder setSceneId(int value) {
                this.sceneId_ = value;
                onChanged();
                return this;
            }

            public Builder clearSceneId() {
                this.sceneId_ = 0;
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

        public static GetSceneAreaRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetSceneAreaRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetSceneAreaRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetSceneAreaRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CityInfoOuterClass.getDescriptor();
    }
}
