package alg.pkg3;

import javax.swing.JOptionPane;

/**
 * @author Carlos Castano and Gepetirri
 */
public class Alg3 {

    //8x^2-3x^5+2x-10
    public static int MenuForma() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Seleccione Forma -------\n"
                + "1. Forma 1\n"
                + "2. Forma 2\n"
                + "3. Forma 3\n"
                + "4. Operaciones entre Formas\n"
                + "0. Salir\n"
                + " "));
        return opc;
    }

    public static int MenuOperacionesMixtas() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Operaciones entre Formas -------\n"
                + "1. Sumar F2 + F3 = F1\n"
                + "2. Multiplicar F1 * F2 = F3\n"
                + "0. Volver\n"
                + " "));
        return opc;
    }

    public static int MenuPrincipal(int forma) {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Menu Principal (Forma " + forma + ") -------\n"
                + "1. Insertar termino\n"
                + "2. Eliminar termino\n"
                + "3. Mostrar\n"
                + "4. Reconstruir\n"
                + "5. Evaluar\n"
                + "6. Sumar\n"
                + "7. Multiplicar\n"
                + "0. Cambiar Forma / Salir\n"
                + " "));
        return opc;
    }

    public static int MenuInsertar() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Menu Insertar -------\n"
                + "1. Forma 1\n"
                + "2. Forma 2\n"
                + "3. Forma 3\n"
                + "0. Salir\n"
                + " "));
        return opc;
    }

    public static int MenuEliminar() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Menu Eliminar -------\n"
                + "1. Forma 1\n"
                + "2. Forma 2\n"
                + "3. Forma 3\n"
                + "0. Salir\n"
                + " "));
        return opc;
    }

    public static int MenuMostrar() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Menu Mostrar -------\n"
                + "1. Forma 1\n"
                + "2. Forma 2\n"
                + "3. Forma 3\n"
                + "0. Salir\n"
                + " "));
        return opc;
    }

    public static int MenuReconstruir() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Menu Reconstruir -------\n"
                + "1. Forma 1\n"
                + "2. Forma 2\n"
                + "3. Forma 3\n"
                + "0. Salir\n"
                + " "));
        return opc;
    }

    public static int MenuEvaluar() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Menu Evaluar -------\n"
                + "1. Forma 1\n"
                + "2. Forma 2\n"
                + "3. Forma 3\n"
                + "0. Salir\n"
                + " "));
        return opc;
    }

    public static int MenuSumar() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Menu Sumar -------\n"
                + "1. Forma 1\n"
                + "2. Forma 2\n"
                + "3. Forma 3\n"
                + "0. Salir\n"
                + " "));
        return opc;
    }

    public static int MenuMultiplicar() {
        int opc = Integer.parseInt(JOptionPane.showInputDialog("------- Menu Multiplicar -------\n"
                + "1. Forma 1\n"
                + "2. Forma 2\n"
                + "3. Forma 3\n"
                + "0. Salir\n"
                + " "));
        return opc;
    }

    // Contar Terminos
    public static int NumeroTerminos(String Vs[]) {
        int contador = 0;

        for (int i = 1; i < Vs.length; i += 2) {
            if (Vs[i] != null && !Vs[i].isEmpty()) {
                contador++;
            }

        }
        System.out.println(contador);
        return contador;
    }

    public static String[] CrearPoli() {
        String Cadena = JOptionPane.showInputDialog("Ingrese polinomio");
        char Vc[] = Cadena.toCharArray();
        String Vs[] = new String[Vc.length], s = "";
        int j = 0;

        for (int i = 0; i < Vc.length; i++) {
            System.out.print("|" + Vc[i] + "");

        }

    for (int i = 0; i < Vc.length; i++) {
            // si hay signos cuando s ya tiene algo:
            if ((Vc[i] == '-' || Vc[i] == '+') && s.isEmpty() == false) {
                Vs[j] = s;
                j++;
                Vs[j] = "0";
                j++;
                s = "";
            }

            if (Vc[i] == '-' || Character.isDigit(Vc[i])) {

                s = s + Vc[i];
            } else {
                if (Vc[i] == 'x') {
                    Vs[j] = s;
                    j++;
                    s = "";
                } else {
                    if (Vc[i] == '^') {
                        Vs[j] = Character.toString(Vc[i + 1]);
                        j++;
                        i++;
                    }
                }
            }
            if (i < Vc.length - 1) {
                if (Vc[i] == 'x' && (Vc[i + 1] == '-' || Vc[i + 1] == '+')) {
                    Vs[j] = "1";
                    j++;
                }
            }
            Vs[j] = s;
            Vs[j + 1] = "0";
        }
        System.out.println("\n");
        for (int i = 0; i < Vs.length; i++) {

            System.out.print("|" + Vs[i] + "|");
        }

        String coeficiente = " ";
        String exponente = " ";
        System.out.print("\n");
        // aqui codigo para ordenar vector //8x^2-3x^5+2x-10
        for (int i = 1; Vs[i] != null; i += 2) {          // i apunta a exponentes
            for (int k = i + 2; Vs[k] != null; k += 2) { // k compara exponentes

                if (Integer.parseInt(Vs[i]) < Integer.parseInt(Vs[k])) {  // ordenar de mayor a menor

                    coeficiente = Vs[i - 1];
                    exponente = Vs[i];
                    // Mover  directamente coeficiente y exponente
                    Vs[i - 1] = Vs[k - 1];
                    Vs[i] = Vs[k];

                    //mover el resto a la posicion anterior
                    Vs[k] = exponente;
                    Vs[k - 1] = coeficiente;

                }
            }
        }

        for (int n = 0; n < Vs.length; n++) {

            System.out.print("|" + Vs[n] + "|");
        }

        NumeroTerminos(Vs);

        return Vs;
    }

    public static void main(String[] args) {

        int opc = 0;
        int forma = 0;
        Forma1 F1;

        String Vs[] = CrearPoli();

        F1 = new Forma1(Integer.parseInt(Vs[1]));
        F1.LlenarPoli(Vs);
        Forma2 F2 = new Forma2(NumeroTerminos(Vs));
        F2.LlenarPoli2(Vs);
        Forma3 F3 = new Forma3();
        F3.LlenarPoli3(Vs);

        do {
            forma = MenuForma();
            if (forma == 0) {
                break;
            }

            if (forma == 4) {
                int opcMixto;
                do {
                    opcMixto = MenuOperacionesMixtas();
                    switch (opcMixto) {
                        case 1:
                            JOptionPane.showMessageDialog(null, "Sumar F2 + F3 = F1");
                            F1 = new Forma1(0);
                            F1.sumarf1f2(F2, F3);
                            F1.Mostrar();
                            break;

                        case 2:
                            JOptionPane.showMessageDialog(null, "Multiplicar F1 * F3 = F2");
                            F2 = new Forma2(0);
                            F2.Multiplicarf1f3(F1, F3);
                            F2.MostrarPoli2();
                            break;

                        case 0:
                            System.out.println("Volviendo...");
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "ERROR");
                    }
                } while (opcMixto != 0);
                continue;
            }

            do {
                opc = MenuPrincipal(forma);
                switch (opc) {
                    case 1:
                        switch (forma) {
                            case 1:
                                int c,
                                 e;
                                JOptionPane.showMessageDialog(null, "Insertar en Forma 1");
                                c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el coeficiente"));
                                e = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el exponente"));
                                F1.insertar(c, e);
                                break;

                            case 2:
                                JOptionPane.showMessageDialog(null, "Insertar en Forma 2");
                                int c2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese coeficiente"));
                                int e2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente"));
                                F2.insertar2(e2, c2);
                                break;

                            case 3:
                                JOptionPane.showMessageDialog(null, "Insertar en Forma 3");
                                int coe = Integer.parseInt(JOptionPane.showInputDialog("Ingrese coeficiente"));
                                int exp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente"));
                                F3.insertar3(coe, exp);

                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "ERROR");
                        }
                        break;

                    case 2:
                        switch (forma) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Eliminar en Forma 1");
                                int c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente a eliminar"));
                                F1.eliminar(Vs, c);
                                break;

                            case 2:
                                JOptionPane.showMessageDialog(null, "Eliminar en Forma 2");
                                int c2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese coeficiente a eliminar"));
                                F2.eliminar2(c2, Vs);
                                break;

                            case 3:
                                JOptionPane.showMessageDialog(null, "Eliminar en Forma 3");
                                int exp = Integer.parseInt(JOptionPane.showInputDialog("Ingrese exponente a eliminar"));
                                F3.Eliminar3(exp);

                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "ERROR");
                        }
                        break;

                    case 3:
                        switch (forma) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Mostrar en Forma 1");
                                F1.Mostrar();
                                break;

                            case 2:
                                JOptionPane.showMessageDialog(null, "Mostrar en Forma 2");
                                F2.MostrarPoli2();

                                break;

                            case 3:
                                JOptionPane.showMessageDialog(null, "Mostrar en Forma 3");
                                F3.Mostrar();
                                F3.multiplicar(F1, F2);
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "ERROR");
                        }
                        break;

                    case 4:
                        switch (forma) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Reconstruir en Forma 1");
                                F1.Reconstruir(Vs);
                                break;

                            case 2:
                                JOptionPane.showMessageDialog(null, "Reconstruir en Forma 2");
                                F2.Reconstruir2(Vs);
                                break;

                            case 3:
                                JOptionPane.showMessageDialog(null, "Reconstruir en Forma 3");
                                F3.Reconstruir3();
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "ERROR");
                        }
                        break;

                    case 5:
                        switch (forma) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Evaluar en Forma 1");
                                double p = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de x que quiere evaluar"));
                                JOptionPane.showMessageDialog(null, "f(" + p + ") = " + F1.Evaluar(p));
                                break;

                            case 2:
                                JOptionPane.showMessageDialog(null, "Evaluar en Forma 2");
                                double x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de x que quiere evaluar"));
                                JOptionPane.showMessageDialog(null, "f(" + x + ") = " + F2.evaluar2(x));
                                break;

                            case 3:
                                JOptionPane.showMessageDialog(null, "Evaluar en Forma 3");
                                double c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese valor de x"));
                                JOptionPane.showMessageDialog(null, "f(" + c + ") = " + F3.Evaluar3(c));

                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "ERROR");
                        }
                        break;

                    case 6:
                        switch (forma) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Sumar en Forma 1");

                                String Vs2[] = CrearPoli();
                                Forma1 F1b = new Forma1(Integer.parseInt(Vs2[1])); //Gepetirri me hizo la explicacion de esto
                                F1b.LlenarPoli(Vs2);
                                F1 = F1.Sumar(F1b);
                                F1.Mostrar();
                                break;

                            case 2:
                                JOptionPane.showMessageDialog(null, "Sumar en Forma 2");
                                String Vs4[] = CrearPoli();
                                Forma2 F2b = new Forma2(NumeroTerminos(Vs4));
                                F2b.LlenarPoli2(Vs4);
                                F2.Sumar2(F2b);
                                F2.MostrarPoli2();
                                break;

                            case 3:
                                JOptionPane.showMessageDialog(null, "Sumar en Forma 3");
                                String Vs6[] = CrearPoli();
                                Forma3 F3b = new Forma3();
                                F3b.LlenarPoli3(Vs6);
                                F3.sumar(F3b);
                                F3.Mostrar();
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "ERROR");
                        }
                        break;

                    case 7:
                        switch (forma) {
                            case 1:
                                JOptionPane.showMessageDialog(null, "Multiplicar en Forma 1");
                                String Vs3[] = CrearPoli();
                                Forma1 F1c = new Forma1(0);
                                F1c.LlenarPoli(Vs3);
                                F1 = F1.multiplicar(F1c);
                                F1.Mostrar();
                                break;

                            case 2:
                                JOptionPane.showMessageDialog(null, "Multiplicar en Forma 2");
                                String Vs5[] = CrearPoli();
                                Forma2 F2c = new Forma2(NumeroTerminos(Vs5));
                                F2c.LlenarPoli2(Vs5);
                                F2 = F2.Multiplicar2(F2c);
                                F2.MostrarPoli2();
                                break;

                            case 3:
                                JOptionPane.showMessageDialog(null, "Multiplicar en Forma 3");
                                String Vs7[] = CrearPoli();
                                Forma3 F3c = new Forma3();
                                F3c.LlenarPoli3(Vs7);
                                F3.multiplicar(F3, F3c);
                                F3.Mostrar();
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "ERROR");
                        }
                        break;

                    case 0:
                        System.out.println("Volviendo a seleccion de Forma...");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "ERROR");
                }
            } while (opc != 0);

        } while (forma != 0);

    }

}
