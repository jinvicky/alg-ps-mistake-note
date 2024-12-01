package dfs.graph.leetCode;

import java.util.*;


/**
 * set으로 구현한 dfs
 */
public class KeysAndRooms2 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0); // room 0은 항상 방문 가능
        dfs(rooms, visited, 0); // room 0에서 DFS 시작
        return visited.size() == rooms.size(); // 모든 방을 방문했는지 확인
    }

    private void dfs(List<List<Integer>> rooms, Set<Integer> visited, int roomIndex) {
        for (int key : rooms.get(roomIndex)) {
            if (!visited.contains(key)) { // 아직 방문하지 않은 방이라면
                visited.add(key); // 방을 방문했다고 표시
                dfs(rooms, visited, key); // 해당 방으로 DFS 진행
            }
        }
    }

    public static void main(String[] args) {
        KeysAndRooms2 keysAndRooms = new KeysAndRooms2();
//        System.out.println(keysAndRooms.canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of())));
        System.out.println(keysAndRooms.canVisitAllRooms(List.of(List.of(1, 3), List.of(3, 0, 1), List.of(2), List.of(0))));
    }
}
