import java.util.Scanner;

/**
 * Problem Link = http://codeforces.com/problemset/problem/158/A
 * @author YektaAnıl
 */
public class Main {


public static void main(String arg[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int k = sc.nextInt();
    int result = 0;
    int array[] = new int[n+1];
    boolean allzero=true;
    for(int i = 1;i<=n;i++){
        array[i] = sc.nextInt();
        if(array[i]!=0 && allzero)
            allzero=false;
        
        if(i>k && array[i]!=0 && array[i]==array[k]){
           result++;
        }
        else if(i<=k && array[i]!=0){
            result++;
        }
        else if(array[i]==0){
            break;
        }

    }
    if(allzero)
        System.out.println("0");
    else
        System.out.println(result);
 }
}
