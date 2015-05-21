/*毫秒转日期*/
function millionsToDate() {
	var format = function(time, format) {
		var t = new Date(time);
		var tf = function(i) {
			return (i < 10 ? '0' : '') + i;
		};
		return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a) {
			switch (a) {
			case 'yyyy':
				return tf(t.getFullYear());
				break;
			case 'MM':
				return tf(t.getMonth() + 1);
				break;
			case 'mm':
				return tf(t.getMinutes());
				break;
			case 'dd':
				return tf(t.getDate());
				break;
			case 'HH':
				return tf(t.getHours());
				break;
			case 'ss':
				return tf(t.getSeconds());
				break;
			}
		});
	};
	var inputNum = new Number(document.getElementById("inputNum").value);
	document.getElementById("inputDate").value = format(inputNum,
			'yyyy-MM-dd HH:mm:ss');
}

/**
 * 测试 JS 接口返回值
 */
function postStr() {
	var rtn = demo.testMethod(document.getElementById("text").value, document.getElementById("text1").value);
	document.getElementById("text2").value = rtn;
	alert(rtn);
}