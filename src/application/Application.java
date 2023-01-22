package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Application {
	
	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		
		//DATA INPUT
		Scanner scanner = new Scanner(System.in);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.print("Enter departament's name: ");
		String departmentName = scanner.nextLine();
		
		System.out.print("Enter worker data:");
		System.out.print("___Name:");
		String workerName = scanner.nextLine();
		
		System.out.print("___Level:");
		String workerLevel = scanner.nextLine();
		
		System.out.print("___Base salary:");
		Double workerBaseSalary = scanner.nextDouble();
		
		
		//INSTANCE WORKER
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerBaseSalary, new Department(departmentName));
		
		System.out.print("How many contracts to this worker?");
		Integer numberOfContracts = scanner.nextInt();
		
		for (Integer i = 1; i <= numberOfContracts; i++) {
			System.out.println("\n==========================================================================\n");
			System.out.println("Enter contract" + "#" + i + " data:");
			
			System.out.print("___Date: (DD/MM/YYYY)");
			Date contractDate = dateFormat.parse(scanner.next());
			
			System.out.print("___Value per hour: (20.0)");
			Double valuePerHour = scanner.nextDouble();
			
			System.out.print("___Duration: (in hours)");
			Integer duration = scanner.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, duration);
			
			worker.addContract(contract);
		}
		
		System.out.println("Enter moth and year to calculate income: (MM/YYYY)");
		String monthAndYear = scanner.next();
		
		Integer month = Integer.parseInt(monthAndYear.substring(0, 2));
		Integer year = Integer.parseInt(monthAndYear.substring(3));
		
		System.out.println("\n==========================================================================\n");
		System.out.println("Name: " + worker.getName());
		System.out.println("Level: " + worker.getLevel());
		System.out.println("Base salary: " + worker.getBaseSalary());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(month, year)));
		
		
		scanner.close();
	}
}
