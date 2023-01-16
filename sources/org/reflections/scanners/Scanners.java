package org.reflections.scanners;

import java.lang.annotation.Inherited;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javassist.bytecode.ClassFile;
import org.reflections.Store;
import org.reflections.util.JavassistHelper;
import org.reflections.util.NameHelper;
import org.reflections.util.QueryBuilder;
import org.reflections.util.QueryFunction;
import org.reflections.vfs.Vfs;

/* loaded from: grasscutter.jar:org/reflections/scanners/Scanners.class */
public enum Scanners implements Scanner, QueryBuilder, NameHelper {
    SubTypes {
        @Override // org.reflections.scanners.Scanners
        public void scan(ClassFile classFile, List<Map.Entry<String, String>> entries) {
            entries.add(entry(classFile.getSuperclass(), classFile.getName()));
            entries.addAll(entries(Arrays.asList(classFile.getInterfaces()), classFile.getName()));
        }
    },
    TypesAnnotated {
        @Override // org.reflections.scanners.Scanners
        public boolean acceptResult(String annotation) {
            return acceptResult(annotation) || annotation.equals(Inherited.class.getName());
        }

        @Override // org.reflections.scanners.Scanners
        public void scan(ClassFile classFile, List<Map.Entry<String, String>> entries) {
            classFile.getClass();
            entries.addAll(entries(JavassistHelper.getAnnotations(this::getAttribute), classFile.getName()));
        }
    },
    MethodsAnnotated {
        @Override // org.reflections.scanners.Scanners
        public void scan(ClassFile classFile, List<Map.Entry<String, String>> entries) {
            JavassistHelper.getMethods(classFile).forEach(method -> {
                classFile.getClass();
                entries.addAll(entries(JavassistHelper.getAnnotations(this::getAttribute), JavassistHelper.methodName(entries, classFile)));
            });
        }
    },
    ConstructorsAnnotated {
        @Override // org.reflections.scanners.Scanners
        public void scan(ClassFile classFile, List<Map.Entry<String, String>> entries) {
            JavassistHelper.getConstructors(classFile).forEach(constructor -> {
                classFile.getClass();
                entries.addAll(entries(JavassistHelper.getAnnotations(this::getAttribute), JavassistHelper.methodName(entries, classFile)));
            });
        }
    },
    FieldsAnnotated {
        @Override // org.reflections.scanners.Scanners
        public void scan(ClassFile classFile, List<Map.Entry<String, String>> entries) {
            classFile.getFields().forEach(field -> {
                classFile.getClass();
                entries.addAll(entries(JavassistHelper.getAnnotations(this::getAttribute), JavassistHelper.fieldName(entries, classFile)));
            });
        }
    },
    Resources {
        @Override // org.reflections.scanners.Scanner
        public boolean acceptsInput(String file) {
            return !file.endsWith(".class");
        }

        @Override // org.reflections.scanners.Scanner
        public List<Map.Entry<String, String>> scan(Vfs.File file) {
            return Collections.singletonList(entry(file.getName(), file.getRelativePath()));
        }

        @Override // org.reflections.scanners.Scanners
        public void scan(ClassFile classFile, List<Map.Entry<String, String>> entries) {
            throw new IllegalStateException();
        }

        @Override // org.reflections.util.QueryBuilder
        public QueryFunction<Store, String> with(String pattern) {
            return store -> {
                return (LinkedHashSet) pattern.getOrDefault(index(), Collections.emptyMap()).entrySet().stream().filter(entry -> {
                    return ((String) entry.getKey()).matches(pattern);
                }).flatMap(entry -> {
                    return ((Set) entry.getValue()).stream();
                }).collect(Collectors.toCollection(LinkedHashSet::new));
            };
        }
    },
    MethodsParameter {
        @Override // org.reflections.scanners.Scanners
        public void scan(ClassFile classFile, List<Map.Entry<String, String>> entries) {
            JavassistHelper.getMethods(classFile).forEach(method -> {
                String value = JavassistHelper.methodName(classFile, entries);
                classFile.addAll(entries(JavassistHelper.getParameters(entries), value));
                JavassistHelper.getParametersAnnotations(entries).forEach(annotations -> {
                    entries.addAll(entries(value, classFile));
                });
            });
        }
    },
    ConstructorsParameter {
        @Override // org.reflections.scanners.Scanners
        public void scan(ClassFile classFile, List<Map.Entry<String, String>> entries) {
            JavassistHelper.getConstructors(classFile).forEach(constructor -> {
                String value = JavassistHelper.methodName(classFile, entries);
                classFile.addAll(entries(JavassistHelper.getParameters(entries), value));
                JavassistHelper.getParametersAnnotations(entries).forEach(annotations -> {
                    entries.addAll(entries(value, classFile));
                });
            });
        }
    },
    MethodsSignature {
        @Override // org.reflections.scanners.Scanners
        public void scan(ClassFile classFile, List<Map.Entry<String, String>> entries) {
            JavassistHelper.getMethods(classFile).forEach(method -> {
                entries.add(entry(JavassistHelper.getParameters(classFile).toString(), JavassistHelper.methodName(entries, classFile)));
            });
        }

        @Override // org.reflections.util.QueryBuilder
        public QueryFunction<Store, String> with(AnnotatedElement... keys) {
            return QueryFunction.single(toNames(keys).toString()).getAll(this::get);
        }
    },
    ConstructorsSignature {
        @Override // org.reflections.scanners.Scanners
        public void scan(ClassFile classFile, List<Map.Entry<String, String>> entries) {
            JavassistHelper.getConstructors(classFile).forEach(constructor -> {
                entries.add(entry(JavassistHelper.getParameters(classFile).toString(), JavassistHelper.methodName(entries, classFile)));
            });
        }

        @Override // org.reflections.util.QueryBuilder
        public QueryFunction<Store, String> with(AnnotatedElement... keys) {
            return QueryFunction.single(toNames(keys).toString()).getAll(this::get);
        }
    },
    MethodsReturn {
        @Override // org.reflections.scanners.Scanners
        public void scan(ClassFile classFile, List<Map.Entry<String, String>> entries) {
            JavassistHelper.getMethods(classFile).forEach(method -> {
                entries.add(entry(JavassistHelper.getReturnType(classFile), JavassistHelper.methodName(entries, classFile)));
            });
        }
    };
    
    private Predicate<String> resultFilter;

    abstract void scan(ClassFile classFile, List<Map.Entry<String, String>> list);

    Scanners() {
        this.resultFilter = s -> {
            return true;
        };
    }

    @Override // org.reflections.scanners.Scanner
    public String index() {
        return name();
    }

    public Scanners filterResultsBy(Predicate<String> filter) {
        this.resultFilter = filter;
        return this;
    }

    @Override // org.reflections.scanners.Scanner
    public final List<Map.Entry<String, String>> scan(ClassFile classFile) {
        List<Map.Entry<String, String>> entries = new ArrayList<>();
        scan(classFile, entries);
        return (List) entries.stream().filter(a -> {
            return acceptResult((String) a.getKey());
        }).collect(Collectors.toList());
    }

    protected boolean acceptResult(String fqn) {
        return fqn != null && this.resultFilter.test(fqn);
    }
}
