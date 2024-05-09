package org.example.OD;

public class FindCityUnionFind {
    static class UF {
        int N;
        int [] unionFind;
        int [] unionSize;
        public UF (int n) {
            N = n;
            unionFind = new int[n];
            unionSize = new int[n];
            for (int i = 0; i < n; i++) {
                unionFind[i] = i;
                unionSize[i] = 1;
            }
        }
        public int find(int i) {
            if (unionFind[i] == i) {
                return i;
            }
            else {
                unionFind[i] = find(unionFind[i]); //路径压缩
            }
            return unionFind[i];
        }
        public void merge(int i, int j) {
            int i_root = find(i);
            int j_root = find(j);
            if (i_root != j_root) {
                //按秩合并
                if (unionSize[i_root] < unionSize[j_root]){
                    unionFind[i_root] = j_root;
                    unionSize[j_root] += unionSize[i_root];
                }else {
                    unionFind[j_root] = i_root;
                    unionSize[i_root] += unionSize[j_root];
                }
            }
        }
        int getMax(){
            int max = 0;
            for (int i = 0; i < unionSize.length; i++){
                max = Math.max(max, unionSize[i]);
            }
            return max;
        }
    }


    public static void main(String[] args) {
        String s = "1 2\n" +
                "2 3\n" +
                "2 5\n" +
                "3 4\n" +
                "3 6";
        String[] split = s.split("\n");
        int[][] edges = new int[split.length][2];
        int max = 0;
        for (int i = 0; i < split.length; i++) {
            String[] split1 = split[i].split(" ");
            edges[i][0] = Integer.parseInt(split1[0]);
            edges[i][1] = Integer.parseInt(split1[1]);
            max = Math.max(max, edges[i][0]);
            max = Math.max(max, edges[i][1]);
        }
        int[] maxArr = new int[max + 1];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < max+1; i++){
            UF uf = new UF(max + 1);

            for (int j = 0; j < edges.length; j++) {
                if (edges[j][0] != i && edges[j][1] != i) {
                    uf.merge(edges[j][0], edges[j][1]);
                }
            }
            res = Math.min(res,uf.getMax());
            maxArr[i] = uf.getMax();
        }
        String result = "";
        for (int i = 0; i < maxArr.length; i++){
            if (maxArr[i] == res){
                result += i+" ";
            }
        }
        System.out.println(result);
    }
}
