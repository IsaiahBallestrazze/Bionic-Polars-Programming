// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
//swerve_no_g
package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.drive;

public class swervedrive_w_g extends Command {

  private final drive s_drive;

private final Supplier <Double> vertical;
private final Supplier <Double> horasontal;
private final Supplier <Double> turn;
private double headhold=0;
private double once=0;
private double degrees;
private double speed;
private double turn2;
  

  /** Creates a new swervedrive. */
  public swervedrive_w_g(drive d_drive, Supplier<Double> d_axes1, Supplier<Double> d_axes2, Supplier<Double> d_axes3) {

s_drive=d_drive;
vertical=d_axes1;
horasontal=d_axes2;
turn=d_axes3;


addRequirements(s_drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

if(vertical.get()!=0&&horasontal.get()!=0){

 degrees= Math.toDegrees(Math.tanh(Math.abs(horasontal.get())/Math.abs(vertical.get())));

 if(vertical.get()<0){degrees=180-degrees;}
 if(horasontal.get()<0){degrees=degrees*-1;}

}

 if(Math.abs(horasontal.get())>=Math.abs(vertical.get())){speed=Math.abs(horasontal.get());}
 if(Math.abs(horasontal.get())<Math.abs(vertical.get())){speed=Math.abs(vertical.get());}

if(vertical.get()==0&&horasontal.get()>0){degrees=90;}
if(vertical.get()<0&&horasontal.get()==0){degrees=180;}
if(vertical.get()>0&&horasontal.get()==0){degrees=0;}
if(vertical.get()==0&&horasontal.get()<0){degrees=-90;}



if(vertical.get()>-.1&&vertical.get()<.1&&horasontal.get()<.1&&horasontal.get()>-.1){degrees=222;}

turn2=turn.get();
//anti drift spin code/auto rotat code
/*

if(-.1<turn2&&turn2<.1){
  turn2=222;
}

if (turn2==222&&once==0){
  headhold=s_drive.gyro180();
  once=1;
}
if(turn2!=222){
  once=0;
}
if(turn2==222&&(headhold-s_drive.gyro180()>5&&headhold-s_drive.gyro180()<=180)){
  turn2=.2;
}
if(turn2==222&&(headhold-s_drive.gyro180()<-5&&headhold-s_drive.gyro180()>=-180)){
  turn2=-.3;
}



if(turn2==222){
  turn2=0;
}



//*/

//s_drive.swerve(degrees, speed, turn2);

s_drive.swerve(degrees+s_drive.gyro180(), speed, turn2,degrees);

//outputs info for debuging. add // infront of paragrafe comment to enable
/*
SmartDashboard.putNumber("degrees", degrees);
SmartDashboard.putNumber("speed", speed);

SmartDashboard.putNumber("encoder1", s_drive.number1());
SmartDashboard.putNumber("encoder2", s_drive.number2());
SmartDashboard.putNumber("encoder3", s_drive.number3());
SmartDashboard.putNumber("encoder4", s_drive.number4());

SmartDashboard.putNumber("gyro180", s_drive.gyro180());
SmartDashboard.putNumber("gyro", s_drive.gyro().getValue());
//*/
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
