package Collections2;

	 
	public class Computer implements Comparable<Computer> {
		
		int id;
		String model;
		int ram;
		@Override
		public String toString() {
			return "Computer [id=" + id + ", model=" + model + ", ram=" + ram + "]";
		}
		@Override
		public int compareTo(Computer sira) {
			return sira.ram-this.ram;
		}
	}
