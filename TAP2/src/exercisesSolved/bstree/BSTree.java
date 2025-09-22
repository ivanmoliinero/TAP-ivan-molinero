package exercisesSolved.bstree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BSTree<T extends Comparable<T>> implements Iterable<T> {
    // Attributes
    protected class TreeNode {
        protected TreeNode leftCh, rightCh, parent;
        protected T value;
    }

    protected TreeNode root;
    protected int numElems;

    public BSTree() {}

    public void insert(T newValue) {
        if(root == null) {
            // first element inserted.
            root = new TreeNode();
            root.value = newValue;
            root.rightCh = root.leftCh = root.parent = null;
            numElems++;
        }
        else {
            TreeNode actNode = root;
            double compVal;
            while(true) {
                if((compVal = actNode.value.compareTo(newValue)) > 0) {
                    // we should explore the left child.
                    if(actNode.leftCh != null) {
                        actNode = actNode.leftCh;
                    }
                    else {
                        // we found the actual position of the node.
                        actNode.leftCh = new TreeNode();
                        actNode.leftCh.leftCh = actNode.leftCh.rightCh = null;
                        actNode.leftCh.value = newValue;
                        actNode.leftCh.parent = actNode;
                        numElems++;
                        break;
                    }
                }
                else if (compVal < 0) {
                    // we should explore the right side.
                    if(actNode.rightCh != null) {
                        actNode = actNode.rightCh;
                    }
                    else {
                        // we found the actual position of the node.
                        actNode.rightCh = new TreeNode();
                        actNode.rightCh.leftCh = actNode.rightCh.rightCh = null;
                        actNode.rightCh.value = newValue;
                        actNode.rightCh.parent = actNode;
                        numElems++;
                        break;
                    }
                }
                else {
                    // duplicated value, exit the loop without making any changes.
                    break;
                }
            }
        }
    }

    public boolean contains(T value) {
        TreeNode actNode = root;
        double compVal;
        while(true) {
            if((compVal = actNode.value.compareTo(value)) > 0) {
                // we should explore the left child.
                if(actNode.leftCh != null) {
                    actNode = actNode.leftCh;
                }
                else {
                    // the node is not where it should be. Assign null and exit.
                    actNode = null;
                    break;
                }
            }
            else if (compVal < 0) {
                // we should explore the right side.
                if(actNode.rightCh != null) {
                    actNode = actNode.rightCh;
                }
                else {
                    // the node is not where it should be. Assign null and exit.
                    actNode = null;
                    break;
                }
            }
            else {
                // found it, exit and return true as it won't be a null value.
                break;
            }
        }

        return actNode != null;
    }

    @Override
    public Iterator<T> iterator() {
        List<T> result = new LinkedList<>();
        preOrderAdding(result, root);

        return result.iterator();
    }

    private void preOrderAdding(List<T> accum, TreeNode node) {
        accum.add(node.value);
        if(node.leftCh != null)
            preOrderAdding(accum, node.leftCh);
        if(node.rightCh != null)
            preOrderAdding(accum, node.rightCh);
    }
}
