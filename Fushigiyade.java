package churimon;

public class Fushigiyade extends Monster3{
	Fushigiyade(){
		super();
		super.setCharacter("フシギヤデ");
	}
	
	Fushigiyade(String trainer, String name){
		super(trainer, name);
		super.setCharacter("フシギヤデ");
	}
	
	Fushigiyade(String trainer, String name, int level){
		super(trainer, name, level);
		super.setCharacter("フシギヤデ");
	}
	
	public void levelUp(int risingLevel)
	{
		this.setLv(this.getLv() + 1 * risingLevel);
		this.setHp(this.getHp() + 31 * risingLevel);
		this.setAtk(this.getAtk() + 6 * risingLevel);
		this.setDef(this.getDef() + 7 * risingLevel);
		this.setSpd(this.getSpd() + 8 * risingLevel);
		this.setHpMax(this.getHp());
	}
}
