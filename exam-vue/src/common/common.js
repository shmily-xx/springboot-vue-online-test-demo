/**
 * 把标准时间转换成时间戳
 * 传入标准时间
 */
export function timestamp(date) {
    let myDate = date ? new Date(date) : new Date()
    return Date.parse(myDate) / 1000
};

/**
 * 时间戳转换成把标准时间
 * 传入时间戳
 */
export function standardTime(timestamp) {
    let time = timestamp.toString() + '000'
    return new Date(parseInt(time))
};
/**
 * 验证手机号是否合格
 * true--说明合格
 */
export function isPhone(phoneStr) {
    let myreg = /^[1][3,4,5,7,8,9][0-9]{9}$/;
    if (!myreg.test(phoneStr)) {
        return false;
    } else {
        return true;
    }
};

/**
 * 验证身份证号是否合格
 * true--说明合格
 */
export function isIdCard(idCardStr) {
    let idcardReg = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
    if (idcardReg.test(idCardStr)) {
        return true;
    } else {
        return false;
    }
};

/**
 * 验证车牌号是否合格
 * true--说明合格
 */
export function isVehicleNumber(vehicleNumber) {
    let xreg = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}(([0-9]{5}[DF]$)|([DF][A-HJ-NP-Z0-9][0-9]{4}$))/;
    let creg = /^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳]{1}$/;
    if (vehicleNumber.length == 7) {
        return creg.test(vehicleNumber);
    } else if (vehicleNumber.length == 8) {
        return xreg.test(vehicleNumber);
    } else {
        return false;
    }
};

/**
 * 验证字符串是否为空（也不能为纯空格）
 * true--说明为空， false--说明不为空
 */
export function isEmptyString(string) {
    if (
        string == undefined ||
        typeof string == 'undefined' ||
        !string ||
        string == null ||
        string == '' ||
        /^\s+$/gi.test(string)
    ) {
        return true;
    } else {
        return false;
    }
};

/**
 * 生日转为年龄（精确到月份）
 */
export function birsdayToAge(birsday) {
    let aDate = new Date();
    let thisYear = aDate.getFullYear();
    let bDate = new Date(birsday);
    let brith = bDate.getFullYear();
    let age = thisYear - brith;
    if (aDate.getMonth() == bDate.getMonth()) {
        if (aDate.getDate() < bDate.getDate()) {
            age = age - 1;
        }
    } else {
        if (aDate.getMonth() < bDate.getMonth()) {
            age = age - 1;
        }
    }
    return age;
};

/**
 * 判断数据类型
 * @param {any} val - 基本类型数据或者引用类型数据
 * @return {string} - 可能返回的结果有，均为小写字符串
 * number、boolean、string、null、undefined、array、object、function等
 */
export function getType(val) {
    //判断数据是 null 和 undefined 的情况
    if (val == null) {
        return val + "";
    }
    return typeof (val) === "object" ?
        Object.prototype.toString.call(val).slice(8, -1).toLowerCase() :
        typeof (val);
};

/**
 * 验证是否为数字
 */
export function isNumber(n) {
    return !isNaN(parseFloat(n)) && isFinite(n);
};

/**
 * 是否为数组
 */
export function isArray(obj) {
    return Object.prototype.toString.call(obj) === '[object Array]';
};

/**
 * 是否空数组
 */
export function isArrayEmpty(val) {
    if (val && val instanceof Array && val.length > 0) {
        return false;
    } else {
        return true;
    }
};

/**
 * 获取url参数字符串
 * 没有返回null
 */
export function getQueryString(name) {
    let reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
    let r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2]);
    }
    return null;
};

/**
 * 递归深拷贝
 */
export function deepCopy(obj) {
    let result = Array.isArray(obj) ? [] : {};
    for (let key in obj) {
        if (obj.hasOwnProperty(key)) {
            if (typeof obj[key] === 'object' && obj[key] !== null) {
                result[key] = deepCopy(obj[key]);
            } else {
                result[key] = obj[key];
            }
        }
    }
    return result;
};

/**
 * 去除参数空数据（用于向后台传递参数的时候）
 * @param {Object} obj [参数对象]
 */
export function filterEmptyData(obj) {
    for (let prop in obj) {
        obj[prop] === '' ? delete obj[prop] : obj[prop];
    }
    return obj;
};

