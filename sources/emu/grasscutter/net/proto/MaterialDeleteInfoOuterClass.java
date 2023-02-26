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
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.SingleFieldBuilderV3;
import com.google.protobuf.UnknownFieldSet;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteInfoOuterClass.class */
public final class MaterialDeleteInfoOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u0018MaterialDeleteInfo.proto\"Þ\u0005\n\u0012MaterialDeleteInfo\u0012\u0017\n\u000fhasDeleteConfig\u0018\u0001 \u0001(\b\u0012@\n\u0011count_down_delete\u0018\u0002 \u0001(\u000b2#.MaterialDeleteInfo.CountDownDeleteH��\u00129\n\u000bdate_delete\u0018\u0003 \u0001(\u000b2\".MaterialDeleteInfo.DateTimeDeleteH��\u0012T\n\u001cdelay_week_count_down_delete\u0018\u0004 \u0001(\u000b2,.MaterialDeleteInfo.DelayWeekCountDownDeleteH��\u001a¼\u0001\n\u000fCountDownDelete\u0012S\n\u0010deleteTimeNumMap\u0018\u0001 \u0003(\u000b29.MaterialDeleteInfo.CountDownDelete.DeleteTimeNumMapEntry\u0012\u001b\n\u0013configCountDownTime\u0018\u0002 \u0001(\r\u001a7\n\u0015DeleteTimeNumMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001\u001a$\n\u000eDateTimeDelete\u0012\u0012\n\ndeleteTime\u0018\u0001 \u0001(\r\u001aç\u0001\n\u0018DelayWeekCountDownDelete\u0012\\\n\u0010deleteTimeNumMap\u0018\u0001 \u0003(\u000b2B.MaterialDeleteInfo.DelayWeekCountDownDelete.DeleteTimeNumMapEntry\u0012\u0017\n\u000fconfigDelayWeek\u0018\u0002 \u0001(\r\u0012\u001b\n\u0013configCountDownTime\u0018\u0003 \u0001(\r\u001a7\n\u0015DeleteTimeNumMapEntry\u0012\u000b\n\u0003key\u0018\u0001 \u0001(\r\u0012\r\n\u0005value\u0018\u0002 \u0001(\r:\u00028\u0001B\r\n\u000bdelete_infoB\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);
    private static final Descriptors.Descriptor internal_static_MaterialDeleteInfo_descriptor = getDescriptor().getMessageTypes().get(0);
    private static final GeneratedMessageV3.FieldAccessorTable internal_static_MaterialDeleteInfo_fieldAccessorTable = new GeneratedMessageV3.FieldAccessorTable(internal_static_MaterialDeleteInfo_descriptor, new String[]{"HasDeleteConfig", "CountDownDelete", "DateDelete", "DelayWeekCountDownDelete", "DeleteInfo"});
    private static final Descriptors.Descriptor internal_static_MaterialDeleteInfo_CountDownDelete_descriptor = internal_static_MaterialDeleteInfo_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_MaterialDeleteInfo_CountDownDelete_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f759x954a700 = new GeneratedMessageV3.FieldAccessorTable(internal_static_MaterialDeleteInfo_CountDownDelete_descriptor, new String[]{"DeleteTimeNumMap", "ConfigCountDownTime"});

    /* renamed from: internal_static_MaterialDeleteInfo_CountDownDelete_DeleteTimeNumMapEntry_descriptor */
    private static final Descriptors.Descriptor f760xdc9fa59d = internal_static_MaterialDeleteInfo_CountDownDelete_descriptor.getNestedTypes().get(0);

    /* renamed from: internal_static_MaterialDeleteInfo_CountDownDelete_DeleteTimeNumMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f761xfa91df1b = new GeneratedMessageV3.FieldAccessorTable(f760xdc9fa59d, new String[]{"Key", "Value"});
    private static final Descriptors.Descriptor internal_static_MaterialDeleteInfo_DateTimeDelete_descriptor = internal_static_MaterialDeleteInfo_descriptor.getNestedTypes().get(1);

    /* renamed from: internal_static_MaterialDeleteInfo_DateTimeDelete_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f762x1526b256 = new GeneratedMessageV3.FieldAccessorTable(internal_static_MaterialDeleteInfo_DateTimeDelete_descriptor, new String[]{"DeleteTime"});

    /* renamed from: internal_static_MaterialDeleteInfo_DelayWeekCountDownDelete_descriptor */
    private static final Descriptors.Descriptor f763xbc57e159 = internal_static_MaterialDeleteInfo_descriptor.getNestedTypes().get(2);

    /* renamed from: internal_static_MaterialDeleteInfo_DelayWeekCountDownDelete_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f764x4a209ed7 = new GeneratedMessageV3.FieldAccessorTable(f763xbc57e159, new String[]{"DeleteTimeNumMap", "ConfigDelayWeek", "ConfigCountDownTime"});

    /* renamed from: internal_static_MaterialDeleteInfo_DelayWeekCountDownDelete_DeleteTimeNumMapEntry_descriptor */
    private static final Descriptors.Descriptor f765x88f59934 = f763xbc57e159.getNestedTypes().get(0);

    /* renamed from: internal_static_MaterialDeleteInfo_DelayWeekCountDownDelete_DeleteTimeNumMapEntry_fieldAccessorTable */
    private static final GeneratedMessageV3.FieldAccessorTable f766xeba24bb2 = new GeneratedMessageV3.FieldAccessorTable(f765x88f59934, new String[]{"Key", "Value"});

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteInfoOuterClass$MaterialDeleteInfoOrBuilder.class */
    public interface MaterialDeleteInfoOrBuilder extends MessageOrBuilder {
        boolean getHasDeleteConfig();

        boolean hasCountDownDelete();

        MaterialDeleteInfo.CountDownDelete getCountDownDelete();

        MaterialDeleteInfo.CountDownDeleteOrBuilder getCountDownDeleteOrBuilder();

        boolean hasDateDelete();

        MaterialDeleteInfo.DateTimeDelete getDateDelete();

        MaterialDeleteInfo.DateTimeDeleteOrBuilder getDateDeleteOrBuilder();

        boolean hasDelayWeekCountDownDelete();

        MaterialDeleteInfo.DelayWeekCountDownDelete getDelayWeekCountDownDelete();

        MaterialDeleteInfo.DelayWeekCountDownDeleteOrBuilder getDelayWeekCountDownDeleteOrBuilder();

        MaterialDeleteInfo.DeleteInfoCase getDeleteInfoCase();
    }

    private MaterialDeleteInfoOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteInfoOuterClass$MaterialDeleteInfo.class */
    public static final class MaterialDeleteInfo extends GeneratedMessageV3 implements MaterialDeleteInfoOrBuilder {
        private static final long serialVersionUID = 0;
        private int deleteInfoCase_;
        private Object deleteInfo_;
        public static final int HASDELETECONFIG_FIELD_NUMBER = 1;
        private boolean hasDeleteConfig_;
        public static final int COUNT_DOWN_DELETE_FIELD_NUMBER = 2;
        public static final int DATE_DELETE_FIELD_NUMBER = 3;
        public static final int DELAY_WEEK_COUNT_DOWN_DELETE_FIELD_NUMBER = 4;
        private byte memoizedIsInitialized;
        private static final MaterialDeleteInfo DEFAULT_INSTANCE = new MaterialDeleteInfo();
        private static final Parser<MaterialDeleteInfo> PARSER = new AbstractParser<MaterialDeleteInfo>() { // from class: emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.1
            @Override // com.google.protobuf.Parser
            public MaterialDeleteInfo parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return new MaterialDeleteInfo(input, extensionRegistry);
            }
        };

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteInfoOuterClass$MaterialDeleteInfo$CountDownDeleteOrBuilder.class */
        public interface CountDownDeleteOrBuilder extends MessageOrBuilder {
            int getDeleteTimeNumMapCount();

            boolean containsDeleteTimeNumMap(int i);

            @Deprecated
            Map<Integer, Integer> getDeleteTimeNumMap();

            Map<Integer, Integer> getDeleteTimeNumMapMap();

            int getDeleteTimeNumMapOrDefault(int i, int i2);

            int getDeleteTimeNumMapOrThrow(int i);

            int getConfigCountDownTime();
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteInfoOuterClass$MaterialDeleteInfo$DateTimeDeleteOrBuilder.class */
        public interface DateTimeDeleteOrBuilder extends MessageOrBuilder {
            int getDeleteTime();
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteInfoOuterClass$MaterialDeleteInfo$DelayWeekCountDownDeleteOrBuilder.class */
        public interface DelayWeekCountDownDeleteOrBuilder extends MessageOrBuilder {
            int getDeleteTimeNumMapCount();

            boolean containsDeleteTimeNumMap(int i);

            @Deprecated
            Map<Integer, Integer> getDeleteTimeNumMap();

            Map<Integer, Integer> getDeleteTimeNumMapMap();

            int getDeleteTimeNumMapOrDefault(int i, int i2);

            int getDeleteTimeNumMapOrThrow(int i);

            int getConfigDelayWeek();

            int getConfigCountDownTime();
        }

        private MaterialDeleteInfo(GeneratedMessageV3.Builder<?> builder) {
            super(builder);
            this.deleteInfoCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        private MaterialDeleteInfo() {
            this.deleteInfoCase_ = 0;
            this.memoizedIsInitialized = -1;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageV3
        public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
            return new MaterialDeleteInfo();
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
        public final UnknownFieldSet getUnknownFields() {
            return this.unknownFields;
        }

        private MaterialDeleteInfo(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                this.hasDeleteConfig_ = input.readBool();
                                break;
                            case 18:
                                CountDownDelete.Builder subBuilder = this.deleteInfoCase_ == 2 ? ((CountDownDelete) this.deleteInfo_).toBuilder() : null;
                                this.deleteInfo_ = input.readMessage(CountDownDelete.parser(), extensionRegistry);
                                if (subBuilder != null) {
                                    subBuilder.mergeFrom((CountDownDelete) this.deleteInfo_);
                                    this.deleteInfo_ = subBuilder.buildPartial();
                                }
                                this.deleteInfoCase_ = 2;
                                break;
                            case 26:
                                DateTimeDelete.Builder subBuilder2 = this.deleteInfoCase_ == 3 ? ((DateTimeDelete) this.deleteInfo_).toBuilder() : null;
                                this.deleteInfo_ = input.readMessage(DateTimeDelete.parser(), extensionRegistry);
                                if (subBuilder2 != null) {
                                    subBuilder2.mergeFrom((DateTimeDelete) this.deleteInfo_);
                                    this.deleteInfo_ = subBuilder2.buildPartial();
                                }
                                this.deleteInfoCase_ = 3;
                                break;
                            case 34:
                                DelayWeekCountDownDelete.Builder subBuilder3 = this.deleteInfoCase_ == 4 ? ((DelayWeekCountDownDelete) this.deleteInfo_).toBuilder() : null;
                                this.deleteInfo_ = input.readMessage(DelayWeekCountDownDelete.parser(), extensionRegistry);
                                if (subBuilder3 != null) {
                                    subBuilder3.mergeFrom((DelayWeekCountDownDelete) this.deleteInfo_);
                                    this.deleteInfo_ = subBuilder3.buildPartial();
                                }
                                this.deleteInfoCase_ = 4;
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
            return MaterialDeleteInfoOuterClass.internal_static_MaterialDeleteInfo_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessageV3
        protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
            return MaterialDeleteInfoOuterClass.internal_static_MaterialDeleteInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MaterialDeleteInfo.class, Builder.class);
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteInfoOuterClass$MaterialDeleteInfo$CountDownDelete.class */
        public static final class CountDownDelete extends GeneratedMessageV3 implements CountDownDeleteOrBuilder {
            private static final long serialVersionUID = 0;
            public static final int DELETETIMENUMMAP_FIELD_NUMBER = 1;
            private MapField<Integer, Integer> deleteTimeNumMap_;
            public static final int CONFIGCOUNTDOWNTIME_FIELD_NUMBER = 2;
            private int configCountDownTime_;
            private byte memoizedIsInitialized;
            private static final CountDownDelete DEFAULT_INSTANCE = new CountDownDelete();
            private static final Parser<CountDownDelete> PARSER = new AbstractParser<CountDownDelete>() { // from class: emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDelete.1
                @Override // com.google.protobuf.Parser
                public CountDownDelete parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new CountDownDelete(input, extensionRegistry);
                }
            };

            /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
                java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
                	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
                */
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDelete.internalGetMapField(int):com.google.protobuf.MapField
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            @Override // com.google.protobuf.GeneratedMessageV3
            protected com.google.protobuf.MapField internalGetMapField(int r5) {
                /*
                    r4 = this;
                    r0 = r5
                    switch(r0) {
                        case 1: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetDeleteTimeNumMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDelete.internalGetMapField(int):com.google.protobuf.MapField");
            }

            private CountDownDelete(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
            }

            private CountDownDelete() {
                this.memoizedIsInitialized = -1;
            }

            /* access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
                return new CountDownDelete();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private CountDownDelete(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                this();
                UnknownFieldSet.Builder unknownFields;
                if (extensionRegistry == null) {
                    throw new NullPointerException();
                }
                try {
                    int mutable_bitField0_ = 0;
                    unknownFields = UnknownFieldSet.newBuilder();
                    boolean done = false;
                    while (!done) {
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 10:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.deleteTimeNumMap_ = MapField.newMapField(DeleteTimeNumMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ |= 1;
                                    }
                                    MapEntry<Integer, Integer> deleteTimeNumMap__ = (MapEntry) input.readMessage(DeleteTimeNumMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.deleteTimeNumMap_.getMutableMap().put(deleteTimeNumMap__.getKey(), deleteTimeNumMap__.getValue());
                                    break;
                                case 16:
                                    this.configCountDownTime_ = input.readUInt32();
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
                return MaterialDeleteInfoOuterClass.internal_static_MaterialDeleteInfo_CountDownDelete_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MaterialDeleteInfoOuterClass.f759x954a700.ensureFieldAccessorsInitialized(CountDownDelete.class, Builder.class);
            }

            /* access modifiers changed from: private */
            /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteInfoOuterClass$MaterialDeleteInfo$CountDownDelete$DeleteTimeNumMapDefaultEntryHolder.class */
            public static final class DeleteTimeNumMapDefaultEntryHolder {
                static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(MaterialDeleteInfoOuterClass.f760xdc9fa59d, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

                private DeleteTimeNumMapDefaultEntryHolder() {
                }
            }

            private MapField<Integer, Integer> internalGetDeleteTimeNumMap() {
                if (this.deleteTimeNumMap_ == null) {
                    return MapField.emptyMapField(DeleteTimeNumMapDefaultEntryHolder.defaultEntry);
                }
                return this.deleteTimeNumMap_;
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDeleteOrBuilder
            public int getDeleteTimeNumMapCount() {
                return internalGetDeleteTimeNumMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDeleteOrBuilder
            public boolean containsDeleteTimeNumMap(int key) {
                return internalGetDeleteTimeNumMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDeleteOrBuilder
            @Deprecated
            public Map<Integer, Integer> getDeleteTimeNumMap() {
                return getDeleteTimeNumMapMap();
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDeleteOrBuilder
            public Map<Integer, Integer> getDeleteTimeNumMapMap() {
                return internalGetDeleteTimeNumMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDeleteOrBuilder
            public int getDeleteTimeNumMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetDeleteTimeNumMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDeleteOrBuilder
            public int getDeleteTimeNumMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetDeleteTimeNumMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDeleteOrBuilder
            public int getConfigCountDownTime() {
                return this.configCountDownTime_;
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
                GeneratedMessageV3.serializeIntegerMapTo(output, internalGetDeleteTimeNumMap(), DeleteTimeNumMapDefaultEntryHolder.defaultEntry, 1);
                if (this.configCountDownTime_ != 0) {
                    output.writeUInt32(2, this.configCountDownTime_);
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
                for (Map.Entry<Integer, Integer> entry : internalGetDeleteTimeNumMap().getMap().entrySet()) {
                    size2 += CodedOutputStream.computeMessageSize(1, DeleteTimeNumMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
                }
                if (this.configCountDownTime_ != 0) {
                    size2 += CodedOutputStream.computeUInt32Size(2, this.configCountDownTime_);
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
                if (!(obj instanceof CountDownDelete)) {
                    return equals(obj);
                }
                CountDownDelete other = (CountDownDelete) obj;
                return internalGetDeleteTimeNumMap().equals(other.internalGetDeleteTimeNumMap()) && getConfigCountDownTime() == other.getConfigCountDownTime() && this.unknownFields.equals(other.unknownFields);
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hash = (19 * 41) + getDescriptor().hashCode();
                if (!internalGetDeleteTimeNumMap().getMap().isEmpty()) {
                    hash = (53 * ((37 * hash) + 1)) + internalGetDeleteTimeNumMap().hashCode();
                }
                int hash2 = (29 * ((53 * ((37 * hash) + 2)) + getConfigCountDownTime())) + this.unknownFields.hashCode();
                this.memoizedHashCode = hash2;
                return hash2;
            }

            public static CountDownDelete parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static CountDownDelete parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static CountDownDelete parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static CountDownDelete parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static CountDownDelete parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static CountDownDelete parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static CountDownDelete parseFrom(InputStream input) throws IOException {
                return (CountDownDelete) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static CountDownDelete parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (CountDownDelete) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            public static CountDownDelete parseDelimitedFrom(InputStream input) throws IOException {
                return (CountDownDelete) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
            }

            public static CountDownDelete parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (CountDownDelete) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
            }

            public static CountDownDelete parseFrom(CodedInputStream input) throws IOException {
                return (CountDownDelete) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static CountDownDelete parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (CountDownDelete) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(CountDownDelete prototype) {
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

            /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteInfoOuterClass$MaterialDeleteInfo$CountDownDelete$Builder.class */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements CountDownDeleteOrBuilder {
                private int bitField0_;
                private MapField<Integer, Integer> deleteTimeNumMap_;
                private int configCountDownTime_;

                /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
                    java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
                    	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                    	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                    	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                    	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                    	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
                    	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
                    	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
                    */
                /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDelete.Builder.internalGetMapField(int):com.google.protobuf.MapField
                    jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                    	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                    	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                    	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                    	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                    	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                    	... 8 more
                    */
                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                protected com.google.protobuf.MapField internalGetMapField(int r5) {
                    /*
                        r4 = this;
                        r0 = r5
                        switch(r0) {
                            case 1: goto L_0x0014;
                            default: goto L_0x0019;
                        }
                        r0 = r4
                        com.google.protobuf.MapField r0 = r0.internalGetDeleteTimeNumMap()
                        return r0
                        java.lang.RuntimeException r0 = new java.lang.RuntimeException
                        r1 = r0
                        r2 = r5
                        // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                        r1.<init>(r2)
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDelete.Builder.internalGetMapField(int):com.google.protobuf.MapField");
                }

                /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
                    java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
                    	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                    	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                    	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                    	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                    	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
                    	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
                    	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
                    */
                /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDelete.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
                    jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                    	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                    	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                    	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                    	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                    	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                    	... 8 more
                    */
                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                protected com.google.protobuf.MapField internalGetMutableMapField(int r5) {
                    /*
                        r4 = this;
                        r0 = r5
                        switch(r0) {
                            case 1: goto L_0x0014;
                            default: goto L_0x0019;
                        }
                        r0 = r4
                        com.google.protobuf.MapField r0 = r0.internalGetMutableDeleteTimeNumMap()
                        return r0
                        java.lang.RuntimeException r0 = new java.lang.RuntimeException
                        r1 = r0
                        r2 = r5
                        // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                        r1.<init>(r2)
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDelete.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return MaterialDeleteInfoOuterClass.internal_static_MaterialDeleteInfo_CountDownDelete_descriptor;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return MaterialDeleteInfoOuterClass.f759x954a700.ensureFieldAccessorsInitialized(CountDownDelete.class, Builder.class);
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent parent) {
                    super(parent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (CountDownDelete.alwaysUseFieldBuilders) {
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    clear();
                    internalGetMutableDeleteTimeNumMap().clear();
                    this.configCountDownTime_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return MaterialDeleteInfoOuterClass.internal_static_MaterialDeleteInfo_CountDownDelete_descriptor;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public CountDownDelete getDefaultInstanceForType() {
                    return CountDownDelete.getDefaultInstance();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public CountDownDelete build() {
                    CountDownDelete result = buildPartial();
                    if (result.isInitialized()) {
                        return result;
                    }
                    throw newUninitializedMessageException((Message) result);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public CountDownDelete buildPartial() {
                    CountDownDelete result = new CountDownDelete(this);
                    int i = this.bitField0_;
                    result.deleteTimeNumMap_ = internalGetDeleteTimeNumMap();
                    result.deleteTimeNumMap_.makeImmutable();
                    result.configCountDownTime_ = this.configCountDownTime_;
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
                    if (other instanceof CountDownDelete) {
                        return mergeFrom((CountDownDelete) other);
                    }
                    mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(CountDownDelete other) {
                    if (other == CountDownDelete.getDefaultInstance()) {
                        return this;
                    }
                    internalGetMutableDeleteTimeNumMap().mergeFrom(other.internalGetDeleteTimeNumMap());
                    if (other.getConfigCountDownTime() != 0) {
                        setConfigCountDownTime(other.getConfigCountDownTime());
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
                    CountDownDelete parsedMessage = null;
                    try {
                        try {
                            parsedMessage = CountDownDelete.PARSER.parsePartialFrom(input, extensionRegistry);
                            if (parsedMessage != null) {
                                mergeFrom(parsedMessage);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            parsedMessage = (CountDownDelete) e.getUnfinishedMessage();
                            throw e.unwrapIOException();
                        }
                    } catch (Throwable th) {
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        throw th;
                    }
                }

                private MapField<Integer, Integer> internalGetDeleteTimeNumMap() {
                    if (this.deleteTimeNumMap_ == null) {
                        return MapField.emptyMapField(DeleteTimeNumMapDefaultEntryHolder.defaultEntry);
                    }
                    return this.deleteTimeNumMap_;
                }

                private MapField<Integer, Integer> internalGetMutableDeleteTimeNumMap() {
                    onChanged();
                    if (this.deleteTimeNumMap_ == null) {
                        this.deleteTimeNumMap_ = MapField.newMapField(DeleteTimeNumMapDefaultEntryHolder.defaultEntry);
                    }
                    if (!this.deleteTimeNumMap_.isMutable()) {
                        this.deleteTimeNumMap_ = this.deleteTimeNumMap_.copy();
                    }
                    return this.deleteTimeNumMap_;
                }

                @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDeleteOrBuilder
                public int getDeleteTimeNumMapCount() {
                    return internalGetDeleteTimeNumMap().getMap().size();
                }

                @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDeleteOrBuilder
                public boolean containsDeleteTimeNumMap(int key) {
                    return internalGetDeleteTimeNumMap().getMap().containsKey(Integer.valueOf(key));
                }

                @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDeleteOrBuilder
                @Deprecated
                public Map<Integer, Integer> getDeleteTimeNumMap() {
                    return getDeleteTimeNumMapMap();
                }

                @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDeleteOrBuilder
                public Map<Integer, Integer> getDeleteTimeNumMapMap() {
                    return internalGetDeleteTimeNumMap().getMap();
                }

                @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDeleteOrBuilder
                public int getDeleteTimeNumMapOrDefault(int key, int defaultValue) {
                    Map<Integer, Integer> map = internalGetDeleteTimeNumMap().getMap();
                    return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
                }

                @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDeleteOrBuilder
                public int getDeleteTimeNumMapOrThrow(int key) {
                    Map<Integer, Integer> map = internalGetDeleteTimeNumMap().getMap();
                    if (map.containsKey(Integer.valueOf(key))) {
                        return map.get(Integer.valueOf(key)).intValue();
                    }
                    throw new IllegalArgumentException();
                }

                public Builder clearDeleteTimeNumMap() {
                    internalGetMutableDeleteTimeNumMap().getMutableMap().clear();
                    return this;
                }

                public Builder removeDeleteTimeNumMap(int key) {
                    internalGetMutableDeleteTimeNumMap().getMutableMap().remove(Integer.valueOf(key));
                    return this;
                }

                @Deprecated
                public Map<Integer, Integer> getMutableDeleteTimeNumMap() {
                    return internalGetMutableDeleteTimeNumMap().getMutableMap();
                }

                public Builder putDeleteTimeNumMap(int key, int value) {
                    internalGetMutableDeleteTimeNumMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                    return this;
                }

                public Builder putAllDeleteTimeNumMap(Map<Integer, Integer> values) {
                    internalGetMutableDeleteTimeNumMap().getMutableMap().putAll(values);
                    return this;
                }

                @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.CountDownDeleteOrBuilder
                public int getConfigCountDownTime() {
                    return this.configCountDownTime_;
                }

                public Builder setConfigCountDownTime(int value) {
                    this.configCountDownTime_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearConfigCountDownTime() {
                    this.configCountDownTime_ = 0;
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

            public static CountDownDelete getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<CountDownDelete> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<CountDownDelete> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public CountDownDelete getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteInfoOuterClass$MaterialDeleteInfo$DateTimeDelete.class */
        public static final class DateTimeDelete extends GeneratedMessageV3 implements DateTimeDeleteOrBuilder {
            private static final long serialVersionUID = 0;
            public static final int DELETETIME_FIELD_NUMBER = 1;
            private int deleteTime_;
            private byte memoizedIsInitialized;
            private static final DateTimeDelete DEFAULT_INSTANCE = new DateTimeDelete();
            private static final Parser<DateTimeDelete> PARSER = new AbstractParser<DateTimeDelete>() { // from class: emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DateTimeDelete.1
                @Override // com.google.protobuf.Parser
                public DateTimeDelete parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new DateTimeDelete(input, extensionRegistry);
                }
            };

            private DateTimeDelete(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
            }

            private DateTimeDelete() {
                this.memoizedIsInitialized = -1;
            }

            /* access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
                return new DateTimeDelete();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private DateTimeDelete(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
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
                                    this.deleteTime_ = input.readUInt32();
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
                return MaterialDeleteInfoOuterClass.internal_static_MaterialDeleteInfo_DateTimeDelete_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MaterialDeleteInfoOuterClass.f762x1526b256.ensureFieldAccessorsInitialized(DateTimeDelete.class, Builder.class);
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DateTimeDeleteOrBuilder
            public int getDeleteTime() {
                return this.deleteTime_;
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
                if (this.deleteTime_ != 0) {
                    output.writeUInt32(1, this.deleteTime_);
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
                if (this.deleteTime_ != 0) {
                    size2 = 0 + CodedOutputStream.computeUInt32Size(1, this.deleteTime_);
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
                if (!(obj instanceof DateTimeDelete)) {
                    return equals(obj);
                }
                DateTimeDelete other = (DateTimeDelete) obj;
                return getDeleteTime() == other.getDeleteTime() && this.unknownFields.equals(other.unknownFields);
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hash = (29 * ((53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + getDeleteTime())) + this.unknownFields.hashCode();
                this.memoizedHashCode = hash;
                return hash;
            }

            public static DateTimeDelete parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static DateTimeDelete parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static DateTimeDelete parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static DateTimeDelete parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static DateTimeDelete parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static DateTimeDelete parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static DateTimeDelete parseFrom(InputStream input) throws IOException {
                return (DateTimeDelete) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static DateTimeDelete parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (DateTimeDelete) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            public static DateTimeDelete parseDelimitedFrom(InputStream input) throws IOException {
                return (DateTimeDelete) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
            }

            public static DateTimeDelete parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (DateTimeDelete) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
            }

            public static DateTimeDelete parseFrom(CodedInputStream input) throws IOException {
                return (DateTimeDelete) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static DateTimeDelete parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (DateTimeDelete) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(DateTimeDelete prototype) {
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

            /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteInfoOuterClass$MaterialDeleteInfo$DateTimeDelete$Builder.class */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DateTimeDeleteOrBuilder {
                private int deleteTime_;

                public static final Descriptors.Descriptor getDescriptor() {
                    return MaterialDeleteInfoOuterClass.internal_static_MaterialDeleteInfo_DateTimeDelete_descriptor;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return MaterialDeleteInfoOuterClass.f762x1526b256.ensureFieldAccessorsInitialized(DateTimeDelete.class, Builder.class);
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent parent) {
                    super(parent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (DateTimeDelete.alwaysUseFieldBuilders) {
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    clear();
                    this.deleteTime_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return MaterialDeleteInfoOuterClass.internal_static_MaterialDeleteInfo_DateTimeDelete_descriptor;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public DateTimeDelete getDefaultInstanceForType() {
                    return DateTimeDelete.getDefaultInstance();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public DateTimeDelete build() {
                    DateTimeDelete result = buildPartial();
                    if (result.isInitialized()) {
                        return result;
                    }
                    throw newUninitializedMessageException((Message) result);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public DateTimeDelete buildPartial() {
                    DateTimeDelete result = new DateTimeDelete(this);
                    result.deleteTime_ = this.deleteTime_;
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
                    if (other instanceof DateTimeDelete) {
                        return mergeFrom((DateTimeDelete) other);
                    }
                    mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(DateTimeDelete other) {
                    if (other == DateTimeDelete.getDefaultInstance()) {
                        return this;
                    }
                    if (other.getDeleteTime() != 0) {
                        setDeleteTime(other.getDeleteTime());
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
                    DateTimeDelete parsedMessage = null;
                    try {
                        try {
                            parsedMessage = DateTimeDelete.PARSER.parsePartialFrom(input, extensionRegistry);
                            if (parsedMessage != null) {
                                mergeFrom(parsedMessage);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            parsedMessage = (DateTimeDelete) e.getUnfinishedMessage();
                            throw e.unwrapIOException();
                        }
                    } catch (Throwable th) {
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        throw th;
                    }
                }

                @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DateTimeDeleteOrBuilder
                public int getDeleteTime() {
                    return this.deleteTime_;
                }

                public Builder setDeleteTime(int value) {
                    this.deleteTime_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearDeleteTime() {
                    this.deleteTime_ = 0;
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

            public static DateTimeDelete getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<DateTimeDelete> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<DateTimeDelete> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DateTimeDelete getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteInfoOuterClass$MaterialDeleteInfo$DelayWeekCountDownDelete.class */
        public static final class DelayWeekCountDownDelete extends GeneratedMessageV3 implements DelayWeekCountDownDeleteOrBuilder {
            private static final long serialVersionUID = 0;
            public static final int DELETETIMENUMMAP_FIELD_NUMBER = 1;
            private MapField<Integer, Integer> deleteTimeNumMap_;
            public static final int CONFIGDELAYWEEK_FIELD_NUMBER = 2;
            private int configDelayWeek_;
            public static final int CONFIGCOUNTDOWNTIME_FIELD_NUMBER = 3;
            private int configCountDownTime_;
            private byte memoizedIsInitialized;
            private static final DelayWeekCountDownDelete DEFAULT_INSTANCE = new DelayWeekCountDownDelete();
            private static final Parser<DelayWeekCountDownDelete> PARSER = new AbstractParser<DelayWeekCountDownDelete>() { // from class: emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDelete.1
                @Override // com.google.protobuf.Parser
                public DelayWeekCountDownDelete parsePartialFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                    return new DelayWeekCountDownDelete(input, extensionRegistry);
                }
            };

            /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
                java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
                	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
                */
            /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDelete.internalGetMapField(int):com.google.protobuf.MapField
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            @Override // com.google.protobuf.GeneratedMessageV3
            protected com.google.protobuf.MapField internalGetMapField(int r5) {
                /*
                    r4 = this;
                    r0 = r5
                    switch(r0) {
                        case 1: goto L_0x0014;
                        default: goto L_0x0019;
                    }
                    r0 = r4
                    com.google.protobuf.MapField r0 = r0.internalGetDeleteTimeNumMap()
                    return r0
                    java.lang.RuntimeException r0 = new java.lang.RuntimeException
                    r1 = r0
                    r2 = r5
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    r1.<init>(r2)
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDelete.internalGetMapField(int):com.google.protobuf.MapField");
            }

            private DelayWeekCountDownDelete(GeneratedMessageV3.Builder<?> builder) {
                super(builder);
                this.memoizedIsInitialized = -1;
            }

            private DelayWeekCountDownDelete() {
                this.memoizedIsInitialized = -1;
            }

            /* access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageV3
            public Object newInstance(GeneratedMessageV3.UnusedPrivateParameter unused) {
                return new DelayWeekCountDownDelete();
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageOrBuilder
            public final UnknownFieldSet getUnknownFields() {
                return this.unknownFields;
            }

            private DelayWeekCountDownDelete(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                this();
                UnknownFieldSet.Builder unknownFields;
                if (extensionRegistry == null) {
                    throw new NullPointerException();
                }
                try {
                    int mutable_bitField0_ = 0;
                    unknownFields = UnknownFieldSet.newBuilder();
                    boolean done = false;
                    while (!done) {
                        try {
                            int tag = input.readTag();
                            switch (tag) {
                                case 0:
                                    done = true;
                                    break;
                                case 10:
                                    if ((mutable_bitField0_ & 1) == 0) {
                                        this.deleteTimeNumMap_ = MapField.newMapField(DeleteTimeNumMapDefaultEntryHolder.defaultEntry);
                                        mutable_bitField0_ |= 1;
                                    }
                                    MapEntry<Integer, Integer> deleteTimeNumMap__ = (MapEntry) input.readMessage(DeleteTimeNumMapDefaultEntryHolder.defaultEntry.getParserForType(), extensionRegistry);
                                    this.deleteTimeNumMap_.getMutableMap().put(deleteTimeNumMap__.getKey(), deleteTimeNumMap__.getValue());
                                    break;
                                case 16:
                                    this.configDelayWeek_ = input.readUInt32();
                                    break;
                                case 24:
                                    this.configCountDownTime_ = input.readUInt32();
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
                return MaterialDeleteInfoOuterClass.f763xbc57e159;
            }

            @Override // com.google.protobuf.GeneratedMessageV3
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MaterialDeleteInfoOuterClass.f764x4a209ed7.ensureFieldAccessorsInitialized(DelayWeekCountDownDelete.class, Builder.class);
            }

            /* access modifiers changed from: private */
            /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteInfoOuterClass$MaterialDeleteInfo$DelayWeekCountDownDelete$DeleteTimeNumMapDefaultEntryHolder.class */
            public static final class DeleteTimeNumMapDefaultEntryHolder {
                static final MapEntry<Integer, Integer> defaultEntry = MapEntry.newDefaultInstance(MaterialDeleteInfoOuterClass.f765x88f59934, WireFormat.FieldType.UINT32, 0, WireFormat.FieldType.UINT32, 0);

                private DeleteTimeNumMapDefaultEntryHolder() {
                }
            }

            private MapField<Integer, Integer> internalGetDeleteTimeNumMap() {
                if (this.deleteTimeNumMap_ == null) {
                    return MapField.emptyMapField(DeleteTimeNumMapDefaultEntryHolder.defaultEntry);
                }
                return this.deleteTimeNumMap_;
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDeleteOrBuilder
            public int getDeleteTimeNumMapCount() {
                return internalGetDeleteTimeNumMap().getMap().size();
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDeleteOrBuilder
            public boolean containsDeleteTimeNumMap(int key) {
                return internalGetDeleteTimeNumMap().getMap().containsKey(Integer.valueOf(key));
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDeleteOrBuilder
            @Deprecated
            public Map<Integer, Integer> getDeleteTimeNumMap() {
                return getDeleteTimeNumMapMap();
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDeleteOrBuilder
            public Map<Integer, Integer> getDeleteTimeNumMapMap() {
                return internalGetDeleteTimeNumMap().getMap();
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDeleteOrBuilder
            public int getDeleteTimeNumMapOrDefault(int key, int defaultValue) {
                Map<Integer, Integer> map = internalGetDeleteTimeNumMap().getMap();
                return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDeleteOrBuilder
            public int getDeleteTimeNumMapOrThrow(int key) {
                Map<Integer, Integer> map = internalGetDeleteTimeNumMap().getMap();
                if (map.containsKey(Integer.valueOf(key))) {
                    return map.get(Integer.valueOf(key)).intValue();
                }
                throw new IllegalArgumentException();
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDeleteOrBuilder
            public int getConfigDelayWeek() {
                return this.configDelayWeek_;
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDeleteOrBuilder
            public int getConfigCountDownTime() {
                return this.configCountDownTime_;
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
                GeneratedMessageV3.serializeIntegerMapTo(output, internalGetDeleteTimeNumMap(), DeleteTimeNumMapDefaultEntryHolder.defaultEntry, 1);
                if (this.configDelayWeek_ != 0) {
                    output.writeUInt32(2, this.configDelayWeek_);
                }
                if (this.configCountDownTime_ != 0) {
                    output.writeUInt32(3, this.configCountDownTime_);
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
                for (Map.Entry<Integer, Integer> entry : internalGetDeleteTimeNumMap().getMap().entrySet()) {
                    size2 += CodedOutputStream.computeMessageSize(1, DeleteTimeNumMapDefaultEntryHolder.defaultEntry.newBuilderForType().setKey(entry.getKey()).setValue(entry.getValue()).build());
                }
                if (this.configDelayWeek_ != 0) {
                    size2 += CodedOutputStream.computeUInt32Size(2, this.configDelayWeek_);
                }
                if (this.configCountDownTime_ != 0) {
                    size2 += CodedOutputStream.computeUInt32Size(3, this.configCountDownTime_);
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
                if (!(obj instanceof DelayWeekCountDownDelete)) {
                    return equals(obj);
                }
                DelayWeekCountDownDelete other = (DelayWeekCountDownDelete) obj;
                return internalGetDeleteTimeNumMap().equals(other.internalGetDeleteTimeNumMap()) && getConfigDelayWeek() == other.getConfigDelayWeek() && getConfigCountDownTime() == other.getConfigCountDownTime() && this.unknownFields.equals(other.unknownFields);
            }

            @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
            public int hashCode() {
                if (this.memoizedHashCode != 0) {
                    return this.memoizedHashCode;
                }
                int hash = (19 * 41) + getDescriptor().hashCode();
                if (!internalGetDeleteTimeNumMap().getMap().isEmpty()) {
                    hash = (53 * ((37 * hash) + 1)) + internalGetDeleteTimeNumMap().hashCode();
                }
                int hash2 = (29 * ((53 * ((37 * ((53 * ((37 * hash) + 2)) + getConfigDelayWeek())) + 3)) + getConfigCountDownTime())) + this.unknownFields.hashCode();
                this.memoizedHashCode = hash2;
                return hash2;
            }

            public static DelayWeekCountDownDelete parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static DelayWeekCountDownDelete parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static DelayWeekCountDownDelete parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static DelayWeekCountDownDelete parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static DelayWeekCountDownDelete parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data);
            }

            public static DelayWeekCountDownDelete parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(data, extensionRegistry);
            }

            public static DelayWeekCountDownDelete parseFrom(InputStream input) throws IOException {
                return (DelayWeekCountDownDelete) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static DelayWeekCountDownDelete parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (DelayWeekCountDownDelete) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            public static DelayWeekCountDownDelete parseDelimitedFrom(InputStream input) throws IOException {
                return (DelayWeekCountDownDelete) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
            }

            public static DelayWeekCountDownDelete parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (DelayWeekCountDownDelete) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
            }

            public static DelayWeekCountDownDelete parseFrom(CodedInputStream input) throws IOException {
                return (DelayWeekCountDownDelete) GeneratedMessageV3.parseWithIOException(PARSER, input);
            }

            public static DelayWeekCountDownDelete parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (DelayWeekCountDownDelete) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
            }

            @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Builder newBuilderForType() {
                return newBuilder();
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.toBuilder();
            }

            public static Builder newBuilder(DelayWeekCountDownDelete prototype) {
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

            /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteInfoOuterClass$MaterialDeleteInfo$DelayWeekCountDownDelete$Builder.class */
            public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements DelayWeekCountDownDeleteOrBuilder {
                private int bitField0_;
                private MapField<Integer, Integer> deleteTimeNumMap_;
                private int configDelayWeek_;
                private int configCountDownTime_;

                /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
                    java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
                    	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                    	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                    	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                    	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                    	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
                    	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
                    	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
                    */
                /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDelete.Builder.internalGetMapField(int):com.google.protobuf.MapField
                    jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                    	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                    	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                    	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                    	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                    	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                    	... 8 more
                    */
                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                protected com.google.protobuf.MapField internalGetMapField(int r5) {
                    /*
                        r4 = this;
                        r0 = r5
                        switch(r0) {
                            case 1: goto L_0x0014;
                            default: goto L_0x0019;
                        }
                        r0 = r4
                        com.google.protobuf.MapField r0 = r0.internalGetDeleteTimeNumMap()
                        return r0
                        java.lang.RuntimeException r0 = new java.lang.RuntimeException
                        r1 = r0
                        r2 = r5
                        // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                        r1.<init>(r2)
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDelete.Builder.internalGetMapField(int):com.google.protobuf.MapField");
                }

                /*  JADX ERROR: Dependency scan failed at insn: 0x001E: INVOKE_CUSTOM r0
                    java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
                    	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                    	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                    	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                    	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                    	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
                    	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
                    	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
                    	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
                    */
                /*  JADX ERROR: Failed to decode insn: 0x001E: INVOKE_CUSTOM r2, method: emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDelete.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField
                    jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                    	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                    	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                    	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                    	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                    	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                    	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                    	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                    	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                    	... 8 more
                    */
                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                protected com.google.protobuf.MapField internalGetMutableMapField(int r5) {
                    /*
                        r4 = this;
                        r0 = r5
                        switch(r0) {
                            case 1: goto L_0x0014;
                            default: goto L_0x0019;
                        }
                        r0 = r4
                        com.google.protobuf.MapField r0 = r0.internalGetMutableDeleteTimeNumMap()
                        return r0
                        java.lang.RuntimeException r0 = new java.lang.RuntimeException
                        r1 = r0
                        r2 = r5
                        // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Invalid map field number: ]}
                        r1.<init>(r2)
                        throw r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDelete.Builder.internalGetMutableMapField(int):com.google.protobuf.MapField");
                }

                public static final Descriptors.Descriptor getDescriptor() {
                    return MaterialDeleteInfoOuterClass.f763xbc57e159;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder
                protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                    return MaterialDeleteInfoOuterClass.f764x4a209ed7.ensureFieldAccessorsInitialized(DelayWeekCountDownDelete.class, Builder.class);
                }

                private Builder() {
                    maybeForceBuilderInitialization();
                }

                private Builder(GeneratedMessageV3.BuilderParent parent) {
                    super(parent);
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                    if (DelayWeekCountDownDelete.alwaysUseFieldBuilders) {
                    }
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public Builder clear() {
                    clear();
                    internalGetMutableDeleteTimeNumMap().clear();
                    this.configDelayWeek_ = 0;
                    this.configCountDownTime_ = 0;
                    return this;
                }

                @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
                public Descriptors.Descriptor getDescriptorForType() {
                    return MaterialDeleteInfoOuterClass.f763xbc57e159;
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
                public DelayWeekCountDownDelete getDefaultInstanceForType() {
                    return DelayWeekCountDownDelete.getDefaultInstance();
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public DelayWeekCountDownDelete build() {
                    DelayWeekCountDownDelete result = buildPartial();
                    if (result.isInitialized()) {
                        return result;
                    }
                    throw newUninitializedMessageException((Message) result);
                }

                @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
                public DelayWeekCountDownDelete buildPartial() {
                    DelayWeekCountDownDelete result = new DelayWeekCountDownDelete(this);
                    int i = this.bitField0_;
                    result.deleteTimeNumMap_ = internalGetDeleteTimeNumMap();
                    result.deleteTimeNumMap_.makeImmutable();
                    result.configDelayWeek_ = this.configDelayWeek_;
                    result.configCountDownTime_ = this.configCountDownTime_;
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
                    if (other instanceof DelayWeekCountDownDelete) {
                        return mergeFrom((DelayWeekCountDownDelete) other);
                    }
                    mergeFrom(other);
                    return this;
                }

                public Builder mergeFrom(DelayWeekCountDownDelete other) {
                    if (other == DelayWeekCountDownDelete.getDefaultInstance()) {
                        return this;
                    }
                    internalGetMutableDeleteTimeNumMap().mergeFrom(other.internalGetDeleteTimeNumMap());
                    if (other.getConfigDelayWeek() != 0) {
                        setConfigDelayWeek(other.getConfigDelayWeek());
                    }
                    if (other.getConfigCountDownTime() != 0) {
                        setConfigCountDownTime(other.getConfigCountDownTime());
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
                    DelayWeekCountDownDelete parsedMessage = null;
                    try {
                        try {
                            parsedMessage = DelayWeekCountDownDelete.PARSER.parsePartialFrom(input, extensionRegistry);
                            if (parsedMessage != null) {
                                mergeFrom(parsedMessage);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e) {
                            parsedMessage = (DelayWeekCountDownDelete) e.getUnfinishedMessage();
                            throw e.unwrapIOException();
                        }
                    } catch (Throwable th) {
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        throw th;
                    }
                }

                private MapField<Integer, Integer> internalGetDeleteTimeNumMap() {
                    if (this.deleteTimeNumMap_ == null) {
                        return MapField.emptyMapField(DeleteTimeNumMapDefaultEntryHolder.defaultEntry);
                    }
                    return this.deleteTimeNumMap_;
                }

                private MapField<Integer, Integer> internalGetMutableDeleteTimeNumMap() {
                    onChanged();
                    if (this.deleteTimeNumMap_ == null) {
                        this.deleteTimeNumMap_ = MapField.newMapField(DeleteTimeNumMapDefaultEntryHolder.defaultEntry);
                    }
                    if (!this.deleteTimeNumMap_.isMutable()) {
                        this.deleteTimeNumMap_ = this.deleteTimeNumMap_.copy();
                    }
                    return this.deleteTimeNumMap_;
                }

                @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDeleteOrBuilder
                public int getDeleteTimeNumMapCount() {
                    return internalGetDeleteTimeNumMap().getMap().size();
                }

                @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDeleteOrBuilder
                public boolean containsDeleteTimeNumMap(int key) {
                    return internalGetDeleteTimeNumMap().getMap().containsKey(Integer.valueOf(key));
                }

                @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDeleteOrBuilder
                @Deprecated
                public Map<Integer, Integer> getDeleteTimeNumMap() {
                    return getDeleteTimeNumMapMap();
                }

                @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDeleteOrBuilder
                public Map<Integer, Integer> getDeleteTimeNumMapMap() {
                    return internalGetDeleteTimeNumMap().getMap();
                }

                @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDeleteOrBuilder
                public int getDeleteTimeNumMapOrDefault(int key, int defaultValue) {
                    Map<Integer, Integer> map = internalGetDeleteTimeNumMap().getMap();
                    return map.containsKey(Integer.valueOf(key)) ? map.get(Integer.valueOf(key)).intValue() : defaultValue;
                }

                @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDeleteOrBuilder
                public int getDeleteTimeNumMapOrThrow(int key) {
                    Map<Integer, Integer> map = internalGetDeleteTimeNumMap().getMap();
                    if (map.containsKey(Integer.valueOf(key))) {
                        return map.get(Integer.valueOf(key)).intValue();
                    }
                    throw new IllegalArgumentException();
                }

                public Builder clearDeleteTimeNumMap() {
                    internalGetMutableDeleteTimeNumMap().getMutableMap().clear();
                    return this;
                }

                public Builder removeDeleteTimeNumMap(int key) {
                    internalGetMutableDeleteTimeNumMap().getMutableMap().remove(Integer.valueOf(key));
                    return this;
                }

                @Deprecated
                public Map<Integer, Integer> getMutableDeleteTimeNumMap() {
                    return internalGetMutableDeleteTimeNumMap().getMutableMap();
                }

                public Builder putDeleteTimeNumMap(int key, int value) {
                    internalGetMutableDeleteTimeNumMap().getMutableMap().put(Integer.valueOf(key), Integer.valueOf(value));
                    return this;
                }

                public Builder putAllDeleteTimeNumMap(Map<Integer, Integer> values) {
                    internalGetMutableDeleteTimeNumMap().getMutableMap().putAll(values);
                    return this;
                }

                @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDeleteOrBuilder
                public int getConfigDelayWeek() {
                    return this.configDelayWeek_;
                }

                public Builder setConfigDelayWeek(int value) {
                    this.configDelayWeek_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearConfigDelayWeek() {
                    this.configDelayWeek_ = 0;
                    onChanged();
                    return this;
                }

                @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfo.DelayWeekCountDownDeleteOrBuilder
                public int getConfigCountDownTime() {
                    return this.configCountDownTime_;
                }

                public Builder setConfigCountDownTime(int value) {
                    this.configCountDownTime_ = value;
                    onChanged();
                    return this;
                }

                public Builder clearConfigCountDownTime() {
                    this.configCountDownTime_ = 0;
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

            public static DelayWeekCountDownDelete getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<DelayWeekCountDownDelete> parser() {
                return PARSER;
            }

            @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
            public Parser<DelayWeekCountDownDelete> getParserForType() {
                return PARSER;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public DelayWeekCountDownDelete getDefaultInstanceForType() {
                return DEFAULT_INSTANCE;
            }
        }

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteInfoOuterClass$MaterialDeleteInfo$DeleteInfoCase.class */
        public enum DeleteInfoCase implements Internal.EnumLite, AbstractMessageLite.InternalOneOfEnum {
            COUNT_DOWN_DELETE(2),
            DATE_DELETE(3),
            DELAY_WEEK_COUNT_DOWN_DELETE(4),
            DELETEINFO_NOT_SET(0);
            
            private final int value;

            DeleteInfoCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static DeleteInfoCase valueOf(int value) {
                return forNumber(value);
            }

            public static DeleteInfoCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return DELETEINFO_NOT_SET;
                    case 1:
                    default:
                        return null;
                    case 2:
                        return COUNT_DOWN_DELETE;
                    case 3:
                        return DATE_DELETE;
                    case 4:
                        return DELAY_WEEK_COUNT_DOWN_DELETE;
                }
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public int getNumber() {
                return this.value;
            }
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
        public DeleteInfoCase getDeleteInfoCase() {
            return DeleteInfoCase.forNumber(this.deleteInfoCase_);
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
        public boolean getHasDeleteConfig() {
            return this.hasDeleteConfig_;
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
        public boolean hasCountDownDelete() {
            return this.deleteInfoCase_ == 2;
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
        public CountDownDelete getCountDownDelete() {
            if (this.deleteInfoCase_ == 2) {
                return (CountDownDelete) this.deleteInfo_;
            }
            return CountDownDelete.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
        public CountDownDeleteOrBuilder getCountDownDeleteOrBuilder() {
            if (this.deleteInfoCase_ == 2) {
                return (CountDownDelete) this.deleteInfo_;
            }
            return CountDownDelete.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
        public boolean hasDateDelete() {
            return this.deleteInfoCase_ == 3;
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
        public DateTimeDelete getDateDelete() {
            if (this.deleteInfoCase_ == 3) {
                return (DateTimeDelete) this.deleteInfo_;
            }
            return DateTimeDelete.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
        public DateTimeDeleteOrBuilder getDateDeleteOrBuilder() {
            if (this.deleteInfoCase_ == 3) {
                return (DateTimeDelete) this.deleteInfo_;
            }
            return DateTimeDelete.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
        public boolean hasDelayWeekCountDownDelete() {
            return this.deleteInfoCase_ == 4;
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
        public DelayWeekCountDownDelete getDelayWeekCountDownDelete() {
            if (this.deleteInfoCase_ == 4) {
                return (DelayWeekCountDownDelete) this.deleteInfo_;
            }
            return DelayWeekCountDownDelete.getDefaultInstance();
        }

        @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
        public DelayWeekCountDownDeleteOrBuilder getDelayWeekCountDownDeleteOrBuilder() {
            if (this.deleteInfoCase_ == 4) {
                return (DelayWeekCountDownDelete) this.deleteInfo_;
            }
            return DelayWeekCountDownDelete.getDefaultInstance();
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
            if (this.hasDeleteConfig_) {
                output.writeBool(1, this.hasDeleteConfig_);
            }
            if (this.deleteInfoCase_ == 2) {
                output.writeMessage(2, (CountDownDelete) this.deleteInfo_);
            }
            if (this.deleteInfoCase_ == 3) {
                output.writeMessage(3, (DateTimeDelete) this.deleteInfo_);
            }
            if (this.deleteInfoCase_ == 4) {
                output.writeMessage(4, (DelayWeekCountDownDelete) this.deleteInfo_);
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
            if (this.hasDeleteConfig_) {
                size2 = 0 + CodedOutputStream.computeBoolSize(1, this.hasDeleteConfig_);
            }
            if (this.deleteInfoCase_ == 2) {
                size2 += CodedOutputStream.computeMessageSize(2, (CountDownDelete) this.deleteInfo_);
            }
            if (this.deleteInfoCase_ == 3) {
                size2 += CodedOutputStream.computeMessageSize(3, (DateTimeDelete) this.deleteInfo_);
            }
            if (this.deleteInfoCase_ == 4) {
                size2 += CodedOutputStream.computeMessageSize(4, (DelayWeekCountDownDelete) this.deleteInfo_);
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
            if (!(obj instanceof MaterialDeleteInfo)) {
                return equals(obj);
            }
            MaterialDeleteInfo other = (MaterialDeleteInfo) obj;
            if (getHasDeleteConfig() != other.getHasDeleteConfig() || !getDeleteInfoCase().equals(other.getDeleteInfoCase())) {
                return false;
            }
            switch (this.deleteInfoCase_) {
                case 2:
                    if (!getCountDownDelete().equals(other.getCountDownDelete())) {
                        return false;
                    }
                    break;
                case 3:
                    if (!getDateDelete().equals(other.getDateDelete())) {
                        return false;
                    }
                    break;
                case 4:
                    if (!getDelayWeekCountDownDelete().equals(other.getDelayWeekCountDownDelete())) {
                        return false;
                    }
                    break;
            }
            return this.unknownFields.equals(other.unknownFields);
        }

        @Override // com.google.protobuf.AbstractMessage, com.google.protobuf.Message
        public int hashCode() {
            if (this.memoizedHashCode != 0) {
                return this.memoizedHashCode;
            }
            int hash = (53 * ((37 * ((19 * 41) + getDescriptor().hashCode())) + 1)) + Internal.hashBoolean(getHasDeleteConfig());
            switch (this.deleteInfoCase_) {
                case 2:
                    hash = (53 * ((37 * hash) + 2)) + getCountDownDelete().hashCode();
                    break;
                case 3:
                    hash = (53 * ((37 * hash) + 3)) + getDateDelete().hashCode();
                    break;
                case 4:
                    hash = (53 * ((37 * hash) + 4)) + getDelayWeekCountDownDelete().hashCode();
                    break;
            }
            int hash2 = (29 * hash) + this.unknownFields.hashCode();
            this.memoizedHashCode = hash2;
            return hash2;
        }

        public static MaterialDeleteInfo parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MaterialDeleteInfo parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MaterialDeleteInfo parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MaterialDeleteInfo parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MaterialDeleteInfo parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data);
        }

        public static MaterialDeleteInfo parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(data, extensionRegistry);
        }

        public static MaterialDeleteInfo parseFrom(InputStream input) throws IOException {
            return (MaterialDeleteInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MaterialDeleteInfo parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MaterialDeleteInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        public static MaterialDeleteInfo parseDelimitedFrom(InputStream input) throws IOException {
            return (MaterialDeleteInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
        }

        public static MaterialDeleteInfo parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MaterialDeleteInfo) GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input, extensionRegistry);
        }

        public static MaterialDeleteInfo parseFrom(CodedInputStream input) throws IOException {
            return (MaterialDeleteInfo) GeneratedMessageV3.parseWithIOException(PARSER, input);
        }

        public static MaterialDeleteInfo parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (MaterialDeleteInfo) GeneratedMessageV3.parseWithIOException(PARSER, input, extensionRegistry);
        }

        @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Builder newBuilderForType() {
            return newBuilder();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.toBuilder();
        }

        public static Builder newBuilder(MaterialDeleteInfo prototype) {
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

        /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/MaterialDeleteInfoOuterClass$MaterialDeleteInfo$Builder.class */
        public static final class Builder extends GeneratedMessageV3.Builder<Builder> implements MaterialDeleteInfoOrBuilder {
            private int deleteInfoCase_ = 0;
            private Object deleteInfo_;
            private boolean hasDeleteConfig_;
            private SingleFieldBuilderV3<CountDownDelete, CountDownDelete.Builder, CountDownDeleteOrBuilder> countDownDeleteBuilder_;
            private SingleFieldBuilderV3<DateTimeDelete, DateTimeDelete.Builder, DateTimeDeleteOrBuilder> dateDeleteBuilder_;
            private SingleFieldBuilderV3<DelayWeekCountDownDelete, DelayWeekCountDownDelete.Builder, DelayWeekCountDownDeleteOrBuilder> delayWeekCountDownDeleteBuilder_;

            public static final Descriptors.Descriptor getDescriptor() {
                return MaterialDeleteInfoOuterClass.internal_static_MaterialDeleteInfo_descriptor;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder
            protected GeneratedMessageV3.FieldAccessorTable internalGetFieldAccessorTable() {
                return MaterialDeleteInfoOuterClass.internal_static_MaterialDeleteInfo_fieldAccessorTable.ensureFieldAccessorsInitialized(MaterialDeleteInfo.class, Builder.class);
            }

            private Builder() {
                maybeForceBuilderInitialization();
            }

            private Builder(GeneratedMessageV3.BuilderParent parent) {
                super(parent);
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
                if (MaterialDeleteInfo.alwaysUseFieldBuilders) {
                }
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public Builder clear() {
                clear();
                this.hasDeleteConfig_ = false;
                this.deleteInfoCase_ = 0;
                this.deleteInfo_ = null;
                return this;
            }

            @Override // com.google.protobuf.GeneratedMessageV3.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
            public Descriptors.Descriptor getDescriptorForType() {
                return MaterialDeleteInfoOuterClass.internal_static_MaterialDeleteInfo_descriptor;
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
            public MaterialDeleteInfo getDefaultInstanceForType() {
                return MaterialDeleteInfo.getDefaultInstance();
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MaterialDeleteInfo build() {
                MaterialDeleteInfo result = buildPartial();
                if (result.isInitialized()) {
                    return result;
                }
                throw newUninitializedMessageException((Message) result);
            }

            @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
            public MaterialDeleteInfo buildPartial() {
                MaterialDeleteInfo result = new MaterialDeleteInfo(this);
                result.hasDeleteConfig_ = this.hasDeleteConfig_;
                if (this.deleteInfoCase_ == 2) {
                    if (this.countDownDeleteBuilder_ == null) {
                        result.deleteInfo_ = this.deleteInfo_;
                    } else {
                        result.deleteInfo_ = this.countDownDeleteBuilder_.build();
                    }
                }
                if (this.deleteInfoCase_ == 3) {
                    if (this.dateDeleteBuilder_ == null) {
                        result.deleteInfo_ = this.deleteInfo_;
                    } else {
                        result.deleteInfo_ = this.dateDeleteBuilder_.build();
                    }
                }
                if (this.deleteInfoCase_ == 4) {
                    if (this.delayWeekCountDownDeleteBuilder_ == null) {
                        result.deleteInfo_ = this.deleteInfo_;
                    } else {
                        result.deleteInfo_ = this.delayWeekCountDownDeleteBuilder_.build();
                    }
                }
                result.deleteInfoCase_ = this.deleteInfoCase_;
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
                if (other instanceof MaterialDeleteInfo) {
                    return mergeFrom((MaterialDeleteInfo) other);
                }
                mergeFrom(other);
                return this;
            }

            public Builder mergeFrom(MaterialDeleteInfo other) {
                if (other == MaterialDeleteInfo.getDefaultInstance()) {
                    return this;
                }
                if (other.getHasDeleteConfig()) {
                    setHasDeleteConfig(other.getHasDeleteConfig());
                }
                switch (other.getDeleteInfoCase()) {
                    case COUNT_DOWN_DELETE:
                        mergeCountDownDelete(other.getCountDownDelete());
                        break;
                    case DATE_DELETE:
                        mergeDateDelete(other.getDateDelete());
                        break;
                    case DELAY_WEEK_COUNT_DOWN_DELETE:
                        mergeDelayWeekCountDownDelete(other.getDelayWeekCountDownDelete());
                        break;
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
                MaterialDeleteInfo parsedMessage = null;
                try {
                    try {
                        parsedMessage = MaterialDeleteInfo.PARSER.parsePartialFrom(input, extensionRegistry);
                        if (parsedMessage != null) {
                            mergeFrom(parsedMessage);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e) {
                        parsedMessage = (MaterialDeleteInfo) e.getUnfinishedMessage();
                        throw e.unwrapIOException();
                    }
                } catch (Throwable th) {
                    if (parsedMessage != null) {
                        mergeFrom(parsedMessage);
                    }
                    throw th;
                }
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
            public DeleteInfoCase getDeleteInfoCase() {
                return DeleteInfoCase.forNumber(this.deleteInfoCase_);
            }

            public Builder clearDeleteInfo() {
                this.deleteInfoCase_ = 0;
                this.deleteInfo_ = null;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
            public boolean getHasDeleteConfig() {
                return this.hasDeleteConfig_;
            }

            public Builder setHasDeleteConfig(boolean value) {
                this.hasDeleteConfig_ = value;
                onChanged();
                return this;
            }

            public Builder clearHasDeleteConfig() {
                this.hasDeleteConfig_ = false;
                onChanged();
                return this;
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
            public boolean hasCountDownDelete() {
                return this.deleteInfoCase_ == 2;
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
            public CountDownDelete getCountDownDelete() {
                if (this.countDownDeleteBuilder_ == null) {
                    if (this.deleteInfoCase_ == 2) {
                        return (CountDownDelete) this.deleteInfo_;
                    }
                    return CountDownDelete.getDefaultInstance();
                } else if (this.deleteInfoCase_ == 2) {
                    return this.countDownDeleteBuilder_.getMessage();
                } else {
                    return CountDownDelete.getDefaultInstance();
                }
            }

            public Builder setCountDownDelete(CountDownDelete value) {
                if (this.countDownDeleteBuilder_ != null) {
                    this.countDownDeleteBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.deleteInfo_ = value;
                    onChanged();
                }
                this.deleteInfoCase_ = 2;
                return this;
            }

            public Builder setCountDownDelete(CountDownDelete.Builder builderForValue) {
                if (this.countDownDeleteBuilder_ == null) {
                    this.deleteInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.countDownDeleteBuilder_.setMessage(builderForValue.build());
                }
                this.deleteInfoCase_ = 2;
                return this;
            }

            public Builder mergeCountDownDelete(CountDownDelete value) {
                if (this.countDownDeleteBuilder_ == null) {
                    if (this.deleteInfoCase_ != 2 || this.deleteInfo_ == CountDownDelete.getDefaultInstance()) {
                        this.deleteInfo_ = value;
                    } else {
                        this.deleteInfo_ = CountDownDelete.newBuilder((CountDownDelete) this.deleteInfo_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.deleteInfoCase_ == 2) {
                        this.countDownDeleteBuilder_.mergeFrom(value);
                    }
                    this.countDownDeleteBuilder_.setMessage(value);
                }
                this.deleteInfoCase_ = 2;
                return this;
            }

            public Builder clearCountDownDelete() {
                if (this.countDownDeleteBuilder_ != null) {
                    if (this.deleteInfoCase_ == 2) {
                        this.deleteInfoCase_ = 0;
                        this.deleteInfo_ = null;
                    }
                    this.countDownDeleteBuilder_.clear();
                } else if (this.deleteInfoCase_ == 2) {
                    this.deleteInfoCase_ = 0;
                    this.deleteInfo_ = null;
                    onChanged();
                }
                return this;
            }

            public CountDownDelete.Builder getCountDownDeleteBuilder() {
                return getCountDownDeleteFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
            public CountDownDeleteOrBuilder getCountDownDeleteOrBuilder() {
                if (this.deleteInfoCase_ == 2 && this.countDownDeleteBuilder_ != null) {
                    return this.countDownDeleteBuilder_.getMessageOrBuilder();
                }
                if (this.deleteInfoCase_ == 2) {
                    return (CountDownDelete) this.deleteInfo_;
                }
                return CountDownDelete.getDefaultInstance();
            }

            private SingleFieldBuilderV3<CountDownDelete, CountDownDelete.Builder, CountDownDeleteOrBuilder> getCountDownDeleteFieldBuilder() {
                if (this.countDownDeleteBuilder_ == null) {
                    if (this.deleteInfoCase_ != 2) {
                        this.deleteInfo_ = CountDownDelete.getDefaultInstance();
                    }
                    this.countDownDeleteBuilder_ = new SingleFieldBuilderV3<>((CountDownDelete) this.deleteInfo_, getParentForChildren(), isClean());
                    this.deleteInfo_ = null;
                }
                this.deleteInfoCase_ = 2;
                onChanged();
                return this.countDownDeleteBuilder_;
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
            public boolean hasDateDelete() {
                return this.deleteInfoCase_ == 3;
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
            public DateTimeDelete getDateDelete() {
                if (this.dateDeleteBuilder_ == null) {
                    if (this.deleteInfoCase_ == 3) {
                        return (DateTimeDelete) this.deleteInfo_;
                    }
                    return DateTimeDelete.getDefaultInstance();
                } else if (this.deleteInfoCase_ == 3) {
                    return this.dateDeleteBuilder_.getMessage();
                } else {
                    return DateTimeDelete.getDefaultInstance();
                }
            }

            public Builder setDateDelete(DateTimeDelete value) {
                if (this.dateDeleteBuilder_ != null) {
                    this.dateDeleteBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.deleteInfo_ = value;
                    onChanged();
                }
                this.deleteInfoCase_ = 3;
                return this;
            }

            public Builder setDateDelete(DateTimeDelete.Builder builderForValue) {
                if (this.dateDeleteBuilder_ == null) {
                    this.deleteInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.dateDeleteBuilder_.setMessage(builderForValue.build());
                }
                this.deleteInfoCase_ = 3;
                return this;
            }

            public Builder mergeDateDelete(DateTimeDelete value) {
                if (this.dateDeleteBuilder_ == null) {
                    if (this.deleteInfoCase_ != 3 || this.deleteInfo_ == DateTimeDelete.getDefaultInstance()) {
                        this.deleteInfo_ = value;
                    } else {
                        this.deleteInfo_ = DateTimeDelete.newBuilder((DateTimeDelete) this.deleteInfo_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.deleteInfoCase_ == 3) {
                        this.dateDeleteBuilder_.mergeFrom(value);
                    }
                    this.dateDeleteBuilder_.setMessage(value);
                }
                this.deleteInfoCase_ = 3;
                return this;
            }

            public Builder clearDateDelete() {
                if (this.dateDeleteBuilder_ != null) {
                    if (this.deleteInfoCase_ == 3) {
                        this.deleteInfoCase_ = 0;
                        this.deleteInfo_ = null;
                    }
                    this.dateDeleteBuilder_.clear();
                } else if (this.deleteInfoCase_ == 3) {
                    this.deleteInfoCase_ = 0;
                    this.deleteInfo_ = null;
                    onChanged();
                }
                return this;
            }

            public DateTimeDelete.Builder getDateDeleteBuilder() {
                return getDateDeleteFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
            public DateTimeDeleteOrBuilder getDateDeleteOrBuilder() {
                if (this.deleteInfoCase_ == 3 && this.dateDeleteBuilder_ != null) {
                    return this.dateDeleteBuilder_.getMessageOrBuilder();
                }
                if (this.deleteInfoCase_ == 3) {
                    return (DateTimeDelete) this.deleteInfo_;
                }
                return DateTimeDelete.getDefaultInstance();
            }

            private SingleFieldBuilderV3<DateTimeDelete, DateTimeDelete.Builder, DateTimeDeleteOrBuilder> getDateDeleteFieldBuilder() {
                if (this.dateDeleteBuilder_ == null) {
                    if (this.deleteInfoCase_ != 3) {
                        this.deleteInfo_ = DateTimeDelete.getDefaultInstance();
                    }
                    this.dateDeleteBuilder_ = new SingleFieldBuilderV3<>((DateTimeDelete) this.deleteInfo_, getParentForChildren(), isClean());
                    this.deleteInfo_ = null;
                }
                this.deleteInfoCase_ = 3;
                onChanged();
                return this.dateDeleteBuilder_;
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
            public boolean hasDelayWeekCountDownDelete() {
                return this.deleteInfoCase_ == 4;
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
            public DelayWeekCountDownDelete getDelayWeekCountDownDelete() {
                if (this.delayWeekCountDownDeleteBuilder_ == null) {
                    if (this.deleteInfoCase_ == 4) {
                        return (DelayWeekCountDownDelete) this.deleteInfo_;
                    }
                    return DelayWeekCountDownDelete.getDefaultInstance();
                } else if (this.deleteInfoCase_ == 4) {
                    return this.delayWeekCountDownDeleteBuilder_.getMessage();
                } else {
                    return DelayWeekCountDownDelete.getDefaultInstance();
                }
            }

            public Builder setDelayWeekCountDownDelete(DelayWeekCountDownDelete value) {
                if (this.delayWeekCountDownDeleteBuilder_ != null) {
                    this.delayWeekCountDownDeleteBuilder_.setMessage(value);
                } else if (value == null) {
                    throw new NullPointerException();
                } else {
                    this.deleteInfo_ = value;
                    onChanged();
                }
                this.deleteInfoCase_ = 4;
                return this;
            }

            public Builder setDelayWeekCountDownDelete(DelayWeekCountDownDelete.Builder builderForValue) {
                if (this.delayWeekCountDownDeleteBuilder_ == null) {
                    this.deleteInfo_ = builderForValue.build();
                    onChanged();
                } else {
                    this.delayWeekCountDownDeleteBuilder_.setMessage(builderForValue.build());
                }
                this.deleteInfoCase_ = 4;
                return this;
            }

            public Builder mergeDelayWeekCountDownDelete(DelayWeekCountDownDelete value) {
                if (this.delayWeekCountDownDeleteBuilder_ == null) {
                    if (this.deleteInfoCase_ != 4 || this.deleteInfo_ == DelayWeekCountDownDelete.getDefaultInstance()) {
                        this.deleteInfo_ = value;
                    } else {
                        this.deleteInfo_ = DelayWeekCountDownDelete.newBuilder((DelayWeekCountDownDelete) this.deleteInfo_).mergeFrom(value).buildPartial();
                    }
                    onChanged();
                } else {
                    if (this.deleteInfoCase_ == 4) {
                        this.delayWeekCountDownDeleteBuilder_.mergeFrom(value);
                    }
                    this.delayWeekCountDownDeleteBuilder_.setMessage(value);
                }
                this.deleteInfoCase_ = 4;
                return this;
            }

            public Builder clearDelayWeekCountDownDelete() {
                if (this.delayWeekCountDownDeleteBuilder_ != null) {
                    if (this.deleteInfoCase_ == 4) {
                        this.deleteInfoCase_ = 0;
                        this.deleteInfo_ = null;
                    }
                    this.delayWeekCountDownDeleteBuilder_.clear();
                } else if (this.deleteInfoCase_ == 4) {
                    this.deleteInfoCase_ = 0;
                    this.deleteInfo_ = null;
                    onChanged();
                }
                return this;
            }

            public DelayWeekCountDownDelete.Builder getDelayWeekCountDownDeleteBuilder() {
                return getDelayWeekCountDownDeleteFieldBuilder().getBuilder();
            }

            @Override // emu.grasscutter.net.proto.MaterialDeleteInfoOuterClass.MaterialDeleteInfoOrBuilder
            public DelayWeekCountDownDeleteOrBuilder getDelayWeekCountDownDeleteOrBuilder() {
                if (this.deleteInfoCase_ == 4 && this.delayWeekCountDownDeleteBuilder_ != null) {
                    return this.delayWeekCountDownDeleteBuilder_.getMessageOrBuilder();
                }
                if (this.deleteInfoCase_ == 4) {
                    return (DelayWeekCountDownDelete) this.deleteInfo_;
                }
                return DelayWeekCountDownDelete.getDefaultInstance();
            }

            private SingleFieldBuilderV3<DelayWeekCountDownDelete, DelayWeekCountDownDelete.Builder, DelayWeekCountDownDeleteOrBuilder> getDelayWeekCountDownDeleteFieldBuilder() {
                if (this.delayWeekCountDownDeleteBuilder_ == null) {
                    if (this.deleteInfoCase_ != 4) {
                        this.deleteInfo_ = DelayWeekCountDownDelete.getDefaultInstance();
                    }
                    this.delayWeekCountDownDeleteBuilder_ = new SingleFieldBuilderV3<>((DelayWeekCountDownDelete) this.deleteInfo_, getParentForChildren(), isClean());
                    this.deleteInfo_ = null;
                }
                this.deleteInfoCase_ = 4;
                onChanged();
                return this.delayWeekCountDownDeleteBuilder_;
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

        public static MaterialDeleteInfo getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<MaterialDeleteInfo> parser() {
            return PARSER;
        }

        @Override // com.google.protobuf.GeneratedMessageV3, com.google.protobuf.MessageLite, com.google.protobuf.Message
        public Parser<MaterialDeleteInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public MaterialDeleteInfo getDefaultInstanceForType() {
            return DEFAULT_INSTANCE;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
