package org.jline.builtins;

import dev.morphia.mapping.Mapper;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.slf4j.Marker;

/* loaded from: grasscutter.jar:org/jline/builtins/NfaMatcher.class */
public class NfaMatcher<T> {
    private final String regexp;
    private final BiFunction<T, String, Boolean> matcher;
    private volatile State start;

    public NfaMatcher(String regexp, BiFunction<T, String, Boolean> matcher) {
        this.regexp = regexp;
        this.matcher = matcher;
    }

    public void compile() {
        if (this.start == null) {
            this.start = toNfa(toPostFix(this.regexp));
        }
    }

    public boolean match(List<T> args) {
        Set<State> clist = new HashSet<>();
        compile();
        addState(clist, this.start);
        for (T arg : args) {
            Set<State> nlist = new HashSet<>();
            clist.stream().filter(s -> {
                return !Objects.equals("++MATCH++", s.f3201c) && !Objects.equals("++SPLIT++", s.f3201c);
            }).filter(s -> {
                return this.matcher.apply(arg, arg.f3201c).booleanValue();
            }).forEach(s -> {
                addState(nlist, nlist.out);
            });
            clist = nlist;
        }
        return clist.stream().anyMatch(s -> {
            return Objects.equals("++MATCH++", s.f3201c);
        });
    }

    public Set<String> matchPartial(List<T> args) {
        Set<State> clist = new HashSet<>();
        compile();
        addState(clist, this.start);
        for (T arg : args) {
            Set<State> nlist = new HashSet<>();
            clist.stream().filter(s -> {
                return !Objects.equals("++MATCH++", s.f3201c) && !Objects.equals("++SPLIT++", s.f3201c);
            }).filter(s -> {
                return this.matcher.apply(arg, arg.f3201c).booleanValue();
            }).forEach(s -> {
                addState(nlist, nlist.out);
            });
            clist = nlist;
        }
        return (Set) clist.stream().filter(s -> {
            return !Objects.equals("++MATCH++", s.f3201c) && !Objects.equals("++SPLIT++", s.f3201c);
        }).map(s -> {
            return s.f3201c;
        }).collect(Collectors.toSet());
    }

    void addState(Set<State> l, State s) {
        if (s != null && l.add(s) && Objects.equals("++SPLIT++", s.f3201c)) {
            addState(l, s.out);
            addState(l, s.out1);
        }
    }

