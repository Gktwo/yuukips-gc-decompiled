package emu.grasscutter.net.proto;

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
import com.google.protobuf.UnknownFieldSet;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutPhysicalObjectModifierOuterClass.class */
public final class BreakoutPhysicalObjectModifierOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n$BreakoutPhysicalObjectModifier.proto\"¹\u0002\n\u001eBreakoutPhysicalObjectModifier\u0012\f\n\u0004type\u0018\u0001 \u0001(\r\u0012\n\n\u0002id\u0018\u0002 \u0001(\r\u0012\u000e\n\u0006param1\u0018\u0003 \u0001(\u0005\u0012\u000e\n\u0006param2\u0018\u0004 \u0001(\u0005\u0012\u000e\n\u0006param3\u0018\u0005 \u0001(\u0005\u0012\u0013\n\u000bondeciihanm\u0018\u0006 \u0001(\u0005\u0012\u0013\n\u000bbcobaoidmmc\u0018\u0007 \u0001(\u0005\u0012\u0013\n\u000bbcmmggaidek\u0018\b \u0001(\u0005\u0012\u0013\n\u000bdgbbbnffmlb\u0018\t \u0001(\b\u0012\u0010\n\bduration\u0018\n \u0001(\u0005\u0012\u000f\n\u0007endTime\u0018\u000b \u0001(\u0005\u0012\r\n\u0005combo\u0018\f \u0001(\r\u0012\u000e\n\u0006peerId\u0018\r \u0001(\r\u0012\u0013\n\u000bhichllhajdp\u0018\u000e \u0001(\r\u0012\r\n\u0005level\u0018\u000f \u0001(\r\u0012\u0013\n\u000bnfheenapfmf\u0018\u0010 \u0001(\rB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_BreakoutPhysicalObjectModifier_descriptor = getDescriptor().getMessageTypes().get(0);

    /* renamed from: internal_static_BreakoutPhysicalObjectModifier_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f661xb8c0aae1 = new GeneratedMessageV3.FieldAccessorTable(internal_static_BreakoutPhysicalObjectModifier_descriptor, new String[]{"Type", "Id", "Param1", "Param2", "Param3", "Ondeciihanm", "Bcobaoidmmc", "Bcmmggaidek", "Dgbbbnffmlb", "Duration", "EndTime", "Combo", "PeerId", "Hichllhajdp", "Level", "Nfheenapfmf"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutPhysicalObjectModifierOuterClass$BreakoutPhysicalObjectModifierOrBuilder.class */
    public interface BreakoutPhysicalObjectModifierOrBuilder extends MessageOrBuilder {
        int getType();

        int getId();

        int getParam1();

        int getParam2();

        int getParam3();

        int getOndeciihanm();

        int getBcobaoidmmc();

        int getBcmmggaidek();

        boolean getDgbbbnffmlb();

        int getDuration();

        int getEndTime();

        int getCombo();

        int getPeerId();

        int getHichllhajdp();

        int getLevel();

        int getNfheenapfmf();
    }

    private BreakoutPhysicalObjectModifierOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutPhysicalObjectModifierOuterClass$BreakoutPhysicalObjectModifier.class */
    public static final class BreakoutPhysicalObjectModifier extends GeneratedMessageV3 implements BreakoutPhysicalObjectModifierOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int TYPE_FIELD_NUMBER = 1;
        private int type_;
        public static final int ID_FIELD_NUMBER = 2;
        private int id_;
        public static final int PARAM1_FIELD_NUMBER = 3;
        private int param1_;
        public static final int PARAM2_FIELD_NUMBER = 4;
        private int param2_;
        public static final int PARAM3_FIELD_NUMBER = 5;
        private int param3_;
        public static final int ONDECIIHANM_FIELD_NUMBER = 6;
        private int ondeciihanm_;
        public static final int BCOBAOIDMMC_FIELD_NUMBER = 7;
        private int bcobaoidmmc_;
        public static final int BCMMGGAIDEK_FIELD_NUMBER = 8;
        private int bcmmggaidek_;
        public static final int DGBBBNFFMLB_FIELD_NUMBER = 9;
        private boolean dgbbbnffmlb_;
        public static final int DURATION_FIELD_NUMBER = 10;
        private int duration_;
        public static final int ENDTIME_FIELD_NUMBER = 11;
        private int endTime_;
        public static final int COMBO_FIELD_NUMBER = 12;
        private int combo_;
        public static final int PEERID_FIELD_NUMBER = 13;
        private int peerId_;
        public static final int HICHLLHAJDP_FIELD_NUMBER = 14;
        private int hichllhajdp_;
        public static final int LEVEL_FIELD_NUMBER = 15;
        private int level_;
        public static final int NFHEENAPFMF_FIELD_NUMBER = 16;
        private int nfheenapfmf_;
        private byte memoizedIsInitialized;
        private static final BreakoutPhysicalObjectModifier DEFAULT_INSTANCE = new BreakoutPhysicalObjectModifier();
        private static final Parser<BreakoutPhysicalObjectModifier> PARSER = new AbstractParser<BreakoutPhysicalObjectModifier>() { // from class: emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifier.1
            @Override // com.google.protobuf.Parser
            public BreakoutPhysicalObjectModifier parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new BreakoutPhysicalObjectModifier(input, extensionRegistry);
            }
        };

        private BreakoutPhysicalObjectModifier(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private BreakoutPhysicalObjectModifier() {
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new BreakoutPhysicalObjectModifier();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private BreakoutPhysicalObjectModifier(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            this();
            UnknownFieldSet.Builder unknownFields;
            if (extensionRegistry == null) {
                throw new NullPointerException();
            }
            try {
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
                                this.type_ = input.readUInt32();
                                break;
                            case 16:
                                this.id_ = input.readUInt32();
                                break;
                            case 24:
                                this.param1_ = input.readInt32();
                                break;
                            case 32:
                                this.param2_ = input.readInt32();
                                break;
                            case 40:
                                this.param3_ = input.readInt32();
                                break;
                            case 48:
                                this.ondeciihanm_ = input.readInt32();
                                break;
                            case 56:
                                this.bcobaoidmmc_ = input.readInt32();
                                break;
                            case 64:
                                this.bcmmggaidek_ = input.readInt32();
                                break;
                            case 72:
                                this.dgbbbnffmlb_ = input.readBool();
                                break;
                            case 80:
                                this.duration_ = input.readInt32();
                                break;
                            case 88:
                                this.endTime_ = input.readInt32();
                                break;
                            case 96:
                                this.combo_ = input.readUInt32();
                                break;
                            case 104:
                                this.peerId_ = input.readUInt32();
                                break;
                            case 112:
                                this.hichllhajdp_ = input.readUInt32();
                                break;
                            case 120:
                                this.level_ = input.readUInt32();
                                break;
                            case 128:
                                this.nfheenapfmf_ = input.readUInt32();
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
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return BreakoutPhysicalObjectModifierOuterClass.internal_static_BreakoutPhysicalObjectModifier_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return BreakoutPhysicalObjectModifierOuterClass.f661xb8c0aae1.ensureFieldAccessorsInitialized(BreakoutPhysicalObjectModifier.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
        public int getType() {
            return this.type_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
        public int getId() {
            return this.id_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
        public int getParam1() {
            return this.param1_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
        public int getParam2() {
            return this.param2_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
        public int getParam3() {
            return this.param3_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
        public int getOndeciihanm() {
            return this.ondeciihanm_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
        public int getBcobaoidmmc() {
            return this.bcobaoidmmc_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
        public int getBcmmggaidek() {
            return this.bcmmggaidek_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
        public boolean getDgbbbnffmlb() {
            return this.dgbbbnffmlb_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
        public int getDuration() {
            return this.duration_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
        public int getEndTime() {
            return this.endTime_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
        public int getCombo() {
            return this.combo_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
        public int getPeerId() {
            return this.peerId_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
        public int getHichllhajdp() {
            return this.hichllhajdp_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
        public int getLevel() {
            return this.level_;
        }

        @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
        public int getNfheenapfmf() {
            return this.nfheenapfmf_;
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
            if (this.type_ != 0) {
                output.writeUInt32(1, this.type_);
            }
            if (this.id_ != 0) {
                output.writeUInt32(2, this.id_);
            }
            if (this.param1_ != 0) {
                output.writeInt32(3, this.param1_);
            }
            if (this.param2_ != 0) {
                output.writeInt32(4, this.param2_);
            }
            if (this.param3_ != 0) {
                output.writeInt32(5, this.param3_);
            }
            if (this.ondeciihanm_ != 0) {
                output.writeInt32(6, this.ondeciihanm_);
            }
            if (this.bcobaoidmmc_ != 0) {
                output.writeInt32(7, this.bcobaoidmmc_);
            }
            if (this.bcmmggaidek_ != 0) {
                output.writeInt32(8, this.bcmmggaidek_);
            }
            if (this.dgbbbnffmlb_) {
                output.writeBool(9, this.dgbbbnffmlb_);
            }
            if (this.duration_ != 0) {
                output.writeInt32(10, this.duration_);
            }
            if (this.endTime_ != 0) {
                output.writeInt32(11, this.endTime_);
            }
            if (this.combo_ != 0) {
                output.writeUInt32(12, this.combo_);
            }
            if (this.peerId_ != 0) {
                output.writeUInt32(13, this.peerId_);
            }
            if (this.hichllhajdp_ != 0) {
                output.writeUInt32(14, this.hichllhajdp_);
            }
            if (this.level_ != 0) {
                output.writeUInt32(15, this.level_);
            }
            if (this.nfheenapfmf_ != 0) {
                output.writeUInt32(16, this.nfheenapfmf_);
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
            if (this.type_ != 0) {
                size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.type_);
            }
            if (this.id_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(2, this.id_);
            }
            if (this.param1_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(3, this.param1_);
            }
            if (this.param2_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(4, this.param2_);
            }
            if (this.param3_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(5, this.param3_);
            }
            if (this.ondeciihanm_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(6, this.ondeciihanm_);
            }
            if (this.bcobaoidmmc_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(7, this.bcobaoidmmc_);
            }
            if (this.bcmmggaidek_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(8, this.bcmmggaidek_);
            }
            if (this.dgbbbnffmlb_) {
                size2 += CodedOutputStream.computeBoolSize(9, this.dgbbbnffmlb_);
            }
            if (this.duration_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(10, this.duration_);
            }
            if (this.endTime_ != 0) {
                size2 += CodedOutputStream.computeInt32Size(11, this.endTime_);
            }
            if (this.combo_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(12, this.combo_);
            }
            if (this.peerId_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(13, this.peerId_);
            }
            if (this.hichllhajdp_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(14, this.hichllhajdp_);
            }
            if (this.level_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(15, this.level_);
            }
            if (this.nfheenapfmf_ != 0) {
                size2 += CodedOutputStream.computeUInt32Size(16, this.nfheenapfmf_);
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
            if (!(obj instanceof BreakoutPhysicalObjectModifier)) {
                return equals(obj);
            }
            BreakoutPhysicalObjectModifier other = (BreakoutPhysicalObjectModifier) obj;
            return getType() == other.getType() && getId() == other.getId() && getParam1() == other.getParam1() && getParam2() == other.getParam2() && getParam3() == other.getParam3() && getOndeciihanm() == other.getOndeciihanm() && getBcobaoidmmc() == other.getBcobaoidmmc() && getBcmmggaidek() == other.getBcmmggaidek() && getDgbbbnffmlb() == other.getDgbbbnffmlb() && getDuration() == other.getDuration() && getEndTime() == other.getEndTime() && getCombo() == other.getCombo() && getPeerId() == other.getPeerId() && getHichllhajdp() == other.getHichllhajdp() && getLevel() == other.getLevel() && getNfheenapfmf() == other.getNfheenapfmf() && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (29 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getType())) + 2)) + getId())) + 3)) + getParam1())) + 4)) + getParam2())) + 5)) + getParam3())) + 6)) + getOndeciihanm())) + 7)) + getBcobaoidmmc())) + 8)) + getBcmmggaidek())) + 9)) + Internal.hashBoolean(getDgbbbnffmlb()))) + 10)) + getDuration())) + 11)) + getEndTime())) + 12)) + getCombo())) + 13)) + getPeerId())) + 14)) + getHichllhajdp())) + 15)) + getLevel())) + 16)) + getNfheenapfmf())) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash;
            return hash;
        }

        public static BreakoutPhysicalObjectModifier parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutPhysicalObjectModifier parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutPhysicalObjectModifier parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutPhysicalObjectModifier parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutPhysicalObjectModifier parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static BreakoutPhysicalObjectModifier parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static BreakoutPhysicalObjectModifier parseFrom(InputStream input) throws IOException {
            return (BreakoutPhysicalObjectModifier) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BreakoutPhysicalObjectModifier parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutPhysicalObjectModifier) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static BreakoutPhysicalObjectModifier parseDelimitedFrom(InputStream input) throws IOException {
            return (BreakoutPhysicalObjectModifier) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static BreakoutPhysicalObjectModifier parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutPhysicalObjectModifier) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static BreakoutPhysicalObjectModifier parseFrom(CodedInputStream input) throws IOException {
            return (BreakoutPhysicalObjectModifier) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static BreakoutPhysicalObjectModifier parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (BreakoutPhysicalObjectModifier) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(BreakoutPhysicalObjectModifier prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/BreakoutPhysicalObjectModifierOuterClass$BreakoutPhysicalObjectModifier$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements BreakoutPhysicalObjectModifierOrBuilder {
            private int type_;
            private int id_;
            private int param1_;
            private int param2_;
            private int param3_;
            private int ondeciihanm_;
            private int bcobaoidmmc_;
            private int bcmmggaidek_;
            private boolean dgbbbnffmlb_;
            private int duration_;
            private int endTime_;
            private int combo_;
            private int peerId_;
            private int hichllhajdp_;
            private int level_;
            private int nfheenapfmf_;

            public static final Descriptors.Descriptor getDescriptor() {
                return BreakoutPhysicalObjectModifierOuterClass.internal_static_BreakoutPhysicalObjectModifier_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return BreakoutPhysicalObjectModifierOuterClass.f661xb8c0aae1.ensureFieldAccessorsInitialized(BreakoutPhysicalObjectModifier.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (BreakoutPhysicalObjectModifier.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.type_ = 0;
                this.id_ = 0;
                this.param1_ = 0;
                this.param2_ = 0;
                this.param3_ = 0;
                this.ondeciihanm_ = 0;
                this.bcobaoidmmc_ = 0;
                this.bcmmggaidek_ = 0;
                this.dgbbbnffmlb_ = false;
                this.duration_ = 0;
                this.endTime_ = 0;
                this.combo_ = 0;
                this.peerId_ = 0;
                this.hichllhajdp_ = 0;
                this.level_ = 0;
                this.nfheenapfmf_ = 0;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return BreakoutPhysicalObjectModifierOuterClass.internal_static_BreakoutPhysicalObjectModifier_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public BreakoutPhysicalObjectModifier getDefaultInstanceForType() {
                return BreakoutPhysicalObjectModifier.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BreakoutPhysicalObjectModifier build() {
                BreakoutPhysicalObjectModifier result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public BreakoutPhysicalObjectModifier buildPartial() {
                BreakoutPhysicalObjectModifier result = new BreakoutPhysicalObjectModifier(this);
                result.type_ = this.type_;
                result.id_ = this.id_;
                result.param1_ = this.param1_;
                result.param2_ = this.param2_;
                result.param3_ = this.param3_;
                result.ondeciihanm_ = this.ondeciihanm_;
                result.bcobaoidmmc_ = this.bcobaoidmmc_;
                result.bcmmggaidek_ = this.bcmmggaidek_;
                result.dgbbbnffmlb_ = this.dgbbbnffmlb_;
                result.duration_ = this.duration_;
                result.endTime_ = this.endTime_;
                result.combo_ = this.combo_;
                result.peerId_ = this.peerId_;
                result.hichllhajdp_ = this.hichllhajdp_;
                result.level_ = this.level_;
                result.nfheenapfmf_ = this.nfheenapfmf_;
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
                if (other instanceof BreakoutPhysicalObjectModifier) {
                    return mergeFrom((BreakoutPhysicalObjectModifier) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(BreakoutPhysicalObjectModifier other) {
                if (other == BreakoutPhysicalObjectModifier.getDefaultInstance()) {
                    return this;
                }
                if (other.getType() != 0) {
                    setType(other.getType());
                }
                if (other.getId() != 0) {
                    setId(other.getId());
                }
                if (other.getParam1() != 0) {
                    setParam1(other.getParam1());
                }
                if (other.getParam2() != 0) {
                    setParam2(other.getParam2());
                }
                if (other.getParam3() != 0) {
                    setParam3(other.getParam3());
                }
                if (other.getOndeciihanm() != 0) {
                    setOndeciihanm(other.getOndeciihanm());
                }
                if (other.getBcobaoidmmc() != 0) {
                    setBcobaoidmmc(other.getBcobaoidmmc());
                }
                if (other.getBcmmggaidek() != 0) {
                    setBcmmggaidek(other.getBcmmggaidek());
                }
                if (other.getDgbbbnffmlb()) {
                    setDgbbbnffmlb(other.getDgbbbnffmlb());
                }
                if (other.getDuration() != 0) {
                    setDuration(other.getDuration());
                }
                if (other.getEndTime() != 0) {
                    setEndTime(other.getEndTime());
                }
                if (other.getCombo() != 0) {
                    setCombo(other.getCombo());
                }
                if (other.getPeerId() != 0) {
                    setPeerId(other.getPeerId());
                }
                if (other.getHichllhajdp() != 0) {
                    setHichllhajdp(other.getHichllhajdp());
                }
                if (other.getLevel() != 0) {
                    setLevel(other.getLevel());
                }
                if (other.getNfheenapfmf() != 0) {
                    setNfheenapfmf(other.getNfheenapfmf());
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
                BreakoutPhysicalObjectModifier parsedMessage = null;
                try {
                    try {
                        parsedMessage = BreakoutPhysicalObjectModifier.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (BreakoutPhysicalObjectModifier) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
            public int getType() {
                return this.type_;
            }

            public Builder setType(int value) {
                this.type_ = value;
                onChanged();
                return this;
            }

            public Builder clearType() {
                this.type_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
            public int getId() {
                return this.id_;
            }

            public Builder setId(int value) {
                this.id_ = value;
                onChanged();
                return this;
            }

            public Builder clearId() {
                this.id_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
            public int getParam1() {
                return this.param1_;
            }

            public Builder setParam1(int value) {
                this.param1_ = value;
                onChanged();
                return this;
            }

            public Builder clearParam1() {
                this.param1_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
            public int getParam2() {
                return this.param2_;
            }

            public Builder setParam2(int value) {
                this.param2_ = value;
                onChanged();
                return this;
            }

            public Builder clearParam2() {
                this.param2_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
            public int getParam3() {
                return this.param3_;
            }

            public Builder setParam3(int value) {
                this.param3_ = value;
                onChanged();
                return this;
            }

            public Builder clearParam3() {
                this.param3_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
            public int getOndeciihanm() {
                return this.ondeciihanm_;
            }

            public Builder setOndeciihanm(int value) {
                this.ondeciihanm_ = value;
                onChanged();
                return this;
            }

            public Builder clearOndeciihanm() {
                this.ondeciihanm_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
            public int getBcobaoidmmc() {
                return this.bcobaoidmmc_;
            }

            public Builder setBcobaoidmmc(int value) {
                this.bcobaoidmmc_ = value;
                onChanged();
                return this;
            }

            public Builder clearBcobaoidmmc() {
                this.bcobaoidmmc_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
            public int getBcmmggaidek() {
                return this.bcmmggaidek_;
            }

            public Builder setBcmmggaidek(int value) {
                this.bcmmggaidek_ = value;
                onChanged();
                return this;
            }

            public Builder clearBcmmggaidek() {
                this.bcmmggaidek_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
            public boolean getDgbbbnffmlb() {
                return this.dgbbbnffmlb_;
            }

            public Builder setDgbbbnffmlb(boolean value) {
                this.dgbbbnffmlb_ = value;
                onChanged();
                return this;
            }

            public Builder clearDgbbbnffmlb() {
                this.dgbbbnffmlb_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
            public int getDuration() {
                return this.duration_;
            }

            public Builder setDuration(int value) {
                this.duration_ = value;
                onChanged();
                return this;
            }

            public Builder clearDuration() {
                this.duration_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
            public int getEndTime() {
                return this.endTime_;
            }

            public Builder setEndTime(int value) {
                this.endTime_ = value;
                onChanged();
                return this;
            }

            public Builder clearEndTime() {
                this.endTime_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
            public int getCombo() {
                return this.combo_;
            }

            public Builder setCombo(int value) {
                this.combo_ = value;
                onChanged();
                return this;
            }

            public Builder clearCombo() {
                this.combo_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
            public int getPeerId() {
                return this.peerId_;
            }

            public Builder setPeerId(int value) {
                this.peerId_ = value;
                onChanged();
                return this;
            }

            public Builder clearPeerId() {
                this.peerId_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
            public int getHichllhajdp() {
                return this.hichllhajdp_;
            }

            public Builder setHichllhajdp(int value) {
                this.hichllhajdp_ = value;
                onChanged();
                return this;
            }

            public Builder clearHichllhajdp() {
                this.hichllhajdp_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
            public int getLevel() {
                return this.level_;
            }

            public Builder setLevel(int value) {
                this.level_ = value;
                onChanged();
                return this;
            }

            public Builder clearLevel() {
                this.level_ = 0;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.BreakoutPhysicalObjectModifierOuterClass.BreakoutPhysicalObjectModifierOrBuilder
            public int getNfheenapfmf() {
                return this.nfheenapfmf_;
            }

            public Builder setNfheenapfmf(int value) {
                this.nfheenapfmf_ = value;
                onChanged();
                return this;
            }

            public Builder clearNfheenapfmf() {
                this.nfheenapfmf_ = 0;
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

        public static BreakoutPhysicalObjectModifier getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<BreakoutPhysicalObjectModifier> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<BreakoutPhysicalObjectModifier> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public BreakoutPhysicalObjectModifier getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
