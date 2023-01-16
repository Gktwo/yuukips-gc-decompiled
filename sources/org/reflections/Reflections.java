package org.reflections;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javassist.bytecode.ClassFile;
import javax.annotation.Nullable;
import org.reflections.scanners.MemberUsageScanner;
import org.reflections.scanners.MethodParameterNamesScanner;
import org.reflections.scanners.Scanner;
import org.reflections.scanners.Scanners;
import org.reflections.serializers.Serializer;
import org.reflections.serializers.XmlSerializer;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.reflections.util.NameHelper;
import org.reflections.util.QueryFunction;
import org.reflections.vfs.Vfs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/reflections/Reflections.class */
public class Reflections implements NameHelper {
    public static final Logger log = LoggerFactory.getLogger(Reflections.class);
    protected final transient Configuration configuration;
    protected final Store store;

    public Reflections(Configuration configuration) {
        this.configuration = configuration;
        Map<String, Map<String, Set<String>>> storeMap = scan();
        if (configuration.shouldExpandSuperTypes()) {
            expandSuperTypes(storeMap.get(Scanners.SubTypes.index()), storeMap.get(Scanners.TypesAnnotated.index()));
        }
        this.store = new Store(storeMap);
    }

    public Reflections(Store store) {
        this.configuration = new ConfigurationBuilder();
        this.store = store;
    }

    public Reflections(String prefix, Scanner... scanners) {
        this(prefix, scanners);
    }

    public Reflections(Object... params) {
        this(ConfigurationBuilder.build(params));
    }

    protected Reflections() {
        this.configuration = new ConfigurationBuilder();
        this.store = new Store(new HashMap());
    }

