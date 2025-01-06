// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.Optional;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ArmDrive;
import frc.robot.commands.Autonomous;
import frc.robot.commands.BlueAlliance;
import frc.robot.commands.Bron_Silv_Gold;
import frc.robot.commands.Chamber;
import frc.robot.commands.ClimerMove;
import frc.robot.commands.Random_Light;
import frc.robot.commands.PixelOff;
import frc.robot.commands.Rainbow;
import frc.robot.commands.RedAlliance;
import frc.robot.commands.Red_White;
import frc.robot.commands.ReverseRainbow;
import frc.robot.commands.Shoot;
import frc.robot.commands.ShootStop;
import frc.robot.commands.Shoot_low;
import frc.robot.commands.aim;
import frc.robot.commands.camreturn;
import frc.robot.commands.falow;
import frc.robot.commands.intake_stear;
import frc.robot.commands.revers;
// import frc.robot.commands.camreturn;
// import frc.robot.commands.falow;
import frc.robot.commands.speedmod;
import frc.robot.commands.speekeraline;
// import frc.robot.commands.speekeraline;
import frc.robot.commands.swerve_no_g;
import frc.robot.commands.swerveback;
import frc.robot.commands.swervedrive_w_g;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Climer;
import frc.robot.subsystems.Intake2;
import frc.robot.subsystems.NeoPixels;
import frc.robot.subsystems.drive;
//import frc.robot.subsystems.vison;
import frc.robot.subsystems.vison;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final drive s_drive = new drive();
  private final Arm m_Arm = new Arm();
  private final Intake2 m_Intake2 = new Intake2();
  private final Climer m_Climer = new Climer();
  private final vison s_vison = new vison();
  private final Joystick arcade = new Joystick(1);
  private final Joystick xbox = new Joystick(0);
  private final NeoPixels s_neo = new NeoPixels();

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {

    // s_vison.setDefaultCommand(new camreturn(s_vison));
    s_drive.setDefaultCommand(
        new swervedrive_w_g(s_drive, () -> -xbox.getRawAxis(1), () -> -xbox.getRawAxis(0), () -> xbox.getRawAxis(4)));

    // JoystickButton aline = new JoystickButton(xbox, 2);
    // aline.onTrue(new speekeraline(s_drive, s_vison, () -> -xbox.getRawAxis(1) ,
    // () -> -xbox.getRawAxis(0), () -> xbox.getRawButton(2)));

    // JoystickButton falow = new JoystickButton(xbox, 1);
    // falow.onTrue(new falow(s_drive, s_vison, () -> xbox.getRawButton(1)));

    JoystickButton no_gyro = new JoystickButton(xbox, 6);
    no_gyro.onTrue(new swerve_no_g(s_drive, () -> -xbox.getRawAxis(1), () -> -xbox.getRawAxis(0),
        () -> xbox.getRawAxis(4), () -> xbox.getRawButton(6)));

    JoystickButton back = new JoystickButton(xbox, 5);
    back.onTrue(new swerveback(s_drive, () -> -xbox.getRawAxis(1), () -> -xbox.getRawAxis(0),
        () -> xbox.getRawAxis(4), () -> xbox.getRawButton(5)));

    JoystickButton rt = new JoystickButton(xbox, 1);
    JoystickButton lt = new JoystickButton(xbox, 2);
    JoystickButton top = new JoystickButton(xbox, 3);
        JoystickButton evenfaster = new JoystickButton(xbox, 3);

    rt.onTrue(new speedmod(s_drive, .6));
    lt.onTrue(new speedmod(s_drive, .35));
    top.onTrue(new speedmod(s_drive,1.0));
evenfaster.onTrue(new speedmod(s_drive, 1.25));
    // UP
    JoystickButton buttonY = new JoystickButton(arcade, 1);
    buttonY.onTrue(new ArmDrive(m_Arm, 1.5));
    buttonY.onTrue(new Red_White(s_neo));

   

    // DOWN
    JoystickButton buttonB = new JoystickButton(arcade, 2);
    buttonB.onTrue(new ArmDrive(m_Arm, .3));

    // FLYWHEEL
    JoystickButton buttonX = new JoystickButton(arcade, 3);
    buttonX.onTrue(new Shoot(m_Intake2, s_neo));
    buttonX.onFalse(new ShootStop(m_Intake2));

    // INTAKE
    JoystickButton buttonA = new JoystickButton(arcade, 4);
    buttonA.onTrue(new Chamber(m_Intake2));
    buttonA.onFalse(new ShootStop(m_Intake2));
    buttonA.onTrue(new Bron_Silv_Gold(s_neo));

    // AMP SHOOT
    JoystickButton buttongreen = new JoystickButton(arcade, 5);
    buttongreen.onTrue(new Shoot_low(m_Intake2, s_neo));
    buttongreen.onFalse(new ShootStop(m_Intake2));

    // NEOPIXLES
    JoystickButton neo = new JoystickButton(arcade, 6);
    neo.onTrue(new revers(m_Intake2));
    neo.onFalse(new ShootStop(m_Intake2));
    Optional<Alliance> ally = DriverStation.getAlliance();
    if (ally.isPresent()) {
      if (ally.get() == Alliance.Red) {
        s_neo.setDefaultCommand(new RedAlliance(s_neo));
        neo.onTrue(new RedAlliance(s_neo));
        buttonB.onTrue(new RedAlliance(s_neo));
      }
      if (ally.get() == Alliance.Blue) {
        s_neo.setDefaultCommand(new BlueAlliance(s_neo));
        neo.onTrue(new BlueAlliance(s_neo));
        buttonB.onTrue(new BlueAlliance(s_neo));
      }
    }

    // AMP ARM
    JoystickButton button5 = new JoystickButton(arcade, 7);
    button5.onTrue(new ArmDrive(m_Arm, 6));
    button5.onTrue(new Rainbow(s_neo));

    // UP 2 (farther shoot)
    JoystickButton camm = new JoystickButton(arcade, 8);
    camm.onTrue(new ArmDrive(m_Arm, 2.25));// needs to be tooned
    camm.onTrue(new ReverseRainbow(s_neo));

    // CLIMB UP
    JoystickButton B = new JoystickButton(arcade, 9);
    B.onTrue(new ClimerMove(m_Climer, -430));
    B.onTrue(new Red_White(s_neo));

    // CLIMB DOWN
    JoystickButton C = new JoystickButton(arcade, 10);
    C.onTrue(new ClimerMove(m_Climer, 0));
    C.onTrue(new Random_Light(s_neo));

    m_Arm.setDefaultCommand(new ArmDrive(m_Arm, 0));

    // s_vison.setDefaultCommand(new camreturn(s_vison));

    JoystickButton aline = new JoystickButton(xbox, 10);

    aline.onTrue(new intake_stear(s_drive, () -> -xbox.getRawAxis(1), () -> -xbox.getRawAxis(0),
        () -> xbox.getRawAxis(4), () -> -xbox.getRawAxis(5)));

    aline.onFalse(
        new swervedrive_w_g(s_drive, () -> -xbox.getRawAxis(1), () -> -xbox.getRawAxis(0), () -> xbox.getRawAxis(4)));

   // s_drive.zero();

  }

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return new Autonomous(s_drive, m_Intake2, m_Arm, s_vison);
  }
}
