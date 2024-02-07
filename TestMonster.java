package churimon;

//検証用クラス
class TestMonster {
	public static void main (String[] args) {
		Monster3 mos = new Monster3();
		System.out.println(mos);
		mos.levelUp(10);
		System.out.println(mos);
	}
}