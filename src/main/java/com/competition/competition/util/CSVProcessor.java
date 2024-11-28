package com.competition.competition.util;

import com.competition.competition.dto.CardRequestDTO;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class CSVProcessor {

    public static List<CardRequestDTO> csvToCards(MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<CardRequestDTO> csvToBean = new CsvToBeanBuilder<CardRequestDTO>(reader)
                    .withType(CardRequestDTO.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<CardRequestDTO> cardRequestDTOS = csvToBean.parse();

            // Log each parsed CardRequestDTO
            for (CardRequestDTO cardRequestDTO : cardRequestDTOS) {
                System.out.println("Parsed CardRequestDTO: " + cardRequestDTO);
            }

            return cardRequestDTOS;
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse CSV file" + e.getMessage());
        }
    }
}
