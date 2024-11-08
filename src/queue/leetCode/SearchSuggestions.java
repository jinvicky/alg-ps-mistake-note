package queue.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * LeetCode 1268. Search Suggestions System
 *
 * [문제]
 * 원래 Trie로 푸는 문제인데 누가 우선순위 큐로 더 직관적인 해답을 냈다.
 */
public class SearchSuggestions {

    public static void main(String[] args) {
        SearchSuggestions searchSuggestions = new SearchSuggestions();
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        System.out.println(searchSuggestions.suggestedProducts(products, searchWord));
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        PriorityQueue<String> pq = new PriorityQueue<>(3, (s1, s2) -> s1.compareTo(s2));
        List<List<String>> list = new ArrayList<>();

        for(int i = 1; i <= searchWord.length(); i++) {
            String temp = searchWord.substring(0, i);
            for(String s : products) {
                if(s.startsWith(temp)) {
                    pq.offer(s);
                }
            }

            List<String> tempList = new ArrayList<>();
            for(int j = 0; j < 3; j++) {
                if(pq.peek() != null) {
                    tempList.add(pq.poll());
                }
            }
            pq.clear();
            list.add(tempList);
        }
        return list;
    }
}
