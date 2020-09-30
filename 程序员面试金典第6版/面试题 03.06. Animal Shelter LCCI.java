class AnimalShelf {
    Queue<Integer> dog, cat;

    public AnimalShelf() {
        dog = new LinkedList();
        cat = new LinkedList();
    }
    
    public void enqueue(int[] animal) {
        if(animal[1] == 0) {
            cat.offer(animal[0]);
        } else {
            dog.offer(animal[0]);
        }
    }
    
    public int[] dequeueAny() {
        int[] res = {-1, -1};
        if(dog.isEmpty() && cat.isEmpty()) {
            return res;
        }
        if(dog.isEmpty()) {
            res = dequeueCat();
            return res;
        }
        if(cat.isEmpty()) {
            res = dequeueDog();
            return res;
        }
        if(cat.peek() < dog.peek()) {
            res = dequeueCat();
            return res;
        }
        if(dog.peek() < cat.peek()) {
            res = dequeueDog();
            return res;
        }
        return res;
    }
    
    public int[] dequeueDog() {
        int[] res = {-1, -1};
        if(dog.isEmpty()) {
            return res;
        }
        res[0] = dog.poll();
        res[1] = 1;
        return res;
    }
    
    public int[] dequeueCat() {
        int[] res = {-1, -1};
        if(cat.isEmpty()) {
            return res;
        }
        res[0] = cat.poll();
        res[1] = 0;
        return res;
    }
}

/**
 * Your AnimalShelf object will be instantiated and called as such:
 * AnimalShelf obj = new AnimalShelf();
 * obj.enqueue(animal);
 * int[] param_2 = obj.dequeueAny();
 * int[] param_3 = obj.dequeueDog();
 * int[] param_4 = obj.dequeueCat();
 */