    protected Map<String, Map<String, Set<String>>> scan() {
        long start = System.currentTimeMillis();
        Map<String, Set<Map.Entry<String, String>>> collect = (Map) this.configuration.getScanners().stream().map((v0) -> {
            return v0.index();
        }).distinct().collect(Collectors.toMap(s -> {
            return s;
        }, s -> {
            return Collections.synchronizedSet(new HashSet());
        }));
        Set<URL> urls = this.configuration.getUrls();
        (this.configuration.isParallel() ? (Stream) urls.stream().parallel() : urls.stream()).forEach(url -> {
            Vfs.Dir dir;
            try {
                dir = null;
                try {
                    dir = Vfs.fromURL(collect);
                    for (Vfs.File file : dir.getFiles()) {
                        if (doFilter(file, this.configuration.getInputsFilter())) {
                            ClassFile classFile = null;
                            for (Scanner scanner : this.configuration.getScanners()) {
                                scanner.getClass();
                                if (doFilter(file, this::acceptsInput)) {
                                    try {
                                        List<Map.Entry<String, String>> entries = scanner.scan(file);
                                        if (entries == null) {
                                            if (classFile == null) {
                                                classFile = getClassFile(file);
                                            }
                                            entries = scanner.scan(classFile);
                                        }
                                        if (entries != null) {
                                            ((Set) collect.get(scanner.index())).addAll(entries);
                                        }
                                    } catch (Exception e) {
                                        if (log != null) {
                                            log.trace("could not scan file {} with scanner {}", file.getRelativePath(), scanner.getClass().getSimpleName(), e);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (dir != null) {
                        dir.close();
                    }
                } catch (Exception e2) {
                    if (log != null) {
                        log.warn("could not create Vfs.Dir from url. ignoring the exception and continuing", (Throwable) e2);
                    }
                    if (dir != null) {
                        dir.close();
                    }
                }
            } catch (Throwable th) {
                if (dir != null) {
                    dir.close();
                }
                throw th;
            }
        });
        Map<String, Map<String, Set<String>>> storeMap = (Map) collect.entrySet().stream().collect(Collectors.toMap((v0) -> {
            return v0.getKey();
        }, entry -> {
            return (HashMap) ((Set) entry.getValue()).stream().filter(e -> {
                return e.getKey() != null;
            }).collect(Collectors.groupingBy((v0) -> {
                return v0.getKey();
            }, HashMap::new, Collectors.mapping((v0) -> {
                return v0.getValue();
            }, Collectors.toSet())));
        }));
        if (log != null) {
            int keys = 0;
            int values = 0;
            for (Map<String, Set<String>> map : storeMap.values()) {
                keys += map.size();
                values = (int) (((long) values) + map.values().stream().mapToLong((v0) -> {
                    return v0.size();
                }).sum());
            }
            log.info(String.format("Reflections took %d ms to scan %d urls, producing %d keys and %d values", Long.valueOf(System.currentTimeMillis() - start), Integer.valueOf(urls.size()), Integer.valueOf(keys), Integer.valueOf(values)));
        }
        return storeMap;
    }

    private boolean doFilter(Vfs.File file, @Nullable Predicate<String> predicate) {
        String path = file.getRelativePath();
        return predicate == null || predicate.test(path) || predicate.test(path.replace('/', '.'));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x0042
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private javassist.bytecode.ClassFile getClassFile(org.reflections.vfs.Vfs.File r7) {
        /*
            r6 = this;
            java.io.DataInputStream r0 = new java.io.DataInputStream     // Catch: Exception -> 0x006d
            r1 = r0
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: Exception -> 0x006d
            r3 = r2
            r4 = r7
            java.io.InputStream r4 = r4.openInputStream()     // Catch: Exception -> 0x006d
            r3.<init>(r4)     // Catch: Exception -> 0x006d
            r1.<init>(r2)     // Catch: Exception -> 0x006d
            r8 = r0
            r0 = 0
            r9 = r0
            javassist.bytecode.ClassFile r0 = new javassist.bytecode.ClassFile     // Catch: Exception -> 0x006d, Throwable -> 0x0042, all -> 0x004a
            r1 = r0
            r2 = r8
            r1.<init>(r2)     // Catch: Exception -> 0x006d, Throwable -> 0x0042, all -> 0x004a
            r10 = r0
            r0 = r8
            if (r0 == 0) goto L_0x003f
            r0 = r9
            if (r0 == 0) goto L_0x003b
            r0 = r8
            r0.close()     // Catch: Exception -> 0x006d, Throwable -> 0x0030
            goto L_0x003f
        L_0x0030:
            r11 = move-exception
            r0 = r9
            r1 = r11
            r0.addSuppressed(r1)     // Catch: Exception -> 0x006d
            goto L_0x003f
        L_0x003b:
            r0 = r8
            r0.close()     // Catch: Exception -> 0x006d
        L_0x003f:
            r0 = r10
            return r0
        L_0x0042:
            r10 = move-exception
            r0 = r10
            r9 = r0
            r0 = r10
            throw r0     // Catch: Exception -> 0x006d, all -> 0x004a
        L_0x004a:
            r12 = move-exception
            r0 = r8
            if (r0 == 0) goto L_0x006a
            r0 = r9
            if (r0 == 0) goto L_0x0066
            r0 = r8
            r0.close()     // Catch: Throwable -> 0x005b, Exception -> 0x006d
            goto L_0x006a
        L_0x005b:
            r13 = move-exception
            r0 = r9
            r1 = r13
            r0.addSuppressed(r1)     // Catch: Exception -> 0x006d
            goto L_0x006a
        L_0x0066:
            r0 = r8
            r0.close()     // Catch: Exception -> 0x006d
        L_0x006a:
            r0 = r12
            throw r0     // Catch: Exception -> 0x006d
        L_0x006d:
            r8 = move-exception
            org.reflections.ReflectionsException r0 = new org.reflections.ReflectionsException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "could not create class object from file "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r7
            java.lang.String r3 = r3.getRelativePath()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r3 = r8
            r1.<init>(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.reflections.Reflections.getClassFile(org.reflections.vfs.Vfs$File):javassist.bytecode.ClassFile");
    }

    public static Reflections collect() {
        return collect("META-INF/reflections/", new FilterBuilder().includePattern(".*-reflections\\.xml"));
    }

    public static Reflections collect(String packagePrefix, Predicate<String> resourceNameFilter) {
        return collect(packagePrefix, resourceNameFilter, new XmlSerializer());
    }

    public static Reflections collect(String packagePrefix, Predicate<String> resourceNameFilter, Serializer serializer) {
        Iterable<Vfs.File> files = Vfs.findFiles(ClasspathHelper.forPackage(packagePrefix, new ClassLoader[0]), packagePrefix, resourceNameFilter);
        Reflections reflections = new Reflections();
        StreamSupport.stream(files.spliterator(), false).forEach(file -> {
            try {
                InputStream inputStream = file.openInputStream();
                reflections.collect(inputStream, serializer);
                if (inputStream != null) {
                    if (0 != 0) {
                        inputStream.close();
                    } else {
                        inputStream.close();
                    }
                }
            } catch (IOException e) {
                throw new ReflectionsException("could not merge " + file, e);
            }
        });
        return reflections;
    }

    public Reflections collect(InputStream inputStream, Serializer serializer) {
        return merge(serializer.read(inputStream));
    }

    public Reflections collect(File file, Serializer serializer) {
        try {
            FileInputStream inputStream = new FileInputStream(file);
            Reflections collect = collect(inputStream, serializer);
            if (inputStream != null) {
                if (0 != 0) {
                    inputStream.close();
                } else {
                    inputStream.close();
                }
            }
            return collect;
        } catch (IOException e) {
            throw new ReflectionsException("could not obtain input stream from file " + file, e);
        }
    }

    public Reflections merge(Reflections reflections) {
        reflections.store.forEach(index, map -> {
            this.store.merge(index, map, m1, m2 -> {
                m2.forEach(k, v -> {
                    Set set = (Set) m1.merge(k, v, s1, s2 -> {
                        s1.addAll(s2);
                        return s1;
                    });
                });
                return m1;
            });
        });
        return this;
    }

    public void expandSuperTypes(Map<String, Set<String>> subTypesStore, Map<String, Set<String>> typesAnnotatedStore) {
        if (!(subTypesStore == null || subTypesStore.isEmpty())) {
            Set<String> keys = new LinkedHashSet<>(subTypesStore.keySet());
            keys.removeAll((Collection) subTypesStore.values().stream().flatMap((v0) -> {
                return v0.stream();
            }).collect(Collectors.toSet()));
            keys.remove("java.lang.Object");
            for (String key : keys) {
                Class<?> type = forClass(key, loaders());
                if (type != null) {
                    expandSupertypes(subTypesStore, typesAnnotatedStore, key, type);
                }
            }
        }
    }

    private void expandSupertypes(Map<String, Set<String>> subTypesStore, Map<String, Set<String>> typesAnnotatedStore, String key, Class<?> type) {
        Set<Annotation> typeAnnotations = ReflectionUtils.getAnnotations(type, new Predicate[0]);
        if (typesAnnotatedStore != null && !typeAnnotations.isEmpty()) {
            String typeName = type.getName();
            for (Annotation typeAnnotation : typeAnnotations) {
                typesAnnotatedStore.computeIfAbsent(typeAnnotation.annotationType().getName(), s -> {
                    return new HashSet();
                }).add(typeName);
            }
        }
        for (Class<?> supertype : ReflectionUtils.getSuperTypes(type)) {
            String supertypeName = supertype.getName();
            if (subTypesStore.containsKey(supertypeName)) {
                subTypesStore.get(supertypeName).add(key);
            } else {
                subTypesStore.computeIfAbsent(supertypeName, s -> {
                    return new HashSet();
                }).add(key);
                expandSupertypes(subTypesStore, typesAnnotatedStore, supertypeName, supertype);
            }
        }
    }

    public <T> Set<T> get(QueryFunction<Store, T> query) {
        return query.apply((QueryFunction<Store, T>) this.store);
    }

    public <T> Set<Class<? extends T>> getSubTypesOf(Class<T> type) {
        return get(Scanners.SubTypes.m5of(type).m3as(Class.class, loaders()));
    }

    public Set<Class<?>> getTypesAnnotatedWith(Class<? extends Annotation> annotation) {
        return get(Scanners.SubTypes.m6of(Scanners.TypesAnnotated.with(annotation)).asClass(loaders()));
    }

    public Set<Class<?>> getTypesAnnotatedWith(Class<? extends Annotation> annotation, boolean honorInherited) {
        if (!honorInherited) {
            return getTypesAnnotatedWith(annotation);
        }
        if (annotation.isAnnotationPresent(Inherited.class)) {
            return get(Scanners.TypesAnnotated.get(annotation).add(Scanners.SubTypes.m6of(Scanners.TypesAnnotated.get(annotation).filter(c -> {
                return !forClass(c, loaders()).isInterface();
            }))).asClass(loaders()));
        }
        return get(Scanners.TypesAnnotated.get(annotation).asClass(loaders()));
    }

    public Set<Class<?>> getTypesAnnotatedWith(Annotation annotation) {
        return get(Scanners.SubTypes.m6of(Scanners.TypesAnnotated.m6of(Scanners.TypesAnnotated.get(annotation.annotationType()).filter(c -> {
            return ReflectionUtils.withAnnotation(annotation).test(forClass(annotation, loaders()));
        }))).asClass(loaders()));
    }

    public Set<Class<?>> getTypesAnnotatedWith(Annotation annotation, boolean honorInherited) {
        if (!honorInherited) {
            return getTypesAnnotatedWith(annotation);
        }
        Class<? extends Annotation> type = annotation.annotationType();
        if (type.isAnnotationPresent(Inherited.class)) {
            return get(Scanners.TypesAnnotated.with(type).asClass(loaders()).filter(ReflectionUtils.withAnnotation(annotation)).add(Scanners.SubTypes.m6of(Scanners.TypesAnnotated.with(type).asClass(loaders()).filter(c -> {
                return !c.isInterface();
            }))));
        }
        return get(Scanners.TypesAnnotated.with(type).asClass(loaders()).filter(ReflectionUtils.withAnnotation(annotation)));
    }

    public Set<Method> getMethodsAnnotatedWith(Class<? extends Annotation> annotation) {
        return get(Scanners.MethodsAnnotated.with(annotation).m3as(Method.class, loaders()));
    }

    public Set<Method> getMethodsAnnotatedWith(Annotation annotation) {
        return get(Scanners.MethodsAnnotated.with(annotation.annotationType()).m3as(Method.class, loaders()).filter(ReflectionUtils.withAnnotation(annotation)));
    }

    public Set<Method> getMethodsWithSignature(Class<?>... types) {
        return get(Scanners.MethodsSignature.with(types).m3as(Method.class, loaders()));
    }

    public Set<Method> getMethodsWithParameter(AnnotatedElement type) {
        return get(Scanners.MethodsParameter.with(type).m3as(Method.class, loaders()));
    }

    public Set<Method> getMethodsReturn(Class<?> type) {
        return get(Scanners.MethodsReturn.m5of(type).m3as(Method.class, loaders()));
    }

    public Set<Constructor> getConstructorsAnnotatedWith(Class<? extends Annotation> annotation) {
        return get(Scanners.ConstructorsAnnotated.with(annotation).m3as(Constructor.class, loaders()));
    }

    public Set<Constructor> getConstructorsAnnotatedWith(Annotation annotation) {
        return get(Scanners.ConstructorsAnnotated.with(annotation.annotationType()).m3as(Constructor.class, loaders()).filter(ReflectionUtils.withAnyParameterAnnotation(annotation)));
    }

    public Set<Constructor> getConstructorsWithSignature(Class<?>... types) {
        return get(Scanners.ConstructorsSignature.with(types).m3as(Constructor.class, loaders()));
    }

    public Set<Constructor> getConstructorsWithParameter(AnnotatedElement type) {
        return get(Scanners.ConstructorsParameter.m5of(type).m3as(Constructor.class, loaders()));
    }

    public Set<Field> getFieldsAnnotatedWith(Class<? extends Annotation> annotation) {
        return get(Scanners.FieldsAnnotated.with(annotation).m3as(Field.class, loaders()));
    }

    public Set<Field> getFieldsAnnotatedWith(Annotation annotation) {
        return get(Scanners.FieldsAnnotated.with(annotation.annotationType()).m3as(Field.class, loaders()).filter(ReflectionUtils.withAnnotation(annotation)));
    }

    public Set<String> getResources(String pattern) {
        return get(Scanners.Resources.with(pattern));
    }

    public Set<String> getResources(Pattern pattern) {
        return getResources(pattern.pattern());
    }

    public List<String> getMemberParameterNames(Member member) {
        return (List) this.store.getOrDefault(MethodParameterNamesScanner.class.getSimpleName(), Collections.emptyMap()).getOrDefault(toName((AnnotatedElement) member), Collections.emptySet()).stream().flatMap(s -> {
            return Stream.of((Object[]) s.split(", "));
        }).collect(Collectors.toList());
    }

    public Collection<Member> getMemberUsage(Member member) {
        return forNames(this.store.getOrDefault(MemberUsageScanner.class.getSimpleName(), Collections.emptyMap()).getOrDefault(toName((AnnotatedElement) member), Collections.emptySet()), Member.class, loaders());
    }

    @Deprecated
    public Set<String> getAllTypes() {
        return getAll(Scanners.SubTypes);
    }

    public Set<String> getAll(Scanner scanner) {
        Map<String, Set<String>> map = this.store.getOrDefault(scanner.index(), Collections.emptyMap());
        return (Set) Stream.concat(map.keySet().stream(), map.values().stream().flatMap((v0) -> {
            return v0.stream();
        })).collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Store getStore() {
        return this.store;
    }

    public Configuration getConfiguration() {
        return this.configuration;
    }

    public File save(String filename) {
        return save(filename, new XmlSerializer());
    }

    public File save(String filename, Serializer serializer) {
        return serializer.save(this, filename);
    }

    ClassLoader[] loaders() {
        return this.configuration.getClassLoaders();
    }
}
