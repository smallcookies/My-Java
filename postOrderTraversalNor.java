package homework;

import java.util.Stack;

/* *
 * @Created with IntelliJ IDEA.
 * @Description：不用递归的后序遍历方法
 * @Author：WangGuiyang
 * @Date：2020/3/28 13:28
 */

class TreeNode {

    public char value;
    public TreeNode left;    //   节点地址
    public TreeNode right;

    //  调用它的构造方法
    public TreeNode(char value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
public class postOrderTraversalNor {


    void postOrderTraversalNor(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode cur = root;      //  定义一个 cur 等于当前的根
        TreeNode prev = null;   //   用来记录最近一次打印过的
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.empty()) {
            //  加 !stack.empty() 是为了防止cur 为空，栈内不为空
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;     //  向左走完
            }
            cur = stack.peek();   // cur 指向当前的栈顶元素   //  D   B
            if (cur.right == null || cur.right == prev) {
                //  打印 之后弹出元素
                System.out.print(cur.value+ " ");
                stack.pop();
                prev = cur;
                cur = null;   //  让cur 为空，不然会进入死循环
            }else {
                cur = cur.right;
            }

        }
        System.out.println();
    }
}

