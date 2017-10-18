<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<jsp:include page="/jsp/main/corepage.jsp"></jsp:include>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>jquery五子棋游戏对战</title>
    <link rel="stylesheet" type="text/css" href="<%=path%>/css/gobang/reset.css">
    <script type="text/javascript" src="<%=path%>/js/gobang/CookieHandle.js"></script>
    <%-- <script type="text/javascript" src="<%=path%>/js/gobang/jquery-1.7.2.js"></script>--%>
</head>
<body>
<div class="wrapper">
    <jsp:include page="/jsp/main/newindex.jsp"></jsp:include>
    <div id="page-wrapper">
        <div id="page-inner">
            <button class="btn selected" onclick="sendMatching()">匹配对手</button>
            <div class="chessboard">
                <!-- top line -->
                <div class="chess-top"></div>
                <div class="chess-top"></div>
                <div class="chess-top"></div>
                <div class="chess-top"></div>
                <div class="chess-top"></div>
                <div class="chess-top"></div>
                <div class="chess-top"></div>
                <div class="chess-top"></div>
                <div class="chess-top"></div>
                <div class="chess-top"></div>
                <div class="chess-top"></div>
                <div class="chess-top"></div>
                <div class="chess-top"></div>
                <div class="chess-top"></div>
                <div class="chess-top chess-right"></div>
                <!-- line 1 -->
                <div class="chess-left"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-right"></div>
                <!-- line 2 -->
                <div class="chess-left"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-right"></div>
                <!-- line 3 -->
                <div class="chess-left"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-right"></div>
                <!-- line 4 -->
                <div class="chess-left"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-right"></div>
                <!-- line 5 -->
                <div class="chess-left"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-right"></div>
                <!-- line 6 -->
                <div class="chess-left"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-right"></div>
                <!-- line 7 -->
                <div class="chess-left"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-right"></div>
                <!-- line 8 -->
                <div class="chess-left"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-right"></div>
                <!-- line 9 -->
                <div class="chess-left"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-right"></div>
                <!-- line 10 -->
                <div class="chess-left"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-right"></div>
                <!-- line 11 -->
                <div class="chess-left"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-right"></div>
                <!-- line 12 -->
                <div class="chess-left"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-right"></div>
                <!-- line 13 -->
                <div class="chess-left"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-middle"></div>
                <div class="chess-right"></div>
                <!-- bottom line  -->
                <div class="chess-bottom"></div>
                <div class="chess-bottom"></div>
                <div class="chess-bottom"></div>
                <div class="chess-bottom"></div>
                <div class="chess-bottom"></div>
                <div class="chess-bottom"></div>
                <div class="chess-bottom"></div>
                <div class="chess-bottom"></div>
                <div class="chess-bottom"></div>
                <div class="chess-bottom"></div>
                <div class="chess-bottom"></div>
                <div class="chess-bottom"></div>
                <div class="chess-bottom"></div>
                <div class="chess-bottom"></div>
                <div class="chess-bottom chess-right"></div>
            </div>

            <div class="operating-panel">
                <p>
                    <a id="black_btn" class="btn selected" href="#">黑&nbsp;&nbsp;子</a>
                    <a id="white_btn" class="btn" href="#">白&nbsp;&nbsp;子</a>
                </p>
                <p>
                    <a id="first_move_btn" class="btn selected" href="#">先&nbsp;&nbsp;手</a>
                    <a id="second_move_btn" class="btn" href="#">后&nbsp;&nbsp;手</a>
                </p>
                <a id="replay_btn" class="btn" href="#">开&nbsp;&nbsp;&nbsp;始</a>
                <p id="result_info">胜率：100%</p>
                <p id="result_tips"></p>
            </div>

            <div style="display: none">
                <!-- 图片需合并 减少http请求数 -->
                <img src="http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/black.png" alt="preload"/>
                <img src="http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/white.png" alt="preload"/>
                <img src="http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/hover.png" alt="preload"/>
                <img src="http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/hover_up.png" alt="preload"/>
                <img src="http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/hover_down.png" alt="preload"/>
                <img src="http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/hover_up_left.png" alt="preload"/>
                <img src="http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/hover_up_right.png" alt="preload"/>
                <img src="http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/hover_left.png" alt="preload"/>
                <img src="http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/hover_right.png" alt="preload"/>
                <img src="http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/hover_down_left.png" alt="preload"/>
                <img src="http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/hover_down_right.png" alt="preload"/>
                <img src="http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/black_last.png" alt="preload"/>
                <img src="http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/white_last.png" alt="preload"/>
            </div>
        </div>
    </div>
