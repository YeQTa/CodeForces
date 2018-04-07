import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*Problem Link = http://codeforces.com/problemset/problem/231/A
 * 
 * @Author Yekta Anıl Aksoy
 * Fast Reader class is used for making fast input / output operation
 */

public class _231A_Team {
	static FastReader in;
	static PrintWriter out;
	
	public static void Solve(){
		int n = in.nextInt();
		int problemcount[] = new int[n+1];
		int index=1;
		int result=0;
		for(int i = 1;i<=n*3;i++){
			problemcount[index]+=in.nextInt();
			if(i%3==0){
				if(problemcount[index]>1){
					result++;
				}
				index++;
			}
		}
		out.print(result);
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
