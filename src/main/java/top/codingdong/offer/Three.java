package top.codingdong.offer;

/**
 * 跳台阶，变态跳台阶，矩形覆盖
 * @author Dong
 * @date 2020/1/4 19:42
 */
public class Three{

    /**
     * 跳台阶
     *
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target <= 0){
            return target;
        }
        int f = 1, g = 1;
        while (target > 0){
            g = g + f;
            f = g - f;
            target--;
        }
        return f;
    }

    /**
     * 变态跳台阶
     *
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
     * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
     * 11111 1112 1121 1211 2111 122  212 221 113 131 311 23 32 14 41 5
     * 1111 112 121 211 13 31 22 4
     * 1  2  4  8 16
     * f(n) = f(n-1)+...+f(1)+1
     * f(n) = 2f(n-1)
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        int f = 1;
        if (target <= 0){
            return 0;
        }
        else if (target == 1){
            return 1;
        }
        for (int i = 1; i < target; i++){
            f *= 2;
        }
        return f;
    }


    /**
     * 矩形覆盖
     *
     * 我们可以用 2 * 1 的小矩形横着或者竖着去覆盖更大的矩形。
     * 请问用 n 个 2 * 1 的小矩形无重叠地覆盖一个 2 * n 的大矩形，总共有多少种方法？
     * 1 2 3 5
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target == 0){
            return 0;
        }
        int f = 0, g = 1;
        for (int i = 0; i < target; i++) {
            g += f;
            f = g - f;
        }
        return g;
    }


}
