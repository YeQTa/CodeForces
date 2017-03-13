import java.util.Scanner;

/**
 * Problem Link = http://codeforces.com/problemset/problem/4/A
 * @author YektaAnıl
 */
public class Main {

public static void main(String arg[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    if(n==2)
        System.out.println("NO");
    else
        System.out.println(n%2==0?"YES":"NO");
    
 }
}
