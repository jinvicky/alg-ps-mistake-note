package binaryTree.leetCode;

import java.util.*;

/**
 * LeetCode 872. Leaf-Similar Trees
 * <p>
 * [회고]
 * 스택으로 푸는 거 아니다;; 조건이 쉬운데 왜 틀렸지?
 * 리프 노드의 조건 : node.left, node.right이 모두 null이다. (쉬운데 몰랐다)
 * <p>
 * [비슷했던 점]
 * - list.size() 비교 부분은 옳았다.
 * -
 * <p>
 * [포인트]
 * - 재귀 호출 방식으로 푼다.
 * - 두 루트의 리프 노드들을 담은 리스트를 준비한다.
 * - 리프 리스트를 만들 때 개수를 잘 맞춰주어야 해. 그래야 for문에서 range 고민을 안 한다.
 */
public class LeafSimilarTrees {

    public void searchAndAddToLeafList(TreeNode node, List<Integer> leafList) {
        if (node == null) {
            return;
        }
        // 노드의 좌우가 널이면 리프이다.
        boolean isLeaf = node.left == null && node.right == null;
        if (isLeaf) {
            leafList.add(node.val);
            // VIP:: 다음이 어차피 null이기 때문에 여기서 리턴하는 것이 효율적.
            return;
        }
        searchAndAddToLeafList(node.left, leafList);
        searchAndAddToLeafList(node.right, leafList);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> rt1List = new ArrayList<>();
        List<Integer> rt2List = new ArrayList<>();

        searchAndAddToLeafList(root1, rt1List);
        searchAndAddToLeafList(root2, rt2List);

        if (rt1List.size() != rt2List.size()) {
            return false;
        }

        for (int i = 0; i < rt1List.size(); i++) {
            // integer, 즉 number 객체는 !=가 아닌 equals()로 비교해야 한다.
            if (!rt1List.get(i).equals(rt2List.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeafSimilarTrees leafSimilarTrees = new LeafSimilarTrees();
        TreeNode root1 = leafSimilarTrees.new TreeNode(3);
        root1.left = leafSimilarTrees.new TreeNode(5);
        root1.right = leafSimilarTrees.new TreeNode(1);
        root1.left.left = leafSimilarTrees.new TreeNode(6);
        root1.left.right = leafSimilarTrees.new TreeNode(2);
        root1.right.left = leafSimilarTrees.new TreeNode(9);
        root1.right.right = leafSimilarTrees.new TreeNode(8);
        root1.left.right.left = leafSimilarTrees.new TreeNode(7);
        root1.left.right.right = leafSimilarTrees.new TreeNode(4);

        TreeNode root2 = leafSimilarTrees.new TreeNode(3);
        root2.left = leafSimilarTrees.new TreeNode(5);
        root2.right = leafSimilarTrees.new TreeNode(1);
        root2.left.left = leafSimilarTrees.new TreeNode(6);
        root2.left.right = leafSimilarTrees.new TreeNode(7);
        root2.right.left = leafSimilarTrees.new TreeNode(4);
        root2.right.right = leafSimilarTrees.new TreeNode(2);
        root2.right.right.left = leafSimilarTrees.new TreeNode(9);
        root2.right.right.right = leafSimilarTrees.new TreeNode(8);

        System.out.println(leafSimilarTrees.leafSimilar(root1, root2));
//
//        LeafSimilarTrees leafSimilarTrees = new LeafSimilarTrees();
//
//        TreeNode root1 = leafSimilarTrees.new TreeNode(1);
//        root1.left = leafSimilarTrees.new TreeNode(2);
//        root1.right = leafSimilarTrees.new TreeNode(3);
//
//        TreeNode root2 = leafSimilarTrees.new TreeNode(1);
//        root2.left = leafSimilarTrees.new TreeNode(3);
//        root2.right = leafSimilarTrees.new TreeNode(2);
//
//        System.out.println(leafSimilarTrees.leafSimilar(root1, root2));
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
