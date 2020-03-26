package algorithm.leetcode;

import java.util.*;

public class BinaryTree {

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
        path.add(root.val);
        if (root.left != null) {
            findAllPathBacktrack(all, path, root.left);
        }
        if (root.right != null) {
            findAllPathBacktrack(all, path, root.right);
        }
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
            path.remove(path.size() - 1);
            path.add(node.val);
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
        //TODO

        return null;
    }

    private boolean isEquals(List<Integer> a, List<Integer> b) {
        if (a.size() != b.size()) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return false;
            }
        }
        return true;
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
        System.out.println(tree.isEquals(pre, pre1));
        System.out.println("    pre:" + pre);

        List<Integer> in = new ArrayList<>();
        List<Integer> in1 = new ArrayList<>();
        tree.inorder(root, in);
        tree.inorderII(root, in1);
        System.out.println(tree.isEquals(in, in1));
        System.out.println("    in:" + in);

        List<Integer> post = new ArrayList<>();
        List<Integer> post1 = new ArrayList<>();
        tree.postorder(root, post);
        tree.postorderII(root, post1);
        System.out.println(tree.isEquals(post, post1));
        System.out.println("    post:" + post);

        List<Integer> level = new ArrayList<>();
        tree.levelOrder(root, level);
        System.out.println("    level:" + level);

        System.out.println("    height:" + tree.height(root));

        System.out.println("    count:" + tree.countNode(root));

        System.out.println("    leaves:" + tree.countLeaves(root));

        System.out.println("    3LevelCount:" + tree.kthLevelCount(root, 3));

        tree.mirror(root);
        List<Integer> mirrorLevel = new ArrayList<>();
        tree.levelOrder(root, mirrorLevel);
        System.out.println("    mirror-level:" + mirrorLevel);
        tree.mirror(root);

        List<List<Integer>> allPath = tree.findAllPath(root);

        System.out.println(allPath);
    }

}
