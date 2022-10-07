class MovingAverage {
    
    int size, windowSum = 0, count = 0;
    Deque<Integer> queue;
    
    public MovingAverage(int size) {
        this.size = size;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        count++;
        queue.addLast(val);
        int tail = queue.size() > size ? queue.pollFirst() : 0;
        windowSum = windowSum - tail + val;
        return windowSum * 1.0 / Math.min(count,size);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */