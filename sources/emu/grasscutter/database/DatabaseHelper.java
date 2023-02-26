package emu.grasscutter.database;

import com.mongodb.DBCollection;
import com.mongodb.client.result.DeleteResult;
import dev.morphia.Datastore;
import dev.morphia.DeleteOptions;
import dev.morphia.query.FindOptions;
import dev.morphia.query.Sort;
import dev.morphia.query.experimental.filters.Filters;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.Account;
import emu.grasscutter.game.activity.PlayerActivityData;
import emu.grasscutter.game.activity.musicgame.MusicGameBeatmap;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.battlepass.BattlePassManager;
import emu.grasscutter.game.dailytask.DailyTaskManager;
import emu.grasscutter.game.friends.Friendship;
import emu.grasscutter.game.gacha.GachaRecord;
import emu.grasscutter.game.home.GameHome;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.mail.Mail;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.quest.GameMainQuest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.quartz.jobs.p027ee.mail.SendMailJob;

/* loaded from: grasscutter.jar:emu/grasscutter/database/DatabaseHelper.class */
public final class DatabaseHelper {
    /*  JADX ERROR: Dependency scan failed at insn: 0x0011: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0062: INVOKE_CUSTOM r-6
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
    /*  JADX ERROR: Failed to decode insn: 0x0011: INVOKE_CUSTOM r1, method: emu.grasscutter.database.DatabaseHelper.createAccountWithUid(java.lang.String, int):emu.grasscutter.game.Account
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, (createAccountWithUid) found reservedId: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, (createAccountWithUid) found reservedId: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0062: INVOKE_CUSTOM r1, method: emu.grasscutter.database.DatabaseHelper.createAccountWithUid(java.lang.String, int):emu.grasscutter.game.Account
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, (createAccountWithUid) save: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, (createAccountWithUid) save: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public static emu.grasscutter.game.Account createAccountWithUid(java.lang.String r3, int r4) {
        /*
            r0 = r3
            boolean r0 = checkIfAccountExists(r0)
            if (r0 == 0) goto L_0x0009
            r0 = 0
            return r0
            r0 = r4
            if (r0 <= 0) goto L_0x002b
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r4
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, (createAccountWithUid) found reservedId: ]}
            r0.warn(r1)
            r0 = r4
            boolean r0 = checkIfPlayerExists(r0)
            if (r0 == 0) goto L_0x0022
            r0 = 0
            return r0
            r0 = r4
            boolean r0 = checkIfAccountReservedPlayerIdExists(r0)
            if (r0 == 0) goto L_0x002b
            r0 = 0
            return r0
            int r0 = getNextAccountId()
            r5 = r0
            r0 = r5
            r1 = 99
            if (r0 != r1) goto L_0x0037
            r0 = 0
            return r0
            r0 = r5
            boolean r0 = checkIfPlayerAccountExists(r0)
            if (r0 == 0) goto L_0x0040
            r0 = 0
            return r0
            emu.grasscutter.game.Account r0 = new emu.grasscutter.game.Account
            r1 = r0
            r1.<init>()
            r6 = r0
            r0 = r6
            r1 = r3
            r0.setUsername(r1)
            r0 = r6
            r1 = r5
            java.lang.String r1 = java.lang.Integer.toString(r1)
            r0.setId(r1)
            r0 = r4
            if (r0 <= 0) goto L_0x005e
            r0 = r6
            r1 = r4
            r0.setReservedPlayerUid(r1)
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r3
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, (createAccountWithUid) save: ]}
            r0.info(r1)
            r0 = r6
            saveAccount(r0)
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.database.DatabaseHelper.createAccountWithUid(java.lang.String, int):emu.grasscutter.game.Account");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0011: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0027: INVOKE_CUSTOM r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0011: INVOKE_CUSTOM r1, method: emu.grasscutter.database.DatabaseHelper.getNextPlayerId(int):int
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, (getNextPlayerId) found reservedId: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, (getNextPlayerId) found reservedId: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0027: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.database.DatabaseHelper.getNextPlayerId(int):int
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, (getNextPlayerId) Next:  (RES: )]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, (getNextPlayerId) Next:  (RES: )]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public static synchronized int getNextPlayerId(int r4) {
        /*
            r0 = r4
            if (r0 <= 0) goto L_0x001c
            r0 = r4
            boolean r0 = checkIfPlayerExists(r0)
            if (r0 != 0) goto L_0x001c
            r0 = r4
            r5 = r0
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r5
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, (getNextPlayerId) found reservedId: ]}
            r0.warn(r1)
            goto L_0x0037
            java.lang.Class<emu.grasscutter.game.player.Player> r0 = emu.grasscutter.game.player.Player.class
            int r0 = emu.grasscutter.database.DatabaseManager.getNextId(r0)
            r5 = r0
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r5
            r2 = r4
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, (getNextPlayerId) Next:  (RES: )]}
            r0.warn(r1)
            r0 = r5
            r1 = r4
            boolean r0 = checkIfAccountReservedPlayerIdExists(r0, r1)
            if (r0 != 0) goto L_0x001c
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.database.DatabaseHelper.getNextPlayerId(int):int");
    }

    public static Account createAccount(String username) {
        return createAccountWithUid(username, 0);
    }

    public static void saveAccount(Account account) {
        DatabaseManager.getAccountDatastore().save((Datastore) account);
    }

    public static boolean checkIfAccountReservedPlayerIdExists(int uid) {
        return uid != 0 && DatabaseManager.getAccountDatastore().find(Account.class).filter(Filters.m1223eq("reservedPlayerId", Integer.valueOf(uid))).count() > 0;
    }

    public static boolean checkIfAccountReservedPlayerIdExists(int uid, int rev) {
        if (uid == 0) {
            return true;
        }
        if ((DatabaseManager.getAccountDatastore().find(Account.class).filter(Filters.m1223eq("reservedPlayerId", Integer.valueOf(uid))).count() > 0) || checkIfPlayerExists(uid)) {
            return true;
        }
        return false;
    }

    public static Account getAccountByName(String username) {
        return (Account) DatabaseManager.getAccountDatastore().find(Account.class).filter(Filters.m1223eq(SendMailJob.PROP_USERNAME, username)).first();
    }

    public static Account getAccountByToken(String token) {
        if (token == null) {
            return null;
        }
        return (Account) DatabaseManager.getAccountDatastore().find(Account.class).filter(Filters.m1223eq("token", token)).first();
    }

    public static Account getAccountBySessionKey(String sessionKey) {
        if (sessionKey == null) {
            return null;
        }
        return (Account) DatabaseManager.getAccountDatastore().find(Account.class).filter(Filters.m1223eq("sessionKey", sessionKey)).first();
    }

    public static Account getAccountById(String uid) {
        return (Account) DatabaseManager.getAccountDatastore().find(Account.class).filter(Filters.m1223eq(DBCollection.ID_FIELD_NAME, uid)).first();
    }

    public static Account getAccountByReservedPlayerId(int playerId) {
        return (Account) DatabaseManager.getAccountDatastore().find(Account.class).filter(Filters.m1223eq("reservedPlayerId", Integer.valueOf(playerId))).first();
    }

    public static boolean checkIfAccountExists(String name) {
        return DatabaseManager.getAccountDatastore().find(Account.class).filter(Filters.m1223eq(SendMailJob.PROP_USERNAME, name)).count() > 0;
    }

    public static boolean checkIfAccountExists(int reservedUid) {
        return DatabaseManager.getAccountDatastore().find(Account.class).filter(Filters.m1223eq("reservedPlayerId", Integer.valueOf(reservedUid))).count() > 0;
    }

    public static List<Account> getAccountAll() {
        return DatabaseManager.getAccountDatastore().find(Account.class).stream().toList();
    }

    public static void deletePlayer(Player player) {
        int uid = player.getUid();
        Player player_isonline = Grasscutter.getGameServer().getPlayerOnlineByUid(uid);
        if (player_isonline != null) {
            player_isonline.getSession().setKick("Delete Player...");
        }
        DatabaseManager.getGameDatabase().getCollection("activities").deleteMany(com.mongodb.client.model.Filters.m1277eq("uid", Integer.valueOf(uid)));
        DatabaseManager.getGameDatabase().getCollection("dailytasks").deleteMany(com.mongodb.client.model.Filters.m1277eq("ownerUid", Integer.valueOf(uid)));
        DatabaseManager.getGameDatabase().getCollection("homes").deleteMany(com.mongodb.client.model.Filters.m1277eq("ownerUid", Integer.valueOf(uid)));
        DatabaseManager.getGameDatabase().getCollection("mail").deleteMany(com.mongodb.client.model.Filters.m1277eq("ownerUid", Integer.valueOf(uid)));
        DatabaseManager.getGameDatabase().getCollection("avatars").deleteMany(com.mongodb.client.model.Filters.m1277eq("ownerId", Integer.valueOf(uid)));
        DatabaseManager.getGameDatabase().getCollection("gachas").deleteMany(com.mongodb.client.model.Filters.m1277eq("ownerId", Integer.valueOf(uid)));
        DatabaseManager.getGameDatabase().getCollection("items").deleteMany(com.mongodb.client.model.Filters.m1277eq("ownerId", Integer.valueOf(uid)));
        DatabaseManager.getGameDatabase().getCollection("quests").deleteMany(com.mongodb.client.model.Filters.m1277eq("ownerUid", Integer.valueOf(uid)));
        DatabaseManager.getGameDatabase().getCollection("battlepass").deleteMany(com.mongodb.client.model.Filters.m1277eq("ownerUid", Integer.valueOf(uid)));
        DatabaseManager.getGameDatabase().getCollection("friendships").deleteMany(com.mongodb.client.model.Filters.m1277eq("ownerId", Integer.valueOf(uid)));
        DatabaseManager.getGameDatabase().getCollection("friendships").deleteMany(com.mongodb.client.model.Filters.m1277eq("friendId", Integer.valueOf(uid)));
        DatabaseManager.getGameDatastore().find(Player.class).filter(Filters.m1223eq("id", Integer.valueOf(uid))).delete();
    }

    public static void deleteAccount(Account target) {
        Player player = getPlayerByAccount(target);
        if (player != null) {
            deletePlayer(player);
        }
        DatabaseManager.getAccountDatastore().find(Account.class).filter(Filters.m1223eq("id", target.getId())).delete();
    }

    public static <T> Stream<T> getByGameClass(Class<T> classType) {
        return DatabaseManager.getGameDatastore().find(classType).stream();
    }

    public static Stream<Player> getPlayerExpAll(int daylogin) {
        return DatabaseManager.getGameDatastore().find(Player.class).filter(Filters.m1220lt("playerProfile.lastActiveTime", Long.valueOf((System.currentTimeMillis() / 1000) - ((long) (((daylogin * 24) * 60) * 60))))).stream();
    }

    public static long PlayerCountExp(int daylogin) {
        return DatabaseManager.getGameDatastore().find(Player.class).filter(Filters.m1220lt("playerProfile.lastActiveTime", Long.valueOf((System.currentTimeMillis() / 1000) - ((long) (((daylogin * 24) * 60) * 60))))).count();
    }

    public static Player getPlayerByUid(int id) {
        return (Player) DatabaseManager.getGameDatastore().find(Player.class).filter(Filters.m1223eq(DBCollection.ID_FIELD_NAME, Integer.valueOf(id))).first();
    }

    public static Player getPlayerByAccount(Account account) {
        return (Player) DatabaseManager.getGameDatastore().find(Player.class).filter(Filters.m1223eq("accountId", account.getId())).first();
    }

    public static Player getPlayerByAccount(String accountId) {
        return (Player) DatabaseManager.getGameDatastore().find(Player.class).filter(Filters.m1223eq("accountId", accountId)).first();
    }

    public static Player getPlayerByAccount(Account account, Class<? extends Player> playerClass) {
        return (Player) DatabaseManager.getGameDatastore().find(playerClass).filter(Filters.m1223eq("accountId", account.getId())).first();
    }

    public static boolean checkIfPlayerExists(int uid) {
        return DatabaseManager.getGameDatastore().find(Player.class).filter(Filters.m1223eq(DBCollection.ID_FIELD_NAME, Integer.valueOf(uid))).count() > 0;
    }

    public static boolean checkIfPlayerAccountExists(int uid) {
        return DatabaseManager.getGameDatastore().find(Player.class).filter(Filters.m1223eq("accountId", Integer.valueOf(uid))).count() > 0;
    }

    public static synchronized Player generatePlayerUid(Player character, int reservedId) {
        int id;
        if (reservedId <= 0 || checkIfPlayerExists(reservedId)) {
            do {
                id = DatabaseManager.getNextId(character);
            } while (checkIfPlayerExists(id));
            character.setUid(id);
        } else {
            character.setUid(reservedId);
        }
        DatabaseManager.getGameDatastore().save((Datastore) character);
        return character;
    }

    public static synchronized int getNextAccountId() {
        int id;
        do {
            id = DatabaseManager.getNextId((Class<?>) Account.class);
        } while (checkIfAccountExists(id));
        return id;
    }

    public static void savePlayer(Player character) {
        DatabaseManager.getGameDatastore().save((Datastore) character);
    }

    public static void saveAvatar(Avatar avatar) {
        DatabaseManager.getGameDatastore().save((Datastore) avatar);
    }

    public static List<Avatar> getAvatars(Player player) {
        return DatabaseManager.getGameDatastore().find(Avatar.class).filter(Filters.m1223eq("ownerId", Integer.valueOf(player.getUid()))).stream().toList();
    }

    public static DeleteResult getAvatarsNullPlayer() {
        ArrayList<Integer> notremove = new ArrayList<>();
        DeleteOptions all = new DeleteOptions();
        all.multi(true);
        return DatabaseManager.getGameDatastore().find(Avatar.class).filter(Filters.nin("ownerId", notremove)).delete(all);
    }

    public static boolean deleteAvatar(Avatar item) {
        return DatabaseManager.getGameDatastore().delete((Datastore) item).wasAcknowledged();
    }

    public static void saveItem(GameItem item) {
        DatabaseManager.getGameDatastore().save((Datastore) item);
    }

    public static boolean deleteItem(GameItem item) {
        return DatabaseManager.getGameDatastore().delete((Datastore) item).wasAcknowledged();
    }

    public static List<GameItem> getInventoryItems(Player player) {
        return DatabaseManager.getGameDatastore().find(GameItem.class).filter(Filters.m1223eq("ownerId", Integer.valueOf(player.getUid()))).stream().toList();
    }

    public static DeleteResult getInventoryNullPlayer() {
        ArrayList<Integer> notremove = new ArrayList<>();
        DeleteOptions all = new DeleteOptions();
        all.multi(true);
        return DatabaseManager.getGameDatastore().find(GameItem.class).filter(Filters.nin("ownerId", notremove)).delete(all);
    }

    public static List<Friendship> getFriends(Player player) {
        return DatabaseManager.getGameDatastore().find(Friendship.class).filter(Filters.m1223eq("ownerId", Integer.valueOf(player.getUid()))).stream().toList();
    }

    public static List<Friendship> getReverseFriends(Player player) {
        return DatabaseManager.getGameDatastore().find(Friendship.class).filter(Filters.m1223eq("friendId", Integer.valueOf(player.getUid()))).stream().toList();
    }

    public static void saveFriendship(Friendship friendship) {
        DatabaseManager.getGameDatastore().save((Datastore) friendship);
    }

    public static void deleteFriendship(Friendship friendship) {
        DatabaseManager.getGameDatastore().delete((Datastore) friendship);
    }

    public static Friendship getReverseFriendship(Friendship friendship) {
        return (Friendship) DatabaseManager.getGameDatastore().find(Friendship.class).filter(Filters.and(Filters.m1223eq("ownerId", Integer.valueOf(friendship.getFriendId())), Filters.m1223eq("friendId", Integer.valueOf(friendship.getOwnerId())))).first();
    }

    public static List<GachaRecord> getGachaRecords(int ownerId, int page, int gachaType) {
        return getGachaRecords(ownerId, page, gachaType, 10);
    }

    /* JADX DEBUG: Type inference failed for r0v4. Raw type applied. Possible types: java.util.List<T>, java.util.List<emu.grasscutter.game.gacha.GachaRecord> */
    public static List<GachaRecord> getGachaRecords(int ownerId, int page, int gachaType, int pageSize) {
        return DatabaseManager.getGameDatastore().find(GachaRecord.class).filter(Filters.m1223eq("ownerId", Integer.valueOf(ownerId)), Filters.m1223eq("gachaType", Integer.valueOf(gachaType))).iterator(new FindOptions().sort(Sort.descending("transactionDate")).skip(pageSize * page).limit(pageSize)).toList();
    }

