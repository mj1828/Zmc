/**
 * 判断用户是否已经登录，未登录返回信息，提示用户登录，登录返回当前登录用户信息 
 */

function doLogin(){
	$.get("http://localhost:8080/doLogin",function(result){
		console.log(result);
	})
}
doLogin();