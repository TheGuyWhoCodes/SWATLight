import java.sql.Driver;

import com.mindsensors.CANLight;

import edu.wpi.first.wpilibj.DriverStation;

public class SWATLED {
	CANLight light;
	DriverStation ds;
	public SWATLED(int CANPort, DriverStation ds){
		light = new CANLight(CANPort);
		light.reset();
	}
	public void reset(){
		light.writeRegister(0, 1.5, 0, 255, 0);
		light.writeRegister(1, 1.5, 0, 150, 0);
		light.writeRegister(2, 1.5, 0, 100, 0);
		
		light.fade(0, 1);
	}
	public void teamColor(){
		if (ds.getAlliance() == DriverStation.Alliance.Red) {
			light.showRGB(255, 0, 0);
        } else if (ds.getAlliance() == DriverStation.Alliance.Blue) {
        	light.showRGB(0, 0, 255);
        } else if (ds.getAlliance() == DriverStation.Alliance.Invalid) {
        	light.showRGB(255, 200, 0); // yellow
        }
	}
	public void rainbowFade(){
		
	}
	public void firstFade(){
		light.writeRegister(1, 1.0, 255,   0,   0); // red
		light.writeRegister(2, 1.0, 255, 255, 255); // white
		light.writeRegister(3, 1.0,   0,   0, 255); // blue
		light.cycle(1, 3);
	}
}
