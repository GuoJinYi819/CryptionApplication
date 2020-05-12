package com.example.cryptionapplication.demo7

import com.example.cryptionapplication.demo5.RSACrypt
import com.wd.internet_security_algorithm.util.Base64
import java.security.Signature
import kotlin.math.sin

/**ClassName: CryptionApplication
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/12 0012 14:40
 * @Description: 用途：完成特定功能
 */
fun main(args: Array<String>) {
    val input = "name=i"
    //获取数字签名实例对象
    val signature = Signature.getInstance("SHA256withRSA")
    //初始化签名
    signature.initSign(null)
    //设置数据源
    signature.update(input.toByteArray())
    //签名
    val sign = signature.sign()
    println(Base64.encode(sign))
}