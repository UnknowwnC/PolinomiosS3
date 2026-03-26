/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Me and Gepetirri
 */
package alg.pkg3;

public class Nodo {

    private int Coe, Exp;
    private Nodo liga;

    public Nodo(int Coe, int Exp, Nodo liga) {
        this.Coe = Coe;
        this.Exp = Exp;
        this.liga = liga;
    }

    public Nodo(int Coe, int Exp) {
        this.Coe = Coe;
        this.Exp = Exp;
        this.liga = null;
    }

    public int getCoe() {
        return Coe;
    }

    public void setCoe(int Coe) {
        this.Coe = Coe;
    }

    public int getExp() {
        return Exp;
    }

    public void setExp(int Exp) {
        this.Exp = Exp;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }
}
