class Solution {
    public boolean isRobotBounded(String instructions) {

        int dir[][] = {
            {0,1},  //North
            {1,0},  //East
            {0,-1}, //South
            {-1,0}  //West
        };
        int x=0, y=0;
        int i=0; 
                
        for(char c : instructions.toCharArray()){
            if(c == 'L') 
                i = (i + 3) % 4;
            else if(c == 'R') 
                i = (i + 1) % 4;
            else {
                x += dir[i][0]; // Calculating the x distance
                y += dir[i][1]; // Calculating the y distance
            }
        }
        return (x == 0 && y == 0) || (i > 0);
    }
}