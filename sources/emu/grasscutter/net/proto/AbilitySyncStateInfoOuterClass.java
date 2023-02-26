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
import emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass;
import emu.grasscutter.net.proto.AbilityAppliedModifierOuterClass;
import emu.grasscutter.net.proto.AbilityMixinRecoverInfoOuterClass;
import emu.grasscutter.net.proto.AbilityScalarValueEntryOuterClass;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilitySyncStateInfoOuterClass.class */
public final class AbilitySyncStateInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aAbilitySyncStateInfo.proto\u001a\u001dAbilityScalarValueEntry.proto\u001a\u001bAbilityAppliedAbility.proto\u001a\u001cAbilityAppliedModifier.proto\u001a\u001dAbilityMixinRecoverInfo.proto\"«\u0002\n\u0014AbilitySyncStateInfo\u0012\u0010\n\bisInited\u0018\u0001 \u0001(\b\u00121\n\u000fdynamicValueMap\u0018\u0002 \u0003(\u000b2\u0018.AbilityScalarValueEntry\u00120\n\u0010appliedAbilities\u0018\u0003 \u0003(\u000b2\u0016.AbilityAppliedAbility\u00121\n\u0010appliedModifiers\u0018\u0004 \u0003(\u000b2\u0017.AbilityAppliedModifier\u00123\n\u0011mixinRecoverInfos\u0018\u0005 \u0003(\u000b2\u0018.AbilityMixinRecoverInfo\u00124\n\u0012sgvDynamicValueMap\u0018\u0006 \u0003(\u000b2\u0018.AbilityScalarValueEntryB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[]{AbilityScalarValueEntryOuterClass.getDescriptor(), AbilityAppliedAbilityOuterClass.getDescriptor(), AbilityAppliedModifierOuterClass.getDescriptor(), AbilityMixinRecoverInfoOuterClass.getDescriptor()});
    private static final Descriptors.Descriptor internal_static_AbilitySyncStateInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_AbilitySyncStateInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_AbilitySyncStateInfo_descriptor, new String[]{"IsInited", "DynamicValueMap", "AppliedAbilities", "AppliedModifiers", "MixinRecoverInfos", "SgvDynamicValueMap"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilitySyncStateInfoOuterClass$AbilitySyncStateInfoOrBuilder.class */
    public interface AbilitySyncStateInfoOrBuilder extends MessageOrBuilder {
        boolean getIsInited();

        List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> getDynamicValueMapList();

        AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry getDynamicValueMap(int i);

        int getDynamicValueMapCount();

        List<? extends AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> getDynamicValueMapOrBuilderList();

        AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder getDynamicValueMapOrBuilder(int i);

        List<AbilityAppliedAbilityOuterClass.AbilityAppliedAbility> getAppliedAbilitiesList();

        AbilityAppliedAbilityOuterClass.AbilityAppliedAbility getAppliedAbilities(int i);

        int getAppliedAbilitiesCount();

        List<? extends AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder> getAppliedAbilitiesOrBuilderList();

        AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder getAppliedAbilitiesOrBuilder(int i);

        List<AbilityAppliedModifierOuterClass.AbilityAppliedModifier> getAppliedModifiersList();

        AbilityAppliedModifierOuterClass.AbilityAppliedModifier getAppliedModifiers(int i);

        int getAppliedModifiersCount();

        List<? extends AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder> getAppliedModifiersOrBuilderList();

        AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder getAppliedModifiersOrBuilder(int i);

        List<AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo> getMixinRecoverInfosList();

        AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo getMixinRecoverInfos(int i);

        int getMixinRecoverInfosCount();

        List<? extends AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder> getMixinRecoverInfosOrBuilderList();

        AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder getMixinRecoverInfosOrBuilder(int i);

        List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> getSgvDynamicValueMapList();

        AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry getSgvDynamicValueMap(int i);

        int getSgvDynamicValueMapCount();

        List<? extends AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> getSgvDynamicValueMapOrBuilderList();

        AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder getSgvDynamicValueMapOrBuilder(int i);
    }

    private AbilitySyncStateInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilitySyncStateInfoOuterClass$AbilitySyncStateInfo.class */
    public static final class AbilitySyncStateInfo extends GeneratedMessageV3 implements AbilitySyncStateInfoOrBuilder {
        private static final long serialVersionUID = 0;
        public static final int ISINITED_FIELD_NUMBER = 1;
        private boolean isInited_;
        public static final int DYNAMICVALUEMAP_FIELD_NUMBER = 2;
        private List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> dynamicValueMap_;
        public static final int APPLIEDABILITIES_FIELD_NUMBER = 3;
        private List<AbilityAppliedAbilityOuterClass.AbilityAppliedAbility> appliedAbilities_;
        public static final int APPLIEDMODIFIERS_FIELD_NUMBER = 4;
        private List<AbilityAppliedModifierOuterClass.AbilityAppliedModifier> appliedModifiers_;
        public static final int MIXINRECOVERINFOS_FIELD_NUMBER = 5;
        private List<AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo> mixinRecoverInfos_;
        public static final int SGVDYNAMICVALUEMAP_FIELD_NUMBER = 6;
        private List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> sgvDynamicValueMap_;
        private byte memoizedIsInitialized;
        private static final AbilitySyncStateInfo DEFAULT_INSTANCE = new AbilitySyncStateInfo();
        private static final Parser<AbilitySyncStateInfo> PARSER = new AbstractParser<AbilitySyncStateInfo>() { // from class: emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo.1
            @Override // com.google.protobuf.Parser
            public AbilitySyncStateInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new AbilitySyncStateInfo(input, extensionRegistry);
            }
        };

        private AbilitySyncStateInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.memoizedIsInitialized = -1;
        }

        private AbilitySyncStateInfo() {
            this.memoizedIsInitialized = -1;
            this.dynamicValueMap_ = Collections.emptyList();
            this.appliedAbilities_ = Collections.emptyList();
            this.appliedModifiers_ = Collections.emptyList();
            this.mixinRecoverInfos_ = Collections.emptyList();
            this.sgvDynamicValueMap_ = Collections.emptyList();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new AbilitySyncStateInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:93:0x016e */
        private AbilitySyncStateInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                case 8:
                                    this.isInited_ = input.readBool();
                                    break;
                                case 18:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.dynamicValueMap_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 1) == 1 ? 1 : 0;
                                    }
                                    this.dynamicValueMap_.add((AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry) input.readMessage(AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.parser(), extensionRegistry));
                                    break;
                                case 26:
                                    if ((mutable_bitField0_ & 2) == 0) {
                                        this.appliedAbilities_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 2) == 1 ? 1 : 0;
                                    }
                                    this.appliedAbilities_.add((AbilityAppliedAbilityOuterClass.AbilityAppliedAbility) input.readMessage(AbilityAppliedAbilityOuterClass.AbilityAppliedAbility.parser(), extensionRegistry));
                                    break;
                                case 34:
                                    if ((mutable_bitField0_ & 4) == 0) {
                                        this.appliedModifiers_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 4) == 1 ? 1 : 0;
                                    }
                                    this.appliedModifiers_.add((AbilityAppliedModifierOuterClass.AbilityAppliedModifier) input.readMessage(AbilityAppliedModifierOuterClass.AbilityAppliedModifier.parser(), extensionRegistry));
                                    break;
                                case 42:
                                    if ((mutable_bitField0_ & 8) == 0) {
                                        this.mixinRecoverInfos_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 8) == 1 ? 1 : 0;
                                    }
                                    this.mixinRecoverInfos_.add((AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo) input.readMessage(AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo.parser(), extensionRegistry));
                                    break;
                                case 50:
                                    if ((mutable_bitField0_ & 16) == 0) {
                                        this.sgvDynamicValueMap_ = new ArrayList();
                                        mutable_bitField0_ = (mutable_bitField0_ | 16) == 1 ? 1 : 0;
                                    }
                                    this.sgvDynamicValueMap_.add((AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry) input.readMessage(AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.parser(), extensionRegistry));
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
                        }
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2).setUnfinishedMessage(this);
                    }
                }
            } finally {
                if ((mutable_bitField0_ & 1) != 0) {
                    this.dynamicValueMap_ = Collections.unmodifiableList(this.dynamicValueMap_);
                }
                if ((mutable_bitField0_ & 2) != 0) {
                    this.appliedAbilities_ = Collections.unmodifiableList(this.appliedAbilities_);
                }
                if ((mutable_bitField0_ & 4) != 0) {
                    this.appliedModifiers_ = Collections.unmodifiableList(this.appliedModifiers_);
                }
                if ((mutable_bitField0_ & 8) != 0) {
                    this.mixinRecoverInfos_ = Collections.unmodifiableList(this.mixinRecoverInfos_);
                }
                if ((mutable_bitField0_ & 16) != 0) {
                    this.sgvDynamicValueMap_ = Collections.unmodifiableList(this.sgvDynamicValueMap_);
                }
                this.unknownFields = unknownFields.build();
                makeExtensionsImmutable();
            }
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return AbilitySyncStateInfoOuterClass.internal_static_AbilitySyncStateInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return AbilitySyncStateInfoOuterClass.internal_static_AbilitySyncStateInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilitySyncStateInfo.class, Builder.class);
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public boolean getIsInited() {
            return this.isInited_;
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> getDynamicValueMapList() {
            return this.dynamicValueMap_;
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public List<? extends AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> getDynamicValueMapOrBuilderList() {
            return this.dynamicValueMap_;
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public int getDynamicValueMapCount() {
            return this.dynamicValueMap_.size();
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry getDynamicValueMap(int index) {
            return this.dynamicValueMap_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder getDynamicValueMapOrBuilder(int index) {
            return this.dynamicValueMap_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public List<AbilityAppliedAbilityOuterClass.AbilityAppliedAbility> getAppliedAbilitiesList() {
            return this.appliedAbilities_;
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public List<? extends AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder> getAppliedAbilitiesOrBuilderList() {
            return this.appliedAbilities_;
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public int getAppliedAbilitiesCount() {
            return this.appliedAbilities_.size();
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public AbilityAppliedAbilityOuterClass.AbilityAppliedAbility getAppliedAbilities(int index) {
            return this.appliedAbilities_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder getAppliedAbilitiesOrBuilder(int index) {
            return this.appliedAbilities_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public List<AbilityAppliedModifierOuterClass.AbilityAppliedModifier> getAppliedModifiersList() {
            return this.appliedModifiers_;
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public List<? extends AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder> getAppliedModifiersOrBuilderList() {
            return this.appliedModifiers_;
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public int getAppliedModifiersCount() {
            return this.appliedModifiers_.size();
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public AbilityAppliedModifierOuterClass.AbilityAppliedModifier getAppliedModifiers(int index) {
            return this.appliedModifiers_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder getAppliedModifiersOrBuilder(int index) {
            return this.appliedModifiers_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public List<AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo> getMixinRecoverInfosList() {
            return this.mixinRecoverInfos_;
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public List<? extends AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder> getMixinRecoverInfosOrBuilderList() {
            return this.mixinRecoverInfos_;
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public int getMixinRecoverInfosCount() {
            return this.mixinRecoverInfos_.size();
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo getMixinRecoverInfos(int index) {
            return this.mixinRecoverInfos_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder getMixinRecoverInfosOrBuilder(int index) {
            return this.mixinRecoverInfos_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> getSgvDynamicValueMapList() {
            return this.sgvDynamicValueMap_;
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public List<? extends AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> getSgvDynamicValueMapOrBuilderList() {
            return this.sgvDynamicValueMap_;
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public int getSgvDynamicValueMapCount() {
            return this.sgvDynamicValueMap_.size();
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry getSgvDynamicValueMap(int index) {
            return this.sgvDynamicValueMap_.get(index);
        }

        @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
        public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder getSgvDynamicValueMapOrBuilder(int index) {
            return this.sgvDynamicValueMap_.get(index);
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
            if (this.isInited_) {
                output.writeBool(1, this.isInited_);
            }
            for (int i = 0; i < this.dynamicValueMap_.size(); i++) {
                output.writeMessage(2, this.dynamicValueMap_.get(i));
            }
            for (int i2 = 0; i2 < this.appliedAbilities_.size(); i2++) {
                output.writeMessage(3, this.appliedAbilities_.get(i2));
            }
            for (int i3 = 0; i3 < this.appliedModifiers_.size(); i3++) {
                output.writeMessage(4, this.appliedModifiers_.get(i3));
            }
            for (int i4 = 0; i4 < this.mixinRecoverInfos_.size(); i4++) {
                output.writeMessage(5, this.mixinRecoverInfos_.get(i4));
            }
            for (int i5 = 0; i5 < this.sgvDynamicValueMap_.size(); i5++) {
                output.writeMessage(6, this.sgvDynamicValueMap_.get(i5));
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
            if (this.isInited_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.isInited_);
            }
            for (int i = 0; i < this.dynamicValueMap_.size(); i++) {
                size2 += CodedOutputStream.computeMessageSize(2, this.dynamicValueMap_.get(i));
            }
            for (int i2 = 0; i2 < this.appliedAbilities_.size(); i2++) {
                size2 += CodedOutputStream.computeMessageSize(3, this.appliedAbilities_.get(i2));
            }
            for (int i3 = 0; i3 < this.appliedModifiers_.size(); i3++) {
                size2 += CodedOutputStream.computeMessageSize(4, this.appliedModifiers_.get(i3));
            }
            for (int i4 = 0; i4 < this.mixinRecoverInfos_.size(); i4++) {
                size2 += CodedOutputStream.computeMessageSize(5, this.mixinRecoverInfos_.get(i4));
            }
            for (int i5 = 0; i5 < this.sgvDynamicValueMap_.size(); i5++) {
                size2 += CodedOutputStream.computeMessageSize(6, this.sgvDynamicValueMap_.get(i5));
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
            if (!(obj instanceof AbilitySyncStateInfo)) {
                return equals(obj);
            }
            AbilitySyncStateInfo other = (AbilitySyncStateInfo) obj;
            return getIsInited() == other.getIsInited() && getDynamicValueMapList().equals(other.getDynamicValueMapList()) && getAppliedAbilitiesList().equals(other.getAppliedAbilitiesList()) && getAppliedModifiersList().equals(other.getAppliedModifiersList()) && getMixinRecoverInfosList().equals(other.getMixinRecoverInfosList()) && getSgvDynamicValueMapList().equals(other.getSgvDynamicValueMapList()) && this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Internal.hashBoolean(getIsInited());
            if (getDynamicValueMapCount() > 0) {
                hash = (53 * ((37 * hash) + 2)) + getDynamicValueMapList().hashCode();
            }
            if (getAppliedAbilitiesCount() > 0) {
                hash = (53 * ((37 * hash) + 3)) + getAppliedAbilitiesList().hashCode();
            }
            if (getAppliedModifiersCount() > 0) {
                hash = (53 * ((37 * hash) + 4)) + getAppliedModifiersList().hashCode();
            }
            if (getMixinRecoverInfosCount() > 0) {
                hash = (53 * ((37 * hash) + 5)) + getMixinRecoverInfosList().hashCode();
            }
            if (getSgvDynamicValueMapCount() > 0) {
                hash = (53 * ((37 * hash) + 6)) + getSgvDynamicValueMapList().hashCode();
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static AbilitySyncStateInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilitySyncStateInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilitySyncStateInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilitySyncStateInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilitySyncStateInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static AbilitySyncStateInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static AbilitySyncStateInfo parseFrom(InputStream input) throws IOException {
            return (AbilitySyncStateInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilitySyncStateInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilitySyncStateInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilitySyncStateInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (AbilitySyncStateInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static AbilitySyncStateInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilitySyncStateInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static AbilitySyncStateInfo parseFrom(CodedInputStream input) throws IOException {
            return (AbilitySyncStateInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static AbilitySyncStateInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AbilitySyncStateInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(AbilitySyncStateInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/AbilitySyncStateInfoOuterClass$AbilitySyncStateInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements AbilitySyncStateInfoOrBuilder {
            private int bitField0_;
            private boolean isInited_;
            private RepeatedFieldBuilderV3<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> dynamicValueMapBuilder_;
            private RepeatedFieldBuilderV3<AbilityAppliedAbilityOuterClass.AbilityAppliedAbility, AbilityAppliedAbilityOuterClass.AbilityAppliedAbility.Builder, AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder> appliedAbilitiesBuilder_;
            private RepeatedFieldBuilderV3<AbilityAppliedModifierOuterClass.AbilityAppliedModifier, AbilityAppliedModifierOuterClass.AbilityAppliedModifier.Builder, AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder> appliedModifiersBuilder_;
            private RepeatedFieldBuilderV3<AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo, AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo.Builder, AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder> mixinRecoverInfosBuilder_;
            private RepeatedFieldBuilderV3<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> sgvDynamicValueMapBuilder_;
            private List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> dynamicValueMap_ = Collections.emptyList();
            private List<AbilityAppliedAbilityOuterClass.AbilityAppliedAbility> appliedAbilities_ = Collections.emptyList();
            private List<AbilityAppliedModifierOuterClass.AbilityAppliedModifier> appliedModifiers_ = Collections.emptyList();
            private List<AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo> mixinRecoverInfos_ = Collections.emptyList();
            private List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> sgvDynamicValueMap_ = Collections.emptyList();

            public static final Descriptors.Descriptor getDescriptor() {
                return AbilitySyncStateInfoOuterClass.internal_static_AbilitySyncStateInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return AbilitySyncStateInfoOuterClass.internal_static_AbilitySyncStateInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(AbilitySyncStateInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (AbilitySyncStateInfo.alwaysUseFieldBuilders) {
                    getDynamicValueMapFieldBuilder();
                    getAppliedAbilitiesFieldBuilder();
                    getAppliedModifiersFieldBuilder();
                    getMixinRecoverInfosFieldBuilder();
                    getSgvDynamicValueMapFieldBuilder();
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.isInited_ = false;
                if (this.dynamicValueMapBuilder_ == null) {
                    this.dynamicValueMap_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                } else {
                    this.dynamicValueMapBuilder_.clear();
                }
                if (this.appliedAbilitiesBuilder_ == null) {
                    this.appliedAbilities_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                } else {
                    this.appliedAbilitiesBuilder_.clear();
                }
                if (this.appliedModifiersBuilder_ == null) {
                    this.appliedModifiers_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                } else {
                    this.appliedModifiersBuilder_.clear();
                }
                if (this.mixinRecoverInfosBuilder_ == null) {
                    this.mixinRecoverInfos_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                } else {
                    this.mixinRecoverInfosBuilder_.clear();
                }
                if (this.sgvDynamicValueMapBuilder_ == null) {
                    this.sgvDynamicValueMap_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                } else {
                    this.sgvDynamicValueMapBuilder_.clear();
                }
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return AbilitySyncStateInfoOuterClass.internal_static_AbilitySyncStateInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public AbilitySyncStateInfo getDefaultInstanceForType() {
                return AbilitySyncStateInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilitySyncStateInfo build() {
                AbilitySyncStateInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public AbilitySyncStateInfo buildPartial() {
                AbilitySyncStateInfo result = new AbilitySyncStateInfo(this);
                int i = this.bitField0_;
                result.isInited_ = this.isInited_;
                if (this.dynamicValueMapBuilder_ == null) {
                    if ((this.bitField0_ & 1) != 0) {
                        this.dynamicValueMap_ = Collections.unmodifiableList(this.dynamicValueMap_);
                        this.bitField0_ &= -2;
                    }
                    result.dynamicValueMap_ = this.dynamicValueMap_;
                } else {
                    result.dynamicValueMap_ = this.dynamicValueMapBuilder_.build();
                }
                if (this.appliedAbilitiesBuilder_ == null) {
                    if ((this.bitField0_ & 2) != 0) {
                        this.appliedAbilities_ = Collections.unmodifiableList(this.appliedAbilities_);
                        this.bitField0_ &= -3;
                    }
                    result.appliedAbilities_ = this.appliedAbilities_;
                } else {
                    result.appliedAbilities_ = this.appliedAbilitiesBuilder_.build();
                }
                if (this.appliedModifiersBuilder_ == null) {
                    if ((this.bitField0_ & 4) != 0) {
                        this.appliedModifiers_ = Collections.unmodifiableList(this.appliedModifiers_);
                        this.bitField0_ &= -5;
                    }
                    result.appliedModifiers_ = this.appliedModifiers_;
                } else {
                    result.appliedModifiers_ = this.appliedModifiersBuilder_.build();
                }
                if (this.mixinRecoverInfosBuilder_ == null) {
                    if ((this.bitField0_ & 8) != 0) {
                        this.mixinRecoverInfos_ = Collections.unmodifiableList(this.mixinRecoverInfos_);
                        this.bitField0_ &= -9;
                    }
                    result.mixinRecoverInfos_ = this.mixinRecoverInfos_;
                } else {
                    result.mixinRecoverInfos_ = this.mixinRecoverInfosBuilder_.build();
                }
                if (this.sgvDynamicValueMapBuilder_ == null) {
                    if ((this.bitField0_ & 16) != 0) {
                        this.sgvDynamicValueMap_ = Collections.unmodifiableList(this.sgvDynamicValueMap_);
                        this.bitField0_ &= -17;
                    }
                    result.sgvDynamicValueMap_ = this.sgvDynamicValueMap_;
                } else {
                    result.sgvDynamicValueMap_ = this.sgvDynamicValueMapBuilder_.build();
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
                if (other instanceof AbilitySyncStateInfo) {
                    return mergeFrom((AbilitySyncStateInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(AbilitySyncStateInfo other) {
                if (other == AbilitySyncStateInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getIsInited()) {
                    setIsInited(other.getIsInited());
                }
                if (this.dynamicValueMapBuilder_ == null) {
                    if (!other.dynamicValueMap_.isEmpty()) {
                        if (this.dynamicValueMap_.isEmpty()) {
                            this.dynamicValueMap_ = other.dynamicValueMap_;
                            this.bitField0_ &= -2;
                        } else {
                            ensureDynamicValueMapIsMutable();
                            this.dynamicValueMap_.addAll(other.dynamicValueMap_);
                        }
                        onChanged();
                    }
                } else if (!other.dynamicValueMap_.isEmpty()) {
                    if (this.dynamicValueMapBuilder_.isEmpty()) {
                        this.dynamicValueMapBuilder_.dispose();
                        this.dynamicValueMapBuilder_ = null;
                        this.dynamicValueMap_ = other.dynamicValueMap_;
                        this.bitField0_ &= -2;
                        this.dynamicValueMapBuilder_ = AbilitySyncStateInfo.alwaysUseFieldBuilders ? getDynamicValueMapFieldBuilder() : null;
                    } else {
                        this.dynamicValueMapBuilder_.addAllMessages(other.dynamicValueMap_);
                    }
                }
                if (this.appliedAbilitiesBuilder_ == null) {
                    if (!other.appliedAbilities_.isEmpty()) {
                        if (this.appliedAbilities_.isEmpty()) {
                            this.appliedAbilities_ = other.appliedAbilities_;
                            this.bitField0_ &= -3;
                        } else {
                            ensureAppliedAbilitiesIsMutable();
                            this.appliedAbilities_.addAll(other.appliedAbilities_);
                        }
                        onChanged();
                    }
                } else if (!other.appliedAbilities_.isEmpty()) {
                    if (this.appliedAbilitiesBuilder_.isEmpty()) {
                        this.appliedAbilitiesBuilder_.dispose();
                        this.appliedAbilitiesBuilder_ = null;
                        this.appliedAbilities_ = other.appliedAbilities_;
                        this.bitField0_ &= -3;
                        this.appliedAbilitiesBuilder_ = AbilitySyncStateInfo.alwaysUseFieldBuilders ? getAppliedAbilitiesFieldBuilder() : null;
                    } else {
                        this.appliedAbilitiesBuilder_.addAllMessages(other.appliedAbilities_);
                    }
                }
                if (this.appliedModifiersBuilder_ == null) {
                    if (!other.appliedModifiers_.isEmpty()) {
                        if (this.appliedModifiers_.isEmpty()) {
                            this.appliedModifiers_ = other.appliedModifiers_;
                            this.bitField0_ &= -5;
                        } else {
                            ensureAppliedModifiersIsMutable();
                            this.appliedModifiers_.addAll(other.appliedModifiers_);
                        }
                        onChanged();
                    }
                } else if (!other.appliedModifiers_.isEmpty()) {
                    if (this.appliedModifiersBuilder_.isEmpty()) {
                        this.appliedModifiersBuilder_.dispose();
                        this.appliedModifiersBuilder_ = null;
                        this.appliedModifiers_ = other.appliedModifiers_;
                        this.bitField0_ &= -5;
                        this.appliedModifiersBuilder_ = AbilitySyncStateInfo.alwaysUseFieldBuilders ? getAppliedModifiersFieldBuilder() : null;
                    } else {
                        this.appliedModifiersBuilder_.addAllMessages(other.appliedModifiers_);
                    }
                }
                if (this.mixinRecoverInfosBuilder_ == null) {
                    if (!other.mixinRecoverInfos_.isEmpty()) {
                        if (this.mixinRecoverInfos_.isEmpty()) {
                            this.mixinRecoverInfos_ = other.mixinRecoverInfos_;
                            this.bitField0_ &= -9;
                        } else {
                            ensureMixinRecoverInfosIsMutable();
                            this.mixinRecoverInfos_.addAll(other.mixinRecoverInfos_);
                        }
                        onChanged();
                    }
                } else if (!other.mixinRecoverInfos_.isEmpty()) {
                    if (this.mixinRecoverInfosBuilder_.isEmpty()) {
                        this.mixinRecoverInfosBuilder_.dispose();
                        this.mixinRecoverInfosBuilder_ = null;
                        this.mixinRecoverInfos_ = other.mixinRecoverInfos_;
                        this.bitField0_ &= -9;
                        this.mixinRecoverInfosBuilder_ = AbilitySyncStateInfo.alwaysUseFieldBuilders ? getMixinRecoverInfosFieldBuilder() : null;
                    } else {
                        this.mixinRecoverInfosBuilder_.addAllMessages(other.mixinRecoverInfos_);
                    }
                }
                if (this.sgvDynamicValueMapBuilder_ == null) {
                    if (!other.sgvDynamicValueMap_.isEmpty()) {
                        if (this.sgvDynamicValueMap_.isEmpty()) {
                            this.sgvDynamicValueMap_ = other.sgvDynamicValueMap_;
                            this.bitField0_ &= -17;
                        } else {
                            ensureSgvDynamicValueMapIsMutable();
                            this.sgvDynamicValueMap_.addAll(other.sgvDynamicValueMap_);
                        }
                        onChanged();
                    }
                } else if (!other.sgvDynamicValueMap_.isEmpty()) {
                    if (this.sgvDynamicValueMapBuilder_.isEmpty()) {
                        this.sgvDynamicValueMapBuilder_.dispose();
                        this.sgvDynamicValueMapBuilder_ = null;
                        this.sgvDynamicValueMap_ = other.sgvDynamicValueMap_;
                        this.bitField0_ &= -17;
                        this.sgvDynamicValueMapBuilder_ = AbilitySyncStateInfo.alwaysUseFieldBuilders ? getSgvDynamicValueMapFieldBuilder() : null;
                    } else {
                        this.sgvDynamicValueMapBuilder_.addAllMessages(other.sgvDynamicValueMap_);
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
                AbilitySyncStateInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = AbilitySyncStateInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (AbilitySyncStateInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public boolean getIsInited() {
                return this.isInited_;
            }

            public Builder setIsInited(boolean value) {
                this.isInited_ = value;
                onChanged();
                return this;
            }

            public Builder clearIsInited() {
                this.isInited_ = false;
                onChanged();
                return this;
            }

            private void ensureDynamicValueMapIsMutable() {
                if ((this.bitField0_ & 1) == 0) {
                    this.dynamicValueMap_ = new ArrayList(this.dynamicValueMap_);
                    this.bitField0_ |= 1;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> getDynamicValueMapList() {
                if (this.dynamicValueMapBuilder_ == null) {
                    return Collections.unmodifiableList(this.dynamicValueMap_);
                }
                return this.dynamicValueMapBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public int getDynamicValueMapCount() {
                if (this.dynamicValueMapBuilder_ == null) {
                    return this.dynamicValueMap_.size();
                }
                return this.dynamicValueMapBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry getDynamicValueMap(int index) {
                if (this.dynamicValueMapBuilder_ == null) {
                    return this.dynamicValueMap_.get(index);
                }
                return this.dynamicValueMapBuilder_.getMessage(index);
            }

            public Builder setDynamicValueMap(int index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry value) {
                if (this.dynamicValueMapBuilder_ != null) {
                    this.dynamicValueMapBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDynamicValueMapIsMutable();
                    this.dynamicValueMap_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setDynamicValueMap(int index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder builderForValue) {
                if (this.dynamicValueMapBuilder_ == null) {
                    ensureDynamicValueMapIsMutable();
                    this.dynamicValueMap_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dynamicValueMapBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addDynamicValueMap(AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry value) {
                if (this.dynamicValueMapBuilder_ != null) {
                    this.dynamicValueMapBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDynamicValueMapIsMutable();
                    this.dynamicValueMap_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addDynamicValueMap(int index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry value) {
                if (this.dynamicValueMapBuilder_ != null) {
                    this.dynamicValueMapBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureDynamicValueMapIsMutable();
                    this.dynamicValueMap_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addDynamicValueMap(AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder builderForValue) {
                if (this.dynamicValueMapBuilder_ == null) {
                    ensureDynamicValueMapIsMutable();
                    this.dynamicValueMap_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.dynamicValueMapBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addDynamicValueMap(int index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder builderForValue) {
                if (this.dynamicValueMapBuilder_ == null) {
                    ensureDynamicValueMapIsMutable();
                    this.dynamicValueMap_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.dynamicValueMapBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllDynamicValueMap(Iterable<? extends AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> values) {
                if (this.dynamicValueMapBuilder_ == null) {
                    ensureDynamicValueMapIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.dynamicValueMap_);
                    onChanged();
                } else {
                    this.dynamicValueMapBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearDynamicValueMap() {
                if (this.dynamicValueMapBuilder_ == null) {
                    this.dynamicValueMap_ = Collections.emptyList();
                    this.bitField0_ &= -2;
                    onChanged();
                } else {
                    this.dynamicValueMapBuilder_.clear();
                }
                return this;
            }

            public Builder removeDynamicValueMap(int index) {
                if (this.dynamicValueMapBuilder_ == null) {
                    ensureDynamicValueMapIsMutable();
                    this.dynamicValueMap_.remove(index);
                    onChanged();
                } else {
                    this.dynamicValueMapBuilder_.remove(index);
                }
                return this;
            }

            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder getDynamicValueMapBuilder(int index) {
                return getDynamicValueMapFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder getDynamicValueMapOrBuilder(int index) {
                if (this.dynamicValueMapBuilder_ == null) {
                    return this.dynamicValueMap_.get(index);
                }
                return this.dynamicValueMapBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public List<? extends AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> getDynamicValueMapOrBuilderList() {
                if (this.dynamicValueMapBuilder_ != null) {
                    return this.dynamicValueMapBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.dynamicValueMap_);
            }

            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder addDynamicValueMapBuilder() {
                return getDynamicValueMapFieldBuilder().addBuilder(AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.getDefaultInstance());
            }

            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder addDynamicValueMapBuilder(int index) {
                return getDynamicValueMapFieldBuilder().addBuilder(index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.getDefaultInstance());
            }

            public List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder> getDynamicValueMapBuilderList() {
                return getDynamicValueMapFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> getDynamicValueMapFieldBuilder() {
                if (this.dynamicValueMapBuilder_ == null) {
                    this.dynamicValueMapBuilder_ = new RepeatedFieldBuilderV3<>(this.dynamicValueMap_, (this.bitField0_ & 1) != 0, getParentForChildren(), isClean());
                    this.dynamicValueMap_ = null;
                }
                return this.dynamicValueMapBuilder_;
            }

            private void ensureAppliedAbilitiesIsMutable() {
                if ((this.bitField0_ & 2) == 0) {
                    this.appliedAbilities_ = new ArrayList(this.appliedAbilities_);
                    this.bitField0_ |= 2;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public List<AbilityAppliedAbilityOuterClass.AbilityAppliedAbility> getAppliedAbilitiesList() {
                if (this.appliedAbilitiesBuilder_ == null) {
                    return Collections.unmodifiableList(this.appliedAbilities_);
                }
                return this.appliedAbilitiesBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public int getAppliedAbilitiesCount() {
                if (this.appliedAbilitiesBuilder_ == null) {
                    return this.appliedAbilities_.size();
                }
                return this.appliedAbilitiesBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public AbilityAppliedAbilityOuterClass.AbilityAppliedAbility getAppliedAbilities(int index) {
                if (this.appliedAbilitiesBuilder_ == null) {
                    return this.appliedAbilities_.get(index);
                }
                return this.appliedAbilitiesBuilder_.getMessage(index);
            }

            public Builder setAppliedAbilities(int index, AbilityAppliedAbilityOuterClass.AbilityAppliedAbility value) {
                if (this.appliedAbilitiesBuilder_ != null) {
                    this.appliedAbilitiesBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAppliedAbilitiesIsMutable();
                    this.appliedAbilities_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAppliedAbilities(int index, AbilityAppliedAbilityOuterClass.AbilityAppliedAbility.Builder builderForValue) {
                if (this.appliedAbilitiesBuilder_ == null) {
                    ensureAppliedAbilitiesIsMutable();
                    this.appliedAbilities_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.appliedAbilitiesBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAppliedAbilities(AbilityAppliedAbilityOuterClass.AbilityAppliedAbility value) {
                if (this.appliedAbilitiesBuilder_ != null) {
                    this.appliedAbilitiesBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAppliedAbilitiesIsMutable();
                    this.appliedAbilities_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAppliedAbilities(int index, AbilityAppliedAbilityOuterClass.AbilityAppliedAbility value) {
                if (this.appliedAbilitiesBuilder_ != null) {
                    this.appliedAbilitiesBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAppliedAbilitiesIsMutable();
                    this.appliedAbilities_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAppliedAbilities(AbilityAppliedAbilityOuterClass.AbilityAppliedAbility.Builder builderForValue) {
                if (this.appliedAbilitiesBuilder_ == null) {
                    ensureAppliedAbilitiesIsMutable();
                    this.appliedAbilities_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.appliedAbilitiesBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAppliedAbilities(int index, AbilityAppliedAbilityOuterClass.AbilityAppliedAbility.Builder builderForValue) {
                if (this.appliedAbilitiesBuilder_ == null) {
                    ensureAppliedAbilitiesIsMutable();
                    this.appliedAbilities_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.appliedAbilitiesBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAppliedAbilities(Iterable<? extends AbilityAppliedAbilityOuterClass.AbilityAppliedAbility> values) {
                if (this.appliedAbilitiesBuilder_ == null) {
                    ensureAppliedAbilitiesIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.appliedAbilities_);
                    onChanged();
                } else {
                    this.appliedAbilitiesBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAppliedAbilities() {
                if (this.appliedAbilitiesBuilder_ == null) {
                    this.appliedAbilities_ = Collections.emptyList();
                    this.bitField0_ &= -3;
                    onChanged();
                } else {
                    this.appliedAbilitiesBuilder_.clear();
                }
                return this;
            }

            public Builder removeAppliedAbilities(int index) {
                if (this.appliedAbilitiesBuilder_ == null) {
                    ensureAppliedAbilitiesIsMutable();
                    this.appliedAbilities_.remove(index);
                    onChanged();
                } else {
                    this.appliedAbilitiesBuilder_.remove(index);
                }
                return this;
            }

            public AbilityAppliedAbilityOuterClass.AbilityAppliedAbility.Builder getAppliedAbilitiesBuilder(int index) {
                return getAppliedAbilitiesFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder getAppliedAbilitiesOrBuilder(int index) {
                if (this.appliedAbilitiesBuilder_ == null) {
                    return this.appliedAbilities_.get(index);
                }
                return this.appliedAbilitiesBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public List<? extends AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder> getAppliedAbilitiesOrBuilderList() {
                if (this.appliedAbilitiesBuilder_ != null) {
                    return this.appliedAbilitiesBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.appliedAbilities_);
            }

            public AbilityAppliedAbilityOuterClass.AbilityAppliedAbility.Builder addAppliedAbilitiesBuilder() {
                return getAppliedAbilitiesFieldBuilder().addBuilder(AbilityAppliedAbilityOuterClass.AbilityAppliedAbility.getDefaultInstance());
            }

            public AbilityAppliedAbilityOuterClass.AbilityAppliedAbility.Builder addAppliedAbilitiesBuilder(int index) {
                return getAppliedAbilitiesFieldBuilder().addBuilder(index, AbilityAppliedAbilityOuterClass.AbilityAppliedAbility.getDefaultInstance());
            }

            public List<AbilityAppliedAbilityOuterClass.AbilityAppliedAbility.Builder> getAppliedAbilitiesBuilderList() {
                return getAppliedAbilitiesFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AbilityAppliedAbilityOuterClass.AbilityAppliedAbility, AbilityAppliedAbilityOuterClass.AbilityAppliedAbility.Builder, AbilityAppliedAbilityOuterClass.AbilityAppliedAbilityOrBuilder> getAppliedAbilitiesFieldBuilder() {
                if (this.appliedAbilitiesBuilder_ == null) {
                    this.appliedAbilitiesBuilder_ = new RepeatedFieldBuilderV3<>(this.appliedAbilities_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                    this.appliedAbilities_ = null;
                }
                return this.appliedAbilitiesBuilder_;
            }

            private void ensureAppliedModifiersIsMutable() {
                if ((this.bitField0_ & 4) == 0) {
                    this.appliedModifiers_ = new ArrayList(this.appliedModifiers_);
                    this.bitField0_ |= 4;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public List<AbilityAppliedModifierOuterClass.AbilityAppliedModifier> getAppliedModifiersList() {
                if (this.appliedModifiersBuilder_ == null) {
                    return Collections.unmodifiableList(this.appliedModifiers_);
                }
                return this.appliedModifiersBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public int getAppliedModifiersCount() {
                if (this.appliedModifiersBuilder_ == null) {
                    return this.appliedModifiers_.size();
                }
                return this.appliedModifiersBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public AbilityAppliedModifierOuterClass.AbilityAppliedModifier getAppliedModifiers(int index) {
                if (this.appliedModifiersBuilder_ == null) {
                    return this.appliedModifiers_.get(index);
                }
                return this.appliedModifiersBuilder_.getMessage(index);
            }

            public Builder setAppliedModifiers(int index, AbilityAppliedModifierOuterClass.AbilityAppliedModifier value) {
                if (this.appliedModifiersBuilder_ != null) {
                    this.appliedModifiersBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAppliedModifiersIsMutable();
                    this.appliedModifiers_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setAppliedModifiers(int index, AbilityAppliedModifierOuterClass.AbilityAppliedModifier.Builder builderForValue) {
                if (this.appliedModifiersBuilder_ == null) {
                    ensureAppliedModifiersIsMutable();
                    this.appliedModifiers_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.appliedModifiersBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAppliedModifiers(AbilityAppliedModifierOuterClass.AbilityAppliedModifier value) {
                if (this.appliedModifiersBuilder_ != null) {
                    this.appliedModifiersBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAppliedModifiersIsMutable();
                    this.appliedModifiers_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addAppliedModifiers(int index, AbilityAppliedModifierOuterClass.AbilityAppliedModifier value) {
                if (this.appliedModifiersBuilder_ != null) {
                    this.appliedModifiersBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureAppliedModifiersIsMutable();
                    this.appliedModifiers_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addAppliedModifiers(AbilityAppliedModifierOuterClass.AbilityAppliedModifier.Builder builderForValue) {
                if (this.appliedModifiersBuilder_ == null) {
                    ensureAppliedModifiersIsMutable();
                    this.appliedModifiers_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.appliedModifiersBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addAppliedModifiers(int index, AbilityAppliedModifierOuterClass.AbilityAppliedModifier.Builder builderForValue) {
                if (this.appliedModifiersBuilder_ == null) {
                    ensureAppliedModifiersIsMutable();
                    this.appliedModifiers_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.appliedModifiersBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllAppliedModifiers(Iterable<? extends AbilityAppliedModifierOuterClass.AbilityAppliedModifier> values) {
                if (this.appliedModifiersBuilder_ == null) {
                    ensureAppliedModifiersIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.appliedModifiers_);
                    onChanged();
                } else {
                    this.appliedModifiersBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearAppliedModifiers() {
                if (this.appliedModifiersBuilder_ == null) {
                    this.appliedModifiers_ = Collections.emptyList();
                    this.bitField0_ &= -5;
                    onChanged();
                } else {
                    this.appliedModifiersBuilder_.clear();
                }
                return this;
            }

            public Builder removeAppliedModifiers(int index) {
                if (this.appliedModifiersBuilder_ == null) {
                    ensureAppliedModifiersIsMutable();
                    this.appliedModifiers_.remove(index);
                    onChanged();
                } else {
                    this.appliedModifiersBuilder_.remove(index);
                }
                return this;
            }

            public AbilityAppliedModifierOuterClass.AbilityAppliedModifier.Builder getAppliedModifiersBuilder(int index) {
                return getAppliedModifiersFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder getAppliedModifiersOrBuilder(int index) {
                if (this.appliedModifiersBuilder_ == null) {
                    return this.appliedModifiers_.get(index);
                }
                return this.appliedModifiersBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public List<? extends AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder> getAppliedModifiersOrBuilderList() {
                if (this.appliedModifiersBuilder_ != null) {
                    return this.appliedModifiersBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.appliedModifiers_);
            }

            public AbilityAppliedModifierOuterClass.AbilityAppliedModifier.Builder addAppliedModifiersBuilder() {
                return getAppliedModifiersFieldBuilder().addBuilder(AbilityAppliedModifierOuterClass.AbilityAppliedModifier.getDefaultInstance());
            }

            public AbilityAppliedModifierOuterClass.AbilityAppliedModifier.Builder addAppliedModifiersBuilder(int index) {
                return getAppliedModifiersFieldBuilder().addBuilder(index, AbilityAppliedModifierOuterClass.AbilityAppliedModifier.getDefaultInstance());
            }

            public List<AbilityAppliedModifierOuterClass.AbilityAppliedModifier.Builder> getAppliedModifiersBuilderList() {
                return getAppliedModifiersFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AbilityAppliedModifierOuterClass.AbilityAppliedModifier, AbilityAppliedModifierOuterClass.AbilityAppliedModifier.Builder, AbilityAppliedModifierOuterClass.AbilityAppliedModifierOrBuilder> getAppliedModifiersFieldBuilder() {
                if (this.appliedModifiersBuilder_ == null) {
                    this.appliedModifiersBuilder_ = new RepeatedFieldBuilderV3<>(this.appliedModifiers_, (this.bitField0_ & 4) != 0, getParentForChildren(), isClean());
                    this.appliedModifiers_ = null;
                }
                return this.appliedModifiersBuilder_;
            }

            private void ensureMixinRecoverInfosIsMutable() {
                if ((this.bitField0_ & 8) == 0) {
                    this.mixinRecoverInfos_ = new ArrayList(this.mixinRecoverInfos_);
                    this.bitField0_ |= 8;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public List<AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo> getMixinRecoverInfosList() {
                if (this.mixinRecoverInfosBuilder_ == null) {
                    return Collections.unmodifiableList(this.mixinRecoverInfos_);
                }
                return this.mixinRecoverInfosBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public int getMixinRecoverInfosCount() {
                if (this.mixinRecoverInfosBuilder_ == null) {
                    return this.mixinRecoverInfos_.size();
                }
                return this.mixinRecoverInfosBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo getMixinRecoverInfos(int index) {
                if (this.mixinRecoverInfosBuilder_ == null) {
                    return this.mixinRecoverInfos_.get(index);
                }
                return this.mixinRecoverInfosBuilder_.getMessage(index);
            }

            public Builder setMixinRecoverInfos(int index, AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo value) {
                if (this.mixinRecoverInfosBuilder_ != null) {
                    this.mixinRecoverInfosBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMixinRecoverInfosIsMutable();
                    this.mixinRecoverInfos_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setMixinRecoverInfos(int index, AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo.Builder builderForValue) {
                if (this.mixinRecoverInfosBuilder_ == null) {
                    ensureMixinRecoverInfosIsMutable();
                    this.mixinRecoverInfos_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.mixinRecoverInfosBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addMixinRecoverInfos(AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo value) {
                if (this.mixinRecoverInfosBuilder_ != null) {
                    this.mixinRecoverInfosBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMixinRecoverInfosIsMutable();
                    this.mixinRecoverInfos_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addMixinRecoverInfos(int index, AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo value) {
                if (this.mixinRecoverInfosBuilder_ != null) {
                    this.mixinRecoverInfosBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureMixinRecoverInfosIsMutable();
                    this.mixinRecoverInfos_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addMixinRecoverInfos(AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo.Builder builderForValue) {
                if (this.mixinRecoverInfosBuilder_ == null) {
                    ensureMixinRecoverInfosIsMutable();
                    this.mixinRecoverInfos_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.mixinRecoverInfosBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addMixinRecoverInfos(int index, AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo.Builder builderForValue) {
                if (this.mixinRecoverInfosBuilder_ == null) {
                    ensureMixinRecoverInfosIsMutable();
                    this.mixinRecoverInfos_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.mixinRecoverInfosBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllMixinRecoverInfos(Iterable<? extends AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo> values) {
                if (this.mixinRecoverInfosBuilder_ == null) {
                    ensureMixinRecoverInfosIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.mixinRecoverInfos_);
                    onChanged();
                } else {
                    this.mixinRecoverInfosBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearMixinRecoverInfos() {
                if (this.mixinRecoverInfosBuilder_ == null) {
                    this.mixinRecoverInfos_ = Collections.emptyList();
                    this.bitField0_ &= -9;
                    onChanged();
                } else {
                    this.mixinRecoverInfosBuilder_.clear();
                }
                return this;
            }

            public Builder removeMixinRecoverInfos(int index) {
                if (this.mixinRecoverInfosBuilder_ == null) {
                    ensureMixinRecoverInfosIsMutable();
                    this.mixinRecoverInfos_.remove(index);
                    onChanged();
                } else {
                    this.mixinRecoverInfosBuilder_.remove(index);
                }
                return this;
            }

            public AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo.Builder getMixinRecoverInfosBuilder(int index) {
                return getMixinRecoverInfosFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder getMixinRecoverInfosOrBuilder(int index) {
                if (this.mixinRecoverInfosBuilder_ == null) {
                    return this.mixinRecoverInfos_.get(index);
                }
                return this.mixinRecoverInfosBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public List<? extends AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder> getMixinRecoverInfosOrBuilderList() {
                if (this.mixinRecoverInfosBuilder_ != null) {
                    return this.mixinRecoverInfosBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.mixinRecoverInfos_);
            }

            public AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo.Builder addMixinRecoverInfosBuilder() {
                return getMixinRecoverInfosFieldBuilder().addBuilder(AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo.getDefaultInstance());
            }

            public AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo.Builder addMixinRecoverInfosBuilder(int index) {
                return getMixinRecoverInfosFieldBuilder().addBuilder(index, AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo.getDefaultInstance());
            }

            public List<AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo.Builder> getMixinRecoverInfosBuilderList() {
                return getMixinRecoverInfosFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo, AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfo.Builder, AbilityMixinRecoverInfoOuterClass.AbilityMixinRecoverInfoOrBuilder> getMixinRecoverInfosFieldBuilder() {
                if (this.mixinRecoverInfosBuilder_ == null) {
                    this.mixinRecoverInfosBuilder_ = new RepeatedFieldBuilderV3<>(this.mixinRecoverInfos_, (this.bitField0_ & 8) != 0, getParentForChildren(), isClean());
                    this.mixinRecoverInfos_ = null;
                }
                return this.mixinRecoverInfosBuilder_;
            }

            private void ensureSgvDynamicValueMapIsMutable() {
                if ((this.bitField0_ & 16) == 0) {
                    this.sgvDynamicValueMap_ = new ArrayList(this.sgvDynamicValueMap_);
                    this.bitField0_ |= 16;
                }
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> getSgvDynamicValueMapList() {
                if (this.sgvDynamicValueMapBuilder_ == null) {
                    return Collections.unmodifiableList(this.sgvDynamicValueMap_);
                }
                return this.sgvDynamicValueMapBuilder_.getMessageList();
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public int getSgvDynamicValueMapCount() {
                if (this.sgvDynamicValueMapBuilder_ == null) {
                    return this.sgvDynamicValueMap_.size();
                }
                return this.sgvDynamicValueMapBuilder_.getCount();
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry getSgvDynamicValueMap(int index) {
                if (this.sgvDynamicValueMapBuilder_ == null) {
                    return this.sgvDynamicValueMap_.get(index);
                }
                return this.sgvDynamicValueMapBuilder_.getMessage(index);
            }

            public Builder setSgvDynamicValueMap(int index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry value) {
                if (this.sgvDynamicValueMapBuilder_ != null) {
                    this.sgvDynamicValueMapBuilder_.setMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSgvDynamicValueMapIsMutable();
                    this.sgvDynamicValueMap_.set(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder setSgvDynamicValueMap(int index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder builderForValue) {
                if (this.sgvDynamicValueMapBuilder_ == null) {
                    ensureSgvDynamicValueMapIsMutable();
                    this.sgvDynamicValueMap_.set(index, builderForValue.build());
                    onChanged();
                } else {
                    this.sgvDynamicValueMapBuilder_.setMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addSgvDynamicValueMap(AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry value) {
                if (this.sgvDynamicValueMapBuilder_ != null) {
                    this.sgvDynamicValueMapBuilder_.addMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSgvDynamicValueMapIsMutable();
                    this.sgvDynamicValueMap_.add(value);
                    onChanged();
                }
                return this;
            }

            public Builder addSgvDynamicValueMap(int index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry value) {
                if (this.sgvDynamicValueMapBuilder_ != null) {
                    this.sgvDynamicValueMapBuilder_.addMessage(index, value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    ensureSgvDynamicValueMapIsMutable();
                    this.sgvDynamicValueMap_.add(index, value);
                    onChanged();
                }
                return this;
            }

            public Builder addSgvDynamicValueMap(AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder builderForValue) {
                if (this.sgvDynamicValueMapBuilder_ == null) {
                    ensureSgvDynamicValueMapIsMutable();
                    this.sgvDynamicValueMap_.add(builderForValue.build());
                    onChanged();
                } else {
                    this.sgvDynamicValueMapBuilder_.addMessage(builderForValue.build());
                }
                return this;
            }

            public Builder addSgvDynamicValueMap(int index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder builderForValue) {
                if (this.sgvDynamicValueMapBuilder_ == null) {
                    ensureSgvDynamicValueMapIsMutable();
                    this.sgvDynamicValueMap_.add(index, builderForValue.build());
                    onChanged();
                } else {
                    this.sgvDynamicValueMapBuilder_.addMessage(index, builderForValue.build());
                }
                return this;
            }

            public Builder addAllSgvDynamicValueMap(Iterable<? extends AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry> values) {
                if (this.sgvDynamicValueMapBuilder_ == null) {
                    ensureSgvDynamicValueMapIsMutable();
                    AbstractMessageLite.Builder.addAll((Iterable) values, (List) this.sgvDynamicValueMap_);
                    onChanged();
                } else {
                    this.sgvDynamicValueMapBuilder_.addAllMessages(values);
                }
                return this;
            }

            public Builder clearSgvDynamicValueMap() {
                if (this.sgvDynamicValueMapBuilder_ == null) {
                    this.sgvDynamicValueMap_ = Collections.emptyList();
                    this.bitField0_ &= -17;
                    onChanged();
                } else {
                    this.sgvDynamicValueMapBuilder_.clear();
                }
                return this;
            }

            public Builder removeSgvDynamicValueMap(int index) {
                if (this.sgvDynamicValueMapBuilder_ == null) {
                    ensureSgvDynamicValueMapIsMutable();
                    this.sgvDynamicValueMap_.remove(index);
                    onChanged();
                } else {
                    this.sgvDynamicValueMapBuilder_.remove(index);
                }
                return this;
            }

            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder getSgvDynamicValueMapBuilder(int index) {
                return getSgvDynamicValueMapFieldBuilder().getBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder getSgvDynamicValueMapOrBuilder(int index) {
                if (this.sgvDynamicValueMapBuilder_ == null) {
                    return this.sgvDynamicValueMap_.get(index);
                }
                return this.sgvDynamicValueMapBuilder_.getMessageOrBuilder(index);
            }

            @Override // emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfoOrBuilder
            public List<? extends AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> getSgvDynamicValueMapOrBuilderList() {
                if (this.sgvDynamicValueMapBuilder_ != null) {
                    return this.sgvDynamicValueMapBuilder_.getMessageOrBuilderList();
                }
                return Collections.unmodifiableList(this.sgvDynamicValueMap_);
            }

            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder addSgvDynamicValueMapBuilder() {
                return getSgvDynamicValueMapFieldBuilder().addBuilder(AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.getDefaultInstance());
            }

            public AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder addSgvDynamicValueMapBuilder(int index) {
                return getSgvDynamicValueMapFieldBuilder().addBuilder(index, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.getDefaultInstance());
            }

            public List<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder> getSgvDynamicValueMapBuilderList() {
                return getSgvDynamicValueMapFieldBuilder().getBuilderList();
            }

            private RepeatedFieldBuilderV3<AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntry.Builder, AbilityScalarValueEntryOuterClass.AbilityScalarValueEntryOrBuilder> getSgvDynamicValueMapFieldBuilder() {
                if (this.sgvDynamicValueMapBuilder_ == null) {
                    this.sgvDynamicValueMapBuilder_ = new RepeatedFieldBuilderV3<>(this.sgvDynamicValueMap_, (this.bitField0_ & 16) != 0, getParentForChildren(), isClean());
                    this.sgvDynamicValueMap_ = null;
                }
                return this.sgvDynamicValueMapBuilder_;
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

        public static AbilitySyncStateInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AbilitySyncStateInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<AbilitySyncStateInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public AbilitySyncStateInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AbilityScalarValueEntryOuterClass.getDescriptor();
        AbilityAppliedAbilityOuterClass.getDescriptor();
        AbilityAppliedModifierOuterClass.getDescriptor();
        AbilityMixinRecoverInfoOuterClass.getDescriptor();
    }
}
