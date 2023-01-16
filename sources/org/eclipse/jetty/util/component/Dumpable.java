package org.eclipse.jetty.util.component;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.ManagedOperation;

@ManagedObject("Dumpable Object")
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/component/Dumpable.class */
public interface Dumpable {
    public static final String KEY = "key: +- bean, += managed, +~ unmanaged, +? auto, +: iterable, +] array, +@ map, +> undefined";

    void dump(Appendable appendable, String str) throws IOException;

    @ManagedOperation(value = "Dump the nested Object state as a String", impact = "INFO")
    default String dump() {
        return dump(this);
    }

    static String dump(Dumpable dumpable) {
        StringBuilder b = new StringBuilder();
        try {
            dumpable.dump(b, "");
        } catch (IOException e) {
            b.append(e.toString());
        }
        b.append(KEY);
        return b.toString();
    }

    default String dumpSelf() {
        return toString();
    }

    static void dumpObject(Appendable out, Object o) throws IOException {
        String s;
        if (o == null) {
            s = "null";
        } else {
            try {
                if (o instanceof Dumpable) {
                    s = StringUtil.replace(StringUtil.replace(((Dumpable) o).dumpSelf(), "\r\n", "|"), '\n', '|');
                } else if (o instanceof Collection) {
                    s = String.format("%s@%x(size=%d)", o.getClass().getName(), Integer.valueOf(o.hashCode()), Integer.valueOf(((Collection) o).size()));
                } else if (o.getClass().isArray()) {
                    s = String.format("%s@%x[size=%d]", o.getClass().getComponentType(), Integer.valueOf(o.hashCode()), Integer.valueOf(Array.getLength(o)));
                } else if (o instanceof Map) {
                    s = String.format("%s@%x{size=%d}", o.getClass().getName(), Integer.valueOf(o.hashCode()), Integer.valueOf(((Map) o).size()));
                } else {
                    s = StringUtil.replace(StringUtil.replace(String.valueOf(o), "\r\n", "|"), '\n', '|');
                }
            } catch (Throwable ex) {
                out.append("=> ").append(ex.toString()).append("\n");
                return;
            }
        }
        if (o instanceof LifeCycle) {
            out.append(s).append(" - ").append(AbstractLifeCycle.getState((LifeCycle) o)).append("\n");
        } else {
            out.append(s).append("\n");
        }
    }

    static void dumpObjects(Appendable out, String indent, Object object, Object... extraChildren) throws IOException {
        dumpObject(out, object);
        int extras = extraChildren == null ? 0 : extraChildren.length;
        if (object instanceof Stream) {
            object = ((Stream) object).toArray();
        }
        if (object instanceof Array) {
            object = Arrays.asList((Object[]) object);
        }
        if (object instanceof Container) {
            dumpContainer(out, indent, (Container) object, extras == 0);
        }
        if (object instanceof Iterable) {
            dumpIterable(out, indent, (Iterable) object, extras == 0);
        } else if (object instanceof Map) {
            dumpMapEntries(out, indent, (Map) object, extras == 0);
        }
        if (extras != 0) {
            int i = 0;
            for (Object item : extraChildren) {
                i++;
                String nextIndent = indent + (i < extras ? "|  " : "   ");
                out.append(indent).append("+> ");
                if (item instanceof Dumpable) {
                    ((Dumpable) item).dump(out, nextIndent);
                } else {
                    dumpObjects(out, nextIndent, item, new Object[0]);
                }
            }
        }
    }

    static void dumpContainer(Appendable out, String indent, Container object, boolean last) throws IOException {
        ContainerLifeCycle containerLifeCycle = object instanceof ContainerLifeCycle ? (ContainerLifeCycle) object : null;
        Iterator<Object> i = object.getBeans().iterator();
        while (i.hasNext()) {
            Object bean = i.next();
            if (!(object instanceof DumpableContainer) || ((DumpableContainer) object).isDumpable(bean)) {
                String nextIndent = indent + ((i.hasNext() || !last) ? "|  " : "   ");
                if (bean instanceof LifeCycle) {
                    if (object.isManaged(bean)) {
                        out.append(indent).append("+= ");
                        if (bean instanceof Dumpable) {
                            ((Dumpable) bean).dump(out, nextIndent);
                        } else {
                            dumpObjects(out, nextIndent, bean, new Object[0]);
                        }
                    } else if (containerLifeCycle == null || !containerLifeCycle.isAuto(bean)) {
                        out.append(indent).append("+~ ");
                        dumpObject(out, bean);
                    } else {
                        out.append(indent).append("+? ");
                        if (bean instanceof Dumpable) {
                            ((Dumpable) bean).dump(out, nextIndent);
                        } else {
                            dumpObjects(out, nextIndent, bean, new Object[0]);
                        }
                    }
                } else if (containerLifeCycle == null || !containerLifeCycle.isUnmanaged(bean)) {
                    out.append(indent).append("+- ");
                    if (bean instanceof Dumpable) {
                        ((Dumpable) bean).dump(out, nextIndent);
                    } else {
                        dumpObjects(out, nextIndent, bean, new Object[0]);
                    }
                } else {
                    out.append(indent).append("+~ ");
                    dumpObject(out, bean);
                }
            }
        }
    }

    static void dumpIterable(Appendable out, String indent, Iterable<?> iterable, boolean last) throws IOException {
        Iterator i = iterable.iterator();
        while (i.hasNext()) {
            Object item = i.next();
            String nextIndent = indent + ((i.hasNext() || !last) ? "|  " : "   ");
            out.append(indent).append("+: ");
            if (item instanceof Dumpable) {
                ((Dumpable) item).dump(out, nextIndent);
            } else {
                dumpObjects(out, nextIndent, item, new Object[0]);
            }
        }
    }

    static void dumpMapEntries(Appendable out, String indent, Map<?, ?> map, boolean last) throws IOException {
        Iterator<? extends Map.Entry<?, ?>> i = map.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<?, ?> entry = i.next();
            String nextIndent = indent + ((i.hasNext() || !last) ? "|  " : "   ");
            out.append(indent).append("+@ ").append(String.valueOf(entry.getKey())).append(" = ");
            Object item = entry.getValue();
            if (item instanceof Dumpable) {
                ((Dumpable) item).dump(out, nextIndent);
            } else {
                dumpObjects(out, nextIndent, item, new Object[0]);
            }
        }
    }

    static Dumpable named(String name, Object object) {
        return out, indent -> {
            out.append(name).append(": ");
            dumpObjects(out, indent, object, new Object[0]);
        };
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/component/Dumpable$DumpableContainer.class */
    public interface DumpableContainer extends Dumpable {
        default boolean isDumpable(Object o) {
            return true;
        }
    }
}
