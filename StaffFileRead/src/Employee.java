class Employee
{
	private String name;

	private int age;

	private double lengthOfService;

	public Employee(String name, int age, double lengthOfService)
	{
		super();
		this.name = name;
		this.age = age;
		this.lengthOfService = lengthOfService;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public double getLengthOfService()
	{
		return lengthOfService;
	}

	public void setLengthOfService(double lengthOfService)
	{
		this.lengthOfService = lengthOfService;
	}
}
