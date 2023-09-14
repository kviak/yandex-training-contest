import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int Q = scanner.nextInt();

        int[] initialTree = new int[N];
        for (int i = 0; i < N; i++) {
            initialTree[i] = i + 1;
        }

        int[] changes = new int[Q];
        for (int i = 0; i < Q; i++) {
            changes[i] = scanner.nextInt();
        }

        for (int v : changes) {
            updateTree(initialTree, v);
        }

        String result = printTree(initialTree, 1);
        System.out.println(result.trim());
    }

    private static void updateTree(int[] tree, int v) {
        int indexV = -1;
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == v) {
                indexV = i;
                break;
            }
        }

        if (indexV == -1) {
            return;
        }

        int indexP = indexV / 2;
        int temp = tree[indexV];
        tree[indexV] = tree[indexP];
        tree[indexP] = temp;
    }

    private static String printTree(int[] tree, int v) {
        StringBuilder result = new StringBuilder();

        int leftChild = 2 * v;
        int rightChild = 2 * v + 1;

        if (leftChild <= tree.length) {
            result.append(printTree(tree, leftChild));
        }

        result.append(tree[v - 1]).append(" ");

        if (rightChild <= tree.length) {
            result.append(printTree(tree, rightChild));
        }

        return result.toString();
    }
}