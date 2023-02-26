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
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import emu.grasscutter.net.proto.IrodoriChessEntranceDetailInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessMapDataOuterClass.class */
public final class IrodoriChessMapDataOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0019IrodoriChessMapData.proto\u001a$IrodoriChessEntranceDetailInfo.proto\"\u0001\n\u0013IrodoriChessMapData\u0012\r\n\u0005mapId\u0018\r \u0001(\r\u0012\u0011\n\tbestScore\u0018\u0003 \u0001(\r\u0012\u0013\n\u000bbecodaoleil\u0018\u0004 \u0003(\r\u00124\n\u000bajcepcgbnfe\u0018\u0005 \u0001(\u000b2\u001f.IrodoriChessEntranceDetailInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{IrodoriChessEntranceDetailInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_IrodoriChessMapData_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_IrodoriChessMapData_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_IrodoriChessMapData_descriptor, new String[]{"MapId", "BestScore", "Becodaoleil", "Ajcepcgbnfe"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessMapDataOuterClass$IrodoriChessMapDataOrBuilder.class */
    public interface IrodoriChessMapDataOrBuilder extends MessageOrBuilder {
        int getMapId();

        int getBestScore();

        List<Integer> getBecodaoleilList();

        int getBecodaoleilCount();

        int getBecodaoleil(int i);

        boolean hasAjcepcgbnfe();

        IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo getAjcepcgbnfe();

        IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfoOrBuilder getAjcepcgbnfeOrBuilder();
    }

    private IrodoriChessMapDataOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessMapDataOuterClass$IrodoriChessMapData.class */
    public static final class IrodoriChessMapData extends GeneratedMessageV3 implements IrodoriChessMapDataOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int MAPID_FIELD_NUMBER = 13;
        private int mapId_;
        public static final int BESTSCORE_FIELD_NUMBER = 3;
        private int bestScore_;
        public static final int BECODAOLEIL_FIELD_NUMBER = 4;
        private Internal.IntList becodaoleil_;
        private int becodaoleilMemoizedSerializedSize;
        public static final int AJCEPCGBNFE_FIELD_NUMBER = 5;
        private IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo ajcepcgbnfe_;
        private byte memoizedIsInitialized;
        private static final IrodoriChessMapData DEFAULT_INSTANCE = new IrodoriChessMapData();
        private static final Parser<IrodoriChessMapData> PARSER = new AbstractParser<IrodoriChessMapData>() { // from class: emu.grasscutter.net.proto.IrodoriChessMapDataOuterClass.IrodoriChessMapData.1
            @Override // com.google.protobuf.Parser
            public IrodoriChessMapData parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new IrodoriChessMapData(input, extensionRegistry);
            }
        };

        private IrodoriChessMapData(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.becodaoleilMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
        }

        private IrodoriChessMapData() {
            this.becodaoleilMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = -1;
            this.becodaoleil_ = emptyIntList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new IrodoriChessMapData();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private IrodoriChessMapData(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 24:
                                this.bestScore_ = input.readUInt32();
                                break;
                            case 32:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.becodaoleil_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                this.becodaoleil_.addInt(input.readUInt32());
                                break;
                            case 34:
                                int limit = input.pushLimit(input.readRawVarint32());
                                if ((mutable_bitField0_ & 1) == 0 && input.getBytesUntilLimit() > 0) {
                                    this.becodaoleil_ = newIntList();
                                    mutable_bitField0_ |= 1;
                                }
                                while (input.getBytesUntilLimit() > 0) {
                                    this.becodaoleil_.addInt(input.readUInt32());
                                }
                                input.popLimit(limit);
                                break;
                            case 42:
                                IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo.Builder subBuilder = this.ajcepcgbnfe_ != null ? this.ajcepcgbnfe_.toBuilder() : null;
                                this.ajcepcgbnfe_ = (IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo) input.readMessage(IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo.parser(), extensionRegistry);
                                if (subBuilder == null) {
                                    break;
                                } else {
                                    subBuilder.mergeFrom(this.ajcepcgbnfe_);
                                    this.ajcepcgbnfe_ = subBuilder.buildPartial();
                                    break;
                                }
                            case 104:
                                this.mapId_ = input.readUInt32();
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
                    this.becodaoleil_.makeImmutable();
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return IrodoriChessMapDataOuterClass.internal_static_IrodoriChessMapData_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return IrodoriChessMapDataOuterClass.internal_static_IrodoriChessMapData_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriChessMapData.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder
        public int getMapId() {
            return this.mapId_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder
        public int getBestScore() {
            return this.bestScore_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder
        public List<Integer> getBecodaoleilList() {
            return this.becodaoleil_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder
        public int getBecodaoleilCount() {
            return this.becodaoleil_.size();
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder
        public int getBecodaoleil(int index) {
            return this.becodaoleil_.getInt(index);
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder
        public boolean hasAjcepcgbnfe() {
            return this.ajcepcgbnfe_ != null;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder
        public IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo getAjcepcgbnfe() {
            return this.ajcepcgbnfe_ == null ? IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo.getDefaultInstance() : this.ajcepcgbnfe_;
        }

        @Override // emu.grasscutter.net.proto.IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder
        public IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfoOrBuilder getAjcepcgbnfeOrBuilder() {
            return getAjcepcgbnfe();
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
            if (this.bestScore_ != 0) {
                output.writeUInt32(3, this.bestScore_);
            }
            if (getBecodaoleilList().size() > 0) {
                output.writeUInt32NoTag(34);
                output.writeUInt32NoTag(this.becodaoleilMemoizedSerializedSize);
            }
            for (int i = 0; i < this.becodaoleil_.size(); i++) {
                output.writeUInt32NoTag(this.becodaoleil_.getInt(i));
            }
            if (this.ajcepcgbnfe_ != null) {
                output.writeMessage(5, getAjcepcgbnfe());
            }
            if (this.mapId_ != 0) {
                output.writeUInt32(13, this.mapId_);
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
            if (this.bestScore_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(3, this.bestScore_);
            }
            int dataSize = 0;
            for (int i = 0; i < this.becodaoleil_.size(); i++) {
                dataSize += CodedOutputStream.computeUInt32SizeNoTag(this.becodaoleil_.getInt(i));
            }
            int size3 = size2 + dataSize;
            if (!getBecodaoleilList().isEmpty()) {
                size3 = size3 + 1 + CodedOutputStream.computeInt32SizeNoTag(dataSize);
            }
            this.becodaoleilMemoizedSerializedSize = dataSize;
            if (this.ajcepcgbnfe_ != null) {
                size3 += CodedOutputStream.computeMessageSize(5, getAjcepcgbnfe());
            }
            if (this.mapId_ != 0) {
                size3 += CodedOutputStream.computeUInt32Size(13, this.mapId_);
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
            if (!(obj instanceof IrodoriChessMapData)) {
                return equals(obj);
            }
            IrodoriChessMapData other = (IrodoriChessMapData) obj;
            if (getMapId() == other.getMapId() && getBestScore() == other.getBestScore() && getBecodaoleilList().equals(other.getBecodaoleilList()) && hasAjcepcgbnfe() == other.hasAjcepcgbnfe()) {
                return (!hasAjcepcgbnfe() || getAjcepcgbnfe().equals(other.getAjcepcgbnfe())) && this.unknownFields.equals(other.unknownFields);
            }
            return false;
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 13)) + getMapId())) + 3)) + getBestScore();
            if (getBecodaoleilCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getBecodaoleilList().hashCode();
            }
            if (hasAjcepcgbnfe()) {
                hash = (53 * ((37 * hash) + 5)) + getAjcepcgbnfe().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static IrodoriChessMapData parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessMapData parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessMapData parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessMapData parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessMapData parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static IrodoriChessMapData parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static IrodoriChessMapData parseFrom(InputStream input) throws IOException {
            return (IrodoriChessMapData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriChessMapData parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessMapData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriChessMapData parseDelimitedFrom(InputStream input) throws IOException {
            return (IrodoriChessMapData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static IrodoriChessMapData parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessMapData) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static IrodoriChessMapData parseFrom(CodedInputStream input) throws IOException {
            return (IrodoriChessMapData) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static IrodoriChessMapData parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (IrodoriChessMapData) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(IrodoriChessMapData prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/IrodoriChessMapDataOuterClass$IrodoriChessMapData$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements IrodoriChessMapDataOrBuilder {
            private int bitField0_;
            private int mapId_;
            private int bestScore_;
            private Internal.IntList becodaoleil_ = IrodoriChessMapData.emptyIntList();
            private IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo ajcepcgbnfe_;
            private SingleFieldBuilderV3<IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo, IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo.Builder, IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfoOrBuilder> ajcepcgbnfeBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return IrodoriChessMapDataOuterClass.internal_static_IrodoriChessMapData_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return IrodoriChessMapDataOuterClass.internal_static_IrodoriChessMapData_fieldAccessorTable.ensureFieldAccessorsInitialized(IrodoriChessMapData.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (IrodoriChessMapData.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.mapId_ = 0;
                this.bestScore_ = 0;
                this.becodaoleil_ = IrodoriChessMapData.emptyIntList();
                this.bitField0_ &= -2;
                if (this.ajcepcgbnfeBuilder_ == null) {
                    this.ajcepcgbnfe_ = null;
                } else {
                    this.ajcepcgbnfe_ = null;
                    this.ajcepcgbnfeBuilder_ = null;
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return IrodoriChessMapDataOuterClass.internal_static_IrodoriChessMapData_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public IrodoriChessMapData getDefaultInstanceForType() {
                return IrodoriChessMapData.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriChessMapData build() {
                IrodoriChessMapData result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public IrodoriChessMapData buildPartial() {
                IrodoriChessMapData result = new IrodoriChessMapData(this);
                int i = this.bitField0_;
                result.mapId_ = this.mapId_;
                result.bestScore_ = this.bestScore_;
                if ((this.bitField0_ & 1) != 0) {
                    this.becodaoleil_.makeImmutable();
                    this.bitField0_ &= -2;
                }
                result.becodaoleil_ = this.becodaoleil_;
                if (this.ajcepcgbnfeBuilder_ == null) {
                    result.ajcepcgbnfe_ = this.ajcepcgbnfe_;
                } else {
                    result.ajcepcgbnfe_ = this.ajcepcgbnfeBuilder_.build();
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
                if (other instanceof IrodoriChessMapData) {
                    return mergeFrom((IrodoriChessMapData) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(IrodoriChessMapData other) {
                if (other == IrodoriChessMapData.getDefaultInstance()) {
                    return this;
                }
                if (other.getMapId() != 0) {
                    setMapId(other.getMapId());
                }
                if (other.getBestScore() != 0) {
                    setBestScore(other.getBestScore());
                }
                if (!other.becodaoleil_.isEmpty()) {
                    if (this.becodaoleil_.isEmpty()) {
                        this.becodaoleil_ = other.becodaoleil_;
                        this.bitField0_ &= -2;
                    } else {
                        ensureBecodaoleilIsMutable();
                        this.becodaoleil_.addAll(other.becodaoleil_);
                    }
                    onChanged();
                }
                if (other.hasAjcepcgbnfe()) {
                    mergeAjcepcgbnfe(other.getAjcepcgbnfe());
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
                IrodoriChessMapData parsedMessage = null;
                try {
                    try {
                        parsedMessage = IrodoriChessMapData.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (IrodoriChessMapData) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder
            public int getMapId() {
                return this.mapId_;
            }

            public Builder setMapId(int value) {
                this.mapId_ = value;
                onChanged();
                return this;
            }

            public Builder clearMapId() {
                this.mapId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder
            public int getBestScore() {
                return this.bestScore_;
            }

            public Builder setBestScore(int value) {
                this.bestScore_ = value;
                onChanged();
                return this;
            }

            public Builder clearBestScore() {
                this.bestScore_ = 0;
                onChanged();
                return this;
            }

            private void ensureBecodaoleilIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.becodaoleil_ = IrodoriChessMapData.mutableCopy(this.becodaoleil_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder
            public List<Integer> getBecodaoleilList() {
                return (this.bitField0_ & 1) != 0 ? Collections.unmodifiableList(this.becodaoleil_) : this.becodaoleil_;
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder
            public int getBecodaoleilCount() {
                return this.becodaoleil_.size();
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder
            public int getBecodaoleil(int index) {
                return this.becodaoleil_.getInt(index);
            }

            public Builder setBecodaoleil(int index, int value) {
                ensureBecodaoleilIsMutable();
                this.becodaoleil_.setInt(index, value);
                onChanged();
                return this;
            }

            public Builder addBecodaoleil(int value) {
                ensureBecodaoleilIsMutable();
                this.becodaoleil_.addInt(value);
                onChanged();
                return this;
            }

            public Builder addAllBecodaoleil(Iterable<? extends Integer> values) {
                ensureBecodaoleilIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.becodaoleil_);
                onChanged();
                return this;
            }

            public Builder clearBecodaoleil() {
                this.becodaoleil_ = IrodoriChessMapData.emptyIntList();
                this.bitField0_ &= -2;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder
            public boolean hasAjcepcgbnfe() {
                return (this.ajcepcgbnfeBuilder_ == null && this.ajcepcgbnfe_ == null) ? false : true;
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder
            public IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo getAjcepcgbnfe() {
                if (this.ajcepcgbnfeBuilder_ == null) {
                    return this.ajcepcgbnfe_ == null ? IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo.getDefaultInstance() : this.ajcepcgbnfe_;
                }
                return this.ajcepcgbnfeBuilder_.getMessage();
            }

            public Builder setAjcepcgbnfe(IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo value) {
                if (this.ajcepcgbnfeBuilder_ != null) {
                    this.ajcepcgbnfeBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.ajcepcgbnfe_ = value;
                    onChanged();
                }
                return this;
            }

            public Builder setAjcepcgbnfe(IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo.Builder builderForValue) {
                if (this.ajcepcgbnfeBuilder_ == null) {
                    this.ajcepcgbnfe_ = builderForValue.build();
                    onChanged();
                } else {
                    this.ajcepcgbnfeBuilder_.setMessage(builderForValue.build());
                }
                return this;
            }

            public Builder mergeAjcepcgbnfe(IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo value) {
                if (this.ajcepcgbnfeBuilder_ == null) {
                    if (this.ajcepcgbnfe_ != null) {
                        this.ajcepcgbnfe_ = IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo.newBuilder(this.ajcepcgbnfe_).mergeFrom(value).buildPartial();
                    } else {
                        this.ajcepcgbnfe_ = value;
                    }
                    onChanged();
                } else {
                    this.ajcepcgbnfeBuilder_.mergeFrom(value);
                }
                return this;
            }

            public Builder clearAjcepcgbnfe() {
                if (this.ajcepcgbnfeBuilder_ == null) {
                    this.ajcepcgbnfe_ = null;
                    onChanged();
                } else {
                    this.ajcepcgbnfe_ = null;
                    this.ajcepcgbnfeBuilder_ = null;
                }
                return this;
            }

            public IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo.Builder getAjcepcgbnfeBuilder() {
                onChanged();
                return getAjcepcgbnfeFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.IrodoriChessMapDataOuterClass.IrodoriChessMapDataOrBuilder
            public IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfoOrBuilder getAjcepcgbnfeOrBuilder() {
                if (this.ajcepcgbnfeBuilder_ != null) {
                    return this.ajcepcgbnfeBuilder_.getMessageOrBuilder();
                }
                return this.ajcepcgbnfe_ == null ? IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo.getDefaultInstance() : this.ajcepcgbnfe_;
            }

            private SingleFieldBuilderV3<IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo, IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfo.Builder, IrodoriChessEntranceDetailInfoOuterClass.IrodoriChessEntranceDetailInfoOrBuilder> getAjcepcgbnfeFieldBuilder() {
                if (this.ajcepcgbnfeBuilder_ == null) {
                    this.ajcepcgbnfeBuilder_ = new SingleFieldBuilderV3<>(getAjcepcgbnfe(), getParentForChildren(), isClean());
                    this.ajcepcgbnfe_ = null;
                }
                return this.ajcepcgbnfeBuilder_;
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

        public static IrodoriChessMapData getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<IrodoriChessMapData> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<IrodoriChessMapData> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public IrodoriChessMapData getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        IrodoriChessEntranceDetailInfoOuterClass.getDescriptor();
    }
}
