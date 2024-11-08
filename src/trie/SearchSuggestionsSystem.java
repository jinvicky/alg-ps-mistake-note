package trie;

import java.util.*;

/**
 * LeetCode 1268. Search Suggestions System
 * 트라이는 생각보다 훨씬 간단하게 구현되었음
 *
 * [핵심]
 * - 국룰이고 그런 거에 메이지 말자. 항상 오픈 마인드.
 * - 원소별로 트라이 26길이의 배열을 가지면 된다. (children, next라는 이름으로 존재)
 *
 * [배경]
 * - 정수, 실수 같은 정적 변수들을 다루는 것과 달리 문자열은 최악의 경우 문자열의 길이에 비례하는 시간이 걸려서
 * 또한 정수처럼 문자열은 1번에 비교되는 자료형이 아니다.
 *
 * 그래서 문자열을 비교하기 위한 효율적인 자료구조로 Trie를 사용한다.
 */
public class SearchSuggestionsSystem {
    public static void main(String[] args) {
        SearchSuggestionsSystem searchSuggestionsSystem = new SearchSuggestionsSystem();
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        String searchWord = "mouse";
        searchSuggestionsSystem.suggestedProducts(products, searchWord);
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);

        Trie<String> root = new Trie<>();
        for (String prod : products) {
            Trie<String> n = root;
            for (char ch : prod.toCharArray()) {
                int i = ch - 'a';
                if (n.next[i] == null) { // null이면 신규 트라이를 추가한다.
                    n.next[i] = new Trie<>();
                }
                n = n.next[i];
                if (n.words.size() < 3) { // words의 길이가 3 이하면 제품명을 더한다. (max=3이었으므로)

                    // 커스텀 트라이:: 문제를 위해 추가된 words[]
                    n.words.add(prod);
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        Trie<String> n = root;

        for(int i = 0; i < searchWord.length(); i++) {
            n = n.next[searchWord.charAt(i) - 'a'];
            if(n==null) {
                for(int j = i; j < searchWord.length(); i++) {
                    res.add(Collections.emptyList());
                }
                break;
            }
            res.add(new ArrayList<>(n.words));
        }
        return res;
    }

    class Trie<T> {
        Trie<T>[] next;
        List<T> words;

        @SuppressWarnings("unchecked")
        Trie() {
            words = new ArrayList<>();
            next = new Trie[26];
        }
    }
}

