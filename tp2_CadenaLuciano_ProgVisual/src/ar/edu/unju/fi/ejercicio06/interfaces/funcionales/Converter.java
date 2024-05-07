package ar.edu.unju.fi.ejercicio06.interfaces.funcionales;

@FunctionalInterface
public interface Converter<X, X1> {
	X1 convert(X x);
	static <X> boolean isNotNull(X x) {
		return x!=null;
	}
	default void mostrarObjeto(X1 x1) {
		System.out.println("Objeto - "+x1.toString());
	}
}