    public static long getGachaRecordsMaxPage(int ownerId, int page, int gachaType) {
        return getGachaRecordsMaxPage(ownerId, page, gachaType, 10);
    }

    public static long getGachaRecordsMaxPage(int ownerId, int page, int gachaType, int pageSize) {
        long count = DatabaseManager.getGameDatastore().find(GachaRecord.class).filter(Filters.m1223eq("ownerId", Integer.valueOf(ownerId)), Filters.m1223eq("gachaType", Integer.valueOf(gachaType))).count();
        return (count / 10) + ((long) (count % 10 > 0 ? 1 : 0));
    }

    public static void saveGachaRecord(GachaRecord gachaRecord) {
        DatabaseManager.getGameDatastore().save((Datastore) gachaRecord);
    }

    public static List<Mail> getAllMail(Player player) {
        return DatabaseManager.getGameDatastore().find(Mail.class).filter(Filters.m1223eq("ownerUid", Integer.valueOf(player.getUid()))).stream().toList();
    }

    public static List<Mail> getMailExpAll() {
        return DatabaseManager.getAccountDatastore().find(Mail.class).stream().filter(g -> {
            return g.expireTime * 1000 < System.currentTimeMillis();
        }).toList();
    }

    public static void saveMail(Mail mail) {
        DatabaseManager.getGameDatastore().save((Datastore) mail);
    }

