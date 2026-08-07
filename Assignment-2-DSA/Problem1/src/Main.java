import java.util.*;

public class Main {

    static ArrayList<Integer>[] tree;
    static int[] key;
    static boolean[] visited;
    static int ans = 0;
    static long k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        k = sc.nextLong();

        key = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            key[i] = sc.nextInt();
        }

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n - 1; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }
        visited = new boolean[n + 1];

        dfs(1, key[1]);

        System.out.println("Total trusted servers are: " +ans);
    }

    static void dfs(int node, long xor) {
        visited[node] = true;

        if (xor >= k) {
            ans++;
        }
        for (int child : tree[node]) {
            if (!visited[child]) {
                dfs(child, xor ^ key[child]);
            }
        }
    }
}