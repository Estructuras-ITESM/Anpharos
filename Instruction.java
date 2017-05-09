import java.io.*;

public class Instruction implements Serializable{

	private int id;
	private Command command;
	private double input1, input2;

	public Instruction(int id, Command command, double input1, double input2){
		this.id = id;
		this.command = command;
		this.input1 = input1;
		this.input2 = input2;
	}

	public Instruction(int id, Command command){
		this.id = id;
		this.command = command;
	}

	public Instruction(int id, Command command, double input1){
		this.id = id;
		this.command = command;
		this.input1 = input1;
	}

	public int getId(){
		return id;
	}

	public Command getCommand(){
		return command;
	}

	public double getInput1(){
		return input1;
	}

	public double getInput2(){
		return input2;
	}

}