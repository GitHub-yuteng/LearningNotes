package DesignPatterns.BehavioralType.Observer.Improve;


public interface Subject {
	void registerObserver(Observer o);
	void removeObserver(Observer o);
	void notifyObservers();
}
