package org.eclipse.jetty.webapp;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.EmptyResource;
import org.eclipse.jetty.util.resource.Resource;
import org.jline.reader.impl.LineReaderImpl;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/MetaData.class */
public class MetaData {
    public static final String VALIDATE_XML = "org.eclipse.jetty.webapp.validateXml";
    public static final String ORDERED_LIBS = "javax.servlet.context.orderedLibs";
    protected WebDescriptor _webDefaultsRoot;
    protected WebDescriptor _webXmlRoot;
    protected boolean _metaDataComplete;
    protected Ordering _ordering;
    private static final Logger LOG = Log.getLogger(MetaData.class);
    public static final Resource NON_FRAG_RESOURCE = EmptyResource.INSTANCE;
    protected Map<String, OriginInfo> _origins = new HashMap();
    protected final List<WebDescriptor> _webOverrideRoots = new ArrayList();
    protected final List<DescriptorProcessor> _descriptorProcessors = new ArrayList();
    protected final List<FragmentDescriptor> _webFragmentRoots = new ArrayList();
    protected final Map<String, FragmentDescriptor> _webFragmentNameMap = new HashMap();
    protected final Map<Resource, FragmentDescriptor> _webFragmentResourceMap = new HashMap();
    protected final Map<Resource, List<DiscoveredAnnotation>> _annotations = new HashMap();
    protected final List<Resource> _webInfClasses = new ArrayList();
    protected final List<Resource> _webInfJars = new ArrayList();
    protected final List<Resource> _orderedContainerResources = new ArrayList();
    protected final List<Resource> _orderedWebInfResources = new ArrayList();
    protected boolean _allowDuplicateFragmentNames = false;
    protected boolean _validateXml = false;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/MetaData$OriginInfo.class */
    public static class OriginInfo {
        private final String name;
        private final Origin origin;
        private final Descriptor descriptor;
        private final Annotation annotation;
        private final Class<?> annotated;

        public OriginInfo(String n, Annotation a, Class<?> ac) {
            this.name = n;
            this.origin = Origin.Annotation;
            this.descriptor = null;
            this.annotation = a;
            this.annotated = ac;
        }

        public OriginInfo(String n, Descriptor d) {
            this.name = n;
            this.descriptor = d;
            this.annotation = null;
            this.annotated = null;
            if (d == null) {
                throw new IllegalArgumentException("No descriptor");
            } else if (d instanceof FragmentDescriptor) {
                this.origin = Origin.WebFragment;
            } else if (d instanceof OverrideDescriptor) {
                this.origin = Origin.WebOverride;
            } else if (d instanceof DefaultsDescriptor) {
                this.origin = Origin.WebDefaults;
            } else {
                this.origin = Origin.WebXml;
            }
        }

        public OriginInfo(String n) {
            this.name = n;
            this.origin = Origin.API;
            this.annotation = null;
            this.descriptor = null;
            this.annotated = null;
        }

        public String getName() {
            return this.name;
        }

        public Origin getOriginType() {
            return this.origin;
        }

        public Descriptor getDescriptor() {
            return this.descriptor;
        }

        public String toString() {
            if (this.descriptor != null) {
                return this.descriptor.toString();
            }
            if (this.annotation != null) {
                return "@" + this.annotation.annotationType().getSimpleName() + "(" + this.annotated.getName() + ")";
            }
            return this.origin.toString();
        }
    }

    public void clear() {
        this._webDefaultsRoot = null;
        this._origins.clear();
        this._webXmlRoot = null;
        this._webOverrideRoots.clear();
        this._metaDataComplete = false;
        this._annotations.clear();
        this._descriptorProcessors.clear();
        this._webFragmentRoots.clear();
        this._webFragmentNameMap.clear();
        this._webFragmentResourceMap.clear();
        this._annotations.clear();
        this._webInfJars.clear();
        this._orderedWebInfResources.clear();
        this._orderedContainerResources.clear();
        this._ordering = null;
        this._allowDuplicateFragmentNames = false;
    }

