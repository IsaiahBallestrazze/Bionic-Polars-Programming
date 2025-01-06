// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Intake2;
//import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.drive;
import frc.robot.subsystems.vison;
 
public class Autonomous extends SequentialCommandGroup {
  /**
   * Creates a new Autonomous Drive based on distance. This will drive out for a specified distance,
   * turn around and drive back.
   *
   * @param drivetrain The drivetrain subsystem on which this command will run
   */
  public Autonomous(drive s_drive, Intake2 s_Intake2, Arm s_arm, vison s_Vison) {


addCommands(new auto_arm(s_arm, 7.0)); //dislodge
addCommands(new auto_arm(s_arm, 0.3));
addCommands(new auto_arm(s_arm, 1.6));

addCommands(new Auto_Shoot(s_Intake2, s_arm, 1.7));
addCommands(new auto_arm(s_arm, 0.3));

addCommands(new auto_turn(s_drive, 0));//zreo

addCommands(new Auto_Drive(s_drive, s_Intake2, 0.0, .6, 90.0));
addCommands(new Auto_Drive(s_drive, s_Intake2, 180.0, .6, 85.0));

addCommands(new auto_turn2(s_drive, s_drive.goff()));//speeker

addCommands(new auto_arm(s_arm, 1.6));
addCommands(new Auto_Shoot(s_Intake2, s_arm, 1.7));




  }
}