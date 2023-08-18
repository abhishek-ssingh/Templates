package Templates.DSU;

import java.util.*;

class DisjointSet {
    int[] parent;
    int[] rank;

    public DisjointSet(int n) {
        // initial config rank->0 , parent -> i
        parent = rank = new int[n + 1];
        Arrays.fill(rank, 0);

        for (int i = 0; i <= n; i++)
            parent[i] = i;
    }

    public int findUPar(int u) {
        // base case
        if (u == parent[u])
            return u;
        /*
         * finding parent by going till top, then when returning storing it in below
         * so all below nodes can get parent updated to ultimate parent
         */
        int ulp = findUPar(parent[u]);
        parent[u] = ulp;
        return ulp;
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if (ulp_u == ulp_v)
            return;

        if (rank[ulp_u] < rank[ulp_v])
            /*
             * v
             * u
             */
            parent[ulp_u] = ulp_v;
        else if (rank[ulp_u] > rank[ulp_v])
            /*
             * u
             * v
             */
            parent[ulp_v] = ulp_u;
        else {
            /*
             * u
             * v
             */
            parent[ulp_v] = ulp_u;
            rank[ulp_u]++;
        }
    }
}

class Main {
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 & 7 are connected
        if (ds.findUPar(3) == ds.findUPar(7))
            System.out.println("Connected");
        else
            System.out.println("Not connected");

        ds.unionByRank(3, 7);
        if (ds.findUPar(3) == ds.findUPar(7))
            System.out.println("Connected");
        else
            System.out.println("Not connected");

    }
}