    public void setDefaults(Resource webDefaults) throws Exception {
        this._webDefaultsRoot = new DefaultsDescriptor(webDefaults);
        this._webDefaultsRoot.setValidating(isValidateXml());
        this._webDefaultsRoot.parse();
        if (this._webDefaultsRoot.isOrdered()) {
            Ordering ordering = getOrdering();
            if (ordering == null) {
                ordering = new AbsoluteOrdering(this);
            }
            for (String s : this._webDefaultsRoot.getOrdering()) {
                if (s.equalsIgnoreCase(LineReaderImpl.DEFAULT_OTHERS_GROUP_NAME)) {
                    ((AbsoluteOrdering) ordering).addOthers();
                } else {
                    ((AbsoluteOrdering) ordering).add(s);
                }
            }
            setOrdering(ordering);
        }
    }

    public void setWebXml(Resource webXml) throws Exception {
        this._webXmlRoot = new WebDescriptor(webXml);
        this._webXmlRoot.setValidating(isValidateXml());
        this._webXmlRoot.parse();
        this._metaDataComplete = this._webXmlRoot.getMetaDataComplete() == MetaDataComplete.True;
        if (this._webXmlRoot.isOrdered()) {
            Ordering ordering = getOrdering();
            if (ordering == null) {
                ordering = new AbsoluteOrdering(this);
            }
            for (String s : this._webXmlRoot.getOrdering()) {
                if (s.equalsIgnoreCase(LineReaderImpl.DEFAULT_OTHERS_GROUP_NAME)) {
                    ((AbsoluteOrdering) ordering).addOthers();
                } else {
                    ((AbsoluteOrdering) ordering).add(s);
                }
            }
            setOrdering(ordering);
        }
    }

    public void addOverride(Resource override) throws Exception {
        OverrideDescriptor webOverrideRoot = new OverrideDescriptor(override);
        webOverrideRoot.setValidating(false);
        webOverrideRoot.parse();
        switch (webOverrideRoot.getMetaDataComplete()) {
            case True:
                this._metaDataComplete = true;
                break;
            case False:
                this._metaDataComplete = false;
                break;
        }
        if (webOverrideRoot.isOrdered()) {
            Ordering ordering = getOrdering();
            if (ordering == null) {
                ordering = new AbsoluteOrdering(this);
            }
            for (String s : webOverrideRoot.getOrdering()) {
                if (s.equalsIgnoreCase(LineReaderImpl.DEFAULT_OTHERS_GROUP_NAME)) {
                    ((AbsoluteOrdering) ordering).addOthers();
                } else {
                    ((AbsoluteOrdering) ordering).add(s);
                }
            }
            setOrdering(ordering);
        }
        this._webOverrideRoots.add(webOverrideRoot);
    }

    public void addFragment(Resource jarResource, Resource xmlResource) throws Exception {
        if (!this._metaDataComplete) {
            FragmentDescriptor descriptor = new FragmentDescriptor(xmlResource);
            this._webFragmentResourceMap.put(jarResource, descriptor);
            this._webFragmentRoots.add(descriptor);
            descriptor.setValidating(isValidateXml());
            descriptor.parse();
            if (descriptor.getName() != null) {
                Descriptor existing = this._webFragmentNameMap.get(descriptor.getName());
                if (existing == null || isAllowDuplicateFragmentNames()) {
                    this._webFragmentNameMap.put(descriptor.getName(), descriptor);
                } else {
                    throw new IllegalStateException("Duplicate fragment name: " + descriptor.getName() + " for " + existing.getResource() + " and " + descriptor.getResource());
                }
            }
            if (this._ordering != null || !descriptor.isOrdered()) {
                orderFragments();
            } else {
                setOrdering(new RelativeOrdering(this));
            }
        }
    }

    public void addDiscoveredAnnotations(List<DiscoveredAnnotation> annotations) {
        if (annotations != null) {
            for (DiscoveredAnnotation a : annotations) {
                addDiscoveredAnnotation(a);
            }
        }
    }

