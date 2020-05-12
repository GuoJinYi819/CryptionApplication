package com.example.cryptionapplication.demo1

/**ClassName: CryptionApplication
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/12 0012 8:29
 * @Description: 用途：完成特定功能
 */
fun main() {
    //获取一个字符的ascii码
    var c:Char = 'a'
                    //字节转int
    var value:Int = c.toInt()
    println(value)

    var str = "a b c"
    //遍历获取每一个字符的ascii

    var sb = StringBuffer()

    var array = str.toCharArray()

    //with高阶函数
    var result = with(sb){
        for (arr in array){
            val toInt = arr.toInt()
            //通过StringBuffer追加 字节
            sb.append(toInt.toString()+"")
        }
        //with的返回值
        toString()
    }
    println(result)
}





