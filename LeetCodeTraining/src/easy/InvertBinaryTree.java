package easy;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class InvertBinaryTree {
    /**
     * 递归解法
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        TreeNode mid;
        mid = root.left;
        root.left = root.right;
        root.right = mid;
        if (root.left == null && root.right == null) {
            return root;
        } else {
            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }
    /**
     * 测试以及测试用例
     */
    @Test
    public void test() {
        TreeNode root = new TreeNode(4);
        TreeNode left1 = new TreeNode(2);
        TreeNode left11 = new TreeNode(1);
        TreeNode left12 = new TreeNode(3);
        TreeNode right1 = new TreeNode(7);
        TreeNode right11 = new TreeNode(6);
        TreeNode right12 = new TreeNode(9);
        root.left = left1;
        left1.left = left11;
        left1.right = left12;
        root.right = right1;
        right1.left = right11;
        right1.right = right12;
        printByLayer(root);
        invertTree(root);
        System.out.println();
        printByLayer(root);
    }
    /**
     * 打印二叉树
     * @param root
     */
    public void printByLayer(TreeNode root){
        Queue<TreeNode> que=new LinkedList<TreeNode>();
        que.add(root);
        int curNum=1;
        int nextNum=0;
        while(!que.isEmpty()){
            TreeNode curNode=que.poll();
            System.out.print(curNode.val+"  ");
            curNum--;
            if(curNode.left!=null){
                que.add(curNode.left);
                nextNum++;
            }
            if(curNode.right!=null){
                que.add(curNode.right);
                nextNum++;
            }
            if(curNum==0){
                curNum=nextNum;
                System.out.println();
            }
        }
    }
    /**
     * 循环解法
     *  层序遍历的循环解法
     * @param root
     * @return
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }
}
