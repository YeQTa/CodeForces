import java.io.*;
import java.util.*;

/*
  Problem Link : http://codeforces.com/problemset/problem/339/A
*/

public class _339A_HelpfulMaths {
	static FastReader in;
	static PrintWriter out;
	
	public static void Solve(){
			String str = in.next();
			int array[] = new int[4];
			
			for(int i = 0;i<str.length();i+=2){
				if(str.charAt(i)=='1'){
					array[1]++;
				}
				else if(str.charAt(i)=='2'){
					array[2]++;
				}
				else
					array[3]++;
					
			}
			StringBuilder result = new StringBuilder(str);
			int index=0;
			//setting 1's
			for(int i = 0;i<array[1];i++){
				result.setCharAt(index, '1');
				index+=2;
			}
			
			//setting 2's
			for(int i = 0;i<array[2];i++){
				result.setCharAt(index, '2');
				index+=2;
			}
			
			//setting 3's
			for(int i = 0;i<array[3];i++){
				result.setCharAt(index, '3');
				index+=2;
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


