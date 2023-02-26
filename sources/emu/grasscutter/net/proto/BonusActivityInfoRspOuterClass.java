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
import emu.grasscutter.net.proto.BonusActivityInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BonusActivityInfoRspOuterClass.class */
public final class BonusActivityInfoRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aBonusActivityInfoRsp.proto\u001a\u0017BonusActivityInfo.proto\"Z\n\u0014BonusActivityInfoRsp\u00121\n\u0015bonusActivityInfoList\u0018\r \u0003(\u000b2\u0012.BonusActivityInfo\u0012\u000f\n\u0007retcode\u0018\f \u0001(\u0005B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{BonusActivityInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_BonusActivityInfoRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_BonusActivityInfoRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_BonusActivityInfoRsp_descriptor, new String[]{"BonusActivityInfoList", "Retcode"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BonusActivityInfoRspOuterClass$BonusActivityInfoRspOrBuilder.class */
    public interface BonusActivityInfoRspOrBuilder extends MessageOrBuilder {
        List<BonusActivityInfoOuterClass.BonusActivityInfo> getBonusActivityInfoListList();

        BonusActivityInfoOuterClass.BonusActivityInfo getBonusActivityInfoList(int i);

        int getBonusActivityInfoListCount();

        List<? extends BonusActivityInfoOuterClass.BonusActivityInfoOrBuilder> getBonusActivityInfoListOrBuilderList();

        BonusActivityInfoOuterClass.BonusActivityInfoOrBuilder getBonusActivityInfoListOrBuilder(int i);

        int getRetcode();
    }

    private BonusActivityInfoRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BonusActivityInfoRspOuterClass$BonusActivityInfoRsp.class */
    public static final class BonusActivityInfoRsp extends GeneratedMessageV3 implements BonusActivityInfoRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int BONUSACTIVITYINFOLIST_FIELD_NUMBER = 13;
        private List<BonusActivityInfoOuterClass.BonusActivityInfo> bonusActivityInfoList_;
        public static final int RETCODE_FIELD_NUMBER = 12;
        private int retcode_;
        private byte memoizedIsInitialized;
        private static final BonusActivityInfoRsp DEFAULT_INSTANCE = new BonusActivityInfoRsp();
        private static final Parser<BonusActivityInfoRsp> PARSER = new AbstractParser<BonusActivityInfoRsp>() { // from class: emu.grasscutter.net.proto.BonusActivityInfoRspOuterClass.BonusActivityInfoRsp.1
            @Override // com.google.protobuf.Parser
            public BonusActivityInfoRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BonusActivityInfoRsp(input, extensionRegistry);
            }
        };

        private BonusActivityInfoRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BonusActivityInfoRsp() {
            this.memoizedIsInitialized = -1;
            this.bonusActivityInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BonusActivityInfoRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BonusActivityInfoRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 96:
                                    this.retcode_ = input.readInt32();
                                    break;
                                case 106:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.bonusActivityInfoList_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.bonusActivityInfoList_.add((BonusActivityInfoOuterClass.BonusActivityInfo) input.readMessage(BonusActivityInfoOuterClass.BonusActivityInfo.parser(), extensionRegistry));
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
                    this.bonusActivityInfoList_ = Collections.unmodifiableList(this.bonusActivityInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BonusActivityInfoRspOuterClass.internal_static_BonusActivityInfoRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BonusActivityInfoRspOuterClass.internal_static_BonusActivityInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(BonusActivityInfoRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BonusActivityInfoRspOuterClass.BonusActivityInfoRspOrBuilder
        public List<BonusActivityInfoOuterClass.BonusActivityInfo> getBonusActivityInfoListList() {
            return this.bonusActivityInfoList_;
        }

        @Override // emu.grasscutter.net.proto.BonusActivityInfoRspOuterClass.BonusActivityInfoRspOrBuilder
        public List<? extends BonusActivityInfoOuterClass.BonusActivityInfoOrBuilder> getBonusActivityInfoListOrBuilderList() {
            return this.bonusActivityInfoList_;
        }

        @Override // emu.grasscutter.net.proto.BonusActivityInfoRspOuterClass.BonusActivityInfoRspOrBuilder
        public int getBonusActivityInfoListCount() {
            return this.bonusActivityInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.BonusActivityInfoRspOuterClass.BonusActivityInfoRspOrBuilder
        public BonusActivityInfoOuterClass.BonusActivityInfo getBonusActivityInfoList(int index) {
            return this.bonusActivityInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BonusActivityInfoRspOuterClass.BonusActivityInfoRspOrBuilder
        public BonusActivityInfoOuterClass.BonusActivityInfoOrBuilder getBonusActivityInfoListOrBuilder(int index) {
            return this.bonusActivityInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.BonusActivityInfoRspOuterClass.BonusActivityInfoRspOrBuilder
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
                output.writeInt32(12, this.retcode_);
            }
            for (int i = 0; i < this.bonusActivityInfoList_.size(); i++) {
                output.writeMessage(13, this.bonusActivityInfoList_.get(i));
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
                size2 = 0 + CodedOutputStream.computeInt32Size(12, this.retcode_);
            }
            for (int i = 0; i < this.bonusActivityInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(13, this.bonusActivityInfoList_.get(i));
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
            if (!(obj instanceof BonusActivityInfoRsp)) {
                return equals(obj);
            }
            BonusActivityInfoRsp other = (BonusActivityInfoRsp) obj;
            return getBonusActivityInfoListList().equals(other.getBonusActivityInfoListList()) && getRetcode() == other.getRetcode() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getBonusActivityInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 13)) + getBonusActivityInfoListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 12)) + getRetcode())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static BonusActivityInfoRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BonusActivityInfoRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BonusActivityInfoRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BonusActivityInfoRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BonusActivityInfoRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BonusActivityInfoRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BonusActivityInfoRsp parseFrom(InputStream input) throws IOException {
            return (BonusActivityInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BonusActivityInfoRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BonusActivityInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BonusActivityInfoRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (BonusActivityInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BonusActivityInfoRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BonusActivityInfoRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BonusActivityInfoRsp parseFrom(CodedInputStream input) throws IOException {
            return (BonusActivityInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BonusActivityInfoRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BonusActivityInfoRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BonusActivityInfoRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BonusActivityInfoRspOuterClass$BonusActivityInfoRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BonusActivityInfoRspOrBuilder {
            private int bitField0_;
            private List<BonusActivityInfoOuterClass.BonusActivityInfo> bonusActivityInfoList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<BonusActivityInfoOuterClass.BonusActivityInfo, BonusActivityInfoOuterClass.BonusActivityInfo.Builder, BonusActivityInfoOuterClass.BonusActivityInfoOrBuilder> bonusActivityInfoListBuilder_;
            private int retcode_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BonusActivityInfoRspOuterClass.internal_static_BonusActivityInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BonusActivityInfoRspOuterClass.internal_static_BonusActivityInfoRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(BonusActivityInfoRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BonusActivityInfoRsp.alwaysUseFieldBuilders) {
                    getBonusActivityInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.bonusActivityInfoListBuilder_ == null) {
                    this.bonusActivityInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.bonusActivityInfoListBuilder_.clear();
                }
                this.retcode_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BonusActivityInfoRspOuterClass.internal_static_BonusActivityInfoRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BonusActivityInfoRsp getDefaultInstanceForType() {
                return BonusActivityInfoRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BonusActivityInfoRsp build() {
                BonusActivityInfoRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BonusActivityInfoRsp buildPartial() {
                BonusActivityInfoRsp result = new BonusActivityInfoRsp(this);
                int i = this.bitField0_;
                if (this.bonusActivityInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.bonusActivityInfoList_ = Collections.unmodifiableList(this.bonusActivityInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.bonusActivityInfoList_ = this.bonusActivityInfoList_;
                } else {
                    result.bonusActivityInfoList_ = this.bonusActivityInfoListBuilder_.build();
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
                if (other instanceof BonusActivityInfoRsp) {
                    return mergeFrom((BonusActivityInfoRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BonusActivityInfoRsp other) {
                if (other == BonusActivityInfoRsp.getDefaultInstance()) {
                    return this;
                }
                if (this.bonusActivityInfoListBuilder_ == null) {
                    if (!other.bonusActivityInfoList_.isEmpty()) {
                        if (this.bonusActivityInfoList_.isEmpty()) {
                            this.bonusActivityInfoList_ = other.bonusActivityInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureBonusActivityInfoListIsMutable();
                            this.bonusActivityInfoList_.addAll(other.bonusActivityInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.bonusActivityInfoList_.isEmpty()) {
                    if (this.bonusActivityInfoListBuilder_.isEmpty()) {
                        this.bonusActivityInfoListBuilder_.dispose();
                        this.bonusActivityInfoListBuilder_ = null;
                        this.bonusActivityInfoList_ = other.bonusActivityInfoList_;
                        this.bitField0_ &= -2;
                        this.bonusActivityInfoListBuilder_ = BonusActivityInfoRsp.alwaysUseFieldBuilders ? getBonusActivityInfoListFieldBuilder() : null;
                    } else {
                        this.bonusActivityInfoListBuilder_.addAllMessages(other.bonusActivityInfoList_);
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
                BonusActivityInfoRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = BonusActivityInfoRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BonusActivityInfoRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureBonusActivityInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.bonusActivityInfoList_ = new ArrayList(this.bonusActivityInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.BonusActivityInfoRspOuterClass.BonusActivityInfoRspOrBuilder
            public List<BonusActivityInfoOuterClass.BonusActivityInfo> getBonusActivityInfoListList() {
                if (this.bonusActivityInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.bonusActivityInfoList_);
                }
                return this.bonusActivityInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.BonusActivityInfoRspOuterClass.BonusActivityInfoRspOrBuilder
            public int getBonusActivityInfoListCount() {
                if (this.bonusActivityInfoListBuilder_ == null) {
                    return this.bonusActivityInfoList_.size();
                }
                return this.bonusActivityInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.BonusActivityInfoRspOuterClass.BonusActivityInfoRspOrBuilder
            public BonusActivityInfoOuterClass.BonusActivityInfo getBonusActivityInfoList(int index) {
                if (this.bonusActivityInfoListBuilder_ == null) {
                    return this.bonusActivityInfoList_.get(index);
                }
                return this.bonusActivityInfoListBuilder_.getMessage(index);
            }

            public Builder setBonusActivityInfoList(int index, BonusActivityInfoOuterClass.BonusActivityInfo value) {
                if (this.bonusActivityInfoListBuilder_ != null) {
                    this.bonusActivityInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBonusActivityInfoListIsMutable();
                    this.bonusActivityInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setBonusActivityInfoList(int index, BonusActivityInfoOuterClass.BonusActivityInfo.Builder builderForValue) {
                if (this.bonusActivityInfoListBuilder_ == null) {
                    ensureBonusActivityInfoListIsMutable();
                    this.bonusActivityInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.bonusActivityInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addBonusActivityInfoList(BonusActivityInfoOuterClass.BonusActivityInfo value) {
                if (this.bonusActivityInfoListBuilder_ != null) {
                    this.bonusActivityInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBonusActivityInfoListIsMutable();
                    this.bonusActivityInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addBonusActivityInfoList(int index, BonusActivityInfoOuterClass.BonusActivityInfo value) {
                if (this.bonusActivityInfoListBuilder_ != null) {
                    this.bonusActivityInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBonusActivityInfoListIsMutable();
                    this.bonusActivityInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addBonusActivityInfoList(BonusActivityInfoOuterClass.BonusActivityInfo.Builder builderForValue) {
                if (this.bonusActivityInfoListBuilder_ == null) {
                    ensureBonusActivityInfoListIsMutable();
                    this.bonusActivityInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.bonusActivityInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addBonusActivityInfoList(int index, BonusActivityInfoOuterClass.BonusActivityInfo.Builder builderForValue) {
                if (this.bonusActivityInfoListBuilder_ == null) {
                    ensureBonusActivityInfoListIsMutable();
                    this.bonusActivityInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.bonusActivityInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllBonusActivityInfoList(Iterable<? extends BonusActivityInfoOuterClass.BonusActivityInfo> values) {
                if (this.bonusActivityInfoListBuilder_ == null) {
                    ensureBonusActivityInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.bonusActivityInfoList_);
                    onChanged();
                } else {
                    this.bonusActivityInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBonusActivityInfoList() {
                if (this.bonusActivityInfoListBuilder_ == null) {
                    this.bonusActivityInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.bonusActivityInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeBonusActivityInfoList(int index) {
                if (this.bonusActivityInfoListBuilder_ == null) {
                    ensureBonusActivityInfoListIsMutable();
                    this.bonusActivityInfoList_.remove(index);
                    onChanged();
                } else {
                    this.bonusActivityInfoListBuilder_.remove(index);
                }
                return this;
            }

            public BonusActivityInfoOuterClass.BonusActivityInfo.Builder getBonusActivityInfoListBuilder(int index) {
                return getBonusActivityInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BonusActivityInfoRspOuterClass.BonusActivityInfoRspOrBuilder
            public BonusActivityInfoOuterClass.BonusActivityInfoOrBuilder getBonusActivityInfoListOrBuilder(int index) {
                if (this.bonusActivityInfoListBuilder_ == null) {
                    return this.bonusActivityInfoList_.get(index);
                }
                return this.bonusActivityInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.BonusActivityInfoRspOuterClass.BonusActivityInfoRspOrBuilder
            public List<? extends BonusActivityInfoOuterClass.BonusActivityInfoOrBuilder> getBonusActivityInfoListOrBuilderList() {
                if (this.bonusActivityInfoListBuilder_ != null) {
                    return this.bonusActivityInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.bonusActivityInfoList_);
            }

            public BonusActivityInfoOuterClass.BonusActivityInfo.Builder addBonusActivityInfoListBuilder() {
                return getBonusActivityInfoListFieldBuilder().addBuilder(BonusActivityInfoOuterClass.BonusActivityInfo.getDefaultInstance());
            }

            public BonusActivityInfoOuterClass.BonusActivityInfo.Builder addBonusActivityInfoListBuilder(int index) {
                return getBonusActivityInfoListFieldBuilder().addBuilder(index, BonusActivityInfoOuterClass.BonusActivityInfo.getDefaultInstance());
            }

            public List<BonusActivityInfoOuterClass.BonusActivityInfo.Builder> getBonusActivityInfoListBuilderList() {
                return getBonusActivityInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<BonusActivityInfoOuterClass.BonusActivityInfo, BonusActivityInfoOuterClass.BonusActivityInfo.Builder, BonusActivityInfoOuterClass.BonusActivityInfoOrBuilder> getBonusActivityInfoListFieldBuilder() {
                if (this.bonusActivityInfoListBuilder_ == null) {
                    this.bonusActivityInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.bonusActivityInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.bonusActivityInfoList_ = null;
                }
                return this.bonusActivityInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.BonusActivityInfoRspOuterClass.BonusActivityInfoRspOrBuilder
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

        public static BonusActivityInfoRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BonusActivityInfoRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BonusActivityInfoRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BonusActivityInfoRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BonusActivityInfoOuterClass.getDescriptor();
    }
}
