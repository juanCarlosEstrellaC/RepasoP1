package com.repaso;

import com.repaso.funcional.Lista;

public class Main {

	public static void main(String[] args) {

		System.out.println("hola");

		// Coloque el número binario al revés:
		var miLista = Lista.of(1, 1, 0, 1);
//		System.out.println(miLista);

		var digito = 1;
		var l2 = miLista.sumarDigito(digito);
//		System.out.println(l2);

		System.out.print("La suma del dígito " + digito + " al número binario\n" + miLista.reversa() + "\nes:\n");
		var l3 = l2.reversa();
		System.out.println(l3);
	}

}
