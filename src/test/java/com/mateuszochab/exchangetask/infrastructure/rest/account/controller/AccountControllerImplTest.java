package com.mateuszochab.exchangetask.infrastructure.rest.account.controller;

import com.mateuszochab.exchangetask.config.MainTestClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AccountControllerImplTest extends MainTestClass {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenPayload_WhenAllEndpoint_ThenResponseIsOk() throws Exception {
        // Given
        String payload = """
                {
                  "firstname": "Jan",
                  "lastname": "Barski",
                  "balance": [
                    {
                      "currency": "PLN",
                      "amount": 3990.0
                    },
                    {
                      "currency": "USD",
                      "amount": 800.0
                    }
                  ]
                }
                """;

        // When
        var result = mockMvc.perform(post("/api/v1/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload));

        // Then
        result.andExpect(status().isOk());
    }

    @Test
    void givenPayload_WhenAddAccount_ThenValidResponseBody() throws Exception {
        // Given
        String payload = """
                {
                  "firstname": "Jan",
                  "lastname": "Barski",
                  "balance": [
                    {
                      "currency": "PLN",
                      "amount": 3990.0
                    },
                    {
                      "currency": "USD",
                      "amount": 800.0
                    }
                  ]
                }
                """;

        // When
        var result = mockMvc.perform(post("/api/v1/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload));

        // Then
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.firstname").value("Jan"))
                .andExpect(jsonPath("$.lastname").value("Barski"))
                .andExpect(jsonPath("$.balance").isArray())
                .andExpect(jsonPath("$.balance[0].currency").value("PLN"))
                .andExpect(jsonPath("$.balance[0].amount").value("3990.0"))
                .andExpect(jsonPath("$.balance[1].currency").value("USD"))
                .andExpect(jsonPath("$.balance[1].amount").value("800.0"));
    }

    @Test
    void givenBadPayloadMissingFirstnameField_WhenCreateAccount_ThenErrorReturned() throws Exception {
        // Given
        String payload = """
                {
                  "lastname": "Barski",
                  "balance": [
                    { "currency": "PLN", "amount": 3990.0 },
                    { "currency": "USD", "amount": 800.0 }
                  ]
                }
                """;

        // When
        var result = mockMvc.perform(post("/api/v1/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload));
        // Then
        result.andExpect(status().isBadRequest());
    }

}