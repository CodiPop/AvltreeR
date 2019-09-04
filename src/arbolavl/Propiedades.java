package arbolavl;

public class Propiedades {

    public static int altura(Nodo raiz) {
        if (raiz == null) {
            return -1;
        } else {
            return 1 + Math.max(altura(raiz.getIzquierdo()), altura(raiz.getDerecho()));
        }
    }

    public static int factorBalance(Nodo raiz) {
        return altura(raiz.getDerecho()) - altura(raiz.getIzquierdo());
    }

    public static Nodo maximo(Nodo raiz) {
        if (raiz.getDerecho() == null) {
            return raiz;
        } else {
            return maximo(raiz.getDerecho());
        }
    }

    public static int obtenerNivel(Nodo raiz, int key, int nivel) {
        if (raiz == null) {
            return 0;
        }
        if (raiz.getDato() == key) {
            return nivel;
        }

        int result = obtenerNivel(raiz.getIzquierdo(), key, nivel + 1);
        if (result != 0) {
            // If found in left subtree , return 
            return result;
        }
        result = obtenerNivel(raiz.getDerecho(), key, nivel + 1);

        return result;
    }
}
