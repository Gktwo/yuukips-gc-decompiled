package kcp.highway.internal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: grasscutter.jar:kcp/highway/internal/ReItrLinkedList.class */
public class ReItrLinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, Serializable {
    transient int size;
    transient Node<E> first;
    transient Node<E> last;
    private static final long serialVersionUID = 8249177923269915620L;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0005: INVOKE_CUSTOM r-2, r-1
        java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        	at java.base/java.util.Objects.checkIndex(Objects.java:359)
        	at java.base/java.util.ArrayList.get(ArrayList.java:427)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
        	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
        */
    /*  JADX ERROR: Failed to decode insn: 0x0005: INVOKE_CUSTOM r0, r1, method: kcp.highway.internal.ReItrLinkedList.outOfBoundsMsg(int):java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, Index: , Size: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, Index: , Size: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private java.lang.String outOfBoundsMsg(int r4) {
        /*
            r3 = this;
            r0 = r4
            r1 = r3
            int r1 = r1.size
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, Index: , Size: ]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kcp.highway.internal.ReItrLinkedList.outOfBoundsMsg(int):java.lang.String");
    }

    public ReItrLinkedList() {
        this.size = 0;
    }

    public ReItrLinkedList(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    private void linkFirst(E e) {
        Node<E> f = this.first;
        Node<E> newNode = new Node<>(null, e, f);
        this.first = newNode;
        if (f == null) {
            this.last = newNode;
        } else {
            f.prev = newNode;
        }
        this.size++;
        this.modCount++;
    }

    void linkLast(E e) {
        Node<E> l = this.last;
        Node<E> newNode = new Node<>(l, e, null);
        this.last = newNode;
        if (l == null) {
            this.first = newNode;
        } else {
            l.next = newNode;
        }
        this.size++;
        this.modCount++;
    }

    void linkBefore(E e, Node<E> succ) {
        Node<E> pred = succ.prev;
        Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null) {
            this.first = newNode;
        } else {
            pred.next = newNode;
        }
        this.size++;
        this.modCount++;
    }

    private E unlinkFirst(Node<E> f) {
        E element = f.item;
        Node<E> next = f.next;
        f.item = null;
        f.next = null;
        this.first = next;
        if (next == null) {
            this.last = null;
        } else {
            next.prev = null;
        }
        this.size--;
        this.modCount++;
        return element;
    }

    private E unlinkLast(Node<E> l) {
        E element = l.item;
        Node<E> prev = l.prev;
        l.item = null;
        l.prev = null;
        this.last = prev;
        if (prev == null) {
            this.first = null;
        } else {
            prev.next = null;
        }
        this.size--;
        this.modCount++;
        return element;
    }

    E unlink(Node<E> x) {
        E element = x.item;
        Node<E> next = x.next;
        Node<E> prev = x.prev;
        if (prev == null) {
            this.first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }
        if (next == null) {
            this.last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }
        x.item = null;
        this.size--;
        this.modCount++;
        return element;
    }

    @Override // java.util.Deque
    public E getFirst() {
        Node<E> f = this.first;
        if (f != null) {
            return f.item;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Deque
    public E getLast() {
        Node<E> l = this.last;
        if (l != null) {
            return l.item;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Deque
    public E removeFirst() {
        Node<E> f = this.first;
        if (f != null) {
            return unlinkFirst(f);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Deque
    public E removeLast() {
        Node<E> l = this.last;
        if (l != null) {
            return unlinkLast(l);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Deque
    public void addFirst(E e) {
        linkFirst(e);
    }

    @Override // java.util.Deque
    public void addLast(E e) {
        linkLast(e);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.Deque
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.Deque
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.util.Deque, java.util.Queue
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.Deque
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = this.first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
            return false;
        }
        for (Node<E> x2 = this.first; x2 != null; x2 = x2.next) {
            if (o.equals(x2.item)) {
                unlink(x2);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> c) {
        return addAll(this.size, c);
    }

    @Override // java.util.AbstractSequentialList, java.util.List, java.util.AbstractList
    public boolean addAll(int index, Collection<? extends E> c) {
        Node<E> succ;
        Node<E> pred;
        checkPositionIndex(index);
        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0) {
            return false;
        }
        if (index == this.size) {
            succ = null;
            pred = this.last;
        } else {
            succ = node(index);
            pred = succ.prev;
        }
        for (Object o : a) {
            Node<E> newNode = new Node<>(pred, o, null);
            if (pred == null) {
                this.first = newNode;
            } else {
                pred.next = newNode;
            }
            pred = newNode;
        }
        if (succ == null) {
            this.last = pred;
        } else {
            pred.next = succ;
            succ.prev = pred;
        }
        this.size += numNew;
        this.modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public void clear() {
        Node<E> x = this.first;
        while (x != null) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        this.last = null;
        this.first = null;
        this.size = 0;
        this.modCount++;
    }

    @Override // java.util.AbstractSequentialList, java.util.List, java.util.AbstractList
    public E get(int index) {
        checkElementIndex(index);
        return node(index).item;
    }

    @Override // java.util.AbstractSequentialList, java.util.List, java.util.AbstractList
    public E set(int index, E element) {
        checkElementIndex(index);
        Node<E> x = node(index);
        E oldVal = x.item;
        x.item = element;
        return oldVal;
    }

    @Override // java.util.AbstractSequentialList, java.util.List, java.util.AbstractList
    public void add(int index, E element) {
        checkPositionIndex(index);
        if (index == this.size) {
            linkLast(element);
        } else {
            linkBefore(element, node(index));
        }
    }

    @Override // java.util.AbstractSequentialList, java.util.List, java.util.AbstractList
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < this.size;
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= this.size;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    Node<E> node(int index) {
        if (index < (this.size >> 1)) {
            Node<E> x = this.first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        }
        Node<E> x2 = this.last;
        for (int i2 = this.size - 1; i2 > index; i2--) {
            x2 = x2.prev;
        }
        return x2;
    }

    @Override // java.util.List, java.util.AbstractList
    public int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = this.first; x != null; x = x.next) {
                if (x.item == null) {
                    return index;
                }
                index++;
            }
            return -1;
        }
        for (Node<E> x2 = this.first; x2 != null; x2 = x2.next) {
            if (o.equals(x2.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override // java.util.List, java.util.AbstractList
    public int lastIndexOf(Object o) {
        int index = this.size;
        if (o == null) {
            for (Node<E> x = this.last; x != null; x = x.prev) {
                index--;
                if (x.item == null) {
                    return index;
                }
            }
            return -1;
        }
        for (Node<E> x2 = this.last; x2 != null; x2 = x2.prev) {
            index--;
            if (o.equals(x2.item)) {
                return index;
            }
        }
        return -1;
    }

    @Override // java.util.Deque, java.util.Queue
    public E peek() {
        Node<E> f = this.first;
        if (f == null) {
            return null;
        }
        return f.item;
    }

    @Override // java.util.Deque, java.util.Queue
    public E element() {
        return getFirst();
    }

    @Override // java.util.Deque, java.util.Queue
    public E poll() {
        Node<E> f = this.first;
        if (f == null) {
            return null;
        }
        return unlinkFirst(f);
    }

    @Override // java.util.Deque, java.util.Queue
    public E remove() {
        return removeFirst();
    }

    @Override // java.util.Deque, java.util.Queue
    public boolean offer(E e) {
        return add(e);
    }

    @Override // java.util.Deque
    public boolean offerFirst(E e) {
        addFirst(e);
        return true;
    }

    @Override // java.util.Deque
    public boolean offerLast(E e) {
        addLast(e);
        return true;
    }

    @Override // java.util.Deque
    public E peekFirst() {
        Node<E> f = this.first;
        if (f == null) {
            return null;
        }
        return f.item;
    }

    @Override // java.util.Deque
    public E peekLast() {
        Node<E> l = this.last;
        if (l == null) {
            return null;
        }
        return l.item;
    }

    @Override // java.util.Deque
    public E pollFirst() {
        Node<E> f = this.first;
        if (f == null) {
            return null;
        }
        return unlinkFirst(f);
    }

    @Override // java.util.Deque
    public E pollLast() {
        Node<E> l = this.last;
        if (l == null) {
            return null;
        }
        return unlinkLast(l);
    }

    @Override // java.util.Deque
    public void push(E e) {
        addFirst(e);
    }

    @Override // java.util.Deque
    public E pop() {
        return removeFirst();
    }

    @Override // java.util.Deque
    public boolean removeFirstOccurrence(Object o) {
        return remove(o);
    }

    @Override // java.util.Deque
    public boolean removeLastOccurrence(Object o) {
        if (o == null) {
            for (Node<E> x = this.last; x != null; x = x.prev) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
            return false;
        }
        for (Node<E> x2 = this.last; x2 != null; x2 = x2.prev) {
            if (o.equals(x2.item)) {
                unlink(x2);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable, java.util.Deque
    public ReusableIterator<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List, java.util.AbstractList
    public ReusableListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractSequentialList, java.util.List, java.util.AbstractList
    public ReusableListIterator<E> listIterator(int index) {
        checkPositionIndex(index);
        return new ListItr(index);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:kcp/highway/internal/ReItrLinkedList$ListItr.class */
    public class ListItr implements ReusableListIterator<E> {
        private Node<E> lastReturned = null;
        private Node<E> next;
        private int nextIndex;
        private int expectedModCount;

