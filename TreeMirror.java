package niuke;

/**
 * 描述：  二叉树的镜像
 */
public class TreeMirror {
    public TreeNode Mirror (TreeNode pRoot) {
        // write code here
        if(pRoot == null){
            return pRoot;
        }

        if(pRoot.left == null && pRoot.right == null){
            return pRoot;
        }

        TreeNode temp = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = temp;

        if(pRoot.left != null){
            Mirror(pRoot.left);
        }

        if(pRoot.right != null){
            Mirror(pRoot.right);
        }

        return pRoot;
    }
}