/**
 * @desc  函数防抖，用于将多次执行变为最后一次执行
 * @param {function} func - 需要使用函数防抖的被执行的函数。必传
 * @param {Number} wait - 多少毫秒之内触发，只执行第一次，默认1000ms。可以不传
 */
export function debounce(fn, delay) {
    delay = delay || 1000; //默认1s后执行
    let timer = null;
    return function () {
        let context = this;
        let arg = arguments;
        if (timer) {
            clearTimeout(timer);
        }
        timer = setTimeout(() => {
            fn.apply(context, arg);
        }, delay);
    };
};

/**
 * 节流函数, 用于将多次执行变为每隔一段时间执行
 * @param fn 事件触发的操作
 * @param delay 间隔多少毫秒需要触发一次事件
 */
export function throttle2(fn, delay) {
    let timer = null;
    return function () {
        let context = this;
        let args = arguments;
        if (!timer) {
            timer = setTimeout(function () {
                fn.apply(context, args);
                clearTimeout(timer);
            }, delay);
        }
    };
};

/**
 * 数字四舍五入（保留n位小数）
 */
export function round(number, n) {
    n = n ? parseInt(n) : 0
    if (n <= 0) return Math.round(number)
    number = Math.round(number * Math.pow(10, n)) / Math.pow(10, n)
    return number
};

/**
 *数字金额转文字  函数
 *
 * @export
 * @param {*} money
 * @returns
 */
export function convertCurrency(money) {
    //汉字的数字
    var cnNums = new Array('零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖');
    //基本单位
    var cnIntRadice = new Array('', '拾', '佰', '仟');
    //对应整数部分扩展单位
    var cnIntUnits = new Array('', '万', '亿', '兆');
    //对应小数部分单位
    var cnDecUnits = new Array('角', '分', '毫', '厘');
    //整数金额时后面跟的字符
    var cnInteger = '整';
    //整型完以后的单位
    var cnIntLast = '元';
    //最大处理的数字
    var maxNum = 999999999999999.9999;
    //金额整数部分
    var integerNum;
    //金额小数部分
    var decimalNum;
    //输出的中文金额字符串
    var chineseStr = '';
    //分离金额后用的数组，预定义
    var parts;
    if (money == '') {
        return '';
    }
    money = parseFloat(money);
    if (money >= maxNum) {
        //超出最大处理数字
        return '';
    }
    if (money == 0) {
        chineseStr = cnNums[0] + cnIntLast + cnInteger;
        return chineseStr;
    }
    //转换为字符串
    money = money.toString();
    if (money.indexOf('.') == -1) {
        integerNum = money;
        decimalNum = '';
    } else {
        parts = money.split('.');
        integerNum = parts[0];
        decimalNum = parts[1].substr(0, 4);
    }
    //获取整型部分转换
    if (parseInt(integerNum, 10) > 0) {
        var zeroCount = 0;
        var IntLen = integerNum.length;
        for (var i = 0; i < IntLen; i++) {
            var n = integerNum.substr(i, 1);
            var p = IntLen - i - 1;
            var q = p / 4;
            var m = p % 4;
            if (n == '0') {
                zeroCount++;
            } else {
                if (zeroCount > 0) {
                    chineseStr += cnNums[0];
                }
                //归零
                zeroCount = 0;
                chineseStr += cnNums[parseInt(n)] + cnIntRadice[m];
            }
            if (m == 0 && zeroCount < 4) {
                chineseStr += cnIntUnits[q];
            }
        }
        chineseStr += cnIntLast;
    }
    //小数部分
    if (decimalNum != '') {
        var decLen = decimalNum.length;
        for (var i = 0; i < decLen; i++) {
            var n = decimalNum.substr(i, 1);
            if (n != '0') {
                chineseStr += cnNums[Number(n)] + cnDecUnits[i];
            }
        }
    }
    if (chineseStr == '') {
        chineseStr += cnNums[0] + cnIntLast + cnInteger;
    } else if (decimalNum == '') {
        chineseStr += cnInteger;
    }
    return chineseStr;
};

/**
 *时间增加或减少几天
 * date  当前日期 例： 2020-06-10
 * days  增加的天数 例： 30
 * return 增加后的天数
 */
export function addDate(date, days) {
    var d = new Date(date);
    d.setDate(d.getDate() + days);
    var month = d.getMonth() + 1;
    var day = d.getDate();
    if (month < 10) {
        month = "0" + month;
    }
    if (day < 10) {
        day = "0" + day;
    }
    var val = d.getFullYear() + "-" + month + "-" + day;
    return val;
};