        ListItr(int index) {
            this.expectedModCount = ReItrLinkedList.this.modCount;
            this.next = index == ReItrLinkedList.this.size ? null : ReItrLinkedList.this.node(index);
            this.nextIndex = index;
        }

        @Override // kcp.highway.internal.ReusableListIterator, kcp.highway.internal.ReusableIterator
        public ReusableListIterator<E> rewind() {
            return rewind(0);
        }

        @Override // kcp.highway.internal.ReusableListIterator
        public ReusableListIterator<E> rewind(int index) {
            this.lastReturned = null;
            this.next = index == ReItrLinkedList.this.size ? null : ReItrLinkedList.this.node(index);
            this.nextIndex = index;
            this.expectedModCount = ReItrLinkedList.this.modCount;
            return this;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.nextIndex < ReItrLinkedList.this.size;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkForComodification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.lastReturned = this.next;
            this.next = this.next.next;
            this.nextIndex++;
            return this.lastReturned.item;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.nextIndex > 0;
        }

        @Override // java.util.ListIterator
        public E previous() {
            checkForComodification();
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            Node<E> node = this.next == null ? ReItrLinkedList.this.last : this.next.prev;
            this.next = node;
            this.lastReturned = node;
            this.nextIndex--;
            return this.lastReturned.item;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.nextIndex;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.nextIndex - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkForComodification();
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            Node<E> lastNext = this.lastReturned.next;
            ReItrLinkedList.this.unlink(this.lastReturned);
            if (this.next == this.lastReturned) {
                this.next = lastNext;
            } else {
                this.nextIndex--;
            }
            this.lastReturned = null;
            this.expectedModCount++;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            if (this.lastReturned == null) {
                throw new IllegalStateException();
            }
            checkForComodification();
            this.lastReturned.item = e;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            checkForComodification();
            this.lastReturned = null;
            if (this.next == null) {
                ReItrLinkedList.this.linkLast(e);
            } else {
                ReItrLinkedList.this.linkBefore(e, this.next);
            }
            this.nextIndex++;
            this.expectedModCount++;
        }

