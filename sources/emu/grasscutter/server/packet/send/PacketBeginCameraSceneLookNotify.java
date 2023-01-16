package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.utils.Position;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketBeginCameraSceneLookNotify.class */
public class PacketBeginCameraSceneLookNotify extends BasePacket {
    public PacketBeginCameraSceneLookNotify(CameraSceneLookNotify parameters) {
        super(PacketOpcodes.BeginCameraSceneLookNotify);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketBeginCameraSceneLookNotify$CameraSceneLookNotify.class */
    public static class CameraSceneLookNotify {
        Position lookPos = new Position();
        Position followPos = new Position();
        float duration = 0.0f;
        boolean isAllowInput = true;
        boolean setFollowPos = false;
        boolean isScreenXY = false;
        boolean recoverKeepCurrent = true;
        boolean isForceWalk = false;
        boolean isForce = false;
        boolean isChangePlayMode = false;
        float screenY = 0.0f;
        float screenX = 0.0f;
        int entityId = 0;
        Collection<String> otherParams = new ArrayList(0);

        /*  JADX ERROR: Dependency scan failed at insn: 0x0038: INVOKE_CUSTOM r-14, r-13, r-12, r-11, r-10, r-9, r-8, r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x0038: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, method: emu.grasscutter.server.packet.send.PacketBeginCameraSceneLookNotify.CameraSceneLookNotify.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, F, Z, Z, Z, Z, Z, Z, Z, F, F, I, Ljava/util/Collection;)Ljava/lang/String;}, PacketBeginCameraSceneLookNotify.CameraSceneLookNotify(lookPos=, followPos=, duration=, isAllowInput=, setFollowPos=, isScreenXY=, recoverKeepCurrent=, isForceWalk=, isForce=, isChangePlayMode=, screenY=, screenX=, entityId=, otherParams=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
            	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, F, Z, Z, Z, Z, Z, Z, Z, F, F, I, Ljava/util/Collection;)Ljava/lang/String;}, PacketBeginCameraSceneLookNotify.CameraSceneLookNotify(lookPos=, followPos=, duration=, isAllowInput=, setFollowPos=, isScreenXY=, recoverKeepCurrent=, isForceWalk=, isForce=, isChangePlayMode=, screenY=, screenX=, entityId=, otherParams=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r15 = this;
                r0 = r15
                emu.grasscutter.utils.Position r0 = r0.getLookPos()
                r1 = r15
                emu.grasscutter.utils.Position r1 = r1.getFollowPos()
                r2 = r15
                float r2 = r2.getDuration()
                r3 = r15
                boolean r3 = r3.isAllowInput()
                r4 = r15
                boolean r4 = r4.isSetFollowPos()
                r5 = r15
                boolean r5 = r5.isScreenXY()
                r6 = r15
                boolean r6 = r6.isRecoverKeepCurrent()
                r7 = r15
                boolean r7 = r7.isForceWalk()
                r8 = r15
                boolean r8 = r8.isForce()
                r9 = r15
                boolean r9 = r9.isChangePlayMode()
                r10 = r15
                float r10 = r10.getScreenY()
                r11 = r15
                float r11 = r11.getScreenX()
                r12 = r15
                int r12 = r12.getEntityId()
                r13 = r15
                java.util.Collection r13 = r13.getOtherParams()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/utils/Position;, Lemu/grasscutter/utils/Position;, F, Z, Z, Z, Z, Z, Z, Z, F, F, I, Ljava/util/Collection;)Ljava/lang/String;}, PacketBeginCameraSceneLookNotify.CameraSceneLookNotify(lookPos=, followPos=, duration=, isAllowInput=, setFollowPos=, isScreenXY=, recoverKeepCurrent=, isForceWalk=, isForce=, isChangePlayMode=, screenY=, screenX=, entityId=, otherParams=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.packet.send.PacketBeginCameraSceneLookNotify.CameraSceneLookNotify.toString():java.lang.String");
        }

        public void setLookPos(Position lookPos) {
            this.lookPos = lookPos;
        }

        public void setFollowPos(Position followPos) {
            this.followPos = followPos;
        }

        public void setDuration(float duration) {
            this.duration = duration;
        }

        public void setAllowInput(boolean isAllowInput) {
            this.isAllowInput = isAllowInput;
        }

        public void setSetFollowPos(boolean setFollowPos) {
            this.setFollowPos = setFollowPos;
        }

        public void setScreenXY(boolean isScreenXY) {
            this.isScreenXY = isScreenXY;
        }

        public void setRecoverKeepCurrent(boolean recoverKeepCurrent) {
            this.recoverKeepCurrent = recoverKeepCurrent;
        }

        public void setForceWalk(boolean isForceWalk) {
            this.isForceWalk = isForceWalk;
        }

        public void setForce(boolean isForce) {
            this.isForce = isForce;
        }

        public void setChangePlayMode(boolean isChangePlayMode) {
            this.isChangePlayMode = isChangePlayMode;
        }

        public void setScreenY(float screenY) {
            this.screenY = screenY;
        }

        public void setScreenX(float screenX) {
            this.screenX = screenX;
        }

        public void setEntityId(int entityId) {
            this.entityId = entityId;
        }

        public void setOtherParams(Collection<String> otherParams) {
            this.otherParams = otherParams;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof CameraSceneLookNotify)) {
                return false;
            }
            CameraSceneLookNotify other = (CameraSceneLookNotify) o;
            if (!other.canEqual(this) || Float.compare(getDuration(), other.getDuration()) != 0 || isAllowInput() != other.isAllowInput() || isSetFollowPos() != other.isSetFollowPos() || isScreenXY() != other.isScreenXY() || isRecoverKeepCurrent() != other.isRecoverKeepCurrent() || isForceWalk() != other.isForceWalk() || isForce() != other.isForce() || isChangePlayMode() != other.isChangePlayMode() || Float.compare(getScreenY(), other.getScreenY()) != 0 || Float.compare(getScreenX(), other.getScreenX()) != 0 || getEntityId() != other.getEntityId()) {
                return false;
            }
            Object this$lookPos = getLookPos();
            Object other$lookPos = other.getLookPos();
            if (this$lookPos == null) {
                if (other$lookPos != null) {
                    return false;
                }
            } else if (!this$lookPos.equals(other$lookPos)) {
                return false;
            }
            Object this$followPos = getFollowPos();
            Object other$followPos = other.getFollowPos();
            if (this$followPos == null) {
                if (other$followPos != null) {
                    return false;
                }
            } else if (!this$followPos.equals(other$followPos)) {
                return false;
            }
            Object this$otherParams = getOtherParams();
            Object other$otherParams = other.getOtherParams();
            return this$otherParams == null ? other$otherParams == null : this$otherParams.equals(other$otherParams);
        }

        protected boolean canEqual(Object other) {
            return other instanceof CameraSceneLookNotify;
        }

        public int hashCode() {
            int result = (((((((((((((((((((((1 * 59) + Float.floatToIntBits(getDuration())) * 59) + (isAllowInput() ? 79 : 97)) * 59) + (isSetFollowPos() ? 79 : 97)) * 59) + (isScreenXY() ? 79 : 97)) * 59) + (isRecoverKeepCurrent() ? 79 : 97)) * 59) + (isForceWalk() ? 79 : 97)) * 59) + (isForce() ? 79 : 97)) * 59) + (isChangePlayMode() ? 79 : 97)) * 59) + Float.floatToIntBits(getScreenY())) * 59) + Float.floatToIntBits(getScreenX())) * 59) + getEntityId();
            Object $lookPos = getLookPos();
            int result2 = (result * 59) + ($lookPos == null ? 43 : $lookPos.hashCode());
            Object $followPos = getFollowPos();
            int result3 = (result2 * 59) + ($followPos == null ? 43 : $followPos.hashCode());
            Object $otherParams = getOtherParams();
            return (result3 * 59) + ($otherParams == null ? 43 : $otherParams.hashCode());
        }

        public Position getLookPos() {
            return this.lookPos;
        }

        public Position getFollowPos() {
            return this.followPos;
        }

        public float getDuration() {
            return this.duration;
        }

        public boolean isAllowInput() {
            return this.isAllowInput;
        }

        public boolean isSetFollowPos() {
            return this.setFollowPos;
        }

        public boolean isScreenXY() {
            return this.isScreenXY;
        }

        public boolean isRecoverKeepCurrent() {
            return this.recoverKeepCurrent;
        }

        public boolean isForceWalk() {
            return this.isForceWalk;
        }

        public boolean isForce() {
            return this.isForce;
        }

        public boolean isChangePlayMode() {
            return this.isChangePlayMode;
        }

        public float getScreenY() {
            return this.screenY;
        }

        public float getScreenX() {
            return this.screenX;
        }

        public int getEntityId() {
            return this.entityId;
        }

        public Collection<String> getOtherParams() {
            return this.otherParams;
        }
    }
}
