package br.com.simvago;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import br.com.simvago.hoteis.DescricaoHotel;
import br.com.simvago.hoteis.RedeDHoteis;

public class Programa {

	public static void main(String... args) throws IOException {
        String localDoArquivo = "input/sampleInput.txt";
        List<String> destino = Files.readLines(new File(localDoArquivo), Charsets.UTF_8);

        ComputarReserva reservationSystem = new ComputarReserva(lines, new DescricaoHotel().redes());
        System.out.println(ComputarReserva.mostrarReservas());
    }
}
