
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Token_ring {
 
    public static void main(String[] args) {
         try {
             try (FileWriter myWriter = new FileWriter("sonuc.txt")) {
                 Scanner scan = new Scanner(System.in);
                 long startTime=0, endTime=0;
                 System.out.println("Düğüm sayısını girin:");
                 int n = scan.nextInt();
                 int m = n - 1;
                 myWriter.write("Düğüm Sayısı: "+m+" \n");
                 int token = 0;
                 int ch = 0, flag = 0;
                 for (int i = 0; i < n; i++) {
                     System.out.print(" " + i);
                 }        System.out.println(" " + 0);
                 do{
                     System.out.println("Gönderen Düğümü Giriniz:");
                     int s = scan.nextInt();
                     System.out.println("Alıcı Düğümü Giriniz:");
                     int r = scan.nextInt();
                     System.out.println("Göndermek İstediğiniz Veriyi Giriniz:");
                     int a;
                     a = scan.nextInt();
                     System.out.print("Jeton Oluşturuldu:");
                     
                     for (int i = token, j = token; (i % n) != s; i++, j = (j + 1) % n) {
                         
                         System.out.print(" " + j + "->");
                         
                     }
                     System.out.println(" " + s);
                     startTime = System.nanoTime();
                     System.out.println("Gönderen " + s + " veri gönderme: " + a);
                     for (int i = s + 1; i != r; i = (i + 1) % n) {
                         
                         System.out.println("Veri  " + a + " tarafından iletildi " + i);
                         
                         endTime = System.nanoTime();
                     }
                     System.out.println("Alıcı " + r + " alınan veri: " + a +"\n");
                     token = s;
                     System.out.println("Tekrar göndermek ister misin? Evet için 1 ve Hayır için 0 girin: ");
                     
                     long estimatedTime = endTime - startTime;
                     double seconds = (double)estimatedTime/1000000000; // saniyeye çevirmek için milyar'a bölüyoruz.
                     System.out.println("Çalışma Süresi: "+seconds);
                     //Program çıktılarını "sonuc.txt" dosyasına ekledim.
                     myWriter.write("Gönderen Düğüm: "+s+" "+"Alıcı Düğüm: "+r+" "+"Gönderilen Veri: "+a+" "+"Gönderme Süresi: "+seconds+" \n" );
                     do{
                         try {
                             if( flag == 1)
                                 System.out.print("Geçersiz Giriş!!...");
                             
                             ch = scan.nextInt();
                             if( ch != 1 && ch != 0 )
                                 flag = 1;
                             else
                                 flag = 0;
                         } catch (InputMismatchException e){
                             System.out.println("Geçersiz Giriş");
                         }
                     }while( ch != 1 && ch != 0 );
                 }while( ch == 1 );
             }
      System.out.println("Dosyaya başarıyla yazıldı.");
    } catch (IOException e) {
      System.out.println("Bir hata oluştu.");
    }
    }  
}
