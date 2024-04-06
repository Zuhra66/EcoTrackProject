package com.example.ecotrack.database;

import androidx.room.TypeConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
    public class LocalDateTimeConverter {
        private static DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        @TypeConverter
        public static LocalDateTime toLocalDateTime(String value) {
            return value == null ? null : LocalDateTime.parse(value, formatter);
        }

        @TypeConverter
        public static String fromLocalDateTime(LocalDateTime date) {
            return date == null ? null : date.format(formatter);
        }
    }

