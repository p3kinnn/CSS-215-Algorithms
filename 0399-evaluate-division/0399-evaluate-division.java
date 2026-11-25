class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double v = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, v);
            graph.get(b).put(a, 1.0 / v);
        }

        double[] answers = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String c = queries.get(i).get(0);
            String d = queries.get(i).get(1);
            if (!graph.containsKey(c) || !graph.containsKey(d)) {
                answers[i] = -1.0;
            } else {
                answers[i] = dfs(graph, c, d, 1.0, new HashSet<>());
            }
        }
        return answers;
    }

    double dfs(Map<String, Map<String, Double>> graph,
               String curr, String target, double product, Set<String> visited) {
        if (curr.equals(target)) {
            return product;
        }
        visited.add(curr);
        for (String next : graph.get(curr).keySet()) {
            double weight = graph.get(curr).get(next);
            if (!visited.contains(next)) {
                double result = dfs(graph, next, target, product * weight, visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }
        return -1.0;
    }
}