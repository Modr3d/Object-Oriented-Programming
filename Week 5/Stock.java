public class Stock {

    String symbol, name;
    double previousClosingPrice, currentPrice;

    Stock(String stockSymbol, String stockName) {
        symbol = stockSymbol;
        name = stockName;
    }

    public double getChangePercent() {
        return (currentPrice * 100 / previousClosingPrice) - 100;
    }
}