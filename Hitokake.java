package churimon;

public class Hitokake extends Monster3{
	Hitokake(){
		super();
		super.setCharacter("ヒトカケ");		
	}
	
	Hitokake(String trainer, String name){
		super(trainer, name);
		super.setCharacter("ヒトカケ");		
	}
	
	Hitokake(String trainer, String name, int level){
		super(trainer, name, level);
		super.setCharacter("ヒトカケ");		
	}
	
	/**
	 * 上昇レベルに従ってステータスを上昇させます。
	 * @param risingLevel
	 */
	public void levelUp(int risingLevel)
	{
		this.setLv(this.getLv() + 1 * risingLevel);
		this.setHp(this.getHp() + 29 * risingLevel);
		this.setAtk(this.getAtk() + 8 * risingLevel);
		this.setDef(this.getDef() + 5 * risingLevel);
		this.setSpd(this.getSpd() + 9 * risingLevel);
		this.setHpMax(this.getHp());
	}
}
