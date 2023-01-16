package org.reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.jline.console.Printer;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.QueryFunction;
import org.reflections.util.ReflectionUtilsPredicates;
import org.reflections.util.UtilQueryBuilder;

/* loaded from: grasscutter.jar:org/reflections/ReflectionUtils.class */
public abstract class ReflectionUtils extends ReflectionUtilsPredicates {
    private static final List<String> objectMethodNames = Arrays.asList("equals", "hashCode", Printer.TO_STRING, "wait", "notify", "notifyAll");
    public static final Predicate<Method> notObjectMethod = m -> {
        return !objectMethodNames.contains(m.getName());
    };
    public static final UtilQueryBuilder<Class<?>, Class<?>> SuperClass = element -> {
        return ctx -> {
            Class<?> superclass = element.getSuperclass();
            return (superclass == null || superclass.equals(Object.class)) ? Collections.emptySet() : Collections.singleton(superclass);
        };
    };
    public static final UtilQueryBuilder<Class<?>, Class<?>> Interfaces = element -> {
        return ctx -> {
            return (LinkedHashSet) Stream.of((Object[]) element.getInterfaces()).collect(Collectors.toCollection(LinkedHashSet::new));
        };
    };
    public static final UtilQueryBuilder<Class<?>, Class<?>> SuperTypes = new UtilQueryBuilder<Class<?>, Class<?>>() { // from class: org.reflections.ReflectionUtils.1
        public QueryFunction<Store, Class<?>> get(Class<?> element) {
            return ReflectionUtils.SuperClass.get(element).add(ReflectionUtils.Interfaces.get(element));
        }

        /* renamed from: of */
        public QueryFunction<Store, Class<?>> mo2of(Class<?> element) {
            QueryFunction single = QueryFunction.single(element);
            UtilQueryBuilder<Class<?>, Class<?>> utilQueryBuilder = ReflectionUtils.SuperTypes;
            utilQueryBuilder.getClass();
            return single.getAll((v1) -> {
                return r1.get(v1);
            });
        }
    };
    public static final UtilQueryBuilder<AnnotatedElement, Annotation> Annotations = new UtilQueryBuilder<AnnotatedElement, Annotation>() { // from class: org.reflections.ReflectionUtils.2
        public QueryFunction<Store, Annotation> get(AnnotatedElement element) {
            return ctx -> {
                return (LinkedHashSet) Arrays.stream(element.getAnnotations()).collect(Collectors.toCollection(LinkedHashSet::new));
            };
        }

        /* renamed from: of */
        public QueryFunction<Store, Annotation> mo2of(AnnotatedElement element) {
            QueryFunction queryFunction = ReflectionUtils.extendType().get(element);
            UtilQueryBuilder<AnnotatedElement, Annotation> utilQueryBuilder = ReflectionUtils.Annotations;
            utilQueryBuilder.getClass();
            return queryFunction.getAll((v1) -> {
                return r1.get(v1);
            }, (v0) -> {
                return v0.annotationType();
            });
        }
    };
    public static final UtilQueryBuilder<AnnotatedElement, Class<? extends Annotation>> AnnotationTypes = new UtilQueryBuilder<AnnotatedElement, Class<? extends Annotation>>() { // from class: org.reflections.ReflectionUtils.3
        /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: org.reflections.util.QueryFunction<org.reflections.Store, R>, org.reflections.util.QueryFunction<org.reflections.Store, java.lang.Class<? extends java.lang.annotation.Annotation>> */
        public QueryFunction<Store, Class<? extends Annotation>> get(AnnotatedElement element) {
            return ReflectionUtils.Annotations.get(element).map((v0) -> {
                return v0.annotationType();
            });
        }

        /* renamed from: of */
        public QueryFunction<Store, Class<? extends Annotation>> mo2of(AnnotatedElement element) {
            QueryFunction queryFunction = ReflectionUtils.extendType().get(element);
            UtilQueryBuilder<AnnotatedElement, Class<? extends Annotation>> utilQueryBuilder = ReflectionUtils.AnnotationTypes;
            utilQueryBuilder.getClass();
            return queryFunction.getAll((v1) -> {
                return r1.get(v1);
            }, a -> {
                return a;
            });
        }
    };
    public static final UtilQueryBuilder<Class<?>, Method> Methods = element -> {
        return ctx -> {
            return (LinkedHashSet) Arrays.stream(element.getDeclaredMethods()).filter(notObjectMethod).collect(Collectors.toCollection(LinkedHashSet::new));
        };
    };
    public static final UtilQueryBuilder<Class<?>, Constructor> Constructors = element -> {
        return ctx -> {
            return (LinkedHashSet) Arrays.stream(element.getDeclaredConstructors()).collect(Collectors.toCollection(LinkedHashSet::new));
        };
    };
    public static final UtilQueryBuilder<Class<?>, Field> Fields = element -> {
        return ctx -> {
            return (LinkedHashSet) Arrays.stream(element.getDeclaredFields()).collect(Collectors.toCollection(LinkedHashSet::new));
        };
    };
    public static final UtilQueryBuilder<String, URL> Resources = element -> {
        return ctx -> {
            return new HashSet(ClasspathHelper.forResource(element, new ClassLoader[0]));
        };
    };

