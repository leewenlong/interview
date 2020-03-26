package algorithm.leetcode;

import java.util.*;

public class BinaryTree {
    public static final String newline = System.getProperty("line.separator");

    public TreeNode build(TreeNode root, int next) {
        if (root == null) {
            return new TreeNode(next);
        }
        if (root.val > next) {
            root.left = build(root.left, next);
        } else if (root.val < next) {
            root.right = build(root.right, next);
        }
        return root;
    }

    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }

    public void preorderII(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> nodes = new Stack<>();
        while (null != root || !nodes.isEmpty()) {
            while (null != root) {
                result.add(root.val);
                nodes.push(root);
                root = root.left;
            }

            if (!nodes.isEmpty()) {
                root = nodes.pop().right;
            }
        }
    }

    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }

    public void inorderII(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (null != root || !stack.isEmpty()) {
            while (null != root) {
                stack.add(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                root = pop.right;
            }
        }
    }

    public void postorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

    public void postorderII(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        TreeNode last = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.peek();
            if (root.right == null || last == root.right) {
                result.add(root.val);
                last = stack.pop();
                root = null;
            } else {
                root = root.right;
            }

        }
    }

    public void levelOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            result.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    //height or depth
    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public int countNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNode(root.left) + countNode(root.right) + 1;
    }

    public int countLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeaves(root.left) + countLeaves(root.right);
    }

    public int kthLevelCount(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return kthLevelCount(root.left, k - 1) + kthLevelCount(root.right, k - 1);
    }

    public void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        mirror(root.left);
        mirror(root.right);
    }

    public List<List<Integer>> findAllPath(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> all = new ArrayList<>();
        findAllPathBacktrack(all, path, root);
        return all;
    }

    private void findAllPathBacktrack(List<List<Integer>> all, List<Integer> path, TreeNode node) {
        if (null == node.left && node.right == null) {
            path.add(node.val);
            all.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
        } else {
            path.add(node.val);
            if (node.left != null) {
                findAllPathBacktrack(all, path, node.left);
            }
            if (node.right != null) {
                findAllPathBacktrack(all, path, node.right);
            }
            path.remove(path.size() - 1);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b) {
        if (root == null) {
            return null;
        }
        if (root == a || root == b) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, a, b);
        TreeNode right = lowestCommonAncestor(root.right, a, b);
        if (left != null && right != null) {//找到a和b在root结点的左右子树上
            return root;
        }
        return left == null ? right : left;
    }


    public static void main(String[] args) {
        Random random = new Random();
        BinaryTree tree = new BinaryTree();
        TreeNode root = new TreeNode(random.nextInt(20));
        for (int i = 0; i < 10; i++) {
            tree.build(root, random.nextInt(20));
        }
        System.out.println("root:" + root.val);

        List<Integer> pre = new ArrayList<>();
        List<Integer> pre1 = new ArrayList<>();
        tree.preorder(root, pre);
        tree.preorderII(root, pre1);
        System.out.println("preorder use recurision and stack result equals : " + pre.equals(pre1));
        System.out.println("preorder result : " + pre + newline);

        List<Integer> in = new ArrayList<>();
        List<Integer> in1 = new ArrayList<>();
        tree.inorder(root, in);
        tree.inorderII(root, in1);
        System.out.println("inorder use recurision and stack result equals : " + tree.equals(in1));
        System.out.println("inorder result : " + in + newline);

        List<Integer> post = new ArrayList<>();
        List<Integer> post1 = new ArrayList<>();
        tree.postorder(root, post);
        tree.postorderII(root, post1);
        System.out.println("postorder use recurision and stack result equals : " + post.equals(post1));
        System.out.println("postorder : " + post + newline);

        List<Integer> level = new ArrayList<>();
        tree.levelOrder(root, level);
        System.out.println("levelorder : " + level + newline);

        System.out.println("height or depth : " + tree.height(root) + newline);

        System.out.println("total node count : " + tree.countNode(root) + newline);

        System.out.println("leaf node count : " + tree.countLeaves(root) + newline);

        System.out.println("3th level node count : " + tree.kthLevelCount(root, 3) + newline);

        tree.mirror(root);
        List<Integer> mirrorLevel = new ArrayList<>();
        tree.levelOrder(root, mirrorLevel);
        System.out.println("mirror levelorder : " + mirrorLevel + newline);
        tree.mirror(root);

        List<List<Integer>> pathA = tree.findAllPath(root);
        System.out.println("all path to leaf : " + pathA + newline);

        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(12);
        TreeNode node7 = new TreeNode(18);
        TreeNode node8 = new TreeNode(0);
        TreeNode node9 = new TreeNode(5);
        TreeNode node10 = new TreeNode(6);
        TreeNode node11 = new TreeNode(20);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        node9.right = node10;
        node7.right = node11;
        TreeNode lca = tree.lowestCommonAncestor(node1, node4, node5);
        System.out.println(lca.val);

    }

}
