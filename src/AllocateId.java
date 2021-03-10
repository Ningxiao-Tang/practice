import java.util.*;

public class AllocateId {
    private Queue<Integer> freelist;
    private Set<Integer> allocated;
    private final int MAX_ID;
    public AllocateId (int maxId) {
        MAX_ID = maxId;
        freelist = new LinkedList<>();
        for (int i = 0; i < maxId; i++){
            freelist.offer(i);
        }
        allocated = new HashSet<>();
    }
    public int allocate () {
        if (freelist.isEmpty())
            return -1;
        int id = freelist.poll();
        allocated.add(id);
        return id;
    }

    public void release(int id) {
        if (id < 0 || id > MAX_ID || !allocated.contains(id))
            return;
        allocated.remove(id);
        freelist.add(id);
    }

    public boolean check(int id) {
        return !allocated.contains(id);
    }

    /*bitmap approach
    space:o(c)
    time: worst case o(n) in searching next available id

     */
    private class Allocator {
        private final int MAX_ID;
        private BitSet bitset;
        private int nextAvail;

        public Allocator(int maxid){
            MAX_ID = maxid;
            bitset = new BitSet(maxid);
            nextAvail = 0;
        }
        public int allocate() {
            if (nextAvail == MAX_ID) return -1;
            int num = nextAvail;
            bitset.set(num);
            nextAvail = bitset.nextClearBit(num);
            return num;
        }
        public void release(int id) {
            if (id < 0 || id >= MAX_ID) return;
            if (bitset.get(id)){
                bitset.clear(id);
                nextAvail = Math.min(nextAvail,id);
            }
        }
        public boolean check(int id){
            if (id < 0 || id >= MAX_ID) return false;
            return !bitset.get(id);
        }


    }
}