</div>
</body>
</html>


<style>.wrapper {
    width: 600px;
    position: relative;
}

/* 棋盘 */
div.chessboard {
    margin: 30px 0 0 50px;
    width: 542px;
    background: url(http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/chessboard.png) no-repeat 14px 14px rgb(250, 250, 250);
    overflow: hidden;
    box-shadow: 2px 2px 8px #888;
    -webkit-box-shadow: 2px 2px 8px #888;
    -moz-box-shadow: 2px 2px 8px #888;
}

div.chessboard div {
    float: left;
    width: 36px;
    height: 36px;
    border-top: 0px solid #ccc;
    border-left: 0px solid #ccc;
    border-right: 0;
    border-bottom: 0;
    cursor: pointer;
}

/* 棋子 */
div.chessboard div.black {
    background: url(http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/black.png) no-repeat 4px 4px;
}

div.chessboard div.white {
    background: url(http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/white.png) no-repeat 4px 4px;
}

div.chessboard div.hover {
    background: url(http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/hover.png) no-repeat 1px 1px;
}

div.chessboard div.hover-up {
    background: url(http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/hover_up.png) no-repeat 1px 1px;
}

div.chessboard div.hover-down {
    background: url(http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/hover_down.png) no-repeat 1px 1px;
}

div.chessboard div.hover-up-left {
    background: url(http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/hover_up_left.png) no-repeat 1px 1px;
}

div.chessboard div.hover-up-right {
    background: url(http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/hover_up_right.png) no-repeat 1px 1px;
}

div.chessboard div.hover-left {
    background: url(http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/hover_left.png) no-repeat 1px 1px;
}

div.chessboard div.hover-right {
    background: url(http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/hover_right.png) no-repeat 1px 1px;
}

div.chessboard div.hover-down-left {
    background: url(http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/hover_down_left.png) no-repeat 1px 1px;
}

div.chessboard div.hover-down-right {
    background: url(http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/hover_down_right.png) no-repeat 1px 1px;
}

div.chessboard div.white-last {
    background: url(http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/white_last.png) no-repeat 4px 4px;
}

div.chessboard div.black-last {
    background: url(http://sandbox.runjs.cn/uploads/rs/102/r2dy3tyw/black_last.png) no-repeat 4px 4px;
}

/* 右侧 */

div.operating-panel {
    position: absolute;
    left: 610px;
    top: 150px;
    width: 200px;
    text-align: center;
}

.operating-panel a {
    display: inline-block;
    padding: 10px 15px;
    margin-bottom: 39px;
    margin-right: 8px;
    margin-left: 8px;
    background: rgb(100, 167, 233);
    text-decoration: none;
    color: #333;
    font-weight: bold;
    font-size: 16px;
    font-family: "微软雅黑", "宋体";
}

.operating-panel a:hover {
    background: rgb(48, 148, 247);
    text-decoration: none;
}

.operating-panel a.disable, .operating-panel a.disable:hover {
    cursor: default;
    background: rgb(197, 203, 209);
    color: rgb(130, 139, 148);
}

.operating-panel a.selected {
    border: 5px solid #F3C242;
    padding: 5px 10px;
}

#result_tips {
    color: #CE4242;
    font-size: 26px;
    font-family: "微软雅黑";
}

#result_info {
    margin-bottom: 26px;
}</style>
<script type="application/javascript">
    $(document).ready(function () {
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
                if (_fiveChess.isGameStart && id !== "replay_btn") {
                    return;
                }	//正在游戏 不操作
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
                    if (!_fiveChess.isPlayerTurn || _fiveChess.isGameOver) {
                        return;
                    }
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
                    if (!_fiveChess.isPlayerTurn || _fiveChess.isGameOver) {
                        return;
                    }
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
            cookieHandle.setCookie({name: "totalGames", value: this.totalGames, expiresHours: 365 * 24});
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
            cookieHandle.setCookie({name: "winGames", value: this.winGames, expiresHours: 365 * 24});
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
        showResult: function (isPlayerWin) {
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
    //--------长连接消息游戏匹配-------------
    function sendMatching() {

    }

</script>

<!-- Generated by RunJS (Wed Mar 13 14:21:55 CST 2013) 1ms -->

<div style="text-align:center;clear:both"><br><br>
</div>