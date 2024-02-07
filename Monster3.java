package churimon;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Monster3 {
	final String WAZA_REGEXP = "^[0-9]+¥¥.[0-9]$";
	final String DMG_CORRECTION_120 = "120";
	final String DMG_CORRECTION_1 = "1";
	
	private String character;
	private String trainer;
	private String name;
	private int lv;
	private int hp;
	private int atk;
	private int def;
	private int spd;
	private int hpMax;
	private String wazaNm;
	private String wazaDmgRate;
	
	Monster3() {
		this.character = "(unknown)";
		this.trainer = "(wild)";
		this.name = "(noname)";
		this.lv = 1;
		this.hp = 80;
		this.atk = 15;
		this.def = 10;
		this.spd = 10;
		this.hpMax = 80;
		this.wazaNm = "たいあたり";
		this.wazaDmgRate = "1.0";
	}
	
	Monster3(String trainer, String name) {
		// デフォルト値は引数なしコンストラクタで定義しているのでここではthis()を使用し変えるところだけを上書きする
		this();
		this.trainer = trainer;
		this.name = name;
	}
	
	public Monster3(String trainer, String name, int firstLevel) {
		this(trainer, name);
		// 2以上であればレベアップする必要がある
		if(1 < firstLevel)
		{
			levelUp(firstLevel - 1);
		}
	}
	/**
	 * java.lang.ObjectクラスのtoStringメソッドをオーバーライド
	 */
	public String toString()
	{
		return "<フィールド確認> character: " +  this.character +  "/ trainer: " + this.trainer +  "/ name:" +  this.name + "/ lv: " + this.lv + "/ hp: " + this.hp + 
				 "/\n" + "atk:" + this.atk + "/ def:" + this.def +  "/ spd:" + this.spd +  "/ hpMax:" + this.hpMax +  "/ wazaNm:" + this.wazaNm +  "/ wazaDmgRate:" + this.wazaDmgRate;
	}
	
	/**
	 * 上昇レベルに従ってステータスを上昇させます。
	 * @param risingLevel
	 */
	public void levelUp(int risingLevel)
	{
		this.lv += risingLevel * 1;
		this.hpMax += risingLevel * 30;
		this.atk += risingLevel * 5;
		this.def += risingLevel * 5;
		this.spd += risingLevel * 5;
		this.hp = this.hpMax;
	}
	
	/**
	 * わざに関する情報を設定します。
	 * @param wagaName
	 * @param wazaBai
	 */
	public void setWaza(String wagaName, String wazaBai)
	{
		boolean isWazaBai = checkWazaBai(wazaBai);
		if(isWazaBai) {
			this.wazaNm = wagaName;
			this.wazaDmgRate = wazaBai;
		}else {
			System.out.println("[ERROR]わざの設定に失敗しました");
		}
	}
	
	/**
	 * 正規表現チェック
	 * チェック内容：引数2が「X…X.X(Xは0～9の数字のいずれか)」形式か
	 * @param wazaBai
	 * @return
	 */
	public boolean checkWazaBai(String wazaBai)
	{
		if(wazaBai.matches(WAZA_REGEXP)) {
			return true;
		}else {
			return false;
		} 
	}
	
	/**
	 * ステータスを表示します。
	 * @return
	 */
	public String getStatus()
	{
		return this.name + "lv:" + this.lv + "HP:" + this.hp + "/" +  this.hpMax;
	}
	
	/**
	 * わざを使用して相手にダメージを与えます。
	 * @return
	 */
	public int useWaza()
	{
		BigDecimal bdAtk = new BigDecimal(this.atk);
		BigDecimal bdWazaDmgRate = new BigDecimal(this.wazaDmgRate);
		int dag = (bdAtk.multiply(bdWazaDmgRate)).intValue();
		return dag;
	}
	
	/**
	 * 
	 * @param dmg
	 * @return
	 */
	public int damaged(int dmg)
	{
		// 使用する値をすべて10進数に変換する
		BigDecimal bdDag = new BigDecimal(dmg);
		BigDecimal bdDaCollection120 = new BigDecimal(DMG_CORRECTION_120);
		BigDecimal bgDaCr1 = new BigDecimal(DMG_CORRECTION_1);
		BigDecimal bgDef = new BigDecimal(this.def);
		
		// BigDecimal damageRate = bgDaCr1.divide(bgDaCr1.add(bgDef.divide(bgDef.divide(bdDaCollection120, 2, RoundingMode.DOWN))));
		BigDecimal damageRate = bgDaCr1.divide( bgDaCr1.add( bgDef.divide(bdDaCollection120, 2, RoundingMode.DOWN) ), 2, RoundingMode.DOWN );
		int dag = ((bdDag.multiply(damageRate)).setScale(0, RoundingMode.DOWN)).intValue();
		
		if(hp > dmg) {
			this.hp -= dag;
		}else {
			this.hp = 0;
		}
		return dag;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}

	public String getWazaNm() {
		return wazaNm;
	}

	public void setWazaNm(String wazaNm) {
		this.wazaNm = wazaNm;
	}

	public String getWazaDmgRate() {
		return wazaDmgRate;
	}

	public void setWazaDmgRate(String wazaDmgRate) {
		this.wazaDmgRate = wazaDmgRate;
	}
}
