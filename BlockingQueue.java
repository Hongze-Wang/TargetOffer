public class BlockingQueue {
    private final Queue<String> queue = new LinkedList();
    private Lock lock = new ReetrantLock();
    private Condition condition = lock.newCondition();
    public String get() {
        try {
            lock.lock();
            while(queue.peek() == null) {
                try {
                    condition.await();
                } catch(InterruptException e) {
                    e.printStackTrace();
                }
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }
    public void put(String s) {
        try {
            lock.lock();
            queue.offer(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}