        final void checkForComodification() {
            if (ReItrLinkedList.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:kcp/highway/internal/ReItrLinkedList$Node.class */
    public static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return new DescendingIterator();
    }

    /* loaded from: grasscutter.jar:kcp/highway/internal/ReItrLinkedList$DescendingIterator.class */
    private class DescendingIterator implements Iterator<E> {
        private final ReItrLinkedList<E>.ListItr itr;

        private DescendingIterator() {
            this.itr = new ListItr(ReItrLinkedList.this.size());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.itr.hasPrevious();
        }

        @Override // java.util.Iterator
        public E next() {
            return this.itr.previous();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.itr.remove();
        }
    }

    private ReItrLinkedList<E> superClone() {
        try {
            return (ReItrLinkedList) clone();
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    @Override // java.lang.Object
    public Object clone() {
        ReItrLinkedList<E> clone = superClone();
        clone.last = null;
        clone.first = null;
        clone.size = 0;
        clone.modCount = 0;
        for (Node<E> x = this.first; x != null; x = x.next) {
            clone.add(x.item);
        }
        return clone;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public Object[] toArray() {
        Object[] result = new Object[this.size];
        int i = 0;
        for (Node<E> x = this.first; x != null; x = x.next) {
            i++;
            result[i] = x.item;
        }
        return result;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v3, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public <T> T[] toArray(T[] a) {
        if (a.length < this.size) {
            a = (T[]) ((Object[]) Array.newInstance(a.getClass().getComponentType(), this.size));
        }
        int i = 0;
        for (Node<E> x = this.first; x != null; x = x.next) {
            i++;
            a[i] = x.item;
        }
        if (a.length > this.size) {
            a[this.size] = null;
        }
        return a;
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeInt(this.size);
        for (Node<E> x = this.first; x != null; x = x.next) {
            s.writeObject(x.item);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kcp.highway.internal.ReItrLinkedList<E> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        int size = s.readInt();
        for (int i = 0; i < size; i++) {
            linkLast(s.readObject());
        }
    }
}
