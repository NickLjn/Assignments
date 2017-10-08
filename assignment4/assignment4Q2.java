package assignment4;

public class assignment4Q2 {

	public static void main(String args[]) {
		Scissors s = new Scissors(5);
		Paper p = new Paper(7);
		Rock r = new Rock(15);
		System.out.println(s.fight(p) + " , " + p.fight(s));
		System.out.println(p.fight(r) + " , " + r.fight(p));
		System.out.println(r.fight(s) + " , " + s.fight(r));
	}

	public static abstract class Tool {
		protected int strength;
		protected char type;

		public void setStrength(int strength) {
			this.strength = strength;
		}

		public int getStrength() {
			return strength;
		}
		public void setType(char type){
			this.type = type;
		}
		public char getType(){
			return type;
		}

		public abstract boolean fight(Tool t);
		
	}
	
	
		static class Rock extends Tool {
			public Rock(int srength) {
				setStrength(strength);
				setType('r');
			}

			@Override
			public boolean fight(Tool t) {
				if (t.getType() == 's') {
					return this.getStrength()*2 > t.getStrength();
				}
				else if (t.getType() == 'p') {
					return this.getStrength()/2 > t.getStrength();
				}
				return this.getStrength() > t.getStrength();
			}

		}

		static class Paper extends Tool {
			public Paper(int srength) {
				setStrength(strength);
				setType('p');
			}

			@Override
			public boolean fight(Tool t) {
				if (t.getType() == 'r') {
					return this.getStrength()*2 > t.getStrength();
				}
				else if (t.getType() == 's') {
					return this.getStrength()/2 > t.getStrength();
				}
				return this.getStrength() > t.getStrength();
			}

		}
	

	static class Scissors extends Tool {
		public Scissors(int srength) {
			setStrength(strength);
			setType('s');
		}

		@Override
		public boolean fight(Tool t) {
			if (t.getType() == 'p') {
				return this.getStrength()*2 > t.getStrength();
			}
			else if (t.getType() == 'r') {
				return this.getStrength()/2 > t.getStrength();
			}
			return this.getStrength() > t.getStrength();
		}

	}
}
