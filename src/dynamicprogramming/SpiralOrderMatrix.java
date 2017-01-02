package dynamicprogramming;

/**
 * Created by Swati on 12-11-2016.
 */
public class SpiralOrderMatrix {
    public static void main(String[] args) {
        SpiralOrderMatrix som = new SpiralOrderMatrix();
        int[][] inputArray = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        som.convertSpiralOrder(inputArray);
    }
    public void convertSpiralOrder(int[][] inputArray)
    {
        int rowMax = inputArray.length;
        int colMax = inputArray[0].length;
        int[] spiralOrderArray = new int[rowMax*colMax];
        int rowMin =0, colMin=0, index=0;
        int i;
        while(rowMin<rowMax && colMin<colMax)
        {

            for(i=colMin;i<colMax;i++)
            {
                spiralOrderArray[index++]=inputArray[rowMin][i];
            }
            rowMin++;

            for(i=rowMin;i<rowMax;i++)
            {
                spiralOrderArray[index++]=inputArray[i][colMax-1];
            }
            colMax--;

            if(rowMin<rowMax) {
                for (i = colMax - 1; i >= colMin; i--) {
                    spiralOrderArray[index++] = inputArray[rowMax - 1][i];
                }
                rowMax--;
            }

            if(colMin<colMax) {
                for (i = rowMax - 1; i >= rowMin; i--) {
                    spiralOrderArray[index++] = inputArray[i][colMin];
                }
                colMin++;
            }
        }
        for(i=0;i<spiralOrderArray.length;i++)
        {
            System.out.print(spiralOrderArray[i]+" ");
        }
    }
}
