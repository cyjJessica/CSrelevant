import edu.princeton.cs.algs4.*;

public class Percolation
{
	 private int arr[][];
	private WeightedQuickUnionUF helper;
	private int n;
	private int count = 0;

	public Percolation(int n)//make a change here
	{
		this.n = n;// initialize the number of total rows and columns
		arr = new int[n][n];// initialize all elements 0 as they are blocked
		helper = new WeightedQuickUnionUF(n * n + 2);
		// add a virtual site before the first row and a virtual site after the
		// last row
	}

	public void open(int row, int col)
	{ /*
		 * open site (row, col) if it is not open already if the element is 0,
		 * set it 1. Then union the open site with its neighbors if they have
		 * already been opened. If the site is in the top or bottom row, union
		 * it with the virtual site
		 */
		validate(row, col);
		if (arr[row - 1][col - 1] == 0)
		{
			arr[row - 1][col - 1] = 1;
			count++;
			
			int row1D = to1D(row, col);
			if (row == 1)
				helper.union(0, col);
			if (row == n)
				helper.union(row1D, n * n + 1);
			if (row>1&&arr[row - 2][col - 1] == 1 )
				helper.union(row1D - n, row1D);
			if (row<n&&arr[row][col - 1] == 1 )
				helper.union(row1D, row1D + n);
			if (col>1&&arr[row - 1][col - 2] == 1 )
				helper.union(row1D - 1, row1D);
			if (col<n&&arr[row - 1][col] == 1 )
				helper.union(row1D, row1D + 1);
			
		}
	}

	private void validate(int x, int y)
	{
		if (x < 1 || x > n || y < 1 || y > n)
		{
			throw new IndexOutOfBoundsException("index is not between 0 and " + (n - 1));
		}
	}

	private int to1D(int x, int y)
	{
		return ((x - 1) * n + y);
	}

	public boolean isOpen(int row, int col)
	{
		// is site (row, col) open?
		validate(row, col);
		return (arr[row - 1][col - 1] == 1);
	}

	public boolean isFull(int row, int col)
	{// is site (row, col) full?
		validate(row, col);
		return (helper.connected(0, to1D(row, col)));
	}

	public int numberOfOpenSites()
	{// number of open sites
		return count;
	}

	public boolean percolates()
	{// does the system percolate?
		return (helper.connected(0, n * n + 1));
	}
}
