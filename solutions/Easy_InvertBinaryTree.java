import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Easy_InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null) return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        return new TreeNode(root.val, right, left);
    }

    public TreeNode invertDFS(TreeNode root) {
        if (root == null) return null;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode visitedNode = stack.pop();
            TreeNode temp = visitedNode.left;
            visitedNode.left = visitedNode.right;
            visitedNode.right = temp;

            if (visitedNode.left != null) stack.push(visitedNode.left);
            if (visitedNode.right != null) stack.push(visitedNode.right);
        }
        return root;
    }

    public TreeNode invertBFS(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode visitedNode = queue.poll();

            TreeNode temp = visitedNode.left;
            visitedNode.left = visitedNode.right;
            visitedNode.right = temp;

            if (visitedNode.left != null) queue.add(visitedNode.left);
            if (visitedNode.right != null) queue.add(visitedNode.right);


        }

        return root;

    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }



}


