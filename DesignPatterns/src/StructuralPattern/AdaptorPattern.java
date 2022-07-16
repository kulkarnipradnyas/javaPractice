package StructuralPattern;

/**
 * Pattern is used so that two unrelated interfaces can work together. The
 * object that joins these unrelated interface is called an Adapter.
 * 
 * @author kulkarni
 *
 */
// This pattern used when any types of conversion is needed 
interface Movable {
	// returns speed in MPH
	double getSpeed();

}

class Ferrary implements Movable {

	@Override
	public double getSpeed() {
		// TODO Auto-generated method stub
		return 268;
	}

}

interface MovableAdaptor {
	// returns speed in KM/H
	double getSpeed();
}

public class AdaptorPattern implements MovableAdaptor {
	private Movable ferraryCars;

	@Override
	public double getSpeed() {
		// TODO Auto-generated method stub
		return convertMPHtoKMPH(ferraryCars.getSpeed());
	}

	private double convertMPHtoKMPH(double mph) {
		return mph * 1.60934;
	}

}
