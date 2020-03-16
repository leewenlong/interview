package interview.offer;

public class FindNumFrom2DArrays {
    /**
     * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
     * 每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int [][] array) {

        if (array == null) {
            return false;
        }

        int lenx = array.length;
        int leny = array[0] == null ? 0:array[0].length;

        for (int i = 0; i < lenx; i++) {
            for (int j = leny-1; j >= 0; j--) {
                if (target > array[i][j]) {
                    break;
                }
                if (target < array[i][j]){
                    continue;
                }
                if (target == array[i][j]){
                    return true;
                }
            }
        }

        return false;
    }
}
