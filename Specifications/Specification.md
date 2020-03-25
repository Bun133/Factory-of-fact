# Factory of fact 仕様書

## 見出し
- [全体](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md)
  - [シーン](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#シーン)
    - [タイトル](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#タイトル)
    - [マップ選択](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#マップ選択)
    - [マップ](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#マップ)
  - [仕様(可視範囲)](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#仕様(可視範囲))
    - [プレイヤー](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#プレイヤー)
        - [クラフト](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md)
        - [組み立て](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#組み立て)
        - [インベントリー](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#インベントリー)
    - [コア](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#コア)
    - [敵](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#敵)
    - [鉱石](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#資源)
    - [機械](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#機械)
      - [加工機器](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#加工機器)
      - [採掘(無から有を生み出す系)機器](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#採掘(無から有を生み出す系)機器)
      - [その他機器](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#その他機器)
    - [電力](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#電力)
      - [消費](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#消費)
      - [発電機器](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#発電機器)
    - [液体](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#液体)
    - [回路](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#回路)
    - [研究](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#研究)
      - [研究装置](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#研究装置)
    - [アイテム](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#アイテム)
    - [ブロック](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.mdブロック)
  - [仕様(不可視範囲)](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#仕様(不可視範囲))
    - [エンティティ](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#エンティティ)
    - [チャンク](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#チャンク)
    - [マップ生成](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#マップ生成)





# シーン

シーンごとに把握していきます。
## タイトル
上部に[ロゴ](https://github.com/Bun133/Factory-of-fact/blob/div/src/assets/textures/title/Factory_of_fact_logo.png)を配置。
その下に、横並びにボタン類
- マップ選択
- セーブデータ書き出し
- ~~マルチプレイ~~
- ホームベース開発
- 退出

## マップ選択
- リスト形式で表示(できればマップのオーバービュー)
  - 押されたら読み込み
- 退出
## マップ
- プレイヤーさんはここで永久に働いてね！
# 仕様(可視範囲)
**可視範囲の**仕様について書いていきます
## プレイヤー
プレイヤーは開始時に[**コア**](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#コア)と少量の資源が与えられます。<br>
また、手詰み防止のために、プレイヤーは時間はかかりますが、石材、木材はフィールド上の鉱脈から入手できます。
### クラフト
クラフトについてです。<br>
[プレイヤー](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#プレイヤー)は[インベントリー](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#インベントリー)でクラフトができます。<br>
クラフトは2種類または1種類のアイテムを原材料とできます。<br>
また、[組み立て台](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#組み立て台)を使用して[組み立て](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#組み立て)ることもできます
### 組み立て
プレイヤーは[組み立て台](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#組み立て)を使用することで、3種類以上のアイテム、素材を組み立て(まあクラフトなんだけどね)ができます<br>
3種類以上ということは実質はいくつでもクラフトできます。(そんなレシピ。作らせない。)<br>
また、組み立てにはGUIが用意されており、上部にレシピ([研究](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#研究)する必要があります。)が表示され、そのボタンをクリック(長押しで作れるだけ作る)することで組み立てられます。<br>
また、組み立てしたものはキューとして追加され、次第にプレイヤーがキューを処理することで組み立てが完了します。
### インベントリー
プレイヤーはいつ何時でもインベントリーを開けます。<br>
ただし、**時間は止まりません**<br>
プレイヤーは10×4のインベントリースロットが与えられます。<br>
また、その際に1つの欄にスタックできる数は、アイテムにより異なります。<br>
<br>
また、インベントリーでプレイヤーは[クラフト](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#クラフト)できます。
## コア
コアはプレイヤーがコアにインタラクトすることで表示される、GUIを通じ、表示されるアイテムや資源を納品することで、[**研究**](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#研究)**済みの重要な**新しいブロックやアイテムなどをアンロックできます。<br>
**重要でないものは必要ありません**<br>
要求されるアイテムはランクが上がるにつれ、高価なものが要求されます。
## ホームベース
[計算結果](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#計画的撤退時の資源計算について)に基づいてプレイヤーはホームベースに資源を持ち帰ることが可能となります。<br>
この資源はタイトル(要検討)にあるホームベース開発から[Tier](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#Tier)及び[他社製製品](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#他社製製品)の使用ライセンスなどを資源と引き換えに使用可能です。<br>
## 敵
敵はマップ上にランダムで配置された敵の拠点から定期的に(Wave)敵がプレイヤーの重要建造物やコアめがけて攻撃してきます。<br>
敵自体も時間経過および、プレイヤーのアンロックにつれ強くなっていきます。<br>
そのうち、プレイヤーの技術を真似し、タレットを使うようになるかもしれません<br>
敵の拠点自体はWave時以外の時でも攻撃可能です。<br>
また、敵の拠点を破壊することで、そこにある資材やブロックを解体することで、資材の入手が可能です。
## ゲームクリアについて
[敵](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#敵)が行う[Wave](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#Wave)のWave数(マップにより異なるが数Waveごと)に[計画的撤退](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#計画的撤退)が可能です。<br>
これが事実上のゲームクリアです。<br>
(敵の親玉倒してゲームクリアのモードも検討中)
## 計画的撤退
計画的撤退についての説明です。<br>
プレイヤーは数[Wave](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#Wave)ごとに計画的撤退が可能となります。<br>
イメージとしてはその星(?)への植民を終了するものです。<br>
プレイヤーは通常モードであればWaveを耐えることになりますが、これに耐えられないと思ったとき、あるいはほかの理由でこのプロセスを発動させます。<br>
### 計画的撤退時の資源計算について
計画的撤退時に存在する建造物の建設必要資源*0.3+コア内の資源を[ホームベース](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#ホームベース)に持ち帰ることが可能です。//TODO
## 資源
- [ランク](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#ランク)
- [出現確立](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#出現確立)
### ランク
資源ごとのランクについて解説していきます。
効率、耐久力は主にツールや機械に影響し、
耐熱性、放熱性はオーバーヒート関連で、
回路化欄で、回路に出来るかどうか、
またその際の効率もこの表の効率に影響します。
#### クラフト可能なもの
クラフトが可能なもの(つまり、燃料や製錬前の資材を除く)

|資源名|効率|耐久力|耐熱性|放熱性|回路化|
|:------|:------|:------|:------|:------|:------|
|木材|1|1|0.1|0.001|:x:|
|石|2|2|2|2|0.01|:x:|
|石材|3|5|3|0.01|:x:|
|銅|5|10|10|4|:white_check_mark:|
|鉄|5|15|15|0.8|:x:|
|金|15|7|15|2|:white_check_mark:|
|ダイヤモンド|10|50|35|20|:white_check_mark:|
#### クラフト不可能なもの
クラフト不可能なもの(つまり燃料など。)
**製錬前の資源は使い道ない**ので表記しません

##### 燃料
効率は、木材の時を100として、それに比例して効率を表記しています。
|資源名|燃焼時間|効率|
|:----|:-----|:----|
|[木材](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#木材)|1|100|
|[コークス](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#コークス)|1|125|
|[石炭](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#石炭)|2|125|


### 出現確立
資源の出現確立などを説明します

|資源名|出現確立|出現規模|説明|プレイヤー破壊|
|:-------|:-------|:--------|:-------|:-----|
|木材|高い|小規模~大規模|[木材](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#木材)|:white_check_mark:|
|石|かなり高い|大規模|[石](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#石)|:white_check_mark:|
|石炭|普通|小規模~中規模|[石炭](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#石炭)|:white_check_mark:|
|銅鉱石|普通|中規模|[銅鉱石](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#銅鉱石)|:x:|
|鉄鉱石|普通|小規模~中規模|[鉄鉱石](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#鉄鉱石)|:x:|
|金鉱石|低い|小規模|[金鉱石](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#金鉱石)|:x:|
|ダイヤモンド鉱石|かなり稀|ごく小規模~小規模|[ダイヤモンド鉱石](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#ダイヤモンド鉱石)|:x:|

### コークス
木材を加工する以外にはこのアイテムを入手する方法はなく、多くの場合木材よりも**効率が良い燃料**として用いられる。
### 石
石は土以外の地面を主に構成する。<br>
多くの場合、**クラフトには用いられない**(形が不ぞろいであるため)<br>
また、加工することで[石材](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#石材)になる。

### 銅鉱石
フィールド上から採掘できる。<br>
[溶鉱炉](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#溶鉱炉)で製錬することで、[銅](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#銅)になる

### 鉄鉱石
フィールド上に出現するものを採掘することで得られる。<br>
この状態では利用することができず、[溶鉱炉](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#溶鉱炉)を通して[鉄](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#鉄)にする必要がある

### 金鉱石
フィールド上から採掘できる。
[溶鉱炉](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#溶鉱炉)で製錬すると[金](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#金)になる。

### ダイヤモンド鉱石
製錬すると[ダイヤモンド](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#ダイヤモンド)になる

## 機械

### 加工機器
#### 組み立て台
#### 電子プリンター
#### 溶鉱炉

### 採掘(無から有を生み出す系)機器
採掘機の性能一覧
|名称|効率|必要物資|
|:----|:----|:----|
|[石製採掘機](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#石製採掘機)|1|無し(ノーリソースっていいね！)|
|[タービン採掘機](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#タービン採掘機)|5|[石炭](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#石炭)|
|[スチーム採掘機](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#スチーム採掘機)|10|[水](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#水) [石炭](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#石炭)or[木材](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#木材)|
#### 石製採掘機
石製採掘機は初期に作るべきものの一つです。
また、石製採掘機は[木材](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#木材)と[石材](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#石材)で構成されています。<br>
#### タービン採掘機
[組み立て台](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#組み立て台)で石材でできます。<br>
燃料に[石炭](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#石炭)が必要ですが、とても使いやすいものになっています。
#### スチーム採掘機
[組み立て台](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#組み立て台)で鉄、石材で組み立てられます。<br>
ただ、これを初期には使うことはおすすめできません。<br>
なぜなら、[水](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#水)と[石炭](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#石炭)が必要だからです。<br>
2種類搬入はめんどくさいですよ～
### その他機器

## 電力

### 消費

### 発電機器

## 液体
### 水
多くの場合、初めて目にするであろう液体です。<br>
多くの場合は加熱してスチームにするか、冷却用として使います。
## 回路
基盤と回路図、素材を[電子プリンター](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#電子プリンター)を用いて作成できる。<br>
### 回路図
回路図は[研究](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#研究)でアンロックできる。
作成は必要ない。(と、私のBrainが言っている。)<br>
アンロックされるものに応じて回路と合わせての組み立て後の機能が違ってくる。
### 低グレード回路
銅を用いて作られる回路のグレード<br>
回路図が良いものでも、かなりの機能が失われる。
### 中グレード回路
金を用いて作られる回路のグレード<br>
回路図通りの機能が使用できる。
### 高グレード回路
ダイヤモンドを用いて作られる回路のグレード<br>
回路図よりも上位、または別の機能も併せて使用できる。
## Tier
Tierは[研究](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#研究)の大本となる考えで、高Tierの技術をアンロックすることで、高い技術を必要とする製品を製造可能です。<br>
**多くの場合このTierの解放をする機会はごくは稀です。**
## 研究
研究装置によってたまった、メカニカルポイントを[研究端末](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#研究端末)で使用し、研究する。<br>
高グレード帯や、重要なアイテムなどは使用時に[コア](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#コア)への納品が必要である。
### 研究装置
#### 研究端末
現在取得している技術を中心に発展内容がツリー状に表示されれる。<br>
アンロックするときは、メカニカルポイントを用意し、習得したい技術をクリックし、「習得」と書かれたボタンを押す。<br>
また、モノによっては[コア](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#コア)で納品の必要がある。
#### スパコン
恐ろしい量の計算ができる。<br>
また、大量の電気を使用する。<br>
**ほぼ、確実に接続した電力網が落ちる。**<br>
その代わり、かなりのスピードで研究が進む。
## アイテム

### 木材
林・森としてワールド中に存在する基本資源。
多くの場合、燃料として使用されるか、加工されて[コークス](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#コークス)になる。
### 石材
機械の大半の原材料となるもの。<br>
石を採掘し、加工することによって得られる。<br>
ある程度の耐久、耐熱能力を持つ。ただ、放熱能力が乏しい。放熱するべきところで用いるべきではない。
### 石炭
採掘により得られる。<br>
主に燃料として用いられるが、固めて加工することで[黒鉛](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#黒鉛)ができる
### 黒鉛
石炭を固めることでできる。
低グレードの回路作成に用いる。
### 銅
銅は主に鉄に変わる廉価な素材として扱われる。<br>
ただし、鉄と違い回路に用いることができる。<br>
また、その際は[低グレード回路](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#低グレード回路)ができる。
### 鉄
鉄鉱石を製錬することで得られる。<br>
多くの場合、石材で作られたもののアップグレードとして利用できる。<br>
また、そこそこの耐久、耐熱能力を持ち、放熱能力も有する。
### 金
金鉱石を製錬するとできる。<br>
鉄よりも上位の素材だが、耐久力が乏しい。<br>
ダイアモンド除くその他すべての素材よりも熱伝導率が良い。<br>
銅鉱石より上位の素材として基盤にも用いられる。<br>
また、その際は[中グレード回路](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#中グレード回路)ができる。
### ダイヤモンド
全ての素材、全ての面において最強の素材。<br>
耐久力もよく、熱伝導率がとてつもなく良い。<br>
回路にすることもでき、[高グレード回路](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#高グレード回路)を作成できる。<br>
また、その回路を使用してスパコンを作成できる
## ブロック
## 他社製製品
他社植民用製品(ガン、タレット、コンベア)などのことを指します。<br>
通常他社製製品を使用する際はTierごとにホームベース開発内からライセンスの取得が必要です。
# 仕様(不可視範囲)

## エンティティ

## チャンク

## マップ生成
