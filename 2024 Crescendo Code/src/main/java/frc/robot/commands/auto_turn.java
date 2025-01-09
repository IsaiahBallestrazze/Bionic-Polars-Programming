// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drive;

public class auto_turn extends Command {
  /** Creates a new auto_turn. */
private final drive s_drive;
private double degree;
private double once;
private double turn2;
  public auto_turn(drive d_Drive,double d_degrees) {

s_drive=d_Drive;
degree=d_degrees;
addRequirements(s_drive);


    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    s_drive.off(s_drive.gyro180());
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("gyrooff",s_drive.goff());
    
      once=s_drive.gyro180()-degree;
      
      if(once>180) turn2=.3;
      else if(once<-180) turn2=-.3;
      else if(once>10) turn2=-.3;
      else if(once<-10) turn2=.3;
      else turn2=0;
      
      s_drive.swerve(222, 0, turn2, 222);
      }
   

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    s_drive.swerve(0, 0, 0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return turn2==0;
  }
}
