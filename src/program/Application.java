package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Application {

	public static void main(String[] args) {

		try {

			Scanner scan = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			System.out.print("Room number: ");
			Integer roomNumber = scan.nextInt();

			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(scan.next());

			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(scan.next());

			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			scan.close();

		} catch (DomainException e) {
			System.out.println("Invalid date format: ");
		} catch (IllegalArgumentException e) {
			System.out.println("Error in reservation: " + e);
		} catch (ParseException e) {
			System.out.println("Please check that the date entered is in the correct format");
		} catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		finally {
			
		}

	}

}
