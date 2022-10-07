class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangleResult = new ArrayList<>();
        
        triangleResult.add(new ArrayList<>(Arrays.asList(1)));
        
        for (int rowNum = 1; rowNum<numRows; rowNum++) {
            List<Integer> prevRow = triangleResult.get(rowNum-1);
            List<Integer> currRow = new ArrayList<>();
            currRow.add(1);
            
            for (int i=1;i<rowNum;i++) {
                int val = prevRow.get(i-1) + prevRow.get(i);
                currRow.add(val);
            }
            currRow.add(1);
            triangleResult.add(currRow);
        }
        
        return triangleResult;
    }
}