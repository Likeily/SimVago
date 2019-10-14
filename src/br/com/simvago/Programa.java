package br.com.simvago;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Programa {

	public static void main(String... args) throws IOException {
        String fileLocation = "input/sampleInput.txt";
        List<String> lines = Files.readLines(new File(fileLocation), Charsets.UTF_8);

        ComputarReserva computarReserva = new ComputarReserva(lines, new DefaultHotels().hotels());
        System.out.println(computarReserva.mostrarReservas());
    }
}
