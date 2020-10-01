/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orariprof;

import java.util.ArrayList;

/**
 *
 * @author imbrosciano_mattia
 */
public class DatiCondiviisi {

    public DatiCondiviisi(ArrayList<String[]> elencoOrari, String classe) {
        this.elencoOrari = elencoOrari;
        this.classePAssata = classe;
        OrariTrovati = new ArrayList<String>();
        OrariTrovatiProf=new ArrayList<String>();
        ArrayList<String> OrariTrovati0 = new ArrayList<String>();;
    }

    public String[] getOrari(int i) {
        return elencoOrari.get(i);
    }

    public String getClassePAssata() {
        return classePAssata;
    }

    public synchronized void pushProf(String str) {
        OrariTrovatiProf.add(str);
    }

    public synchronized void pushOrari(String str) {
        OrariTrovati.add(str);
    }

    public ArrayList<String[]> getElencoOrari() {
        return elencoOrari;
    }

    public ArrayList<String> getOrariTrovatiProf() {
        return OrariTrovatiProf;
    }

    public ArrayList<String> getOrariTrovati() {
        return OrariTrovati;
    }
    public void  VisuliazzaOrarioTrovato(){
       
        for (int i = 0; i < OrariTrovatiProf.size(); i++) {
            if(!OrariTrovatiProf.get(i).equals(",")){
             System.out.println(OrariTrovati.get(i));
             System.out.println(OrariTrovatiProf.get(i));
            }
        }
    }
    private ArrayList<String[]> elencoOrari;
    private String classePAssata;
    private ArrayList<String> OrariTrovatiProf;

    private ArrayList<String> OrariTrovati;

}
