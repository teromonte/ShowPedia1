package aplication.Admin;

import java.util.HashMap;
import java.util.Map;

import exceptions.All.ExistShowException;
import object.Show.Show;
import object.Show.ShowClass;

public class AplicationClass implements Aplication {
	
	private Map<String,Show>showList;
	public AplicationClass() {
		showList = new HashMap<String, Show>();
	}
	public void addShow(String showName) throws ExistShowException {
		if(showList.containsKey(showName)) {
			throw new ExistShowException();
		}else {
			Show s = new ShowClass(showName);
			showList.put(showName, s);
		}
	}
}