    public static boolean deleteMail(Mail mail) {
        return DatabaseManager.getGameDatastore().delete((Datastore) mail).wasAcknowledged();
    }

    public static List<GameMainQuest> getAllQuests(Player player) {
        return DatabaseManager.getGameDatastore().find(GameMainQuest.class).filter(Filters.m1223eq("ownerUid", Integer.valueOf(player.getUid()))).stream().toList();
    }

    public static void saveQuest(GameMainQuest quest) {
        DatabaseManager.getGameDatastore().save((Datastore) quest);
    }

    public static boolean deleteQuest(GameMainQuest quest) {
        return DatabaseManager.getGameDatastore().delete((Datastore) quest).wasAcknowledged();
    }

    public static DailyTaskManager getDailyTasksByUid(int id) {
        return (DailyTaskManager) DatabaseManager.getGameDatastore().find(DailyTaskManager.class).filter(Filters.m1223eq("ownerUid", Integer.valueOf(id))).first();
    }

    public static void saveDailyTasks(DailyTaskManager manager) {
        DatabaseManager.getGameDatastore().save((Datastore) manager);
    }

    public static GameHome getHomeByUid(int id) {
        return (GameHome) DatabaseManager.getGameDatastore().find(GameHome.class).filter(Filters.m1223eq("ownerUid", Integer.valueOf(id))).first();
    }

