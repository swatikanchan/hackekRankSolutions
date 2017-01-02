package dynamicprogramming;

/**
 * Created by Swati on 10-10-2016.
 */
public class MinCostPath {
    public static void main(String[] args) {
        int[][] costPath = {{1,2,1},{4,8,2},{1,5,3}};
        int desiredRowIndex = 2, desiredColumnIndex = 2;
        int minimumCost = computeMinimumCostPath(costPath, desiredRowIndex, desiredColumnIndex);
        System.out.println("Minimum Cost Path:"+minimumCost);
    }

    private static int computeMinimumCostPath(int[][] costPath, int desiredRowIndex, int desiredColumnIndex) {
        int minimumCost = 0;
        if(desiredRowIndex==0 && desiredColumnIndex==0)
        {
            return 0;
        }
        else{
            minimumCost = getMinimumCost(costPath, desiredRowIndex, desiredColumnIndex);
        }
        return minimumCost;
    }

    private static int getMinimumCost(int[][] costPath, int desiredRowIndex, int desiredColumnIndex) {
        int minimumCost = costPath[0][0];
        int tempRow = 0,tempColumn=0;
        for(int i=tempRow;i<desiredRowIndex;i++)
        {
            for(int j=tempColumn;j<desiredColumnIndex;j++)
            {
                if(costPath[i+1][j]<costPath[i][j+1])
                {
                    if(costPath[i+1][j]<costPath[i+1][j+1])
                    {
                        minimumCost=minimumCost+costPath[i+1][j];
                        tempRow++;
                        System.out.println(costPath[i+1][j]);
                    }
                    else
                    {
                        minimumCost=minimumCost+costPath[i+1][j+1];
                        tempRow++;
                        tempColumn++;
                        System.out.println(costPath[i+1][j+1]);

                    }
                }
                 else
                {
                    if(costPath[i][j+1]<costPath[i+1][j+1])
                    {
                        minimumCost=minimumCost+costPath[i][j+1];
                        tempColumn++;
                        System.out.println(costPath[i][j+1]);
                    }
                    else
                    {
                        minimumCost=minimumCost+costPath[i+1][j+1];
                        tempRow++;
                        tempColumn++;
                        System.out.println(costPath[i+1][j+1]);
                    }
                }

            }
        }
        return minimumCost+costPath[desiredRowIndex][desiredColumnIndex];
    }
}
