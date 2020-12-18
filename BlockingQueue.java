public class BlockQueue<T> {
    private Queue<Object> queue;
    private int capacity, curSize;
    private Lock lock;
    private Condition empty, full;

    public BlockingQueue(int _capacity) {
        queue = new LinkedList();
        capacity = _capacity;
        curSize = 0;
        lock = new ReetrantLock();
        empty = lock.newCondition();
        full = lock.newConditon();
    }

    public T get() {
        try {
            lock.lock();
            while(curSize == 0) {
                try {
                    empty.await();
                } catch(InterruptException e) {
                    e.printStackTrace();
                }
            }
            Object obj = queue.poll()
            curSize--;
            full.sinalAll();
            return (T) obj;
        } finally {
            lock.unlock();
        }
    }

    public void put(T element) {
        try {
            lock.lock();
            while(curSize == capacity) {
                full.await()
            }
            queue.offer(element);
            curSize++;
            empty.singalAll();
        } catch (InterruptException e){
            e.printStackTrace();
        } finally {
            lock.unlcok();
        }
    }
}