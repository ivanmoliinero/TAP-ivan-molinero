package exercisesSolved.bstree;

public class BSCarTree extends BSTree<Car>{
    public void claxon() {
        preOrder(root);
    }

    private void preOrder(TreeNode node) {
        node.value.claxon();
        if(node.leftCh != null)
            preOrder(node.leftCh);
        if(node.rightCh != null)
            preOrder(node.rightCh);
    }
}
