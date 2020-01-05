package top.codingdong.offer;

/**
 * 数值的整数次方、
 *
 * @author Dong
 * @date 2020/1/5 21:10
 */
public class Five {

    /**
     * 数值的整数次方
     * <p>
     * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
     * 保证base和exponent不同时为0
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {

        // 底数为 0
        if (base == 0.0) {
            // 指数为 0
            if (exponent == 0) {
                throw new RuntimeException("底数与指数不能同时为0");
            }
            // 指数小于 0
            if (exponent < 0) {
                throw new RuntimeException("分母不能为0");
            }
            // 指数大于 0
            return 0;
            //底数不为 0
        } else if (base != 0.0) {
            // 底数为1 或 指数为0
            if (base == 1 || exponent == 0) {
                return 1;
            }
            // 指数为1
            if (exponent == 1) {
                return base;
            }
        }

        // 获取指数的绝对值
        int n = exponent;
        if (exponent < 0) {
            n = -exponent;
        }

        //1.递归实现
        // 递归实现 幂运算
        double result = Power(base, n >> 1);
        result *= result;
        // 当指数为2的倍数时，返回的result为1 result *= result还是1，所以需要让result = bast;
        if ((n & 1) == 1) {
            result *= base;
        }
/*
            // 循环实现
            double result = base;
            for (int i = 1; i < n; i++) {
                result *= base;
            }
*/
        // 根据指数的正负返回合适的值
//        return exponent > 0 ? result : 1 / result;
        if (exponent < 0) {
            result = 1 / result;
        }
        return result;

    }
}

