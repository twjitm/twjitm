/**
 * cookieHandle: 常用cookie操作方法的封装
 * date: 2013.1.10
 * author: Seven
**/
var cookieHandle = {
    //获取cookie中name对应的值
    getCookie: function (name) {
        var cookies = document.cookie.split("; "),
            arr;
        for (var i = 0, len = cookies.length; i < len;i++) {
            arr = cookies[i].split("=");
            if(arr[0] == encodeURIComponent(name)) {
                return decodeURIComponent(arr[1]);
            }
        }
        return "";
    },
    // 设置cookie
    // option.name: cookie名，必选
    // option.value: cookie值，必选
    // option.expiresHours: 过期时间，可选，默认为浏览器关闭即消失
    // option.path: cookie存放路径，可选。例如"/"、"/shop"。
    // 默认情况下，如果在某个页面创建了一个cookie，那么该页面所在目录中的其他页面也可以访问该cookie。
    // 如果这个目录下还有子目录，则在子目录中也可以访问。
    // 例如在www.xxxx.com/html/a.html中所创建的cookie，
    // 可以被www.xxxx.com/html/b.html或www.xxx.com/html/some/c.html所访问，但不能被www.xxxx.com/d.html访问。
    // option.domain: 可访问该cookie的域名，可选。
    setCookie: function (option) {
        var cookieStr = encodeURIComponent(option.name) + "=" + encodeURIComponent(option.value);
        if (option.expiresHours) {
            var date = new Date();
            date.setTime(date.getTime() + option.expiresHours * 3600 * 1000);
            cookieStr = cookieStr + "; expires=" + date.toUTCString();
        }
        if (option.path) {
            cookieStr = cookieStr + "; path=" + option.path;
        }
        if (option.domain) {
            cookieStr = cookieStr + "; domain=" + option.domain;
        }
        document.cookie = cookieStr;
    },
    // 删除cookie
    // name: cookie名，必选
    // option.path: cookie存放路径，可选
    // option.domain: 可访问该cookie的域名，可选
    // 需要注意的是，设置cookie时，如果setCookie传了path、domain，删除时也必选传入这两个参数，否则无法删除cookie
    // 另外，经测试，如设置了path、domain，删除时需在设置cookie的同一域下删除
    deleteCookie: function (name, option) {
        var date = new Date(0);
        document.cookie = name + "=88; expires=" + date.toUTCString() +
                            (option.path ? ("; path=" + option.path) : "") +
                            (option.domain ? ("; domain=" + option.domain) : "");
    }
};