package javassist.util;

import com.sun.jdi.Bootstrap;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.connect.AttachingConnector;
import com.sun.jdi.connect.Connector;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import com.sun.jdi.event.EventSet;
import com.sun.jdi.request.EventRequestManager;
import com.sun.jdi.request.MethodEntryRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:javassist/util/HotSwapper.class */
public class HotSwapper {
    private VirtualMachine jvm;
    private MethodEntryRequest request;
    private Map<ReferenceType, byte[]> newClassFiles;
    private Trigger trigger;
    private static final String HOST_NAME = "localhost";
    private static final String TRIGGER_NAME = Trigger.class.getName();

    public HotSwapper(int port) throws IOException, IllegalConnectorArgumentsException {
        this(Integer.toString(port));
    }

    public HotSwapper(String port) throws IOException, IllegalConnectorArgumentsException {
        this.jvm = null;
        this.request = null;
        this.newClassFiles = null;
        this.trigger = new Trigger();
        AttachingConnector connector = findConnector("com.sun.jdi.SocketAttach");
        Map<String, Connector.Argument> arguments = connector.defaultArguments();
        arguments.get("hostname").setValue(HOST_NAME);
        arguments.get("port").setValue(port);
        this.jvm = connector.attach(arguments);
        this.request = methodEntryRequests(this.jvm.eventRequestManager(), TRIGGER_NAME);
    }

    private Connector findConnector(String connector) throws IOException {
        for (Connector con : Bootstrap.virtualMachineManager().allConnectors()) {
            if (con.name().equals(connector)) {
                return con;
            }
        }
        throw new IOException("Not found: " + connector);
    }

    private static MethodEntryRequest methodEntryRequests(EventRequestManager manager, String classpattern) {
        MethodEntryRequest mereq = manager.createMethodEntryRequest();
        mereq.addClassFilter(classpattern);
        mereq.setSuspendPolicy(1);
        return mereq;
    }

    private void deleteEventRequest(EventRequestManager manager, MethodEntryRequest request) {
        manager.deleteEventRequest(request);
    }

    public void reload(String className, byte[] classFile) {
        ReferenceType classtype = toRefType(className);
        Map<ReferenceType, byte[]> map = new HashMap<>();
        map.put(classtype, classFile);
        reload2(map, className);
    }

    public void reload(Map<String, byte[]> classFiles) {
        Map<ReferenceType, byte[]> map = new HashMap<>();
        String className = null;
        for (Map.Entry<String, byte[]> e : classFiles.entrySet()) {
            className = e.getKey();
            map.put(toRefType(className), e.getValue());
        }
        if (className != null) {
            reload2(map, className + " etc.");
        }
    }

    private ReferenceType toRefType(String className) {
        List<ReferenceType> list = this.jvm.classesByName(className);
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        throw new RuntimeException("no such class: " + className);
    }

    private void reload2(Map<ReferenceType, byte[]> map, String msg) {
        synchronized (this.trigger) {
            startDaemon();
            this.newClassFiles = map;
            this.request.enable();
            this.trigger.doSwap();
            this.request.disable();
            if (this.newClassFiles != null) {
                this.newClassFiles = null;
                throw new RuntimeException("failed to reload: " + msg);
            }
        }
    }

    private void startDaemon() {
        new Thread() { // from class: javassist.util.HotSwapper.1
            private void errorMsg(Throwable e) {
                System.err.print("Exception in thread \"HotSwap\" ");
                e.printStackTrace(System.err);
            }

            /* JADX WARNING: Code restructure failed: missing block: B:8:0x0028, code lost:
                r3.this$0.hotswap();
             */
            @Override // java.lang.Thread, java.lang.Runnable
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r3 = this;
                    r0 = 0
                    r4 = r0
                    r0 = r3
                    javassist.util.HotSwapper r0 = javassist.util.HotSwapper.this     // Catch: Throwable -> 0x0038
                    com.sun.jdi.event.EventSet r0 = r0.waitEvent()     // Catch: Throwable -> 0x0038
                    r4 = r0
                    r0 = r4
                    com.sun.jdi.event.EventIterator r0 = r0.eventIterator()     // Catch: Throwable -> 0x0038
                    r5 = r0
                L_0x0011:
                    r0 = r5
                    boolean r0 = r0.hasNext()     // Catch: Throwable -> 0x0038
                    if (r0 == 0) goto L_0x0035
                    r0 = r5
                    com.sun.jdi.event.Event r0 = r0.nextEvent()     // Catch: Throwable -> 0x0038
                    r6 = r0
                    r0 = r6
                    boolean r0 = r0 instanceof com.sun.jdi.event.MethodEntryEvent     // Catch: Throwable -> 0x0038
                    if (r0 == 0) goto L_0x0032
                    r0 = r3
                    javassist.util.HotSwapper r0 = javassist.util.HotSwapper.this     // Catch: Throwable -> 0x0038
                    r0.hotswap()     // Catch: Throwable -> 0x0038
                    goto L_0x0035
                L_0x0032:
                    goto L_0x0011
                L_0x0035:
                    goto L_0x003e
                L_0x0038:
                    r5 = move-exception
                    r0 = r3
                    r1 = r5
                    r0.errorMsg(r1)
                L_0x003e:
                    r0 = r4
                    if (r0 == 0) goto L_0x0048
                    r0 = r4
                    r0.resume()     // Catch: Throwable -> 0x004b
                L_0x0048:
                    goto L_0x0051
                L_0x004b:
                    r5 = move-exception
                    r0 = r3
                    r1 = r5
                    r0.errorMsg(r1)
                L_0x0051:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: javassist.util.HotSwapper.C52031.run():void");
            }
        }.start();
    }

    EventSet waitEvent() throws InterruptedException {
        return this.jvm.eventQueue().remove();
    }

    void hotswap() {
        this.jvm.redefineClasses(this.newClassFiles);
        this.newClassFiles = null;
    }
}
