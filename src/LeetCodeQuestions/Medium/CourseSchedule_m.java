package LeetCodeQuestions.Medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_m {
    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // int[] incomingEdges = new int[numCourses];
            // List<Integer>[] goCourses = new List[numCourses];
            // for (int i = 0; i < goCourses.length; i++) {
            //     goCourses[i] = new LinkedList<Integer>();
            // }
            // for (int[] pair : prerequisites) {
            //     incomingEdges[pair[0]]++;
            //     goCourses[pair[1]].add(pair[0]);
            // }
            // Queue<Integer> queue = new LinkedList<Integer>();
            // for (int i = 0; i < incomingEdges.length; i++) {
            //     if (incomingEdges[i] == 0) {
            //         queue.add(i);
            //     }
            // }
            // int edgeCnt = prerequisites.length;
            // while (!queue.isEmpty()) {
            //     int cur = queue.poll();
            //     for (int goCrs : goCourses[cur]) {
            //         edgeCnt--;
            //         if (--incomingEdges[goCrs] == 0)
            //             queue.add(goCrs);
            //     }
            // }
            // return edgeCnt == 0;
            int[] incomingEdges = new int[numCourses];
            List<Integer>[] nodes = new List[numCourses];
            for (int i = 0; i < nodes.length; i++)
                nodes[i] = new LinkedList<Integer>();

            for (int[] edge : prerequisites) {
                incomingEdges[edge[0]]++;
                nodes[edge[1]].add(edge[0]);
            }

            Queue<Integer> startNodes = new LinkedList<Integer>();
            for (int i = 0; i < incomingEdges.length; i++)
                if (incomingEdges[i] == 0)
                    startNodes.add(i);

            int numEdges = prerequisites.length;
            int numRemainingEdges = numEdges;
            while (!startNodes.isEmpty()) {
                int node = startNodes.poll();
                for (int adjNode : nodes[node]) {
                    numRemainingEdges--;
                    incomingEdges[adjNode]--;
                    if (incomingEdges[adjNode] == 0)
                        startNodes.add(adjNode);
                }
            }

            return numRemainingEdges == 0;
        }
    }
}
