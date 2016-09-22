import java.io.*;
import java.util.*;

class Node{
    int value;
    Node left;
    Node right;
    Node(){
        left = null;
        right = null;
        value = -1;
    }
}

class Checker{

    boolean isHeap(Node root){
        return isComplete(root)&&isSmaller(root);
    }

    boolean isSmaller(Node root){
        if(root == null) return true;
        if(root.left!=null && root.value>root.left.value) return false;
        if(root.right!=null && root.value>root.right.value) return false;
        return isSmaller(root.left)&&isSmaller(root.right);
    }

    boolean isComplete(Node root){
        return countNode(root) == getMaxIndex(root,0)+1;
    }

    int countNode(Node root){
        return root==null? 0: 1+countNode(root.left)+countNode(root.right);
    }

    int getMaxIndex(Node root, int index){
        if(root==null) return -1;
        return Math.max( index, Math.max( getMaxIndex(root.left, 2*index+1), getMaxIndex(root.right, 2*index+2) ));
    }
}

public class Test {
    public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new File("src/com/nathan/bittiger/verifyHeap/input"));

        int n = in.nextInt();

        Checker checker = new Checker();
        while(n!=-1){

            //build tree
            Node[] tree = new Node[n];
            for(int i=0; i<n;++i) tree[i] = new Node();

            for(int i=0; i<n; ++i){
                tree[i].value = in.nextInt();
                int leftId = in.nextInt();
                if(leftId!=-1) tree[i].left = tree[leftId];
                int rightId = in.nextInt();
                if(rightId!=-1) tree[i].right = tree[rightId];
            }
            System.out.println(checker.isHeap(tree[0]));
            n = in.nextInt();
        }
        in.close();
    }
}