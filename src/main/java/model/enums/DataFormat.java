package model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DataFormat {
    YEAR_MONTH_DAY_HOUR_MINUTES("yyyy-MM-dd HH:mm");

    String text;
}