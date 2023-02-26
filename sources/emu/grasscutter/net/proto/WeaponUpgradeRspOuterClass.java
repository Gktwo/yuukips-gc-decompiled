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
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponUpgradeRspOuterClass.class */
public final class WeaponUpgradeRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016WeaponUpgradeRsp.proto\u001a\u000fItemParam.proto\"\u0001\n\u0010WeaponUpgradeRsp\u0012\u0010\n\bcurLevel\u0018\u0005 \u0001(\r\u0012!\n\ritemParamList\u0018\t \u0003(\u000b2\n.ItemParam\u0012\u000f\n\u0007retcode\u0018\u000e \u0001(\u0005\u0012\u0010\n\boldLevel\u0018\u0001 \u0001(\r\u0012\u0018\n\u0010targetWeaponGuid\u0018\r \u0001(\u0004B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_WeaponUpgradeRsp_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_WeaponUpgradeRsp_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_WeaponUpgradeRsp_descriptor, new String[]{"CurLevel", "ItemParamList", "Retcode", "OldLevel", "TargetWeaponGuid"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponUpgradeRspOuterClass$WeaponUpgradeRspOrBuilder.class */
    public interface WeaponUpgradeRspOrBuilder extends MessageOrBuilder {
        int getCurLevel();

        List<ItemParamOuterClass.ItemParam> getItemParamListList();

        ItemParamOuterClass.ItemParam getItemParamList(int i);

        int getItemParamListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemParamListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getItemParamListOrBuilder(int i);

        int getRetcode();

        int getOldLevel();

        long getTargetWeaponGuid();
    }

    private WeaponUpgradeRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponUpgradeRspOuterClass$WeaponUpgradeRsp.class */
    public static final class WeaponUpgradeRsp extends GeneratedMessageV3 implements WeaponUpgradeRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int CURLEVEL_FIELD_NUMBER = 5;
        private int curLevel_;
        public static final int ITEMPARAMLIST_FIELD_NUMBER = 9;
        private List<ItemParamOuterClass.ItemParam> itemParamList_;
        public static final int RETCODE_FIELD_NUMBER = 14;
        private int retcode_;
        public static final int OLDLEVEL_FIELD_NUMBER = 1;
        private int oldLevel_;
        public static final int TARGETWEAPONGUID_FIELD_NUMBER = 13;
        private long targetWeaponGuid_;
        private byte memoizedIsInitialized;
        private static final WeaponUpgradeRsp DEFAULT_INSTANCE = new WeaponUpgradeRsp();
        private static final Parser<WeaponUpgradeRsp> PARSER = new AbstractParser<WeaponUpgradeRsp>() { // from class: emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRsp.1
            @Override // com.google.protobuf.Parser
            public WeaponUpgradeRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new WeaponUpgradeRsp(input, extensionRegistry);
            }
        };

        private WeaponUpgradeRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private WeaponUpgradeRsp() {
            this.memoizedIsInitialized = -1;
            this.itemParamList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new WeaponUpgradeRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private WeaponUpgradeRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.oldLevel_ = input.readUInt32();
                                break;
                            case 40:
                                this.curLevel_ = input.readUInt32();
                                break;
                            case 74:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.itemParamList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.itemParamList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            case 104:
                                this.targetWeaponGuid_ = input.readUInt64();
                                break;
                            case 112:
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
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.itemParamList_ = Collections.unmodifiableList(this.itemParamList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return WeaponUpgradeRspOuterClass.internal_static_WeaponUpgradeRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return WeaponUpgradeRspOuterClass.internal_static_WeaponUpgradeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(WeaponUpgradeRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRspOrBuilder
        public int getCurLevel() {
            return this.curLevel_;
        }

        @Override // emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getItemParamListList() {
            return this.itemParamList_;
        }

        @Override // emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemParamListOrBuilderList() {
            return this.itemParamList_;
        }

        @Override // emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRspOrBuilder
        public int getItemParamListCount() {
            return this.itemParamList_.size();
        }

        @Override // emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRspOrBuilder
        public ItemParamOuterClass.ItemParam getItemParamList(int index) {
            return this.itemParamList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getItemParamListOrBuilder(int index) {
            return this.itemParamList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRspOrBuilder
        public int getOldLevel() {
            return this.oldLevel_;
        }

        @Override // emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRspOrBuilder
        public long getTargetWeaponGuid() {
            return this.targetWeaponGuid_;
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
            if (this.oldLevel_ != 0) {
                output.writeUInt32(1, this.oldLevel_);
            }
            if (this.curLevel_ != 0) {
                output.writeUInt32(5, this.curLevel_);
            }
            for (int i = 0; i < this.itemParamList_.size(); i++) {
                output.writeMessage(9, this.itemParamList_.get(i));
            }
            if (this.targetWeaponGuid_ != 0) {
                output.writeUInt64(13, this.targetWeaponGuid_);
            }
            if (this.retcode_ != 0) {
                output.writeInt32(14, this.retcode_);
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
            if (this.oldLevel_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.oldLevel_);
            }
            if (this.curLevel_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(5, this.curLevel_);
            }
            for (int i = 0; i < this.itemParamList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(9, this.itemParamList_.get(i));
            }
            if (this.targetWeaponGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(13, this.targetWeaponGuid_);
            }
            if (this.retcode_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(14, this.retcode_);
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
            if (!(obj instanceof WeaponUpgradeRsp)) {
                return equals(obj);
            }
            WeaponUpgradeRsp other = (WeaponUpgradeRsp) obj;
            return getCurLevel() == other.getCurLevel() && getItemParamListList().equals(other.getItemParamListList()) && getRetcode() == other.getRetcode() && getOldLevel() == other.getOldLevel() && getTargetWeaponGuid() == other.getTargetWeaponGuid() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 5)) + getCurLevel();
            if (getItemParamListCount() > 0) {
                hash = (53 * ((37 * hash) + 9)) + getItemParamListList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * hash) + 14)) + getRetcode())) + 1)) + getOldLevel())) + 13)) + Internal.hashLong(getTargetWeaponGuid()))) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static WeaponUpgradeRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WeaponUpgradeRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WeaponUpgradeRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WeaponUpgradeRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WeaponUpgradeRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static WeaponUpgradeRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static WeaponUpgradeRsp parseFrom(InputStream input) throws IOException {
            return (WeaponUpgradeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WeaponUpgradeRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WeaponUpgradeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static WeaponUpgradeRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (WeaponUpgradeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static WeaponUpgradeRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WeaponUpgradeRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static WeaponUpgradeRsp parseFrom(CodedInputStream input) throws IOException {
            return (WeaponUpgradeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static WeaponUpgradeRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (WeaponUpgradeRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(WeaponUpgradeRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/WeaponUpgradeRspOuterClass$WeaponUpgradeRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements WeaponUpgradeRspOrBuilder {
            private int bitField0_;
            private int curLevel_;
            private List<ItemParamOuterClass.ItemParam> itemParamList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> itemParamListBuilder_;
            private int retcode_;
            private int oldLevel_;
            private long targetWeaponGuid_;

            public static final Descriptors.Descriptor getDescriptor() {
                return WeaponUpgradeRspOuterClass.internal_static_WeaponUpgradeRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return WeaponUpgradeRspOuterClass.internal_static_WeaponUpgradeRsp_fieldAccessorTable.ensureFieldAccessorsInitialized(WeaponUpgradeRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (WeaponUpgradeRsp.alwaysUseFieldBuilders) {
                    getItemParamListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.curLevel_ = 0;
                if (this.itemParamListBuilder_ == null) {
                    this.itemParamList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.itemParamListBuilder_.clear();
                }
                this.retcode_ = 0;
                this.oldLevel_ = 0;
                this.targetWeaponGuid_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return WeaponUpgradeRspOuterClass.internal_static_WeaponUpgradeRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public WeaponUpgradeRsp getDefaultInstanceForType() {
                return WeaponUpgradeRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WeaponUpgradeRsp build() {
                WeaponUpgradeRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public WeaponUpgradeRsp buildPartial() {
                WeaponUpgradeRsp result = new WeaponUpgradeRsp(this);
                int i = this.bitField0_;
                result.curLevel_ = this.curLevel_;
                if (this.itemParamListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.itemParamList_ = Collections.unmodifiableList(this.itemParamList_);
                        this.bitField0_ &= -2;
                    }
                    result.itemParamList_ = this.itemParamList_;
                } else {
                    result.itemParamList_ = this.itemParamListBuilder_.build();
                }
                result.retcode_ = this.retcode_;
                result.oldLevel_ = this.oldLevel_;
                result.targetWeaponGuid_ = this.targetWeaponGuid_;
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
                if (other instanceof WeaponUpgradeRsp) {
                    return mergeFrom((WeaponUpgradeRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(WeaponUpgradeRsp other) {
                if (other == WeaponUpgradeRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getCurLevel() != 0) {
                    setCurLevel(other.getCurLevel());
                }
                if (this.itemParamListBuilder_ == null) {
                    if (!other.itemParamList_.isEmpty()) {
                        if (this.itemParamList_.isEmpty()) {
                            this.itemParamList_ = other.itemParamList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureItemParamListIsMutable();
                            this.itemParamList_.addAll(other.itemParamList_);
                        }
                        onChanged();
                    }
                } else if (!other.itemParamList_.isEmpty()) {
                    if (this.itemParamListBuilder_.isEmpty()) {
                        this.itemParamListBuilder_.dispose();
                        this.itemParamListBuilder_ = null;
                        this.itemParamList_ = other.itemParamList_;
                        this.bitField0_ &= -2;
                        this.itemParamListBuilder_ = WeaponUpgradeRsp.alwaysUseFieldBuilders ? getItemParamListFieldBuilder() : null;
                    } else {
                        this.itemParamListBuilder_.addAllMessages(other.itemParamList_);
                    }
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getOldLevel() != 0) {
                    setOldLevel(other.getOldLevel());
                }
                if (other.getTargetWeaponGuid() != 0) {
                    setTargetWeaponGuid(other.getTargetWeaponGuid());
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
                WeaponUpgradeRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = WeaponUpgradeRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (WeaponUpgradeRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRspOrBuilder
            public int getCurLevel() {
                return this.curLevel_;
            }

            public Builder setCurLevel(int value) {
                this.curLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearCurLevel() {
                this.curLevel_ = 0;
                onChanged();
                return this;
            }

            private void ensureItemParamListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.itemParamList_ = new ArrayList(this.itemParamList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getItemParamListList() {
                if (this.itemParamListBuilder_ == null) {
                    return Collections.unmodifiableList(this.itemParamList_);
                }
                return this.itemParamListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRspOrBuilder
            public int getItemParamListCount() {
                if (this.itemParamListBuilder_ == null) {
                    return this.itemParamList_.size();
                }
                return this.itemParamListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRspOrBuilder
            public ItemParamOuterClass.ItemParam getItemParamList(int index) {
                if (this.itemParamListBuilder_ == null) {
                    return this.itemParamList_.get(index);
                }
                return this.itemParamListBuilder_.getMessage(index);
            }

            public Builder setItemParamList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.itemParamListBuilder_ != null) {
                    this.itemParamListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setItemParamList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemParamListBuilder_ == null) {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemParamListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addItemParamList(ItemParamOuterClass.ItemParam value) {
                if (this.itemParamListBuilder_ != null) {
                    this.itemParamListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addItemParamList(int index, ItemParamOuterClass.ItemParam value) {
                if (this.itemParamListBuilder_ != null) {
                    this.itemParamListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addItemParamList(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemParamListBuilder_ == null) {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.itemParamListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addItemParamList(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.itemParamListBuilder_ == null) {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.itemParamListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllItemParamList(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.itemParamListBuilder_ == null) {
                    ensureItemParamListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.itemParamList_);
                    onChanged();
                } else {
                    this.itemParamListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearItemParamList() {
                if (this.itemParamListBuilder_ == null) {
                    this.itemParamList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.itemParamListBuilder_.clear();
                }
                return this;
            }

            public Builder removeItemParamList(int index) {
                if (this.itemParamListBuilder_ == null) {
                    ensureItemParamListIsMutable();
                    this.itemParamList_.remove(index);
                    onChanged();
                } else {
                    this.itemParamListBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getItemParamListBuilder(int index) {
                return getItemParamListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getItemParamListOrBuilder(int index) {
                if (this.itemParamListBuilder_ == null) {
                    return this.itemParamList_.get(index);
                }
                return this.itemParamListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRspOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemParamListOrBuilderList() {
                if (this.itemParamListBuilder_ != null) {
                    return this.itemParamListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.itemParamList_);
            }

            public ItemParamOuterClass.ItemParam.Builder addItemParamListBuilder() {
                return getItemParamListFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addItemParamListBuilder(int index) {
                return getItemParamListFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getItemParamListBuilderList() {
                return getItemParamListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getItemParamListFieldBuilder() {
                if (this.itemParamListBuilder_ == null) {
                    this.itemParamListBuilder_ = new RepeatedFieldBuilderV3<>(this.itemParamList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.itemParamList_ = null;
                }
                return this.itemParamListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRspOrBuilder
            public int getOldLevel() {
                return this.oldLevel_;
            }

            public Builder setOldLevel(int value) {
                this.oldLevel_ = value;
                onChanged();
                return this;
            }

            public Builder clearOldLevel() {
                this.oldLevel_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.WeaponUpgradeRspOuterClass.WeaponUpgradeRspOrBuilder
            public long getTargetWeaponGuid() {
                return this.targetWeaponGuid_;
            }

            public Builder setTargetWeaponGuid(long value) {
                this.targetWeaponGuid_ = value;
                onChanged();
                return this;
            }

            public Builder clearTargetWeaponGuid() {
                this.targetWeaponGuid_ = 0;
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

        public static WeaponUpgradeRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<WeaponUpgradeRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<WeaponUpgradeRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public WeaponUpgradeRsp getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        ItemParamOuterClass.getDescriptor();
    }
}
