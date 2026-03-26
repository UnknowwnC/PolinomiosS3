package alg.pkg3;

import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Castano and Gepetirri
 */
public class Forma3 {

//atributos
    private Nodo Punta;

//metodos 
    public Forma3() {
        this.Punta = null;
    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo Punta) {
        this.Punta = Punta;
    }

    public void LlenarPoli3(String Vs[]) {

        int i = 0;

        while (i < Vs.length && Vs[i] != null && !Vs[i].isEmpty() && Vs[i + 1] != null && !Vs[i + 1].isEmpty()) {

            int coe = Integer.parseInt(Vs[i]);
            int exp = Integer.parseInt(Vs[i + 1]);

            insertar3(coe, exp);

            i += 2;
        }
    }

    public void insertar3(int coe, int exp) {

        Nodo x = new Nodo(coe, exp);

        if (Punta == null || exp > Punta.getExp()) {
            x.setLiga(Punta);
            Punta = x;
            return;
        }

        Nodo p = Punta;
        Nodo ant = null;

        while (p != null && p.getExp() > exp) {
            ant = p;
            p = p.getLiga();
        }

        // si ya existe ese exponente
        if (p != null && p.getExp() == exp) {
            p.setCoe(p.getCoe() + coe);
            return;
        }

        x.setLiga(p);
        ant.setLiga(x);
    }

    public void Mostrar() {

        Nodo p = Punta;
        String salida = "";

        if (p == null) {
            JOptionPane.showMessageDialog(null, "El polinomio estÃ¡ vacio");
        }

        while (p != null) {

            salida = salida + "||" + p.getCoe() + "|" + p.getExp() + "||  " + " --> ";

            p = p.getLiga();
        }

        JOptionPane.showMessageDialog(null, salida + "nulo :> ");
    }

    public void Eliminar3(int exp) {

        if (Punta == null) {
            JOptionPane.showMessageDialog(null, "El polinomio esta vacio");
            return;
        }

        Nodo p = Punta;
        Nodo ant = null;

        while (p != null && p.getExp() != exp) {
            ant = p;
            p = p.getLiga();
        }

        if (p == null) {
            JOptionPane.showMessageDialog(null, "No existe ese exponente");
            return;
        }

        // si es el primer nodo
        if (ant == null) {
            Punta = Punta.getLiga();
        } else {
            ant.setLiga(p.getLiga());
        }

        JOptionPane.showMessageDialog(null, "Termino eliminado");
    }

    public double Evaluar3(double c) {

        Nodo p = Punta;
        double resultado = 0;

        while (p != null) {

            int coe = p.getCoe();
            int exp = p.getExp();

            resultado += coe * Math.pow(c, exp);

            p = p.getLiga();
        }
        return resultado;

    }

    public void Reconstruir3() {

        Nodo p = Punta;
        String poli = "";

        while (p != null) {

            poli += p.getCoe() + "x^" + p.getExp();

            if (p.getLiga() != null) {
                poli += " + ";
            }

            p = p.getLiga();
        }
        JOptionPane.showMessageDialog(null, poli);
        System.out.println(poli);
    }

    public void sumar(Forma3 otro) {
        Nodo p = otro.getPunta();

        while (p != null) {
            insertar3(p.getCoe(), p.getExp());
            p = p.getLiga();
        }
        JOptionPane.showMessageDialog(null, "Suma realizada correctamente");

    }

    public void multiplicar(Forma3 mult, Forma3 resultado) {
        Nodo p = this.getPunta();

        while (p != null) {
            Nodo q = mult.getPunta();
            while (q != null) {
                int mul = p.getCoe() * q.getCoe();
                int sum = p.getExp() + q.getExp();

                resultado.insertar3(mul, sum);
                q = q.getLiga();
            }
            p = p.getLiga();

        }

        JOptionPane.showMessageDialog(null, "multiplicacion realizada correctamente");

    }

    public void multiplicar(Forma1 F1, Forma2 F33) {
        int grado1 = F1.getVPF1(0);

        for (int i = 1; i < grado1 + 1; i++) {
            for (int j = 1; j < F33.getVPF2().length; j += 2) {
                int Acoe = F1.getVPF1(i);
                int Aexp = grado1 - (i - 1);
                int Bcoe = F33.getVPF2(j);
                int Bexp = F33.getVPF2(j + 1);

                int Nexp = Aexp + Bexp;
                int Ncoe = Acoe * Bcoe;

                this.insertar3(Ncoe, Nexp);
            }

        }
    }

}
