package top.codingdong.offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * 重建二叉树，用两个栈实现队列，查找最小值
 *
 * @author Dong
 * @date 2020/1/3 19:32
 */
public class Two {

    /**
     * Definition for binary tree
     */
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 重建二叉树
     *
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
     * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        // 寻找中序中根节点位置
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }
        return root;
    }


    /**
     * 用两个栈实现队列
     *
     * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
     */
    public static class MyQueue{
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        public void push(int node) {
            stack1.push(node);
        }
        public int pop() {
            if(stack2.size() == 0){
                while(stack1.size() > 0){
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }


    /**
     * 查找最小值
     *
     * 最小值
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0){
            return 0;
        }
        Arrays.sort(array);
        return array[0];
    }

    /**
     * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        int f = 0 , g = 1;
        while(n > 0){
            g = g + f;
            f = g - f;
            n--;
        }
        return f;
    }

}
