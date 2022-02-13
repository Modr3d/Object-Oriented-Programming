public class Problem_4_1_1 {
    public static void main(String[] args) {
        Stock stock = new Stock("ORCL", "Oracle Corporation");
        stock.currentPrice = 34.35;
        stock.previousClosingPrice = 34.5;

        System.out.printf("Symbol: %s\n", stock.symbol);
        System.out.printf("Name: %s\n", stock.name);
        System.out.println("Previous Closing Price: " + stock.previousClosingPrice);
        System.out.println("Current Price: " + stock.currentPrice);
        System.out.print("Price Change: " + stock.getChangePercent() + "%");
    }
}