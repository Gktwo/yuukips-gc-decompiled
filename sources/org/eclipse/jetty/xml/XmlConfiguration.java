package org.eclipse.jetty.xml;

import dev.morphia.mapping.Mapper;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.stream.Stream;
import javassist.bytecode.DeprecatedAttribute;
import org.eclipse.jetty.util.LazyList;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.Pool;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.annotation.Name;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.xml.XmlParser;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import p001ch.qos.logback.core.joran.action.ActionConst;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/xml/XmlConfiguration.class */
public class XmlConfiguration {
    private static final Logger LOG = Log.getLogger(XmlConfiguration.class);
    private static final Class<?>[] __primitives = {Boolean.TYPE, Character.TYPE, Byte.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Void.TYPE};
    private static final Class<?>[] __boxedPrimitives = {Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Void.class};
    private static final Class<?>[] __supportedCollections = {ArrayList.class, HashSet.class, Queue.class, List.class, Set.class, Collection.class};
    private static final Iterable<ConfigurationProcessorFactory> __factoryLoader = ServiceLoader.load(ConfigurationProcessorFactory.class);
    private static final Pool<ConfigurationParser> __parsers = new Pool<>(Pool.StrategyType.THREAD_ID, Math.min(8, Runtime.getRuntime().availableProcessors()));
    public static final Comparator<Executable> EXECUTABLE_COMPARATOR = e1, e2 -> {
        int count = e1.getParameterCount();
        int compare = Integer.compare(count, e2.getParameterCount());
        if (compare == 0 && count > 0) {
            Parameter[] p1 = e1.getParameters();
            Parameter[] p2 = e2.getParameters();
            int compare2 = Boolean.compare(p1[count - 1].isVarArgs(), p2[count - 1].isVarArgs());
            if (compare2 == 0) {
                for (int i = 0; i < count; i++) {
                    Class<?> t1 = p1[i].getType();
                    Class<?> t2 = p2[i].getType();
                    if (t1 != t2) {
                        compare2 = Boolean.compare(t1.isAssignableFrom(t2), t2.isAssignableFrom(t1));
                        if (compare2 == 0) {
                            compare2 = Boolean.compare(!t1.isPrimitive(), !t2.isPrimitive());
                            if (compare2 == 0) {
                                compare2 = t1.getName().compareTo(t2.getName());
                            }
                        }
                        if (compare2 != 0) {
                            break;
                        }
                    }
                }
            }
            compare = Math.min(1, Math.max(compare2, -1));
        }
        return compare;
    };
    private final Map<String, Object> _idMap;
    private final Map<String, String> _propertyMap;
    private final Resource _location;
    private final String _dtd;
    private ConfigurationProcessor _processor;

    public void setJettyStandardIdsAndProperties(Object server, Resource webapp) {
        if (server != null) {
            try {
                getIdMap().put("Server", server);
            } catch (Exception e) {
                LOG.warn(e);
                return;
            }
        }
        Path home = Paths.get(System.getProperty("jetty.home", Mapper.IGNORED_FIELDNAME), new String[0]);
        getProperties().put("jetty.home", home.toString());
        getProperties().put("jetty.home.uri", normalizeURI(home.toUri().toASCIIString()));
        Path base = Paths.get(System.getProperty("jetty.base", home.toString()), new String[0]);
        getProperties().put("jetty.base", base.toString());
        getProperties().put("jetty.base.uri", normalizeURI(base.toUri().toASCIIString()));
        if (webapp != null) {
            Path webappPath = webapp.getFile().toPath().toAbsolutePath();
            getProperties().put("jetty.webapp", webappPath.toString());
            getProperties().put("jetty.webapps", webappPath.getParent().toString());
            getProperties().put("jetty.webapps.uri", normalizeURI(webapp.getURI().toString()));
        }
    }

    public static String normalizeURI(String uri) {
        if (uri.endsWith("/")) {
            return uri.substring(0, uri.length() - 1);
        }
        return uri;
    }

