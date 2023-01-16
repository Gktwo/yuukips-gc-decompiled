package org.eclipse.jetty.websocket.api.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.eclipse.jetty.websocket.api.BatchMode;

@Target({ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/api/annotations/WebSocket.class */
public @interface WebSocket {
    int inputBufferSize() default -2;

    int maxBinaryMessageSize() default -2;

    int maxIdleTime() default -2;

    int maxTextMessageSize() default -2;

    BatchMode batchMode() default BatchMode.AUTO;
}
