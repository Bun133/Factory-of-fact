# Factory of fact 仕様書

## 見出し
- [全体](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md)
  - [シーン](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#シーン)
    - [タイトル](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#タイトル)
    - [マップ選択](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#マップ選択)
    - [マップ](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#マップ)
  - [仕様(可視範囲)](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#仕様(可視範囲))
    - [プレイヤー](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#プレイヤー)
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
    - [回路](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#回路)
    - [研究](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#研究)
      - [研究装置](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#研究装置)
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
プレイヤーは開始時に[**コア**](https://github.com/Bun133/Factory-of-fact/blob/div/Specification.md#コア)と少量の資源が与えられます。
また、手詰み防止のために、プレイヤーは時間はかかりますが、石材、木材、鉄鉱石はフィールド上の鉱脈から入手できます。
## コア
コアはプレイヤーがコアにインタラクトすることで表示される、GUIを通じ、表示されるアイテムや資源を納品することで、[**研究**](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#研究)**済みの重要な**新しいブロックやアイテムなどをアンロックできます。
**重要でないものは必要ありません**
要求されるアイテムはランクが上がるにつれ、高価なものが要求されます。
## 敵
敵はマップ上にランダムで配置された敵の拠点から定期的に(Wave)敵がプレイヤーの重要建造物やコアめがけて攻撃してきます。
敵自体も時間経過および、プレイヤーのアンロックにつれ強くなっていきます。
そのうち、プレイヤーの技術を真似し、タレットを使うようになるかもしれません
敵の拠点自体はWave時以外の時でも攻撃可能です。
また、敵の拠点を破壊することで、そこにある資材やブロックを解体することで、資材の入手が可能です。
## 資源
資源の出現確立などを説明します

|資源名|出現確立|出現規模|説明|プレイヤー破壊|
|:-------|:-------|:--------|:-------|:-----|
|木材|高い|小規模~大規模|[木材](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#木材)|:white_check_mark:|
|石|かなり高い|大規模|[石](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#石)|:white_check_mark:|
|石炭|普通|小規模~中規模|[石炭](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#石炭)|:white_check_mark:|
|銅鉱石|普通|中規模|[銅鉱石](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#銅鉱石)|:x:|
|鉄鉱石|普通|小規模~中規模|[鉄鉱石](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#鉄鉱石)|:x:|
|金鉱石|低い|小規模|[金鉱石](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#金鉱石)|:x:|
|ダイアモンド鉱石|かなり稀|ごく小規模~小規模|[ダイアモンド鉱石](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#ダイアモンド鉱石)|:x:|
### 木材
林・森としてワールド中に存在する基本資源。
多くの場合、燃料として使用されるか、加工されて[コークス](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#コークス)になる。
### コークス
木材を加工する以外にはこのアイテムを入手する方法はなく、多くの場合木材よりも**効率が良い燃料**として用いられる。
### 石
石は土以外の地面を主に構成する。
初期は重宝する。
また、加工することで[石材](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#石材)になる。
### 石材
機械の大半の原材料となるもの。
石を採掘し、加工することによって得られる。
ある程度の耐久、耐熱能力を持つ。ただ、放熱能力が乏しい。放熱するべきところで用いるべきではない。
### 石炭
採掘により得られる。
主に燃料として用いられるが、固めて加工することで[黒鉛](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#黒鉛)ができる
### 黒鉛
石炭を固めることでできる。
低グレードの回路作成に用いる。
### 銅鉱石
フィールド上から採掘できる。
[溶鉱炉](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#溶鉱炉)で製錬することで、[銅](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#銅)になる
### 銅
銅は主に鉄に変わる廉価な素材として扱われる。
ただし、鉄と違い回路に用いることができる。
また、その際は[低グレード回路](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#低グレード回路)ができる。
### 鉄鉱石
フィールド上に出現するものを採掘することで得られる。
この状態では利用することができず、[溶鉱炉](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#溶鉱炉)を通して[鉄](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#鉄)にする必要がある
### 鉄
鉄鉱石を製錬することで得られる。
多くの場合、石材で作られたもののアップグレードとして利用できる。
また、そこそこの耐久、耐熱能力を持ち、放熱能力も有する。
### 金鉱石
フィールド上から採掘できる。
[溶鉱炉](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#溶鉱炉)で製錬すると[金](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#金)になる。
### 金
金鉱石を製錬するとできる。
鉄よりも上位の素材だが、耐久力が乏しい。
ダイアモンド除くその他すべての素材よりも熱伝導率が良い。
銅鉱石より上位の素材として基盤にも用いられる。
また、その際は[中グレード回路](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#中グレード回路)ができる。
### ダイアモンド鉱石
製錬すると[ダイアモンド](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#ダイアモンド)になる
### ダイアモンド
全ての素材、全ての面において最強の素材。
耐久力もよく、熱伝導率がとてつもなく良い。
回路にすることもでき、[高グレード回路](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#高グレード回路)を作成できる。
また、その回路を使用してスパコンを作成できる
## 機械

### 加工機器
#### 電子プリンター
#### 溶鉱炉

### 採掘(無から有を生み出す系)機器

### その他機器

## 電力

### 消費

### 発電機器

## 液体

## 回路
基盤と回路図、素材を[電子プリンター](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#電子プリンター)を用いて作成できる。
### 回路図
回路図は[研究](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#研究)でアンロックできる。
作成は必要ない。(と、私のBrainが言っている。)
アンロックされるものに応じて回路と合わせての組み立て後の機能が違ってくる。
### 低グレード回路
銅を用いて作られる回路のグレード
回路図が良いものでも、かなりの機能が失われる。
### 中グレード回路
金を用いて作られる回路のグレード
回路図通りの機能が使用できる。
### 高グレード回路
ダイアモンドを用いて作られる回路のグレード
回路図よりも上位、または別の機能も併せて使用できる。
## 研究
研究装置によってたまった、メカニカルポイントを[研究端末](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#研究端末)で使用し、研究する。
高グレード帯や、重要なアイテムなどは使用時に[コア](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#コア)への納品が必要である。
### 研究装置
#### 研究端末
現在取得している技術を中心に発展内容がツリー状に表示されれる。
アンロックするときは、メカニカルポイントを用意し、習得したい技術をクリックし、「習得」と書かれたボタンを押す。
また、モノによっては[コア](https://github.com/Bun133/Factory-of-fact/edit/div/Specification.md#コア)で納品の必要がある。
#### スパコン
恐ろしい量の計算ができる。
また、大量の電気を使用する。
**ほぼ、確実に接続した電力網が落ちる。**
その代わり、かなりのスピードで研究が進む。
## アイテム

## ブロック

# 仕様(不可視範囲)

## エンティティ

## チャンク

## マップ生成
