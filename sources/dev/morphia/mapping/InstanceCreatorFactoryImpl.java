package dev.morphia.mapping;

import dev.morphia.mapping.codec.MorphiaInstanceCreator;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.experimental.ConstructorCreator;
import java.lang.reflect.Constructor;
import java.util.function.Supplier;

/* loaded from: grasscutter.jar:dev/morphia/mapping/InstanceCreatorFactoryImpl.class */
public class InstanceCreatorFactoryImpl implements InstanceCreatorFactory {
    private final EntityModel model;
    private Supplier<MorphiaInstanceCreator> creator;

    public InstanceCreatorFactoryImpl(EntityModel model) {
        this.model = model;
    }

    @Override // dev.morphia.mapping.InstanceCreatorFactory
    public MorphiaInstanceCreator create() {
        if (this.creator == null) {
            if (!this.model.getType().isInterface()) {
                try {
                    Constructor<?> constructor = this.model.getType().getDeclaredConstructor(new Class[0]);
                    this.creator = () -> {
                        return new NoArgCreator(constructor);
                    };
                } catch (NoSuchMethodException e) {
                    try {
                        Constructor<?> constructor2 = ConstructorCreator.getFullConstructor(this.model);
                        this.creator = ()
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0041: IPUT  
                              (wrap: java.util.function.Supplier<dev.morphia.mapping.codec.MorphiaInstanceCreator> : 0x003c: INVOKE_CUSTOM (r1v3 java.util.function.Supplier<dev.morphia.mapping.codec.MorphiaInstanceCreator> A[REMOVE]) = 
                              (r5v0 'this' dev.morphia.mapping.InstanceCreatorFactoryImpl A[D('this' dev.morphia.mapping.InstanceCreatorFactoryImpl), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                              (r0v13 'constructor2' java.lang.reflect.Constructor<?> A[D('constructor' java.lang.reflect.Constructor<?>), DONT_INLINE])
                            
                             handle type: INVOKE_DIRECT
                             lambda: java.util.function.Supplier.get():java.lang.Object
                             call insn: ?: INVOKE  (r1 I:dev.morphia.mapping.InstanceCreatorFactoryImpl), (r2 I:java.lang.reflect.Constructor) type: DIRECT call: dev.morphia.mapping.InstanceCreatorFactoryImpl.lambda$create$1(java.lang.reflect.Constructor):dev.morphia.mapping.codec.MorphiaInstanceCreator)
                              (r5v0 'this' dev.morphia.mapping.InstanceCreatorFactoryImpl A[D('this' dev.morphia.mapping.InstanceCreatorFactoryImpl), IMMUTABLE_TYPE, THIS])
                             dev.morphia.mapping.InstanceCreatorFactoryImpl.creator java.util.function.Supplier in method: dev.morphia.mapping.InstanceCreatorFactoryImpl.create():dev.morphia.mapping.codec.MorphiaInstanceCreator, file: grasscutter.jar:dev/morphia/mapping/InstanceCreatorFactoryImpl.class
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:314)
                            	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                            	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:393)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:325)
                            	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
                            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
                            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:462)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                            	... 40 more
                            */
                        /*
                            this = this;
                            r0 = r5
                            java.util.function.Supplier<dev.morphia.mapping.codec.MorphiaInstanceCreator> r0 = r0.creator
                            if (r0 != 0) goto L_0x006e
                            r0 = r5
                            dev.morphia.mapping.codec.pojo.EntityModel r0 = r0.model
                            java.lang.Class r0 = r0.getType()
                            boolean r0 = r0.isInterface()
                            if (r0 != 0) goto L_0x0055
                            r0 = r5
                            dev.morphia.mapping.codec.pojo.EntityModel r0 = r0.model     // Catch: NoSuchMethodException -> 0x0030
                            java.lang.Class r0 = r0.getType()     // Catch: NoSuchMethodException -> 0x0030
                            r1 = 0
                            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch: NoSuchMethodException -> 0x0030
                            java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r1)     // Catch: NoSuchMethodException -> 0x0030
                            r6 = r0
                            r0 = r5
                            r1 = r6
                            dev.morphia.mapping.codec.MorphiaInstanceCreator r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                                return lambda$create$0(r1);
                            }     // Catch: NoSuchMethodException -> 0x0030
                            r0.creator = r1     // Catch: NoSuchMethodException -> 0x0030
                            goto L_0x006e
                        L_0x0030:
                            r6 = move-exception
                            r0 = r5
                            dev.morphia.mapping.codec.pojo.EntityModel r0 = r0.model     // Catch: MappingException -> 0x0047
                            java.lang.reflect.Constructor r0 = dev.morphia.mapping.experimental.ConstructorCreator.getFullConstructor(r0)     // Catch: MappingException -> 0x0047
                            r7 = r0
                            r0 = r5
                            r1 = r5
                            r2 = r7
                            dev.morphia.mapping.codec.MorphiaInstanceCreator r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                                return r1.lambda$create$1(r2);
                            }     // Catch: MappingException -> 0x0047
                            r0.creator = r1     // Catch: MappingException -> 0x0047
                            goto L_0x0052
                        L_0x0047:
                            r7 = move-exception
                            r0 = r5
                            r1 = r5
                            dev.morphia.mapping.codec.MorphiaInstanceCreator r1 = () -> { // java.util.function.Supplier.get():java.lang.Object
                                return r1.lambda$create$2();
                            }
                            r0.creator = r1
                        L_0x0052:
                            goto L_0x006e
                        L_0x0055:
                            dev.morphia.mapping.MappingException r0 = new dev.morphia.mapping.MappingException
                            r1 = r0
                            r2 = r5
                            dev.morphia.mapping.codec.pojo.EntityModel r2 = r2.model
                            java.lang.Class r2 = r2.getType()
                            java.lang.String r2 = r2.getName()
                            r3 = 0
                            java.util.Locale[] r3 = new java.util.Locale[r3]
                            java.lang.String r2 = dev.morphia.sofia.Sofia.noSuitableConstructor(r2, r3)
                            r1.<init>(r2)
                            throw r0
                        L_0x006e:
                            r0 = r5
                            java.util.function.Supplier<dev.morphia.mapping.codec.MorphiaInstanceCreator> r0 = r0.creator
                            java.lang.Object r0 = r0.get()
                            dev.morphia.mapping.codec.MorphiaInstanceCreator r0 = (dev.morphia.mapping.codec.MorphiaInstanceCreator) r0
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.InstanceCreatorFactoryImpl.create():dev.morphia.mapping.codec.MorphiaInstanceCreator");
                    }
                }
