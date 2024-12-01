package binaryTree.leetCode;

/**
 * LeetCode 450. Delete Node in a BST
 */
public class DeleteNodeInABst {
    // 모든 노드를 탐색해서 출력한다.
    public void searchNodeAll(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        if (root.val == val) {
            System.out.println("val = " + val);
        }

        searchNodeAll(root.left, val);
        searchNodeAll(root.right, val);
    }

    // 내가 찾고자 하는 노드와, 그 노드의 조상 노드를 구한다.
    public void replaceNode(TreeNode current, TreeNode prev, int val) {
        if (current == null) {
            return;
        }
        if (current.val == val) {
            System.out.println("current.val = " + current.val);
            System.out.println("prev.val = " + prev.val);

            // 2를 4의 왼쪽으로 옮긴다.
            current.right.left = current.left;

            // 5의 왼쪽에 4를 넣는다.
            prev.left = current.right;
        }
        prev = current;
        replaceNode(current.left, prev, val);
        replaceNode(current.right, prev, val);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        replaceNode(root, null, key);

        return root;
    }

    public static void main(String[] args) {
        DeleteNodeInABst deleteNodeInABst = new DeleteNodeInABst();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        deleteNodeInABst.deleteNode(root, 3);
    }

}
