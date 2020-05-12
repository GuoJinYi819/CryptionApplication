package com.example.cryptionapplication.demo2

/**ClassName: CryptionApplication
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/12 0012 8:45
 * @Description: 用途：凯撒加密算法
 */

class CaesarCrypt{
    //加密函数
    /**
     * @param 加密值
     * @param 秘钥
     */
    fun encrypt(command:String,key:Int):String{
        //加密
        val charArray = command.toCharArray()
        //秘钥
        return with(StringBuffer()){
            charArray.forEach {
                //遍历每一个字符 对ascii码进行加减乘除

                val c = it // 移动到b ->b
                //获取c的ascii码
                var ascii = c.toInt()

                //移动
                ascii+=key
                //再转为字符
                val result = ascii.toChar()
                append(result)
            }
            toString()
        }
    }
    //解密函数
    /**
     * @param 加密值
     * @param 秘钥
     */
    fun decrypt(put:String,key:Int):String{
        //加密
        val charArray = put.toCharArray()
        //秘钥
        return with(StringBuffer()){
            charArray.forEach {
                //遍历每一个字符 对ascii码进行加减乘除

                val c = it // 移动到b ->b
                //获取c的ascii码
                var ascii = c.toInt()

                //反方向移动
                ascii-=key
                //再转为字符
                val result = ascii.toChar()
                append(result)
            }
            toString()
        }
    }
}

fun main() {
    //移动字符

    //要加密的数据
    var command = "A"
    //秘钥
    var key = 1

    val encrypt = CaesarCrypt().encrypt(command, key)
    println("加密=${encrypt}")
    //解密
    var decrypt = CaesarCrypt().decrypt(encrypt,key)
    println("解密=${decrypt}")

}