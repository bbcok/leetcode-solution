package org.example.OD;

import java.util.*;

public class RobotMaze {
    static int xLength;
    static int yLength;
    static class CheckModel {
        int x;
        int y;

        public CheckModel(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object o) {
            if (o == this)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            CheckModel check = (CheckModel) o;
            return x == check.x && y == check.y;
        }

    }
    List<Set<CheckModel>> setList=new ArrayList<>();
    private static void findItOut(int x, int y, Set<CheckModel> wallSet, Set<CheckModel> checkSet,
                                  Set<CheckModel> finishSet) {

        if (yLength - 1 == y && xLength - 1 == x) {
            finishSet.add(new CheckModel(x, y));
        }

        if (yLength <= y || x >= xLength) {
            return;
        }

        checkSet.add(new CheckModel(x, y));
        // 北方向
        if (!wallSet.contains(new CheckModel(x, y + 1))) {
            findItOut(x, y + 1, wallSet, checkSet, finishSet);
        } else {
            finishSet.add(new CheckModel(x, y));
        }
        // 东方向
        if (!wallSet.contains(new CheckModel(x + 1, y))) {
            findItOut(x + 1, y, wallSet, checkSet, finishSet);
        } else {
            finishSet.add(new CheckModel(x, y));
        }
    }

    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            xLength = s.nextInt();
            yLength = s.nextInt();
            int size = s.nextInt();
            int[][] values = new int[size][2];
            for (int i = 0; i < size; ++i) {
                values[i][0] = s.nextInt();
                values[i][1] = s.nextInt();
            }
            int trapCount = 0;
            int invalidCount = 0;
            Set<CheckModel> wallHashSet = new HashSet<>();
            for (int[] wall : values) {
                wallHashSet.add(new CheckModel(wall[0], wall[1]));
            }
            Set<CheckModel> checksHashSet = new HashSet<>();
            Set<CheckModel> finishHashSet = new HashSet<>();

            findItOut(0, 0, wallHashSet, checksHashSet, finishHashSet);

            invalidCount = xLength * yLength - checksHashSet.size() - wallHashSet.size();

            for (CheckModel model : finishHashSet) {
                Set<CheckModel> checksT = new HashSet<>();
                Set<CheckModel> finishT = new HashSet<>();
                findItOut(model.x, model.y, wallHashSet, checksT, finishT);
                if (!finishT.contains(new CheckModel(xLength - 1, yLength - 1))) {
                    trapCount++;
                }
            }

            System.out.print(trapCount + " " + invalidCount);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("input error");
        }
    }
}
