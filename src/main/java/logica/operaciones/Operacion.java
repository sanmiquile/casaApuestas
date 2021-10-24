package logica.operaciones;

import logica.exceptions.NumeroParametrosInvalidoException;

public interface Operacion {
   String ejecutar(String[] parametros);

   default void validarParametros(int numeroParametrosRequeridos,int numeroParametros) throws NumeroParametrosInvalidoException {
      if( numeroParametrosRequeridos != numeroParametros ){
         throw new NumeroParametrosInvalidoException();
      }
   }
}
