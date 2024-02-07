package churimon;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Monster1 {
	final String WAZA_REGEXP = "^[0-9]+¥¥.[0-9]$";
	final String DMG_CORRECTION_120 = "120";
	final String DMG_CORRECTION_1 = "1";
	
	/**
	 * フィールドを定義
	 */
	String character = "(unknown)";
	String trainer = "(wild)";
	String name = "(noname)";
	int lv = 1;
	int hp = 80;
	int atk = 15;
	int def = 10;
	int spd = 10;
	int hpMax = 80;
	String wazaNm = "たいあたり";
	String wazaDmgRate = "1.0";
	
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
		int dmg = (bdAtk.multiply(bdWazaDmgRate)).intValue();
		return dmg;
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
		
		BigDecimal damageRate = bgDaCr1.divide( bgDaCr1.add( bgDef.divide(bdDaCollection120, 2, RoundingMode.DOWN) ), 2, RoundingMode.DOWN );
		int dag = ((bdDag.multiply(damageRate)).setScale(0, RoundingMode.DOWN)).intValue();
		
		if(hp > dmg) {
			this.hp -= dag;
		}else {
			this.hp = 0;
		}
		return dag;
	}
}
