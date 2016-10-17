package ws2.controller;

import ws2.model.Crud;
import ws2.view.Console;

public class User {
	
	public void CrudApplication(Console a_view, Crud a_crud) {
		
		// integer which allows memory of current member being changed
		int id;
		
		a_view.presentInstructions();
		
		// Lisen to cli which commandos the user puts in till the user exit the program
		while (!a_view.wantToExit()) {
			a_view.printCommando();
			
			switch (a_view.getCommand()) {
				case "create":
					a_crud.createMember(a_view.getNewMember());
					break;
					
				case "remove":
					if (a_crud.isListEmpty()) {
						id = a_view.getIntToGetMember();

						while (!a_crud.doesMemberExist(id)) {

							a_view.printNoMemberWithIdFound();
							id = a_view.getIntToGetMember();
						}

						a_view.printMemberRemoved();
						a_crud.deleteMember(id);
					} else {
						a_view.printNoMembers();
					}

					break;
					
				case "list":
					
					// Let the user to choose between compact list or verbose list for more details
					switch (a_view.getListCommando()) {
					case "compact":
						a_view.printList(a_crud.listMembersCompact());
						break;
					case "verbose":
						a_view.printList(a_crud.listMembersVerbose());
						break;
					}
					break;
					
				case "view":
					id = a_view.getIntToGetMember();

					while (!a_crud.doesMemberExist(id)) {

						a_view.printNoMemberWithIdFound();
						id = a_view.getIntToGetMember();
					}

					a_view.printList(a_crud.viewMember(id));
					break;
					
				case "change":
					id = a_view.getIntToGetMember();

					while (!a_crud.doesMemberExist(id)) {

						a_view.printNoMemberWithIdFound();
						id = a_view.getIntToGetMember();
					}

					// Let user change Member and or boat
					switch (a_view.getMemberCommand()) {
					case "name":
						a_crud.changeMember(id, "name", a_view.getChangeInput("member name"));
						break;
						
					case "pnumber":
						a_crud.changeMember(id, "pnumber", a_view.getChangeInput("member personal number"));
						break;
						
					case "boat":
						
						int boatId;
						
						switch (a_view.getBoatCommand()) {
						case "create":
							a_crud.changeBoat(id, 0, "create", a_view.getNewBoat("create"));
							break;
							
						case "remove":

							if (a_crud.doesMemberGotBoat(id, 0)) {
								boatId = a_view.getIntToGetBoat("remove");

								while (!a_crud.doesMemberGotBoat(id, boatId)) {
									a_view.printBoatNotFound();
									boatId = a_view.getIntToGetBoat("remove");
								}

								a_crud.changeBoat(id, boatId, "remove", new String[0]);
							} else {
								a_view.printBoatNotFound();
							}
							break;
							
						case "change":
							if (a_crud.doesMemberGotBoat(id, 0)) {
								boatId = a_view.getIntToGetBoat("change");

								while (!a_crud.doesMemberGotBoat(id, boatId)) {
									a_view.printBoatNotFound();
									boatId = a_view.getIntToGetBoat("change");
								}

								a_crud.changeBoat(id, boatId, "change", a_view.getNewBoat("change"));
							} else {
								a_view.printBoatNotFound();
							}
							break;
						}
					}
					
					// Prints the changes made
					a_view.printList(a_crud.viewMember(id));
					break;
			}
		}
		
		a_view.printExitProgram();
	}
	
}
