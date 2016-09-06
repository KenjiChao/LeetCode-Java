// recursive
public class Solution {
    List<String> route = new LinkedList<>();
    HashMap<String, PriorityQueue<String>> map = new HashMap<>();

    public List<String> findItinerary(String[][] tickets) {
        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).add(ticket[1]);
        }

        visit("JFK");

        return route;
    }

    private void visit(String airport) {
        while (map.containsKey(airport) && !map.get(airport).isEmpty()) {
            visit(map.get(airport).poll());
        }
        route.add(0, airport);
    }
}

// iterative
public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> route = new LinkedList<>();
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] ticket : tickets) {
            map.putIfAbsent(ticket[0], new PriorityQueue<>());
            map.get(ticket[0]).add(ticket[1]);
        }

        Stack<String> stack = new Stack<>();
        stack.add("JFK");
        while (!stack.empty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
                stack.push(map.get(stack.peek()).poll());
            }
            route.add(0, stack.pop());
        }

        return route;
    }
}
