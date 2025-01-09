// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.AdvancedCommand;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.AutonomousDistance;
import frc.robot.commands.AutonomousTime;
import frc.robot.commands.GyroCommand;
import frc.robot.commands.LEDOff;
import frc.robot.commands.LEDOn;
import frc.robot.commands.MotorGo;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.IOBoard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final IOBoard m_IoBoard = new IOBoard();

  // Assumes a gamepad plugged into channel 0z
  private final Joystick m_controller = new Joystick(0);

  // Create SmartDashboard chooser for autonomous routines
  private final SendableChooser<Command> m_chooser = new SendableChooser<>();


  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    // Default command is arcade drive. This will run unless another command
    // is scheduled over it.

    JoystickButton zButton = new JoystickButton(m_controller, 1); // for LED's lesson 2
    zButton.onTrue(new LEDOn(m_IoBoard));
      zButton.onFalse(new LEDOff(m_IoBoard));

    JoystickButton xButton = new JoystickButton(m_controller, 2); // for AdvancedCommand lesson 4
    xButton.onTrue(new AdvancedCommand(m_drivetrain, .5, 10));

        JoystickButton qButton = new JoystickButton(m_controller, 3); // for AdvancedCommand lesson 4
    qButton.onTrue(new MotorGo(m_drivetrain, 1 , 1));

        JoystickButton eButton = new JoystickButton(m_controller, 4); // for AdvancedCommand lesson 4
    eButton.onTrue(new MotorGo(m_drivetrain, 1, -1));

        JoystickButton gbutton = new JoystickButton(m_controller, 5); // for Gyro lesson 6
    gbutton.onTrue(new GyroCommand(m_drivetrain));

 m_drivetrain.setDefaultCommand(getArcadeDriveCommand());
    // Setup SmartDashboard options

    m_chooser.setDefaultOption("Auto Routine Distance", new AutonomousDistance(m_drivetrain));
    m_chooser.addOption("Auto Routine Time", new AutonomousTime(m_drivetrain));
    SmartDashboard.putData(m_chooser);
  }

  public Command getAutonomousCommand() {
    return m_chooser.getSelected();
  }

  public Command getArcadeDriveCommand() {
    return new ArcadeDrive(
        m_drivetrain, () -> -m_controller.getRawAxis(1), () -> -m_controller.getRawAxis(2));
  }
}
