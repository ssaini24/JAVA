package topView;

import java.util.Map;
import java.util.TreeMap;

public class TopView {

    private TreeMap<Integer, Integer> hashMap;

    public TopView(TreeMap<Integer, Integer> hashMap){
        this.hashMap = hashMap;
    }

    public void topView(BinaryTree root){
        traverse(root, 0);
        printView();
    }

    private void traverse(BinaryTree root, int vertical){
        if (root == null)
            return;

        if (!hashMap.containsKey(vertical))
            hashMap.put(vertical, root.val);

        traverse(root.leftNode, vertical-1);
        traverse(root.rightNode, vertical+1);
    }

    private void printView(){
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
