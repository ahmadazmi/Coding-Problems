import java.util.*;

class Solution {
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Create a hashmap, where each key is tied with a
        // hashmap that has the connecting variable as a key
        // and the tied value is the cost of this connection.
        // E.g. equation = ['a', 'b'], values = [2.0]
        // hashmap = [a:[b:[2]], b:[a:[0.5]]]
        HashMap<String, HashMap<String, Double>> edges = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String varOne = equations.get(i).get(0);
            String varTwo = equations.get(i).get(1);
            if (!edges.containsKey(varOne)) edges.put(varOne, new HashMap<String, Double>());
            if (!edges.containsKey(varTwo)) edges.put(varTwo, new HashMap<String, Double>());
            edges.get(varOne).put(varTwo, values[i]);
            edges.get(varTwo).put(varOne, 1/values[i]);
        }
        
        double[] res = new double[queries.size()];
        for (int i = 0; i < res.length; i++) {
            if (!edges.containsKey(queries.get(i).get(0))
               || !edges.containsKey(queries.get(i).get(1))) res[i] = -1;
            res[i] = dfsCost(edges, queries.get(i).get(0), queries.get(i).get(1), new HashSet<String>());
        }
        
        return res;
    }
    
    private double dfsCost(HashMap<String, HashMap<String, Double>> edges, String from, String to, HashSet<String> visited) {
        visited.add(from);
        if (!edges.containsKey(from)) return -1;
        HashMap<String, Double> node = edges.get(from);
        if (node.containsKey(to)) return node.get(to);
        for (Map.Entry<String, Double> neighbor : node.entrySet()) {
            if (visited.contains(neighbor.getKey())) continue;
            double pathCost = dfsCost(edges, neighbor.getKey(), to, visited);
            if (pathCost > -1) return pathCost*neighbor.getValue();
        }
        return -1;
    }
    
}