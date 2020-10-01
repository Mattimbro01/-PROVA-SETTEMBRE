/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orariprof;

/**
 *
 * @author imbrosciano_mattia
 */
public class TrovaClassi extends Thread {

    public TrovaClassi(DatiCondiviisi dati, int numeroTh) {
        this.dati = dati;
        this.numeroTh = numeroTh;
    }

    @Override
    public void run() {
        String[] Orario = dati.getOrari(0);
        String[] OrarioProf = dati.getOrari(numeroTh);
        String classeTrovare = dati.getClassePAssata();
        String Trovati = ",";
        String Ora = ",";
        int k = 0;
        int giorno=0;
        boolean trovato = false;
        for (int i = 0; i < 35; i++) {
            if(i % 6 ==0)
                giorno++;
            if (classeTrovare.equals(OrarioProf[i])) {
                trovato = true;
                if (trovato = true) {
                    if (k == 0) {
                        Trovati += OrarioProf[0] + ",";
                         k++;
                    }
                    Trovati += OrarioProf[i] + ",";
                    Ora += "Giorno"+giorno+" "+Orario[i] + ",";
                }

            }
        }
        dati.pushProf(Trovati);
        dati.pushOrari(Ora);
    }
    DatiCondiviisi dati;
    int numeroTh;
}
