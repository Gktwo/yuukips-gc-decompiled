package dev.morphia.annotations.builders;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Collation;
import com.mongodb.client.model.IndexOptions;
import com.mongodb.lang.Nullable;
import dev.morphia.annotations.Field;
import dev.morphia.annotations.Index;
import dev.morphia.annotations.Indexed;
import dev.morphia.annotations.Indexes;
import dev.morphia.annotations.Text;
import dev.morphia.internal.PathTarget;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.MappingException;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.sofia.Sofia;
import dev.morphia.utils.IndexType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:dev/morphia/annotations/builders/IndexHelper.class */
public final class IndexHelper {
    private static final Logger LOG = LoggerFactory.getLogger(IndexHelper.class);
    private final Mapper mapper;

    /*  JADX ERROR: Dependency scan failed at insn: 0x004B: INVOKE_CUSTOM r1
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
    /*  JADX ERROR: Failed to decode insn: 0x004B: INVOKE_CUSTOM r2, method: dev.morphia.annotations.builders.IndexHelper.calculateWeights(dev.morphia.annotations.Index, com.mongodb.client.model.IndexOptions):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Weight values only apply to text indexes: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Weight values only apply to text indexes: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private void calculateWeights(dev.morphia.annotations.Index r5, com.mongodb.client.model.IndexOptions r6) {
        /*
            r4 = this;
            org.bson.Document r0 = new org.bson.Document
            r1 = r0
            r1.<init>()
            r7 = r0
            r0 = r5
            dev.morphia.annotations.Field[] r0 = r0.fields()
            r8 = r0
            r0 = r8
            int r0 = r0.length
            r9 = r0
            r0 = 0
            r10 = r0
            r0 = r10
            r1 = r9
            if (r0 >= r1) goto L_0x0070
            r0 = r8
            r1 = r10
            r0 = r0[r1]
            r11 = r0
            r0 = r11
            int r0 = r0.weight()
            r1 = -1
            if (r0 == r1) goto L_0x006a
            r0 = r11
            dev.morphia.utils.IndexType r0 = r0.type()
            dev.morphia.utils.IndexType r1 = dev.morphia.utils.IndexType.TEXT
            if (r0 == r1) goto L_0x0054
            dev.morphia.mapping.MappingException r0 = new dev.morphia.mapping.MappingException
            r1 = r0
            r2 = r5
            dev.morphia.annotations.Field[] r2 = r2.fields()
            java.lang.String r2 = java.util.Arrays.toString(r2)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Weight values only apply to text indexes: ]}
            r1.<init>(r2)
            throw r0
            r0 = r7
            r1 = r11
            java.lang.String r1 = r1.value()
            r2 = r11
            int r2 = r2.weight()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r0 = r0.put(r1, r2)
            int r10 = r10 + 1
            goto L_0x0018
            r0 = r7
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x007d
            r0 = r6
            r1 = r7
            com.mongodb.client.model.IndexOptions r0 = r0.weights(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.annotations.builders.IndexHelper.calculateWeights(dev.morphia.annotations.Index, com.mongodb.client.model.IndexOptions):void");
    }

    public IndexHelper(Mapper mapper) {
        this.mapper = mapper;
    }

    private List<Index> collectFieldIndexes(EntityModel entityModel) {
        List<Index> list = (List) entityModel.getProperties(Indexed.class).stream().map(field -> {
            return convert((Indexed) field.getAnnotation(Indexed.class), field.getMappedName());
        }).collect(Collectors.toList());
        list.addAll((Collection) entityModel.getProperties(Text.class).stream().map(field -> {
            return convert((Text) field.getAnnotation(Text.class), field.getMappedName());
        }).collect(Collectors.toList()));
        return list;
    }

    private List<Index> collectIndexes(EntityModel entityModel, List<EntityModel> parentModels) {
        if (parentModels.contains(entityModel) || (entityModel.getEmbeddedAnnotation() != null && parentModels.isEmpty())) {
            return Collections.emptyList();
        }
        List<Index> indexes = collectTopLevelIndexes(entityModel);
        indexes.addAll(collectFieldIndexes(entityModel));
        return indexes;
    }

    private List<Index> collectTopLevelIndexes(EntityModel entityModel) {
        List<Index> list = new ArrayList<>();
        Indexes indexes = (Indexes) entityModel.getAnnotation(Indexes.class);
        if (indexes != null) {
            Index[] value = indexes.value();
            for (Index index : value) {
                List<Field> fields = new ArrayList<>();
                Field[] fields2 = index.fields();
                for (Field field : fields2) {
                    fields.add(new FieldBuilder().value(findField(entityModel, index.options(), field.value())).type(field.type()).weight(field.weight()));
                }
                list.add(replaceFields(index, fields));
            }
        }
        EntityModel superClass = entityModel.getSuperClass();
        if (superClass != null) {
            list.addAll(collectTopLevelIndexes(superClass));
        }
        return list;
    }

    private Index replaceFields(Index original, List<Field> list) {
        return new IndexBuilder(original).fields(list);
    }

    public Document calculateKeys(EntityModel entityModel, Index index) {
        String path;
        Document keys = new Document();
        Field[] fields = index.fields();
        for (Field field : fields) {
            try {
                path = findField(entityModel, index.options(), field.value());
            } catch (Exception e) {
                path = field.value();
                if (!index.options().disableValidation()) {
                    throw new MappingException(Sofia.invalidIndexPath(path, entityModel.getType().getName(), new Locale[0]));
                }
                LOG.warn(Sofia.invalidIndexPath(path, entityModel.getType().getName(), new Locale[0]));
            }
            keys.putAll(new Document(path, field.type().toIndexValue()));
        }
        return keys;
    }

    @Nullable
    public Index convert(@Nullable Indexed indexed, String nameToStore) {
        if (indexed == null) {
            return null;
        }
        return new IndexBuilder().options(indexed.options()).fields(Collections.singletonList(new FieldBuilder().value(nameToStore).type(IndexType.fromValue(indexed.value().toIndexValue()))));
    }

    @Nullable
    public Index convert(@Nullable Text text, String nameToStore) {
        if (text == null) {
            return null;
        }
        return new IndexBuilder().options(text.options()).fields(Collections.singletonList(new FieldBuilder().value(nameToStore).type(IndexType.TEXT).weight(text.value())));
    }

    public IndexOptions convert(dev.morphia.annotations.IndexOptions options) {
        IndexOptions indexOptions = new IndexOptions().background(options.background()).sparse(options.sparse()).unique(options.unique());
        if (!options.language().equals("")) {
            indexOptions.defaultLanguage(options.language());
        }
        if (!options.languageOverride().equals("")) {
            indexOptions.languageOverride(options.languageOverride());
        }
        if (!options.name().equals("")) {
            indexOptions.name(options.name());
        }
        if (options.expireAfterSeconds() != -1) {
            indexOptions.expireAfter(Long.valueOf((long) options.expireAfterSeconds()), TimeUnit.SECONDS);
        }
        if (!options.partialFilter().equals("")) {
            indexOptions.partialFilterExpression(Document.parse(options.partialFilter()));
        }
        if (!options.collation().locale().equals("")) {
            indexOptions.collation(convert(options.collation()));
        }
        return indexOptions;
    }

    public Collation convert(dev.morphia.annotations.Collation collation) {
        return Collation.builder().locale(collation.locale()).backwards(Boolean.valueOf(collation.backwards())).caseLevel(Boolean.valueOf(collation.caseLevel())).collationAlternate(collation.alternate()).collationCaseFirst(collation.caseFirst()).collationMaxVariable(collation.maxVariable()).collationStrength(collation.strength()).normalization(Boolean.valueOf(collation.normalization())).numericOrdering(Boolean.valueOf(collation.numericOrdering())).build();
    }

    public void createIndex(MongoCollection<?> collection, EntityModel model) {
        if (!(model.isInterface() || model.isAbstract())) {
            for (Index index : collectIndexes(model, Collections.emptyList())) {
                createIndex(collection, model, index);
            }
        }
    }

    public void createIndex(MongoCollection<?> collection, EntityModel entityModel, Index index) {
        Document keys = calculateKeys(entityModel, index);
        IndexOptions indexOptions = convert(index.options());
        calculateWeights(index, indexOptions);
        collection.createIndex(keys, indexOptions);
    }

    public String findField(EntityModel entityModel, dev.morphia.annotations.IndexOptions options, String path) {
        if (path.equals("$**")) {
            return path;
        }
        return new PathTarget(this.mapper, entityModel, path, !options.disableValidation()).translatedPath();
    }
}
