
import java.util.Scanner;
public class Main{
    
    public static void main(String[] args){
        int size;
        Scanner scanner = new Scanner( System.in );
        System.out.print( "Bonjour, veuillez saisir la taille du tableau : " );
        size = scanner.nextInt();
        triTab t1 = new triTab(size);
        triTab t2 = new triTab(t1);
        triTab t3 = new triTab(t2);
        triTab t4 = new triTab(t3);
        triTab t5 = new triTab(t4);
        System.out.println();
        /*
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t5);
        */
        
        
        //System.out.println(t1);
        long start1 = System.currentTimeMillis();
        t1.triBulleV1();
        long end1 = System.currentTimeMillis();
        long execution1 = end1 - start1;
        //System.out.println ("\nSuite au tri : ");
        //System.out.println(t1);
        System.out.println ("Temps de traitement avec le tri à bulles V1 : "+execution1+ " ms" );
        
        
        //System.out.println(t2);
        long start2 = System.currentTimeMillis();
        t2.triBulleV2();
        long end2 = System.currentTimeMillis();
        long execution2 = end2 - start2;
        //System.out.println ("\nSuite au tri : ");
        //System.out.println(t2);
        System.out.println ("Temps de traitement avec le tri à bulles V2 : "+execution2+ " ms" );
        
        
        
        //System.out.println(t3);
        long start3 = System.currentTimeMillis();
        t3.triSelection();
        long end3 = System.currentTimeMillis();
        long execution3 = end3 - start3;
        //System.out.println ("\nSuite au tri : ");
        //System.out.println(t3);
        System.out.println ("Temps de traitement avec le tri par selection : "+execution3+ " ms" );
        
        
        
        
        //System.out.println(t4);
        long start4 = System.currentTimeMillis();
        t4.triRapide(0,t4.getTaille());
        long end4 = System.currentTimeMillis();
        long execution4 = end4 - start4;
        //System.out.println ("\nSuite au tri : ");
        //System.out.println(t4);
        System.out.println ("Temps de traitement avec le tri Rapide : "+execution4+ " ms" );
        
        
        
        //System.out.println(t5);
        long start5 = System.currentTimeMillis();
        t5.triDenombrement();
        long end5 = System.currentTimeMillis();
        long execution5 = end5 - start5;
        //System.out.println ("\nSuite au tri : ");
        //System.out.println(t5);
        System.out.println ("Temps de traitement avec le tri par dénombrement : "+execution5+ " ms" );
        

        //Fonctions de recherche :
        //System.out.println(t.t[0].getCle()+" "+t.rechDichotRec(t.t[0].getCle(),0, t.getTaille()));
        //System.out.println(t.getElem(2));
        //System.out.println(t.getElem(t.t[0].getCle()));
        //System.out.println(t.rechNaive(t.t[0].getCle()));
        //System.out.println(t.rechDichot(t.t[0].getCle()));
        //System.out.println(t.rechDichot(99));
        //System.out.println(t.t[0].getCle()+" "+t.rechDichotRec(t.t[0].getCle(),0, t.getTaille()));
        

    }


}