/**
 *数字每千位加逗号
 * 
 */
export function commafy(num) {
    return num && num.toString()
        .replace(/\d+/, function (s) {
            return s.replace(/(\d)(?=(\d{3})+$)/g, '$1,')
        })
};

/**
 *数字补位
 * numberPad用于按照位数补0,默认为2
 */
export function numberPad(source, length = 2) {
    let pre = ''
    const negative = source < 0
    const string = String(Math.abs(source))
    if (string.length < length) {
        pre = (new Array(length - string.length + 1)).join('0')
    }
    return (negative ? '-' : '') + pre + string
};

/**
 *随机数
 *
 */
export function numberRandom(min, max) {
    return Math.floor(Math.random() * (max - min + 1) + min)
};

/**
 *手机号码中间4位隐藏花号（*）显示
 *
 */
export function hideMobile(mobile) {
    return mobile.replace(/^(\d{3})\d{4}(\d{4})$/, "$1****$2")
};


/**
 * 去除字符串空格
 * @param str 要处理的字符串
 * @param type 1：所有空格 2：前后空格 3：前空格 4：后空格
 */
export function strTrim(str, type) {
    switch (type) {
        case 1:
            return str.replace(/\s+/g, "");
        case 2:
            return str.replace(/(^\s*)|(\s*$)/g, "");
        case 3:
            return str.replace(/(^\s*)/g, "");
        case 4:
            return str.replace(/(\s*$)/g, "");
        default:
            return str;
    }
};

/**
 * 字母大小写切换
 * @param str 要处理的字符串
 * @param type 1:首字母大写 2：首页母小写 3：大小写转换 4：全部大写 5：全部小写
 */
export function strChangeCase(str, type) {
    function ToggleCase(str) {
        var itemText = ""
        str.split("").forEach(
            function (item) {
                if (/^([a-z]+)/.test(item)) {
                    itemText += item.toUpperCase();
                } else if (/^([A-Z]+)/.test(item)) {
                    itemText += item.toLowerCase();
                } else {
                    itemText += item;
                }
            });
        return itemText;
    }

    switch (type) {
        case 1:
            return str.replace(/^(\w)(\w+)/, function (v, v1, v2) {
                return v1.toUpperCase() + v2.toLowerCase();
            });
        case 2:
            return str.replace(/^(\w)(\w+)/, function (v, v1, v2) {
                return v1.toLowerCase() + v2.toUpperCase();
            });
        case 3:
            return ToggleCase(str);
        case 4:
            return str.toUpperCase();
        case 5:
            return str.toLowerCase();
        default:
            return str;
    }
};

/**
 * 检测密码强度
 * @param str 字符串
 * @returns 1：密码弱 2：密码中等 3：密码强 4：密码很强
 */
export function checkPwd(str) {
    var nowLv = 0;
    if (str.length < 6) {
        return nowLv
    };
    if (/[0-9]/.test(str)) {
        nowLv++
    };
    if (/[a-z]/.test(str)) {
        nowLv++
    };
    if (/[A-Z]/.test(str)) {
        nowLv++
    };
    return nowLv;
};

/**
 * 返回指定某个区间的一个数字（可以不传参，不传就返回0-255之间的数；可以只传一个，返回0到传入的这个数字之间的某个值）
 * @param n1 开始区间 例：5
 * @param n2 结束区间 例：10
 * @returns 返回这个区间的某个随机值
 */
export function randomNumber(n1, n2) {
    if (arguments.length === 2) {
        return Math.round(n1 + Math.random() * (n2 - n1));
    } else if (arguments.length === 1) {
        return Math.round(Math.random() * n1)
    } else {
        return Math.round(Math.random() * 255)
    }
};

/**
 * 随机产生某个颜色
 * @returns {String} 颜色 例：rgb(250,82,49)
 */
//randomNumber是上面定义的函数
export function randomColor() {
    return 'rgb(' + this.randomNumber(255) + ',' + this.randomNumber(255) + ',' + this.randomNumber(255) + ')';
};

/**
 * 简单数组排序，针对数字数组
 * @param type 1：降序，0：升序
 */
export function sortArr(arr, type) {
    if (type == 1) {
        //降序
        arr.sort(function (a, b) {
            return b - a;
        });
    } else {
        arr.sort(function (a, b) {
            return a - b;
        });
    }
    return arr;
};


