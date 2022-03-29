class UndergroundSystem {
    
    // id, stationName, Time
    private Map<Integer,Pair<String,Integer>> checkInData;
    // stationStart->StationEnd, totalTime, totalTrips
    private Map<String,Pair<Double,Double>> journeyData;
    
    public UndergroundSystem() {
        checkInData=new HashMap<>();
        journeyData=new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInData.put(id,new Pair<>(stationName,t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String,Integer> checkInDataForId=checkInData.get(id);
        String startStationName=checkInDataForId.getKey();
        Integer checkInTime=checkInDataForId.getValue();
        
        String routeKey=stationKey(startStationName,stationName);
        Pair<Double,Double> routeStats=journeyData.getOrDefault(routeKey,new Pair<>(0.0,0.0));
        Double totalTimeTaken=routeStats.getKey();
        Double totalTrips=routeStats.getValue();
        
        double tripTime=t-checkInTime;
        journeyData.put(routeKey,new Pair<>(totalTimeTaken+tripTime,totalTrips+1));
        
        checkInData.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey=stationKey(startStation,endStation);
        double totalTime=journeyData.get(routeKey).getKey();
        double totalTrips=journeyData.get(routeKey).getValue();
        
        return totalTime/totalTrips;
    }
    private String stationKey(String startStationName,String endStationName){
        return startStationName+"->"+endStationName;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */