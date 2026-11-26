
class Solution {
    public boolean canAliceWin(int n) {

        int stones = 10;
        boolean aliceTurn = true;

        while (n >= stones && stones >0) {
            n -= stones;
            stones--;
            aliceTurn = !aliceTurn;
        }

        return !aliceTurn;
    }
}