/**
* 浏览器全屏
*/

export function reqFullScreen() {

    if (document.documentElement.requestFullScreen) {

        document.documentElement.requestFullScreen();

    } else if (document.documentElement.webkitRequestFullScreen) {

        document.documentElement.webkitRequestFullScreen();

    } else if (document.documentElement.mozRequestFullScreen) {

        document.documentElement.mozRequestFullScreen();

    }

};

/**
 
* 浏览器退出全屏
 
*/

export function exitFullScreen() {

    if (document.documentElement.requestFullScreen) {

        document.exitFullScreen();

    } else if (document.documentElement.webkitRequestFullScreen) {

        document.webkitCancelFullScreen();

    } else if (document.documentElement.mozRequestFullScreen) {

        document.mozCancelFullScreen();

    }

};

/** 加密 */
export function encrypt(word) {
    let encrypted = CryptoJS.AES.encrypt(word.toString(), key,//  AES加密
        {
            iv: iv,
            mode: CryptoJS.mode.CBC,
            padding: CryptoJS.pad.Pkcs7   // 后台用的是pad.Pkcs5,前台对应为Pkcs7
        })
    return encrypted.toString()
};

/** 解密 */
export function decrypt(word) {
    let decrypted = CryptoJS.AES.decrypt(word, key,//  AES解密
        {
            iv: iv,
            mode: CryptoJS.mode.CBC,
            padding: CryptoJS.pad.Pkcs7
        })
    return CryptoJS.enc.Utf8.stringify(decrypted)
};

/** 参数加密 */
export function paramsEncrypt(params = {}) {
    for (let prop in params) {
        if (params[prop] != null) {
            params[prop] = this.encrypt(params[prop])
        }
    }
};

/** 文件下载*/
export function downLoad(way, url, name, type) {
    var token = sessionStorage.getItem("account.token") || "";
    var xhr = new XMLHttpRequest();
    xhr.open(way, url, true);
    xhr.responseType = "blob";
    xhr.setRequestHeader("Authorization", "Bearer " + token);
    xhr.onload = function () {
        if (this.status === 200) {
            var blob = this.response;
            var reader = new FileReader();
            reader.readAsDataURL(blob); // 转换为base64，可以直接放入a标签href
            reader.onload = function (e) {
                var a = document.createElement("a"); // 转换完成，创建一个a标签用于下载
                a.download = name + type;
                a.href = e.target.result;
                $("body").append(a); // 修复firefox中无法触发click
                a.click();
                $(a).remove();
            };
        }
    };
    xhr.send(); // 发送ajax请求
};

/**
 * 获取当前年、月、日
 */
export function parseTime(time, cFormat) {
    if (!time) {
        return ''
    }
    if (arguments.length === 0) {
        return null
    }
    const format = cFormat || '{y}-{m}-{d} {h}:{i}:{s}'
    let date
    if (typeof time === 'object') {
        date = time
    } else {
        if (typeof time === 'string' && /^[0-9]+$/.test(time)) {
            time = parseInt(time)
        }
        if (typeof time === 'number' && time.toString().length === 10) {
            time = time * 1000
        }
        date = new Date(time)
    }
    const formatObj = {
        y: date.getFullYear(),
        m: date.getMonth() + 1,
        d: date.getDate(),
        h: date.getHours(),
        i: date.getMinutes(),
        s: date.getSeconds(),
        a: date.getDay()
    }
    const time_str = format.replace(/{([ymdhisa])+}/g, (result, key) => {
        const value = formatObj[key]
        // Note: getDay() returns 0 on Sunday
        if (key === 'a') {
            return ['日', '一', '二', '三', '四', '五', '六'][value]
        }
        return value.toString().padStart(2, '0')
    })
    return time_str
};

export function getFormatDate() {
    /*     var now = new Date();
        var getFullYear = now.getFullYear();
        var getMonth = now.getMonth();
        var getDay = now.getDay(); */
    const now = new Date()
    return {
        getFullYear: now.getFullYear(),
        getMonth: now.getMonth(),
        getDay: now.getDay()
    }

}
/* export default {
    getFormatDate: function () {
        return {
            now: new Date(),
            getFullYear: now.getFullYear(),
            getMonth: now.getMonth(),
            getDay: now.getDay()
        }
    }
} */