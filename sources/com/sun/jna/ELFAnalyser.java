package com.sun.jna;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:com/sun/jna/ELFAnalyser.class */
class ELFAnalyser {
    private static final byte[] ELF_MAGIC = {Byte.MAX_VALUE, 69, 76, 70};
    private static final int EF_ARM_ABI_FLOAT_HARD = 1024;
    private static final int EF_ARM_ABI_FLOAT_SOFT = 512;
    private static final int EI_DATA_BIG_ENDIAN = 2;
    private static final int E_MACHINE_ARM = 40;
    private static final int EI_CLASS_64BIT = 2;
    private final String filename;
    private boolean ELF = false;
    private boolean _64Bit = false;
    private boolean bigEndian = false;
    private boolean armHardFloatFlag = false;
    private boolean armSoftFloatFlag = false;
    private boolean armEabiAapcsVfp = false;
    private boolean arm = false;

    public static ELFAnalyser analyse(String filename) throws IOException {
        ELFAnalyser res = new ELFAnalyser(filename);
        res.runDetection();
        return res;
    }

    public boolean isELF() {
        return this.ELF;
    }

    public boolean is64Bit() {
        return this._64Bit;
    }

    public boolean isBigEndian() {
        return this.bigEndian;
    }

    public String getFilename() {
        return this.filename;
    }

    public boolean isArmHardFloat() {
        return isArmEabiAapcsVfp() || isArmHardFloatFlag();
    }

    public boolean isArmEabiAapcsVfp() {
        return this.armEabiAapcsVfp;
    }

    public boolean isArmHardFloatFlag() {
        return this.armHardFloatFlag;
    }

    public boolean isArmSoftFloatFlag() {
        return this.armSoftFloatFlag;
    }

    public boolean isArm() {
        return this.arm;
    }

    private ELFAnalyser(String filename) {
        this.filename = filename;
    }

    private void runDetection() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(this.filename, "r");
        try {
            if (raf.length() > 4) {
                byte[] magic = new byte[4];
                raf.seek(0);
                raf.read(magic);
                if (Arrays.equals(magic, ELF_MAGIC)) {
                    this.ELF = true;
                }
            }
            if (!this.ELF) {
                try {
                    raf.close();
                } catch (IOException e) {
                }
            } else {
                raf.seek(4);
                byte sizeIndicator = raf.readByte();
                byte endianessIndicator = raf.readByte();
                this._64Bit = sizeIndicator == 2;
                this.bigEndian = endianessIndicator == 2;
                raf.seek(0);
                ByteBuffer headerData = ByteBuffer.allocate(this._64Bit ? 64 : 52);
                raf.getChannel().read(headerData, 0);
                headerData.order(this.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
                this.arm = headerData.get(18) == 40;
                if (this.arm) {
                    int flags = headerData.getInt(this._64Bit ? 48 : 36);
                    this.armHardFloatFlag = (flags & 1024) == 1024;
                    this.armSoftFloatFlag = (flags & 512) == 512;
                    parseEabiAapcsVfp(headerData, raf);
                }
                try {
                    raf.close();
                } catch (IOException e2) {
                }
            }
        } catch (Throwable th) {
            try {
                raf.close();
            } catch (IOException e3) {
            }
            throw th;
        }
    }

