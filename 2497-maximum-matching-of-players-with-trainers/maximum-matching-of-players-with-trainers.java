class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0 , j = 0 , cnt = 0;
        int m = players.length , n = trainers.length;
        while(i < m && j < n){
            if(trainers[j] >= players[i]){
                cnt++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return cnt;
    }
}