    public synchronized void addDiscoveredAnnotation(DiscoveredAnnotation annotation) {
        if (annotation != null) {
            Resource resource = annotation.getResource();
            if (resource == null || !this._webInfJars.contains(resource)) {
                resource = EmptyResource.INSTANCE;
            }
            this._annotations.computeIfAbsent(resource, k -> {
                return new ArrayList();
            }).add(annotation);
        }
    }

    public void addDescriptorProcessor(DescriptorProcessor p) {
        this._descriptorProcessors.add(p);
    }

    public void removeDescriptorProcessor(DescriptorProcessor p) {
        this._descriptorProcessors.remove(p);
    }

    public void orderFragments() {
        this._orderedWebInfResources.clear();
        if (getOrdering() != null) {
            this._orderedWebInfResources.addAll(getOrdering().order(this._webInfJars));
        }
    }

    public void resolve(WebAppContext context) throws Exception {
        List<Resource> resources;
        LOG.debug("metadata resolve {}", context);
        this._origins.clear();
        List<Resource> orderedWebInfJars = null;
        if (getOrdering() != null) {
            orderedWebInfJars = getOrderedWebInfJars();
            List<String> orderedLibs = new ArrayList<>();
            for (Resource webInfJar : orderedWebInfJars) {
                String fullname = webInfJar.getName();
                int i = fullname.indexOf(".jar");
                orderedLibs.add(fullname.substring(fullname.lastIndexOf("/", i) + 1, i + 4));
            }
            context.setAttribute("javax.servlet.context.orderedLibs", orderedLibs);
        }
        if (this._webXmlRoot != null) {
            context.getServletContext().setEffectiveMajorVersion(this._webXmlRoot.getMajorVersion());
            context.getServletContext().setEffectiveMinorVersion(this._webXmlRoot.getMinorVersion());
        }
        for (DescriptorProcessor p : this._descriptorProcessors) {
            p.process(context, getWebDefault());
            p.process(context, getWebXml());
            for (WebDescriptor wd : getOverrideWebs()) {
                LOG.debug("process {} {}", context, wd);
                p.process(context, wd);
            }
        }
        List<DiscoveredAnnotation> nonFragAnnotations = this._annotations.get(NON_FRAG_RESOURCE);
        if (nonFragAnnotations != null) {
            for (DiscoveredAnnotation a : nonFragAnnotations) {
                LOG.debug("apply {}", a);
                a.apply();
            }
        }
        if (getOrdering() != null) {
            resources = orderedWebInfJars;
        } else {
            resources = getWebInfJars();
        }
        for (Resource r : resources) {
            FragmentDescriptor fd = this._webFragmentResourceMap.get(r);
            if (fd != null) {
                for (DescriptorProcessor p2 : this._descriptorProcessors) {
                    LOG.debug("process {} {}", context, fd);
                    p2.process(context, fd);
                }
            }
            List<DiscoveredAnnotation> fragAnnotations = this._annotations.get(r);
            if (fragAnnotations != null) {
                for (DiscoveredAnnotation a2 : fragAnnotations) {
                    LOG.debug("apply {}", a2);
                    a2.apply();
                }
            }
        }
    }

    public boolean isDistributable() {
        boolean distributable = (this._webDefaultsRoot != null && this._webDefaultsRoot.isDistributable()) || (this._webXmlRoot != null && this._webXmlRoot.isDistributable());
        for (WebDescriptor d : this._webOverrideRoots) {
            distributable &= d.isDistributable();
        }
        if (getOrdering() != null) {
            for (Resource r : getOrderedWebInfJars()) {
                FragmentDescriptor d2 = this._webFragmentResourceMap.get(r);
                if (d2 != null) {
                    distributable = distributable && d2.isDistributable();
                }
            }
        }
        return distributable;
    }

    public WebDescriptor getWebXml() {
        return this._webXmlRoot;
    }

