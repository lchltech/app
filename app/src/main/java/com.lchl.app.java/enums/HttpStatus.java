package com.lchl.app.java.enums;

/**
 * <pre>
 * Http Status Code Enums.
 * HTTP状态码（HTTP Status Code）是用以表示网页服务器HTTP响应状态的3位数字代码。
 *
 * 1xx 消息: 请求已被服务器接收，继续处理。
 * -> 100 Continue
 * -> 101 Switching Protocols
 * -> 102 Processing
 *
 * 2xx 成功: 请求已成功被服务器接收、理解、并接受
 * -> 200 OK
 * -> 201 Created
 * -> 201 Accepted
 * -> 203 Non-Authoritative Information
 * -> 204 No Content
 * -> 205 Reset Content
 * -> 206 Partial Content
 * -> 207 Multi-Status
 *
 * 3xx 重定向: 需要后续操作才能完成这一请求
 * -> 300 Multiple Choices
 * -> 301 Moved Permanently
 * -> 302 Found
 * -> 303 See Other
 * -> 304 Not Modified
 * -> 305 Use Proxy
 * -> 306 Switch Proxy
 * -> 307 Temporary Redirect
 *
 * 4xx 请求错误: 请求含有词法错误或者无法被执行
 * -> 400 Bad Request
 * -> 401 Unauthorized
 * -> 402 Payment Required
 * -> 403 Forbidden
 * -> 404 Not Found
 * -> 405 Method Not Allowed
 * -> 406 Not Acceptable
 * -> 407 Proxy Authentication Required
 * -> 408 Request Timeout
 * -> 409 Conflict
 * -> 410 Gone
 * -> 411 Length Required
 * -> 412 Precondition Failed
 * -> 413 Request Entity Too Large
 * -> 414 Request-URI Too Long
 * -> 415 Unsupported Media Type
 * -> 416 Requested Range Not Satisfiable
 * -> 417 Expectation Failed
 * -> 418 I'm a teapot: 本操作码是在1998年作为IETF的传统愚人节笑话, 在RFC 2324 超文本咖啡壶控制协议中定义的，
 *                      并不需要在真实的HTTP服务器中定义。
 * -> 421 There are too many connections from your internet address
 * -> 422 Unprocessable Entity
 * -> 423 Locked
 * -> 424 Failed Dependency
 * -> 425 Unordered Collection
 * -> 426 Upgrade Required
 * -> 449 Retry With: 由微软扩展，代表请求应当在执行完适当的操作后进行重试。
 *
 * 5xx 服务器错误: 服务器在处理某个正确请求时发生错误
 * -> 500 Internal Server Error
 * -> 501 Not Implemented
 * -> 502 Bad Gateway
 * -> 503 Service Unavailable
 * -> 504 Gateway Timeout
 * -> 505 HTTP Version Not Supported
 * -> 506 Variant Also Negotiates
 * -> 507 Insufficient Storage
 * -> 509 Bandwidth Limit Exceeded
 * -> 510 Not Extended
 *
 *
 * User: chaohua.luo
 * Date: 12-5-14
 * Time: 下午4:05
 * </pre>
 */
public enum HttpStatus {
    HSC100(100),
    HSC101(101),
    HSC102(102),

    HSC200(200),
    HSC201(201),
    HSC202(202),
    HSC203(203),
    HSC204(204),
    HSC205(205),
    HSC206(206),
    HSC207(207),

    HSC300(300),
    HSC301(301),
    HSC302(302),
    HSC303(303),
    HSC304(304),
    HSC305(305),
    HSC306(306),
    HSC307(307),

    HSC400(400),
    HSC401(401),
    HSC402(402),
    HSC403(403),
    HSC404(404),
    HSC405(405),
    HSC406(406),
    HSC407(407),
    HSC408(408),
    HSC409(409),
    HSC410(410),
    HSC411(411),
    HSC412(412),
    HSC413(413),
    HSC414(414),
    HSC415(415),
    HSC416(416),
    HSC417(417),
    HSC418(418),
    HSC421(421),
    HSC422(422),
    HSC423(423),
    HSC424(424),
    HSC425(425),
    HSC426(426),

    HSC500(500),
    HSC501(501),
    HSC502(502),
    HSC503(503),
    HSC504(504),
    HSC505(505),
    HSC506(506),
    HSC507(507),
    HSC508(508),
    HSC509(509),
    HSC510(510);
    
    
    private int code;
    private HttpStatus(int code) {
        this.code = code;
    }
    
    public int code() {
        return this.code;
    }
}
