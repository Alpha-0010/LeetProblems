class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result = new ArrayList<>();
        int n = graph.length;
        backtrack(graph,new ArrayList<>(Arrays.asList(0)),0);
        return result;
    }
    
    private void backtrack (int[][] graph,List<Integer> tempList,int node) {
        /*...Base Case...*/
        if (node == graph.length-1) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        
        for (int i=0;i<graph[node].length;i++) {
            int nextNode=graph[node][i];
            tempList.add(nextNode);
            backtrack(graph,new ArrayList<>(tempList),nextNode);
            tempList.remove(tempList.size()-1);
        }
        
    }
    
}