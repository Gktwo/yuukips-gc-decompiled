package org.eclipse.jetty.server;

import java.io.IOException;
import java.net.URLClassLoader;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.component.DumpableCollection;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/ClassLoaderDump.class */
public class ClassLoaderDump implements Dumpable {
    final ClassLoader _loader;

    public ClassLoaderDump(ClassLoader loader) {
        this._loader = loader;
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dump() {
        return Dumpable.dump(this);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        if (this._loader == null) {
            out.append("No ClassLoader\n");
        } else if (this._loader instanceof Dumpable) {
            ((Dumpable) this._loader).dump(out, indent);
        } else if (this._loader instanceof URLClassLoader) {
            String loader = this._loader.toString();
            DumpableCollection urls = DumpableCollection.fromArray("URLs", ((URLClassLoader) this._loader).getURLs());
            ClassLoader parent = this._loader.getParent();
            if (parent == null) {
                Dumpable.dumpObjects(out, indent, loader, urls);
            } else if (parent == Server.class.getClassLoader()) {
                Dumpable.dumpObjects(out, indent, loader, urls, parent.toString());
            } else if (parent instanceof Dumpable) {
                Dumpable.dumpObjects(out, indent, loader, urls, parent);
            } else {
                Dumpable.dumpObjects(out, indent, loader, urls, new ClassLoaderDump(parent));
            }
        } else {
            String loader2 = this._loader.toString();
            ClassLoader parent2 = this._loader.getParent();
            if (parent2 == null) {
                Dumpable.dumpObject(out, loader2);
            }
            if (parent2 == Server.class.getClassLoader()) {
                Dumpable.dumpObjects(out, indent, loader2, parent2.toString());
            } else if (parent2 instanceof Dumpable) {
                Dumpable.dumpObjects(out, indent, loader2, parent2);
            } else if (parent2 != null) {
                Dumpable.dumpObjects(out, indent, loader2, new ClassLoaderDump(parent2));
            }
        }
    }
}
