package number_guessing;
import java.util.Scanner;
public class Projectgeekforgeek {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int num = 1 + (int)(100* Math.random());
        
        int k = 5;
        int guess;
        System.out.println(10 / 3);
        System.out.println("--Tro choi doan so--");
        System.out.println("Ban co "+k+" lan doan!");
        for(int i = k - 1; i>=0; i--){
            System.out.print("Nhap so cua ban :");
            guess = sc.nextInt();
            sc.nextLine();
            if(guess==num){
                System.out.println("Chuc mung! ban da doan trung so!");
                break;
            }else if(guess > num){
                System.out.println("OPPS! Sai roi. So ban doan lon hon so can tim!");
                System.out.println("Ba con "+ i +" luot thoi!");
            }else if (guess < num){
                System.out.println("OPPS! Sai roi. So ban doan nho hon so can tim!");
                System.out.println("Ba con "+ i +" luot thoi!");
            }
            if(i == 0){
                System.out.println("OPPS! Ban da thua!");
                break;
            }
        }
    }
}
