package com.example.cryptionapplication.demo6

import java.lang.StringBuilder
import java.security.MessageDigest
import kotlin.experimental.and

/**ClassName: CryptionApplication
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/12 0012 14:02
 * @Description: 用途：md5加密
 */
object MessageDigetUtil {
    fun md5(input:String): String {
        val digest = MessageDigest.getInstance("MD5")
        val result = digest.digest(input.toByteArray())

        var stringBuilder = StringBuilder()
        result.forEach {
            // println(it) //it -当前数组的每一个元素
            var value = it
            //转16进制
            val hex = value.toInt() and (0xFF)
            val str = Integer.toHexString(hex)
            println(str)
            if(str.length==1){
                stringBuilder.append("0").append(str)
            }else{
                stringBuilder.append(str)
            }
        }
        return stringBuilder.toString()
    }

    fun sha1(input: String): String {
        val digest = MessageDigest.getInstance("SHA-1")
        val result = digest.digest(input.toByteArray())
        //转16进制
        val toHex = toHex(result)
        return toHex

    }

    //转16进制
    fun toHex(byteArray: ByteArray): String {

        val result = with(StringBuilder()){
            byteArray.forEach {
                // println(it) //it -当前数组的每一个元素
                var value = it
                //转16进制
                val hex = value.toInt() and (0xFF)
                val str = Integer.toHexString(hex)
                println(str)
                if(str.length==1){
                    this.append("0").append(str)
                }else{
                    this.append(str)
                }
            }
            this.toString()
        }
        return result

    }
}

fun main() {

    var input = "嘿嘿"

    val md5 = MessageDigetUtil.md5(input)
    //位数
    //println(stringBuilder.toString().toByteArray().size)
    println(md5)

    //sha1 值
    val sha1 = MessageDigetUtil.sha1(input)
    println(sha1)

}