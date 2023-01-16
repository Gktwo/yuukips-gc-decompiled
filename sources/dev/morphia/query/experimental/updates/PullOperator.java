package dev.morphia.query.experimental.updates;

import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.internal.PathTarget;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.writer.DocumentWriter;
import dev.morphia.query.OperationTarget;
import dev.morphia.query.experimental.filters.Filter;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/updates/PullOperator.class */
public class PullOperator extends UpdateOperator {
    public PullOperator(String field, Filter filter) {
        super("$pull", field, filter);
    }

    @Override // dev.morphia.query.experimental.updates.UpdateOperator
    public OperationTarget toTarget(final PathTarget pathTarget) {
        return new OperationTarget(value(), pathTarget) { // from class: dev.morphia.query.experimental.updates.PullOperator.1
            @Override // dev.morphia.query.OperationTarget
            public Object encode(Mapper mapper) {
                DocumentWriter writer = new DocumentWriter(mapper);
                ExpressionHelper.document(writer, ()
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
                      (r0v0 'writer' dev.morphia.mapping.codec.writer.DocumentWriter A[D('writer' dev.morphia.mapping.codec.writer.DocumentWriter)])
                      (wrap: java.lang.Runnable : 0x000d: INVOKE_CUSTOM (r1v2 java.lang.Runnable A[REMOVE]) = 
                      (r5v0 'this' dev.morphia.query.experimental.updates.PullOperator$1 A[D('this' dev.morphia.query.experimental.updates.PullOperator$1), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                      (r6v0 'mapper' dev.morphia.mapping.Mapper A[D('mapper' dev.morphia.mapping.Mapper), DONT_INLINE])
                      (r0v0 'writer' dev.morphia.mapping.codec.writer.DocumentWriter A[D('writer' dev.morphia.mapping.codec.writer.DocumentWriter), DONT_INLINE])
                    
                     handle type: INVOKE_DIRECT
                     lambda: java.lang.Runnable.run():void
                     call insn: ?: INVOKE  
                      (r1 I:dev.morphia.query.experimental.updates.PullOperator$1)
                      (r2 I:dev.morphia.mapping.Mapper)
                      (r3 I:dev.morphia.mapping.codec.writer.DocumentWriter)
                     type: DIRECT call: dev.morphia.query.experimental.updates.PullOperator.1.lambda$encode$0(dev.morphia.mapping.Mapper, dev.morphia.mapping.codec.writer.DocumentWriter):void)
                     type: STATIC call: dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(org.bson.BsonWriter, java.lang.Runnable):void in method: dev.morphia.query.experimental.updates.PullOperator.1.encode(dev.morphia.mapping.Mapper):java.lang.Object, file: grasscutter.jar:dev/morphia/query/experimental/updates/PullOperator$1.class
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                    Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
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
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                    	... 15 more
                    */
                /*
                    this = this;
                    dev.morphia.mapping.codec.writer.DocumentWriter r0 = new dev.morphia.mapping.codec.writer.DocumentWriter
                    r1 = r0
                    r2 = r6
                    r1.<init>(r2)
                    r7 = r0
                    r0 = r7
                    r1 = r5
                    r2 = r6
                    r3 = r7
                    java.lang.Object r1 = () -> { // java.lang.Runnable.run():void
                        r1.lambda$encode$0(r2, r3);
                    }
                    dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(r0, r1)
                    r0 = r5
                    dev.morphia.internal.PathTarget r0 = r8
                    dev.morphia.mapping.codec.pojo.PropertyModel r0 = r0.getTarget()
                    r8 = r0
                    org.bson.Document r0 = new org.bson.Document
                    r1 = r0
                    r2 = r8
                    if (r2 == 0) goto L_0x002c
                    r2 = r8
                    java.lang.String r2 = r2.getMappedName()
                    goto L_0x0033
                L_0x002c:
                    r2 = r5
                    dev.morphia.query.experimental.updates.PullOperator r2 = dev.morphia.query.experimental.updates.PullOperator.this
                    java.lang.String r2 = r2.field()
                L_0x0033:
                    r3 = r7
                    org.bson.Document r3 = r3.getDocument()
                    r1.<init>(r2, r3)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: dev.morphia.query.experimental.updates.PullOperator.C13421.encode(dev.morphia.mapping.Mapper):java.lang.Object");
            }
        };
    }
}
