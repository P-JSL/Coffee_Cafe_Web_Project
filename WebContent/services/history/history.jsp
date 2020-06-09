<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="../../css/history.css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${sessionScope.user  == 0 }">
		<c:import url="../../header_0.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user == 1 }">
		<c:import url="../../header.jsp"></c:import>
	</c:when>
	<c:when test="${sessionScope.user==2 }">
		<c:import url="../../header_2.jsp"></c:import>
	</c:when>
</c:choose>
<%
	String p = request.getContextPath();
%>
<link rel="stylesheet" href="https://unpkg.com/swiper/css/swiper.css">
<link rel="stylesheet"
	href="https://unpkg.com/swiper/css/swiper.min.css">

<script src="https://unpkg.com/swiper/js/swiper.js"></script>
<script src="https://unpkg.com/swiper/js/swiper.min.js"></script>
<!-- Link Swiper's CSS -->
<link rel="stylesheet" href="<%=p%>/css/swiper.min.css">
<link rel="stylesheet" href="<%=p%>/css/swiper_silder.css">
<!-- Demo styles -->
</head>
<body>
	<div class="container">
		<!-- Swiper -->
		<div class="swiper-container">
			<div class="swiper-wrapper">
				<div class="swiper-slide">
					<h4>COFFEE HISTORY's</h4>

					<div class="container">
						<div class="image">
							<img src="<%=p%>/img/coffee_bean.jpg"
								style="display: inline-block; max-width: 400px; max-height: 200px;">
						</div>
						<div class="intro">コーヒーが飲料になったきっかけは？</div>

						<div class="begin">
							<p>2000年代に入ってから人々が集まる場所でコーヒー一杯は欠かせないほど、現在のコーヒーは大衆的な飲料として席を占めた。
								もうコーヒー専門のフランチャイズ店が
								もう2000個以上になるほどにコーヒーに関心が高まっていて、またコーヒー市場は競争が激しい。
								初めての発見当時、人々は野良のコーヒーの実をそのまま食べたそうだ。 けれど、その味が非常に刺激的だったので水を入れて飲み、
								その日以来薬のように煮って飲みながら全世界に広められた。
								豆によって味と香りが違るコーヒーはコーヒーの木から年1回ずつ収穫され、様々な成分を含めている。
								赤黒い色のしょっぱくて苦い実が世界から最も消費される飲料になった理由は何なんだろうか。</p>
						</div>
						<h4>コーヒー発祥における２つの伝説</h4>
						<p>コーヒー発見には、数多くある伝説の内、二大伝説と言われるものがあります。
							それはキリスト教国での説である「ヤギ飼いカルディの話（エチオピア起源説）」とイスラム教国の説である「僧侶シェーク・オマールの話（アラビア起源説）」です。
						</p>
						<div class="middle">
							<h5>1.ヤギ飼いカルディの話（エチオピア起源説）</h5>
							<div class="container">
								<div>
									<img src="<%=p%>/img/abc.jpg"
										style="display: block; margin: 0 auto;">
								</div>
							</div>

							<span>
								この説は、レバノンの言語学者ファウスト・ナイロニの「眠りを知らない修道院」（1671年）に記されているもので、６世紀頃のエチオピア高原が舞台です。

								ヤギ飼いカルディは、或る日放し飼いにしていたヤギ達が昼夜の別なくひどく興奮しているのを発見しました。

								調べてみると、どうも丘の中腹に自生している潅木の赤い実を食べたらしいのです。

								近くの修道僧にこれを告げると、それでは試しに食べてみようということになり、食べてみると気分はみるみる爽快になり、体に活力がみなぎってきたのです。

								僧はさっそく僧院に持ち帰り、ほかの僧たちにも勧めました。
								それからは徹夜の宗教行事のときに睡魔に苦しむ僧はいなくなったということです。 僧侶シェーク・オマールの話（アラビア起源説）
								こちらは、回教徒アブダル・カディの「コーヒー由来書」（1587年）に記されているお話で、１３世紀頃のイエメン山中が舞台です。

								回教僧のシェーク・オマールは、無実の罪でイエメンのモカからオーサバというところへ追放されてしまいました。
								食べるものもなく山中をさまよい歩いていると、一羽の鳥が赤い木の実をついばんでは陽気にさえずっているのを見つけたのです。
								ためしにその実を摘んで煮出すと、何ともいえない独特の香りがし、飲んでみると、疲れが嘘のように消え去って元気が回復しました。
								その後、医者でもあった彼はこの実を使ってたくさんの病人を救いました。
								そして罪を許されて再びモカへ帰り、聖者として人々にあがめられたということです。 ＜どちらの伝説が正しいの？＞

								管理人の見解ですが、エチオピアは人類の祖先ホモ・サピエンスが住んでいたところでもあります。
								また、野生のコーヒーの木は、エチオピアをはじめアフリカ大陸のあちこちで見つかっています。

								簡単ですが、上記のことを理由に、文字に残されている伝説より大昔に人々がコーヒーの赤い実を食べていてもおかしくないと考えています。
								コーヒー歴史は、エチオピアで始まったと言ってよいと思います。 </span> <br /> <br />
							<h5>２．アラビア諸国からヨーロッパに（１０世紀初頭-１５世紀頃）</h5>
							<div class="container">
								<div>
									<img src="<%=p%>/img/abc.jpg"
										style="display: block; margin: 0 auto;">

								</div>
							</div>

							<span>
								その後、コーヒーは１０世紀初頭から人々に飲まれ始めたのではないかと考えられています。それは、アラビアの医師ラーゼスが残した記録に、バンと呼ばれる乾燥したコーヒーの実を砕いて水に浸して煎じ、バンカムと呼んで医薬にしていたとかかれているからです。

								その約100年後に医学者で哲学者のアビセンナが、バンとバンカムについて、やはり「薬用」だと書き残しています。

								このような事から、コーヒーが飲まれ始めた当初は、薬として飲まれていたようです。

								その後、長い間コーヒーはイスラム教寺院の中だけに、門外不出の秘薬として伝えられていきました。夜通し行う宗教儀式の前に眠気を払う霊薬として飲まれたのです。そんな中、豆を煎って飲むようになったのは13世紀頃からと考えられています。

								13世紀中頃になって初めて、イスラム教の一般信者にその存在が知られ、寺院の回りはコーヒーの露天であふれかえり、人々は、儀式的にお祈りの前にコーヒーを飲むようになったといわれています。
								それからメッカ、カイロ、ダマスカスへと伝わっていき、
								14世紀中頃には世界最古のコーヒー店「カーネス」が当時のコンスタンチノープルに作られました。

								世界的な広まりをみせる中、人々の中でのコーヒーの高い人気に賛否両論が起こり、ついにメッカの地方長官カイル・ベイが「コーヒー禁止令」を発布して最初のコーヒー弾圧をしました。しかし、当時のエジプト国王・サルタンが大のコーヒー好きでありましたので、その「コーヒー禁止令」を知って激しく怒り、すぐさま禁止令を撤回して「コーヒーを飲むのはコーランの教えや宗教上の罪悪にはならない」と宣告しました。

								以後コーヒー弾圧は何度か繰り返されます。それだけコーヒーに魅せられる人が多かったということだと思います。

								こうして16世紀中ごろにはトルコへ、その後ヨーロッパへと上陸していきます。 </span> <br /> <br />
							<h5>３．ヨーロッパから世界各地へ（１５世紀初頭-現代）</h5>


							<span>
								ヨーロッパ諸国へのコーヒーの広がりは、15世紀初頭のベネチアを皮切りに、ヨーロッパ全土へと浸透していきます。

								ローマでは、イスラム教徒の飲み物をキリスト教徒が飲むのはどうかと、賛否両論が持ち上がります。当時の法王クレメンス８世は「悪魔の飲み物といわれるのにこんなにおいしい。これを異教徒に独占させておくのはもったいない」と、コーヒーに洗礼を施してキリスト教徒の飲み物として受け入れました。
								イギリスではコーヒーハウスが数多く作られ、紳士の社交場として人気を博しました。男たちはここで政治を語り文学を論じ、ビジネスを展開しました。

								当時コーヒーハウスに入れるのは男性だけで、中には家に帰らずに入り浸る男たちも現れる始末。そこで1670年代にはコーヒーハウスの閉鎖を求める主婦たちの嘆願書が出されています。

								フランスにもトルコ・コーヒーが伝わります。コーヒーはフランス上流階級をも魅了してやがてサロンが数多く作られ、新しい文学や哲学や芸術も生まれました。その波は一般市民にも及んで、あふれるほどの街角のカフェを生み出していきます。

								特に15世紀末に誕生した「カフェ・プロコプ」にはルソーやバルザックなどの文化人が次々に集い、知的サロンとしてにぎわいました。

								やがてフランスでドリップ式が、イタリアでエスプレッソが考案されて、コーヒーを飲むスタイルが徐々に変化していきます。

								これだけ世界的に人気のあったコーヒーですから、その栽培に興味を持った人たちもたくさんいました。13世紀にはメッカへの巡礼者たちが大量の生豆を持ち出し、それが各地に植えられ、１７世紀にもインド人のババ・ブーダンがイスラム巡礼の際に、メッカからコーヒーの実を盗み出して南インドのマイソールに植えています。

								また、18世紀前半にはフランス海軍の将校ド・クリュー自分の飲み水を注いでコーヒーの苗木を守り、フランス領マルチニーク島に運んだという話が残っています。これがやがて中南米へと広がって行たのです。こうしてコーヒーの広まりと同時にコーヒーの栽培も世界各地に拡大していったのです。
							</span> <br /> <br />
						</div>
					</div>
				</div>
			</div>
			<!-- Add Scroll Bar -->
			<div class="swiper-scrollbar"></div>
		</div>
		<!-- js -->

		<!-- Swiper JS -->
		<script src="<%=p%>/package/js/swiper.min.js"></script>

		<!-- Initialize Swiper -->
		<script>
			var swiper = new Swiper('.swiper-container', {
				direction : 'vertical',
				slidesPerView : 'auto',
				freeMode : true,
				scrollbar : {
					el : '.swiper-scrollbar',
				},
				mousewheel : true,
			});
		</script>
		<%@include file="../../footer.jsp"%>
		</html>