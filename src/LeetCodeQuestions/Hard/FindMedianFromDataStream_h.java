package LeetCodeQuestions.Hard;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    /**
     * initialize your data structure here.
     */
    PriorityQueue<Long> small;
    PriorityQueue<Long> large;

    public MedianFinder() {
        small = new PriorityQueue<>(new Comparator<Long>() {
            public int compare(Long o1, Long o2) {
                return Math.toIntExact(o1 - o2);
            }
        });
        large = new PriorityQueue<>(new Comparator<Long>() {
            public int compare(Long o1, Long o2) {
                return Math.toIntExact(o2 - o1);
            }
        });
    }

    public void addNum(int num) {
        large.add((long) num);
        small.add(large.poll());
        if (large.size() < small.size()) large.add(small.poll());
    }

    public double findMedian() {
        return large.size() > small.size()
                ? large.peek()
                : (large.peek() + small.peek()) / 2.0;
    }
}