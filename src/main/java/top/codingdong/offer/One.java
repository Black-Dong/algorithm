package top.codingdong.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 二维数组中的查找，替换空格，从尾到头打印链表
 *
 * @author Dong
 * @date 2020/1/2 19:23
 */
public class One {

    /**
     * 二维数组中的查找
     *
     * 在一个二维数组中（每个一维数组的长度相同），
     * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {
        if (array == null || array[0].length == 0) {
            return false;
        }
        int i = array.length - 1;
        int j = 0;
        while (i >= 0 && j < array.length) {
            if (target > array[i][j]) {
                j++;
            } else if (target == array[i][j]) {
                return true;
            } else if (target < array[i][j]) {
                i--;
            }
        }
        return false;
    }


    /**
     * 替换空格
     *
     * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     *
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        return str.toString().replaceAll(" ", "%20");
    }


    /**
     * 链表
     */
    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    /**
     * 从尾到头打印链表
     *
     * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Stack<ListNode> stack = new Stack<ListNode>();

        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            arrayList.add(stack.pop().val);
        }
        return arrayList;
    }
}

