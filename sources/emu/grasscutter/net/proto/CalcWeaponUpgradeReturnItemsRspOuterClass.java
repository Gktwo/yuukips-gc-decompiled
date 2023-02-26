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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CalcWeaponUpgradeReturnItemsRspOuterClass.class */
public final class CalcWeaponUpgradeReturnItemsRspOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n%CalcWeaponUpgradeReturnItemsRsp.proto\u001a\u000fItemParam.proto\"o\n\u001fCalcWeaponUpgradeReturnItemsRsp\u0012\u000f\n\u0007retcode\u0018\u0004 \u0001(\u0005\u0012\u0018\n\u0010targetWeaponGuid\u0018\t \u0001(\u0004\u0012!\n\ritemParamList\u0018\u0007 \u0003(\u000b2\n.ItemParamB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_CalcWeaponUpgradeReturnItemsRsp_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_CalcWeaponUpgradeReturnItemsRsp_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f668x9e9bbf31 = new GeneratedMessageV3.FieldAccessorTable(internal_static_CalcWeaponUpgradeReturnItemsRsp_descriptor, new String[]{"Retcode", "TargetWeaponGuid", "ItemParamList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CalcWeaponUpgradeReturnItemsRspOuterClass$CalcWeaponUpgradeReturnItemsRspOrBuilder.class */
    public interface CalcWeaponUpgradeReturnItemsRspOrBuilder extends MessageOrBuilder {
        int getRetcode();

        long getTargetWeaponGuid();

        List<ItemParamOuterClass.ItemParam> getItemParamListList();

        ItemParamOuterClass.ItemParam getItemParamList(int i);

        int getItemParamListCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemParamListOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getItemParamListOrBuilder(int i);
    }

    private CalcWeaponUpgradeReturnItemsRspOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CalcWeaponUpgradeReturnItemsRspOuterClass$CalcWeaponUpgradeReturnItemsRsp.class */
    public static final class CalcWeaponUpgradeReturnItemsRsp extends GeneratedMessageV3 implements CalcWeaponUpgradeReturnItemsRspOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int RETCODE_FIELD_NUMBER = 4;
        private int retcode_;
        public static final int TARGETWEAPONGUID_FIELD_NUMBER = 9;
        private long targetWeaponGuid_;
        public static final int ITEMPARAMLIST_FIELD_NUMBER = 7;
        private List<ItemParamOuterClass.ItemParam> itemParamList_;
        private byte memoizedIsInitialized;
        private static final CalcWeaponUpgradeReturnItemsRsp DEFAULT_INSTANCE = new CalcWeaponUpgradeReturnItemsRsp();
        private static final Parser<CalcWeaponUpgradeReturnItemsRsp> PARSER = new AbstractParser<CalcWeaponUpgradeReturnItemsRsp>() { // from class: emu.grasscutter.net.proto.CalcWeaponUpgradeReturnItemsRspOuterClass.CalcWeaponUpgradeReturnItemsRsp.1
            @Override // com.google.protobuf.Parser
            public CalcWeaponUpgradeReturnItemsRsp parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new CalcWeaponUpgradeReturnItemsRsp(input, extensionRegistry);
            }
        };

        private CalcWeaponUpgradeReturnItemsRsp(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private CalcWeaponUpgradeReturnItemsRsp() {
            this.memoizedIsInitialized = -1;
            this.itemParamList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new CalcWeaponUpgradeReturnItemsRsp();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private CalcWeaponUpgradeReturnItemsRsp(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 32:
                                this.retcode_ = input.readInt32();
                                break;
                            case 58:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.itemParamList_ = new ArrayList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.itemParamList_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
                                break;
                            case 72:
                                this.targetWeaponGuid_ = input.readUInt64();
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
            return CalcWeaponUpgradeReturnItemsRspOuterClass.internal_static_CalcWeaponUpgradeReturnItemsRsp_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return CalcWeaponUpgradeReturnItemsRspOuterClass.f668x9e9bbf31.ensureFieldAccessorsInitialized(CalcWeaponUpgradeReturnItemsRsp.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.CalcWeaponUpgradeReturnItemsRspOuterClass.CalcWeaponUpgradeReturnItemsRspOrBuilder
        public int getRetcode() {
            return this.retcode_;
        }

        @Override // emu.grasscutter.net.proto.CalcWeaponUpgradeReturnItemsRspOuterClass.CalcWeaponUpgradeReturnItemsRspOrBuilder
        public long getTargetWeaponGuid() {
            return this.targetWeaponGuid_;
        }

        @Override // emu.grasscutter.net.proto.CalcWeaponUpgradeReturnItemsRspOuterClass.CalcWeaponUpgradeReturnItemsRspOrBuilder
        public List<ItemParamOuterClass.ItemParam> getItemParamListList() {
            return this.itemParamList_;
        }

        @Override // emu.grasscutter.net.proto.CalcWeaponUpgradeReturnItemsRspOuterClass.CalcWeaponUpgradeReturnItemsRspOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getItemParamListOrBuilderList() {
            return this.itemParamList_;
        }

        @Override // emu.grasscutter.net.proto.CalcWeaponUpgradeReturnItemsRspOuterClass.CalcWeaponUpgradeReturnItemsRspOrBuilder
        public int getItemParamListCount() {
            return this.itemParamList_.size();
        }

        @Override // emu.grasscutter.net.proto.CalcWeaponUpgradeReturnItemsRspOuterClass.CalcWeaponUpgradeReturnItemsRspOrBuilder
        public ItemParamOuterClass.ItemParam getItemParamList(int index) {
            return this.itemParamList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.CalcWeaponUpgradeReturnItemsRspOuterClass.CalcWeaponUpgradeReturnItemsRspOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getItemParamListOrBuilder(int index) {
            return this.itemParamList_.get(index);
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
                output.writeInt32(4, this.retcode_);
            }
            for (int i = 0; i < this.itemParamList_.size(); i++) {
                output.writeMessage(7, this.itemParamList_.get(i));
            }
            if (this.targetWeaponGuid_ != 0) {
                output.writeUInt64(9, this.targetWeaponGuid_);
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
                size2 = 0 + CodedOutputStream.computeInt32Size(4, this.retcode_);
            }
            for (int i = 0; i < this.itemParamList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(7, this.itemParamList_.get(i));
            }
            if (this.targetWeaponGuid_ != 0) {
                size2 += CodedOutputStream.computeUInt64Size(9, this.targetWeaponGuid_);
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
            if (!(obj instanceof CalcWeaponUpgradeReturnItemsRsp)) {
                return equals(obj);
            }
            CalcWeaponUpgradeReturnItemsRsp other = (CalcWeaponUpgradeReturnItemsRsp) obj;
            return getRetcode() == other.getRetcode() && getTargetWeaponGuid() == other.getTargetWeaponGuid() && getItemParamListList().equals(other.getItemParamListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 4)) + getRetcode())) + 9)) + Internal.hashLong(getTargetWeaponGuid());
            if (getItemParamListCount() > 0) {
                hash = (53 * ((37 * hash) + 7)) + getItemParamListList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static CalcWeaponUpgradeReturnItemsRsp parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CalcWeaponUpgradeReturnItemsRsp parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CalcWeaponUpgradeReturnItemsRsp parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CalcWeaponUpgradeReturnItemsRsp parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CalcWeaponUpgradeReturnItemsRsp parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static CalcWeaponUpgradeReturnItemsRsp parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static CalcWeaponUpgradeReturnItemsRsp parseFrom(InputStream input) throws IOException {
            return (CalcWeaponUpgradeReturnItemsRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CalcWeaponUpgradeReturnItemsRsp parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CalcWeaponUpgradeReturnItemsRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static CalcWeaponUpgradeReturnItemsRsp parseDelimitedFrom(InputStream input) throws IOException {
            return (CalcWeaponUpgradeReturnItemsRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static CalcWeaponUpgradeReturnItemsRsp parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CalcWeaponUpgradeReturnItemsRsp) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static CalcWeaponUpgradeReturnItemsRsp parseFrom(CodedInputStream input) throws IOException {
            return (CalcWeaponUpgradeReturnItemsRsp) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static CalcWeaponUpgradeReturnItemsRsp parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (CalcWeaponUpgradeReturnItemsRsp) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(CalcWeaponUpgradeReturnItemsRsp prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/CalcWeaponUpgradeReturnItemsRspOuterClass$CalcWeaponUpgradeReturnItemsRsp$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CalcWeaponUpgradeReturnItemsRspOrBuilder {
            private int bitField0_;
            private int retcode_;
            private long targetWeaponGuid_;
            private List<ItemParamOuterClass.ItemParam> itemParamList_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> itemParamListBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return CalcWeaponUpgradeReturnItemsRspOuterClass.internal_static_CalcWeaponUpgradeReturnItemsRsp_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return CalcWeaponUpgradeReturnItemsRspOuterClass.f668x9e9bbf31.ensureFieldAccessorsInitialized(CalcWeaponUpgradeReturnItemsRsp.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (CalcWeaponUpgradeReturnItemsRsp.alwaysUseFieldBuilders) {
                    getItemParamListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.retcode_ = 0;
                this.targetWeaponGuid_ = 0;
                if (this.itemParamListBuilder_ == null) {
                    this.itemParamList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.itemParamListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return CalcWeaponUpgradeReturnItemsRspOuterClass.internal_static_CalcWeaponUpgradeReturnItemsRsp_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CalcWeaponUpgradeReturnItemsRsp getDefaultInstanceForType() {
                return CalcWeaponUpgradeReturnItemsRsp.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CalcWeaponUpgradeReturnItemsRsp build() {
                CalcWeaponUpgradeReturnItemsRsp result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public CalcWeaponUpgradeReturnItemsRsp buildPartial() {
                CalcWeaponUpgradeReturnItemsRsp result = new CalcWeaponUpgradeReturnItemsRsp(this);
                int i = this.bitField0_;
                result.retcode_ = this.retcode_;
                result.targetWeaponGuid_ = this.targetWeaponGuid_;
                if (this.itemParamListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.itemParamList_ = Collections.unmodifiableList(this.itemParamList_);
                        this.bitField0_ &= -2;
                    }
                    result.itemParamList_ = this.itemParamList_;
                } else {
                    result.itemParamList_ = this.itemParamListBuilder_.build();
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
                if (other instanceof CalcWeaponUpgradeReturnItemsRsp) {
                    return mergeFrom((CalcWeaponUpgradeReturnItemsRsp) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(CalcWeaponUpgradeReturnItemsRsp other) {
                if (other == CalcWeaponUpgradeReturnItemsRsp.getDefaultInstance()) {
                    return this;
                }
                if (other.getRetcode() != 0) {
                    setRetcode(other.getRetcode());
                }
                if (other.getTargetWeaponGuid() != 0) {
                    setTargetWeaponGuid(other.getTargetWeaponGuid());
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
                        this.itemParamListBuilder_ = CalcWeaponUpgradeReturnItemsRsp.alwaysUseFieldBuilders ? getItemParamListFieldBuilder() : null;
                    } else {
                        this.itemParamListBuilder_.addAllMessages(other.itemParamList_);
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
                CalcWeaponUpgradeReturnItemsRsp parsedMessage = null;
                try {
                    try {
                        parsedMessage = CalcWeaponUpgradeReturnItemsRsp.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (CalcWeaponUpgradeReturnItemsRsp) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.CalcWeaponUpgradeReturnItemsRspOuterClass.CalcWeaponUpgradeReturnItemsRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.CalcWeaponUpgradeReturnItemsRspOuterClass.CalcWeaponUpgradeReturnItemsRspOrBuilder
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

            private void ensureItemParamListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.itemParamList_ = new ArrayList(this.itemParamList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.CalcWeaponUpgradeReturnItemsRspOuterClass.CalcWeaponUpgradeReturnItemsRspOrBuilder
            public List<ItemParamOuterClass.ItemParam> getItemParamListList() {
                if (this.itemParamListBuilder_ == null) {
                    return Collections.unmodifiableList(this.itemParamList_);
                }
                return this.itemParamListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.CalcWeaponUpgradeReturnItemsRspOuterClass.CalcWeaponUpgradeReturnItemsRspOrBuilder
            public int getItemParamListCount() {
                if (this.itemParamListBuilder_ == null) {
                    return this.itemParamList_.size();
                }
                return this.itemParamListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.CalcWeaponUpgradeReturnItemsRspOuterClass.CalcWeaponUpgradeReturnItemsRspOrBuilder
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

            @Override // emu.grasscutter.net.proto.CalcWeaponUpgradeReturnItemsRspOuterClass.CalcWeaponUpgradeReturnItemsRspOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getItemParamListOrBuilder(int index) {
                if (this.itemParamListBuilder_ == null) {
                    return this.itemParamList_.get(index);
                }
                return this.itemParamListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.CalcWeaponUpgradeReturnItemsRspOuterClass.CalcWeaponUpgradeReturnItemsRspOrBuilder
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

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder
            public final Builder setUnknownFields(UnknownFieldSet unknownFields) {
                return setUnknownFields(unknownFields);
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.Message.Builder
            public final Builder mergeUnknownFields(UnknownFieldSet unknownFields) {
                return mergeUnknownFields(unknownFields);
            }
        }

        public static CalcWeaponUpgradeReturnItemsRsp getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<CalcWeaponUpgradeReturnItemsRsp> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<CalcWeaponUpgradeReturnItemsRsp> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public CalcWeaponUpgradeReturnItemsRsp getDefaultInstanceForType() {
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
