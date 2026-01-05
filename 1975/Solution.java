class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        boolean negativeParity = true;
        int min = Integer.MAX_VALUE;
        int length = matrix.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int val = matrix[i][j];
                int abs = Math.abs(val);
                sum += abs;
                min = Math.min(min, abs);
                if (val < 0) {
                    negativeParity = !negativeParity;
                }
            }
        }
        if (negativeParity) {
            return sum;
        } else {
            return sum - 2 * min;
        }
    }
}