import java.util.Scanner;

/**
 * Problem Link = http://codeforces.com/problemset/problem/71/A
 * @author YektaAnıl
 */
public class _71A_WayTooLongWords {


public static void main(String arg[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    while(n-->=0){
        String s = sc.nextLine();
        if(s.length()>10){
            System.out.println(s.charAt(0)+""+(s.length()-2)+""+s.charAt(s.length()-1));
        }
        else
            System.out.println(s);
    }
 }
}
