package com.example.cryptionapplication.demo3

import java.security.Key
import java.security.spec.KeySpec
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.DESKeySpec

/**ClassName: CryptionApplication
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/12 0012 9:30
 * @Description: 用途：DES的加密和机密
 */
//单例模式
object DESCrypt{
    fun encrypt(input:String,password:String):ByteArray{
        //1 创建cipher
        var c = Cipher.getInstance("DES")
        //初始化 cipher init()  参数1 加密/解密模式
        //秘钥工厂
        val keyFactory = SecretKeyFactory.getInstance("DES")
        var keySpec = DESKeySpec(password.toByteArray())

        var key:Key?=  keyFactory.generateSecret(keySpec)
        c.init(Cipher.ENCRYPT_MODE,key)

        //加密/解密
        val encrypt = c.doFinal(input.toByteArray())
        return encrypt
    }
    //解密
    fun decrypt(input:ByteArray,password:String):ByteArray{
        //1 创建cipher
        var c = Cipher.getInstance("DES")
        //初始化 cipher init()  参数1 加密/解密模式
        //秘钥工厂
        val keyFactory = SecretKeyFactory.getInstance("DES")
        var keySpec = DESKeySpec(password.toByteArray())

        var key:Key?=  keyFactory.generateSecret(keySpec)
        c.init(Cipher.DECRYPT_MODE,key)

        //加密/解密
        val encrypt = c.doFinal(input)
        return encrypt
    }
}

fun main() {

    //原文
    var input = "嘿嘿嘿"
    var password = "12345678" //秘钥   DES的秘钥长度 8位

    //调用工具类
    val encrypt = DESCrypt.encrypt(input, password)
    println("加密=${encrypt}")

    //解密
    val decrypt = DESCrypt.decrypt(encrypt, password)
                //转为字符串
    println("解密="+ String(decrypt))
}