import java.util.*;

public class MazeSolver {

    public static List<String> dfs(Map<String, List<String>> graph, String start, String end) {
        Stack<List<String>> stack = new Stack<>();
        Set<String> visited = new HashSet<>();

        stack.push(Arrays.asList(start));

        while (!stack.isEmpty()) {
            List<String> path = stack.pop();
            String node = path.get(path.size() - 1);

            if (node.equals(end)) {
                return path;
            }

            if (!visited.contains(node)) {
                visited.add(node);

                for (String neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        List<String> newPath = new ArrayList<>(path);
                        newPath.add(neighbor);
                        stack.push(newPath);
                    }
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("1", Arrays.asList("2"));
        graph.put("2", Arrays.asList("1", "3", "4"));
        graph.put("3", Arrays.asList("2", "7"));
        graph.put("4", Arrays.asList("2","5","6"));
        graph.put("5", Arrays.asList("4", "9"));
        graph.put("6", Arrays.asList("4", "7"));
        graph.put("7", Arrays.asList("3", "6","8"));
        graph.put("8", Arrays.asList("7", "9"));
        graph.put("9", Arrays.asList("5", "8","10"));
        graph.put("10", Arrays.asList( "9"));



        String start = "1";
        String end = "10";

        List<String> path = dfs(graph, start, end);
        System.out.println("DFS Path: " + path);
    }
}
