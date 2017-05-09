package anpharos.app;

import anpharos.sphero.Instruction;
import anpharos.sphero.Sphero;

import java.util.*;


public class Program{

	private anpharos.structures.Queue<Instruction> instructionQueue;
	private LinkedList<Sphero> spheroList;

	public Program(){
		instructionQueue = new anpharos.structures.Queue<Instruction>();
		spheroList = new LinkedList<Sphero>();
		spheroList.add(new Sphero(100, 100, ""));
	}

	public anpharos.structures.Queue<Instruction> getInstructionQueue(){
		return instructionQueue;
	}

	public LinkedList<Sphero> getSpheroList(){
		return spheroList;
	}

}