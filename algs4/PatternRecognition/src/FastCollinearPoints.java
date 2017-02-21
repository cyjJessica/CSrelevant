import java.util.ArrayList;
import java.util.Arrays;

public class FastCollinearPoints
{

	private ArrayList<LineSegment> seg = new ArrayList<LineSegment>();

	public FastCollinearPoints(Point[] points)
	{
		// finds all line segments containing 4 or more points
		Point[] copypoint = new Point[points.length];

		for (int i = 0; i < points.length; i++)
		{
			if (points[i] == null)
				throw new java.lang.NullPointerException();
			copypoint[i] = points[i];
		}

		Arrays.sort(copypoint);

		
		for (int i = 0; i < points.length - 1; i++)
		{

			if (copypoint[i].compareTo(copypoint[i + 1]) == 0)
			{
				throw new java.lang.IllegalArgumentException();
			}
		}

		for (int i = 0; i < points.length - 3; i++)
		{
			//Arrays.sort(copypoint);
			Arrays.sort(copypoint, copypoint[i].slopeOrder());
			System.out.println("start");
			for (Point p : copypoint)
			{
				
				System.out.println(p);
			}
			for (int k = 0, first = 1, last = 2; last < copypoint.length; last++)
			{
				while (last < copypoint.length && Double.compare(copypoint[k].slopeTo(copypoint[first]),
						copypoint[k].slopeTo(copypoint[last])) == 0)
					last++;

				if (last - first >= 3 && copypoint[k].compareTo(copypoint[first]) < 0)
					seg.add(new LineSegment(copypoint[k], copypoint[last - 1]));

				first = last;
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

	public static void main(String[] args)
	{
		Point p1 = new Point(1234, 5678);
		Point p2 = new Point(14000, 10000);
		Point p3 = new Point(18000, 10000);
		Point p4 = new Point(19000, 10000);
		Point p5 = new Point(21000, 10000);
		Point p6 = new Point(32000, 10000);
		Point[] point = { p1, p2, p3, p4, p5, p6 };
		FastCollinearPoints collinear = new FastCollinearPoints(point);

	}
}