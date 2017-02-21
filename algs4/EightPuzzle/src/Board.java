import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Board
{
	private int[][] board;
	private int N;

	public Board(int[][] blocks)
	{// construct a board from an n-by-n array of blocks
		// (where blocks[i][j] = block in row i, column j)
		N = blocks.length;
		board = new int[N][N];
		board = deepCopy(blocks, N);
	}

	private int[][] deepCopy(int[][] arr, int n)
	{
		int[][] copy = new int[n][n];
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				copy[i][j] = arr[i][j];
		return copy;
	}

	public int dimension()
	{
		// board dimension n
		return N;
	}

	public int hamming()
	{
		// number of blocks out of place
		int count = 0;
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (board[i][j] == i * N + j + 1)
					continue;
				else
					count++;
			}
		}

		return --count;
	}

	public int manhattan()
	{
		// sum of Manhattan distances between blocks and goal
		int total_dis = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < N; j++)
				total_dis += m_dis(i, j);
		return total_dis;
	}

	private int m_dis(int i, int j)
	{
		if (board[i][j] == 0)
			return 0;
		else
		{
			int row = board[i][j] / N;
			int col = board[i][j] % N;
			if (col == 0)
			{
				col = N - 1;
				row -= 1;
			} else
				col -= 1;
			return Math.abs(col - j) + Math.abs(row - i);
		}
	}

	public boolean isGoal()
	{
		// is this board the goal board?
		return manhattan() == 0;
	}

	public Board twin()
	{
		// a board that is obtained by exchanging any pair of blocks
		int[][] copy = deepCopy(board, N);
		if (copy[0][0] * copy[0][1] != 0)
			exchange(copy, 0, 0, 0, 1);
		else
			exchange(copy, 1, 0, 1, 1);
		return new Board(copy);
	}

	private int[][] exchange(int[][] arr, int row_before, int col_before, int row_after, int col_after)
	{
		int temp = arr[row_before][col_before];
		arr[row_before][col_before] = arr[row_after][col_after];
		arr[row_after][col_after] = temp;
		return arr;
	}

	public boolean equals(Object y)
	{
		// does this board equal y?
		if (y==null)
			return false;
		if (y == this)
			return true;
		if (y.getClass() != this.getClass())
			return false;
		Board tmp = (Board) y;
		return (this.N == tmp.N) && (Arrays.deepEquals(this.board, tmp.board));
	}

	public Iterable<Board> neighbors()
	{
		// all neighboring boards
		Stack<Board> neighbour = new Stack<Board>();

		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (board[i][j] == 0)
				{
					if (i > 0)
					{
						int[][] copy = deepCopy(board, N);
						exchange(copy, i, j, i - 1, j);
						neighbour.push(new Board(copy));
					}

					if (i < N - 1)
					{
						int[][] copy = deepCopy(board, N);
						exchange(copy, i, j, i + 1, j);
						neighbour.push(new Board(copy));
					}

					if (j > 0)
					{
						int[][] copy = deepCopy(board, N);
						exchange(copy, i, j, i, j - 1);
						neighbour.push(new Board(copy));
					}

					if (j < N - 1)
					{
						int[][] copy = deepCopy(board, N);
						exchange(copy, i, j, i, j + 1);
						neighbour.push(new Board(copy));
					}
				}
			}
		}
		return neighbour;
	}

	public String toString()
	{
		// string representation of this board (in the output format specified
		// below)
		StringBuffer s = new StringBuffer();
		s = s.append(N).append('\n');
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				s = s.append(board[i][j]);
				s = s.append('\t');
			}
			s = s.append('\n');
		}
		return s.toString();
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		// unit tests (not graded)
		Scanner scanner = new Scanner(new File("E:/2016-2017-1/Algorithms/8puzzle-testing/8puzzle/puzzle41.txt"));
		// read the N points from a file
		// In in = new In(args[0]);
		int n = scanner.nextInt();
		int[][] blocks = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				blocks[i][j] = scanner.nextInt();
		Board initial = new Board(blocks);
		StdOut.println(initial.hamming());
	}

}