/*
 * Copyright 2020 Yiğit Özdemir
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.thunderstorm010.vacefron4j.internal;

import com.jsoniter.JsonIterator;
import com.jsoniter.any.Any;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpUtil {
    public static byte[] request(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36");
        int responseCode = connection.getResponseCode();
        InputStream data;
        if (responseCode == 200) {
            data = connection.getInputStream();
        } else {
            data = connection.getErrorStream();
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        copy(data, outputStream);
        byte[] output = outputStream.toByteArray();
        if (responseCode == 200) {
            return output;
        } else if (responseCode == 400) {
            String outputStr = new String(output, StandardCharsets.UTF_8);
            Any iterator = JsonIterator.deserialize(outputStr);
            throw new APIError("Code " + iterator.get("code").as(int.class) + ": " + iterator.get("message").as(String.class));
        } else {
            throw new RuntimeException("HTTP " + responseCode);
        }
    }


    private static void copy(InputStream source, OutputStream target) throws IOException {
        byte[] buf = new byte[8192];
        int length;
        while ((length = source.read(buf)) > 0) {
            target.write(buf, 0, length);
        }
    }

}
