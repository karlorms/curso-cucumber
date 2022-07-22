package br.mg.karlorms.converters;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.cucumber.java.ParameterType;

public class DataConverter {
	
	@ParameterType(value = ".*")
	public Date converterDate (String value) {
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date retorno;
		try {
			retorno = df.parse(value);
			return retorno;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
