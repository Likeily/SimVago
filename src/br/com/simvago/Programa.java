package br.com.simvago;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.List;

import br.com.simvago.hoteis.DescricaoHotel;
import br.com.simvago.hoteis.RedeDHoteis;

public class Programa {

	public static void main(String... args) throws IOException {

		BufferedReader localDoArquivo = new BufferedReader(
				new InputStreamReader(new FileInputStream("input/sampleInput.txt"), "UTF-8"));

		String linha = localDoArquivo.readLine();

		while (linha != null) {
			System.out.println(linha);
			linha = localDoArquivo.readLine();
		}

		localDoArquivo.close();

		ComputarReserva computarReserva = new ComputarReserva(linha, new RedeDHoteis().hoteis());
		System.out.println(computarReserva.reservationResults());
	}
}
