
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int balance = 5000;// Bakiye
        int select;// Seçim
        int right = 3;//Deneme Hakkı
        String userName;
        String password;


        String[] Colors = {"\u001B[35m", "\u001B[30m", "\u001B[31m", "\u001B[32m", "\u001B[33m", "\u001B[34m", "\u001B[35m", "\u001B[36m", "\u001B[37m"};
        Random random = new Random();
        int color = random.nextInt(9);


        while (right > 0) {
            System.out.print("Kullanıcı Adınız :");
            userName = scanner.nextLine();
            System.out.print("Parolanız : ");
            password = scanner.nextLine();

            if (userName.equals("admin") && password.equals("123")) {
                System.out.println("Merhaba " + userName + ", Javaloper Banka Hoş Geldiniz...");
                do {

                    System.out.println(Colors[color] + "1-Para yatırma\n" + "2-Para Çekme\n" + "3-Bakiye Sorgula\n" + "4-Çıkış Yap");
                    System.out.print("Lütfen yapmak istediğiniz işlemi seçiniz : ");
                    select = scanner.nextInt();
                    if (select == 1) {
                        System.out.print("Para miktarı : ");
                        int price = scanner.nextInt();
                        balance += price;
                        System.out.print("Bakiyeniz: " + balance + "₺\n");
                        color = random.nextInt(9);
                    } else if (select == 2) {
                        System.out.print("Para miktarı : ");
                        int price = scanner.nextInt();
                        if (price > balance) {
                            System.out.println("Bakiye yetersiz.");
                            System.out.print("Bakiyeniz: " + balance + "₺\n");
                            color = random.nextInt(9);
                        } else {
                            balance -= price;
                            System.out.print("Bakiyeniz: " + balance + "₺\n");
                            color = random.nextInt(9);
                        }
                    } else if (select == 3) {
                        System.out.println("Bakiyeniz : " + balance + "₺");
                        color = random.nextInt(9);
                    }
                } while (select != 4);
                System.out.println("Tekrar görüşmek üzere.");
                break;
            } else {
                right--;
                System.out.println("Kullanıcı adı veya şifre yalnış. Tekrar deneyiniz.");
                if (right == 0) {
                    System.out.println("Hesabınız bloke olmuştur lütfen banka ile iletişime geçiniz.");
                } else {
                    System.out.println("Kalan Hakkınız : " + right);
                }
            }
        }
    }
}