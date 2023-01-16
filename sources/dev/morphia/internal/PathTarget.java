package dev.morphia.internal;

import com.mongodb.lang.Nullable;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.NotMappableException;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.pojo.PropertyModel;
import dev.morphia.query.ValidationException;
import dev.morphia.sofia.Sofia;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.StringJoiner;

/* loaded from: grasscutter.jar:dev/morphia/internal/PathTarget.class */
public class PathTarget {
    private final List<String> segments;
    private final boolean validateNames;
    private int position;
    private final Mapper mapper;
    private final EntityModel root;
    private EntityModel context;
    private PropertyModel target;
    private boolean resolved;

    public PathTarget(Mapper mapper, EntityModel root, String path) {
        this(mapper, root, path, true);
    }

    public PathTarget(Mapper mapper, @Nullable EntityModel root, String path, boolean validateNames) {
        this.segments = Arrays.asList(path.split("\\."));
        this.root = root;
        this.mapper = mapper;
        this.validateNames = validateNames;
        this.resolved = path.startsWith("$");
    }

    public <T> PathTarget(Mapper mapper, @Nullable Class<T> type, String path) {
        this(mapper, (type == null || !mapper.isMappable(type)) ? null : mapper.getEntityModel(type), path, true);
    }

    public <T> PathTarget(Mapper mapper, @Nullable Class<T> type, String path, boolean validateNames) {
        this(mapper, (type == null || !mapper.isMappable(type)) ? null : mapper.getEntityModel(type), path, validateNames);
    }

    public String translatedPath() {
        if (!this.resolved) {
            resolve();
        }
        StringJoiner joiner = new StringJoiner(Mapper.IGNORED_FIELDNAME);
        List<String> list = this.segments;
        Objects.requireNonNull(joiner);
        list.forEach((v1) -> {
            r1.add(v1);
        });
        return joiner.toString();
    }

    @Nullable
    public PropertyModel getTarget() {
        if (!this.resolved) {
            resolve();
        }
        return this.target;
    }

    public String toString() {
        return String.format("PathTarget{root=%s, segments=%s, target=%s}", this.root.getType().getSimpleName(), this.segments, this.target);
    }

    private boolean hasNext() {
        return this.position < this.segments.size();
    }

    private void failValidation(String pathElement) {
        this.resolved = true;
        throw new ValidationException(Sofia.invalidPathTarget(translatedPath(), this.root.getType().getName(), pathElement, new Locale[0]));
    }

    private void resolve() {
        this.context = this.root;
        this.position = 0;
        PropertyModel property = null;
        while (hasNext()) {
            String segment = next();
            if ("$".equals(segment) || ((segment.startsWith("$[") && segment.endsWith("]")) || segment.matches("[0-9]+"))) {
                if (!hasNext()) {
                    break;
                }
                segment = next();
            }
            property = resolveProperty(segment);
            if (property != null) {
                if (hasNext() && property.isReference()) {
                    failValidation(segment);
                }
                translate(property.getMappedName());
                if (property.isMap() && hasNext()) {
                    next();
                }
            } else if (this.validateNames) {
                failValidation(segment);
            }
        }
        this.target = property;
        this.resolved = true;
    }

    private void translate(String nameToStore) {
        this.segments.set(this.position - 1, nameToStore);
    }

    @Nullable
    private PropertyModel resolveProperty(String segment) {
        if (this.context == null) {
            return null;
        }
        PropertyModel model = this.context.getProperty(segment);
        if (model == null) {
            Iterator<EntityModel> subTypes = this.context.getSubtypes().iterator();
            while (model == null && subTypes.hasNext()) {
                this.context = subTypes.next();
                model = resolveProperty(segment);
            }
        }
        if (model != null) {
            try {
                this.context = this.mapper.getEntityModel(model.getNormalizedType());
            } catch (NotMappableException e) {
                this.context = null;
            }
        }
        return model;
    }

    String next() {
        List<String> list = this.segments;
        int i = this.position;
        this.position = i + 1;
        return list.get(i);
    }
}
