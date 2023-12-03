public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        market.acceptToMarket(new Human("Иван"));
        //market.update();
        market.acceptToMarket(new Human("Владимир"));
        market.update();
    }
}
