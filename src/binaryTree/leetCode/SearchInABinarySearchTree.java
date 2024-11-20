package binaryTree.leetCode;

/**
 * LeetCode 700. Search in a Binary Search Tree
 *
 * [어려웠던점]
 * 재귀가 너무너무너무 어렵다... 이해가 안 된다....
 *
 * 이진 탐색 트리의 특성상 목표의 val이 현개 root.val보다 크면 root.right, 작으면 root.left로 이동한다.
 * LeafSimilarTrees 문제나 dfs easy 문제와 비슷하지만, 재귀를 양쪽으로 하지 않고 방향을 정해서 한 다는 점이 다르다.
 */
public class SearchInABinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) {
            return root;
        }
        TreeNode next = root.val > val ? root.left : root.right;
        return searchBST(next, val);

    }

    public static void main(String[] args) {
        SearchInABinarySearchTree searchInABinarySearchTree = new SearchInABinarySearchTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(searchInABinarySearchTree.searchBST(root, 2));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
