## Pokemon CLI

## 
- コンストラクタで初期化の初期化の際にthis()を呼び出すことで、初期化の処理を共通化を行った。その後変更するフィールドに対して上書きを行う
- BigDecimalの使い方
  - 計算に必要な値はすべてBigDecimalで扱うことで、誤差をなくすことができる
  - メソッド(add,divide,subtract,multiply)を使って計算を行う
  - intValue()を使ってBigDecimalをintに変換する
  ```java
  		int dag = ((bdDag.multiply(damageRate)).setScale(0, RoundingMode.DOWN)).intValue();
  ```
  
