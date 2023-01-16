package com.mongodb;

import com.mongodb.annotations.ThreadSafe;
import com.mongodb.lang.Nullable;
import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;

@ThreadSafe
/* loaded from: grasscutter.jar:com/mongodb/SubjectProvider.class */
public interface SubjectProvider {
    @Nullable
    Subject getSubject() throws LoginException;
}
