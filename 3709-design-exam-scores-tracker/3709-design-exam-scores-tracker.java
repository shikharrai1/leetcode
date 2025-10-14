class ExamTracker {
      ArrayList<long []> timeScore;
      long scoreSum;
    public ExamTracker() {
        timeScore = new ArrayList<>();
        scoreSum = 0;
    }
    
    public void record(int time, int score) {
        scoreSum += score;
        timeScore.add(new long[]{time,scoreSum});
    }
    public int binarySearch(int time){
        int si = 0;
        int ei = timeScore.size()-1;

        while(si < ei){
            int mid = (si+ei)/2;
             if(timeScore.get(mid)[0] == time){
                return mid;
            }
            if(timeScore.get(mid)[0] < time){
                si = mid+1;
            }else{
                ei = mid;
            }
        }
        return si;
    }
    public long totalScore(int startTime, int endTime) {
        int leftIdx = binarySearch(startTime);
        int rightIdx = binarySearch(endTime);
        if(timeScore.get(rightIdx)[0] > endTime){
            rightIdx--;
        }
        if(rightIdx < 0) return 0;
        return timeScore.get(rightIdx)[1] - (leftIdx == 0 ? 0 : timeScore.get(leftIdx-1)[1]);
    }
}

/**
 * Your ExamTracker object will be instantiated and called as such:
 * ExamTracker obj = new ExamTracker();
 * obj.record(time,score);
 * long param_2 = obj.totalScore(startTime,endTime);
 */