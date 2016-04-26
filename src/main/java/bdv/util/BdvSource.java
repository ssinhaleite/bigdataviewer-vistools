package bdv.util;

public abstract class BdvSource implements Bdv
{
	private BdvHandle bdv;

	// so that we can fix the bdv numTimepoints when removing sources.
	private final int numTimepoints;

	protected BdvSource( final BdvHandle bdv, final int numTimepoints )
	{
		this.bdv = bdv;
		this.numTimepoints = numTimepoints;
	}

	// invalidates this BdvSource completely
	// closes bdv if it was the last source
	public abstract void removeFromBdv();

	public abstract void setDisplayRange( final double min, final double max );

	public abstract void setDisplayRangeBounds( final double min, final double max );

	@Override
	public BdvHandle getBdvHandle()
	{
		return bdv;
	}

	protected void setBdvHandle( final BdvHandle bdv )
	{
		this.bdv = bdv;
	}

	protected abstract boolean isPlaceHolderSource();

	protected int getNumTimepoints()
	{
		return numTimepoints;
	}
}
