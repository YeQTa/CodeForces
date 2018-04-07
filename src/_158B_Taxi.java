import java.io.*;
import java.util.*;

/* 
  Problem Link : http://codeforces.com/problemset/problem/158/B
*/

public class _158B_Taxi {
	static FastReader in;
	static PrintWriter out;
	
	public static void Solve(){
       int n = in.nextInt();
       int result=0;
       int array[] = new int[4];
       while(n-->0){
    	   int num = in.nextInt();
    	   if(num==4)
    		   result++;
    	   else if(num==1)
    		   array[1]++;
    	   else if(num==2)
    		   array[2]++;
    	   else
    		   array[3]++;
       }
       //if # of 1's is zero, then we can just group 2's and we can add it to # of 3's
       if(array[1]==0){
    	   result += (int)Math.ceil((double)array[2]/2)+array[3];
       }
       else{
    	   //first we deleted # of 1's or 3's(minimum one)
    	   int min = Math.min(array[1], array[3]);
    	   result+=min;
    	   array[3]-=min;
    	   array[1]-=min;
    	   
    	   if(array[1]==0){
    		   result+=(int)Math.ceil((double)array[2]/2) + array[3];
    	   }
    	   else if(array[3]==0){
    		   array[2]+=(int)Math.ceil((double)array[1]/2);
    		   result+= (int)Math.ceil((double)array[2]/2);
    	   }
       }
      
       System.out.println(result);

       
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


