package ru.igormayachenkov.eprotection_cameras.network

import org.json.JSONObject
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory


private const val TAG:String="myapp.APINative"

class APINative : API {

    private val COOKIE_NAME:String="session";

    //val sslContext:SSLContext = SSLContext.getInstance("TLS")
    private val sslContext:SSLContext = SSLContext.getDefault()

    @Throws(Exception::class)
    internal fun openConnection(method: String, url: URL): HttpURLConnection {
        val conn: HttpURLConnection
        if (url.protocol == "https") {
            // Tell the URLConnection to use a SocketFactory from our SSLContext
            val connS = url.openConnection() as HttpsURLConnection
            connS.sslSocketFactory = sslContext.socketFactory
            conn = connS
        } else {
            // HTTP
            conn = url.openConnection() as HttpURLConnection
        }
        // Method
        conn.requestMethod = method

        // Set timeouts
        conn.readTimeout = 60000
        conn.connectTimeout = 15000

        return conn
    }

    @Throws(Exception::class)
    private fun inputAsString(conn:HttpURLConnection):String{
        val stream:InputStream = if (conn.responseCode == 200) conn.inputStream else conn.errorStream
        val reader = InputStreamReader(stream, "UTF-8")
        val buffer = CharArray(1000)
        val sb = StringBuilder()
        // Read chunked stream in the loop
        while (true) {
            val len = reader.read(buffer)
            if (len <= 0) break
            sb.append(buffer, 0, len)
        }
        val resp = sb.toString()
        stream.close()

        conn.disconnect()

        // Return result or error
        if (conn.responseCode != 200) {
            // Parse the error message
            val error = BackendMessage(JSONObject(resp))
            throwAPIException(conn.responseCode, error.message)
        }
        return resp
    }

    @Throws(APIException::class)
    private fun throwAPIException(responseCode:Int, message:String?){
        // Check some error codes
//        if(responseCode===401) {// Unauthorized
//            val handler = Handler(Looper.getMainLooper())
//            handler.post { Logic.onUnauthorizedReceived()}
//        }
        // Throw the exception
        throw APIException(responseCode, message)
    }

    //----------------------------------------------------------------------------------------------
    // SEND REQUEST
    @Throws(Exception::class)
    private fun sendRequest(method:String, url: URL, token:String?, data:String? ):String{

        // Init connection
        val conn:HttpURLConnection = openConnection(method,url)
        conn.doOutput = data!=null
        conn.doInput  = true
        // Add session header
        if (token != null)
            conn.setRequestProperty("cookie", "$COOKIE_NAME=$token")
        // Add version header
//        if (version != 0) conn.setRequestProperty("version", String.format("%d", version))

        // CONNECT
        conn.connect()

        // DO OUTPUT
        if (data != null) {
            val wr = OutputStreamWriter(conn.outputStream)
            wr.write(data)
            wr.flush()
        }

        // DO INPUT
        return inputAsString(conn)
    }


    //----------------------------------------------------------------------------------------------
    // API IMPLEMENTATION
    override fun get(
        baseUrl:String,
        workspace:String,
        path:String, // load path inside a workspace: load/state, load/changes
        token:String?
    ): JSONObject{
        val resp:String = sendRequest("GET",URL("$baseUrl/$workspace$path"), token, null)
        return JSONObject(resp)
    }

    override fun post(
        baseUrl:String,
        workspace: String,
        path: String,
        token: String?,
        data: JSONObject
    ): JSONObject {
        val resp:String = sendRequest("POST",URL("$baseUrl/$workspace$path"), token, data.toString())
        return JSONObject(resp)
    }
}