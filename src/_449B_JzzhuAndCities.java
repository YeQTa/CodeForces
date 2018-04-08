import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class _449B_JzzhuAndCities {
	static FastReader in;
	static PrintWriter out;

	final static long INFINITY = (long)(1e16);
	
	private static class Node implements Comparable<Node>{
		int v;
		long w;
		
		public Node(int v,long w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			if(this.w > o.w)
				return 1;
			else if(this.w < o.w)
				return -1;
			return 0;
		}
	}

	
	
	public static void Solve(){
		
		String[] line = in.nextLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int m = Integer.parseInt(line[1]);
		int k = Integer.parseInt(line[2]);
		
		@SuppressWarnings("unchecked")
		ArrayList<Node> g[] = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			g[i] = new ArrayList<Node>();
		}
		
		for(int i = 0; i < m; i++) {
			line = in.nextLine().split(" ");
			int u = Integer.parseInt(line[0]) - 1;
			int v  = Integer.parseInt(line[1]) - 1;
			int x = Integer.parseInt(line[2]);
			
			g[u].add(new Node(v,x));
			g[v].add(new Node(u,x));
		}
		
		boolean need[] = new boolean[n];
		int train[]  = new int[n];
		
		for(int i = 0; i < k; i++) {
			line = in.nextLine().split(" ");
			int s = Integer.parseInt(line[0]) - 1;
			int y = Integer.parseInt(line[1]);
			need[s] = true;
			
			if(train[s] == 0)
				train[s] = y;
			else
				train[s]  = Math.min(train[s], y);
		}
		
		long dist[] = new long[n];
		boolean[] outOfQueue = new boolean[g.length];
		
		Arrays.fill(dist, INFINITY);
		dist[0] = 0;
		
		PriorityQueue<Node> q = new PriorityQueue<Node>(2*g.length);
		q.add(new Node(0,0));
		
		for(int i = 1; i < n; i++) {
			if(need[i]) {
				q.add(new Node(i,train[i]));
				dist[i] = train[i];
			}
		}
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			int curr = now.v;
			if(!outOfQueue[curr]) {
				outOfQueue[curr] = true;
				int s = g[curr].size();
				for(int i = 0; i < s; i++) {
					int next = g[curr].get(i).v;
					long edge = g[curr].get(i).w;

					if(dist[curr] + edge < dist[next]) {
						dist[next] = dist[curr] + edge;
						need[next] = false;
						q.add(new Node(next,dist[next]));
					}
					else if(dist[curr] + edge == dist[next])
						need[next] = false;
				}
			}
		}
		
		int der = 0;
		for(int i = 1; i<n; i++) {
			if(need[i])
				der++;
		}
		out.println(k-der);
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
