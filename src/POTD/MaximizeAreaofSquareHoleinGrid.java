package POTD;

import java.util.Arrays;

public class MaximizeAreaofSquareHoleinGrid {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars){
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int hCurr = 1;
        int vCurr = 1;
        int vMax = 1;
        int hMax = 1;
        for (int i = 1; i < hBars.length; i++){
            if(hBars[i] == hBars[i-1]+1){
                hCurr++;
            }else {
                hCurr = 1;
            }

            hMax = Math.max(hMax, hCurr);
        }

        for (int i = 1; i < vBars.length; i++){
            if (vBars[i] == vBars[i-1]+1){
                vCurr++;
            }else {
                vCurr = 1;
            }
            vMax = Math.max(vMax, vCurr);
        }

        int side = Math.min(vMax, hMax);
        return side * side;
    }
}
