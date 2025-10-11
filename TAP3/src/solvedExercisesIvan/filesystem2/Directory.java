package solvedExercisesIvan.filesystem2;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Directory implements SystemComponent, Iterable<SystemComponent> {
    private List<SystemComponent> subComponents; // no matter if they are files or directories.
    private String name;
    private SystemComponent father;

    public Directory(String name) {
        subComponents = new LinkedList<>();
        this.name = name;
        this.father = null;
    }

    public void addComponent(SystemComponent newComponent) throws AlreadyAddedException {
        if(subComponents.contains(newComponent))
            throw new AlreadyAddedException(newComponent);
        subComponents.add(newComponent);
        newComponent.addFather(this);
    }

    @Override
    public String ls() {
        return subComponents.stream().collect(new Collector<SystemComponent, StringBuilder, String>() {
            @Override
            public Supplier<StringBuilder> supplier() {
                return StringBuilder::new;
            }

            @Override
            public BiConsumer<StringBuilder, SystemComponent> accumulator() {
                return (StringBuilder accum, SystemComponent newElem) -> accum.append(newElem.ls());
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

    @Override
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
                        return (accum, elem) -> accum.add(elem.collect());
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

    @Override
    public List<SystemComponent> toList() {
        List<SystemComponent> res = subComponents.stream().collect(new Collector<SystemComponent, LinkedList<List<SystemComponent>>, List<SystemComponent>>() {
            @Override
            public Supplier<LinkedList<List<SystemComponent>>> supplier() {
                return LinkedList::new;
            }

            @Override
            public BiConsumer<LinkedList<List<SystemComponent>>, SystemComponent> accumulator() {
                return (accum, elem) -> accum.add(elem.toList());
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

        // EXTRA: Order this.
        res.sort((elem1, elem2) -> elem1.getName().compareTo(elem2.getName()));

        return res;
    }

    @Override
    public List<SystemComponent> search(String name) {
        return subComponents.stream().collect(new Collector<SystemComponent, LinkedList<List<SystemComponent>>, List<SystemComponent>>() {
            @Override
            public Supplier<LinkedList<List<SystemComponent>>> supplier() {
                return LinkedList::new;
            }

            @Override
            public BiConsumer<LinkedList<List<SystemComponent>>, SystemComponent> accumulator() {
                return (accum, elem) -> accum.add(elem.search(name));
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
    public List<SystemComponent> search(Predicate<SystemComponent> op) {
        return subComponents.stream().collect(new Collector<SystemComponent, LinkedList<List<SystemComponent>>, List<SystemComponent>>() {
            @Override
            public Supplier<LinkedList<List<SystemComponent>>> supplier() {
                return LinkedList::new;
            }

            @Override
            public BiConsumer<LinkedList<List<SystemComponent>>, SystemComponent> accumulator() {
                return (accum, elem) -> accum.add(elem.search(op));
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
    public String getName() {
        return name;
    }

    @Override
    public void addFather(SystemComponent father) {
        this.father = father;
    }

    public String toString() {
        if(father == null)
            return name;

        return father + "/" + name;
    }

    @Override
    public Iterator<SystemComponent> iterator() {
        return subComponents.iterator(); // shall we do an iteration over all objects???
    }
}
