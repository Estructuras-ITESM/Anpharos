package anpharos.app;

import anpharos.sphero.Instruction;
import anpharos.sphero.Sphero;

import java.util.*;
import java.io.*;

public class Program implements Serializable{

	private Queue<Instruction> instructionQueue;
	private LinkedList<Sphero> spheroList;

	public Program(){
		instructionQueue = new Queue<Instruction>();
		spheroList = new LinkedList<Sphero>();
		spheroList.add(new Sphero(100, 100, ""));
	}

	public Queue<Instruction> getInstructionQueue(){
		return instructionQueue;
	}

	public LinkedList<Sphero> getSpheroList(){
		return spheroList;
	}

}
