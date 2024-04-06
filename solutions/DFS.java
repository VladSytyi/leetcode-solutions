import java.util.Stack;

public class DFS {

    //
    public TreeNode dfs(TreeNode treeNode) {

        if (treeNode == null) return null;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);

        while (!stack.isEmpty()) {
            TreeNode visited = stack.pop();

            // do smth here with obtained TreeNode

            if (visited.right != null) stack.push(visited.right);
            if (visited.left != null) stack.push(visited.left);


        }

        return treeNode;

    }

    record TreeNode(int val, TreeNode left, TreeNode right){}
}
