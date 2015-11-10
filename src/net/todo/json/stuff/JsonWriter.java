package net.todo.json.stuff;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class JsonWriter {
	
	public void write (HttpServletResponse resp, Map<String, Object> map) {
		try {
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(new Gson().toJson(map));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
