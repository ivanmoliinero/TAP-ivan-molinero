package solvedExercisesIvan.classAdapter;

//We choose an Object Adapter implementation because the Target isn't an Interface
public class UsbToCarAdapter extends Usb implements CigarretteLighterReceptacleInterface {

	public UsbToCarAdapter() {}
	
	public int getPower(){
		return getEnergy();
	}

    @Override
    public int getEnergy() {
        return 2;
    }

}
