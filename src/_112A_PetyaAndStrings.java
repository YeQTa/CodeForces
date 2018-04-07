import java.io.*;
import java.util.*;

/*
  Problem Link : http://codeforces.com/problemset/problem/112/A
*/

public class _112A_PetyaAndStrings {
	static FastReader in;
	static PrintWriter out;
	
	public static void Solve(){
       String str = in.next().toLowerCase();
       String str2 = in.next().toLowerCase();
       
       out.println(str.compareTo(str2)>0?"1":str.compareTo(str2)<0?"-1":"0");
       
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


