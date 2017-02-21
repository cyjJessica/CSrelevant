import java.util.ArrayList;
import java.util.Arrays;
import edu.princeton.cs.algs4.*;

public class BruteCollinearPoints
{
	private ArrayList<LineSegment> seg = new ArrayList<LineSegment>();

	public BruteCollinearPoints(Point[] points)
	{
		// finds all line segments containing 4 points
		Point[] copypoint=new Point[points.length];
		for (int i=0;i<points.length;i++)
		{
			if (points[i]==null)
				throw new java.lang.NullPointerException();
		copypoint[i]=points[i];
		}
		
		for (int i=0;i<points.length;i++)
		{
			for (int j=i+1;j<points.length;j++)
			{
				if (points[i].compareTo(points[j])==0)
				{
					throw new java.lang.IllegalArgumentException();
				}
			}
		}
		
		Arrays.sort(copypoint);
		
		 for (int p = 0; p < copypoint.length - 3; p++) {
	            for (int q = p + 1; q < copypoint.length - 2; q++) {
	                for (int r = q + 1; r < copypoint.length - 1; r++) {
	                    for (int s = r + 1; s < copypoint.length; s++) {
	                        if (copypoint[p].slopeTo(copypoint[q]) == copypoint[p].slopeTo(copypoint[r]) &&
	                        		copypoint[p].slopeTo(copypoint[q]) == copypoint[p].slopeTo(copypoint[s]))
	                        {
	                        	seg.add(new LineSegment(copypoint[p], copypoint[s]));
	                        }
	                    }
	                }
	            }
	        }
	}

	public int numberOfSegments()
	{
		// the number of line segments
		return seg.size();
	}

	public LineSegment[] segments()
	{
		// the line segments
		return seg.toArray(new LineSegment[seg.size()]);
	}
	
}
