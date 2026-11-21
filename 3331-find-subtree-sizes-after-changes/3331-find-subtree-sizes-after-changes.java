class Solution {
    
    List<List<Integer>> adj = new ArrayList<>();
    Map<Character, Integer> lastSeen = new HashMap<>();
    int [] size;

    private void dfs(int node, String s, int [] parent)
    {
        char ch = s.charAt(node);

        //remember previous node
        Integer prev = lastSeen.get(ch);

        //current node becomes nearest node
        lastSeen.put(ch, node);

        //visit all children
        for(int child : adj.get(node))
        {
            dfs(child, s, parent);
        }

        if(prev == null){
            lastSeen.remove(ch);
        } else {
            lastSeen.put(ch, prev);
        }

        if(node != 0){

            int newParent = parent[node];

            if(prev != null){
                newParent = prev;
            }


            parent[node] = newParent;

            size[newParent] += size[node];
        }
    }

    public int[] findSubtreeSizes(int[] parent, String s) {
       int n = parent.length;

       for(int i=0; i<n; i++) 
       {
        adj.add(new ArrayList<>());
       }

       for(int i =1; i<n; i++)
       {
        adj.get(parent[i]).add(i);
       }

       size = new int[n];
       Arrays.fill(size, 1);

       dfs(0, s, parent);

       return size;


    }
}