import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BizimLL myLinkedList = new BizimLL();
        String devam = "e";
        Scanner sc=new Scanner(System.in);
        while(devam.equals("e")){
            System.out.println("eklemek istediğiniz sayıyı girin");
            int eklenecek = sc.nextInt();
            Scanner sc_2 = new Scanner(System.in);
            System.out.println("eklemek yapmak istediğiniz metodu seçiniz:");

            Scanner sc_indeks = new Scanner(System.in);
            System.out.println("indeks:");
            int indeks = sc_indeks.nextInt();

            String metot_tercihi = sc_2.next();
            if(metot_tercihi.equals("baş")){
                myLinkedList.basaEkle(eklenecek);
            }
            else if(metot_tercihi.equals("orta")){
                myLinkedList.ortayaEkle(eklenecek,indeks);
            }
            else if(metot_tercihi.equals("son")){
                myLinkedList.sonaEkle(eklenecek);
            }
            Scanner sc_3 = new Scanner(System.in);
            System.out.println("devam etmek istiyor musunuz:");
            devam = sc_3.next();
        }
        myLinkedList.listeyiyazdir();

    }

}
class Eleman {
    int sayi;
    Eleman siradaki;
    public Eleman(int sayi){
    this.sayi = sayi;
    this.siradaki = null;
    }
}
class BizimLL {

    Eleman bas;
    Eleman son;

    public BizimLL(){
        bas = null;

    }
    public void basaEkle( int sayi ){
        Eleman yeniEleman = new Eleman( sayi);
        if(doluMu()){
            yeniEleman.siradaki = bas;
            bas = yeniEleman;
        }
        else{
            bas = yeniEleman;
            son = yeniEleman;
        }
    }
    public void ortayaEkle( int sayi, int indeks){
            Eleman yeniEleman = new Eleman( sayi);
            if(doluMu()){
                if(indeks == 0 ){
                    yeniEleman.siradaki = bas;
                    bas = yeniEleman;
                }
                else{
                    Eleman current0 = null;
                    Eleman current1 = bas;
                    int currentindeks = 0;

                    while ( current1 != null && currentindeks < indeks){
                        current0 = current1;
                        currentindeks ++;
                    }
                    if (current1 == null){
                        son.siradaki = yeniEleman;
                        son = yeniEleman;
                    }
                    else{
                        yeniEleman.siradaki = current1;
                        current0.siradaki = yeniEleman;
                    }
                }
            }
            else{
                bas = yeniEleman;
                son = yeniEleman;
            }
        }
        public void sonaEkle( int sayi ){
            Eleman yeniEleman = new Eleman( sayi);
            if(doluMu()){
                son.siradaki = yeniEleman;
                son = yeniEleman;
            }
            else{
                bas = yeniEleman;
                son = yeniEleman;
            }


        }

        public boolean doluMu() {
            if (bas != null) {
                return false;
            } else {
                return false;
            }

        }
        public void listeyiyazdir(){
            Eleman current = bas;
            int elemansayisi = 0;
            while ( current != null ){
                System.out.print( current.sayi + " ");
                current= current.siradaki;
                elemansayisi++;

            }
            System.out.println("Eleman sayısı" + elemansayisi);
        }
    }

