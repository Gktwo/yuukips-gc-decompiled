package com.mongodb.client.model;

import com.mongodb.assertions.Assertions;

/* loaded from: grasscutter.jar:com/mongodb/client/model/ValidationAction.class */
public enum ValidationAction {
    ERROR("error"),
    WARN("warn");
    
    private final String value;

    ValidationAction(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static ValidationAction fromString(String validationAction) {
        Assertions.notNull("validationAction", validationAction);
        ValidationAction[] values = values();
        for (ValidationAction action : values) {
            if (validationAction.equalsIgnoreCase(action.value)) {
                return action;
            }
        }
        throw new IllegalArgumentException(String.format("'%s' is not a valid validationAction", validationAction));
    }
}
