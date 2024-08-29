package com.competition.competition.util;

import com.competition.competition.dto.cardrequest.CardRequest;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

public class CSVProcessor {

    public static List<CardRequest> csvToCards(MultipartFile file) {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            CsvToBean<CardRequest> csvToBean = new CsvToBeanBuilder<CardRequest>(reader)
                    .withType(CardRequest.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse();
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse CSV file" + e.getMessage());
        }
    }
}
