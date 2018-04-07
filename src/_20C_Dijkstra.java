
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

/*
 * GRAPH IS GIVEN BELOW. YOU NEED TO PRINT THE SHORTEST PATH FROM NODE 1 TO LAST NODE 
 * EXAMPLE INPUT 
5 6
1 2 2
2 5 5
2 3 4
1 4 1
4 3 3
3 5 1
* OUTPUT = 1 4 3 5 
*/
public class _20C_Dijkstra {
	static FastReader in;
	static PrintWriter out;
	
	private static class Node implements Comparable<Node>{
		int id;
		long distance = Long.MAX_VALUE; // distance to node1
		final Map<Node, Integer> linkedNodes = new HashMap<>();
		Node previous;
		
		public Node(int id) {
			this.id = id;
		}

		@Override
		public int compareTo(Node o) {
			return Long.compare(this.distance, o.distance);
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (id != other.id)
				return false;
			return true;
		}
		
	}
	
	public static int n;
	public static void Solve(){
		String[] line = in.nextLine().split(" ");
        n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        
        Node[] nodes = new Node[n];
        

        
        //getting inputs
        for(int i = 0; i < m; ++i) {
        		line = in.nextLine().split(" ");
        		int a = Integer.parseInt(line[0]) - 1;
        		int b = Integer.parseInt(line[1]) - 1;
        		int w = Integer.parseInt(line[2]);
        		
        		//creating nodes
        		if(nodes[a]==null) {
        			nodes[a] = new Node(a);
        		}
        		if(nodes[b]==null) {
        			nodes[b] = new Node(b);
        		}

        		//adding edges
        		nodes[a].linkedNodes.put(nodes[b], w);
        		nodes[b].linkedNodes.put(nodes[a], w);

        }
        
        
        // Djikstra Algorithm
		final PriorityQueue<Node> pq = new PriorityQueue<>();

		if(nodes[0] == null) {
			out.print(-1);
		}
		
		else {
			
			nodes[0].distance=0;
			pq.add(nodes[0]);
			do {
				final Node node = pq.poll();
				
				for(Entry<Node, Integer> linkedNodeEntry : node.linkedNodes.entrySet()) {
					final Node linkedNode = linkedNodeEntry.getKey();
					final int linkedNodeEdgeWeight = linkedNodeEntry.getValue();
					
					// calculated distance of linked node from source node will be addition of distance of this node from 
					// source and weight of edge between this node and linked node
					long targetDistance = node.distance + linkedNodeEdgeWeight;
	                
					if(!(node.distance == Integer.MAX_VALUE) && targetDistance < linkedNode.distance) {
						// If target calculated distance is less than linkedNode's current distance, we need to update this 
						// linked node's priority so we do same ritual of removing, updating and re-inserting!
						
						linkedNode.distance = targetDistance;
						linkedNode.previous = node;
						pq.offer(linkedNode);
						
					}
				}
			}while(!pq.isEmpty());
			
			if (nodes[n-1]==null || nodes[n - 1].distance == Integer.MAX_VALUE)
				out.println(-1);
			else
			{
				int[] ans = new int[n];
				int counter = 0;
				Node curr = nodes[n-1];

				while (curr != null)
				{
					ans[counter++] = curr.id + 1;
					curr = curr.previous;
				}


				if(ans[counter-1]!=1) {
					out.print(-1);
				}
				else {
					for (int i = counter-1; i >= 0; i--)
						out.print(ans[i] + " ");
				}

			}

			
			
		}
		

	}
	

	public static void main(String[] args) {
		in = new FastReader();
		out = new PrintWriter(System.out);
		
		//long s = System.currentTimeMillis();
		Solve();
		out.flush();
		//System.out.println(System.currentTimeMillis()-s +"ms");
	}
	
	
	
	static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
 
        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt()
        {
            return Integer.parseInt(next());
        }
 
        long nextLong()
        {
            return Long.parseLong(next());
        }
 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
 
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

}
