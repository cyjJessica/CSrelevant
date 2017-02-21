

import edu.princeton.cs.algs4.*;

public class PercolationStats
{
	private int n;
	private int trials;
	private Percolation per;
	private double fraction[];

	public PercolationStats(int n, int trials)
	{// perform trials independent experiments on an n-by-n grid
		validate(n, trials);
		this.n = n;
		this.trials = trials;
		allTrial();
	}

	private void validate(int x, int t)
	{
		if (x < 1 || t <= 0)
		{
			throw new IndexOutOfBoundsException("index is not between 0 and " + (n - 1));
		}
	}

	private void allTrial()
	{
		fraction = new double[trials];
		for (int i = 1; i <= trials; i++)
		{
			per = new Percolation(n);
			int openSite = 0;
			while (per.percolates() == false)

			{
				int row = StdRandom.uniform(1, n + 1);
				int col = StdRandom.uniform(1, n + 1);
				if (!per.isOpen(row, col))
				{
					per.open(row, col);
					openSite++;
				}

			}
			fraction[i - 1] = ((double) openSite) / (n * n);
			// fraction[i-1] = ((double)per.numberOfOpenSites())/(n*n);
		}
	}

	public double mean()
	{// sample mean of percolation threshold
		return StdStats.mean(fraction);

	}

	public double stddev()
	{
		// sample standard deviation of percolation threshold

		return StdStats.stddev(fraction);
	}

	public double confidenceLo()
	{// low endpoint of 95% confidence interval
		return mean() - 1.96 * stddev() / Math.sqrt(trials);
	}

	public double confidenceHi()
	{// high endpoint of 95% confidence interval
		return mean() + 1.96 * stddev() / Math.sqrt(trials);
	}

	public static void main(String[] args) 
	{// test client (described below)
		int N = Integer.parseInt(args[0]);
		int T = Integer.parseInt(args[1]);
		PercolationStats ps = new PercolationStats(N, T);
		System.out.println("mean:" + ps.mean() + "stddev:" + ps.stddev());
		System.out.println("95% confidential interval:" + ps.confidenceLo() + "," + ps.confidenceHi());
	}
}
