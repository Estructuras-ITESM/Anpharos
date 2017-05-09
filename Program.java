import java.util.*;
import java.io.*;

public class Program{

	private Queue<Instruction> instructionQueue;
	private LinkedList<Sphero> spheroList;

	public Program(){
		instructionQueue = new Queue<Instruction>();
		spheroList = new LinkedList<Sphero>();
		spheroList.add(new Sphero(100, 100, ""));
		spheroList.add(new Sphero(100, 100, ""));
	}

	public Queue<Instruction> getInstructionQueue(){
		return instructionQueue;
	}

	public LinkedList<Sphero> getSpheroList(){
		return spheroList;
	}

	public void setInstructionQueue(Queue<Instruction> instructions){
		instructionQueue = instructions;
	}

}