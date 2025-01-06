// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Intake2;

public class Auto_Shoot extends Command {
  /** Creates a new Shoot. */
  private final Intake2 s_Intake2;
 
private double Flyspeed = .75;
private double Inspeed = .75;
private double Chamspeed = .75;//.75

private double timer = 0.0;

  public Auto_Shoot(Intake2 d_Intake2) {
    // Use addRequirements() here to declare subsystem dependencies.


    s_Intake2 = d_Intake2;
    addRequirements(s_Intake2);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {


  s_Intake2.Fly(Flyspeed);
  if(s_Intake2.FlyEncoder() > 2500){
  s_Intake2.ChamberSpeed(Chamspeed);
  s_Intake2.IntakeSpeed(Inspeed);

timer ++;

}

   



  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  s_Intake2.ChamberSpeed(0.0);
  s_Intake2.IntakeSpeed(0.0);
 s_Intake2.Fly(0.0);
 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer > 20;
  }
}