    public List<WebDescriptor> getOverrideWebs() {
        return this._webOverrideRoots;
    }

    public WebDescriptor getWebDefault() {
        return this._webDefaultsRoot;
    }

    public List<FragmentDescriptor> getFragments() {
        return this._webFragmentRoots;
    }

    public List<Resource> getOrderedWebInfJars() {
        return this._orderedWebInfResources;
    }

    public List<FragmentDescriptor> getOrderedFragments() {
        List<FragmentDescriptor> list = new ArrayList<>();
        if (getOrdering() == null) {
            return list;
        }
        for (Resource r : getOrderedWebInfJars()) {
            FragmentDescriptor fd = this._webFragmentResourceMap.get(r);
            if (fd != null) {
                list.add(fd);
            }
        }
        return list;
    }

    public Ordering getOrdering() {
        return this._ordering;
    }

    public void setOrdering(Ordering o) {
        this._ordering = o;
        orderFragments();
    }

    public FragmentDescriptor getFragment(Resource jar) {
        return this._webFragmentResourceMap.get(jar);
    }

    public FragmentDescriptor getFragment(String name) {
        return this._webFragmentNameMap.get(name);
    }

    public Resource getJarForFragment(String name) {
        FragmentDescriptor f = getFragment(name);
        if (f == null) {
            return null;
        }
        Resource jar = null;
        for (Map.Entry<Resource, FragmentDescriptor> entry : this._webFragmentResourceMap.entrySet()) {
            if (entry.getValue().equals(f)) {
                jar = entry.getKey();
            }
        }
        return jar;
    }

    public Map<String, FragmentDescriptor> getNamedFragments() {
        return Collections.unmodifiableMap(this._webFragmentNameMap);
    }

    public Origin getOrigin(String name) {
        OriginInfo x = this._origins.get(name);
        if (x == null) {
            return Origin.NotSet;
        }
        return x.getOriginType();
    }

    public OriginInfo getOriginInfo(String name) {
        OriginInfo x = this._origins.get(name);
        if (x == null) {
            return null;
        }
        return x;
    }

    public Descriptor getOriginDescriptor(String name) {
        OriginInfo o = this._origins.get(name);
        if (o == null) {
            return null;
        }
        return o.getDescriptor();
    }

    public void setOrigin(String name, Descriptor d) {
        this._origins.put(name, new OriginInfo(name, d));
    }

    public void setOrigin(String name, Annotation annotation, Class<?> annotated) {
        if (name != null) {
            this._origins.put(name, new OriginInfo(name, annotation, annotated));
        }
    }

    public void setOriginAPI(String name) {
        if (name != null) {
            this._origins.put(name, new OriginInfo(name));
        }
    }

    public boolean isMetaDataComplete() {
        return this._metaDataComplete;
    }

    public void addWebInfJar(Resource newResource) {
        this._webInfJars.add(newResource);
    }

    public List<Resource> getWebInfJars() {
        return Collections.unmodifiableList(this._webInfJars);
    }

    public List<Resource> getContainerResources() {
        return this._orderedContainerResources;
    }

    public void addContainerResource(Resource jar) {
        this._orderedContainerResources.add(jar);
    }

    public void setWebInfClassesDirs(List<Resource> dirs) {
        this._webInfClasses.addAll(dirs);
    }

    public List<Resource> getWebInfClassesDirs() {
        return this._webInfClasses;
    }

    public boolean isAllowDuplicateFragmentNames() {
        return this._allowDuplicateFragmentNames;
    }

    public void setAllowDuplicateFragmentNames(boolean allowDuplicateFragmentNames) {
        this._allowDuplicateFragmentNames = allowDuplicateFragmentNames;
    }

    public boolean isValidateXml() {
        return this._validateXml;
    }

    public void setValidateXml(boolean validateXml) {
        this._validateXml = validateXml;
    }

    public Map<String, OriginInfo> getOrigins() {
        return Collections.unmodifiableMap(this._origins);
    }
}
