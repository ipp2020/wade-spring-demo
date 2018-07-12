package com.wade.springboot.wadespringbootdemo.controller;

import com.google.gson.Gson;
import com.wade.springboot.wadespringbootdemo.dto.RequestCodeDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping(value = "/json")
public class JsonValidateController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    //@RequestMapping(value = "/test", method = RequestMethod.POST)
    @RequestMapping(value = "/test")
    public String index(HttpServletRequest request) {

        try {
            String requestBody;

            String submitMehtod = request.getMethod();
            // GET
            if (submitMehtod.equals("GET")) {
                requestBody =  new String(request.getQueryString().getBytes("iso-8859-1"), "utf-8").replaceAll("%22", "\"");
                // POST
            } else {
                requestBody = this.getRequestPostStr(request);
            }
            System.out.println(requestBody);

            Gson gson = new Gson();

            RequestCodeDTO requestCodeDTO = gson.fromJson(request.getReader(), RequestCodeDTO.class);

            String s = requestCodeDTO.getCode();

            return requestBody;
        } catch (Exception e) {
            return e.toString();
        }

    }


    /**
     * 描述:获取 post 请求的 byte[] 数组
     * <pre>
     * 举例：
     * </pre>
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request)
            throws IOException {
        int contentLength = request.getContentLength();
        if (contentLength < 0) {
            return null;
        }
        byte buffer[] = new byte[contentLength];
        for (int i = 0; i < contentLength; ) {

            int readlen = request.getInputStream().read(buffer, i,
                    contentLength - i);
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }

    /**
     * 描述:获取 post 请求内容
     * <pre>
     * 举例：
     * </pre>
     *
     * @param request
     * @return
     * @throws IOException
     */
    public static String getRequestPostStr(HttpServletRequest request)
            throws IOException {
        byte buffer[] = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        return new String(buffer, charEncoding);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {


        logger.info("===========================================index ");

        return "index";
    }
}
