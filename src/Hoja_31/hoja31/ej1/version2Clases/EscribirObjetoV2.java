package Hoja_31.hoja31.ej1.version2Clases;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscribirObjetoV2 extends ObjectOutputStream {
    public EscribirObjetoV2(FileOutputStream fos) throws IOException {
        super(fos);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }
}
