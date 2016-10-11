package ws2;

import ws2.controller.User;
import ws2.model.Crud;
import ws2.view.Console;

public class StartSystem {

	public static void main(String[] args) {
		
		// Initiates our cli-based application
		User user = new User();
		Console view = new Console();
		Crud model = new Crud("member_list.xml");
		
		user.CrudApplication(view, model);
		
	}

}