    public static void saveHome(GameHome gameHome) {
        DatabaseManager.getGameDatastore().save((Datastore) gameHome);
    }

    public static BattlePassManager loadBattlePass(Player player) {
        BattlePassManager manager = (BattlePassManager) DatabaseManager.getGameDatastore().find(BattlePassManager.class).filter(Filters.m1223eq("ownerUid", Integer.valueOf(player.getUid()))).first();
        if (manager == null) {
            manager = new BattlePassManager(player);
            manager.save();
        } else {
            manager.setPlayer(player);
        }
        return manager;
    }

    public static void saveBattlePass(BattlePassManager manager) {
        DatabaseManager.getGameDatastore().save((Datastore) manager);
    }

    public static PlayerActivityData getPlayerActivityData(int uid, int activityId) {
        return (PlayerActivityData) DatabaseManager.getGameDatastore().find(PlayerActivityData.class).filter(Filters.and(Filters.m1223eq("uid", Integer.valueOf(uid)), Filters.m1223eq("activityId", Integer.valueOf(activityId)))).first();
    }

    public static DeleteResult getActivityPlayerNull() {
        ArrayList<Integer> notremove = new ArrayList<>();
        DeleteOptions all = new DeleteOptions();
        all.multi(true);
        return DatabaseManager.getGameDatastore().find(PlayerActivityData.class).filter(Filters.nin("uid", notremove)).delete(all);
    }

    public static void savePlayerActivityData(PlayerActivityData playerActivityData) {
        DatabaseManager.getGameDatastore().save((Datastore) playerActivityData);
    }

    public static MusicGameBeatmap getMusicGameBeatmap(long musicShareId) {
        return (MusicGameBeatmap) DatabaseManager.getGameDatastore().find(MusicGameBeatmap.class).filter(Filters.m1223eq("musicShareId", Long.valueOf(musicShareId))).first();
    }

    public static void saveMusicGameBeatmap(MusicGameBeatmap musicGameBeatmap) {
        DatabaseManager.getGameDatastore().save((Datastore) musicGameBeatmap);
    }
}
