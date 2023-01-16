package emu.grasscutter.game.activity.condition;

import emu.grasscutter.Grasscutter;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;

/* loaded from: grasscutter.jar:emu/grasscutter/game/activity/condition/AllActivityConditionBuilder.class */
public class AllActivityConditionBuilder {
    public static Map<ActivityConditions, ActivityConditionBaseHandler> buildActivityConditions() {
        return new AllActivityConditionBuilder().initActivityConditions();
    }

    private Map<ActivityConditions, ActivityConditionBaseHandler> initActivityConditions() {
        return (Map) Grasscutter.reflector.getTypesAnnotatedWith(ActivityCondition.class).stream().map(this::newInstance).map(h -> {
            return new AbstractMap.SimpleEntry(extractActionType(h), h);
        }).collect(Collectors.toMap((v0) -> {
            return v0.getKey();
        }, (v0) -> {
            return v0.getValue();
        }));
    }

    private ActivityConditions extractActionType(ActivityConditionBaseHandler e) {
        ActivityCondition condition = (ActivityCondition) e.getClass().getAnnotation(ActivityCondition.class);
        if (condition != null) {
            return condition.value();
        }
        Grasscutter.getLogger().error("Failed to read command type for class {}", e.getClass().getName());
        return null;
    }

    private ActivityConditionBaseHandler newInstance(Class<?> clazz) {
        try {
            Object result = clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (result instanceof ActivityConditionBaseHandler) {
                return (ActivityConditionBaseHandler) result;
            }
            Grasscutter.getLogger().error("Failed to initiate activity condition: {}, object have wrong type", clazz.getName());
            return null;
        } catch (Exception e) {
            Grasscutter.getLogger().error(String.format("Failed to initiate activity condition: %s, %s", clazz.getName(), e.getMessage()), (Throwable) e);
            return null;
        }
    }
}
