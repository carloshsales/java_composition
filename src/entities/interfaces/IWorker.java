package entities.interfaces;

import entities.HourContract;

public interface IWorker {
	public void addContract(HourContract contract);
	public void removeContract(HourContract contract);
	public Double income(int month, int year);
}
