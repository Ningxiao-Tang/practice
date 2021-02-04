import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import javafx.util.Pair;

public class HitCounter {
    private Queue<Integer> hits;
    /** Initialize your data structure here. */
    public HitCounter() {
        this.hits = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        this.hits.offer(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!this.hits.isEmpty()) {
            int diff = timestamp - this.hits.peek();
            if (diff >= 300) this.hits.remove();
            else break;
        }
        return this.hits.size();
    }
}

class HitCounterScale {
    private int total;
    private Deque<Pair<Integer,Integer>> hits;

    public HitCounterScale() {
        this.total =0;
        this.hits = new LinkedList<>();
    }

    public void hit(int timestamp) {
        if (this.hits.isEmpty() || this.hits.getLast().getKey() != timestamp){
            this.hits.add(new Pair<>(timestamp, 1));
        } else {
            int prevCount = this.hits.getLast().getValue();
            this.hits.removeLast();
            this.hits.add(new Pair<>(timestamp, prevCount+1));
        }
        this.total++;
    }

    public int getHits(int timestamp) {
        while (!this.hits.isEmpty()) {
            int diff = timestamp - this.hits.getFirst().getKey();
            if (diff >= 300) {
                this.total -= this.hits.getFirst().getValue();
                this.hits.removeFirst();
            }
            else break;
        }
        return this.total;
    }


}

