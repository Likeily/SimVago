package br.com.simvago;

import java.util.Calendar;

public enum TipoTaxa {

	SEMANAL,
	FIMDSEMANA;
	
	public static TipoTaxa checaFDS(Calendar data) {
        if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
        {
            return FIMDSEMANA;
        }
        else if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
        {
        	return FIMDSEMANA;
        }
        else
        {
        	return SEMANAL;
        } 
    }
	
}