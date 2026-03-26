package alg.pkg3;

import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Castano and Gepetirri
 */
public class Forma2 {

    //Atributos
    private int Du, VPF2[];

    //metodos
    public Forma2(int Terminos) {
        this.Du = Terminos * 2;
        this.VPF2 = new int[Du + 1];
        VPF2[0] = Terminos;
    }

    public int getDu() {
        return Du;
    }

    public void setDu(int Du) {
        this.Du = Du;
    }

    public int[] getVPF2() {
        return VPF2;
    }

    public void setVPF2(int[] VPF2) {
        this.VPF2 = VPF2;
    }

    public int getVPF2(int i) {
        return VPF2[i];
    }

    public void setVPF2(int d, int i) {
        this.VPF2[i] = d;
    }

    public void LlenarPoli2(String Vs[]) {

        // Contar datos validos
        int contador = 0;
        for (int i = 0; i < Vs.length; i++) {
            if (Vs[i] != null && !Vs[i].isEmpty()) {
                contador++;
            }
        }

        int n = contador / 2; // numero de terminos reales

        int coef[] = new int[n];
        int expo[] = new int[n];

        // Separar coeficientes y exponentes
        int j = 0;
        for (int i = 0; i < Vs.length && j < n; i += 2) {
            if (Vs[i] != null && !Vs[i].isEmpty() && Vs[i + 1] != null && !Vs[i + 1].isEmpty()) {
                coef[j] = Integer.parseInt(Vs[i]);
                expo[j] = Integer.parseInt(Vs[i + 1]);
                j++;
            }
        }

        // Ordenar de mayor a menor por exponente
        for (int i = 0; i < n - 1; i++) {
            for (int k = i + 1; k < n; k++) {

                if (expo[i] < expo[k]) {

                    int auxExp = expo[i];
                    expo[i] = expo[k];
                    expo[k] = auxExp;

                    int auxCoef = coef[i];
                    coef[i] = coef[k];
                    coef[k] = auxCoef;
                }
            }
        }

        // Crear VPF2 SOLO con terminos reales
        VPF2 = new int[n * 2 + 1];

        VPF2[0] = n; // numero de terminos reales

        int pos = 1;

        for (int i = 0; i < n; i++) {
            VPF2[pos] = coef[i];
            VPF2[pos + 1] = expo[i];
            pos += 2;
        }
    }

    //Mostrar polinomio en forma 2
    public void MostrarPoli2() {
        String msj = " ";
        for (int i = 0; i < VPF2.length; i++) {
            msj += "|" + VPF2[i] + "|";
            System.out.println(VPF2[i] + " ");
        }

        JOptionPane.showMessageDialog(null, msj);

    }

    public void Reconstruir2(String Vs[]) {
        String poli = "";

        for (int i = 0; i < Vs.length - 1 && Vs[i] != null && Vs[i + 1] != null; i += 2) {
            int coe = Integer.parseInt(Vs[i]);
            int exp = Integer.parseInt(Vs[i + 1]);

            if (coe != 0) {
                if (!poli.equals("") && coe > 0) {
                    poli += "+";
                }
                if (exp == 0) {
                    poli += coe;
                } else if (exp == 1) {
                    if (coe == 1) {
                        poli += "x";
                    } else if (coe == -1) {
                        poli += "-x";
                    } else {
                        poli += coe + "x";
                    }
                } else {
                    if (coe == 1) {
                        poli += "x^" + exp;
                    } else if (coe == -1) {
                        poli += "-x^" + exp;
                    } else {
                        poli += coe + "x^" + exp;
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Polinomio: " + poli);
    }

    public String insertar2(int e2, int c2) {

        if (VPF2 == null) {
            return "Polinomio no creado";
        }

        if (e2 < 0) {
            JOptionPane.showMessageDialog(null, "Exponente no puede ser negativo");
            return "No insertado";
        }

        int n = VPF2[0];

        // Si el exponente ya existe solo suma el coeficiente
        for (int i = 1; i < VPF2.length; i += 2) {
            if (VPF2[i + 1] == e2) {
                VPF2[i] += c2;
                return "Ha sido insertado de manera exitosa";
            }
        }

        // Si no existe crear nuevo vector
        int nuevo[] = new int[VPF2.length + 2];
        nuevo[0] = n + 1;

        int j = 1;
        boolean insertado = false;

        for (int i = 1; i < VPF2.length; i += 2) {

            if (!insertado && e2 > VPF2[i + 1]) {
                nuevo[j] = c2;
                nuevo[j + 1] = e2;
                j += 2;
                insertado = true;
            }

            nuevo[j] = VPF2[i];
            nuevo[j + 1] = VPF2[i + 1];
            j += 2;
        }

        if (!insertado) {
            nuevo[j] = c2;
            nuevo[j + 1] = e2;
        }

        VPF2 = nuevo;

        return "Ha sido insertado de manera exitosa";
    }

    public void eliminar2(int c, String Vs[]) {
        int coef = VPF2[0];
        int Tam = (coef * 2) + 1;

        int[] aux = new int[Tam - 2];
        int j = 0;
        for (int i = 1; i < VPF2.length; i += 2) {
            if (VPF2[i] == c) {
            } else {
                aux[j] = VPF2[i];
                aux[j + 1] = VPF2[i + 1];

                j += 2;
            }

        }
        aux[0] = VPF2[0] - 1;
        VPF2 = aux;

        JOptionPane.showMessageDialog(null, "Se ah eliminado correctamente");

    }

    public double evaluar2(double x) {
        int coe = VPF2[0];
        double resultado = 0;

        for (int i = 1; i < VPF2.length; i += 2) {
            int coef = VPF2[i];
            int exp = VPF2[i + 1];

            double pot = 1;
            for (int j = 0; j < exp; j++) {
                pot = pot * x;
            }
            resultado += coef * pot;

        }
        return resultado;

    }

    public void Sumar2(Forma2 F2b) {
        int coef = VPF2[0];
        int coef2 = F2b.getVPF2(0);
        int Atam = (coef * 2) + 1;
        int Btam = (coef2 * 2) + 1;

        for (int j = 1; j < Btam; j += 2) {
            int Bcoef = F2b.getVPF2(j);
            int Bexp = F2b.getVPF2(j + 1);
            this.insertar2(Bexp, Bcoef); // " <- 🖕🏼"
        }
    }

    public Forma2 Multiplicar2(Forma2 F2c) {
        int Acoef = VPF2[0];
        int Bcoef = F2c.getVPF2(0);
        int maxCoef = Acoef * Bcoef;

        Forma2 resultado = new Forma2(0);

        for (int i = 1; i < VPF2.length; i += 2) {
            for (int j = 1; j < F2c.getVPF2().length; j += 2) {
                int coe = VPF2[i] * F2c.getVPF2(j);
                int exp = VPF2[i + 1] + F2c.getVPF2(j + 1);
                resultado.insertar2(exp, coe);

            }

        }

        return resultado;

    }

    public void Multiplicarf1f3(Forma1 f1, Forma3 f3) {
        int grado = f1.getVPF1(0);

        for (int i = 1; i < grado + 2; i++) {

            int Acoef = f1.getVPF1(i);
            int Aexp = grado - (i - 1);

            Nodo p = f3.getPunta();
            while (p != null) {
                int Bcoef = p.getCoe();
                int Bexp = p.getExp();

                p = p.getLiga();

                int Nexp = Aexp + Bexp;
                int Ncoef = Acoef * Bcoef;

                this.insertar2(Nexp, Ncoef);

            }
        }

    }

}
