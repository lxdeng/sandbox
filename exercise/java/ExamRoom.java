import java.util.*;

public class ExamRoom {
    int size;
    ArrayList<Integer> seats;
    
    public ExamRoom(int N) {
        seats = new ArrayList<Integer>();
        size = N;
    }
    
    public int seat() {
        if (seats.size() == 0) {
            seats.add(0);
            return 0;
        }
    
        int max = 0;
        int toSeat = -1;
        int left = -1;
        int index = -1;
        
        for (int i = 0; i < seats.size(); i++) {
            int right = seats.get(i);
            
            if (left == -1) {
                if (right > max) {
                    max = right;
                    toSeat = 0;
                    index = 0;
                }
            } else {
                int dist = (right - left)/2;
                if (dist > max) {
                    max = dist;   
                    toSeat = left + dist;
                    index = i;
                }
            }
            left = right;
        }
        
        if (left < size-1 && size - 1 - left > max) {
            toSeat = size - 1;
            index = seats.size();
        }
        
        if (toSeat == -1) throw new IllegalArgumentException("Full");
        
        seats.add(index, toSeat);
        return toSeat;
    }
    
    public void leave(int p) {
        int l = 0;
        int h = seats.size();
        
        while (l < h) {
            int middle = l + (h-l)/2;
            int s = seats.get(middle);
            if (s == p) {
                System.out.println("removed " + p);
                seats.remove(middle);
                return;
            } else {
                if (p > s)
                    l = middle + 1;
                else
                    h = middle;
            }
        }
    }
    
    public static void main(String[] args) {
    	ExamRoom room = new ExamRoom(4);
    	
    	room.seat();
    	room.seat();
    	room.seat();
    	room.seat();
    	
    	room.leave(1);
    	room.leave(3);
    	room.seat();
    }
}
