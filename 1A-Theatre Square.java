import java.util.Scanner;

/**
 * Problem Link = http://codeforces.com/problemset/problem/1/A
 * @author YektaAnıl
 */
 
public class Main {
    

public static void main(String arg[]) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextInt();
    long m = sc.nextInt();
    long a = sc.nextInt();
    long result = (long)(((m+a-1)/a)*((n+a-1)/a));
    System.out.println(result);
    
 }
}
