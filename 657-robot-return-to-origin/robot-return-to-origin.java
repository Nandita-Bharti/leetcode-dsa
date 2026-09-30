class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);
            
            switch (move) {
                case 'U':
                    y++; 
                    break;
                case 'D':
                    y--; 
                    break;
                case 'R':
                    x++; 
                    break;
                case 'L':
                    x--; 
                    break;
            }
        }
        return x == 0 && y == 0;
    }
}