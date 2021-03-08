package lcci;

import java.util.Stack;

/**
 * Created by wangyuedong02 on 2021/3/8 下午4:21
 *
 * @link https://leetcode-cn.com/problems/zero-matrix-lcci/
 */
public class Number08 {
    /**
     * 用stack去存有0的行/列
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        Stack<Integer> row = new Stack<Integer>();
        Stack<Integer> col = new Stack<Integer>();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (matrix[i][j] == 0) {
                    row.push(i);
                    col.push(j);
                }
            }
        }

        while (row.size() > 0) {
            int cur = row.peek();
            for (int i = 0; i < colSize; i++) {
                matrix[cur][i] = 0;
            }
            row.pop();
        }

        while (col.size() > 0) {
            int cur = col.peek();
            for (int i = 0; i < rowSize; i++) {
                matrix[i][cur] = 0;
            }
            col.pop();
        }

    }

    /**
     * 用第一行和第一列标记这一行/列是否有0
     * @param matrix
     */
    public static void setZeroes1(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        boolean isHeadRowHasZero = false;
        for (int i = 0; i < colSize; i++) {
            if (matrix[0][i] == 0) {
                isHeadRowHasZero = true;
                break;
            }
        }
        //如果第一列有0，那么这一列要变成0
        boolean isHeadColHasZero = false;
        for (int i = 0; i < rowSize; i++) {
            if (matrix[i][0] == 0) {
                isHeadColHasZero = true;
                break;
            }
        }
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < rowSize; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < colSize; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < colSize; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < rowSize; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        //如果第一行有0，那么这一行要都变成0
        if (isHeadRowHasZero) {
            for (int i = 0; i < colSize; i++) {
                matrix[0][i] = 0;
            }
        }
        if (isHeadColHasZero) {
            for (int i = 0; i < rowSize; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] res = new int[2][2];
        res[0][0] = 1;
        res[1][1] = 1;
        setZeroes(res);
    }
}
