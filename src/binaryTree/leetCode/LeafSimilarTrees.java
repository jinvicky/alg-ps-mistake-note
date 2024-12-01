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
        TreeNode root1 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(9), new TreeNode(8)));
        TreeNode root2 = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(7)), new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(9), new TreeNode(8))));
        System.out.println(leafSimilarTrees.leafSimilar(root1, root2));
    }

}
