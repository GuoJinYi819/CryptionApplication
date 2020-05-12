package com.example.cryptionapplication.demo5

import com.wd.internet_security_algorithm.util.Base64
import java.security.Key
import java.security.KeyPairGenerator
import javax.crypto.Cipher

/**ClassName: CryptionApplication
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/12 0012 11:25
 * @Description: 用途：非对称加密和解密
 *
 */
class RSACrypt{

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



    //1
    var cipher:Cipher = Cipher.getInstance("RSA")
    //2
    var key:Key? = null
    cipher.init(Cipher.ENCRYPT_MODE,key)
    //3






    //非对称加密的三部曲
    //1  创建cipher对象
    //2  初始化
    //3  加密/解密
}