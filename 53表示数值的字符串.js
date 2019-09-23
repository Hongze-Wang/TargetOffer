//s字符串
function isNumeric(s)
{
    // write code here
    var reg = /^[+-]?\d*\.?\d+([eE][+-]?\d+)?$/;
    return reg.test(s);
}

// /^[\+-]?\d*\.?\d+(e[\+-]?\d+)?$/i
// /i表示对大小写不敏感 可以在$/加i 在所有字母有关的判断中不区分大小写
// JavaScript在正则表达式前后要加/