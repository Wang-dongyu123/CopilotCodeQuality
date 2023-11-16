package main.java.Hard;

/**https://leetcode.com/problems/the-earliest-and-latest-rounds-where-players-compete/ */
//There is a tournament where n players are participating. The players are standing in a single row and are numbered from 1 to n based on their initial standing position (player 1 is the first player in the row, player 2 is the second player in the row, etc.).
//The tournament consists of multiple rounds (starting from round number 1). In each round, the ith player from the front of the row competes against the ith player from the end of the row, and the winner advances to the next round. When the number of players is odd for the current round, the player in the middle automatically advances to the next round.
//For example, if the row consists of players 1, 2, 4, 6, 7
//Player 1 competes against player 7.
//Player 2 competes against player 6.
//Player 4 automatically advances to the next round.
//After each round is over, the winners are lined back up in the row based on the original ordering assigned to them initially (ascending order).
//The players numbered firstPlayer and secondPlayer are the best in the tournament. They can win against any other player before they compete against each other. If any two other players compete against each other, either of them might win, and thus you may choose the outcome of this round.
//Given the integers n, firstPlayer, and secondPlayer, return an integer array containing two values, the earliest possible round number and the latest possible round number in which these two players will compete against each other, respectively.


class TheEarliestAndLatestRoundsWherePlayersCompete {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int[] res = new int[2];
        if(firstPlayer > secondPlayer){
            int temp = firstPlayer;
            firstPlayer = secondPlayer;
            secondPlayer = temp;
        }
        int round = 0;
        while(n > 1){
            round++;
            if(firstPlayer % 2 == 1 && secondPlayer == firstPlayer + 1){
                res[0] = round;
                res[1] = round;
                break;
            }
            if(firstPlayer % 2 == 1){
                firstPlayer = (firstPlayer + 1) / 2;
            }else{
                firstPlayer = firstPlayer / 2;
            }
            if(secondPlayer % 2 == 1){
                secondPlayer = (secondPlayer + 1) / 2;
            }else{
                secondPlayer = secondPlayer / 2;
            }
            n = n / 2;
        }
        if(res[0] == 0){
            res[0] = round;
            res[1] = round;
        }
        return res;
        
    }
}
     
    