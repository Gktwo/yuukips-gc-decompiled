package emu.grasscutter.net.proto;

import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.Internal;
import com.google.protobuf.ProtocolMessageEnum;

/* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneSurfaceMaterialOuterClass.class */
public final class SceneSurfaceMaterialOuterClass {
    private static Descriptors.FileDescriptor descriptor = Descriptors.FileDescriptor.internalBuildGeneratedFileFrom(new String[]{"\n\u001aSceneSurfaceMaterial.proto*£\u0002\n\u0014SceneSurfaceMaterial\u0012\"\n\u001eSCENE_SURFACE_MATERIAL_INVALID\u0010��\u0012 \n\u001cSCENE_SURFACE_MATERIAL_GRASS\u0010\u0001\u0012\u001f\n\u001bSCENE_SURFACE_MATERIAL_DIRT\u0010\u0002\u0012\u001f\n\u001bSCENE_SURFACE_MATERIAL_ROCK\u0010\u0003\u0012\u001f\n\u001bSCENE_SURFACE_MATERIAL_SNOW\u0010\u0004\u0012 \n\u001cSCENE_SURFACE_MATERIAL_WATER\u0010\u0005\u0012\u001f\n\u001bSCENE_SURFACE_MATERIAL_TILE\u0010\u0006\u0012\u001f\n\u001bSCENE_SURFACE_MATERIAL_SAND\u0010\u0007B\u001b\n\u0019emu.grasscutter.net.protob\u0006proto3"}, new Descriptors.FileDescriptor[0]);

    private SceneSurfaceMaterialOuterClass() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static void registerAllExtensions(ExtensionRegistry registry) {
        registerAllExtensions((ExtensionRegistryLite) registry);
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/net/proto/SceneSurfaceMaterialOuterClass$SceneSurfaceMaterial.class */
    public enum SceneSurfaceMaterial implements ProtocolMessageEnum {
        SCENE_SURFACE_MATERIAL_INVALID(0),
        SCENE_SURFACE_MATERIAL_GRASS(1),
        SCENE_SURFACE_MATERIAL_DIRT(2),
        SCENE_SURFACE_MATERIAL_ROCK(3),
        SCENE_SURFACE_MATERIAL_SNOW(4),
        SCENE_SURFACE_MATERIAL_WATER(5),
        SCENE_SURFACE_MATERIAL_TILE(6),
        SCENE_SURFACE_MATERIAL_SAND(7),
        UNRECOGNIZED(-1);
        
        public static final int SCENE_SURFACE_MATERIAL_INVALID_VALUE = 0;
        public static final int SCENE_SURFACE_MATERIAL_GRASS_VALUE = 1;
        public static final int SCENE_SURFACE_MATERIAL_DIRT_VALUE = 2;
        public static final int SCENE_SURFACE_MATERIAL_ROCK_VALUE = 3;
        public static final int SCENE_SURFACE_MATERIAL_SNOW_VALUE = 4;
        public static final int SCENE_SURFACE_MATERIAL_WATER_VALUE = 5;
        public static final int SCENE_SURFACE_MATERIAL_TILE_VALUE = 6;
        public static final int SCENE_SURFACE_MATERIAL_SAND_VALUE = 7;
        private static final Internal.EnumLiteMap<SceneSurfaceMaterial> internalValueMap = new Internal.EnumLiteMap<SceneSurfaceMaterial>() { // from class: emu.grasscutter.net.proto.SceneSurfaceMaterialOuterClass.SceneSurfaceMaterial.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            public SceneSurfaceMaterial findValueByNumber(int number) {
                return SceneSurfaceMaterial.forNumber(number);
            }
        };
        private static final SceneSurfaceMaterial[] VALUES = values();
        private final int value;

        @Override // com.google.protobuf.ProtocolMessageEnum, com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static SceneSurfaceMaterial valueOf(int value) {
            return forNumber(value);
        }

        public static SceneSurfaceMaterial forNumber(int value) {
            switch (value) {
                case 0:
                    return SCENE_SURFACE_MATERIAL_INVALID;
                case 1:
                    return SCENE_SURFACE_MATERIAL_GRASS;
                case 2:
                    return SCENE_SURFACE_MATERIAL_DIRT;
                case 3:
                    return SCENE_SURFACE_MATERIAL_ROCK;
                case 4:
                    return SCENE_SURFACE_MATERIAL_SNOW;
                case 5:
                    return SCENE_SURFACE_MATERIAL_WATER;
                case 6:
                    return SCENE_SURFACE_MATERIAL_TILE;
                case 7:
                    return SCENE_SURFACE_MATERIAL_SAND;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<SceneSurfaceMaterial> internalGetValueMap() {
            return internalValueMap;
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumValueDescriptor getValueDescriptor() {
            if (this != UNRECOGNIZED) {
                return getDescriptor().getValues().get(ordinal());
            }
            throw new IllegalStateException("Can't get the descriptor of an unrecognized enum value.");
        }

        @Override // com.google.protobuf.ProtocolMessageEnum
        public final Descriptors.EnumDescriptor getDescriptorForType() {
            return getDescriptor();
        }

        public static final Descriptors.EnumDescriptor getDescriptor() {
            return SceneSurfaceMaterialOuterClass.getDescriptor().getEnumTypes().get(0);
        }

        public static SceneSurfaceMaterial valueOf(Descriptors.EnumValueDescriptor desc) {
            if (desc.getType() != getDescriptor()) {
                throw new IllegalArgumentException("EnumValueDescriptor is not for this type.");
            } else if (desc.getIndex() == -1) {
                return UNRECOGNIZED;
            } else {
                return VALUES[desc.getIndex()];
            }
        }

        SceneSurfaceMaterial(int value) {
            this.value = value;
        }
    }

    public static Descriptors.FileDescriptor getDescriptor() {
        return descriptor;
    }
}
