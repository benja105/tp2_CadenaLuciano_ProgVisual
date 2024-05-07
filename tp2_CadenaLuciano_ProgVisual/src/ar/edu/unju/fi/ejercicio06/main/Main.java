package ar.edu.unju.fi.ejercicio06.main;

import ar.edu.unju.fi.ejercicio06.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio06.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio06.model.FelinoSalvaje;

public class Main {
    public static void main(String[] args) {
        FelinoDomestico gato1 = new FelinoDomestico("Garfield", (byte) 14, 14.5f);
        Converter<FelinoDomestico, FelinoSalvaje> converter1 = t -> new FelinoSalvaje(t.getNombre(), t.getEdad(),
                t.getPeso());
        FelinoSalvaje felino1 = converter1.convert(gato1);
        converter1.mostrarObjeto(felino1);
        FelinoSalvaje felino2 = new FelinoSalvaje("Tanner", (byte) 20, 186.5f);
        Converter<FelinoSalvaje, FelinoDomestico> converter2 = t2 -> new FelinoDomestico(t2.getNombre(),
                t2.getEdad(), t2.getPeso());
        if (Converter.isNotNull(felino2)) {
            FelinoDomestico gato2 = converter2.convert(felino2);
            converter2.mostrarObjeto(gato2);
        }
    }
}
