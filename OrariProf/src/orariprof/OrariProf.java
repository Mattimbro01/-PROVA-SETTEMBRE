/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orariprof;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author imbrosciano_mattia
 */
/**
 * Analisi
 * Grado Parallelismo: 1+7 thread(Main +TrovaClasse)
 * La funziona dei thrhead è cercare una classe in un orario di un prof e metterlo dentro a un vettore
 * Main interragisce con l'utente
 * Dati condivisi:-elencoOrari:matrice che contiene tutti gli orari dei prof.
 * -classePAssata: classe passata dal utente da cercare
 * -OrariTrovatiProf orari dei prof  trovati 
 * -OrariTrovati ore trovate dove ce la classe
 * Mutua escusione:Si quando si aggiunge un elento nuovo nel array OrariTrovatiProf,OrariTrovati
 */
public class OrariProf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        String ora = "ORA,1^,2^,3^,4^,5^,6^,1^,2^,3^,4^,5^,6^,1^,2^,3^,4^,5^,6^,1^,2^,3^,4^,5^,6^,1^,2^,3^,4^,5^,6^,1^,2^,3^,4^,5^,tot ore";
        String Agostini = "AGOSTONI G.,2BI,2CI LFS,1AI LFS,.,.,.,2CI,1AI,1BI LFS,2AI,.,.,-,-,-,-,-,-,1BI,2BI LFS,1CI LFS,.,2AI,.,1CI,2CI,1AI,.,2AI LFS,.,1CI,1BI,2BI,.,.,18";
        String Ali = "ALI' M.,3AL,4BS,.,4AL,5AS,.,5AL,5BL,.,4BL,3AS,.,-,-,-,-,-,-,4BS,3BS,3AL,4BL,.,.,.,.,4AL,3BS,4AS,.,3AS,5BL,5AL,5AS,4AS,20";
        String Aliprandi = "ALIPRANDI S.,4AM LI5,4AM LI5,4BE,.,3EE,.,.,.,5AM LSM,5AM LSM,3EE LSM,3EE LSM,-,-,-,-,-,-,.,.,.,4BE LSM,4BE LSM,4AM,4AM,5AM LSM,.,4BE,5BM LSM,.,.,.,5BM LSM,5BM LSM,3EE,18";
        String Andreaachi = "ANDREACCHI S.,5AI LI6,1CI LI4,4BI LI7,5BI LI7,.,.,3BI LI7,3BI LI7,5BI LI7,4CI LI7,4CI LI7,.,5AI LI6,5AI LI6,.,4BI LI7,4BI LI7,.,.,5BI LI7,5BI LI7,.,.,.,.,.,1CI LI4,3BI LI7,4CI LI7,.,-,-,-,-,-,18";
        String Asta = "ANDREACCHI S.,5AI LI6,1CI LI4,4BI LI7,5BI LI7,.,.,3BI LI7,3BI LI7,5BI LI7,4CI LI7,4CI LI7,.,5AI LI6,5AI LI6,.,4BI LI7,4BI LI7,.,.,5BI LI7,5BI LI7,.,.,.,.,.,1CI LI4,3BI LI7,4CI LI7,.,-,-,-,-,-,18";
        String Ballabio = "BALLABIO M.L.,5D,2B,1D,.,5AI,.,.,.,2B,5AI,2C,5D,.,.,1D,5D,2C,.,,,,,,,.,5AI,1D,2C,2B,.,-,-,-,-,-,15";
        String Bardi = "BARDI P.,.,.,1BM LI4,5AI LI6,1CM LI4,.,-,-,-,-,-,-,1AM LI4,.,1CM LI4,.,.,.,5AI LI6,5AI LI6,1BM LI4,.,1AM LI4,.,1AC LI2,1AC LI2,1BC LI2,1BC LI2,.,.,5AI LI6,5AI LI6,4AI LI6,4AI LI6,3AI LI6,18";
        ArrayList<String[]> elencoOrari = new ArrayList<String[]>();
        elencoOrari.add(ora.split(","));
        elencoOrari.add(Agostini.split(","));
        elencoOrari.add(Ali.split(","));
        elencoOrari.add(Aliprandi.split(","));
        elencoOrari.add(Andreaachi.split(","));
        elencoOrari.add(Asta.split(","));
        elencoOrari.add(Ballabio.split(","));
        elencoOrari.add(Bardi.split(","));
        System.out.println("Inserisci nome classe");
        String classe = scanner.nextLine();
        DatiCondiviisi dati = new DatiCondiviisi(elencoOrari, classe);
        TrovaClassi prof1 = new TrovaClassi(dati, 1);
        TrovaClassi prof2 = new TrovaClassi(dati, 2);
        TrovaClassi prof3 = new TrovaClassi(dati, 3);
        TrovaClassi prof4 = new TrovaClassi(dati, 4);
        TrovaClassi prof5 = new TrovaClassi(dati, 5);
        TrovaClassi prof6 = new TrovaClassi(dati, 6);
        TrovaClassi prof7 = new TrovaClassi(dati, 7);

        prof1.start();
        prof2.start();
        prof3.start();
        prof4.start();
        prof5.start();
        prof6.start();
        prof7.start();

        prof1.join();
        prof2.join();
        prof3.join();
        prof4.join();
        prof5.join();
        prof6.join();
        prof7.join();
        ArrayList<String> orari= dati.getOrariTrovati();
        System.out.println(ora);
        dati.VisuliazzaOrarioTrovato();

    }
}
