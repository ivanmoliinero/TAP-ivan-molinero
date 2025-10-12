package solvedExercisesIvan.filesystemVisitor;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Directory implements SystemComponent {
    private List<SystemComponent> subComponents; // no matter if they are files or directories.
    private String name;
    private SystemComponent father;

    public Directory(String name, SystemComponent father) {
        subComponents = new LinkedList<>();
        this.name = name;
        this.father = father;
    }

    public void addComponent(SystemComponent newComponent) {
        subComponents.add(newComponent);
    }

    public String ls() {
        return subComponents.stream().collect(new Collector<SystemComponent, StringBuilder, String>() {
            @Override
            public Supplier<StringBuilder> supplier() {
                return StringBuilder::new;
            }

            @Override
            public BiConsumer<StringBuilder, SystemComponent> accumulator() {
                return (StringBuilder accum, SystemComponent newElem) -> {};
            }

            @Override
            public BinaryOperator<StringBuilder> combiner() {
                return null;
            }

            @Override
            public Function<StringBuilder, String> finisher() {
                return (result) -> result.toString() + name + "\n";
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Collections.emptySet();
            }
        });
    }

    public List<String> collect() {
        return subComponents
                .stream()
                .collect(new Collector<SystemComponent, LinkedList<List<String>>, List<String>>() {
                    @Override
                    public Supplier<LinkedList<List<String>>> supplier() {
                        return LinkedList::new;
                    }

                    @Override
                    public BiConsumer<LinkedList<List<String>>, SystemComponent> accumulator() {
                        return (accum, elem) -> {};
                    }

                    @Override
                    public BinaryOperator<LinkedList<List<String>>> combiner() {
                        return null;
                    }

                    @Override
                    public Function<LinkedList<List<String>>, List<String>> finisher() {
                        return (res) -> {
                            List<String> finalRes = res.stream().flatMap((elem) -> elem.stream()).collect(Collectors.toList());
                            finalRes.add(name);
                            return finalRes;
                        };
                    }

                    @Override
                    public Set<Characteristics> characteristics() {
                        return Collections.emptySet();
                    }
                });
    }

    public List<SystemComponent> toList() {
        List<SystemComponent> res = subComponents.stream().collect(new Collector<SystemComponent, LinkedList<List<SystemComponent>>, List<SystemComponent>>() {
            @Override
            public Supplier<LinkedList<List<SystemComponent>>> supplier() {
                return LinkedList::new;
            }

            @Override
            public BiConsumer<LinkedList<List<SystemComponent>>, SystemComponent> accumulator() {
                return (accum, elem) -> {};
            }

            @Override
            public BinaryOperator<LinkedList<List<SystemComponent>>> combiner() {
                return null;
            }

            @Override
            public Function<LinkedList<List<SystemComponent>>, List<SystemComponent>> finisher() {
                return (res) -> {
                    List<SystemComponent> finalRes = res.stream().flatMap((elem) -> elem.stream()).collect(Collectors.toList());
                    return finalRes;
                };
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Collections.emptySet();
            }
        });

        res.add(this);
        return res;
    }

    public List<SystemComponent> search(String name) {
        return subComponents.stream().collect(new Collector<SystemComponent, LinkedList<List<SystemComponent>>, List<SystemComponent>>() {
            @Override
            public Supplier<LinkedList<List<SystemComponent>>> supplier() {
                return LinkedList::new;
            }

            @Override
            public BiConsumer<LinkedList<List<SystemComponent>>, SystemComponent> accumulator() {
                return (accum, elem) -> {};
            }

            @Override
            public BinaryOperator<LinkedList<List<SystemComponent>>> combiner() {
                return null;
            }

            @Override
            public Function<LinkedList<List<SystemComponent>>, List<SystemComponent>> finisher() {
                return (res) -> {
                    List<SystemComponent> finalRes = res.stream().flatMap((elem) -> elem.stream()).collect(Collectors.toList());
                    return finalRes;
                };
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Collections.emptySet();
            }
        });
    }

    public List<SystemComponent> search(Predicate<SystemComponent> op) {
        return subComponents.stream().collect(new Collector<SystemComponent, LinkedList<List<SystemComponent>>, List<SystemComponent>>() {
            @Override
            public Supplier<LinkedList<List<SystemComponent>>> supplier() {
                return LinkedList::new;
            }

            @Override
            public BiConsumer<LinkedList<List<SystemComponent>>, SystemComponent> accumulator() {
                return (accum, elem) ->  {};
            }

            @Override
            public BinaryOperator<LinkedList<List<SystemComponent>>> combiner() {
                return null;
            }

            @Override
            public Function<LinkedList<List<SystemComponent>>, List<SystemComponent>> finisher() {
                return (res) -> {
                    List<SystemComponent> finalRes = res.stream().flatMap((elem) -> elem.stream()).collect(Collectors.toList());
                    return finalRes;
                };
            }

            @Override
            public Set<Characteristics> characteristics() {
                return Collections.emptySet();
            }
        });
    }

    @Override
    public void accept(FileSystemVisitor vis) {
        vis.visit(this);
    }

    @Override
    public String getName() {
        return name;
    }

    public String toString() {
        if(father == null)
            return name;

        return father + "/" + name;
    }

    public List<SystemComponent> getSubComponents() {
        return subComponents;
    }
}
