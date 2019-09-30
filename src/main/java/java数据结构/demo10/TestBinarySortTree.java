package java数据结构.demo10;


public class TestBinarySortTree {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 9, 5, 4, 6, 7};
        BinarySortTree bst = new BinarySortTree();
        for (int i : arr) {
            bst.add(new Node(i));
        }
        System.out.println(bst.root.height());
        System.out.println(bst.root.value);
        System.out.println(bst.search(5));
    }

}
