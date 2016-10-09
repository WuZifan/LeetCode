package easy;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class MaximumDepthOfBinaryTree {
	/**
	 * 用迭代来做的，感觉运行时间略长 思路： 0、最开始判断整个节点是否为空 1、判断是否为叶节点(左右节点是不是都是空)
	 * 2、若是叶节点，返回1，表示深度是1； 3、如果不是叶节点，分别判断该节点的左右子节点是否为空
	 * 4、如果不为空，就将该节点的左(右)子节点再次带入方法，得到返回值； 5、比较左右节点的返回值大小，将大的返回值再加1后返回。
	 * 
	 * @param root
	 * @return
	 */
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		} else {
			int left_depth = 0;
			int right_depth = 0;
			if (root.left != null) {
				left_depth = maxDepth(root.left);
			}
			if (root.right != null) {
				right_depth = maxDepth(root.right);
			}
			return (left_depth > right_depth ? left_depth + 1 : right_depth + 1);
		}
	}

	/**
	 * 循环需要用到层序遍历，层序遍历和 前中后三种遍历方式不太一样 测试了一下还是递归比较快= - 
	 * 思路: 
	 * 层序遍历思路：
	 * 1、运用到队列；先将根节点塞入队列； 
	 * 2、如果队列不为空，就进入循环； 
	 * 3、在循环中，拿出首元素，将其左子节点(不为空时)放入队列
	 * 4、将其右子节点(不为空时)放入队列 
	 * 5、循环到3； 
	 * 
	 * 计算层数遍历思路： 
	 * 1、root为空返回0；
	 * 2、不为空时，设置三个参数，分别为level，cur_num，next_num; 
	 * 3、level为层数，初始化为1；
	 * 4、cur_num为当前层在队列中剩余的个数，初始化为1（因为root是当前层，还在队列中）
	 * 5、next_num为下一层在队列中剩余的个数，初始化为0(此时根节点的左右儿子都没放入) 
	 * 6、进入循环后，每一次poll都让cur_num减一；
	 * 7、每一次push都让next_num加一； 
	 * 8、当cur_num为0时，表示这一层所有的元素都遍历过了，下一个出来的就是下一层
	 * 9、此时level加一，将next_num的值赋给cur_num，并将cur_num置0； 
	 * 10、最后返回level即可。
	 */
	public int maxDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		int level = 0;
		int current_num = 1;
		int next_num = 0;
		while (!que.isEmpty()) {
			TreeNode node = que.poll();
			current_num--;
			if (node.left != null) {
				que.add(node.left);
				next_num++;
			}
			if (node.right != null) {
				que.add(node.right);
				next_num++;
			}
			if (current_num == 0) {
				current_num = next_num;
				next_num = 0;
				level++;
			}
		}
		return level;
	}

	@Test
	public void test() {
		TreeNode root = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		TreeNode left2 = new TreeNode(3);
		TreeNode right1 = new TreeNode(4);
		root.right = right1;
		root.left = left1;
		left1.left = left2;
		System.out.println(maxDepth2(root));
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
