package easy;

import org.junit.Test;

public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        /*
         * 和之前求加法的一样，左右分开迭代，
         * 最后把结果加在一起返回即可
         */
        int sumLeft = 0;
        int sumRight = 0;
        /*
         * 非空判断
         */
        if (root == null) {
            return 0;
        }
        /*
         * 左迭代
         */
        if (root.left != null) {
            /*
             * 判断这个左节点是不是叶子
             */
            if (root.left.left == null && root.left.right == null) {
                sumLeft += root.left.val;
            }
            /*
             * 注意这里，和迭代结果的相加要在叶子节点之外进行，
             * 不然回退到根节点的时候，会因为不是叶子节点而加不到，使得答案变成0
             */
            sumLeft += sumOfLeftLeaves(root.left);
        }
        /*
         * 右迭代
         */
        if (root.right != null) {
            sumRight += sumOfLeftLeaves(root.right);
        }
        return sumLeft + sumRight;
    }
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode rtLeft = new TreeNode(2);
        TreeNode rtRight = new TreeNode(3);
        TreeNode rrLeft = new TreeNode(4);
        TreeNode rrRight = new TreeNode(5);
        root.left = rtLeft;
        root.right = rtRight;
        rtLeft.left = rrLeft;
        rtLeft.right = rrRight;
        System.out.println(sumOfLeftLeaves(root));
    }
}