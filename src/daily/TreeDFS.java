package daily;

import java.util.ArrayList;

class TreeDFS {
    public static void main(String[] args) {
        TreeDFSSolution.tree root = new TreeDFSSolution.tree("A");
        TreeDFSSolution.tree nodeB = root.addChildNode(new TreeDFSSolution.tree("B"));
        TreeDFSSolution.tree nodeC = root.addChildNode(new TreeDFSSolution.tree("C"));
        TreeDFSSolution.tree nodeD = nodeB.addChildNode(new TreeDFSSolution.tree("D"));
        TreeDFSSolution.tree nodeE = nodeB.addChildNode(new TreeDFSSolution.tree("E"));
        TreeDFSSolution.tree nodeF = nodeC.addChildNode(new TreeDFSSolution.tree("F"));
        TreeDFSSolution.tree nodeG = nodeC.addChildNode(new TreeDFSSolution.tree("G"));

        TreeDFSSolution dfsSolution = new TreeDFSSolution();
        ArrayList<String> values = dfsSolution.dfs(root);

        for(String value : values) {
            System.out.println(value);
        }
    }
}

class TreeDFSSolution {
    public ArrayList<String> dfs(tree node){
        ArrayList<String> values = new ArrayList<>();
        values.add(node.getValue());

        if(node.getChildrenNode() != null) {
            for(int i = 0; i < node.getChildrenNode().size(); i++) {
                ArrayList<String> curList = dfs(node.getChildrenNode().get(i));
                values.addAll(curList);
            }
        }
        return values;
    }

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
