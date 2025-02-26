package Hoja_31.hoja31.ej1.Clases;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirObjeto extends ObjectOutputStream {
    public EscribirObjeto(FileOutputStream fos) throws IOException {
        super(fos);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }
}
