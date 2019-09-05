package arbolavl;

public class Metodos {

    public static Nodo insertarAVL(Nodo raiz, int dato) {
        if (raiz == null) {
            return new Nodo(dato);
        } else if (dato > raiz.getDato()) {
            raiz.setDerecho(insertarAVL(raiz.getDerecho(), dato));
        } else if (dato < raiz.getDato()) {
            raiz.setIzquierdo(insertarAVL(raiz.getIzquierdo(), dato));
        }

        int factorBalance = Propiedades.factorBalance(raiz);

        if (factorBalance == -2 && Propiedades.factorBalance(raiz.getIzquierdo()) != 1) {
            return rotacionSimpleIzquierda(raiz);
        }
        if (factorBalance == 2 && Propiedades.factorBalance(raiz.getDerecho()) != -1) {
            return rotacionSimpleDerecha(raiz);
        }
        if (factorBalance == -2 && Propiedades.factorBalance(raiz.getIzquierdo()) == 1) {
            return rotacionDobleIzquierda(raiz);
        }
        if (factorBalance == 2 && Propiedades.factorBalance(raiz.getDerecho()) == -1) {
            return rotacionDobleDerecha(raiz);
        }

        return raiz;

    }

    public static Nodo buscarAVL(Nodo raiz, int dato) {
        if (raiz != null) {
            if (raiz.getDato() == dato) {
                return raiz;
            }
            if (dato > raiz.getDato()) {
                return buscarAVL(raiz.getDerecho(), dato);
            } else {
                return buscarAVL(raiz.getIzquierdo(), dato);
            }
        }
        return null;
    }

    public static Nodo rotacionSimpleIzquierda(Nodo raiz) {
        Nodo hijo = raiz.getIzquierdo();
        raiz.setIzquierdo(hijo.getDerecho());
        hijo.setDerecho(raiz);
        return hijo;
    }

    public static Nodo rotacionSimpleDerecha(Nodo raiz) {
        Nodo hijo = raiz.getDerecho();
        raiz.setDerecho(hijo.getIzquierdo());
        hijo.setIzquierdo(raiz);
        return hijo;
    }

    public static Nodo rotacionDobleIzquierda(Nodo raiz) {
        raiz.setIzquierdo(rotacionSimpleDerecha(raiz.getIzquierdo()));
        return rotacionSimpleIzquierda(raiz);
    }

    public static Nodo rotacionDobleDerecha(Nodo raiz) {
        raiz.setDerecho(rotacionSimpleIzquierda(raiz.getDerecho()));
        return rotacionSimpleDerecha(raiz);
    }

    public static Nodo borrarAVL(Nodo raiz, int dato) {
        if (raiz == null) {
            return raiz;
        }
        if (dato < raiz.getDato()) {
            raiz.setIzquierdo(borrarAVL(raiz.getIzquierdo(), dato));
        } else if (dato > raiz.getDato()) {
            raiz.setDerecho(borrarAVL(raiz.getDerecho(), dato));
        } else if ((raiz.getIzquierdo() == null) || (raiz.getDerecho() == null)) {
            Nodo temp = null;
            if (temp == raiz.getIzquierdo()) {
                temp = raiz.getDerecho();
            } else {
                temp = raiz.getIzquierdo();
            }
            if (temp == null) {
                temp = raiz;
                raiz = null;
            } else {
                raiz = temp;
            }
        } else {

            Nodo temp = Propiedades.maximo(raiz.getIzquierdo());

            raiz.setDato(temp.getDato());

            raiz.setIzquierdo(borrarAVL(raiz.getIzquierdo(), temp.getDato()));
        }

        if (raiz == null) {
            return raiz;
        }

        int factorBalance = Propiedades.factorBalance(raiz);

        if (factorBalance == -2 && Propiedades.factorBalance(raiz.getIzquierdo()) != 1) {
            return rotacionSimpleIzquierda(raiz);
        }
        if (factorBalance == 2 && Propiedades.factorBalance(raiz.getDerecho()) != -1) {
            return rotacionSimpleDerecha(raiz);
        }
        if (factorBalance == -2 && Propiedades.factorBalance(raiz.getIzquierdo()) == 1) {
            return rotacionDobleIzquierda(raiz);
        }
        if (factorBalance == 2 && Propiedades.factorBalance(raiz.getDerecho()) == -1) {
            return rotacionDobleDerecha(raiz);
        }

        return raiz;
    }
    public  int completos(Nodo Nodo) {
        int cont = 0;
        if (Nodo != null) {
            cont = completos(Nodo.getIzquierdo()) + completos(Nodo.getDerecho());
            if (Nodo.getIzquierdo() != null && Nodo.getDerecho() != null) {
                cont = cont + 1;
            }
        }
        return cont;
    }
}
