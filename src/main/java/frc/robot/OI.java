/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.armManual;
import frc.robot.commands.armRetract;
import frc.robot.commands.cellOutput;
import frc.robot.commands.intakeCell;
import frc.robot.commands.liftVert;
import frc.robot.commands.putDown;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

public Joystick joy1;
public JoystickButton joystickButton1;
public JoystickButton joystickButton2;
public JoystickButton joystickButton3;
public JoystickButton joystickButton4;
public JoystickButton joystickButton5;
public JoystickButton joystickButton6;
public JoystickButton joystickButton7;
public JoystickButton joystickButton8;



public OI() {
  joy1 = new Joystick(0);
  //public Joystick joy1 = new Joystick(0);
 JoystickButton btn2 = new JoystickButton(joy1, 2);
 JoystickButton btn3 = new JoystickButton(joy1, 3);
 JoystickButton btn5 = new JoystickButton(joy1, 5);
 JoystickButton btn6 = new JoystickButton(joy1, 6);
 JoystickButton btn7 = new JoystickButton(joy1, 7);
 JoystickButton btn8 = new JoystickButton(joy1, 8);
 //JoystickButton btn9 = new JoystickButton(joy1, 9);
 //JoystickButton btn10 = new JoystickButton(joy1, 10);
 //JoystickButton btn11 = new JoystickButton(joy1, 11);
 //JoystickButton btn12 = new JoystickButton(joy1, 12);

 

btn8.whileHeld(new liftVert());
btn5.whileHeld(new intakeCell());
btn6.whileHeld(new cellOutput());
btn2.whileHeld(new armManual());
btn7.whileHeld(new putDown());
btn3.whileHeld(new armRetract());
}

public Joystick getjoy1() {
  return joy1;
}


//public GenericHID getJoystick() {
	//return null;
//}

//public Object interpretHatState(Object joystick1, int i, int j, double d, double e) {
	//return null;
}

