package emu.grasscutter.server.http.documentation;

import emu.grasscutter.command.CommandMap;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.utils.Language;
import java.util.ArrayList;
import java.util.List;
import p013io.javalin.http.ContentType;
import p013io.javalin.http.Context;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because "blocks" is null
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:894)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:367)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:119)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:49)
    */
/* loaded from: grasscutter.jar:emu/grasscutter/server/http/documentation/HandbookRequestHandler.class */
final class HandbookRequestHandler implements DocumentationHandler {
    private List<String> handbookHtmls;

    @Override // emu.grasscutter.server.http.documentation.DocumentationHandler
    public void handle(Context ctx) {
        int langIdx = Language.TextStrings.MAP_LANGUAGES.getOrDefault(Configuration.DOCUMENT_LANGUAGE, 0);
        if (this.handbookHtmls == null) {
            ctx.status(500);
            return;
        }
        ctx.contentType(ContentType.TEXT_HTML);
        ctx.result(this.handbookHtmls.get(langIdx));
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [it.unimi.dsi.fastutil.ints.IntSet] */
    /* JADX WARN: Type inference failed for: r0v28, types: [it.unimi.dsi.fastutil.ints.IntSet] */
    /* JADX WARN: Type inference failed for: r0v39, types: [it.unimi.dsi.fastutil.ints.IntSet] */
    /* JADX WARN: Type inference failed for: r0v50, types: [it.unimi.dsi.fastutil.ints.IntSet] */
    private List<String> generateHandbookHtmls(String template) {
        int NUM_LANGUAGES = Language.TextStrings.NUM_LANGUAGES;
        List<String> output = new ArrayList<>(NUM_LANGUAGES);
        List<Language> languages = Language.TextStrings.getLanguages();
        List<StringBuilder> sbs = new ArrayList<>(NUM_LANGUAGES);
        for (int langIdx = 0; langIdx < NUM_LANGUAGES; langIdx++) {
            sbs.add(new StringBuilder(""));
        }
        CommandMap.getInstance().getHandlersAsList().forEach(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x004c: INVOKE  
              (wrap: java.util.List<emu.grasscutter.command.CommandHandler> : 0x003f: INVOKE  (r0v7 java.util.List<emu.grasscutter.command.CommandHandler> A[REMOVE]) = 
              (wrap: emu.grasscutter.command.CommandMap : 0x003c: INVOKE  (r0v6 emu.grasscutter.command.CommandMap A[REMOVE]) =  type: STATIC call: emu.grasscutter.command.CommandMap.getInstance():emu.grasscutter.command.CommandMap)
             type: VIRTUAL call: emu.grasscutter.command.CommandMap.getHandlersAsList():java.util.List)
              (wrap: java.util.function.Consumer : 0x0047: INVOKE_CUSTOM (r1v4 java.util.function.Consumer A[REMOVE]) = 
              (r0v0 'NUM_LANGUAGES' int A[D('NUM_LANGUAGES' int), DONT_INLINE])
              (r0v3 'sbs' java.util.List<java.lang.StringBuilder> A[D('sbs' java.util.List<java.lang.StringBuilder>), DONT_INLINE])
              (r0v2 'languages' java.util.List<emu.grasscutter.utils.Language> A[D('languages' java.util.List<emu.grasscutter.utils.Language>), DONT_INLINE])
            
             handle type: INVOKE_STATIC
             lambda: java.util.function.Consumer.accept(java.lang.Object):void
             call insn: ?: INVOKE  (r1 I:int), (r2 I:java.util.List), (r3 I:java.util.List), (v3 emu.grasscutter.command.CommandHandler) type: STATIC call: emu.grasscutter.server.http.documentation.HandbookRequestHandler.lambda$generateHandbookHtmls$0(int, java.util.List, java.util.List, emu.grasscutter.command.CommandHandler):void)
             type: INTERFACE call: java.util.List.forEach(java.util.function.Consumer):void in method: emu.grasscutter.server.http.documentation.HandbookRequestHandler.generateHandbookHtmls(java.lang.String):java.util.List<java.lang.String>, file: grasscutter.jar:emu/grasscutter/server/http/documentation/HandbookRequestHandler.class
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
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:900)
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
        // Method dump skipped, instructions count: 788
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.http.documentation.HandbookRequestHandler.generateHandbookHtmls(java.lang.String):java.util.List");
    }
}
