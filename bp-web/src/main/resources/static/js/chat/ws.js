/**
 * Created by Administrator on 2017-11-22.
 */
$(function () {
    $('.js-data-example-ajax').select2({
        ajax: {
            url: '/api/user',
            dataType: 'json',
            // Additional AJAX parameters go here; see the end of this chapter for the full code of this example
            processResults: function (data) {
                // Tranforms the top-level key of the response object from 'items' to 'results'
                var d=[];
                for(var i=0;i<data.length;i++){
                    d.push({id:data[i].id,text:data[i].userName});
                }
                return {
                    results: d
                };
            }
        },
        minimumInputLength: 1,//最少输入几个个字符时开始搜索
        language: "zh-CN"
    });
});

/*web-socket*/
var stompClient = null;
function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}
function connect() {
    var socket = new SockJS('/gs-guide-websocket');//1连接SockJS的endpoint是“/gs-guide-websocket”，与后台代码中注册的endpoint要一样。
    stompClient = Stomp.over(socket);//2创建STOMP协议的webSocket客户端。
    stompClient.connect({}, function (frame) {//3连接webSocket的服务端。
        setConnected(true);
        console.log('Connected: ' + frame);

        //4通过stompClient.subscribe（）订阅服务器的目标是'/topic/greetings'发送过来的地址，与@SendTo中的地址对应。
        stompClient.subscribe('/topic/greetings', function (greeting) {
            showGreeting(JSON.parse(greeting.body).content);
        });

        //接收一对一消息
        stompClient.subscribe('/user/' + sid + '/message', function(message){
            showGreeting(JSON.parse(message.body).content);
        });
    });
}
function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}
function sendName() {
    //通过stompClient.send（）向地址为"/hello"的服务器地址发起请求，与@MessageMapping里的地址对应。
    // 因为我们配置了registry.setApplicationDestinationPrefixes("/app");所以需要增加前缀/app
    stompClient.send("/app/notice", {}, JSON.stringify({'content': $("#name").val()}));
}

function sendToUser() {
    //发送给指定人
    stompClient.send("/app/message2", {}, JSON.stringify({'content': $("#name").val(),'users':['2@lhyzp.com']}));
}

function showGreeting(message) {
    $("#greetings").append("<tr><td>" + message + "</td></tr>");
}
$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendName(); });
    $( "#sendToUser" ).click(function() { sendToUser(); });
});
