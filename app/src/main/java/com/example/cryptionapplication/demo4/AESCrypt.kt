package com.example.cryptionapplication.demo4

import android.os.Build
import androidx.annotation.RequiresApi
import com.wd.internet_security_algorithm.util.Base64
import javax.crypto.Cipher
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.SecretKeySpec

/**ClassName: CryptionApplication
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/12 0012 9:57
 * @Description: 用途：AES加密和解密
 */

object AESCrypt{
    fun encrypt(password:String, input:String): String {
        //创建cipher对象
        val cipher = Cipher.getInstance("AES")
        //初始化cipher
        //秘钥工厂  生成秘钥

        var key:SecretKeySpec = SecretKeySpec(password.toByteArray(),"AES")
        cipher.init(Cipher.ENCRYPT_MODE,key)
        //加密或解密
        val encrypt = cipher.doFinal(input.toByteArray())
        val result = Base64.encode(encrypt)
        return result
    }
    //解密
    fun decrypt(password:String, input:String): String {
        //创建cipher对象
        val cipher = Cipher.getInstance("AES")
        //初始化cipher
        //秘钥工厂  生成秘钥
        val keySpec:SecretKeySpec = SecretKeySpec(password.toByteArray(),"AES")

        cipher.init(Cipher.DECRYPT_MODE,keySpec)
        //加密或解密
        val encrypt = cipher.doFinal(Base64.decode(input))
        //返回
        val result = String(encrypt)
        return result
    }
}

fun main() {
    //生成秘钥
    val password = "1234567812345678"
    val input = "嘿嘿嘿"


    val encrypt = AESCrypt.encrypt(password, input) //加密
    val decrypt = AESCrypt.decrypt(password, encrypt) //解密

    println("加密="+encrypt)
    println("解密="+decrypt)

}