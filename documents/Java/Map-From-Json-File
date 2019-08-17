# Gson을 이용해 JSON Object 얻기

``` Java
package practice;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.Dummy;
public class Recursive {
	public static void main(String[] args) throws FileNotFoundException {
		Gson gson = new Gson();
		Gson prtGson = new GsonBuilder().setPrettyPrinting().create();
		List<Dummy> dum = new ArrayList<Dummy>();
		List<HashMap<String, Object>> map = new ArrayList<HashMap<String, Object>>();
		String path = "C:\\rotcafer\\study\\src\\main\\resources\\dummy\\dummy.json";
		Reader reader = new FileReader(path);
		
	  map = gson.fromJson(reader, ArrayList.class);
	    
	}	
}
```
