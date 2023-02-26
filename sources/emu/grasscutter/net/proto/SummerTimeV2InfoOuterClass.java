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

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2InfoOuterClass.class */
public final class SummerTimeV2InfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0016SummerTimeV2Info.proto\u001a\u001fSummerTimeV2BoatStageInfo.proto\u001a\"SummerTimeV2DungeonStageInfo.proto\"Ö\u0001\n\u0010SummerTimeV2Info\u0012\u0014\n\fleftMonsters\u0018\u0007 \u0001(\b\u0012\u001b\n\u0013Unk3300_BNNMNCKEHHO\u0018\n \u0001(\r\u00125\n\u0011boatStageInfoList\u0018\u0006 \u0003(\u000b2\u001a.SummerTimeV2BoatStageInfo\u0012\u001b\n\u0013Unk3300_JHBCHFHAGFO\u0018\u000e \u0001(\r\u0012;\n\u0014dungeonStageInfoList\u0018\u000b \u0003(\u000b2\u001d.SummerTimeV2DungeonStageInfoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{SummerTimeV2BoatStageInfoOuterClass.getDescriptor(), SummerTimeV2DungeonStageInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_SummerTimeV2Info_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_SummerTimeV2Info_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_SummerTimeV2Info_descriptor, new String[]{"LeftMonsters", "Unk3300BNNMNCKEHHO", "BoatStageInfoList", "Unk3300JHBCHFHAGFO", "DungeonStageInfoList"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2InfoOuterClass$SummerTimeV2InfoOrBuilder.class */
    public interface SummerTimeV2InfoOrBuilder extends MessageOrBuilder {
        boolean getLeftMonsters();

        int getUnk3300BNNMNCKEHHO();

        List<SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo> getBoatStageInfoListList();

        SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo getBoatStageInfoList(int i);

        int getBoatStageInfoListCount();

        List<? extends SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder> getBoatStageInfoListOrBuilderList();

        SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder getBoatStageInfoListOrBuilder(int i);

        int getUnk3300JHBCHFHAGFO();

        List<SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo> getDungeonStageInfoListList();

        SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo getDungeonStageInfoList(int i);

        int getDungeonStageInfoListCount();

        List<? extends SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder> getDungeonStageInfoListOrBuilderList();

        SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder getDungeonStageInfoListOrBuilder(int i);
    }

    private SummerTimeV2InfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2InfoOuterClass$SummerTimeV2Info.class */
    public static final class SummerTimeV2Info extends GeneratedMessageV3 implements SummerTimeV2InfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int LEFTMONSTERS_FIELD_NUMBER = 7;
        private boolean leftMonsters_;
        public static final int UNK3300_BNNMNCKEHHO_FIELD_NUMBER = 10;
        private int unk3300BNNMNCKEHHO_;
        public static final int BOATSTAGEINFOLIST_FIELD_NUMBER = 6;
        private List<SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo> boatStageInfoList_;
        public static final int UNK3300_JHBCHFHAGFO_FIELD_NUMBER = 14;
        private int unk3300JHBCHFHAGFO_;
        public static final int DUNGEONSTAGEINFOLIST_FIELD_NUMBER = 11;
        private List<SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo> dungeonStageInfoList_;
        private byte memoizedIsInitialized;
        private static final SummerTimeV2Info DEFAULT_INSTANCE = new SummerTimeV2Info();
        private static final Parser<SummerTimeV2Info> PARSER = new AbstractParser<SummerTimeV2Info>() { // from class: emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2Info.1
            @Override // com.google.protobuf.Parser
            public SummerTimeV2Info parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new SummerTimeV2Info(input, extensionRegistry);
            }
        };

        private SummerTimeV2Info(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private SummerTimeV2Info() {
            this.memoizedIsInitialized = -1;
            this.boatStageInfoList_ = Collections.emptyList();
            this.dungeonStageInfoList_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new SummerTimeV2Info();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:64:0x00f1 */
        private SummerTimeV2Info(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                            case 50:
                                if ((mutable_bitField0_ & 1) == 0) {
                                    this.boatStageInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                }
                                this.boatStageInfoList_.add((SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo) input.readMessage(SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo.parser(), extensionRegistry));
                                break;
                            case 56:
                                this.leftMonsters_ = input.readBool();
                                break;
                            case 80:
                                this.unk3300BNNMNCKEHHO_ = input.readUInt32();
                                break;
                            case 90:
                                if ((mutable_bitField0_ & 2) == 0) {
                                    this.dungeonStageInfoList_ = new ArrayList();
                                    mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                }
                                this.dungeonStageInfoList_.add((SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo) input.readMessage(SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo.parser(), extensionRegistry));
                                break;
                            case 112:
                                this.unk3300JHBCHFHAGFO_ = input.readUInt32();
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
                    this.boatStageInfoList_ = Collections.unmodifiableList(this.boatStageInfoList_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.dungeonStageInfoList_ = Collections.unmodifiableList(this.dungeonStageInfoList_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return SummerTimeV2InfoOuterClass.internal_static_SummerTimeV2Info_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return SummerTimeV2InfoOuterClass.internal_static_SummerTimeV2Info_fieldAccessorTable.ensureFieldAccessorsInitialized(SummerTimeV2Info.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
        public boolean getLeftMonsters() {
            return this.leftMonsters_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
        public int getUnk3300BNNMNCKEHHO() {
            return this.unk3300BNNMNCKEHHO_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
        public List<SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo> getBoatStageInfoListList() {
            return this.boatStageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
        public List<? extends SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder> getBoatStageInfoListOrBuilderList() {
            return this.boatStageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
        public int getBoatStageInfoListCount() {
            return this.boatStageInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
        public SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo getBoatStageInfoList(int index) {
            return this.boatStageInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
        public SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder getBoatStageInfoListOrBuilder(int index) {
            return this.boatStageInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
        public int getUnk3300JHBCHFHAGFO() {
            return this.unk3300JHBCHFHAGFO_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
        public List<SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo> getDungeonStageInfoListList() {
            return this.dungeonStageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
        public List<? extends SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder> getDungeonStageInfoListOrBuilderList() {
            return this.dungeonStageInfoList_;
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
        public int getDungeonStageInfoListCount() {
            return this.dungeonStageInfoList_.size();
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
        public SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo getDungeonStageInfoList(int index) {
            return this.dungeonStageInfoList_.get(index);
        }

        @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
        public SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder getDungeonStageInfoListOrBuilder(int index) {
            return this.dungeonStageInfoList_.get(index);
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
                output.writeMessage(6, this.boatStageInfoList_.get(i));
            }
            if (this.leftMonsters_) {
                output.writeBool(7, this.leftMonsters_);
            }
            if (this.unk3300BNNMNCKEHHO_ != 0) {
                output.writeUInt32(10, this.unk3300BNNMNCKEHHO_);
            }
            for (int i2 = 0; i2 < this.dungeonStageInfoList_.size(); i2++) {
                output.writeMessage(11, this.dungeonStageInfoList_.get(i2));
            }
            if (this.unk3300JHBCHFHAGFO_ != 0) {
                output.writeUInt32(14, this.unk3300JHBCHFHAGFO_);
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
                size2 += CodedOutputStream.computeMessageSize(6, this.boatStageInfoList_.get(i));
            }
            if (this.leftMonsters_) {
                size2 += CodedOutputStream.computeBoolSize(7, this.leftMonsters_);
            }
            if (this.unk3300BNNMNCKEHHO_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(10, this.unk3300BNNMNCKEHHO_);
            }
            for (int i2 = 0; i2 < this.dungeonStageInfoList_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(11, this.dungeonStageInfoList_.get(i2));
            }
            if (this.unk3300JHBCHFHAGFO_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.unk3300JHBCHFHAGFO_);
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
            if (!(obj instanceof SummerTimeV2Info)) {
                return equals(obj);
            }
            SummerTimeV2Info other = (SummerTimeV2Info) obj;
            return getLeftMonsters() == other.getLeftMonsters() && getUnk3300BNNMNCKEHHO() == other.getUnk3300BNNMNCKEHHO() && getBoatStageInfoListList().equals(other.getBoatStageInfoListList()) && getUnk3300JHBCHFHAGFO() == other.getUnk3300JHBCHFHAGFO() && getDungeonStageInfoListList().equals(other.getDungeonStageInfoListList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 7)) + Internal.hashBoolean(getLeftMonsters()))) + 10)) + getUnk3300BNNMNCKEHHO();
            if (getBoatStageInfoListCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getBoatStageInfoListList().hashCode();
            }
            int hash2 = (53 * ((37 * hash) + 14)) + getUnk3300JHBCHFHAGFO();
            if (getDungeonStageInfoListCount() > 0) {
                hash2 = (53 * ((37 * hash2) + 11)) + getDungeonStageInfoListList().hashCode();
            }
            int hash3 = (29 * hash2) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash3;
            return hash3;
        }

        public static SummerTimeV2Info parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeV2Info parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeV2Info parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeV2Info parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeV2Info parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static SummerTimeV2Info parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static SummerTimeV2Info parseFrom(InputStream input) throws IOException {
            return (SummerTimeV2Info) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SummerTimeV2Info parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeV2Info) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static SummerTimeV2Info parseDelimitedFrom(InputStream input) throws IOException {
            return (SummerTimeV2Info) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static SummerTimeV2Info parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeV2Info) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static SummerTimeV2Info parseFrom(CodedInputStream input) throws IOException {
            return (SummerTimeV2Info) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static SummerTimeV2Info parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SummerTimeV2Info) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(SummerTimeV2Info prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SummerTimeV2InfoOuterClass$SummerTimeV2Info$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements SummerTimeV2InfoOrBuilder {
            private int bitField0_;
            private boolean leftMonsters_;
            private int unk3300BNNMNCKEHHO_;
            private RepeatedFieldBuilderV3<SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo, SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo.Builder, SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder> boatStageInfoListBuilder_;
            private int unk3300JHBCHFHAGFO_;
            private RepeatedFieldBuilderV3<SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo, SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo.Builder, SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder> dungeonStageInfoListBuilder_;
            private List<SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo> boatStageInfoList_ = Collections.emptyList();
            private List<SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo> dungeonStageInfoList_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return SummerTimeV2InfoOuterClass.internal_static_SummerTimeV2Info_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return SummerTimeV2InfoOuterClass.internal_static_SummerTimeV2Info_fieldAccessorTable.ensureFieldAccessorsInitialized(SummerTimeV2Info.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (SummerTimeV2Info.alwaysUseFieldBuilders) {
                    getBoatStageInfoListFieldBuilder();
                    getDungeonStageInfoListFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.leftMonsters_ = false;
                this.unk3300BNNMNCKEHHO_ = 0;
                if (this.boatStageInfoListBuilder_ == null) {
                    this.boatStageInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.boatStageInfoListBuilder_.clear();
                }
                this.unk3300JHBCHFHAGFO_ = 0;
                if (this.dungeonStageInfoListBuilder_ == null) {
                    this.dungeonStageInfoList_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.dungeonStageInfoListBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return SummerTimeV2InfoOuterClass.internal_static_SummerTimeV2Info_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public SummerTimeV2Info getDefaultInstanceForType() {
                return SummerTimeV2Info.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SummerTimeV2Info build() {
                SummerTimeV2Info result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public SummerTimeV2Info buildPartial() {
                SummerTimeV2Info result = new SummerTimeV2Info(this);
                int i = this.bitField0_;
                result.leftMonsters_ = this.leftMonsters_;
                result.unk3300BNNMNCKEHHO_ = this.unk3300BNNMNCKEHHO_;
                if (this.boatStageInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.boatStageInfoList_ = Collections.unmodifiableList(this.boatStageInfoList_);
                        this.bitField0_ &= -2;
                    }
                    result.boatStageInfoList_ = this.boatStageInfoList_;
                } else {
                    result.boatStageInfoList_ = this.boatStageInfoListBuilder_.build();
                }
                result.unk3300JHBCHFHAGFO_ = this.unk3300JHBCHFHAGFO_;
                if (this.dungeonStageInfoListBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.dungeonStageInfoList_ = Collections.unmodifiableList(this.dungeonStageInfoList_);
                        this.bitField0_ &= -3;
                    }
                    result.dungeonStageInfoList_ = this.dungeonStageInfoList_;
                } else {
                    result.dungeonStageInfoList_ = this.dungeonStageInfoListBuilder_.build();
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
                if (other instanceof SummerTimeV2Info) {
                    return mergeFrom((SummerTimeV2Info) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(SummerTimeV2Info other) {
                if (other == SummerTimeV2Info.getDefaultInstance()) {
                    return this;
                }
                if (other.getLeftMonsters()) {
                    setLeftMonsters(other.getLeftMonsters());
                }
                if (other.getUnk3300BNNMNCKEHHO() != 0) {
                    setUnk3300BNNMNCKEHHO(other.getUnk3300BNNMNCKEHHO());
                }
                if (this.boatStageInfoListBuilder_ == null) {
                    if (!other.boatStageInfoList_.isEmpty()) {
                        if (this.boatStageInfoList_.isEmpty()) {
                            this.boatStageInfoList_ = other.boatStageInfoList_;
                            this.bitField0_ &= -2;
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
                        this.bitField0_ &= -2;
                        this.boatStageInfoListBuilder_ = SummerTimeV2Info.alwaysUseFieldBuilders ? getBoatStageInfoListFieldBuilder() : null;
                    } else {
                        this.boatStageInfoListBuilder_.addAllMessages(other.boatStageInfoList_);
                    }
                }
                if (other.getUnk3300JHBCHFHAGFO() != 0) {
                    setUnk3300JHBCHFHAGFO(other.getUnk3300JHBCHFHAGFO());
                }
                if (this.dungeonStageInfoListBuilder_ == null) {
                    if (!other.dungeonStageInfoList_.isEmpty()) {
                        if (this.dungeonStageInfoList_.isEmpty()) {
                            this.dungeonStageInfoList_ = other.dungeonStageInfoList_;
                            this.bitField0_ &= -3;
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
                        this.bitField0_ &= -3;
                        this.dungeonStageInfoListBuilder_ = SummerTimeV2Info.alwaysUseFieldBuilders ? getDungeonStageInfoListFieldBuilder() : null;
                    } else {
                        this.dungeonStageInfoListBuilder_.addAllMessages(other.dungeonStageInfoList_);
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
                SummerTimeV2Info parsedMessage = null;
                try {
                    try {
                        parsedMessage = SummerTimeV2Info.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (SummerTimeV2Info) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
            public boolean getLeftMonsters() {
                return this.leftMonsters_;
            }

            public Builder setLeftMonsters(boolean value) {
                this.leftMonsters_ = value;
                onChanged();
                return this;
            }

            public Builder clearLeftMonsters() {
                this.leftMonsters_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
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

            private void ensureBoatStageInfoListIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.boatStageInfoList_ = new ArrayList(this.boatStageInfoList_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
            public List<SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfo> getBoatStageInfoListList() {
                if (this.boatStageInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.boatStageInfoList_);
                }
                return this.boatStageInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
            public int getBoatStageInfoListCount() {
                if (this.boatStageInfoListBuilder_ == null) {
                    return this.boatStageInfoList_.size();
                }
                return this.boatStageInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
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
                    this.bitField0_ &= -2;
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

            @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
            public SummerTimeV2BoatStageInfoOuterClass.SummerTimeV2BoatStageInfoOrBuilder getBoatStageInfoListOrBuilder(int index) {
                if (this.boatStageInfoListBuilder_ == null) {
                    return this.boatStageInfoList_.get(index);
                }
                return this.boatStageInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
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
                    this.boatStageInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.boatStageInfoList_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.boatStageInfoList_ = null;
                }
                return this.boatStageInfoListBuilder_;
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
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

            private void ensureDungeonStageInfoListIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.dungeonStageInfoList_ = new ArrayList(this.dungeonStageInfoList_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
            public List<SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfo> getDungeonStageInfoListList() {
                if (this.dungeonStageInfoListBuilder_ == null) {
                    return Collections.unmodifiableList(this.dungeonStageInfoList_);
                }
                return this.dungeonStageInfoListBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
            public int getDungeonStageInfoListCount() {
                if (this.dungeonStageInfoListBuilder_ == null) {
                    return this.dungeonStageInfoList_.size();
                }
                return this.dungeonStageInfoListBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
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
                    this.bitField0_ &= -3;
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

            @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
            public SummerTimeV2DungeonStageInfoOuterClass.SummerTimeV2DungeonStageInfoOrBuilder getDungeonStageInfoListOrBuilder(int index) {
                if (this.dungeonStageInfoListBuilder_ == null) {
                    return this.dungeonStageInfoList_.get(index);
                }
                return this.dungeonStageInfoListBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.SummerTimeV2InfoOuterClass.SummerTimeV2InfoOrBuilder
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
                    this.dungeonStageInfoListBuilder_ = new RepeatedFieldBuilderV3<>(this.dungeonStageInfoList_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.dungeonStageInfoList_ = null;
                }
                return this.dungeonStageInfoListBuilder_;
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

        public static SummerTimeV2Info getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SummerTimeV2Info> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<SummerTimeV2Info> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public SummerTimeV2Info getDefaultInstanceForType() {
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
