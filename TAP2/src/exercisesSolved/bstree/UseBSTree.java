package exercisesSolved.bstree;

public class UseBSTree {
    public static void main(String[] args) throws Exception {
        // Integer test.
        BSTree<Integer> tree = new BSTree<>();

        tree.insert(5);
        tree.insert(3);
        tree.insert(6);
        tree.insert(1);
        tree.insert(4);

        System.out.println(tree.contains(4));
        System.out.println(tree.contains(6));

        for(Integer i : tree)
            System.out.println(i);

        // Car test
        BSTree<Car> treeCar = new BSTree<>();
        treeCar.insert(new Car("VOLVO", 40000));
        treeCar.insert(new Car("LAMBORGHINI", 100000));
        treeCar.insert(new Car("TESLA", 80000));
        treeCar.insert(new Car("OPEL", 20000));

        for(Car i : treeCar)
            System.out.println(i);

        // Car test with the claxon.
        BSCarTree treeCar2 = new BSCarTree();
        treeCar2.insert(new Car("VOLVO", 40000));
        treeCar2.insert(new Car("LAMBORGHINI", 100000));
        treeCar2.insert(new Car("TESLA", 80000));
        treeCar2.insert(new Car("OPEL", 20000));

        treeCar2.claxon();
    }
}
