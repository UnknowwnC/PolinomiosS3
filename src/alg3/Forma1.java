package alg.pkg3;

import javax.swing.JOptionPane;

/**
 *
 * @author Carlos Castano and Gepetirri//8x^2-3x^5+2x-10
 */
public class Forma1 {

    //atributos
    private int Du, VPF1[];

    //constructor
    public Forma1(int Grado) {
        Du = Grado + 1;
        VPF1 = new int[Du + 1];
        VPF1[0] = Grado;
    }

    public int getDu() {
        return Du;
    }

    public void setDu(int du) {
        this.Du = du;
    }

    public int[] getVPF1() {
        return VPF1;
    }

    public void setVPF1(int[] VPF1) {
        this.VPF1 = VPF1;
    }

    public int getVPF1(int i) {
        return VPF1[i];
    }

    public void setVPF1(int d, int i) {
        this.VPF1[i] = d;
    }

    // Llenar el polinomio(Gepetirri intervino)
    // Estructura: VPF1[0]=grado, VPF1[1]=coef grado mayor, ..., VPF1[grado+1]=término independiente
    public void LlenarPoli(String Vs[]) {
        int mayorExp = 0;

        // Encontrar el mayor exponente
        for (int i = 1; i < Vs.length && Vs[i] != null; i += 2) {
            int exp = Integer.parseInt(Vs[i]);
            if (exp > mayorExp) {
                mayorExp = exp;
            }
        }

        // Tamaño = grado + 2: índice 0 guarda el grado, índices 1..(grado+1) guardan coeficientes
        VPF1 = new int[mayorExp + 2];
        VPF1[0] = mayorExp;
        Du = mayorExp + 1;

        // Vs estructura: [coe0, exp0, coe1, exp1, ...]
        for (int i = 0; i < Vs.length - 1 && Vs[i] != null && Vs[i + 1] != null; i += 2) {
            int coe = Integer.parseInt(Vs[i]);
            int exp = Integer.parseInt(Vs[i + 1]);
            // posición en el vector: exponente más alto → índice 1, independiente → índice grado+1
            int posi = mayorExp - exp + 1;
            VPF1[posi] = coe;
        }
    }

    // Insertar termino
    public String insertar(int c, int e) {
        if (e < 0) {
            JOptionPane.showMessageDialog(null, "Exponente no puede ser negativo");
            return "Exponente inválido";
        }

        int Grado = VPF1[0];

        if (e > Grado) {
            int nuevoGrado = e;
            // Tamaño = nuevoGrado + 2
            int[] VPF1Nuevo = new int[nuevoGrado + 2];
            VPF1Nuevo[0] = nuevoGrado;

            for (int i = 1; i <= Grado + 1; i++) {
                int expViejo = Grado - (i - 1);
                int posiNueva = nuevoGrado - expViejo + 1;
                VPF1Nuevo[posiNueva] = VPF1[i];
            }

            VPF1 = VPF1Nuevo;
            Grado = nuevoGrado;
            Du = nuevoGrado + 1;

        }

        int posi = Grado - e + 1;
        VPF1[posi] += c;
        return "Registro insertado";
    }

    // Mostrar el polinomio
    public void Mostrar() {
        int grado = VPF1[0];

        // Buscar el exponente más alto con coeficiente distinto de cero
        int nuevoGrado = 0;
        for (int i = 1; i <= grado + 1; i++) {
            if (VPF1[i] != 0) {
                nuevoGrado = grado - (i - 1);
                break;
            }
        }

        // Ajustar el vector al nuevo grado real
        int[] VPF1Nuevo = new int[nuevoGrado + 2];
        VPF1Nuevo[0] = nuevoGrado;
        for (int j = 1; j <= nuevoGrado + 1; j++) {
            int posi = grado - nuevoGrado + j;
            VPF1Nuevo[j] = VPF1[posi];
        }
        VPF1 = VPF1Nuevo;
        Du = nuevoGrado + 1;

        // Mostrar resultado
        String mensaje = " ";
        System.out.println("Vector Forma 1:");
        for (int i = 0; i < VPF1.length; i++) {
            mensaje += "|" + VPF1[i] + "|";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

    // Eliminar termino(Gepetirri ayudo)
    public void eliminar(String Vs[], int e) {

        // Borrar en VPF1 
        int grado = VPF1[0];
        if (e >= 0 && e <= grado) {
            int posi = grado - e + 1;
            VPF1[posi] = 0;
        }

        // Borrar en Vs 
        for (int i = 1; i < Vs.length && Vs[i] != null; i += 2) {
            if (Integer.parseInt(Vs[i]) == e) {
                Vs[i - 1] = "0";
            }
        }

        JOptionPane.showMessageDialog(null, "Exponente eliminado");
    }

    // Reconstruir
    public void Reconstruir(String Vs[]) {
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

    //Evaluar 
    public double Evaluar(double p) {
        int grado = VPF1[0];
        double resultado = 0;

        for (int i = 1; i < VPF1.length; i++) {
            int coe = VPF1[i];
            int exp = grado - (i - 1);

            double pot = 1;
            for (int j = 0; j < exp; j++) {
                pot = pot * p;
            }
            resultado += coe * pot;

        }
        return resultado;

    }

    // Sumar polinomios
    public Forma1 Sumar(Forma1 F2) {
        int Grado1 = VPF1[0];
        int Grado2 = F2.VPF1[0];
        int Gradomax;

        if (Grado1 < Grado2) {
            Gradomax = Grado2;

        } else {
            Gradomax = Grado1;

        }
        Forma1 resultado = new Forma1(Gradomax);

        for (int i = 1; i < Grado1 + 2; i++) {
            int exp = Grado1 - (i - 1);
            int posi = Gradomax - exp + 1;
            resultado.getVPF1()[posi] += VPF1[i];

        }
        for (int j = 1; j < Grado2 + 2; j++) {
            int exp = Grado2 - (j - 1);
            int posi = Gradomax - exp + 1;
            resultado.getVPF1()[posi] += F2.getVPF1(j);

        }

        return resultado;

    }

    //metodo multiplicar
    public Forma1 multiplicar(Forma1 F2) {
        int grado1 = VPF1[0];
        int grado2 = F2.getVPF1(0);
        int gradoMax = grado1 + grado2;

        Forma1 resultado = new Forma1(gradoMax);

        for (int i = 1; i <= grado1 + 1; i++) {
            for (int j = 1; j <= grado2 + 1; j++) {
                int coef = VPF1[i] * F2.getVPF1(j);
                int exp = grado1 - (i - 1) + grado2 - (j - 1);
                int posi = gradoMax - exp + 1;
                resultado.getVPF1()[posi] += coef;
            }
        }

        return resultado;
    }

    public void sumarf1f2(Forma2 f2, Forma3 f3) {
        for (int i = 1; i < f2.getVPF2().length; i += 2) {
            int Acoe = f2.getVPF2(i);
            int Aexp = f2.getVPF2(i + 1);

            this.insertar(Acoe, Aexp);
        }

        Nodo p = f3.getPunta();
        while (p != null) {
            int Bcoe = p.getCoe();
            int Bexp = p.getExp();

            this.insertar(Bcoe, Bexp);
            p = p.getLiga();

        }

    }

}
