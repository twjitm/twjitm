$(document).ready(function() {
	fiveChess.init();
});

var fiveChess = {
	NO_CHESS: 0,
	BLACK_CHESS: -1,
	WHITE_CHESS: 1,
	chessArr: [],	//记录棋子
	chessBoardHtml: "",
	humanPlayer: "black",	//玩家棋子颜色
	AIPlayer: "white",	//AI棋子颜色
	isPlayerTurn: true, //轮到player下棋
	totalGames: cookieHandle.getCookie("totalGames") || 0,	//总局数
	winGames: cookieHandle.getCookie("winGames") || 0,	//玩家赢局数
	isGameStart: false,	//游戏已经开始
	isGameOver: false, //游戏结束
	playerLastChess: [], //玩家最后下子位置
	AILastChess: [], //AI最后下子位置

	init: function () {
		this.chessBoardHtml = $("div.chessboard").html();
		var _fiveChess = this;
		//右侧操作按钮
		$(".operating-panel a").click(function (event) {
			event.preventDefault();
			var id = $(this).attr("id");
			if (_fiveChess.isGameStart && id !== "replay_btn" ) { return; }	//正在游戏 不操作
			switch (id) {
				case "black_btn":
					_fiveChess.humanPlayer = "black";
					_fiveChess.AIPlayer = "white";
					break;
				case "white_btn":
					_fiveChess.humanPlayer = "white";
					_fiveChess.AIPlayer = "black";
					break;
				case "first_move_btn":
					_fiveChess.isPlayerTurn = true;
					break;
				case "second_move_btn":
					_fiveChess.isPlayerTurn = false;
					break;
				case "replay_btn":
					_fiveChess.resetChessBoard();
					if (_fiveChess.isGameStart) {	//点重玩
						_fiveChess.gameOver();
					}
					else {	//点开始
						_fiveChess.gameStart();
					}
					break;
			}
			if (id !== "replay_btn") {
				$(this).addClass("selected").siblings().removeClass("selected");
			}
		});
		this.resetChessBoard();
		$("#result_info").html("胜率：" + (this.winGames * 100 / this.totalGames | 0) + "%");
	},
	//重置棋盘
	resetChessBoard: function () {
		$("div.chessboard").html(this.chessBoardHtml);
		$("#result_tips").html("");
		this.isGameOver = false;
		this.isPlayerTurn = $("#first_move_btn").hasClass("selected");
		//初始化棋子状态
		var i, j;
		for (i = 0; i < 15; i++) {
			this.chessArr[i] = [];
			for (j = 0; j < 15; j++) {
				this.chessArr[i][j] = this.NO_CHESS;
			}
		}
		//player下棋事件
		var _fiveChess = this;
		$("div.chessboard div").click(function () {
			if (!_fiveChess.isPlayerTurn || _fiveChess.isGameOver) {
				return;
			}
			if (!_fiveChess.isGameStart) {
				_fiveChess.gameStart();
			}
			var index = $(this).index(),
				i = index / 15 | 0,
				j = index % 15;
			if (_fiveChess.chessArr[i][j] === _fiveChess.NO_CHESS) {
				_fiveChess.playChess(i, j, _fiveChess.humanPlayer);
				if (i === 0 && j === 0) {
					$(this).removeClass("hover-up-left");
				}
				else if (i === 0 && j === 14) {
					$(this).removeClass("hover-up-right");
				}
				else if (i === 14 && j === 0) {
					$(this).removeClass("hover-down-left");
				}
				else if (i === 14 && j === 14) {
					$(this).removeClass("hover-down-right");
				}
				else if (i === 0) {
					$(this).removeClass("hover-up");
				}
				else if (i === 14) {
					$(this).removeClass("hover-down");
				}
				else if (j === 0) {
					$(this).removeClass("hover-left");
				}
				else if (j === 14) {
					$(this).removeClass("hover-right");
				}
				else {
					$(this).removeClass("hover");
				}
				_fiveChess.playerLastChess = [i, j];
				_fiveChess.playerWinOrNot(i, j);
			}
		});
		//鼠标在棋盘上移动效果
		$("div.chessboard div").hover(
			function () {
				if (!_fiveChess.isPlayerTurn || _fiveChess.isGameOver) { return; }
				var index = $(this).index(),
					i = index / 15 | 0,
					j = index % 15;
				if (_fiveChess.chessArr[i][j] === _fiveChess.NO_CHESS) {
					if (i === 0 && j === 0) {
						$(this).addClass("hover-up-left");
					}
					else if (i === 0 && j === 14) {
						$(this).addClass("hover-up-right");
					}
					else if (i === 14 && j === 0) {
						$(this).addClass("hover-down-left");
					}
					else if (i === 14 && j === 14) {
						$(this).addClass("hover-down-right");
					}
					else if (i === 0) {
						$(this).addClass("hover-up");
					}
					else if (i === 14) {
						$(this).addClass("hover-down");
					}
					else if (j === 0) {
						$(this).addClass("hover-left");
					}
					else if (j === 14) {
						$(this).addClass("hover-right");
					}
					else {
						$(this).addClass("hover");
					}
				}
			},
			function () {
				if (!_fiveChess.isPlayerTurn || _fiveChess.isGameOver) { return; }
				var index = $(this).index(),
					i = index / 15 | 0,
					j = index % 15;
					if (i === 0 && j === 0) {
						$(this).removeClass("hover-up-left");
					}
					else if (i === 0 && j === 14) {
						$(this).removeClass("hover-up-right");
					}
					else if (i === 14 && j === 0) {
						$(this).removeClass("hover-down-left");
					}
					else if (i === 14 && j === 14) {
						$(this).removeClass("hover-down-right");
					}
					else if (i === 0) {
						$(this).removeClass("hover-up");
					}
					else if (i === 14) {
						$(this).removeClass("hover-down");
					}
					else if (j === 0) {
						$(this).removeClass("hover-left");
					}
					else if (j === 14) {
						$(this).removeClass("hover-right");
					}
					else {
						$(this).removeClass("hover");
					}
			}
		);
	},
	gameStart: function () {
		this.totalGames++;
		cookieHandle.setCookie({ name: "totalGames", value: this.totalGames, expiresHours: 365 * 24 });
		//AI先手
		if (!this.isPlayerTurn) {
			this.AImoveChess();
		}
		this.isGameStart = true;
		$(".operating-panel p a").addClass("disable");
		$("#replay_btn").html("重&nbsp;&nbsp;&nbsp;玩");
	},
	gameOver: function () {
		this.isGameStart = false;
		$(".operating-panel a").removeClass("disable");
		$("#replay_btn").html("开&nbsp;&nbsp;&nbsp;始");
		$("#result_info").html("胜率：" + (this.winGames * 100 / this.totalGames | 0) + "%");
	},

	//下棋 i行，j列，color颜色
	playChess: function (i, j, color) {
		this.chessArr[i][j] = color === "black" ? this.BLACK_CHESS : this.WHITE_CHESS;
		if (color === this.AIPlayer) {
			$("div.chessboard div." + color + "-last").addClass(color).removeClass(color + "-last");
			$("div.chessboard div:eq(" + (i * 15 + j) + ")").addClass(color + "-last");
		}
		else {
			$("div.chessboard div:eq(" + (i * 15 + j) + ")").addClass(color);
		}
	},
	//玩家是否取胜
	playerWinOrNot: function (i, j) {
		var nums = 1,	//连续棋子个数
			chessColor = this.humanPlayer === "black" ? this.BLACK_CHESS : this.WHITE_CHESS,
			m, n;
		//x方向
		for (m = j - 1; m >= 0; m--) {
			if (this.chessArr[i][m] === chessColor) {
				nums++;
			}
			else {
				break;
			}
		}
		for (m = j + 1; m < 15; m++) {
			if (this.chessArr[i][m] === chessColor) {
				nums++;
			}
			else {
				break;
			}
		}
		if (nums >= 5) {
			this.playerWin();
			return;
		}
		else {
			nums = 1;
		}
		//y方向
		for (m = i - 1; m >= 0; m--) {
			if (this.chessArr[m][j] === chessColor) {
				nums++;
			}
			else {
				break;
			}
		}
		for (m = i + 1; m < 15; m++) {
			if (this.chessArr[m][j] === chessColor) {
				nums++;
			}
			else {
				break;
			}
		}
		if (nums >= 5) {
			this.playerWin();
			return;
		}
		else {
			nums = 1;
		}
		//左斜方向
		for (m = i - 1, n = j - 1; m >= 0 && n >= 0; m--, n--) {
			if (this.chessArr[m][n] === chessColor) {
				nums++;
			}
			else {
				break;
			}
		}
		for (m = i + 1, n = j + 1; m < 15 && n < 15; m++, n++) {
			if (this.chessArr[m][n] === chessColor) {
				nums++;
			}
			else {
				break;
			}
		}
		if (nums >= 5) {
			this.playerWin();
			return;
		}
		else {
			nums = 1;
		}
		//右斜方向
		for (m = i - 1, n = j + 1; m >= 0 && n < 15; m--, n++) {
			if (this.chessArr[m][n] === chessColor) {
				nums++;
			}
			else {
				break;
			}
		}
		for (m = i + 1, n = j - 1; m < 15 && n >= 0; m++, n--) {
			if (this.chessArr[m][n] === chessColor) {
				nums++;
			}
			else {
				break;
			}
		}
		if (nums >= 5) {
			this.playerWin();
			return;
		}
		this.AImoveChess();
	},
	playerWin: function () {
		this.winGames++;
		cookieHandle.setCookie({ name: "winGames", value: this.winGames, expiresHours: 365 * 24 });
		this.showResult(true);
		this.gameOver();
	},
	//AI下棋
	AImoveChess: function () {
		this.isPlayerTurn = false;
		var maxX = 0,
			maxY = 0,
			maxWeight = 0,
			i, j, tem;
		for (i = 14; i >= 0; i--) {
			for (j = 14; j >= 0; j--) {
				if (this.chessArr[i][j] !== this.NO_CHESS) {
					continue;
				}
				tem = this.computeWeight(i, j);
				if (tem > maxWeight) {
					maxWeight = tem;
					maxX = i;
					maxY = j;
				}
			}
		}
		this.playChess(maxX, maxY, this.AIPlayer);
		this.AILastChess = [maxX, maxY];
		if ((maxWeight >= 100000 && maxWeight < 250000) || (maxWeight >= 500000)) {
			this.showResult(false);
			this.gameOver();
		}
		else {
			this.isPlayerTurn = true;
		}
	},
	showResult: function(isPlayerWin) {
		if (isPlayerWin) {
			$("#result_tips").html("恭喜你获胜！");
		}
		else {
			$("#result_tips").html("哈哈，你输咯！");
		}
		this.isGameOver = true;
		this.showWinChesses(isPlayerWin);
	},
	//标记显示获胜棋子
	showWinChesses: function (isPlayerWin) {
		var nums = 1,	//连续棋子个数
			lineChess = [],	//连续棋子位置
			i,
			j,
			chessColor,
			m, n;
		if (isPlayerWin) {
			chessColor = this.humanPlayer === "black" ? this.BLACK_CHESS : this.WHITE_CHESS;
			i = this.playerLastChess[0];
			j = this.playerLastChess[1];
		}
		else {
			chessColor = this.AIPlayer === "black" ? this.BLACK_CHESS : this.WHITE_CHESS;
			i = this.AILastChess[0];
			j = this.AILastChess[1];
		}
		$("div.chessboard div." + this.AIPlayer + "-last").addClass(this.AIPlayer).removeClass(this.AIPlayer + "-last");
		//x方向
		lineChess[0] = [i];
		lineChess[1] = [j];
		for (m = j - 1; m >= 0; m--) {
			if (this.chessArr[i][m] === chessColor) {
				lineChess[0][nums] = i;
				lineChess[1][nums] = m;
				nums++;
			}
			else {
				break;
			}
		}
		for (m = j + 1; m < 15; m++) {
			if (this.chessArr[i][m] === chessColor) {
				lineChess[0][nums] = i;
				lineChess[1][nums] = m;
				nums++;
			}
			else {
				break;
			}
		}
		if (nums >= 5) {
			for (k = nums - 1; k >= 0; k--) {
				this.markChess(lineChess[0][k] * 15 + lineChess[1][k], isPlayerWin ? this.humanPlayer : this.AIPlayer);
			}
			return;
		}
		//y方向
		nums = 1;
		lineChess[0] = [i];
		lineChess[1] = [j];
		for (m = i - 1; m >= 0; m--) {
			if (this.chessArr[m][j] === chessColor) {
				lineChess[0][nums] = m;
				lineChess[1][nums] = j;
				nums++;
			}
			else {
				break;
			}
		}
		for (m = i + 1; m < 15; m++) {
			if (this.chessArr[m][j] === chessColor) {
				lineChess[0][nums] = m;
				lineChess[1][nums] = j;
				nums++;
			}
			else {
				break;
			}
		}
		if (nums >= 5) {
			for (k = nums - 1; k >= 0; k--) {
				this.markChess(lineChess[0][k] * 15 + lineChess[1][k], isPlayerWin ? this.humanPlayer : this.AIPlayer);
			}
			return;
		}
		//左斜方向
		nums = 1;
		lineChess[0] = [i];
		lineChess[1] = [j];
		for (m = i - 1, n = j - 1; m >= 0 && n >= 0; m--, n--) {
			if (this.chessArr[m][n] === chessColor) {
				lineChess[0][nums] = m;
				lineChess[1][nums] = n;
				nums++;
			}
			else {
				break;
			}
		}
		for (m = i + 1, n = j + 1; m < 15 && n < 15; m++, n++) {
			if (this.chessArr[m][n] === chessColor) {
				lineChess[0][nums] = m;
				lineChess[1][nums] = n;
				nums++;
			}
			else {
				break;
			}
		}
		if (nums >= 5) {
			for (k = nums - 1; k >= 0; k--) {
				this.markChess(lineChess[0][k] * 15 + lineChess[1][k], isPlayerWin ? this.humanPlayer : this.AIPlayer);
			}
			return;
		}
		//右斜方向
		nums = 1;
		lineChess[0] = [i];
		lineChess[1] = [j];
		for (m = i - 1, n = j + 1; m >= 0 && n < 15; m--, n++) {
			if (this.chessArr[m][n] === chessColor) {
				lineChess[0][nums] = m;
				lineChess[1][nums] = n;
				nums++;
			}
			else {
				break;
			}
		}
		for (m = i + 1, n = j - 1; m < 15 && n >= 0; m++, n--) {
			if (this.chessArr[m][n] === chessColor) {
				lineChess[0][nums] = m;
				lineChess[1][nums] = n;
				nums++;
			}
			else {
				break;
			}
		}
		if (nums >= 5) {
			for (k = nums - 1; k >= 0; k--) {
				this.markChess(lineChess[0][k] * 15 + lineChess[1][k], isPlayerWin ? this.humanPlayer : this.AIPlayer);
			}
		}
	},
	markChess: function (pos, color) {
		$("div.chessboard div:eq(" + pos + ")").removeClass(color).addClass(color + "-last");
	},
	//下子到i，j X方向 结果: 多少连子 两边是否截断
	putDirectX: function (i, j, chessColor) {
		var m, n,
			nums = 1,
			side1 = false,
			side2 = false;
		for (m = j - 1; m >= 0; m--) {
			if (this.chessArr[i][m] === chessColor) {
				nums++;
			}
			else {
				if (this.chessArr[i][m] === this.NO_CHESS) {
					side1 = true;
				}
				break;
			}
		}
		for (m = j + 1; m < 15; m++) {
			if (this.chessArr[i][m] === chessColor) {
				nums++;
			}
			else {
				if (this.chessArr[i][m] === this.NO_CHESS) {
					side2 = true;
				}
				break;
			}
		}
		return {"nums": nums, "side1": side1, "side2": side2};
	},
	//下子到i，j Y方向 结果
	putDirectY: function (i, j, chessColor) {
		var m, n,
			nums = 1,
			side1 = false,
			side2 = false;
		for (m = i - 1; m >= 0; m--) {
			if (this.chessArr[m][j] === chessColor) {
				nums++;
			}
			else {
				if (this.chessArr[m][j] === this.NO_CHESS) {
					side1 = true;
				}
				break;
			}
		}
		for (m = i + 1; m < 15; m++) {
			if (this.chessArr[m][j] === chessColor) {
				nums++;
			}
			else {
				if (this.chessArr[m][j] === this.NO_CHESS) {
					side2 = true;
				}
				break;
			}
		}
		return {"nums": nums, "side1": side1, "side2": side2};
	},
	//下子到i，j XY方向 结果
	putDirectXY: function (i, j, chessColor) {
		var m, n,
			nums = 1,
			side1 = false,
			side2 = false;
		for (m = i - 1, n = j - 1; m >= 0 && n >= 0; m--, n--) {
			if (this.chessArr[m][n] === chessColor) {
				nums++;
			}
			else {
				if (this.chessArr[m][n] === this.NO_CHESS) {
					side1 = true;
				}
				break;
			}
		}
		for (m = i + 1, n = j + 1; m < 15 && n < 15; m++, n++) {
			if (this.chessArr[m][n] === chessColor) {
				nums++;
			}
			else {
				if (this.chessArr[m][n] === this.NO_CHESS) {
					side2 = true;
				}
				break;
			}
		}
		return {"nums": nums, "side1": side1, "side2": side2};
	},
	putDirectYX: function (i, j, chessColor) {
		var m, n,
			nums = 1,
			side1 = false,
			side2 = false;
		for (m = i - 1, n = j + 1; m >= 0 && n < 15; m--, n++) {
			if (this.chessArr[m][n] === chessColor) {
				nums++;
			}
			else {
				if (this.chessArr[m][n] === this.NO_CHESS) {
					side1 = true;
				}
				break;
			}
		}
		for (m = i + 1, n = j - 1; m < 15 && n >= 0; m++, n--) {
			if (this.chessArr[m][n] === chessColor) {
				nums++;
			}
			else {
				if (this.chessArr[m][n] === this.NO_CHESS) {
					side2 = true;
				}
				break;
			}
		}
		return {"nums": nums, "side1": side1, "side2": side2};
	},
	//计算下子至i,j的权重
	computeWeight: function (i, j) {
		var weight = 14 - (Math.abs(i - 7) + Math.abs(j - 7)), //基于棋盘位置权重
			pointInfo = {},	//某点下子后连子信息
			chessColor = this.AIPlayer === "black" ? this.BLACK_CHESS : this.WHITE_CHESS;
		//x方向
		pointInfo = this.putDirectX(i, j, chessColor);
		weight += this.weightStatus(pointInfo.nums, pointInfo.side1, pointInfo.side2, true);//AI下子权重
		pointInfo = this.putDirectX(i, j, -chessColor);
		weight += this.weightStatus(pointInfo.nums, pointInfo.side1, pointInfo.side2, false);//player下子权重
		//y方向
		pointInfo = this.putDirectY(i, j, chessColor);
		weight += this.weightStatus(pointInfo.nums, pointInfo.side1, pointInfo.side2, true);//AI下子权重
		pointInfo = this.putDirectY(i, j, -chessColor);
		weight += this.weightStatus(pointInfo.nums, pointInfo.side1, pointInfo.side2, false);//player下子权重
		//左斜方向
		pointInfo = this.putDirectXY(i, j, chessColor);
		weight += this.weightStatus(pointInfo.nums, pointInfo.side1, pointInfo.side2, true);//AI下子权重
		pointInfo = this.putDirectXY(i, j, -chessColor);
		weight += this.weightStatus(pointInfo.nums, pointInfo.side1, pointInfo.side2, false);//player下子权重
		//右斜方向
		pointInfo = this.putDirectYX(i, j, chessColor);
		weight += this.weightStatus(pointInfo.nums, pointInfo.side1, pointInfo.side2, true);//AI下子权重
		pointInfo = this.putDirectYX(i, j, -chessColor);
		weight += this.weightStatus(pointInfo.nums, pointInfo.side1, pointInfo.side2, false);//player下子权重
		return weight;
	},
	//权重方案   独：两边为空可下子，单：一边为空
	weightStatus: function (nums, side1, side2, isAI) {
		var weight = 0;
		switch (nums) {
			case 1:
				if (side1 && side2) {
					weight = isAI ? 15 : 10;	//独一
				}
				break;
			case 2:
				if (side1 && side2) {
					weight = isAI ? 100 : 50;	//独二
				}
				else if (side1 || side2) {
					weight = isAI ? 10 : 5;	//单二
				}
				break;
			case 3:
				if (side1 && side2) {
					weight = isAI ? 500 : 200;	//独三
				}
				else if (side1 || side2) {
					weight = isAI ? 30 : 20;	//单三
				}
				break;
			case 4:
				if (side1 && side2) {
					weight = isAI ? 5000 : 2000;	//独四
				}
				else if (side1 || side2) {
					weight = isAI ? 400 : 100;	//单四
				}
				break;
			case 5:
				weight = isAI ? 100000 : 10000;	//五
				break;
			default:
				weight = isAI ? 500000 : 250000;
				break;
		}
		return weight;
	}
};