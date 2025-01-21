package com.study.board.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// SpringBoot 애플리케이션에서 OpenAPI(Swagger)를 설정하는 클래스
// Swagger 라이브러리 사용해서 API 문서 자동으로 생성하도록 구성된거 !
// 파일 실행하면, OpenAPI 객체가 Bean에 등록
// 확인 경로 -> http://localhost:8080/swagger-ui.html

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API 문서")            // 문서의 제목
                        .description("API 명세서")    // 문서의 설명
                        .version("1.0.0")           // API 버전 설정
                );
    }

}
