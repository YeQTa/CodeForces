import java.util.Scanner;

/* Problem Link =  http://codeforces.com/problemset/problem/118/A    */

public class _118A_StringTask {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next().toLowerCase();
		String result="";
		
		for(int i = 0;i<str.length();i++){
			if(str.charAt(i)!='a' && str.charAt(i)!='o' && str.charAt(i)!='y' && str.charAt(i)!='e'
 && str.charAt(i)!='u'  && str.charAt(i)!='i'){
				result+="."+str.charAt(i);
			}
		}
		System.out.println(result);
		sc.close();
	}

}
