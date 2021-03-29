package observer;

import java.util.ArrayList;

interface Observer {
	public void update(ArrayList rates);
	public String getName();
}