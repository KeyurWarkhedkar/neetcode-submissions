class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<List<Integer>> ans = new ArrayList<>();
        int first = 0;
        int second = 0;

        while(first < firstList.length && second < secondList.length) {
            if((firstList[first][0] >= secondList[second][0] && firstList[first][0] <= secondList[second][1])
            || (secondList[second][0] >= firstList[first][0] && secondList[second][0] <= firstList[first][1])) {
                List<Integer> temp = new ArrayList<>();
                temp.add(Math.max(firstList[first][0], secondList[second][0]));
                temp.add(Math.min(firstList[first][1], secondList[second][1]));
                ans.add(temp);
                if(firstList[first][1] >= secondList[second][1]) {
                    second++;
                } else {
                    first++;
                }
            } else {
                if(firstList[first][1] >= secondList[second][1]) {
                    second++;
                } else {
                    first++;
                }
            }
            System.out.println(first + " " + second);
        }

        int[][] answer = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++) {
            answer[i][0] = ans.get(i).get(0);
            answer[i][1] = ans.get(i).get(1);
        }

        return answer;
    }
}