    private void parseEabiAapcsVfp(ByteBuffer headerData, RandomAccessFile raf) throws IOException {
        for (ELFSectionHeaderEntry eshe : new ELFSectionHeaders(this._64Bit, this.bigEndian, headerData, raf).getEntries()) {
            if (".ARM.attributes".equals(eshe.getName())) {
                ByteBuffer armAttributesBuffer = ByteBuffer.allocate(eshe.getSize());
                armAttributesBuffer.order(this.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
                raf.getChannel().read(armAttributesBuffer, (long) eshe.getOffset());
                armAttributesBuffer.rewind();
                Map<ArmAeabiAttributesTag, Object> fileAttributes = parseArmAttributes(armAttributesBuffer).get(1);
                if (fileAttributes != null) {
                    Object abiVFPargValue = fileAttributes.get(ArmAeabiAttributesTag.ABI_VFP_args);
                    if ((abiVFPargValue instanceof Integer) && ((Integer) abiVFPargValue).equals(1)) {
                        this.armEabiAapcsVfp = true;
                    } else if ((abiVFPargValue instanceof BigInteger) && ((BigInteger) abiVFPargValue).intValue() == 1) {
                        this.armEabiAapcsVfp = true;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/sun/jna/ELFAnalyser$ELFSectionHeaders.class */
    public static class ELFSectionHeaders {
        private final List<ELFSectionHeaderEntry> entries = new ArrayList();

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r0v68, types: [long] */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARN: Type inference failed for: r11v4 */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ELFSectionHeaders(boolean r7, boolean r8, java.nio.ByteBuffer r9, java.io.RandomAccessFile r10) throws java.io.IOException {
            /*
            // Method dump skipped, instructions count: 388
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sun.jna.ELFAnalyser.ELFSectionHeaders.<init>(boolean, boolean, java.nio.ByteBuffer, java.io.RandomAccessFile):void");
        }

        public List<ELFSectionHeaderEntry> getEntries() {
            return this.entries;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/sun/jna/ELFAnalyser$ELFSectionHeaderEntry.class */
    public static class ELFSectionHeaderEntry {
        private final int nameOffset;
        private String name;
        private final int type;
        private final int flags;
        private final int offset;
        private final int size;

        public ELFSectionHeaderEntry(boolean _64bit, ByteBuffer sectionHeaderData) {
            this.nameOffset = sectionHeaderData.getInt(0);
            this.type = sectionHeaderData.getInt(4);
            this.flags = (int) (_64bit ? sectionHeaderData.getLong(8) : (long) sectionHeaderData.getInt(8));
            this.offset = (int) (_64bit ? sectionHeaderData.getLong(24) : (long) sectionHeaderData.getInt(16));
            this.size = (int) (_64bit ? sectionHeaderData.getLong(32) : (long) sectionHeaderData.getInt(20));
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNameOffset() {
            return this.nameOffset;
        }

        public int getType() {
            return this.type;
        }

        public int getFlags() {
            return this.flags;
        }

        public int getOffset() {
            return this.offset;
        }

        public int getSize() {
            return this.size;
        }

        public String toString() {
            return "ELFSectionHeaderEntry{nameIdx=" + this.nameOffset + ", name=" + this.name + ", type=" + this.type + ", flags=" + this.flags + ", offset=" + this.offset + ", size=" + this.size + '}';
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/sun/jna/ELFAnalyser$ArmAeabiAttributesTag.class */
    public static class ArmAeabiAttributesTag {
        private final int value;
        private final String name;
        private final ParameterType parameterType;
        private static final List<ArmAeabiAttributesTag> tags = new LinkedList();
        private static final Map<Integer, ArmAeabiAttributesTag> valueMap = new HashMap();
        private static final Map<String, ArmAeabiAttributesTag> nameMap = new HashMap();
        public static final ArmAeabiAttributesTag File = addTag(1, "File", ParameterType.UINT32);
        public static final ArmAeabiAttributesTag Section = addTag(2, "Section", ParameterType.UINT32);
        public static final ArmAeabiAttributesTag Symbol = addTag(3, "Symbol", ParameterType.UINT32);
        public static final ArmAeabiAttributesTag CPU_raw_name = addTag(4, "CPU_raw_name", ParameterType.NTBS);
        public static final ArmAeabiAttributesTag CPU_name = addTag(5, "CPU_name", ParameterType.NTBS);
        public static final ArmAeabiAttributesTag CPU_arch = addTag(6, "CPU_arch", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag CPU_arch_profile = addTag(7, "CPU_arch_profile", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ARM_ISA_use = addTag(8, "ARM_ISA_use", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag THUMB_ISA_use = addTag(9, "THUMB_ISA_use", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag FP_arch = addTag(10, "FP_arch", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag WMMX_arch = addTag(11, "WMMX_arch", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag Advanced_SIMD_arch = addTag(12, "Advanced_SIMD_arch", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag PCS_config = addTag(13, "PCS_config", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_PCS_R9_use = addTag(14, "ABI_PCS_R9_use", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_PCS_RW_data = addTag(15, "ABI_PCS_RW_data", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_PCS_RO_data = addTag(16, "ABI_PCS_RO_data", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_PCS_GOT_use = addTag(17, "ABI_PCS_GOT_use", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_PCS_wchar_t = addTag(18, "ABI_PCS_wchar_t", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_FP_rounding = addTag(19, "ABI_FP_rounding", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_FP_denormal = addTag(20, "ABI_FP_denormal", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_FP_exceptions = addTag(21, "ABI_FP_exceptions", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_FP_user_exceptions = addTag(22, "ABI_FP_user_exceptions", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_FP_number_model = addTag(23, "ABI_FP_number_model", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_align_needed = addTag(24, "ABI_align_needed", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_align8_preserved = addTag(25, "ABI_align8_preserved", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_enum_size = addTag(26, "ABI_enum_size", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_HardFP_use = addTag(27, "ABI_HardFP_use", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_VFP_args = addTag(28, "ABI_VFP_args", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_WMMX_args = addTag(29, "ABI_WMMX_args", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_optimization_goals = addTag(30, "ABI_optimization_goals", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_FP_optimization_goals = addTag(31, "ABI_FP_optimization_goals", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag compatibility = addTag(32, "compatibility", ParameterType.NTBS);
        public static final ArmAeabiAttributesTag CPU_unaligned_access = addTag(34, "CPU_unaligned_access", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag FP_HP_extension = addTag(36, "FP_HP_extension", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag ABI_FP_16bit_format = addTag(38, "ABI_FP_16bit_format", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag MPextension_use = addTag(42, "MPextension_use", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag DIV_use = addTag(44, "DIV_use", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag nodefaults = addTag(64, "nodefaults", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag also_compatible_with = addTag(65, "also_compatible_with", ParameterType.NTBS);
        public static final ArmAeabiAttributesTag conformance = addTag(67, "conformance", ParameterType.NTBS);
        public static final ArmAeabiAttributesTag T2EE_use = addTag(66, "T2EE_use", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag Virtualization_use = addTag(68, "Virtualization_use", ParameterType.ULEB128);
        public static final ArmAeabiAttributesTag MPextension_use2 = addTag(70, "MPextension_use", ParameterType.ULEB128);

        /* loaded from: grasscutter.jar:com/sun/jna/ELFAnalyser$ArmAeabiAttributesTag$ParameterType.class */
        public enum ParameterType {
            UINT32,
            NTBS,
            ULEB128
        }

        public ArmAeabiAttributesTag(int value, String name, ParameterType parameterType) {
            this.value = value;
            this.name = name;
            this.parameterType = parameterType;
        }

        public int getValue() {
            return this.value;
        }

        public String getName() {
            return this.name;
        }

        public ParameterType getParameterType() {
            return this.parameterType;
        }

        public String toString() {
            return this.name + " (" + this.value + ")";
        }

        public int hashCode() {
            return (67 * 7) + this.value;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass() && this.value == ((ArmAeabiAttributesTag) obj).value) {
                return true;
            }
            return false;
        }

        private static ArmAeabiAttributesTag addTag(int value, String name, ParameterType type) {
            ArmAeabiAttributesTag tag = new ArmAeabiAttributesTag(value, name, type);
            if (!valueMap.containsKey(Integer.valueOf(tag.getValue()))) {
                valueMap.put(Integer.valueOf(tag.getValue()), tag);
            }
            if (!nameMap.containsKey(tag.getName())) {
                nameMap.put(tag.getName(), tag);
            }
            tags.add(tag);
            return tag;
        }

        public static List<ArmAeabiAttributesTag> getTags() {
            return Collections.unmodifiableList(tags);
        }

        public static ArmAeabiAttributesTag getByName(String name) {
            return nameMap.get(name);
        }

        public static ArmAeabiAttributesTag getByValue(int value) {
            if (valueMap.containsKey(Integer.valueOf(value))) {
                return valueMap.get(Integer.valueOf(value));
            }
            return new ArmAeabiAttributesTag(value, "Unknown " + value, getParameterType(value));
        }

        private static ParameterType getParameterType(int value) {
            ArmAeabiAttributesTag tag = getByValue(value);
            if (tag != null) {
                return tag.getParameterType();
            }
            if (value % 2 == 0) {
                return ParameterType.ULEB128;
            }
            return ParameterType.NTBS;
        }
    }

    private static Map<Integer, Map<ArmAeabiAttributesTag, Object>> parseArmAttributes(ByteBuffer bb) {
        if (bb.get() != 65) {
            return Collections.EMPTY_MAP;
        }
        while (bb.position() < bb.limit()) {
            int posSectionStart = bb.position();
            int sectionLength = bb.getInt();
            if (sectionLength <= 0) {
                break;
            } else if ("aeabi".equals(readNTBS(bb, null))) {
                return parseAEABI(bb);
            } else {
                bb.position(posSectionStart + sectionLength);
            }
        }
        return Collections.EMPTY_MAP;
    }

    private static Map<Integer, Map<ArmAeabiAttributesTag, Object>> parseAEABI(ByteBuffer buffer) {
        Map<Integer, Map<ArmAeabiAttributesTag, Object>> data = new HashMap<>();
        while (buffer.position() < buffer.limit()) {
            int pos = buffer.position();
            int subsectionTag = readULEB128(buffer).intValue();
            int length = buffer.getInt();
            if (subsectionTag == 1) {
                data.put(Integer.valueOf(subsectionTag), parseFileAttribute(buffer));
            }
            buffer.position(pos + length);
        }
        return data;
    }

    private static Map<ArmAeabiAttributesTag, Object> parseFileAttribute(ByteBuffer bb) {
        Map<ArmAeabiAttributesTag, Object> result = new HashMap<>();
        while (bb.position() < bb.limit()) {
            ArmAeabiAttributesTag tag = ArmAeabiAttributesTag.getByValue(readULEB128(bb).intValue());
            switch (tag.getParameterType()) {
                case UINT32:
                    result.put(tag, Integer.valueOf(bb.getInt()));
                    break;
                case NTBS:
                    result.put(tag, readNTBS(bb, null));
                    break;
                case ULEB128:
                    result.put(tag, readULEB128(bb));
                    break;
            }
        }
        return result;
    }

    private static String readNTBS(ByteBuffer buffer, Integer position) {
        if (position != null) {
            buffer.position(position.intValue());
        }
        int startingPos = buffer.position();
        while (buffer.get() != 0 && buffer.position() <= buffer.limit()) {
        }
        byte[] data = new byte[(buffer.position() - startingPos) - 1];
        buffer.position(startingPos);
        buffer.get(data);
        buffer.position(buffer.position() + 1);
        try {
            return new String(data, "ASCII");
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static BigInteger readULEB128(ByteBuffer buffer) {
        BigInteger result = BigInteger.ZERO;
        int shift = 0;
        while (true) {
            byte b = buffer.get();
            result = result.or(BigInteger.valueOf((long) (b & Byte.MAX_VALUE)).shiftLeft(shift));
            if ((b & 128) == 0) {
                return result;
            }
            shift += 7;
        }
    }
}
