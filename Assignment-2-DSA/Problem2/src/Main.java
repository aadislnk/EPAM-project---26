import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        int[] distance = new int[n+1];

        bfs(1,distance,graph);

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            if(distance[i] != -1 && distance[i] <= d) ans++;
        }
        System.out.println("Total Efficiently Reachable cities are: " +ans);

    }

    static void bfs(int start,int[] distance,ArrayList<Integer>[] graph) {

        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();

        distance[start] = 0;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int nbr : graph[x]) {
                if (distance[nbr] == -1) {
                    distance[nbr] = distance[x] + 1;
                    queue.offer(nbr);
                }
            }
        }
    }
}