package logica.operaciones;

import logica.exceptions.NumeroParametrosInvalidoException;

import java.io.BufferedReader;
import java.io.PrintWriter;

public interface Operacion {
   String ejecutar(String[] parametros, PrintWriter salida, BufferedReader entrada);

   default void validarParametros(int numeroParametrosRequeridos,int numeroParametros) throws NumeroParametrosInvalidoException {
      if( numeroParametrosRequeridos != numeroParametros ){
         throw new NumeroParametrosInvalidoException();
      }
   }
}
