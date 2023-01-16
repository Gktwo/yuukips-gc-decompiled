package p013io.netty.util;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p001ch.qos.logback.core.joran.action.Action;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.util.DefaultAttributeMap */
/* loaded from: grasscutter.jar:io/netty/util/DefaultAttributeMap.class */
public class DefaultAttributeMap implements AttributeMap {
    private static final AtomicReferenceFieldUpdater<DefaultAttributeMap, DefaultAttribute[]> ATTRIBUTES_UPDATER;
    private static final DefaultAttribute[] EMPTY_ATTRIBUTES;
    private volatile DefaultAttribute[] attributes = EMPTY_ATTRIBUTES;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !DefaultAttributeMap.class.desiredAssertionStatus();
        ATTRIBUTES_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultAttributeMap.class, DefaultAttribute[].class, "attributes");
        EMPTY_ATTRIBUTES = new DefaultAttribute[0];
    }

    private static int searchAttributeByKey(DefaultAttribute[] sortedAttributes, AttributeKey<?> key) {
        int low = 0;
        int high = sortedAttributes.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            AttributeKey midValKey = sortedAttributes[mid].key;
            if (midValKey == key) {
                return mid;
            }
            int midValKeyId = midValKey.mo1173id();
            int keyId = key.mo1173id();
            if ($assertionsDisabled || midValKeyId != keyId) {
                if (midValKeyId < keyId) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                throw new AssertionError();
            }
        }
        return -(low + 1);
    }

    private static void orderedCopyOnInsert(DefaultAttribute[] sortedSrc, int srcLength, DefaultAttribute[] copy, DefaultAttribute toInsert) {
        int id = toInsert.key.mo1173id();
        int i = srcLength - 1;
        while (i >= 0) {
            DefaultAttribute attribute = sortedSrc[i];
            if (!$assertionsDisabled && attribute.key.mo1173id() == id) {
                throw new AssertionError();
            } else if (attribute.key.mo1173id() < id) {
                break;
            } else {
                copy[i + 1] = sortedSrc[i];
                i--;
            }
        }
        copy[i + 1] = toInsert;
        int toCopy = i + 1;
        if (toCopy > 0) {
            System.arraycopy(sortedSrc, 0, copy, 0, toCopy);
        }
    }

    @Override // p013io.netty.util.AttributeMap
    public <T> Attribute<T> attr(AttributeKey<T> key) {
        DefaultAttribute[] attributes;
        DefaultAttribute[] newAttributes;
        ObjectUtil.checkNotNull(key, Action.KEY_ATTRIBUTE);
        DefaultAttribute newAttribute = null;
        do {
            attributes = this.attributes;
            int index = searchAttributeByKey(attributes, key);
            if (index >= 0) {
                DefaultAttribute attribute = attributes[index];
                if (!$assertionsDisabled && attribute.key() != key) {
                    throw new AssertionError();
                } else if (!attribute.isRemoved()) {
                    return attribute;
                } else {
                    if (newAttribute == null) {
                        newAttribute = new DefaultAttribute(this, key);
                    }
                    newAttributes = (DefaultAttribute[]) Arrays.copyOf(attributes, attributes.length);
                    newAttributes[index] = newAttribute;
                }
            } else {
                if (newAttribute == null) {
                    newAttribute = new DefaultAttribute(this, key);
                }
                int count = attributes.length;
                newAttributes = new DefaultAttribute[count + 1];
                orderedCopyOnInsert(attributes, count, newAttributes, newAttribute);
            }
        } while (!ATTRIBUTES_UPDATER.compareAndSet(this, attributes, newAttributes));
        return newAttribute;
    }

    @Override // p013io.netty.util.AttributeMap
    public <T> boolean hasAttr(AttributeKey<T> key) {
        ObjectUtil.checkNotNull(key, Action.KEY_ATTRIBUTE);
        return searchAttributeByKey(this.attributes, key) >= 0;
    }

    /* access modifiers changed from: private */
    public <T> void removeAttributeIfMatch(AttributeKey<T> key, DefaultAttribute<T> value) {
        DefaultAttribute[] attributes;
        DefaultAttribute[] newAttributes;
        do {
            attributes = this.attributes;
            int index = searchAttributeByKey(attributes, key);
            if (index >= 0) {
                DefaultAttribute attribute = attributes[index];
                if (!$assertionsDisabled && attribute.key() != key) {
                    throw new AssertionError();
                } else if (attribute == value) {
                    int count = attributes.length;
                    int newCount = count - 1;
                    newAttributes = newCount == 0 ? EMPTY_ATTRIBUTES : new DefaultAttribute[newCount];
                    System.arraycopy(attributes, 0, newAttributes, 0, index);
                    int remaining = (count - index) - 1;
                    if (remaining > 0) {
                        System.arraycopy(attributes, index + 1, newAttributes, index, remaining);
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!ATTRIBUTES_UPDATER.compareAndSet(this, attributes, newAttributes));
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.DefaultAttributeMap$DefaultAttribute */
    /* loaded from: grasscutter.jar:io/netty/util/DefaultAttributeMap$DefaultAttribute.class */
    public static final class DefaultAttribute<T> extends AtomicReference<T> implements Attribute<T> {
        private static final AtomicReferenceFieldUpdater<DefaultAttribute, DefaultAttributeMap> MAP_UPDATER = AtomicReferenceFieldUpdater.newUpdater(DefaultAttribute.class, DefaultAttributeMap.class, "attributeMap");
        private static final long serialVersionUID = -2661411462200283011L;
        private volatile DefaultAttributeMap attributeMap;
        private final AttributeKey<T> key;

        DefaultAttribute(DefaultAttributeMap attributeMap, AttributeKey<T> key) {
            this.attributeMap = attributeMap;
            this.key = key;
        }

        @Override // p013io.netty.util.Attribute
        public AttributeKey<T> key() {
            return this.key;
        }

        /* access modifiers changed from: private */
        public boolean isRemoved() {
            return this.attributeMap == null;
        }

        @Override // p013io.netty.util.Attribute
        public T setIfAbsent(T value) {
            while (!compareAndSet(null, value)) {
                T old = get();
                if (old != null) {
                    return old;
                }
            }
            return null;
        }

        @Override // p013io.netty.util.Attribute
        public T getAndRemove() {
            DefaultAttributeMap attributeMap = this.attributeMap;
            boolean removed = attributeMap != null && MAP_UPDATER.compareAndSet(this, attributeMap, null);
            T oldValue = getAndSet(null);
            if (removed) {
                attributeMap.removeAttributeIfMatch(this.key, this);
            }
            return oldValue;
        }

        @Override // p013io.netty.util.Attribute
        public void remove() {
            DefaultAttributeMap attributeMap = this.attributeMap;
            boolean removed = attributeMap != null && MAP_UPDATER.compareAndSet(this, attributeMap, null);
            set(null);
            if (removed) {
                attributeMap.removeAttributeIfMatch(this.key, this);
            }
        }
    }
}
