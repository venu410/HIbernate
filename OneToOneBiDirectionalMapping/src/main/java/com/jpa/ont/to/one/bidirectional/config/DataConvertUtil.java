package com.jpa.ont.to.one.bidirectional.config;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConvertUtil {

	public static String toJson(Object object) {
		String jsonString = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			Writer writer = new StringWriter();
			mapper.writeValue(writer, object);
			jsonString = writer.toString();
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonString;

	}

}
