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
import emu.grasscutter.net.proto.DailyDungeonEntryInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetDailyDungeonEntryInfoRspOuterClass.class */
public final class GetDailyDungeonEntryInfoRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n!GetDailyDungeonEntryInfoRsp.proto\u001a\u001bDailyDungeonEntryInfo.proto\"g\n\u001bGetDailyDungeonEntryInfoRsp\u00127\n\u0017daily_dungeon_info_list\u0018\u0001 \u0003(\u000b2\u0016.DailyDungeonEntryInfo\u0012\u000f\n\u0007retcode\u0018\t \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{DailyDungeonEntryInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_GetDailyDungeonEntryInfoRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_GetDailyDungeonEntryInfoRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_GetDailyDungeonEntryInfoRsp_descriptor, new String[]{"DailyDungeonInfoList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetDailyDungeonEntryInfoRspOuterClass$GetDailyDungeonEntryInfoRspOrBuilder.class */
    public interface GetDailyDungeonEntryInfoRspOrBuilder extends MessageOrBuilder {
        List<DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo> getDailyDungeonInfoListList();

        DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo getDailyDungeonInfoList(int i);

        int getDailyDungeonInfoListCount();

        List<? extends DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder> getDailyDungeonInfoListOrBuilderList();

        DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder getDailyDungeonInfoListOrBuilder(int i);

        int getRetcode();
    }

    private GetDailyDungeonEntryInfoRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetDailyDungeonEntryInfoRspOuterClass$GetDailyDungeonEntryInfoRsp.class */
    public static final class GetDailyDungeonEntryInfoRsp extends GeneratedMessageV3 implements GetDailyDungeonEntryInfoRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int DAILY_DUNGEON_INFO_LIST_FIELD_NUMBER = 1;
        private List<DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo> dailyDungeonInfoList_;
        public static final int RETCODE_FIELD_NUMBER = 9;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final GetDailyDungeonEntryInfoRsp DEFAULT_INSTANCE = new GetDailyDungeonEntryInfoRsp();
        private static final Parser<GetDailyDungeonEntryInfoRsp> PARSER = new AbstractParser<GetDailyDungeonEntryInfoRsp>() { // from class: emu.grasscutter.net.proto.GetDailyDungeonEntryInfoRspOuterClass.GetDailyDungeonEntryInfoRsp.1
            @Override // com.google.protobuf.Parser
            public GetDailyDungeonEntryInfoRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new GetDailyDungeonEntryInfoRsp(input, extensionRegistry);
            }
        };

        private GetDailyDungeonEntryInfoRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private GetDailyDungeonEntryInfoRsp() {
            this.memoizedIsInitialized = -1;
            this.dailyDungeonInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new GetDailyDungeonEntryInfoRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private GetDailyDungeonEntryInfoRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                        this.dailyDungeonInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.dailyDungeonInfoList_.add((DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo) input.readMessage(DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo.parser(), extensionRegistry));
                                    break;
                                case 72:
                                    this.retcode_ = input.readInt32();
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
                    this.dailyDungeonInfoList_ = Collections.unmodifiableList(this.dailyDungeonInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return GetDailyDungeonEntryInfoRspOuterClass.internal_static_GetDailyDungeonEntryInfoRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return GetDailyDungeonEntryInfoRspOuterClass.internal_static_GetDailyDungeonEntryInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetDailyDungeonEntryInfoRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.GetDailyDungeonEntryInfoRspOuterClass.GetDailyDungeonEntryInfoRspOrBuilder
        public List<DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo> getDailyDungeonInfoListList() {
            return this.dailyDungeonInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetDailyDungeonEntryInfoRspOuterClass.GetDailyDungeonEntryInfoRspOrBuilder
        public List<? extends DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder> getDailyDungeonInfoListOrBuilderList() {
            return this.dailyDungeonInfoList_;
        }

        @Override // emu.grasscutter.net.proto.GetDailyDungeonEntryInfoRspOuterClass.GetDailyDungeonEntryInfoRspOrBuilder
        public int getDailyDungeonInfoListCount() {
            return this.dailyDungeonInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.GetDailyDungeonEntryInfoRspOuterClass.GetDailyDungeonEntryInfoRspOrBuilder
        public DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo getDailyDungeonInfoList(int index) {
            return this.dailyDungeonInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetDailyDungeonEntryInfoRspOuterClass.GetDailyDungeonEntryInfoRspOrBuilder
        public DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder getDailyDungeonInfoListOrBuilder(int index) {
            return this.dailyDungeonInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.GetDailyDungeonEntryInfoRspOuterClass.GetDailyDungeonEntryInfoRspOrBuilder
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
            for (int i = 0; i < this.dailyDungeonInfoList_.size(); i++) {
                output.writeMessage(1, this.dailyDungeonInfoList_.get(i));
            }
            if (this.retcode_ != 0) {
                output.writeInt32(9, this.retcode_);
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
            for (int i = 0; i < this.dailyDungeonInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(1, this.dailyDungeonInfoList_.get(i));
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(9, this.retcode_);
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
            if (!(obj instanceof GetDailyDungeonEntryInfoRsp)) {
                return equals(obj);
            }
            GetDailyDungeonEntryInfoRsp other = (GetDailyDungeonEntryInfoRsp) obj;
            return getDailyDungeonInfoListList().equals(other.getDailyDungeonInfoListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getDailyDungeonInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 1)) + getDailyDungeonInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 9)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static GetDailyDungeonEntryInfoRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetDailyDungeonEntryInfoRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetDailyDungeonEntryInfoRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetDailyDungeonEntryInfoRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetDailyDungeonEntryInfoRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static GetDailyDungeonEntryInfoRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static GetDailyDungeonEntryInfoRsp parseFrom(InputStream input) throws IOException {
            return (GetDailyDungeonEntryInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetDailyDungeonEntryInfoRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailyDungeonEntryInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetDailyDungeonEntryInfoRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (GetDailyDungeonEntryInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static GetDailyDungeonEntryInfoRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailyDungeonEntryInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static GetDailyDungeonEntryInfoRsp parseFrom(CodedInputStream input) throws IOException {
            return (GetDailyDungeonEntryInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static GetDailyDungeonEntryInfoRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetDailyDungeonEntryInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(GetDailyDungeonEntryInfoRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/GetDailyDungeonEntryInfoRspOuterClass$GetDailyDungeonEntryInfoRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements GetDailyDungeonEntryInfoRspOrBuilder {
            private int bitField0_;
            private List<DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo> dailyDungeonInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo, DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo.Builder, DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder> dailyDungeonInfoListBuilder_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return GetDailyDungeonEntryInfoRspOuterClass.internal_static_GetDailyDungeonEntryInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return GetDailyDungeonEntryInfoRspOuterClass.internal_static_GetDailyDungeonEntryInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(GetDailyDungeonEntryInfoRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (GetDailyDungeonEntryInfoRsp.alwaysUseFieldBuilders) {
                    getDailyDungeonInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.dailyDungeonInfoListBuilder_ == null) {
                    this.dailyDungeonInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.dailyDungeonInfoListBuilder_.clear();
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return GetDailyDungeonEntryInfoRspOuterClass.internal_static_GetDailyDungeonEntryInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public GetDailyDungeonEntryInfoRsp getDefaultInstanceForType() {
                return GetDailyDungeonEntryInfoRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetDailyDungeonEntryInfoRsp build() {
                GetDailyDungeonEntryInfoRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public GetDailyDungeonEntryInfoRsp buildPartial() {
                GetDailyDungeonEntryInfoRsp result = new GetDailyDungeonEntryInfoRsp(this);
                int i = this.bitField0_;
                if (this.dailyDungeonInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.dailyDungeonInfoList_ = Collections.unmodifiableList(this.dailyDungeonInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.dailyDungeonInfoList_ = this.dailyDungeonInfoList_;
                } else {
                    result.dailyDungeonInfoList_ = this.dailyDungeonInfoListBuilder_.build();
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
                if (other instanceof GetDailyDungeonEntryInfoRsp) {
                    return mergeFrom((GetDailyDungeonEntryInfoRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(GetDailyDungeonEntryInfoRsp other) {
                if (other == GetDailyDungeonEntryInfoRsp.getDefaultInstance()) {
                    return this;
                }
                if (this.dailyDungeonInfoListBuilder_ == null) {
                    if (!other.dailyDungeonInfoList_.isEmpty()) {
                        if (this.dailyDungeonInfoList_.isEmpty()) {
                            this.dailyDungeonInfoList_ = other.dailyDungeonInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDailyDungeonInfoListIsMutable();
                            this.dailyDungeonInfoList_.addAll(other.dailyDungeonInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.dailyDungeonInfoList_.isEmpty()) {
                    if (this.dailyDungeonInfoListBuilder_.isEmpty()) {
                        this.dailyDungeonInfoListBuilder_.dispose();
                        this.dailyDungeonInfoListBuilder_ = null;
                        this.dailyDungeonInfoList_ = other.dailyDungeonInfoList_;
                        this.bitField0_ &= -2;
                        this.dailyDungeonInfoListBuilder_ = GetDailyDungeonEntryInfoRsp.alwaysUseFieldBuilders ? getDailyDungeonInfoListFieldBuilder() : null;
                    } else {
                        this.dailyDungeonInfoListBuilder_.addAllMessages(other.dailyDungeonInfoList_);
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
                GetDailyDungeonEntryInfoRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = GetDailyDungeonEntryInfoRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (GetDailyDungeonEntryInfoRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureDailyDungeonInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.dailyDungeonInfoList_ = new ArrayList(this.dailyDungeonInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.GetDailyDungeonEntryInfoRspOuterClass.GetDailyDungeonEntryInfoRspOrBuilder
            public List<DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo> getDailyDungeonInfoListList() {
                if (this.dailyDungeonInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.dailyDungeonInfoList_);
                }
                return this.dailyDungeonInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.GetDailyDungeonEntryInfoRspOuterClass.GetDailyDungeonEntryInfoRspOrBuilder
            public int getDailyDungeonInfoListCount() {
                if (this.dailyDungeonInfoListBuilder_ == null) {
                    return this.dailyDungeonInfoList_.size();
                }
                return this.dailyDungeonInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.GetDailyDungeonEntryInfoRspOuterClass.GetDailyDungeonEntryInfoRspOrBuilder
            public DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo getDailyDungeonInfoList(int index) {
                if (this.dailyDungeonInfoListBuilder_ == null) {
                    return this.dailyDungeonInfoList_.get(index);
                }
                return this.dailyDungeonInfoListBuilder_.getMessage(index);
            }

            public Builder setDailyDungeonInfoList(int index, DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo value) {
                if (this.dailyDungeonInfoListBuilder_ != null) {
                    this.dailyDungeonInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDailyDungeonInfoListIsMutable();
                    this.dailyDungeonInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDailyDungeonInfoList(int index, DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo.Builder builderForValue) {
                if (this.dailyDungeonInfoListBuilder_ == null) {
                    ensureDailyDungeonInfoListIsMutable();
                    this.dailyDungeonInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dailyDungeonInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDailyDungeonInfoList(DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo value) {
                if (this.dailyDungeonInfoListBuilder_ != null) {
                    this.dailyDungeonInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDailyDungeonInfoListIsMutable();
                    this.dailyDungeonInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDailyDungeonInfoList(int index, DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo value) {
                if (this.dailyDungeonInfoListBuilder_ != null) {
                    this.dailyDungeonInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDailyDungeonInfoListIsMutable();
                    this.dailyDungeonInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDailyDungeonInfoList(DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo.Builder builderForValue) {
                if (this.dailyDungeonInfoListBuilder_ == null) {
                    ensureDailyDungeonInfoListIsMutable();
                    this.dailyDungeonInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dailyDungeonInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDailyDungeonInfoList(int index, DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo.Builder builderForValue) {
                if (this.dailyDungeonInfoListBuilder_ == null) {
                    ensureDailyDungeonInfoListIsMutable();
                    this.dailyDungeonInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dailyDungeonInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDailyDungeonInfoList(Iterable<? extends DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo> values) {
                if (this.dailyDungeonInfoListBuilder_ == null) {
                    ensureDailyDungeonInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.dailyDungeonInfoList_);
                    onChanged();
                } else {
                    this.dailyDungeonInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDailyDungeonInfoList() {
                if (this.dailyDungeonInfoListBuilder_ == null) {
                    this.dailyDungeonInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.dailyDungeonInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDailyDungeonInfoList(int index) {
                if (this.dailyDungeonInfoListBuilder_ == null) {
                    ensureDailyDungeonInfoListIsMutable();
                    this.dailyDungeonInfoList_.remove(index);
                    onChanged();
                } else {
                    this.dailyDungeonInfoListBuilder_.remove(index);
                }
                return this;
            }

            public DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo.Builder getDailyDungeonInfoListBuilder(int index) {
                return getDailyDungeonInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetDailyDungeonEntryInfoRspOuterClass.GetDailyDungeonEntryInfoRspOrBuilder
            public DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder getDailyDungeonInfoListOrBuilder(int index) {
                if (this.dailyDungeonInfoListBuilder_ == null) {
                    return this.dailyDungeonInfoList_.get(index);
                }
                return this.dailyDungeonInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.GetDailyDungeonEntryInfoRspOuterClass.GetDailyDungeonEntryInfoRspOrBuilder
            public List<? extends DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder> getDailyDungeonInfoListOrBuilderList() {
                if (this.dailyDungeonInfoListBuilder_ != null) {
                    return this.dailyDungeonInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.dailyDungeonInfoList_);
            }

            public DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo.Builder addDailyDungeonInfoListBuilder() {
                return getDailyDungeonInfoListFieldBuilder().addBuilder(DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo.getDefaultInstance());
            }

            public DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo.Builder addDailyDungeonInfoListBuilder(int index) {
                return getDailyDungeonInfoListFieldBuilder().addBuilder(index, DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo.getDefaultInstance());
            }

            public List<DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo.Builder> getDailyDungeonInfoListBuilderList() {
                return getDailyDungeonInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo, DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo.Builder, DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfoOrBuilder> getDailyDungeonInfoListFieldBuilder() {
                if (this.dailyDungeonInfoListBuilder_ == null) {
                    this.dailyDungeonInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.dailyDungeonInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.dailyDungeonInfoList_ = null;
                }
                return this.dailyDungeonInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.GetDailyDungeonEntryInfoRspOuterClass.GetDailyDungeonEntryInfoRspOrBuilder
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

        public static GetDailyDungeonEntryInfoRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetDailyDungeonEntryInfoRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<GetDailyDungeonEntryInfoRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public GetDailyDungeonEntryInfoRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DailyDungeonEntryInfoOuterClass.getDescriptor();
    }
}
