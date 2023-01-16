package org.jline.reader.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.jline.reader.Candidate;
import org.jline.reader.CompletingParsedLine;
import org.jline.reader.CompletionMatcher;
import org.jline.reader.LineReader;
import org.jline.utils.AttributedString;

/* loaded from: grasscutter.jar:org/jline/reader/impl/CompletionMatcherImpl.class */
public class CompletionMatcherImpl implements CompletionMatcher {
    protected Predicate<String> exact;
    protected List<Function<Map<String, List<Candidate>>, Map<String, List<Candidate>>>> matchers;
    private Map<String, List<Candidate>> matching;
    private boolean caseInsensitive;

    protected void reset(boolean caseInsensitive) {
        this.caseInsensitive = caseInsensitive;
        this.exact = s -> {
            return false;
        };
        this.matchers = new ArrayList();
        this.matching = null;
    }

    @Override // org.jline.reader.CompletionMatcher
    public void compile(Map<LineReader.Option, Boolean> options, boolean prefix, CompletingParsedLine line, boolean caseInsensitive, int errors, String originalGroupName) {
        reset(caseInsensitive);
        defaultMatchers(options, prefix, line, caseInsensitive, errors, originalGroupName);
    }

    @Override // org.jline.reader.CompletionMatcher
    public List<Candidate> matches(List<Candidate> candidates) {
        this.matching = Collections.emptyMap();
        Map<String, List<Candidate>> sortedCandidates = sort(candidates);
        for (Function<Map<String, List<Candidate>>, Map<String, List<Candidate>>> matcher : this.matchers) {
            this.matching = matcher.apply(sortedCandidates);
            if (!this.matching.isEmpty()) {
                break;
            }
        }
        return !this.matching.isEmpty() ? (List) this.matching.entrySet().stream().flatMap(e -> {
            return ((List) e.getValue()).stream();
        }).distinct().collect(Collectors.toList()) : new ArrayList();
    }

    @Override // org.jline.reader.CompletionMatcher
    public Candidate exactMatch() {
        if (this.matching != null) {
            return (Candidate) this.matching.values().stream().flatMap((v0) -> {
                return v0.stream();
            }).filter((v0) -> {
                return v0.complete();
            }).filter(c -> {
                return this.exact.test(c.value());
            }).findFirst().orElse(null);
        }
        throw new IllegalStateException();
    }

    @Override // org.jline.reader.CompletionMatcher
    public String getCommonPrefix() {
        if (this.matching == null) {
            throw new IllegalStateException();
        }
        String commonPrefix = null;
        for (String key : this.matching.keySet()) {
            commonPrefix = commonPrefix == null ? key : getCommonStart(commonPrefix, key, this.caseInsensitive);
        }
        return commonPrefix;
    }

    protected void defaultMatchers(Map<LineReader.Option, Boolean> options, boolean prefix, CompletingParsedLine line, boolean caseInsensitive, int errors, String originalGroupName) {
        String wd = line.word();
        String wdi = caseInsensitive ? wd.toLowerCase() : wd;
        String wp = wdi.substring(0, line.wordCursor());
        if (prefix) {
            this.matchers = new ArrayList(Arrays.asList(simpleMatcher(s -> {
                return (caseInsensitive ? s.toLowerCase() : s).startsWith(wp);
            }), simpleMatcher(s -> {
                return (caseInsensitive ? s.toLowerCase() : s).contains(wp);
            })));
            if (LineReader.Option.COMPLETE_MATCHER_TYPO.isSet(options)) {
                this.matchers.add(typoMatcher(wp, errors, caseInsensitive, originalGroupName));
            }
            this.exact = s -> {
                return caseInsensitive ? s.equalsIgnoreCase(wp) : s.equals(wp);
            };
        } else if (LineReader.Option.EMPTY_WORD_OPTIONS.isSet(options) || wd.length() != 0) {
            if (LineReader.Option.COMPLETE_IN_WORD.isSet(options)) {
                String ws = wdi.substring(line.wordCursor());
                Pattern p1 = Pattern.compile(Pattern.quote(wp) + ".*" + Pattern.quote(ws) + ".*");
                Pattern p2 = Pattern.compile(".*" + Pattern.quote(wp) + ".*" + Pattern.quote(ws) + ".*");
                this.matchers = new ArrayList(Arrays.asList(simpleMatcher(s -> {
                    return p1.matcher(caseInsensitive ? s.toLowerCase() : s).matches();
                }), simpleMatcher(s -> {
                    return p2.matcher(caseInsensitive ? s.toLowerCase() : s).matches();
                })));
            } else {
                this.matchers = new ArrayList(Arrays.asList(simpleMatcher(s -> {
                    return (caseInsensitive ? s.toLowerCase() : s).startsWith(wdi);
                }), simpleMatcher(s -> {
                    return (caseInsensitive ? s.toLowerCase() : s).contains(wdi);
                })));
            }
            if (LineReader.Option.COMPLETE_MATCHER_CAMELCASE.isSet(options)) {
                this.matchers.add(simpleMatcher(s -> {
                    return camelMatch(wd, 0, wd, 0);
                }));
            }
            if (LineReader.Option.COMPLETE_MATCHER_TYPO.isSet(options)) {
                this.matchers.add(typoMatcher(wdi, errors, caseInsensitive, originalGroupName));
            }
            this.exact = s -> {
                return caseInsensitive ? s.equalsIgnoreCase(wd) : s.equals(wd);
            };
        } else {
            this.matchers = new ArrayList(Collections.singletonList(simpleMatcher(s -> {
                return !s.startsWith("-");
            })));
            this.exact = s -> {
                return caseInsensitive ? s.equalsIgnoreCase(wd) : s.equals(wd);
            };
        }
    }

