package dev.morphia.internal;

import com.mongodb.client.ClientSession;
import com.mongodb.lang.Nullable;
import dev.morphia.internal.SessionConfigurable;

/* loaded from: grasscutter.jar:dev/morphia/internal/SessionConfigurable.class */
public interface SessionConfigurable<T extends SessionConfigurable<T>> {
    T clientSession(ClientSession clientSession);

    @Nullable
    ClientSession clientSession();
}
