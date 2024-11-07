package com.example.coindesk.util;

import com.example.coindesk.service.CoinConfigService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Map;

@Component
public class CoindeskUtil {


    @Autowired
    private CoinConfigService coinConfigService;

    /**
     * JSON 字符串解析為 CoindeskResponse
     *
     * @return 解析自提供的 JSON 的 CoindeskResponse
     * @throws RuntimeException 如果 JSON 解析失敗則拋出異常
     */
    public static CoindeskResponse parseJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            return mapper.readValue(json, CoindeskResponse.class);
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse JSON", e);
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CoindeskResponse {
        private Time time;
        private Map<String, Bpi> bpi;

        public Time getTime() {
            return time;
        }

        public void setTime(Time time) {
            this.time = time;
        }

        public Map<String, Bpi> getBpi() {
            return bpi;
        }

        public void setBpi(Map<String, Bpi> bpi) {
            this.bpi = bpi;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Time {
            private ZonedDateTime updatedISO;

            public ZonedDateTime getUpdatedISO() {
                return updatedISO;
            }

            public void setUpdatedISO(ZonedDateTime updatedISO) {
                this.updatedISO = updatedISO;
            }
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Bpi {

            private String code;

            @JsonProperty("rate_float")
            private float rate_float;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public float getRateFloat() {
                return rate_float;
            }

            public void setRateFloat(float rateFloat) {
                this.rate_float = rateFloat;
            }
        }
    }

}
