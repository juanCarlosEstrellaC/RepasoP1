package com.repaso.funcional;

public sealed interface Lista<T> permits Nil<T>, Cons<T> {

	// Atributos:
	Lista NIL = new Nil<>();

	// Métodos:
	T head();
	Lista<T> tail();
	boolean isEmpty();

	static <T> Lista<T> of(T h, Lista<T> t) {
		return new Cons<T>(h, t);
	}

	static <T> Lista<Integer> of(T... elementos) {
		Lista<T> t = NIL;

		for (int i = (elementos.length - 1); i >= 0; i--) {
			T h = elementos[i];
			var tmp = Lista.of(h, t);
			t = tmp;
		}
		return (Lista<Integer>) t;
	}
	
	
	default Lista<Integer> sumarDigito(Integer a){
		if (!this.isEmpty()) {
			if (a == 0) {
				return (Lista<Integer>) this;
			}
			
			if (this.tail().tail() == null) {
				return (Lista<Integer>) this;
			} else {
				if (a == 1) {
					Integer r = 0;
					Integer l = 0;
					if (this.head().equals(1)) {
						 r = 0;
						 l = 1;
					} else {
						 r = 1;
						 l = 0;
					}
					return Lista.of(r, this.tail().sumarDigito(l));
				} else {
					return Lista.of(this.head(), this.tail().sumarDigito(0));
				}
			}
		}
		
		return Lista.of(a);
	}
	
	
	default Lista<Integer> reversa() {
		if (!(this.tail() == null)) {
			if (this.tail().tail() == null) {
				return Lista.of(this.head());
			} else {
				var ret = this.tail().reversa();
				return ret.append((Integer) this.head());
			}
		}
		return (Lista<Integer>) this;
	}
		
	default Lista<T> append(T element) { 
		if (this == NIL) { 
			return (Lista<T>) Lista.of(element);
		} else { 
			return Lista.of(this.head(), this.tail().append(element));  
		}
	}	
		
}


