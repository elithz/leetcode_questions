package huawei_testquestions;

import java.util.ArrayList;
import java.util.Scanner;

public class buses_question {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> strs = new ArrayList<>();
        while (sc.hasNextLine()) {
            strs.add(sc.nextLine());
            String[] parameters = strs.get(strs.size() - 1).split(" ");
            if(strs.size() != 1 && parameters.length == 2)
                break;
        }
        sc.close();
        String[] parametersStationRoute = strs.get(0).split(" ");
        int numStation = Integer.parseInt(parametersStationRoute[0]);
        int numRoute = Integer.parseInt(parametersStationRoute[1]);

        int[][] costs = new int[numStation + 1][numStation + 1];
        for(int i = 0; i < costs.length; i ++)
            for(int j = 0; j < costs[0].length; j ++)
                costs[i][j] = Integer.MAX_VALUE;
        for (int i = 1; i < strs.size() - 1; i++) {
            String[] parameters = strs.get(i).split(" ");
            costs[Integer.parseInt(parameters[1])][Integer.parseInt(parameters[2])] = Integer.parseInt(parameters[3]);
        }

        String[] parametersOnOff = strs.get(strs.size() - 1).split(" ");
        int from = Integer.parseInt(parametersOnOff[0]);
        int to = Integer.parseInt(parametersOnOff[1]);

        System.out.println(minimalTicketPrice(costs, numStation, from, to));

    }

    public static int minimalTicketPrice(int[][] costs, int numStation, int from, int to){
        int res = 0;
        for(int k = 1; k <= numStation; k ++){
            for(int i = 1; i <= numStation; i ++){
                for(int j = 1; j <= numStation; j ++){
                    if(costs[i][k] != Integer.MAX_VALUE && costs[k][j] != Integer.MAX_VALUE)
                        costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j] - k);
                }
            }
        }

        return res = costs[from][to];
    }
}