    static State toNfa(List<String> postfix) {
        Deque<Frag> stack = new ArrayDeque<>();
        for (String p : postfix) {
            char c = 65535;
            switch (p.hashCode()) {
                case 42:
                    if (p.equals("*")) {
                        c = 3;
                        break;
                    }
                    break;
                case 43:
                    if (p.equals(Marker.ANY_NON_NULL_MARKER)) {
                        c = 4;
                        break;
                    }
                    break;
                case 46:
                    if (p.equals(Mapper.IGNORED_FIELDNAME)) {
                        c = 0;
                        break;
                    }
                    break;
                case 63:
                    if (p.equals("?")) {
                        c = 2;
                        break;
                    }
                    break;
                case 124:
                    if (p.equals("|")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    Frag e2 = stack.pollLast();
                    Frag e1 = stack.pollLast();
                    e1.patch(e2.start);
                    stack.offerLast(new Frag(e1.start, e2.out));
                    break;
                case 1:
                    Frag e22 = stack.pollLast();
                    Frag e12 = stack.pollLast();
                    stack.offerLast(new Frag(new State("++SPLIT++", e12.start, e22.start), e12.out, e22.out));
                    break;
                case 2:
                    Frag e = stack.pollLast();
                    State s = new State("++SPLIT++", e.start, null);
                    List<Consumer<State>> list = e.out;
                    Objects.requireNonNull(s);
                    stack.offerLast(new Frag(s, list, this::setOut1));
                    break;
                case 3:
                    Frag e3 = stack.pollLast();
                    State s2 = new State("++SPLIT++", e3.start, null);
                    e3.patch(s2);
                    Objects.requireNonNull(s2);
                    stack.offerLast(new Frag(s2, this::setOut1));
                    break;
                case 4:
                    Frag e4 = stack.pollLast();
                    State s3 = new State("++SPLIT++", e4.start, null);
                    e4.patch(s3);
                    State state = e4.start;
                    Objects.requireNonNull(s3);
                    stack.offerLast(new Frag(state, this::setOut1));
                    break;
                default:
                    State s4 = new State(p, null, null);
                    Objects.requireNonNull(s4);
                    stack.offerLast(new Frag(s4, this::setOut));
                    break;
            }
        }
        Frag e5 = stack.pollLast();
        if (!stack.isEmpty()) {
            throw new IllegalStateException("Wrong postfix expression, " + stack.size() + " elements remaining");
        }
        e5.patch(new State("++MATCH++", null, null));
        return e5.start;
    }

    static List<String> toPostFix(String regexp) {
        List<String> postfix = new ArrayList<>();
        int s = -1;
        int natom = 0;
        int nalt = 0;
        Deque<Integer> natoms = new ArrayDeque<>();
        Deque<Integer> nalts = new ArrayDeque<>();
        for (int i = 0; i < regexp.length(); i++) {
            char c = regexp.charAt(i);
            if (!Character.isJavaIdentifierPart(c)) {
                if (s >= 0) {
                    if (natom > 1) {
                        natom--;
                        postfix.add(Mapper.IGNORED_FIELDNAME);
                    }
                    postfix.add(regexp.substring(s, i));
                    natom++;
                    s = -1;
                }
                if (Character.isWhitespace(c)) {
                    continue;
                } else {
                    switch (c) {
                        case '(':
                            if (natom > 1) {
                                natom--;
                                postfix.add(Mapper.IGNORED_FIELDNAME);
                            }
                            nalts.offerLast(Integer.valueOf(nalt));
                            natoms.offerLast(Integer.valueOf(natom));
                            nalt = 0;
                            natom = 0;
                            continue;
                        case ')':
                            if (nalts.isEmpty() || natom == 0) {
                                throw new IllegalStateException("unexpected '" + c + "' at pos " + i);
                            }
                            while (true) {
                                natom--;
                                if (natom > 0) {
                                    postfix.add(Mapper.IGNORED_FIELDNAME);
                                }
                            }
                            while (nalt > 0) {
                                postfix.add("|");
                                nalt--;
                            }
                            nalt = nalts.pollLast().intValue();
                            natom = natoms.pollLast().intValue() + 1;
                            continue;
                        case '*':
                        case '+':
                        case '?':
                            if (natom == 0) {
                                throw new IllegalStateException("unexpected '" + c + "' at pos " + i);
                            }
                            postfix.add(String.valueOf(c));
                            continue;
                        case '|':
                            if (natom == 0) {
                                throw new IllegalStateException("unexpected '" + c + "' at pos " + i);
                            }
                            while (true) {
                                natom--;
                                if (natom > 0) {
                                    postfix.add(Mapper.IGNORED_FIELDNAME);
                                } else {
                                    nalt++;
                                    continue;
                                }
                            }
                        default:
                            throw new IllegalStateException("unexpected '" + c + "' at pos " + i);
                    }
                }
            } else if (s < 0) {
                s = i;
            }
        }
        if (s >= 0) {
            if (natom > 1) {
                natom--;
                postfix.add(Mapper.IGNORED_FIELDNAME);
            }
            postfix.add(regexp.substring(s));
            natom++;
        }
        while (true) {
            natom--;
            if (natom > 0) {
                postfix.add(Mapper.IGNORED_FIELDNAME);
            }
        }
        while (nalt > 0) {
            postfix.add("|");
            nalt--;
        }
        return postfix;
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/jline/builtins/NfaMatcher$State.class */
    public static class State {
        static final String Match = "++MATCH++";
        static final String Split = "++SPLIT++";

        /* renamed from: c */
        final String f3201c;
        State out;
        State out1;

        public State(String c, State out, State out1) {
            this.f3201c = c;
            this.out = out;
            this.out1 = out1;
        }

        public void setOut(State out) {
            this.out = out;
        }

        public void setOut1(State out1) {
            this.out1 = out1;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/builtins/NfaMatcher$Frag.class */
    public static class Frag {
        final State start;
        final List<Consumer<State>> out = new ArrayList();

        public Frag(State start, Collection<Consumer<State>> l) {
            this.start = start;
            this.out.addAll(l);
        }

        public Frag(State start, Collection<Consumer<State>> l1, Collection<Consumer<State>> l2) {
            this.start = start;
            this.out.addAll(l1);
            this.out.addAll(l2);
        }

        public Frag(State start, Consumer<State> c) {
            this.start = start;
            this.out.add(c);
        }

        public Frag(State start, Collection<Consumer<State>> l, Consumer<State> c) {
            this.start = start;
            this.out.addAll(l);
            this.out.add(c);
        }

        public void patch(State s) {
            this.out.forEach(c -> {
                c.accept(s);
            });
        }
    }
}
