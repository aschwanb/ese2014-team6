package ch.studihome.jspserver.model.pojos;

public class SearchForm
{
	private long id;
	private int minprice;
	private int maxprice;
	private int minroomsize;
	private int maxroomsize;
	private int minappartmentsize;
	private int maxappartmentsize;
	private int minnumberofinhabitants;
	private int maxnumberofinhabitants;
	private String area;
	private String typeofapartment;
	
	public SearchForm()
	{
		this.minprice = 0;
		this.maxprice = Integer.MAX_VALUE;
		this.minroomsize = 0;
		this.maxroomsize = Integer.MAX_VALUE;
		this.minappartmentsize = 0;
		this.maxappartmentsize = Integer.MAX_VALUE;
		this.minnumberofinhabitants = 0;
		this.maxnumberofinhabitants = Integer.MAX_VALUE;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getMinprice() {
		return minprice;
	}
	
	public void setMinprice(int minprice) {
		this.minprice = minprice;
	}
	
	public int getMaxprice() {
		return maxprice;
	}
	
	public void setMaxprice(int maxprice) {
		this.maxprice = maxprice;
	}
	
	public int getMinroomsize() {
		return minroomsize;
	}
	
	public void setMinroomsize(int minroomsize) {
		this.minroomsize = minroomsize;
	}
	
	public int getMaxroomsize() {
		return maxroomsize;
	}
	
	public void setMaxroomsize(int maxroomsize) {
		this.maxroomsize = maxroomsize;
	}
	
	public int getMinappartmentsize() {
		return minappartmentsize;
	}
	
	public void setMinappartmentsize(int minappartmentsize) {
		this.minappartmentsize = minappartmentsize;
	}
	
	public int getMaxappartmentsize() {
		return maxappartmentsize;
	}
	
	public void setMaxappartmentsize(int maxappartmentsize) {
		this.maxappartmentsize = maxappartmentsize;
	}
	
	public int getMinnumberofinhabitants() {
		return minnumberofinhabitants;
	}
	
	public void setMinnumberofinhabitants(int minnumberofinhabitants) {
		this.minnumberofinhabitants = minnumberofinhabitants;
	}
	
	public int getMaxnumberofinhabitants() {
		return maxnumberofinhabitants;
	}
	
	public void setMaxnumberofinhabitants(int maxnumberofinhabitants) {
		this.maxnumberofinhabitants = maxnumberofinhabitants;
	}
	
	public String getArea() {
		return area;
	}
	
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getTypeofapartment() {
		return typeofapartment;
	}
	
	public void setTypeofapartment(String typeofapartment) {
		this.typeofapartment = typeofapartment;
	}
	
	
}
