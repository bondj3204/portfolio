import java.util.Scanner;

class Airplane{
	public static void main(String args[]){
		int row = 13, seats = 6;
		char[][] currentSeatings = initializePlaneCapacity(row, seats);

		init(row, seats, currentSeatings);
	}

	public static void init(int row, int seats, char[][] currentSeatings){
		Scanner scanner = new Scanner(System.in);

		int selectedTicket = ticketSelection(scanner);
		int selectedRow = rowSelection(scanner, row, selectedTicket);
		int selectedColumn = columnSelection(seats, scanner);


		System.out.println("selectedTicket: " + selectedTicket);
		System.out.println("selectedRow: " + selectedRow);
		System.out.println("selectedColumn: " + selectedColumn);

		reserveSeat(scanner, row, seats, selectedRow, selectedColumn, currentSeatings);

	}
	
	public static char[][] initializePlaneCapacity(int rows, int seats){
		char[][] temporary = new char[rows][seats];;
		for(int i = 0; i < rows; i++){
			for(int o = 0; o < seats; o++){
				temporary[i][o] = '*';
			}
		}
		return temporary;
	}

	public static void printPlaneSeats(char[][] currentSeatings){

		System.out.println("\n\t-------------------------------------------\n");
		System.out.println("\t\tReserve Seats is Mark as X\n");
		int rows = 13; int seats = 6;
		for(int i = 0; i < rows; i++){
			for(int o = 0; o < seats; o++){
				System.out.print("\t" + currentSeatings[i][o] + " ");
			}
			System.out.print("\n");
		}
		System.out.println("\n\t-------------------------------------------\n");
	}

	public static int ticketSelection(Scanner scanner){
		System.out.println("[1] First Class \n[2] Second Class \n[3] Economy");
		System.out.print("Select TICKET type from Above : ");
		int temp = scanner.nextInt();
		if(temp != 1 && temp != 2 && temp != 3){
			System.out.print("Selected Ticket is NOT Valid. Try Again ? : [press y for yes, any other button for no.] : ");
			char retry = scanner.next().charAt(0);
			if(retry == 'y' || retry == 'Y')
				temp = ticketSelection(scanner);
			else
				System.exit(0);
		}
		return temp;
	}

	public static int rowSelection(Scanner scanner, int row, int selectedTicket){
		int temp = 0;
		boolean errorFound = false;
		switch(selectedTicket){
			case 1:
				System.out.print("Enter row[1-3] : ");
				temp = scanner.nextInt();
				if(temp < 1 || temp > 3)
					errorFound = true;
				break;
			case 2:
				System.out.print("Enter row[4-8] : ");
				temp = scanner.nextInt();
				if(temp < 4 || temp > 8)
					errorFound = true;
				break;
			case 3:
				System.out.print("Enter row[9-13] : ");
				temp = scanner.nextInt();
				if(temp < 9 || temp > 13)
					errorFound = true;
				break;
		}
		if(temp <= 0 || temp > row || errorFound){
			System.out.print("Selected ROW is NOT Valid. Try Again ? : [press y for yes, any other button for no.] : ");
			char retry = scanner.next().charAt(0);
			if(retry == 'y' || retry == 'Y')
				temp = rowSelection(scanner, row, selectedTicket);
			else
				System.exit(0);
		}
		return temp;
	}

	public static int columnSelection(int seats, Scanner scanner){
		System.out.print("Enter Column[1-6] : ");
		int temp = scanner.nextInt();
		if(temp <= 0 || temp > seats){
			System.out.print("Selected SEAT is NOT Valid. Try Again ? : [press y for yes, any other button for no.] : ");
			char retry = scanner.next().charAt(0);
			if(retry == 'y' || retry == 'Y')
				temp = columnSelection(seats, scanner);
			else
				System.exit(0);
		}
		return temp;
	}

	public static  void reserveSeat(Scanner scanner, int row, int seats, int selectedRow, int selectedColumn, char[][] currentSeatings){
		char check = currentSeatings[selectedRow - 1][selectedColumn - 1];
		if(check == '*'){
			currentSeatings[selectedRow - 1][selectedColumn - 1] = 'X';
			printPlaneSeats(currentSeatings);
			System.out.print("Succesfully Reserved the selected SEAT. Try Again ? : [press y for yes, any other button for no.] : ");
			char retry = scanner.next().charAt(0);
			if(retry == 'y' || retry == 'Y')
				init(row, seats, currentSeatings);
			else
				System.exit(0);
		}else{
			System.out.print("Sorry, Selected SEAT is already taken. Try Again ? : [press y for yes, any other button for no.] : ");
			char retry = scanner.next().charAt(0);
			if(retry == 'y' || retry == 'Y')
				init(row, seats, currentSeatings);
			else
				System.exit(0);
		}
	}

}