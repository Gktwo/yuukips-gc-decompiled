package org.terracotta.quartz;

import org.terracotta.toolkit.internal.ToolkitInternal;

/* loaded from: grasscutter.jar:org/terracotta/quartz/TerracottaJobStore.class */
public class TerracottaJobStore extends AbstractTerracottaJobStore {
    @Override // org.terracotta.quartz.AbstractTerracottaJobStore
    TerracottaJobStoreExtensions getRealStore(ToolkitInternal toolkit) {
        return new PlainTerracottaJobStore(toolkit);
    }
}
