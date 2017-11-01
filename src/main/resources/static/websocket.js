var stompClient = null;
 
function setConnected(connected) {
    document.getElementById('connect').disabled = connected;
    document.getElementById('disconnect').disabled = !connected;
    document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
    document.getElementById('response').innerHTML = '';
}
 
function connect() {
    var socket = new SockJS('/websocket-app');
    stompClient = Stomp.over(socket);  
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/mural', function(messageOutput) {
            showMessageOutput(messageOutput.body);
        });
    });
}
 
function disconnect() {
    if(stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}
 
function sendMessage() {
    var message = document.getElementById('text').value;
    stompClient.send("/app/message", {}, message);
}
 
function showMessageOutput(messageOutput) {
    var response = document.getElementById('response');
    var p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode(messageOutput));
    response.appendChild(p);
}
