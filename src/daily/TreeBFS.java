package daily;

import java.util.ArrayList;

class TreeBFS {
    public static void main(String[] args) {
        TreeBFSSolution.tree root = new TreeBFSSolution.tree("1");
        TreeBFSSolution.tree rootChild1 = root.addChildNode(new TreeBFSSolution.tree("2"));
        TreeBFSSolution.tree rootChild2 = root.addChildNode(new TreeBFSSolution.tree("3"));
        TreeBFSSolution.tree leaf1 = rootChild1.addChildNode(new TreeBFSSolution.tree("4"));
        TreeBFSSolution.tree leaf2 = rootChild1.addChildNode(new TreeBFSSolution.tree("5"));
        leaf1.addChildNode(new TreeBFSSolution.tree("6"));
        rootChild2.addChildNode(new TreeBFSSolution.tree("7"));

        TreeBFSSolution bfsSolution = new TreeBFSSolution();
        ArrayList<String> values = bfsSolution.bfs(root);

        for (String value : values){
            System.out.println(value);
        }
    }
}

class TreeBFSSolution {
    public ArrayList<String> bfs(tree node) {
        // TODO:
        ArrayList<String> values = new ArrayList<>();
        values.add(node.getValue());

        if(node.getChildrenNode() != null) {
            for(int i = 0; i < node.getChildrenNode().size(); i++) {
                ArrayList<String> curList = bfs(node.getChildrenNode().get(i));
                values.addAll(curList);
            }
        }
        return values;
    }

    //아래 클래스의 내용은 수정하지 말아야 합니다.
    public static class tree {
        private String value;
        private ArrayList<tree> children;

        public tree(String data) {
            this.value = data;
            this.children = null;
        }

        public tree addChildNode(tree node) {
            if(children == null) children = new ArrayList<>();
            children.add(node);
            return children.get(children.size() - 1);
        }

        public String getValue() {      //현재 노드의 데이터를 반환
            return value;
        }

        public ArrayList<tree> getChildrenNode() {
            return children;
        }
    }
}
