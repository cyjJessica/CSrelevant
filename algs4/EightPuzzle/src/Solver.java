import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver
{
	private int totalMove;
	private Node end;
	private boolean isSolvable;

	private class Node implements Comparable<Node>
	{
		Board board;
		Node previous;
		int priority;
		int move;

		public Node(Board b, int move, Node pre)
		{
			board = b;
			this.move = move;
			previous = pre;
			priority = b.manhattan() + move;
		}

		public int compareTo(Node that)
		{
			if (this.priority > that.priority)
				return 1;
			else if (this.priority < that.priority)
				return -1;
			else
				return 0;
		}

		public void pushNode( MinPQ<Node> pq)
		{
			for (Board b : this.board.neighbors())
			{
				if ((this.previous == null) || (!b.equals(this.previous.board)))
				{
					pq.insert(new Node(b, this.move + 1, this));
				}
			}
		}
	}

	public Solver(Board initial)
    {
    	// find a solution to the initial board (using the A* algorithm)
		if (initial==null)
			throw new java.lang.NullPointerException();
    	MinPQ<Node> pq=new MinPQ<Node>();
    	MinPQ<Node> pqTwin=new MinPQ<Node>();
    	pq.insert(new Node(initial,0,null));
    	pqTwin.insert(new Node(initial.twin(),0,null));
    	while (true)
    	{
    		Node node=pq.delMin();
    		Node nodeTwin=pqTwin.delMin();
    		if (node.board.isGoal())
    		{
    			isSolvable=true;
    			end=node;
    			totalMove=node.move;
    			break;
    		}
    		if (nodeTwin.board.isGoal())
    		{
    			isSolvable=false;
    			totalMove=-1;
    			break;
    		}
    		node.pushNode(pq);
    		nodeTwin.pushNode(pqTwin);
    	}
    }

	public boolean isSolvable()
	{
		// is the initial board solvable?
		return isSolvable;
	}

	public int moves()
	{
		// min number of moves to solve initial board; -1 if unsolvable
		return totalMove;
	}

	public Iterable<Board> solution()
	{
		// sequence of boards in a shortest solution; null if unsolvable
		Stack<Board> sol=new Stack<Board>();
		if (!isSolvable)
			return null;
		else 
		{
			Node tmp=end;
			while (tmp!=null)
			{
				sol.push(tmp.board);
				tmp=tmp.previous;
			}
		}
		return sol;
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		// solve a slider puzzle (given below)
		Scanner scanner = new Scanner(new File("E:/2016-2017-1/Algorithms/8puzzle-testing/8puzzle/puzzle3x3-14.txt"));
		// read the N points from a file
		// In in = new In(args[0]);
		int n = scanner.nextInt();
		int[][] blocks = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				blocks[i][j] = scanner.nextInt();
		Board initial = new Board(blocks);
		 // solve the puzzle
	    Solver solver = new Solver(initial);

	    // print solution to standard output
	    if (!solver.isSolvable())
	        StdOut.println("No solution possible");
	    else {
	        StdOut.println("Minimum number of moves = " + solver.moves());
	        for (Board board : solver.solution())
	            StdOut.println(board);
	    }
	}
}