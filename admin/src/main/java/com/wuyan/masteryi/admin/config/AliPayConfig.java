package com.wuyan.masteryi.admin.config;
/*
 *project:master-yi
 *file:AliPayConfig
 *@author:wsn
 *date:2021/7/7 14:51
 */

public class AliPayConfig {
    public static String serverUrl="https://openapi.alipaydev.com/gateway.do";
    public static String Appid="2021000117684301";
    public static String privateKey="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCIxP1aA4tQ6e+hPXu581ar/yZyvnwaUzQnOwqT3rd0YbrdMmiZFLu/7LaIUPaSd4gl0I1tPa/fgVKyY+2ipGBhV5+96rIJiAS3+qde7MfujTjpiSB7MVmusc6OgY9ATbKV9R9R8gTV6IlavlI4HRjSLGI7cUdlipfZofdEZHkwC3BCcgeP50nebCXNz7O0vwVO+jAV1GWRtuuElFHflpBjIAs2ekL673og3YJfNsyYyK6Wa1YkX9uC90SQrLLZVHf5yIAh8Rt6dXsmGNPLN4xpNSu06gfHlXlqjNxFYWccj8okF2zEkx3QTNTBBjLc/WB4oJctEox16ndD9cuWe8iVAgMBAAECggEAH/4ETWP62KiAFzVslaioI3+BnOGV4gqIbozPApvcSer6bPd3pCdHa7ORVv2pT8WKIV5RVrZRR3TWxUe+tIbCzMJUaXZWwwgAIpENSZUVh2WdZHNhF7AJjGWnLYp82cvS9GTsOJzmKKtGReWzEdEsly0upTzwOH5c2tmaH3NpLaWGInnkmUJNToSgCGI05fxko91rKOFl1VEl23cbCoAN+yV2PoUlq2voy2FFR7REIkkS62Ombbuc9vsO/h+p30zt08j1MWs2+nUEj/XBpDNROIrvWwrOD7RdJ193pDvBrGY0/2js29i/aY46mc7kcGVpV7jMuiOKEOTlz5JiD7KJgQKBgQDjIhlRCbJ9qPzjNaXkBRcCf3M63cxoiqQEd/SsNHJJX17L2+fz7nfbiIau0Nz+Pl6BBgAxHvxWDVXU0TvOJVizRTKsyUqVlzyNk1p+WomEsJtVs1XdaeH5ZJVakv5Rlv/Vuq+BfnHrnxEt+a4kb/yvPwuXDtTAcV2tJjf+1ibisQKBgQCaJtvZ6FDxd8PqkoPVF/A92uG308r1ERxElqTQwl5qkGfQ+MpqStzhXuR9+QAAAfSHMrneOfUYEbwwcBM14P3Jb6Mzum9Gb5Auc0bXIKQNvDSSvekc7mj5OykNm8C8NhvwLTCKK+KNf7nDCINWNhCHDph/88EEOGbe0MElUqyVJQKBgQC6iunh/aXjwKOZ9BjAElIYkhZQdZOJFLyqkt6XhCeNDU/s/DofxG4aFqIO96lZAl5Zd1U3AqzZ++/PbtzAbTnRWnbJJDUmcOShnjEHb1JccTPSigxuYaTfT/W+QtWuquaJYd786p2jl6vjZ5nXgUY1pADf2qVvPGxkZew9VyLusQKBgFZRkCZzOnAcWm6N4JiAsRxR5rcjN7EHBcc6e8wSKwCNIDUaO25NwWXJ1zTbK67VaXITa5UO6zmxJKoS+A7hj/suMjsTGKBedGQuVOq98l9mliHdih2TOuDkydY+8yvxOK/C/j1A2bnWXdTifXjXCWY3PBnaCqksVB5M0vrtUoqpAoGAdUoYbNHujQ925FOWY9cE7oQKjlZezwm1TCF3WHvhystSVXXBD1V3BuRUYfdsflAwK2wjc49+vbWAIJnxULp/32qb/SMH0186hSJPt1EvU3fjs6RZW8/fAHDP9b2TTAUriNQQoQ5hpTBoYtWDnApqKZ59dBlvTNNG6tTHL6yH16I=";  //私钥 不知道是什么 往上面看 配置沙箱密钥的时候 自己保存的
    public static String formate="json";
    public static String charset="utf-8";
    public static String AliPayPublicKey="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsphueO7CkNHgPfoWbrJSbNLh5xY//fSzhMKkQPd3pL9JfrhAIIibG5PxEJ59denoaZ9/miaEObkAj76RDnWxLeAtXKPZ1/V/IWQew+PI5hCUVP7VUKC0vTWugA6kCyZ05C+Td2HPJXcBjMyZ8ngJnhMgf3PWISyxyfuZuuq+AvSZl/sVmR7hGosZKgUimDw/z1WNqvatA9JS1vLZS9IIalZTTyZPHf1ZolAsbX9fPfxuVQPtBFs3AeXdlDupSBKgNMjcsCFa9K0orl/5xqUOTEoS5MR6FHG7tHP7xoFZPWai7mxh2yGgAUakquQmIXliN9kPAGcflnh2v5H7Oa3lOQIDAQAB";
    public static String signType="RSA2";
    public static String returnURL="http://localhost:8081/success";
    public static String notifyURL="http://vbwz5t.natappfree.cc/trade/payCallback";
    //1 表示订单已创建但还未支付
    //2 表示订单已支付，正在运输中
    //3 表示运输完成，订单完成
    //4 表示请求退款
    //5 支付失败或超时，等待删除
    //6 退款成功
}
