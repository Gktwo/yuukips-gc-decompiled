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
import emu.grasscutter.net.proto.ItemParamOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketTraderInfoOuterClass.class */
public final class VintageMarketTraderInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001dVintageMarketTraderInfo.proto\u001a\u000fItemParam.proto\"L\n\u0017VintageMarketTraderInfo\u0012\u001f\n\u000bhiiflfhdkkg\u0018\n \u0003(\u000b2\n.ItemParam\u0012\u0010\n\btraderId\u0018\u0006 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{ItemParamOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_VintageMarketTraderInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_VintageMarketTraderInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_VintageMarketTraderInfo_descriptor, new String[]{"Hiiflfhdkkg", "TraderId"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketTraderInfoOuterClass$VintageMarketTraderInfoOrBuilder.class */
    public interface VintageMarketTraderInfoOrBuilder extends MessageOrBuilder {
        List<ItemParamOuterClass.ItemParam> getHiiflfhdkkgList();

        ItemParamOuterClass.ItemParam getHiiflfhdkkg(int i);

        int getHiiflfhdkkgCount();

        List<? extends ItemParamOuterClass.ItemParamOrBuilder> getHiiflfhdkkgOrBuilderList();

        ItemParamOuterClass.ItemParamOrBuilder getHiiflfhdkkgOrBuilder(int i);

        int getTraderId();
    }

    private VintageMarketTraderInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketTraderInfoOuterClass$VintageMarketTraderInfo.class */
    public static final class VintageMarketTraderInfo extends GeneratedMessageV3 implements VintageMarketTraderInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int HIIFLFHDKKG_FIELD_NUMBER = 10;
        private List<ItemParamOuterClass.ItemParam> hiiflfhdkkg_;
        public static final int TRADERID_FIELD_NUMBER = 6;
        private int traderId_;
        private byte memoizedIsInitialized;
        private static final VintageMarketTraderInfo DEFAULT_INSTANCE = new VintageMarketTraderInfo();
        private static final Parser<VintageMarketTraderInfo> PARSER = new AbstractParser<VintageMarketTraderInfo>() { // from class: emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfo.1
            @Override // com.google.protobuf.Parser
            public VintageMarketTraderInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new VintageMarketTraderInfo(input, extensionRegistry);
            }
        };

        private VintageMarketTraderInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private VintageMarketTraderInfo() {
            this.memoizedIsInitialized = -1;
            this.hiiflfhdkkg_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new VintageMarketTraderInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private VintageMarketTraderInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 48:
                                    this.traderId_ = input.readUInt32();
                                    break;
                                case 82:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.hiiflfhdkkg_ = new ArrayList();
                                        mutable_bitField0_ |= 1;
                                    }
                                    this.hiiflfhdkkg_.add((ItemParamOuterClass.ItemParam) input.readMessage(ItemParamOuterClass.ItemParam.parser(), extensionRegistry));
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
                    this.hiiflfhdkkg_ = Collections.unmodifiableList(this.hiiflfhdkkg_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return VintageMarketTraderInfoOuterClass.internal_static_VintageMarketTraderInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return VintageMarketTraderInfoOuterClass.internal_static_VintageMarketTraderInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VintageMarketTraderInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
        public List<ItemParamOuterClass.ItemParam> getHiiflfhdkkgList() {
            return this.hiiflfhdkkg_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
        public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getHiiflfhdkkgOrBuilderList() {
            return this.hiiflfhdkkg_;
        }

        @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
        public int getHiiflfhdkkgCount() {
            return this.hiiflfhdkkg_.size();
        }

        @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
        public ItemParamOuterClass.ItemParam getHiiflfhdkkg(int index) {
            return this.hiiflfhdkkg_.get(index);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
        public ItemParamOuterClass.ItemParamOrBuilder getHiiflfhdkkgOrBuilder(int index) {
            return this.hiiflfhdkkg_.get(index);
        }

        @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
        public int getTraderId() {
            return this.traderId_;
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
            if (this.traderId_ != 0) {
                output.writeUInt32(6, this.traderId_);
            }
            for (int i = 0; i < this.hiiflfhdkkg_.size(); i++) {
                output.writeMessage(10, this.hiiflfhdkkg_.get(i));
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
            if (this.traderId_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(6, this.traderId_);
            }
            for (int i = 0; i < this.hiiflfhdkkg_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(10, this.hiiflfhdkkg_.get(i));
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
            if (!(obj instanceof VintageMarketTraderInfo)) {
                return equals(obj);
            }
            VintageMarketTraderInfo other = (VintageMarketTraderInfo) obj;
            return getHiiflfhdkkgList().equals(other.getHiiflfhdkkgList()) && getTraderId() == other.getTraderId() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (19 * 41) + getDescriptor().hashCode();
            if (getHiiflfhdkkgCount() > 0) {
                hash = (53 * ((37 * hash) + 10)) + getHiiflfhdkkgList().hashCode();
            }
            int hash2 = (29 * ((53 * ((37 * hash) + 6)) + getTraderId())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static VintageMarketTraderInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageMarketTraderInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageMarketTraderInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageMarketTraderInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageMarketTraderInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static VintageMarketTraderInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static VintageMarketTraderInfo parseFrom(InputStream input) throws IOException {
            return (VintageMarketTraderInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintageMarketTraderInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageMarketTraderInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintageMarketTraderInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (VintageMarketTraderInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static VintageMarketTraderInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageMarketTraderInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static VintageMarketTraderInfo parseFrom(CodedInputStream input) throws IOException {
            return (VintageMarketTraderInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static VintageMarketTraderInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (VintageMarketTraderInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(VintageMarketTraderInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/VintageMarketTraderInfoOuterClass$VintageMarketTraderInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements VintageMarketTraderInfoOrBuilder {
            private int bitField0_;
            private List<ItemParamOuterClass.ItemParam> hiiflfhdkkg_ = Collections.emptyList();
            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> hiiflfhdkkgBuilder_;
            private int traderId_;

            public static final Descriptors.Descriptor getDescriptor() {
                return VintageMarketTraderInfoOuterClass.internal_static_VintageMarketTraderInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return VintageMarketTraderInfoOuterClass.internal_static_VintageMarketTraderInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(VintageMarketTraderInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (VintageMarketTraderInfo.alwaysUseFieldBuilders) {
                    getHiiflfhdkkgFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                if (this.hiiflfhdkkgBuilder_ == null) {
                    this.hiiflfhdkkg_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.hiiflfhdkkgBuilder_.clear();
                }
                this.traderId_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return VintageMarketTraderInfoOuterClass.internal_static_VintageMarketTraderInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public VintageMarketTraderInfo getDefaultInstanceForType() {
                return VintageMarketTraderInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintageMarketTraderInfo build() {
                VintageMarketTraderInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public VintageMarketTraderInfo buildPartial() {
                VintageMarketTraderInfo result = new VintageMarketTraderInfo(this);
                int i = this.bitField0_;
                if (this.hiiflfhdkkgBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.hiiflfhdkkg_ = Collections.unmodifiableList(this.hiiflfhdkkg_);
                        this.bitField0_ &= -2;
                    }
                    result.hiiflfhdkkg_ = this.hiiflfhdkkg_;
                } else {
                    result.hiiflfhdkkg_ = this.hiiflfhdkkgBuilder_.build();
                }
                result.traderId_ = this.traderId_;
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
                if (other instanceof VintageMarketTraderInfo) {
                    return mergeFrom((VintageMarketTraderInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(VintageMarketTraderInfo other) {
                if (other == VintageMarketTraderInfo.getDefaultInstance()) {
                    return this;
                }
                if (this.hiiflfhdkkgBuilder_ == null) {
                    if (!other.hiiflfhdkkg_.isEmpty()) {
                        if (this.hiiflfhdkkg_.isEmpty()) {
                            this.hiiflfhdkkg_ = other.hiiflfhdkkg_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureHiiflfhdkkgIsMutable();
                            this.hiiflfhdkkg_.addAll(other.hiiflfhdkkg_);
                        }
                        onChanged();
                    }
                } else if (!other.hiiflfhdkkg_.isEmpty()) {
                    if (this.hiiflfhdkkgBuilder_.isEmpty()) {
                        this.hiiflfhdkkgBuilder_.dispose();
                        this.hiiflfhdkkgBuilder_ = null;
                        this.hiiflfhdkkg_ = other.hiiflfhdkkg_;
                        this.bitField0_ &= -2;
                        this.hiiflfhdkkgBuilder_ = VintageMarketTraderInfo.alwaysUseFieldBuilders ? getHiiflfhdkkgFieldBuilder() : null;
                    } else {
                        this.hiiflfhdkkgBuilder_.addAllMessages(other.hiiflfhdkkg_);
                    }
                }
                if (other.getTraderId() != 0) {
                    setTraderId(other.getTraderId());
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
                VintageMarketTraderInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = VintageMarketTraderInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (VintageMarketTraderInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            private void ensureHiiflfhdkkgIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.hiiflfhdkkg_ = new ArrayList(this.hiiflfhdkkg_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
            public List<ItemParamOuterClass.ItemParam> getHiiflfhdkkgList() {
                if (this.hiiflfhdkkgBuilder_ == null) {
                    return Collections.unmodifiableList(this.hiiflfhdkkg_);
                }
                return this.hiiflfhdkkgBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
            public int getHiiflfhdkkgCount() {
                if (this.hiiflfhdkkgBuilder_ == null) {
                    return this.hiiflfhdkkg_.size();
                }
                return this.hiiflfhdkkgBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
            public ItemParamOuterClass.ItemParam getHiiflfhdkkg(int index) {
                if (this.hiiflfhdkkgBuilder_ == null) {
                    return this.hiiflfhdkkg_.get(index);
                }
                return this.hiiflfhdkkgBuilder_.getMessage(index);
            }

            public Builder setHiiflfhdkkg(int index, ItemParamOuterClass.ItemParam value) {
                if (this.hiiflfhdkkgBuilder_ != null) {
                    this.hiiflfhdkkgBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureHiiflfhdkkgIsMutable();
                    this.hiiflfhdkkg_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setHiiflfhdkkg(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.hiiflfhdkkgBuilder_ == null) {
                    ensureHiiflfhdkkgIsMutable();
                    this.hiiflfhdkkg_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.hiiflfhdkkgBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addHiiflfhdkkg(ItemParamOuterClass.ItemParam value) {
                if (this.hiiflfhdkkgBuilder_ != null) {
                    this.hiiflfhdkkgBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureHiiflfhdkkgIsMutable();
                    this.hiiflfhdkkg_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addHiiflfhdkkg(int index, ItemParamOuterClass.ItemParam value) {
                if (this.hiiflfhdkkgBuilder_ != null) {
                    this.hiiflfhdkkgBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureHiiflfhdkkgIsMutable();
                    this.hiiflfhdkkg_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addHiiflfhdkkg(ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.hiiflfhdkkgBuilder_ == null) {
                    ensureHiiflfhdkkgIsMutable();
                    this.hiiflfhdkkg_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.hiiflfhdkkgBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addHiiflfhdkkg(int index, ItemParamOuterClass.ItemParam.Builder builderForValue) {
                if (this.hiiflfhdkkgBuilder_ == null) {
                    ensureHiiflfhdkkgIsMutable();
                    this.hiiflfhdkkg_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.hiiflfhdkkgBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllHiiflfhdkkg(Iterable<? extends ItemParamOuterClass.ItemParam> values) {
                if (this.hiiflfhdkkgBuilder_ == null) {
                    ensureHiiflfhdkkgIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.hiiflfhdkkg_);
                    onChanged();
                } else {
                    this.hiiflfhdkkgBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearHiiflfhdkkg() {
                if (this.hiiflfhdkkgBuilder_ == null) {
                    this.hiiflfhdkkg_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.hiiflfhdkkgBuilder_.clear();
                }
                return this;
            }

            public Builder removeHiiflfhdkkg(int index) {
                if (this.hiiflfhdkkgBuilder_ == null) {
                    ensureHiiflfhdkkgIsMutable();
                    this.hiiflfhdkkg_.remove(index);
                    onChanged();
                } else {
                    this.hiiflfhdkkgBuilder_.remove(index);
                }
                return this;
            }

            public ItemParamOuterClass.ItemParam.Builder getHiiflfhdkkgBuilder(int index) {
                return getHiiflfhdkkgFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
            public ItemParamOuterClass.ItemParamOrBuilder getHiiflfhdkkgOrBuilder(int index) {
                if (this.hiiflfhdkkgBuilder_ == null) {
                    return this.hiiflfhdkkg_.get(index);
                }
                return this.hiiflfhdkkgBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
            public List<? extends ItemParamOuterClass.ItemParamOrBuilder> getHiiflfhdkkgOrBuilderList() {
                if (this.hiiflfhdkkgBuilder_ != null) {
                    return this.hiiflfhdkkgBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.hiiflfhdkkg_);
            }

            public ItemParamOuterClass.ItemParam.Builder addHiiflfhdkkgBuilder() {
                return getHiiflfhdkkgFieldBuilder().addBuilder(ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public ItemParamOuterClass.ItemParam.Builder addHiiflfhdkkgBuilder(int index) {
                return getHiiflfhdkkgFieldBuilder().addBuilder(index, ItemParamOuterClass.ItemParam.getDefaultInstance());
            }

            public List<ItemParamOuterClass.ItemParam.Builder> getHiiflfhdkkgBuilderList() {
                return getHiiflfhdkkgFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<ItemParamOuterClass.ItemParam, ItemParamOuterClass.ItemParam.Builder, ItemParamOuterClass.ItemParamOrBuilder> getHiiflfhdkkgFieldBuilder() {
                if (this.hiiflfhdkkgBuilder_ == null) {
                    this.hiiflfhdkkgBuilder_ = new RepeatedFieldBuilderV3<>(this.hiiflfhdkkg_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.hiiflfhdkkg_ = null;
                }
                return this.hiiflfhdkkgBuilder_;
            }

            @Override // emu.grasscutter.net.proto.VintageMarketTraderInfoOuterClass.VintageMarketTraderInfoOrBuilder
            public int getTraderId() {
                return this.traderId_;
            }

            public Builder setTraderId(int value) {
                this.traderId_ = value;
                onChanged();
                return this;
            }

            public Builder clearTraderId() {
                this.traderId_ = 0;
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

        public static VintageMarketTraderInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<VintageMarketTraderInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<VintageMarketTraderInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public VintageMarketTraderInfo getDefaultInstanceForType() {
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
