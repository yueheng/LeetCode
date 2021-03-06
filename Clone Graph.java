/*
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled uniquely.

We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
As an example, consider the serialized graph {0,1,2#1,2#2,2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
Second node is labeled as 1. Connect node 1 to node 2.
Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
*/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map= new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        queue.add(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.remove();
            if(!map.containsKey(curr)) {   //important
                UndirectedGraphNode newcurr = new UndirectedGraphNode(curr.label);
                map.put(curr, newcurr);
                ArrayList<UndirectedGraphNode> n = curr.neighbors;
                for(int i = 0; i < n.size(); i++) {
                    if(!map.containsKey(n.get(i))) queue.add(n.get(i));
                }
            }
        }
        queue.add(node);
        while(!queue.isEmpty()) {
            UndirectedGraphNode curr = queue.remove();
            UndirectedGraphNode newcurr = map.get(curr);
            ArrayList<UndirectedGraphNode> n = curr.neighbors;
            ArrayList<UndirectedGraphNode> newn = newcurr.neighbors;
            if(newn.size() == 0) {  ////important
                for(int i = 0; i < n.size(); i++) {
                    UndirectedGraphNode temp = n.get(i);
                    newn.add(map.get(temp));
                    queue.add(temp);
                }
            }
        }
        return map.get(node);
    }
}