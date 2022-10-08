class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals in ascending order of their start time and the merge the mergeable intervals...
        Arrays.sort(intervals, (i1,i2) -> (i1[0] - i2[0]) );
        
        LinkedList<int[]> list = new LinkedList<>();
        list.add(intervals[0]);
        
        for (int i=1;i<intervals.length;i++) {
            
            if (list.getLast()[1] >= intervals[i][0]) { //Merge
                list.getLast()[1] = Math.max(list.getLast()[1],intervals[i][1]);
            }else { // Make a new Interval
                list.add(intervals[i]);
            }
        }
        
        int[][] result = new int[list.size()][2];
        int idx = 0;
        for (int[] interval : list) {
            result[idx++] = interval;
        }
        
        return result;
    }
}