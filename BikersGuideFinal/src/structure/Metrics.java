package structure;

public class Metrics {
	
	public Integer distance = Integer.MAX_VALUE;
	public Integer elevation = Integer.MAX_VALUE;
	public Float weight = Float.MAX_VALUE;
	
	public Metrics(Integer distance,Integer elevation)
	{
		this.distance = distance;
		this.elevation = elevation;
		weightCalculator(distance,elevation);
	}
	
	public Metrics()
	{
		this.distance = Integer.MAX_VALUE;
		this.elevation = Integer.MAX_VALUE;
		this.weight = Float.MAX_VALUE;
	}
	
	public void weightCalculator(Integer distance, Integer elevation)
	{
		
		if(distance==0 || distance==Integer.MAX_VALUE)
			weight = (float) distance;
		else
		{
			if(elevation<0)
				weight = (float) 1;
			else
			{
				Float hypotenuse = (float) Math.sqrt(distance*distance + elevation*elevation);
				weight = (float) (distance * 70 * 9.8 * ((distance + elevation)/hypotenuse));
			}
			
			
		}
			
		
	}


}
