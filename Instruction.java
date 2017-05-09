public class Instruction{

	private int id, input1, input2;
	private Command command;

	public Instruction(int id, Command command, int input1, int input2){
		this.id = id;
		this.command = command;
		this.input1 = input1;
		this.input2 = input2;
	}

	public Instruction(int id, Command command){
		this.id = id;
		this.command = command;
	}

	public Instruction(int id, Command command, int input1){
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

	public int getInput1(){
		return input1;
	}

	public int getInput2(){
		return input2;
	}

	public String toString(){
		return ""+command+"";
	}

}