    public static <C, T> Set<T> get(QueryFunction<C, T> function) {
        return function.apply((QueryFunction<C, T>) null);
    }

    public static <T> Set<T> get(QueryFunction<Store, T> queryFunction, Predicate<? super T>... predicates) {
        return get(queryFunction.filter((Predicate) Arrays.stream(predicates).reduce(t -> {
            return true;
        }, (v0, v1) -> {
            return v0.and(v1);
        })));
    }

    public static <T extends AnnotatedElement> UtilQueryBuilder<AnnotatedElement, T> extendType() {
        return element -> {
            if (!(element instanceof Class) || ((Class) element).isAnnotation()) {
                return QueryFunction.single(element);
            }
            QueryFunction<Store, Class<?>> single = QueryFunction.single((Class) element);
            UtilQueryBuilder<Class<?>, Class<?>> utilQueryBuilder = SuperTypes;
            utilQueryBuilder.getClass();
            return single.add(single.getAll((v1) -> {
                return r2.get(v1);
            }));
        };
    }

    public static <T extends AnnotatedElement> Set<Annotation> getAllAnnotations(T type, Predicate<Annotation>... predicates) {
        return get(Annotations.mo2of((UtilQueryBuilder<AnnotatedElement, Annotation>) type), predicates);
    }

    public static Set<Class<?>> getAllSuperTypes(Class<?> type, Predicate<? super Class<?>>... predicates) {
        return get(SuperTypes.mo2of((UtilQueryBuilder<Class<?>, Class<?>>) type), (predicates == null || predicates.length == 0) ? new Predicate[]{t -> {
            return !Object.class.equals(t);
        }} : predicates);
    }

    public static Set<Class<?>> getSuperTypes(Class<?> type) {
        return get(SuperTypes.get(type));
    }

    public static Set<Method> getAllMethods(Class<?> type, Predicate<? super Method>... predicates) {
        return get(Methods.mo2of((UtilQueryBuilder<Class<?>, Method>) type), predicates);
    }

    public static Set<Method> getMethods(Class<?> t, Predicate<? super Method>... predicates) {
        return get(Methods.get(t), predicates);
    }

    public static Set<Constructor> getAllConstructors(Class<?> type, Predicate<? super Constructor>... predicates) {
        return get(Constructors.mo2of((UtilQueryBuilder<Class<?>, Constructor>) type), predicates);
    }

    public static Set<Constructor> getConstructors(Class<?> t, Predicate<? super Constructor>... predicates) {
        return get(Constructors.get(t), predicates);
    }

    public static Set<Field> getAllFields(Class<?> type, Predicate<? super Field>... predicates) {
        return get(Fields.mo2of((UtilQueryBuilder<Class<?>, Field>) type), predicates);
    }

    public static Set<Field> getFields(Class<?> type, Predicate<? super Field>... predicates) {
        return get(Fields.get(type), predicates);
    }

    public static <T extends AnnotatedElement> Set<Annotation> getAnnotations(T type, Predicate<Annotation>... predicates) {
        return get(Annotations.get(type), predicates);
    }

    public static Map<String, Object> toMap(Annotation annotation) {
        return (Map) get(Methods.mo2of((UtilQueryBuilder<Class<?>, Method>) annotation.annotationType()).filter(notObjectMethod.and(withParametersCount(0)))).stream().collect(Collectors.toMap((v0) -> {
            return v0.getName();
        }, m -> {
            Object v1 = invoke(m, annotation, new Object[0]);
            return (!v1.getClass().isArray() || !v1.getClass().getComponentType().isAnnotation()) ? v1 : Stream.of((Object[]) ((Annotation[]) v1)).map(ReflectionUtils::toMap).collect(Collectors.toList());
        }));
    }

    public static Map<String, Object> toMap(Annotation annotation, AnnotatedElement element) {
        Map<String, Object> map = toMap(annotation);
        if (element != null) {
            map.put("annotatedElement", element);
        }
        return map;
    }

    public static Annotation toAnnotation(Map<String, Object> map) {
        return toAnnotation(map, (Class) map.get("annotationType"));
    }

    public static <T extends Annotation> T toAnnotation(Map<String, Object> map, Class<T> annotationType) {
        return (T) ((Annotation) Proxy.newProxyInstance(annotationType.getClassLoader(), new Class[]{annotationType}, proxy, method, args -> {
            return notObjectMethod.test(method) ? map.get(method.getName()) : method.invoke(map, new Object[0]);
        }));
    }

    public static Object invoke(Method method, Object obj, Object... args) {
        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            return e;
        }
    }
}
