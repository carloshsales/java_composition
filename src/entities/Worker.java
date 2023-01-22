package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker implements entities.interfaces.IWorker {
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {}
	public Worker(String name, WorkerLevel level, Double workerBaseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = workerBaseSalary;
		this.department = department;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public WorkerLevel getLevel() {
		return level;
	}
	
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	
	public Double getBaseSalary() {
		return baseSalary;
	}
	
	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public List<HourContract> getContracts(){
		return contracts;
	}
	
	@Override
	public void addContract(HourContract contract) {
		contracts.add(contract);		
	}
	
	@Override
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	@Override
	public Double income(int month, int year) {
		Double sum = this.baseSalary;
		Calendar calendar = Calendar.getInstance();		
		
		for (HourContract contract : this.contracts) {
			calendar.setTime(contract.getDate());
			
			int contract_month = calendar.get(Calendar.MONTH) + 1; //FIRST CALENDAR MONTH = 0
			int contract_year = calendar.get(Calendar.YEAR);
			
			System.out.println(contract_month + "  == " + month +(contract_month == month) + "  " + contract_year + " == " + year + (contract_year == year));
			
			if(contract_month == month && contract_year == year) {
				sum += contract.totalValue();			
			}
		}
		return sum;
	}
	
}











