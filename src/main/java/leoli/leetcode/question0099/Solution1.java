package leoli.leetcode.question0099;

import leoli.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。
 *
 * 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？
 *
 * 示例 1：
 * 输入：root = [1,3,null,null,2]
 * 输出：[3,1,null,null,2]
 * 解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
 *
 * 示例 2：
 * 输入：root = [3,1,4,null,null,2]
 * 输出：[2,1,4,null,null,3]
 * 解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。
 *
 * 提示：
 *
 * 树上节点的数目在范围 [2, 1000] 内
 * -231 <= Node.val <= 231 - 1
 *
 * @See https://leetcode-cn.com/problems/recover-binary-search-tree
 *
 * 方式１：将节点按中序遍历平铺开，理论上应该list[i] > list[i-1]，找出异常节点互换即可
 *
 * @author leoli
 * @date 2021/4/14
 */
public class Solution1 {

    TreeNode x = null;
    TreeNode y = null;

    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList();
        dfs(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).val < list.get(i - 1).val) {
                if (x == null) {
                    x = list.get(i - 1);
                }
                y = list.get(i);
            }
        }

        if (x != null && y != null) {
            int v = x.val;
            x.val = y.val;
            y.val = v;
        }

    }

    private void dfs(TreeNode node, List list) {
        if (node == null) {
            return;
        }
        dfs(node.left, list);
        list.add(node);
        dfs(node.right, list);
    }

}
