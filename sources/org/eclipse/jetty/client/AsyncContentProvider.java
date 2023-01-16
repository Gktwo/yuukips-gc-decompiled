package org.eclipse.jetty.client;

import java.util.EventListener;
import org.eclipse.jetty.client.api.ContentProvider;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/AsyncContentProvider.class */
public interface AsyncContentProvider extends ContentProvider {

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/AsyncContentProvider$Listener.class */
    public interface Listener extends EventListener {
        void onContent();
    }

    void setListener(Listener listener);
}
