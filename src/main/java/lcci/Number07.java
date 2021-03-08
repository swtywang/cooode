package lcci;

/**
 * Created by wangyuedong02 on 2021/3/8 下午3:07
 *
 * @link https://leetcode-cn.com/problems/rotate-matrix-lcci/
 * @desc 旋转矩阵
 */
public class Number07 {
    public static void rotate(int[][] matrix) {
        int size = matrix[0].length;
        int[][] result = new int[size][size];
        //step1 先对角线交换
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //step2 沿中轴线交换
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][size - j - 1];
                matrix[i][size - j - 1] = temp;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }

    public static void main(String[] args) {

    }

}
