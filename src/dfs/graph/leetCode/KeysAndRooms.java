package dfs.graph.leetCode;

import java.util.List;

/**
 * 방문여부 배열로 구현한 dfs (그래프)
 * boolean을 어떻게 dfs로 구현할 지 디게 고민을 했는데 그냥 메서드 바깥에 count 선언하고 return 문에서 비교하네;;
 */
public class KeysAndRooms {

   boolean[] visited;
   int count = 0;
   List<List<Integer>> list;
   int n;

   public boolean canVisitAllRooms(List<List<Integer>> rooms) {
       n = rooms.size();
       visited = new boolean[n];
       list = rooms;
       dfs(0);
       return count == n;
   }

    /**
     * 리턴하는 조건
     *
     * 1. 방문여부가 true일 때
     * 2. count가 n와 동일할 때 (모든 방문을 성공적으로 열었다)
     */
   void dfs(int v) {
       if(visited[v] == true) {
           return;
       }

       visited[v] = true;
       count++;

       if(count == n) {
           return;
       }

       for(int node : list.get(v)) {
           dfs(node);
       }
   }

    public static void main(String[] args) {
        KeysAndRooms keysAndRooms = new KeysAndRooms();
//        System.out.println(keysAndRooms.canVisitAllRooms(List.of(List.of(1), List.of(2), List.of(3), List.of())));
        System.out.println(keysAndRooms.canVisitAllRooms(List.of(List.of(1,3), List.of(3,0,1), List.of(2), List.of(0))));
    }
}
