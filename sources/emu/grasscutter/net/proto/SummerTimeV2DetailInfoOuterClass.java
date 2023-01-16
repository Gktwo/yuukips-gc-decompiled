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
import emu.grasscutter.net.proto.SummerTimeV2BoatStageInfoOuterClass;
import emu.grasscutter.net.proto.SummerTimeV2DungeonStageInfoOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2DetailInfoOuterClass.class */
public final class SummerTimeV2DetailInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001cSummerTimeV2DetailInfo.proto\u001a\u001fSummerTimeV2BoatStageInfo.proto\u001a\"SummerTimeV2DungeonStageInfo.proto\"ç\u0001\n\u0016SummerTimeV2DetailInfo\u0012\u0019\n\u0011is_content_closed\u0018\u000e \u0001(\b\u0012\u001b\n\u0013Unk3300_BNNMNCKEHHO\u0018\t \u0001(\r\u0012>\n\u0017dungeon_stage_info_list\u0018\u0005 \u0003(\u000b2\u001d.SummerTimeV2DungeonStageInfo\u0012\u001b\n\u0013Unk3300_JHBCHFHAGFO\u0018\b \u0001(\r\u00128\n\u0014boat_stage_info_list\u0018\u0003 \u0003(\u000b2\u001a.SummerTimeV2BoatStageInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SummerTimeV2BoatStageInfoOuterClass.getDescriptor(), SummerTimeV2DungeonStageInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SummerTimeV2DetailInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SummerTimeV2DetailInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SummerTimeV2DetailInfo_descriptor, new String[]{"IsContentClosed", "Unk3300BNNMNCKEHHO", "DungeonStageInfoList", "Unk3300JHBCHFHAGFO", "BoatStageInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2DetailInfoOuterClass$SummerTimeV2DetailInfoOrBuilder.class */
    public interface SummerTimeV2DetailInfoOrBuilder extends MessageOrBuilder {
        boolean getIsContentClosed();

        int getUnk3300BNNMNCKEHHO();

        List<SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo> getDungeonStageInfoListList();

        SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo getDungeonStageInfoList(int i);

        int getDungeonStageInfoListCount();

        List<? extends SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder> getDungeonStageInfoListOrBuilderList();

        SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder getDungeonStageInfoListOrBuilder(int i);

        int getUnk3300JHBCHFHAGFO();

        List<SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo> getBoatStageInfoListList();

        SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo getBoatStageInfoList(int i);

        int getBoatStageInfoListCount();

        List<? extends SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder> getBoatStageInfoListOrBuilderList();

        SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder getBoatStageInfoListOrBuilder(int i);
    }

    private SummerTimeV2DetailInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2DetailInfoOuterClass$SummerTimeV2DetailInfo.class */
    public static final class SummerTimeV2DetailInfo extends GeneratedMessageV3 implements SummerTimeV2DetailInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int IS_CONTENT_CLOSED_FIELD_NUMBER = 14;
        private boolean isContentClosed_;
        public static final int UNK3300_BNNMNCKEHHO_FIELD_NUMBER = 9;
        private int unk3300BNNMNCKEHHO_;
        public static final int DUNGEON_STAGE_INFO_LIST_FIELD_NUMBER = 5;
        private List<SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo> dungeonStageInfoList_;
        public static final int UNK3300_JHBCHFHAGFO_FIELD_NUMBER = 8;
        private int unk3300JHBCHFHAGFO_;
        public static final int BOAT_STAGE_INFO_LIST_FIELD_NUMBER = 3;
        private List<SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo> boatStageInfoList_;
        private byte memoizedIsInitialized;
        private static final SummerTimeV2DetailInfo DEFAULT_INSTANCE = new SummerTimeV2DetailInfo();
        private static final Parser<SummerTimeV2DetailInfo> PARSER = new AbstractParser<SummerTimeV2DetailInfo>() { // from class: emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfo.1
            @Override // com.google.protobuf.Parser
            public SummerTimeV2DetailInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SummerTimeV2DetailInfo(input, extensionRegistry);
            }
        };

        private SummerTimeV2DetailInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SummerTimeV2DetailInfo() {
            this.memoizedIsInitialized = -1;
            this.dungeonStageInfoList_ = Collections.emptyList();
            this.boatStageInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SummerTimeV2DetailInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x00f1 */
        private SummerTimeV2DetailInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 26:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.boatStageInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.boatStageInfoList_.add((SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo) input.readMessage(SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo.parser(), extensionRegistry));
                                break;
                            case 42:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.dungeonStageInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.dungeonStageInfoList_.add((SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo) input.readMessage(SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo.parser(), extensionRegistry));
                                break;
                            case 64:
                                this.unk3300JHBCHFHAGFO_ = input.readUInt32();
                                break;
                            case 72:
                                this.unk3300BNNMNCKEHHO_ = input.readUInt32();
                                break;
                            case 112:
                                this.isContentClosed_ = input.readBool();
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
                if ((mutable_bitField0_ & 2) != 0) {
                    this.boatStageInfoList_ = Collections.unmodifiableList(this.boatStageInfoList_);
                }
                if ((mutable_bitField0_ & 1) != 0) {
                    this.dungeonStageInfoList_ = Collections.unmodifiableList(this.dungeonStageInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SummerTimeV2DetailInfoOuterClass.internal_static_SummerTimeV2DetailInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SummerTimeV2DetailInfoOuterClass.internal_static_SummerTimeV2DetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SummerTimeV2DetailInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
        public boolean getIsContentClosed() {
            return this.isContentClosed_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
        public int getUnk3300BNNMNCKEHHO() {
            return this.unk3300BNNMNCKEHHO_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
        public List<SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo> getDungeonStageInfoListList() {
            return this.dungeonStageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
        public List<? extends SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder> getDungeonStageInfoListOrBuilderList() {
            return this.dungeonStageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
        public int getDungeonStageInfoListCount() {
            return this.dungeonStageInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
        public SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo getDungeonStageInfoList(int index) {
            return this.dungeonStageInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
        public SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder getDungeonStageInfoListOrBuilder(int index) {
            return this.dungeonStageInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
        public int getUnk3300JHBCHFHAGFO() {
            return this.unk3300JHBCHFHAGFO_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
        public List<SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo> getBoatStageInfoListList() {
            return this.boatStageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
        public List<? extends SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder> getBoatStageInfoListOrBuilderList() {
            return this.boatStageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
        public int getBoatStageInfoListCount() {
            return this.boatStageInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
        public SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo getBoatStageInfoList(int index) {
            return this.boatStageInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
        public SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder getBoatStageInfoListOrBuilder(int index) {
            return this.boatStageInfoList_.get(index);
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
            for (int i = 0; i < this.boatStageInfoList_.size(); i++) {
                output.writeMessage(3, this.boatStageInfoList_.get(i));
            }
            for (int i2 = 0; i2 < this.dungeonStageInfoList_.size(); i2++) {
                output.writeMessage(5, this.dungeonStageInfoList_.get(i2));
            }
            if (this.unk3300JHBCHFHAGFO_ != 0) {
                output.writeUInt32(8, this.unk3300JHBCHFHAGFO_);
            }
            if (this.unk3300BNNMNCKEHHO_ != 0) {
                output.writeUInt32(9, this.unk3300BNNMNCKEHHO_);
            }
            if (this.isContentClosed_) {
                output.writeBool(14, this.isContentClosed_);
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
            for (int i = 0; i < this.boatStageInfoList_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.boatStageInfoList_.get(i));
            }
            for (int i2 = 0; i2 < this.dungeonStageInfoList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.dungeonStageInfoList_.get(i2));
            }
            if (this.unk3300JHBCHFHAGFO_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(8, this.unk3300JHBCHFHAGFO_);
            }
            if (this.unk3300BNNMNCKEHHO_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(9, this.unk3300BNNMNCKEHHO_);
            }
            if (this.isContentClosed_) {
                size2 += CodedOutputStream.computeBoolSize(14, this.isContentClosed_);
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
            if (!(obj instanceof SummerTimeV2DetailInfo)) {
                return equals(obj);
            }
            SummerTimeV2DetailInfo other = (SummerTimeV2DetailInfo) obj;
            return getIsContentClosed() == other.getIsContentClosed() && getUnk3300BNNMNCKEHHO() == other.getUnk3300BNNMNCKEHHO() && getDungeonStageInfoListList().equals(other.getDungeonStageInfoListList()) && getUnk3300JHBCHFHAGFO() == other.getUnk3300JHBCHFHAGFO() && getBoatStageInfoListList().equals(other.getBoatStageInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 14)) + Internal.hashBoolean(getIsContentClosed()))) + 9)) + getUnk3300BNNMNCKEHHO();
            if (getDungeonStageInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getDungeonStageInfoListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 8)) + getUnk3300JHBCHFHAGFO();
            if (getBoatStageInfoListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 3)) + getBoatStageInfoListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static SummerTimeV2DetailInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeV2DetailInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeV2DetailInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeV2DetailInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeV2DetailInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeV2DetailInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeV2DetailInfo parseFrom(InputStream input) throws IOException {
            return (SummerTimeV2DetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SummerTimeV2DetailInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeV2DetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SummerTimeV2DetailInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (SummerTimeV2DetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SummerTimeV2DetailInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeV2DetailInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SummerTimeV2DetailInfo parseFrom(CodedInputStream input) throws IOException {
            return (SummerTimeV2DetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SummerTimeV2DetailInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeV2DetailInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SummerTimeV2DetailInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2DetailInfoOuterClass$SummerTimeV2DetailInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SummerTimeV2DetailInfoOrBuilder {
            private int bitField0_;
            private boolean isContentClosed_;
            private int unk3300BNNMNCKEHHO_;
            private RepeatedFieldBuilderV3<SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo, SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo.Builder, SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder> dungeonStageInfoListBuilder_;
            private int unk3300JHBCHFHAGFO_;
            private RepeatedFieldBuilderV3<SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo, SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo.Builder, SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder> boatStageInfoListBuilder_;
            private List<SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo> dungeonStageInfoList_ = Collections.emptyList();
            private List<SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo> boatStageInfoList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return SummerTimeV2DetailInfoOuterClass.internal_static_SummerTimeV2DetailInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SummerTimeV2DetailInfoOuterClass.internal_static_SummerTimeV2DetailInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(SummerTimeV2DetailInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SummerTimeV2DetailInfo.alwaysUseFieldBuilders) {
                    getDungeonStageInfoListFieldBuilder();
                    getBoatStageInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isContentClosed_ = false;
                this.unk3300BNNMNCKEHHO_ = 0;
                if (this.dungeonStageInfoListBuilder_ == null) {
                    this.dungeonStageInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.dungeonStageInfoListBuilder_.clear();
                }
                this.unk3300JHBCHFHAGFO_ = 0;
                if (this.boatStageInfoListBuilder_ == null) {
                    this.boatStageInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.boatStageInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SummerTimeV2DetailInfoOuterClass.internal_static_SummerTimeV2DetailInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SummerTimeV2DetailInfo getDefaultInstanceForType() {
                return SummerTimeV2DetailInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SummerTimeV2DetailInfo build() {
                SummerTimeV2DetailInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SummerTimeV2DetailInfo buildPartial() {
                SummerTimeV2DetailInfo result = new SummerTimeV2DetailInfo(this);
                int i = this.bitField0_;
                result.isContentClosed_ = this.isContentClosed_;
                result.unk3300BNNMNCKEHHO_ = this.unk3300BNNMNCKEHHO_;
                if (this.dungeonStageInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.dungeonStageInfoList_ = Collections.unmodifiableList(this.dungeonStageInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.dungeonStageInfoList_ = this.dungeonStageInfoList_;
                } else {
                    result.dungeonStageInfoList_ = this.dungeonStageInfoListBuilder_.build();
                }
                result.unk3300JHBCHFHAGFO_ = this.unk3300JHBCHFHAGFO_;
                if (this.boatStageInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.boatStageInfoList_ = Collections.unmodifiableList(this.boatStageInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.boatStageInfoList_ = this.boatStageInfoList_;
                } else {
                    result.boatStageInfoList_ = this.boatStageInfoListBuilder_.build();
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
                if (other instanceof SummerTimeV2DetailInfo) {
                    return mergeFrom((SummerTimeV2DetailInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SummerTimeV2DetailInfo other) {
                if (other == SummerTimeV2DetailInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsContentClosed()) {
                    setIsContentClosed(other.getIsContentClosed());
                }
                if (other.getUnk3300BNNMNCKEHHO() != 0) {
                    setUnk3300BNNMNCKEHHO(other.getUnk3300BNNMNCKEHHO());
                }
                if (this.dungeonStageInfoListBuilder_ == null) {
                    if (!other.dungeonStageInfoList_.isEmpty()) {
                        if (this.dungeonStageInfoList_.isEmpty()) {
                            this.dungeonStageInfoList_ = other.dungeonStageInfoList_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDungeonStageInfoListIsMutable();
                            this.dungeonStageInfoList_.addAll(other.dungeonStageInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.dungeonStageInfoList_.isEmpty()) {
                    if (this.dungeonStageInfoListBuilder_.isEmpty()) {
                        this.dungeonStageInfoListBuilder_.dispose();
                        this.dungeonStageInfoListBuilder_ = null;
                        this.dungeonStageInfoList_ = other.dungeonStageInfoList_;
                        this.bitField0_ &= -2;
                        this.dungeonStageInfoListBuilder_ = SummerTimeV2DetailInfo.alwaysUseFieldBuilders ? getDungeonStageInfoListFieldBuilder() : null;
                    } else {
                        this.dungeonStageInfoListBuilder_.addAllMessages(other.dungeonStageInfoList_);
                    }
                }
                if (other.getUnk3300JHBCHFHAGFO() != 0) {
                    setUnk3300JHBCHFHAGFO(other.getUnk3300JHBCHFHAGFO());
                }
                if (this.boatStageInfoListBuilder_ == null) {
                    if (!other.boatStageInfoList_.isEmpty()) {
                        if (this.boatStageInfoList_.isEmpty()) {
                            this.boatStageInfoList_ = other.boatStageInfoList_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureBoatStageInfoListIsMutable();
                            this.boatStageInfoList_.addAll(other.boatStageInfoList_);
                        }
                        onChanged();
                    }
                } else if (!other.boatStageInfoList_.isEmpty()) {
                    if (this.boatStageInfoListBuilder_.isEmpty()) {
                        this.boatStageInfoListBuilder_.dispose();
                        this.boatStageInfoListBuilder_ = null;
                        this.boatStageInfoList_ = other.boatStageInfoList_;
                        this.bitField0_ &= -3;
                        this.boatStageInfoListBuilder_ = SummerTimeV2DetailInfo.alwaysUseFieldBuilders ? getBoatStageInfoListFieldBuilder() : null;
                    } else {
                        this.boatStageInfoListBuilder_.addAllMessages(other.boatStageInfoList_);
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
                SummerTimeV2DetailInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = SummerTimeV2DetailInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SummerTimeV2DetailInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
            public boolean getIsContentClosed() {
                return this.isContentClosed_;
            }

            public Builder setIsContentClosed(boolean value) {
                this.isContentClosed_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsContentClosed() {
                this.isContentClosed_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
            public int getUnk3300BNNMNCKEHHO() {
                return this.unk3300BNNMNCKEHHO_;
            }

            public Builder setUnk3300BNNMNCKEHHO(int value) {
                this.unk3300BNNMNCKEHHO_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300BNNMNCKEHHO() {
                this.unk3300BNNMNCKEHHO_ = 0;
                onChanged();
                return this;
            }

            private void ensureDungeonStageInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.dungeonStageInfoList_ = new ArrayList(this.dungeonStageInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
            public List<SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo> getDungeonStageInfoListList() {
                if (this.dungeonStageInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.dungeonStageInfoList_);
                }
                return this.dungeonStageInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
            public int getDungeonStageInfoListCount() {
                if (this.dungeonStageInfoListBuilder_ == null) {
                    return this.dungeonStageInfoList_.size();
                }
                return this.dungeonStageInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
            public SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo getDungeonStageInfoList(int index) {
                if (this.dungeonStageInfoListBuilder_ == null) {
                    return this.dungeonStageInfoList_.get(index);
                }
                return this.dungeonStageInfoListBuilder_.getMessage(index);
            }

            public Builder setDungeonStageInfoList(int index, SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo value) {
                if (this.dungeonStageInfoListBuilder_ != null) {
                    this.dungeonStageInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDungeonStageInfoListIsMutable();
                    this.dungeonStageInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDungeonStageInfoList(int index, SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo.Builder builderForValue) {
                if (this.dungeonStageInfoListBuilder_ == null) {
                    ensureDungeonStageInfoListIsMutable();
                    this.dungeonStageInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dungeonStageInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDungeonStageInfoList(SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo value) {
                if (this.dungeonStageInfoListBuilder_ != null) {
                    this.dungeonStageInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDungeonStageInfoListIsMutable();
                    this.dungeonStageInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDungeonStageInfoList(int index, SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo value) {
                if (this.dungeonStageInfoListBuilder_ != null) {
                    this.dungeonStageInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDungeonStageInfoListIsMutable();
                    this.dungeonStageInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDungeonStageInfoList(SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo.Builder builderForValue) {
                if (this.dungeonStageInfoListBuilder_ == null) {
                    ensureDungeonStageInfoListIsMutable();
                    this.dungeonStageInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dungeonStageInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDungeonStageInfoList(int index, SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo.Builder builderForValue) {
                if (this.dungeonStageInfoListBuilder_ == null) {
                    ensureDungeonStageInfoListIsMutable();
                    this.dungeonStageInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dungeonStageInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDungeonStageInfoList(Iterable<? extends SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo> values) {
                if (this.dungeonStageInfoListBuilder_ == null) {
                    ensureDungeonStageInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.dungeonStageInfoList_);
                    onChanged();
                } else {
                    this.dungeonStageInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDungeonStageInfoList() {
                if (this.dungeonStageInfoListBuilder_ == null) {
                    this.dungeonStageInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.dungeonStageInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeDungeonStageInfoList(int index) {
                if (this.dungeonStageInfoListBuilder_ == null) {
                    ensureDungeonStageInfoListIsMutable();
                    this.dungeonStageInfoList_.remove(index);
                    onChanged();
                } else {
                    this.dungeonStageInfoListBuilder_.remove(index);
                }
                return this;
            }

            public SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo.Builder getDungeonStageInfoListBuilder(int index) {
                return getDungeonStageInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
            public SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder getDungeonStageInfoListOrBuilder(int index) {
                if (this.dungeonStageInfoListBuilder_ == null) {
                    return this.dungeonStageInfoList_.get(index);
                }
                return this.dungeonStageInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
            public List<? extends SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder> getDungeonStageInfoListOrBuilderList() {
                if (this.dungeonStageInfoListBuilder_ != null) {
                    return this.dungeonStageInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.dungeonStageInfoList_);
            }

            public SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo.Builder addDungeonStageInfoListBuilder() {
                return getDungeonStageInfoListFieldBuilder().addBuilder(SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo.getDefaultInstance());
            }

            public SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo.Builder addDungeonStageInfoListBuilder(int index) {
                return getDungeonStageInfoListFieldBuilder().addBuilder(index, SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo.getDefaultInstance());
            }

            public List<SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo.Builder> getDungeonStageInfoListBuilderList() {
                return getDungeonStageInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo, SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo.Builder, SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder> getDungeonStageInfoListFieldBuilder() {
                if (this.dungeonStageInfoListBuilder_ == null) {
                    this.dungeonStageInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.dungeonStageInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.dungeonStageInfoList_ = null;
                }
                return this.dungeonStageInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
            public int getUnk3300JHBCHFHAGFO() {
                return this.unk3300JHBCHFHAGFO_;
            }

            public Builder setUnk3300JHBCHFHAGFO(int value) {
                this.unk3300JHBCHFHAGFO_ = value;
                onChanged();
                return this;
            }

            public Builder clearUnk3300JHBCHFHAGFO() {
                this.unk3300JHBCHFHAGFO_ = 0;
                onChanged();
                return this;
            }

            private void ensureBoatStageInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.boatStageInfoList_ = new ArrayList(this.boatStageInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
            public List<SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo> getBoatStageInfoListList() {
                if (this.boatStageInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.boatStageInfoList_);
                }
                return this.boatStageInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
            public int getBoatStageInfoListCount() {
                if (this.boatStageInfoListBuilder_ == null) {
                    return this.boatStageInfoList_.size();
                }
                return this.boatStageInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
            public SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo getBoatStageInfoList(int index) {
                if (this.boatStageInfoListBuilder_ == null) {
                    return this.boatStageInfoList_.get(index);
                }
                return this.boatStageInfoListBuilder_.getMessage(index);
            }

            public Builder setBoatStageInfoList(int index, SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo value) {
                if (this.boatStageInfoListBuilder_ != null) {
                    this.boatStageInfoListBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBoatStageInfoListIsMutable();
                    this.boatStageInfoList_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setBoatStageInfoList(int index, SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo.Builder builderForValue) {
                if (this.boatStageInfoListBuilder_ == null) {
                    ensureBoatStageInfoListIsMutable();
                    this.boatStageInfoList_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.boatStageInfoListBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addBoatStageInfoList(SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo value) {
                if (this.boatStageInfoListBuilder_ != null) {
                    this.boatStageInfoListBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBoatStageInfoListIsMutable();
                    this.boatStageInfoList_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addBoatStageInfoList(int index, SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo value) {
                if (this.boatStageInfoListBuilder_ != null) {
                    this.boatStageInfoListBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureBoatStageInfoListIsMutable();
                    this.boatStageInfoList_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addBoatStageInfoList(SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo.Builder builderForValue) {
                if (this.boatStageInfoListBuilder_ == null) {
                    ensureBoatStageInfoListIsMutable();
                    this.boatStageInfoList_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.boatStageInfoListBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addBoatStageInfoList(int index, SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo.Builder builderForValue) {
                if (this.boatStageInfoListBuilder_ == null) {
                    ensureBoatStageInfoListIsMutable();
                    this.boatStageInfoList_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.boatStageInfoListBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllBoatStageInfoList(Iterable<? extends SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo> values) {
                if (this.boatStageInfoListBuilder_ == null) {
                    ensureBoatStageInfoListIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.boatStageInfoList_);
                    onChanged();
                } else {
                    this.boatStageInfoListBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearBoatStageInfoList() {
                if (this.boatStageInfoListBuilder_ == null) {
                    this.boatStageInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.boatStageInfoListBuilder_.clear();
                }
                return this;
            }

            public Builder removeBoatStageInfoList(int index) {
                if (this.boatStageInfoListBuilder_ == null) {
                    ensureBoatStageInfoListIsMutable();
                    this.boatStageInfoList_.remove(index);
                    onChanged();
                } else {
                    this.boatStageInfoListBuilder_.remove(index);
                }
                return this;
            }

            public SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo.Builder getBoatStageInfoListBuilder(int index) {
                return getBoatStageInfoListFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
            public SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder getBoatStageInfoListOrBuilder(int index) {
                if (this.boatStageInfoListBuilder_ == null) {
                    return this.boatStageInfoList_.get(index);
                }
                return this.boatStageInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2DetailInfoOuterClass.SummerTimeV2DetailInfoOrBuilder
            public List<? extends SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder> getBoatStageInfoListOrBuilderList() {
                if (this.boatStageInfoListBuilder_ != null) {
                    return this.boatStageInfoListBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.boatStageInfoList_);
            }

            public SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo.Builder addBoatStageInfoListBuilder() {
                return getBoatStageInfoListFieldBuilder().addBuilder(SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo.getDefaultInstance());
            }

            public SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo.Builder addBoatStageInfoListBuilder(int index) {
                return getBoatStageInfoListFieldBuilder().addBuilder(index, SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo.getDefaultInstance());
            }

            public List<SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo.Builder> getBoatStageInfoListBuilderList() {
                return getBoatStageInfoListFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo, SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo.Builder, SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder> getBoatStageInfoListFieldBuilder() {
                if (this.boatStageInfoListBuilder_ == null) {
                    this.boatStageInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.boatStageInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.boatStageInfoList_ = null;
                }
                return this.boatStageInfoListBuilder_;
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

        public static SummerTimeV2DetailInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SummerTimeV2DetailInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SummerTimeV2DetailInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SummerTimeV2DetailInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SummerTimeV2BoatStageInfoOuterClass.getDescriptor();
        SummerTimeV2DungeonStageInfoOuterClass.getDescriptor();
    }
}
