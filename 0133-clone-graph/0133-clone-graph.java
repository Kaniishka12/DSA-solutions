/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map <Node,Node> mp=new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
       
       Node n=new Node(node.val);
       mp.put(node,n);
       for(Node nei:node.neighbors){
        if(!mp.containsKey(nei))cloneGraph(nei);
        n.neighbors.add(mp.get(nei));
       }
       return n;
    }
}