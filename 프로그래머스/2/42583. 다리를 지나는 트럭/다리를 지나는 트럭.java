import java.util.*;

class Solution {
    
    class Truck {
        int w;
        int t;
        
        public Truck(int w, int t) {
            this.w = w;
            this.t = t;
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> onBridge = new LinkedList<Truck>();
        Queue<Integer> trucks = new LinkedList<Integer>();
        for(int i = 0; i < truck_weights.length; i++) {
            trucks.offer(truck_weights[i]);
        }
        int totalWeight = 0;
        int time = 0;
        
        while(true) {
            time++;
            
            if(!onBridge.isEmpty()) {   // 다리에서 트럭이 내려오는 로직
                Truck truck = onBridge.peek();
                if(time - truck.t >= bridge_length) {
                    onBridge.poll();
                    totalWeight -= truck.w;
                    if(onBridge.isEmpty() && trucks.isEmpty()) return time;
                }
            }
            
            if(!trucks.isEmpty()) {     // 다리에 트럭이 올라가는 로직
                int truckWeight = trucks.peek();
                if(totalWeight + truckWeight <= weight) {
                    onBridge.offer(new Truck(truckWeight, time));
                    totalWeight += truckWeight;
                    trucks.poll();
                }
            }
            
        }
    }
}