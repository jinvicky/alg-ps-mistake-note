package dp.leetCode;

/**
 * LeetCode 714. Best Time to Buy and Sell Stock with Transaction Fee
 *
 * [소요시간]
 * 10시간 매달려서 포기.
 *
 * [회고]
 * 액셀시트랑 그림 수십장 그리고 별 짓을 다함. buy를 갱신하는 범위를 못 계산해서 틀림.
 * 2차원 문제라고 하지만 변수명 2개로 푸는 문제다.
 * sell을 계산할 때, buy랑 price를 더해야 한다.
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit (int[] prices, int fee) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;

        for(int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price - fee); // 여기도 틀렸네, buy랑 price를 더해야 한다.
        }
        return sell;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee bestTimeToBuyAndSellStockWithTransactionFee = new BestTimeToBuyAndSellStockWithTransactionFee();
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;

        prices = new int[]{1,3,7,5,10,3};
        fee = 3;
        System.out.println(bestTimeToBuyAndSellStockWithTransactionFee.maxProfit(prices, fee));
    }
}