    ConfigurationParser getParser() {
        Pool<ConfigurationParser>.Entry entry = __parsers.acquire(x$0 -> {
            return new ConfigurationParser(x$0);
        });
        if (entry == null) {
            return new ConfigurationParser(null);
        }
        return entry.getPooled();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x0045
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public XmlConfiguration(org.eclipse.jetty.util.resource.Resource r5) throws org.xml.sax.SAXException, java.io.IOException {
        /*
            r4 = this;
            r0 = r4
            r0.<init>()
            r0 = r4
            java.util.HashMap r1 = new java.util.HashMap
            r2 = r1
            r2.<init>()
            r0._idMap = r1
            r0 = r4
            java.util.HashMap r1 = new java.util.HashMap
            r2 = r1
            r2.<init>()
            r0._propertyMap = r1
            r0 = r4
            org.eclipse.jetty.xml.XmlConfiguration$ConfigurationParser r0 = r0.getParser()
            r6 = r0
            r0 = r5
            java.io.InputStream r0 = r0.getInputStream()     // Catch: Throwable -> 0x0069
            r7 = r0
            r0 = r4
            r1 = r5
            r0._location = r1     // Catch: Throwable -> 0x0069, Throwable -> 0x0045
            r0 = r4
            r1 = r6
            r2 = r7
            org.eclipse.jetty.xml.XmlParser$Node r1 = r1.parse(r2)     // Catch: Throwable -> 0x0069, Throwable -> 0x0045
            r0.setConfig(r1)     // Catch: Throwable -> 0x0069, Throwable -> 0x0045
            r0 = r4
            r1 = r6
            java.lang.String r1 = r1.getDTD()     // Catch: Throwable -> 0x0069, Throwable -> 0x0045
            r0._dtd = r1     // Catch: Throwable -> 0x0069, Throwable -> 0x0045
            r0 = r7
            if (r0 == 0) goto L_0x005e
            r0 = r7
            r0.close()     // Catch: Throwable -> 0x0069
            goto L_0x005e
        L_0x0045:
            r8 = move-exception
            r0 = r7
            if (r0 == 0) goto L_0x005b
            r0 = r7
            r0.close()     // Catch: Throwable -> 0x0052, Throwable -> 0x0069
            goto L_0x005b
        L_0x0052:
            r9 = move-exception
            r0 = r8
            r1 = r9
            r0.addSuppressed(r1)     // Catch: Throwable -> 0x0069
        L_0x005b:
            r0 = r8
            throw r0     // Catch: Throwable -> 0x0069
        L_0x005e:
            r0 = r6
            if (r0 == 0) goto L_0x007f
            r0 = r6
            r0.close()
            goto L_0x007f
        L_0x0069:
            r7 = move-exception
            r0 = r6
            if (r0 == 0) goto L_0x007d
            r0 = r6
            r0.close()     // Catch: Throwable -> 0x0075
            goto L_0x007d
        L_0x0075:
            r8 = move-exception
            r0 = r7
            r1 = r8
            r0.addSuppressed(r1)
        L_0x007d:
            r0 = r7
            throw r0
        L_0x007f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.xml.XmlConfiguration.<init>(org.eclipse.jetty.util.resource.Resource):void");
    }

    @Deprecated
    public XmlConfiguration(URL configuration) throws SAXException, IOException {
        this(Resource.newResource(configuration));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x0064
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @java.lang.Deprecated
    public XmlConfiguration(java.lang.String r5) throws org.xml.sax.SAXException, java.io.IOException {
        /*
            r4 = this;
            r0 = r4
            r0.<init>()
            r0 = r4
            java.util.HashMap r1 = new java.util.HashMap
            r2 = r1
            r2.<init>()
            r0._idMap = r1
            r0 = r4
            java.util.HashMap r1 = new java.util.HashMap
            r2 = r1
            r2.<init>()
            r0._propertyMap = r1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            java.lang.String r1 = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<!DOCTYPE Configure PUBLIC \"-//Jetty//Configure//EN\" \"http://www.eclipse.org/jetty/configure_9_3.dtd\">"
            java.lang.StringBuilder r0 = r0.append(r1)
            r1 = r5
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5 = r0
            r0 = r4
            org.eclipse.jetty.xml.XmlConfiguration$ConfigurationParser r0 = r0.getParser()
            r6 = r0
            java.io.StringReader r0 = new java.io.StringReader     // Catch: Throwable -> 0x0084
            r1 = r0
            r2 = r5
            r1.<init>(r2)     // Catch: Throwable -> 0x0084
            r7 = r0
            org.xml.sax.InputSource r0 = new org.xml.sax.InputSource     // Catch: Throwable -> 0x0084, Throwable -> 0x0064
            r1 = r0
            r2 = r7
            r1.<init>(r2)     // Catch: Throwable -> 0x0084, Throwable -> 0x0064
            r8 = r0
            r0 = r4
            r1 = 0
            r0._location = r1     // Catch: Throwable -> 0x0084, Throwable -> 0x0064
            r0 = r4
            r1 = r6
            r2 = r8
            org.eclipse.jetty.xml.XmlParser$Node r1 = r1.parse(r2)     // Catch: Throwable -> 0x0084, Throwable -> 0x0064
            r0.setConfig(r1)     // Catch: Throwable -> 0x0084, Throwable -> 0x0064
            r0 = r4
            r1 = r6
            java.lang.String r1 = r1.getDTD()     // Catch: Throwable -> 0x0084, Throwable -> 0x0064
            r0._dtd = r1     // Catch: Throwable -> 0x0084, Throwable -> 0x0064
            r0 = r7
            r0.close()     // Catch: Throwable -> 0x0084
            goto L_0x0079
        L_0x0064:
            r8 = move-exception
            r0 = r7
            r0.close()     // Catch: Throwable -> 0x006d, Throwable -> 0x0084
            goto L_0x0076
        L_0x006d:
            r9 = move-exception
            r0 = r8
            r1 = r9
            r0.addSuppressed(r1)     // Catch: Throwable -> 0x0084
        L_0x0076:
            r0 = r8
            throw r0     // Catch: Throwable -> 0x0084
        L_0x0079:
            r0 = r6
            if (r0 == 0) goto L_0x009a
            r0 = r6
            r0.close()
            goto L_0x009a
        L_0x0084:
            r7 = move-exception
            r0 = r6
            if (r0 == 0) goto L_0x0098
            r0 = r6
            r0.close()     // Catch: Throwable -> 0x0090
            goto L_0x0098
        L_0x0090:
            r8 = move-exception
            r0 = r7
            r1 = r8
            r0.addSuppressed(r1)
        L_0x0098:
            r0 = r7
            throw r0
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.xml.XmlConfiguration.<init>(java.lang.String):void");
    }

    @Deprecated
    public XmlConfiguration(InputStream configuration) throws SAXException, IOException {
        this._idMap = new HashMap();
        this._propertyMap = new HashMap();
        InputSource source = new InputSource(configuration);
        ConfigurationParser parser = getParser();
        try {
            this._location = null;
            setConfig(parser.parse(source));
            this._dtd = parser.getDTD();
            if (parser != null) {
                parser.close();
            }
        } catch (Throwable th) {
            if (parser != null) {
                try {
                    parser.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public String toString() {
        if (this._location == null) {
            return "UNKNOWN-LOCATION";
        }
        return this._location.toString();
    }

    private void setConfig(XmlParser.Node config) {
        if ("Configure".equals(config.getTag())) {
            this._processor = new JettyXmlConfiguration();
        } else if (__factoryLoader != null) {
            for (ConfigurationProcessorFactory factory : __factoryLoader) {
                this._processor = factory.getConfigurationProcessor(this._dtd, config.getTag());
                if (this._processor != null) {
                    break;
                }
            }
            if (this._processor == null) {
                throw new IllegalStateException("Unknown configuration type: " + config.getTag() + " in " + this);
            }
        } else {
            throw new IllegalArgumentException("Unknown XML tag:" + config.getTag());
        }
        this._processor.init(this._location, config, this);
    }

    public Map<String, Object> getIdMap() {
        return this._idMap;
    }

    public Map<String, String> getProperties() {
        return this._propertyMap;
    }

    public Object configure(Object obj) throws Exception {
        return this._processor.configure(obj);
    }

    public Object configure() throws Exception {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Configure {}", this._location);
        }
        return this._processor.configure();
    }

    public void initializeDefaults(Object object) {
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/xml/XmlConfiguration$JettyXmlConfiguration.class */
    public static class JettyXmlConfiguration implements ConfigurationProcessor {
        XmlParser.Node _root;
        XmlConfiguration _configuration;

        private JettyXmlConfiguration() {
        }

        @Override // org.eclipse.jetty.xml.ConfigurationProcessor
        public void init(URL url, XmlParser.Node root, XmlConfiguration configuration) {
        }

        @Override // org.eclipse.jetty.xml.ConfigurationProcessor
        public void init(Resource resource, XmlParser.Node root, XmlConfiguration configuration) {
            this._root = root;
            this._configuration = configuration;
        }

        @Override // org.eclipse.jetty.xml.ConfigurationProcessor
        public Object configure(Object obj) throws Exception {
            Class<?> oClass = nodeClass(this._root);
            if (oClass == null || oClass.isInstance(obj)) {
                String id = this._root.getAttribute("id");
                if (id != null) {
                    this._configuration.getIdMap().put(id, obj);
                }
                AttrOrElementNode aoeNode = new AttrOrElementNode(obj, this._root, "Arg");
                aoeNode.getNodes("Arg").forEach(node -> {
                    XmlConfiguration.LOG.warn("Ignored arg {} in {}", node, this._configuration._location);
                });
                configure(obj, this._root, aoeNode.getNext());
                return obj;
            }
            throw new IllegalArgumentException("Object of class '" + obj.getClass().getCanonicalName() + "' is not of type '" + oClass.getCanonicalName() + "'. " + (oClass.getClassLoader() == obj.getClass().getClassLoader() ? "" : "Object Class and type Class are from different loaders.") + " in " + this._configuration);
        }

        @Override // org.eclipse.jetty.xml.ConfigurationProcessor
        public Object configure() throws Exception {
            AttrOrElementNode aoeNode;
            Class<?> oClass = nodeClass(this._root);
            String id = this._root.getAttribute("id");
            Object obj = id == null ? null : this._configuration.getIdMap().get(id);
            if (obj != null || oClass == null) {
                aoeNode = new AttrOrElementNode(obj, this._root, "Arg");
                aoeNode.getNodes("Arg").forEach(node -> {
                    XmlConfiguration.LOG.warn("Ignored arg {} in {}", node, this._configuration._location);
                });
            } else {
                aoeNode = new AttrOrElementNode(this, this._root, "Arg");
                try {
                    obj = construct(oClass, new Args(null, oClass, aoeNode.getNodes("Arg")));
                } catch (NoSuchMethodException e) {
                    throw new IllegalStateException(String.format("No matching constructor %s in %s", oClass, this._configuration));
                }
            }
            if (id != null) {
                this._configuration.getIdMap().put(id, obj);
            }
            this._configuration.initializeDefaults(obj);
            configure(obj, this._root, aoeNode.getNext());
            return obj;
        }

        private static Class<?> nodeClass(XmlParser.Node node) throws ClassNotFoundException {
            String className = node.getAttribute("class");
            if (className == null) {
                return null;
            }
            return Loader.loadClass(className);
        }

        public void configure(Object obj, XmlParser.Node cfg, int i) throws Exception {
            while (i < cfg.size()) {
                Object o = cfg.get(i);
                if (!(o instanceof String)) {
                    XmlParser.Node node = (XmlParser.Node) o;
                    try {
                        String tag = node.getTag();
                        char c = 65535;
                        switch (tag.hashCode()) {
                            case -928497163:
                                if (tag.equals("Property")) {
                                    c = 11;
                                    break;
                                }
                                break;
                            case 2363:
                                if (tag.equals("Id")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 66102:
                                if (tag.equals("Arg")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 69837:
                                if (tag.equals("Env")) {
                                    c = '\r';
                                    break;
                                }
                                break;
                            case 71478:
                                if (tag.equals("Get")) {
                                    c = 6;
                                    break;
                                }
                                break;
                            case 77116:
                                if (tag.equals("Map")) {
                                    c = '\t';
                                    break;
                                }
                                break;
                            case 78208:
                                if (tag.equals("New")) {
                                    c = 7;
                                    break;
                                }
                                break;
                            case 80623:
                                if (tag.equals("Put")) {
                                    c = 4;
                                    break;
                                }
                                break;
                            case 82035:
                                if (tag.equals("Ref")) {
                                    c = '\n';
                                    break;
                                }
                                break;
                            case 83010:
                                if (tag.equals("Set")) {
                                    c = 3;
                                    break;
                                }
                                break;
                            case 2092670:
                                if (tag.equals("Call")) {
                                    c = 5;
                                    break;
                                }
                                break;
                            case 63537721:
                                if (tag.equals("Array")) {
                                    c = '\b';
                                    break;
                                }
                                break;
                            case 65190232:
                                if (tag.equals("Class")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 772399428:
                                if (tag.equals("SystemProperty")) {
                                    c = '\f';
                                    break;
                                }
                                break;
                        }
                        switch (c) {
                            case 0:
                            case 1:
                            case 2:
                                throw new IllegalStateException("Element '" + tag + "' not skipped");
                            case 3:
                                set(obj, node);
                                break;
                            case 4:
                                put(obj, node);
                                break;
                            case 5:
                                call(obj, node);
                                break;
                            case 6:
                                get(obj, node);
                                break;
                            case 7:
                                newObj(obj, node);
                                break;
                            case '\b':
                                newArray(obj, node);
                                break;
                            case '\t':
                                newMap(obj, node);
                                break;
                            case '\n':
                                refObj(node);
                                break;
                            case 11:
                                propertyObj(node);
                                break;
                            case '\f':
                                systemPropertyObj(node);
                                break;
                            case '\r':
                                envObj(node);
                                break;
                            default:
                                throw new IllegalStateException("Unknown tag: " + tag + " in " + this._configuration);
                        }
                    } catch (Exception e) {
                        XmlConfiguration.LOG.warn("Config error at " + node, e.toString() + " in " + this._configuration);
                        throw e;
                    }
                }
                i++;
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:44:0x0195
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        private void set(java.lang.Object r8, org.eclipse.jetty.xml.XmlParser.Node r9) throws java.lang.Exception {
            /*
            // Method dump skipped, instructions count: 944
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.xml.XmlConfiguration.JettyXmlConfiguration.set(java.lang.Object, org.eclipse.jetty.xml.XmlParser$Node):void");
        }

        private Object invokeConstructor(Constructor<?> constructor, Object... args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
            Object result = constructor.newInstance(args);
            if (constructor.getAnnotation(Deprecated.class) != null) {
                XmlConfiguration.LOG.warn("Deprecated constructor {} in {}", constructor, this._configuration);
            }
            return result;
        }

        private Object invokeMethod(Method method, Object obj, Object[] args) throws IllegalAccessException, InvocationTargetException {
            return invokeMethod(method, obj, args, false);
        }

        private Object invokeMethod(Method method, Object obj, Object[] args, boolean isUsingDefaultValue) throws IllegalAccessException, InvocationTargetException {
            Object result = method.invoke(obj, args);
            if (method.getAnnotation(Deprecated.class) != null) {
                if (isUsingDefaultValue) {
                    XmlConfiguration.LOG.debug("Deprecated method {} in {}", method, this._configuration);
                } else {
                    XmlConfiguration.LOG.warn("Deprecated method {} in {}", method, this._configuration);
                }
            }
            return result;
        }

        private Object getField(Field field, Object object) throws IllegalAccessException {
            Object result = field.get(object);
            if (field.getAnnotation(Deprecated.class) != null) {
                XmlConfiguration.LOG.warn("Deprecated field {} in {}", field, this._configuration);
            }
            return result;
        }

        private void setField(Field field, Object obj, Object arg, boolean isUsingDefaultValue) throws IllegalAccessException {
            field.set(obj, arg);
            if (field.getAnnotation(Deprecated.class) == null) {
                return;
            }
            if (isUsingDefaultValue) {
                XmlConfiguration.LOG.debug("Deprecated field {} in {}", field, this._configuration);
            } else {
                XmlConfiguration.LOG.warn("Deprecated field {} in {}", field, this._configuration);
            }
        }

        private static Collection<?> convertArrayToCollection(Object array, Class<?> collectionType) {
            if (array == null) {
                return null;
            }
            Collection<?> collection = null;
            if (array.getClass().isArray()) {
                if (collectionType.isAssignableFrom(ArrayList.class)) {
                    collection = convertArrayToArrayList(array);
                } else if (collectionType.isAssignableFrom(HashSet.class)) {
                    collection = new HashSet<>(convertArrayToArrayList(array));
                }
            }
            if (collection != null) {
                return collection;
            }
            throw new IllegalArgumentException("Can't convert \"" + array.getClass() + "\" to " + collectionType);
        }

        private static ArrayList<Object> convertArrayToArrayList(Object array) {
            int length = Array.getLength(array);
            ArrayList<Object> list = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                list.add(Array.get(array, i));
            }
            return list;
        }

        private void put(Object obj, XmlParser.Node node) throws Exception {
            if (!(obj instanceof Map)) {
                throw new IllegalArgumentException("Object for put is not a Map: " + obj);
            }
            String name = node.getAttribute("name");
            Object value = value(obj, node);
            ((Map) obj).put(name, value);
            if (XmlConfiguration.LOG.isDebugEnabled()) {
                XmlConfiguration.LOG.debug("XML " + obj + ".put(" + name + "," + value + ")", new Object[0]);
            }
        }

        private Object get(Object obj, XmlParser.Node node) throws Exception {
            Class<?> oClass = nodeClass(node);
            if (oClass != null) {
                obj = null;
            } else {
                oClass = obj.getClass();
            }
            String name = node.getAttribute("name");
            String id = node.getAttribute("id");
            if (XmlConfiguration.LOG.isDebugEnabled()) {
                XmlConfiguration.LOG.debug("XML get " + name, new Object[0]);
            }
            try {
                if ("class".equalsIgnoreCase(name)) {
                    obj = oClass;
                } else {
                    obj = invokeMethod(oClass.getMethod(BeanUtil.PREFIX_GETTER_GET + name.substring(0, 1).toUpperCase(Locale.ENGLISH) + name.substring(1), new Class[0]), obj, null, false);
                }
                if (id != null) {
                    this._configuration.getIdMap().put(id, obj);
                }
                configure(obj, node, 0);
            } catch (NoSuchMethodException nsme) {
                try {
                    obj = getField(oClass.getField(name), obj);
                    configure(obj, node, 0);
                } catch (NoSuchFieldException e) {
                    throw nsme;
                }
            }
            return obj;
        }

        private Object call(Object obj, XmlParser.Node node) throws Exception {
            Class<?> oClass;
            AttrOrElementNode aoeNode = new AttrOrElementNode(obj, node, "Id", "Name", "Class", "Arg");
            String id = aoeNode.getString("Id");
            String name = aoeNode.getString("Name");
            String clazz = aoeNode.getString("Class");
            if (clazz != null) {
                oClass = Loader.loadClass(clazz);
                obj = null;
            } else if (obj != null) {
                oClass = obj.getClass();
            } else {
                throw new IllegalArgumentException(node.toString());
            }
            if (XmlConfiguration.LOG.isDebugEnabled()) {
                XmlConfiguration.LOG.debug("XML call " + name, new Object[0]);
            }
            try {
                Object nobj = call(oClass, name, obj, new Args(obj, oClass, aoeNode.getNodes("Arg")));
                if (id != null) {
                    this._configuration.getIdMap().put(id, nobj);
                }
                configure(nobj, node, aoeNode.getNext());
                return nobj;
            } catch (NoSuchMethodException e) {
                throw new IllegalStateException("No Method: " + node + " on " + oClass, e);
            }
        }

        private Object call(Class<?> oClass, String methodName, Object obj, Args args) throws InvocationTargetException, NoSuchMethodException {
            Object[] arguments;
            Objects.requireNonNull(oClass, "Class cannot be null");
            Objects.requireNonNull(methodName, "Method name cannot be null");
            if (StringUtil.isBlank(methodName)) {
                throw new IllegalArgumentException("Method name cannot be blank");
            }
            Method[] methods = oClass.getMethods();
            Arrays.sort(methods, XmlConfiguration.EXECUTABLE_COMPARATOR);
            for (Method method : methods) {
                if (method.getName().equals(methodName) && (arguments = args.applyTo(method)) != null) {
                    if (Modifier.isStatic(method.getModifiers()) == (obj == null) && (obj != null || method.getDeclaringClass() == oClass)) {
                        try {
                            return invokeMethod(method, obj, arguments);
                        } catch (IllegalAccessException | IllegalArgumentException e) {
                            XmlConfiguration.LOG.ignore(e);
                        }
                    }
                }
            }
            throw new NoSuchMethodException(methodName);
        }

        private Object newObj(Object obj, XmlParser.Node node) throws Exception {
            AttrOrElementNode aoeNode = new AttrOrElementNode(obj, node, "Id", "Class", "Arg");
            String id = aoeNode.getString("Id");
            String clazz = aoeNode.getString("Class");
            if (XmlConfiguration.LOG.isDebugEnabled()) {
                XmlConfiguration.LOG.debug("XML new " + clazz, new Object[0]);
            }
            Class<?> oClass = Loader.loadClass(clazz);
            try {
                Object nobj = construct(oClass, new Args(obj, oClass, aoeNode.getNodes("Arg")));
                if (id != null) {
                    this._configuration.getIdMap().put(id, nobj);
                }
                this._configuration.initializeDefaults(nobj);
                configure(nobj, node, aoeNode.getNext());
                return nobj;
            } catch (NoSuchMethodException e) {
                throw new IllegalStateException("No suitable constructor: " + node + " on " + obj);
            }
        }

        private Object construct(Class<?> klass, Args args) throws InvocationTargetException, NoSuchMethodException {
            Object[] arguments;
            Objects.requireNonNull(klass, "Class cannot be null");
            Objects.requireNonNull(args, "Named list cannot be null");
            Constructor<?>[] constructors = klass.getConstructors();
            Arrays.sort(constructors, XmlConfiguration.EXECUTABLE_COMPARATOR);
            for (Constructor<?> constructor : constructors) {
                try {
                    arguments = args.applyTo(constructor);
                } catch (IllegalAccessException | IllegalArgumentException | InstantiationException e) {
                    XmlConfiguration.LOG.ignore(e);
                }
                if (arguments != null) {
                    return invokeConstructor(constructor, arguments);
                }
                continue;
            }
            throw new NoSuchMethodException("<init>");
        }

        private Object refObj(XmlParser.Node node) throws Exception {
            String refid = node.getAttribute("refid");
            if (refid == null) {
                refid = node.getAttribute("id");
            }
            Object obj = this._configuration.getIdMap().get(refid);
            if (obj != null || node.size() <= 0) {
                configure(obj, node, 0);
                return obj;
            }
            throw new IllegalStateException("No object for refid=" + refid);
        }

        private Object newArray(Object obj, XmlParser.Node node) throws Exception {
            AttrOrElementNode aoeNode = new AttrOrElementNode(obj, node, "Id", "Type", "Item");
            String id = aoeNode.getString("Id");
            String type = aoeNode.getString("Type");
            List<XmlParser.Node> items = aoeNode.getNodes("Item");
            Class<?> aClass = Object.class;
            if (type != null) {
                aClass = TypeUtil.fromName(type);
                if (aClass == null) {
                    char c = 65535;
                    switch (type.hashCode()) {
                        case -1808118735:
                            if (type.equals("String")) {
                                c = 0;
                                break;
                            }
                            break;
                        case 84303:
                            if (type.equals("URL")) {
                                c = 1;
                                break;
                            }
                            break;
                        case 480110752:
                            if (type.equals("InetAddress")) {
                                c = 2;
                                break;
                            }
                            break;
                    }
                    switch (c) {
                        case 0:
                            aClass = String.class;
                            break;
                        case 1:
                            aClass = URL.class;
                            break;
                        case 2:
                            aClass = InetAddress.class;
                            break;
                        default:
                            aClass = Loader.loadClass(type);
                            break;
                    }
                }
            }
            Object al = null;
            for (XmlParser.Node item : items) {
                String nid = item.getAttribute("id");
                Object v = value(obj, item);
                al = LazyList.add(al, (v != null || !aClass.isPrimitive()) ? v : 0);
                if (nid != null) {
                    this._configuration.getIdMap().put(nid, v);
                }
            }
            Object array = LazyList.toArray(al, aClass);
            if (id != null) {
                this._configuration.getIdMap().put(id, array);
            }
            return array;
        }

        private Object newMap(Object obj, XmlParser.Node node) throws Exception {
            AttrOrElementNode aoeNode = new AttrOrElementNode(this, node, "Id", "Entry");
            String id = aoeNode.getString("Id");
            List<XmlParser.Node> entries = aoeNode.getNodes("Entry");
            Map<Object, Object> map = new HashMap<>();
            if (id != null) {
                this._configuration.getIdMap().put(id, map);
            }
            for (XmlParser.Node entry : entries) {
                if (!entry.getTag().equals("Entry")) {
                    throw new IllegalStateException("Not an Entry");
                }
                XmlParser.Node key = null;
                XmlParser.Node value = null;
                Iterator<Object> it = entry.iterator();
                while (it.hasNext()) {
                    Object object = it.next();
                    if (!(object instanceof String)) {
                        XmlParser.Node item = (XmlParser.Node) object;
                        if (!item.getTag().equals("Item")) {
                            throw new IllegalStateException("Not an Item");
                        } else if (key == null) {
                            key = item;
                        } else {
                            value = item;
                        }
                    }
                }
                if (key == null || value == null) {
                    throw new IllegalStateException("Missing Item in Entry");
                }
                String kid = key.getAttribute("id");
                String vid = value.getAttribute("id");
                Object k = value(obj, key);
                Object v = value(obj, value);
                map.put(k, v);
                if (kid != null) {
                    this._configuration.getIdMap().put(kid, k);
                }
                if (vid != null) {
                    this._configuration.getIdMap().put(vid, v);
                }
            }
            return map;
        }

        private Object propertyObj(XmlParser.Node node) throws Exception {
            AttrOrElementNode aoeNode = new AttrOrElementNode(this, node, "Id", "Name", DeprecatedAttribute.tag, "Default");
            String id = aoeNode.getString("Id");
            String name = aoeNode.getString("Name", true);
            List<Object> deprecated = aoeNode.getList(DeprecatedAttribute.tag);
            String dftValue = aoeNode.getString("Default");
            Map<String, String> properties = this._configuration.getProperties();
            String value = properties.get(name);
            String alternate = null;
            if (!deprecated.isEmpty()) {
                for (Object d : deprecated) {
                    String v = properties.get(StringUtil.valueOf(d));
                    if (v != null) {
                        if (value == null) {
                            XmlConfiguration.LOG.warn("Property '{}' is deprecated, use '{}' instead", d, name);
                        } else {
                            XmlConfiguration.LOG.warn("Property '{}' is deprecated, value from '{}' used", d, name);
                        }
                    }
                    if (alternate == null) {
                        alternate = v;
                    }
                }
            }
            if (value == null) {
                value = alternate;
            }
            if (value == null) {
                value = dftValue;
            }
            if (id != null) {
                this._configuration.getIdMap().put(id, value);
            }
            return value;
        }

        private Object systemPropertyObj(XmlParser.Node node) throws Exception {
            AttrOrElementNode aoeNode = new AttrOrElementNode(this, node, "Id", "Name", DeprecatedAttribute.tag, "Default");
            String id = aoeNode.getString("Id");
            String name = aoeNode.getString("Name", true);
            List<Object> deprecated = aoeNode.getList(DeprecatedAttribute.tag);
            String dftValue = aoeNode.getString("Default");
            String value = System.getProperty(name);
            String alternate = null;
            if (!deprecated.isEmpty()) {
                for (Object d : deprecated) {
                    if (d != null) {
                        String v = System.getProperty(d.toString());
                        if (v != null) {
                            if (value == null) {
                                XmlConfiguration.LOG.warn("SystemProperty '{}' is deprecated, use '{}' instead", d, name);
                            } else {
                                XmlConfiguration.LOG.warn("SystemProperty '{}' is deprecated, value from '{}' used", d, name);
                            }
                        }
                        if (alternate == null) {
                            alternate = v;
                        }
                    }
                }
            }
            if (value == null) {
                value = alternate;
            }
            if (value == null) {
                value = dftValue;
            }
            if (id != null) {
                this._configuration.getIdMap().put(id, value);
            }
            return value;
        }

        private Object envObj(XmlParser.Node node) throws Exception {
            AttrOrElementNode aoeNode = new AttrOrElementNode(this, node, "Id", "Name", DeprecatedAttribute.tag, "Default");
            String id = aoeNode.getString("Id");
            String name = aoeNode.getString("Name", true);
            List<Object> deprecated = aoeNode.getList(DeprecatedAttribute.tag);
            String dftValue = aoeNode.getString("Default");
            String value = System.getenv(name);
            if (value == null && !deprecated.isEmpty()) {
                Iterator<Object> it = deprecated.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object d = it.next();
                    value = System.getenv(StringUtil.valueOf(d));
                    if (value != null) {
                        XmlConfiguration.LOG.warn("Property '{}' is deprecated, use '{}' instead", d, name);
                        break;
                    }
                }
            }
            if (value == null) {
                value = dftValue;
            }
            if (id != null) {
                this._configuration.getIdMap().put(id, value);
            }
            return value;
        }

        private String defaultValue(Object obj, XmlParser.Node node) throws Exception {
            StringBuilder ret = new StringBuilder();
            appendDefaultPropertyValues(ret, node);
            return ret.toString();
        }

        private void appendDefaultPropertyValues(StringBuilder defValues, XmlParser.Node node) throws Exception {
            String dftValue;
            Iterator<Object> it = node.iterator();
            while (it.hasNext()) {
                Object child = it.next();
                if (child instanceof XmlParser.Node) {
                    XmlParser.Node childNode = (XmlParser.Node) child;
                    String tag = childNode.getTag();
                    if (("Property".equals(tag) || "SystemProperty".equals(tag)) && (dftValue = new AttrOrElementNode(this, childNode, "Id", "Name", DeprecatedAttribute.tag, "Default").getString("Default")) != null) {
                        defValues.append(dftValue);
                    }
                    appendDefaultPropertyValues(defValues, childNode);
                }
            }
        }

        /* access modifiers changed from: private */
        public Object value(Object obj, XmlParser.Node node) throws Exception {
            Object value;
            String type = node.getAttribute("type");
            String ref = node.getAttribute(ActionConst.REF_ATTRIBUTE);
            if (ref != null) {
                value = this._configuration.getIdMap().get(ref);
            } else if (node.size() != 0) {
                int first = 0;
                int last = node.size() - 1;
                if (!"String".equals(type)) {
                    while (first <= last) {
                        Object item = node.get(first);
                        if (!(item instanceof String) || ((String) item).trim().length() > 0) {
                            break;
                        }
                        first++;
                    }
                    while (first < last) {
                        Object item2 = node.get(last);
                        if (!(item2 instanceof String) || ((String) item2).trim().length() > 0) {
                            break;
                        }
                        last--;
                    }
                    if (first > last) {
                        return null;
                    }
                    if (first == last) {
                        value = itemValue(obj, node.get(first));
                        if (value instanceof String) {
                            value = ((String) value).trim();
                        }
                    } else {
                        StringBuilder buf = new StringBuilder();
                        for (int i = first; i <= last; i++) {
                            buf.append(itemValue(obj, node.get(i)));
                        }
                        value = buf.toString().trim();
                    }
                } else if (0 == last) {
                    value = itemValue(obj, node.get(0));
                } else {
                    StringBuilder buf2 = new StringBuilder();
                    for (int i2 = 0; i2 <= last; i2++) {
                        buf2.append(itemValue(obj, node.get(i2)));
                    }
                    value = buf2.toString();
                }
            } else if ("String".equals(type)) {
                return "";
            } else {
                return null;
            }
            if (value == null) {
                if ("String".equals(type)) {
                    return "";
                }
                return null;
            } else if (type == null) {
                return value;
            } else {
                if (isTypeMatchingClass(type, String.class)) {
                    return value.toString();
                }
                Class<?> pClass = TypeUtil.fromName(type);
                if (pClass != null) {
                    return TypeUtil.valueOf(pClass, value.toString());
                }
                if (isTypeMatchingClass(type, URL.class)) {
                    if (value instanceof URL) {
                        return value;
                    }
                    try {
                        return new URL(value.toString());
                    } catch (MalformedURLException e) {
                        throw new InvocationTargetException(e);
                    }
                } else if (!isTypeMatchingClass(type, InetAddress.class)) {
                    Class<?>[] clsArr = XmlConfiguration.__supportedCollections;
                    for (Class<?> collectionClass : clsArr) {
                        if (isTypeMatchingClass(type, collectionClass)) {
                            return convertArrayToCollection(value, collectionClass);
                        }
                    }
                    throw new IllegalStateException("Unknown type " + type);
                } else if (value instanceof InetAddress) {
                    return value;
                } else {
                    try {
                        return InetAddress.getByName(value.toString());
                    } catch (UnknownHostException e2) {
                        throw new InvocationTargetException(e2);
                    }
                }
            }
        }

        private static boolean isTypeMatchingClass(String type, Class<?> classToMatch) {
            return classToMatch.getSimpleName().equalsIgnoreCase(type) || classToMatch.getName().equals(type);
        }

        private Object itemValue(Object obj, Object item) throws Exception {
            if (item instanceof String) {
                return item;
            }
            XmlParser.Node node = (XmlParser.Node) item;
            String tag = node.getTag();
            if ("Call".equals(tag)) {
                return call(obj, node);
            }
            if ("Get".equals(tag)) {
                return get(obj, node);
            }
            if ("New".equals(tag)) {
                return newObj(obj, node);
            }
            if ("Ref".equals(tag)) {
                return refObj(node);
            }
            if ("Array".equals(tag)) {
                return newArray(obj, node);
            }
            if ("Map".equals(tag)) {
                return newMap(obj, node);
            }
            if ("Property".equals(tag)) {
                return propertyObj(node);
            }
            if ("SystemProperty".equals(tag)) {
                return systemPropertyObj(node);
            }
            if ("Env".equals(tag)) {
                return envObj(node);
            }
            XmlConfiguration.LOG.warn("Unknown value tag: " + node + " in " + this._configuration, new Throwable());
            return null;
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:org/eclipse/jetty/xml/XmlConfiguration$JettyXmlConfiguration$AttrOrElementNode.class */
        public class AttrOrElementNode {
            final Object _obj;
            final XmlParser.Node _node;
            final Set<String> _elements;
            final int _next;

            AttrOrElementNode(JettyXmlConfiguration jettyXmlConfiguration, XmlParser.Node node, String... elements) {
                this(null, node, elements);
            }

            AttrOrElementNode(Object obj, XmlParser.Node node, String... elements) {
                this._elements = new HashSet();
                this._obj = obj;
                this._node = node;
                Collections.addAll(this._elements, elements);
                int next = 0;
                Iterator<Object> it = this._node.iterator();
                while (it.hasNext()) {
                    Object o = it.next();
                    if (o instanceof String) {
                        if (((String) o).trim().length() != 0) {
                            break;
                        }
                        next++;
                    } else if (!(o instanceof XmlParser.Node)) {
                        break;
                    } else {
                        if (!this._elements.contains(((XmlParser.Node) o).getTag())) {
                            break;
                        }
                        next++;
                    }
                }
                this._next = next;
            }

            public int getNext() {
                return this._next;
            }

            public String getString(String elementName) throws Exception {
                return StringUtil.valueOf(get(elementName, false));
            }

            public String getString(String elementName, boolean mandatory) throws Exception {
                return StringUtil.valueOf(get(elementName, mandatory));
            }

            public Object get(String elementName, boolean mandatory) throws Exception {
                String attrName = StringUtil.asciiToLowerCase(elementName);
                String attr = this._node.getAttribute(attrName);
                Object value = attr;
                int i = 0;
                while (true) {
                    if (i >= this._next) {
                        break;
                    }
                    Object o = this._node.get(i);
                    if (o instanceof XmlParser.Node) {
                        XmlParser.Node n = (XmlParser.Node) o;
                        if (elementName.equals(n.getTag())) {
                            if (attr != null) {
                                throw new IllegalStateException("Cannot have attr '" + attrName + "' and element '" + elementName + "'");
                            }
                            value = JettyXmlConfiguration.this.value(this._obj, n);
                        }
                    }
                    i++;
                }
                if (!mandatory || value != null) {
                    return value;
                }
                throw new IllegalStateException("Must have attr '" + attrName + "' or element '" + elementName + "'");
            }

            public List<Object> getList(String elementName) throws Exception {
                return getList(elementName, false);
            }

            public List<Object> getList(String elementName, boolean manditory) throws Exception {
                String attrName = StringUtil.asciiToLowerCase(elementName);
                List<Object> values = new ArrayList<>();
                String attr = this._node.getAttribute(attrName);
                if (attr != null) {
                    values.addAll(StringUtil.csvSplit(null, attr, 0, attr.length()));
                }
                for (int i = 0; i < this._next; i++) {
                    Object o = this._node.get(i);
                    if (o instanceof XmlParser.Node) {
                        XmlParser.Node n = (XmlParser.Node) o;
                        if (!elementName.equals(n.getTag())) {
                            continue;
                        } else if (attr != null) {
                            throw new IllegalStateException("Cannot have attr '" + attrName + "' and element '" + elementName + "'");
                        } else {
                            values.add(JettyXmlConfiguration.this.value(this._obj, n));
                        }
                    }
                }
                if (!manditory || !values.isEmpty()) {
                    return values;
                }
                throw new IllegalStateException("Must have attr '" + attrName + "' or element '" + elementName + "'");
            }

            public List<XmlParser.Node> getNodes(String elementName) {
                return XmlConfiguration.getNodes(this._node, elementName);
            }
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:org/eclipse/jetty/xml/XmlConfiguration$JettyXmlConfiguration$Args.class */
        public class Args {
            private final Class<?> _class;
            private final List<Object> _arguments;
            private final List<String> _names;

            private Args(Object obj, Class<?> oClass, List<XmlParser.Node> args) throws Exception {
                this._class = oClass;
                this._arguments = new ArrayList();
                this._names = new ArrayList();
                for (XmlParser.Node child : args) {
                    this._arguments.add(JettyXmlConfiguration.this.value(obj, child));
                    this._names.add(child.getAttribute("name"));
                }
            }

            private Args(List<Object> arguments, List<String> names) {
                this._class = null;
                this._arguments = arguments;
                this._names = names;
            }

            Object[] applyTo(Executable executable) {
                int count;
                Object[] args = matchArgsToParameters(executable);
                if (args == null && this._class != null && (count = executable.getParameterCount()) > 0 && executable.getParameters()[count - 1].isVarArgs()) {
                    args = asEmptyVarArgs(executable.getParameterTypes()[count - 1]).matchArgsToParameters(executable);
                }
                return args;
            }

            Args asEmptyVarArgs(Class<?> varArgType) {
                List<Object> arguments = new ArrayList<>(this._arguments);
                arguments.add(Array.newInstance(varArgType.getComponentType(), 0));
                List<String> names = new ArrayList<>(this._names);
                names.add(null);
                return new Args(arguments, names);
            }

            Object[] matchArgsToParameters(Executable executable) {
                Object[] args;
                int count = executable.getParameterCount();
                if (count != this._arguments.size()) {
                    return null;
                }
                if (count == 0) {
                    return new Object[0];
                }
                if (this._names.stream().noneMatch((v0) -> {
                    return Objects.nonNull(v0);
                })) {
                    args = this._arguments.toArray(new Object[0]);
                } else {
                    Annotation[][] parameterAnnotations = executable.getParameterAnnotations();
                    if (parameterAnnotations == null || parameterAnnotations.length == 0) {
                        return null;
                    }
                    Map<String, Integer> position = new HashMap<>();
                    int p = 0;
                    for (Annotation[] paramAnnotation : parameterAnnotations) {
                        p++;
                        Integer pos = Integer.valueOf(p);
                        Stream stream = Arrays.stream(paramAnnotation);
                        Objects.requireNonNull(Name.class);
                        Stream filter = stream.filter((v1) -> {
                            return r1.isInstance(v1);
                        });
                        Objects.requireNonNull(Name.class);
                        filter.map((v1) -> {
                            return r1.cast(v1);
                        }).findFirst().ifPresent(n -> {
                            position.put(n.value(), pos);
                        });
                    }
                    List<Object> arguments = new ArrayList<>(this._arguments);
                    List<String> names = new ArrayList<>(this._names);
                    int p2 = 0;
                    while (p2 < count) {
                        String name = names.get(p2);
                        if (name != null) {
                            Integer pos2 = position.get(name);
                            if (pos2 == null) {
                                return null;
                            }
                            if (pos2.intValue() != p2) {
                                arguments.add(pos2.intValue(), arguments.remove(p2));
                                names.add(pos2.intValue(), names.remove(p2));
                                p2 = Math.min(p2, pos2.intValue());
                            }
                        }
                        p2++;
                    }
                    args = arguments.toArray(new Object[0]);
                }
                return args;
            }
        }
    }

    /* access modifiers changed from: private */
    public static List<XmlParser.Node> getNodes(XmlParser.Node node, String elementName) {
        String attrName = StringUtil.asciiToLowerCase(elementName);
        List<XmlParser.Node> values = new ArrayList<>();
        String attr = node.getAttribute(attrName);
        if (attr != null) {
            for (String a : StringUtil.csvSplit(null, attr, 0, attr.length())) {
                XmlParser.Node n = new XmlParser.Node(null, elementName, null);
                n.add(a);
                values.add(n);
            }
        }
        Iterator<Object> it = node.iterator();
        while (it.hasNext()) {
            Object o = it.next();
            if (o instanceof XmlParser.Node) {
                XmlParser.Node n2 = (XmlParser.Node) o;
                if (!elementName.equals(n2.getTag())) {
                    continue;
                } else if (attr != null) {
                    throw new IllegalStateException("Cannot have attr '" + attrName + "' and element '" + elementName + "'");
                } else {
                    values.add(n2);
                }
            }
        }
        return values;
    }

    public static void main(String... args) throws Exception {
        try {
            AccessController.doPrivileged(() -> {
                Properties properties = new Properties();
                properties.putAll(System.getProperties());
                for (String arg : args) {
                    if (arg.indexOf(61) >= 0) {
                        int i = arg.indexOf(61);
                        properties.put(arg.substring(0, i), arg.substring(i + 1));
                    } else if (arg.toLowerCase(Locale.ENGLISH).endsWith(".properties")) {
                        properties.load(Resource.newResource(arg).getInputStream());
                    }
                }
                XmlConfiguration last = null;
                List<Object> objects = new ArrayList<>(args.length);
                for (String arg2 : args) {
                    if (!arg2.toLowerCase(Locale.ENGLISH).endsWith(".properties") && arg2.indexOf(61) < 0) {
                        XmlConfiguration configuration = new XmlConfiguration(Resource.newResource(arg2));
                        if (last != null) {
                            configuration.getIdMap().putAll(last.getIdMap());
                        }
                        if (properties.size() > 0) {
                            Map<String, String> props = new HashMap<>();
                            properties.entrySet().stream().forEach(objectObjectEntry -> {
                                props.put(objectObjectEntry.getKey().toString(), String.valueOf(objectObjectEntry.getValue()));
                            });
                            configuration.getProperties().putAll(props);
                        }
                        Object obj = configuration.configure();
                        if (obj != null && !objects.contains(obj)) {
                            objects.add(obj);
                        }
                        last = configuration;
                    }
                }
                for (Object obj2 : objects) {
                    if (obj2 instanceof LifeCycle) {
                        LifeCycle lc = (LifeCycle) obj2;
                        if (!lc.isRunning()) {
                            lc.start();
                        }
                    }
                }
                return null;
            });
        } catch (Error | Exception e) {
            LOG.warn(e);
            throw e;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/xml/XmlConfiguration$ConfigurationParser.class */
    public static class ConfigurationParser extends XmlParser implements AutoCloseable {
        private final Pool<ConfigurationParser>.Entry _entry;

        private ConfigurationParser(Pool<ConfigurationParser>.Entry entry) {
            this._entry = entry;
            ClassLoader loader = XmlConfiguration.class.getClassLoader();
            URL config60 = loader.getResource("org/eclipse/jetty/xml/configure_6_0.dtd");
            URL config76 = loader.getResource("org/eclipse/jetty/xml/configure_7_6.dtd");
            URL config90 = loader.getResource("org/eclipse/jetty/xml/configure_9_0.dtd");
            URL config93 = loader.getResource("org/eclipse/jetty/xml/configure_9_3.dtd");
            redirectEntity("configure.dtd", config90);
            redirectEntity("configure_1_0.dtd", config60);
            redirectEntity("configure_1_1.dtd", config60);
            redirectEntity("configure_1_2.dtd", config60);
            redirectEntity("configure_1_3.dtd", config60);
            redirectEntity("configure_6_0.dtd", config60);
            redirectEntity("configure_7_6.dtd", config76);
            redirectEntity("configure_9_0.dtd", config90);
            redirectEntity("configure_9_3.dtd", config93);
            redirectEntity("http://jetty.mortbay.org/configure.dtd", config93);
            redirectEntity("http://jetty.eclipse.org/configure.dtd", config93);
            redirectEntity("https://jetty.eclipse.org/configure.dtd", config93);
            redirectEntity("http://www.eclipse.org/jetty/configure.dtd", config93);
            redirectEntity("https://www.eclipse.org/jetty/configure.dtd", config93);
            redirectEntity("-//Mort Bay Consulting//DTD Configure//EN", config93);
            redirectEntity("-//Jetty//Configure//EN", config93);
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            if (this._entry != null) {
                XmlConfiguration.__parsers.release(this._entry);
            }
        }
    }
}
