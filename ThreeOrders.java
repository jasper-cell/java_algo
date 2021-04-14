package niuke;

import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}

public class ThreeOrders {
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        // write code here
        ArrayList<Integer> list1 =  new ArrayList<>();
        ArrayList<Integer> list2 =  new ArrayList<>();
        ArrayList<Integer> list3 =  new ArrayList<>();

        preOrder(root,list1);
        inOrder(root, list2);
        backOrder(root, list3);

        int[][] res = new int[3][list3.size()];
        for(int i =0; i < list3.size(); i++){
            res[0][i] = list1.get(i);
            res[1][i] = list2.get(i);
            res[2][i] = list3.get(i);
        }
        return res;
    }


    public void preOrder(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }

        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    public void inOrder(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }

        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public void backOrder(TreeNode root, ArrayList<Integer> list){
        if(root == null){
            return;
        }

        backOrder(root.left,  list);
        backOrder(root.right,  list);
        list.add(root.val);
    }
}