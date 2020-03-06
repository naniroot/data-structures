package bst;

import util.TestData;

import java.util.Random;

public class BinarySearchTree {
    public static void main(String args[]) {
        BinarySearchTree tree = new BinarySearchTree();
        int arraySize = 50;
        int arr[] = TestData.generateRandomIntegerArray(arraySize, 100);
        TreeNode root = null;
        for(int a: arr) {
            root = tree.insert(root, a);
        }
        tree.printTreeInorder(root);
        System.out.println();
        tree.search(root,54);
        System.out.println("Number of node: " + tree.countNodes(root));

//        System.out.println("Deleting node " + arr[0]);
//        root = tree.delete(root, arr[0]);
//        System.out.println("Deleting node " + root.val);
//        root = tree.delete(root, root.val);
//        tree.printTreeInorder(root);
//        System.out.println();

        Random rand = new Random();
        for(int i=0; i<10; i++) {
            int k = rand.nextInt(arraySize-i);
            System.out.println("Trying to delete: " + arr[k]);
            root = tree.delete(root, arr[k]);
            int temp = arr[arraySize-i-1];
            arr[arraySize-i-1] = arr[k];
            arr[k] = temp;
            tree.printTreeInorder(root);
            System.out.println();
        }
        System.out.println("Number of node: " + tree.countNodes(root));
    }

    TreeNode insert(TreeNode root, int val) {
        if(root == null) {
            return new TreeNode(val);
        }
        if(val > root.val) {
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }
        return root;
    }

    TreeNode delete(TreeNode root, int delVal) {
        if(root == null) {
            return root;
        }
        if(delVal > root.val) {
            root.right = delete(root.right, delVal);
            return root;
        } else if(delVal < root.val){
            root.left = delete(root.left, delVal);
            return root;
        } else {
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            int minValue = minValue(root.right);
            root.val = minValue;
            root.right = delete(root.right, minValue);
        }
        return root;
    }

    int minValue(TreeNode root) {
        int minv = root.val;
        while(root.left != null) {
            root = root.left;
            minv = root.val;
        }
        return minv;
    }

    boolean search(TreeNode root, int searchVal) {
        if(root == null) {
            System.out.println("NOT FOUND");
            return false;
        }
        if(root.val == searchVal) {
            System.out.println("Found element " + searchVal);
            return true;
        }
        if(searchVal > root.val) {
            return search(root.right, searchVal);
        } else {
            return search(root.left, searchVal);
        }
    }

    void printTreeInorder(TreeNode root) {
        if(root == null) {
            return;
        }
        printTreeInorder(root.left);
        System.out.print(root.val + " ");
        printTreeInorder(root.right);
    }

    int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