    protected Function<Map<String, List<Candidate>>, Map<String, List<Candidate>>> simpleMatcher(Predicate<String> predicate) {
        return m -> {
            return (Map) m.entrySet().stream().filter(e -> {
                return predicate.test((String) e.getKey());
            }).collect(Collectors.toMap((v0) -> {
                return v0.getKey();
            }, (v0) -> {
                return v0.getValue();
            }));
        };
    }

    protected Function<Map<String, List<Candidate>>, Map<String, List<Candidate>>> typoMatcher(String word, int errors, boolean caseInsensitive, String originalGroupName) {
        return m -> {
            Map<String, List<Candidate>> map = (Map) m.entrySet().stream().filter(e -> {
                return ReaderUtils.distance(word, caseInsensitive ? ((String) e.getKey()).toLowerCase() : (String) e.getKey()) < errors;
            }).collect(Collectors.toMap((v0) -> {
                return v0.getKey();
            }, (v0) -> {
                return v0.getValue();
            }));
            if (map.size() > 1) {
                map.computeIfAbsent(word, w -> {
                    return new ArrayList();
                }).add(new Candidate(word, word, originalGroupName, null, null, null, false));
            }
            return map;
        };
    }

    protected boolean camelMatch(String word, int i, String candidate, int j) {
        if (word.length() <= i) {
            return true;
        }
        if (candidate.length() <= j) {
            return false;
        }
        char c = word.charAt(i);
        if (c == candidate.charAt(j)) {
            return camelMatch(word, i + 1, candidate, j + 1);
        }
        for (int j1 = j; j1 < candidate.length(); j1++) {
            if (Character.isUpperCase(candidate.charAt(j1)) && Character.toUpperCase(c) == candidate.charAt(j1) && camelMatch(word, i + 1, candidate, j1 + 1)) {
                return true;
            }
        }
        return false;
    }

    private Map<String, List<Candidate>> sort(List<Candidate> candidates) {
        Map<String, List<Candidate>> sortedCandidates = new HashMap<>();
        for (Candidate candidate : candidates) {
            sortedCandidates.computeIfAbsent(AttributedString.fromAnsi(candidate.value()).toString(), s -> {
                return new ArrayList();
            }).add(candidate);
        }
        return sortedCandidates;
    }

    private String getCommonStart(String str1, String str2, boolean caseInsensitive) {
        int[] s1 = str1.codePoints().toArray();
        int[] s2 = str2.codePoints().toArray();
        int len = 0;
        while (len < Math.min(s1.length, s2.length)) {
            int ch1 = s1[len];
            int ch2 = s2[len];
            if (ch1 != ch2 && caseInsensitive) {
                ch1 = Character.toUpperCase(ch1);
                ch2 = Character.toUpperCase(ch2);
                if (ch1 != ch2) {
                    ch1 = Character.toLowerCase(ch1);
                    ch2 = Character.toLowerCase(ch2);
                }
            }
            if (ch1 != ch2) {
                break;
            }
            len++;
        }
        return new String(s1, 0, len);
    }
}
