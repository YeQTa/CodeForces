import java.io.*;
import java.util.*;

/* 
  Problem Link = http://codeforces.com/contest/96/problem/A
*/

public class Solution {
	static FastReader in;
	static PrintWriter out;
	
	public static void Solve(){
       String str = in.next();
       
       int contiguous=1;
       for(int i = 1;i<str.length();i++){
    	   if(str.charAt(i) == str.charAt(i-1)){
    		   contiguous++;
    		   if(contiguous==7){
    			   out.println("YES");
    			   break;
    		   }
    	   }
    	   else
    		   contiguous=1;
    	   
    	   if(i==str.length()-1 && contiguous!=7){
    		   out.println("NO");
    		   break;
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


