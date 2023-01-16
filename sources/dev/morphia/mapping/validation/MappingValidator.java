package dev.morphia.mapping.validation;

import dev.morphia.annotations.Property;
import dev.morphia.annotations.Reference;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.validation.ConstraintViolation;
import dev.morphia.mapping.validation.classrules.DuplicatedAttributeNames;
import dev.morphia.mapping.validation.classrules.EntityAndEmbed;
import dev.morphia.mapping.validation.classrules.EntityOrEmbed;
import dev.morphia.mapping.validation.classrules.MultipleId;
import dev.morphia.mapping.validation.classrules.MultipleVersions;
import dev.morphia.mapping.validation.fieldrules.ContradictingAnnotations;
import dev.morphia.mapping.validation.fieldrules.IdDoesNotMix;
import dev.morphia.mapping.validation.fieldrules.LazyReferenceMissingDependencies;
import dev.morphia.mapping.validation.fieldrules.LazyReferenceOnArray;
import dev.morphia.mapping.validation.fieldrules.MapKeyTypeConstraint;
import dev.morphia.mapping.validation.fieldrules.ReferenceToUnidentifiable;
import dev.morphia.mapping.validation.fieldrules.VersionMisuse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:dev/morphia/mapping/validation/MappingValidator.class */
public class MappingValidator {
    private static final Logger LOG = LoggerFactory.getLogger(MappingValidator.class);

    public void validate(Mapper mapper, EntityModel entityModel) {
        Set<ConstraintViolation> ve = new TreeSet<>(o1, o2 -> {
            return o1.getLevel().ordinal() > o2.getLevel().ordinal() ? -1 : 1;
        });
        for (ClassConstraint v : getConstraints()) {
            v.check(mapper, entityModel, ve);
        }
        if (ve.isEmpty()) {
            return;
        }
        if (ve.iterator().next().getLevel().ordinal() >= ConstraintViolation.Level.FATAL.ordinal()) {
            throw new ConstraintViolationException(ve);
        }
        List<LogLine> l = new ArrayList<>();
        for (ConstraintViolation v2 : ve) {
            l.add(new LogLine(v2));
        }
        Collections.sort(l);
        for (LogLine line : l) {
            line.log();
        }
    }

    private List<ClassConstraint> getConstraints() {
        List<ClassConstraint> constraints = new ArrayList<>(32);
        constraints.add(new MultipleId());
        constraints.add(new MultipleVersions());
        constraints.add(new EntityAndEmbed());
        constraints.add(new EntityOrEmbed());
        constraints.add(new DuplicatedAttributeNames());
        constraints.add(new IdDoesNotMix());
        constraints.add(new ReferenceToUnidentifiable());
        constraints.add(new LazyReferenceMissingDependencies());
        constraints.add(new LazyReferenceOnArray());
        constraints.add(new MapKeyTypeConstraint());
        constraints.add(new VersionMisuse());
        constraints.add(new ContradictingAnnotations(Reference.class, Property.class));
        return constraints;
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:dev/morphia/mapping/validation/MappingValidator$LogLine.class */
    public static class LogLine implements Comparable<LogLine> {

        /* renamed from: v */
        private final ConstraintViolation f480v;

        LogLine(ConstraintViolation v) {
            this.f480v = v;
        }

        public int compareTo(LogLine o) {
            return this.f480v.getPrefix().compareTo(o.f480v.getPrefix());
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.f480v.hashCode();
        }

        @Override // java.lang.Object
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            return this.f480v.equals(((LogLine) o).f480v);
        }

        void log() {
            switch (this.f480v.getLevel()) {
                case SEVERE:
                    MappingValidator.LOG.error(this.f480v.render());
                    return;
                case WARNING:
                    MappingValidator.LOG.warn(this.f480v.render());
                    return;
                case INFO:
                    MappingValidator.LOG.info(this.f480v.render());
                    return;
                case MINOR:
                    MappingValidator.LOG.debug(this.f480v.render());
                    return;
                default:
                    throw new IllegalStateException(String.format("Cannot log %s of Level %s", ConstraintViolation.class.getSimpleName(), this.f480v.getLevel()));
            }
        }
    }
}
