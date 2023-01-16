package com.mchange.net;

import com.mchange.util.RobustMessageLogger;
import java.io.IOException;
import java.net.Socket;

/* loaded from: grasscutter.jar:com/mchange/net/SocketUtils.class */
public final class SocketUtils {
    public static void attemptClose(Socket socket) {
        attemptClose(socket, null);
    }

    public static void attemptClose(Socket socket, RobustMessageLogger robustMessageLogger) {
        try {
            socket.close();
        } catch (IOException e) {
            if (robustMessageLogger != null) {
                robustMessageLogger.log(e, "IOException trying to close Socket");
            }
        } catch (NullPointerException e2) {
            if (robustMessageLogger != null) {
                robustMessageLogger.log(e2, "NullPointerException trying to close Socket");
            }
        }
    }

    private SocketUtils() {
    }
}
