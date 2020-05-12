package com.example.cryptionapplication.demo5

import com.wd.internet_security_algorithm.util.Base64
import java.security.Key
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import javax.crypto.Cipher

/**ClassName: CryptionApplication
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/12 0012 11:25
 * @Description: 用途：非对称加密和解密
 *
 */
object RSACrypt{
    val transformation = "RSA"
    //私钥加密    原文           私钥
    fun encryptPrivate(input:String,privateKey: PrivateKey): String {
        //1
        var cipher:Cipher = Cipher.getInstance(transformation)
        //2
        cipher.init(Cipher.ENCRYPT_MODE,privateKey)
        //3
        val encrypt = cipher.doFinal(input.toByteArray())
        return Base64.encode(encrypt)
    }
    //公钥
    fun encryptPublic(input:String,publicKey: PublicKey): String {
        //1
        var cipher:Cipher = Cipher.getInstance(transformation)
        //2
        cipher.init(Cipher.ENCRYPT_MODE,publicKey)
        //3
        val encrypt = cipher.doFinal(input.toByteArray())
        return Base64.encode(encrypt)
    }

}

fun main() {
    //如何生成秘钥对
    val generator = KeyPairGenerator.getInstance("RSA")
    //生成密钥对
    val genKeyPair = generator.genKeyPair()
    //公钥
    val publicKey = genKeyPair.public
    //秘钥
    val privateKey = genKeyPair.private
    println("公钥"+Base64.encode(publicKey.encoded))
    println("私钥"+Base64.encode(privateKey.encoded))

    var input = "嘿嘿"
    //私钥加密
    val encrypt = RSACrypt.encryptPrivate(input, privateKey)
    println("私钥="+encrypt)
    val encryptPublic = RSACrypt.encryptPublic(input, publicKey)
    println("共钥="+encryptPublic)


    //非对称加密的三部曲
    //1  创建cipher对象
    //2  初始化
    //3  加密/解密
}