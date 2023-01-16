package com.mongodb.client.model;

/* loaded from: grasscutter.jar:com/mongodb/client/model/RenameCollectionOptions.class */
public class RenameCollectionOptions {
    private boolean dropTarget;

    public boolean isDropTarget() {
        return this.dropTarget;
    }

    public RenameCollectionOptions dropTarget(boolean dropTarget) {
        this.dropTarget = dropTarget;
        return this;
    }

    public String toString() {
        return "RenameCollectionOptions{dropTarget=" + this.dropTarget + '}';
    }
}
