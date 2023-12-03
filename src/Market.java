import java.util.ArrayList;
import java.util.List;

public class Market implements QueueBehaviour, MarketBehaviour {
    private List<Actor> queue = new ArrayList<>();
    @Override
    public void takeToQueue(Actor actor) {
        queue.add(actor);
        System.out.println(actor.getName() + " встал в очередь");
    }

    @Override
    public void makeOrders() {
        for (Actor actor: queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + " сделал заказ");
            }
        }
    }

    @Override
    public void takeOrders() {
        for (Actor actor: queue) {
            if (actor.isMakeOrder() && !actor.isTakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " взял заказ");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<Actor> releasedActors = new ArrayList<>();
        for (Actor actor: queue) {
           if (actor.isTakeOrder()) {
               releasedActors.add(actor);
               System.out.println(actor.getName() + " вышел из очереди");
           }
        }
        releaseFromMarket(releasedActors);
    }

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " пришел в магазин");
        takeToQueue(actor);
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) {
        for (Actor actor: actors) {
            queue.remove(actor);
            System.out.println(actor.getName() + " вышел из магазина");
        }
    }

    @Override
    public void update() {
        makeOrders();
        takeOrders();
        releaseFromQueue();
    }
}
