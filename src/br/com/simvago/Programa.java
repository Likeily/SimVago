package br.com.simvago;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import br.com.simvago.hoteis.DescricaoHotel;

public class Programa {

	public static void main(String... args) throws IOException {

		BufferedReader localDoArquivo = new BufferedReader(
				new InputStreamReader(new FileInputStream("entrada/entrada_de_dados.txt"), "UTF-8"));

		String ler = localDoArquivo.readLine();

		while (ler != null) {
			System.out.println(ler);
			ler = localDoArquivo.readLine();
		}

		localDoArquivo.close();

		ComputarReserva computarReserva = new ComputarReserva(ler, new DescricaoHotel().redes());
		System.out.println(computarReserva.exibirReservas());
	}
}
