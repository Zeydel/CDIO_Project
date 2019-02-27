import java.io.File;

import lejos.*;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class Main {


	public static void main(String[] args) {
		Button.waitForAnyPress();
		for(int i = 0; i < 3; i++) {
			Sound.playTone(500, 800);
			Delay.msDelay(200);
		}

		Sound.playTone(1000, 800);
		
		UnregulatedMotor b = new UnregulatedMotor(MotorPort.B);
		UnregulatedMotor c = new UnregulatedMotor(MotorPort.C);
		b.setPower(100);
		c.setPower(100);

		b.backward();
		c.backward();
		Delay.msDelay(30000);

	}
}
