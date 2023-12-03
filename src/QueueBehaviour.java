public interface QueueBehaviour {
    void takeToQueue(Actor actor);
    void makeOrders();
    void takeOrders();
    void releaseFromQueue();
}
